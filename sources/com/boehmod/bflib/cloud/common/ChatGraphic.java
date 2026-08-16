package com.boehmod.bflib.cloud.common;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/ChatGraphic.class */
public enum ChatGraphic {
    WARNING(57346, 9, 2),
    QUESTION(57347, 9, 2),
    ANTI_CHEAT(57350, 9, 2);

    private final char character;
    private final int width;
    private final int height;

    ChatGraphic(char character, int width, int height) {
        this.character = character;
        this.width = width;
        this.height = height;
    }

    public char getCharacter() {
        return this.character;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
