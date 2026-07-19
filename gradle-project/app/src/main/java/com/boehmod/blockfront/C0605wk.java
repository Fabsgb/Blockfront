package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wk.class */
public final class C0605wk extends Record implements CustomPacketPayload {
    private final int sO;

    @NotNull
    private final List<C0556up> ck;

    @NotNull
    public static final CustomPacketPayload.Type<C0605wk> an = new CustomPacketPayload.Type<>(C0265jv.d("packet_bullet_collision_living_client"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0605wk> ao = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0605wk::new);

    public C0605wk(int i, @NotNull List<C0556up> list) {
        this.sO = i;
        this.ck = list;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0605wk.class), C0605wk.class, "entityId;entityBulletHit", "FIELD:Lcom/boehmod/blockfront/wk;->sO:I", "FIELD:Lcom/boehmod/blockfront/wk;->ck:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0605wk.class), C0605wk.class, "entityId;entityBulletHit", "FIELD:Lcom/boehmod/blockfront/wk;->sO:I", "FIELD:Lcom/boehmod/blockfront/wk;->ck:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0605wk.class, Object.class), C0605wk.class, "entityId;entityBulletHit", "FIELD:Lcom/boehmod/blockfront/wk;->sO:I", "FIELD:Lcom/boehmod/blockfront/wk;->ck:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int al() {
        return this.sO;
    }

    @NotNull
    public List<C0556up> aN() {
        return this.ck;
    }

    public C0605wk(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readInt(), C0635xn.b(friendlyByteBuf));
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.sO);
        C0635xn.b(friendlyByteBuf, this.ck);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return an;
    }

    public static void b(C0605wk c0605wk, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(c0605wk, iPayloadContext);
    }
}
