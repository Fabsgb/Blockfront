package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pM.class */
public abstract class AbstractC0848pM {

    /* JADX INFO: renamed from: pN */
    public static final int f4568pN = 11;

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public abstract void mo3924a(@NotNull Minecraft minecraft, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull C0847pL c0847pL);

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public abstract void mo3925a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull C0847pL c0847pL, float f);

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public abstract int mo3926a(@NotNull Font font);

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: bB */
    public abstract int mo3927bB();

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: d */
    public abstract void mo3928d(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf);

    /* JADX INFO: renamed from: e */
    public abstract void mo3929e(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf);

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3923a(@NotNull Minecraft minecraft, @NotNull Font font) {
    }
}
