package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import it.unimi.dsi.fastutil.floats.FloatFloatImmutablePair;
import it.unimi.dsi.fastutil.floats.FloatFloatPair;
import java.util.stream.IntStream;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.nY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/nY.class */
public class C0754nY {

    /* JADX INFO: renamed from: ki */
    private float f4165ki;

    /* JADX INFO: renamed from: kj */
    private float f4166kj;

    /* JADX INFO: renamed from: kk */
    private float f4167kk;

    /* JADX INFO: renamed from: kl */
    private float f4168kl;

    /* JADX INFO: renamed from: oe */
    public int f4164oe = 0;

    /* JADX INFO: renamed from: km */
    private float f4169km = 0.0f;

    /* JADX INFO: renamed from: kn */
    private float f4170kn = 0.0f;

    /* JADX INFO: renamed from: ko */
    private float f4171ko = 0.0f;

    /* JADX INFO: renamed from: kp */
    private float f4172kp = 0.0f;

    /* JADX INFO: renamed from: c */
    public void m3489c(@NotNull AbstractC0750nU abstractC0750nU) {
        this.f4167kk = this.f4165ki;
        this.f4168kl = this.f4166kj;
        this.f4165ki = this.f4171ko;
        this.f4166kj = this.f4172kp;
        int i = this.f4164oe;
        this.f4164oe = i + 1;
        if (i >= 4) {
            this.f4164oe = 0;
            m3491e(abstractC0750nU);
        }
        m3490d(abstractC0750nU);
    }

    /* JADX INFO: renamed from: d */
    public void m3490d(@NotNull AbstractC0750nU abstractC0750nU) {
        C0809oa<AbstractC0750nU> c0809oaM3436b = abstractC0750nU.m3436b();
        float fM3442aE = abstractC0750nU.m3442aE();
        float fMin = Math.min(0.1f, 0.01f + (2.5f * Math.abs(fM3442aE * (fM3442aE < 0.0f ? c0809oaM3436b.f4386kC : c0809oaM3436b.f4385kB))));
        this.f4171ko = Mth.lerp(fMin, this.f4171ko, this.f4169km);
        this.f4172kp = Mth.lerp(fMin, this.f4172kp, this.f4170kn);
    }

    /* JADX INFO: renamed from: e */
    public void m3491e(@NotNull AbstractC0750nU abstractC0750nU) {
        Level level = abstractC0750nU.level();
        float yRot = (abstractC0750nU.getYRot() * 0.017453292f) - 1.5707964f;
        Vec3 vec3Add = abstractC0750nU.position().add(0.0d, 2.0d, 0.0d);
        this.f4169km = (float) Mth.clamp(m3492a(level, vec3Add, yRot, 0.25f, 6, true), -4.0d, 4.0d);
        this.f4170kn = (float) (-Mth.clamp(m3492a(level, vec3Add, yRot, 0.25f, 6, false), -4.0d, 4.0d));
    }

    /* JADX INFO: renamed from: a */
    private double m3492a(Level level, Vec3 vec3, float f, float f2, int i, boolean z) {
        return IntStream.range(1, i).mapToDouble(i2 -> {
            Vec3 vec4 = z ? new Vec3(f2 * i2, 0.0d, 0.0d) : new Vec3(0.0d, 0.0d, f2 * i2);
            return m3493a(level, vec4, vec3, f) - m3493a(level, vec4.scale(-1.0d), vec3, f);
        }).sum();
    }

    /* JADX INFO: renamed from: a */
    private double m3493a(@NotNull Level level, @NotNull Vec3 vec3, @NotNull Vec3 vec4, float f) {
        Vec3 vec3Add = vec4.add(vec3.yRot(-f));
        return vec3Add.y + level.clip(new ClipContext(vec3Add, vec3Add.add(0.0d, -4.0d, 0.0d), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, CollisionContext.empty())).getLocation().y;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    public void m3494b(@NotNull PoseStack poseStack, float f) {
        Vec2 vec2 = new Vec2(C1270xJ.m7170f(this.f4165ki, this.f4167kk, f), C1270xJ.m7170f(this.f4166kj, this.f4168kl, f));
        poseStack.mulPose(Axis.XP.rotationDegrees((-2.5f) * vec2.x * 3.0f));
        poseStack.mulPose(Axis.ZP.rotationDegrees(2.5f * vec2.y * 3.0f));
        poseStack.translate(0.0f, (-0.1f) * Math.max(Math.abs(vec2.x), Math.abs(vec2.y)), 0.0f);
    }

    /* JADX INFO: renamed from: aG */
    public float m3495aG() {
        return this.f4171ko;
    }

    /* JADX INFO: renamed from: aH */
    public float m3496aH() {
        return this.f4172kp;
    }

    /* JADX INFO: renamed from: a */
    public FloatFloatPair m3497a() {
        return FloatFloatImmutablePair.of(Math.abs(this.f4165ki - this.f4167kk), Math.abs(this.f4166kj - this.f4168kl));
    }

    /* JADX INFO: renamed from: b */
    public FloatFloatPair m3498b(float f) {
        return FloatFloatImmutablePair.of(C1270xJ.m7170f(this.f4165ki, this.f4167kk, f), C1270xJ.m7170f(this.f4166kj, this.f4168kl, f));
    }
}
