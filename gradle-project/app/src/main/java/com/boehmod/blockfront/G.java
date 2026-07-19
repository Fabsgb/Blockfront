package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Quaternionf;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/G.class */
public class G {
    public static final float m = 3.0f;
    public static final float n = 7.0f;
    public static final float o = 6.0f;
    public static final Vector3dc a;
    public static final Vector3dc b;
    public static final Vector3dc c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private static final P f11a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private static final Quaternionf f12a;
    private static final double k = 0.1d;
    public static final double l = 0.01d;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NotNull
    private final P f13b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NotNull
    private final P f14c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final H[] f15a;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    private final double f16m;

    /* JADX INFO: renamed from: n, reason: collision with other field name */
    private final double f17n;

    @NotNull
    private final Vector3dc d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final I f19a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private com.boehmod.blockfront.client.corpse.physics.d f20a;
    static final /* synthetic */ boolean F;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NotNull
    private final List<com.boehmod.blockfront.client.corpse.physics.c> f18d = new ObjectArrayList();

    @NotNull
    private final List<K> e = new ObjectArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private mZ f21a = null;

    static {
        F = !G.class.desiredAssertionStatus();
        a = new Vector3d(0.7853981633974483d, 0.0d, 0.39269908169872414d);
        b = new Vector3d(0.39269908169872414d, 0.39269908169872414d, 2.5132741228718345d);
        c = new Vector3d(1.0471975511965976d, 1.5707963705062866d, 0.5235987755982988d);
        f11a = new P();
        f12a = new Quaternionf();
    }

    public G(@NotNull I i, @NotNull Q q, @NotNull H[] hArr, double d, double d2) {
        this.f19a = i;
        this.f13b = new P(q);
        this.f15a = hArr;
        this.f16m = d;
        this.f17n = d2;
        L l2 = null;
        for (H h : hArr) {
            if (h.a() == C.BASIC) {
                for (ModelPart.Cube cube : h.m152a()) {
                    if (l2 == null) {
                        l2 = new L(cube.minX, cube.minY, cube.minZ, cube.maxX, cube.maxY, cube.maxZ);
                    } else {
                        l2.a(cube.minX, cube.minY, cube.minZ, l2);
                        l2.a(cube.maxX, cube.maxY, cube.maxZ, l2);
                    }
                }
            }
        }
        if (!F && l2 == null) {
            throw new AssertionError("Ragdoll part must have at least one cube");
        }
        double d3 = 0.0625d * d;
        Vector3d vector3dMul = l2.a(new Vector3d()).mul(d3);
        this.f13b.mo157c().set(vector3dMul);
        this.f13b.d().add(this.f13b.mo158a().transform(new Vector3d(vector3dMul)));
        this.d = l2.b(new Vector3d()).mul(0.5d * d3);
        this.f14c = new P(this.f13b);
    }

    public void a(@NotNull mZ mZVar) {
        this.f21a = mZVar;
    }

    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fT fTVar, @NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, @NotNull LocalPlayer localPlayer, float f, int i, int i2, int i3, @NotNull ResourceLocation resourceLocation) {
        poseStack.pushPose();
        a(poseStack, f);
        for (H h : this.f15a) {
            if (h.f().equals(resourceLocation)) {
                Vector3fc vector3fcM151a = h.m151a();
                poseStack.pushPose();
                poseStack.scale(vector3fcM151a.x(), vector3fcM151a.y(), vector3fcM151a.z());
                PoseStack.Pose poseLast = poseStack.last();
                for (ModelPart.Cube cube : h.m152a()) {
                    cube.compile(poseLast, vertexConsumer, i, i2, i3);
                }
                poseStack.popPose();
            }
        }
        poseStack.popPose();
        if (this.f21a != null) {
            P pA = f11a.a(this.f14c).a(this.f13b, f);
            Vector3d vector3dD = pA.d();
            this.f21a.setPos(vector3dD.x, vector3dD.y, vector3dD.z);
            this.f21a.xo = vector3dD.x;
            this.f21a.yo = vector3dD.y;
            this.f21a.zo = vector3dD.z;
            this.f21a.a(EnumC0352na.RAGDOLL);
            this.f21a.b.set(pA.mo158a());
            if ((!c0297l.m602a().ay() && (fTVar.dk() || localPlayer.isDeadOrDying())) && minecraft.getCameraEntity() != this.f21a && minecraft.getCameraEntity() != this.f21a) {
                iG.a(minecraft, this.f21a);
            }
        }
    }

    public void a(@NotNull PoseStack poseStack, float f) {
        P pA = f11a.a(this.f14c).a(this.f13b, f);
        Vector3d vector3dD = pA.d();
        Quaterniond quaterniondMo158a = pA.mo158a();
        Vector3d vector3dMo157c = pA.mo157c();
        Vector3d vector3dMo156b = pA.mo156b();
        poseStack.translate(vector3dD.x, vector3dD.y, vector3dD.z);
        poseStack.mulPose(f12a.set(quaterniondMo158a));
        poseStack.scale((float) (this.f16m * vector3dMo156b.x), (float) (this.f16m * vector3dMo156b.y), (float) (this.f16m * vector3dMo156b.z));
        poseStack.translate(-vector3dMo157c.x, -vector3dMo157c.y, -vector3dMo157c.z);
    }

    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel) {
        if (!F && this.f20a == null) {
            throw new AssertionError("Ragdoll part must have a physics body to update");
        }
        Vector3dc vector3dcD = a().d();
        this.e.removeIf(k2 -> {
            return k2.a(minecraft, c0297l, clientLevel, this, vector3dcD);
        });
        this.f14c.a(this.f13b);
        this.f20a.a(this.f13b);
    }

    public void a(@NotNull G g, @NotNull Vector3dc vector3dc, @NotNull Quaterniondc quaterniondc) {
        Q qA = a();
        Q qA2 = g.a();
        Vector3d vector3dNegate = qA.mo157c().negate(new Vector3d());
        Vector3d vector3d = new Vector3d();
        qA.mo158a().transform(vector3dNegate, vector3d).add(qA.d());
        qA2.mo158a().transformInverse(vector3d.sub(qA2.d()));
        this.f18d.add(new com.boehmod.blockfront.client.corpse.physics.c(g, quaterniondc, new Quaterniond(), vector3dNegate, vector3d, vector3dc));
    }

    @NotNull
    public Q a() {
        return this.f13b;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public com.boehmod.blockfront.client.corpse.physics.d m145a() {
        if (F || this.f20a != null) {
            return this.f20a;
        }
        throw new AssertionError("Ragdoll part must have a physics body to get");
    }

    public void a(@NotNull com.boehmod.blockfront.client.corpse.physics.d dVar) {
        this.f20a = (com.boehmod.blockfront.client.corpse.physics.d) Objects.requireNonNull(dVar);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Vector3dc m146a() {
        return this.d;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Collection<com.boehmod.blockfront.client.corpse.physics.c> m147a() {
        return Collections.unmodifiableList(this.f18d);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public H[] m148a() {
        return this.f15a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public double m149a() {
        return this.f17n;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public I m150a() {
        return this.f19a;
    }

    public void n() {
        if (this.f21a != null) {
            this.f21a = null;
            Minecraft minecraft = Minecraft.getInstance();
            LocalPlayer localPlayer = minecraft.player;
            if (minecraft.getCameraEntity() == this.f21a && localPlayer != null) {
                iG.a(minecraft, (Entity) localPlayer);
            }
        }
        m145a().r();
    }

    public void o() {
        this.f21a = null;
    }

    public void a(@NotNull J j) {
        this.e.add(j);
    }

    public void d(@NotNull ClientLevel clientLevel) {
        Vector3d vector3dD = this.f13b.d();
        AABB aabbInflate = new AABB(vector3dD.x, vector3dD.y, vector3dD.z, vector3dD.x, vector3dD.y, vector3dD.z).inflate(0.1d);
        double xsize = aabbInflate.getXsize() * aabbInflate.getYsize() * aabbInflate.getZsize();
        double d = 0.0d;
        for (BlockPos blockPos : BlockPos.betweenClosed(Mth.floor(aabbInflate.minX), Mth.floor(aabbInflate.minY), Mth.floor(aabbInflate.minZ), Mth.floor(aabbInflate.maxX), Mth.floor(aabbInflate.maxY), Mth.floor(aabbInflate.maxZ))) {
            if (!clientLevel.getBlockState(blockPos).getFluidState().isEmpty()) {
                AABB aabbIntersect = new AABB(blockPos).intersect(aabbInflate);
                double xsize2 = aabbIntersect.getXsize();
                double ysize = aabbIntersect.getYsize();
                double zsize = aabbIntersect.getZsize();
                if (xsize2 > 0.0d && ysize > 0.0d && zsize > 0.0d) {
                    d += xsize2 * ysize * zsize;
                }
            }
        }
        m145a().a(1.0d - (((d / xsize) / (((this.d.x() * this.d.y()) * this.d.z()) * 8.0d)) * 0.01d));
    }
}
