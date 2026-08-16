package com.boehmod.blockfront;

import com.boehmod.blockfront.client.corpse.physics.C0175a;
import com.boehmod.blockfront.client.corpse.physics.C0176b;
import com.boehmod.blockfront.client.corpse.physics.C0177c;
import com.boehmod.blockfront.client.corpse.physics.C0178d;
import com.boehmod.blockfront.client.corpse.physics.RustCorpsePhysics;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
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
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.SectionPos;
import net.minecraft.resources.ResourceLocation;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.L */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/L.class */
public class C0015L {

    /* JADX INFO: renamed from: ar */
    public static final int f181ar = 100;

    /* JADX INFO: renamed from: as */
    public static final int f182as = 20;

    /* JADX INFO: renamed from: at */
    public static final int f183at = 2;

    /* JADX INFO: renamed from: o */
    public static final double f184o = -26.0d;

    /* JADX INFO: renamed from: p */
    public static final double f185p = 0.05d;

    /* JADX INFO: renamed from: au */
    public static final int f186au = 2;

    /* JADX INFO: renamed from: av */
    public static final int f187av = 1;

    /* JADX INFO: renamed from: m */
    public static final float f188m = 16.0f;

    /* JADX INFO: renamed from: n */
    public static final float f189n = 1.0f;

    /* JADX INFO: renamed from: o */
    public static final float f190o = 0.0f;

    /* JADX INFO: renamed from: p */
    public static final float f191p = 20.0f;

    /* JADX INFO: renamed from: q */
    public static final float f192q = 15.0f;

    /* JADX INFO: renamed from: aw */
    public static final int f193aw = 64;

    /* JADX INFO: renamed from: ax */
    public static final int f194ax = 32;

    /* JADX INFO: renamed from: q */
    public static final double f195q = 5.0d;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0176b f200a;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final List<C0014K> f196c = new ObjectArrayList();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Object2ObjectLinkedOpenHashMap<ResourceLocation, List<C0014K>> f197a = new Object2ObjectLinkedOpenHashMap<>();

    /* JADX INFO: renamed from: d */
    @NotNull
    private final List<C0014K> f198d = new ObjectArrayList();

    /* JADX INFO: renamed from: c */
    @NotNull
    private final Map<SectionPos, C0013J> f199c = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final AtomicInteger f201a = new AtomicInteger(0);

    /* JADX INFO: renamed from: d */
    private final int[] f202d = new int[4096];

    public C0015L() {
        RustCorpsePhysics.initialize(0.0d, -26.0d, 0.0d);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private <T extends LivingEntity> C0014K m58a(@NotNull Minecraft minecraft, @NotNull C1256ww.a aVar, @NotNull T t, float f) {
        LivingEntityRenderer renderer = minecraft.getEntityRenderDispatcher().getRenderer(t);
        if (!(renderer instanceof InterfaceC0028Y)) {
            throw new IllegalArgumentException("Cannot ragdoll an entity whose renderer does not implement RagdollableEntityRenderer!");
        }
        InterfaceC0028Y interfaceC0028Y = (InterfaceC0028Y) renderer;
        float f2 = 1.0f;
        if ((t instanceof AbstractClientPlayer) || (t instanceof C0756na)) {
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
        return new C0014K(interfaceC0028Y.mo167a(this, aVar, t, new C0027X(this, poseStack, f2)));
    }

    @Contract("_, _, _, _, _ -> new")
    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0016M m59a(@NotNull C0027X c0027x, @NotNull EnumC0018O enumC0018O, double d, @NotNull PartPose partPose, @NotNull C0017N... c0017nArr) {
        PoseStack poseStackM165a = c0027x.m165a();
        float fM166a = c0027x.m166a();
        poseStackM165a.pushPose();
        poseStackM165a.translate(partPose.x, partPose.y, partPose.z);
        poseStackM165a.mulPose(new Quaternionf().rotateZYX(partPose.zRot, partPose.yRot, partPose.xRot));
        Matrix4f matrix4fPose = poseStackM165a.last().pose();
        C0016M c0016m = new C0016M(enumC0018O, new C0025V(new Vector3d(matrix4fPose.getTranslation(new Vector3f())), new Quaterniond(new Quaternionf().setFromUnnormalized(matrix4fPose)), new Vector3d(), new Vector3d(1.0d)), c0017nArr, fM166a, d);
        poseStackM165a.popPose();
        return c0016m;
    }

    /* JADX INFO: renamed from: a */
    public void m60a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        m61b(clientLevel);
        if (this.f196c.isEmpty()) {
            return;
        }
        int i = Minecraft.useFancyGraphics() ? 2 : 1;
        for (int i2 = 0; i2 < i; i2++) {
            RustCorpsePhysics.tick(0.05d / ((double) i));
            Iterator<C0014K> it = this.f196c.iterator();
            while (it.hasNext()) {
                Iterator<C0016M> it2 = it.next().m51c().iterator();
                while (it2.hasNext()) {
                    it2.next().m89d(clientLevel);
                }
            }
        }
        Frustum frustum = minecraft.levelRenderer.getFrustum();
        if (frustum == null) {
            return;
        }
        this.f196c.removeIf(c0014k -> {
            return c0014k.m53a(minecraft, c0623l, clientLevel, localPlayer, frustum);
        });
    }

    /* JADX INFO: renamed from: b */
    private void m61b(@NotNull ClientLevel clientLevel) {
        long gameTime = clientLevel.getGameTime();
        ClientChunkCache chunkSource = clientLevel.getChunkSource();
        int sectionsCount = clientLevel.getSectionsCount();
        this.f199c.entrySet().removeIf(entry -> {
            SectionPos sectionPos = (SectionPos) entry.getKey();
            return ((C0013J) entry.getValue()).m43b() < gameTime - 20 || !chunkSource.hasChunk(sectionPos.x(), sectionPos.z());
        });
        Iterator<C0014K> it = this.f196c.iterator();
        while (it.hasNext()) {
            InterfaceC0022S interfaceC0022SM52a = it.next().m52a();
            C0023T c0023t = new C0023T(Mth.floor(interfaceC0022SM52a.mo101d()) >> 4, Mth.floor(interfaceC0022SM52a.mo102e()) >> 4, Mth.floor(interfaceC0022SM52a.mo103f()) >> 4, Mth.floor(interfaceC0022SM52a.mo104g()) >> 4, Mth.floor(interfaceC0022SM52a.mo105h()) >> 4, Mth.floor(interfaceC0022SM52a.mo106i()) >> 4);
            int iMo128m = c0023t.mo128m();
            for (int iMo125j = c0023t.mo125j(); iMo125j <= iMo128m; iMo125j++) {
                int iMo130o = c0023t.mo130o();
                for (int iMo127l = c0023t.mo127l(); iMo127l <= iMo130o; iMo127l++) {
                    LevelChunk chunk = clientLevel.getChunk(iMo125j, iMo127l);
                    int iMo129n = c0023t.mo129n();
                    for (int iMo126k = c0023t.mo126k(); iMo126k <= iMo129n; iMo126k++) {
                        SectionPos sectionPosOf = SectionPos.of(iMo125j, iMo126k, iMo127l);
                        int sectionIndexFromSectionY = clientLevel.getSectionIndexFromSectionY(iMo126k);
                        if (sectionIndexFromSectionY >= 0 && sectionIndexFromSectionY < sectionsCount) {
                            C0013J c0013j = this.f199c.get(sectionPosOf);
                            if (c0013j == null) {
                                m62a(chunk.getSection(sectionIndexFromSectionY), iMo125j, iMo126k, iMo127l);
                                this.f199c.put(sectionPosOf, new C0013J(gameTime));
                            } else {
                                c0013j.m44a(gameTime);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m62a(@NotNull LevelChunkSection levelChunkSection, int i, int i2, int i3) {
        if (this.f200a == null) {
            C0530jM.m2337a("[BlockFront] Warning: Attempted to add chunk section without a block physics bakery!", new Object[0]);
            return;
        }
        if (levelChunkSection.hasOnlyAir()) {
            return;
        }
        int[] iArr = this.f202d;
        for (int i4 = 0; i4 < 16; i4++) {
            for (int i5 = 0; i5 < 16; i5++) {
                for (int i6 = 0; i6 < 16; i6++) {
                    C0175a c0175aM1069b = this.f200a.m1069b(levelChunkSection.getBlockState(i4, i6, i5));
                    iArr[i4 + (i5 << 4) + (i6 << 8)] = c0175aM1069b == null ? 0 : c0175aM1069b.m1066q() + 1;
                }
            }
        }
        RustCorpsePhysics.addChunk(i, i2, i3, iArr);
    }

    /* JADX INFO: renamed from: a */
    public void m63a(@NotNull C0014K c0014k) {
        this.f196c.add(c0014k);
        List<C0016M> listM51c = c0014k.m51c();
        for (C0016M c0016m : listM51c) {
            c0016m.m80a(RustCorpsePhysics.m1063a(this.f201a.getAndIncrement(), c0016m.m78a(), c0016m.m81a(), c0016m.m84c()));
        }
        for (C0016M c0016m2 : listM51c) {
            C0178d c0178dM79a = c0016m2.m79a();
            for (C0177c c0177c : c0016m2.m82a()) {
                c0178dM79a.m1081a(c0177c.m1071a().m79a(), c0177c.m1074e(), c0177c.m1075f(), c0177c.m1072b(), c0177c.m1073c(), c0177c.m1076g(), 5.0d);
            }
        }
        if (this.f196c.size() > (C0014K.m46k() ? 64 : 32)) {
            m64b((C0014K) this.f196c.removeFirst());
        }
    }

    /* JADX INFO: renamed from: b */
    public void m64b(@NotNull C0014K c0014k) {
        this.f196c.remove(c0014k);
        c0014k.m55q();
    }

    /* JADX INFO: renamed from: s */
    public void m65s() {
        Iterator<C0014K> it = this.f196c.iterator();
        while (it.hasNext()) {
            it.next().m55q();
        }
        this.f196c.clear();
    }

    /* JADX INFO: renamed from: a */
    public void m66a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull LivingEntity livingEntity, @NotNull C1256ww.a aVar, @NotNull Random random) {
        C0777nv c0777nv;
        if (localPlayer.distanceTo(livingEntity) > 256.0f) {
            return;
        }
        boolean z = livingEntity == minecraft.player;
        if (z) {
            Iterator<C0014K> it = this.f196c.iterator();
            while (it.hasNext()) {
                it.next().m56r();
            }
        }
        C0014K c0014kM58a = m58a(minecraft, aVar, livingEntity, 1.0f);
        C0014K c0014kM58a2 = m58a(minecraft, aVar, livingEntity, 0.0f);
        m63a(c0014kM58a);
        List<C0016M> listM51c = c0014kM58a.m51c();
        List<C0016M> listM51c2 = c0014kM58a2.m51c();
        int size = listM51c.size();
        for (int i = 0; i < size; i++) {
            C0016M c0016m = listM51c.get(i);
            InterfaceC0026W interfaceC0026WM78a = c0016m.m78a();
            InterfaceC0026W interfaceC0026WM78a2 = listM51c2.get(i).m78a();
            Quaterniond quaterniondDiv = interfaceC0026WM78a2.mo156a().div(interfaceC0026WM78a.mo156a(), new Quaterniond());
            Vector3d vector3d = new Vector3d(quaterniondDiv.x, quaterniondDiv.y, quaterniondDiv.z);
            if (vector3d.lengthSquared() <= 1.0E-15d) {
                vector3d.mul(2.0d / quaterniondDiv.w);
            } else {
                vector3d.normalize().mul(2.0d * Math.safeAcos(quaterniondDiv.w));
            }
            Vector3d vector3dNegate = interfaceC0026WM78a2.mo157d().sub(interfaceC0026WM78a.mo157d(), new Vector3d()).div(0.05d).negate();
            vector3dNegate.add(aVar.m7112c());
            vector3d.div(0.05d).negate();
            if (c0016m.m85a() == EnumC0018O.BODY && aVar.m7111df()) {
                vector3d.add(((random.nextFloat() * 2.0f) - 1.0f) * 20.0f, ((random.nextFloat() * 2.0f) - 1.0f) * 20.0f, ((random.nextFloat() * 2.0f) - 1.0f) * 20.0f);
            }
            if (c0016m.m85a() == EnumC0018O.HEAD && z && (c0777nv = (C0777nv) ((EntityType) C1307xu.f7594kB.get()).create(clientLevel)) != null) {
                C0490iZ.m2213a(c0777nv, clientLevel);
                c0016m.m73a(c0777nv);
                Camera mainCamera = minecraft.gameRenderer.getMainCamera();
                mainCamera.eyeHeight = 0.0f;
                mainCamera.eyeHeightOld = 0.0f;
            }
            c0016m.m79a().m1079b(C1270xJ.m7167a(vector3dNegate, -15.0d, 15.0d), C1270xJ.m7167a(vector3d, -15.0d, 15.0d));
        }
    }

    /* JADX INFO: renamed from: c */
    public void m67c(@NotNull ClientLevel clientLevel) {
        if (this.f200a != null) {
            C0530jM.m2337a("[BlockFront] Warning: Attempted to instantiate level collider when one already exists!", new Object[0]);
        } else {
            this.f200a = new C0176b(clientLevel);
        }
    }

    /* JADX INFO: renamed from: t */
    public void m68t() {
        if (this.f200a == null) {
            C0530jM.m2337a("[BlockFront] Warning: Attempted to free null level collider!", new Object[0]);
            return;
        }
        m65s();
        RustCorpsePhysics.clearLevel();
        this.f200a = null;
    }

    /* JADX INFO: renamed from: a */
    public void m69a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0394gj c0394gj, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, float f) {
        if (this.f196c.isEmpty()) {
            return;
        }
        Frustum frustum = minecraft.levelRenderer.getFrustum();
        MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
        if (minecraft.getEntityRenderDispatcher().shouldRenderHitBoxes()) {
            for (C0014K c0014k : this.f196c) {
                if (frustum.isVisible(c0014k.m52a().m120a())) {
                    c0014k.m50a(poseStack, f, bufferSource);
                }
            }
            return;
        }
        if (C0495ie.f3043w.m2230U()) {
            RenderSystem.setShaderTexture(3, C0014K.f165k);
        }
        this.f198d.clear();
        for (C0014K c0014k2 : this.f196c) {
            if (frustum.isVisible(c0014k2.m52a().m120a())) {
                this.f198d.add(c0014k2);
            }
        }
        int i = OverlayTexture.NO_OVERLAY;
        int i2 = 0;
        while (true) {
            this.f197a.clear();
            for (C0014K c0014k3 : this.f198d) {
                List<ResourceLocation> listM48b = c0014k3.m48b();
                if (i2 < listM48b.size()) {
                    ((List) this.f197a.computeIfAbsent(listM48b.get(i2), obj -> {
                        return new ObjectArrayList();
                    })).add(c0014k3);
                }
            }
            if (!this.f197a.isEmpty()) {
                ObjectBidirectionalIterator it = this.f197a.object2ObjectEntrySet().iterator();
                while (it.hasNext()) {
                    Object2ObjectMap.Entry entry = (Object2ObjectMap.Entry) it.next();
                    ResourceLocation resourceLocation = (ResourceLocation) entry.getKey();
                    VertexConsumer buffer = bufferSource.getBuffer(C0430hS.f2706d.apply(resourceLocation));
                    Iterator it2 = ((List) entry.getValue()).iterator();
                    while (it2.hasNext()) {
                        ((C0014K) it2.next()).m49a(minecraft, c0623l, c0394gj, clientLevel, localPlayer, poseStack, resourceLocation, buffer, i, f);
                    }
                }
                i2++;
            } else {
                return;
            }
        }
    }
}
