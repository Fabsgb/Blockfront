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

/* JADX INFO: renamed from: com.boehmod.blockfront.pa */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pa.class */
public final class C0861pa extends Record {

    /* JADX INFO: renamed from: ax */
    @NotNull
    private final List<ItemStack> f4503ax;

    /* JADX INFO: renamed from: ay */
    @NotNull
    private final List<C0870pj> f4504ay;

    /* JADX INFO: renamed from: ns */
    private final int f4505ns;

    /* JADX INFO: renamed from: nt */
    private final int f4506nt;

    /* JADX INFO: renamed from: u */
    @NotNull
    public static final Codec<C0861pa> f4507u = RecordCodecBuilder.create(instance -> {
        return instance.group(ItemStack.CODEC.listOf().optionalFieldOf("items", List.of()).forGetter((v0) -> {
            return v0.m4290C();
        }), C0870pj.f4573y.listOf().optionalFieldOf("slots", List.of()).forGetter((v0) -> {
            return v0.m4291D();
        }), Codec.INT.optionalFieldOf("cost", 0).forGetter((v0) -> {
            return v0.m4292bg();
        }), Codec.INT.optionalFieldOf("exp", 0).forGetter((v0) -> {
            return v0.m4293bh();
        })).apply(instance, (v1, v2, v3, v4) -> {
            return new C0861pa(v1, v2, v3, v4);
        });
    });

    public C0861pa(@NotNull List<ItemStack> list, @NotNull List<C0870pj> list2, int i, int i2) {
        this.f4503ax = list;
        this.f4504ay = list2;
        this.f4505ns = i;
        this.f4506nt = i2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0861pa.class), C0861pa.class, "items;slots;cost;exp", "FIELD:Lcom/boehmod/blockfront/pa;->ax:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/pa;->ay:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/pa;->ns:I", "FIELD:Lcom/boehmod/blockfront/pa;->nt:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0861pa.class), C0861pa.class, "items;slots;cost;exp", "FIELD:Lcom/boehmod/blockfront/pa;->ax:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/pa;->ay:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/pa;->ns:I", "FIELD:Lcom/boehmod/blockfront/pa;->nt:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0861pa.class, Object.class), C0861pa.class, "items;slots;cost;exp", "FIELD:Lcom/boehmod/blockfront/pa;->ax:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/pa;->ay:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/pa;->ns:I", "FIELD:Lcom/boehmod/blockfront/pa;->nt:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: C */
    public List<ItemStack> m4290C() {
        return this.f4503ax;
    }

    @NotNull
    /* JADX INFO: renamed from: D */
    public List<C0870pj> m4291D() {
        return this.f4504ay;
    }

    /* JADX INFO: renamed from: bg */
    public int m4292bg() {
        return this.f4505ns;
    }

    /* JADX INFO: renamed from: bh */
    public int m4293bh() {
        return this.f4506nt;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0866pf m4289a(@NotNull C1019sZ c1019sZ, @NotNull Map<String, ItemStack> map) {
        C0866pf c0866pf = new C0866pf();
        for (ItemStack itemStack : this.f4503ax) {
            if (!itemStack.isEmpty()) {
                c0866pf.m4330e(itemStack.copy());
            }
        }
        Iterator<C0870pj> it = this.f4504ay.iterator();
        while (it.hasNext()) {
            ItemStack itemStackM4374a = it.next().m4374a(c1019sZ, map);
            if (!itemStackM4374a.isEmpty()) {
                c0866pf.m4330e(itemStackM4374a);
            }
        }
        c0866pf.m4334b(this.f4506nt);
        c0866pf.m4332a(this.f4505ns);
        return c0866pf;
    }
}
