package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.LinkedHashMap;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.uw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uw.class */
public final class C1149uw extends Record {

    /* JADX INFO: renamed from: a */
    @Nullable
    private final C1152uz f6080a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private final C1151uy f6081a;

    /* JADX INFO: renamed from: ir */
    private final boolean f6082ir;

    /* JADX INFO: renamed from: is */
    private final boolean f6083is;

    /* JADX INFO: renamed from: aj */
    @NotNull
    public static final Map<ResourceLocation, C1149uw> f6084aj = new LinkedHashMap();

    /* JADX INFO: renamed from: ak */
    @NotNull
    public static final Map<Block, C1149uw> f6085ak = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: al */
    @NotNull
    public static final Map<SoundType, C1149uw> f6086al = new Object2ObjectOpenHashMap();

    public C1149uw(@Nullable C1152uz c1152uz, @Nullable C1151uy c1151uy, boolean z, boolean z2) {
        this.f6080a = c1152uz;
        this.f6081a = c1151uy;
        this.f6082ir = z;
        this.f6083is = z2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1149uw.class), C1149uw.class, "traversable;impact;preventsWeaponClipping;seeThrough", "FIELD:Lcom/boehmod/blockfront/uw;->a:Lcom/boehmod/blockfront/uz;", "FIELD:Lcom/boehmod/blockfront/uw;->a:Lcom/boehmod/blockfront/uy;", "FIELD:Lcom/boehmod/blockfront/uw;->ir:Z", "FIELD:Lcom/boehmod/blockfront/uw;->is:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1149uw.class), C1149uw.class, "traversable;impact;preventsWeaponClipping;seeThrough", "FIELD:Lcom/boehmod/blockfront/uw;->a:Lcom/boehmod/blockfront/uz;", "FIELD:Lcom/boehmod/blockfront/uw;->a:Lcom/boehmod/blockfront/uy;", "FIELD:Lcom/boehmod/blockfront/uw;->ir:Z", "FIELD:Lcom/boehmod/blockfront/uw;->is:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1149uw.class, Object.class), C1149uw.class, "traversable;impact;preventsWeaponClipping;seeThrough", "FIELD:Lcom/boehmod/blockfront/uw;->a:Lcom/boehmod/blockfront/uz;", "FIELD:Lcom/boehmod/blockfront/uw;->a:Lcom/boehmod/blockfront/uy;", "FIELD:Lcom/boehmod/blockfront/uw;->ir:Z", "FIELD:Lcom/boehmod/blockfront/uw;->is:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public C1152uz m6441b() {
        return this.f6080a;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public C1151uy m6442b() {
        return this.f6081a;
    }

    /* JADX INFO: renamed from: cE */
    public boolean m6443cE() {
        return this.f6082ir;
    }

    /* JADX INFO: renamed from: cF */
    public boolean m6444cF() {
        return this.f6083is;
    }

    static {
        C0532jP.m2392bo();
    }

    /* JADX INFO: renamed from: aR */
    public static void m6435aR() {
        f6084aj.clear();
        f6085ak.clear();
        f6086al.clear();
    }

    /* JADX INFO: renamed from: a */
    public static void m6436a(@NotNull ResourceLocation resourceLocation, @NotNull C1149uw c1149uw) {
        f6084aj.put(resourceLocation, c1149uw);
    }

    /* JADX INFO: renamed from: c */
    public void m6437c(@NotNull Block block) {
        f6085ak.put(block, this);
    }

    /* JADX INFO: renamed from: a */
    public void m6438a(@NotNull SoundType soundType) {
        f6086al.put(soundType, this);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C1152uz m6439a() {
        return this.f6080a;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C1151uy m6440a() {
        return this.f6081a;
    }
}
