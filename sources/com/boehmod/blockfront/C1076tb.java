package com.boehmod.blockfront;

import com.boehmod.bflib.common.RandomCollection;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.tb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tb.class */
public class C1076tb extends AbstractC1078td {

    /* JADX INFO: renamed from: qe */
    private int f5835qe = 400;

    /* JADX INFO: renamed from: gN */
    private boolean f5836gN = false;

    /* JADX INFO: renamed from: ag */
    private Vec3 f5837ag = Vec3.ZERO;

    /* JADX INFO: renamed from: a */
    private AbstractC0774ns f5838a = null;

    @Override // com.boehmod.blockfront.AbstractC1078td
    /* JADX INFO: renamed from: a */
    public void mo5947a(@NotNull C1018sX c1018sX, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull Level level, @NotNull Set<UUID> set) {
        int i = this.f5835qe;
        this.f5835qe = i - 1;
        if (i <= 0 && !this.f5836gN) {
            this.f5836gN = true;
            m5951b(c1018sX, level, set);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m5951b(C1018sX c1018sX, Level level, Set<UUID> set) {
        RandomCollection randomCollection = new RandomCollection();
        randomCollection.add(0.5d, (EntityType) C1307xu.f7601kG.get());
        randomCollection.add(0.5d, (EntityType) C1307xu.f7602kH.get());
        AbstractC0774ns abstractC0774nsCreate = ((EntityType) randomCollection.getRandom()).create(level);
        if (abstractC0774nsCreate != null) {
            abstractC0774nsCreate.teleportTo(this.f5837ag.x, this.f5837ag.y, this.f5837ag.z);
            abstractC0774nsCreate.mo3117e(c1018sX);
            level.addFreshEntity(abstractC0774nsCreate);
            this.f5838a = abstractC0774nsCreate;
        }
        C0875pn.m4370a(c1018sX, SoundEvents.WITHER_DEATH, SoundSource.AMBIENT);
        C0875pn.m4436a((AbstractC0863pb<?, ?, ?>) c1018sX, (Component) Component.translatable("bf.message.gamemode.ttt.randomat.nextbot.spawn").withStyle(ChatFormatting.GOLD), 80, m5954ar());
    }

    @Override // com.boehmod.blockfront.AbstractC1078td
    /* JADX INFO: renamed from: a */
    public void mo5948a(@NotNull C1018sX c1018sX, @NotNull Player player, @NotNull Level level, @NotNull Set<UUID> set) {
        this.f5837ag = player.position();
    }

    @Override // com.boehmod.blockfront.AbstractC1078td
    /* JADX INFO: renamed from: a */
    public void mo5949a(@NotNull C1018sX c1018sX, @NotNull Level level, @NotNull Set<UUID> set) {
        if (this.f5838a != null && this.f5838a.isAlive() && !this.f5838a.isRemoved()) {
            this.f5838a.discard();
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1078td
    @NotNull
    public String getName() {
        return "bf.message.gamemode.ttt.randomat.nextbot";
    }

    @Override // com.boehmod.blockfront.AbstractC1078td
    @NotNull
    /* JADX INFO: renamed from: t */
    public String mo5950t() {
        return "bf.message.gamemode.ttt.randomat.nextbot.desc";
    }
}
