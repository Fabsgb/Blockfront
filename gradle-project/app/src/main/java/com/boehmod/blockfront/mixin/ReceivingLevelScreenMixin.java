package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.C0040bk;
import com.boehmod.blockfront.C0265jv;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.ReceivingLevelScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mixin/ReceivingLevelScreenMixin.class */
@Mixin({ReceivingLevelScreen.class})
public abstract class ReceivingLevelScreenMixin extends Screen {

    @Unique
    private final ResourceLocation blockFrontAll$backgroundTexture;

    protected ReceivingLevelScreenMixin() {
        super(Component.empty());
        this.blockFrontAll$backgroundTexture = blockFrontAll$getRandomTexture();
    }

    @Unique
    @NotNull
    private ResourceLocation blockFrontAll$getRandomTexture() {
        return C0265jv.d("textures/gui/background/loading/background" + ThreadLocalRandom.current().nextInt(0, 4) + ".png");
    }

    public void renderBackground(GuiGraphics guiGraphics, int i, int i2, float f) {
        C0040bk.a(Minecraft.getInstance(), guiGraphics.pose(), guiGraphics, this.blockFrontAll$backgroundTexture, this.width, this.height, f);
    }
}
