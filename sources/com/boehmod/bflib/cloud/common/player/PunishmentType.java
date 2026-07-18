package com.boehmod.bflib.cloud.common.player;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/player/PunishmentType.class */
public enum PunishmentType {
    MUTE("Muted", "bf.message.punishment.type.mute", false),
    WARNING("Warned", "bf.message.punishment.type.warn", true),
    BAN_COMP("Competitive Cooldown", "bf.message.punishment.type.comp.cooldown", false),
    BAN_MM("Match-making Banned", "bf.message.punishment.type.ban.mm", false),
    BAN_CLOUD("Cloud Banned", "bf.message.punishment.type.ban.cloud", true);


    @NotNull
    private final String displayName;

    @NotNull
    private final String translatableName;
    private final boolean isOverlapping;

    PunishmentType(@NotNull String name, @NotNull String translatableName, boolean overlapping) {
        this.displayName = name;
        this.translatableName = translatableName;
        this.isOverlapping = overlapping;
    }

    @NotNull
    public String getDisplayName() {
        return this.displayName;
    }

    @NotNull
    public String getTranslatableName() {
        return this.translatableName;
    }

    public boolean isOverlapping() {
        return this.isOverlapping;
    }
}
