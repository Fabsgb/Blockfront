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
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.GeoReplacedEntity;
import software.bernie.geckolib.util.ClientUtil;
import software.bernie.geckolib.util.RenderUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/network/packet/StopTriggeredEntityAnimPacket.class */
public final class StopTriggeredEntityAnimPacket extends Record implements MultiloaderPacket {
    private final int entityId;
    private final boolean isReplacedEntity;
    private final String controllerName;
    private final String animName;
    public static final CustomPacketPayload.Type<StopTriggeredEntityAnimPacket> TYPE = new CustomPacketPayload.Type<>(GeckoLibConstants.m8356id("stop_triggered_entity_anim"));
    public static final StreamCodec<FriendlyByteBuf, StopTriggeredEntityAnimPacket> CODEC = StreamCodec.composite(ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.entityId();
    }, ByteBufCodecs.BOOL, (v0) -> {
        return v0.isReplacedEntity();
    }, ByteBufCodecs.STRING_UTF8, (v0) -> {
        return v0.controllerName();
    }, ByteBufCodecs.STRING_UTF8, (v0) -> {
        return v0.animName();
    }, (v1, v2, v3, v4) -> {
        return new StopTriggeredEntityAnimPacket(v1, v2, v3, v4);
    });

    public StopTriggeredEntityAnimPacket(int entityId, boolean isReplacedEntity, String controllerName, String animName) {
        this.entityId = entityId;
        this.isReplacedEntity = isReplacedEntity;
        this.controllerName = controllerName;
        this.animName = animName;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, StopTriggeredEntityAnimPacket.class), StopTriggeredEntityAnimPacket.class, "entityId;isReplacedEntity;controllerName;animName", "FIELD:Lsoftware/bernie/geckolib/network/packet/StopTriggeredEntityAnimPacket;->entityId:I", "FIELD:Lsoftware/bernie/geckolib/network/packet/StopTriggeredEntityAnimPacket;->isReplacedEntity:Z", "FIELD:Lsoftware/bernie/geckolib/network/packet/StopTriggeredEntityAnimPacket;->controllerName:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/network/packet/StopTriggeredEntityAnimPacket;->animName:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, StopTriggeredEntityAnimPacket.class), StopTriggeredEntityAnimPacket.class, "entityId;isReplacedEntity;controllerName;animName", "FIELD:Lsoftware/bernie/geckolib/network/packet/StopTriggeredEntityAnimPacket;->entityId:I", "FIELD:Lsoftware/bernie/geckolib/network/packet/StopTriggeredEntityAnimPacket;->isReplacedEntity:Z", "FIELD:Lsoftware/bernie/geckolib/network/packet/StopTriggeredEntityAnimPacket;->controllerName:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/network/packet/StopTriggeredEntityAnimPacket;->animName:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, StopTriggeredEntityAnimPacket.class, Object.class), StopTriggeredEntityAnimPacket.class, "entityId;isReplacedEntity;controllerName;animName", "FIELD:Lsoftware/bernie/geckolib/network/packet/StopTriggeredEntityAnimPacket;->entityId:I", "FIELD:Lsoftware/bernie/geckolib/network/packet/StopTriggeredEntityAnimPacket;->isReplacedEntity:Z", "FIELD:Lsoftware/bernie/geckolib/network/packet/StopTriggeredEntityAnimPacket;->controllerName:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/network/packet/StopTriggeredEntityAnimPacket;->animName:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public int entityId() {
        return this.entityId;
    }

    public boolean isReplacedEntity() {
        return this.isReplacedEntity;
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
            GeoEntity entity = ClientUtil.getLevel().getEntity(this.entityId);
            if (entity == null) {
                return;
            }
            if (!this.isReplacedEntity) {
                if (entity instanceof GeoEntity) {
                    GeoEntity geoEntity = entity;
                    geoEntity.stopTriggeredAnim(this.controllerName.isEmpty() ? null : this.controllerName, this.animName.isEmpty() ? null : this.animName);
                    return;
                }
                return;
            }
            GeoAnimatable patt0$temp = RenderUtil.getReplacedAnimatable(entity.getType());
            if (patt0$temp instanceof GeoReplacedEntity) {
                GeoReplacedEntity replacedEntity = (GeoReplacedEntity) patt0$temp;
                replacedEntity.stopTriggeredAnim(entity, this.controllerName.isEmpty() ? null : this.controllerName, this.animName.isEmpty() ? null : this.animName);
            }
        });
    }
}
