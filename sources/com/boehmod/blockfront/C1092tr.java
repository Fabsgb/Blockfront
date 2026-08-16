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

/* JADX INFO: renamed from: com.boehmod.blockfront.tr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tr.class */
public final class C1092tr {

    /* JADX INFO: renamed from: bK */
    @NotNull
    public static final List<C1092tr> f5880bK = new ObjectArrayList();

    /* JADX INFO: renamed from: T */
    @NotNull
    private static final Map<ResourceLocation, C1092tr> f5881T = new LinkedHashMap();

    /* JADX INFO: renamed from: cS */
    @NotNull
    private final String f5882cS;

    /* JADX INFO: renamed from: fr */
    @NotNull
    private final ResourceLocation f5883fr;

    /* JADX INFO: renamed from: fs */
    @NotNull
    private final ResourceLocation f5884fs;

    /* JADX INFO: renamed from: ft */
    @NotNull
    private final ResourceLocation f5885ft;

    /* JADX INFO: renamed from: fu */
    @NotNull
    private final ResourceLocation f5886fu;

    /* JADX INFO: renamed from: fv */
    @NotNull
    private final ResourceLocation f5887fv;

    /* JADX INFO: renamed from: fw */
    @NotNull
    private final ResourceLocation f5888fw;

    /* JADX INFO: renamed from: fx */
    @NotNull
    private final ResourceLocation f5889fx;

    /* JADX INFO: renamed from: fy */
    @NotNull
    private final ResourceLocation f5890fy;

    static {
        C0609km.m2773bz();
    }

    /* JADX INFO: renamed from: aZ */
    public static void m5985aZ() {
        f5880bK.clear();
        f5881T.clear();
    }

    public C1092tr(@NotNull String str, @NotNull ResourceLocation resourceLocation, @NotNull ResourceLocation resourceLocation2, @NotNull ResourceLocation resourceLocation3, @NotNull ResourceLocation resourceLocation4, @NotNull ResourceLocation resourceLocation5, @NotNull ResourceLocation resourceLocation6, @NotNull ResourceLocation resourceLocation7) {
        this.f5882cS = str;
        this.f5883fr = C0532jO.m2378d(str);
        this.f5884fs = resourceLocation;
        this.f5885ft = resourceLocation2;
        this.f5886fu = resourceLocation3;
        this.f5887fv = resourceLocation4;
        this.f5888fw = resourceLocation5;
        this.f5889fx = resourceLocation6;
        this.f5890fy = resourceLocation7;
        f5880bK.add(this);
        f5881T.put(this.f5883fr, this);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1092tr m5986a(@NotNull ResourceLocation resourceLocation) {
        return f5881T.get(resourceLocation);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1092tr m5987a(@NotNull String str) {
        return f5881T.get(C0532jO.m2378d(str));
    }

    @NotNull
    /* JADX INFO: renamed from: ax */
    public static List<C1092tr> m5988ax() {
        return Collections.unmodifiableList(f5880bK);
    }

    @NotNull
    public String getKey() {
        return this.f5882cS;
    }

    @NotNull
    /* JADX INFO: renamed from: M */
    public ResourceLocation m5989M() {
        return this.f5883fr;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private static DeferredHolder<SoundEvent, SoundEvent> m5990a(@NotNull ResourceLocation resourceLocation) {
        return (DeferredHolder) C1312xz.f7911h.get(resourceLocation.toString());
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public DeferredHolder<SoundEvent, SoundEvent> m5991d() {
        return m5990a(this.f5884fs);
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    public DeferredHolder<SoundEvent, SoundEvent> m5992e() {
        return m5990a(this.f5885ft);
    }

    @Nullable
    /* JADX INFO: renamed from: f */
    public DeferredHolder<SoundEvent, SoundEvent> m5993f() {
        return m5990a(this.f5886fu);
    }

    @Nullable
    /* JADX INFO: renamed from: g */
    public DeferredHolder<SoundEvent, SoundEvent> m5994g() {
        return m5990a(this.f5887fv);
    }

    @Nullable
    /* JADX INFO: renamed from: h */
    public DeferredHolder<SoundEvent, SoundEvent> m5995h() {
        return m5990a(this.f5888fw);
    }

    @Nullable
    /* JADX INFO: renamed from: i */
    public DeferredHolder<SoundEvent, SoundEvent> m5996i() {
        return m5990a(this.f5889fx);
    }

    @Nullable
    /* JADX INFO: renamed from: j */
    public DeferredHolder<SoundEvent, SoundEvent> m5997j() {
        return m5990a(this.f5890fy);
    }
}
