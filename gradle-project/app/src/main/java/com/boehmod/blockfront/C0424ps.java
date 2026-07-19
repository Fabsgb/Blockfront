package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ps, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ps.class */
public class C0424ps extends AbstractC0422pq {
    public static final float kD = 1.0f;
    public static final float kE = 0.6f;

    @NotNull
    private ItemStack c;

    public C0424ps() {
        this(new ItemStack(Items.STICK));
    }

    public C0424ps(@NotNull ItemStack itemStack) {
        this.c = itemStack.copy();
        if (this.c.getItem() instanceof tO) {
            this.c.set(wV.E.get(), true);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public void a(@NotNull Minecraft minecraft, @NotNull oF<?, ?, ?> oFVar, @NotNull C0421pp c0421pp) {
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull oF<?, ?, ?> oFVar, @NotNull C0421pp c0421pp, float f) {
        if (this.c.isEmpty()) {
            return;
        }
        int iA = a(font) / 2;
        C0040bk.a(poseStack, guiGraphics, this.c, iA, iA / 2.0f, this.c.getItem() instanceof C0550uj ? 0.6f : 1.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public int a(@NotNull Font font) {
        return 24;
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public int bm() {
        return -16711936;
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public void d(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.c = (ItemStack) ItemStack.STREAM_CODEC.decode(registryFriendlyByteBuf);
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public void e(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        ItemStack.STREAM_CODEC.encode(registryFriendlyByteBuf, this.c);
    }
}
