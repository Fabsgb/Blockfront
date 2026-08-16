package com.boehmod.blockfront;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.util.FastColor;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Vector2dc;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.gL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gL.class */
public class C0370gL implements VertexConsumer {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ClientLevel f2516a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final VertexConsumer f2517a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Vector2dc f2518a;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final Vector2dc f2519b;

    public C0370gL(@NotNull ClientLevel clientLevel, @NotNull VertexConsumer vertexConsumer, @NotNull Vector2dc vector2dc, @NotNull Vector2dc vector2dc2) {
        this.f2516a = clientLevel;
        this.f2517a = vertexConsumer;
        this.f2518a = vector2dc;
        this.f2519b = vector2dc2;
    }

    public void addVertex(float f, float f2, float f3, int i, float f4, float f5, int i2, int i3, float f6, float f7, float f8) {
        Vector3f vector3f = new Vector3f(f6, f7, f8);
        Vector3f vector3f2 = Lighting.DIFFUSE_LIGHT_0;
        Vector3f vector3f3 = Lighting.DIFFUSE_LIGHT_1;
        if (this.f2516a.effects().constantAmbientLight()) {
            vector3f2 = Lighting.NETHER_DIFFUSE_LIGHT_0;
            vector3f3 = Lighting.NETHER_DIFFUSE_LIGHT_1;
        }
        double dMin = Math.min(1.0d, ((Math.max(0.0d, vector3f2.dot(vector3f)) + Math.max(0.0d, vector3f3.dot(vector3f))) * 0.6d) + 0.4d);
        int iColor = FastColor.ARGB32.color((int) (((double) FastColor.ARGB32.red(i)) * dMin), (int) (((double) FastColor.ARGB32.green(i)) * dMin), (int) (((double) FastColor.ARGB32.blue(i)) * dMin));
        addVertex(f, f2, f3);
        setColor(iColor);
        setUv(f4, f5);
        setOverlay(i2);
        setLight(i3);
        setNormal(f6, f7, f8);
    }

    @NotNull
    public VertexConsumer addVertex(@NotNull Matrix4f matrix4f, float f, float f2, float f3) {
        return super.addVertex(matrix4f, f, f2, f3);
    }

    @NotNull
    public VertexConsumer addVertex(float f, float f2, float f3) {
        this.f2517a.addVertex(f, f2, f3);
        return this;
    }

    @NotNull
    public VertexConsumer setColor(int i, int i2, int i3, int i4) {
        this.f2517a.setColor(i, i2, i3, i4);
        return this;
    }

    @NotNull
    public VertexConsumer setUv(float f, float f2) {
        double dX = this.f2518a.x();
        double dY = this.f2518a.y();
        double dX2 = this.f2519b.x() - dX;
        double dY2 = this.f2519b.y() - dY;
        this.f2517a.setUv((float) ((((double) f) * dX2) + dX), (float) ((((double) f2) * dY2) + dY));
        return this;
    }

    @NotNull
    public VertexConsumer setUv1(int i, int i2) {
        this.f2517a.setUv1(i, i2);
        return this;
    }

    @NotNull
    public VertexConsumer setUv2(int i, int i2) {
        this.f2517a.setUv2(i, i2);
        return this;
    }

    @NotNull
    public VertexConsumer setNormal(float f, float f2, float f3) {
        this.f2517a.setNormal(f, f2, f3);
        return this;
    }
}
