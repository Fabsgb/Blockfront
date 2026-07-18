package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0182b;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.wx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wx.class */
public final class C1256wx extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: jk */
    private final boolean f7436jk;

    /* JADX INFO: renamed from: aA */
    @NotNull
    public static final CustomPacketPayload.Type<C1256wx> f7437aA = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_grenade_cook_start"));

    /* JADX INFO: renamed from: aB */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1256wx> f7438aB = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7729d(v1);
    }, C1256wx::new);

    public C1256wx(boolean z) {
        this.f7436jk = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1256wx.class), C1256wx.class, "near", "FIELD:Lcom/boehmod/blockfront/wx;->jk:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1256wx.class), C1256wx.class, "near", "FIELD:Lcom/boehmod/blockfront/wx;->jk:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1256wx.class, Object.class), C1256wx.class, "near", "FIELD:Lcom/boehmod/blockfront/wx;->jk:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: dg */
    public boolean m7731dg() {
        return this.f7436jk;
    }

    public C1256wx(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readBoolean());
    }

    /* JADX INFO: renamed from: d */
    public void m7729d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.f7436jk);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f7437aA;
    }

    /* JADX INFO: renamed from: a */
    public static void m7730a(C1256wx c1256wx, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a;
        C0732nD c0732nDM3535a;
        Entity entityPlayer = iPayloadContext.player();
        if (entityPlayer instanceof ServerPlayer) {
            Entity entity = (ServerPlayer) entityPlayer;
            Entity vehicle = entity.getVehicle();
            if ((vehicle instanceof AbstractC0779ny) && (c0732nDM3535a = ((AbstractC0779ny) vehicle).m3535a(entity)) != null && c0732nDM3535a.f3938fr) {
                return;
            }
            ItemStack mainHandItem = entity.getMainHandItem();
            if (mainHandItem.isEmpty()) {
                return;
            }
            Item item = mainHandItem.getItem();
            if (!(item instanceof C1136uj)) {
                return;
            }
            C1136uj c1136uj = (C1136uj) item;
            if (c1136uj.mo5957ck() && (abstractC0563juM168a = C0029a.m164a().m168a()) != null) {
                AbstractC0182b abstractC0182bM1136a = abstractC0563juM168a.m2528a().m1136a((Player) entity);
                if (abstractC0182bM1136a instanceof C1274xO) {
                    C1274xO c1274xO = (C1274xO) abstractC0182bM1136a;
                    if (c1274xO.m1093dm() || C0799oR.m4052a((Player) entity, (AbstractC0182b<?, ?, ?, ?>) c1274xO)) {
                        return;
                    }
                    Level level = entity.level();
                    c1274xO.m7786a().m7776a(c1136uj, c1256wx.f7436jk, level.getGameTime());
                    Vec3 vec3Position = entity.position();
                    level.playSound((Player) null, vec3Position.x, vec3Position.y, vec3Position.z, c1136uj.m6265A(), SoundSource.PLAYERS, 1.0f, (float) (0.8999999761581421d + (0.20000000298023224d * Math.random())));
                }
            }
        }
    }
}
