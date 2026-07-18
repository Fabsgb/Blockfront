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

/* JADX INFO: renamed from: com.boehmod.blockfront.aZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aZ.class */
public class C0055aZ extends AbstractC0044aO {

    /* JADX INFO: renamed from: aj */
    public static boolean f384aj = false;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final C0499ij f385a = new C0499ij();

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final C0500ik f386a = new C0500ik();

    @Override // com.boehmod.blockfront.AbstractC0044aO
    /* JADX INFO: renamed from: a */
    public void mo204a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull C0622l c0622l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0324fT c0324fT, @NotNull C0482iS c0482iS, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, boolean z, float f) {
        SoundManager soundManager = minecraft.getSoundManager();
        f385a.tick();
        f386a.tick();
        if (clientLevel != null) {
            if (soundManager.isActive(f385a)) {
                soundManager.stop(f385a);
            }
            if (soundManager.isActive(f386a)) {
                soundManager.stop(f386a);
                return;
            }
            return;
        }
        if (f384aj) {
            if (!soundManager.isActive(f385a)) {
                soundManager.play(f385a);
            }
            if (!soundManager.isActive(f386a)) {
                soundManager.play(f386a);
            }
        }
    }
}
