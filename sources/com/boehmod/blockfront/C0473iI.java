package com.boehmod.blockfront;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;

/* JADX INFO: renamed from: com.boehmod.blockfront.iI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/iI.class */
public class C0473iI extends C0475iK<AbstractC0752nW> {

    /* JADX INFO: renamed from: a */
    private final C0816oh f2919a;

    public C0473iI(AbstractC0752nW abstractC0752nW, C0816oh c0816oh, SoundEvent soundEvent, float f, float f2, Vec3 vec3) {
        super(abstractC0752nW, false, false, false, true, soundEvent, vec3, f, f2);
        this.f2919a = c0816oh;
    }

    @Override // com.boehmod.blockfront.C0475iK
    public void tick() {
        Vec3 vec3Position = ((AbstractC0752nW) this.f2924a).position();
        this.x = vec3Position.x;
        this.y = vec3Position.y;
        this.z = vec3Position.z;
        this.volume = Mth.lerp(0.3f, this.volume, ((AbstractC0752nW) this.f2924a).m3479a(this.f2919a).m3486a(((AbstractC0752nW) this.f2924a).getEntityData()) ? 1.0f : 0.0f);
    }
}
