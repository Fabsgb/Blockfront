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

/* JADX INFO: renamed from: com.boehmod.blockfront.eL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eL.class */
public class C0264eL<T extends LivingEntity> extends AgeableListModel<T> implements ArmedModel {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final ModelPart f2159a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final ModelPart f2160b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final ModelPart f2161c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final ModelPart f2162d;

    /* JADX INFO: renamed from: cn */
    public boolean f2163cn;

    /* JADX INFO: renamed from: ep */
    public float f2164ep;

    /* JADX INFO: renamed from: eq */
    private static final float f2165eq = 1.5f;

    /* JADX INFO: renamed from: er */
    private static final float f2166er = 1.35f;

    /* JADX INFO: renamed from: es */
    private static final float f2167es = 0.7f;

    public C0264eL(@NotNull ModelPart modelPart) {
        this(modelPart, RenderType::entityCutoutNoCull);
    }

    public C0264eL(@NotNull ModelPart modelPart, @NotNull Function<ResourceLocation, RenderType> function) {
        super(function, false, 16.0f, 0.0f, 2.0f, 2.0f, 2.0f);
        this.f2159a = modelPart.getChild("backpack_top");
        this.f2160b = modelPart.getChild("backpack_top_straps");
        this.f2161c = modelPart.getChild(C0394gj.f2552af);
        this.f2162d = modelPart.getChild("backpack_straps");
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static MeshDefinition m1496a(@NotNull CubeDeformation cubeDeformation) {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition root = meshDefinition.getRoot();
        root.addOrReplaceChild("backpack_top", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5f, -25.75f, 1.75f, 9.0f, 5.0f, 5.0f, cubeDeformation), PartPose.offset(0.0f, 0.0f, 0.0f));
        root.addOrReplaceChild("backpack_top_straps", CubeListBuilder.create().texOffs(0, 10).addBox(-4.0f, -20.75f, 2.0f, 8.0f, 8.0f, 4.0f, cubeDeformation), PartPose.offset(0.0f, 0.0f, 0.0f));
        root.addOrReplaceChild(C0394gj.f2552af, CubeListBuilder.create().texOffs(24, 10).addBox(-4.0f, -20.75f, 2.0f, 8.0f, 8.0f, 4.0f, cubeDeformation.extend(0.25f)), PartPose.offset(0.0f, 0.0f, 0.0f));
        root.addOrReplaceChild("backpack_straps", CubeListBuilder.create().texOffs(28, 0).addBox(-4.5f, -25.75f, 1.75f, 9.0f, 5.0f, 5.0f, cubeDeformation.extend(0.25f)), PartPose.offset(0.0f, 0.0f, 0.0f));
        return meshDefinition;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static PartPose m1497a(@NotNull PartPose partPose, boolean z) {
        return PartPose.offsetAndRotation(partPose.x, partPose.y + ((z ? f2166er : 1.5f) * 16.0f), partPose.z + ((z ? 0.7f : 0.0f) * 16.0f), partPose.xRot, partPose.yRot, partPose.zRot);
    }

    public void renderToBuffer(PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int i, int i2, int i3) {
        poseStack.pushPose();
        if (this.f2163cn) {
            poseStack.translate(0.0f, f2166er, 0.7f);
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
        return ImmutableList.of(this.f2159a, this.f2160b, this.f2161c, this.f2162d);
    }

    public void translateToHand(@NotNull HumanoidArm humanoidArm, @NotNull PoseStack poseStack) {
    }

    public void setupAnim(@NotNull T t, float f, float f2, float f3, float f4, float f5) {
        this.f2161c.yRot = 0.0f;
        m1499a((LivingEntity) t);
        if (this.f2163cn) {
            this.f2161c.xRot = 0.5f;
            this.f2161c.y = 3.2f;
        } else {
            this.f2161c.xRot = 0.0f;
            this.f2161c.y = 0.0f;
        }
        this.f2159a.copyFrom(this.f2161c);
        this.f2160b.copyFrom(this.f2161c);
        this.f2162d.copyFrom(this.f2161c);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void prepareMobModel(@NotNull T t, float f, float f2, float f3) {
        this.f2164ep = t.getSwimAmount(f3);
        super.prepareMobModel(t, f, f2, f3);
    }

    /* JADX INFO: renamed from: a */
    protected void m1499a(@NotNull T t) {
        if (this.attackTime > 0.0f) {
            this.f2161c.yRot = Mth.sin(Mth.sqrt(this.attackTime) * 6.2831855f) * 0.2f;
            if (m1500a((LivingEntity) t) == HumanoidArm.LEFT) {
                this.f2161c.yRot *= -1.0f;
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private HumanoidArm m1500a(@NotNull T t) {
        return ((LivingEntity) t).swingingArm == InteractionHand.MAIN_HAND ? t.getMainArm() : t.getMainArm().getOpposite();
    }
}
