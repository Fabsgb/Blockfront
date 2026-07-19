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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/E.class */
public class E {

    @Nonnull
    public static final ResourceLocation k;
    public static final double b = 140.0d;
    public static final double c = 60.0d;
    public static final double d = 20.0d;
    public static final double e = 5.0d;
    public static final int A = 200;
    public static final int B = 256;
    public static final float f = 8.0f;
    public static final float g = 2.0f;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NotNull
    private final List<G> f2b;

    @NotNull
    private final L a;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    private double f4f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    private double f5g;
    static final /* synthetic */ boolean E;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NotNull
    private final Set<ResourceLocation> f3d = new ObjectArraySet();
    private int C = 200;

    static {
        E = !E.class.desiredAssertionStatus();
        k = C0265jv.d("textures/models/entities/corpse/blood.png");
    }

    public E(@NotNull Collection<G> collection) {
        this.f2b = new ObjectArrayList(collection);
        Iterator<G> it = this.f2b.iterator();
        while (it.hasNext()) {
            for (H h : it.next().m148a()) {
                this.f3d.add(h.f());
            }
        }
        this.a = new L(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d);
        m();
    }

    public boolean a(@NotNull Frustum frustum) {
        boolean zJ = j();
        if (frustum.isVisible(this.a.a())) {
            double d2 = zJ ? 140.0d : 60.0d;
            double d3 = this.f4f + 0.05d;
            this.f4f = d3;
            return d3 > d2;
        }
        double d4 = zJ ? 20.0d : 5.0d;
        double d5 = this.f5g + 0.05d;
        this.f5g = d5;
        return d5 > d4;
    }

    public static boolean j() {
        return Minecraft.getInstance().options.graphicsMode().get() != GraphicsStatus.FAST;
    }

    private void m() {
        if (!E && this.f2b.isEmpty()) {
            throw new AssertionError("Ragdoll missing parts!");
        }
        double dMin = Double.POSITIVE_INFINITY;
        double dMin2 = Double.POSITIVE_INFINITY;
        double dMin3 = Double.POSITIVE_INFINITY;
        double dMax = Double.NEGATIVE_INFINITY;
        double dMax2 = Double.NEGATIVE_INFINITY;
        double dMax3 = Double.NEGATIVE_INFINITY;
        Iterator<G> it = this.f2b.iterator();
        while (it.hasNext()) {
            Vector3dc vector3dcD = it.next().a().d();
            dMin = Math.min(dMin, vector3dcD.x());
            dMin2 = Math.min(dMin2, vector3dcD.y());
            dMin3 = Math.min(dMin3, vector3dcD.z());
            dMax = Math.max(dMax, vector3dcD.x());
            dMax2 = Math.max(dMax2, vector3dcD.y());
            dMax3 = Math.max(dMax3, vector3dcD.z());
        }
        this.a.b(dMin - 1.0d, dMin2 - 1.0d, dMin3 - 1.0d, dMax + 1.0d, dMax2 + 1.0d, dMax3 + 1.0d);
    }

    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, fT fTVar, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, float f2) {
        boolean zShouldRenderHitBoxes = minecraft.getEntityRenderDispatcher().shouldRenderHitBoxes();
        MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
        int i = OverlayTexture.NO_OVERLAY;
        Function<ResourceLocation, RenderType> function = hC.d;
        if (hN.w.T()) {
            RenderSystem.setShaderTexture(3, k);
        }
        if (zShouldRenderHitBoxes) {
            a(poseStack, f2, bufferSource);
            return;
        }
        for (ResourceLocation resourceLocation : this.f3d) {
            a(minecraft, c0297l, fTVar, clientLevel, localPlayer, poseStack, resourceLocation, bufferSource.getBuffer(function.apply(resourceLocation)), i, f2);
        }
    }

    private void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fT fTVar, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull ResourceLocation resourceLocation, @NotNull VertexConsumer vertexConsumer, int i, float f2) {
        for (G g2 : this.f2b) {
            Vector3dc vector3dcD = g2.a().d();
            g2.a(minecraft, c0297l, fTVar, poseStack, vertexConsumer, localPlayer, f2, LevelRenderer.getLightColor(clientLevel, BlockPos.containing(vector3dcD.x(), vector3dcD.y(), vector3dcD.z())), i, -1, resourceLocation);
        }
    }

    private void a(@NotNull PoseStack poseStack, float f2, @NotNull MultiBufferSource.BufferSource bufferSource) {
        VertexConsumer buffer = bufferSource.getBuffer(RenderType.LINES);
        RenderSystem.disableDepthTest();
        for (G g2 : this.f2b) {
            poseStack.pushPose();
            g2.a(poseStack, f2);
            Vector3dc vector3dcM146a = g2.m146a();
            Vector3dc vector3dcMo157c = g2.a().mo157c();
            poseStack.translate(vector3dcMo157c.x(), vector3dcMo157c.y(), vector3dcMo157c.z());
            LevelRenderer.renderLineBox(poseStack, buffer, -vector3dcM146a.x(), -vector3dcM146a.y(), -vector3dcM146a.z(), vector3dcM146a.x(), vector3dcM146a.y(), vector3dcM146a.z(), 1.0f, 1.0f, 1.0f, 1.0f);
            poseStack.scale(0.2f, 0.2f, 0.2f);
            LevelRenderer.renderLineBox(poseStack, buffer, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0f, 0.0f, 0.0f, 1.0f);
            LevelRenderer.renderLineBox(poseStack, buffer, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0f, 1.0f, 0.0f, 1.0f);
            LevelRenderer.renderLineBox(poseStack, buffer, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0f, 0.0f, 1.0f, 1.0f);
            poseStack.popPose();
        }
        RenderSystem.enableDepthTest();
    }

    @NotNull
    public List<G> b() {
        return this.f2b;
    }

    @NotNull
    public M a() {
        return this.a;
    }

    public boolean a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull Frustum frustum) {
        this.f2b.forEach(g2 -> {
            g2.a(minecraft, c0297l, clientLevel);
        });
        m();
        int i = this.C;
        this.C = i - 1;
        if (i <= 0 && clientLevel.random.nextInt(100) == 0) {
            Vector3d vector3dA = this.a.a(new Vector3d());
            Vec3 vec3Position = localPlayer.position();
            float fDistance = (float) vector3dA.distance(vec3Position.x, vec3Position.y, vec3Position.z);
            float fNextFloat = clientLevel.random.nextFloat() * 6.2831855f;
            vector3dA.x += Math.cos(fNextFloat) * 2.0d;
            vector3dA.z += Math.sin(fNextFloat) * 2.0d;
            if (fDistance <= 8.0f) {
                clientLevel.playLocalSound(vector3dA.x, vector3dA.y, vector3dA.z, (SoundEvent) C0624xc.ss.get(), SoundSource.AMBIENT, 0.1f + (0.2f * clientLevel.random.nextFloat()), 0.8f + (0.2f * clientLevel.random.nextFloat()), false);
            }
        }
        if (a(localPlayer) || a(frustum)) {
            n();
            return true;
        }
        return false;
    }

    private boolean a(@NotNull LocalPlayer localPlayer) {
        Vec3 vec3Position = localPlayer.position();
        double dX = vec3Position.x();
        double dY = vec3Position.y();
        double dZ = vec3Position.z();
        double dE = this.a.e();
        double dF = this.a.f();
        double dG = this.a.g();
        double dB = this.a.b();
        double dC = this.a.c();
        double d2 = this.a.d();
        return (((dX - dE) * (dX - dE)) + ((dY - dF) * (dY - dF))) + ((dZ - dG) * (dZ - dG)) > 65536.0d || (((dX - dB) * (dX - dB)) + ((dY - dC) * (dY - dC))) + ((dZ - d2) * (dZ - d2)) > 65536.0d;
    }

    public void n() {
        Iterator<G> it = this.f2b.iterator();
        while (it.hasNext()) {
            it.next().n();
        }
    }

    public void o() {
        Iterator<G> it = this.f2b.iterator();
        while (it.hasNext()) {
            it.next().o();
        }
    }
}
