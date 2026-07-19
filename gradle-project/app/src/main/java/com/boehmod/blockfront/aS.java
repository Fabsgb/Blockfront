package com.boehmod.blockfront;

import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aS.class */
public final class aS extends aO {
    private static final int bd = 15;
    private static final float be = 5.0f;

    /* JADX INFO: renamed from: be, reason: collision with other field name */
    private int f42be = 0;

    @Override // com.boehmod.blockfront.aO
    public void a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull C0297l c0297l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull fT fTVar, @NotNull iS iSVar, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable oF<?, ?, ?> oFVar, boolean z, float f) {
        if (localPlayer != null && !fTVar.dk()) {
            int i = this.f42be - 1;
            this.f42be = i;
            if (i <= 0) {
                this.f42be = 15;
                float health = localPlayer.getHealth();
                float maxHealth = health / localPlayer.getMaxHealth();
                if (maxHealth > 0.0f && health <= 5.0f) {
                    minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.oB.get(), 1.0f, (1.0f - maxHealth) / 2.0f));
                }
            }
        }
        if (C0067ck.r > 0) {
            C0067ck.r--;
        }
        if (C0558ur.rY > 0) {
            C0558ur.rY--;
        }
    }
}
