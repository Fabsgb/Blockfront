package foundry.veil.api.client.necromancer;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4x3f;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector4f;
import org.joml.Vector4fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/necromancer/Bone.class */
public class Bone {

    @Nullable
    public Bone parent;
    public final String identifier;
    private int index;
    public Vector3f position = new Vector3f(0.0f);
    public Vector3f previousPosition = new Vector3f(0.0f);
    public Vector3f basePosition = new Vector3f(0.0f);
    public Vector3f rotationPoint = new Vector3f(0.0f);
    public Vector3f previousRotationPoint = new Vector3f(0.0f);
    public Vector3f baseRotationPoint = new Vector3f(0.0f);
    public Quaternionf rotation = new Quaternionf();
    public Quaternionf previousRotation = new Quaternionf();
    public Quaternionf baseRotation = new Quaternionf();
    public Vector3f size = new Vector3f(1.0f);
    public Vector3f previousSize = new Vector3f(1.0f);
    public Vector3f baseSize = new Vector3f(1.0f);
    public Vector4f color = new Vector4f(1.0f);
    public Vector4f previousColor = new Vector4f(1.0f);
    public Vector4f baseColor = new Vector4f(1.0f);
    public List<Bone> children = new ArrayList();
    public List<Bone> parentChain = new ArrayList();

    public Bone(String identifier) {
        this.identifier = identifier;
    }

    protected void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

    public void setBaseAttributes(Vector3fc pos, Quaternionfc rotation, Vector3f rotationPoint, Vector3fc scale, Vector4fc color) {
        this.basePosition.set(pos);
        this.position.set(this.basePosition);
        this.previousPosition.set(this.basePosition);
        this.baseSize.set(scale);
        this.size.set(this.baseSize);
        this.previousSize.set(this.baseSize);
        this.baseRotation.set(rotation);
        this.rotation.set(this.baseRotation);
        this.previousRotation.set(this.baseRotation);
        this.baseRotationPoint.set(rotationPoint);
        this.rotationPoint.set(this.baseRotationPoint);
        this.previousRotationPoint.set(this.baseRotationPoint);
        this.baseColor.set(color);
        this.color.set(this.baseColor);
        this.previousColor.set(this.baseColor);
    }

    public void reset() {
        this.position.set(this.basePosition);
        this.rotation.set(this.baseRotation);
        this.rotationPoint.set(this.baseRotationPoint);
        this.size.set(this.baseSize);
        this.color.set(this.baseColor);
    }

    protected void updatePreviousAttributes() {
        this.previousPosition.set(this.position);
        this.previousRotation.set(this.rotation);
        this.previousRotationPoint.set(this.rotationPoint);
        this.previousSize.set(this.size);
        this.previousColor.set(this.color);
    }

    public Matrix4x3f getModelTransform(Matrix4x3f matrix, Quaternionf orientation, float partialTicks) {
        for (Bone bone : this.parentChain) {
            bone.getLocalTransform(matrix, orientation, partialTicks);
        }
        getLocalTransform(matrix, orientation, partialTicks);
        return matrix;
    }

    public Matrix4x3f getModelTransform(Matrix4x3f matrix, float partialTicks) {
        return getModelTransform(matrix, new Quaternionf(), partialTicks);
    }

    public void getLocalTransform(Matrix4x3f matrix, Quaternionf orientation, float partialTicks) {
        float x = Mth.lerp(partialTicks, this.previousPosition.x, this.position.x);
        float y = Mth.lerp(partialTicks, this.previousPosition.y, this.position.y);
        float z = Mth.lerp(partialTicks, this.previousPosition.z, this.position.z);
        matrix.translate(x, y, z);
        this.previousRotation.slerp(this.rotation, partialTicks, orientation);
        float rotationPointX = Mth.lerp(partialTicks, this.previousRotationPoint.x, this.rotationPoint.x);
        float rotationPointY = Mth.lerp(partialTicks, this.previousRotationPoint.y, this.rotationPoint.y);
        float rotationPointZ = Mth.lerp(partialTicks, this.previousRotationPoint.z, this.rotationPoint.z);
        matrix.translate(rotationPointX, rotationPointY, rotationPointZ);
        matrix.rotate(orientation.normalize());
        matrix.translate(-rotationPointX, -rotationPointY, -rotationPointZ);
        matrix.scale(Mth.lerp(partialTicks, this.previousSize.x, this.size.x), Mth.lerp(partialTicks, this.previousSize.y, this.size.y), Mth.lerp(partialTicks, this.previousSize.z, this.size.z));
    }

    public void getLocalTransform(Matrix4x3f matrix, float partialTicks) {
        getLocalTransform(matrix, new Quaternionf(), partialTicks);
    }

    public void getColor(Vector4f color, float partialTicks) {
        this.previousColor.lerp(this.color, partialTicks, color);
    }

    protected void tick(float deltaTime) {
    }

    public void addChild(Bone child) {
        if (child.parent != null) {
            child.parent.children.remove(child);
        }
        this.children.add(child);
        child.parent = this;
    }

    public void setParent(Bone parent) {
        this.parent = parent;
        parent.children.add(this);
    }

    /* JADX INFO: renamed from: foundry.veil.api.client.necromancer.Bone$1 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/necromancer/Bone$1.class */
    static /* synthetic */ class C13091 {
        static final /* synthetic */ int[] $SwitchMap$net$minecraft$core$Direction$Axis = new int[Direction.Axis.values().length];

        static {
            try {
                $SwitchMap$net$minecraft$core$Direction$Axis[Direction.Axis.X.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction$Axis[Direction.Axis.Y.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction$Axis[Direction.Axis.Z.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public Bone rotate(float angle, Direction.Axis axis) {
        switch (C13091.$SwitchMap$net$minecraft$core$Direction$Axis[axis.ordinal()]) {
            case 1:
                this.rotation.rotateX(angle);
                break;
            case 2:
                this.rotation.rotateY(angle);
                break;
            case 3:
                this.rotation.rotateZ(angle);
                break;
        }
        return this;
    }

    public Bone rotateDeg(float angle, Direction.Axis axis) {
        switch (C13091.$SwitchMap$net$minecraft$core$Direction$Axis[axis.ordinal()]) {
            case 1:
                this.rotation.rotateX(angle * 0.017453292f);
                break;
            case 2:
                this.rotation.rotateY(angle * 0.017453292f);
                break;
            case 3:
                this.rotation.rotateZ(angle * 0.017453292f);
                break;
        }
        return this;
    }

    public Bone offset(float x, float y, float z) {
        this.position.add(x, y, z);
        return this;
    }

    public Bone offsetX(float x) {
        this.position.add(x, 0.0f, 0.0f);
        return this;
    }

    public Bone offsetY(float y) {
        this.position.add(0.0f, y, 0.0f);
        return this;
    }

    public Bone offsetZ(float z) {
        this.position.add(0.0f, 0.0f, z);
        return this;
    }
}
