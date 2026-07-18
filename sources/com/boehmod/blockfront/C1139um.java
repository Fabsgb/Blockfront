package com.boehmod.blockfront;

import com.boehmod.blockfront.C1136uj;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.um */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/um.class */
public final class C1139um extends C1136uj {
    public C1139um(@NotNull String str, Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.C1136uj
    /* JADX INFO: renamed from: a */
    protected AbstractC0676mA mo5958a(@NotNull Level level) {
        return ((EntityType) C1230wX.f7042kL.get()).create(level);
    }

    @Override // com.boehmod.blockfront.C1136uj
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1136uj.a mo5959a() {
        return C1136uj.a.SMOKE;
    }
}
