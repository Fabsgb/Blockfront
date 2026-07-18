package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.util.FormattedCharSequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pv.class */
public class C0882pv extends AbstractC0877pq {

    /* JADX INFO: renamed from: iS */
    @NotNull
    private Component f4610iS;

    /* JADX INFO: renamed from: y */
    @NotNull
    private FormattedCharSequence f4611y;

    /* JADX INFO: renamed from: nA */
    private int f4612nA;

    public C0882pv(@NotNull Component component) {
        this.f4611y = FormattedCharSequence.EMPTY;
        this.f4610iS = component;
    }

    public C0882pv() {
        this(Component.literal("Unknown"));
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: a */
    public void mo4435a(@NotNull Minecraft minecraft, @NotNull Font font) {
        this.f4611y = this.f4610iS.getVisualOrderText();
        this.f4612nA = font.width(this.f4611y) + 2;
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: a */
    public void mo4436a(@NotNull Minecraft minecraft, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull C0876pp c0876pp) {
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: a */
    public void mo4437a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull C0876pp c0876pp, float f) {
        C0119bk.m409a(poseStack, font, guiGraphics, this.f4611y, mo4438a(font) / 2, 2.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: a */
    public int mo4438a(@NotNull Font font) {
        return this.f4612nA;
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: bm */
    public int mo4439bm() {
        return -16711681;
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: d */
    public void mo4440d(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.f4610iS = (Component) ComponentSerialization.STREAM_CODEC.decode(registryFriendlyByteBuf);
        if (this.f4610iS.getString().equals(Minecraft.getInstance().getUser().getName())) {
            this.f4610iS = this.f4610iS.copy().withColor(ColorReferences.COLOR_WHITE);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: e */
    public void mo4441e(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        ComponentSerialization.STREAM_CODEC.encode(registryFriendlyByteBuf, this.f4610iS);
    }
}
