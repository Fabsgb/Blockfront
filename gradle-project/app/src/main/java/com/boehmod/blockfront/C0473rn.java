package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rn.class */
public final class C0473rn extends Record {
    private final String cr;
    private final List<oX> bc;

    @NotNull
    public static final Codec<C0473rn> W = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("name").forGetter((v0) -> {
            return v0.g();
        }), oX.s.listOf().fieldOf("spawns").forGetter((v0) -> {
            return v0.ai();
        })).apply(instance, C0473rn::new);
    });

    public C0473rn(String str, List<oX> list) {
        this.cr = str;
        this.bc = list;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0473rn.class), C0473rn.class, "name;spawns", "FIELD:Lcom/boehmod/blockfront/rn;->cr:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rn;->bc:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0473rn.class), C0473rn.class, "name;spawns", "FIELD:Lcom/boehmod/blockfront/rn;->cr:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rn;->bc:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0473rn.class, Object.class), C0473rn.class, "name;spawns", "FIELD:Lcom/boehmod/blockfront/rn;->cr:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/rn;->bc:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public String g() {
        return this.cr;
    }

    public List<oX> ai() {
        return this.bc;
    }
}
