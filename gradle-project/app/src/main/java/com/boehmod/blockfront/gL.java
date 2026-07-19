package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec2;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gL.class */
public class gL extends gI<AbstractC0376ny> {
    private static final ResourceLocation cL = C0265jv.d("textures/misc/waypoints/waypoint_vehicle.png");

    @Override // com.boehmod.blockfront.gI
    public /* bridge */ /* synthetic */ void a(@NotNull C0297l c0297l, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull Entity entity, @NotNull GuiGraphics guiGraphics, @NotNull oF oFVar, @NotNull oG oGVar, @NotNull oI oIVar, @NotNull oO oOVar, int i, float f, float f2) {
        a(c0297l, renderNameTagEvent, minecraft, fVVar, (AbstractC0376ny) entity, guiGraphics, (oF<?, ?, ?>) oFVar, (oG<?, ?>) oGVar, (oI<?>) oIVar, oOVar, i, f, f2);
    }

    @Override // com.boehmod.blockfront.gI
    public /* bridge */ /* synthetic */ boolean a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull LocalPlayer localPlayer, @NotNull Entity entity, @NotNull oF oFVar, @NotNull oG oGVar, @NotNull oO oOVar) {
        return a(renderNameTagEvent, minecraft, fVVar, localPlayer, (AbstractC0376ny) entity, (oF<?, ?, ?>) oFVar, (oG<?, ?>) oGVar, oOVar);
    }

    public boolean a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull LocalPlayer localPlayer, @NotNull AbstractC0376ny abstractC0376ny, @NotNull oF<?, ?, ?> oFVar, @NotNull oG<?, ?> oGVar, @NotNull oO oOVar) {
        if (minecraft.player != null && (!minecraft.player.hasLineOfSight(abstractC0376ny) || abstractC0376ny.equals(minecraft.player.getVehicle()))) {
            return false;
        }
        return oOVar.getName().equalsIgnoreCase(abstractC0376ny.J());
    }

    public void a(@NotNull C0297l c0297l, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull AbstractC0376ny abstractC0376ny, @NotNull GuiGraphics guiGraphics, @NotNull oF<?, ?, ?> oFVar, @NotNull oG<?, ?> oGVar, @NotNull oI<?> oIVar, @NotNull oO oOVar, int i, float f, float f2) {
        if (minecraft.cameraEntity == null) {
            return;
        }
        nE<AbstractC0376ny> nEVarM741b = abstractC0376ny.m741b();
        float bbHeight = (abstractC0376ny.getBbHeight() + 3.0f) - nEVarM741b.jQ;
        Vec2 rotationVector = minecraft.cameraEntity.getRotationVector();
        ResourceLocation resourceLocationW = nEVarM741b.w();
        float fAbs = 0.5f;
        Entity entityM743a = abstractC0376ny.m743a();
        if (entityM743a instanceof Player) {
            fT fTVar = (fT) fVVar.a((Player) entityM743a);
            if (fTVar.ah() > 0) {
                resourceLocationW = fTVar.j();
                i = ColorReferences.COLOR_THEME_YELLOW_SOLID;
                fAbs = Math.abs(Mth.sin(f / 10.0f));
            }
        }
        a(guiGraphics, i, 42, 24, bbHeight, rotationVector, 0.025f, -21.0f, -12.0f, resourceLocationW, cL, fAbs);
    }
}
