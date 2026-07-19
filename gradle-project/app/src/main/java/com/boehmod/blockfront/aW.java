package com.boehmod.blockfront;

import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.client.GraphicsStatus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aW.class */
public class aW extends aO {
    private static final Component u = Component.translatable("bf.message.fabulous.graphics").withStyle(ChatFormatting.RED);

    @Override // com.boehmod.blockfront.aO
    public void a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull C0297l c0297l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull fT fTVar, @NotNull iS iSVar, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable oF<?, ?, ?> oFVar, boolean z, float f) {
        if (oFVar == null) {
            return;
        }
        OptionInstance optionInstanceGraphicsMode = minecraft.options.graphicsMode();
        if (optionInstanceGraphicsMode.get() != GraphicsStatus.FABULOUS) {
            return;
        }
        optionInstanceGraphicsMode.set(GraphicsStatus.FAST);
        minecraft.levelRenderer.allChanged();
        minecraft.options.save();
        if (localPlayer != null) {
            iC.c(minecraft, u);
        }
    }
}
