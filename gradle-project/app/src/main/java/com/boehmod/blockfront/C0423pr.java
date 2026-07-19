package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pr.class */
public class C0423pr extends AbstractC0422pq {

    @NotNull
    private ResourceLocation T;

    @NotNull
    private String bV;

    public C0423pr(@NotNull String str) {
        this.bV = str;
        this.T = C0265jv.d("textures/gui/killfeed/" + str + ".png");
    }

    public C0423pr() {
        this("headshot");
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public void a(@NotNull Minecraft minecraft, @NotNull oF<?, ?, ?> oFVar, @NotNull C0421pp c0421pp) {
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull oF<?, ?, ?> oFVar, @NotNull C0421pp c0421pp, float f) {
        C0040bk.a(poseStack, guiGraphics, this.T, 1, 0, 11, 11);
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public int a(@NotNull Font font) {
        return 13;
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public int bm() {
        return -65536;
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public void d(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.bV = registryFriendlyByteBuf.readUtf();
        this.T = C0265jv.d("textures/gui/killfeed/" + this.bV + ".png");
    }

    @Override // com.boehmod.blockfront.AbstractC0422pq
    public void e(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeUtf(this.bV);
    }
}
