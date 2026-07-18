package com.boehmod.blockfront;

import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.resources.PlayerSkin;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iF.class */
public class C0469iF {

    /* JADX INFO: renamed from: dd */
    private boolean f2907dd = false;

    /* JADX INFO: renamed from: aT */
    public void m2119aT() {
        this.f2907dd = false;
    }

    /* JADX INFO: renamed from: a */
    public void m2120a(@NotNull Minecraft minecraft, @NotNull Font font, @NotNull ItemInHandRenderer itemInHandRenderer) {
        if (this.f2907dd) {
            return;
        }
        this.f2907dd = true;
        C0562jt.log("Checking player renderer...", new Object[0]);
        EntityRenderDispatcher entityRenderDispatcher = minecraft.getEntityRenderDispatcher();
        EntityRendererProvider.Context context = new EntityRendererProvider.Context(entityRenderDispatcher, minecraft.getItemRenderer(), minecraft.getBlockRenderer(), itemInHandRenderer, minecraft.getResourceManager(), minecraft.getEntityModels(), font);
        entityRenderDispatcher.playerRenderers = Map.of(PlayerSkin.Model.WIDE, new C0371gN(context, false), PlayerSkin.Model.SLIM, new C0371gN(context, true));
        C0562jt.log("Finished checking and replacing player renderer!", new Object[0]);
    }
}
