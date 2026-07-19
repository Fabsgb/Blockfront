package com.boehmod.blockfront;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vh.class */
public final class C0575vh extends Record implements CustomPacketPayload {

    @NotNull
    private final UUID H;

    @NotNull
    public static final CustomPacketPayload.Type<C0575vh> l = new CustomPacketPayload.Type<>(C0265jv.d("packet_copy_map_effect"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0575vh> m = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0575vh::new);

    public C0575vh(@NotNull UUID uuid) {
        this.H = uuid;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0575vh.class), C0575vh.class, "mapEffectID", "FIELD:Lcom/boehmod/blockfront/vh;->H:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0575vh.class), C0575vh.class, "mapEffectID", "FIELD:Lcom/boehmod/blockfront/vh;->H:Ljava/util/UUID;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0575vh.class, Object.class), C0575vh.class, "mapEffectID", "FIELD:Lcom/boehmod/blockfront/vh;->H:Ljava/util/UUID;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public UUID l() {
        return this.H;
    }

    public C0575vh(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(new UUID(friendlyByteBuf.readLong(), friendlyByteBuf.readLong()));
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeLong(this.H.getMostSignificantBits());
        friendlyByteBuf.writeLong(this.H.getLeastSignificantBits());
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return l;
    }

    public static void a(C0575vh c0575vh, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a;
        oF<?, ?, ?> oFVarA;
        sY sYVarM767a;
        pA pAVarA;
        C0280kj c0280kjM1103a;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) wY.z.get();
            if ((mainHandItem.getItem() != item && offhandItem.getItem() != item) || (abstractC0264juM166a = C0002a.a().m166a()) == null || (oFVarA = abstractC0264juM166a.a(player)) == null || (pAVarA = (sYVarM767a = oFVarA.m767a()).a(c0575vh.H)) == null) {
                return;
            }
            RandomSource random = player.getRandom();
            Vec3 vec3 = new Vec3(random.nextBoolean() ? 0.1d : -0.1d, random.nextBoolean() ? 0.1d : -0.1d, random.nextBoolean() ? 0.1d : -0.1d);
            if (sYVarM767a.p(c0575vh.H) && (c0280kjM1103a = sYVarM767a.m1103a(c0575vh.H)) != null) {
                sYVarM767a.a(new C0280kj(c0280kjM1103a.A(), c0280kjM1103a.j().add(vec3), c0280kjM1103a.b() != null ? c0280kjM1103a.b().deepCopy() : null));
                jO jOVarC = jO.c();
                sYVarM767a.b(jOVarC);
                sYVarM767a.da();
                C0582vo.a(new C0609wo(oFVarA, true), oFVarA);
                MinecraftServer minecraftServerA = C0262js.a();
                if (minecraftServerA != null) {
                    jN.a(oFVarA, minecraftServerA.overworld(), null);
                }
                jK jKVarA = jOVarC.a();
                if (jKVarA != null) {
                    jKVarA.i(oFVarA.m751a().getName() + ".json");
                }
                jM jMVarA = jOVarC.a(sX.class);
                if (jMVarA != null) {
                    jMVarA.j(oFVarA.m751a().getName());
                    return;
                }
                return;
            }
            ByteBuf byteBufBuffer = Unpooled.buffer();
            pB.d.encode(byteBufBuffer, pAVarA);
            pA pAVar = (pA) pB.d.decode(byteBufBuffer);
            pAVar.y = UUID.randomUUID();
            pAVar.c = pAVar.c.add(vec3);
            sYVarM767a.a(pAVar);
            sYVarM767a.da();
            C0582vo.a(new C0609wo(oFVarA, true), oFVarA);
            MinecraftServer minecraftServerA2 = C0262js.a();
            if (minecraftServerA2 != null) {
                jN.a(oFVarA, minecraftServerA2.overworld(), null);
            }
        }
    }
}
