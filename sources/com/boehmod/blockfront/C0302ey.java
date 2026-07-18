package com.boehmod.blockfront;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.Iterator;
import java.util.function.Function;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.ey */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ey.class */
public class C0302ey<T extends LivingEntity> extends AgeableListModel<T> implements ArmedModel {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final ModelPart f2289a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final ModelPart f2290b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final ModelPart f2291c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final ModelPart f2292d;

    /* JADX INFO: renamed from: cf */
    public boolean f2293cf;

    /* JADX INFO: renamed from: em */
    public float f2294em;

    /* JADX INFO: renamed from: en */
    private static final float f2295en = 1.5f;

    /* JADX INFO: renamed from: eo */
    private static final float f2296eo = 1.35f;

    /* JADX INFO: renamed from: ep */
    private static final float f2297ep = 0.7f;

    public C0302ey(@NotNull ModelPart modelPart) {
        this(modelPart, RenderType::entityCutoutNoCull);
    }

    public C0302ey(@NotNull ModelPart modelPart, @NotNull Function<ResourceLocation, RenderType> function) {
        super(function, false, 16.0f, 0.0f, 2.0f, 2.0f, 2.0f);
        this.f2289a = modelPart.getChild("backpack_top");
        this.f2290b = modelPart.getChild("backpack_top_straps");
        this.f2291c = modelPart.getChild(C0324fT.f2357Y);
        this.f2292d = modelPart.getChild("backpack_straps");
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static MeshDefinition m1592a(@NotNull CubeDeformation cubeDeformation) {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition root = meshDefinition.getRoot();
        root.addOrReplaceChild("backpack_top", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5f, -25.75f, 1.75f, 9.0f, 5.0f, 5.0f, cubeDeformation), PartPose.offset(0.0f, 0.0f, 0.0f));
        root.addOrReplaceChild("backpack_top_straps", CubeListBuilder.create().texOffs(0, 10).addBox(-4.0f, -20.75f, 2.0f, 8.0f, 8.0f, 4.0f, cubeDeformation), PartPose.offset(0.0f, 0.0f, 0.0f));
        root.addOrReplaceChild(C0324fT.f2357Y, CubeListBuilder.create().texOffs(24, 10).addBox(-4.0f, -20.75f, 2.0f, 8.0f, 8.0f, 4.0f, cubeDeformation.extend(0.25f)), PartPose.offset(0.0f, 0.0f, 0.0f));
        root.addOrReplaceChild("backpack_straps", CubeListBuilder.create().texOffs(28, 0).addBox(-4.5f, -25.75f, 1.75f, 9.0f, 5.0f, 5.0f, cubeDeformation.extend(0.25f)), PartPose.offset(0.0f, 0.0f, 0.0f));
        return meshDefinition;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static PartPose m1593a(@NotNull PartPose partPose, boolean z) {
        Vector3f vector3fTransform = new Quaternionf().rotationZYX(partPose.zRot, partPose.yRot, partPose.xRot).transform(new Vector3f(0.0f, (z ? f2296eo : 1.5f) * 16.0f, (z ? 0.7f : 0.0f) * 16.0f));
        return PartPose.offsetAndRotation(partPose.x + vector3fTransform.x, partPose.y + vector3fTransform.y, partPose.z + vector3fTransform.z, partPose.xRot, partPose.yRot, partPose.zRot);
    }

    public void renderToBuffer(PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int i, int i2, int i3) {
        poseStack.pushPose();
        if (this.f2293cf) {
            poseStack.translate(0.0f, f2296eo, 0.7f);
        } else {
            poseStack.translate(0.0f, 1.5f, 0.0f);
        }
        Iterator<ModelPart> it = bodyParts().iterator();
        while (it.hasNext()) {
            it.next().render(poseStack, vertexConsumer, i, i2, i3);
        }
        poseStack.popPose();
    }

    @NotNull
    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of();
    }

    @NotNull
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(this.f2289a, this.f2290b, this.f2291c, this.f2292d);
    }

    public void translateToHand(@NotNull HumanoidArm humanoidArm, @NotNull PoseStack poseStack) {
    }

    public void setupAnim(@NotNull T t, float f, float f2, float f3, float f4, float f5) {
        this.f2291c.yRot = 0.0f;
        m1595a((LivingEntity) t);
        if (this.f2293cf) {
            this.f2291c.xRot = 0.5f;
            this.f2291c.y = 3.2f;
        } else {
            this.f2291c.xRot = 0.0f;
            this.f2291c.y = 0.0f;
        }
        this.f2289a.copyFrom(this.f2291c);
        this.f2290b.copyFrom(this.f2291c);
        this.f2292d.copyFrom(this.f2291c);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void prepareMobModel(@NotNull T t, float f, float f2, float f3) {
        this.f2294em = t.getSwimAmount(f3);
        super.prepareMobModel(t, f, f2, f3);
    }

    /* JADX INFO: renamed from: a */
    protected void m1595a(@NotNull T t) {
        if (this.attackTime > 0.0f) {
            this.f2291c.yRot = Mth.sin(Mth.sqrt(this.attackTime) * 6.2831855f) * 0.2f;
            if (m1596a((LivingEntity) t) == HumanoidArm.LEFT) {
                this.f2291c.yRot *= -1.0f;
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private HumanoidArm m1596a(@NotNull T t) {
        return ((LivingEntity) t).swingingArm == InteractionHand.MAIN_HAND ? t.getMainArm() : t.getMainArm().getOpposite();
    }
}
