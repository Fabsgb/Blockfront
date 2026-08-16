package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.C0129bt;
import com.boehmod.blockfront.C0532jO;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.DisconnectedScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mixin/DisconnectedScreenMixin.class */
@Mixin({DisconnectedScreen.class})
public abstract class DisconnectedScreenMixin extends Screen {

    @Unique
    private final ResourceLocation blockFrontAll$backgroundTexture;

    protected DisconnectedScreenMixin() {
        super(Component.empty());
        this.blockFrontAll$backgroundTexture = blockFrontAll$getRandomTexture();
    }

    @Unique
    @NotNull
    private ResourceLocation blockFrontAll$getRandomTexture() {
        return C0532jO.m2378d("textures/gui/background/loading/background" + ThreadLocalRandom.current().nextInt(0, 4) + ".png");
    }

    public void renderBackground(GuiGraphics guiGraphics, int i, int i2, float f) {
        C0129bt.m645a(Minecraft.getInstance(), guiGraphics.pose(), guiGraphics, this.blockFrontAll$backgroundTexture, this.width, this.height, f);
    }
}
