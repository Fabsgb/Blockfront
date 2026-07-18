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

/* JADX INFO: renamed from: com.boehmod.blockfront.gL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gL.class */
public class C0369gL extends AbstractC0366gI<AbstractC0779ny> {

    /* JADX INFO: renamed from: cL */
    private static final ResourceLocation f2456cL = C0564jv.m2555d("textures/misc/waypoints/waypoint_vehicle.png");

    @Override // com.boehmod.blockfront.AbstractC0366gI
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo1758a(@NotNull C0622l c0622l, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull Entity entity, @NotNull GuiGraphics guiGraphics, @NotNull AbstractC0787oF abstractC0787oF, @NotNull AbstractC0788oG abstractC0788oG, @NotNull AbstractC0790oI abstractC0790oI, @NotNull C0796oO c0796oO, int i, float f, float f2) {
        m1768a(c0622l, renderNameTagEvent, minecraft, c0326fV, (AbstractC0779ny) entity, guiGraphics, (AbstractC0787oF<?, ?, ?>) abstractC0787oF, (AbstractC0788oG<?, ?>) abstractC0788oG, (AbstractC0790oI<?>) abstractC0790oI, c0796oO, i, f, f2);
    }

    @Override // com.boehmod.blockfront.AbstractC0366gI
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo1754a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull LocalPlayer localPlayer, @NotNull Entity entity, @NotNull AbstractC0787oF abstractC0787oF, @NotNull AbstractC0788oG abstractC0788oG, @NotNull C0796oO c0796oO) {
        return m1767a(renderNameTagEvent, minecraft, c0326fV, localPlayer, (AbstractC0779ny) entity, (AbstractC0787oF<?, ?, ?>) abstractC0787oF, (AbstractC0788oG<?, ?>) abstractC0788oG, c0796oO);
    }

    /* JADX INFO: renamed from: a */
    public boolean m1767a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull LocalPlayer localPlayer, @NotNull AbstractC0779ny abstractC0779ny, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0788oG<?, ?> abstractC0788oG, @NotNull C0796oO c0796oO) {
        if (minecraft.player != null && (!minecraft.player.hasLineOfSight(abstractC0779ny) || abstractC0779ny.equals(minecraft.player.getVehicle()))) {
            return false;
        }
        return c0796oO.getName().equalsIgnoreCase(abstractC0779ny.m3519J());
    }

    /* JADX INFO: renamed from: a */
    public void m1768a(@NotNull C0622l c0622l, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull AbstractC0779ny abstractC0779ny, @NotNull GuiGraphics guiGraphics, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0788oG<?, ?> abstractC0788oG, @NotNull AbstractC0790oI<?> abstractC0790oI, @NotNull C0796oO c0796oO, int i, float f, float f2) {
        if (minecraft.cameraEntity == null) {
            return;
        }
        C0733nE<AbstractC0779ny> c0733nEM3499b = abstractC0779ny.m3499b();
        float bbHeight = (abstractC0779ny.getBbHeight() + 3.0f) - c0733nEM3499b.f3965jQ;
        Vec2 rotationVector = minecraft.cameraEntity.getRotationVector();
        ResourceLocation resourceLocationM3355w = c0733nEM3499b.m3355w();
        float fAbs = 0.5f;
        Entity entityM3515a = abstractC0779ny.m3515a();
        if (entityM3515a instanceof Player) {
            C0324fT c0324fT = (C0324fT) c0326fV.m1133a((Player) entityM3515a);
            if (c0324fT.m1666ah() > 0) {
                resourceLocationM3355w = c0324fT.m1644j();
                i = ColorReferences.COLOR_THEME_YELLOW_SOLID;
                fAbs = Math.abs(Mth.sin(f / 10.0f));
            }
        }
        m1757a(guiGraphics, i, 42, 24, bbHeight, rotationVector, 0.025f, -21.0f, -12.0f, resourceLocationM3355w, f2456cL, fAbs);
    }
}
