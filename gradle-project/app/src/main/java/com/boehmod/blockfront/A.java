package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/A.class */
public final class A extends Record {
    private final String s;
    private final ResourceLocation a;
    private final ResourceLocation b;
    private final ResourceLocation c;
    private final ResourceLocation d;
    private final ResourceLocation e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final Codec<A> f0a = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("name").forGetter((v0) -> {
            return v0.g();
        }), ResourceLocation.CODEC.fieldOf("top").forGetter((v0) -> {
            return v0.a();
        }), ResourceLocation.CODEC.fieldOf("bottom").forGetter((v0) -> {
            return v0.b();
        }), ResourceLocation.CODEC.fieldOf("left").forGetter((v0) -> {
            return v0.c();
        }), ResourceLocation.CODEC.fieldOf("right").forGetter((v0) -> {
            return v0.d();
        }), ResourceLocation.CODEC.fieldOf("middle").forGetter((v0) -> {
            return v0.e();
        })).apply(instance, A::new);
    });

    @NotNull
    private static final ResourceLocation f = C0265jv.d("textures/crosshairs/default/top.png");

    @NotNull
    private static final ResourceLocation g = C0265jv.d("textures/crosshairs/default/bottom.png");

    @NotNull
    private static final ResourceLocation h = C0265jv.d("textures/crosshairs/default/left.png");

    @NotNull
    private static final ResourceLocation i = C0265jv.d("textures/crosshairs/default/right.png");

    @NotNull
    private static final ResourceLocation j = C0265jv.d("textures/crosshairs/default/middle.png");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final A f1a = new A("default", f, g, h, i, j);

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, A.class), A.class, "name;top;bottom;left;right;middle", "FIELD:Lcom/boehmod/blockfront/A;->s:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/A;->a:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/A;->b:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/A;->c:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/A;->d:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/A;->e:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, A.class), A.class, "name;top;bottom;left;right;middle", "FIELD:Lcom/boehmod/blockfront/A;->s:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/A;->a:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/A;->b:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/A;->c:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/A;->d:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/A;->e:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, A.class, Object.class), A.class, "name;top;bottom;left;right;middle", "FIELD:Lcom/boehmod/blockfront/A;->s:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/A;->a:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/A;->b:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/A;->c:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/A;->d:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/A;->e:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public String g() {
        return this.s;
    }

    public ResourceLocation a() {
        return this.a;
    }

    public ResourceLocation b() {
        return this.b;
    }

    public ResourceLocation c() {
        return this.c;
    }

    public ResourceLocation d() {
        return this.d;
    }

    public ResourceLocation e() {
        return this.e;
    }

    public A(@NotNull String str, @NotNull ResourceLocation resourceLocation, @NotNull ResourceLocation resourceLocation2, @NotNull ResourceLocation resourceLocation3, @NotNull ResourceLocation resourceLocation4, @NotNull ResourceLocation resourceLocation5) {
        this.s = str;
        this.a = resourceLocation;
        this.b = resourceLocation2;
        this.c = resourceLocation3;
        this.d = resourceLocation4;
        this.e = resourceLocation5;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/A$a.class */
    public static class a extends jW<A> {
        public a(@NotNull Minecraft minecraft) {
            super(minecraft.getResourceManager(), "crosshairs", "crosshairs.json", A.f0a, A.f1a, (v0) -> {
                return v0.g();
            });
        }
    }
}
