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

/* JADX INFO: renamed from: com.boehmod.blockfront.ez, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ez.class */
public class C0135ez extends HumanoidModel<mE> {

    @NotNull
    public final ModelPart e;

    @NotNull
    public final ModelPart f;

    @NotNull
    public final ModelPart g;

    @NotNull
    public final ModelPart h;

    @NotNull
    public final ModelPart i;
    private final boolean cg;

    public C0135ez(@NotNull ModelPart modelPart, boolean z) {
        super(modelPart, RenderType::entityTranslucent);
        this.cg = z;
        this.e = modelPart.getChild("left_sleeve");
        this.f = modelPart.getChild("right_sleeve");
        this.g = modelPart.getChild("left_pants");
        this.h = modelPart.getChild("right_pants");
        this.i = modelPart.getChild("jacket");
    }

    public static MeshDefinition a(CubeDeformation cubeDeformation, boolean z, float f) {
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
        return Iterables.concat(super.bodyParts(), ImmutableList.of(this.g, this.h, this.e, this.f, this.i));
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setupAnim(@NotNull mE mEVar, float f, float f2, float f3, float f4, float f5) {
        super.setupAnim(mEVar, f, f2, f3, f4, f5);
        float fG = C0040bk.g() + mEVar.getId();
        ItemStack mainHandItem = mEVar.getMainHandItem();
        float fA = C0634xm.a(Minecraft.getInstance());
        if (!mainHandItem.isEmpty()) {
            Item item = mainHandItem.getItem();
            Objects.requireNonNull(item);
            switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), C0558ur.class, C0550uj.class, C0543uc.class).dynamicInvoker().invoke(item, 0) /* invoke-custom */) {
                case 0:
                    C0558ur c0558ur = (C0558ur) item;
                    boolean zAH = mEVar.aH();
                    boolean zAG = mEVar.aG();
                    float f6 = 0.05f * (mEVar.aw() > 0 ? 1 : 0);
                    float fSin = !mEVar.isSprinting() ? 0.0f : Mth.sin(fG / 4.0f) / 14.0f;
                    this.rightArm.xRot = (!zAG ? (-0.5f) + fSin : (-1.6f) + this.head.xRot) - f6;
                    this.rightArm.yRot = !zAG ? (-1.2f) + fSin : this.head.yRot;
                    this.rightArm.zRot = !zAG ? (-0.4f) + fSin : this.head.zRot;
                    if (c0558ur.cv()) {
                        this.leftArm.xRot = !zAG ? (-0.2f) + fSin : (-1.6f) + this.head.xRot;
                        this.leftArm.yRot = !zAG ? (-0.5f) + fSin : 0.9f + this.head.yRot;
                        this.leftArm.zRot = !zAG ? (-0.4f) + fSin : this.head.zRot;
                    } else if (!zAH) {
                        this.leftArm.xRot = !zAG ? (-0.4f) + fSin : (-1.6f) + this.head.xRot;
                        this.leftArm.yRot = !zAG ? (-0.5f) + fSin : 0.9f + this.head.yRot;
                        this.leftArm.zRot = !zAG ? 0.6f + fSin : this.head.zRot;
                    }
                    if (zAH) {
                        float fSin2 = Mth.sin(fG / 25.0f) * Mth.sin(fG / 5.0f) * Mth.sin(fG / 15.0f);
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
        if (mEVar.aI()) {
            ModelPart modelPart = this.head;
            this.hat.xRot = 1.0f;
            modelPart.xRot = 1.0f;
            this.leftArm.xRot = -0.7f;
            this.leftArm.yRot = 0.75f;
            this.leftArm.zRot = 0.7f;
        }
        float fE = 0.75f * C0634xm.e(mEVar.iE, mEVar.iF, fA);
        this.head.yRot = fE;
        this.hat.yRot = fE;
        this.g.copyFrom(this.leftLeg);
        this.h.copyFrom(this.rightLeg);
        this.e.copyFrom(this.leftArm);
        this.f.copyFrom(this.rightArm);
        this.i.copyFrom(this.body);
    }

    public void setAllVisible(boolean z) {
        super.setAllVisible(z);
        this.e.visible = z;
        this.f.visible = z;
        this.g.visible = z;
        this.h.visible = z;
        this.i.visible = z;
    }

    public void translateToHand(@NotNull HumanoidArm humanoidArm, @NotNull PoseStack poseStack) {
        ModelPart arm = getArm(humanoidArm);
        if (this.cg) {
            float f = 0.5f * (humanoidArm == HumanoidArm.RIGHT ? 1 : -1);
            arm.x += f;
            arm.translateAndRotate(poseStack);
            arm.x -= f;
            return;
        }
        arm.translateAndRotate(poseStack);
    }
}
