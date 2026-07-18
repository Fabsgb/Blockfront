package com.boehmod.blockfront;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import javax.annotation.Nonnull;
import net.minecraft.client.GraphicsStatus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: renamed from: com.boehmod.blockfront.E */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/E.class */
public class C0007E {

    /* JADX INFO: renamed from: k */
    @Nonnull
    public static final ResourceLocation f127k;

    /* JADX INFO: renamed from: b */
    public static final double f128b = 140.0d;

    /* JADX INFO: renamed from: c */
    public static final double f129c = 60.0d;

    /* JADX INFO: renamed from: d */
    public static final double f130d = 20.0d;

    /* JADX INFO: renamed from: e */
    public static final double f131e = 5.0d;

    /* JADX INFO: renamed from: A */
    public static final int f132A = 200;

    /* JADX INFO: renamed from: B */
    public static final int f133B = 256;

    /* JADX INFO: renamed from: f */
    public static final float f134f = 8.0f;

    /* JADX INFO: renamed from: g */
    public static final float f135g = 2.0f;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final List<C0009G> f136b;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0014L f138a;

    /* JADX INFO: renamed from: f */
    private double f139f;

    /* JADX INFO: renamed from: g */
    private double f140g;

    /* JADX INFO: renamed from: E */
    static final /* synthetic */ boolean f142E;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final Set<ResourceLocation> f137d = new ObjectArraySet();

    /* JADX INFO: renamed from: C */
    private int f141C = 200;

    static {
        f142E = !C0007E.class.desiredAssertionStatus();
        f127k = C0564jv.m2555d("textures/models/entities/corpse/blood.png");
    }

    public C0007E(@NotNull Collection<C0009G> collection) {
        this.f136b = new ObjectArrayList(collection);
        Iterator<C0009G> it = this.f136b.iterator();
        while (it.hasNext()) {
            for (C0010H c0010h : it.next().m50a()) {
                this.f137d.add(c0010h.m59f());
            }
        }
        this.f138a = new C0014L(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d);
        m15m();
    }

    /* JADX INFO: renamed from: a */
    public boolean m13a(@NotNull Frustum frustum) {
        boolean zM14j = m14j();
        if (frustum.isVisible(this.f138a.m87a())) {
            double d = zM14j ? 140.0d : 60.0d;
            double d2 = this.f139f + 0.05d;
            this.f139f = d2;
            return d2 > d;
        }
        double d3 = zM14j ? 20.0d : 5.0d;
        double d4 = this.f140g + 0.05d;
        this.f140g = d4;
        return d4 > d3;
    }

    /* JADX INFO: renamed from: j */
    public static boolean m14j() {
        return Minecraft.getInstance().options.graphicsMode().get() != GraphicsStatus.FAST;
    }

    /* JADX INFO: renamed from: m */
    private void m15m() {
        if (!f142E && this.f136b.isEmpty()) {
            throw new AssertionError("Ragdoll missing parts!");
        }
        double dMin = Double.POSITIVE_INFINITY;
        double dMin2 = Double.POSITIVE_INFINITY;
        double dMin3 = Double.POSITIVE_INFINITY;
        double dMax = Double.NEGATIVE_INFINITY;
        double dMax2 = Double.NEGATIVE_INFINITY;
        double dMax3 = Double.NEGATIVE_INFINITY;
        Iterator<C0009G> it = this.f136b.iterator();
        while (it.hasNext()) {
            Vector3dc vector3dcMo124d = it.next().m45a().mo124d();
            dMin = Math.min(dMin, vector3dcMo124d.x());
            dMin2 = Math.min(dMin2, vector3dcMo124d.y());
            dMin3 = Math.min(dMin3, vector3dcMo124d.z());
            dMax = Math.max(dMax, vector3dcMo124d.x());
            dMax2 = Math.max(dMax2, vector3dcMo124d.y());
            dMax3 = Math.max(dMax3, vector3dcMo124d.z());
        }
        this.f138a.m66b(dMin - 1.0d, dMin2 - 1.0d, dMin3 - 1.0d, dMax + 1.0d, dMax2 + 1.0d, dMax3 + 1.0d);
    }

    /* JADX INFO: renamed from: a */
    public void m16a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, C0324fT c0324fT, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, float f) {
        boolean zShouldRenderHitBoxes = minecraft.getEntityRenderDispatcher().shouldRenderHitBoxes();
        MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
        int i = OverlayTexture.NO_OVERLAY;
        Function<ResourceLocation, RenderType> function = C0413hC.f2628d;
        if (C0424hN.f2742w.m1996T()) {
            RenderSystem.setShaderTexture(3, f127k);
        }
        if (zShouldRenderHitBoxes) {
            m18a(poseStack, f, bufferSource);
            return;
        }
        for (ResourceLocation resourceLocation : this.f137d) {
            m17a(minecraft, c0622l, c0324fT, clientLevel, localPlayer, poseStack, resourceLocation, bufferSource.getBuffer(function.apply(resourceLocation)), i, f);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m17a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0324fT c0324fT, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull ResourceLocation resourceLocation, @NotNull VertexConsumer vertexConsumer, int i, float f) {
        for (C0009G c0009g : this.f136b) {
            Vector3dc vector3dcMo124d = c0009g.m45a().mo124d();
            c0009g.m41a(minecraft, c0622l, c0324fT, poseStack, vertexConsumer, localPlayer, f, LevelRenderer.getLightColor(clientLevel, BlockPos.containing(vector3dcMo124d.x(), vector3dcMo124d.y(), vector3dcMo124d.z())), i, -1, resourceLocation);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m18a(@NotNull PoseStack poseStack, float f, @NotNull MultiBufferSource.BufferSource bufferSource) {
        VertexConsumer buffer = bufferSource.getBuffer(RenderType.LINES);
        RenderSystem.disableDepthTest();
        for (C0009G c0009g : this.f136b) {
            poseStack.pushPose();
            c0009g.m42a(poseStack, f);
            Vector3dc vector3dcM48a = c0009g.m48a();
            Vector3dc vector3dcMo122c = c0009g.m45a().mo122c();
            poseStack.translate(vector3dcMo122c.x(), vector3dcMo122c.y(), vector3dcMo122c.z());
            LevelRenderer.renderLineBox(poseStack, buffer, -vector3dcM48a.x(), -vector3dcM48a.y(), -vector3dcM48a.z(), vector3dcM48a.x(), vector3dcM48a.y(), vector3dcM48a.z(), 1.0f, 1.0f, 1.0f, 1.0f);
            poseStack.scale(0.2f, 0.2f, 0.2f);
            LevelRenderer.renderLineBox(poseStack, buffer, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0f, 0.0f, 0.0f, 1.0f);
            LevelRenderer.renderLineBox(poseStack, buffer, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0f, 1.0f, 0.0f, 1.0f);
            LevelRenderer.renderLineBox(poseStack, buffer, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0f, 0.0f, 1.0f, 1.0f);
            poseStack.popPose();
        }
        RenderSystem.enableDepthTest();
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public List<C0009G> m19b() {
        return this.f136b;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0015M m20a() {
        return this.f138a;
    }

    /* JADX INFO: renamed from: a */
    public boolean m21a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull Frustum frustum) {
        this.f136b.forEach(c0009g -> {
            c0009g.m43a(minecraft, c0622l, clientLevel);
        });
        m15m();
        int i = this.f141C;
        this.f141C = i - 1;
        if (i <= 0 && clientLevel.random.nextInt(100) == 0) {
            Vector3d vector3dA = this.f138a.m84a(new Vector3d());
            Vec3 vec3Position = localPlayer.position();
            float fDistance = (float) vector3dA.distance(vec3Position.x, vec3Position.y, vec3Position.z);
            float fNextFloat = clientLevel.random.nextFloat() * 6.2831855f;
            vector3dA.x += Math.cos(fNextFloat) * 2.0d;
            vector3dA.z += Math.sin(fNextFloat) * 2.0d;
            if (fDistance <= 8.0f) {
                clientLevel.playLocalSound(vector3dA.x, vector3dA.y, vector3dA.z, (SoundEvent) C1280xc.f7717ss.get(), SoundSource.AMBIENT, 0.1f + (0.2f * clientLevel.random.nextFloat()), 0.8f + (0.2f * clientLevel.random.nextFloat()), false);
            }
        }
        if (m22a(localPlayer) || m13a(frustum)) {
            m23n();
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private boolean m22a(@NotNull LocalPlayer localPlayer) {
        Vec3 vec3Position = localPlayer.position();
        double dX = vec3Position.x();
        double dY = vec3Position.y();
        double dZ = vec3Position.z();
        double dMo71e = this.f138a.mo71e();
        double dMo72f = this.f138a.mo72f();
        double dMo73g = this.f138a.mo73g();
        double dMo68b = this.f138a.mo68b();
        double dMo69c = this.f138a.mo69c();
        double dMo70d = this.f138a.mo70d();
        return (((dX - dMo71e) * (dX - dMo71e)) + ((dY - dMo72f) * (dY - dMo72f))) + ((dZ - dMo73g) * (dZ - dMo73g)) > 65536.0d || (((dX - dMo68b) * (dX - dMo68b)) + ((dY - dMo69c) * (dY - dMo69c))) + ((dZ - dMo70d) * (dZ - dMo70d)) > 65536.0d;
    }

    /* JADX INFO: renamed from: n */
    public void m23n() {
        Iterator<C0009G> it = this.f136b.iterator();
        while (it.hasNext()) {
            it.next().m53n();
        }
    }

    /* JADX INFO: renamed from: o */
    public void m24o() {
        Iterator<C0009G> it = this.f136b.iterator();
        while (it.hasNext()) {
            it.next().m54o();
        }
    }
}
