package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183c;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vv.class */
public final class C1201vv implements CustomPacketPayload {

    /* JADX INFO: renamed from: y */
    @NotNull
    public static final CustomPacketPayload.Type<C1201vv> f6317y;

    /* JADX INFO: renamed from: z */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1201vv> f6318z;

    /* JADX INFO: renamed from: iI */
    static final /* synthetic */ boolean f6319iI;

    static {
        f6319iI = !C1201vv.class.desiredAssertionStatus();
        f6317y = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_fire_entity"));
        f6318z = CustomPacketPayload.codec((v0, v1) -> {
            v0.m6693d(v1);
        }, C1201vv::new);
    }

    public C1201vv() {
    }

    public C1201vv(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    /* JADX INFO: renamed from: d */
    public void m6693d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6317y;
    }

    /* JADX INFO: renamed from: a */
    public static void m6694a(C1201vv c1201vv, @NotNull IPayloadContext iPayloadContext) {
        Player player = iPayloadContext.player();
        ItemStack mainHandItem = player.getMainHandItem();
        if (mainHandItem.isEmpty()) {
            return;
        }
        Item item = mainHandItem.getItem();
        if (item instanceof C1144ur) {
            C1144ur c1144ur = (C1144ur) item;
            AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
            if (!f6319iI && abstractC0563juM168a == null) {
                throw new AssertionError("Mod manager is null");
            }
            AbstractC0183c<?> abstractC0183cM2528a = abstractC0563juM168a.m2528a();
            if (c1144ur.m6347a().m6224a() == EnumC1121uU.ENTITY) {
                c1144ur.m6387a(abstractC0183cM2528a, player.level(), player, mainHandItem);
            }
        }
    }
}
