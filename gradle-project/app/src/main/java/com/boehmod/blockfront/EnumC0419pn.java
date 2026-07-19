package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.pn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pn.class */
public enum EnumC0419pn {
    SNOW("snow"),
    LIGHT_SNOW("light_snow"),
    HEAVY_SNOW("heavy_snow"),
    FALLING_LEAVES("falling_leaves"),
    RAINSTORM("rainstorm"),
    SANDSTORM("sandstorm"),
    SANDY_FLOOR("sandy_floor"),
    SNOWY_FLOOR("snowy_floor");


    @NotNull
    private final String id;

    @NotNull
    public static final Codec<EnumC0419pn> CODEC = Codec.STRING.xmap(EnumC0419pn::fromId, (v0) -> {
        return v0.getId();
    });

    @NotNull
    private static final Map<String, EnumC0419pn> BY_ID = (Map) Arrays.stream(values()).collect(Collectors.toMap((v0) -> {
        return v0.getId();
    }, Function.identity()));

    EnumC0419pn(@NotNull String str) {
        this.id = str;
    }

    @Nullable
    public static EnumC0419pn fromId(@NotNull String str) {
        return BY_ID.get(str);
    }

    @Nonnull
    public String getId() {
        return this.id;
    }
}
