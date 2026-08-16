package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pO.class */
public class C0850pO extends AbstractC0848pM {

    /* JADX INFO: renamed from: ly */
    public static final float f4571ly = 1.0f;

    /* JADX INFO: renamed from: lz */
    public static final float f4572lz = 0.6f;

    /* JADX INFO: renamed from: c */
    @NotNull
    private ItemStack f4573c;

    public C0850pO() {
        this(new ItemStack(Items.STICK));
    }

    public C0850pO(@NotNull ItemStack itemStack) {
        this.f4573c = itemStack.copy();
        if (this.f4573c.getItem() instanceof AbstractC1140um) {
            this.f4573c.set(C1305xs.f7524E.get(), true);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: a */
    public void mo3924a(@NotNull Minecraft minecraft, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull C0847pL c0847pL) {
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: a */
    public void mo3925a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull C0847pL c0847pL, float f) {
        if (this.f4573c.isEmpty()) {
            return;
        }
        int iMo3926a = mo3926a(font) / 2;
        C0126bq.m441a(poseStack, guiGraphics, this.f4573c, iMo3926a, iMo3926a / 2.0f, this.f4573c.getItem() instanceof C1109uH ? 0.6f : 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: a */
    public int mo3926a(@NotNull Font font) {
        return 24;
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: bB */
    public int mo3927bB() {
        return -16711936;
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: d */
    public void mo3928d(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.f4573c = (ItemStack) ItemStack.STREAM_CODEC.decode(registryFriendlyByteBuf);
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: e */
    public void mo3929e(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        ItemStack.STREAM_CODEC.encode(registryFriendlyByteBuf, this.f4573c);
    }
}
