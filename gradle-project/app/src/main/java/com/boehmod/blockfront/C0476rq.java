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

/* JADX INFO: renamed from: com.boehmod.blockfront.rq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rq.class */
public final class C0476rq extends AbstractC0482rw {
    private static final int pt = 3;
    private static final int pu = 15;
    private static final int pv = 10;
    private static final int pw = 60;
    public static final int px = 64;
    public static final float lC = 90.0f;
    private int pr;
    private int py;

    public C0476rq(@NotNull ServerPlayer serverPlayer, @NotNull Vec3 vec3, int i, int i2) {
        super(serverPlayer, vec3, i, i2);
        this.pr = 60;
        this.py = 0;
    }

    @Override // com.boehmod.blockfront.AbstractC0475rp
    void c(@NotNull ServerLevel serverLevel, @NotNull oF<?, ?, ?> oFVar, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0475rp
    void d(@NotNull ServerLevel serverLevel, @NotNull oF<?, ?, ?> oFVar, @NotNull Set<UUID> set) {
        int i = this.pr;
        this.pr = i - 1;
        if (i > 0) {
            return;
        }
        int i2 = this.py;
        this.py = i2 - 1;
        if (i2 > 0) {
            return;
        }
        this.py = serverLevel.random.nextInt(3, 15);
        Vec3 vec3A = C0634xm.a(serverLevel.random, this.ae, 10);
        C0353nb c0353nbCreate = ((EntityType) wX.kX.get()).create(serverLevel);
        if (c0353nbCreate != null && this.b != null) {
            c0353nbCreate.a((Player) this.b, 0.0f, new ItemStack((ItemLike) wY.o.get()), 0.0f, 0.0f);
            c0353nbCreate.setPos(vec3A.x, serverLevel.getHeight(), vec3A.z);
            serverLevel.addFreshEntity(c0353nbCreate);
            Vec3 vec3Add = this.ae.add(new Vec3(64.0d, 0.0d, 64.0d).yRot((float) Math.toRadians(serverLevel.random.nextFloat() * 90.0f)));
            oR.a(set, (SoundEvent) C0624xc.rd.get(), SoundSource.AMBIENT, 25.0f, vec3Add);
            oR.a(set, (SoundEvent) C0624xc.re.get(), SoundSource.AMBIENT, 25.0f, vec3Add);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0475rp
    void a(@NotNull Level level, @NotNull oF<?, ?, ?> oFVar, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0475rp
    @NotNull
    public Component l() {
        return Component.translatable("bf.message.gamemode.radio.command.airstrike");
    }
}
