package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pg.class */
public class C0412pg {
    private static final float kz = 0.005f;
    private float kA = 0.0f;

    public void u(@NotNull Minecraft minecraft) {
    }

    public float aM() {
        return this.kA;
    }

    public void a(@NotNull Minecraft minecraft, @NotNull oF<?, ?, ?> oFVar, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull Vec3 vec3) {
        this.kA += kz;
    }
}
