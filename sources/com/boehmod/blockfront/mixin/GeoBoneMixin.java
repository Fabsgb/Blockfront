package com.boehmod.blockfront.mixin;

import com.boehmod.blockfront.InterfaceC1294xq;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import software.bernie.geckolib.cache.object.GeoBone;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mixin/GeoBoneMixin.class */
@Mixin({GeoBone.class})
public abstract class GeoBoneMixin implements InterfaceC1294xq {

    @Unique
    private int bf$flags = -1;

    @Override // com.boehmod.blockfront.InterfaceC1294xq
    public int bf$getFlags() {
        return this.bf$flags;
    }

    @Override // com.boehmod.blockfront.InterfaceC1294xq
    public void bf$setFlags(int i) {
        this.bf$flags = i;
    }
}
