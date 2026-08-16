package com.boehmod.bflib.cloud.common.item;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/item/CaseContent.class */
public class CaseContent {

    /* JADX INFO: renamed from: id */
    private final int f0id;

    public CaseContent(int id) {
        this.f0id = id;
    }

    @Nullable
    public CloudItem<?> getCloudItem(@NotNull CloudRegistry cloudRegistry) {
        return cloudRegistry.getItem(this.f0id);
    }
}
