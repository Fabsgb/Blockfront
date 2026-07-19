package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nj.class */
public final class C0361nj extends AbstractC0362nk implements InterfaceC0364nm {
    private static final ResourceLocation dv = C0265jv.d("textures/misc/worldpoint/ammo.png");
    private static final Component ir = Component.translatable("bf.message.gamemode.ammo.box.refill");

    public C0361nj(EntityType<? extends C0361nj> entityType, Level level) {
        super(entityType, level);
    }

    @Override // com.boehmod.blockfront.AbstractC0362nk, com.boehmod.blockfront.C0371nt
    protected DeferredHolder<SoundEvent, SoundEvent> a(@NotNull SoundType soundType) {
        return C0624xc.tX;
    }

    @Override // com.boehmod.blockfront.mA
    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.AbstractC0362nk
    void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerPlayer serverPlayer, @NotNull oF<?, ?, ?> oFVar, @NotNull oI<?> oIVar) {
        boolean z = false;
        for (ItemStack itemStack : serverPlayer.getInventory().items) {
            if (!itemStack.isEmpty() && oR.b(itemStack)) {
                z = true;
            }
        }
        if (z) {
            oR.a(serverPlayer, (Component) Component.literal(String.valueOf((char) 57353)).withColor(ColorReferences.COLOR_WHITE).append(" "), ir);
            oR.a(serverPlayer, (SoundEvent) C0624xc.tY.get(), SoundSource.NEUTRAL);
        }
    }

    @Override // com.boehmod.blockfront.C0371nt
    public int aH() {
        return 0;
    }

    @Override // com.boehmod.blockfront.InterfaceC0364nm
    @NotNull
    public ResourceLocation getWaypointTexture() {
        return dv;
    }
}
