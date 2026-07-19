package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/kJ.class */
public final class kJ extends C0283km {
    public kJ(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override // com.boehmod.blockfront.C0283km, com.boehmod.blockfront.kE
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
        if (Minecraft.useFancyGraphics()) {
            C0243j c0243jM594a = c0297l.m594a();
            float fRandom = 0.1f + ((float) (Math.random() * 0.10000000149011612d));
            Vec3i normal = direction.getNormal();
            c0243jM594a.a(new Z(vec3, wZ.oa, (1 + ((int) (Math.random() * 3.0d))) * 20).a(new Vec3(normal.getX() * fRandom, normal.getY() * fRandom, normal.getZ() * fRandom)));
            clientLevel.playLocalSound(blockPos.getX() + 0.5f, blockPos.getY() + 0.5f, blockPos.getZ() + 0.5f, (SoundEvent) C0624xc.sR.get(), SoundSource.BLOCKS, 1.0f, 0.8f + (0.1f * clientLevel.random.nextInt(4)), false);
        }
    }
}
