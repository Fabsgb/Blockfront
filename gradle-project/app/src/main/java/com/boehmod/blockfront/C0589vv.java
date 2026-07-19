package com.boehmod.blockfront;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vv.class */
public final class C0589vv implements CustomPacketPayload {

    @NotNull
    public static final CustomPacketPayload.Type<C0589vv> y;

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0589vv> z;
    static final /* synthetic */ boolean iI;

    static {
        iI = !C0589vv.class.desiredAssertionStatus();
        y = new CustomPacketPayload.Type<>(C0265jv.d("packet_fire_entity"));
        z = CustomPacketPayload.codec((v0, v1) -> {
            v0.d(v1);
        }, C0589vv::new);
    }

    public C0589vv() {
    }

    public C0589vv(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return y;
    }

    public static void a(C0589vv c0589vv, @NotNull IPayloadContext iPayloadContext) {
        Player player = iPayloadContext.player();
        ItemStack mainHandItem = player.getMainHandItem();
        if (mainHandItem.isEmpty()) {
            return;
        }
        Item item = mainHandItem.getItem();
        if (item instanceof C0558ur) {
            C0558ur c0558ur = (C0558ur) item;
            AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
            if (!iI && abstractC0264juM166a == null) {
                throw new AssertionError("Mod manager is null");
            }
            com.boehmod.blockfront.common.player.c<?> cVarM531a = abstractC0264juM166a.m531a();
            if (c0558ur.m1210a().m1177a() == uU.ENTITY) {
                c0558ur.a(cVarM531a, player.level(), player, mainHandItem);
            }
        }
    }
}
