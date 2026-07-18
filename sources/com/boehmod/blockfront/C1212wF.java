package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183c;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wF.class */
public final class C1212wF implements CustomPacketPayload {

    /* JADX INFO: renamed from: aI */
    @NotNull
    public static final CustomPacketPayload.Type<C1212wF> f6364aI;

    /* JADX INFO: renamed from: aJ */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1212wF> f6365aJ;

    /* JADX INFO: renamed from: jr */
    static final /* synthetic */ boolean f6366jr;

    static {
        f6366jr = !C1212wF.class.desiredAssertionStatus();
        f6364aI = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_gun_trigger"));
        f6365aJ = CustomPacketPayload.codec((v0, v1) -> {
            v0.m6732d(v1);
        }, C1212wF::new);
    }

    public C1212wF() {
    }

    public C1212wF(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    /* JADX INFO: renamed from: d */
    public void m6732d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6364aI;
    }

    /* JADX INFO: renamed from: a */
    public static void m6733a(C1212wF c1212wF, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f6366jr && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0183c abstractC0183cM2528a = abstractC0563juM168a.m2528a();
        LivingEntity livingEntityPlayer = iPayloadContext.player();
        if (abstractC0183cM2528a.m1136a((Player) livingEntityPlayer).m1093dm()) {
            return;
        }
        ItemStack selected = livingEntityPlayer.getInventory().getSelected();
        if (selected.isEmpty()) {
            return;
        }
        Item item = selected.getItem();
        if (item instanceof C1144ur) {
            ((C1144ur) item).m6386a(selected, livingEntityPlayer.level(), livingEntityPlayer);
        }
    }
}
