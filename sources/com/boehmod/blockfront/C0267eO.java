package com.boehmod.blockfront;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.eO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eO.class */
public class C0267eO extends EntityModel<C0769nn> {

    /* JADX INFO: renamed from: j */
    private final ModelPart f2174j;

    /* JADX INFO: renamed from: k */
    @NotNull
    private final ModelPart f2175k;

    /* JADX INFO: renamed from: l */
    @NotNull
    private final ModelPart f2176l;

    /* JADX INFO: renamed from: m */
    @NotNull
    private final ModelPart f2177m;

    /* JADX INFO: renamed from: n */
    @NotNull
    private final ModelPart f2178n;

    /* JADX INFO: renamed from: o */
    @NotNull
    private final ModelPart f2179o;

    /* JADX INFO: renamed from: p */
    @NotNull
    private final ModelPart f2180p;

    /* JADX INFO: renamed from: q */
    @NotNull
    private final ModelPart f2181q;

    /* JADX INFO: renamed from: r */
    @NotNull
    private final ModelPart f2182r;

    /* JADX INFO: renamed from: s */
    @NotNull
    private final ModelPart f2183s;

    public C0267eO(@NotNull ModelPart modelPart) {
        this.f2174j = modelPart.getChild("head");
        this.f2175k = this.f2174j.getChild("real_head");
        this.f2176l = modelPart.getChild("body");
        this.f2183s = modelPart.getChild("upper_body");
        this.f2177m = modelPart.getChild("right_hind_leg");
        this.f2178n = modelPart.getChild("left_hind_leg");
        this.f2179o = modelPart.getChild("right_front_leg");
        this.f2180p = modelPart.getChild("left_front_leg");
        this.f2181q = modelPart.getChild("tail");
        this.f2182r = this.f2181q.getChild("real_tail");
    }

    @NotNull
    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of(this.f2174j);
    }

    @NotNull
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(this.f2176l, this.f2177m, this.f2178n, this.f2179o, this.f2180p, this.f2181q, this.f2183s);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void prepareMobModel(@NotNull C0769nn c0769nn, float f, float f2, float f3) {
        this.f2176l.setPos(0.0f, 14.0f, 2.0f);
        this.f2176l.xRot = 1.5707964f;
        this.f2183s.setPos(-1.0f, 14.0f, -3.0f);
        this.f2183s.xRot = this.f2176l.xRot;
        this.f2181q.setPos(-1.0f, 12.0f, 8.0f);
        this.f2177m.setPos(-2.5f, 16.0f, 7.0f);
        this.f2178n.setPos(0.5f, 16.0f, 7.0f);
        this.f2179o.setPos(-2.5f, 16.0f, -4.0f);
        this.f2180p.setPos(0.5f, 16.0f, -4.0f);
        this.f2177m.xRot = Mth.cos(f * 0.6662f) * 1.4f * f2;
        this.f2178n.xRot = Mth.cos((f * 0.6662f) + 3.1415927f) * 1.4f * f2;
        this.f2179o.xRot = Mth.cos((f * 0.6662f) + 3.1415927f) * 1.4f * f2;
        this.f2180p.xRot = Mth.cos(f * 0.6662f) * 1.4f * f2;
        float fM466g = C0129bt.m466g() + c0769nn.getId();
        float fSin = 0.2f * Mth.sin(fM466g / 4.0f);
        float fSin2 = 0.1f * Mth.sin(fM466g / 7.0f);
        this.f2174j.xRot = fSin;
        this.f2174j.zRot = fSin2;
        this.f2175k.zRot = fSin2 + fSin;
        this.f2183s.zRot = fSin;
        this.f2176l.zRot = fSin;
        this.f2182r.zRot = fSin;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setupAnim(@NotNull C0769nn c0769nn, float f, float f2, float f3, float f4, float f5) {
        float fM466g = C0129bt.m466g() + c0769nn.getId();
        float fSin = Mth.sin(fM466g / 3.0f) * 0.5f;
        float fSin2 = Mth.sin(fM466g / 5.0f);
        this.f2181q.xRot = 1.2f + fSin;
        this.f2181q.yRot = 0.0f + fSin2;
        this.f2181q.zRot = 0.0f;
        this.f2174j.xRot = f5 * 0.017453292f;
        this.f2174j.yRot = f4 * 0.017453292f;
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
