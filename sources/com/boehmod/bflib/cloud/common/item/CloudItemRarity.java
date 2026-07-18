package com.boehmod.bflib.cloud.common.item;

import com.boehmod.blockfront.C0479iP;
import net.kyori.adventure.text.format.TextColor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/item/CloudItemRarity.class */
public enum CloudItemRarity {
    DEFAULT(C0479iP.f2938ax, -11118500, -2433307, 0.0f),
    COAL("Coal", -11308150, -2231809, 0.8f),
    IRON("Iron", -16743713, -3741697, 0.15f),
    LAPIS("Lapis", -11187795, -2238209, 0.03f),
    GOLD("Gold", -5487711, -9989, 0.006f),
    DIAMOND("Diamond", -1626042, -10533, 0.002f),
    OBSIDIAN("Obsidian", -15304, -4407, 0.001f);

    private final int color;
    private final int chatColor;

    @NotNull
    private final String name;
    private final float dropChance;

    CloudItemRarity(@NotNull String name, int color, int chatColor, float dropChance) {
        this.name = name;
        this.color = color;
        this.chatColor = chatColor;
        this.dropChance = dropChance;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getColor() {
        return this.color;
    }

    public final int getChatColor() {
        return this.chatColor;
    }

    @NotNull
    public final TextColor getTextColor() {
        return TextColor.color(getColor());
    }

    @NotNull
    public final TextColor getChatTextColor() {
        return TextColor.color(getChatColor());
    }

    public final float getDropChance() {
        return this.dropChance;
    }
}
