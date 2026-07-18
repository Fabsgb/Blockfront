package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;
import org.joml.Vector3fc;

/* JADX INFO: renamed from: com.boehmod.blockfront.H */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/H.class */
public final class C0010H extends Record {

    /* JADX INFO: renamed from: l */
    @NotNull
    private final ResourceLocation f185l;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final EnumC0005C f186a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Vector3fc f187a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ModelPart.Cube[] f188a;

    public C0010H(@NotNull ResourceLocation resourceLocation, @NotNull EnumC0005C enumC0005C, @NotNull Vector3fc vector3fc, @NotNull ModelPart.Cube[] cubeArr) {
        this.f185l = resourceLocation;
        this.f186a = enumC0005C;
        this.f187a = vector3fc;
        this.f188a = cubeArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0010H.class), C0010H.class, "texture;layerType;scale;cubes", "FIELD:Lcom/boehmod/blockfront/H;->l:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/H;->a:Lcom/boehmod/blockfront/C;", "FIELD:Lcom/boehmod/blockfront/H;->a:Lorg/joml/Vector3fc;", "FIELD:Lcom/boehmod/blockfront/H;->a:[Lnet/minecraft/client/model/geom/ModelPart$Cube;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0010H.class), C0010H.class, "texture;layerType;scale;cubes", "FIELD:Lcom/boehmod/blockfront/H;->l:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/H;->a:Lcom/boehmod/blockfront/C;", "FIELD:Lcom/boehmod/blockfront/H;->a:Lorg/joml/Vector3fc;", "FIELD:Lcom/boehmod/blockfront/H;->a:[Lnet/minecraft/client/model/geom/ModelPart$Cube;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0010H.class, Object.class), C0010H.class, "texture;layerType;scale;cubes", "FIELD:Lcom/boehmod/blockfront/H;->l:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/H;->a:Lcom/boehmod/blockfront/C;", "FIELD:Lcom/boehmod/blockfront/H;->a:Lorg/joml/Vector3fc;", "FIELD:Lcom/boehmod/blockfront/H;->a:[Lnet/minecraft/client/model/geom/ModelPart$Cube;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    public ResourceLocation m59f() {
        return this.f185l;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0005C m60a() {
        return this.f186a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Vector3fc m61a() {
        return this.f187a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public ModelPart.Cube[] m62a() {
        return this.f188a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0010H m58a(@NotNull ResourceLocation resourceLocation, @NotNull ModelPart modelPart, @NotNull EnumC0005C enumC0005C) {
        return new C0010H(resourceLocation, enumC0005C, new Vector3f(modelPart.xScale, modelPart.yScale, modelPart.zScale), (ModelPart.Cube[]) modelPart.cubes.toArray(new ModelPart.Cube[0]));
    }
}
