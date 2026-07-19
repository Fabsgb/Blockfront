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

/* JADX INFO: renamed from: com.boehmod.blockfront.vp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/vp.class */
public final class C0583vp extends Record implements CustomPacketPayload {

    @NotNull
    private final BlockPos g;

    @NotNull
    private final ResourceLocation gE;

    @NotNull
    private final ResourceLocation gF;

    @NotNull
    private final String dx;

    @NotNull
    private final ResourceLocation gG;
    private final float nP;
    private final boolean iH;
    private static final int sw = 256;

    @NotNull
    public static final CustomPacketPayload.Type<C0583vp> s = new CustomPacketPayload.Type<>(C0265jv.d("packet_edit_configurable_geo"));

    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C0583vp> t = CustomPacketPayload.codec((v0, v1) -> {
        v0.d(v1);
    }, C0583vp::new);

    public C0583vp(@NotNull BlockPos blockPos, @NotNull ResourceLocation resourceLocation, @NotNull ResourceLocation resourceLocation2, @NotNull String str, @NotNull ResourceLocation resourceLocation3, float f, boolean z) {
        this.g = blockPos;
        this.gE = resourceLocation;
        this.gF = resourceLocation2;
        this.dx = str;
        this.gG = resourceLocation3;
        this.nP = f;
        this.iH = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0583vp.class), C0583vp.class, "pos;model;animation;animationName;texture;rotation;realtime", "FIELD:Lcom/boehmod/blockfront/vp;->g:Lnet/minecraft/core/BlockPos;", "FIELD:Lcom/boehmod/blockfront/vp;->gE:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vp;->gF:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vp;->dx:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vp;->gG:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vp;->nP:F", "FIELD:Lcom/boehmod/blockfront/vp;->iH:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0583vp.class), C0583vp.class, "pos;model;animation;animationName;texture;rotation;realtime", "FIELD:Lcom/boehmod/blockfront/vp;->g:Lnet/minecraft/core/BlockPos;", "FIELD:Lcom/boehmod/blockfront/vp;->gE:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vp;->gF:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vp;->dx:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vp;->gG:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vp;->nP:F", "FIELD:Lcom/boehmod/blockfront/vp;->iH:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0583vp.class, Object.class), C0583vp.class, "pos;model;animation;animationName;texture;rotation;realtime", "FIELD:Lcom/boehmod/blockfront/vp;->g:Lnet/minecraft/core/BlockPos;", "FIELD:Lcom/boehmod/blockfront/vp;->gE:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vp;->gF:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vp;->dx:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/vp;->gG:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/vp;->nP:F", "FIELD:Lcom/boehmod/blockfront/vp;->iH:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public BlockPos f() {
        return this.g;
    }

    @NotNull
    public ResourceLocation W() {
        return this.gE;
    }

    @NotNull
    public ResourceLocation X() {
        return this.gF;
    }

    @NotNull
    public String ax() {
        return this.dx;
    }

    @NotNull
    /* JADX INFO: renamed from: f, reason: collision with other method in class */
    public ResourceLocation m1282f() {
        return this.gG;
    }

    public float bN() {
        return this.nP;
    }

    public boolean cP() {
        return this.iH;
    }

    public C0583vp(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readBlockPos(), friendlyByteBuf.readResourceLocation(), friendlyByteBuf.readResourceLocation(), friendlyByteBuf.readUtf(256), friendlyByteBuf.readResourceLocation(), friendlyByteBuf.readFloat(), friendlyByteBuf.readBoolean());
    }

    public void d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBlockPos(this.g);
        friendlyByteBuf.writeResourceLocation(this.gE);
        friendlyByteBuf.writeResourceLocation(this.gF);
        friendlyByteBuf.writeUtf(this.dx, 256);
        friendlyByteBuf.writeResourceLocation(this.gG);
        friendlyByteBuf.writeFloat(this.nP);
        friendlyByteBuf.writeBoolean(this.iH);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return s;
    }

    public static void a(@NotNull C0583vp c0583vp, @NotNull IPayloadContext iPayloadContext) {
        Player player = iPayloadContext.player();
        if (player.isCreative()) {
            Level level = player.level();
            if (level.isLoaded(c0583vp.g)) {
                BlockEntity blockEntity = level.getBlockEntity(c0583vp.g);
                if (blockEntity instanceof lO) {
                    lO lOVar = (lO) blockEntity;
                    lOVar.a(c0583vp.gE, c0583vp.gF, c0583vp.dx, c0583vp.gG, c0583vp.nP, c0583vp.iH);
                    lOVar.setChanged();
                    BlockState blockState = level.getBlockState(c0583vp.g);
                    level.sendBlockUpdated(c0583vp.g, blockState, blockState, 3);
                }
            }
        }
    }
}
