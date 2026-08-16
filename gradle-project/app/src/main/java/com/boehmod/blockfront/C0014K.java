package com.boehmod.blockfront;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import net.minecraft.client.GraphicsStatus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: renamed from: com.boehmod.blockfront.K */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/K.class */
public class C0014K {

    /* JADX INFO: renamed from: k */
    @Nonnull
    public static final ResourceLocation f165k;

    /* JADX INFO: renamed from: i */
    public static final double f166i = 140.0d;

    /* JADX INFO: renamed from: j */
    public static final double f167j = 60.0d;

    /* JADX INFO: renamed from: k */
    public static final double f168k = 20.0d;

    /* JADX INFO: renamed from: l */
    public static final double f169l = 5.0d;

    /* JADX INFO: renamed from: ao */
    public static final int f170ao = 200;

    /* JADX INFO: renamed from: ap */
    public static final int f171ap = 256;

    /* JADX INFO: renamed from: k */
    public static final float f172k = 8.0f;

    /* JADX INFO: renamed from: l */
    public static final float f173l = 2.0f;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final List<C0016M> f174a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0021R f176a;

    /* JADX INFO: renamed from: m */
    private double f177m;

    /* JADX INFO: renamed from: n */
    private double f178n;

    /* JADX INFO: renamed from: J */
    static final /* synthetic */ boolean f180J;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final List<ResourceLocation> f175b = new ObjectArrayList();

    /* JADX INFO: renamed from: aq */
    private int f179aq = 200;

    static {
        f180J = !C0014K.class.desiredAssertionStatus();
        f165k = C0532jO.m2378d("textures/models/entities/corpse/blood.png");
    }

    public C0014K(@NotNull Collection<C0016M> collection) {
        this.f174a = new ObjectArrayList(collection);
        Iterator<C0016M> it = this.f174a.iterator();
        while (it.hasNext()) {
            for (C0017N c0017n : it.next().m83a()) {
                ResourceLocation resourceLocationM92f = c0017n.m92f();
                if (!this.f175b.contains(resourceLocationM92f)) {
                    this.f175b.add(resourceLocationM92f);
                }
            }
        }
        this.f176a = new C0021R(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d);
        m47p();
    }

    /* JADX INFO: renamed from: a */
    public boolean m45a(@NotNull Frustum frustum) {
        boolean zM46k = m46k();
        if (frustum.isVisible(this.f176a.m120a())) {
            double d = zM46k ? 140.0d : 60.0d;
            double d2 = this.f177m + 0.05d;
            this.f177m = d2;
            return d2 > d;
        }
        double d3 = zM46k ? 20.0d : 5.0d;
        double d4 = this.f178n + 0.05d;
        this.f178n = d4;
        return d4 > d3;
    }

    /* JADX INFO: renamed from: k */
    public static boolean m46k() {
        return Minecraft.getInstance().options.graphicsMode().get() != GraphicsStatus.FAST;
    }

    /* JADX INFO: renamed from: p */
    private void m47p() {
        if (!f180J && this.f174a.isEmpty()) {
            throw new AssertionError("Ragdoll missing parts!");
        }
        double dMin = Double.POSITIVE_INFINITY;
        double dMin2 = Double.POSITIVE_INFINITY;
        double dMin3 = Double.POSITIVE_INFINITY;
        double dMax = Double.NEGATIVE_INFINITY;
        double dMax2 = Double.NEGATIVE_INFINITY;
        double dMax3 = Double.NEGATIVE_INFINITY;
        Iterator<C0016M> it = this.f174a.iterator();
        while (it.hasNext()) {
            Vector3dc vector3dcMo157d = it.next().m78a().mo157d();
            dMin = Math.min(dMin, vector3dcMo157d.x());
            dMin2 = Math.min(dMin2, vector3dcMo157d.y());
            dMin3 = Math.min(dMin3, vector3dcMo157d.z());
            dMax = Math.max(dMax, vector3dcMo157d.x());
            dMax2 = Math.max(dMax2, vector3dcMo157d.y());
            dMax3 = Math.max(dMax3, vector3dcMo157d.z());
        }
        this.f176a.m99b(dMin - 1.0d, dMin2 - 1.0d, dMin3 - 1.0d, dMax + 1.0d, dMax2 + 1.0d, dMax3 + 1.0d);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public List<ResourceLocation> m48b() {
        return this.f175b;
    }

    /* JADX INFO: renamed from: a */
    void m49a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0394gj c0394gj, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull ResourceLocation resourceLocation, @NotNull VertexConsumer vertexConsumer, int i, float f) {
        for (C0016M c0016m : this.f174a) {
            Vector3dc vector3dcMo157d = c0016m.m78a().mo157d();
            c0016m.m74a(minecraft, c0623l, c0394gj, poseStack, vertexConsumer, localPlayer, f, LevelRenderer.getLightColor(clientLevel, BlockPos.containing(vector3dcMo157d.x(), vector3dcMo157d.y(), vector3dcMo157d.z())), i, -1, resourceLocation);
        }
    }

    /* JADX INFO: renamed from: a */
    void m50a(@NotNull PoseStack poseStack, float f, @NotNull MultiBufferSource.BufferSource bufferSource) {
        VertexConsumer buffer = bufferSource.getBuffer(RenderType.LINES);
        RenderSystem.disableDepthTest();
        for (C0016M c0016m : this.f174a) {
            poseStack.pushPose();
            c0016m.m75a(poseStack, f);
            Vector3dc vector3dcM81a = c0016m.m81a();
            Vector3dc vector3dcMo155c = c0016m.m78a().mo155c();
            poseStack.translate(vector3dcMo155c.x(), vector3dcMo155c.y(), vector3dcMo155c.z());
            LevelRenderer.renderLineBox(poseStack, buffer, -vector3dcM81a.x(), -vector3dcM81a.y(), -vector3dcM81a.z(), vector3dcM81a.x(), vector3dcM81a.y(), vector3dcM81a.z(), 1.0f, 1.0f, 1.0f, 1.0f);
            poseStack.scale(0.2f, 0.2f, 0.2f);
            LevelRenderer.renderLineBox(poseStack, buffer, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0f, 0.0f, 0.0f, 1.0f);
            LevelRenderer.renderLineBox(poseStack, buffer, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0f, 1.0f, 0.0f, 1.0f);
            LevelRenderer.renderLineBox(poseStack, buffer, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0f, 0.0f, 1.0f, 1.0f);
            poseStack.popPose();
        }
        RenderSystem.enableDepthTest();
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public List<C0016M> m51c() {
        return this.f174a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public InterfaceC0022S m52a() {
        return this.f176a;
    }

    /* JADX INFO: renamed from: a */
    public boolean m53a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull Frustum frustum) {
        this.f174a.forEach(c0016m -> {
            c0016m.m76a(minecraft, c0623l, clientLevel);
        });
        m47p();
        int i = this.f179aq;
        this.f179aq = i - 1;
        if (i <= 0 && clientLevel.random.nextInt(100) == 0) {
            Vector3d vector3dA = this.f176a.m117a(new Vector3d());
            Vec3 vec3Position = localPlayer.position();
            float fDistance = (float) vector3dA.distance(vec3Position.x, vec3Position.y, vec3Position.z);
            float fNextFloat = clientLevel.random.nextFloat() * 6.2831855f;
            vector3dA.x += Math.cos(fNextFloat) * 2.0d;
            vector3dA.z += Math.sin(fNextFloat) * 2.0d;
            if (fDistance <= 8.0f) {
                clientLevel.playLocalSound(vector3dA.x, vector3dA.y, vector3dA.z, (SoundEvent) C1312xz.f8128st.get(), SoundSource.AMBIENT, 0.1f + (0.2f * clientLevel.random.nextFloat()), 0.8f + (0.2f * clientLevel.random.nextFloat()), false);
            }
        }
        if (m54a(localPlayer) || m45a(frustum)) {
            m55q();
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private boolean m54a(@NotNull LocalPlayer localPlayer) {
        Vec3 vec3Position = localPlayer.position();
        double dX = vec3Position.x();
        double dY = vec3Position.y();
        double dZ = vec3Position.z();
        double dMo104g = this.f176a.mo104g();
        double dMo105h = this.f176a.mo105h();
        double dMo106i = this.f176a.mo106i();
        double dMo101d = this.f176a.mo101d();
        double dMo102e = this.f176a.mo102e();
        double dMo103f = this.f176a.mo103f();
        return (((dX - dMo104g) * (dX - dMo104g)) + ((dY - dMo105h) * (dY - dMo105h))) + ((dZ - dMo106i) * (dZ - dMo106i)) > 65536.0d || (((dX - dMo101d) * (dX - dMo101d)) + ((dY - dMo102e) * (dY - dMo102e))) + ((dZ - dMo103f) * (dZ - dMo103f)) > 65536.0d;
    }

    /* JADX INFO: renamed from: q */
    public void m55q() {
        Iterator<C0016M> it = this.f174a.iterator();
        while (it.hasNext()) {
            it.next().m86q();
        }
    }

    /* JADX INFO: renamed from: r */
    public void m56r() {
        Iterator<C0016M> it = this.f174a.iterator();
        while (it.hasNext()) {
            it.next().m87r();
        }
    }
}
