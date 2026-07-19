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

/* JADX INFO: renamed from: com.boehmod.blockfront.nh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nh.class */
public class C0359nh extends C0357nf {
    private static final int lK = 120;

    @Nullable
    private C0233iq a;

    public C0359nh(@NotNull EntityType<? extends C0357nf> entityType, @NotNull Level level) {
        super(entityType, level);
        this.a = null;
    }

    @Override // com.boehmod.blockfront.C0357nf
    @OnlyIn(Dist.CLIENT)
    protected void a(@NotNull ThreadLocalRandom threadLocalRandom, @NotNull Level level, @NotNull Vec3 vec3) {
        super.a(threadLocalRandom, level, vec3);
        Minecraft minecraft = Minecraft.getInstance();
        if (this.a == null) {
            SoundManager soundManager = minecraft.getSoundManager();
            this.a = new C0233iq(this, (SoundEvent) C0624xc.sE.get(), SoundSource.PLAYERS, 0.95f + (threadLocalRandom.nextFloat() * 0.1f), 15.0f);
            soundManager.play(this.a);
        }
    }

    @Override // com.boehmod.blockfront.C0357nf
    @OnlyIn(Dist.CLIENT)
    protected void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull Vec3 vec3) {
        super.a(minecraft, c0297l, clientLevel, vec3);
    }

    @Override // com.boehmod.blockfront.C0357nf
    public SoundEvent e() {
        return (SoundEvent) C0624xc.sD.get();
    }

    @Override // com.boehmod.blockfront.C0357nf
    @NotNull
    public SoundEvent f() {
        return (SoundEvent) C0624xc.sE.get();
    }

    @Override // com.boehmod.blockfront.C0357nf
    public int aF() {
        return 120;
    }

    @Override // com.boehmod.blockfront.C0357nf
    protected boolean aN() {
        return false;
    }

    @Override // com.boehmod.blockfront.C0357nf
    protected boolean aM() {
        return false;
    }
}
