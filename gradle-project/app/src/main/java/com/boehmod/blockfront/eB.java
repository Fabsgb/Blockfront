package com.boehmod.blockfront;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eB.class */
public class eB extends EntityModel<mR> {
    private final ModelPart j;

    @NotNull
    private final ModelPart k;

    @NotNull
    private final ModelPart l;

    @NotNull
    private final ModelPart m;

    @NotNull
    private final ModelPart n;

    @NotNull
    private final ModelPart o;

    @NotNull
    private final ModelPart p;

    @NotNull
    private final ModelPart q;

    @NotNull
    private final ModelPart r;

    @NotNull
    private final ModelPart s;

    public eB(@NotNull ModelPart modelPart) {
        this.j = modelPart.getChild("head");
        this.k = this.j.getChild("real_head");
        this.l = modelPart.getChild("body");
        this.s = modelPart.getChild("upper_body");
        this.m = modelPart.getChild("right_hind_leg");
        this.n = modelPart.getChild("left_hind_leg");
        this.o = modelPart.getChild("right_front_leg");
        this.p = modelPart.getChild("left_front_leg");
        this.q = modelPart.getChild("tail");
        this.r = this.q.getChild("real_tail");
    }

    @NotNull
    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of(this.j);
    }

    @NotNull
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(this.l, this.m, this.n, this.o, this.p, this.q, this.s);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void prepareMobModel(@NotNull mR mRVar, float f, float f2, float f3) {
        this.l.setPos(0.0f, 14.0f, 2.0f);
        this.l.xRot = 1.5707964f;
        this.s.setPos(-1.0f, 14.0f, -3.0f);
        this.s.xRot = this.l.xRot;
        this.q.setPos(-1.0f, 12.0f, 8.0f);
        this.m.setPos(-2.5f, 16.0f, 7.0f);
        this.n.setPos(0.5f, 16.0f, 7.0f);
        this.o.setPos(-2.5f, 16.0f, -4.0f);
        this.p.setPos(0.5f, 16.0f, -4.0f);
        this.m.xRot = Mth.cos(f * 0.6662f) * 1.4f * f2;
        this.n.xRot = Mth.cos((f * 0.6662f) + 3.1415927f) * 1.4f * f2;
        this.o.xRot = Mth.cos((f * 0.6662f) + 3.1415927f) * 1.4f * f2;
        this.p.xRot = Mth.cos(f * 0.6662f) * 1.4f * f2;
        float fG = C0040bk.g() + mRVar.getId();
        float fSin = 0.2f * Mth.sin(fG / 4.0f);
        float fSin2 = 0.1f * Mth.sin(fG / 7.0f);
        this.j.xRot = fSin;
        this.j.zRot = fSin2;
        this.k.zRot = fSin2 + fSin;
        this.s.zRot = fSin;
        this.l.zRot = fSin;
        this.r.zRot = fSin;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setupAnim(@NotNull mR mRVar, float f, float f2, float f3, float f4, float f5) {
        float fG = C0040bk.g() + mRVar.getId();
        float fSin = Mth.sin(fG / 3.0f) * 0.5f;
        float fSin2 = Mth.sin(fG / 5.0f);
        this.q.xRot = 1.2f + fSin;
        this.q.yRot = 0.0f + fSin2;
        this.q.zRot = 0.0f;
        this.j.xRot = f5 * 0.017453292f;
        this.j.yRot = f4 * 0.017453292f;
    }

    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int i, int i2, int i3) {
        headParts().forEach(modelPart -> {
            modelPart.render(poseStack, vertexConsumer, i, i2, i3);
        });
        bodyParts().forEach(modelPart2 -> {
            modelPart2.render(poseStack, vertexConsumer, i, i2, i3);
        });
    }
}
