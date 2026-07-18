package com.boehmod.blockfront;

import com.boehmod.blockfront.C1136uj;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tX.class */
public final class C1071tX extends C1136uj {
    public C1071tX(@NotNull String str, Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.C1136uj
    /* JADX INFO: renamed from: ck */
    public boolean mo5957ck() {
        return false;
    }

    @Override // com.boehmod.blockfront.C1136uj
    /* JADX INFO: renamed from: a */
    protected AbstractC0676mA mo5958a(@NotNull Level level) {
        return ((EntityType) C1230wX.f7049kS.get()).create(level);
    }

    @Override // com.boehmod.blockfront.C1136uj
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1136uj.a mo5959a() {
        return C1136uj.a.LANDMINE;
    }

    @Override // com.boehmod.blockfront.C1136uj
    /* JADX INFO: renamed from: cl */
    public boolean mo5960cl() {
        return false;
    }

    @Override // com.boehmod.blockfront.C1136uj
    @NotNull
    /* JADX INFO: renamed from: y */
    public SoundEvent mo5966y() {
        return (SoundEvent) C1280xc.f7798tV.get();
    }
}
