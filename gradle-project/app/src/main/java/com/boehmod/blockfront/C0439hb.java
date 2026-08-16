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

/* JADX INFO: renamed from: com.boehmod.blockfront.hb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hb.class */
public class C0439hb extends AbstractC0383gY<AbstractC0750nU> {

    /* JADX INFO: renamed from: cL */
    private static final ResourceLocation f2794cL = C0532jO.m2378d("textures/misc/waypoints/waypoint_vehicle.png");

    @Override // com.boehmod.blockfront.AbstractC0383gY
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo1825a(@NotNull C0623l c0623l, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull Entity entity, @NotNull GuiGraphics guiGraphics, @NotNull AbstractC0863pb abstractC0863pb, @NotNull AbstractC0864pc abstractC0864pc, @NotNull AbstractC0866pe abstractC0866pe, @NotNull C0872pk c0872pk, int i, float f, float f2) {
        m2024a(c0623l, renderNameTagEvent, minecraft, c0396gl, (AbstractC0750nU) entity, guiGraphics, (AbstractC0863pb<?, ?, ?>) abstractC0863pb, (AbstractC0864pc<?, ?>) abstractC0864pc, (AbstractC0866pe<?>) abstractC0866pe, c0872pk, i, f, f2);
    }

    @Override // com.boehmod.blockfront.AbstractC0383gY
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo1821a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull LocalPlayer localPlayer, @NotNull Entity entity, @NotNull AbstractC0863pb abstractC0863pb, @NotNull AbstractC0864pc abstractC0864pc, @NotNull C0872pk c0872pk) {
        return m2023a(renderNameTagEvent, minecraft, c0396gl, localPlayer, (AbstractC0750nU) entity, (AbstractC0863pb<?, ?, ?>) abstractC0863pb, (AbstractC0864pc<?, ?>) abstractC0864pc, c0872pk);
    }

    /* JADX INFO: renamed from: a */
    public boolean m2023a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull LocalPlayer localPlayer, @NotNull AbstractC0750nU abstractC0750nU, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0864pc<?, ?> abstractC0864pc, @NotNull C0872pk c0872pk) {
        if (minecraft.player != null && (!minecraft.player.hasLineOfSight(abstractC0750nU) || abstractC0750nU.equals(minecraft.player.getVehicle()))) {
            return false;
        }
        return c0872pk.getName().equalsIgnoreCase(abstractC0750nU.m3456Q());
    }

    /* JADX INFO: renamed from: a */
    public void m2024a(@NotNull C0623l c0623l, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull AbstractC0750nU abstractC0750nU, @NotNull GuiGraphics guiGraphics, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0864pc<?, ?> abstractC0864pc, @NotNull AbstractC0866pe<?> abstractC0866pe, @NotNull C0872pk c0872pk, int i, float f, float f2) {
        if (minecraft.cameraEntity == null) {
            return;
        }
        C0809oa<AbstractC0750nU> c0809oaM3436b = abstractC0750nU.m3436b();
        float bbHeight = (abstractC0750nU.getBbHeight() + 3.0f) - c0809oaM3436b.f4393kJ;
        Vec2 rotationVector = minecraft.cameraEntity.getRotationVector();
        ResourceLocation resourceLocationM3733x = c0809oaM3436b.m3733x();
        float fAbs = 0.5f;
        Entity entityM3452a = abstractC0750nU.m3452a();
        if (entityM3452a instanceof Player) {
            C0394gj c0394gj = (C0394gj) c0396gl.m1150a((Player) entityM3452a);
            if (c0394gj.m1876at() > 0) {
                resourceLocationM3733x = c0394gj.m1854k();
                i = ColorReferences.COLOR_THEME_YELLOW_SOLID;
                fAbs = Math.abs(Mth.sin(f / 10.0f));
            }
        }
        m1824a(guiGraphics, i, 42, 24, bbHeight, rotationVector, 0.025f, -21.0f, -12.0f, resourceLocationM3733x, f2794cL, fAbs);
    }
}
