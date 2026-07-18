package com.boehmod.blockfront;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.eB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eB.class */
public class C0253eB extends EntityModel<C0693mR> {

    /* JADX INFO: renamed from: j */
    private final ModelPart f2055j;

    /* JADX INFO: renamed from: k */
    @NotNull
    private final ModelPart f2056k;

    /* JADX INFO: renamed from: l */
    @NotNull
    private final ModelPart f2057l;

    /* JADX INFO: renamed from: m */
    @NotNull
    private final ModelPart f2058m;

    /* JADX INFO: renamed from: n */
    @NotNull
    private final ModelPart f2059n;

    /* JADX INFO: renamed from: o */
    @NotNull
    private final ModelPart f2060o;

    /* JADX INFO: renamed from: p */
    @NotNull
    private final ModelPart f2061p;

    /* JADX INFO: renamed from: q */
    @NotNull
    private final ModelPart f2062q;

    /* JADX INFO: renamed from: r */
    @NotNull
    private final ModelPart f2063r;

    /* JADX INFO: renamed from: s */
    @NotNull
    private final ModelPart f2064s;

    public C0253eB(@NotNull ModelPart modelPart) {
        this.f2055j = modelPart.getChild("head");
        this.f2056k = this.f2055j.getChild("real_head");
        this.f2057l = modelPart.getChild("body");
        this.f2064s = modelPart.getChild("upper_body");
        this.f2058m = modelPart.getChild("right_hind_leg");
        this.f2059n = modelPart.getChild("left_hind_leg");
        this.f2060o = modelPart.getChild("right_front_leg");
        this.f2061p = modelPart.getChild("left_front_leg");
        this.f2062q = modelPart.getChild("tail");
        this.f2063r = this.f2062q.getChild("real_tail");
    }

    @NotNull
    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of(this.f2055j);
    }

    @NotNull
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(this.f2057l, this.f2058m, this.f2059n, this.f2060o, this.f2061p, this.f2062q, this.f2064s);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void prepareMobModel(@NotNull C0693mR c0693mR, float f, float f2, float f3) {
        this.f2057l.setPos(0.0f, 14.0f, 2.0f);
        this.f2057l.xRot = 1.5707964f;
        this.f2064s.setPos(-1.0f, 14.0f, -3.0f);
        this.f2064s.xRot = this.f2057l.xRot;
        this.f2062q.setPos(-1.0f, 12.0f, 8.0f);
        this.f2058m.setPos(-2.5f, 16.0f, 7.0f);
        this.f2059n.setPos(0.5f, 16.0f, 7.0f);
        this.f2060o.setPos(-2.5f, 16.0f, -4.0f);
        this.f2061p.setPos(0.5f, 16.0f, -4.0f);
        this.f2058m.xRot = Mth.cos(f * 0.6662f) * 1.4f * f2;
        this.f2059n.xRot = Mth.cos((f * 0.6662f) + 3.1415927f) * 1.4f * f2;
        this.f2060o.xRot = Mth.cos((f * 0.6662f) + 3.1415927f) * 1.4f * f2;
        this.f2061p.xRot = Mth.cos(f * 0.6662f) * 1.4f * f2;
        float fM366g = C0119bk.m366g() + c0693mR.getId();
        float fSin = 0.2f * Mth.sin(fM366g / 4.0f);
        float fSin2 = 0.1f * Mth.sin(fM366g / 7.0f);
        this.f2055j.xRot = fSin;
        this.f2055j.zRot = fSin2;
        this.f2056k.zRot = fSin2 + fSin;
        this.f2064s.zRot = fSin;
        this.f2057l.zRot = fSin;
        this.f2063r.zRot = fSin;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setupAnim(@NotNull C0693mR c0693mR, float f, float f2, float f3, float f4, float f5) {
        float fM366g = C0119bk.m366g() + c0693mR.getId();
        float fSin = Mth.sin(fM366g / 3.0f) * 0.5f;
        float fSin2 = Mth.sin(fM366g / 5.0f);
        this.f2062q.xRot = 1.2f + fSin;
        this.f2062q.yRot = 0.0f + fSin2;
        this.f2062q.zRot = 0.0f;
        this.f2055j.xRot = f5 * 0.017453292f;
        this.f2055j.yRot = f4 * 0.017453292f;
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
