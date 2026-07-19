package com.boehmod.blockfront;

import java.util.Random;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/e.class */
public class C0109e extends com.boehmod.blockfront.common.player.a<fT> {
    public C0109e(@NotNull fT fTVar) {
        super(fTVar);
    }

    public void a(@NotNull ClientLevel clientLevel, @NotNull Player player, @NotNull Random random) {
        if (this.eU) {
            Vec3 vec3Add = player.getEyePosition().add(0.0d, -0.25d, 0.0d).add(new Vec3(-0.4000000059604645d, 0.0d, 0.0d).yRot(((-player.yBodyRot) * 0.017453292f) - 1.5707964f));
            if (random.nextBoolean()) {
                clientLevel.addParticle(ParticleTypes.LAVA, vec3Add.x, vec3Add.y, vec3Add.z, 0.0d, 0.0d, 0.0d);
            }
            clientLevel.addParticle(ParticleTypes.SMOKE, vec3Add.x, vec3Add.y, vec3Add.z, 0.0d, 0.0d, 0.0d);
        }
    }
}
