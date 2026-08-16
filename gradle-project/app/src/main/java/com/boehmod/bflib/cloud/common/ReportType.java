package com.boehmod.bflib.cloud.common;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/ReportType.class */
public enum ReportType {
    CHAT_ABUSE("Chat", "Chat spam, harassment, offensive language and abuse", "chat"),
    VOICE_CHAT_ABUSE("Voice", "VC spam, harassment, offensive language and abuse", "voice"),
    CHEATING("Hack", "Hacked clients, X-ray and visual enhancements", "cheating"),
    EXPLOITING("Exploit", "Map exploits and game changing glitches", "exploiting"),
    BAD_NAME("Username", "Inappropriate or offensive username", "bad_name"),
    BAD_SKIN("Skin", "Inappropriate or offensive player skin", "bad_skin"),
    BAD_CLAN("Clan", "Inappropriate or offensive clan name", "bad_clan");


    @NotNull
    private final String title;

    @NotNull
    private final String description;

    @NotNull
    private final String tag;

    ReportType(@NotNull String title, String description, String tag) {
        this.title = title;
        this.description = description;
        this.tag = tag;
    }

    @Nullable
    public static ReportType fromTag(@NotNull String tag) {
        for (ReportType reportType : values()) {
            if (reportType.getTag().equals(tag)) {
                return reportType;
            }
        }
        return null;
    }

    @NotNull
    public String getTitle() {
        return this.title;
    }

    @NotNull
    public String getDescription() {
        return this.description;
    }

    @NotNull
    public String getTag() {
        return this.tag;
    }
}
