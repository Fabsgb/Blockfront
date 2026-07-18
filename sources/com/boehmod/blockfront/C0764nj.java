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

/* JADX INFO: renamed from: com.boehmod.blockfront.nj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nj.class */
public final class C0764nj extends AbstractC0765nk implements InterfaceC0767nm {

    /* JADX INFO: renamed from: dv */
    private static final ResourceLocation f4093dv = C0564jv.m2555d("textures/misc/worldpoint/ammo.png");

    /* JADX INFO: renamed from: ir */
    private static final Component f4094ir = Component.translatable("bf.message.gamemode.ammo.box.refill");

    public C0764nj(EntityType<? extends C0764nj> entityType, Level level) {
        super(entityType, level);
    }

    @Override // com.boehmod.blockfront.AbstractC0765nk, com.boehmod.blockfront.C0774nt
    /* JADX INFO: renamed from: a */
    protected DeferredHolder<SoundEvent, SoundEvent> mo3443a(@NotNull SoundType soundType) {
        return C1280xc.f7800tX;
    }

    @Override // com.boehmod.blockfront.AbstractC0676mA
    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }

    @Override // com.boehmod.blockfront.AbstractC0765nk
    /* JADX INFO: renamed from: a */
    void mo3444a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerPlayer serverPlayer, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0790oI<?> abstractC0790oI) {
        boolean z = false;
        for (ItemStack itemStack : serverPlayer.getInventory().items) {
            if (!itemStack.isEmpty() && C0799oR.m4032b(itemStack)) {
                z = true;
            }
        }
        if (z) {
            C0799oR.m3973a(serverPlayer, (Component) Component.literal(String.valueOf((char) 57353)).withColor(ColorReferences.COLOR_WHITE).append(" "), f4094ir);
            C0799oR.m3928a(serverPlayer, (SoundEvent) C1280xc.f7801tY.get(), SoundSource.NEUTRAL);
        }
    }

    @Override // com.boehmod.blockfront.C0774nt
    /* JADX INFO: renamed from: aH */
    public int mo3445aH() {
        return 0;
    }

    @Override // com.boehmod.blockfront.InterfaceC0767nm
    @NotNull
    public ResourceLocation getWaypointTexture() {
        return f4093dv;
    }
}
