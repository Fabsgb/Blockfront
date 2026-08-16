package com.boehmod.blockfront;

import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ix */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ix.class */
public class C0514ix extends C0468iD {

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C1117uP f3150b;

    public C0514ix(@NotNull SoundEvent soundEvent, @NotNull C1117uP c1117uP) {
        super(soundEvent);
        this.f3150b = c1117uP;
    }

    @Override // com.boehmod.blockfront.C0468iD
    public void tick() {
        super.tick();
    }

    /* JADX INFO: renamed from: a */
    public C1117uP m2293a() {
        return this.f3150b;
    }
}
