package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aZ.class */
public class C0056aZ extends AbstractC0053aW {

    /* JADX INFO: renamed from: n */
    @NotNull
    private final ObjectList<Entity> f403n = new ObjectArrayList();

    @Override // com.boehmod.blockfront.AbstractC0053aW
    /* JADX INFO: renamed from: a */
    public void mo246a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull C0623l c0623l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0394gj c0394gj, @NotNull C0555jl c0555jl, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, boolean z, float f) {
        if (clientLevel == null) {
            return;
        }
        try {
            this.f403n.clear();
            for (FallingBlockEntity fallingBlockEntity : clientLevel.entitiesForRendering()) {
                if (fallingBlockEntity instanceof FallingBlockEntity) {
                    FallingBlockEntity fallingBlockEntity2 = fallingBlockEntity;
                    if (fallingBlockEntity2.onGround()) {
                        this.f403n.add(fallingBlockEntity2);
                    }
                }
            }
            this.f403n.forEach((v0) -> {
                v0.discard();
            });
        } catch (IndexOutOfBoundsException e) {
        }
    }
}
