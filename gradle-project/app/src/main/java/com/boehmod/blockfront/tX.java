package com.boehmod.blockfront;

import com.boehmod.blockfront.C0550uj;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tX.class */
public final class tX extends C0550uj {
    public tX(@NotNull String str, Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.C0550uj
    public boolean ck() {
        return false;
    }

    @Override // com.boehmod.blockfront.C0550uj
    protected mA a(@NotNull Level level) {
        return ((EntityType) wX.kS.get()).create(level);
    }

    @Override // com.boehmod.blockfront.C0550uj
    @NotNull
    public C0550uj.a a() {
        return C0550uj.a.LANDMINE;
    }

    @Override // com.boehmod.blockfront.C0550uj
    public boolean cl() {
        return false;
    }

    @Override // com.boehmod.blockfront.C0550uj
    @NotNull
    public SoundEvent y() {
        return (SoundEvent) C0624xc.tV.get();
    }
}
