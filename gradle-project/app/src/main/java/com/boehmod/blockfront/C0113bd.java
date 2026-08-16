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

/* JADX INFO: renamed from: com.boehmod.blockfront.bd */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bd.class */
public final class C0113bd extends AbstractC0053aW {

    /* JADX INFO: renamed from: bY */
    private static final int f767bY = 3;

    /* JADX INFO: renamed from: m */
    @NotNull
    public static final List<C0403gs> f766m = new ObjectArrayList();

    /* JADX INFO: renamed from: bZ */
    public static int f768bZ = 0;

    @Override // com.boehmod.blockfront.AbstractC0053aW
    /* JADX INFO: renamed from: a */
    public void mo246a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull C0623l c0623l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0394gj c0394gj, @NotNull C0555jl c0555jl, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, boolean z, float f) {
        c0623l.m2856a(minecraft, random, clientLevel, localPlayer, c0555jl, c0394gj, f, vec3, blockPos);
        C0129bt.onUpdate();
        C0036aF.m202a(localPlayer);
        if (localPlayer != null && clientLevel != null) {
            int i = f768bZ + 1;
            f768bZ = i;
            if (i > 3) {
                f768bZ = 0;
            }
            f766m.removeIf(c0403gs -> {
                return c0403gs.m1914a(minecraft, c0623l, localPlayer, clientLevel, random);
            });
            return;
        }
        f766m.clear();
    }
}
