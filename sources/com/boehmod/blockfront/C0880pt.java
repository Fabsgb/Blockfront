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

/* JADX INFO: renamed from: com.boehmod.blockfront.pt */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pt.class */
public class C0880pt extends AbstractC0877pq {

    /* JADX INFO: renamed from: C */
    @NotNull
    private Component f4605C;

    /* JADX INFO: renamed from: x */
    @NotNull
    private FormattedCharSequence f4606x;

    /* JADX INFO: renamed from: nA */
    private int f4607nA;

    public C0880pt(@NotNull Component component) {
        this.f4606x = FormattedCharSequence.EMPTY;
        this.f4605C = component;
    }

    public C0880pt() {
        this(Component.literal("Unknown"));
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: a */
    public void mo4435a(@NotNull Minecraft minecraft, @NotNull Font font) {
        this.f4606x = this.f4605C.getVisualOrderText();
        this.f4607nA = font.width(this.f4606x) + 2;
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: a */
    public void mo4436a(@NotNull Minecraft minecraft, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull C0876pp c0876pp) {
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: a */
    public void mo4437a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull C0876pp c0876pp, float f) {
        C0119bk.m409a(poseStack, font, guiGraphics, this.f4606x, (mo4438a(font) / 2.0f) - 1.5f, 2.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: a */
    public int mo4438a(@NotNull Font font) {
        return this.f4607nA;
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: bm */
    public int mo4439bm() {
        return -16776961;
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: d */
    public void mo4440d(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.f4605C = (Component) ComponentSerialization.STREAM_CODEC.decode(registryFriendlyByteBuf);
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: e */
    public void mo4441e(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        ComponentSerialization.STREAM_CODEC.encode(registryFriendlyByteBuf, this.f4605C);
    }
}
