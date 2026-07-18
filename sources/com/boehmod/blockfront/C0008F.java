package com.boehmod.blockfront;

import com.boehmod.blockfront.C1176vW;
import com.boehmod.blockfront.client.corpse.physics.C0174a;
import com.boehmod.blockfront.client.corpse.physics.C0175b;
import com.boehmod.blockfront.client.corpse.physics.C0176c;
import com.boehmod.blockfront.client.corpse.physics.C0177d;
import com.boehmod.blockfront.client.corpse.physics.RustCorpsePhysics;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.F */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/F.class */
public class C0008F {

    /* JADX INFO: renamed from: D */
    public static final int f143D = 100;

    /* JADX INFO: renamed from: E */
    public static final int f144E = 20;

    /* JADX INFO: renamed from: F */
    public static final int f145F = 2;

    /* JADX INFO: renamed from: h */
    public static final double f146h = -26.0d;

    /* JADX INFO: renamed from: i */
    public static final double f147i = 0.05d;

    /* JADX INFO: renamed from: G */
    public static final int f148G = 2;

    /* JADX INFO: renamed from: H */
    public static final int f149H = 1;

    /* JADX INFO: renamed from: h */
    public static final float f150h = 16.0f;

    /* JADX INFO: renamed from: i */
    public static final float f151i = 1.0f;

    /* JADX INFO: renamed from: j */
    public static final float f152j = 0.0f;

    /* JADX INFO: renamed from: k */
    public static final float f153k = 20.0f;

    /* JADX INFO: renamed from: l */
    public static final float f154l = 15.0f;

    /* JADX INFO: renamed from: I */
    public static final int f155I = 64;

    /* JADX INFO: renamed from: J */
    public static final int f156J = 32;

    /* JADX INFO: renamed from: j */
    public static final double f157j = 5.0d;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0175b f160a;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final List<C0007E> f158c = new ObjectArrayList();

    /* JADX INFO: renamed from: c */
    @NotNull
    private final Map<SectionPos, C0006D> f159c = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final AtomicInteger f161a = new AtomicInteger(0);

    /* JADX INFO: renamed from: b */
    private final int[] f162b = new int[4096];

    public C0008F() {
        RustCorpsePhysics.initialize(0.0d, -26.0d, 0.0d);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private <T extends LivingEntity> C0007E m26a(@NotNull Minecraft minecraft, @NotNull C1176vW.a aVar, @NotNull T t, float f) {
        LivingEntityRenderer renderer = minecraft.getEntityRenderDispatcher().getRenderer(t);
        if (!(renderer instanceof InterfaceC0021S)) {
            throw new IllegalArgumentException("Cannot ragdoll an entity whose renderer does not implement RagdollableEntityRenderer!");
        }
        InterfaceC0021S interfaceC0021S = (InterfaceC0021S) renderer;
        float f2 = 1.0f;
        if ((t instanceof AbstractClientPlayer) || (t instanceof C0680mE)) {
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
        return new C0007E(interfaceC0021S.mo134a(this, aVar, t, new C0020R(this, poseStack, f2)));
    }

    @Contract("_, _, _, _, _ -> new")
    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0009G m27a(@NotNull C0020R c0020r, @NotNull EnumC0011I enumC0011I, double d, @NotNull PartPose partPose, @NotNull C0010H... c0010hArr) {
        PoseStack poseStackM132a = c0020r.m132a();
        float fM133a = c0020r.m133a();
        poseStackM132a.pushPose();
        poseStackM132a.translate(partPose.x, partPose.y, partPose.z);
        poseStackM132a.mulPose(new Quaternionf().rotateZYX(partPose.zRot, partPose.yRot, partPose.xRot));
        Matrix4f matrix4fPose = poseStackM132a.last().pose();
        C0009G c0009g = new C0009G(enumC0011I, new C0018P(new Vector3d(matrix4fPose.getTranslation(new Vector3f())), new Quaterniond(new Quaternionf().setFromUnnormalized(matrix4fPose)), new Vector3d(), new Vector3d(1.0d)), c0010hArr, fM133a, d);
        poseStackM132a.popPose();
        return c0009g;
    }

    /* JADX INFO: renamed from: a */
    public void m28a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        m29b(clientLevel);
        if (this.f158c.isEmpty()) {
            return;
        }
        int i = Minecraft.useFancyGraphics() ? 2 : 1;
        for (int i2 = 0; i2 < i; i2++) {
            RustCorpsePhysics.tick(0.05d / ((double) i));
            Iterator<C0007E> it = this.f158c.iterator();
            while (it.hasNext()) {
                Iterator<C0009G> it2 = it.next().m19b().iterator();
                while (it2.hasNext()) {
                    it2.next().m56d(clientLevel);
                }
            }
        }
        Frustum frustum = minecraft.levelRenderer.getFrustum();
        if (frustum == null) {
            return;
        }
        this.f158c.removeIf(c0007e -> {
            return c0007e.m21a(minecraft, c0622l, clientLevel, localPlayer, frustum);
        });
    }

    /* JADX INFO: renamed from: b */
    private void m29b(@NotNull ClientLevel clientLevel) {
        long gameTime = clientLevel.getGameTime();
        ClientChunkCache chunkSource = clientLevel.getChunkSource();
        int sectionsCount = clientLevel.getSectionsCount();
        this.f159c.entrySet().removeIf(entry -> {
            SectionPos sectionPos = (SectionPos) entry.getKey();
            return ((C0006D) entry.getValue()).m11a() < gameTime - 20 || !chunkSource.hasChunk(sectionPos.x(), sectionPos.z());
        });
        Iterator<C0007E> it = this.f158c.iterator();
        while (it.hasNext()) {
            InterfaceC0015M interfaceC0015MM20a = it.next().m20a();
            C0016N c0016n = new C0016N(Mth.floor(interfaceC0015MM20a.mo68b()) >> 4, Mth.floor(interfaceC0015MM20a.mo69c()) >> 4, Mth.floor(interfaceC0015MM20a.mo70d()) >> 4, Mth.floor(interfaceC0015MM20a.mo71e()) >> 4, Mth.floor(interfaceC0015MM20a.mo72f()) >> 4, Mth.floor(interfaceC0015MM20a.mo73g()) >> 4);
            int iMo95i = c0016n.mo95i();
            for (int iMo92f = c0016n.mo92f(); iMo92f <= iMo95i; iMo92f++) {
                int iMo97k = c0016n.mo97k();
                for (int iMo94h = c0016n.mo94h(); iMo94h <= iMo97k; iMo94h++) {
                    LevelChunk chunk = clientLevel.getChunk(iMo92f, iMo94h);
                    int iMo96j = c0016n.mo96j();
                    for (int iMo93g = c0016n.mo93g(); iMo93g <= iMo96j; iMo93g++) {
                        SectionPos sectionPosOf = SectionPos.of(iMo92f, iMo93g, iMo94h);
                        int sectionIndexFromSectionY = clientLevel.getSectionIndexFromSectionY(iMo93g);
                        if (sectionIndexFromSectionY >= 0 && sectionIndexFromSectionY < sectionsCount) {
                            C0006D c0006d = this.f159c.get(sectionPosOf);
                            if (c0006d == null) {
                                m30a(chunk.getSection(sectionIndexFromSectionY), iMo92f, iMo93g, iMo94h);
                                this.f159c.put(sectionPosOf, new C0006D(gameTime));
                            } else {
                                c0006d.m12a(gameTime);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m30a(@NotNull LevelChunkSection levelChunkSection, int i, int i2, int i3) {
        if (this.f160a == null) {
            C0562jt.m2515a("[BlockFront] Warning: Attempted to add chunk section without a block physics bakery!", new Object[0]);
            return;
        }
        if (levelChunkSection.hasOnlyAir()) {
            return;
        }
        int[] iArr = this.f162b;
        for (int i4 = 0; i4 < 16; i4++) {
            for (int i5 = 0; i5 < 16; i5++) {
                for (int i6 = 0; i6 < 16; i6++) {
                    C0174a c0174aM1045b = this.f160a.m1045b(levelChunkSection.getBlockState(i4, i6, i5));
                    iArr[i4 + (i5 << 4) + (i6 << 8)] = c0174aM1045b == null ? 0 : c0174aM1045b.m1042m() + 1;
                }
            }
        }
        RustCorpsePhysics.addChunk(i, i2, i3, iArr);
    }

    /* JADX INFO: renamed from: a */
    public void m31a(@NotNull C0007E c0007e) {
        this.f158c.add(c0007e);
        List<C0009G> listM19b = c0007e.m19b();
        for (C0009G c0009g : listM19b) {
            c0009g.m47a(RustCorpsePhysics.m1039a(this.f161a.getAndIncrement(), c0009g.m45a(), c0009g.m48a(), c0009g.m51a()));
        }
        for (C0009G c0009g2 : listM19b) {
            C0177d c0177dM46a = c0009g2.m46a();
            for (C0176c c0176c : c0009g2.m49a()) {
                c0177dM46a.m1057a(c0176c.m1047a().m46a(), c0176c.m1050e(), c0176c.m1051f(), c0176c.m1048b(), c0176c.m1049c(), c0176c.m1052g(), 5.0d);
            }
        }
        if (this.f158c.size() > (C0007E.m14j() ? 64 : 32)) {
            m32b((C0007E) this.f158c.removeFirst());
        }
    }

    /* JADX INFO: renamed from: b */
    public void m32b(@NotNull C0007E c0007e) {
        this.f158c.remove(c0007e);
        c0007e.m23n();
    }

    /* JADX INFO: renamed from: p */
    public void m33p() {
        Iterator<C0007E> it = this.f158c.iterator();
        while (it.hasNext()) {
            it.next().m23n();
        }
        this.f158c.clear();
    }

    /* JADX INFO: renamed from: a */
    public void m34a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull LivingEntity livingEntity, @NotNull C1176vW.a aVar, @NotNull Random random) {
        C0701mZ c0701mZ;
        if (localPlayer.distanceTo(livingEntity) > 256.0f) {
            return;
        }
        boolean z = livingEntity == minecraft.player;
        if (z) {
            Iterator<C0007E> it = this.f158c.iterator();
            while (it.hasNext()) {
                it.next().m24o();
            }
        }
        C0007E c0007eM26a = m26a(minecraft, aVar, livingEntity, 1.0f);
        C0007E c0007eM26a2 = m26a(minecraft, aVar, livingEntity, 0.0f);
        m31a(c0007eM26a);
        List<C0009G> listM19b = c0007eM26a.m19b();
        List<C0009G> listM19b2 = c0007eM26a2.m19b();
        int size = listM19b.size();
        for (int i = 0; i < size; i++) {
            C0009G c0009g = listM19b.get(i);
            InterfaceC0019Q interfaceC0019QM45a = c0009g.m45a();
            InterfaceC0019Q interfaceC0019QM45a2 = listM19b2.get(i).m45a();
            Quaterniond quaterniondDiv = interfaceC0019QM45a2.mo123a().div(interfaceC0019QM45a.mo123a(), new Quaterniond());
            Vector3d vector3d = new Vector3d(quaterniondDiv.x, quaterniondDiv.y, quaterniondDiv.z);
            if (vector3d.lengthSquared() <= 1.0E-15d) {
                vector3d.mul(2.0d / quaterniondDiv.w);
            } else {
                vector3d.normalize().mul(2.0d * Math.safeAcos(quaterniondDiv.w));
            }
            Vector3d vector3dNegate = interfaceC0019QM45a2.mo124d().sub(interfaceC0019QM45a.mo124d(), new Vector3d()).div(0.05d).negate();
            vector3dNegate.add(aVar.m6586e());
            vector3d.div(0.05d).negate();
            if (c0009g.m52a() == EnumC0011I.BODY && aVar.m6585cW()) {
                vector3d.add(((random.nextFloat() * 2.0f) - 1.0f) * 20.0f, ((random.nextFloat() * 2.0f) - 1.0f) * 20.0f, ((random.nextFloat() * 2.0f) - 1.0f) * 20.0f);
            }
            if (c0009g.m52a() == EnumC0011I.HEAD && z && (c0701mZ = (C0701mZ) ((EntityType) C1230wX.f7029kB.get()).create(clientLevel)) != null) {
                C0470iG.m2121a(c0701mZ, clientLevel);
                c0009g.m40a(c0701mZ);
                Camera mainCamera = minecraft.gameRenderer.getMainCamera();
                mainCamera.eyeHeight = 0.0f;
                mainCamera.eyeHeightOld = 0.0f;
            }
            c0009g.m46a().m1055b(C1290xm.m7841a(vector3dNegate, -15.0d, 15.0d), C1290xm.m7841a(vector3d, -15.0d, 15.0d));
        }
    }

    /* JADX INFO: renamed from: c */
    public void m35c(@NotNull ClientLevel clientLevel) {
        if (this.f160a != null) {
            C0562jt.m2515a("[BlockFront] Warning: Attempted to instantiate level collider when one already exists!", new Object[0]);
        } else {
            this.f160a = new C0175b(clientLevel);
        }
    }

    /* JADX INFO: renamed from: q */
    public void m36q() {
        if (this.f160a == null) {
            C0562jt.m2515a("[BlockFront] Warning: Attempted to free null level collider!", new Object[0]);
            return;
        }
        m33p();
        RustCorpsePhysics.clearLevel();
        this.f160a = null;
    }

    /* JADX INFO: renamed from: a */
    public void m37a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0324fT c0324fT, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, float f) {
        Frustum frustum = minecraft.levelRenderer.getFrustum();
        for (C0007E c0007e : this.f158c) {
            if (frustum.isVisible(c0007e.m20a().m87a())) {
                c0007e.m16a(minecraft, c0622l, c0324fT, clientLevel, localPlayer, poseStack, f);
            }
        }
    }
}
