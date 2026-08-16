package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.wV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wV.class */
public final class C1229wV extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: jC */
    private final boolean f6673jC;

    /* JADX INFO: renamed from: ay */
    @NotNull
    public static final CustomPacketPayload.Type<C1229wV> f6674ay = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_grenade_cook_start"));

    /* JADX INFO: renamed from: az */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1229wV> f6675az = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6997d(v1);
    }, C1229wV::new);

    public C1229wV(boolean z) {
        this.f6673jC = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1229wV.class), C1229wV.class, "near", "FIELD:Lcom/boehmod/blockfront/wV;->jC:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1229wV.class), C1229wV.class, "near", "FIELD:Lcom/boehmod/blockfront/wV;->jC:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1229wV.class, Object.class), C1229wV.class, "near", "FIELD:Lcom/boehmod/blockfront/wV;->jC:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: dp */
    public boolean m6999dp() {
        return this.f6673jC;
    }

    public C1229wV(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readBoolean());
    }

    /* JADX INFO: renamed from: d */
    public void m6997d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.f6673jC);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6674ay;
    }

    /* JADX INFO: renamed from: a */
    public static void m6998a(C1229wV c1229wV, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a;
        C0755nZ c0755nZM3472a;
        Entity entityPlayer = iPayloadContext.player();
        if (entityPlayer instanceof ServerPlayer) {
            Entity entity = (ServerPlayer) entityPlayer;
            Entity vehicle = entity.getVehicle();
            if ((vehicle instanceof AbstractC0750nU) && (c0755nZM3472a = ((AbstractC0750nU) vehicle).m3472a(entity)) != null && c0755nZM3472a.f4186fL) {
                return;
            }
            ItemStack mainHandItem = entity.getMainHandItem();
            if (mainHandItem.isEmpty()) {
                return;
            }
            Item item = mainHandItem.getItem();
            if (!(item instanceof C1109uH)) {
                return;
            }
            C1109uH c1109uH = (C1109uH) item;
            if (c1109uH.mo6228cu() && (abstractC0531jNM179a = C0030a.m175a().m179a()) != null) {
                AbstractC0183b abstractC0183bM1153a = abstractC0531jNM179a.m2351a().m1153a((Player) entity);
                if (abstractC0183bM1153a instanceof C1326ym) {
                    C1326ym c1326ym = (C1326ym) abstractC0183bM1153a;
                    if (c1326ym.m1110dv() || C0875pn.m4488a((Player) entity, (AbstractC0183b<?, ?, ?, ?>) c1326ym)) {
                        return;
                    }
                    Level level = entity.level();
                    c1326ym.m8302a().m8292a(c1109uH, c1229wV.f6673jC, level.getGameTime());
                    Vec3 vec3Position = entity.position();
                    level.playSound((Player) null, vec3Position.x, vec3Position.y, vec3Position.z, c1109uH.m6227A(), SoundSource.PLAYERS, 1.0f, (float) (0.8999999761581421d + (0.20000000298023224d * Math.random())));
                }
            }
        }
    }
}
