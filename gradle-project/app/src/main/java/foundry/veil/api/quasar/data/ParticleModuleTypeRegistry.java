package foundry.veil.api.quasar.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import foundry.veil.Veil;
import foundry.veil.api.quasar.data.module.ModuleType;
import foundry.veil.api.quasar.data.module.ParticleModuleData;
import foundry.veil.api.quasar.data.module.collision.CollisionSubEmitterData;
import foundry.veil.api.quasar.data.module.collision.DieOnCollisionModuleData;
import foundry.veil.api.quasar.data.module.force.DragForceData;
import foundry.veil.api.quasar.data.module.force.GravityForceData;
import foundry.veil.api.quasar.data.module.force.PointAttractorForceData;
import foundry.veil.api.quasar.data.module.force.PointForceData;
import foundry.veil.api.quasar.data.module.force.VectorFieldForceData;
import foundry.veil.api.quasar.data.module.force.VortexForceData;
import foundry.veil.api.quasar.data.module.force.WindForceData;
import foundry.veil.api.quasar.data.module.init.BlockParticleModuleData;
import foundry.veil.api.quasar.data.module.init.InitSizeParticleModuleData;
import foundry.veil.api.quasar.data.module.init.InitSubEmitterModuleData;
import foundry.veil.api.quasar.data.module.init.InitialVelocityModuleData;
import foundry.veil.api.quasar.data.module.init.LightModuleData;
import foundry.veil.api.quasar.data.module.init.LightmapParticleModuleData;
import foundry.veil.api.quasar.data.module.render.ColorParticleModuleData;
import foundry.veil.api.quasar.data.module.render.TrailParticleModuleData;
import foundry.veil.api.quasar.data.module.update.TickSizeParticleModuleData;
import foundry.veil.api.quasar.data.module.update.TickSubEmitterModuleData;
import foundry.veil.api.quasar.emitters.module.init.InitRandomRotationModuleData;
import foundry.veil.api.quasar.emitters.module.update.VectorField;
import foundry.veil.api.util.CodecUtil;
import foundry.veil.api.util.FastNoiseLite;
import foundry.veil.impl.quasar.ColorGradient;
import foundry.veil.platform.registry.RegistrationProvider;
import gg.moonflower.molangcompiler.api.MolangExpression;
import java.util.ArrayList;
import java.util.function.Supplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;
import org.joml.Vector3d;
import org.joml.Vector3f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/data/ParticleModuleTypeRegistry.class */
public class ParticleModuleTypeRegistry {
    public static final ResourceKey<Registry<ModuleType<?>>> REGISTRY_KEY = ResourceKey.createRegistryKey(Veil.veilPath("quasar/module_type"));
    private static final RegistrationProvider<ModuleType<?>> PROVIDER = RegistrationProvider.get(REGISTRY_KEY, Veil.MODID);

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    private static final RegistrationProvider<ModuleType<?>> INIT_MODULES_PROVIDER = PROVIDER;

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    private static final RegistrationProvider<ModuleType<?>> UPDATE_MODULES_PROVIDER = PROVIDER;

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    private static final RegistrationProvider<ModuleType<?>> RENDER_MODULES_PROVIDER = PROVIDER;
    public static final Registry<ModuleType<? extends ParticleModuleData>> REGISTRY = PROVIDER.asVanillaRegistry();

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public static final Registry<ModuleType<? extends ParticleModuleData>> INIT_MODULES_REGISTRY = REGISTRY;

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public static final Registry<ModuleType<? extends ParticleModuleData>> UPDATE_MODULES_REGISTRY = REGISTRY;

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public static final Registry<ModuleType<? extends ParticleModuleData>> RENDER_MODULES_REGISTRY = REGISTRY;
    public static final Codec<ModuleType<?>> CODEC = CodecUtil.registryOrLegacyCodec(REGISTRY);

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public static final Codec<ModuleType<?>> INIT_MODULE_CODEC = CODEC;

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public static final Codec<ModuleType<?>> UPDATE_MODULE_CODEC = CODEC;

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public static final Codec<ModuleType<?>> RENDER_MODULE_CODEC = CODEC;
    public static final ModuleType<InitialVelocityModuleData> INITIAL_VELOCITY = registerModule("initial_velocity", InitialVelocityModuleData.CODEC, () -> {
        return new InitialVelocityModuleData(new Vector3d(0.0d, 1.0d, 0.0d), false, 1.0f);
    });
    public static final ModuleType<InitSubEmitterModuleData> INIT_SUB_EMITTER = registerModule("init_sub_emitter", InitSubEmitterModuleData.CODEC, () -> {
        return new InitSubEmitterModuleData(ResourceLocation.withDefaultNamespace(""));
    });

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public static final ModuleType<InitSizeParticleModuleData> INIT_SIZE = registerDeprecatedModule("init_size", InitSizeParticleModuleData.CODEC, () -> {
        return new InitSizeParticleModuleData(MolangExpression.of(1.0f));
    }, "Use \"random_size\" instead", "5.0.0");

    @ApiStatus.ScheduledForRemoval(inVersion = "5.0.0")
    @Deprecated
    public static final ModuleType<InitRandomRotationModuleData> INIT_RANDOM_ROTATION = registerDeprecatedModule("init_random_rotation", InitRandomRotationModuleData.CODEC, () -> {
        return new InitRandomRotationModuleData(new Vector3f(-180.0f, -180.0f, -180.0f), new Vector3f(180.0f, 180.0f, 180.0f));
    }, "Use \"random_initial_rotation\" instead", "5.0.0");
    public static final ModuleType<LightModuleData> LIGHT = registerModule("light", LightModuleData.CODEC, () -> {
        return new LightModuleData(new ColorGradient(1.0f, 1.0f, 1.0f, 1.0f), MolangExpression.of(1.0f), MolangExpression.of(1.0f));
    });
    public static final ModuleType<LightmapParticleModuleData> LIGHTMAP = registerModule("lightmap", LightmapParticleModuleData.CODEC, () -> {
        return new LightmapParticleModuleData(15728880);
    });
    public static final ModuleType<BlockParticleModuleData> BLOCK_PARTICLE = registerModule("block", BlockParticleModuleData.CODEC, () -> {
        return new BlockParticleModuleData(false);
    });
    public static final ModuleType<TrailParticleModuleData> TRAIL = registerModule("trail", TrailParticleModuleData.CODEC, () -> {
        return new TrailParticleModuleData(new ArrayList());
    });
    public static final ModuleType<ColorParticleModuleData> COLOR = registerModule("color", ColorParticleModuleData.CODEC, () -> {
        return new ColorParticleModuleData(new ColorGradient(1.0f, 1.0f, 1.0f, 1.0f), MolangExpression.ZERO);
    });
    public static final ModuleType<TickSizeParticleModuleData> TICK_SIZE = registerModule("size", TickSizeParticleModuleData.CODEC, () -> {
        return new TickSizeParticleModuleData(MolangExpression.of(1.0f));
    });
    public static final ModuleType<TickSubEmitterModuleData> TICK_SUB_EMITTER = registerModule("tick_sub_emitter", TickSubEmitterModuleData.CODEC, () -> {
        return new TickSubEmitterModuleData(ResourceLocation.withDefaultNamespace(""), 5);
    });
    public static final ModuleType<DieOnCollisionModuleData> DIE_ON_COLLISION = registerModule("die_on_collision", DieOnCollisionModuleData.CODEC, DieOnCollisionModuleData::new);
    public static final ModuleType<CollisionSubEmitterData> SUB_EMITTER_COLLISION = registerModule("sub_emitter_collision", CollisionSubEmitterData.CODEC, () -> {
        return new CollisionSubEmitterData(ResourceLocation.withDefaultNamespace(""));
    });
    public static final ModuleType<GravityForceData> GRAVITY = registerModule("gravity", GravityForceData.CODEC, () -> {
        return new GravityForceData(1.0d);
    });
    public static final ModuleType<VortexForceData> VORTEX = registerModule("vortex", VortexForceData.CODEC, () -> {
        return new VortexForceData(new Vector3d(0.0d, 1.0d, 0.0d), new Vector3d(0.0d), true, 10.0d, 1.0f);
    });
    public static final ModuleType<PointAttractorForceData> POINT_ATTRACTOR = registerModule("point_attractor", PointAttractorForceData.CODEC, () -> {
        return new PointAttractorForceData(new Vector3d(0.0d), true, 20.0f, 1.0f, false, false);
    });
    public static final ModuleType<VectorFieldForceData> VECTOR_FIELD = registerModule("vector_field", VectorFieldForceData.CODEC, () -> {
        return new VectorFieldForceData(new VectorField(new FastNoiseLite(), 1.0f), 1.0f);
    });
    public static final ModuleType<DragForceData> DRAG = registerModule("drag", DragForceData.CODEC, () -> {
        return new DragForceData(0.5d);
    });
    public static final ModuleType<WindForceData> WIND = registerModule("wind", WindForceData.CODEC, () -> {
        return new WindForceData(new Vector3d(1.0d, 0.0d, 0.0d), 0.5f, 1.0f);
    });
    public static final ModuleType<PointForceData> POINT = registerModule("point_force", PointForceData.CODEC, () -> {
        return new PointForceData(new Vector3d(0.0d), true, 20.0f, 1.0f);
    });

    @ApiStatus.Internal
    public static void bootstrap() {
    }

    private static <T extends ParticleModuleData> ModuleType<T> registerModule(String str, final MapCodec<T> mapCodec, final Supplier<T> supplier) {
        ModuleType<T> moduleType = (ModuleType<T>) new ModuleType<T>() { // from class: foundry.veil.api.quasar.data.ParticleModuleTypeRegistry.1
            @Override // foundry.veil.api.quasar.data.module.ModuleType
            public MapCodec<T> codec() {
                return mapCodec;
            }

            @Override // foundry.veil.api.quasar.data.module.ModuleType
            public Supplier<T> defaultValue() {
                return supplier;
            }
        };
        PROVIDER.register(str, () -> {
            return moduleType;
        });
        return moduleType;
    }

    @Deprecated
    private static <T extends ParticleModuleData> ModuleType<T> registerDeprecatedModule(String str, final MapCodec<T> mapCodec, final Supplier<T> supplier, String str2, String str3) {
        final ModuleType.DeprecationStatus deprecationStatus = new ModuleType.DeprecationStatus(str2, str3);
        ModuleType<T> moduleType = (ModuleType<T>) new ModuleType<T>() { // from class: foundry.veil.api.quasar.data.ParticleModuleTypeRegistry.2
            @Override // foundry.veil.api.quasar.data.module.ModuleType
            public MapCodec<T> codec() {
                return mapCodec;
            }

            @Override // foundry.veil.api.quasar.data.module.ModuleType
            public Supplier<T> defaultValue() {
                return supplier;
            }

            @Override // foundry.veil.api.quasar.data.module.ModuleType
            public ModuleType.DeprecationStatus deprecationStatus() {
                return deprecationStatus;
            }
        };
        PROVIDER.register(str, () -> {
            return moduleType;
        });
        return moduleType;
    }
}
