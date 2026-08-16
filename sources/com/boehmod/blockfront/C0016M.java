package com.boehmod.blockfront;

import com.boehmod.blockfront.client.corpse.physics.C0177c;
import com.boehmod.blockfront.client.corpse.physics.C0178d;
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
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Quaternionf;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3fc;

/* JADX INFO: renamed from: com.boehmod.blockfront.M */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/M.class */
public class C0016M {

    /* JADX INFO: renamed from: r */
    public static final float f203r = 3.0f;

    /* JADX INFO: renamed from: s */
    public static final float f204s = 7.0f;

    /* JADX INFO: renamed from: t */
    public static final float f205t = 6.0f;

    /* JADX INFO: renamed from: a */
    public static final Vector3dc f206a;

    /* JADX INFO: renamed from: b */
    public static final Vector3dc f207b;

    /* JADX INFO: renamed from: c */
    public static final Vector3dc f208c;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final C0025V f209a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final Quaternionf f210a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final Matrix4f f211a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final Matrix3f f212a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final BlockPos.MutableBlockPos f213a;

    /* JADX INFO: renamed from: r */
    private static final double f214r = 0.1d;

    /* JADX INFO: renamed from: s */
    public static final double f215s = 0.01d;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C0025V f216b;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final C0025V f217c;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0017N[] f218a;

    /* JADX INFO: renamed from: t */
    private final double f219t;

    /* JADX INFO: renamed from: u */
    private final double f220u;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final Vector3dc f221d;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final EnumC0018O f224a;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0178d f225a;

    /* JADX INFO: renamed from: K */
    static final /* synthetic */ boolean f227K;

    /* JADX INFO: renamed from: e */
    @NotNull
    private final List<C0177c> f222e = new ObjectArrayList();

    /* JADX INFO: renamed from: f */
    @NotNull
    private final List<AbstractC0020Q> f223f = new ObjectArrayList();

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0777nv f226a = null;

    static {
        f227K = !C0016M.class.desiredAssertionStatus();
        f206a = new Vector3d(0.7853981633974483d, 0.0d, 0.39269908169872414d);
        f207b = new Vector3d(0.39269908169872414d, 0.39269908169872414d, 2.5132741228718345d);
        f208c = new Vector3d(1.0471975511965976d, 1.5707963705062866d, 0.5235987755982988d);
        f209a = new C0025V();
        f210a = new Quaternionf();
        f211a = new Matrix4f();
        f212a = new Matrix3f();
        f213a = new BlockPos.MutableBlockPos();
    }

    public C0016M(@NotNull EnumC0018O enumC0018O, @NotNull InterfaceC0026W interfaceC0026W, @NotNull C0017N[] c0017nArr, double d, double d2) {
        this.f224a = enumC0018O;
        this.f216b = new C0025V(interfaceC0026W);
        this.f218a = c0017nArr;
        this.f219t = d;
        this.f220u = d2;
        C0021R c0021r = null;
        for (C0017N c0017n : c0017nArr) {
            if (c0017n.m93a() == EnumC0012I.BASIC) {
                for (ModelPart.Cube cube : c0017n.m95a()) {
                    if (c0021r == null) {
                        c0021r = new C0021R(cube.minX, cube.minY, cube.minZ, cube.maxX, cube.maxY, cube.maxZ);
                    } else {
                        c0021r.m113a(cube.minX, cube.minY, cube.minZ, c0021r);
                        c0021r.m113a(cube.maxX, cube.maxY, cube.maxZ, c0021r);
                    }
                }
            }
        }
        if (!f227K && c0021r == null) {
            throw new AssertionError("Ragdoll part must have at least one cube");
        }
        double d3 = 0.0625d * d;
        Vector3d vector3dMul = c0021r.m117a(new Vector3d()).mul(d3);
        this.f216b.mo155c().set(vector3dMul);
        this.f216b.mo157d().add(this.f216b.mo156a().transform(new Vector3d(vector3dMul)));
        this.f221d = c0021r.m118b(new Vector3d()).mul(0.5d * d3);
        this.f217c = new C0025V(this.f216b);
    }

    /* JADX INFO: renamed from: a */
    public void m73a(@NotNull C0777nv c0777nv) {
        this.f226a = c0777nv;
    }

    /* JADX INFO: renamed from: a */
    public void m74a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0394gj c0394gj, @NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, @NotNull LocalPlayer localPlayer, float f, int i, int i2, int i3, @NotNull ResourceLocation resourceLocation) {
        boolean z = false;
        for (C0017N c0017n : this.f218a) {
            if (c0017n.m92f().equals(resourceLocation)) {
                z = true;
                break;
            }
        }
        if (z) {
            poseStack.pushPose();
            m75a(poseStack, f);
            PoseStack.Pose poseLast = poseStack.last();
            f211a.set(poseLast.pose());
            f212a.set(poseLast.normal());
            boolean z2 = false;
            for (C0017N c0017n2 : this.f218a) {
                if (c0017n2.m92f().equals(resourceLocation)) {
                    if (z2) {
                        poseLast.pose().set(f211a);
                        poseLast.normal().set(f212a);
                    }
                    Vector3fc vector3fcM94a = c0017n2.m94a();
                    poseStack.scale(vector3fcM94a.x(), vector3fcM94a.y(), vector3fcM94a.z());
                    z2 = true;
                    for (ModelPart.Cube cube : c0017n2.m95a()) {
                        cube.compile(poseLast, vertexConsumer, i, i2, i3);
                    }
                }
            }
            poseStack.popPose();
        }
        if (this.f226a != null) {
            C0025V c0025vM145a = f209a.m144a(this.f217c).m145a(this.f216b, f);
            Vector3d vector3dMo157d = c0025vM145a.mo157d();
            this.f226a.setPos(vector3dMo157d.x, vector3dMo157d.y, vector3dMo157d.z);
            this.f226a.xo = vector3dMo157d.x;
            this.f226a.yo = vector3dMo157d.y;
            this.f226a.zo = vector3dMo157d.z;
            this.f226a.m3655a(EnumC0778nw.RAGDOLL);
            this.f226a.f4323b.set(c0025vM145a.mo156a());
            if ((!c0623l.m2895a().m3074aJ() && (c0394gj.m1104dt() || localPlayer.isDeadOrDying())) && minecraft.getCameraEntity() != this.f226a && minecraft.getCameraEntity() != this.f226a) {
                C0490iZ.m2215a(minecraft, this.f226a);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m75a(@NotNull PoseStack poseStack, float f) {
        C0025V c0025vM145a = f209a.m144a(this.f217c).m145a(this.f216b, f);
        Vector3d vector3dMo157d = c0025vM145a.mo157d();
        Quaterniond quaterniondMo156a = c0025vM145a.mo156a();
        Vector3d vector3dMo155c = c0025vM145a.mo155c();
        Vector3d vector3dMo154b = c0025vM145a.mo154b();
        poseStack.translate(vector3dMo157d.x, vector3dMo157d.y, vector3dMo157d.z);
        poseStack.mulPose(f210a.set(quaterniondMo156a));
        poseStack.scale((float) (this.f219t * vector3dMo154b.x), (float) (this.f219t * vector3dMo154b.y), (float) (this.f219t * vector3dMo154b.z));
        poseStack.translate(-vector3dMo155c.x, -vector3dMo155c.y, -vector3dMo155c.z);
    }

    /* JADX INFO: renamed from: a */
    public void m76a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel) {
        if (!f227K && this.f225a == null) {
            throw new AssertionError("Ragdoll part must have a physics body to update");
        }
        Vector3dc vector3dcMo157d = m78a().mo157d();
        this.f223f.removeIf(abstractC0020Q -> {
            return abstractC0020Q.mo96a(minecraft, c0623l, clientLevel, this, vector3dcMo157d);
        });
        this.f217c.m144a(this.f216b);
        this.f225a.m1078a(this.f216b);
    }

    /* JADX INFO: renamed from: a */
    public void m77a(@NotNull C0016M c0016m, @NotNull Vector3dc vector3dc, @NotNull Quaterniondc quaterniondc) {
        InterfaceC0026W interfaceC0026WM78a = m78a();
        InterfaceC0026W interfaceC0026WM78a2 = c0016m.m78a();
        Vector3d vector3dNegate = interfaceC0026WM78a.mo155c().negate(new Vector3d());
        Vector3d vector3d = new Vector3d();
        interfaceC0026WM78a.mo156a().transform(vector3dNegate, vector3d).add(interfaceC0026WM78a.mo157d());
        interfaceC0026WM78a2.mo156a().transformInverse(vector3d.sub(interfaceC0026WM78a2.mo157d()));
        this.f222e.add(new C0177c(c0016m, quaterniondc, new Quaterniond(), vector3dNegate, vector3d, vector3dc));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0026W m78a() {
        return this.f216b;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0178d m79a() {
        if (f227K || this.f225a != null) {
            return this.f225a;
        }
        throw new AssertionError("Ragdoll part must have a physics body to get");
    }

    /* JADX INFO: renamed from: a */
    public void m80a(@NotNull C0178d c0178d) {
        this.f225a = (C0178d) Objects.requireNonNull(c0178d);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Vector3dc m81a() {
        return this.f221d;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Collection<C0177c> m82a() {
        return Collections.unmodifiableList(this.f222e);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0017N[] m83a() {
        return this.f218a;
    }

    /* JADX INFO: renamed from: c */
    public double m84c() {
        return this.f220u;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0018O m85a() {
        return this.f224a;
    }

    /* JADX INFO: renamed from: q */
    public void m86q() {
        if (this.f226a != null) {
            this.f226a = null;
            Minecraft minecraft = Minecraft.getInstance();
            LocalPlayer localPlayer = minecraft.player;
            if (minecraft.getCameraEntity() == this.f226a && localPlayer != null) {
                C0490iZ.m2215a(minecraft, (Entity) localPlayer);
            }
        }
        m79a().m1077u();
    }

    /* JADX INFO: renamed from: r */
    public void m87r() {
        this.f226a = null;
    }

    /* JADX INFO: renamed from: a */
    public void m88a(@NotNull C0019P c0019p) {
        this.f223f.add(c0019p);
    }

    /* JADX INFO: renamed from: d */
    public void m89d(@NotNull ClientLevel clientLevel) {
        Vector3d vector3dMo157d = this.f216b.mo157d();
        double d = vector3dMo157d.x - 0.1d;
        double d2 = vector3dMo157d.y - 0.1d;
        double d3 = vector3dMo157d.z - 0.1d;
        double d4 = vector3dMo157d.x + 0.1d;
        double d5 = vector3dMo157d.y + 0.1d;
        double d6 = vector3dMo157d.z + 0.1d;
        double d7 = (d4 - d) * (d5 - d2) * (d6 - d3);
        double d8 = 0.0d;
        int iFloor = Mth.floor(d);
        int iFloor2 = Mth.floor(d2);
        int iFloor3 = Mth.floor(d3);
        int iFloor4 = Mth.floor(d4);
        int iFloor5 = Mth.floor(d5);
        int iFloor6 = Mth.floor(d6);
        for (int i = iFloor; i <= iFloor4; i++) {
            for (int i2 = iFloor2; i2 <= iFloor5; i2++) {
                for (int i3 = iFloor3; i3 <= iFloor6; i3++) {
                    if (!clientLevel.getBlockState(f213a.set(i, i2, i3)).getFluidState().isEmpty()) {
                        double dMin = Math.min(d4, i + 1) - Math.max(d, i);
                        double dMin2 = Math.min(d5, i2 + 1) - Math.max(d2, i2);
                        double dMin3 = Math.min(d6, i3 + 1) - Math.max(d3, i3);
                        if (dMin > 0.0d && dMin2 > 0.0d && dMin3 > 0.0d) {
                            d8 += dMin * dMin2 * dMin3;
                        }
                    }
                }
            }
        }
        m79a().m1080a(1.0d - (((d8 / d7) / (((this.f221d.x() * this.f221d.y()) * this.f221d.z()) * 8.0d)) * 0.01d));
    }
}
