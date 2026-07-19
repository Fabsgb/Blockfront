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

/* JADX INFO: renamed from: com.boehmod.blockfront.bp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bp.class */
public class C0045bp {
    public static final ResourceLocation M = C0265jv.d("textures/gui/compass/waypoint_pp.png");
    public static final ResourceLocation N = C0265jv.d("textures/gui/compass/waypoint_pp_enemy.png");

    @NotNull
    private final Vec3 i;

    @NotNull
    private final ResourceLocation O;

    @Nullable
    private ResourceLocation P;

    @Nullable
    private Component A = null;
    private int cv = ColorReferences.COLOR_WHITE_SOLID;
    private boolean aw = false;
    private float aD = 1.0f;
    private int cw = 8;
    private float cO = 0.0f;
    private boolean ax = false;
    private AABB c = c();

    public C0045bp(@NotNull ResourceLocation resourceLocation, @NotNull Vec2 vec2) {
        this.i = new Vec3(vec2.x, 0.0d, vec2.y);
        this.O = resourceLocation;
    }

    public C0045bp(@NotNull ResourceLocation resourceLocation, @NotNull Vec3 vec3) {
        this.i = vec3;
        this.O = resourceLocation;
    }

    @NotNull
    public AABB c() {
        return new AABB(this.i.x, this.i.y, this.i.z, this.i.x, this.i.y, this.i.z).inflate(0.20000000298023224d);
    }

    public AABB d() {
        return this.c;
    }

    public C0045bp a(@NotNull ResourceLocation resourceLocation, int i) {
        this.P = resourceLocation;
        this.cv = i;
        return this;
    }

    public C0045bp a() {
        this.ax = true;
        return this;
    }

    public C0045bp a(float f) {
        this.cO = f;
        return this;
    }

    public C0045bp a(@NotNull Component component) {
        this.A = component;
        return this;
    }

    public C0045bp a(int i) {
        this.cw = i;
        this.c = c();
        return this;
    }

    public float o() {
        return this.cw;
    }

    public void onUpdate() {
        if (this.aw) {
            if (this.aD < 1.0f) {
                this.aD += 0.01f;
            }
        } else if (this.aD > 0.0f) {
            this.aD -= 0.01f;
        }
    }

    public void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3) {
        if (this.P != null) {
            C0040bk.b(poseStack, guiGraphics, this.P, f, f2, this.cw, this.cw, this.cO, f3, this.cv);
        }
        C0040bk.b(poseStack, guiGraphics, this.O, f, f2, this.cw, this.cw, this.cO, f3);
    }

    public void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, float f, float f2) {
        if (this.A != null) {
            C0040bk.b(poseStack, font, guiGraphics, this.A, f, f2 + 5.0f, 0.5f);
        }
    }

    public void c(boolean z) {
        this.aw = z;
    }

    public C0045bp b(float f) {
        this.aD = f;
        return this;
    }

    public float b() {
        return this.aD;
    }

    @NotNull
    public ResourceLocation getTexture() {
        return this.O;
    }

    public boolean p() {
        return this.ax;
    }

    @NotNull
    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public Vec3 m239c() {
        return this.i;
    }

    /* JADX INFO: renamed from: p, reason: collision with other method in class */
    public float m240p() {
        return this.cO;
    }
}
