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

/* JADX INFO: renamed from: com.boehmod.blockfront.vP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vP.class */
public final class C1170vP extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: g */
    @NotNull
    private final BlockPos f6363g;

    /* JADX INFO: renamed from: gE */
    @NotNull
    private final ResourceLocation f6364gE;

    /* JADX INFO: renamed from: gF */
    @NotNull
    private final ResourceLocation f6365gF;

    /* JADX INFO: renamed from: dI */
    @NotNull
    private final String f6366dI;

    /* JADX INFO: renamed from: gG */
    @NotNull
    private final ResourceLocation f6367gG;

    /* JADX INFO: renamed from: oN */
    private final float f6368oN;

    /* JADX INFO: renamed from: jb */
    private final boolean f6369jb;

    /* JADX INFO: renamed from: uA */
    private static final int f6370uA = 256;

    /* JADX INFO: renamed from: s */
    @NotNull
    public static final CustomPacketPayload.Type<C1170vP> f6371s = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_edit_configurable_geo"));

    /* JADX INFO: renamed from: t */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1170vP> f6372t = CustomPacketPayload.codec((v0, v1) -> {
        v0.m6651d(v1);
    }, C1170vP::new);

    public C1170vP(@NotNull BlockPos blockPos, @NotNull ResourceLocation resourceLocation, @NotNull ResourceLocation resourceLocation2, @NotNull String str, @NotNull ResourceLocation resourceLocation3, float f, boolean z) {
        this.f6363g = blockPos;
        this.f6364gE = resourceLocation;
        this.f6365gF = resourceLocation2;
        this.f6366dI = str;
        this.f6367gG = resourceLocation3;
        this.f6368oN = f;
        this.f6369jb = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1170vP.class), C1170vP.class, "pos;model;animation;animationName;texture;rotation;realtime", "FIELD:Lcom/boehmod/blockfront/vP;->g:Lnet/minecraft/core/BlockPos;", "FIELD:Lcom/boehmod/blockfront/vP;->gE:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vP;->gF:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vP;->dI:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vP;->gG:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vP;->oN:F", "FIELD:Lcom/boehmod/blockfront/vP;->jb:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1170vP.class), C1170vP.class, "pos;model;animation;animationName;texture;rotation;realtime", "FIELD:Lcom/boehmod/blockfront/vP;->g:Lnet/minecraft/core/BlockPos;", "FIELD:Lcom/boehmod/blockfront/vP;->gE:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vP;->gF:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vP;->dI:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vP;->gG:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vP;->oN:F", "FIELD:Lcom/boehmod/blockfront/vP;->jb:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1170vP.class, Object.class), C1170vP.class, "pos;model;animation;animationName;texture;rotation;realtime", "FIELD:Lcom/boehmod/blockfront/vP;->g:Lnet/minecraft/core/BlockPos;", "FIELD:Lcom/boehmod/blockfront/vP;->gE:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vP;->gF:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vP;->dI:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vP;->gG:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vP;->oN:F", "FIELD:Lcom/boehmod/blockfront/vP;->jb:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    public BlockPos m6653f() {
        return this.f6363g;
    }

    @NotNull
    /* JADX INFO: renamed from: Y */
    public ResourceLocation m6654Y() {
        return this.f6364gE;
    }

    @NotNull
    /* JADX INFO: renamed from: Z */
    public ResourceLocation m6655Z() {
        return this.f6365gF;
    }

    @NotNull
    /* JADX INFO: renamed from: aE */
    public String m6656aE() {
        return this.f6366dI;
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    public ResourceLocation m6657f() {
        return this.f6367gG;
    }

    /* JADX INFO: renamed from: bT */
    public float m6658bT() {
        return this.f6368oN;
    }

    /* JADX INFO: renamed from: cY */
    public boolean m6659cY() {
        return this.f6369jb;
    }

    public C1170vP(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readBlockPos(), friendlyByteBuf.readResourceLocation(), friendlyByteBuf.readResourceLocation(), friendlyByteBuf.readUtf(256), friendlyByteBuf.readResourceLocation(), friendlyByteBuf.readFloat(), friendlyByteBuf.readBoolean());
    }

    /* JADX INFO: renamed from: d */
    public void m6651d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBlockPos(this.f6363g);
        friendlyByteBuf.writeResourceLocation(this.f6364gE);
        friendlyByteBuf.writeResourceLocation(this.f6365gF);
        friendlyByteBuf.writeUtf(this.f6366dI, 256);
        friendlyByteBuf.writeResourceLocation(this.f6367gG);
        friendlyByteBuf.writeFloat(this.f6368oN);
        friendlyByteBuf.writeBoolean(this.f6369jb);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6371s;
    }

    /* JADX INFO: renamed from: a */
    public static void m6652a(@NotNull C1170vP c1170vP, @NotNull IPayloadContext iPayloadContext) {
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            Level level = player.level();
            if (level.isLoaded(c1170vP.f6363g)) {
                BlockEntity blockEntity = level.getBlockEntity(c1170vP.f6363g);
                if (blockEntity instanceof C0713mk) {
                    C0713mk c0713mk = (C0713mk) blockEntity;
                    c0713mk.m3258a(c1170vP.f6364gE, c1170vP.f6365gF, c1170vP.f6366dI, c1170vP.f6367gG, c1170vP.f6368oN, c1170vP.f6369jb);
                    c0713mk.setChanged();
                    BlockState blockState = level.getBlockState(c1170vP.f6363g);
                    level.sendBlockUpdated(c1170vP.f6363g, blockState, blockState, 3);
                }
            }
        }
    }
}
