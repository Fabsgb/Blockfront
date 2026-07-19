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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/network/packet/EntityAnimTriggerPacket.class */
public final class EntityAnimTriggerPacket extends Record implements MultiloaderPacket {
    private final int entityId;
    private final boolean isReplacedEntity;
    private final String controllerName;
    private final String animName;
    public static final CustomPacketPayload.Type<EntityAnimTriggerPacket> TYPE = new CustomPacketPayload.Type<>(GeckoLibConstants.id("entity_anim_trigger"));
    public static final StreamCodec<FriendlyByteBuf, EntityAnimTriggerPacket> CODEC = StreamCodec.composite(ByteBufCodecs.VAR_INT, (v0) -> {
        return v0.entityId();
    }, ByteBufCodecs.BOOL, (v0) -> {
        return v0.isReplacedEntity();
    }, ByteBufCodecs.STRING_UTF8, (v0) -> {
        return v0.controllerName();
    }, ByteBufCodecs.STRING_UTF8, (v0) -> {
        return v0.animName();
    }, (v1, v2, v3, v4) -> {
        return new EntityAnimTriggerPacket(v1, v2, v3, v4);
    });

    public EntityAnimTriggerPacket(int entityId, boolean isReplacedEntity, String controllerName, String animName) {
        this.entityId = entityId;
        this.isReplacedEntity = isReplacedEntity;
        this.controllerName = controllerName;
        this.animName = animName;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, EntityAnimTriggerPacket.class), EntityAnimTriggerPacket.class, "entityId;isReplacedEntity;controllerName;animName", "FIELD:Lsoftware/bernie/geckolib/network/packet/EntityAnimTriggerPacket;->entityId:I", "FIELD:Lsoftware/bernie/geckolib/network/packet/EntityAnimTriggerPacket;->isReplacedEntity:Z", "FIELD:Lsoftware/bernie/geckolib/network/packet/EntityAnimTriggerPacket;->controllerName:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/network/packet/EntityAnimTriggerPacket;->animName:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, EntityAnimTriggerPacket.class), EntityAnimTriggerPacket.class, "entityId;isReplacedEntity;controllerName;animName", "FIELD:Lsoftware/bernie/geckolib/network/packet/EntityAnimTriggerPacket;->entityId:I", "FIELD:Lsoftware/bernie/geckolib/network/packet/EntityAnimTriggerPacket;->isReplacedEntity:Z", "FIELD:Lsoftware/bernie/geckolib/network/packet/EntityAnimTriggerPacket;->controllerName:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/network/packet/EntityAnimTriggerPacket;->animName:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, EntityAnimTriggerPacket.class, Object.class), EntityAnimTriggerPacket.class, "entityId;isReplacedEntity;controllerName;animName", "FIELD:Lsoftware/bernie/geckolib/network/packet/EntityAnimTriggerPacket;->entityId:I", "FIELD:Lsoftware/bernie/geckolib/network/packet/EntityAnimTriggerPacket;->isReplacedEntity:Z", "FIELD:Lsoftware/bernie/geckolib/network/packet/EntityAnimTriggerPacket;->controllerName:Ljava/lang/String;", "FIELD:Lsoftware/bernie/geckolib/network/packet/EntityAnimTriggerPacket;->animName:Ljava/lang/String;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
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
                    geoEntity.triggerAnim(this.controllerName.isEmpty() ? null : this.controllerName, this.animName);
                    return;
                }
                return;
            }
            GeoAnimatable patt0$temp = RenderUtil.getReplacedAnimatable(entity.getType());
            if (patt0$temp instanceof GeoReplacedEntity) {
                GeoReplacedEntity replacedEntity = (GeoReplacedEntity) patt0$temp;
                replacedEntity.triggerAnim(entity, this.controllerName.isEmpty() ? null : this.controllerName, this.animName);
            }
        });
    }
}
