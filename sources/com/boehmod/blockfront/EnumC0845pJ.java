package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.pJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pJ.class */
public enum EnumC0845pJ {
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
    private final String f4555id;

    @NotNull
    public static final Codec<EnumC0845pJ> CODEC = Codec.STRING.xmap(EnumC0845pJ::fromId, (v0) -> {
        return v0.getId();
    });

    @NotNull
    private static final Map<String, EnumC0845pJ> BY_ID = (Map) Arrays.stream(values()).collect(Collectors.toMap((v0) -> {
        return v0.getId();
    }, Function.identity()));

    EnumC0845pJ(String str) {
        this.f4555id = str;
    }

    @Nullable
    public static EnumC0845pJ fromId(@NotNull String str) {
        return BY_ID.get(str);
    }

    @Nonnull
    public String getId() {
        return this.f4555id;
    }
}
