package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wx.class */
public final class C0618wx extends Record implements CustomPacketPayload {
    private final boolean jk;

    @NotNull
    public static final CustomPacketPayload.Type<C0618wx> aA = new CustomPacketPayload.Type<>(C0265jv.d("packet_grenade_cook_start"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0618wx> aB = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0618wx::new);

    public C0618wx(boolean z) {
        this.jk = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0618wx.class), C0618wx.class, "near", "FIELD:Lcom/boehmod/blockfront/wx;->jk:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0618wx.class), C0618wx.class, "near", "FIELD:Lcom/boehmod/blockfront/wx;->jk:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0618wx.class, Object.class), C0618wx.class, "near", "FIELD:Lcom/boehmod/blockfront/wx;->jk:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public boolean dg() {
        return this.jk;
    }

    public C0618wx(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readBoolean());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.jk);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return aA;
    }

    public static void a(C0618wx c0618wx, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a;
        nD nDVarA;
        Entity entityPlayer = iPayloadContext.player();
        if (entityPlayer instanceof ServerPlayer) {
            Entity entity = (ServerPlayer) entityPlayer;
            Entity vehicle = entity.getVehicle();
            if ((vehicle instanceof AbstractC0376ny) && (nDVarA = ((AbstractC0376ny) vehicle).a(entity)) != null && nDVarA.fr) {
                return;
            }
            ItemStack mainHandItem = entity.getMainHandItem();
            if (mainHandItem.isEmpty()) {
                return;
            }
            Item item = mainHandItem.getItem();
            if (!(item instanceof C0550uj)) {
                return;
            }
            C0550uj c0550uj = (C0550uj) item;
            if (c0550uj.ck() && (abstractC0264juM166a = C0002a.a().m166a()) != null) {
                com.boehmod.blockfront.common.player.b bVarM305a = abstractC0264juM166a.m531a().m305a((Player) entity);
                if (bVarM305a instanceof xO) {
                    xO xOVar = (xO) bVarM305a;
                    if (xOVar.dm() || oR.a((Player) entity, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) xOVar)) {
                        return;
                    }
                    Level level = entity.level();
                    xOVar.m1677a().a(c0550uj, c0618wx.jk, level.getGameTime());
                    Vec3 vec3Position = entity.position();
                    level.playSound((Player) null, vec3Position.x, vec3Position.y, vec3Position.z, c0550uj.A(), SoundSource.PLAYERS, 1.0f, (float) (0.8999999761581421d + (0.20000000298023224d * Math.random())));
                }
            }
        }
    }
}
