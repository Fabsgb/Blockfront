package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.phys.Vec2;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.gI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gI.class */
public abstract class AbstractC0366gI<T extends Entity> {

    /* JADX INFO: renamed from: h */
    private static final Map<EntityType<?>, AbstractC0366gI<?>> f2453h = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: a */
    public abstract boolean mo1754a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull LocalPlayer localPlayer, @NotNull T t, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0788oG<?, ?> abstractC0788oG, @NotNull C0796oO c0796oO);

    /* JADX INFO: renamed from: a */
    public abstract void mo1758a(@NotNull C0622l c0622l, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull T t, @NotNull GuiGraphics guiGraphics, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0788oG<?, ?> abstractC0788oG, @NotNull AbstractC0790oI<?> abstractC0790oI, @NotNull C0796oO c0796oO, int i, float f, float f2);

    /* JADX INFO: renamed from: a */
    public static AbstractC0366gI<?> m1755a(@NotNull EntityType<?> entityType) {
        return f2453h.get(entityType);
    }

    /* JADX INFO: renamed from: a */
    public static void m1756a(@NotNull EntityType<?> entityType, @NotNull AbstractC0366gI<?> abstractC0366gI) {
        f2453h.put(entityType, abstractC0366gI);
    }

    /* JADX INFO: renamed from: a */
    static void m1757a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, float f, @NotNull Vec2 vec2, float f2, float f3, float f4, @Nullable ResourceLocation resourceLocation, @Nullable ResourceLocation resourceLocation2, float f5) {
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, f, 0.0f);
        poseStackPose.mulPose(Axis.YP.rotationDegrees(-vec2.y));
        poseStackPose.scale(-f2, -f2, f2);
        if (resourceLocation2 != null) {
            C0119bk.m436a(poseStackPose, guiGraphics, resourceLocation2, f3, f3, i2, i2, 0.0f, f5, i);
        }
        if (resourceLocation != null) {
            C0119bk.m434a(poseStackPose, guiGraphics, resourceLocation, f4, f4 - 3.0f, i3, i3, 0.0f, f5);
        }
        poseStackPose.popPose();
    }
}
