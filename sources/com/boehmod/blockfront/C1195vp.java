package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.vp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vp.class */
public final class C1195vp extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: g */
    @NotNull
    private final BlockPos f6279g;

    /* JADX INFO: renamed from: gE */
    @NotNull
    private final ResourceLocation f6280gE;

    /* JADX INFO: renamed from: gF */
    @NotNull
    private final ResourceLocation f6281gF;

    /* JADX INFO: renamed from: dx */
    @NotNull
    private final String f6282dx;

    /* JADX INFO: renamed from: gG */
    @NotNull
    private final ResourceLocation f6283gG;

    /* JADX INFO: renamed from: nP */
    private final float f6284nP;

    /* JADX INFO: renamed from: iH */
    private final boolean f6285iH;

    /* JADX INFO: renamed from: sw */
    private static final int f6286sw = 256;

    /* JADX INFO: renamed from: s */
    @NotNull
    public static final CustomPacketPayload.Type<C1195vp> f6287s = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_edit_configurable_geo"));

    /* JADX INFO: renamed from: t */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1195vp> f6288t = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6656d(v1);
    }, C1195vp::new);

    public C1195vp(@NotNull BlockPos blockPos, @NotNull ResourceLocation resourceLocation, @NotNull ResourceLocation resourceLocation2, @NotNull String str, @NotNull ResourceLocation resourceLocation3, float f, boolean z) {
        this.f6279g = blockPos;
        this.f6280gE = resourceLocation;
        this.f6281gF = resourceLocation2;
        this.f6282dx = str;
        this.f6283gG = resourceLocation3;
        this.f6284nP = f;
        this.f6285iH = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1195vp.class), C1195vp.class, "pos;model;animation;animationName;texture;rotation;realtime", "FIELD:Lcom/boehmod/blockfront/vp;->g:Lnet/minecraft/core/BlockPos;", "FIELD:Lcom/boehmod/blockfront/vp;->gE:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vp;->gF:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vp;->dx:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vp;->gG:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vp;->nP:F", "FIELD:Lcom/boehmod/blockfront/vp;->iH:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1195vp.class), C1195vp.class, "pos;model;animation;animationName;texture;rotation;realtime", "FIELD:Lcom/boehmod/blockfront/vp;->g:Lnet/minecraft/core/BlockPos;", "FIELD:Lcom/boehmod/blockfront/vp;->gE:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vp;->gF:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vp;->dx:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vp;->gG:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vp;->nP:F", "FIELD:Lcom/boehmod/blockfront/vp;->iH:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1195vp.class, Object.class), C1195vp.class, "pos;model;animation;animationName;texture;rotation;realtime", "FIELD:Lcom/boehmod/blockfront/vp;->g:Lnet/minecraft/core/BlockPos;", "FIELD:Lcom/boehmod/blockfront/vp;->gE:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vp;->gF:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vp;->dx:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vp;->gG:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vp;->nP:F", "FIELD:Lcom/boehmod/blockfront/vp;->iH:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    public BlockPos m6658f() {
        return this.f6279g;
    }

    @NotNull
    /* JADX INFO: renamed from: W */
    public ResourceLocation m6659W() {
        return this.f6280gE;
    }

    @NotNull
    /* JADX INFO: renamed from: X */
    public ResourceLocation m6660X() {
        return this.f6281gF;
    }

    @NotNull
    /* JADX INFO: renamed from: ax */
    public String m6661ax() {
        return this.f6282dx;
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    public ResourceLocation m6662f() {
        return this.f6283gG;
    }

    /* JADX INFO: renamed from: bN */
    public float m6663bN() {
        return this.f6284nP;
    }

    /* JADX INFO: renamed from: cP */
    public boolean m6664cP() {
        return this.f6285iH;
    }

    public C1195vp(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readBlockPos(), friendlyByteBuf.readResourceLocation(), friendlyByteBuf.readResourceLocation(), friendlyByteBuf.readUtf(256), friendlyByteBuf.readResourceLocation(), friendlyByteBuf.readFloat(), friendlyByteBuf.readBoolean());
    }

    /* JADX INFO: renamed from: d */
    public void m6656d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBlockPos(this.f6279g);
        friendlyByteBuf.writeResourceLocation(this.f6280gE);
        friendlyByteBuf.writeResourceLocation(this.f6281gF);
        friendlyByteBuf.writeUtf(this.f6282dx, 256);
        friendlyByteBuf.writeResourceLocation(this.f6283gG);
        friendlyByteBuf.writeFloat(this.f6284nP);
        friendlyByteBuf.writeBoolean(this.f6285iH);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6287s;
    }

    /* JADX INFO: renamed from: a */
    public static void m6657a(@NotNull C1195vp c1195vp, @NotNull IPayloadContext iPayloadContext) {
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            Level level = player.level();
            if (level.isLoaded(c1195vp.f6279g)) {
                BlockEntity blockEntity = level.getBlockEntity(c1195vp.f6279g);
                if (blockEntity instanceof C0637lO) {
                    C0637lO c0637lO = (C0637lO) blockEntity;
                    c0637lO.m2827a(c1195vp.f6280gE, c1195vp.f6281gF, c1195vp.f6282dx, c1195vp.f6283gG, c1195vp.f6284nP, c1195vp.f6285iH);
                    c0637lO.setChanged();
                    BlockState blockState = level.getBlockState(c1195vp.f6279g);
                    level.sendBlockUpdated(c1195vp.f6279g, blockState, blockState, 3);
                }
            }
        }
    }
}
