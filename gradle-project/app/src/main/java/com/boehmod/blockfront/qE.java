package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.bflib.common.RandomCollection;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.Supplier;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Vector3f;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qE.class */
public class qE extends pA implements pD, pE, pF, pG, pH, pK, pL {
    private static final int oT = 3;
    private static final float lx = 16.0f;
    private static final int oU = 200;
    private static final float ly = 64.0f;

    @NotNull
    public List<qF> aD;
    public int oV;
    private int oW;
    private int oX;
    private int oY;
    private int oZ;
    private long t;
    private int pa;
    private float lz;

    @Nullable
    private RandomCollection<qF> b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0230in[] f281a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0230in[] f282b;

    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0230in[] c;

    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0230in[] d;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0238iv f283b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0238iv f284c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0238iv f285d;

    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0238iv e;
    private int[] u;
    private int[] v;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NotNull
    private final EnumMap<EnumC0419pn, AbstractC0003aa> f286c;

    @NotNull
    private static final ResourceLocation eK = C0265jv.d("textures/misc/debug/mapeffect/weather.png");
    private static final Vector3f l = new Vector3f();
    private static final Vec3[] a = {new Vec3(16.0d, 0.0d, 0.0d), new Vec3(-8.0d, 0.0d, (16.0d * Math.sqrt(3.0d)) / 2.0d), new Vec3(-8.0d, 0.0d, ((-16.0d) * Math.sqrt(3.0d)) / 2.0d)};

    @NotNull
    public static final MapCodec<qE> Q = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(qF.K.listOf().optionalFieldOf("entries", List.of()).forGetter(qEVar -> {
            return qEVar.aD;
        }), Codec.INT.optionalFieldOf("transitionTicks", 200).forGetter(qEVar2 -> {
            return Integer.valueOf(qEVar2.oV);
        })).apply(instance, (v1, v2) -> {
            return new qE(v1, v2);
        });
    });

    public qE() {
        this.aD = new ObjectArrayList();
        this.oV = 200;
        this.oW = -1;
        this.oX = -1;
        this.oY = 0;
        this.oZ = 0;
        this.t = 0L;
        this.pa = 0;
        this.lz = -1.0f;
        this.u = new int[0];
        this.v = new int[0];
        this.f286c = new EnumMap<>(EnumC0419pn.class);
    }

    public qE(@NotNull List<qF> list, int i) {
        this.aD = new ObjectArrayList();
        this.oV = 200;
        this.oW = -1;
        this.oX = -1;
        this.oY = 0;
        this.oZ = 0;
        this.t = 0L;
        this.pa = 0;
        this.lz = -1.0f;
        this.u = new int[0];
        this.v = new int[0];
        this.f286c = new EnumMap<>(EnumC0419pn.class);
        this.aD = new ObjectArrayList(list);
        this.oV = i;
    }

    private void cD() {
        RandomCollection<qF> randomCollection = new RandomCollection<>();
        for (qF qFVar : this.aD) {
            if (qFVar.ad > 0.0d) {
                randomCollection.add(qFVar.ad, qFVar);
            }
        }
        this.b = randomCollection;
    }

    private int a(@NotNull qF qFVar) {
        int size = this.aD.size();
        for (int i = 0; i < size; i++) {
            if (this.aD.get(i) == qFVar) {
                return i;
            }
        }
        return -1;
    }

    private int a(@NotNull RandomSource randomSource) {
        if (this.b == null) {
            cD();
        }
        if (this.b == null || this.b.isEmpty()) {
            return -1;
        }
        return a(this.b.getRandom(randomSource.nextDouble()));
    }

    private int a(@NotNull RandomSource randomSource, int i) {
        if (this.b == null) {
            cD();
        }
        if (this.b == null || this.b.isEmpty()) {
            return -1;
        }
        if (i < 0) {
            return a(this.b.getRandom(randomSource.nextDouble()));
        }
        for (int i2 = 0; i2 < 8; i2++) {
            int iA = a(this.b.getRandom(randomSource.nextDouble()));
            if (iA != i) {
                return iA;
            }
        }
        for (int i3 = 1; i3 < this.aD.size(); i3++) {
            int size = (i + i3) % this.aD.size();
            if (size != i) {
                return size;
            }
        }
        return -1;
    }

    private int a(@NotNull qF qFVar, @NotNull RandomSource randomSource) {
        return qFVar.b(randomSource.nextDouble());
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull sY sYVar) {
        super.a(minecraft, sYVar);
        sYVar.a((pG) this);
        sYVar.a((pE) this);
        sYVar.a((pL) this);
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
        if (this.aD.isEmpty()) {
            return;
        }
        if (this.oW == -1) {
            this.oW = 0;
            this.t = serverLevel.getGameTime() + ((long) a(this.aD.get(this.oW), randomSource));
            this.pa = 0;
        }
        long gameTime = serverLevel.getGameTime();
        this.pa++;
        if (this.oX == -1 && gameTime >= this.t - ((long) this.oV) && this.aD.size() > 1) {
            this.oX = a(randomSource);
            this.oZ = this.oV;
            this.oY = 0;
            C0582vo.a(new C0600wf(this.y, this.oX, this.oZ), oFVar);
        }
        if (this.oX >= 0) {
            this.oY++;
            if (this.oY >= this.oZ) {
                this.oW = this.oX;
                this.oX = -1;
                this.oY = 0;
                this.oZ = 0;
                this.t = gameTime + ((long) a(this.aD.get(this.oW), randomSource));
                this.pa = 0;
            }
        }
        cE();
    }

    private void cE() {
        qF qFVar;
        float fClamp;
        if (this.oW < 0 || this.oW >= this.aD.size()) {
            this.lz = -1.0f;
            return;
        }
        qF qFVar2 = this.aD.get(this.oW);
        if (this.oX >= 0 && this.oX < this.aD.size()) {
            qFVar = this.aD.get(this.oX);
        } else {
            qFVar = null;
        }
        qF qFVar3 = qFVar;
        Float fX = qFVar2.a.x();
        Float fX2 = qFVar3 != null ? qFVar3.a.x() : null;
        if (fX == null && fX2 == null) {
            this.lz = -1.0f;
            return;
        }
        if (qFVar3 != null && this.oZ > 0) {
            fClamp = Mth.clamp(this.oY / this.oZ, 0.0f, 1.0f);
        } else {
            fClamp = 0.0f;
        }
        float f = fClamp;
        float fFloatValue = fX != null ? fX.floatValue() : 64.0f;
        float fLerp = qFVar3 != null ? Mth.lerp(f, fFloatValue, fX2 != null ? fX2.floatValue() : 64.0f) : fFloatValue;
        this.lz = fLerp >= 64.0f ? -1.0f : fLerp;
    }

    @Override // com.boehmod.blockfront.pD
    public float aN() {
        return this.lz;
    }

    public boolean a(@NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource) {
        if (this.aD.size() < 2 || this.oW == -1 || this.oX != -1) {
            return false;
        }
        this.oX = a(randomSource, this.oW);
        if (this.oX == -1) {
            return false;
        }
        this.oZ = this.oV;
        this.oY = 0;
        C0582vo.a(new C0600wf(this.y, this.oX, this.oZ), oFVar);
        return true;
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        qF qFVar;
        float fClamp;
        if (this.aD.isEmpty() || this.oW < 0 || this.oW >= this.aD.size()) {
            return;
        }
        this.pa++;
        if (this.oX >= 0) {
            this.oY++;
            if (this.oY >= this.oZ) {
                F(minecraft);
            }
        }
        qF qFVar2 = this.aD.get(this.oW);
        if (this.oX >= 0 && this.oX < this.aD.size()) {
            qFVar = this.aD.get(this.oX);
        } else {
            qFVar = null;
        }
        qF qFVar3 = qFVar;
        if (qFVar3 != null && this.oZ > 0) {
            fClamp = Mth.clamp(this.oY / this.oZ, 0.0f, 1.0f);
        } else {
            fClamp = 0.0f;
        }
        float f2 = fClamp;
        a(oFVar.m767a(), qFVar2, qFVar3, f2);
        a(minecraft, c0297l, oFVar, clientLevel, localPlayer, qFVar2, qFVar3, f2);
        a(minecraft, c0297l, clientLevel, localPlayer, qFVar2, qFVar3, f2, randomSource);
        a(minecraft, c0297l, clientLevel, localPlayer, randomSource, qFVar2, qFVar3, f2);
    }

    @OnlyIn(Dist.CLIENT)
    private void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull RandomSource randomSource, @NotNull qF qFVar, @Nullable qF qFVar2, float f) {
        Entity cameraEntity = minecraft.getCameraEntity();
        Vec3 vec3Position = cameraEntity != null ? cameraEntity.position() : localPlayer.position();
        BlockPos blockPosBlockPosition = cameraEntity != null ? cameraEntity.blockPosition() : localPlayer.blockPosition();
        List<EnumC0419pn> listN = qFVar.a.N();
        List<EnumC0419pn> listN2 = qFVar2 != null ? qFVar2.a.N() : List.of();
        Iterator it = this.f286c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            EnumC0419pn enumC0419pn = (EnumC0419pn) entry.getKey();
            if (!listN.contains(enumC0419pn) && !listN2.contains(enumC0419pn)) {
                ((AbstractC0003aa) entry.getValue()).c(minecraft, c0297l);
                it.remove();
            }
        }
        float f2 = qFVar2 != null ? 1.0f - f : 1.0f;
        for (EnumC0419pn enumC0419pn2 : listN) {
            a(minecraft, c0297l, clientLevel, randomSource, vec3Position, blockPosBlockPosition, enumC0419pn2, listN2.contains(enumC0419pn2) ? 1.0f : f2);
        }
        for (EnumC0419pn enumC0419pn3 : listN2) {
            if (!listN.contains(enumC0419pn3)) {
                a(minecraft, c0297l, clientLevel, randomSource, vec3Position, blockPosBlockPosition, enumC0419pn3, f);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    private void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @NotNull EnumC0419pn enumC0419pn, float f) {
        AbstractC0003aa abstractC0003aa = (AbstractC0003aa) this.f286c.computeIfAbsent(enumC0419pn, C0004ab::a);
        if (abstractC0003aa == null) {
            return;
        }
        abstractC0003aa.a(minecraft, c0297l, clientLevel, randomSource, vec3, blockPos, f);
    }

    @Override // com.boehmod.blockfront.pL
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        qF qFVar;
        float fClamp;
        if (this.aD.isEmpty() || this.oW < 0 || this.oW >= this.aD.size()) {
            return;
        }
        qF qFVar2 = this.aD.get(this.oW);
        if (this.oX >= 0 && this.oX < this.aD.size()) {
            qFVar = this.aD.get(this.oX);
        } else {
            qFVar = null;
        }
        qF qFVar3 = qFVar;
        if (qFVar3 != null && this.oZ > 0) {
            fClamp = Mth.clamp(this.oY / this.oZ, 0.0f, 1.0f);
        } else {
            fClamp = 0.0f;
        }
        float f2 = fClamp;
        List<EnumC0419pn> listN = qFVar2.a.N();
        List<EnumC0419pn> listN2 = qFVar3 != null ? qFVar3.a.N() : List.of();
        float f3 = qFVar3 != null ? 1.0f - f2 : 1.0f;
        for (EnumC0419pn enumC0419pn : listN) {
            a(minecraft, c0297l, guiGraphics, i, i2, f, enumC0419pn, listN2.contains(enumC0419pn) ? 1.0f : f3);
        }
        for (EnumC0419pn enumC0419pn2 : listN2) {
            if (!listN.contains(enumC0419pn2)) {
                a(minecraft, c0297l, guiGraphics, i, i2, f, enumC0419pn2, f2);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    private void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, @NotNull EnumC0419pn enumC0419pn, float f2) {
        AbstractC0003aa abstractC0003aa;
        if (f2 > 0.0f && (abstractC0003aa = this.f286c.get(enumC0419pn)) != null) {
            abstractC0003aa.a(minecraft, c0297l, guiGraphics, i, i2, f, f2);
        }
    }

    @Override // com.boehmod.blockfront.pE
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, int i, @NotNull PoseStack poseStack, @NotNull Matrix4f matrix4f, @NotNull Matrix4f matrix4f2, float f, double d, double d2, double d3) {
        qF qFVar;
        float fClamp;
        if (this.aD.isEmpty() || this.oW < 0 || this.oW >= this.aD.size()) {
            return;
        }
        qF qFVar2 = this.aD.get(this.oW);
        if (this.oX >= 0 && this.oX < this.aD.size()) {
            qFVar = this.aD.get(this.oX);
        } else {
            qFVar = null;
        }
        qF qFVar3 = qFVar;
        if (qFVar3 != null && this.oZ > 0) {
            fClamp = Mth.clamp(this.oY / this.oZ, 0.0f, 1.0f);
        } else {
            fClamp = 0.0f;
        }
        float f2 = fClamp;
        C0172gi c0172giM917a = qFVar2.a.m917a();
        C0172gi c0172giM917a2 = qFVar3 != null ? qFVar3.a.m917a() : null;
        if (c0172giM917a != null && c0172giM917a.equals(c0172giM917a2)) {
            C0170gg.a(c0172giM917a, minecraft, clientLevel, i, poseStack, matrix4f, matrix4f2, f, d, d2, d3, 1.0f);
            return;
        }
        float f3 = qFVar3 != null ? 1.0f - f2 : 1.0f;
        if (c0172giM917a != null) {
            C0170gg.a(c0172giM917a, minecraft, clientLevel, i, poseStack, matrix4f, matrix4f2, f, d, d2, d3, f3);
        }
        if (c0172giM917a2 != null) {
            C0170gg.a(c0172giM917a2, minecraft, clientLevel, i, poseStack, matrix4f, matrix4f2, f, d, d2, d3, f2);
        }
    }

    @Override // com.boehmod.blockfront.pG
    @OnlyIn(Dist.CLIENT)
    @NotNull
    public Vector3f a(float f, float f2) {
        qF qFVar;
        float fClamp;
        Vector3f vector3f = new Vector3f();
        if (this.aD.isEmpty() || this.oW < 0 || this.oW >= this.aD.size()) {
            return vector3f;
        }
        qF qFVar2 = this.aD.get(this.oW);
        if (this.oX >= 0 && this.oX < this.aD.size()) {
            qFVar = this.aD.get(this.oX);
        } else {
            qFVar = null;
        }
        qF qFVar3 = qFVar;
        if (qFVar3 != null && this.oZ > 0) {
            fClamp = Mth.clamp(this.oY / this.oZ, 0.0f, 1.0f);
        } else {
            fClamp = 0.0f;
        }
        float f3 = fClamp;
        a(vector3f, qFVar2, f, f2, qFVar3 != null ? 1.0f - f3 : 1.0f);
        if (qFVar3 != null) {
            a(vector3f, qFVar3, f, f2, f3);
        }
        return vector3f;
    }

    @OnlyIn(Dist.CLIENT)
    private static void a(@NotNull Vector3f vector3f, @NotNull qF qFVar, float f, float f2, float f3) {
        if (f3 <= 0.0f) {
            return;
        }
        fY fYVarA = qFVar.a.a();
        if (fYVarA != null) {
            float f4 = f3 * (1.0f - f2);
            if (f4 > 0.0f) {
                vector3f.add(fYVarA.a(f, 1.0f, l).mul(f4));
            }
        }
        fY fYVarB = qFVar.a.b();
        if (fYVarB != null) {
            float f5 = f3 * f2;
            if (f5 > 0.0f) {
                vector3f.add(fYVarB.a(f, 1.0f, l).mul(f5));
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    private void F(@NotNull Minecraft minecraft) {
        a(minecraft, this.f281a);
        a(minecraft, this.f282b);
        this.f281a = this.c;
        this.f282b = this.d;
        this.c = null;
        this.d = null;
        a(minecraft, this.f283b);
        a(minecraft, this.f284c);
        this.f283b = this.f285d;
        this.f284c = this.e;
        this.f285d = null;
        this.e = null;
        this.oW = this.oX;
        this.oX = -1;
        this.oY = 0;
        this.oZ = 0;
        this.pa = 0;
        this.u = this.v;
        this.v = new int[0];
    }

    private static int a(int i, int i2, float f) {
        return (i & (-16777216)) | (Mth.clamp((int) Mth.lerp(f, (i >> 16) & 255, (i2 >> 16) & 255), 0, 255) << 16) | (Mth.clamp((int) Mth.lerp(f, (i >> 8) & 255, (i2 >> 8) & 255), 0, 255) << 8) | Mth.clamp((int) Mth.lerp(f, i & 255, i2 & 255), 0, 255);
    }

    @OnlyIn(Dist.CLIENT)
    private static void a(@NotNull sY sYVar, @NotNull qF qFVar, @Nullable qF qFVar2, float f) {
        boolean z = qFVar.gx;
        boolean z2 = qFVar2 != null && qFVar2.gx;
        if (z && z2) {
            sYVar.c(a(qFVar.pd, qFVar2.pd, f), 1.0f);
        } else if (z) {
            sYVar.c(qFVar.pd, 1.0f - f);
        } else if (z2) {
            sYVar.c(qFVar2.pd, f);
        } else {
            sYVar.dd();
        }
        boolean z3 = qFVar.gy;
        boolean z4 = qFVar2 != null && qFVar2.gy;
        if (z3 && z4) {
            sYVar.b(Mth.lerp(f, qFVar.lA, qFVar2.lA), Mth.lerp(f, qFVar.lB, qFVar2.lB), 1.0f);
        } else if (z3) {
            sYVar.b(qFVar.lA, qFVar.lB, 1.0f - f);
        } else if (z4) {
            sYVar.b(qFVar2.lA, qFVar2.lB, f);
        } else {
            sYVar.dg();
        }
        boolean z5 = qFVar.gz;
        boolean z6 = qFVar2 != null && qFVar2.gz;
        if (z5 && z6) {
            sYVar.b(a(qFVar.pe, qFVar2.pe, f), 1.0f);
        } else if (z5) {
            sYVar.b(qFVar.pe, 1.0f - f);
        } else if (z6) {
            sYVar.b(qFVar2.pe, f);
        } else {
            sYVar.dc();
        }
        boolean z7 = qFVar.gA;
        boolean z8 = qFVar2 != null && qFVar2.gA;
        if (z7 && z8) {
            sYVar.d(a(qFVar.pf, qFVar2.pf, f), 1.0f);
        } else if (z7) {
            sYVar.d(qFVar.pf, 1.0f - f);
        } else if (z8) {
            sYVar.d(qFVar2.pf, f);
        } else {
            sYVar.de();
        }
        Float fW = qFVar.a.w();
        Float fW2 = qFVar2 != null ? qFVar2.a.w() : null;
        if (fW != null || fW2 != null) {
            float fFloatValue = fW != null ? fW.floatValue() : 0.0f;
            float fLerp = qFVar2 != null ? Mth.lerp(f, fFloatValue, fW2 != null ? fW2.floatValue() : 0.0f) : fFloatValue;
            if (fLerp > 0.0f) {
                sYVar.o(fLerp);
                return;
            } else {
                sYVar.df();
                return;
            }
        }
        sYVar.df();
    }

    @OnlyIn(Dist.CLIENT)
    private void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull oF<?, ?, ?> oFVar, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull qF qFVar, @Nullable qF qFVar2, float f) {
        float fO = c0297l.m587a().O();
        float f2 = qFVar2 != null ? 1.0f - f : 1.0f;
        float f3 = qFVar2 != null ? f : 0.0f;
        float f4 = !oR.a((Level) clientLevel, localPlayer.getBlockX(), localPlayer.getBlockZ(), localPlayer.getBlockY()) ? fO : 0.0f;
        this.f281a = a(minecraft, oFVar, c0297l, this.f281a, qFVar.r);
        this.f282b = a(minecraft, oFVar, c0297l, this.f282b, qFVar.s);
        a(this.f281a, f2 * (1.0f - fO));
        a(this.f282b, f2 * fO);
        this.f283b = a(minecraft, this.f283b, qFVar.t);
        this.f284c = a(minecraft, this.f284c, qFVar.u);
        a(this.f283b, f2 * (1.0f - fO));
        a(this.f284c, f2 * f4);
        if (qFVar2 != null) {
            this.c = a(minecraft, oFVar, c0297l, this.c, qFVar2.r);
            this.d = a(minecraft, oFVar, c0297l, this.d, qFVar2.s);
            a(this.c, f3 * (1.0f - fO));
            a(this.d, f3 * fO);
            this.f285d = a(minecraft, this.f285d, qFVar2.t);
            this.e = a(minecraft, this.e, qFVar2.u);
            a(this.f285d, f3 * (1.0f - fO));
            a(this.e, f3 * f4);
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Nullable
    private static C0230in[] a(@NotNull Minecraft minecraft, @NotNull oF<?, ?, ?> oFVar, @NotNull C0297l c0297l, @Nullable C0230in[] c0230inArr, @NotNull Supplier<SoundEvent> supplier) {
        if (c0230inArr != null) {
            return c0230inArr;
        }
        SoundEvent soundEvent = supplier.get();
        if (soundEvent == null) {
            return null;
        }
        C0412pg c0412pgM595a = c0297l.m595a();
        SoundManager soundManager = minecraft.getSoundManager();
        C0230in[] c0230inArr2 = new C0230in[3];
        for (int i = 0; i < 3; i++) {
            C0230in c0230in = new C0230in(minecraft, oFVar, soundEvent, SoundSource.AMBIENT, a[i], 0.7f + (i * 0.25f), c0412pgM595a, i);
            soundManager.play(c0230in);
            c0230inArr2[i] = c0230in;
        }
        return c0230inArr2;
    }

    @OnlyIn(Dist.CLIENT)
    private static void a(@Nullable C0230in[] c0230inArr, float f) {
        if (c0230inArr == null) {
            return;
        }
        for (C0230in c0230in : c0230inArr) {
            if (c0230in != null) {
                c0230in.h(f);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Nullable
    private static C0238iv a(@NotNull Minecraft minecraft, @Nullable C0238iv c0238iv, @NotNull Supplier<SoundEvent> supplier) {
        if (c0238iv != null) {
            return c0238iv;
        }
        SoundEvent soundEvent = supplier.get();
        if (soundEvent == null) {
            return null;
        }
        C0238iv c0238iv2 = new C0238iv(soundEvent);
        minecraft.getSoundManager().play(c0238iv2);
        return c0238iv2;
    }

    @OnlyIn(Dist.CLIENT)
    private static void a(@Nullable C0238iv c0238iv, float f) {
        if (c0238iv != null) {
            c0238iv.h(f);
        }
    }

    @OnlyIn(Dist.CLIENT)
    private static void a(@NotNull Minecraft minecraft, @Nullable C0238iv c0238iv) {
        if (c0238iv != null) {
            minecraft.getSoundManager().stop(c0238iv);
        }
    }

    @OnlyIn(Dist.CLIENT)
    private static void a(@NotNull Minecraft minecraft, @Nullable C0230in[] c0230inArr) {
        if (c0230inArr == null) {
            return;
        }
        SoundManager soundManager = minecraft.getSoundManager();
        for (C0230in c0230in : c0230inArr) {
            if (c0230in != null) {
                soundManager.stop(c0230in);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    private void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull qF qFVar, @Nullable qF qFVar2, float f, @NotNull RandomSource randomSource) {
        this.u = a(minecraft, c0297l, clientLevel, localPlayer, qFVar, this.u, qFVar2 != null ? 1.0f - f : 1.0f, randomSource);
        if (qFVar2 != null) {
            this.v = a(minecraft, c0297l, clientLevel, localPlayer, qFVar2, this.v, f, randomSource);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00d5  */
    @net.neoforged.api.distmarker.OnlyIn(net.neoforged.api.distmarker.Dist.CLIENT)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int[] a(@org.jetbrains.annotations.NotNull net.minecraft.client.Minecraft r7, @org.jetbrains.annotations.NotNull com.boehmod.blockfront.C0297l r8, @org.jetbrains.annotations.NotNull net.minecraft.client.multiplayer.ClientLevel r9, @org.jetbrains.annotations.NotNull net.minecraft.client.player.LocalPlayer r10, @org.jetbrains.annotations.NotNull com.boehmod.blockfront.qF r11, int[] r12, float r13, @org.jetbrains.annotations.NotNull net.minecraft.util.RandomSource r14) {
        /*
            Method dump skipped, instruction units count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.boehmod.blockfront.qE.a(net.minecraft.client.Minecraft, com.boehmod.blockfront.l, net.minecraft.client.multiplayer.ClientLevel, net.minecraft.client.player.LocalPlayer, com.boehmod.blockfront.qF, int[], float, net.minecraft.util.RandomSource):int[]");
    }

    @OnlyIn(Dist.CLIENT)
    public void a(int i, int i2) {
        if (i < 0 || i >= this.aD.size()) {
            return;
        }
        this.oX = i;
        this.oZ = i2;
        this.oY = 0;
    }

    @OnlyIn(Dist.CLIENT)
    public void a(int i, int i2, int i3, int i4) {
        boolean z = this.oW != i;
        this.oW = i;
        this.oX = i2;
        this.oY = i3;
        this.oZ = i4;
        if (z) {
            this.pa = 0;
        }
        if (this.oW >= 0 && this.oW < this.aD.size()) {
            this.u = new int[this.aD.get(this.oW).aE.size()];
        }
    }

    @Override // com.boehmod.blockfront.pK
    public void h(@NotNull ByteBuf byteBuf) {
        byteBuf.writeInt(this.oW);
        byteBuf.writeInt(this.oX);
        byteBuf.writeInt(this.oY);
        byteBuf.writeInt(this.oZ);
    }

    @Override // com.boehmod.blockfront.pK
    @OnlyIn(Dist.CLIENT)
    public void g(@NotNull ByteBuf byteBuf) {
        a(byteBuf.readInt(), byteBuf.readInt(), byteBuf.readInt(), byteBuf.readInt());
    }

    @Override // com.boehmod.blockfront.pH
    public void a(@NotNull ServerLevel serverLevel, @NotNull RandomSource randomSource) {
        if (this.oW != -1 || this.aD.isEmpty()) {
            return;
        }
        this.oW = 0;
        this.t = serverLevel.getGameTime() + ((long) a(this.aD.get(this.oW), randomSource));
        this.pa = 0;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        list.add(Component.literal("Entries: " + this.aD.size()));
        list.add(Component.literal("Transition Ticks: " + this.oV));
        list.add(Component.literal("Current Index: " + this.oW));
        list.add(Component.literal("Next Index: " + this.oX));
        if (this.oX >= 0 && this.oZ > 0) {
            list.add(Component.literal(String.format("Transition: %.1f%%", Float.valueOf((100.0f * this.oY) / this.oZ))).withStyle(ChatFormatting.GRAY));
        }
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public ResourceLocation x() {
        return eK;
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public List<pQ<?>> H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.H());
        objectArrayList.add(new pT(Component.literal("Transition Ticks"), () -> {
            return Integer.valueOf(this.oV);
        }, num -> {
            this.oV = num.intValue();
        }, 0, 24000));
        for (int i = 0; i < this.aD.size(); i++) {
            int i2 = i;
            qF qFVar = this.aD.get(i);
            int i3 = pQ.t[i2 % pQ.t.length];
            objectArrayList.add(new pS(Component.literal("Entry " + i2 + " Weight"), () -> {
                return Float.valueOf((float) qFVar.ad);
            }, f -> {
                qFVar.ad = f.floatValue();
            }, 0.0f, 100.0f).a(i3));
            objectArrayList.add(new pT(Component.literal("Entry " + i2 + " Min Duration"), () -> {
                return Integer.valueOf(qFVar.pb);
            }, num2 -> {
                qFVar.pb = num2.intValue();
            }, 0, 1000000).a(i3));
            objectArrayList.add(new pT(Component.literal("Entry " + i2 + " Max Duration"), () -> {
                return Integer.valueOf(qFVar.pc);
            }, num3 -> {
                qFVar.pc = num3.intValue();
            }, 0, 1000000).a(i3));
            objectArrayList.add(new pV(Component.literal("Entry " + i2 + " Interior Sound"), () -> {
                return qFVar.r.get();
            }, soundEvent -> {
                qFVar.r = soundEvent != null ? () -> {
                    return soundEvent;
                } : () -> {
                    return null;
                };
            }).a(i3));
            objectArrayList.add(new pV(Component.literal("Entry " + i2 + " Exterior Sound"), () -> {
                return qFVar.s.get();
            }, soundEvent2 -> {
                qFVar.s = soundEvent2 != null ? () -> {
                    return soundEvent2;
                } : () -> {
                    return null;
                };
            }).a(i3));
            objectArrayList.add(new pV(Component.literal("Entry " + i2 + " Player Interior Sound"), () -> {
                return qFVar.t.get();
            }, soundEvent3 -> {
                qFVar.t = soundEvent3 != null ? () -> {
                    return soundEvent3;
                } : () -> {
                    return null;
                };
            }).a(i3));
            objectArrayList.add(new pV(Component.literal("Entry " + i2 + " Player Exterior Sound"), () -> {
                return qFVar.u.get();
            }, soundEvent4 -> {
                qFVar.u = soundEvent4 != null ? () -> {
                    return soundEvent4;
                } : () -> {
                    return null;
                };
            }).a(i3));
            objectArrayList.add(new pO(Component.literal("Entry " + i2 + " Has Fog Color"), () -> {
                return Boolean.valueOf(qFVar.gx);
            }, bool -> {
                qFVar.gx = bool.booleanValue();
            }).a(i3));
            objectArrayList.add(new pP(Component.literal("Entry " + i2 + " Fog Color"), () -> {
                return Integer.valueOf(qFVar.pd);
            }, num4 -> {
                qFVar.pd = num4.intValue();
            }).a(i3));
            objectArrayList.add(new pO(Component.literal("Entry " + i2 + " Has Fog Density"), () -> {
                return Boolean.valueOf(qFVar.gy);
            }, bool2 -> {
                qFVar.gy = bool2.booleanValue();
            }).a(i3));
            objectArrayList.add(new pS(Component.literal("Entry " + i2 + " Near Fog Density"), () -> {
                return Float.valueOf(qFVar.lA);
            }, f2 -> {
                qFVar.lA = f2.floatValue();
            }, 0.0f, 1024.0f).a(i3));
            objectArrayList.add(new pS(Component.literal("Entry " + i2 + " Far Fog Density"), () -> {
                return Float.valueOf(qFVar.lB);
            }, f3 -> {
                qFVar.lB = f3.floatValue();
            }, 0.0f, 1024.0f).a(i3));
            objectArrayList.add(new pO(Component.literal("Entry " + i2 + " Has Sky Color"), () -> {
                return Boolean.valueOf(qFVar.gz);
            }, bool3 -> {
                qFVar.gz = bool3.booleanValue();
            }).a(i3));
            objectArrayList.add(new pP(Component.literal("Entry " + i2 + " Sky Color"), () -> {
                return Integer.valueOf(qFVar.pe);
            }, num5 -> {
                qFVar.pe = num5.intValue();
            }).a(i3));
            objectArrayList.add(new pO(Component.literal("Entry " + i2 + " Has Light Color"), () -> {
                return Boolean.valueOf(qFVar.gA);
            }, bool4 -> {
                qFVar.gA = bool4.booleanValue();
            }).a(i3));
            objectArrayList.add(new pP(Component.literal("Entry " + i2 + " Light Color"), () -> {
                return Integer.valueOf(qFVar.pf);
            }, num6 -> {
                qFVar.pf = num6.intValue();
            }).a(i3));
            objectArrayList.add(new pR(Component.literal("Entry " + i2 + " Weather Type"), EnumC0419pn.class, () -> {
                if (qFVar.a.N().isEmpty()) {
                    return null;
                }
                return (EnumC0419pn) qFVar.a.N().getFirst();
            }, enumC0419pn -> {
                qFVar.a = new qG(List.of(enumC0419pn), qFVar.a.a(), qFVar.a.b(), qFVar.a.m917a(), qFVar.a.w(), qFVar.a.x());
            }).a(i3));
            objectArrayList.add(new pS(Component.literal("Entry " + i2 + " Darkness"), () -> {
                return Float.valueOf(qFVar.a.w() != null ? qFVar.a.w().floatValue() : 0.0f);
            }, f4 -> {
                qFVar.a = new qG(qFVar.a.N(), qFVar.a.a(), qFVar.a.b(), qFVar.a.m917a(), f4.floatValue() > 0.0f ? f4 : null, qFVar.a.x());
            }, 0.0f, 1.0f).a(i3));
            objectArrayList.add(new pS(Component.literal("Entry " + i2 + " Bot View Distance"), () -> {
                return Float.valueOf(qFVar.a.x() != null ? qFVar.a.x().floatValue() : 0.0f);
            }, f5 -> {
                qFVar.a = new qG(qFVar.a.N(), qFVar.a.a(), qFVar.a.b(), qFVar.a.m917a(), qFVar.a.w(), f5.floatValue() > 0.0f ? f5 : null);
            }, 0.0f, 64.0f).a(i3));
            objectArrayList.add(new pM(Component.literal("Remove Entry " + i2), () -> {
                this.aD.remove(i2);
                cD();
            }).a(i3));
        }
        objectArrayList.add(new pM(Component.literal("Add Entry"), () -> {
            this.aD.add(new qF());
            cD();
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.pA
    public void cA() {
        super.cA();
        this.oW = -1;
        this.oX = -1;
        this.oY = 0;
        this.oZ = 0;
        this.t = 0L;
        this.pa = 0;
        this.lz = -1.0f;
        this.b = null;
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.a(minecraft, randomSource);
        a(minecraft, this.f281a);
        a(minecraft, this.f282b);
        a(minecraft, this.c);
        a(minecraft, this.d);
        this.f281a = null;
        this.f282b = null;
        this.c = null;
        this.d = null;
        a(minecraft, this.f283b);
        a(minecraft, this.f284c);
        a(minecraft, this.f285d);
        a(minecraft, this.e);
        this.f283b = null;
        this.f284c = null;
        this.f285d = null;
        this.e = null;
        this.oW = -1;
        this.oX = -1;
        this.oY = 0;
        this.oZ = 0;
        this.pa = 0;
        this.u = new int[0];
        this.v = new int[0];
        C0297l c0297lB = C0297l.b();
        if (c0297lB != null) {
            Iterator<AbstractC0003aa> it = this.f286c.values().iterator();
            while (it.hasNext()) {
                it.next().c(minecraft, c0297lB);
            }
        }
        this.f286c.clear();
        C0170gg.aL();
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    private static String c(@NotNull List<EnumC0419pn> list) {
        if (list.isEmpty()) {
            return "none";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(list.get(i).getId());
        }
        return sb.toString();
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    private static String a(@NotNull Supplier<SoundEvent> supplier) {
        SoundEvent soundEvent = supplier.get();
        return soundEvent == null ? "none" : soundEvent.getLocation().toString();
    }

    @Override // com.boehmod.blockfront.pF
    public void a(@NotNull C0297l c0297l, @NotNull oF<?, ?, ?> oFVar, @NotNull List<String> list) {
        qF qFVar;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        list.add("");
        list.add("Weather:");
        if (this.aD.isEmpty() || this.oW < 0 || this.oW >= this.aD.size()) {
            list.add(String.valueOf(ChatFormatting.GRAY) + "(no entry active)");
            return;
        }
        sY sYVarM767a = oFVar.m767a();
        float fO = c0297l.m587a().O();
        qF qFVar2 = this.aD.get(this.oW);
        if (this.oX >= 0 && this.oX < this.aD.size()) {
            qFVar = this.aD.get(this.oX);
        } else {
            qFVar = null;
        }
        qF qFVar3 = qFVar;
        if (qFVar3 != null && this.oZ > 0) {
            list.add("Entry: " + String.valueOf(ChatFormatting.GRAY) + this.oW + String.valueOf(ChatFormatting.WHITE) + " -> " + String.valueOf(ChatFormatting.GRAY) + this.oX + String.valueOf(ChatFormatting.WHITE) + " of " + String.valueOf(ChatFormatting.GRAY) + this.aD.size());
            list.add("Transition: " + String.valueOf(ChatFormatting.GRAY) + String.format("%.1f%%", Float.valueOf((100.0f * this.oY) / this.oZ)) + String.valueOf(ChatFormatting.WHITE) + " (" + this.oY + "/" + this.oZ + "t)");
        } else {
            list.add("Entry: " + String.valueOf(ChatFormatting.GRAY) + this.oW + String.valueOf(ChatFormatting.WHITE) + " of " + String.valueOf(ChatFormatting.GRAY) + this.aD.size());
        }
        list.add("Active: " + String.valueOf(ChatFormatting.GRAY) + this.pa + "t" + String.valueOf(ChatFormatting.WHITE) + " (range " + String.valueOf(ChatFormatting.GRAY) + qFVar2.pb + "-" + qFVar2.pc + "t" + String.valueOf(ChatFormatting.WHITE) + ")");
        list.add("Outdoor Alpha: " + String.valueOf(ChatFormatting.GRAY) + String.format("%.2f", Float.valueOf(fO)));
        if (sYVarM767a.bZ()) {
            str = "Fog Color: " + String.valueOf(ChatFormatting.GRAY) + String.format("#%06X @ %.2f", Integer.valueOf(sYVarM767a.bQ() & ColorReferences.COLOR_WHITE), Float.valueOf(sYVarM767a.aW()));
        } else {
            str = "Fog Color: " + String.valueOf(ChatFormatting.DARK_GRAY) + "off";
        }
        list.add(str);
        if (sYVarM767a.cd()) {
            str2 = "Fog Density: " + String.valueOf(ChatFormatting.GRAY) + String.format("near=%.2f far=%.2f @ %.2f", Float.valueOf(sYVarM767a.ba()), Float.valueOf(sYVarM767a.bb()), Float.valueOf(sYVarM767a.aZ()));
        } else {
            str2 = "Fog Density: " + String.valueOf(ChatFormatting.DARK_GRAY) + "off";
        }
        list.add(str2);
        if (sYVarM767a.bX()) {
            str3 = "Sky Color: " + String.valueOf(ChatFormatting.GRAY) + String.format("#%06X @ %.2f", Integer.valueOf(sYVarM767a.bO() & ColorReferences.COLOR_WHITE), Float.valueOf(sYVarM767a.aV()));
        } else {
            str3 = "Sky Color: " + String.valueOf(ChatFormatting.DARK_GRAY) + "off";
        }
        list.add(str3);
        if (sYVarM767a.ca()) {
            str4 = "Light Color: " + String.valueOf(ChatFormatting.GRAY) + String.format("#%06X @ %.2f", Integer.valueOf(sYVarM767a.bR() & ColorReferences.COLOR_WHITE), Float.valueOf(sYVarM767a.aX()));
        } else {
            str4 = "Light Color: " + String.valueOf(ChatFormatting.DARK_GRAY) + "off";
        }
        list.add(str4);
        if (sYVarM767a.cb()) {
            str5 = "Darkness: " + String.valueOf(ChatFormatting.GRAY) + String.format("%.2f", Float.valueOf(sYVarM767a.aY()));
        } else {
            str5 = "Darkness: " + String.valueOf(ChatFormatting.DARK_GRAY) + "off";
        }
        list.add(str5);
        list.add("Interior: " + String.valueOf(ChatFormatting.GRAY) + a(qFVar2.r) + (qFVar3 != null ? String.valueOf(ChatFormatting.WHITE) + " -> " + String.valueOf(ChatFormatting.GRAY) + a(qFVar3.r) : ""));
        list.add("Exterior: " + String.valueOf(ChatFormatting.GRAY) + a(qFVar2.s) + (qFVar3 != null ? String.valueOf(ChatFormatting.WHITE) + " -> " + String.valueOf(ChatFormatting.GRAY) + a(qFVar3.s) : ""));
        list.add("Weather Type: " + String.valueOf(ChatFormatting.GRAY) + c(qFVar2.a.N()) + (qFVar3 != null ? String.valueOf(ChatFormatting.WHITE) + " -> " + String.valueOf(ChatFormatting.GRAY) + c(qFVar3.a.N()) : ""));
    }
}
