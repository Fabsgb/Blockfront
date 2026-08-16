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

/* JADX INFO: renamed from: com.boehmod.blockfront.ha */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ha.class */
public abstract class AbstractC0438ha<T extends LivingEntity> extends AbstractC0383gY<T> {

    /* JADX INFO: renamed from: fE */
    protected static final float f2792fE = 15.0f;

    /* JADX INFO: renamed from: cK */
    protected static final ResourceLocation f2793cK = C0532jO.m2378d("textures/misc/waypoints/waypoint_player.png");

    /* JADX INFO: renamed from: a */
    public abstract String mo1819a(@NotNull T t, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb);

    /* JADX INFO: renamed from: a */
    public abstract C1093ts mo1818a(@NotNull T t, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb);

    @Override // com.boehmod.blockfront.AbstractC0383gY
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo1825a(@NotNull C0623l c0623l, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull Entity entity, @NotNull GuiGraphics guiGraphics, @NotNull AbstractC0863pb abstractC0863pb, @NotNull AbstractC0864pc abstractC0864pc, @NotNull AbstractC0866pe abstractC0866pe, @NotNull C0872pk c0872pk, int i, float f, float f2) {
        m2022a(c0623l, renderNameTagEvent, minecraft, c0396gl, (LivingEntity) entity, guiGraphics, (AbstractC0863pb<?, ?, ?>) abstractC0863pb, (AbstractC0864pc<?, ?>) abstractC0864pc, (AbstractC0866pe<?>) abstractC0866pe, c0872pk, i, f, f2);
    }

    @Override // com.boehmod.blockfront.AbstractC0383gY
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo1821a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @Nullable LocalPlayer localPlayer, @NotNull Entity entity, @NotNull AbstractC0863pb abstractC0863pb, @NotNull AbstractC0864pc abstractC0864pc, @NotNull C0872pk c0872pk) {
        return mo1820a(renderNameTagEvent, minecraft, c0396gl, localPlayer, (LivingEntity) entity, (AbstractC0863pb<?, ?, ?>) abstractC0863pb, (AbstractC0864pc<?, ?>) abstractC0864pc, c0872pk);
    }

    /* JADX INFO: renamed from: a */
    public boolean mo1820a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @Nullable LocalPlayer localPlayer, @NotNull T t, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0864pc<?, ?> abstractC0864pc, @NotNull C0872pk c0872pk) {
        Entity entity = minecraft.cameraEntity;
        LocalPlayer localPlayer2 = entity instanceof LivingEntity ? (LivingEntity) entity : localPlayer;
        return (localPlayer2 == null || localPlayer2.hasLineOfSight(t)) && mo1819a((LivingEntity) t, abstractC0863pb).equals(c0872pk.getName()) && t.getVehicle() == null;
    }

    /* JADX INFO: renamed from: a */
    public void m2022a(@NotNull C0623l c0623l, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull T t, @NotNull GuiGraphics guiGraphics, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0864pc<?, ?> abstractC0864pc, @NotNull AbstractC0866pe<?> abstractC0866pe, @NotNull C0872pk c0872pk, int i, float f, float f2) {
        if (minecraft.cameraEntity == null) {
            return;
        }
        mo1832a(c0623l, c0396gl, guiGraphics, t, abstractC0863pb, abstractC0866pe, minecraft.player, minecraft.cameraEntity.getRotationVector(), i, 28, 16, t.getBbHeight() + 1.0f, 0.025f, -14.0f, -8.0f, f);
    }

    /* JADX INFO: renamed from: a */
    public void mo1832a(@NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull GuiGraphics guiGraphics, @NotNull T t, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0866pe<?> abstractC0866pe, @Nullable LocalPlayer localPlayer, @NotNull Vec2 vec2, int i, int i2, int i3, float f, float f2, float f3, float f4, float f5) {
        m1824a(guiGraphics, i, i2, i3, f, vec2, f2, f3, f4, mo1818a((LivingEntity) t, abstractC0863pb).getIcon(), f2793cK, 0.5f);
    }
}
