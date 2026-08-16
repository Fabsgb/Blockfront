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

/* JADX INFO: renamed from: com.boehmod.blockfront.pR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pR.class */
public class C0853pR extends AbstractC0848pM {

    /* JADX INFO: renamed from: jf */
    @NotNull
    private Component f4579jf;

    /* JADX INFO: renamed from: C */
    @NotNull
    private FormattedCharSequence f4580C;

    /* JADX INFO: renamed from: pz */
    private int f4581pz;

    public C0853pR(@NotNull Component component) {
        this.f4580C = FormattedCharSequence.EMPTY;
        this.f4579jf = component;
    }

    public C0853pR() {
        this(Component.literal("Unknown"));
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: a */
    public void mo3923a(@NotNull Minecraft minecraft, @NotNull Font font) {
        this.f4580C = this.f4579jf.getVisualOrderText();
        this.f4581pz = font.width(this.f4580C) + 2;
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: a */
    public void mo3924a(@NotNull Minecraft minecraft, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull C0847pL c0847pL) {
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: a */
    public void mo3925a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull C0847pL c0847pL, float f) {
        C0129bt.m509a(poseStack, font, guiGraphics, this.f4580C, mo3926a(font) / 2, 2.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: a */
    public int mo3926a(@NotNull Font font) {
        return this.f4581pz;
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: bB */
    public int mo3927bB() {
        return -16711681;
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: d */
    public void mo3928d(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.f4579jf = (Component) ComponentSerialization.STREAM_CODEC.decode(registryFriendlyByteBuf);
        if (this.f4579jf.getString().equals(Minecraft.getInstance().getUser().getName())) {
            this.f4579jf = this.f4579jf.copy().withColor(ColorReferences.COLOR_WHITE);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: e */
    public void mo3929e(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        ComponentSerialization.STREAM_CODEC.encode(registryFriendlyByteBuf, this.f4579jf);
    }
}
