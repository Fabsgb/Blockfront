package com.boehmod.blockfront;

import com.boehmod.blockfront.mixin.WeighedSoundEventsAccessor;
import com.mojang.blaze3d.audio.Channel;
import com.mojang.blaze3d.audio.SoundBuffer;
import it.unimi.dsi.fastutil.floats.FloatArrayList;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.sound.sampled.AudioFormat;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.client.sounds.ChunkedSampleByteBuf;
import net.minecraft.client.sounds.JOrbisAudioStream;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.client.sounds.Weighted;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.openal.ALC10;

/* JADX INFO: renamed from: com.boehmod.blockfront.iO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iO.class */
@OnlyIn(Dist.CLIENT)
public final class C0479iO {

    /* JADX INFO: renamed from: a */
    @OnlyIn(Dist.CLIENT)
    private static final C0479iO f2932a = new C0479iO();

    /* JADX INFO: renamed from: Y */
    private static final List<DeferredHolder<SoundEvent, SoundEvent>> f2933Y = List.of(C1312xz.f8872GJ, C1312xz.f8873GK);

    /* JADX INFO: renamed from: o */
    private final Map<ResourceLocation, SoundBuffer> f2934o = new ConcurrentHashMap();

    /* JADX INFO: renamed from: f */
    private final Set<ResourceLocation> f2935f = ConcurrentHashMap.newKeySet();

    /* JADX INFO: renamed from: g */
    private final Set<ResourceLocation> f2936g = ConcurrentHashMap.newKeySet();

    /* JADX INFO: renamed from: h */
    private final Set<String> f2937h = ConcurrentHashMap.newKeySet();

    /* JADX INFO: renamed from: b */
    private final AtomicInteger f2938b = new AtomicInteger();

    /* JADX INFO: renamed from: l */
    private long f2939l = 0;

    private C0479iO() {
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public static C0479iO m2144a() {
        return f2932a;
    }

    /* JADX INFO: renamed from: a */
    public void m2145a(Channel channel, ResourceLocation resourceLocation) {
        long jAlcGetCurrentContext = ALC10.alcGetCurrentContext();
        if (jAlcGetCurrentContext == 0) {
            return;
        }
        if (this.f2939l == 0) {
            this.f2939l = jAlcGetCurrentContext;
        } else if (jAlcGetCurrentContext != this.f2939l) {
            this.f2939l = jAlcGetCurrentContext;
            this.f2938b.incrementAndGet();
            this.f2934o.clear();
            this.f2935f.clear();
            this.f2937h.clear();
            m2147bc();
        }
        if (this.f2935f.contains(resourceLocation)) {
            return;
        }
        SoundBuffer soundBuffer = this.f2934o.get(resourceLocation);
        if (soundBuffer == null) {
            if (this.f2937h.add(m2148a(resourceLocation))) {
                CompletableFuture.runAsync(() -> {
                    m2149b(resourceLocation);
                }, Util.backgroundExecutor());
            }
        } else {
            channel.stop();
            channel.attachStaticBuffer(soundBuffer);
            channel.play();
        }
    }

    /* JADX INFO: renamed from: bb */
    public void m2146bb() {
        this.f2938b.incrementAndGet();
        this.f2934o.clear();
        this.f2935f.clear();
        this.f2937h.clear();
        m2147bc();
    }

    /* JADX INFO: renamed from: bc */
    private void m2147bc() {
        SoundManager soundManager = Minecraft.getInstance().getSoundManager();
        Iterator<DeferredHolder<SoundEvent, SoundEvent>> it = f2933Y.iterator();
        while (it.hasNext()) {
            ResourceLocation id = it.next().getId();
            WeighedSoundEventsAccessor soundEvent = soundManager.getSoundEvent(id);
            if (soundEvent == null) {
                C0530jM.log("Reverb pre-warm skipped for %s: unknown sound event.", id);
            } else {
                int i = 0;
                Iterator<Weighted<Sound>> it2 = soundEvent.getList().iterator();
                while (it2.hasNext()) {
                    Sound sound = (Weighted) it2.next();
                    if ((sound instanceof Sound) && m2150a(sound.getPath())) {
                        i++;
                    }
                }
                if (i > 0) {
                    C0530jM.log("Queued %d reverb build(s) for %s.", Integer.valueOf(i), id);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m2148a(ResourceLocation resourceLocation) {
        return resourceLocation.getNamespace() + ":" + resourceLocation.getPath().replaceFirst("\\d*\\.ogg$", "");
    }

    /* JADX INFO: renamed from: b */
    private void m2149b(ResourceLocation resourceLocation) {
        String path = resourceLocation.getPath();
        int iLastIndexOf = path.lastIndexOf(47);
        if (iLastIndexOf < 0) {
            m2150a(resourceLocation);
            return;
        }
        String strSubstring = path.substring(0, iLastIndexOf);
        String strReplaceFirst = path.substring(iLastIndexOf + 1).replaceFirst("\\d*\\.ogg$", "");
        int i = 0;
        Iterator it = Minecraft.getInstance().getResourceManager().listResources(strSubstring, resourceLocation2 -> {
            return resourceLocation2.getNamespace().equals(resourceLocation.getNamespace()) && resourceLocation2.getPath().startsWith(strReplaceFirst, iLastIndexOf + 1) && resourceLocation2.getPath().substring((iLastIndexOf + 1) + strReplaceFirst.length()).matches("\\d*\\.ogg");
        }).keySet().iterator();
        while (it.hasNext()) {
            if (m2150a((ResourceLocation) it.next())) {
                i++;
            }
        }
        if (i > 0) {
            C0530jM.log("Warming reverb cache for %d sound(s) in family %s.", Integer.valueOf(i), m2148a(resourceLocation));
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m2150a(ResourceLocation resourceLocation) {
        if (this.f2934o.containsKey(resourceLocation) || this.f2935f.contains(resourceLocation) || !this.f2936g.add(resourceLocation)) {
            return false;
        }
        CompletableFuture.runAsync(() -> {
            m2151c(resourceLocation);
        }, Util.backgroundExecutor());
        return true;
    }

    /* JADX INFO: renamed from: c */
    private void m2151c(ResourceLocation resourceLocation) {
        int i = this.f2938b.get();
        boolean z = false;
        try {
            SoundBuffer soundBufferM2152a = m2152a(resourceLocation);
            if (this.f2938b.get() != i) {
                z = true;
            } else if (soundBufferM2152a == null) {
                this.f2935f.add(resourceLocation);
            } else {
                this.f2934o.put(resourceLocation, soundBufferM2152a);
            }
            this.f2936g.remove(resourceLocation);
            if (z) {
                m2150a(resourceLocation);
            }
        } catch (Throwable th) {
            this.f2936g.remove(resourceLocation);
            throw th;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private SoundBuffer m2152a(ResourceLocation resourceLocation) {
        try {
            InputStream inputStreamOpen = Minecraft.getInstance().getResourceManager().open(resourceLocation);
            try {
                FloatArrayList floatArrayList = new FloatArrayList((int) Math.min(4194304L, Math.max(16384L, ((long) inputStreamOpen.available()) * 5)));
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
                        C0530jM.log("Reverb skipped for %s: expected mono, got %d channels.", resourceLocation, Integer.valueOf(format.getChannels()));
                        return null;
                    }
                    float[] fArrM2143a = C0478iN.m2143a(floatArrayList.elements(), floatArrayList.size(), (int) format.getSampleRate(), C0481iQ.f2952a);
                    ChunkedSampleByteBuf chunkedSampleByteBuf = new ChunkedSampleByteBuf(fArrM2143a.length * 2);
                    for (float f : fArrM2143a) {
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
            } catch (Throwable th3) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (Exception e) {
            C0530jM.log("Failed to build reverb buffer for %s: %s", resourceLocation, e.getMessage());
            return null;
        }
    }
}
