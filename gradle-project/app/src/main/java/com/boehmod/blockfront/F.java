package com.boehmod.blockfront;

import com.boehmod.blockfront.client.corpse.physics.RustCorpsePhysics;
import com.boehmod.blockfront.vW;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.multiplayer.ClientChunkCache;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.core.SectionPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.joml.Math;
import org.joml.Matrix4f;
import org.joml.Quaterniond;
import org.joml.Quaternionf;
import org.joml.Vector3d;
import org.joml.Vector3f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/F.class */
public class F {
    public static final int D = 100;
    public static final int E = 20;
    public static final int F = 2;
    public static final double h = -26.0d;
    public static final double i = 0.05d;
    public static final int G = 2;
    public static final int H = 1;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static final float f6h = 16.0f;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public static final float f7i = 1.0f;
    public static final float j = 0.0f;
    public static final float k = 20.0f;
    public static final float l = 15.0f;
    public static final int I = 64;
    public static final int J = 32;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public static final double f8j = 5.0d;

    @Nullable
    private com.boehmod.blockfront.client.corpse.physics.b a;

    @NotNull
    private final List<E> c = new ObjectArrayList();

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NotNull
    private final Map<SectionPos, D> f9c = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final AtomicInteger f10a = new AtomicInteger(0);
    private final int[] b = new int[4096];

    public F() {
        RustCorpsePhysics.initialize(0.0d, -26.0d, 0.0d);
    }

    @NotNull
    private <T extends LivingEntity> E a(@NotNull Minecraft minecraft, @NotNull vW.a aVar, @NotNull T t, float f) {
        LivingEntityRenderer renderer = minecraft.getEntityRenderDispatcher().getRenderer(t);
        if (!(renderer instanceof S)) {
            throw new IllegalArgumentException("Cannot ragdoll an entity whose renderer does not implement RagdollableEntityRenderer!");
        }
        S s = (S) renderer;
        float f2 = 1.0f;
        if ((t instanceof AbstractClientPlayer) || (t instanceof mE)) {
            f2 = 0.9375f;
        }
        Vec3 vec3Add = t.getPosition(f).add(renderer.getRenderOffset(t, f));
        float f3 = ((LivingEntity) t).tickCount + f;
        float preciseBodyRotation = t.getPreciseBodyRotation(f);
        PoseStack poseStack = new PoseStack();
        poseStack.translate(vec3Add.x, vec3Add.y, vec3Add.z);
        if (renderer instanceof LivingEntityRenderer) {
            renderer.setupRotations(t, poseStack, f3, preciseBodyRotation, f, t.getScale());
        }
        poseStack.scale(-1.0f, -1.0f, 1.0f);
        poseStack.scale(f2, f2, f2);
        poseStack.translate(0.0d, -1.501d, 0.0d);
        poseStack.scale(0.0625f, 0.0625f, 0.0625f);
        if ((t instanceof LocalPlayer) && (renderer instanceof LivingEntityRenderer)) {
            renderer.getModel().setupAnim(t, 0.0f, 0.0f, ((LivingEntity) t).tickCount + f, Mth.rotLerp(f, ((LivingEntity) t).yHeadRotO, ((LivingEntity) t).yHeadRot) - Mth.rotLerp(f, ((LivingEntity) t).yBodyRotO, ((LivingEntity) t).yBodyRot), Mth.lerp(f, ((LivingEntity) t).xRotO, t.getXRot()));
        }
        return new E(s.a(this, aVar, t, new R(this, poseStack, f2)));
    }

    @Contract("_, _, _, _, _ -> new")
    @NotNull
    public static G a(@NotNull R r, @NotNull I i2, double d, @NotNull PartPose partPose, @NotNull H... hArr) {
        PoseStack poseStackA = r.a();
        float fM159a = r.m159a();
        poseStackA.pushPose();
        poseStackA.translate(partPose.x, partPose.y, partPose.z);
        poseStackA.mulPose(new Quaternionf().rotateZYX(partPose.zRot, partPose.yRot, partPose.xRot));
        Matrix4f matrix4fPose = poseStackA.last().pose();
        G g = new G(i2, new P(new Vector3d(matrix4fPose.getTranslation(new Vector3f())), new Quaterniond(new Quaternionf().setFromUnnormalized(matrix4fPose)), new Vector3d(), new Vector3d(1.0d)), hArr, fM159a, d);
        poseStackA.popPose();
        return g;
    }

    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        b(clientLevel);
        if (this.c.isEmpty()) {
            return;
        }
        int i2 = Minecraft.useFancyGraphics() ? 2 : 1;
        for (int i3 = 0; i3 < i2; i3++) {
            RustCorpsePhysics.tick(0.05d / ((double) i2));
            Iterator<E> it = this.c.iterator();
            while (it.hasNext()) {
                Iterator<G> it2 = it.next().b().iterator();
                while (it2.hasNext()) {
                    it2.next().d(clientLevel);
                }
            }
        }
        Frustum frustum = minecraft.levelRenderer.getFrustum();
        if (frustum == null) {
            return;
        }
        this.c.removeIf(e -> {
            return e.a(minecraft, c0297l, clientLevel, localPlayer, frustum);
        });
    }

    private void b(@NotNull ClientLevel clientLevel) {
        long gameTime = clientLevel.getGameTime();
        ClientChunkCache chunkSource = clientLevel.getChunkSource();
        int sectionsCount = clientLevel.getSectionsCount();
        this.f9c.entrySet().removeIf(entry -> {
            SectionPos sectionPos = (SectionPos) entry.getKey();
            return ((D) entry.getValue()).a() < gameTime - 20 || !chunkSource.hasChunk(sectionPos.x(), sectionPos.z());
        });
        Iterator<E> it = this.c.iterator();
        while (it.hasNext()) {
            M mA = it.next().a();
            N n = new N(Mth.floor(mA.b()) >> 4, Mth.floor(mA.c()) >> 4, Mth.floor(mA.d()) >> 4, Mth.floor(mA.e()) >> 4, Mth.floor(mA.f()) >> 4, Mth.floor(mA.g()) >> 4);
            int i2 = n.i();
            for (int iF = n.f(); iF <= i2; iF++) {
                int iK = n.k();
                for (int iH = n.h(); iH <= iK; iH++) {
                    LevelChunk chunk = clientLevel.getChunk(iF, iH);
                    int iJ = n.j();
                    for (int iG = n.g(); iG <= iJ; iG++) {
                        SectionPos sectionPosOf = SectionPos.of(iF, iG, iH);
                        int sectionIndexFromSectionY = clientLevel.getSectionIndexFromSectionY(iG);
                        if (sectionIndexFromSectionY >= 0 && sectionIndexFromSectionY < sectionsCount) {
                            D d = this.f9c.get(sectionPosOf);
                            if (d == null) {
                                a(chunk.getSection(sectionIndexFromSectionY), iF, iG, iH);
                                this.f9c.put(sectionPosOf, new D(gameTime));
                            } else {
                                d.a(gameTime);
                            }
                        }
                    }
                }
            }
        }
    }

    private void a(@NotNull LevelChunkSection levelChunkSection, int i2, int i3, int i4) {
        if (this.a == null) {
            C0263jt.a("[BlockFront] Warning: Attempted to add chunk section without a block physics bakery!", new Object[0]);
            return;
        }
        if (levelChunkSection.hasOnlyAir()) {
            return;
        }
        int[] iArr = this.b;
        for (int i5 = 0; i5 < 16; i5++) {
            for (int i6 = 0; i6 < 16; i6++) {
                for (int i7 = 0; i7 < 16; i7++) {
                    com.boehmod.blockfront.client.corpse.physics.a aVarB = this.a.b(levelChunkSection.getBlockState(i5, i7, i6));
                    iArr[i5 + (i6 << 4) + (i7 << 8)] = aVarB == null ? 0 : aVarB.m() + 1;
                }
            }
        }
        RustCorpsePhysics.addChunk(i2, i3, i4, iArr);
    }

    public void a(@NotNull E e) {
        this.c.add(e);
        List<G> listB = e.b();
        for (G g : listB) {
            g.a(RustCorpsePhysics.a(this.f10a.getAndIncrement(), g.a(), g.m146a(), g.m149a()));
        }
        for (G g2 : listB) {
            com.boehmod.blockfront.client.corpse.physics.d dVarM145a = g2.m145a();
            for (com.boehmod.blockfront.client.corpse.physics.c cVar : g2.m147a()) {
                dVarM145a.a(cVar.a().m145a(), cVar.e(), cVar.f(), cVar.b(), cVar.c(), cVar.g(), 5.0d);
            }
        }
        if (this.c.size() > (E.j() ? 64 : 32)) {
            b((E) this.c.removeFirst());
        }
    }

    public void b(@NotNull E e) {
        this.c.remove(e);
        e.n();
    }

    public void p() {
        Iterator<E> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().n();
        }
        this.c.clear();
    }

    public void a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull LivingEntity livingEntity, @NotNull vW.a aVar, @NotNull Random random) {
        mZ mZVar;
        if (localPlayer.distanceTo(livingEntity) > 256.0f) {
            return;
        }
        boolean z = livingEntity == minecraft.player;
        if (z) {
            Iterator<E> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().o();
            }
        }
        E eA = a(minecraft, aVar, livingEntity, 1.0f);
        E eA2 = a(minecraft, aVar, livingEntity, 0.0f);
        a(eA);
        List<G> listB = eA.b();
        List<G> listB2 = eA2.b();
        int size = listB.size();
        for (int i2 = 0; i2 < size; i2++) {
            G g = listB.get(i2);
            Q qA = g.a();
            Q qA2 = listB2.get(i2).a();
            Quaterniond quaterniondDiv = qA2.mo158a().div(qA.mo158a(), new Quaterniond());
            Vector3d vector3d = new Vector3d(quaterniondDiv.x, quaterniondDiv.y, quaterniondDiv.z);
            if (vector3d.lengthSquared() <= 1.0E-15d) {
                vector3d.mul(2.0d / quaterniondDiv.w);
            } else {
                vector3d.normalize().mul(2.0d * Math.safeAcos(quaterniondDiv.w));
            }
            Vector3d vector3dNegate = qA2.d().sub(qA.d(), new Vector3d()).div(0.05d).negate();
            vector3dNegate.add(aVar.e());
            vector3d.div(0.05d).negate();
            if (g.m150a() == I.BODY && aVar.cW()) {
                vector3d.add(((random.nextFloat() * 2.0f) - 1.0f) * 20.0f, ((random.nextFloat() * 2.0f) - 1.0f) * 20.0f, ((random.nextFloat() * 2.0f) - 1.0f) * 20.0f);
            }
            if (g.m150a() == I.HEAD && z && (mZVar = (mZ) ((EntityType) wX.kB.get()).create(clientLevel)) != null) {
                iG.a(mZVar, clientLevel);
                g.a(mZVar);
                Camera mainCamera = minecraft.gameRenderer.getMainCamera();
                mainCamera.eyeHeight = 0.0f;
                mainCamera.eyeHeightOld = 0.0f;
            }
            g.m145a().b(C0634xm.a(vector3dNegate, -15.0d, 15.0d), C0634xm.a(vector3d, -15.0d, 15.0d));
        }
    }

    public void c(@NotNull ClientLevel clientLevel) {
        if (this.a != null) {
            C0263jt.a("[BlockFront] Warning: Attempted to instantiate level collider when one already exists!", new Object[0]);
        } else {
            this.a = new com.boehmod.blockfront.client.corpse.physics.b(clientLevel);
        }
    }

    public void q() {
        if (this.a == null) {
            C0263jt.a("[BlockFront] Warning: Attempted to free null level collider!", new Object[0]);
            return;
        }
        p();
        RustCorpsePhysics.clearLevel();
        this.a = null;
    }

    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fT fTVar, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, float f) {
        Frustum frustum = minecraft.levelRenderer.getFrustum();
        for (E e : this.c) {
            if (frustum.isVisible(e.a().a())) {
                e.a(minecraft, c0297l, fTVar, clientLevel, localPlayer, poseStack, f);
            }
        }
    }
}
