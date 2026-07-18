package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.A */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/A.class */
public final class C0003A extends Record {

    /* JADX INFO: renamed from: s */
    private final String f108s;

    /* JADX INFO: renamed from: a */
    private final ResourceLocation f109a;

    /* JADX INFO: renamed from: b */
    private final ResourceLocation f110b;

    /* JADX INFO: renamed from: c */
    private final ResourceLocation f111c;

    /* JADX INFO: renamed from: d */
    private final ResourceLocation f112d;

    /* JADX INFO: renamed from: e */
    private final ResourceLocation f113e;

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final Codec<C0003A> f114a = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("name").forGetter((v0) -> {
            return v0.m0g();
        }), ResourceLocation.CODEC.fieldOf("top").forGetter((v0) -> {
            return v0.m1a();
        }), ResourceLocation.CODEC.fieldOf("bottom").forGetter((v0) -> {
            return v0.m2b();
        }), ResourceLocation.CODEC.fieldOf("left").forGetter((v0) -> {
            return v0.m3c();
        }), ResourceLocation.CODEC.fieldOf("right").forGetter((v0) -> {
            return v0.m4d();
        }), ResourceLocation.CODEC.fieldOf("middle").forGetter((v0) -> {
            return v0.m5e();
        })).apply(instance, C0003A::new);
    });

    /* JADX INFO: renamed from: f */
    @NotNull
    private static final ResourceLocation f115f = C0564jv.m2555d("textures/crosshairs/default/top.png");

    /* JADX INFO: renamed from: g */
    @NotNull
    private static final ResourceLocation f116g = C0564jv.m2555d("textures/crosshairs/default/bottom.png");

    /* JADX INFO: renamed from: h */
    @NotNull
    private static final ResourceLocation f117h = C0564jv.m2555d("textures/crosshairs/default/left.png");

    /* JADX INFO: renamed from: i */
    @NotNull
    private static final ResourceLocation f118i = C0564jv.m2555d("textures/crosshairs/default/right.png");

    /* JADX INFO: renamed from: j */
    @NotNull
    private static final ResourceLocation f119j = C0564jv.m2555d("textures/crosshairs/default/middle.png");

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final C0003A f120a = new C0003A("default", f115f, f116g, f117h, f118i, f119j);

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0003A.class), C0003A.class, "name;top;bottom;left;right;middle", "FIELD:Lcom/boehmod/blockfront/A;->s:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/A;->a:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/A;->b:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/A;->c:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/A;->d:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/A;->e:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0003A.class), C0003A.class, "name;top;bottom;left;right;middle", "FIELD:Lcom/boehmod/blockfront/A;->s:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/A;->a:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/A;->b:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/A;->c:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/A;->d:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/A;->e:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0003A.class, Object.class), C0003A.class, "name;top;bottom;left;right;middle", "FIELD:Lcom/boehmod/blockfront/A;->s:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/A;->a:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/A;->b:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/A;->c:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/A;->d:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/A;->e:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: g */
    public String m0g() {
        return this.f108s;
    }

    /* JADX INFO: renamed from: a */
    public ResourceLocation m1a() {
        return this.f109a;
    }

    /* JADX INFO: renamed from: b */
    public ResourceLocation m2b() {
        return this.f110b;
    }

    /* JADX INFO: renamed from: c */
    public ResourceLocation m3c() {
        return this.f111c;
    }

    /* JADX INFO: renamed from: d */
    public ResourceLocation m4d() {
        return this.f112d;
    }

    /* JADX INFO: renamed from: e */
    public ResourceLocation m5e() {
        return this.f113e;
    }

    public C0003A(@NotNull String str, @NotNull ResourceLocation resourceLocation, @NotNull ResourceLocation resourceLocation2, @NotNull ResourceLocation resourceLocation3, @NotNull ResourceLocation resourceLocation4, @NotNull ResourceLocation resourceLocation5) {
        this.f108s = str;
        this.f109a = resourceLocation;
        this.f110b = resourceLocation2;
        this.f111c = resourceLocation3;
        this.f112d = resourceLocation4;
        this.f113e = resourceLocation5;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.A$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/A$a.class */
    public static class a extends AbstractC0539jW<C0003A> {
        public a(@NotNull Minecraft minecraft) {
            super(minecraft.getResourceManager(), "crosshairs", "crosshairs.json", C0003A.f114a, C0003A.f120a, (v0) -> {
                return v0.m0g();
            });
        }
    }
}
