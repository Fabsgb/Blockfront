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

/* JADX INFO: renamed from: com.boehmod.blockfront.ww */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ww.class */
public final class C1256ww extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: uL */
    private final int f6786uL;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final a f6787a;

    /* JADX INFO: renamed from: Z */
    @NotNull
    public static final CustomPacketPayload.Type<C1256ww> f6788Z = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_spawn_corpse"));

    /* JADX INFO: renamed from: aa */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1256ww> f6789aa = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7104d(v1);
    }, C1256ww::new);

    public C1256ww(int i, @NotNull a aVar) {
        this.f6786uL = i;
        this.f6787a = aVar;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1256ww.class), C1256ww.class, "playerId;context", "FIELD:Lcom/boehmod/blockfront/ww;->uL:I", "FIELD:Lcom/boehmod/blockfront/ww;->a:Lcom/boehmod/blockfront/ww$a;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1256ww.class), C1256ww.class, "playerId;context", "FIELD:Lcom/boehmod/blockfront/ww;->uL:I", "FIELD:Lcom/boehmod/blockfront/ww;->a:Lcom/boehmod/blockfront/ww$a;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1256ww.class, Object.class), C1256ww.class, "playerId;context", "FIELD:Lcom/boehmod/blockfront/ww;->uL:I", "FIELD:Lcom/boehmod/blockfront/ww;->a:Lcom/boehmod/blockfront/ww$a;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: cC */
    public int m7106cC() {
        return this.f6786uL;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public a m7107a() {
        return this.f6787a;
    }

    public C1256ww(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readInt(), new a(friendlyByteBuf));
    }

    /* JADX INFO: renamed from: d */
    public void m7104d(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.f6786uL);
        this.f6787a.m7108d(friendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6788Z;
    }

    /* JADX INFO: renamed from: b */
    public static void m7105b(C1256ww c1256ww, @NotNull IPayloadContext iPayloadContext) {
        C0676m.m2953a(c1256ww, iPayloadContext);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.ww$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ww$a.class */
    public static final class a extends Record {

        /* JADX INFO: renamed from: jk */
        private final boolean f6790jk;

        /* JADX INFO: renamed from: jl */
        private final boolean f6791jl;

        /* JADX INFO: renamed from: jm */
        private final boolean f6792jm;

        /* JADX INFO: renamed from: q */
        private final Vector3f f6793q;

        public a(boolean z, boolean z2, boolean z3, Vector3f vector3f) {
            this.f6790jk = z;
            this.f6791jl = z2;
            this.f6792jm = z3;
            this.f6793q = vector3f;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "burned;dismembered;explosion;velocity", "FIELD:Lcom/boehmod/blockfront/ww$a;->jk:Z", "FIELD:Lcom/boehmod/blockfront/ww$a;->jl:Z", "FIELD:Lcom/boehmod/blockfront/ww$a;->jm:Z", "FIELD:Lcom/boehmod/blockfront/ww$a;->q:Lorg/joml/Vector3f;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "burned;dismembered;explosion;velocity", "FIELD:Lcom/boehmod/blockfront/ww$a;->jk:Z", "FIELD:Lcom/boehmod/blockfront/ww$a;->jl:Z", "FIELD:Lcom/boehmod/blockfront/ww$a;->jm:Z", "FIELD:Lcom/boehmod/blockfront/ww$a;->q:Lorg/joml/Vector3f;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "burned;dismembered;explosion;velocity", "FIELD:Lcom/boehmod/blockfront/ww$a;->jk:Z", "FIELD:Lcom/boehmod/blockfront/ww$a;->jl:Z", "FIELD:Lcom/boehmod/blockfront/ww$a;->jm:Z", "FIELD:Lcom/boehmod/blockfront/ww$a;->q:Lorg/joml/Vector3f;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        /* JADX INFO: renamed from: dd */
        public boolean m7109dd() {
            return this.f6790jk;
        }

        /* JADX INFO: renamed from: de */
        public boolean m7110de() {
            return this.f6791jl;
        }

        /* JADX INFO: renamed from: df */
        public boolean m7111df() {
            return this.f6792jm;
        }

        /* JADX INFO: renamed from: c */
        public Vector3f m7112c() {
            return this.f6793q;
        }

        public a(@NotNull FriendlyByteBuf friendlyByteBuf) {
            this(friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readVector3f());
        }

        /* JADX INFO: renamed from: d */
        public void m7108d(@NotNull FriendlyByteBuf friendlyByteBuf) {
            friendlyByteBuf.writeBoolean(this.f6790jk);
            friendlyByteBuf.writeBoolean(this.f6791jl);
            friendlyByteBuf.writeBoolean(this.f6792jm);
            friendlyByteBuf.writeVector3f(this.f6793q);
        }
    }
}
