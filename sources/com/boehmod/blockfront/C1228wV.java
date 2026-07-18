package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wV.class */
public class C1228wV {

    /* JADX INFO: renamed from: e */
    @NotNull
    public static final DeferredRegister<DataComponentType<?>> f6954e = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, "bf");

    /* JADX INFO: renamed from: y */
    @Nonnull
    public static final Supplier<DataComponentType<Boolean>> f6955y = f6954e.register("has_tag", () -> {
        return DataComponentType.builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build();
    });

    /* JADX INFO: renamed from: z */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f6956z = f6954e.register("sticker0", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    /* JADX INFO: renamed from: A */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f6957A = f6954e.register("sticker1", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    /* JADX INFO: renamed from: B */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f6958B = f6954e.register("sticker2", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    /* JADX INFO: renamed from: C */
    @Nonnull
    public static final Supplier<DataComponentType<Float>> f6959C = f6954e.register("skin_id", () -> {
        return DataComponentType.builder().persistent(Codec.FLOAT).networkSynchronized(ByteBufCodecs.FLOAT).build();
    });

    /* JADX INFO: renamed from: D */
    @Nonnull
    public static final Supplier<DataComponentType<String>> f6960D = f6954e.register("original_owner", () -> {
        return DataComponentType.builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build();
    });

    /* JADX INFO: renamed from: E */
    @Nonnull
    public static final Supplier<DataComponentType<Boolean>> f6961E = f6954e.register("display_gun", () -> {
        return DataComponentType.builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build();
    });

    /* JADX INFO: renamed from: F */
    @Nonnull
    public static final Supplier<DataComponentType<String>> f6962F = f6954e.register("mag_type", () -> {
        return DataComponentType.builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build();
    });

    /* JADX INFO: renamed from: G */
    @Nonnull
    public static final Supplier<DataComponentType<String>> f6963G = f6954e.register("barrel_type", () -> {
        return DataComponentType.builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build();
    });

    /* JADX INFO: renamed from: H */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f6964H = f6954e.register("ammo", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    /* JADX INFO: renamed from: I */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f6965I = f6954e.register("ammo_loaded", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    /* JADX INFO: renamed from: J */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f6966J = f6954e.register("max_ammo", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    /* JADX INFO: renamed from: K */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f6967K = f6954e.register("reload_tick", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    /* JADX INFO: renamed from: L */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f6968L = f6954e.register("muzzle_flash", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    /* JADX INFO: renamed from: M */
    @Nonnull
    public static final Supplier<DataComponentType<Float>> f6969M = f6954e.register("heat", () -> {
        return DataComponentType.builder().persistent(Codec.FLOAT).networkSynchronized(ByteBufCodecs.FLOAT).build();
    });

    /* JADX INFO: renamed from: N */
    @Nonnull
    public static final Supplier<DataComponentType<Boolean>> f6970N = f6954e.register("scope", () -> {
        return DataComponentType.builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build();
    });

    /* JADX INFO: renamed from: O */
    @Nonnull
    public static final Supplier<DataComponentType<Boolean>> f6971O = f6954e.register("active", () -> {
        return DataComponentType.builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build();
    });

    /* JADX INFO: renamed from: P */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f6972P = f6954e.register("explode_time", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    /* JADX INFO: renamed from: Q */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f6973Q = f6954e.register("blood_amount", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    /* JADX INFO: renamed from: R */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f6974R = f6954e.register("mud_amount", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    /* JADX INFO: renamed from: S */
    @Nonnull
    public static final Supplier<DataComponentType<Double>> f6975S = f6954e.register("mint", () -> {
        return DataComponentType.builder().persistent(Codec.DOUBLE).networkSynchronized(ByteBufCodecs.DOUBLE).build();
    });

    /* JADX INFO: renamed from: T */
    @Nonnull
    public static final Supplier<DataComponentType<Boolean>> f6976T = f6954e.register("has_pattern", () -> {
        return DataComponentType.builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build();
    });

    /* JADX INFO: renamed from: U */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f6977U = f6954e.register("pattern_width", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    /* JADX INFO: renamed from: V */
    @Nonnull
    public static final Supplier<DataComponentType<Integer>> f6978V = f6954e.register("pattern_height", () -> {
        return DataComponentType.builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build();
    });

    /* JADX INFO: renamed from: W */
    @Nonnull
    public static final Supplier<DataComponentType<String>> f6979W = f6954e.register("pattern_name", () -> {
        return DataComponentType.builder().persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8).build();
    });

    /* JADX INFO: renamed from: X */
    @Nonnull
    public static final Supplier<DataComponentType<Boolean>> f6980X = f6954e.register("generic", () -> {
        return DataComponentType.builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build();
    });
}
