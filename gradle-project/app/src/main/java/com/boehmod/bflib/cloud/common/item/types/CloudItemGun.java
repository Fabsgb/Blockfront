package com.boehmod.bflib.cloud.common.item.types;

import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import com.boehmod.bflib.cloud.common.item.CloudResourceLocation;
import com.boehmod.bflib.cloud.common.item.pattern.SkinPattern;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.util.List;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/item/types/CloudItemGun.class */
public class CloudItemGun extends CloudItem<CloudItemGun> {

    @NotNull
    private static final Int2ObjectOpenHashMap<CloudItemGun> GUNS = new Int2ObjectOpenHashMap<>();

    @Nullable
    private SkinPattern skinPattern;

    public CloudItemGun(int id, @NotNull String name, @NotNull CloudResourceLocation cloudResourceLocation) {
        super(id, name, cloudResourceLocation);
        GUNS.put(id, this);
        setItemType(CloudItemType.GUN);
    }

    @Nullable
    public static CloudItemGun getRandomGun() {
        if (GUNS.isEmpty()) {
            throw new IllegalStateException("No guns available");
        }
        List<CloudItemGun> guns = GUNS.values().stream().filter(item -> {
            return (item == null || item.isDeprecated() || !item.isDefault()) ? false : true;
        }).toList();
        if (guns.isEmpty()) {
            throw new IllegalStateException("No guns available");
        }
        int index = (int) (Math.random() * ((double) guns.size()));
        return guns.get(index);
    }

    @NotNull
    public CloudItemGun setPatternSkin(@NotNull SkinPattern skinPattern) {
        this.skinPattern = skinPattern;
        return this;
    }

    @Nullable
    public SkinPattern getPatternSkin() {
        return this.skinPattern;
    }

    public boolean hasPatternSkin() {
        return this.skinPattern != null;
    }
}
