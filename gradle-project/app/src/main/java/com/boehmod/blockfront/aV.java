package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aV.class */
public final class aV extends aO {
    private static final int bi = 3;

    @NotNull
    public static final List<C0166gc> l = new ObjectArrayList();
    public static int bj = 0;

    @Override // com.boehmod.blockfront.aO
    public void a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull C0297l c0297l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull fT fTVar, @NotNull iS iSVar, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable oF<?, ?, ?> oFVar, boolean z, float f) {
        c0297l.a(minecraft, random, clientLevel, localPlayer, iSVar, fTVar, f, vec3, blockPos);
        C0040bk.onUpdate();
        C0027ay.a(localPlayer);
        if (localPlayer != null && clientLevel != null) {
            int i = bj + 1;
            bj = i;
            if (i > 3) {
                bj = 0;
            }
            l.removeIf(c0166gc -> {
                return c0166gc.a(minecraft, c0297l, localPlayer, clientLevel, random);
            });
            return;
        }
        l.clear();
    }
}
