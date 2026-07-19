package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pq.class */
public abstract class AbstractC0422pq {
    public static final int nO = 11;

    @OnlyIn(Dist.CLIENT)
    public abstract void a(@NotNull Minecraft minecraft, @NotNull oF<?, ?, ?> oFVar, @NotNull C0421pp c0421pp);

    @OnlyIn(Dist.CLIENT)
    public abstract void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull oF<?, ?, ?> oFVar, @NotNull C0421pp c0421pp, float f);

    @OnlyIn(Dist.CLIENT)
    public abstract int a(@NotNull Font font);

    @OnlyIn(Dist.CLIENT)
    public abstract int bm();

    @OnlyIn(Dist.CLIENT)
    public abstract void d(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf);

    public abstract void e(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf);

    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull Font font) {
    }
}
