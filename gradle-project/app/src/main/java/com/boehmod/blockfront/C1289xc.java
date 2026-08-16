package com.boehmod.blockfront;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xc.class */
public final class C1289xc implements CustomPacketPayload {

    /* JADX INFO: renamed from: aF */
    @NotNull
    public static final CustomPacketPayload.Type<C1289xc> f6928aF = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_gun_switch_fire_mode"));

    /* JADX INFO: renamed from: aG */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1289xc> f6929aG = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7320d(v1);
    }, C1289xc::new);

    public C1289xc() {
    }

    public C1289xc(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    /* JADX INFO: renamed from: d */
    public void m7320d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6928aF;
    }

    /* JADX INFO: renamed from: a */
    public static void m7321a(C1289xc c1289xc, @NotNull IPayloadContext iPayloadContext) {
        ItemStack mainHandItem = iPayloadContext.player().getMainHandItem();
        Item item = mainHandItem.getItem();
        if (item instanceof C1117uP) {
            C1117uP c1117uP = (C1117uP) item;
            if (c1117uP.m6365a().length <= 1 || C1117uP.m6275f(mainHandItem)) {
                return;
            }
            C1117uP.m6320f(mainHandItem, (C1117uP.m6319g(mainHandItem) + 1) % c1117uP.m6365a().length);
        }
    }
}
