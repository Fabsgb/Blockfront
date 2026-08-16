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

/* JADX INFO: renamed from: com.boehmod.blockfront.pw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pw.class */
public final class C0884pw extends Record {

    /* JADX INFO: renamed from: aE */
    @NotNull
    private final List<ItemStack> f4836aE;

    /* JADX INFO: renamed from: aF */
    @NotNull
    private final List<C0841pF> f4837aF;

    /* JADX INFO: renamed from: pr */
    private final int f4838pr;

    /* JADX INFO: renamed from: ps */
    private final int f4839ps;

    /* JADX INFO: renamed from: u */
    @NotNull
    public static final Codec<C0884pw> f4840u = RecordCodecBuilder.create(instance -> {
        return instance.group(ItemStack.CODEC.listOf().optionalFieldOf("items", List.of()).forGetter((v0) -> {
            return v0.m4615E();
        }), C0841pF.f4542y.listOf().optionalFieldOf("slots", List.of()).forGetter((v0) -> {
            return v0.m4616F();
        }), Codec.INT.optionalFieldOf("cost", 0).forGetter((v0) -> {
            return v0.m4617bv();
        }), Codec.INT.optionalFieldOf("exp", 0).forGetter((v0) -> {
            return v0.m4618bw();
        })).apply(instance, (v1, v2, v3, v4) -> {
            return new C0884pw(v1, v2, v3, v4);
        });
    });

    public C0884pw(@NotNull List<ItemStack> list, @NotNull List<C0841pF> list2, int i, int i2) {
        this.f4836aE = list;
        this.f4837aF = list2;
        this.f4838pr = i;
        this.f4839ps = i2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0884pw.class), C0884pw.class, "items;slots;cost;exp", "FIELD:Lcom/boehmod/blockfront/pw;->aE:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/pw;->aF:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/pw;->pr:I", "FIELD:Lcom/boehmod/blockfront/pw;->ps:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0884pw.class), C0884pw.class, "items;slots;cost;exp", "FIELD:Lcom/boehmod/blockfront/pw;->aE:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/pw;->aF:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/pw;->pr:I", "FIELD:Lcom/boehmod/blockfront/pw;->ps:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0884pw.class, Object.class), C0884pw.class, "items;slots;cost;exp", "FIELD:Lcom/boehmod/blockfront/pw;->aE:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/pw;->aF:Ljava/util/List;", "FIELD:Lcom/boehmod/blockfront/pw;->pr:I", "FIELD:Lcom/boehmod/blockfront/pw;->ps:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: E */
    public List<ItemStack> m4615E() {
        return this.f4836aE;
    }

    @NotNull
    /* JADX INFO: renamed from: F */
    public List<C0841pF> m4616F() {
        return this.f4837aF;
    }

    /* JADX INFO: renamed from: bv */
    public int m4617bv() {
        return this.f4838pr;
    }

    /* JADX INFO: renamed from: bw */
    public int m4618bw() {
        return this.f4839ps;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0837pB m4614a(@NotNull C1097tw c1097tw, @NotNull Map<String, ItemStack> map) {
        C0837pB c0837pB = new C0837pB();
        for (ItemStack itemStack : this.f4836aE) {
            if (!itemStack.isEmpty()) {
                c0837pB.m3815e(itemStack.copy());
            }
        }
        Iterator<C0841pF> it = this.f4837aF.iterator();
        while (it.hasNext()) {
            ItemStack itemStackM3860a = it.next().m3860a(c1097tw, map);
            if (!itemStackM3860a.isEmpty()) {
                c0837pB.m3815e(itemStackM3860a);
            }
        }
        c0837pB.m3819b(this.f4839ps);
        c0837pB.m3817a(this.f4838pr);
        return c0837pB;
    }
}
