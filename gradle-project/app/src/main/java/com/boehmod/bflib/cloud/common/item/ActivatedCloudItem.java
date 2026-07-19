package com.boehmod.bflib.cloud.common.item;

import com.boehmod.bflib.cloud.common.item.ActivatedCloudItem;
import com.boehmod.bflib.cloud.common.player.achievement.CloudAchievement;
import java.util.Optional;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/item/ActivatedCloudItem.class */
public class ActivatedCloudItem<T extends ActivatedCloudItem<T>> extends CloudItem<T> {

    @Nullable
    private CloudAchievement activationAchievement;

    public ActivatedCloudItem(int id, @NotNull String name, @NotNull CloudResourceLocation cloudResourceLocation) {
        super(id, name, cloudResourceLocation);
    }

    @NotNull
    public T setAchievement(@NotNull CloudAchievement achievement) {
        this.activationAchievement = achievement;
        return this;
    }

    @NotNull
    public Optional<CloudAchievement> getActivationAchievement() {
        return Optional.ofNullable(this.activationAchievement);
    }
}
