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

/* JADX INFO: renamed from: com.boehmod.blockfront.nC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nC.class */
public class C0731nC {

    /* JADX INFO: renamed from: jp */
    private float f3917jp;

    /* JADX INFO: renamed from: jq */
    private float f3918jq;

    /* JADX INFO: renamed from: jr */
    private float f3919jr;

    /* JADX INFO: renamed from: js */
    private float f3920js;

    /* JADX INFO: renamed from: mg */
    public int f3916mg = 0;

    /* JADX INFO: renamed from: jt */
    private float f3921jt = 0.0f;

    /* JADX INFO: renamed from: ju */
    private float f3922ju = 0.0f;

    /* JADX INFO: renamed from: jv */
    private float f3923jv = 0.0f;

    /* JADX INFO: renamed from: jw */
    private float f3924jw = 0.0f;

    /* JADX INFO: renamed from: c */
    public void m3302c(@NotNull AbstractC0779ny abstractC0779ny) {
        this.f3919jr = this.f3917jp;
        this.f3920js = this.f3918jq;
        this.f3917jp = this.f3923jv;
        this.f3918jq = this.f3924jw;
        int i = this.f3916mg;
        this.f3916mg = i + 1;
        if (i >= 4) {
            this.f3916mg = 0;
            m3304e(abstractC0779ny);
        }
        m3303d(abstractC0779ny);
    }

    /* JADX INFO: renamed from: d */
    public void m3303d(@NotNull AbstractC0779ny abstractC0779ny) {
        C0733nE<AbstractC0779ny> c0733nEM3499b = abstractC0779ny.m3499b();
        float fM3505ay = abstractC0779ny.m3505ay();
        float fMin = Math.min(0.1f, 0.01f + (2.5f * Math.abs(fM3505ay * (fM3505ay < 0.0f ? c0733nEM3499b.f3958jJ : c0733nEM3499b.f3957jI))));
        this.f3923jv = Mth.lerp(fMin, this.f3923jv, this.f3921jt);
        this.f3924jw = Mth.lerp(fMin, this.f3924jw, this.f3922ju);
    }

    /* JADX INFO: renamed from: e */
    public void m3304e(@NotNull AbstractC0779ny abstractC0779ny) {
        Level level = abstractC0779ny.level();
        float yRot = (abstractC0779ny.getYRot() * 0.017453292f) - 1.5707964f;
        Vec3 vec3Add = abstractC0779ny.position().add(0.0d, 2.0d, 0.0d);
        this.f3921jt = (float) Mth.clamp(m3305a(level, vec3Add, yRot, 0.25f, 6, true), -4.0d, 4.0d);
        this.f3922ju = (float) (-Mth.clamp(m3305a(level, vec3Add, yRot, 0.25f, 6, false), -4.0d, 4.0d));
    }

    /* JADX INFO: renamed from: a */
    private double m3305a(Level level, Vec3 vec3, float f, float f2, int i, boolean z) {
        return IntStream.range(1, i).mapToDouble(i2 -> {
            Vec3 vec32 = z ? new Vec3(f2 * i2, 0.0d, 0.0d) : new Vec3(0.0d, 0.0d, f2 * i2);
            return m3306a(level, vec32, vec3, f) - m3306a(level, vec32.scale(-1.0d), vec3, f);
        }).sum();
    }

    /* JADX INFO: renamed from: a */
    private double m3306a(@NotNull Level level, @NotNull Vec3 vec3, @NotNull Vec3 vec32, float f) {
        Vec3 vec3Add = vec32.add(vec3.yRot(-f));
        return vec3Add.y + level.clip(new ClipContext(vec3Add, vec3Add.add(0.0d, -4.0d, 0.0d), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, CollisionContext.empty())).getLocation().y;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    public void m3307b(@NotNull PoseStack poseStack, float f) {
        Vec2 vec2 = new Vec2(C1290xm.m7843e(this.f3917jp, this.f3919jr, f), C1290xm.m7843e(this.f3918jq, this.f3920js, f));
        poseStack.mulPose(Axis.XP.rotationDegrees((-2.5f) * vec2.x * 3.0f));
        poseStack.mulPose(Axis.ZP.rotationDegrees(2.5f * vec2.y * 3.0f));
        poseStack.translate(0.0f, (-0.1f) * Math.max(Math.abs(vec2.x), Math.abs(vec2.y)), 0.0f);
    }

    /* JADX INFO: renamed from: aA */
    public float m3308aA() {
        return this.f3923jv;
    }

    /* JADX INFO: renamed from: aB */
    public float m3309aB() {
        return this.f3924jw;
    }

    /* JADX INFO: renamed from: a */
    public FloatFloatPair m3310a() {
        return FloatFloatImmutablePair.of(Math.abs(this.f3917jp - this.f3919jr), Math.abs(this.f3918jq - this.f3920js));
    }

    /* JADX INFO: renamed from: b */
    public FloatFloatPair m3311b(float f) {
        return FloatFloatImmutablePair.of(C1290xm.m7843e(this.f3917jp, this.f3919jr, f), C1290xm.m7843e(this.f3918jq, this.f3920js, f));
    }
}
