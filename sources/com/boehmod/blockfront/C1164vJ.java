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

/* JADX INFO: renamed from: com.boehmod.blockfront.vJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vJ.class */
public final class C1164vJ extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: dH */
    @NotNull
    private final String f6346dH;

    /* JADX INFO: renamed from: ax */
    @NotNull
    private final Vec3 f6347ax;

    /* JADX INFO: renamed from: n */
    @NotNull
    public static final CustomPacketPayload.Type<C1164vJ> f6348n = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_create_template_reference"));

    /* JADX INFO: renamed from: o */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1164vJ> f6349o = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6626d(v1);
    }, C1164vJ::new);

    public C1164vJ(@NotNull String str, @NotNull Vec3 vec3) {
        this.f6346dH = str;
        this.f6347ax = vec3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1164vJ.class), C1164vJ.class, "templateName;anchorPosition", "FIELD:Lcom/boehmod/blockfront/vJ;->dH:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vJ;->ax:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1164vJ.class), C1164vJ.class, "templateName;anchorPosition", "FIELD:Lcom/boehmod/blockfront/vJ;->dH:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vJ;->ax:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1164vJ.class, Object.class), C1164vJ.class, "templateName;anchorPosition", "FIELD:Lcom/boehmod/blockfront/vJ;->dH:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vJ;->ax:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: I */
    public String m6628I() {
        return this.f6346dH;
    }

    @NotNull
    /* JADX INFO: renamed from: E */
    public Vec3 m6629E() {
        return this.f6347ax;
    }

    public C1164vJ(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readUtf(), new Vec3(friendlyByteBuf.readDouble(), friendlyByteBuf.readDouble(), friendlyByteBuf.readDouble()));
    }

    /* JADX INFO: renamed from: d */
    public void m6626d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeUtf(this.f6346dH);
        friendlyByteBuf.writeDouble(this.f6347ax.x);
        friendlyByteBuf.writeDouble(this.f6347ax.y);
        friendlyByteBuf.writeDouble(this.f6347ax.z);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6348n;
    }

    /* JADX INFO: renamed from: a */
    public static void m6627a(@NotNull C1164vJ c1164vJ, @NotNull IPayloadContext iPayloadContext) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a;
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2353a;
        C0607kk c0607kkM2734c;
        C0605ki c0605kiM2737a;
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            ItemStack mainHandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();
            Item item = (Item) C1308xv.f7694z.get();
            Item item2 = (Item) C1308xv.f7695A.get();
            if (!(mainHandItem.getItem() == item || offhandItem.getItem() == item || mainHandItem.getItem() == item2 || offhandItem.getItem() == item2) || (abstractC0531jNM179a = C0030a.m175a().m179a()) == null || (abstractC0863pbM2353a = abstractC0531jNM179a.m2353a(player)) == null || (c0605kiM2737a = (c0607kkM2734c = C0607kk.m2734c()).m2737a(C0575kE.class)) == null || c0605kiM2737a.m2707a(c1164vJ.f6346dH) == null) {
                return;
            }
            C1096tv c1096tvM4089a = abstractC0863pbM2353a.m4089a();
            c1096tvM4089a.m6102a(new C0576kF(c1164vJ.f6346dH, c1164vJ.f6347ax));
            c1096tvM4089a.m6099b(c0607kkM2734c);
            c1096tvM4089a.m6088dm();
            C1169vO.m6646a(new C1220wM(abstractC0863pbM2353a, true), abstractC0863pbM2353a);
            MinecraftServer minecraftServerM2335a = C0529jL.m2335a();
            if (minecraftServerM2335a != null) {
                C0606kj.m2733a(abstractC0863pbM2353a, minecraftServerM2335a.overworld(), null);
            }
            RunnableC0603kg runnableC0603kgM2735a = c0607kkM2734c.m2735a();
            if (runnableC0603kgM2735a != null) {
                runnableC0603kgM2735a.m2692i(abstractC0863pbM2353a.m4027a().getName() + ".json");
            }
            C0605ki c0605kiM2737a2 = c0607kkM2734c.m2737a(C1095tu.class);
            if (c0605kiM2737a2 != null) {
                c0605kiM2737a2.m2713j(abstractC0863pbM2353a.m4027a().getName());
            }
        }
    }
}
