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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sU.class */
public final class sU {

    @NotNull
    public static final List<sU> bD = new ObjectArrayList();

    @NotNull
    private static final Map<ResourceLocation, sU> T = new LinkedHashMap();

    @NotNull
    private final String cI;

    @NotNull
    private final ResourceLocation fs;

    @NotNull
    private final ResourceLocation ft;

    @NotNull
    private final ResourceLocation fu;

    @NotNull
    private final ResourceLocation fv;

    @NotNull
    private final ResourceLocation fw;

    @NotNull
    private final ResourceLocation fx;

    @NotNull
    private final ResourceLocation fy;

    @NotNull
    private final ResourceLocation fz;

    static {
        jQ.bo();
    }

    public static void aR() {
        bD.clear();
        T.clear();
    }

    public sU(@NotNull String str, @NotNull ResourceLocation resourceLocation, @NotNull ResourceLocation resourceLocation2, @NotNull ResourceLocation resourceLocation3, @NotNull ResourceLocation resourceLocation4, @NotNull ResourceLocation resourceLocation5, @NotNull ResourceLocation resourceLocation6, @NotNull ResourceLocation resourceLocation7) {
        this.cI = str;
        this.fs = C0265jv.d(str);
        this.ft = resourceLocation;
        this.fu = resourceLocation2;
        this.fv = resourceLocation3;
        this.fw = resourceLocation4;
        this.fx = resourceLocation5;
        this.fy = resourceLocation6;
        this.fz = resourceLocation7;
        bD.add(this);
        T.put(this.fs, this);
    }

    @Nullable
    public static sU a(@NotNull ResourceLocation resourceLocation) {
        return T.get(resourceLocation);
    }

    @Nullable
    public static sU a(@NotNull String str) {
        return T.get(C0265jv.d(str));
    }

    @NotNull
    public static List<sU> av() {
        return Collections.unmodifiableList(bD);
    }

    @NotNull
    public String getKey() {
        return this.cI;
    }

    @NotNull
    public ResourceLocation L() {
        return this.fs;
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static DeferredHolder<SoundEvent, SoundEvent> m1091a(@NotNull ResourceLocation resourceLocation) {
        return (DeferredHolder) C0624xc.h.get(resourceLocation.toString());
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> d() {
        return m1091a(this.ft);
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> e() {
        return m1091a(this.fu);
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> f() {
        return m1091a(this.fv);
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> g() {
        return m1091a(this.fw);
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> h() {
        return m1091a(this.fx);
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> i() {
        return m1091a(this.fy);
    }

    @Nullable
    public DeferredHolder<SoundEvent, SoundEvent> j() {
        return m1091a(this.fz);
    }
}
