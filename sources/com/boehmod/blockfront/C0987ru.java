package com.boehmod.blockfront;

import java.util.Set;
import java.util.UUID;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ru */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ru.class */
public final class C0987ru extends AbstractC0989rw {

    /* JADX INFO: renamed from: pD */
    private static final int f5236pD = 4;

    /* JADX INFO: renamed from: pE */
    private static final int f5237pE = 10;

    /* JADX INFO: renamed from: pF */
    private static final int f5238pF = 4;

    /* JADX INFO: renamed from: pG */
    private static final int f5239pG = 60;

    /* JADX INFO: renamed from: pH */
    private static final int f5240pH = 400;

    /* JADX INFO: renamed from: pr */
    private int f5241pr;

    /* JADX INFO: renamed from: py */
    private int f5242py;

    public C0987ru(@NotNull ServerPlayer serverPlayer, @NotNull Vec3 vec3, int i, int i2) {
        super(serverPlayer, vec3, i, i2);
        this.f5241pr = 60;
        this.f5242py = 0;
    }

    @Override // com.boehmod.blockfront.AbstractC0982rp
    /* JADX INFO: renamed from: c */
    void mo5417c(@NotNull ServerLevel serverLevel, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0982rp
    /* JADX INFO: renamed from: d */
    void mo5418d(@NotNull ServerLevel serverLevel, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set) {
        int i = this.f5241pr;
        this.f5241pr = i - 1;
        if (i > 0) {
            return;
        }
        int i2 = this.f5242py;
        this.f5242py = i2 - 1;
        if (i2 > 0) {
            return;
        }
        this.f5242py = serverLevel.random.nextInt(4, 10);
        Vec3 vec3M7850a = C1290xm.m7850a(serverLevel.random, this.f5243ae, 4);
        C0761ng c0761ngCreate = ((EntityType) C1230wX.f7056kZ.get()).create(serverLevel);
        if (c0761ngCreate != null && this.f5215b != null) {
            c0761ngCreate.m3440w(400);
            c0761ngCreate.mo3283a((Player) this.f5215b, 0.0f, new ItemStack((ItemLike) C1231wY.f7118o.get()), 0.0f, 0.0f);
            c0761ngCreate.setPos(vec3M7850a.x, serverLevel.getHeight(), vec3M7850a.z);
            serverLevel.addFreshEntity(c0761ngCreate);
            C0799oR.m3939a(set, (SoundEvent) C1280xc.f7650rd.get(), SoundSource.AMBIENT, 25.0f, this.f5243ae.add(new Vec3(64.0d, 0.0d, 64.0d).yRot((float) Math.toRadians(serverLevel.random.nextFloat() * 90.0f))));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0982rp
    /* JADX INFO: renamed from: a */
    void mo5419a(@NotNull Level level, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0982rp
    @NotNull
    /* JADX INFO: renamed from: l */
    public Component mo5420l() {
        return Component.translatable("bf.message.gamemode.radio.command.smokestrike");
    }
}
