package software.bernie.geckolib.cache.object;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.core.Direction;
import org.joml.Vector3f;
import software.bernie.geckolib.loading.json.raw.FaceUV;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/cache/object/GeoQuad.class */
public final class GeoQuad extends Record {
    private final GeoVertex[] vertices;
    private final Vector3f normal;
    private final Direction direction;

    public GeoQuad(GeoVertex[] vertices, Vector3f normal, Direction direction) {
        this.vertices = vertices;
        this.normal = normal;
        this.direction = direction;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, GeoQuad.class), GeoQuad.class, "vertices;normal;direction", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoQuad;->vertices:[Lsoftware/bernie/geckolib/cache/object/GeoVertex;", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoQuad;->normal:Lorg/joml/Vector3f;", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoQuad;->direction:Lnet/minecraft/core/Direction;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, GeoQuad.class), GeoQuad.class, "vertices;normal;direction", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoQuad;->vertices:[Lsoftware/bernie/geckolib/cache/object/GeoVertex;", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoQuad;->normal:Lorg/joml/Vector3f;", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoQuad;->direction:Lnet/minecraft/core/Direction;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, GeoQuad.class, Object.class), GeoQuad.class, "vertices;normal;direction", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoQuad;->vertices:[Lsoftware/bernie/geckolib/cache/object/GeoVertex;", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoQuad;->normal:Lorg/joml/Vector3f;", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoQuad;->direction:Lnet/minecraft/core/Direction;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public GeoVertex[] vertices() {
        return this.vertices;
    }

    public Vector3f normal() {
        return this.normal;
    }

    public Direction direction() {
        return this.direction;
    }

    @Deprecated(forRemoval = true)
    public static GeoQuad build(GeoVertex[] vertices, double[] uvCoords, double[] uvSize, float texWidth, float texHeight, boolean mirror, Direction direction) {
        return build(vertices, (float) uvCoords[0], (float) uvCoords[1], (float) uvSize[0], (float) uvSize[1], texWidth, texHeight, mirror, direction);
    }

    @Deprecated(forRemoval = true)
    public static GeoQuad build(GeoVertex[] vertices, float u, float v, float uSize, float vSize, float texWidth, float texHeight, boolean mirror, Direction direction) {
        return build(vertices, u, v, uSize, vSize, FaceUV.Rotation.NONE, texWidth, texHeight, mirror, direction);
    }

    public static GeoQuad build(GeoVertex[] vertices, double[] uvCoords, double[] uvSize, FaceUV.Rotation uvRotation, float texWidth, float texHeight, boolean mirror, Direction direction) {
        return build(vertices, (float) uvCoords[0], (float) uvCoords[1], (float) uvSize[0], (float) uvSize[1], uvRotation, texWidth, texHeight, mirror, direction);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public static GeoQuad build(GeoVertex[] vertices, float u, float v, float uSize, float vSize, FaceUV.Rotation uvRotation, float texWidth, float texHeight, boolean mirror, Direction direction) throws MatchException {
        float uWidth = (u + uSize) / texWidth;
        float vHeight = (v + vSize) / texHeight;
        float u2 = u / texWidth;
        float v2 = v / texHeight;
        Vector3f normal = direction.step();
        if (!mirror) {
            uWidth = u2;
            u2 = uWidth;
        } else {
            normal.mul(-1.0f, 1.0f, 1.0f);
        }
        float[] uvs = uvRotation.rotateUvs(u2, v2, uWidth, vHeight);
        vertices[0] = vertices[0].withUVs(uvs[0], uvs[1]);
        vertices[1] = vertices[1].withUVs(uvs[2], uvs[3]);
        vertices[2] = vertices[2].withUVs(uvs[4], uvs[5]);
        vertices[3] = vertices[3].withUVs(uvs[6], uvs[7]);
        return new GeoQuad(vertices, normal, direction);
    }
}
