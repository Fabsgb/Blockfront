package com.boehmod.blockfront;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uk */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uk.class */
public final class C1137uk extends C1136uj {
    public C1137uk(@NotNull String str, Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.C1136uj
    /* JADX INFO: renamed from: a */
    protected AbstractC0676mA mo5958a(@NotNull Level level) {
        return ((EntityType) C1230wX.f7046kP.get()).create(level);
    }

    @Override // com.boehmod.blockfront.C1136uj
    /* JADX INFO: renamed from: ab */
    public int mo6250ab() {
        return 60;
    }
}
