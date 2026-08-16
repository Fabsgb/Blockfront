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

/* JADX INFO: renamed from: com.boehmod.blockfront.hJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hJ.class */
public final class C0421hJ implements InterfaceC0420hI {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0404gt f2692a = new C0404gt();

    @Override // com.boehmod.blockfront.InterfaceC0420hI
    /* JADX INFO: renamed from: a */
    public void mo1970a(@NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull C0396gl c0396gl, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull GuiGraphics guiGraphics, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull Font font, @NotNull Camera camera, @NotNull Iterable<Entity> iterable, @NotNull Random random, float f) {
        List<C0403gs> list = C0113bd.f766m;
        if (list.isEmpty()) {
            return;
        }
        try {
            this.f2692a.m1928a(minecraft, camera, list, f);
        } catch (NullPointerException | ConcurrentModificationException e) {
        }
    }
}
