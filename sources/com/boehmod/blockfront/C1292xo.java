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

/* JADX INFO: renamed from: com.boehmod.blockfront.xo */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xo.class */
public class C1292xo {

    /* JADX INFO: renamed from: c */
    @NotNull
    private static final Logger f8642c = LogManager.getLogger("RegistryUtils");

    @Nullable
    /* JADX INFO: renamed from: a */
    public static Supplier<BlockEntityType<?>> m7881a(@NotNull String str) {
        BlockEntityType blockEntityType = (BlockEntityType) BuiltInRegistries.BLOCK_ENTITY_TYPE.get(ResourceLocation.tryParse(str));
        if (blockEntityType == null) {
            f8642c.warn("Failed to find block entity type for given key: {}", str);
            return null;
        }
        return () -> {
            return blockEntityType;
        };
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public static String m7882b(@NotNull Supplier<? extends BlockEntityType<?>> supplier) {
        ResourceLocation key = BlockEntityType.getKey(supplier.get());
        if (key == null) {
            f8642c.warn("Failed to find key for given block entity type: {}", supplier.get());
        }
        if (key != null) {
            return key.toString();
        }
        return null;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static Supplier<EntityType<?>> m7883b(@NotNull String str) {
        return () -> {
            return (EntityType) BuiltInRegistries.ENTITY_TYPE.get(ResourceLocation.tryParse(str));
        };
    }

    @NotNull
    /* JADX INFO: renamed from: i */
    public static Collection<String> m7884i() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        Iterator it = BuiltInRegistries.ENTITY_TYPE.keySet().iterator();
        while (it.hasNext()) {
            objectArrayList.add(((ResourceLocation) it.next()).toString());
        }
        return objectArrayList;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public static String m7885c(@NotNull Supplier<? extends EntityType<?>> supplier) {
        return BuiltInRegistries.ENTITY_TYPE.getKey(supplier.get()).toString();
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public static Supplier<Block> m7886c(@NotNull String str) {
        return () -> {
            return (Block) BuiltInRegistries.BLOCK.get(ResourceLocation.tryParse(str));
        };
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public static String m7887c(@NotNull Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).toString();
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public static Supplier<SoundEvent> m7888d(@NotNull String str) {
        SoundEvent soundEvent = (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.tryParse(str));
        if (soundEvent == null) {
            f8642c.warn("Failed to find sound event for given key: '{}'", str);
            return null;
        }
        return () -> {
            return soundEvent;
        };
    }

    @Nullable
    /* JADX INFO: renamed from: f */
    public static String m7889f(@NotNull SoundEvent soundEvent) {
        ResourceLocation key = BuiltInRegistries.SOUND_EVENT.getKey(soundEvent);
        if (key == null) {
            f8642c.warn("Failed to find key for given sound event: '{}'", soundEvent);
        }
        if (key != null) {
            return key.toString();
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    public static Supplier<ParticleType<?>> m7890e(@NotNull String str) {
        ParticleType particleType = (ParticleType) BuiltInRegistries.PARTICLE_TYPE.get(ResourceLocation.tryParse(str));
        if (particleType == null) {
            f8642c.warn("Failed to find particle type for given key: '{}'", str);
            return null;
        }
        return () -> {
            return particleType;
        };
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static String m7891a(@NotNull ParticleType<?> particleType) {
        ResourceLocation key = BuiltInRegistries.PARTICLE_TYPE.getKey(particleType);
        if (key == null) {
            f8642c.warn("Failed to find key for given particle type: '{}'", particleType);
        }
        if (key != null) {
            return key.toString();
        }
        return null;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static String m7892a(@NotNull Item item) {
        return BuiltInRegistries.ITEM.getKey(item).toString();
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    public static Supplier<Item> m7893f(@NotNull String str) {
        return () -> {
            return (Item) BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(str));
        };
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ResourceLocation m7894a(@NotNull Supplier<? extends EntityType<?>> supplier) {
        return BuiltInRegistries.ENTITY_TYPE.getKey(supplier.get());
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Supplier<EntityType<?>> m7895a(@NotNull ResourceLocation resourceLocation) {
        return () -> {
            return (EntityType) BuiltInRegistries.ENTITY_TYPE.get(resourceLocation);
        };
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ResourceLocation m7896a(@NotNull Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static Supplier<Block> m7897b(@NotNull ResourceLocation resourceLocation) {
        return () -> {
            return (Block) BuiltInRegistries.BLOCK.get(resourceLocation);
        };
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public static ResourceLocation m7898b(@NotNull Supplier<? extends BlockEntityType<?>> supplier) {
        return BlockEntityType.getKey(supplier.get());
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public static Supplier<BlockEntityType<?>> m7899c(@NotNull ResourceLocation resourceLocation) {
        BlockEntityType blockEntityType = (BlockEntityType) BuiltInRegistries.BLOCK_ENTITY_TYPE.get(resourceLocation);
        if (blockEntityType == null) {
            f8642c.warn("Failed to find block entity type for given key: {}", resourceLocation);
            return null;
        }
        return () -> {
            return blockEntityType;
        };
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static ResourceLocation m7900a(@NotNull SoundEvent soundEvent) {
        return BuiltInRegistries.SOUND_EVENT.getKey(soundEvent);
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public static Supplier<SoundEvent> m7901d(@NotNull ResourceLocation resourceLocation) {
        SoundEvent soundEvent = (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(resourceLocation);
        if (soundEvent == null) {
            f8642c.warn("Failed to find sound event for given key: '{}'", resourceLocation);
            return null;
        }
        return () -> {
            return soundEvent;
        };
    }
}
