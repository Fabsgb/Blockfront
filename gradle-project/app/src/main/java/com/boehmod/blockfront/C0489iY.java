package com.boehmod.blockfront;

import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.resources.PlayerSkin;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iY.class */
public class C0489iY {

    /* JADX INFO: renamed from: dn */
    private boolean f2996dn = false;

    /* JADX INFO: renamed from: bf */
    public void m2211bf() {
        this.f2996dn = false;
    }

    /* JADX INFO: renamed from: a */
    public void m2212a(@NotNull Minecraft minecraft, @NotNull Font font, @NotNull ItemInHandRenderer itemInHandRenderer) {
        if (this.f2996dn) {
            return;
        }
        this.f2996dn = true;
        C0530jM.log("Checking player renderer...", new Object[0]);
        EntityRenderDispatcher entityRenderDispatcher = minecraft.getEntityRenderDispatcher();
        EntityRendererProvider.Context context = new EntityRendererProvider.Context(entityRenderDispatcher, minecraft.getItemRenderer(), minecraft.getBlockRenderer(), itemInHandRenderer, minecraft.getResourceManager(), minecraft.getEntityModels(), font);
        entityRenderDispatcher.playerRenderers = Map.of(PlayerSkin.Model.WIDE, new C0441hd(context, false), PlayerSkin.Model.SLIM, new C0441hd(context, true));
        C0530jM.log("Finished checking and replacing player renderer!", new Object[0]);
    }
}
