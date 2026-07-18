package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.vW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vW.class */
public final class C1176vW extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: sH */
    private final int f6210sH;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final a f6211a;

    /* JADX INFO: renamed from: Z */
    @NotNull
    public static final CustomPacketPayload.Type<C1176vW> f6212Z = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_spawn_corpse"));

    /* JADX INFO: renamed from: aa */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1176vW> f6213aa = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6578d(v1);
    }, C1176vW::new);

    public C1176vW(int i, @NotNull a aVar) {
        this.f6210sH = i;
        this.f6211a = aVar;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1176vW.class), C1176vW.class, "playerId;context", "FIELD:Lcom/boehmod/blockfront/vW;->sH:I", "FIELD:Lcom/boehmod/blockfront/vW;->a:Lcom/boehmod/blockfront/vW$a;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1176vW.class), C1176vW.class, "playerId;context", "FIELD:Lcom/boehmod/blockfront/vW;->sH:I", "FIELD:Lcom/boehmod/blockfront/vW;->a:Lcom/boehmod/blockfront/vW$a;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1176vW.class, Object.class), C1176vW.class, "playerId;context", "FIELD:Lcom/boehmod/blockfront/vW;->sH:I", "FIELD:Lcom/boehmod/blockfront/vW;->a:Lcom/boehmod/blockfront/vW$a;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: cm */
    public int m6580cm() {
        return this.f6210sH;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public a m6581a() {
        return this.f6211a;
    }

    public C1176vW(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readInt(), new a(friendlyByteBuf));
    }

    /* JADX INFO: renamed from: d */
    public void m6578d(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.f6210sH);
        this.f6211a.m6582d(friendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6212Z;
    }

    /* JADX INFO: renamed from: b */
    public static void m6579b(C1176vW c1176vW, @NotNull IPayloadContext iPayloadContext) {
        C0675m.m2942a(c1176vW, iPayloadContext);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.vW$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vW$a.class */
    public static final class a extends Record {

        /* JADX INFO: renamed from: iR */
        private final boolean f6214iR;

        /* JADX INFO: renamed from: iS */
        private final boolean f6215iS;

        /* JADX INFO: renamed from: iT */
        private final boolean f6216iT;

        /* JADX INFO: renamed from: o */
        private final Vector3f f6217o;

        public a(boolean z, boolean z2, boolean z3, Vector3f vector3f) {
            this.f6214iR = z;
            this.f6215iS = z2;
            this.f6216iT = z3;
            this.f6217o = vector3f;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "burned;dismembered;explosion;velocity", "FIELD:Lcom/boehmod/blockfront/vW$a;->iR:Z", "FIELD:Lcom/boehmod/blockfront/vW$a;->iS:Z", "FIELD:Lcom/boehmod/blockfront/vW$a;->iT:Z", "FIELD:Lcom/boehmod/blockfront/vW$a;->o:Lorg/joml/Vector3f;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "burned;dismembered;explosion;velocity", "FIELD:Lcom/boehmod/blockfront/vW$a;->iR:Z", "FIELD:Lcom/boehmod/blockfront/vW$a;->iS:Z", "FIELD:Lcom/boehmod/blockfront/vW$a;->iT:Z", "FIELD:Lcom/boehmod/blockfront/vW$a;->o:Lorg/joml/Vector3f;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "burned;dismembered;explosion;velocity", "FIELD:Lcom/boehmod/blockfront/vW$a;->iR:Z", "FIELD:Lcom/boehmod/blockfront/vW$a;->iS:Z", "FIELD:Lcom/boehmod/blockfront/vW$a;->iT:Z", "FIELD:Lcom/boehmod/blockfront/vW$a;->o:Lorg/joml/Vector3f;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: cU */
        public boolean m6583cU() {
            return this.f6214iR;
        }

        /* JADX INFO: renamed from: cV */
        public boolean m6584cV() {
            return this.f6215iS;
        }

        /* JADX INFO: renamed from: cW */
        public boolean m6585cW() {
            return this.f6216iT;
        }

        /* JADX INFO: renamed from: e */
        public Vector3f m6586e() {
            return this.f6217o;
        }

        public a(@NotNull FriendlyByteBuf friendlyByteBuf) {
            this(friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readVector3f());
        }

        /* JADX INFO: renamed from: d */
        public void m6582d(@NotNull FriendlyByteBuf friendlyByteBuf) {
            friendlyByteBuf.writeBoolean(this.f6214iR);
            friendlyByteBuf.writeBoolean(this.f6215iS);
            friendlyByteBuf.writeBoolean(this.f6216iT);
            friendlyByteBuf.writeVector3f(this.f6217o);
        }
    }
}
