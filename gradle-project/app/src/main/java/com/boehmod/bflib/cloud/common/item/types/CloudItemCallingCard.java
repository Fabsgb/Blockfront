package com.boehmod.bflib.cloud.common.item.types;

import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import com.boehmod.bflib.cloud.common.item.CloudResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/item/types/CloudItemCallingCard.class */
public class CloudItemCallingCard extends CloudItem<CloudItemCallingCard> {
    public CloudItemCallingCard(int id, @NotNull String name, @NotNull CloudResourceLocation cloudResourceLocation) {
        super(id, name, cloudResourceLocation);
        setItemType(CloudItemType.CARD);
    }
}
