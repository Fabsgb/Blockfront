package software.bernie.geckolib.cache.object;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.joml.Vector3f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/cache/object/GeoVertex.class */
public final class GeoVertex extends Record {
    private final Vector3f position;
    private final float texU;
    private final float texV;

    public GeoVertex(Vector3f position, float texU, float texV) {
        this.position = position;
        this.texU = texU;
        this.texV = texV;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, GeoVertex.class), GeoVertex.class, "position;texU;texV", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoVertex;->position:Lorg/joml/Vector3f;", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoVertex;->texU:F", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoVertex;->texV:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, GeoVertex.class), GeoVertex.class, "position;texU;texV", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoVertex;->position:Lorg/joml/Vector3f;", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoVertex;->texU:F", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoVertex;->texV:F").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, GeoVertex.class, Object.class), GeoVertex.class, "position;texU;texV", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoVertex;->position:Lorg/joml/Vector3f;", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoVertex;->texU:F", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoVertex;->texV:F").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public Vector3f position() {
        return this.position;
    }

    public float texU() {
        return this.texU;
    }

    public float texV() {
        return this.texV;
    }

    public GeoVertex(double x, double y, double z) {
        this(new Vector3f((float) x, (float) y, (float) z), 0.0f, 0.0f);
    }

    public GeoVertex withUVs(float texU, float texV) {
        return new GeoVertex(this.position, texU, texV);
    }
}
