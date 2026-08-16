package foundry.veil.api.flare.model;

import foundry.veil.Veil;
import foundry.veil.api.flare.data.model.FlareBakedQuad;
import foundry.veil.api.flare.data.model.FlareShell;
import foundry.veil.api.flare.data.model.ShellElement;
import foundry.veil.api.flare.data.model.ShellElementFace;
import foundry.veil.api.flare.data.model.ShellElementRotation;
import foundry.veil.api.flare.data.model.ShellFaceUV;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.FaceInfo;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/flare/model/ShellBakery.class */
public final class ShellBakery {
    public static final ResourceLocation MISSING_SHELL_LOCATION = Veil.veilPath("builtin/missing");
    public static final BakedShell MISSING_SHELL;

    static {
        Map<Direction, ShellElementFace> faces = new EnumMap<>(Direction.class);
        for (Direction direction : Direction.values()) {
            faces.put(direction, new ShellElementFace(new ShellFaceUV(0.0f, 0.0f, 16.0f, 16.0f, 0)));
        }
        UnbakedShell unbaked = new FlareShell(List.of(new ShellElement(new Vector3f(0.0f, 0.0f, 0.0f), new Vector3f(16.0f, 16.0f, 16.0f), null, faces)));
        MISSING_SHELL = (BakedShell) Objects.requireNonNull(unbaked.bake(), "Missing Shell");
    }

    private ShellBakery() {
    }

    public static FlareBakedQuad bakeQuad(ShellElement element, ShellElementFace face, Direction direction) {
        return bakeQuad(element.from(), element.m8341to(), face, direction, element.rotation());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public static FlareBakedQuad bakeQuad(Vector3fc from, Vector3fc to, ShellElementFace face, Direction facing, ShellElementRotation rotation) throws MatchException {
        Vector3f normal = facing.step();
        float[] vertexData = makeVertices(face.m8342uv(), normal, facing, setupShape(from, to), rotation);
        return new FlareBakedQuad(vertexData);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    private static float[] makeVertices(ShellFaceUV uvs, Vector3f normal, Direction direction, float[] posDiv16, @Nullable ShellElementRotation rotation) throws MatchException {
        Matrix4f matrix4fRotationZ;
        float[] vertexData = new float[32];
        Matrix4f rotationMatrix = null;
        if (rotation != null) {
            float angle = rotation.angle() * 0.017453292f;
            switch (C14351.$SwitchMap$net$minecraft$core$Direction$Axis[rotation.axis().ordinal()]) {
                case 1:
                    matrix4fRotationZ = new Matrix4f().rotationX(angle);
                    break;
                case 2:
                    matrix4fRotationZ = new Matrix4f().rotationY(angle);
                    break;
                case 3:
                    matrix4fRotationZ = new Matrix4f().rotationZ(angle);
                    break;
                default:
                    throw new MatchException((String) null, (Throwable) null);
            }
            rotationMatrix = matrix4fRotationZ;
            rotationMatrix.transformDirection(normal);
        }
        for (int i = 0; i < 4; i++) {
            bakeVertex(vertexData, i, normal, direction, uvs, posDiv16, rotation, rotationMatrix);
        }
        return vertexData;
    }

    /* JADX INFO: renamed from: foundry.veil.api.flare.model.ShellBakery$1 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/flare/model/ShellBakery$1.class */
    static /* synthetic */ class C14351 {
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

    private static void bakeVertex(float[] vertexData, int vertexIndex, Vector3f normal, Direction direction, ShellFaceUV shellFaceUV, float[] posDiv16, @Nullable ShellElementRotation rotation, @Nullable Matrix4f transform) {
        FaceInfo.VertexInfo vertexInfo = FaceInfo.fromFacing(direction).getVertexInfo(vertexIndex);
        Vector3f pos = new Vector3f(posDiv16[vertexInfo.xFace], posDiv16[vertexInfo.yFace], posDiv16[vertexInfo.zFace]);
        if (rotation != null && transform != null) {
            Vector3f origin = new Vector3f(rotation.origin()).div(16.0f).sub(0.5f, 0.0f, 0.5f);
            Vector3f offset = transform.transformPosition(new Vector3f(pos.x() - origin.x(), pos.y() - origin.y(), pos.z() - origin.z()));
            pos.set(offset.x() + origin.x(), offset.y() + origin.y(), offset.z() + origin.z());
        }
        fillVertex(vertexData, vertexIndex, pos, normal, shellFaceUV);
    }

    private static float[] setupShape(Vector3fc min, Vector3fc max) {
        float[] vertexPosition = new float[Direction.values().length];
        vertexPosition[FaceInfo.Constants.MIN_X] = (min.x() / 16.0f) - 0.5f;
        vertexPosition[FaceInfo.Constants.MIN_Y] = min.y() / 16.0f;
        vertexPosition[FaceInfo.Constants.MIN_Z] = (min.z() / 16.0f) - 0.5f;
        vertexPosition[FaceInfo.Constants.MAX_X] = (max.x() / 16.0f) - 0.5f;
        vertexPosition[FaceInfo.Constants.MAX_Y] = max.y() / 16.0f;
        vertexPosition[FaceInfo.Constants.MAX_Z] = (max.z() / 16.0f) - 0.5f;
        return vertexPosition;
    }

    private static void fillVertex(float[] vertexData, int vertexIndex, Vector3f pos, Vector3f normal, ShellFaceUV shellFaceUV) {
        int i = vertexIndex * 8;
        vertexData[i] = pos.x();
        vertexData[i + 1] = pos.y();
        vertexData[i + 2] = pos.z();
        vertexData[i + 3] = normal.x();
        vertexData[i + 4] = normal.y();
        vertexData[i + 5] = normal.z();
        vertexData[i + 6] = shellFaceUV.getU(vertexIndex) / 16.0f;
        vertexData[i + 7] = shellFaceUV.getV(vertexIndex) / 16.0f;
    }
}
