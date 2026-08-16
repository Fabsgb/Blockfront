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

/* JADX INFO: renamed from: com.boehmod.blockfront.nF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nF.class */
public final class C0735nF extends AbstractC0736nG implements InterfaceC0738nI {

    /* JADX INFO: renamed from: dt */
    private static final ResourceLocation f4048dt = C0532jO.m2378d("textures/misc/worldpoint/ammo.png");

    /* JADX INFO: renamed from: iD */
    private static final Component f4049iD = Component.translatable("bf.message.gamemode.ammo.box.refill");

    public C0735nF(EntityType<? extends C0735nF> entityType, Level level) {
        super(entityType, level);
    }

    @Override // com.boehmod.blockfront.AbstractC0736nG, com.boehmod.blockfront.C0745nP
    /* JADX INFO: renamed from: a */
    protected DeferredHolder<SoundEvent, SoundEvent> mo3366a(@NotNull SoundType soundType) {
        return C1312xz.f8211tY;
    }

    @Override // com.boehmod.blockfront.AbstractC0699mW
    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.AbstractC0736nG
    /* JADX INFO: renamed from: a */
    void mo3367a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerPlayer serverPlayer, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0866pe<?> abstractC0866pe) {
        boolean z = false;
        for (ItemStack itemStack : serverPlayer.getInventory().items) {
            if (!itemStack.isEmpty() && C0875pn.m4468b(itemStack)) {
                z = true;
            }
        }
        if (z) {
            C0875pn.m4409a(serverPlayer, (Component) Component.literal(String.valueOf((char) 57353)).withColor(ColorReferences.COLOR_WHITE).append(" "), f4049iD);
            C0875pn.m4364a(serverPlayer, (SoundEvent) C1312xz.f8212tZ.get(), SoundSource.NEUTRAL);
        }
    }

    @Override // com.boehmod.blockfront.C0745nP
    /* JADX INFO: renamed from: aW */
    public int mo3368aW() {
        return 0;
    }

    @Override // com.boehmod.blockfront.InterfaceC0738nI
    @NotNull
    public ResourceLocation getWaypointTexture() {
        return f4048dt;
    }
}
