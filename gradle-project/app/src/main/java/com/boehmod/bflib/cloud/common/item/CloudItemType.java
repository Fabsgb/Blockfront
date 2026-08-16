package com.boehmod.bflib.cloud.common.item;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/item/CloudItemType.class */
public enum CloudItemType {
    ALL(0.0f, true),
    GENERIC(0.0f, false),
    BOOSTER(0.0f, false),
    CARD(0.0f, true),
    CAPE(0.0f, false),
    COIN(0.0f, true),
    GUN(1.0f, true),
    HAT(0.0f, false),
    KEY(0.0f, false),
    MELEE(0.0f, true),
    CASE(0.0f, false),
    STICKER(0.0f, false);

    private final float dropChance;
    private final boolean armoryFilter;

    CloudItemType(float dropChance, boolean armoryFilter) {
        this.dropChance = dropChance;
        this.armoryFilter = armoryFilter;
    }

    public float getDropChance() {
        return this.dropChance;
    }

    public boolean isArmoryFilter() {
        return this.armoryFilter;
    }
}
