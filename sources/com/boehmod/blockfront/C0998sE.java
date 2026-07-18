package com.boehmod.blockfront;

import com.boehmod.bflib.common.RandomCollection;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.sE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sE.class */
public class C0998sE extends AbstractC1000sG {

    /* JADX INFO: renamed from: of */
    private int f5271of = 400;

    /* JADX INFO: renamed from: gt */
    private boolean f5272gt = false;

    /* JADX INFO: renamed from: af */
    private Vec3 f5273af = Vec3.ZERO;

    /* JADX INFO: renamed from: a */
    private AbstractC0698mW f5274a = null;

    @Override // com.boehmod.blockfront.AbstractC1000sG
    /* JADX INFO: renamed from: a */
    public void mo5459a(@NotNull C0994sA c0994sA, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull Level level, @NotNull Set<UUID> set) {
        int i = this.f5271of;
        this.f5271of = i - 1;
        if (i <= 0 && !this.f5272gt) {
            this.f5272gt = true;
            m5463b(c0994sA, level, set);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m5463b(C0994sA c0994sA, Level level, Set<UUID> set) {
        RandomCollection randomCollection = new RandomCollection();
        randomCollection.add(0.5d, (EntityType) C1230wX.f7036kG.get());
        randomCollection.add(0.5d, (EntityType) C1230wX.f7037kH.get());
        AbstractC0698mW abstractC0698mWCreate = ((EntityType) randomCollection.getRandom()).create(level);
        if (abstractC0698mWCreate != null) {
            abstractC0698mWCreate.teleportTo(this.f5273af.x, this.f5273af.y, this.f5273af.z);
            abstractC0698mWCreate.mo3282e(c0994sA);
            level.addFreshEntity(abstractC0698mWCreate);
            this.f5274a = abstractC0698mWCreate;
        }
        C0799oR.m3934a(c0994sA, SoundEvents.WITHER_DEATH, SoundSource.AMBIENT);
        C0799oR.m4000a((AbstractC0787oF<?, ?, ?>) c0994sA, (Component) Component.translatable("bf.message.gamemode.ttt.randomat.nextbot.spawn").withStyle(ChatFormatting.GOLD), 80, m5466ak());
    }

    @Override // com.boehmod.blockfront.AbstractC1000sG
    /* JADX INFO: renamed from: a */
    public void mo5460a(@NotNull C0994sA c0994sA, @NotNull Player player, @NotNull Level level, @NotNull Set<UUID> set) {
        this.f5273af = player.position();
    }

    @Override // com.boehmod.blockfront.AbstractC1000sG
    /* JADX INFO: renamed from: a */
    public void mo5461a(@NotNull C0994sA c0994sA, @NotNull Level level, @NotNull Set<UUID> set) {
        if (this.f5274a != null && this.f5274a.isAlive() && !this.f5274a.isRemoved()) {
            this.f5274a.discard();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1000sG
    @NotNull
    public String getName() {
        return "bf.message.gamemode.ttt.randomat.nextbot";
    }

    @Override // com.boehmod.blockfront.AbstractC1000sG
    @NotNull
    /* JADX INFO: renamed from: p */
    public String mo5462p() {
        return "bf.message.gamemode.ttt.randomat.nextbot.desc";
    }
}
