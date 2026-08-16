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

/* JADX INFO: renamed from: com.boehmod.blockfront.by */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/by.class */
public class C0134by {

    /* JADX INFO: renamed from: M */
    public static final ResourceLocation f1000M = C0532jO.m2378d("textures/gui/compass/waypoint_pp.png");

    /* JADX INFO: renamed from: N */
    public static final ResourceLocation f1001N = C0532jO.m2378d("textures/gui/compass/waypoint_pp_enemy.png");

    /* JADX INFO: renamed from: i */
    @NotNull
    private final Vec3 f1002i;

    /* JADX INFO: renamed from: O */
    @NotNull
    private final ResourceLocation f1003O;

    /* JADX INFO: renamed from: P */
    @Nullable
    private ResourceLocation f1004P;

    /* JADX INFO: renamed from: A */
    @Nullable
    private Component f1005A = null;

    /* JADX INFO: renamed from: dn */
    private int f1006dn = ColorReferences.COLOR_WHITE_SOLID;

    /* JADX INFO: renamed from: aB */
    private boolean f1007aB = false;

    /* JADX INFO: renamed from: aI */
    private float f1008aI = 1.0f;

    /* JADX INFO: renamed from: do */
    private int f1009do = 8;

    /* JADX INFO: renamed from: cU */
    private float f1010cU = 0.0f;

    /* JADX INFO: renamed from: aC */
    private boolean f1011aC = false;

    /* JADX INFO: renamed from: c */
    private AABB f1012c = m724c();

    public C0134by(@NotNull ResourceLocation resourceLocation, @NotNull Vec2 vec2) {
        this.f1002i = new Vec3(vec2.x, 0.0d, vec2.y);
        this.f1003O = resourceLocation;
    }

    public C0134by(@NotNull ResourceLocation resourceLocation, @NotNull Vec3 vec3) {
        this.f1002i = vec3;
        this.f1003O = resourceLocation;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public AABB m724c() {
        return new AABB(this.f1002i.x, this.f1002i.y, this.f1002i.z, this.f1002i.x, this.f1002i.y, this.f1002i.z).inflate(0.20000000298023224d);
    }

    /* JADX INFO: renamed from: d */
    public AABB m725d() {
        return this.f1012c;
    }

    /* JADX INFO: renamed from: a */
    public C0134by m726a(@NotNull ResourceLocation resourceLocation, int i) {
        this.f1004P = resourceLocation;
        this.f1006dn = i;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0134by m727a() {
        this.f1011aC = true;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0134by m728a(float f) {
        this.f1010cU = f;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0134by m729a(@NotNull Component component) {
        this.f1005A = component;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0134by m730a(int i) {
        this.f1009do = i;
        this.f1012c = m724c();
        return this;
    }

    /* JADX INFO: renamed from: o */
    public float m731o() {
        return this.f1009do;
    }

    public void onUpdate() {
        if (this.f1007aB) {
            if (this.f1008aI < 1.0f) {
                this.f1008aI += 0.01f;
            }
        } else if (this.f1008aI > 0.0f) {
            this.f1008aI -= 0.01f;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m732a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, float f, float f2, float f3) {
        if (this.f1004P != null) {
            C0129bt.m546b(poseStack, guiGraphics, this.f1004P, f, f2, this.f1009do, this.f1009do, this.f1010cU, f3, this.f1006dn);
        }
        C0129bt.m544b(poseStack, guiGraphics, this.f1003O, f, f2, this.f1009do, this.f1009do, this.f1010cU, f3);
    }

    /* JADX INFO: renamed from: a */
    public void m733a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, float f, float f2) {
        if (this.f1005A != null) {
            C0129bt.m490b(poseStack, font, guiGraphics, this.f1005A, f, f2 + 5.0f, 0.5f);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m734c(boolean z) {
        this.f1007aB = z;
    }

    /* JADX INFO: renamed from: b */
    public C0134by m735b(float f) {
        this.f1008aI = f;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public float m736b() {
        return this.f1008aI;
    }

    @NotNull
    public ResourceLocation getTexture() {
        return this.f1003O;
    }

    /* JADX INFO: renamed from: q */
    public boolean m737q() {
        return this.f1011aC;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public Vec3 m738c() {
        return this.f1002i;
    }

    /* JADX INFO: renamed from: p */
    public float m739p() {
        return this.f1010cU;
    }
}
