package foundry.veil.forge.network;

import foundry.veil.api.network.VeilPacketManager;
import foundry.veil.api.network.handler.ClientPacketContext;
import foundry.veil.api.network.handler.PacketContext;
import foundry.veil.api.network.handler.ServerPacketContext;
import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Objects;
import java.util.Set;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.javafmlmod.FMLModContainer;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/forge/network/NeoForgeVeilPacketManager.class */
@ApiStatus.Internal
public class NeoForgeVeilPacketManager implements VeilPacketManager {
    private final String version;
    private final Set<RegisteredPacket<ClientPacketContext>> clientPackets;
    private final Set<RegisteredPacket<ServerPacketContext>> serverPackets;

    public NeoForgeVeilPacketManager(String modId, String version) {
        FMLModContainer fMLModContainer = (ModContainer) ModList.get().getModContainerById(modId).orElseThrow(() -> {
            return new NullPointerException("Cannot find mod container for id " + modId);
        });
        if (!(fMLModContainer instanceof FMLModContainer)) {
            throw new ClassCastException("The container of the mod " + modId + " is not a FML one!");
        }
        FMLModContainer forgeContainer = fMLModContainer;
        this.version = version;
        this.clientPackets = new ObjectArraySet();
        this.serverPackets = new ObjectArraySet();
        ((IEventBus) Objects.requireNonNull(forgeContainer.getEventBus())).addListener(this::registerHandler);
    }

    private void registerHandler(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar(this.version);
        PayloadRegistrar optionalRegistrar = registrar.optional();
        for (RegisteredPacket<ClientPacketContext> packet : this.clientPackets) {
            VeilPacketManager.PacketHandler handler = ((RegisteredPacket) packet).handler;
            (((RegisteredPacket) packet).optional ? optionalRegistrar : registrar).playToClient(((RegisteredPacket) packet).id, ((RegisteredPacket) packet).codec, (payload, context) -> {
                handler.handlePacket(payload, new NeoForgeClientPacketContext(context));
            });
        }
        for (RegisteredPacket<ServerPacketContext> packet2 : this.serverPackets) {
            VeilPacketManager.PacketHandler handler2 = ((RegisteredPacket) packet2).handler;
            (((RegisteredPacket) packet2).optional ? optionalRegistrar : registrar).playToServer(((RegisteredPacket) packet2).id, ((RegisteredPacket) packet2).codec, (payload2, context2) -> {
                handler2.handlePacket(payload2, new NeoForgeServerPacketContext(context2));
            });
        }
    }

    @Override // foundry.veil.api.network.VeilPacketManager
    public <T extends CustomPacketPayload> void registerClientbound(CustomPacketPayload.Type<T> id, StreamCodec<? super RegistryFriendlyByteBuf, T> codec, VeilPacketManager.PacketHandler<ClientPacketContext, T> handler, boolean optional) {
        this.clientPackets.add(new RegisteredPacket<>(id, codec, handler, optional));
    }

    @Override // foundry.veil.api.network.VeilPacketManager
    public <T extends CustomPacketPayload> void registerServerbound(CustomPacketPayload.Type<T> id, StreamCodec<? super RegistryFriendlyByteBuf, T> codec, VeilPacketManager.PacketHandler<ServerPacketContext, T> handler, boolean optional) {
        this.serverPackets.add(new RegisteredPacket<>(id, codec, handler, optional));
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/forge/network/NeoForgeVeilPacketManager$RegisteredPacket.class */
    private static final class RegisteredPacket<T extends PacketContext> extends Record {
        private final CustomPacketPayload.Type<? extends CustomPacketPayload> id;
        private final StreamCodec<? super RegistryFriendlyByteBuf, ?> codec;
        private final VeilPacketManager.PacketHandler<T, ?> handler;
        private final boolean optional;

        private RegisteredPacket(CustomPacketPayload.Type<? extends CustomPacketPayload> id, StreamCodec<? super RegistryFriendlyByteBuf, ?> codec, VeilPacketManager.PacketHandler<T, ?> handler, boolean optional) {
            this.id = id;
            this.codec = codec;
            this.handler = handler;
            this.optional = optional;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, RegisteredPacket.class), RegisteredPacket.class, "id;codec;handler;optional", "FIELD:Lfoundry/veil/forge/network/NeoForgeVeilPacketManager$RegisteredPacket;->id:Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "FIELD:Lfoundry/veil/forge/network/NeoForgeVeilPacketManager$RegisteredPacket;->codec:Lnet/minecraft/network/codec/StreamCodec;", "FIELD:Lfoundry/veil/forge/network/NeoForgeVeilPacketManager$RegisteredPacket;->handler:Lfoundry/veil/api/network/VeilPacketManager$PacketHandler;", "FIELD:Lfoundry/veil/forge/network/NeoForgeVeilPacketManager$RegisteredPacket;->optional:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, RegisteredPacket.class), RegisteredPacket.class, "id;codec;handler;optional", "FIELD:Lfoundry/veil/forge/network/NeoForgeVeilPacketManager$RegisteredPacket;->id:Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "FIELD:Lfoundry/veil/forge/network/NeoForgeVeilPacketManager$RegisteredPacket;->codec:Lnet/minecraft/network/codec/StreamCodec;", "FIELD:Lfoundry/veil/forge/network/NeoForgeVeilPacketManager$RegisteredPacket;->handler:Lfoundry/veil/api/network/VeilPacketManager$PacketHandler;", "FIELD:Lfoundry/veil/forge/network/NeoForgeVeilPacketManager$RegisteredPacket;->optional:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, RegisteredPacket.class, Object.class), RegisteredPacket.class, "id;codec;handler;optional", "FIELD:Lfoundry/veil/forge/network/NeoForgeVeilPacketManager$RegisteredPacket;->id:Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "FIELD:Lfoundry/veil/forge/network/NeoForgeVeilPacketManager$RegisteredPacket;->codec:Lnet/minecraft/network/codec/StreamCodec;", "FIELD:Lfoundry/veil/forge/network/NeoForgeVeilPacketManager$RegisteredPacket;->handler:Lfoundry/veil/api/network/VeilPacketManager$PacketHandler;", "FIELD:Lfoundry/veil/forge/network/NeoForgeVeilPacketManager$RegisteredPacket;->optional:Z").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public CustomPacketPayload.Type<? extends CustomPacketPayload> id() {
            return this.id;
        }

        public StreamCodec<? super RegistryFriendlyByteBuf, ?> codec() {
            return this.codec;
        }

        public VeilPacketManager.PacketHandler<T, ?> handler() {
            return this.handler;
        }

        public boolean optional() {
            return this.optional;
        }
    }
}
