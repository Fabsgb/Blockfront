package com.boehmod.blockfront;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;

/* JADX INFO: renamed from: com.boehmod.blockfront.ir */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ir.class */
public class C0507ir extends C0509it<AbstractC0729nA> {

    /* JADX INFO: renamed from: a */
    private final C0740nL f3023a;

    public C0507ir(AbstractC0729nA abstractC0729nA, C0740nL c0740nL, SoundEvent soundEvent, float f, float f2, Vec3 vec3) {
        super(abstractC0729nA, false, false, false, true, soundEvent, vec3, f, f2);
        this.f3023a = c0740nL;
    }

    @Override // com.boehmod.blockfront.C0509it
    public void tick() {
        Vec3 vec3Position = ((AbstractC0729nA) this.f3028a).position();
        this.x = vec3Position.x;
        this.y = vec3Position.y;
        this.z = vec3Position.z;
        this.volume = Mth.lerp(0.3f, this.volume, ((AbstractC0729nA) this.f3028a).m3290a(this.f3023a).m3299a(((AbstractC0729nA) this.f3028a).getEntityData()) ? 1.0f : 0.0f);
    }
}
