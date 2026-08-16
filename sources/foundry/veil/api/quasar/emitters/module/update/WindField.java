package foundry.veil.api.quasar.emitters.module.update;

import foundry.veil.api.util.FastNoiseLite;
import net.minecraft.world.phys.Vec3;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/emitters/module/update/WindField.class */
public class WindField {
    Vec3 windDirection;
    float strength;
    float falloff;
    FastNoiseLite noise;

    public WindField(Vec3 windDirection, float strength, float falloff, FastNoiseLite noise) {
        this.windDirection = windDirection;
        this.strength = strength;
        this.falloff = falloff;
        this.noise = noise;
    }

    public Vec3 getWindDirection() {
        return this.windDirection;
    }

    public void tickWind() {
        float x = (float) (this.windDirection.x() + (((double) this.noise.GetNoise(0.0f, 0.0f, 0.0f)) * 0.01d));
        float y = (float) (this.windDirection.y() + (((double) this.noise.GetNoise(0.0f, 0.0f, 1.0f)) * 0.01d));
        float z = (float) (this.windDirection.z() + (((double) this.noise.GetNoise(0.0f, 0.0f, 2.0f)) * 0.01d));
        this.windDirection = new Vec3(x, y, z);
    }
}
