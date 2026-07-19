package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wV.class */
public class wV {

    @NotNull
    public static final DeferredRegister<DataComponentType<?>> e = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, "bf");

    @Nonnull
    public static final Supplier<DataComponentType<Boolean>> y = e.register("has_tag", () -> {
        return DataComponentType.builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build();
    });

    @Nonnull
    public static final Supplier<DataComponentType<Integer>> z = e.register("sticker0", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    @Nonnull
    public static final Supplier<DataComponentType<Integer>> A = e.register("sticker1", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    @Nonnull
    public static final Supplier<DataComponentType<Integer>> B = e.register("sticker2", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    @Nonnull
    public static final Supplier<DataComponentType<Float>> C = e.register("skin_id", () -> {
        return DataComponentType.builder().persistent(Codec.FLOAT).networkSynchronized(ByteBufCodecs.FLOAT).build();
    });

    @Nonnull
    public static final Supplier<DataComponentType<String>> D = e.register("original_owner", () -> {
        return DataComponentType.builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build();
    });

    @Nonnull
    public static final Supplier<DataComponentType<Boolean>> E = e.register("display_gun", () -> {
        return DataComponentType.builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build();
    });

    @Nonnull
    public static final Supplier<DataComponentType<String>> F = e.register("mag_type", () -> {
        return DataComponentType.builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build();
    });

    @Nonnull
    public static final Supplier<DataComponentType<String>> G = e.register("barrel_type", () -> {
        return DataComponentType.builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build();
    });

    @Nonnull
    public static final Supplier<DataComponentType<Integer>> H = e.register("ammo", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    @Nonnull
    public static final Supplier<DataComponentType<Integer>> I = e.register("ammo_loaded", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    @Nonnull
    public static final Supplier<DataComponentType<Integer>> J = e.register("max_ammo", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    @Nonnull
    public static final Supplier<DataComponentType<Integer>> K = e.register("reload_tick", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    @Nonnull
    public static final Supplier<DataComponentType<Integer>> L = e.register("muzzle_flash", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    @Nonnull
    public static final Supplier<DataComponentType<Float>> M = e.register("heat", () -> {
        return DataComponentType.builder().persistent(Codec.FLOAT).networkSynchronized(ByteBufCodecs.FLOAT).build();
    });

    @Nonnull
    public static final Supplier<DataComponentType<Boolean>> N = e.register("scope", () -> {
        return DataComponentType.builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build();
    });

    @Nonnull
    public static final Supplier<DataComponentType<Boolean>> O = e.register("active", () -> {
        return DataComponentType.builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build();
    });

    @Nonnull
    public static final Supplier<DataComponentType<Integer>> P = e.register("explode_time", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    @Nonnull
    public static final Supplier<DataComponentType<Integer>> Q = e.register("blood_amount", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    @Nonnull
    public static final Supplier<DataComponentType<Integer>> R = e.register("mud_amount", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    @Nonnull
    public static final Supplier<DataComponentType<Double>> S = e.register("mint", () -> {
        return DataComponentType.builder().persistent(Codec.DOUBLE).networkSynchronized(ByteBufCodecs.DOUBLE).build();
    });

    @Nonnull
    public static final Supplier<DataComponentType<Boolean>> T = e.register("has_pattern", () -> {
        return DataComponentType.builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build();
    });

    @Nonnull
    public static final Supplier<DataComponentType<Integer>> U = e.register("pattern_width", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    @Nonnull
    public static final Supplier<DataComponentType<Integer>> V = e.register("pattern_height", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    @Nonnull
    public static final Supplier<DataComponentType<String>> W = e.register("pattern_name", () -> {
        return DataComponentType.builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build();
    });

    @Nonnull
    public static final Supplier<DataComponentType<Boolean>> X = e.register("generic", () -> {
        return DataComponentType.builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build();
    });
}
