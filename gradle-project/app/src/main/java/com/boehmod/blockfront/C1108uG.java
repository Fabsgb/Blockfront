package com.boehmod.blockfront;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uG.class */
public final class C1108uG extends C1109uH {
    public C1108uG(@NotNull String str, Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.C1109uH
    /* JADX INFO: renamed from: a */
    protected AbstractC0699mW mo6209a(@NotNull Level level) {
        return ((EntityType) C1307xu.f7606kK.get()).create(level);
    }

    @Override // com.boehmod.blockfront.C1109uH
    /* JADX INFO: renamed from: al */
    public int mo6210al() {
        return 20;
    }

    @Override // com.boehmod.blockfront.C1109uH
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1109uH.a mo6211a() {
        return C1109uH.a.FLASH;
    }
}
