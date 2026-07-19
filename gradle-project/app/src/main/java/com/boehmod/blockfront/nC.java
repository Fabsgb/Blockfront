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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/nC.class */
public class nC {
    private float jp;
    private float jq;
    private float jr;
    private float js;
    public int mg = 0;
    private float jt = 0.0f;
    private float ju = 0.0f;
    private float jv = 0.0f;
    private float jw = 0.0f;

    public void c(@NotNull AbstractC0376ny abstractC0376ny) {
        this.jr = this.jp;
        this.js = this.jq;
        this.jp = this.jv;
        this.jq = this.jw;
        int i = this.mg;
        this.mg = i + 1;
        if (i >= 4) {
            this.mg = 0;
            e(abstractC0376ny);
        }
        d(abstractC0376ny);
    }

    public void d(@NotNull AbstractC0376ny abstractC0376ny) {
        nE<AbstractC0376ny> nEVarM741b = abstractC0376ny.m741b();
        float fAy = abstractC0376ny.ay();
        float fMin = Math.min(0.1f, 0.01f + (2.5f * Math.abs(fAy * (fAy < 0.0f ? nEVarM741b.jJ : nEVarM741b.jI))));
        this.jv = Mth.lerp(fMin, this.jv, this.jt);
        this.jw = Mth.lerp(fMin, this.jw, this.ju);
    }

    public void e(@NotNull AbstractC0376ny abstractC0376ny) {
        Level level = abstractC0376ny.level();
        float yRot = (abstractC0376ny.getYRot() * 0.017453292f) - 1.5707964f;
        Vec3 vec3Add = abstractC0376ny.position().add(0.0d, 2.0d, 0.0d);
        this.jt = (float) Mth.clamp(a(level, vec3Add, yRot, 0.25f, 6, true), -4.0d, 4.0d);
        this.ju = (float) (-Mth.clamp(a(level, vec3Add, yRot, 0.25f, 6, false), -4.0d, 4.0d));
    }

    private double a(Level level, Vec3 vec3, float f, float f2, int i, boolean z) {
        return IntStream.range(1, i).mapToDouble(i2 -> {
            Vec3 vec32 = z ? new Vec3(f2 * i2, 0.0d, 0.0d) : new Vec3(0.0d, 0.0d, f2 * i2);
            return a(level, vec32, vec3, f) - a(level, vec32.scale(-1.0d), vec3, f);
        }).sum();
    }

    private double a(@NotNull Level level, @NotNull Vec3 vec3, @NotNull Vec3 vec32, float f) {
        Vec3 vec3Add = vec32.add(vec3.yRot(-f));
        return vec3Add.y + level.clip(new ClipContext(vec3Add, vec3Add.add(0.0d, -4.0d, 0.0d), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, CollisionContext.empty())).getLocation().y;
    }

    @OnlyIn(Dist.CLIENT)
    public void b(@NotNull PoseStack poseStack, float f) {
        Vec2 vec2 = new Vec2(C0634xm.e(this.jp, this.jr, f), C0634xm.e(this.jq, this.js, f));
        poseStack.mulPose(Axis.XP.rotationDegrees((-2.5f) * vec2.x * 3.0f));
        poseStack.mulPose(Axis.ZP.rotationDegrees(2.5f * vec2.y * 3.0f));
        poseStack.translate(0.0f, (-0.1f) * Math.max(Math.abs(vec2.x), Math.abs(vec2.y)), 0.0f);
    }

    public float aA() {
        return this.jv;
    }

    public float aB() {
        return this.jw;
    }

    public FloatFloatPair a() {
        return FloatFloatImmutablePair.of(Math.abs(this.jp - this.jr), Math.abs(this.jq - this.js));
    }

    public FloatFloatPair b(float f) {
        return FloatFloatImmutablePair.of(C0634xm.e(this.jp, this.jr, f), C0634xm.e(this.jq, this.js, f));
    }
}
