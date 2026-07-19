package com.boehmod.blockfront;

import com.boehmod.blockfront.C0550uj;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uh.class */
public final class C0548uh extends C0550uj {
    public C0548uh(@NotNull String str, Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.C0550uj
    protected mA a(@NotNull Level level) {
        return ((EntityType) wX.kM.get()).create(level);
    }

    @Override // com.boehmod.blockfront.C0550uj
    @NotNull
    public C0550uj.a a() {
        return C0550uj.a.FIRE;
    }
}
