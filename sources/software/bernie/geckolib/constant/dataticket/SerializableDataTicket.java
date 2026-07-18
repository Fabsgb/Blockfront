package software.bernie.geckolib.constant.dataticket;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/constant/dataticket/SerializableDataTicket.class */
public abstract class SerializableDataTicket<D> extends DataTicket<D> {
    public static final StreamCodec<RegistryFriendlyByteBuf, SerializableDataTicket<?>> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, (v0) -> {
        return v0.m8008id();
    }, DataTickets::byName);

    public abstract StreamCodec<? super RegistryFriendlyByteBuf, D> streamCodec();

    public SerializableDataTicket(String id, Class<? extends D> objectType) {
        super(id, objectType);
    }

    /* JADX INFO: renamed from: software.bernie.geckolib.constant.dataticket.SerializableDataTicket$1 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/constant/dataticket/SerializableDataTicket$1.class */
    class C14651 extends SerializableDataTicket<Double> {
        C14651(String id, Class cls) {
            super(id, cls);
        }

        @Override // software.bernie.geckolib.constant.dataticket.SerializableDataTicket
        public StreamCodec<? super RegistryFriendlyByteBuf, Double> streamCodec() {
            return ByteBufCodecs.DOUBLE;
        }
    }

    public static SerializableDataTicket<Double> ofDouble(ResourceLocation id) {
        return new SerializableDataTicket<Double>(id.toString(), Double.class) { // from class: software.bernie.geckolib.constant.dataticket.SerializableDataTicket.1
            C14651(String id2, Class cls) {
                super(id2, cls);
            }

            @Override // software.bernie.geckolib.constant.dataticket.SerializableDataTicket
            public StreamCodec<? super RegistryFriendlyByteBuf, Double> streamCodec() {
                return ByteBufCodecs.DOUBLE;
            }
        };
    }

    /* JADX INFO: renamed from: software.bernie.geckolib.constant.dataticket.SerializableDataTicket$2 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/constant/dataticket/SerializableDataTicket$2.class */
    class C14662 extends SerializableDataTicket<Float> {
        C14662(String id, Class cls) {
            super(id, cls);
        }

        @Override // software.bernie.geckolib.constant.dataticket.SerializableDataTicket
        public StreamCodec<? super RegistryFriendlyByteBuf, Float> streamCodec() {
            return ByteBufCodecs.FLOAT;
        }
    }

    public static SerializableDataTicket<Float> ofFloat(ResourceLocation id) {
        return new SerializableDataTicket<Float>(id.toString(), Float.class) { // from class: software.bernie.geckolib.constant.dataticket.SerializableDataTicket.2
            C14662(String id2, Class cls) {
                super(id2, cls);
            }

            @Override // software.bernie.geckolib.constant.dataticket.SerializableDataTicket
            public StreamCodec<? super RegistryFriendlyByteBuf, Float> streamCodec() {
                return ByteBufCodecs.FLOAT;
            }
        };
    }

    /* JADX INFO: renamed from: software.bernie.geckolib.constant.dataticket.SerializableDataTicket$3 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/constant/dataticket/SerializableDataTicket$3.class */
    class C14673 extends SerializableDataTicket<Boolean> {
        C14673(String id, Class cls) {
            super(id, cls);
        }

        @Override // software.bernie.geckolib.constant.dataticket.SerializableDataTicket
        public StreamCodec<? super RegistryFriendlyByteBuf, Boolean> streamCodec() {
            return ByteBufCodecs.BOOL;
        }
    }

    public static SerializableDataTicket<Boolean> ofBoolean(ResourceLocation id) {
        return new SerializableDataTicket<Boolean>(id.toString(), Boolean.class) { // from class: software.bernie.geckolib.constant.dataticket.SerializableDataTicket.3
            C14673(String id2, Class cls) {
                super(id2, cls);
            }

            @Override // software.bernie.geckolib.constant.dataticket.SerializableDataTicket
            public StreamCodec<? super RegistryFriendlyByteBuf, Boolean> streamCodec() {
                return ByteBufCodecs.BOOL;
            }
        };
    }

    /* JADX INFO: renamed from: software.bernie.geckolib.constant.dataticket.SerializableDataTicket$4 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/constant/dataticket/SerializableDataTicket$4.class */
    class C14684 extends SerializableDataTicket<Integer> {
        C14684(String id, Class cls) {
            super(id, cls);
        }

        @Override // software.bernie.geckolib.constant.dataticket.SerializableDataTicket
        public StreamCodec<? super RegistryFriendlyByteBuf, Integer> streamCodec() {
            return ByteBufCodecs.VAR_INT;
        }
    }

    public static SerializableDataTicket<Integer> ofInt(ResourceLocation id) {
        return new SerializableDataTicket<Integer>(id.toString(), Integer.class) { // from class: software.bernie.geckolib.constant.dataticket.SerializableDataTicket.4
            C14684(String id2, Class cls) {
                super(id2, cls);
            }

            @Override // software.bernie.geckolib.constant.dataticket.SerializableDataTicket
            public StreamCodec<? super RegistryFriendlyByteBuf, Integer> streamCodec() {
                return ByteBufCodecs.VAR_INT;
            }
        };
    }

    /* JADX INFO: renamed from: software.bernie.geckolib.constant.dataticket.SerializableDataTicket$5 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/constant/dataticket/SerializableDataTicket$5.class */
    class C14695 extends SerializableDataTicket<String> {
        C14695(String id, Class cls) {
            super(id, cls);
        }

        @Override // software.bernie.geckolib.constant.dataticket.SerializableDataTicket
        public StreamCodec<? super RegistryFriendlyByteBuf, String> streamCodec() {
            return ByteBufCodecs.STRING_UTF8;
        }
    }

    public static SerializableDataTicket<String> ofString(ResourceLocation id) {
        return new SerializableDataTicket<String>(id.toString(), String.class) { // from class: software.bernie.geckolib.constant.dataticket.SerializableDataTicket.5
            C14695(String id2, Class cls) {
                super(id2, cls);
            }

            @Override // software.bernie.geckolib.constant.dataticket.SerializableDataTicket
            public StreamCodec<? super RegistryFriendlyByteBuf, String> streamCodec() {
                return ByteBufCodecs.STRING_UTF8;
            }
        };
    }

    /* JADX INFO: renamed from: software.bernie.geckolib.constant.dataticket.SerializableDataTicket$6 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/constant/dataticket/SerializableDataTicket$6.class */
    class C14706<E> extends SerializableDataTicket<E> {
        final /* synthetic */ Class val$enumClass;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14706(String id, Class cls, Class cls2) {
            super(id, cls);
            cls = cls2;
        }

        /* JADX INFO: renamed from: software.bernie.geckolib.constant.dataticket.SerializableDataTicket$6$1 */
        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/constant/dataticket/SerializableDataTicket$6$1.class */
        class AnonymousClass1 implements StreamCodec<RegistryFriendlyByteBuf, E> {
            AnonymousClass1() {
            }

            public Enum decode(RegistryFriendlyByteBuf buf) {
                return Enum.valueOf(cls, buf.readUtf());
            }

            public void encode(RegistryFriendlyByteBuf buf, Enum r5) {
                buf.writeUtf(r5.toString());
            }
        }

        @Override // software.bernie.geckolib.constant.dataticket.SerializableDataTicket
        public StreamCodec<? super RegistryFriendlyByteBuf, E> streamCodec() {
            return new StreamCodec<RegistryFriendlyByteBuf, E>() { // from class: software.bernie.geckolib.constant.dataticket.SerializableDataTicket.6.1
                AnonymousClass1() {
                }

                public Enum decode(RegistryFriendlyByteBuf buf) {
                    return Enum.valueOf(cls, buf.readUtf());
                }

                public void encode(RegistryFriendlyByteBuf buf, Enum r5) {
                    buf.writeUtf(r5.toString());
                }
            };
        }
    }

    public static <E extends Enum<E>> SerializableDataTicket<E> ofEnum(ResourceLocation id, Class<E> enumClass) {
        return new SerializableDataTicket<E>(id.toString(), enumClass) { // from class: software.bernie.geckolib.constant.dataticket.SerializableDataTicket.6
            final /* synthetic */ Class val$enumClass;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C14706(String id2, Class enumClass2, Class enumClass22) {
                super(id2, enumClass22);
                cls = enumClass22;
            }

            /* JADX INFO: renamed from: software.bernie.geckolib.constant.dataticket.SerializableDataTicket$6$1 */
            /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.7.3.jar:software/bernie/geckolib/constant/dataticket/SerializableDataTicket$6$1.class */
            class AnonymousClass1 implements StreamCodec<RegistryFriendlyByteBuf, E> {
                AnonymousClass1() {
                }

                public Enum decode(RegistryFriendlyByteBuf buf) {
                    return Enum.valueOf(cls, buf.readUtf());
                }

                public void encode(RegistryFriendlyByteBuf buf, Enum r5) {
                    buf.writeUtf(r5.toString());
                }
            }

            @Override // software.bernie.geckolib.constant.dataticket.SerializableDataTicket
            public StreamCodec<? super RegistryFriendlyByteBuf, E> streamCodec() {
                return new StreamCodec<RegistryFriendlyByteBuf, E>() { // from class: software.bernie.geckolib.constant.dataticket.SerializableDataTicket.6.1
                    AnonymousClass1() {
                    }

                    public Enum decode(RegistryFriendlyByteBuf buf) {
                        return Enum.valueOf(cls, buf.readUtf());
                    }

                    public void encode(RegistryFriendlyByteBuf buf, Enum r5) {
                        buf.writeUtf(r5.toString());
                    }
                };
            }
        };
    }
}
