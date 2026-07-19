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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vW.class */
public final class vW extends Record implements CustomPacketPayload {
    private final int sH;

    @NotNull
    private final a a;

    @NotNull
    public static final CustomPacketPayload.Type<vW> Z = new CustomPacketPayload.Type<>(C0265jv.d("packet_spawn_corpse"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, vW> aa = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, vW::new);

    public vW(int i, @NotNull a aVar) {
        this.sH = i;
        this.a = aVar;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, vW.class), vW.class, "playerId;context", "FIELD:Lcom/boehmod/blockfront/vW;->sH:I", "FIELD:Lcom/boehmod/blockfront/vW;->a:Lcom/boehmod/blockfront/vW$a;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, vW.class), vW.class, "playerId;context", "FIELD:Lcom/boehmod/blockfront/vW;->sH:I", "FIELD:Lcom/boehmod/blockfront/vW;->a:Lcom/boehmod/blockfront/vW$a;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, vW.class, Object.class), vW.class, "playerId;context", "FIELD:Lcom/boehmod/blockfront/vW;->sH:I", "FIELD:Lcom/boehmod/blockfront/vW;->a:Lcom/boehmod/blockfront/vW$a;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int cm() {
        return this.sH;
    }

    @NotNull
    public a a() {
        return this.a;
    }

    public vW(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readInt(), new a(friendlyByteBuf));
    }

    public void d(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.sH);
        this.a.d(friendlyByteBuf);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return Z;
    }

    public static void b(vW vWVar, @NotNull IPayloadContext iPayloadContext) {
        C0324m.a(vWVar, iPayloadContext);
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vW$a.class */
    public static final class a extends Record {
        private final boolean iR;
        private final boolean iS;
        private final boolean iT;
        private final Vector3f o;

        public a(boolean z, boolean z2, boolean z3, Vector3f vector3f) {
            this.iR = z;
            this.iS = z2;
            this.iT = z3;
            this.o = vector3f;
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

        public boolean cU() {
            return this.iR;
        }

        public boolean cV() {
            return this.iS;
        }

        public boolean cW() {
            return this.iT;
        }

        public Vector3f e() {
            return this.o;
        }

        public a(@NotNull FriendlyByteBuf friendlyByteBuf) {
            this(friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readVector3f());
        }

        public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
            friendlyByteBuf.writeBoolean(this.iR);
            friendlyByteBuf.writeBoolean(this.iS);
            friendlyByteBuf.writeBoolean(this.iT);
            friendlyByteBuf.writeVector3f(this.o);
        }
    }
}
