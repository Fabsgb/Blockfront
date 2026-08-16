package com.boehmod.blockfront;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.nD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nD.class */
public class C0733nD extends C0731nB {

    /* JADX INFO: renamed from: nI */
    private static final int f4046nI = 120;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0472iH f4047a;

    public C0733nD(@NotNull EntityType<? extends C0731nB> entityType, @NotNull Level level) {
        super(entityType, level);
        this.f4047a = null;
    }

    @Override // com.boehmod.blockfront.C0731nB
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected void mo3357a(@NotNull ThreadLocalRandom threadLocalRandom, @NotNull Level level, @NotNull Vec3 vec3) {
        super.mo3357a(threadLocalRandom, level, vec3);
        Minecraft minecraft = Minecraft.getInstance();
        if (this.f4047a == null) {
            SoundManager soundManager = minecraft.getSoundManager();
            this.f4047a = new C0472iH(this, (SoundEvent) C1312xz.f8140sF.get(), SoundSource.PLAYERS, 0.95f + (threadLocalRandom.nextFloat() * 0.1f), 15.0f);
            soundManager.play(this.f4047a);
        }
    }

    @Override // com.boehmod.blockfront.C0731nB
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected void mo3358a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull Vec3 vec3) {
        super.mo3358a(minecraft, c0623l, clientLevel, vec3);
    }

    @Override // com.boehmod.blockfront.C0731nB
    /* JADX INFO: renamed from: e */
    public SoundEvent mo3349e() {
        return (SoundEvent) C1312xz.f8139sE.get();
    }

    @Override // com.boehmod.blockfront.C0731nB
    @NotNull
    /* JADX INFO: renamed from: f */
    public SoundEvent mo3350f() {
        return (SoundEvent) C1312xz.f8140sF.get();
    }

    @Override // com.boehmod.blockfront.C0731nB
    /* JADX INFO: renamed from: aU */
    public int mo3352aU() {
        return 120;
    }

    @Override // com.boehmod.blockfront.C0731nB
    /* JADX INFO: renamed from: aX */
    protected boolean mo3353aX() {
        return false;
    }

    @Override // com.boehmod.blockfront.C0731nB
    /* JADX INFO: renamed from: aW */
    protected boolean mo3351aW() {
        return false;
    }
}
