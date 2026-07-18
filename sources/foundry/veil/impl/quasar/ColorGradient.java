package foundry.veil.impl.quasar;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.color.Color;
import foundry.veil.api.client.color.Colorc;
import foundry.veil.api.client.editor.EditorAttributeProvider;
import imgui.ImGui;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.util.Mth;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/quasar/ColorGradient.class */
public class ColorGradient implements EditorAttributeProvider {
    private static final Codec<Colorc> SINGLE_COLOR_CODEC = Color.ARGB_CODEC.fieldOf("color").codec();
    private static final Codec<ColorGradient> FULL_CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(RGBPoint.CODEC.listOf().fieldOf("rgb_points").forGetter((v0) -> {
            return v0.getPoints();
        }), AlphaPoint.CODEC.listOf().fieldOf("alpha_points").forGetter((v0) -> {
            return v0.getAlphaPoints();
        })).apply(instance, ColorGradient::new);
    });
    public static final Codec<ColorGradient> CODEC = Codec.either(SINGLE_COLOR_CODEC, FULL_CODEC).xmap(either -> {
        return (ColorGradient) either.map(ColorGradient::new, right -> {
            return right;
        });
    }, gradient -> {
        if (gradient.isConstant()) {
            Colorc point = gradient.points[0].color;
            return Either.left(new Color(point.red(), point.green(), point.blue(), gradient.alphaPoints[0].alpha));
        }
        return Either.right(gradient);
    });
    private RGBPoint[] points;
    private AlphaPoint[] alphaPoints;

    public ColorGradient(Colorc color) {
        this(color.red(), color.green(), color.blue(), color.alpha());
    }

    public ColorGradient(float red, float green, float blue, float alpha) {
        this.points = new RGBPoint[]{new RGBPoint(0.0f, new Color(red, green, blue))};
        this.alphaPoints = new AlphaPoint[]{new AlphaPoint(0.0f, alpha)};
    }

    public ColorGradient(RGBPoint[] points, AlphaPoint[] alphaPoints) {
        this.points = points;
        this.alphaPoints = alphaPoints;
    }

    public ColorGradient(RGBPoint[] points) {
        this(points, new AlphaPoint[]{new AlphaPoint(0.0f, 0.0f), new AlphaPoint(1.0f, 1.0f)});
    }

    public ColorGradient(List<RGBPoint> points, List<AlphaPoint> alphaPoints) {
        this((RGBPoint[]) points.toArray(new RGBPoint[0]), (AlphaPoint[]) alphaPoints.toArray(new AlphaPoint[0]));
    }

    public ColorGradient(Color startColor, Color endColor, float startAlpha, float endAlpha) {
        this(new RGBPoint[]{new RGBPoint(0.0f, startColor), new RGBPoint(1.0f, endColor)}, new AlphaPoint[]{new AlphaPoint(0.0f, startAlpha), new AlphaPoint(1.0f, endAlpha)});
    }

    public ColorGradient(Color startColor, Color endColor) {
        this(new RGBPoint[]{new RGBPoint(0.0f, startColor), new RGBPoint(1.0f, endColor)});
    }

    public boolean isConstant() {
        return this.points.length == 1 && this.alphaPoints.length == 1;
    }

    public Color getColor(float percentage) {
        return getColor(percentage, new Color());
    }

    public Color getColor(float percentage, Color store) {
        getRGB(percentage, store);
        store.alpha(getAlpha(percentage));
        return store;
    }

    private float getAlpha(float percentage) {
        if (this.alphaPoints.length == 0) {
            return 1.0f;
        }
        if (this.alphaPoints.length == 1) {
            return this.alphaPoints[0].alpha;
        }
        for (int i = 0; i < this.alphaPoints.length - 1; i++) {
            if (percentage >= this.alphaPoints[i].percent && percentage <= this.alphaPoints[i + 1].percent) {
                return Mth.lerp((percentage - this.alphaPoints[i].percent) / (this.alphaPoints[i + 1].percent - this.alphaPoints[i].percent), this.alphaPoints[i].alpha, this.alphaPoints[i + 1].alpha);
            }
        }
        return this.alphaPoints[this.alphaPoints.length - 1].alpha;
    }

    private void getRGB(float percentage, Color store) {
        if (this.points.length == 1) {
            store.set(this.points[0].color);
            return;
        }
        for (int i = 0; i < this.points.length - 1; i++) {
            if (percentage >= this.points[i].percent && percentage <= this.points[i + 1].percent) {
                store.set(this.points[i].color.lerp(this.points[i + 1].color, (percentage - this.points[i].percent) / (this.points[i + 1].percent - this.points[i].percent), store));
                return;
            }
        }
        store.set(this.points[this.points.length - 1].color);
    }

    public List<RGBPoint> getPoints() {
        return List.of((Object[]) this.points);
    }

    public List<AlphaPoint> getAlphaPoints() {
        return List.of((Object[]) this.alphaPoints);
    }

    @Override // foundry.veil.api.client.editor.EditorAttributeProvider
    public void renderImGuiAttributes() {
        ImGui.text("RGB Points");
        ImGui.indent();
        List<RGBPoint> pointsView = new ArrayList<>(List.of((Object[]) this.points));
        boolean dirty = false;
        int i = 0;
        while (i < pointsView.size()) {
            ImGui.pushID(i);
            RGBPoint point = pointsView.get(i);
            RGBPoint newPoint = renderRGBPoint(point);
            if (i != 0 && ImGui.arrowButton("##up", 2)) {
                RGBPoint pointAbove = pointsView.get(i - 1);
                pointsView.set(i - 1, point);
                pointsView.set(i, pointAbove);
                dirty = true;
            }
            if (i != 0 && i != pointsView.size() - 1) {
                ImGui.sameLine();
            }
            if (i != pointsView.size() - 1 && ImGui.arrowButton("##down", 3)) {
                RGBPoint pointBelow = pointsView.get(i + 1);
                pointsView.set(i + 1, point);
                pointsView.set(i, pointBelow);
                dirty = true;
            }
            if (newPoint != null) {
                if (newPoint.percent() == Float.MIN_VALUE) {
                    int i2 = i;
                    i--;
                    pointsView.remove(i2);
                } else {
                    pointsView.set(i, newPoint);
                }
                dirty = true;
            }
            ImGui.separator();
            ImGui.popID();
            i++;
        }
        if (ImGui.button("New RGB Point")) {
            if (pointsView.isEmpty()) {
                pointsView.add(new RGBPoint(0.0f, Color.WHITE));
            } else {
                pointsView.add(new RGBPoint(Math.min(((RGBPoint) pointsView.getLast()).percent() + 0.1f, 1.0f), Color.WHITE));
            }
            dirty = true;
        }
        ImGui.unindent();
        ImGui.text("Alpha Points");
        ImGui.indent();
        List<AlphaPoint> alphaPointsView = new ArrayList<>(List.of((Object[]) this.alphaPoints));
        int i3 = 0;
        while (i3 < alphaPointsView.size()) {
            ImGui.pushID(i3 + 999);
            AlphaPoint newPoint2 = renderAlphaPoint(alphaPointsView.get(i3));
            if (newPoint2 != null) {
                if (newPoint2.percent() == Float.MIN_VALUE) {
                    int i4 = i3;
                    i3--;
                    alphaPointsView.remove(i4);
                } else {
                    alphaPointsView.set(i3, newPoint2);
                }
                dirty = true;
            }
            ImGui.popID();
            i3++;
        }
        if (ImGui.button("New Alpha Point")) {
            if (alphaPointsView.isEmpty()) {
                alphaPointsView.add(new AlphaPoint(0.0f, 1.0f));
            } else {
                alphaPointsView.add(new AlphaPoint(Math.min(((AlphaPoint) alphaPointsView.getLast()).percent() + 0.1f, 1.0f), 1.0f));
            }
            dirty = true;
        }
        ImGui.unindent();
        if (dirty) {
            this.points = (RGBPoint[]) pointsView.toArray(new RGBPoint[0]);
            this.alphaPoints = (AlphaPoint[]) alphaPointsView.toArray(new AlphaPoint[0]);
        }
    }

    @Nullable
    private RGBPoint renderRGBPoint(RGBPoint point) {
        float[] editPercent = {point.percent()};
        float[] editColor = {point.color().red(), point.color().green(), point.color().blue()};
        boolean percentEdited = ImGui.dragScalar("percent", editPercent, 0.005f, 0.0f, 1.0f);
        boolean colorEdited = ImGui.colorEdit3("rgb", editColor);
        RGBPoint toReturn = null;
        if (percentEdited || colorEdited) {
            toReturn = new RGBPoint(editPercent[0], new Color(editColor[0], editColor[1], editColor[2]));
        }
        if (ImGui.button("Remove Point")) {
            toReturn = new RGBPoint(Float.MIN_VALUE, Color.BLACK);
        }
        return toReturn;
    }

    @Nullable
    private AlphaPoint renderAlphaPoint(AlphaPoint point) {
        float[] editPercent = {point.percent()};
        float[] editAlpha = {point.alpha()};
        boolean percentEdited = ImGui.dragScalar("percent", editPercent, 0.005f, 0.0f, 1.0f);
        boolean alphaEdited = ImGui.dragScalar("alpha", editAlpha, 0.005f, 0.0f, 1.0f);
        AlphaPoint toReturn = null;
        if (percentEdited || alphaEdited) {
            toReturn = new AlphaPoint(editPercent[0], editAlpha[0]);
        }
        if (ImGui.button("Remove Point")) {
            toReturn = new AlphaPoint(Float.MIN_VALUE, 0.0f);
        }
        return toReturn;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/quasar/ColorGradient$RGBPoint.class */
    public static final class RGBPoint extends Record {
        private final float percent;
        private final Colorc color;
        public static final Codec<RGBPoint> CODEC = RecordCodecBuilder.create(instance -> {
            return instance.group(Codec.FLOAT.fieldOf("percent").forGetter((v0) -> {
                return v0.percent();
            }), Color.RGB_CODEC.fieldOf("color").forGetter((v0) -> {
                return v0.color();
            })).apply(instance, (v1, v2) -> {
                return new RGBPoint(v1, v2);
            });
        });

        public RGBPoint(float percent, Colorc color) {
            this.percent = percent;
            this.color = color;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, RGBPoint.class), RGBPoint.class, "percent;color", "FIELD:Lfoundry/veil/impl/quasar/ColorGradient$RGBPoint;->percent:F", "FIELD:Lfoundry/veil/impl/quasar/ColorGradient$RGBPoint;->color:Lfoundry/veil/api/client/color/Colorc;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, RGBPoint.class), RGBPoint.class, "percent;color", "FIELD:Lfoundry/veil/impl/quasar/ColorGradient$RGBPoint;->percent:F", "FIELD:Lfoundry/veil/impl/quasar/ColorGradient$RGBPoint;->color:Lfoundry/veil/api/client/color/Colorc;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, RGBPoint.class, Object.class), RGBPoint.class, "percent;color", "FIELD:Lfoundry/veil/impl/quasar/ColorGradient$RGBPoint;->percent:F", "FIELD:Lfoundry/veil/impl/quasar/ColorGradient$RGBPoint;->color:Lfoundry/veil/api/client/color/Colorc;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public float percent() {
            return this.percent;
        }

        public Colorc color() {
            return this.color;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/quasar/ColorGradient$AlphaPoint.class */
    public static final class AlphaPoint extends Record {
        private final float percent;
        private final float alpha;
        public static final Codec<AlphaPoint> CODEC = RecordCodecBuilder.create(instance -> {
            return instance.group(Codec.FLOAT.fieldOf("percent").forGetter((v0) -> {
                return v0.percent();
            }), Codec.FLOAT.fieldOf("alpha").forGetter((v0) -> {
                return v0.alpha();
            })).apply(instance, (v1, v2) -> {
                return new AlphaPoint(v1, v2);
            });
        });

        public AlphaPoint(float percent, float alpha) {
            this.percent = percent;
            this.alpha = alpha;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, AlphaPoint.class), AlphaPoint.class, "percent;alpha", "FIELD:Lfoundry/veil/impl/quasar/ColorGradient$AlphaPoint;->percent:F", "FIELD:Lfoundry/veil/impl/quasar/ColorGradient$AlphaPoint;->alpha:F").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, AlphaPoint.class), AlphaPoint.class, "percent;alpha", "FIELD:Lfoundry/veil/impl/quasar/ColorGradient$AlphaPoint;->percent:F", "FIELD:Lfoundry/veil/impl/quasar/ColorGradient$AlphaPoint;->alpha:F").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, AlphaPoint.class, Object.class), AlphaPoint.class, "percent;alpha", "FIELD:Lfoundry/veil/impl/quasar/ColorGradient$AlphaPoint;->percent:F", "FIELD:Lfoundry/veil/impl/quasar/ColorGradient$AlphaPoint;->alpha:F").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public float percent() {
            return this.percent;
        }

        public float alpha() {
            return this.alpha;
        }
    }
}
