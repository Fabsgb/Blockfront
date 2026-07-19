package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vn.class */
public final class C0581vn extends Record implements CustomPacketPayload {

    @NotNull
    private final UUID I;

    @NotNull
    public static final CustomPacketPayload.Type<C0581vn> r = new CustomPacketPayload.Type<>(C0265jv.d("packet_delete_map_effect"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0581vn> s = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0581vn::new);

    public C0581vn(@NotNull UUID uuid) {
        this.I = uuid;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0581vn.class), C0581vn.class, "mapEffectID", "FIELD:Lcom/boehmod/blockfront/vn;->I:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0581vn.class), C0581vn.class, "mapEffectID", "FIELD:Lcom/boehmod/blockfront/vn;->I:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0581vn.class, Object.class), C0581vn.class, "mapEffectID", "FIELD:Lcom/boehmod/blockfront/vn;->I:Ljava/util/UUID;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public UUID l() {
        return this.I;
    }

    public C0581vn(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(new UUID(friendlyByteBuf.readLong(), friendlyByteBuf.readLong()));
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeLong(this.I.getMostSignificantBits());
        friendlyByteBuf.writeLong(this.I.getLeastSignificantBits());
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return r;
    }

    public static void a(C0581vn c0581vn, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a;
        oF<?, ?, ?> oFVarA;
        sY sYVarM767a;
        pA pAVarA;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) wY.z.get();
            if ((mainHandItem.getItem() != item && offhandItem.getItem() != item) || (abstractC0264juM166a = C0002a.a().m166a()) == null || (oFVarA = abstractC0264juM166a.a(player)) == null || (pAVarA = (sYVarM767a = oFVarA.m767a()).a(c0581vn.I)) == null) {
                return;
            }
            if (sYVarM767a.p(c0581vn.I)) {
                C0280kj c0280kjM1103a = sYVarM767a.m1103a(c0581vn.I);
                if (c0280kjM1103a != null) {
                    sYVarM767a.b(c0280kjM1103a);
                    jO jOVarC = jO.c();
                    jK jKVarA = jOVarC.a();
                    if (jKVarA != null) {
                        jKVarA.i(oFVarA.m751a().getName() + ".json");
                    }
                    jM jMVarA = jOVarC.a(sX.class);
                    if (jMVarA != null) {
                        jMVarA.j(oFVarA.m751a().getName());
                    }
                }
            } else {
                sYVarM767a.b(pAVarA);
            }
            sYVarM767a.da();
            C0582vo.a(new C0609wo(oFVarA, true), oFVarA);
            MinecraftServer minecraftServerA = C0262js.a();
            if (minecraftServerA != null) {
                jN.a(oFVarA, minecraftServerA.overworld(), null);
            }
        }
    }
}
