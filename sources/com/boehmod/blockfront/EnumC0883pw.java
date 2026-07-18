package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;

/* JADX INFO: renamed from: com.boehmod.blockfront.pw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pw.class */
public enum EnumC0883pw {
    DEFAULT(ColorReferences.COLOR_KILL_FEED_ENTRY_OUTLINE_COLOR_DEFAULT_TOP, ColorReferences.COLOR_KILL_FEED_ENTRY_OUTLINE_COLOR_DEFAULT_BOTTOM),
    SELF(ColorReferences.COLOR_KILL_FEED_ENTRY_OUTLINE_COLOR_SELF_TOP, ColorReferences.COLOR_KILL_FEED_ENTRY_OUTLINE_COLOR_SELF_BOTTOM),
    SELF_DEATH(ColorReferences.KILL_FEED_ENTRY_OUTLINE_COLOR_SELF_DEATH_TOP, ColorReferences.KILL_FEED_ENTRY_OUTLINE_COLOR_SELF_DEATH_BOTTOM);

    private final int outlineColorTop;
    private final int outlineColorBottom;

    EnumC0883pw(int i, int i2) {
        this.outlineColorTop = i;
        this.outlineColorBottom = i2;
    }

    public int getOutlineColorTop() {
        return this.outlineColorTop;
    }

    public int getOutlineColorBottom() {
        return this.outlineColorBottom;
    }
}
