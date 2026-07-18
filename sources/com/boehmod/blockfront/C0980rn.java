package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rn.class */
public final class C0980rn extends Record {

    /* JADX INFO: renamed from: cr */
    private final String f5205cr;

    /* JADX INFO: renamed from: bc */
    private final List<C0805oX> f5206bc;

    /* JADX INFO: renamed from: W */
    @NotNull
    public static final Codec<C0980rn> f5207W = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("name").forGetter((v0) -> {
            return v0.m5406g();
        }), C0805oX.f4422s.listOf().fieldOf("spawns").forGetter((v0) -> {
            return v0.m5407ai();
        })).apply(instance, C0980rn::new);
    });

    public C0980rn(String str, List<C0805oX> list) {
        this.f5205cr = str;
        this.f5206bc = list;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0980rn.class), C0980rn.class, "name;spawns", "FIELD:Lcom/boehmod/blockfront/rn;->cr:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rn;->bc:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0980rn.class), C0980rn.class, "name;spawns", "FIELD:Lcom/boehmod/blockfront/rn;->cr:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rn;->bc:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0980rn.class, Object.class), C0980rn.class, "name;spawns", "FIELD:Lcom/boehmod/blockfront/rn;->cr:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rn;->bc:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: g */
    public String m5406g() {
        return this.f5205cr;
    }

    /* JADX INFO: renamed from: ai */
    public List<C0805oX> m5407ai() {
        return this.f5206bc;
    }
}
