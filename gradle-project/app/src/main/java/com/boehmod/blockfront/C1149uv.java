package com.boehmod.blockfront;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uv.class */
public final class C1149uv extends C1109uH {
    public C1149uv(@NotNull String str, Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.C1109uH
    /* JADX INFO: renamed from: cu */
    public boolean mo6228cu() {
        return false;
    }

    @Override // com.boehmod.blockfront.C1109uH
    /* JADX INFO: renamed from: a */
    protected AbstractC0699mW mo6209a(@NotNull Level level) {
        return ((EntityType) C1307xu.f7614kS.get()).create(level);
    }

    @Override // com.boehmod.blockfront.C1109uH
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1109uH.a mo6211a() {
        return C1109uH.a.LANDMINE;
    }

    @Override // com.boehmod.blockfront.C1109uH
    /* JADX INFO: renamed from: cv */
    public boolean mo6232cv() {
        return false;
    }

    @Override // com.boehmod.blockfront.C1109uH
    @NotNull
    /* JADX INFO: renamed from: y */
    public SoundEvent mo6225y() {
        return (SoundEvent) C1312xz.f8209tW.get();
    }
}
