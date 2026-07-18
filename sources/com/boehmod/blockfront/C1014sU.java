package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sU.class */
public final class C1014sU {

    /* JADX INFO: renamed from: bD */
    @NotNull
    public static final List<C1014sU> f5316bD = new ObjectArrayList();

    /* JADX INFO: renamed from: T */
    @NotNull
    private static final Map<ResourceLocation, C1014sU> f5317T = new LinkedHashMap();

    /* JADX INFO: renamed from: cI */
    @NotNull
    private final String f5318cI;

    /* JADX INFO: renamed from: fs */
    @NotNull
    private final ResourceLocation f5319fs;

    /* JADX INFO: renamed from: ft */
    @NotNull
    private final ResourceLocation f5320ft;

    /* JADX INFO: renamed from: fu */
    @NotNull
    private final ResourceLocation f5321fu;

    /* JADX INFO: renamed from: fv */
    @NotNull
    private final ResourceLocation f5322fv;

    /* JADX INFO: renamed from: fw */
    @NotNull
    private final ResourceLocation f5323fw;

    /* JADX INFO: renamed from: fx */
    @NotNull
    private final ResourceLocation f5324fx;

    /* JADX INFO: renamed from: fy */
    @NotNull
    private final ResourceLocation f5325fy;

    /* JADX INFO: renamed from: fz */
    @NotNull
    private final ResourceLocation f5326fz;

    static {
        C0533jQ.m2411bo();
    }

    /* JADX INFO: renamed from: aR */
    public static void m5497aR() {
        f5316bD.clear();
        f5317T.clear();
    }

    public C1014sU(@NotNull String str, @NotNull ResourceLocation resourceLocation, @NotNull ResourceLocation resourceLocation2, @NotNull ResourceLocation resourceLocation3, @NotNull ResourceLocation resourceLocation4, @NotNull ResourceLocation resourceLocation5, @NotNull ResourceLocation resourceLocation6, @NotNull ResourceLocation resourceLocation7) {
        this.f5318cI = str;
        this.f5319fs = C0564jv.m2555d(str);
        this.f5320ft = resourceLocation;
        this.f5321fu = resourceLocation2;
        this.f5322fv = resourceLocation3;
        this.f5323fw = resourceLocation4;
        this.f5324fx = resourceLocation5;
        this.f5325fy = resourceLocation6;
        this.f5326fz = resourceLocation7;
        f5316bD.add(this);
        f5317T.put(this.f5319fs, this);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1014sU m5498a(@NotNull ResourceLocation resourceLocation) {
        return f5317T.get(resourceLocation);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1014sU m5499a(@NotNull String str) {
        return f5317T.get(C0564jv.m2555d(str));
    }

    @NotNull
    /* JADX INFO: renamed from: av */
    public static List<C1014sU> m5500av() {
        return Collections.unmodifiableList(f5316bD);
    }

    @NotNull
    public String getKey() {
        return this.f5318cI;
    }

    @NotNull
    /* JADX INFO: renamed from: L */
    public ResourceLocation m5501L() {
        return this.f5319fs;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private static DeferredHolder<SoundEvent, SoundEvent> m5502a(@NotNull ResourceLocation resourceLocation) {
        return (DeferredHolder) C1280xc.f7499h.get(resourceLocation.toString());
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public DeferredHolder<SoundEvent, SoundEvent> m5503d() {
        return m5502a(this.f5320ft);
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    public DeferredHolder<SoundEvent, SoundEvent> m5504e() {
        return m5502a(this.f5321fu);
    }

    @Nullable
    /* JADX INFO: renamed from: f */
    public DeferredHolder<SoundEvent, SoundEvent> m5505f() {
        return m5502a(this.f5322fv);
    }

    @Nullable
    /* JADX INFO: renamed from: g */
    public DeferredHolder<SoundEvent, SoundEvent> m5506g() {
        return m5502a(this.f5323fw);
    }

    @Nullable
    /* JADX INFO: renamed from: h */
    public DeferredHolder<SoundEvent, SoundEvent> m5507h() {
        return m5502a(this.f5324fx);
    }

    @Nullable
    /* JADX INFO: renamed from: i */
    public DeferredHolder<SoundEvent, SoundEvent> m5508i() {
        return m5502a(this.f5325fy);
    }

    @Nullable
    /* JADX INFO: renamed from: j */
    public DeferredHolder<SoundEvent, SoundEvent> m5509j() {
        return m5502a(this.f5326fz);
    }
}
