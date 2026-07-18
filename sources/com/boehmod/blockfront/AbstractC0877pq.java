package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pq.class */
public abstract class AbstractC0877pq {

    /* JADX INFO: renamed from: nO */
    public static final int f4599nO = 11;

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public abstract void mo4436a(@NotNull Minecraft minecraft, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull C0876pp c0876pp);

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public abstract void mo4437a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull C0876pp c0876pp, float f);

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public abstract int mo4438a(@NotNull Font font);

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: bm */
    public abstract int mo4439bm();

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: d */
    public abstract void mo4440d(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf);

    /* JADX INFO: renamed from: e */
    public abstract void mo4441e(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf);

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4435a(@NotNull Minecraft minecraft, @NotNull Font font) {
    }
}
