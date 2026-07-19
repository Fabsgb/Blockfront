package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec2;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gK.class */
public abstract class gK<T extends LivingEntity> extends gI<T> {
    protected static final float fu = 15.0f;
    protected static final ResourceLocation cK = C0265jv.d("textures/misc/waypoints/waypoint_player.png");

    /* JADX INFO: renamed from: a */
    public abstract String mo418a(@NotNull T t, @NotNull oF<?, ?, ?> oFVar);

    public abstract sV a(@NotNull T t, @NotNull oF<?, ?, ?> oFVar);

    @Override // com.boehmod.blockfront.gI
    public /* bridge */ /* synthetic */ void a(@NotNull C0297l c0297l, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull Entity entity, @NotNull GuiGraphics guiGraphics, @NotNull oF oFVar, @NotNull oG oGVar, @NotNull oI oIVar, @NotNull oO oOVar, int i, float f, float f2) {
        a(c0297l, renderNameTagEvent, minecraft, fVVar, (LivingEntity) entity, guiGraphics, (oF<?, ?, ?>) oFVar, (oG<?, ?>) oGVar, (oI<?>) oIVar, oOVar, i, f, f2);
    }

    @Override // com.boehmod.blockfront.gI
    public /* bridge */ /* synthetic */ boolean a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull fV fVVar, @Nullable LocalPlayer localPlayer, @NotNull Entity entity, @NotNull oF oFVar, @NotNull oG oGVar, @NotNull oO oOVar) {
        return a(renderNameTagEvent, minecraft, fVVar, localPlayer, (LivingEntity) entity, (oF<?, ?, ?>) oFVar, (oG<?, ?>) oGVar, oOVar);
    }

    public boolean a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull fV fVVar, @Nullable LocalPlayer localPlayer, @NotNull T t, @NotNull oF<?, ?, ?> oFVar, @NotNull oG<?, ?> oGVar, @NotNull oO oOVar) {
        Entity entity = minecraft.cameraEntity;
        LocalPlayer localPlayer2 = entity instanceof LivingEntity ? (LivingEntity) entity : localPlayer;
        return (localPlayer2 == null || localPlayer2.hasLineOfSight(t)) && mo418a((LivingEntity) t, oFVar).equals(oOVar.getName()) && t.getVehicle() == null;
    }

    public void a(@NotNull C0297l c0297l, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull T t, @NotNull GuiGraphics guiGraphics, @NotNull oF<?, ?, ?> oFVar, @NotNull oG<?, ?> oGVar, @NotNull oI<?> oIVar, @NotNull oO oOVar, int i, float f, float f2) {
        if (minecraft.cameraEntity == null) {
            return;
        }
        a(c0297l, fVVar, guiGraphics, t, oFVar, oIVar, minecraft.player, minecraft.cameraEntity.getRotationVector(), i, 28, 16, t.getBbHeight() + 1.0f, 0.025f, -14.0f, -8.0f, f);
    }

    public void a(@NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull GuiGraphics guiGraphics, @NotNull T t, @NotNull oF<?, ?, ?> oFVar, @NotNull oI<?> oIVar, @Nullable LocalPlayer localPlayer, @NotNull Vec2 vec2, int i, int i2, int i3, float f, float f2, float f3, float f4, float f5) {
        a(guiGraphics, i, i2, i3, f, vec2, f2, f3, f4, a((LivingEntity) t, oFVar).getIcon(), cK, 0.5f);
    }
}
