package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.CapeLayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hp.class */
public class C0206hp extends CapeLayer {
    static final /* synthetic */ boolean cC;

    static {
        cC = !C0206hp.class.desiredAssertionStatus();
    }

    public C0206hp(@NotNull RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> renderLayerParent) {
        super(renderLayerParent);
    }

    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, @NotNull AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3, float f4, float f5, float f6) {
        C0297l c0297lB = C0297l.b();
        if (!cC && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0297lB.m591a() == null) {
            super.render(poseStack, multiBufferSource, i, abstractClientPlayer, f, f2, f3, f4, f5, f6);
        }
    }
}
