package com.boehmod.blockfront;

import com.mojang.blaze3d.audio.Channel;
import com.mojang.blaze3d.audio.SoundBuffer;
import it.unimi.dsi.fastutil.floats.FloatArrayList;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.sound.sampled.AudioFormat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.sounds.ChunkedSampleByteBuf;
import net.minecraft.client.sounds.JOrbisAudioStream;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.openal.ALC10;

/* JADX INFO: renamed from: com.boehmod.blockfront.ix, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ix.class */
@OnlyIn(Dist.CLIENT)
public final class C0240ix {

    @OnlyIn(Dist.CLIENT)
    private static final C0240ix a = new C0240ix();
    private final Map<ResourceLocation, SoundBuffer> o = new Object2ObjectOpenHashMap();
    private final Set<ResourceLocation> g = new ObjectOpenHashSet();

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    private long f174g = 0;

    private C0240ix() {
    }

    @OnlyIn(Dist.CLIENT)
    public static C0240ix a() {
        return a;
    }

    public void a(Channel channel, ResourceLocation resourceLocation) {
        long jAlcGetCurrentContext = ALC10.alcGetCurrentContext();
        if (jAlcGetCurrentContext == 0) {
            return;
        }
        if (jAlcGetCurrentContext != this.f174g) {
            this.o.clear();
            this.g.clear();
            this.f174g = jAlcGetCurrentContext;
        }
        if (this.g.contains(resourceLocation)) {
            return;
        }
        SoundBuffer soundBufferA = this.o.get(resourceLocation);
        if (soundBufferA == null) {
            soundBufferA = a(resourceLocation);
            if (soundBufferA == null) {
                this.g.add(resourceLocation);
                return;
            }
            this.o.put(resourceLocation, soundBufferA);
        }
        channel.stop();
        channel.attachStaticBuffer(soundBufferA);
        channel.play();
    }

    @Nullable
    private SoundBuffer a(ResourceLocation resourceLocation) {
        try {
            ResourceManager resourceManager = Minecraft.getInstance().getResourceManager();
            FloatArrayList floatArrayList = new FloatArrayList();
            InputStream inputStreamOpen = resourceManager.open(resourceLocation);
            try {
                JOrbisAudioStream jOrbisAudioStream = new JOrbisAudioStream(inputStreamOpen);
                try {
                    AudioFormat format = jOrbisAudioStream.getFormat();
                    do {
                        Objects.requireNonNull(floatArrayList);
                    } while (jOrbisAudioStream.readChunk(floatArrayList::add));
                    jOrbisAudioStream.close();
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                    if (format.getChannels() != 1) {
                        C0263jt.log("Reverb skipped for %s: expected mono, got %d channels.", resourceLocation, Integer.valueOf(format.getChannels()));
                        return null;
                    }
                    float[] fArrA = C0239iw.a(floatArrayList.toFloatArray(), (int) format.getSampleRate(), C0242iz.a);
                    ChunkedSampleByteBuf chunkedSampleByteBuf = new ChunkedSampleByteBuf(fArrA.length * 2);
                    for (float f : fArrA) {
                        chunkedSampleByteBuf.accept(f);
                    }
                    return new SoundBuffer(chunkedSampleByteBuf.get(), format);
                } catch (Throwable th) {
                    try {
                        jOrbisAudioStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } finally {
            }
        } catch (Exception e) {
            C0263jt.log("Failed to build reverb buffer for %s: %s", resourceLocation, e.getMessage());
            return null;
        }
    }
}
