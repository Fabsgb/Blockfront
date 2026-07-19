package com.boehmod.blockfront;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uk.class */
public final class C0551uk extends C0550uj {
    public C0551uk(@NotNull String str, Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.C0550uj
    protected mA a(@NotNull Level level) {
        return ((EntityType) wX.kP.get()).create(level);
    }

    @Override // com.boehmod.blockfront.C0550uj
    public int ab() {
        return 60;
    }
}
