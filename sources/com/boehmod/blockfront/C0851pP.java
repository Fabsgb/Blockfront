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

/* JADX INFO: renamed from: com.boehmod.blockfront.pP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pP.class */
public class C0851pP extends AbstractC0848pM {

    /* JADX INFO: renamed from: C */
    @NotNull
    private Component f4574C;

    /* JADX INFO: renamed from: B */
    @NotNull
    private FormattedCharSequence f4575B;

    /* JADX INFO: renamed from: pz */
    private int f4576pz;

    public C0851pP(@NotNull Component component) {
        this.f4575B = FormattedCharSequence.EMPTY;
        this.f4574C = component;
    }

    public C0851pP() {
        this(Component.literal("Unknown"));
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: a */
    public void mo3923a(@NotNull Minecraft minecraft, @NotNull Font font) {
        this.f4575B = this.f4574C.getVisualOrderText();
        this.f4576pz = font.width(this.f4575B) + 2;
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: a */
    public void mo3924a(@NotNull Minecraft minecraft, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull C0847pL c0847pL) {
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: a */
    public void mo3925a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull C0847pL c0847pL, float f) {
        C0129bt.m509a(poseStack, font, guiGraphics, this.f4575B, (mo3926a(font) / 2.0f) - 1.5f, 2.0f);
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: a */
    public int mo3926a(@NotNull Font font) {
        return this.f4576pz;
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: bB */
    public int mo3927bB() {
        return -16776961;
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: d */
    public void mo3928d(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.f4574C = (Component) ComponentSerialization.STREAM_CODEC.decode(registryFriendlyByteBuf);
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: e */
    public void mo3929e(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        ComponentSerialization.STREAM_CODEC.encode(registryFriendlyByteBuf, this.f4574C);
    }
}
