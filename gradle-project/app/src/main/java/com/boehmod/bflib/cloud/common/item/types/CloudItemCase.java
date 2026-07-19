package com.boehmod.bflib.cloud.common.item.types;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CaseContent;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import com.boehmod.bflib.cloud.common.item.CloudResourceLocation;
import com.boehmod.bflib.common.RandomCollection;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/item/types/CloudItemCase.class */
public class CloudItemCase extends CloudItem<CloudItemCase> {
    public static final int RANDOM_COUNT = 30;

    @NotNull
    public final RandomCollection<CaseContent> content;

    @NotNull
    public final CloudItemKey key;

    public CloudItemCase(int id, @NotNull String name, @NotNull CloudResourceLocation cloudResourceLocation, @NotNull CloudItemKey key) {
        super(id, name, cloudResourceLocation);
        this.content = new RandomCollection<>();
        this.key = key;
        setItemType(CloudItemType.CASE);
        disableEquip();
    }

    @NotNull
    public IntList calculateCapsuleResult(@NotNull CloudRegistry cloudRegistry) {
        IntArrayList integers = new IntArrayList();
        for (int i = 0; i < 30; i++) {
            CloudItem<?> cloudItem = this.content.getRandom().getCloudItem(cloudRegistry);
            if (cloudItem != null) {
                integers.add(cloudItem.getId());
            }
        }
        return integers;
    }

    @NotNull
    public CloudItemCase addContent(@NotNull CloudItem<?> cloudItem, int weight) {
        this.content.add(weight, new CaseContent(cloudItem.getId()));
        return this;
    }

    @NotNull
    public CloudItemCase addContent(@NotNull CaseContent caseContent, int weight) {
        this.content.add(weight, caseContent);
        return this;
    }

    @NotNull
    public CloudItem<?> getKey() {
        return this.key;
    }
}
