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

/* JADX INFO: renamed from: com.boehmod.blockfront.eM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eM.class */
public class C0265eM extends HumanoidModel<C0756na> {

    /* JADX INFO: renamed from: e */
    @NotNull
    public final ModelPart f2168e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final ModelPart f2169f;

    /* JADX INFO: renamed from: g */
    @NotNull
    public final ModelPart f2170g;

    /* JADX INFO: renamed from: h */
    @NotNull
    public final ModelPart f2171h;

    /* JADX INFO: renamed from: i */
    @NotNull
    public final ModelPart f2172i;

    /* JADX INFO: renamed from: co */
    private final boolean f2173co;

    public C0265eM(@NotNull ModelPart modelPart, boolean z) {
        super(modelPart, RenderType::entityTranslucent);
        this.f2173co = z;
        this.f2168e = modelPart.getChild("left_sleeve");
        this.f2169f = modelPart.getChild("right_sleeve");
        this.f2170g = modelPart.getChild("left_pants");
        this.f2171h = modelPart.getChild("right_pants");
        this.f2172i = modelPart.getChild("jacket");
    }

    /* JADX INFO: renamed from: a */
    public static MeshDefinition m1501a(CubeDeformation cubeDeformation, boolean z, float f) {
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
        return Iterables.concat(super.bodyParts(), ImmutableList.of(this.f2170g, this.f2171h, this.f2168e, this.f2169f, this.f2172i));
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setupAnim(@NotNull C0756na c0756na, float f, float f2, float f3, float f4, float f5) {
        super.setupAnim(c0756na, f, f2, f3, f4, f5);
        float fM466g = C0129bt.m466g() + c0756na.getId();
        ItemStack mainHandItem = c0756na.getMainHandItem();
        float fM7188a = C1270xJ.m7188a(Minecraft.getInstance());
        if (!mainHandItem.isEmpty()) {
            Item item = mainHandItem.getItem();
            Objects.requireNonNull(item);
            switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), C1117uP.class, C1109uH.class, C1102uA.class).dynamicInvoker().invoke(item, 0) /* invoke-custom */) {
                case 0:
                    C1117uP c1117uP = (C1117uP) item;
                    boolean zM3573aa = c0756na.m3573aa();
                    boolean zM3570aR = c0756na.m3570aR();
                    boolean zIsSprinting = c0756na.isSprinting();
                    float f6 = 0.05f * (c0756na.m3564aL() > 0 ? 1 : 0);
                    float fSin = !zIsSprinting ? 0.0f : Mth.sin(fM466g / 4.0f) / 14.0f;
                    this.rightArm.xRot = (!zM3570aR ? (-0.5f) + fSin : (-1.6f) + this.head.xRot) - f6;
                    this.rightArm.yRot = !zM3570aR ? (-1.2f) + fSin : this.head.yRot;
                    this.rightArm.zRot = !zM3570aR ? (-0.4f) + fSin : this.head.zRot;
                    if (c1117uP.m6364cE()) {
                        this.leftArm.xRot = !zM3570aR ? (-0.2f) + fSin : (-1.6f) + this.head.xRot;
                        this.leftArm.yRot = !zM3570aR ? (-0.5f) + fSin : 0.9f + this.head.yRot;
                        this.leftArm.zRot = !zM3570aR ? (-0.4f) + fSin : this.head.zRot;
                    } else if (!zM3573aa) {
                        this.leftArm.xRot = !zM3570aR ? (-0.4f) + fSin : (-1.6f) + this.head.xRot;
                        this.leftArm.yRot = !zM3570aR ? (-0.5f) + fSin : 0.9f + this.head.yRot;
                        this.leftArm.zRot = !zM3570aR ? 0.6f + fSin : this.head.zRot;
                    }
                    if (zM3573aa) {
                        float fSin2 = Mth.sin(fM466g / 25.0f) * Mth.sin(fM466g / 5.0f) * Mth.sin(fM466g / 15.0f);
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
        if (c0756na.m3575aS()) {
            ModelPart modelPart = this.head;
            this.hat.xRot = 1.0f;
            modelPart.xRot = 1.0f;
            this.leftArm.xRot = -0.7f;
            this.leftArm.yRot = 0.75f;
            this.leftArm.zRot = 0.7f;
        }
        float fM7170f = 0.75f * C1270xJ.m7170f(c0756na.f4219jx, c0756na.f4220jy, fM7188a);
        this.head.yRot = fM7170f;
        this.hat.yRot = fM7170f;
        this.f2170g.copyFrom(this.leftLeg);
        this.f2171h.copyFrom(this.rightLeg);
        this.f2168e.copyFrom(this.leftArm);
        this.f2169f.copyFrom(this.rightArm);
        this.f2172i.copyFrom(this.body);
    }

    public void setAllVisible(boolean z) {
        super.setAllVisible(z);
        this.f2168e.visible = z;
        this.f2169f.visible = z;
        this.f2170g.visible = z;
        this.f2171h.visible = z;
        this.f2172i.visible = z;
    }

    public void translateToHand(@NotNull HumanoidArm humanoidArm, @NotNull PoseStack poseStack) {
        ModelPart arm = getArm(humanoidArm);
        if (this.f2173co) {
            float f = 0.5f * (humanoidArm == HumanoidArm.RIGHT ? 1 : -1);
            arm.x += f;
            arm.translateAndRotate(poseStack);
            arm.x -= f;
            return;
        }
        arm.translateAndRotate(poseStack);
    }
}
