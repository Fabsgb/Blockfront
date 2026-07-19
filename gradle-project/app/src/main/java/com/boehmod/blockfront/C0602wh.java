package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wh.class */
public final class C0602wh extends Record implements CustomPacketPayload {

    @NotNull
    private final List<C0555uo> ch;

    @NotNull
    public static final CustomPacketPayload.Type<C0602wh> ak;

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0602wh> al;
    static final /* synthetic */ boolean jc;

    public C0602wh(@NotNull List<C0555uo> list) {
        this.ch = list;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0602wh.class), C0602wh.class, "blockBulletHits", "FIELD:Lcom/boehmod/blockfront/wh;->ch:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0602wh.class), C0602wh.class, "blockBulletHits", "FIELD:Lcom/boehmod/blockfront/wh;->ch:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0602wh.class, Object.class), C0602wh.class, "blockBulletHits", "FIELD:Lcom/boehmod/blockfront/wh;->ch:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public List<C0555uo> aL() {
        return this.ch;
    }

    static {
        jc = !C0602wh.class.desiredAssertionStatus();
        ak = new CustomPacketPayload.Type<>(C0265jv.d("packet_bullet_collision_block"));
        al = CustomPacketPayload.codec((v0, v1) -> {
            v0.d(v1);
        }, C0602wh::new);
    }

    public C0602wh(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this((List<C0555uo>) C0635xn.m1694a(friendlyByteBuf));
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        C0635xn.a(friendlyByteBuf, this.ch);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return ak;
    }

    public static void a(C0602wh c0602wh, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!jc && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        MinecraftServer minecraftServerA = C0262js.a();
        if (!jc && minecraftServerA == null) {
            throw new AssertionError("Minecraft server is null!");
        }
        ServerLevel level = minecraftServerA.getLevel(Level.OVERWORLD);
        if (!jc && level == null) {
            throw new AssertionError("Server level is null!");
        }
        Player player = iPayloadContext.player();
        uE.a(level, (LivingEntity) player, abstractC0264juM166a.mo604a(player.getUUID()), c0602wh.ch);
    }
}
