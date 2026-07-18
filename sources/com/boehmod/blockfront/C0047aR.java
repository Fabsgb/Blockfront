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

/* JADX INFO: renamed from: com.boehmod.blockfront.aR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aR.class */
public class C0047aR extends AbstractC0044aO {

    /* JADX INFO: renamed from: e */
    @NotNull
    private final ObjectList<Entity> f300e = new ObjectArrayList();

    @Override // com.boehmod.blockfront.AbstractC0044aO
    /* JADX INFO: renamed from: a */
    public void mo204a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @NotNull C0622l c0622l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0324fT c0324fT, @NotNull C0482iS c0482iS, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, boolean z, float f) {
        if (clientLevel == null) {
            return;
        }
        try {
            this.f300e.clear();
            for (FallingBlockEntity fallingBlockEntity : clientLevel.entitiesForRendering()) {
                if (fallingBlockEntity instanceof FallingBlockEntity) {
                    FallingBlockEntity fallingBlockEntity2 = fallingBlockEntity;
                    if (fallingBlockEntity2.onGround()) {
                        this.f300e.add(fallingBlockEntity2);
                    }
                }
            }
            this.f300e.forEach((v0) -> {
                v0.discard();
            });
        } catch (IndexOutOfBoundsException e) {
        }
    }
}
