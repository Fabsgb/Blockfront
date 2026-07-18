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

/* JADX INFO: renamed from: com.boehmod.blockfront.wh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wh.class */
public final class C1240wh extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: ch */
    @NotNull
    private final List<C1141uo> f7361ch;

    /* JADX INFO: renamed from: ak */
    @NotNull
    public static final CustomPacketPayload.Type<C1240wh> f7362ak;

    /* JADX INFO: renamed from: al */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1240wh> f7363al;

    /* JADX INFO: renamed from: jc */
    static final /* synthetic */ boolean f7364jc;

    public C1240wh(@NotNull List<C1141uo> list) {
        this.f7361ch = list;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1240wh.class), C1240wh.class, "blockBulletHits", "FIELD:Lcom/boehmod/blockfront/wh;->ch:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1240wh.class), C1240wh.class, "blockBulletHits", "FIELD:Lcom/boehmod/blockfront/wh;->ch:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1240wh.class, Object.class), C1240wh.class, "blockBulletHits", "FIELD:Lcom/boehmod/blockfront/wh;->ch:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: aL */
    public List<C1141uo> m7660aL() {
        return this.f7361ch;
    }

    static {
        f7364jc = !C1240wh.class.desiredAssertionStatus();
        f7362ak = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_bullet_collision_block"));
        f7363al = CustomPacketPayload.codec((v0, v1) -> {
            v0.m7658d(v1);
        }, C1240wh::new);
    }

    public C1240wh(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this((List<C1141uo>) C1291xn.m7877a(friendlyByteBuf));
    }

    /* JADX INFO: renamed from: d */
    public void m7658d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        C1291xn.m7878a(friendlyByteBuf, this.f7361ch);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f7362ak;
    }

    /* JADX INFO: renamed from: a */
    public static void m7659a(C1240wh c1240wh, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f7364jc && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        MinecraftServer minecraftServerM2514a = C0561js.m2514a();
        if (!f7364jc && minecraftServerM2514a == null) {
            throw new AssertionError("Minecraft server is null!");
        }
        ServerLevel level = minecraftServerM2514a.getLevel(Level.OVERWORLD);
        if (!f7364jc && level == null) {
            throw new AssertionError("Server level is null!");
        }
        Player player = iPayloadContext.player();
        C1105uE.m6097a(level, (LivingEntity) player, abstractC0563juM168a.mo2531a(player.getUUID()), c1240wh.f7361ch);
    }
}
