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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gI.class */
public abstract class gI<T extends Entity> {
    private static final Map<EntityType<?>, gI<?>> h = new Object2ObjectOpenHashMap();

    public abstract boolean a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull LocalPlayer localPlayer, @NotNull T t, @NotNull oF<?, ?, ?> oFVar, @NotNull oG<?, ?> oGVar, @NotNull oO oOVar);

    public abstract void a(@NotNull C0297l c0297l, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull T t, @NotNull GuiGraphics guiGraphics, @NotNull oF<?, ?, ?> oFVar, @NotNull oG<?, ?> oGVar, @NotNull oI<?> oIVar, @NotNull oO oOVar, int i, float f, float f2);

    public static gI<?> a(@NotNull EntityType<?> entityType) {
        return h.get(entityType);
    }

    public static void a(@NotNull EntityType<?> entityType, @NotNull gI<?> gIVar) {
        h.put(entityType, gIVar);
    }

    static void a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, float f, @NotNull Vec2 vec2, float f2, float f3, float f4, @Nullable ResourceLocation resourceLocation, @Nullable ResourceLocation resourceLocation2, float f5) {
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, f, 0.0f);
        poseStackPose.mulPose(Axis.YP.rotationDegrees(-vec2.y));
        poseStackPose.scale(-f2, -f2, f2);
        if (resourceLocation2 != null) {
            C0040bk.a(poseStackPose, guiGraphics, resourceLocation2, f3, f3, i2, i2, 0.0f, f5, i);
        }
        if (resourceLocation != null) {
            C0040bk.a(poseStackPose, guiGraphics, resourceLocation, f4, f4 - 3.0f, i3, i3, 0.0f, f5);
        }
        poseStackPose.popPose();
    }
}
