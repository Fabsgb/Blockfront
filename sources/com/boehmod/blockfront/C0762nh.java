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

/* JADX INFO: renamed from: com.boehmod.blockfront.nh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nh.class */
public class C0762nh extends C0760nf {

    /* JADX INFO: renamed from: lK */
    private static final int f4091lK = 120;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0506iq f4092a;

    public C0762nh(@NotNull EntityType<? extends C0760nf> entityType, @NotNull Level level) {
        super(entityType, level);
        this.f4092a = null;
    }

    @Override // com.boehmod.blockfront.C0760nf
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected void mo3434a(@NotNull ThreadLocalRandom threadLocalRandom, @NotNull Level level, @NotNull Vec3 vec3) {
        super.mo3434a(threadLocalRandom, level, vec3);
        Minecraft minecraft = Minecraft.getInstance();
        if (this.f4092a == null) {
            SoundManager soundManager = minecraft.getSoundManager();
            this.f4092a = new C0506iq(this, (SoundEvent) C1280xc.f7729sE.get(), SoundSource.PLAYERS, 0.95f + (threadLocalRandom.nextFloat() * 0.1f), 15.0f);
            soundManager.play(this.f4092a);
        }
    }

    @Override // com.boehmod.blockfront.C0760nf
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected void mo3435a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull Vec3 vec3) {
        super.mo3435a(minecraft, c0622l, clientLevel, vec3);
    }

    @Override // com.boehmod.blockfront.C0760nf
    /* JADX INFO: renamed from: e */
    public SoundEvent mo3428e() {
        return (SoundEvent) C1280xc.f7728sD.get();
    }

    @Override // com.boehmod.blockfront.C0760nf
    @NotNull
    /* JADX INFO: renamed from: f */
    public SoundEvent mo3429f() {
        return (SoundEvent) C1280xc.f7729sE.get();
    }

    @Override // com.boehmod.blockfront.C0760nf
    /* JADX INFO: renamed from: aF */
    public int mo3425aF() {
        return 120;
    }

    @Override // com.boehmod.blockfront.C0760nf
    /* JADX INFO: renamed from: aN */
    protected boolean mo3430aN() {
        return false;
    }

    @Override // com.boehmod.blockfront.C0760nf
    /* JADX INFO: renamed from: aM */
    protected boolean mo3426aM() {
        return false;
    }
}
