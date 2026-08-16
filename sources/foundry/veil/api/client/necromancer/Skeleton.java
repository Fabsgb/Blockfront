package foundry.veil.api.client.necromancer;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.joml.Matrix3f;
import org.joml.Matrix4x3f;
import org.joml.Quaternionf;
import org.joml.Vector4f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/necromancer/Skeleton.class */
public abstract class Skeleton {
    public static final int MAX_BONES = 256;
    public static final int UNIFORM_STRIDE = 112;
    public List<Bone> roots = new ArrayList();
    public Map<String, Bone> bones = new HashMap();
    private int maxDepth = 1;

    public void tick() {
        for (Bone part : this.bones.values()) {
            part.updatePreviousAttributes();
        }
        for (Bone bone : this.bones.values()) {
            bone.tick(0.05f);
        }
    }

    public void addBone(Bone part) {
        part.setIndex(this.bones.size());
        this.bones.put(part.identifier, part);
    }

    public void buildRoots() {
        this.maxDepth = 0;
        for (Bone part : this.bones.values()) {
            if (part.parent == null) {
                this.roots.add(part);
            } else {
                Set<Bone> closedSet = new HashSet<>();
                Bone bone = part.parent;
                while (true) {
                    Bone parentBone = bone;
                    if (parentBone != null) {
                        if (!closedSet.add(parentBone)) {
                            throw new IllegalStateException("Circular reference in bone: " + parentBone.identifier);
                        }
                        part.parentChain.add(parentBone);
                        bone = parentBone.parent;
                    } else {
                        Collections.reverse(part.parentChain);
                        this.maxDepth = Math.max(part.parentChain.size(), this.maxDepth);
                        break;
                    }
                }
            }
        }
        this.maxDepth++;
    }

    public int getMaxDepth() {
        return this.maxDepth;
    }

    public void storeInstancedData(ByteBuffer buffer, Collection<Bone> bones, Object2IntMap<String> boneIds, int depth, Vector4f color, Matrix3f normalMatrix, Matrix4x3f baseTransform, Matrix4x3f[] matrixStack, Quaternionf[] orientationStack, float partialTicks) {
        for (Bone bone : bones) {
            int boneBufferIndex = boneIds.getInt(bone.identifier);
            boolean hasBufferPosition = boneBufferIndex != -1;
            boolean hasChildren = !bone.children.isEmpty();
            Matrix4x3f matrix = matrixStack[depth].set(baseTransform);
            Quaternionf orientation = orientationStack[depth];
            if (hasBufferPosition || hasChildren) {
                bone.getLocalTransform(matrix, orientation, partialTicks);
                if (hasBufferPosition) {
                    matrix.getTransposed(buffer.position() + (boneBufferIndex * UNIFORM_STRIDE), buffer);
                    bone.getColor(color, partialTicks);
                    color.get(buffer.position() + (boneBufferIndex * UNIFORM_STRIDE) + 48, buffer);
                    matrix.normal(normalMatrix).get3x4((boneBufferIndex * UNIFORM_STRIDE) + 64, buffer);
                }
            }
            if (hasChildren) {
                storeInstancedData(buffer, bone.children, boneIds, depth + 1, color, normalMatrix, matrix, matrixStack, orientationStack, partialTicks);
            }
        }
    }
}
