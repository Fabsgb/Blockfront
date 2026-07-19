package com.boehmod.blockfront;

import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.resources.PlayerSkin;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iF.class */
public class iF {
    private boolean dd = false;

    public void aT() {
        this.dd = false;
    }

    public void a(@NotNull Minecraft minecraft, @NotNull Font font, @NotNull ItemInHandRenderer itemInHandRenderer) {
        if (this.dd) {
            return;
        }
        this.dd = true;
        C0263jt.log("Checking player renderer...", new Object[0]);
        EntityRenderDispatcher entityRenderDispatcher = minecraft.getEntityRenderDispatcher();
        EntityRendererProvider.Context context = new EntityRendererProvider.Context(entityRenderDispatcher, minecraft.getItemRenderer(), minecraft.getBlockRenderer(), itemInHandRenderer, minecraft.getResourceManager(), minecraft.getEntityModels(), font);
        entityRenderDispatcher.playerRenderers = Map.of(PlayerSkin.Model.WIDE, new gN(context, false), PlayerSkin.Model.SLIM, new gN(context, true));
        C0263jt.log("Finished checking and replacing player renderer!", new Object[0]);
    }
}
