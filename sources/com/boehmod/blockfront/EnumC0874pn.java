package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.pn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pn.class */
public enum EnumC0874pn {
    SNOW("snow"),
    LIGHT_SNOW("light_snow"),
    HEAVY_SNOW("heavy_snow"),
    FALLING_LEAVES("falling_leaves"),
    RAINSTORM("rainstorm"),
    SANDSTORM("sandstorm"),
    SANDY_FLOOR("sandy_floor"),
    SNOWY_FLOOR("snowy_floor");


    /* JADX INFO: renamed from: id */
    @NotNull
    private final String f4586id;

    @NotNull
    public static final Codec<EnumC0874pn> CODEC = Codec.STRING.xmap(EnumC0874pn::fromId, (v0) -> {
        return v0.getId();
    });

    @NotNull
    private static final Map<String, EnumC0874pn> BY_ID = (Map) Arrays.stream(values()).collect(Collectors.toMap((v0) -> {
        return v0.getId();
    }, Function.identity()));

    EnumC0874pn(@NotNull String str) {
        this.f4586id = str;
    }

    @Nullable
    public static EnumC0874pn fromId(@NotNull String str) {
        return BY_ID.get(str);
    }

    @Nonnull
    public String getId() {
        return this.f4586id;
    }
}
