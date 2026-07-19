package com.boehmod.blockfront;

import com.boehmod.bflib.common.RandomCollection;
import java.util.Set;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sE.class */
public class sE extends sG {
    private int of = 400;
    private boolean gt = false;
    private Vec3 af = Vec3.ZERO;
    private mW a = null;

    @Override // com.boehmod.blockfront.sG
    public void a(@NotNull sA sAVar, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull Level level, @NotNull Set<UUID> set) {
        int i = this.of;
        this.of = i - 1;
        if (i <= 0 && !this.gt) {
            this.gt = true;
            b(sAVar, level, set);
        }
    }

    private void b(sA sAVar, Level level, Set<UUID> set) {
        RandomCollection randomCollection = new RandomCollection();
        randomCollection.add(0.5d, (EntityType) wX.kG.get());
        randomCollection.add(0.5d, (EntityType) wX.kH.get());
        mW mWVarCreate = ((EntityType) randomCollection.getRandom()).create(level);
        if (mWVarCreate != null) {
            mWVarCreate.teleportTo(this.af.x, this.af.y, this.af.z);
            mWVarCreate.e(sAVar);
            level.addFreshEntity(mWVarCreate);
            this.a = mWVarCreate;
        }
        oR.a(sAVar, SoundEvents.WITHER_DEATH, SoundSource.AMBIENT);
        oR.a((oF<?, ?, ?>) sAVar, (Component) Component.translatable("bf.message.gamemode.ttt.randomat.nextbot.spawn").withStyle(ChatFormatting.GOLD), 80, ak());
    }

    @Override // com.boehmod.blockfront.sG
    public void a(@NotNull sA sAVar, @NotNull Player player, @NotNull Level level, @NotNull Set<UUID> set) {
        this.af = player.position();
    }

    @Override // com.boehmod.blockfront.sG
    public void a(@NotNull sA sAVar, @NotNull Level level, @NotNull Set<UUID> set) {
        if (this.a != null && this.a.isAlive() && !this.a.isRemoved()) {
            this.a.discard();
        }
    }

    @Override // com.boehmod.blockfront.sG
    @NotNull
    public String getName() {
        return "bf.message.gamemode.ttt.randomat.nextbot";
    }

    @Override // com.boehmod.blockfront.sG
    @NotNull
    public String p() {
        return "bf.message.gamemode.ttt.randomat.nextbot.desc";
    }
}
