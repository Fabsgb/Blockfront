package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.util.FormattedCharSequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pt.class */
public class C0425pt extends AbstractC0422pq {

    @NotNull
    private Component C;

    @NotNull
    private FormattedCharSequence x;
    private int nA;

    public C0425pt(@NotNull Component component) {
        this.x = FormattedCharSequence.EMPTY;
        this.C = component;
    }

    public C0425pt() {
        this(Component.literal("Unknown"));
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public void a(@NotNull Minecraft minecraft, @NotNull Font font) {
        this.x = this.C.getVisualOrderText();
        this.nA = font.width(this.x) + 2;
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public void a(@NotNull Minecraft minecraft, @NotNull oF<?, ?, ?> oFVar, @NotNull C0421pp c0421pp) {
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull oF<?, ?, ?> oFVar, @NotNull C0421pp c0421pp, float f) {
        C0040bk.a(poseStack, font, guiGraphics, this.x, (a(font) / 2.0f) - 1.5f, 2.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public int a(@NotNull Font font) {
        return this.nA;
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public int bm() {
        return -16776961;
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public void d(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.C = (Component) ComponentSerialization.STREAM_CODEC.decode(registryFriendlyByteBuf);
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public void e(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        ComponentSerialization.STREAM_CODEC.encode(registryFriendlyByteBuf, this.C);
    }
}
