package com.boehmod.blockfront;

import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aZ.class */
public class aZ extends aO {
    public static boolean aj = false;

    @NotNull
    private static final C0226ij a = new C0226ij();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private static final C0227ik f49a = new C0227ik();

    @Override // com.boehmod.blockfront.aO
    public void a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull C0297l c0297l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull fT fTVar, @NotNull iS iSVar, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable oF<?, ?, ?> oFVar, boolean z, float f) {
        SoundManager soundManager = minecraft.getSoundManager();
        a.tick();
        f49a.tick();
        if (clientLevel != null) {
            if (soundManager.isActive(a)) {
                soundManager.stop(a);
            }
            if (soundManager.isActive(f49a)) {
                soundManager.stop(f49a);
                return;
            }
            return;
        }
        if (aj) {
            if (!soundManager.isActive(a)) {
                soundManager.play(a);
            }
            if (!soundManager.isActive(f49a)) {
                soundManager.play(f49a);
            }
        }
    }
}
