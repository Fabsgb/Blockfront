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

/* JADX INFO: renamed from: com.boehmod.blockfront.aS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aS.class */
public final class C0048aS extends AbstractC0044aO {

    /* JADX INFO: renamed from: bd */
    private static final int f301bd = 15;

    /* JADX INFO: renamed from: be */
    private static final float f302be = 5.0f;

    /* JADX INFO: renamed from: be */
    private int f303be = 0;

    @Override // com.boehmod.blockfront.AbstractC0044aO
    /* JADX INFO: renamed from: a */
    public void mo204a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull C0622l c0622l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0324fT c0324fT, @NotNull C0482iS c0482iS, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, boolean z, float f) {
        if (localPlayer != null && !c0324fT.m1087dk()) {
            int i = this.f303be - 1;
            this.f303be = i;
            if (i <= 0) {
                this.f303be = 15;
                float health = localPlayer.getHealth();
                float maxHealth = health / localPlayer.getMaxHealth();
                if (maxHealth > 0.0f && health <= 5.0f) {
                    minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7518oB.get(), 1.0f, (1.0f - maxHealth) / 2.0f));
                }
            }
        }
        if (C0172ck.f1429r > 0) {
            C0172ck.f1429r--;
        }
        if (C1144ur.f6002rY > 0) {
            C1144ur.f6002rY--;
        }
    }
}
