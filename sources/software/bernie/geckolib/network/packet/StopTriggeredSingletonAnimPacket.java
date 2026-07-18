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
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/network/packet/StopTriggeredSingletonAnimPacket.class */
public final class StopTriggeredSingletonAnimPacket extends Record implements MultiloaderPacket {
    private final String syncableId;
    private final long instanceId;
    private final String controllerName;
    private final String animName;
    public static final CustomPacketPayload.Type<StopTriggeredSingletonAnimPacket> TYPE = new CustomPacketPayload.Type<>(GeckoLibConstants.m8005id("stop_triggered_singleton_anim"));
    public static final StreamCodec<FriendlyByteBuf, StopTriggeredSingletonAnimPacket> CODEC = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, (v0) -> {
        return v0.syncableId();
    }, ByteBufCodecs.VAR_LONG, (v0) -> {
        return v0.instanceId();
    }, ByteBufCodecs.STRING_UTF8, (v0) -> {
        return v0.controllerName();
    }, ByteBufCodecs.STRING_UTF8, (v0) -> {
        return v0.animName();
    }, (v1, v2, v3, v4) -> {
        return new StopTriggeredSingletonAnimPacket(v1, v2, v3, v4);
    });

    public StopTriggeredSingletonAnimPacket(String syncableId, long instanceId, String controllerName, String animName) {
        this.syncableId = syncableId;
        this.instanceId = instanceId;
        this.controllerName = controllerName;
        this.animName = animName;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, StopTriggeredSingletonAnimPacket.class), StopTriggeredSingletonAnimPacket.class, "syncableId;instanceId;controllerName;animName", "FIELD:Lsoftware/bernie/geckolib/network/packet/StopTriggeredSingletonAnimPacket;->syncableId:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/network/packet/StopTriggeredSingletonAnimPacket;->instanceId:J", "FIELD:Lsoftware/bernie/geckolib/network/packet/StopTriggeredSingletonAnimPacket;->controllerName:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/network/packet/StopTriggeredSingletonAnimPacket;->animName:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, StopTriggeredSingletonAnimPacket.class), StopTriggeredSingletonAnimPacket.class, "syncableId;instanceId;controllerName;animName", "FIELD:Lsoftware/bernie/geckolib/network/packet/StopTriggeredSingletonAnimPacket;->syncableId:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/network/packet/StopTriggeredSingletonAnimPacket;->instanceId:J", "FIELD:Lsoftware/bernie/geckolib/network/packet/StopTriggeredSingletonAnimPacket;->controllerName:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/network/packet/StopTriggeredSingletonAnimPacket;->animName:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, StopTriggeredSingletonAnimPacket.class, Object.class), StopTriggeredSingletonAnimPacket.class, "syncableId;instanceId;controllerName;animName", "FIELD:Lsoftware/bernie/geckolib/network/packet/StopTriggeredSingletonAnimPacket;->syncableId:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/network/packet/StopTriggeredSingletonAnimPacket;->instanceId:J", "FIELD:Lsoftware/bernie/geckolib/network/packet/StopTriggeredSingletonAnimPacket;->controllerName:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/network/packet/StopTriggeredSingletonAnimPacket;->animName:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public String syncableId() {
        return this.syncableId;
    }

    public long instanceId() {
        return this.instanceId;
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
            AnimatableManager<GeoAnimatable> animatableManager;
            GeoAnimatable animatable = GeckoLibUtil.getSyncedAnimatable(this.syncableId);
            if (animatable != null && (animatableManager = animatable.getAnimatableInstanceCache().getManagerForId(this.instanceId)) != null) {
                animatableManager.stopTriggeredAnimation(this.controllerName.isEmpty() ? null : this.controllerName, this.animName.isEmpty() ? null : this.animName);
            }
        });
    }
}
