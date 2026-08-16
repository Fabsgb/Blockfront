package software.bernie.geckolib.network.packet;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.function.Consumer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.stateless.StatelessGeoSingletonAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/network/packet/StatelessSingletonStopAnimPacket.class */
public final class StatelessSingletonStopAnimPacket extends Record implements MultiloaderPacket {
    private final String syncableId;
    private final long instanceId;
    private final String animation;
    public static final CustomPacketPayload.Type<StatelessSingletonStopAnimPacket> TYPE = new CustomPacketPayload.Type<>(GeckoLibConstants.m8356id("stateless_singleton_stop_anim"));
    public static final StreamCodec<FriendlyByteBuf, StatelessSingletonStopAnimPacket> CODEC = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, (v0) -> {
        return v0.syncableId();
    }, ByteBufCodecs.VAR_LONG, (v0) -> {
        return v0.instanceId();
    }, ByteBufCodecs.STRING_UTF8, (v0) -> {
        return v0.animation();
    }, (v1, v2, v3) -> {
        return new StatelessSingletonStopAnimPacket(v1, v2, v3);
    });

    public StatelessSingletonStopAnimPacket(String syncableId, long instanceId, String animation) {
        this.syncableId = syncableId;
        this.instanceId = instanceId;
        this.animation = animation;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, StatelessSingletonStopAnimPacket.class), StatelessSingletonStopAnimPacket.class, "syncableId;instanceId;animation", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessSingletonStopAnimPacket;->syncableId:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessSingletonStopAnimPacket;->instanceId:J", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessSingletonStopAnimPacket;->animation:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, StatelessSingletonStopAnimPacket.class), StatelessSingletonStopAnimPacket.class, "syncableId;instanceId;animation", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessSingletonStopAnimPacket;->syncableId:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessSingletonStopAnimPacket;->instanceId:J", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessSingletonStopAnimPacket;->animation:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, StatelessSingletonStopAnimPacket.class, Object.class), StatelessSingletonStopAnimPacket.class, "syncableId;instanceId;animation", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessSingletonStopAnimPacket;->syncableId:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessSingletonStopAnimPacket;->instanceId:J", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessSingletonStopAnimPacket;->animation:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public String syncableId() {
        return this.syncableId;
    }

    public long instanceId() {
        return this.instanceId;
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
            GeoAnimatable animatable = GeckoLibUtil.getSyncedAnimatable(this.syncableId);
            if (animatable instanceof StatelessGeoSingletonAnimatable) {
                StatelessGeoSingletonAnimatable statelessAnimatable = (StatelessGeoSingletonAnimatable) animatable;
                statelessAnimatable.handleClientAnimationStop(animatable, this.instanceId, this.animation);
            }
        });
    }
}
