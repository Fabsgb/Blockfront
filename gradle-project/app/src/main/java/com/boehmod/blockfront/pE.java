package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pE.class */
public interface pE {
    @OnlyIn(Dist.CLIENT)
    void a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, int i, @NotNull PoseStack poseStack, @NotNull Matrix4f matrix4f, @NotNull Matrix4f matrix4f2, float f, double d, double d2, double d3);
}
