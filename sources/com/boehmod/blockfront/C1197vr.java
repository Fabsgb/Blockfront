package com.boehmod.blockfront;

import io.netty.buffer.Unpooled;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vr.class */
public final class C1197vr extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: dy */
    @NotNull
    private final String f6293dy;

    /* JADX INFO: renamed from: i */
    private final byte[] f6294i;

    /* JADX INFO: renamed from: u */
    @NotNull
    public static final CustomPacketPayload.Type<C1197vr> f6295u = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_edit_template"));

    /* JADX INFO: renamed from: v */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1197vr> f6296v = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6669d(v1);
    }, C1197vr::new);

    public C1197vr(@NotNull String str, byte[] bArr) {
        this.f6293dy = str;
        this.f6294i = bArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1197vr.class), C1197vr.class, "templateName;effectData", "FIELD:Lcom/boehmod/blockfront/vr;->dy:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vr;->i:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1197vr.class), C1197vr.class, "templateName;effectData", "FIELD:Lcom/boehmod/blockfront/vr;->dy:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vr;->i:[B").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1197vr.class, Object.class), C1197vr.class, "templateName;effectData", "FIELD:Lcom/boehmod/blockfront/vr;->dy:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vr;->i:[B").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: B */
    public String m6671B() {
        return this.f6293dy;
    }

    /* JADX INFO: renamed from: d */
    public byte[] m6672d() {
        return this.f6294i;
    }

    public C1197vr(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUtf(), friendlyByteBuf.readByteArray());
    }

    /* JADX INFO: renamed from: d */
    public void m6669d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUtf(this.f6293dy);
        friendlyByteBuf.writeByteArray(this.f6294i);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6295u;
    }

    /* JADX INFO: renamed from: a */
    public static void m6670a(@NotNull C1197vr c1197vr, @NotNull IPayloadContext iPayloadContext) {
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) C1231wY.f7129z.get();
            Item item2 = (Item) C1231wY.f7130A.get();
            if ((mainHandItem.getItem() == item || offhandItem.getItem() == item || mainHandItem.getItem() == item2 || offhandItem.getItem() == item2) && C0029a.m164a().m168a() != null) {
                C0529jM c0529jMM2375a = C0531jO.m2372c().m2375a(C0604ki.class);
                if (c0529jMM2375a == null) {
                    C0562jt.m2515a("[PacketEditTemplate] Templates registry not found.", new Object[0]);
                } else if (c0529jMM2375a.m2347a(c1197vr.f6293dy) == null) {
                    C0562jt.m2515a("[PacketEditTemplate] Template '%s' not found.", c1197vr.f6293dy);
                } else {
                    c0529jMM2375a.m2352c(c1197vr.f6293dy, new C0604ki((AbstractC0835pA) C0836pB.f4477d.decode(Unpooled.wrappedBuffer(c1197vr.f6294i))));
                    C0530jN.m2367n(c1197vr.f6293dy);
                }
            }
        }
    }
}
