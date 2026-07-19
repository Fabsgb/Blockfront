package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/H.class */
public final class H extends Record {

    @NotNull
    private final ResourceLocation l;

    @NotNull
    private final C a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final Vector3fc f22a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final ModelPart.Cube[] f23a;

    public H(@NotNull ResourceLocation resourceLocation, @NotNull C c, @NotNull Vector3fc vector3fc, @NotNull ModelPart.Cube[] cubeArr) {
        this.l = resourceLocation;
        this.a = c;
        this.f22a = vector3fc;
        this.f23a = cubeArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, H.class), H.class, "texture;layerType;scale;cubes", "FIELD:Lcom/boehmod/blockfront/H;->l:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/H;->a:Lcom/boehmod/blockfront/C;", "FIELD:Lcom/boehmod/blockfront/H;->a:Lorg/joml/Vector3fc;", "FIELD:Lcom/boehmod/blockfront/H;->a:[Lnet/minecraft/client/model/geom/ModelPart$Cube;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, H.class), H.class, "texture;layerType;scale;cubes", "FIELD:Lcom/boehmod/blockfront/H;->l:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/H;->a:Lcom/boehmod/blockfront/C;", "FIELD:Lcom/boehmod/blockfront/H;->a:Lorg/joml/Vector3fc;", "FIELD:Lcom/boehmod/blockfront/H;->a:[Lnet/minecraft/client/model/geom/ModelPart$Cube;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, H.class, Object.class), H.class, "texture;layerType;scale;cubes", "FIELD:Lcom/boehmod/blockfront/H;->l:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/H;->a:Lcom/boehmod/blockfront/C;", "FIELD:Lcom/boehmod/blockfront/H;->a:Lorg/joml/Vector3fc;", "FIELD:Lcom/boehmod/blockfront/H;->a:[Lnet/minecraft/client/model/geom/ModelPart$Cube;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public ResourceLocation f() {
        return this.l;
    }

    @NotNull
    public C a() {
        return this.a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Vector3fc m151a() {
        return this.f22a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ModelPart.Cube[] m152a() {
        return this.f23a;
    }

    @NotNull
    public static H a(@NotNull ResourceLocation resourceLocation, @NotNull ModelPart modelPart, @NotNull C c) {
        return new H(resourceLocation, c, new Vector3f(modelPart.xScale, modelPart.yScale, modelPart.zScale), (ModelPart.Cube[]) modelPart.cubes.toArray(new ModelPart.Cube[0]));
    }
}
