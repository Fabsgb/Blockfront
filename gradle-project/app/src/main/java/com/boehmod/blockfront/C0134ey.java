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

/* JADX INFO: renamed from: com.boehmod.blockfront.ey, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ey.class */
public class C0134ey<T extends LivingEntity> extends AgeableListModel<T> implements ArmedModel {

    @NotNull
    public final ModelPart a;

    @NotNull
    public final ModelPart b;

    @NotNull
    public final ModelPart c;

    @NotNull
    public final ModelPart d;
    public boolean cf;
    public float em;
    private static final float en = 1.5f;
    private static final float eo = 1.35f;
    private static final float ep = 0.7f;

    public C0134ey(@NotNull ModelPart modelPart) {
        this(modelPart, RenderType::entityCutoutNoCull);
    }

    public C0134ey(@NotNull ModelPart modelPart, @NotNull Function<ResourceLocation, RenderType> function) {
        super(function, false, 16.0f, 0.0f, 2.0f, 2.0f, 2.0f);
        this.a = modelPart.getChild("backpack_top");
        this.b = modelPart.getChild("backpack_top_straps");
        this.c = modelPart.getChild(fT.Y);
        this.d = modelPart.getChild("backpack_straps");
    }

    @NotNull
    public static MeshDefinition a(@NotNull CubeDeformation cubeDeformation) {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition root = meshDefinition.getRoot();
        root.addOrReplaceChild("backpack_top", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5f, -25.75f, 1.75f, 9.0f, 5.0f, 5.0f, cubeDeformation), PartPose.offset(0.0f, 0.0f, 0.0f));
        root.addOrReplaceChild("backpack_top_straps", CubeListBuilder.create().texOffs(0, 10).addBox(-4.0f, -20.75f, 2.0f, 8.0f, 8.0f, 4.0f, cubeDeformation), PartPose.offset(0.0f, 0.0f, 0.0f));
        root.addOrReplaceChild(fT.Y, CubeListBuilder.create().texOffs(24, 10).addBox(-4.0f, -20.75f, 2.0f, 8.0f, 8.0f, 4.0f, cubeDeformation.extend(0.25f)), PartPose.offset(0.0f, 0.0f, 0.0f));
        root.addOrReplaceChild("backpack_straps", CubeListBuilder.create().texOffs(28, 0).addBox(-4.5f, -25.75f, 1.75f, 9.0f, 5.0f, 5.0f, cubeDeformation.extend(0.25f)), PartPose.offset(0.0f, 0.0f, 0.0f));
        return meshDefinition;
    }

    @NotNull
    public static PartPose a(@NotNull PartPose partPose, boolean z) {
        Vector3f vector3fTransform = new Quaternionf().rotationZYX(partPose.zRot, partPose.yRot, partPose.xRot).transform(new Vector3f(0.0f, (z ? eo : 1.5f) * 16.0f, (z ? 0.7f : 0.0f) * 16.0f));
        return PartPose.offsetAndRotation(partPose.x + vector3fTransform.x, partPose.y + vector3fTransform.y, partPose.z + vector3fTransform.z, partPose.xRot, partPose.yRot, partPose.zRot);
    }

    public void renderToBuffer(PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int i, int i2, int i3) {
        poseStack.pushPose();
        if (this.cf) {
            poseStack.translate(0.0f, eo, 0.7f);
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
        return ImmutableList.of(this.a, this.b, this.c, this.d);
    }

    public void translateToHand(@NotNull HumanoidArm humanoidArm, @NotNull PoseStack poseStack) {
    }

    public void setupAnim(@NotNull T t, float f, float f2, float f3, float f4, float f5) {
        this.c.yRot = 0.0f;
        a((LivingEntity) t);
        if (this.cf) {
            this.c.xRot = 0.5f;
            this.c.y = 3.2f;
        } else {
            this.c.xRot = 0.0f;
            this.c.y = 0.0f;
        }
        this.a.copyFrom(this.c);
        this.b.copyFrom(this.c);
        this.d.copyFrom(this.c);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void prepareMobModel(@NotNull T t, float f, float f2, float f3) {
        this.em = t.getSwimAmount(f3);
        super.prepareMobModel(t, f, f2, f3);
    }

    protected void a(@NotNull T t) {
        if (this.attackTime > 0.0f) {
            this.c.yRot = Mth.sin(Mth.sqrt(this.attackTime) * 6.2831855f) * 0.2f;
            if (m394a((LivingEntity) t) == HumanoidArm.LEFT) {
                this.c.yRot *= -1.0f;
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private HumanoidArm m394a(@NotNull T t) {
        return ((LivingEntity) t).swingingArm == InteractionHand.MAIN_HAND ? t.getMainArm() : t.getMainArm().getOpposite();
    }
}
