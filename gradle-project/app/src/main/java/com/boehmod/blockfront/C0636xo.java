package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Supplier;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.xo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xo.class */
public class C0636xo {

    @NotNull
    private static final Logger c = LogManager.getLogger("RegistryUtils");

    @Nullable
    public static Supplier<BlockEntityType<?>> a(@NotNull String str) {
        BlockEntityType blockEntityType = (BlockEntityType) BuiltInRegistries.BLOCK_ENTITY_TYPE.get(ResourceLocation.tryParse(str));
        if (blockEntityType == null) {
            c.warn("Failed to find block entity type for given key: {}", str);
            return null;
        }
        return () -> {
            return blockEntityType;
        };
    }

    @Nullable
    public static String b(@NotNull Supplier<? extends BlockEntityType<?>> supplier) {
        ResourceLocation key = BlockEntityType.getKey(supplier.get());
        if (key == null) {
            c.warn("Failed to find key for given block entity type: {}", supplier.get());
        }
        if (key != null) {
            return key.toString();
        }
        return null;
    }

    @NotNull
    public static Supplier<EntityType<?>> b(@NotNull String str) {
        return () -> {
            return (EntityType) BuiltInRegistries.ENTITY_TYPE.get(ResourceLocation.tryParse(str));
        };
    }

    @NotNull
    public static Collection<String> i() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        Iterator it = BuiltInRegistries.ENTITY_TYPE.keySet().iterator();
        while (it.hasNext()) {
            objectArrayList.add(((ResourceLocation) it.next()).toString());
        }
        return objectArrayList;
    }

    @NotNull
    public static String c(@NotNull Supplier<? extends EntityType<?>> supplier) {
        return BuiltInRegistries.ENTITY_TYPE.getKey(supplier.get()).toString();
    }

    @NotNull
    public static Supplier<Block> c(@NotNull String str) {
        return () -> {
            return (Block) BuiltInRegistries.BLOCK.get(ResourceLocation.tryParse(str));
        };
    }

    @NotNull
    public static String c(@NotNull Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).toString();
    }

    @Nullable
    public static Supplier<SoundEvent> d(@NotNull String str) {
        SoundEvent soundEvent = (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.tryParse(str));
        if (soundEvent == null) {
            c.warn("Failed to find sound event for given key: '{}'", str);
            return null;
        }
        return () -> {
            return soundEvent;
        };
    }

    @Nullable
    public static String f(@NotNull SoundEvent soundEvent) {
        ResourceLocation key = BuiltInRegistries.SOUND_EVENT.getKey(soundEvent);
        if (key == null) {
            c.warn("Failed to find key for given sound event: '{}'", soundEvent);
        }
        if (key != null) {
            return key.toString();
        }
        return null;
    }

    @Nullable
    public static Supplier<ParticleType<?>> e(@NotNull String str) {
        ParticleType particleType = (ParticleType) BuiltInRegistries.PARTICLE_TYPE.get(ResourceLocation.tryParse(str));
        if (particleType == null) {
            c.warn("Failed to find particle type for given key: '{}'", str);
            return null;
        }
        return () -> {
            return particleType;
        };
    }

    @Nullable
    public static String a(@NotNull ParticleType<?> particleType) {
        ResourceLocation key = BuiltInRegistries.PARTICLE_TYPE.getKey(particleType);
        if (key == null) {
            c.warn("Failed to find key for given particle type: '{}'", particleType);
        }
        if (key != null) {
            return key.toString();
        }
        return null;
    }

    @NotNull
    public static String a(@NotNull Item item) {
        return BuiltInRegistries.ITEM.getKey(item).toString();
    }

    @NotNull
    public static Supplier<Item> f(@NotNull String str) {
        return () -> {
            return (Item) BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(str));
        };
    }

    @NotNull
    public static ResourceLocation a(@NotNull Supplier<? extends EntityType<?>> supplier) {
        return BuiltInRegistries.ENTITY_TYPE.getKey(supplier.get());
    }

    @NotNull
    public static Supplier<EntityType<?>> a(@NotNull ResourceLocation resourceLocation) {
        return () -> {
            return (EntityType) BuiltInRegistries.ENTITY_TYPE.get(resourceLocation);
        };
    }

    @NotNull
    public static ResourceLocation a(@NotNull Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    @NotNull
    public static Supplier<Block> b(@NotNull ResourceLocation resourceLocation) {
        return () -> {
            return (Block) BuiltInRegistries.BLOCK.get(resourceLocation);
        };
    }

    @Nullable
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static ResourceLocation m1696b(@NotNull Supplier<? extends BlockEntityType<?>> supplier) {
        return BlockEntityType.getKey(supplier.get());
    }

    @Nullable
    public static Supplier<BlockEntityType<?>> c(@NotNull ResourceLocation resourceLocation) {
        BlockEntityType blockEntityType = (BlockEntityType) BuiltInRegistries.BLOCK_ENTITY_TYPE.get(resourceLocation);
        if (blockEntityType == null) {
            c.warn("Failed to find block entity type for given key: {}", resourceLocation);
            return null;
        }
        return () -> {
            return blockEntityType;
        };
    }

    @Nullable
    public static ResourceLocation a(@NotNull SoundEvent soundEvent) {
        return BuiltInRegistries.SOUND_EVENT.getKey(soundEvent);
    }

    @Nullable
    public static Supplier<SoundEvent> d(@NotNull ResourceLocation resourceLocation) {
        SoundEvent soundEvent = (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(resourceLocation);
        if (soundEvent == null) {
            c.warn("Failed to find sound event for given key: '{}'", resourceLocation);
            return null;
        }
        return () -> {
            return soundEvent;
        };
    }
}
