package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/B.class */
public final class B extends Record {
    private final String t;
    private final String u;
    private final String v;

    @NotNull
    public static final Codec<B> b = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("name").forGetter((v0) -> {
            return v0.g();
        }), Codec.STRING.fieldOf("uuid").forGetter((v0) -> {
            return v0.h();
        }), Codec.STRING.fieldOf("translation").forGetter((v0) -> {
            return v0.i();
        })).apply(instance, B::new);
    });

    @NotNull
    public static final B a = new B("default", "143b454d-2366-4eee-b930-76b0e55a8f0a", "unknown");

    public B(String str, String str2, String str3) {
        this.t = str;
        this.u = str2;
        this.v = str3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, B.class), B.class, "name;uuid;translation", "FIELD:Lcom/boehmod/blockfront/B;->t:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/B;->u:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/B;->v:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, B.class), B.class, "name;uuid;translation", "FIELD:Lcom/boehmod/blockfront/B;->t:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/B;->u:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/B;->v:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, B.class, Object.class), B.class, "name;uuid;translation", "FIELD:Lcom/boehmod/blockfront/B;->t:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/B;->u:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/B;->v:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public String g() {
        return this.t;
    }

    public String h() {
        return this.u;
    }

    public String i() {
        return this.v;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/B$a.class */
    public static class a extends jW<B> {
        public a(@NotNull Minecraft minecraft) {
            super(minecraft.getResourceManager(), "credits", "credits.json", B.b, B.a, (v0) -> {
                return v0.h();
            });
        }
    }
}
