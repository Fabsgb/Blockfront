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

/* JADX INFO: renamed from: com.boehmod.blockfront.lf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/lf.class */
public final class C0655lf extends C0579kI {
    public C0655lf(@NotNull BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override // com.boehmod.blockfront.C0579kI, com.boehmod.blockfront.InterfaceC0650la
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo2615a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, int i, Vec3 vec3, @NotNull BlockPos blockPos, @NotNull BlockState blockState, Direction direction) {
        if (Minecraft.useFancyGraphics()) {
            C0517j c0517jM2883a = c0623l.m2883a();
            float fRandom = 0.1f + ((float) (Math.random() * 0.10000000149011612d));
            Vec3i normal = direction.getNormal();
            c0517jM2883a.m2297a(new C0062af(vec3, C1309xw.f7892oc, (1 + ((int) (Math.random() * 3.0d))) * 20).m277a(new Vec3(normal.getX() * fRandom, normal.getY() * fRandom, normal.getZ() * fRandom)));
            clientLevel.playLocalSound(blockPos.getX() + 0.5f, blockPos.getY() + 0.5f, blockPos.getZ() + 0.5f, (SoundEvent) C1312xz.f8153sS.get(), SoundSource.BLOCKS, 1.0f, 0.8f + (0.1f * clientLevel.random.nextInt(4)), false);
        }
    }
}
