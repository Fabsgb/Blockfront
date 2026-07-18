package com.boehmod.blockfront;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.mojang.blaze3d.vertex.PoseStack;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.SwitchBootstraps;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ez */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ez.class */
public class C0303ez extends HumanoidModel<C0680mE> {

    /* JADX INFO: renamed from: e */
    @NotNull
    public final ModelPart f2298e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final ModelPart f2299f;

    /* JADX INFO: renamed from: g */
    @NotNull
    public final ModelPart f2300g;

    /* JADX INFO: renamed from: h */
    @NotNull
    public final ModelPart f2301h;

    /* JADX INFO: renamed from: i */
    @NotNull
    public final ModelPart f2302i;

    /* JADX INFO: renamed from: cg */
    private final boolean f2303cg;

    public C0303ez(@NotNull ModelPart modelPart, boolean z) {
        super(modelPart, RenderType::entityTranslucent);
        this.f2303cg = z;
        this.f2298e = modelPart.getChild("left_sleeve");
        this.f2299f = modelPart.getChild("right_sleeve");
        this.f2300g = modelPart.getChild("left_pants");
        this.f2301h = modelPart.getChild("right_pants");
        this.f2302i = modelPart.getChild("jacket");
    }

    /* JADX INFO: renamed from: a */
    public static MeshDefinition m1597a(CubeDeformation cubeDeformation, boolean z, float f) {
        MeshDefinition meshDefinitionCreateMesh = HumanoidModel.createMesh(cubeDeformation, 0.0f);
        PartDefinition root = meshDefinitionCreateMesh.getRoot();
        if (z) {
            root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 48).addBox(-1.0f, -2.0f, -2.0f, 3.0f, 12.0f, 4.0f, cubeDeformation), PartPose.offset(5.0f, 2.5f + f, 0.0f));
            root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-2.0f, -2.0f, -2.0f, 3.0f, 12.0f, 4.0f, cubeDeformation), PartPose.offset(-5.0f, 2.5f + f, 0.0f));
            root.addOrReplaceChild("left_sleeve", CubeListBuilder.create().texOffs(48, 48).addBox(-1.0f, -2.0f, -2.0f, 3.0f, 12.0f, 4.0f, cubeDeformation.extend(0.25f)), PartPose.offset(5.0f, 2.5f + f, 0.0f));
            root.addOrReplaceChild("right_sleeve", CubeListBuilder.create().texOffs(40, 32).addBox(-2.0f, -2.0f, -2.0f, 3.0f, 12.0f, 4.0f, cubeDeformation.extend(0.25f)), PartPose.offset(-5.0f, 2.5f + f, 0.0f));
        } else {
            root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 48).addBox(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, cubeDeformation), PartPose.offset(5.0f, 2.0f + f, 0.0f));
            root.addOrReplaceChild("left_sleeve", CubeListBuilder.create().texOffs(48, 48).addBox(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, cubeDeformation.extend(0.25f)), PartPose.offset(5.0f, 2.0f + f, 0.0f));
            root.addOrReplaceChild("right_sleeve", CubeListBuilder.create().texOffs(40, 32).addBox(-3.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, cubeDeformation.extend(0.25f)), PartPose.offset(-5.0f, 2.0f + f, 0.0f));
        }
        root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(16, 48).addBox(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, cubeDeformation), PartPose.offset(1.9f, 12.0f + f, 0.0f));
        root.addOrReplaceChild("left_pants", CubeListBuilder.create().texOffs(0, 48).addBox(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, cubeDeformation.extend(0.25f)), PartPose.offset(1.9f, 12.0f + f, 0.0f));
        root.addOrReplaceChild("right_pants", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, cubeDeformation.extend(0.25f)), PartPose.offset(-1.9f, 12.0f + f, 0.0f));
        root.addOrReplaceChild("jacket", CubeListBuilder.create().texOffs(16, 32).addBox(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, cubeDeformation.extend(0.25f)), PartPose.offset(0.0f, f, 0.0f));
        return meshDefinitionCreateMesh;
    }

    @NotNull
    protected Iterable<ModelPart> bodyParts() {
        return Iterables.concat(super.bodyParts(), ImmutableList.of(this.f2300g, this.f2301h, this.f2298e, this.f2299f, this.f2302i));
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setupAnim(@NotNull C0680mE c0680mE, float f, float f2, float f3, float f4, float f5) {
        super.setupAnim(c0680mE, f, f2, f3, f4, f5);
        float fM366g = C0119bk.m366g() + c0680mE.getId();
        ItemStack mainHandItem = c0680mE.getMainHandItem();
        float fM7861a = C1290xm.m7861a(Minecraft.getInstance());
        if (!mainHandItem.isEmpty()) {
            Item item = mainHandItem.getItem();
            Objects.requireNonNull(item);
            switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), C1144ur.class, C1136uj.class, C1129uc.class).dynamicInvoker().invoke(item, 0) /* invoke-custom */) {
                case 0:
                    C1144ur c1144ur = (C1144ur) item;
                    boolean zM3066aH = c0680mE.m3066aH();
                    boolean zM3063aG = c0680mE.m3063aG();
                    float f6 = 0.05f * (c0680mE.m3057aw() > 0 ? 1 : 0);
                    float fSin = !c0680mE.isSprinting() ? 0.0f : Mth.sin(fM366g / 4.0f) / 14.0f;
                    this.rightArm.xRot = (!zM3063aG ? (-0.5f) + fSin : (-1.6f) + this.head.xRot) - f6;
                    this.rightArm.yRot = !zM3063aG ? (-1.2f) + fSin : this.head.yRot;
                    this.rightArm.zRot = !zM3063aG ? (-0.4f) + fSin : this.head.zRot;
                    if (c1144ur.m6389cv()) {
                        this.leftArm.xRot = !zM3063aG ? (-0.2f) + fSin : (-1.6f) + this.head.xRot;
                        this.leftArm.yRot = !zM3063aG ? (-0.5f) + fSin : 0.9f + this.head.yRot;
                        this.leftArm.zRot = !zM3063aG ? (-0.4f) + fSin : this.head.zRot;
                    } else if (!zM3066aH) {
                        this.leftArm.xRot = !zM3063aG ? (-0.4f) + fSin : (-1.6f) + this.head.xRot;
                        this.leftArm.yRot = !zM3063aG ? (-0.5f) + fSin : 0.9f + this.head.yRot;
                        this.leftArm.zRot = !zM3063aG ? 0.6f + fSin : this.head.zRot;
                    }
                    if (zM3066aH) {
                        float fSin2 = Mth.sin(fM366g / 25.0f) * Mth.sin(fM366g / 5.0f) * Mth.sin(fM366g / 15.0f);
                        this.rightArm.xRot = (0.2f * fSin2) - 0.5f;
                        this.rightArm.yRot = -0.4f;
                        this.rightArm.zRot = 0.0f;
                        this.leftArm.xRot = -0.6f;
                        this.leftArm.yRot = 0.6f + (0.2f * fSin2);
                        this.leftArm.zRot = 0.6f;
                    }
                    break;
                case 1:
                    this.leftArm.xRot = (-1.6f) + this.head.xRot;
                    this.leftArm.yRot = this.head.yRot;
                    this.rightArm.xRot = (-2.6f) + this.head.xRot;
                    this.rightArm.yRot = this.head.yRot;
                    this.rightArm.zRot = -0.2f;
                    break;
                case 2:
                    this.leftArm.xRot = (-1.6f) + this.head.xRot;
                    this.leftArm.yRot = this.head.yRot;
                    this.rightArm.xRot = (-1.2f) + this.head.xRot;
                    this.rightArm.yRot = this.head.yRot;
                    this.rightArm.zRot = 0.8f;
                    break;
            }
        }
        if (c0680mE.m3068aI()) {
            ModelPart modelPart = this.head;
            this.hat.xRot = 1.0f;
            modelPart.xRot = 1.0f;
            this.leftArm.xRot = -0.7f;
            this.leftArm.yRot = 0.75f;
            this.leftArm.zRot = 0.7f;
        }
        float fM7843e = 0.75f * C1290xm.m7843e(c0680mE.f3656iE, c0680mE.f3657iF, fM7861a);
        this.head.yRot = fM7843e;
        this.hat.yRot = fM7843e;
        this.f2300g.copyFrom(this.leftLeg);
        this.f2301h.copyFrom(this.rightLeg);
        this.f2298e.copyFrom(this.leftArm);
        this.f2299f.copyFrom(this.rightArm);
        this.f2302i.copyFrom(this.body);
    }

    public void setAllVisible(boolean z) {
        super.setAllVisible(z);
        this.f2298e.visible = z;
        this.f2299f.visible = z;
        this.f2300g.visible = z;
        this.f2301h.visible = z;
        this.f2302i.visible = z;
    }

    public void translateToHand(@NotNull HumanoidArm humanoidArm, @NotNull PoseStack poseStack) {
        ModelPart arm = getArm(humanoidArm);
        if (this.f2303cg) {
            float f = 0.5f * (humanoidArm == HumanoidArm.RIGHT ? 1 : -1);
            arm.x += f;
            arm.translateAndRotate(poseStack);
            arm.x -= f;
            return;
        }
        arm.translateAndRotate(poseStack);
    }
}
