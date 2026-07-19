package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tT.class */
public final class tT extends AbstractC0542ub {
    private static final int rL = 100;
    private static final float mK = 0.75f;

    public tT(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.AbstractC0542ub
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull Player player, @NotNull AbstractC0542ub abstractC0542ub, @NotNull ItemStack itemStack) {
        UUID uuid = player.getUUID();
        Object objMo604a = abstractC0264ju.mo604a(uuid);
        if (objMo604a instanceof qK) {
            qK qKVar = (qK) objMo604a;
            mB mBVar = (mB) oR.a((Level) serverLevel, (Entity) player, mB.class, 0.75f);
            if (mBVar != null && !mBVar.aD() && qKVar.a((Level) serverLevel, player, mBVar) && (player instanceof ServerPlayer)) {
                mBVar.bv();
                qKVar.a(mBVar, (ServerPlayer) player, uuid);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.boehmod.blockfront.AbstractC0542ub
    public boolean a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull Level level, @NotNull Player player, @NotNull AbstractC0542ub abstractC0542ub, @NotNull ItemStack itemStack) {
        if (Minecraft.getInstance().player == null) {
            return false;
        }
        mB mBVar = (mB) oR.a(level, (Entity) player, mB.class, 0.75f);
        if (oFVar instanceof qK) {
            return (mBVar == null || mBVar.aD() || !((qK) oFVar).a(level, player, mBVar)) ? false : true;
        }
        return mBVar != null;
    }

    @Override // com.boehmod.blockfront.AbstractC0542ub, com.boehmod.blockfront.tC
    public int bU() {
        return 100;
    }

    @Override // com.boehmod.blockfront.AbstractC0542ub, com.boehmod.blockfront.tC
    @NotNull
    public String as() {
        return "bf.message.bomb.defusal.kit.inspecting";
    }

    @Override // com.boehmod.blockfront.AbstractC0542ub, com.boehmod.blockfront.tC
    public int getColor() {
        return ColorReferences.COLOR_TEAM_ALLIES;
    }

    @Override // com.boehmod.blockfront.AbstractC0542ub, com.boehmod.blockfront.tC
    @NotNull
    public ResourceLocation getIcon() {
        return C0025aw.o;
    }

    @Override // com.boehmod.blockfront.AbstractC0542ub
    public int bW() {
        return 20;
    }

    @Override // com.boehmod.blockfront.AbstractC0542ub
    @NotNull
    public SoundEvent x() {
        return SoundEvents.SNOW_GOLEM_SHEAR;
    }
}
