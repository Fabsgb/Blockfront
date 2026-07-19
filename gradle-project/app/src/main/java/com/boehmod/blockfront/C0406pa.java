package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pa.class */
public final class C0406pa extends Record {

    @NotNull
    private final List<ItemStack> ax;

    @NotNull
    private final List<C0415pj> ay;
    private final int ns;
    private final int nt;

    @NotNull
    public static final Codec<C0406pa> u = RecordCodecBuilder.create(instance -> {
        return instance.group(ItemStack.CODEC.listOf().optionalFieldOf("items", List.of()).forGetter((v0) -> {
            return v0.C();
        }), C0415pj.y.listOf().optionalFieldOf("slots", List.of()).forGetter((v0) -> {
            return v0.D();
        }), Codec.INT.optionalFieldOf("cost", 0).forGetter((v0) -> {
            return v0.bg();
        }), Codec.INT.optionalFieldOf("exp", 0).forGetter((v0) -> {
            return v0.bh();
        })).apply(instance, (v1, v2, v3, v4) -> {
            return new C0406pa(v1, v2, v3, v4);
        });
    });

    public C0406pa(@NotNull List<ItemStack> list, @NotNull List<C0415pj> list2, int i, int i2) {
        this.ax = list;
        this.ay = list2;
        this.ns = i;
        this.nt = i2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0406pa.class), C0406pa.class, "items;slots;cost;exp", "FIELD:Lcom/boehmod/blockfront/pa;->ax:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/pa;->ay:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/pa;->ns:I", "FIELD:Lcom/boehmod/blockfront/pa;->nt:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0406pa.class), C0406pa.class, "items;slots;cost;exp", "FIELD:Lcom/boehmod/blockfront/pa;->ax:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/pa;->ay:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/pa;->ns:I", "FIELD:Lcom/boehmod/blockfront/pa;->nt:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0406pa.class, Object.class), C0406pa.class, "items;slots;cost;exp", "FIELD:Lcom/boehmod/blockfront/pa;->ax:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/pa;->ay:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/pa;->ns:I", "FIELD:Lcom/boehmod/blockfront/pa;->nt:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public List<ItemStack> C() {
        return this.ax;
    }

    @NotNull
    public List<C0415pj> D() {
        return this.ay;
    }

    public int bg() {
        return this.ns;
    }

    public int bh() {
        return this.nt;
    }

    @NotNull
    public C0411pf a(@NotNull sZ sZVar, @NotNull Map<String, ItemStack> map) {
        C0411pf c0411pf = new C0411pf();
        for (ItemStack itemStack : this.ax) {
            if (!itemStack.isEmpty()) {
                c0411pf.e(itemStack.copy());
            }
        }
        Iterator<C0415pj> it = this.ay.iterator();
        while (it.hasNext()) {
            ItemStack itemStackA = it.next().a(sZVar, map);
            if (!itemStackA.isEmpty()) {
                c0411pf.e(itemStackA);
            }
        }
        c0411pf.b(this.nt);
        c0411pf.a(this.ns);
        return c0411pf;
    }
}
