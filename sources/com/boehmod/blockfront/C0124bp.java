package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import javax.annotation.Nullable;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bp.class */
public class C0124bp {

    /* JADX INFO: renamed from: M */
    public static final ResourceLocation f865M = C0564jv.m2555d("textures/gui/compass/waypoint_pp.png");

    /* JADX INFO: renamed from: N */
    public static final ResourceLocation f866N = C0564jv.m2555d("textures/gui/compass/waypoint_pp_enemy.png");

    /* JADX INFO: renamed from: i */
    @NotNull
    private final Vec3 f867i;

    /* JADX INFO: renamed from: O */
    @NotNull
    private final ResourceLocation f868O;

    /* JADX INFO: renamed from: P */
    @Nullable
    private ResourceLocation f869P;

    /* JADX INFO: renamed from: A */
    @Nullable
    private Component f870A = null;

    /* JADX INFO: renamed from: cv */
    private int f871cv = ColorReferences.COLOR_WHITE_SOLID;

    /* JADX INFO: renamed from: aw */
    private boolean f872aw = false;

    /* JADX INFO: renamed from: aD */
    private float f873aD = 1.0f;

    /* JADX INFO: renamed from: cw */
    private int f874cw = 8;

    /* JADX INFO: renamed from: cO */
    private float f875cO = 0.0f;

    /* JADX INFO: renamed from: ax */
    private boolean f876ax = false;

    /* JADX INFO: renamed from: c */
    private AABB f877c = m619c();

    public C0124bp(@NotNull ResourceLocation resourceLocation, @NotNull Vec2 vec2) {
        this.f867i = new Vec3(vec2.x, 0.0d, vec2.y);
        this.f868O = resourceLocation;
    }

    public C0124bp(@NotNull ResourceLocation resourceLocation, @NotNull Vec3 vec3) {
        this.f867i = vec3;
        this.f868O = resourceLocation;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public AABB m619c() {
        return new AABB(this.f867i.x, this.f867i.y, this.f867i.z, this.f867i.x, this.f867i.y, this.f867i.z).inflate(0.20000000298023224d);
    }

    /* JADX INFO: renamed from: d */
    public AABB m620d() {
        return this.f877c;
    }

    /* JADX INFO: renamed from: a */
    public C0124bp m621a(@NotNull ResourceLocation resourceLocation, int i) {
        this.f869P = resourceLocation;
        this.f871cv = i;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0124bp m622a() {
        this.f876ax = true;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0124bp m623a(float f) {
        this.f875cO = f;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0124bp m624a(@NotNull Component component) {
        this.f870A = component;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0124bp m625a(int i) {
        this.f874cw = i;
        this.f877c = m619c();
        return this;
    }

    /* JADX INFO: renamed from: o */
    public float m626o() {
        return this.f874cw;
    }

    public void onUpdate() {
        if (this.f872aw) {
            if (this.f873aD < 1.0f) {
                this.f873aD += 0.01f;
            }
        } else if (this.f873aD > 0.0f) {
            this.f873aD -= 0.01f;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m627a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3) {
        if (this.f869P != null) {
            C0119bk.m446b(poseStack, guiGraphics, this.f869P, f, f2, this.f874cw, this.f874cw, this.f875cO, f3, this.f871cv);
        }
        C0119bk.m444b(poseStack, guiGraphics, this.f868O, f, f2, this.f874cw, this.f874cw, this.f875cO, f3);
    }

    /* JADX INFO: renamed from: a */
    public void m628a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, float f, float f2) {
        if (this.f870A != null) {
            C0119bk.m390b(poseStack, font, guiGraphics, this.f870A, f, f2 + 5.0f, 0.5f);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m629c(boolean z) {
        this.f872aw = z;
    }

    /* JADX INFO: renamed from: b */
    public C0124bp m630b(float f) {
        this.f873aD = f;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public float m631b() {
        return this.f873aD;
    }

    @NotNull
    public ResourceLocation getTexture() {
        return this.f868O;
    }

    /* JADX INFO: renamed from: p */
    public boolean m632p() {
        return this.f876ax;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public Vec3 m633c() {
        return this.f867i;
    }

    /* JADX INFO: renamed from: p */
    public float m634p() {
        return this.f875cO;
    }
}
