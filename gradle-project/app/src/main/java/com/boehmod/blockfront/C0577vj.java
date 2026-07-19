package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vj.class */
public final class C0577vj extends Record implements CustomPacketPayload {

    @NotNull
    private final String dw;

    @NotNull
    private final Vec3 aw;

    @NotNull
    public static final CustomPacketPayload.Type<C0577vj> n = new CustomPacketPayload.Type<>(C0265jv.d("packet_create_template_reference"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0577vj> o = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0577vj::new);

    public C0577vj(@NotNull String str, @NotNull Vec3 vec3) {
        this.dw = str;
        this.aw = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0577vj.class), C0577vj.class, "templateName;anchorPosition", "FIELD:Lcom/boehmod/blockfront/vj;->dw:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vj;->aw:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0577vj.class), C0577vj.class, "templateName;anchorPosition", "FIELD:Lcom/boehmod/blockfront/vj;->dw:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vj;->aw:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0577vj.class, Object.class), C0577vj.class, "templateName;anchorPosition", "FIELD:Lcom/boehmod/blockfront/vj;->dw:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vj;->aw:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public String B() {
        return this.dw;
    }

    @NotNull
    public Vec3 D() {
        return this.aw;
    }

    public C0577vj(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUtf(), new Vec3(friendlyByteBuf.readDouble(), friendlyByteBuf.readDouble(), friendlyByteBuf.readDouble()));
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUtf(this.dw);
        friendlyByteBuf.writeDouble(this.aw.x);
        friendlyByteBuf.writeDouble(this.aw.y);
        friendlyByteBuf.writeDouble(this.aw.z);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return n;
    }

    public static void a(@NotNull C0577vj c0577vj, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a;
        oF<?, ?, ?> oFVarA;
        jO jOVarC;
        jM jMVarA;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) wY.z.get();
            Item item2 = (Item) wY.A.get();
            if (!(mainHandItem.getItem() == item || offhandItem.getItem() == item || mainHandItem.getItem() == item2 || offhandItem.getItem() == item2) || (abstractC0264juM166a = C0002a.a().m166a()) == null || (oFVarA = abstractC0264juM166a.a(player)) == null || (jMVarA = (jOVarC = jO.c()).a(C0279ki.class)) == null || jMVarA.a(c0577vj.dw) == null) {
                return;
            }
            sY sYVarM767a = oFVarA.m767a();
            sYVarM767a.a(new C0280kj(c0577vj.dw, c0577vj.aw));
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
            jM jMVarA2 = jOVarC.a(sX.class);
            if (jMVarA2 != null) {
                jMVarA2.j(oFVarA.m751a().getName());
            }
        }
    }
}
