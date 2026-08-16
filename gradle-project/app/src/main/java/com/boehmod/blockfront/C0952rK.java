package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rK.class */
public final class C0952rK extends Record {

    /* JADX INFO: renamed from: cB */
    private final String f5309cB;

    /* JADX INFO: renamed from: bj */
    private final List<C0881pt> f5310bj;

    /* JADX INFO: renamed from: W */
    @NotNull
    public static final Codec<C0952rK> f5311W = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("name").forGetter((v0) -> {
            return v0.m5282k();
        }), C0881pt.f4825s.listOf().fieldOf("spawns").forGetter((v0) -> {
            return v0.m5283ak();
        })).apply(instance, C0952rK::new);
    });

    public C0952rK(String str, List<C0881pt> list) {
        this.f5309cB = str;
        this.f5310bj = list;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0952rK.class), C0952rK.class, "name;spawns", "FIELD:Lcom/boehmod/blockfront/rK;->cB:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rK;->bj:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0952rK.class), C0952rK.class, "name;spawns", "FIELD:Lcom/boehmod/blockfront/rK;->cB:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rK;->bj:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0952rK.class, Object.class), C0952rK.class, "name;spawns", "FIELD:Lcom/boehmod/blockfront/rK;->cB:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rK;->bj:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: k */
    public String m5282k() {
        return this.f5309cB;
    }

    /* JADX INFO: renamed from: ak */
    public List<C0881pt> m5283ak() {
        return this.f5310bj;
    }
}
