package com.boehmod.bflib.cloud.common.item.types;

import com.boehmod.bflib.cloud.common.item.ActivatedCloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import com.boehmod.bflib.cloud.common.item.CloudResourceLocation;
import com.boehmod.bflib.cloud.common.player.Booster;
import com.boehmod.bflib.cloud.common.player.BoosterType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/item/types/CloudItemBooster.class */
public class CloudItemBooster extends ActivatedCloudItem<CloudItemBooster> {

    @NotNull
    private final BoosterType type;
    private final int minutes;
    private final int multiplier;

    public CloudItemBooster(int id, @NotNull String name, @NotNull CloudResourceLocation cloudResourceLocation, @NotNull BoosterType type, int minutes, int multiplier) {
        super(id, name, cloudResourceLocation);
        this.type = type;
        this.minutes = minutes;
        this.multiplier = multiplier;
        setItemType(CloudItemType.BOOSTER);
        disableEquip();
        disableShowcase();
    }

    @NotNull
    public Booster createNewBooster() {
        return new Booster(this.type, this.minutes, this.multiplier);
    }
}
