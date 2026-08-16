package foundry.veil.impl.client.render.perspective;

import java.util.Objects;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionfc;
import org.joml.Vector3dc;
import org.joml.Vector3f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/perspective/LevelPerspectiveCamera.class */
@ApiStatus.Internal
public class LevelPerspectiveCamera extends Camera {
    private static final Vector3f EULER_ANGLES = new Vector3f();
    private float viewDistance;

    public void setup(Vector3dc position, @Nullable Entity cameraEntity, ClientLevel level, Quaternionfc orientation, float viewDistance) {
        super.setup(level, cameraEntity != null ? cameraEntity : (Entity) Objects.requireNonNull(Minecraft.getInstance().player), false, false, 1.0f);
        setPosition(position.x(), position.y(), position.z());
        orientation.getEulerAnglesYXZ(EULER_ANGLES);
        super.setRotation((float) (((double) ((-EULER_ANGLES.y) * 180.0f)) / 3.141592653589793d), (float) (((double) (EULER_ANGLES.x * 180.0f)) / 3.141592653589793d));
        rotation().set(orientation);
        getLookVector().set(0.0f, 0.0f, -1.0f).rotate(orientation);
        getUpVector().set(0.0f, 1.0f, 0.0f).rotate(orientation);
        getLeftVector().set(-1.0f, 0.0f, 0.0f).rotate(orientation);
        this.viewDistance = viewDistance;
    }

    public boolean isDetached() {
        return true;
    }

    public float getRenderDistance() {
        return this.viewDistance;
    }
}
