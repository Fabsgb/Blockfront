package foundry.veil.api.quasar.p002fx;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/fx/Line.class */
public class Line {
    private Vec3[] points;
    private int color;
    private Function<Float, Float> widthFunction;
    private int length;
    private boolean billboard;
    private TilingMode tilingMode;
    private int frequency;
    private float minDistance;
    private ResourceLocation texture;
    private CurveMode curveMode;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/fx/Line$RenderMode.class */
    public enum RenderMode {
        FLAT,
        CUBOID
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/fx/Line$TilingMode.class */
    public enum TilingMode {
        NONE,
        STRETCH,
        REPEAT
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/fx/Line$CurveMode.class */
    public enum CurveMode {
        NONE((points, freq) -> {
            return points;
        }),
        BEZIER((points2, freq2) -> {
            Vec3[] curvePoints = new Vec3[(points2.length - 2) * freq2.intValue()];
            for (int i = 0; i < points2.length - 1; i++) {
                Vec3 p0 = points2[i];
                Vec3 p1 = points2[i + 1];
                Vec3 p2 = points2[Math.min(i + 2, points2.length - 1)];
                Vec3 p3 = points2[Math.min(i + 3, points2.length - 1)];
                for (int j = 0; j < freq2.intValue(); j++) {
                    float t = j / freq2.intValue();
                    float t2 = t * t;
                    float t3 = t2 * t;
                    float x = (float) (0.5d * ((2.0d * p1.x()) + (((-p0.x()) + p2.x()) * ((double) t)) + (((((2.0d * p0.x()) - (5.0d * p1.x())) + (4.0d * p2.x())) - p3.x()) * ((double) t2)) + (((((-p0.x()) + (3.0d * p1.x())) - (3.0d * p2.x())) + p3.x()) * ((double) t3))));
                    float y = (float) (0.5d * ((2.0d * p1.y()) + (((-p0.y()) + p2.y()) * ((double) t)) + (((((2.0d * p0.y()) - (5.0d * p1.y())) + (4.0d * p2.y())) - p3.y()) * ((double) t2)) + (((((-p0.y()) + (3.0d * p1.y())) - (3.0d * p2.y())) + p3.y()) * ((double) t3))));
                    float z = (float) (0.5d * ((2.0d * p1.z()) + (((-p0.z()) + p2.z()) * ((double) t)) + (((((2.0d * p0.z()) - (5.0d * p1.z())) + (4.0d * p2.z())) - p3.z()) * ((double) t2)) + (((((-p0.z()) + (3.0d * p1.z())) - (3.0d * p2.z())) + p3.z()) * ((double) t3))));
                    curvePoints[(i * freq2.intValue()) + j] = new Vec3(x, y, z);
                }
            }
            return curvePoints;
        }),
        CATMULL_ROM((points3, freq3) -> {
            Vec3[] curvePoints = new Vec3[points3.length * freq3.intValue()];
            for (int i = 0; i < points3.length - 1; i++) {
                Vec3 p0 = points3[Math.max(i - 1, 0)];
                Vec3 p1 = points3[i];
                Vec3 p2 = points3[Math.min(i + 1, points3.length - 1)];
                Vec3 p3 = points3[Math.min(i + 2, points3.length - 1)];
                for (int j = 0; j < freq3.intValue(); j++) {
                    float t = j / freq3.intValue();
                    float t2 = t * t;
                    float t3 = t2 * t;
                    float x = (float) (0.5d * ((2.0d * p1.x()) + (((-p0.x()) + p2.x()) * ((double) t)) + (((((2.0d * p0.x()) - (5.0d * p1.x())) + (4.0d * p2.x())) - p3.x()) * ((double) t2)) + (((((-p0.x()) + (3.0d * p1.x())) - (3.0d * p2.x())) + p3.x()) * ((double) t3))));
                    float y = (float) (0.5d * ((2.0d * p1.y()) + (((-p0.y()) + p2.y()) * ((double) t)) + (((((2.0d * p0.y()) - (5.0d * p1.y())) + (4.0d * p2.y())) - p3.y()) * ((double) t2)) + (((((-p0.y()) + (3.0d * p1.y())) - (3.0d * p2.y())) + p3.y()) * ((double) t3))));
                    float z = (float) (0.5d * ((2.0d * p1.z()) + (((-p0.z()) + p2.z()) * ((double) t)) + (((((2.0d * p0.z()) - (5.0d * p1.z())) + (4.0d * p2.z())) - p3.z()) * ((double) t2)) + (((((-p0.z()) + (3.0d * p1.z())) - (3.0d * p2.z())) + p3.z()) * ((double) t3))));
                    curvePoints[(i * freq3.intValue()) + j] = new Vec3(x, y, z);
                }
            }
            return curvePoints;
        });

        final BiFunction<Vec3[], Integer, Vec3[]> curveFunction;

        CurveMode(BiFunction biFunction) {
            this.curveFunction = biFunction;
        }
    }

    public Line(Vec3[] points, int color, Function<Float, Float> widthFunction) {
        this.length = 100;
        this.billboard = true;
        this.tilingMode = TilingMode.STRETCH;
        this.frequency = 1;
        this.minDistance = 0.0f;
        this.texture = null;
        this.curveMode = CurveMode.NONE;
        this.points = points;
        this.color = color;
        this.widthFunction = widthFunction;
    }

    public Line(int color, Function<Float, Float> widthFunction) {
        this(new Vec3[]{Vec3.ZERO}, color, widthFunction);
    }

    public void setCurveMode(CurveMode curveMode) {
        this.curveMode = curveMode;
    }

    public void setTilingMode(TilingMode tilingMode) {
        this.tilingMode = tilingMode;
    }

    public void setTexture(ResourceLocation texture) {
        this.texture = texture;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setMinDistance(float minDistance) {
        this.minDistance = minDistance;
    }

    public void setPoints(Vec3[] points) {
        if (points.length > this.length) {
            Vec3[] newPoints = new Vec3[this.length];
            System.arraycopy(points, points.length - this.length, newPoints, 0, this.length);
            points = newPoints;
        }
        this.points = points;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setWidthFunction(Function<Float, Float> widthFunction) {
        this.widthFunction = widthFunction;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setBillboard(boolean billboard) {
        this.billboard = billboard;
    }

    public Vec3[] getPoints() {
        return this.points;
    }

    public int getColor() {
        return this.color;
    }

    public Function<Float, Float> getWidthFunction() {
        return this.widthFunction;
    }

    public int getLength() {
        return this.length;
    }

    public boolean getBillboard() {
        return this.billboard;
    }

    public TilingMode getTilingMode() {
        return this.tilingMode;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public float getMinDistance() {
        return this.minDistance;
    }

    public ResourceLocation getTexture() {
        return this.texture;
    }

    public CurveMode getCurveMode() {
        return this.curveMode;
    }

    public void addPoint(Vec3 point) {
        Vec3[] newPoints = new Vec3[this.points.length + 1];
        System.arraycopy(this.points, 0, newPoints, 0, this.points.length);
        newPoints[this.points.length] = point;
        this.points = newPoints;
    }

    public void removePoint(int index) {
        Vec3[] newPoints = new Vec3[this.points.length - 1];
        System.arraycopy(this.points, 0, newPoints, 0, index);
        System.arraycopy(this.points, index + 1, newPoints, index, (this.points.length - index) - 1);
        this.points = newPoints;
    }

    public Vec3[] setupCurvePoints() {
        return this.curveMode.curveFunction.apply(this.points, Integer.valueOf(this.frequency));
    }

    public void render(PoseStack stack, VertexConsumer consumer, int light) {
        stack.pushPose();
        RenderSystem.disableCull();
        Vec3[] curvePoints = setupCurvePoints();
        Vector3f[][] corners = new Vector3f[curvePoints.length][2];
        for (int i = 0; i < curvePoints.length; i++) {
            float width = this.widthFunction.apply(Float.valueOf(i / (curvePoints.length - 1))).floatValue();
            Vector3f topOffset = new Vector3f(0.0f, width / 2.0f, 0.0f);
            Vector3f bottomOffset = new Vector3f(0.0f, -(width / 2.0f), 0.0f);
            if (this.billboard) {
            }
            topOffset.add((float) curvePoints[i].x, (float) curvePoints[i].y, (float) curvePoints[i].z);
            bottomOffset.add((float) curvePoints[i].x, (float) curvePoints[i].y, (float) curvePoints[i].z);
            corners[i / this.frequency][0] = topOffset;
            corners[i / this.frequency][1] = bottomOffset;
        }
        renderPoints(stack, consumer, light, corners, this.color);
        RenderSystem.enableCull();
        stack.popPose();
    }

    private void renderPoints(PoseStack stack, VertexConsumer consumer, int light, Vector3f[][] corners, int color) {
        stack.pushPose();
        float r = ((color >> 16) & 255) / 255.0f;
        float g = ((color >> 8) & 255) / 255.0f;
        float b = (color & 255) / 255.0f;
        float a = ((color >> 24) & 255) / 255.0f;
        for (int i = 0; i < corners.length - 1; i++) {
            Vector3f top = corners[i][0];
            Vector3f bottom = corners[i][1];
            Vector3f nextTop = corners[i + 1][0];
            Vector3f nextBottom = corners[i + 1][1];
            if (nextTop == null) {
                nextTop = top;
            }
            if (nextBottom == null) {
                nextBottom = bottom;
            }
            if (top != null && bottom != null) {
                float u = 0.0f;
                float u1 = 1.0f;
                if (this.tilingMode == TilingMode.STRETCH) {
                    u = i / (corners.length - 1);
                    u1 = (i + 1) / (corners.length - 1);
                }
                consumer.addVertex(stack.last().pose(), bottom.x(), bottom.y(), bottom.z()).setColor(r, g, b, a).setUv(u, 0.0f).setOverlay(OverlayTexture.NO_OVERLAY).setLight(light).setNormal(0.0f, 1.0f, 0.0f);
                consumer.addVertex(stack.last().pose(), top.x(), top.y(), top.z()).setColor(r, g, b, a).setUv(u, 1.0f).setOverlay(OverlayTexture.NO_OVERLAY).setLight(light).setNormal(0.0f, 1.0f, 0.0f);
                consumer.addVertex(stack.last().pose(), nextTop.x(), nextTop.y(), nextTop.z()).setColor(r, g, b, a).setUv(u1, 1.0f).setOverlay(OverlayTexture.NO_OVERLAY).setLight(light).setNormal(0.0f, 1.0f, 0.0f);
                consumer.addVertex(stack.last().pose(), nextBottom.x(), nextBottom.y(), nextBottom.z()).setColor(r, g, b, a).setUv(u1, 0.0f).setOverlay(OverlayTexture.NO_OVERLAY).setLight(light).setNormal(0.0f, 1.0f, 0.0f);
            }
        }
        stack.popPose();
    }
}
