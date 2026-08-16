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

/* JADX INFO: renamed from: com.boehmod.blockfront.rN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rN.class */
public final class C0955rN extends AbstractC0961rT {

    /* JADX INFO: renamed from: rs */
    private static final int f5323rs = 3;

    /* JADX INFO: renamed from: rt */
    private static final int f5324rt = 15;

    /* JADX INFO: renamed from: ru */
    private static final int f5325ru = 10;

    /* JADX INFO: renamed from: rv */
    private static final int f5326rv = 60;

    /* JADX INFO: renamed from: rw */
    public static final int f5327rw = 64;

    /* JADX INFO: renamed from: mB */
    public static final float f5328mB = 90.0f;

    /* JADX INFO: renamed from: rq */
    private int f5329rq;

    /* JADX INFO: renamed from: rx */
    private int f5330rx;

    public C0955rN(@NotNull ServerPlayer serverPlayer, @NotNull Vec3 vec3, int i, int i2) {
        super(serverPlayer, vec3, i, i2);
        this.f5329rq = 60;
        this.f5330rx = 0;
    }

    @Override // com.boehmod.blockfront.AbstractC0954rM
    /* JADX INFO: renamed from: c */
    void mo5293c(@NotNull ServerLevel serverLevel, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0954rM
    /* JADX INFO: renamed from: d */
    void mo5294d(@NotNull ServerLevel serverLevel, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Set<UUID> set) {
        int i = this.f5329rq;
        this.f5329rq = i - 1;
        if (i > 0) {
            return;
        }
        int i2 = this.f5330rx;
        this.f5330rx = i2 - 1;
        if (i2 > 0) {
            return;
        }
        this.f5330rx = serverLevel.random.nextInt(3, 15);
        Vec3 vec3M7177a = C1270xJ.m7177a(serverLevel.random, this.f5347af, 10);
        C0779nx c0779nxCreate = ((EntityType) C1307xu.f7619kX.get()).create(serverLevel);
        if (c0779nxCreate != null && this.f5319c != null) {
            c0779nxCreate.mo3118a((Player) this.f5319c, 0.0f, new ItemStack((ItemLike) C1308xv.f7683o.get()), 0.0f, 0.0f);
            c0779nxCreate.setPos(vec3M7177a.x, serverLevel.getHeight(), vec3M7177a.z);
            serverLevel.addFreshEntity(c0779nxCreate);
            C0875pn.m4375a(set, (SoundEvent) C1312xz.f8062rf.get(), SoundSource.AMBIENT, 25.0f, this.f5347af.add(new Vec3(64.0d, 0.0d, 64.0d).yRot((float) Math.toRadians(serverLevel.random.nextFloat() * 90.0f))));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0954rM
    /* JADX INFO: renamed from: a */
    void mo5295a(@NotNull Level level, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0954rM
    @NotNull
    /* JADX INFO: renamed from: l */
    public Component mo5296l() {
        return Component.translatable("bf.message.gamemode.radio.command.airstrike");
    }
}
