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

/* JADX INFO: renamed from: com.boehmod.blockfront.ix */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ix.class */
@OnlyIn(Dist.CLIENT)
public final class C0513ix {

    /* JADX INFO: renamed from: a */
    @OnlyIn(Dist.CLIENT)
    private static final C0513ix f3036a = new C0513ix();

    /* JADX INFO: renamed from: o */
    private final Map<ResourceLocation, SoundBuffer> f3037o = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: g */
    private final Set<ResourceLocation> f3038g = new ObjectOpenHashSet();

    /* JADX INFO: renamed from: g */
    private long f3039g = 0;

    private C0513ix() {
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public static C0513ix m2255a() {
        return f3036a;
    }

    /* JADX INFO: renamed from: a */
    public void m2256a(Channel channel, ResourceLocation resourceLocation) {
        long jAlcGetCurrentContext = ALC10.alcGetCurrentContext();
        if (jAlcGetCurrentContext == 0) {
            return;
        }
        if (jAlcGetCurrentContext != this.f3039g) {
            this.f3037o.clear();
            this.f3038g.clear();
            this.f3039g = jAlcGetCurrentContext;
        }
        if (this.f3038g.contains(resourceLocation)) {
            return;
        }
        SoundBuffer soundBufferM2257a = this.f3037o.get(resourceLocation);
        if (soundBufferM2257a == null) {
            soundBufferM2257a = m2257a(resourceLocation);
            if (soundBufferM2257a == null) {
                this.f3038g.add(resourceLocation);
                return;
            }
            this.f3037o.put(resourceLocation, soundBufferM2257a);
        }
        channel.stop();
        channel.attachStaticBuffer(soundBufferM2257a);
        channel.play();
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private SoundBuffer m2257a(ResourceLocation resourceLocation) {
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
                        C0562jt.log("Reverb skipped for %s: expected mono, got %d channels.", resourceLocation, Integer.valueOf(format.getChannels()));
                        return null;
                    }
                    float[] fArrM2254a = C0512iw.m2254a(floatArrayList.toFloatArray(), (int) format.getSampleRate(), C0515iz.f3052a);
                    ChunkedSampleByteBuf chunkedSampleByteBuf = new ChunkedSampleByteBuf(fArrM2254a.length * 2);
                    for (float f : fArrM2254a) {
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
            C0562jt.log("Failed to build reverb buffer for %s: %s", resourceLocation, e.getMessage());
            return null;
        }
    }
}
