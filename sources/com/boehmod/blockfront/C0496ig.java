package com.boehmod.blockfront;

import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ig */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ig.class */
public class C0496ig extends C0502im {

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C1144ur f2993b;

    public C0496ig(@NotNull SoundEvent soundEvent, @NotNull C1144ur c1144ur) {
        super(soundEvent);
        this.f2993b = c1144ur;
    }

    @Override // com.boehmod.blockfront.C0502im
    public void tick() {
        super.tick();
    }

    /* JADX INFO: renamed from: a */
    public C1144ur m2238a() {
        return this.f2993b;
    }
}
