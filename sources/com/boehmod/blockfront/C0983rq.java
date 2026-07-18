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

/* JADX INFO: renamed from: com.boehmod.blockfront.rq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rq.class */
public final class C0983rq extends AbstractC0989rw {

    /* JADX INFO: renamed from: pt */
    private static final int f5219pt = 3;

    /* JADX INFO: renamed from: pu */
    private static final int f5220pu = 15;

    /* JADX INFO: renamed from: pv */
    private static final int f5221pv = 10;

    /* JADX INFO: renamed from: pw */
    private static final int f5222pw = 60;

    /* JADX INFO: renamed from: px */
    public static final int f5223px = 64;

    /* JADX INFO: renamed from: lC */
    public static final float f5224lC = 90.0f;

    /* JADX INFO: renamed from: pr */
    private int f5225pr;

    /* JADX INFO: renamed from: py */
    private int f5226py;

    public C0983rq(@NotNull ServerPlayer serverPlayer, @NotNull Vec3 vec3, int i, int i2) {
        super(serverPlayer, vec3, i, i2);
        this.f5225pr = 60;
        this.f5226py = 0;
    }

    @Override // com.boehmod.blockfront.AbstractC0982rp
    /* JADX INFO: renamed from: c */
    void mo5417c(@NotNull ServerLevel serverLevel, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0982rp
    /* JADX INFO: renamed from: d */
    void mo5418d(@NotNull ServerLevel serverLevel, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Set<UUID> set) {
        int i = this.f5225pr;
        this.f5225pr = i - 1;
        if (i > 0) {
            return;
        }
        int i2 = this.f5226py;
        this.f5226py = i2 - 1;
        if (i2 > 0) {
            return;
        }
        this.f5226py = serverLevel.random.nextInt(3, 15);
        Vec3 vec3M7850a = C1290xm.m7850a(serverLevel.random, this.f5243ae, 10);
        C0756nb c0756nbCreate = ((EntityType) C1230wX.f7054kX.get()).create(serverLevel);
        if (c0756nbCreate != null && this.f5215b != null) {
            c0756nbCreate.mo3283a((Player) this.f5215b, 0.0f, new ItemStack((ItemLike) C1231wY.f7118o.get()), 0.0f, 0.0f);
            c0756nbCreate.setPos(vec3M7850a.x, serverLevel.getHeight(), vec3M7850a.z);
            serverLevel.addFreshEntity(c0756nbCreate);
            Vec3 vec3Add = this.f5243ae.add(new Vec3(64.0d, 0.0d, 64.0d).yRot((float) Math.toRadians(serverLevel.random.nextFloat() * 90.0f)));
            C0799oR.m3939a(set, (SoundEvent) C1280xc.f7650rd.get(), SoundSource.AMBIENT, 25.0f, vec3Add);
            C0799oR.m3939a(set, (SoundEvent) C1280xc.f7651re.get(), SoundSource.AMBIENT, 25.0f, vec3Add);
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
        return Component.translatable("bf.message.gamemode.radio.command.airstrike");
    }
}
