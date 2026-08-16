package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.G */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/G.class */
public final class C0010G extends Record {

    /* JADX INFO: renamed from: x */
    private final String f146x;

    /* JADX INFO: renamed from: a */
    private final ResourceLocation f147a;

    /* JADX INFO: renamed from: b */
    private final ResourceLocation f148b;

    /* JADX INFO: renamed from: c */
    private final ResourceLocation f149c;

    /* JADX INFO: renamed from: d */
    private final ResourceLocation f150d;

    /* JADX INFO: renamed from: e */
    private final ResourceLocation f151e;

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final Codec<C0010G> f152a = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("name").forGetter((v0) -> {
            return v0.m32k();
        }), ResourceLocation.CODEC.fieldOf("top").forGetter((v0) -> {
            return v0.m33a();
        }), ResourceLocation.CODEC.fieldOf("bottom").forGetter((v0) -> {
            return v0.m34b();
        }), ResourceLocation.CODEC.fieldOf("left").forGetter((v0) -> {
            return v0.m35c();
        }), ResourceLocation.CODEC.fieldOf("right").forGetter((v0) -> {
            return v0.m36d();
        }), ResourceLocation.CODEC.fieldOf("middle").forGetter((v0) -> {
            return v0.m37e();
        })).apply(instance, C0010G::new);
    });

    /* JADX INFO: renamed from: f */
    @NotNull
    private static final ResourceLocation f153f = C0532jO.m2378d("textures/crosshairs/default/top.png");

    /* JADX INFO: renamed from: g */
    @NotNull
    private static final ResourceLocation f154g = C0532jO.m2378d("textures/crosshairs/default/bottom.png");

    /* JADX INFO: renamed from: h */
    @NotNull
    private static final ResourceLocation f155h = C0532jO.m2378d("textures/crosshairs/default/left.png");

    /* JADX INFO: renamed from: i */
    @NotNull
    private static final ResourceLocation f156i = C0532jO.m2378d("textures/crosshairs/default/right.png");

    /* JADX INFO: renamed from: j */
    @NotNull
    private static final ResourceLocation f157j = C0532jO.m2378d("textures/crosshairs/default/middle.png");

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final C0010G f158a = new C0010G("default", f153f, f154g, f155h, f156i, f157j);

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0010G.class), C0010G.class, "name;top;bottom;left;right;middle", "FIELD:Lcom/boehmod/blockfront/G;->x:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/G;->a:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/G;->b:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/G;->c:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/G;->d:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/G;->e:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0010G.class), C0010G.class, "name;top;bottom;left;right;middle", "FIELD:Lcom/boehmod/blockfront/G;->x:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/G;->a:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/G;->b:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/G;->c:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/G;->d:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/G;->e:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0010G.class, Object.class), C0010G.class, "name;top;bottom;left;right;middle", "FIELD:Lcom/boehmod/blockfront/G;->x:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/G;->a:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/G;->b:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/G;->c:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/G;->d:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/G;->e:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: k */
    public String m32k() {
        return this.f146x;
    }

    /* JADX INFO: renamed from: a */
    public ResourceLocation m33a() {
        return this.f147a;
    }

    /* JADX INFO: renamed from: b */
    public ResourceLocation m34b() {
        return this.f148b;
    }

    /* JADX INFO: renamed from: c */
    public ResourceLocation m35c() {
        return this.f149c;
    }

    /* JADX INFO: renamed from: d */
    public ResourceLocation m36d() {
        return this.f150d;
    }

    /* JADX INFO: renamed from: e */
    public ResourceLocation m37e() {
        return this.f151e;
    }

    public C0010G(@NotNull String str, @NotNull ResourceLocation resourceLocation, @NotNull ResourceLocation resourceLocation2, @NotNull ResourceLocation resourceLocation3, @NotNull ResourceLocation resourceLocation4, @NotNull ResourceLocation resourceLocation5) {
        this.f146x = str;
        this.f147a = resourceLocation;
        this.f148b = resourceLocation2;
        this.f149c = resourceLocation3;
        this.f150d = resourceLocation4;
        this.f151e = resourceLocation5;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.G$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/G$a.class */
    public static class a extends AbstractC0615ks<C0010G> {
        public a(@NotNull Minecraft minecraft) {
            super(minecraft.getResourceManager(), "crosshairs", "crosshairs.json", C0010G.f152a, C0010G.f158a, (v0) -> {
                return v0.m32k();
            });
        }
    }
}
