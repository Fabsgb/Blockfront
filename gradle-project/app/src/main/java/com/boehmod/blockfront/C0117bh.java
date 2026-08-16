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

/* JADX INFO: renamed from: com.boehmod.blockfront.bh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bh.class */
public class C0117bh extends AbstractC0053aW {

    /* JADX INFO: renamed from: ao */
    public static boolean f798ao = false;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final C0465iA f799a = new C0465iA();

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final C0466iB f800a = new C0466iB();

    @Override // com.boehmod.blockfront.AbstractC0053aW
    /* JADX INFO: renamed from: a */
    public void mo246a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull C0623l c0623l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0394gj c0394gj, @NotNull C0555jl c0555jl, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, boolean z, float f) {
        SoundManager soundManager = minecraft.getSoundManager();
        f799a.tick();
        f800a.tick();
        if (clientLevel != null) {
            if (soundManager.isActive(f799a)) {
                soundManager.stop(f799a);
            }
            if (soundManager.isActive(f800a)) {
                soundManager.stop(f800a);
                return;
            }
            return;
        }
        if (f798ao) {
            if (!soundManager.isActive(f799a)) {
                soundManager.play(f799a);
            }
            if (!soundManager.isActive(f800a)) {
                soundManager.play(f800a);
            }
        }
    }
}
