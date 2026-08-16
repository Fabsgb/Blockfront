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
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/network/packet/StatelessSingletonPlayAnimPacket.class */
public final class StatelessSingletonPlayAnimPacket extends Record implements MultiloaderPacket {
    private final String syncableId;
    private final long instanceId;
    private final RawAnimation animation;
    public static final CustomPacketPayload.Type<StatelessSingletonPlayAnimPacket> TYPE = new CustomPacketPayload.Type<>(GeckoLibConstants.m8356id("stateless_singleton_play_anim"));
    public static final StreamCodec<FriendlyByteBuf, StatelessSingletonPlayAnimPacket> CODEC = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, (v0) -> {
        return v0.syncableId();
    }, ByteBufCodecs.VAR_LONG, (v0) -> {
        return v0.instanceId();
    }, RawAnimation.STREAM_CODEC, (v0) -> {
        return v0.animation();
    }, (v1, v2, v3) -> {
        return new StatelessSingletonPlayAnimPacket(v1, v2, v3);
    });

    public StatelessSingletonPlayAnimPacket(String syncableId, long instanceId, RawAnimation animation) {
        this.syncableId = syncableId;
        this.instanceId = instanceId;
        this.animation = animation;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, StatelessSingletonPlayAnimPacket.class), StatelessSingletonPlayAnimPacket.class, "syncableId;instanceId;animation", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessSingletonPlayAnimPacket;->syncableId:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessSingletonPlayAnimPacket;->instanceId:J", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessSingletonPlayAnimPacket;->animation:Lsoftware/bernie/geckolib/animation/RawAnimation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, StatelessSingletonPlayAnimPacket.class), StatelessSingletonPlayAnimPacket.class, "syncableId;instanceId;animation", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessSingletonPlayAnimPacket;->syncableId:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessSingletonPlayAnimPacket;->instanceId:J", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessSingletonPlayAnimPacket;->animation:Lsoftware/bernie/geckolib/animation/RawAnimation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, StatelessSingletonPlayAnimPacket.class, Object.class), StatelessSingletonPlayAnimPacket.class, "syncableId;instanceId;animation", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessSingletonPlayAnimPacket;->syncableId:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessSingletonPlayAnimPacket;->instanceId:J", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessSingletonPlayAnimPacket;->animation:Lsoftware/bernie/geckolib/animation/RawAnimation;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public String syncableId() {
        return this.syncableId;
    }

    public long instanceId() {
        return this.instanceId;
    }

    public RawAnimation animation() {
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
                statelessAnimatable.handleClientAnimationPlay(animatable, this.instanceId, this.animation);
            }
        });
    }
}
