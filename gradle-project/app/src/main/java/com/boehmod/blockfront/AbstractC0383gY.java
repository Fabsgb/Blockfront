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

/* JADX INFO: renamed from: com.boehmod.blockfront.gY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gY.class */
public abstract class AbstractC0383gY<T extends Entity> {

    /* JADX INFO: renamed from: h */
    private static final Map<EntityType<?>, AbstractC0383gY<?>> f2529h = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: a */
    public abstract boolean mo1821a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull LocalPlayer localPlayer, @NotNull T t, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0864pc<?, ?> abstractC0864pc, @NotNull C0872pk c0872pk);

    /* JADX INFO: renamed from: a */
    public abstract void mo1825a(@NotNull C0623l c0623l, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull T t, @NotNull GuiGraphics guiGraphics, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0864pc<?, ?> abstractC0864pc, @NotNull AbstractC0866pe<?> abstractC0866pe, @NotNull C0872pk c0872pk, int i, float f, float f2);

    /* JADX INFO: renamed from: a */
    public static AbstractC0383gY<?> m1822a(@NotNull EntityType<?> entityType) {
        return f2529h.get(entityType);
    }

    /* JADX INFO: renamed from: a */
    public static void m1823a(@NotNull EntityType<?> entityType, @NotNull AbstractC0383gY<?> abstractC0383gY) {
        f2529h.put(entityType, abstractC0383gY);
    }

    /* JADX INFO: renamed from: a */
    static void m1824a(@NotNull GuiGraphics guiGraphics, int i, int i2, int i3, float f, @NotNull Vec2 vec2, float f2, float f3, float f4, @Nullable ResourceLocation resourceLocation, @Nullable ResourceLocation resourceLocation2, float f5) {
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, f, 0.0f);
        poseStackPose.mulPose(Axis.YP.rotationDegrees(-vec2.y));
        poseStackPose.scale(-f2, -f2, f2);
        if (resourceLocation2 != null) {
            C0129bt.m536a(poseStackPose, guiGraphics, resourceLocation2, f3, f3, i2, i2, 0.0f, f5, i);
        }
        if (resourceLocation != null) {
            C0129bt.m534a(poseStackPose, guiGraphics, resourceLocation, f4, f4 - 3.0f, i3, i3, 0.0f, f5);
        }
        poseStackPose.popPose();
    }
}
