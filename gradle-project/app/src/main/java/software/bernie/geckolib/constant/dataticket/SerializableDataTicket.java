package software.bernie.geckolib.constant.dataticket;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/constant/dataticket/SerializableDataTicket.class */
public abstract class SerializableDataTicket<D> extends DataTicket<D> {
    public static final StreamCodec<RegistryFriendlyByteBuf, SerializableDataTicket<?>> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, (v0) -> {
        return v0.id();
    }, DataTickets::byName);

    public abstract StreamCodec<? super RegistryFriendlyByteBuf, D> streamCodec();

    public SerializableDataTicket(String id, Class<? extends D> objectType) {
        super(id, objectType);
    }

    public static SerializableDataTicket<Double> ofDouble(ResourceLocation id) {
        return new SerializableDataTicket<Double>(id.toString(), Double.class) { // from class: software.bernie.geckolib.constant.dataticket.SerializableDataTicket.1
            @Override // software.bernie.geckolib.constant.dataticket.SerializableDataTicket
            public StreamCodec<? super RegistryFriendlyByteBuf, Double> streamCodec() {
                return ByteBufCodecs.DOUBLE;
            }
        };
    }

    public static SerializableDataTicket<Float> ofFloat(ResourceLocation id) {
        return new SerializableDataTicket<Float>(id.toString(), Float.class) { // from class: software.bernie.geckolib.constant.dataticket.SerializableDataTicket.2
            @Override // software.bernie.geckolib.constant.dataticket.SerializableDataTicket
            public StreamCodec<? super RegistryFriendlyByteBuf, Float> streamCodec() {
                return ByteBufCodecs.FLOAT;
            }
        };
    }

    public static SerializableDataTicket<Boolean> ofBoolean(ResourceLocation id) {
        return new SerializableDataTicket<Boolean>(id.toString(), Boolean.class) { // from class: software.bernie.geckolib.constant.dataticket.SerializableDataTicket.3
            @Override // software.bernie.geckolib.constant.dataticket.SerializableDataTicket
            public StreamCodec<? super RegistryFriendlyByteBuf, Boolean> streamCodec() {
                return ByteBufCodecs.BOOL;
            }
        };
    }

    public static SerializableDataTicket<Integer> ofInt(ResourceLocation id) {
        return new SerializableDataTicket<Integer>(id.toString(), Integer.class) { // from class: software.bernie.geckolib.constant.dataticket.SerializableDataTicket.4
            @Override // software.bernie.geckolib.constant.dataticket.SerializableDataTicket
            public StreamCodec<? super RegistryFriendlyByteBuf, Integer> streamCodec() {
                return ByteBufCodecs.VAR_INT;
            }
        };
    }

    public static SerializableDataTicket<String> ofString(ResourceLocation id) {
        return new SerializableDataTicket<String>(id.toString(), String.class) { // from class: software.bernie.geckolib.constant.dataticket.SerializableDataTicket.5
            @Override // software.bernie.geckolib.constant.dataticket.SerializableDataTicket
            public StreamCodec<? super RegistryFriendlyByteBuf, String> streamCodec() {
                return ByteBufCodecs.STRING_UTF8;
            }
        };
    }

    public static <E extends Enum<E>> SerializableDataTicket<E> ofEnum(ResourceLocation resourceLocation, final Class<E> cls) {
        return (SerializableDataTicket<E>) new SerializableDataTicket<E>(resourceLocation.toString(), cls) { // from class: software.bernie.geckolib.constant.dataticket.SerializableDataTicket.6
            @Override // software.bernie.geckolib.constant.dataticket.SerializableDataTicket
            public StreamCodec<? super RegistryFriendlyByteBuf, E> streamCodec() {
                return new StreamCodec<RegistryFriendlyByteBuf, E>() { // from class: software.bernie.geckolib.constant.dataticket.SerializableDataTicket.6.1
                    /* JADX WARN: Incorrect return type in method signature: (Lnet/minecraft/network/RegistryFriendlyByteBuf;)TE; */
                    public Enum decode(RegistryFriendlyByteBuf buf) {
                        return Enum.valueOf(cls, buf.readUtf());
                    }

                    /* JADX WARN: Incorrect types in method signature: (Lnet/minecraft/network/RegistryFriendlyByteBuf;TE;)V */
                    public void encode(RegistryFriendlyByteBuf buf, Enum r5) {
                        buf.writeUtf(r5.toString());
                    }
                };
            }
        };
    }
}
