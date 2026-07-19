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

/* JADX INFO: renamed from: com.boehmod.blockfront.uw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uw.class */
public final class C0563uw extends Record {

    @Nullable
    private final C0566uz a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private final C0565uy f319a;
    private final boolean ir;
    private final boolean is;

    @NotNull
    public static final Map<ResourceLocation, C0563uw> aj = new LinkedHashMap();

    @NotNull
    public static final Map<Block, C0563uw> ak = new Object2ObjectOpenHashMap();

    @NotNull
    public static final Map<SoundType, C0563uw> al = new Object2ObjectOpenHashMap();

    public C0563uw(@Nullable C0566uz c0566uz, @Nullable C0565uy c0565uy, boolean z, boolean z2) {
        this.a = c0566uz;
        this.f319a = c0565uy;
        this.ir = z;
        this.is = z2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0563uw.class), C0563uw.class, "traversable;impact;preventsWeaponClipping;seeThrough", "FIELD:Lcom/boehmod/blockfront/uw;->a:Lcom/boehmod/blockfront/uz;", "FIELD:Lcom/boehmod/blockfront/uw;->a:Lcom/boehmod/blockfront/uy;", "FIELD:Lcom/boehmod/blockfront/uw;->ir:Z", "FIELD:Lcom/boehmod/blockfront/uw;->is:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0563uw.class), C0563uw.class, "traversable;impact;preventsWeaponClipping;seeThrough", "FIELD:Lcom/boehmod/blockfront/uw;->a:Lcom/boehmod/blockfront/uz;", "FIELD:Lcom/boehmod/blockfront/uw;->a:Lcom/boehmod/blockfront/uy;", "FIELD:Lcom/boehmod/blockfront/uw;->ir:Z", "FIELD:Lcom/boehmod/blockfront/uw;->is:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0563uw.class, Object.class), C0563uw.class, "traversable;impact;preventsWeaponClipping;seeThrough", "FIELD:Lcom/boehmod/blockfront/uw;->a:Lcom/boehmod/blockfront/uz;", "FIELD:Lcom/boehmod/blockfront/uw;->a:Lcom/boehmod/blockfront/uy;", "FIELD:Lcom/boehmod/blockfront/uw;->ir:Z", "FIELD:Lcom/boehmod/blockfront/uw;->is:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Nullable
    public C0566uz b() {
        return this.a;
    }

    @Nullable
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public C0565uy m1233b() {
        return this.f319a;
    }

    public boolean cE() {
        return this.ir;
    }

    public boolean cF() {
        return this.is;
    }

    static {
        jP.bo();
    }

    public static void aR() {
        aj.clear();
        ak.clear();
        al.clear();
    }

    public static void a(@NotNull ResourceLocation resourceLocation, @NotNull C0563uw c0563uw) {
        aj.put(resourceLocation, c0563uw);
    }

    public void c(@NotNull Block block) {
        ak.put(block, this);
    }

    public void a(@NotNull SoundType soundType) {
        al.put(soundType, this);
    }

    @Nullable
    public C0566uz a() {
        return this.a;
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0565uy m1232a() {
        return this.f319a;
    }
}
