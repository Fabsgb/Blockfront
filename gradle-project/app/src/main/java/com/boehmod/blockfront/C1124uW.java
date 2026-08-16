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

/* JADX INFO: renamed from: com.boehmod.blockfront.uW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uW.class */
public final class C1124uW extends Record {

    /* JADX INFO: renamed from: a */
    @Nullable
    private final C1127uZ f6149a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private final C1126uY f6150a;

    /* JADX INFO: renamed from: iL */
    private final boolean f6151iL;

    /* JADX INFO: renamed from: iM */
    private final boolean f6152iM;

    /* JADX INFO: renamed from: aj */
    @NotNull
    public static final Map<ResourceLocation, C1124uW> f6153aj = new LinkedHashMap();

    /* JADX INFO: renamed from: ak */
    @NotNull
    public static final Map<Block, C1124uW> f6154ak = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: al */
    @NotNull
    public static final Map<SoundType, C1124uW> f6155al = new Object2ObjectOpenHashMap();

    public C1124uW(@Nullable C1127uZ c1127uZ, @Nullable C1126uY c1126uY, boolean z, boolean z2) {
        this.f6149a = c1127uZ;
        this.f6150a = c1126uY;
        this.f6151iL = z;
        this.f6152iM = z2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1124uW.class), C1124uW.class, "traversable;impact;preventsWeaponClipping;seeThrough", "FIELD:Lcom/boehmod/blockfront/uW;->a:Lcom/boehmod/blockfront/uZ;", "FIELD:Lcom/boehmod/blockfront/uW;->a:Lcom/boehmod/blockfront/uY;", "FIELD:Lcom/boehmod/blockfront/uW;->iL:Z", "FIELD:Lcom/boehmod/blockfront/uW;->iM:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1124uW.class), C1124uW.class, "traversable;impact;preventsWeaponClipping;seeThrough", "FIELD:Lcom/boehmod/blockfront/uW;->a:Lcom/boehmod/blockfront/uZ;", "FIELD:Lcom/boehmod/blockfront/uW;->a:Lcom/boehmod/blockfront/uY;", "FIELD:Lcom/boehmod/blockfront/uW;->iL:Z", "FIELD:Lcom/boehmod/blockfront/uW;->iM:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1124uW.class, Object.class), C1124uW.class, "traversable;impact;preventsWeaponClipping;seeThrough", "FIELD:Lcom/boehmod/blockfront/uW;->a:Lcom/boehmod/blockfront/uZ;", "FIELD:Lcom/boehmod/blockfront/uW;->a:Lcom/boehmod/blockfront/uY;", "FIELD:Lcom/boehmod/blockfront/uW;->iL:Z", "FIELD:Lcom/boehmod/blockfront/uW;->iM:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public C1127uZ m6427b() {
        return this.f6149a;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public C1126uY m6428b() {
        return this.f6150a;
    }

    /* JADX INFO: renamed from: cN */
    public boolean m6429cN() {
        return this.f6151iL;
    }

    /* JADX INFO: renamed from: cO */
    public boolean m6430cO() {
        return this.f6152iM;
    }

    static {
        C0608kl.m2754bz();
    }

    /* JADX INFO: renamed from: aZ */
    public static void m6421aZ() {
        f6153aj.clear();
        f6154ak.clear();
        f6155al.clear();
    }

    /* JADX INFO: renamed from: a */
    public static void m6422a(@NotNull ResourceLocation resourceLocation, @NotNull C1124uW c1124uW) {
        f6153aj.put(resourceLocation, c1124uW);
    }

    /* JADX INFO: renamed from: c */
    public void m6423c(@NotNull Block block) {
        f6154ak.put(block, this);
    }

    /* JADX INFO: renamed from: a */
    public void m6424a(@NotNull SoundType soundType) {
        f6155al.put(soundType, this);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C1127uZ m6425a() {
        return this.f6149a;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C1126uY m6426a() {
        return this.f6150a;
    }
}
