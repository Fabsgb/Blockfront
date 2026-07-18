package foundry.veil.api.quasar.p002fx;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.serialization.Codec;
import foundry.veil.api.client.render.MatrixStack;
import foundry.veil.api.quasar.emitters.module.render.TrailSettings;
import foundry.veil.api.util.EnumCodec;
import foundry.veil.impl.quasar.MathUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Vector3f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/fx/Trail.class */
public class Trail {
    private List<Vec3> points;
    private final List<Vec3> rotations;
    private int color;
    private Function<Float, Float> widthFunction;
    private int length;
    private boolean billboard;
    private TilingMode tilingMode;
    private int frequency;
    private float minDistance;
    private ResourceLocation texture;
    private boolean additive;
    private boolean parentRotation;
    private int timeout;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/quasar/fx/Trail$TilingMode.class */
    public enum TilingMode {
        NONE,
        STRETCH,
        REPEAT;

        public static final Codec<TilingMode> CODEC = EnumCodec.builder("Tiling Mode").values(values()).build();
    }

    public Trail(TrailSettings settings) {
        this(MathUtil.colorFromVec4f(settings.getTrailColor()), ageScale -> {
            return Float.valueOf(settings.getTrailWidthModifier().modify(ageScale.floatValue(), 1.0d));
        });
        this.billboard = settings.getBillboard();
        this.length = settings.getTrailLength();
        this.frequency = settings.getTrailFrequency();
        this.tilingMode = settings.getTilingMode();
        this.texture = settings.getTrailTexture();
        this.additive = settings.isAdditive();
        this.parentRotation = settings.getParentRotation();
    }

    public Trail(Collection<Vec3> points, int color, Function<Float, Float> widthFunction) {
        this.points = new ArrayList();
        this.rotations = new ArrayList();
        this.length = 100;
        this.billboard = false;
        this.tilingMode = TilingMode.STRETCH;
        this.frequency = 1;
        this.minDistance = 0.0f;
        this.texture = null;
        this.additive = false;
        this.parentRotation = false;
        this.timeout = 0;
        this.points.addAll(points);
        this.color = color;
        this.widthFunction = widthFunction;
    }

    public Trail(int color, Function<Float, Float> widthFunction) {
        this(List.of(), color, widthFunction);
    }

    public void setParentRotation(boolean parentRotation) {
        this.parentRotation = parentRotation;
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
        this.points = new ArrayList(Arrays.asList(points));
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setBillboard(boolean billboard) {
        this.billboard = billboard;
    }

    public boolean isAdditive() {
        return this.additive;
    }

    public void setAdditive(boolean additive) {
        this.additive = additive;
    }

    public void setWidthFunction(Function<Float, Float> widthFunction) {
        this.widthFunction = widthFunction;
    }

    @Nullable
    public ResourceLocation getTexture() {
        return this.texture;
    }

    public int getLength() {
        return this.length;
    }

    public void pushRotatedPoint(Vec3 point, Vec3 rotation) {
        if (this.timeout > 80 && this.timeout % 5 == 0 && !this.points.isEmpty()) {
            this.points.removeLast();
            this.rotations.removeLast();
            return;
        }
        if (this.points.isEmpty()) {
            this.points.addFirst(point);
            this.rotations.addFirst(rotation);
            return;
        }
        if (((Vec3) this.points.getLast()).distanceTo(point) < this.minDistance) {
            this.timeout++;
            return;
        }
        if (!this.points.isEmpty() && ((Vec3) this.points.getLast()).equals(point)) {
            this.timeout++;
            return;
        }
        this.timeout = 0;
        this.points.addFirst(point);
        this.rotations.addFirst(rotation);
        if (this.points.size() > this.length) {
            this.points.removeLast();
            this.rotations.removeLast();
        }
    }

    @ApiStatus.Internal
    public void render(MatrixStack stack, VertexConsumer consumer, int light, float partialTicks, Vec3 target, Vec3 targetRotation) {
        Vec3 lerpedRotation;
        Vec3 lerpedPoint;
        if (this.points.isEmpty()) {
            return;
        }
        List<Vec3> lerpedPoints = new ArrayList<>();
        for (int i = 0; i < this.points.size(); i++) {
            Vec3 lerpedPoint2 = this.points.get(i);
            if (i == 0) {
                lerpedPoint = lerpedPoint2.lerp(target, partialTicks);
            } else {
                lerpedPoint = lerpedPoint2.lerp(this.points.get(i - 1), partialTicks);
            }
            lerpedPoints.add(lerpedPoint);
        }
        List<Vec3> lerpedRotations = new ArrayList<>();
        for (int i2 = 0; i2 < this.rotations.size(); i2++) {
            Vec3 lerpedRotation2 = this.rotations.get(i2);
            if (i2 == 0) {
                lerpedRotation = lerpedRotation2.lerp(targetRotation, partialTicks);
            } else {
                lerpedRotation = lerpedRotation2.lerp(this.rotations.get(i2 - 1), partialTicks);
            }
            lerpedRotations.add(lerpedRotation);
        }
        Vector3f[][] corners = new Vector3f[lerpedPoints.size()][2];
        for (int i3 = 0; i3 < lerpedPoints.size(); i3++) {
            if (i3 % this.frequency == 0) {
                float width = this.widthFunction.apply(Float.valueOf(i3 / (lerpedPoints.size() - 1))).floatValue();
                Vector3f topOffset = new Vector3f(0.0f, width / 2.0f, 0.0f);
                Vector3f bottomOffset = new Vector3f(0.0f, -(width / 2.0f), 0.0f);
                if (this.billboard) {
                    Vec3 a = Minecraft.getInstance().gameRenderer.getMainCamera().getPosition().subtract(lerpedPoints.get(i3)).normalize();
                    Vector3f cameraDirection = new Vector3f((float) a.x, (float) a.y, (float) a.z);
                    Vec3 b = lerpedPoints.get(Math.min(i3 + this.frequency, lerpedPoints.size() - 1)).subtract(lerpedPoints.get(i3)).normalize();
                    Vector3f dirToNextPoint = new Vector3f((float) b.x(), (float) b.y(), (float) b.z());
                    Vector3f axis = new Vector3f(cameraDirection);
                    axis.mul(-1.0f);
                    axis.cross(dirToNextPoint);
                    topOffset = new Vector3f(axis);
                    topOffset.mul(width / 2.0f);
                    bottomOffset = new Vector3f(axis);
                    bottomOffset.mul((-width) / 2.0f);
                } else if (lerpedRotations.get(i3) != null && this.parentRotation) {
                    Vec3 a2 = lerpedRotations.get(Math.min(i3 + this.frequency, lerpedRotations.size() - 1));
                    Vector3f cameraDirection2 = new Vector3f((float) a2.x, (float) a2.y, (float) a2.z);
                    Vec3 b2 = lerpedPoints.get(Math.min(i3 + this.frequency, lerpedPoints.size() - 1)).subtract(lerpedPoints.get(i3)).normalize();
                    Vector3f dirToNextPoint2 = new Vector3f((float) b2.x(), (float) b2.y(), (float) b2.z());
                    Vector3f axis2 = new Vector3f(cameraDirection2);
                    axis2.mul(-1.0f);
                    axis2.cross(dirToNextPoint2);
                    topOffset = new Vector3f(axis2);
                    topOffset.mul(width / 2.0f);
                    bottomOffset = new Vector3f(axis2);
                    bottomOffset.mul((-width) / 2.0f);
                }
                topOffset.add((float) lerpedPoints.get(i3).x, (float) lerpedPoints.get(i3).y, (float) lerpedPoints.get(i3).z);
                bottomOffset.add((float) lerpedPoints.get(i3).x, (float) lerpedPoints.get(i3).y, (float) lerpedPoints.get(i3).z);
                corners[i3 / this.frequency][0] = topOffset;
                corners[i3 / this.frequency][1] = bottomOffset;
            }
        }
        renderPoints(stack, consumer, light, corners, this.color);
    }

    private void renderPoints(MatrixStack stack, VertexConsumer consumer, int light, Vector3f[][] corners, int color) {
        int r = (color >> 16) & 255;
        int g = (color >> 8) & 255;
        int b = color & 255;
        int a = (color >> 24) & 255;
        for (int i = 0; i < corners.length; i++) {
            Vector3f top = corners[i][0];
            Vector3f bottom = corners[i][1];
            if (top != null && bottom != null) {
                float u = 0.0f;
                if (this.tilingMode == TilingMode.STRETCH) {
                    u = i / (corners.length - 1);
                }
                Matrix4f matrix4f = stack.position();
                consumer.addVertex(matrix4f, bottom.x(), bottom.y(), bottom.z()).setColor(r, g, b, a).setUv(u, 0.0f).setOverlay(OverlayTexture.NO_OVERLAY).setLight(light).setNormal(0.0f, 1.0f, 0.0f);
                consumer.addVertex(matrix4f, top.x(), top.y(), top.z()).setColor(r, g, b, a).setUv(u, 1.0f).setOverlay(OverlayTexture.NO_OVERLAY).setLight(light).setNormal(0.0f, 1.0f, 0.0f);
            }
        }
    }
}
