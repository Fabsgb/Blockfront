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
import software.bernie.geckolib.animatable.stateless.StatelessAnimatable;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.ClientUtil;
import software.bernie.geckolib.util.RenderUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/network/packet/StatelessEntityPlayAnimPacket.class */
public final class StatelessEntityPlayAnimPacket extends Record implements MultiloaderPacket {
    private final int entityId;
    private final boolean isReplacedEntity;
    private final RawAnimation animation;
    public static final CustomPacketPayload.Type<StatelessEntityPlayAnimPacket> TYPE = new CustomPacketPayload.Type<>(GeckoLibConstants.m8356id("stateless_entity_play_anim"));
    public static final StreamCodec<FriendlyByteBuf, StatelessEntityPlayAnimPacket> CODEC = StreamCodec.composite(ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.entityId();
    }, ByteBufCodecs.BOOL, (v0) -> {
        return v0.isReplacedEntity();
    }, RawAnimation.STREAM_CODEC, (v0) -> {
        return v0.animation();
    }, (v1, v2, v3) -> {
        return new StatelessEntityPlayAnimPacket(v1, v2, v3);
    });

    public StatelessEntityPlayAnimPacket(int entityId, boolean isReplacedEntity, RawAnimation animation) {
        this.entityId = entityId;
        this.isReplacedEntity = isReplacedEntity;
        this.animation = animation;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, StatelessEntityPlayAnimPacket.class), StatelessEntityPlayAnimPacket.class, "entityId;isReplacedEntity;animation", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessEntityPlayAnimPacket;->entityId:I", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessEntityPlayAnimPacket;->isReplacedEntity:Z", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessEntityPlayAnimPacket;->animation:Lsoftware/bernie/geckolib/animation/RawAnimation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, StatelessEntityPlayAnimPacket.class), StatelessEntityPlayAnimPacket.class, "entityId;isReplacedEntity;animation", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessEntityPlayAnimPacket;->entityId:I", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessEntityPlayAnimPacket;->isReplacedEntity:Z", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessEntityPlayAnimPacket;->animation:Lsoftware/bernie/geckolib/animation/RawAnimation;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, StatelessEntityPlayAnimPacket.class, Object.class), StatelessEntityPlayAnimPacket.class, "entityId;isReplacedEntity;animation", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessEntityPlayAnimPacket;->entityId:I", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessEntityPlayAnimPacket;->isReplacedEntity:Z", "FIELD:Lsoftware/bernie/geckolib/network/packet/StatelessEntityPlayAnimPacket;->animation:Lsoftware/bernie/geckolib/animation/RawAnimation;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public int entityId() {
        return this.entityId;
    }

    public boolean isReplacedEntity() {
        return this.isReplacedEntity;
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
            GeoAnimatable replacedAnimatable;
            GeoAnimatable entity = ClientUtil.getLevel().getEntity(this.entityId);
            if (entity == null) {
                return;
            }
            if (this.isReplacedEntity) {
                replacedAnimatable = RenderUtil.getReplacedAnimatable(entity.getType());
            } else if (entity instanceof GeoAnimatable) {
                GeoAnimatable entityAnimatable = entity;
                replacedAnimatable = entityAnimatable;
            } else {
                replacedAnimatable = null;
            }
            GeoAnimatable animatable = replacedAnimatable;
            if (animatable instanceof StatelessAnimatable) {
                StatelessAnimatable statelessAnimatable = (StatelessAnimatable) animatable;
                statelessAnimatable.handleClientAnimationPlay(animatable, this.entityId, this.animation);
            }
        });
    }
}
