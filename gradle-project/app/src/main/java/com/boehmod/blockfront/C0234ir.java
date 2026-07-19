package com.boehmod.blockfront;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;

/* JADX INFO: renamed from: com.boehmod.blockfront.ir, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ir.class */
public class C0234ir extends C0236it<nA> {
    private final nL a;

    public C0234ir(nA nAVar, nL nLVar, SoundEvent soundEvent, float f, float f2, Vec3 vec3) {
        super(nAVar, false, false, false, true, soundEvent, vec3, f, f2);
        this.a = nLVar;
    }

    @Override // com.boehmod.blockfront.C0236it
    public void tick() {
        Vec3 vec3Position = ((nA) this.a).position();
        this.x = vec3Position.x;
        this.y = vec3Position.y;
        this.z = vec3Position.z;
        this.volume = Mth.lerp(0.3f, this.volume, ((nA) this.a).a(this.a).m712a(((nA) this.a).getEntityData()) ? 1.0f : 0.0f);
    }
}
