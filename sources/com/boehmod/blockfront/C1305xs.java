package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xs */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xs.class */
public class C1305xs {

    /* JADX INFO: renamed from: e */
    @NotNull
    public static final DeferredRegister<DataComponentType<?>> f7517e = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, "bf");

    /* JADX INFO: renamed from: y */
    @Nonnull
    public static final Supplier<DataComponentType<Boolean>> f7518y = f7517e.register("has_tag", () -> {
        return DataComponentType.builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build();
    });

    /* JADX INFO: renamed from: z */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f7519z = f7517e.register("sticker0", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    /* JADX INFO: renamed from: A */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f7520A = f7517e.register("sticker1", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    /* JADX INFO: renamed from: B */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f7521B = f7517e.register("sticker2", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    /* JADX INFO: renamed from: C */
    @Nonnull
    public static final Supplier<DataComponentType<Float>> f7522C = f7517e.register("skin_id", () -> {
        return DataComponentType.builder().persistent(Codec.FLOAT).networkSynchronized(ByteBufCodecs.FLOAT).build();
    });

    /* JADX INFO: renamed from: D */
    @Nonnull
    public static final Supplier<DataComponentType<String>> f7523D = f7517e.register("original_owner", () -> {
        return DataComponentType.builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build();
    });

    /* JADX INFO: renamed from: E */
    @Nonnull
    public static final Supplier<DataComponentType<Boolean>> f7524E = f7517e.register("display_gun", () -> {
        return DataComponentType.builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build();
    });

    /* JADX INFO: renamed from: F */
    @Nonnull
    public static final Supplier<DataComponentType<String>> f7525F = f7517e.register("mag_type", () -> {
        return DataComponentType.builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build();
    });

    /* JADX INFO: renamed from: G */
    @Nonnull
    public static final Supplier<DataComponentType<String>> f7526G = f7517e.register("barrel_type", () -> {
        return DataComponentType.builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build();
    });

    /* JADX INFO: renamed from: H */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f7527H = f7517e.register("ammo", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    /* JADX INFO: renamed from: I */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f7528I = f7517e.register("ammo_loaded", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    /* JADX INFO: renamed from: J */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f7529J = f7517e.register("max_ammo", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    /* JADX INFO: renamed from: K */
    @Nonnull
    public static final Supplier<DataComponentType<Long>> f7530K = f7517e.register("reload_tick", () -> {
        return DataComponentType.builder().persistent(Codec.LONG).networkSynchronized(ByteBufCodecs.VAR_LONG).build();
    });

    /* JADX INFO: renamed from: L */
    @Nonnull
    public static final Supplier<DataComponentType<Long>> f7531L = f7517e.register("heat_timestamp", () -> {
        return DataComponentType.builder().persistent(Codec.LONG).networkSynchronized(ByteBufCodecs.VAR_LONG).build();
    });

    /* JADX INFO: renamed from: M */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f7532M = f7517e.register("fire_mode", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.VAR_INT).build();
    });

    /* JADX INFO: renamed from: N */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f7533N = f7517e.register("muzzle_flash", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    /* JADX INFO: renamed from: O */
    @Nonnull
    public static final Supplier<DataComponentType<Float>> f7534O = f7517e.register("heat", () -> {
        return DataComponentType.builder().persistent(Codec.FLOAT).networkSynchronized(ByteBufCodecs.FLOAT).build();
    });

    /* JADX INFO: renamed from: P */
    @Nonnull
    public static final Supplier<DataComponentType<Boolean>> f7535P = f7517e.register("scope", () -> {
        return DataComponentType.builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build();
    });

    /* JADX INFO: renamed from: Q */
    @Nonnull
    public static final Supplier<DataComponentType<Boolean>> f7536Q = f7517e.register("active", () -> {
        return DataComponentType.builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build();
    });

    /* JADX INFO: renamed from: R */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f7537R = f7517e.register("explode_time", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    /* JADX INFO: renamed from: S */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f7538S = f7517e.register("blood_amount", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    /* JADX INFO: renamed from: T */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f7539T = f7517e.register("mud_amount", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    /* JADX INFO: renamed from: U */
    @Nonnull
    public static final Supplier<DataComponentType<Double>> f7540U = f7517e.register("mint", () -> {
        return DataComponentType.builder().persistent(Codec.DOUBLE).networkSynchronized(ByteBufCodecs.DOUBLE).build();
    });

    /* JADX INFO: renamed from: V */
    @Nonnull
    public static final Supplier<DataComponentType<Boolean>> f7541V = f7517e.register("has_pattern", () -> {
        return DataComponentType.builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build();
    });

    /* JADX INFO: renamed from: W */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f7542W = f7517e.register("pattern_width", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    /* JADX INFO: renamed from: X */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f7543X = f7517e.register("pattern_height", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    /* JADX INFO: renamed from: Y */
    @Nonnull
    public static final Supplier<DataComponentType<String>> f7544Y = f7517e.register("pattern_name", () -> {
        return DataComponentType.builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build();
    });

    /* JADX INFO: renamed from: Z */
    @Nonnull
    public static final Supplier<DataComponentType<Boolean>> f7545Z = f7517e.register("generic", () -> {
        return DataComponentType.builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build();
    });
}
