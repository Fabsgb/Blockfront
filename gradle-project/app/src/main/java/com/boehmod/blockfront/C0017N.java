package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;
import org.joml.Vector3fc;

/* JADX INFO: renamed from: com.boehmod.blockfront.N */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/N.class */
public final class C0017N extends Record {

    /* JADX INFO: renamed from: l */
    @NotNull
    private final ResourceLocation f228l;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final EnumC0012I f229a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Vector3fc f230a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ModelPart.Cube[] f231a;

    public C0017N(@NotNull ResourceLocation resourceLocation, @NotNull EnumC0012I enumC0012I, @NotNull Vector3fc vector3fc, @NotNull ModelPart.Cube[] cubeArr) {
        this.f228l = resourceLocation;
        this.f229a = enumC0012I;
        this.f230a = vector3fc;
        this.f231a = cubeArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0017N.class), C0017N.class, "texture;layerType;scale;cubes", "FIELD:Lcom/boehmod/blockfront/N;->l:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/N;->a:Lcom/boehmod/blockfront/I;", "FIELD:Lcom/boehmod/blockfront/N;->a:Lorg/joml/Vector3fc;", "FIELD:Lcom/boehmod/blockfront/N;->a:[Lnet/minecraft/client/model/geom/ModelPart$Cube;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0017N.class), C0017N.class, "texture;layerType;scale;cubes", "FIELD:Lcom/boehmod/blockfront/N;->l:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/N;->a:Lcom/boehmod/blockfront/I;", "FIELD:Lcom/boehmod/blockfront/N;->a:Lorg/joml/Vector3fc;", "FIELD:Lcom/boehmod/blockfront/N;->a:[Lnet/minecraft/client/model/geom/ModelPart$Cube;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0017N.class, Object.class), C0017N.class, "texture;layerType;scale;cubes", "FIELD:Lcom/boehmod/blockfront/N;->l:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/N;->a:Lcom/boehmod/blockfront/I;", "FIELD:Lcom/boehmod/blockfront/N;->a:Lorg/joml/Vector3fc;", "FIELD:Lcom/boehmod/blockfront/N;->a:[Lnet/minecraft/client/model/geom/ModelPart$Cube;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    public ResourceLocation m92f() {
        return this.f228l;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0012I m93a() {
        return this.f229a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Vector3fc m94a() {
        return this.f230a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public ModelPart.Cube[] m95a() {
        return this.f231a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0017N m91a(@NotNull ResourceLocation resourceLocation, @NotNull ModelPart modelPart, @NotNull EnumC0012I enumC0012I) {
        return new C0017N(resourceLocation, enumC0012I, new Vector3f(modelPart.xScale, modelPart.yScale, modelPart.zScale), (ModelPart.Cube[]) modelPart.cubes.toArray(new ModelPart.Cube[0]));
    }
}
