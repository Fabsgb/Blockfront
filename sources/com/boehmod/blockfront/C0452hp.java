package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.CapeLayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hp.class */
public class C0452hp extends CapeLayer {

    /* JADX INFO: renamed from: cC */
    static final /* synthetic */ boolean f2853cC;

    static {
        f2853cC = !C0452hp.class.desiredAssertionStatus();
    }

    public C0452hp(@NotNull RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> renderLayerParent) {
        super(renderLayerParent);
    }

    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, @NotNull AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3, float f4, float f5, float f6) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2853cC && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0622lM2667b.m2688a() == null) {
            super.render(poseStack, multiBufferSource, i, abstractClientPlayer, f, f2, f3, f4, f5, f6);
        }
    }
}
