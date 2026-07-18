package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ps */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ps.class */
public class C0879ps extends AbstractC0877pq {

    /* JADX INFO: renamed from: kD */
    public static final float f4602kD = 1.0f;

    /* JADX INFO: renamed from: kE */
    public static final float f4603kE = 0.6f;

    /* JADX INFO: renamed from: c */
    @NotNull
    private ItemStack f4604c;

    public C0879ps() {
        this(new ItemStack(Items.STICK));
    }

    public C0879ps(@NotNull ItemStack itemStack) {
        this.f4604c = itemStack.copy();
        if (this.f4604c.getItem() instanceof AbstractC1062tO) {
            this.f4604c.set(C1228wV.f6961E.get(), true);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: a */
    public void mo4436a(@NotNull Minecraft minecraft, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull C0876pp c0876pp) {
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: a */
    public void mo4437a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull C0876pp c0876pp, float f) {
        if (this.f4604c.isEmpty()) {
            return;
        }
        int iMo4438a = mo4438a(font) / 2;
        C0119bk.m501a(poseStack, guiGraphics, this.f4604c, iMo4438a, iMo4438a / 2.0f, this.f4604c.getItem() instanceof C1136uj ? 0.6f : 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: a */
    public int mo4438a(@NotNull Font font) {
        return 24;
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: bm */
    public int mo4439bm() {
        return -16711936;
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: d */
    public void mo4440d(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.f4604c = (ItemStack) ItemStack.STREAM_CODEC.decode(registryFriendlyByteBuf);
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: e */
    public void mo4441e(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        ItemStack.STREAM_CODEC.encode(registryFriendlyByteBuf, this.f4604c);
    }
}
