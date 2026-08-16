package software.bernie.geckolib.cache.object;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.world.phys.Vec3;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/geckolib-neoforge-1.21.1-4.9.2.jar:software/bernie/geckolib/cache/object/GeoCube.class */
public final class GeoCube extends Record {
    private final GeoQuad[] quads;
    private final Vec3 pivot;
    private final Vec3 rotation;
    private final Vec3 size;
    private final double inflate;
    private final boolean mirror;

    public GeoCube(GeoQuad[] quads, Vec3 pivot, Vec3 rotation, Vec3 size, double inflate, boolean mirror) {
        this.quads = quads;
        this.pivot = pivot;
        this.rotation = rotation;
        this.size = size;
        this.inflate = inflate;
        this.mirror = mirror;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, GeoCube.class), GeoCube.class, "quads;pivot;rotation;size;inflate;mirror", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoCube;->quads:[Lsoftware/bernie/geckolib/cache/object/GeoQuad;", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoCube;->pivot:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoCube;->rotation:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoCube;->size:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoCube;->inflate:D", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoCube;->mirror:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, GeoCube.class), GeoCube.class, "quads;pivot;rotation;size;inflate;mirror", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoCube;->quads:[Lsoftware/bernie/geckolib/cache/object/GeoQuad;", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoCube;->pivot:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoCube;->rotation:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoCube;->size:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoCube;->inflate:D", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoCube;->mirror:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, GeoCube.class, Object.class), GeoCube.class, "quads;pivot;rotation;size;inflate;mirror", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoCube;->quads:[Lsoftware/bernie/geckolib/cache/object/GeoQuad;", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoCube;->pivot:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoCube;->rotation:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoCube;->size:Lnet/minecraft/world/phys/Vec3;", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoCube;->inflate:D", "FIELD:Lsoftware/bernie/geckolib/cache/object/GeoCube;->mirror:Z").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public GeoQuad[] quads() {
        return this.quads;
    }

    public Vec3 pivot() {
        return this.pivot;
    }

    public Vec3 rotation() {
        return this.rotation;
    }

    public Vec3 size() {
        return this.size;
    }

    public double inflate() {
        return this.inflate;
    }

    public boolean mirror() {
        return this.mirror;
    }
}
