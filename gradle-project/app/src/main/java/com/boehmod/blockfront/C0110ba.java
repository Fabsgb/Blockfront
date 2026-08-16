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

/* JADX INFO: renamed from: com.boehmod.blockfront.ba */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ba.class */
public final class C0110ba extends AbstractC0053aW {

    /* JADX INFO: renamed from: bT */
    private static final int f715bT = 15;

    /* JADX INFO: renamed from: bk */
    private static final float f716bk = 5.0f;

    /* JADX INFO: renamed from: bU */
    private int f717bU = 0;

    @Override // com.boehmod.blockfront.AbstractC0053aW
    /* JADX INFO: renamed from: a */
    public void mo246a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull C0623l c0623l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0394gj c0394gj, @NotNull C0555jl c0555jl, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, boolean z, float f) {
        if (localPlayer != null && !c0394gj.m1104dt()) {
            int i = this.f717bU - 1;
            this.f717bU = i;
            if (i <= 0) {
                this.f717bU = 15;
                float health = localPlayer.getHealth();
                float maxHealth = health / localPlayer.getMaxHealth();
                if (maxHealth > 0.0f && health <= 5.0f) {
                    minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7930oD.get(), 1.0f, (1.0f - maxHealth) / 2.0f));
                }
            }
        }
        if (C0192ct.f1553t > 0) {
            C0192ct.f1553t--;
        }
        if (C1117uP.f6071ue > 0) {
            C1117uP.f6071ue--;
        }
    }
}
