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
import software.bernie.geckolib.animatable.stateless.StatelessGeoBlockEntity;
import software.bernie.geckolib.util.ClientUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/network/packet/StatelessBlockEntityStopAnimPacket.class */
public final class StatelessBlockEntityStopAnimPacket extends Record implements MultiloaderPacket {
    private final BlockPos blockPos;
    private final String animation;
    public static final CustomPacketPayload.Type<StatelessBlockEntityStopAnimPacket> TYPE = new CustomPacketPayload.Type<>(GeckoLibConstants.m8356id("stateless_block_entity_stop_anim"));
    public static final StreamCodec<FriendlyByteBuf, StatelessBlockEntityStopAnimPacket> CODEC = StreamCodec.composite(BlockPos.STREAM_CODEC, (v0) -> {
        return v0.blockPos();
    }, ByteBufCodecs.STRING_UTF8, (v0) -> {
        return v0.animation();
    }, StatelessBlockEntityStopAnimPacket::new);

    public StatelessBlockEntityStopAnimPacket(BlockPos blockPos, String animation) {
        this.blockPos = blockPos;
        this.animation = animation;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, StatelessBlockEntityStopAnimPacket.class), StatelessBlockEntityStopAnimPacket.class, "blockPos;animation", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessBlockEntityStopAnimPacket;->blockPos:Lnet/minecraft/core/BlockPos;", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessBlockEntityStopAnimPacket;->animation:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, StatelessBlockEntityStopAnimPacket.class), StatelessBlockEntityStopAnimPacket.class, "blockPos;animation", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessBlockEntityStopAnimPacket;->blockPos:Lnet/minecraft/core/BlockPos;", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessBlockEntityStopAnimPacket;->animation:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, StatelessBlockEntityStopAnimPacket.class, Object.class), StatelessBlockEntityStopAnimPacket.class, "blockPos;animation", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessBlockEntityStopAnimPacket;->blockPos:Lnet/minecraft/core/BlockPos;", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessBlockEntityStopAnimPacket;->animation:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public BlockPos blockPos() {
        return this.blockPos;
    }

    public String animation() {
        return this.animation;
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    @Override // software.bernie.geckolib.network.packet.MultiloaderPacket
    public void receiveMessage(@Nullable Player sender, Consumer<Runnable> workQueue) {
        workQueue.accept(() -> {
            GeoBlockEntity blockEntity = ClientUtil.getLevel().getBlockEntity(this.blockPos);
            if (blockEntity instanceof GeoBlockEntity) {
                GeoBlockEntity blockEntity2 = blockEntity;
                if (blockEntity2 instanceof StatelessGeoBlockEntity) {
                    StatelessGeoBlockEntity statelessAnimatable = (StatelessGeoBlockEntity) blockEntity2;
                    statelessAnimatable.handleClientAnimationStop(blockEntity2, 0L, this.animation);
                }
            }
        });
    }
}
