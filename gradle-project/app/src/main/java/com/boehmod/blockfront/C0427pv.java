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

/* JADX INFO: renamed from: com.boehmod.blockfront.pv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pv.class */
public class C0427pv extends AbstractC0422pq {

    @NotNull
    private Component iS;

    @NotNull
    private FormattedCharSequence y;
    private int nA;

    public C0427pv(@NotNull Component component) {
        this.y = FormattedCharSequence.EMPTY;
        this.iS = component;
    }

    public C0427pv() {
        this(Component.literal("Unknown"));
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public void a(@NotNull Minecraft minecraft, @NotNull Font font) {
        this.y = this.iS.getVisualOrderText();
        this.nA = font.width(this.y) + 2;
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public void a(@NotNull Minecraft minecraft, @NotNull oF<?, ?, ?> oFVar, @NotNull C0421pp c0421pp) {
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull oF<?, ?, ?> oFVar, @NotNull C0421pp c0421pp, float f) {
        C0040bk.a(poseStack, font, guiGraphics, this.y, a(font) / 2, 2.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public int a(@NotNull Font font) {
        return this.nA;
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public int bm() {
        return -16711681;
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public void d(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.iS = (Component) ComponentSerialization.STREAM_CODEC.decode(registryFriendlyByteBuf);
        if (this.iS.getString().equals(Minecraft.getInstance().getUser().getName())) {
            this.iS = this.iS.copy().withColor(ColorReferences.COLOR_WHITE);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public void e(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        ComponentSerialization.STREAM_CODEC.encode(registryFriendlyByteBuf, this.iS);
    }
}
