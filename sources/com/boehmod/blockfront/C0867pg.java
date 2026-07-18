package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pg */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pg.class */
public class C0867pg {

    /* JADX INFO: renamed from: kz */
    private static final float f4554kz = 0.005f;

    /* JADX INFO: renamed from: kA */
    private float f4555kA = 0.0f;

    /* JADX INFO: renamed from: u */
    public void m4355u(@NotNull Minecraft minecraft) {
    }

    /* JADX INFO: renamed from: aM */
    public float m4356aM() {
        return this.f4555kA;
    }

    /* JADX INFO: renamed from: a */
    public void m4357a(@NotNull Minecraft minecraft, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull Vec3 vec3) {
        this.f4555kA += f4554kz;
    }
}
