package foundry.veil.api.util;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import net.minecraft.core.Position;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/util/CatmulRomSpline.class */
public final class CatmulRomSpline {
    private final Iter iter = new Iter();

    public Iterable<Vector3dc> generateJomlSpline(Collection<? extends Vector3dc> controlPoints, int numSegments) {
        if (controlPoints.size() < 4) {
            return Collections.emptyList();
        }
        this.iter.setJoml(controlPoints.iterator(), numSegments);
        return () -> {
            return this.iter;
        };
    }

    public Iterable<Vector3dc> generateSpline(Collection<? extends Position> controlPoints, int numSegments) {
        if (controlPoints.size() < 4) {
            return Collections.emptyList();
        }
        this.iter.set(controlPoints.iterator(), numSegments);
        return () -> {
            return this.iter;
        };
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/util/CatmulRomSpline$Iter.class */
    private static class Iter implements Iterator<Vector3dc> {
        private Object point0;
        private Object point1;
        private Object point2;
        private Object point3;
        private int segments;
        private int currentSegment;
        private final Vector3d value = new Vector3d();
        private Iterator points = null;
        private boolean joml = false;

        private Iter() {
        }

        public void setJoml(Iterator points, int segments) {
            this.points = points;
            this.point0 = points.next();
            this.point1 = points.next();
            this.point2 = points.next();
            this.point3 = points.next();
            this.joml = true;
            this.segments = segments;
            this.currentSegment = 0;
        }

        public void set(Iterator points, int segments) {
            this.points = points;
            this.point0 = points.next();
            this.point1 = points.next();
            this.point2 = points.next();
            this.point3 = points.next();
            this.joml = false;
            this.segments = segments;
            this.currentSegment = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.currentSegment < this.segments && this.points.hasNext();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Vector3dc next() {
            if (this.currentSegment >= this.segments) {
                this.currentSegment = 0;
                this.point0 = this.point1;
                this.point1 = this.point2;
                this.point2 = this.point3;
                this.point3 = this.points.next();
            }
            double t = ((double) this.currentSegment) / ((double) this.segments);
            double t2 = t * t;
            double t3 = t2 * t;
            double a = (((-0.5d) * t3) + t2) - (0.5d * t);
            double b = ((1.5d * t3) - (2.5d * t2)) + 1.0d;
            double c = ((-1.5d) * t3) + (2.0d * t2) + (0.5d * t);
            double d = (0.5d * t3) - (0.5d * t2);
            if (this.joml) {
                Vector3dc p0 = (Vector3dc) this.point0;
                Vector3dc p1 = (Vector3dc) this.point1;
                Vector3dc p2 = (Vector3dc) this.point2;
                Vector3dc p3 = (Vector3dc) this.point3;
                this.value.set((p0.x() * a) + (p1.x() * b) + (p2.x() * c) + (p3.x() * d), (p0.y() * a) + (p1.y() * b) + (p2.y() * c) + (p3.y() * d), (p0.z() * a) + (p1.z() * b) + (p2.z() * c) + (p3.z() * d));
            } else {
                Position p4 = (Position) this.point0;
                Position p5 = (Position) this.point1;
                Position p6 = (Position) this.point2;
                Position p7 = (Position) this.point3;
                this.value.set((p4.x() * a) + (p5.x() * b) + (p6.x() * c) + (p7.x() * d), (p4.y() * a) + (p5.y() * b) + (p6.y() * c) + (p7.y() * d), (p4.z() * a) + (p5.z() * b) + (p6.z() * c) + (p7.z() * d));
            }
            this.currentSegment++;
            return this.value;
        }
    }
}
