package com.boehmod.blockfront;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wZ.class */
public final class C1233wZ extends Record implements CustomPacketPayload {

    /* JADX INFO: renamed from: R */
    private final long f6686R;

    /* JADX INFO: renamed from: aC */
    @NotNull
    public static final CustomPacketPayload.Type<C1233wZ> f6687aC = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_gun_reload"));

    /* JADX INFO: renamed from: aD */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1233wZ> f6688aD = CustomPacketPayload.codec((v0, v1) -> {
        v0.m7008d(v1);
    }, C1233wZ::new);

    public C1233wZ(long j) {
        this.f6686R = j;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1233wZ.class), C1233wZ.class, "reloadStartTick", "FIELD:Lcom/boehmod/blockfront/wZ;->R:J").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1233wZ.class), C1233wZ.class, "reloadStartTick", "FIELD:Lcom/boehmod/blockfront/wZ;->R:J").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1233wZ.class, Object.class), C1233wZ.class, "reloadStartTick", "FIELD:Lcom/boehmod/blockfront/wZ;->R:J").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: i */
    public long m7010i() {
        return this.f6686R;
    }

    public C1233wZ(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this(friendlyByteBuf.readVarLong());
    }

    /* JADX INFO: renamed from: d */
    public void m7008d(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeVarLong(this.f6686R);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6687aC;
    }

    /* JADX INFO: renamed from: a */
    public static void m7009a(C1233wZ c1233wZ, @NotNull IPayloadContext iPayloadContext) {
        LivingEntity livingEntityPlayer = iPayloadContext.player();
        ItemStack mainHandItem = livingEntityPlayer.getMainHandItem();
        Item item = mainHandItem.getItem();
        if (item instanceof C1117uP) {
            ((C1117uP) item).m6342a(livingEntityPlayer, livingEntityPlayer.level(), mainHandItem, c1233wZ.f6686R);
        }
    }
}
