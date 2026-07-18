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

/* JADX INFO: renamed from: com.boehmod.blockfront.vj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vj.class */
public final class C1189vj extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: dw */
    @NotNull
    private final String f6262dw;

    /* JADX INFO: renamed from: aw */
    @NotNull
    private final Vec3 f6263aw;

    /* JADX INFO: renamed from: n */
    @NotNull
    public static final CustomPacketPayload.Type<C1189vj> f6264n = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_create_template_reference"));

    /* JADX INFO: renamed from: o */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1189vj> f6265o = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6631d(v1);
    }, C1189vj::new);

    public C1189vj(@NotNull String str, @NotNull Vec3 vec3) {
        this.f6262dw = str;
        this.f6263aw = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1189vj.class), C1189vj.class, "templateName;anchorPosition", "FIELD:Lcom/boehmod/blockfront/vj;->dw:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vj;->aw:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1189vj.class), C1189vj.class, "templateName;anchorPosition", "FIELD:Lcom/boehmod/blockfront/vj;->dw:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vj;->aw:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1189vj.class, Object.class), C1189vj.class, "templateName;anchorPosition", "FIELD:Lcom/boehmod/blockfront/vj;->dw:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vj;->aw:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: B */
    public String m6633B() {
        return this.f6262dw;
    }

    @NotNull
    /* JADX INFO: renamed from: D */
    public Vec3 m6634D() {
        return this.f6263aw;
    }

    public C1189vj(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUtf(), new Vec3(friendlyByteBuf.readDouble(), friendlyByteBuf.readDouble(), friendlyByteBuf.readDouble()));
    }

    /* JADX INFO: renamed from: d */
    public void m6631d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUtf(this.f6262dw);
        friendlyByteBuf.writeDouble(this.f6263aw.x);
        friendlyByteBuf.writeDouble(this.f6263aw.y);
        friendlyByteBuf.writeDouble(this.f6263aw.z);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6264n;
    }

    /* JADX INFO: renamed from: a */
    public static void m6632a(@NotNull C1189vj c1189vj, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a;
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2530a;
        C0531jO c0531jOM2372c;
        C0529jM c0529jMM2375a;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) C1231wY.f7129z.get();
            Item item2 = (Item) C1231wY.f7130A.get();
            if (!(mainHandItem.getItem() == item || offhandItem.getItem() == item || mainHandItem.getItem() == item2 || offhandItem.getItem() == item2) || (abstractC0563juM168a = C0029a.m164a().m168a()) == null || (abstractC0787oFM2530a = abstractC0563juM168a.m2530a(player)) == null || (c0529jMM2375a = (c0531jOM2372c = C0531jO.m2372c()).m2375a(C0604ki.class)) == null || c0529jMM2375a.m2347a(c1189vj.f6262dw) == null) {
                return;
            }
            C1018sY c1018sYM3653a = abstractC0787oFM2530a.m3653a();
            c1018sYM3653a.m5614a(new C0605kj(c1189vj.f6262dw, c1189vj.f6263aw));
            c1018sYM3653a.m5611b(c0531jOM2372c);
            c1018sYM3653a.m5600da();
            C1194vo.m6651a(new C1247wo(abstractC0787oFM2530a, true), abstractC0787oFM2530a);
            MinecraftServer minecraftServerM2514a = C0561js.m2514a();
            if (minecraftServerM2514a != null) {
                C0530jN.m2371a(abstractC0787oFM2530a, minecraftServerM2514a.overworld(), null);
            }
            RunnableC0527jK runnableC0527jKM2373a = c0531jOM2372c.m2373a();
            if (runnableC0527jKM2373a != null) {
                runnableC0527jKM2373a.m2332i(abstractC0787oFM2530a.m3591a().getName() + ".json");
            }
            C0529jM c0529jMM2375a2 = c0531jOM2372c.m2375a(C1017sX.class);
            if (c0529jMM2375a2 != null) {
                c0529jMM2375a2.m2351j(abstractC0787oFM2530a.m3591a().getName());
            }
        }
    }
}
