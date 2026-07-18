package com.boehmod.blockfront;

import com.boehmod.blockfront.client.corpse.physics.C0176c;
import com.boehmod.blockfront.client.corpse.physics.C0177d;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.G */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/G.class */
public class C0009G {

    /* JADX INFO: renamed from: m */
    public static final float f163m = 3.0f;

    /* JADX INFO: renamed from: n */
    public static final float f164n = 7.0f;

    /* JADX INFO: renamed from: o */
    public static final float f165o = 6.0f;

    /* JADX INFO: renamed from: a */
    public static final Vector3dc f166a;

    /* JADX INFO: renamed from: b */
    public static final Vector3dc f167b;

    /* JADX INFO: renamed from: c */
    public static final Vector3dc f168c;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final C0018P f169a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final Quaternionf f170a;

    /* JADX INFO: renamed from: k */
    private static final double f171k = 0.1d;

    /* JADX INFO: renamed from: l */
    public static final double f172l = 0.01d;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C0018P f173b;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final C0018P f174c;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0010H[] f175a;

    /* JADX INFO: renamed from: m */
    private final double f176m;

    /* JADX INFO: renamed from: n */
    private final double f177n;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final Vector3dc f178d;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final EnumC0011I f181a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0177d f182a;

    /* JADX INFO: renamed from: F */
    static final /* synthetic */ boolean f184F;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final List<C0176c> f179d = new ObjectArrayList();

    /* JADX INFO: renamed from: e */
    @NotNull
    private final List<AbstractC0013K> f180e = new ObjectArrayList();

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0701mZ f183a = null;

    static {
        f184F = !C0009G.class.desiredAssertionStatus();
        f166a = new Vector3d(0.7853981633974483d, 0.0d, 0.39269908169872414d);
        f167b = new Vector3d(0.39269908169872414d, 0.39269908169872414d, 2.5132741228718345d);
        f168c = new Vector3d(1.0471975511965976d, 1.5707963705062866d, 0.5235987755982988d);
        f169a = new C0018P();
        f170a = new Quaternionf();
    }

    public C0009G(@NotNull EnumC0011I enumC0011I, @NotNull InterfaceC0019Q interfaceC0019Q, @NotNull C0010H[] c0010hArr, double d, double d2) {
        this.f181a = enumC0011I;
        this.f173b = new C0018P(interfaceC0019Q);
        this.f175a = c0010hArr;
        this.f176m = d;
        this.f177n = d2;
        C0014L c0014l = null;
        for (C0010H c0010h : c0010hArr) {
            if (c0010h.m60a() == EnumC0005C.BASIC) {
                for (ModelPart.Cube cube : c0010h.m62a()) {
                    if (c0014l == null) {
                        c0014l = new C0014L(cube.minX, cube.minY, cube.minZ, cube.maxX, cube.maxY, cube.maxZ);
                    } else {
                        c0014l.m80a(cube.minX, cube.minY, cube.minZ, c0014l);
                        c0014l.m80a(cube.maxX, cube.maxY, cube.maxZ, c0014l);
                    }
                }
            }
        }
        if (!f184F && c0014l == null) {
            throw new AssertionError("Ragdoll part must have at least one cube");
        }
        double d3 = 0.0625d * d;
        Vector3d vector3dMul = c0014l.m84a(new Vector3d()).mul(d3);
        this.f173b.mo122c().set(vector3dMul);
        this.f173b.mo124d().add(this.f173b.mo123a().transform(new Vector3d(vector3dMul)));
        this.f178d = c0014l.m85b(new Vector3d()).mul(0.5d * d3);
        this.f174c = new C0018P(this.f173b);
    }

    /* JADX INFO: renamed from: a */
    public void m40a(@NotNull C0701mZ c0701mZ) {
        this.f183a = c0701mZ;
    }

    /* JADX INFO: renamed from: a */
    public void m41a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0324fT c0324fT, @NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, @NotNull LocalPlayer localPlayer, float f, int i, int i2, int i3, @NotNull ResourceLocation resourceLocation) {
        poseStack.pushPose();
        m42a(poseStack, f);
        for (C0010H c0010h : this.f175a) {
            if (c0010h.m59f().equals(resourceLocation)) {
                Vector3fc vector3fcM61a = c0010h.m61a();
                poseStack.pushPose();
                poseStack.scale(vector3fcM61a.x(), vector3fcM61a.y(), vector3fcM61a.z());
                PoseStack.Pose poseLast = poseStack.last();
                for (ModelPart.Cube cube : c0010h.m62a()) {
                    cube.compile(poseLast, vertexConsumer, i, i2, i3);
                }
                poseStack.popPose();
            }
        }
        poseStack.popPose();
        if (this.f183a != null) {
            C0018P c0018pM112a = f169a.m111a(this.f174c).m112a(this.f173b, f);
            Vector3d vector3dMo124d = c0018pM112a.mo124d();
            this.f183a.setPos(vector3dMo124d.x, vector3dMo124d.y, vector3dMo124d.z);
            this.f183a.xo = vector3dMo124d.x;
            this.f183a.yo = vector3dMo124d.y;
            this.f183a.zo = vector3dMo124d.z;
            this.f183a.m3148a(EnumC0755na.RAGDOLL);
            this.f183a.f3760b.set(c0018pM112a.mo123a());
            if ((!c0622l.m2709a().m3241ay() && (c0324fT.m1087dk() || localPlayer.isDeadOrDying())) && minecraft.getCameraEntity() != this.f183a && minecraft.getCameraEntity() != this.f183a) {
                C0470iG.m2123a(minecraft, this.f183a);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m42a(@NotNull PoseStack poseStack, float f) {
        C0018P c0018pM112a = f169a.m111a(this.f174c).m112a(this.f173b, f);
        Vector3d vector3dMo124d = c0018pM112a.mo124d();
        Quaterniond quaterniondMo123a = c0018pM112a.mo123a();
        Vector3d vector3dMo122c = c0018pM112a.mo122c();
        Vector3d vector3dMo121b = c0018pM112a.mo121b();
        poseStack.translate(vector3dMo124d.x, vector3dMo124d.y, vector3dMo124d.z);
        poseStack.mulPose(f170a.set(quaterniondMo123a));
        poseStack.scale((float) (this.f176m * vector3dMo121b.x), (float) (this.f176m * vector3dMo121b.y), (float) (this.f176m * vector3dMo121b.z));
        poseStack.translate(-vector3dMo122c.x, -vector3dMo122c.y, -vector3dMo122c.z);
    }

    /* JADX INFO: renamed from: a */
    public void m43a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel) {
        if (!f184F && this.f182a == null) {
            throw new AssertionError("Ragdoll part must have a physics body to update");
        }
        Vector3dc vector3dcMo124d = m45a().mo124d();
        this.f180e.removeIf(abstractC0013K -> {
            return abstractC0013K.mo63a(minecraft, c0622l, clientLevel, this, vector3dcMo124d);
        });
        this.f174c.m111a(this.f173b);
        this.f182a.m1054a(this.f173b);
    }

    /* JADX INFO: renamed from: a */
    public void m44a(@NotNull C0009G c0009g, @NotNull Vector3dc vector3dc, @NotNull Quaterniondc quaterniondc) {
        InterfaceC0019Q interfaceC0019QM45a = m45a();
        InterfaceC0019Q interfaceC0019QM45a2 = c0009g.m45a();
        Vector3d vector3dNegate = interfaceC0019QM45a.mo122c().negate(new Vector3d());
        Vector3d vector3d = new Vector3d();
        interfaceC0019QM45a.mo123a().transform(vector3dNegate, vector3d).add(interfaceC0019QM45a.mo124d());
        interfaceC0019QM45a2.mo123a().transformInverse(vector3d.sub(interfaceC0019QM45a2.mo124d()));
        this.f179d.add(new C0176c(c0009g, quaterniondc, new Quaterniond(), vector3dNegate, vector3d, vector3dc));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0019Q m45a() {
        return this.f173b;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0177d m46a() {
        if (f184F || this.f182a != null) {
            return this.f182a;
        }
        throw new AssertionError("Ragdoll part must have a physics body to get");
    }

    /* JADX INFO: renamed from: a */
    public void m47a(@NotNull C0177d c0177d) {
        this.f182a = (C0177d) Objects.requireNonNull(c0177d);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Vector3dc m48a() {
        return this.f178d;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Collection<C0176c> m49a() {
        return Collections.unmodifiableList(this.f179d);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0010H[] m50a() {
        return this.f175a;
    }

    /* JADX INFO: renamed from: a */
    public double m51a() {
        return this.f177n;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0011I m52a() {
        return this.f181a;
    }

    /* JADX INFO: renamed from: n */
    public void m53n() {
        if (this.f183a != null) {
            this.f183a = null;
            Minecraft minecraft = Minecraft.getInstance();
            LocalPlayer localPlayer = minecraft.player;
            if (minecraft.getCameraEntity() == this.f183a && localPlayer != null) {
                C0470iG.m2123a(minecraft, (Entity) localPlayer);
            }
        }
        m46a().m1053r();
    }

    /* JADX INFO: renamed from: o */
    public void m54o() {
        this.f183a = null;
    }

    /* JADX INFO: renamed from: a */
    public void m55a(@NotNull C0012J c0012j) {
        this.f180e.add(c0012j);
    }

    /* JADX INFO: renamed from: d */
    public void m56d(@NotNull ClientLevel clientLevel) {
        Vector3d vector3dMo124d = this.f173b.mo124d();
        AABB aabbInflate = new AABB(vector3dMo124d.x, vector3dMo124d.y, vector3dMo124d.z, vector3dMo124d.x, vector3dMo124d.y, vector3dMo124d.z).inflate(0.1d);
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
        m46a().m1056a(1.0d - (((d / xsize) / (((this.f178d.x() * this.f178d.y()) * this.f178d.z()) * 8.0d)) * 0.01d));
    }
}
