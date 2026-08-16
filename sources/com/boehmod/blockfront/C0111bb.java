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

/* JADX INFO: renamed from: com.boehmod.blockfront.bb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bb.class */
public class C0111bb extends AbstractC0053aW {

    /* JADX INFO: renamed from: j */
    @NotNull
    public static final List<C0057aa> f718j = new ObjectArrayList();

    /* JADX INFO: renamed from: k */
    @NotNull
    public static final List<C0029Z> f719k = new ObjectArrayList();

    @Override // com.boehmod.blockfront.AbstractC0053aW
    /* JADX INFO: renamed from: a */
    public void mo246a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull C0623l c0623l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0394gj c0394gj, @NotNull C0555jl c0555jl, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, boolean z, float f) {
        f718j.removeIf((v0) -> {
            return v0.m259l();
        });
        f719k.removeIf((v0) -> {
            return v0.m172l();
        });
    }
}
