package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ht */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ht.class */
public final class C0456ht implements InterfaceC0455hs {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0387gd f2862a = new C0387gd();

    @Override // com.boehmod.blockfront.InterfaceC0455hs
    /* JADX INFO: renamed from: a */
    public void mo2068a(@NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull C0326fV c0326fV, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull GuiGraphics guiGraphics, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Font font, @NotNull Camera camera, @NotNull Iterable<Entity> iterable, @NotNull Random random, float f) {
        List<C0386gc> list = C0051aV.f352l;
        if (list.isEmpty()) {
            return;
        }
        try {
            this.f2862a.m1863a(minecraft, camera, list, f);
        } catch (NullPointerException | ConcurrentModificationException e) {
        }
    }
}
