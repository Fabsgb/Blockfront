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

/* JADX INFO: renamed from: com.boehmod.blockfront.gK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gK.class */
public abstract class AbstractC0368gK<T extends LivingEntity> extends AbstractC0366gI<T> {

    /* JADX INFO: renamed from: fu */
    protected static final float f2454fu = 15.0f;

    /* JADX INFO: renamed from: cK */
    protected static final ResourceLocation f2455cK = C0564jv.m2555d("textures/misc/waypoints/waypoint_player.png");

    /* JADX INFO: renamed from: a */
    public abstract String mo1752a(@NotNull T t, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF);

    /* JADX INFO: renamed from: a */
    public abstract C1015sV mo1751a(@NotNull T t, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF);

    @Override // com.boehmod.blockfront.AbstractC0366gI
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo1758a(@NotNull C0622l c0622l, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull Entity entity, @NotNull GuiGraphics guiGraphics, @NotNull AbstractC0787oF abstractC0787oF, @NotNull AbstractC0788oG abstractC0788oG, @NotNull AbstractC0790oI abstractC0790oI, @NotNull C0796oO c0796oO, int i, float f, float f2) {
        m1766a(c0622l, renderNameTagEvent, minecraft, c0326fV, (LivingEntity) entity, guiGraphics, (AbstractC0787oF<?, ?, ?>) abstractC0787oF, (AbstractC0788oG<?, ?>) abstractC0788oG, (AbstractC0790oI<?>) abstractC0790oI, c0796oO, i, f, f2);
    }

    @Override // com.boehmod.blockfront.AbstractC0366gI
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo1754a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @Nullable LocalPlayer localPlayer, @NotNull Entity entity, @NotNull AbstractC0787oF abstractC0787oF, @NotNull AbstractC0788oG abstractC0788oG, @NotNull C0796oO c0796oO) {
        return mo1753a(renderNameTagEvent, minecraft, c0326fV, localPlayer, (LivingEntity) entity, (AbstractC0787oF<?, ?, ?>) abstractC0787oF, (AbstractC0788oG<?, ?>) abstractC0788oG, c0796oO);
    }

    /* JADX INFO: renamed from: a */
    public boolean mo1753a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @Nullable LocalPlayer localPlayer, @NotNull T t, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0788oG<?, ?> abstractC0788oG, @NotNull C0796oO c0796oO) {
        Entity entity = minecraft.cameraEntity;
        LocalPlayer localPlayer2 = entity instanceof LivingEntity ? (LivingEntity) entity : localPlayer;
        return (localPlayer2 == null || localPlayer2.hasLineOfSight(t)) && mo1752a((LivingEntity) t, abstractC0787oF).equals(c0796oO.getName()) && t.getVehicle() == null;
    }

    /* JADX INFO: renamed from: a */
    public void m1766a(@NotNull C0622l c0622l, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull T t, @NotNull GuiGraphics guiGraphics, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0788oG<?, ?> abstractC0788oG, @NotNull AbstractC0790oI<?> abstractC0790oI, @NotNull C0796oO c0796oO, int i, float f, float f2) {
        if (minecraft.cameraEntity == null) {
            return;
        }
        mo1765a(c0622l, c0326fV, guiGraphics, t, abstractC0787oF, abstractC0790oI, minecraft.player, minecraft.cameraEntity.getRotationVector(), i, 28, 16, t.getBbHeight() + 1.0f, 0.025f, -14.0f, -8.0f, f);
    }

    /* JADX INFO: renamed from: a */
    public void mo1765a(@NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull GuiGraphics guiGraphics, @NotNull T t, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0790oI<?> abstractC0790oI, @Nullable LocalPlayer localPlayer, @NotNull Vec2 vec2, int i, int i2, int i3, float f, float f2, float f3, float f4, float f5) {
        m1757a(guiGraphics, i, i2, i3, f, vec2, f2, f3, f4, mo1751a((LivingEntity) t, abstractC0787oF).getIcon(), f2455cK, 0.5f);
    }
}
