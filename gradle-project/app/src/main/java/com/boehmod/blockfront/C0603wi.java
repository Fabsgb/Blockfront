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

/* JADX INFO: renamed from: com.boehmod.blockfront.wi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wi.class */
public final class C0603wi extends Record implements CustomPacketPayload {
    private final int sM;

    @NotNull
    private final List<C0555uo> ci;

    @NotNull
    public static final CustomPacketPayload.Type<C0603wi> al = new CustomPacketPayload.Type<>(C0265jv.d("packet_bullet_collision_block_client"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0603wi> am = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0603wi::new);

    public C0603wi(int i, @NotNull List<C0555uo> list) {
        this.sM = i;
        this.ci = list;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0603wi.class), C0603wi.class, "entityID;blockBulletHits", "FIELD:Lcom/boehmod/blockfront/wi;->sM:I", "FIELD:Lcom/boehmod/blockfront/wi;->ci:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0603wi.class), C0603wi.class, "entityID;blockBulletHits", "FIELD:Lcom/boehmod/blockfront/wi;->sM:I", "FIELD:Lcom/boehmod/blockfront/wi;->ci:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0603wi.class, Object.class), C0603wi.class, "entityID;blockBulletHits", "FIELD:Lcom/boehmod/blockfront/wi;->sM:I", "FIELD:Lcom/boehmod/blockfront/wi;->ci:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int cq() {
        return this.sM;
    }

    @NotNull
    public List<C0555uo> aL() {
        return this.ci;
    }

    public C0603wi(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readInt(), C0635xn.m1694a(friendlyByteBuf));
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.sM);
        C0635xn.a(friendlyByteBuf, this.ci);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return al;
    }

    public static void b(C0603wi c0603wi, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(c0603wi, iPayloadContext);
    }
}
