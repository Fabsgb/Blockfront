package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aa.class */
public abstract class AbstractC0003aa {
    public abstract void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, float f);

    public void a(@NotNull Minecraft minecraft, C0297l c0297l, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
    }

    public void c(@NotNull Minecraft minecraft, @NotNull C0297l c0297l) {
    }
}
