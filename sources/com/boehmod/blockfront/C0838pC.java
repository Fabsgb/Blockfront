package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pC.class */
public class C0838pC {

    /* JADX INFO: renamed from: lu */
    private static final float f4523lu = 0.005f;

    /* JADX INFO: renamed from: lv */
    private float f4524lv = 0.0f;

    /* JADX INFO: renamed from: w */
    public void m3840w(@NotNull Minecraft minecraft) {
    }

    /* JADX INFO: renamed from: aS */
    public float m3841aS() {
        return this.f4524lv;
    }

    /* JADX INFO: renamed from: a */
    public void m3842a(@NotNull Minecraft minecraft, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull Vec3 vec3) {
        this.f4524lv += f4523lu;
    }
}
