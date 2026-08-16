package software.bernie.geckolib.network.packet;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.function.Consumer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.util.ClientUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/network/packet/BlockEntityAnimTriggerPacket.class */
public final class BlockEntityAnimTriggerPacket extends Record implements MultiloaderPacket {
    private final BlockPos pos;
    private final String controllerName;
    private final String animName;
    public static final CustomPacketPayload.Type<BlockEntityAnimTriggerPacket> TYPE = new CustomPacketPayload.Type<>(GeckoLibConstants.m8356id("blockentity_anim_trigger"));
    public static final StreamCodec<FriendlyByteBuf, BlockEntityAnimTriggerPacket> CODEC = StreamCodec.composite(BlockPos.STREAM_CODEC, (v0) -> {
        return v0.pos();
    }, ByteBufCodecs.STRING_UTF8, (v0) -> {
        return v0.controllerName();
    }, ByteBufCodecs.STRING_UTF8, (v0) -> {
        return v0.animName();
    }, BlockEntityAnimTriggerPacket::new);

    public BlockEntityAnimTriggerPacket(BlockPos pos, String controllerName, String animName) {
        this.pos = pos;
        this.controllerName = controllerName;
        this.animName = animName;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, BlockEntityAnimTriggerPacket.class), BlockEntityAnimTriggerPacket.class, "pos;controllerName;animName", "FIELD:Lsoftware/bernie/geckolib/network/packet/BlockEntityAnimTriggerPacket;->pos:Lnet/minecraft/core/BlockPos;", "FIELD:Lsoftware/bernie/geckolib/network/packet/BlockEntityAnimTriggerPacket;->controllerName:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/network/packet/BlockEntityAnimTriggerPacket;->animName:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, BlockEntityAnimTriggerPacket.class), BlockEntityAnimTriggerPacket.class, "pos;controllerName;animName", "FIELD:Lsoftware/bernie/geckolib/network/packet/BlockEntityAnimTriggerPacket;->pos:Lnet/minecraft/core/BlockPos;", "FIELD:Lsoftware/bernie/geckolib/network/packet/BlockEntityAnimTriggerPacket;->controllerName:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/network/packet/BlockEntityAnimTriggerPacket;->animName:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, BlockEntityAnimTriggerPacket.class, Object.class), BlockEntityAnimTriggerPacket.class, "pos;controllerName;animName", "FIELD:Lsoftware/bernie/geckolib/network/packet/BlockEntityAnimTriggerPacket;->pos:Lnet/minecraft/core/BlockPos;", "FIELD:Lsoftware/bernie/geckolib/network/packet/BlockEntityAnimTriggerPacket;->controllerName:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/network/packet/BlockEntityAnimTriggerPacket;->animName:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public BlockPos pos() {
        return this.pos;
    }

    public String controllerName() {
        return this.controllerName;
    }

    public String animName() {
        return this.animName;
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    @Override // software.bernie.geckolib.network.packet.MultiloaderPacket
    public void receiveMessage(@Nullable Player sender, Consumer<Runnable> workQueue) {
        workQueue.accept(() -> {
            GeoBlockEntity blockEntity = ClientUtil.getLevel().getBlockEntity(this.pos);
            if (blockEntity instanceof GeoBlockEntity) {
                GeoBlockEntity blockEntity2 = blockEntity;
                blockEntity2.triggerAnim(this.controllerName.isEmpty() ? null : this.controllerName, this.animName);
            }
        });
    }
}
