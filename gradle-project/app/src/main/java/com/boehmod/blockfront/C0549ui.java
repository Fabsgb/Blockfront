package com.boehmod.blockfront;

import com.boehmod.blockfront.C0550uj;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ui, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ui.class */
public final class C0549ui extends C0550uj {
    public C0549ui(@NotNull String str, Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.C0550uj
    protected mA a(@NotNull Level level) {
        return ((EntityType) wX.kK.get()).create(level);
    }

    @Override // com.boehmod.blockfront.C0550uj
    public int ab() {
        return 20;
    }

    @Override // com.boehmod.blockfront.C0550uj
    @NotNull
    public C0550uj.a a() {
        return C0550uj.a.FLASH;
    }
}
