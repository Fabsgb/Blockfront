package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pN.class */
public class C0849pN extends AbstractC0848pM {

    /* JADX INFO: renamed from: T */
    @NotNull
    private ResourceLocation f4569T;

    /* JADX INFO: renamed from: cf */
    @NotNull
    private String f4570cf;

    public C0849pN(@NotNull String str) {
        this.f4570cf = str;
        this.f4569T = C0532jO.m2378d("textures/gui/killfeed/" + str + ".png");
    }

    public C0849pN() {
        this("headshot");
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: a */
    public void mo3924a(@NotNull Minecraft minecraft, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull C0847pL c0847pL) {
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: a */
    public void mo3925a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull C0847pL c0847pL, float f) {
        C0129bt.m531a(poseStack, guiGraphics, this.f4569T, 1, 0, 11, 11);
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: a */
    public int mo3926a(@NotNull Font font) {
        return 13;
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: bB */
    public int mo3927bB() {
        return -65536;
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: d */
    public void mo3928d(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.f4570cf = registryFriendlyByteBuf.readUtf();
        this.f4569T = C0532jO.m2378d("textures/gui/killfeed/" + this.f4570cf + ".png");
    }

    @Override // com.boehmod.blockfront.AbstractC0848pM
    /* JADX INFO: renamed from: e */
    public void mo3929e(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeUtf(this.f4570cf);
    }
}
