package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pr.class */
public class C0878pr extends AbstractC0877pq {

    /* JADX INFO: renamed from: T */
    @NotNull
    private ResourceLocation f4600T;

    /* JADX INFO: renamed from: bV */
    @NotNull
    private String f4601bV;

    public C0878pr(@NotNull String str) {
        this.f4601bV = str;
        this.f4600T = C0564jv.m2555d("textures/gui/killfeed/" + str + ".png");
    }

    public C0878pr() {
        this("headshot");
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: a */
    public void mo4436a(@NotNull Minecraft minecraft, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull C0876pp c0876pp) {
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: a */
    public void mo4437a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull C0876pp c0876pp, float f) {
        C0119bk.m431a(poseStack, guiGraphics, this.f4600T, 1, 0, 11, 11);
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: a */
    public int mo4438a(@NotNull Font font) {
        return 13;
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: bm */
    public int mo4439bm() {
        return -65536;
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: d */
    public void mo4440d(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.f4601bV = registryFriendlyByteBuf.readUtf();
        this.f4600T = C0564jv.m2555d("textures/gui/killfeed/" + this.f4601bV + ".png");
    }

    @Override // com.boehmod.blockfront.AbstractC0877pq
    /* JADX INFO: renamed from: e */
    public void mo4441e(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeUtf(this.f4601bV);
    }
}
