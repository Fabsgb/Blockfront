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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aR.class */
public class aR extends aO {

    @NotNull
    private final ObjectList<Entity> e = new ObjectArrayList();

    @Override // com.boehmod.blockfront.aO
    public void a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull fV fVVar, @NotNull C0297l c0297l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull fT fTVar, @NotNull iS iSVar, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable oF<?, ?, ?> oFVar, boolean z, float f) {
        if (clientLevel == null) {
            return;
        }
        try {
            this.e.clear();
            for (FallingBlockEntity fallingBlockEntity : clientLevel.entitiesForRendering()) {
                if (fallingBlockEntity instanceof FallingBlockEntity) {
                    FallingBlockEntity fallingBlockEntity2 = fallingBlockEntity;
                    if (fallingBlockEntity2.onGround()) {
                        this.e.add(fallingBlockEntity2);
                    }
                }
            }
            this.e.forEach((v0) -> {
                v0.discard();
            });
        } catch (IndexOutOfBoundsException e) {
        }
    }
}
