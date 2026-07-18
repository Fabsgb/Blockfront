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

/* JADX INFO: renamed from: com.boehmod.blockfront.aV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aV.class */
public final class C0051aV extends AbstractC0044aO {

    /* JADX INFO: renamed from: bi */
    private static final int f353bi = 3;

    /* JADX INFO: renamed from: l */
    @NotNull
    public static final List<C0386gc> f352l = new ObjectArrayList();

    /* JADX INFO: renamed from: bj */
    public static int f354bj = 0;

    @Override // com.boehmod.blockfront.AbstractC0044aO
    /* JADX INFO: renamed from: a */
    public void mo204a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull C0622l c0622l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0324fT c0324fT, @NotNull C0482iS c0482iS, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, boolean z, float f) {
        c0622l.m2671a(minecraft, random, clientLevel, localPlayer, c0482iS, c0324fT, f, vec3, blockPos);
        C0119bk.onUpdate();
        C0080ay.m275a(localPlayer);
        if (localPlayer != null && clientLevel != null) {
            int i = f354bj + 1;
            f354bj = i;
            if (i > 3) {
                f354bj = 0;
            }
            f352l.removeIf(c0386gc -> {
                return c0386gc.m1850a(minecraft, c0622l, localPlayer, clientLevel, random);
            });
            return;
        }
        f352l.clear();
    }
}
