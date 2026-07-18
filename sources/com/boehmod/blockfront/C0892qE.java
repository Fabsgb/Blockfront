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

/* JADX INFO: renamed from: com.boehmod.blockfront.qE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qE.class */
public class C0892qE extends AbstractC0835pA implements InterfaceC0838pD, InterfaceC0839pE, InterfaceC0840pF, InterfaceC0841pG, InterfaceC0842pH, InterfaceC0845pK, InterfaceC0846pL {

    /* JADX INFO: renamed from: oT */
    private static final int f4653oT = 3;

    /* JADX INFO: renamed from: lx */
    private static final float f4654lx = 16.0f;

    /* JADX INFO: renamed from: oU */
    private static final int f4656oU = 200;

    /* JADX INFO: renamed from: ly */
    private static final float f4657ly = 64.0f;

    /* JADX INFO: renamed from: aD */
    @NotNull
    public List<C0893qF> f4659aD;

    /* JADX INFO: renamed from: oV */
    public int f4660oV;

    /* JADX INFO: renamed from: oW */
    private int f4661oW;

    /* JADX INFO: renamed from: oX */
    private int f4662oX;

    /* JADX INFO: renamed from: oY */
    private int f4663oY;

    /* JADX INFO: renamed from: oZ */
    private int f4664oZ;

    /* JADX INFO: renamed from: t */
    private long f4665t;

    /* JADX INFO: renamed from: pa */
    private int f4666pa;

    /* JADX INFO: renamed from: lz */
    private float f4667lz;

    /* JADX INFO: renamed from: b */
    @Nullable
    private RandomCollection<C0893qF> f4668b;

    /* JADX INFO: renamed from: a */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0503in[] f4669a;

    /* JADX INFO: renamed from: b */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0503in[] f4670b;

    /* JADX INFO: renamed from: c */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0503in[] f4671c;

    /* JADX INFO: renamed from: d */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0503in[] f4672d;

    /* JADX INFO: renamed from: b */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0511iv f4673b;

    /* JADX INFO: renamed from: c */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0511iv f4674c;

    /* JADX INFO: renamed from: d */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0511iv f4675d;

    /* JADX INFO: renamed from: e */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0511iv f4676e;

    /* JADX INFO: renamed from: u */
    private int[] f4677u;

    /* JADX INFO: renamed from: v */
    private int[] f4678v;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final EnumMap<EnumC0874pn, AbstractC0056aa> f4679c;

    /* JADX INFO: renamed from: eK */
    @NotNull
    private static final ResourceLocation f4651eK = C0564jv.m2555d("textures/misc/debug/mapeffect/weather.png");

    /* JADX INFO: renamed from: l */
    private static final Vector3f f4652l = new Vector3f();

    /* JADX INFO: renamed from: a */
    private static final Vec3[] f4655a = {new Vec3(16.0d, 0.0d, 0.0d), new Vec3(-8.0d, 0.0d, (16.0d * Math.sqrt(3.0d)) / 2.0d), new Vec3(-8.0d, 0.0d, ((-16.0d) * Math.sqrt(3.0d)) / 2.0d)};

    /* JADX INFO: renamed from: Q */
    @NotNull
    public static final MapCodec<C0892qE> f4658Q = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(C0893qF.f4681K.listOf().optionalFieldOf("entries", List.of()).forGetter(c0892qE -> {
            return c0892qE.f4659aD;
        }), Codec.INT.optionalFieldOf("transitionTicks", 200).forGetter(c0892qE2 -> {
            return Integer.valueOf(c0892qE2.f4660oV);
        })).apply(instance, (v1, v2) -> {
            return new C0892qE(v1, v2);
        });
    });

    public C0892qE() {
        this.f4659aD = new ObjectArrayList();
        this.f4660oV = 200;
        this.f4661oW = -1;
        this.f4662oX = -1;
        this.f4663oY = 0;
        this.f4664oZ = 0;
        this.f4665t = 0L;
        this.f4666pa = 0;
        this.f4667lz = -1.0f;
        this.f4677u = new int[0];
        this.f4678v = new int[0];
        this.f4679c = new EnumMap<>(EnumC0874pn.class);
    }

    public C0892qE(@NotNull List<C0893qF> list, int i) {
        this.f4659aD = new ObjectArrayList();
        this.f4660oV = 200;
        this.f4661oW = -1;
        this.f4662oX = -1;
        this.f4663oY = 0;
        this.f4664oZ = 0;
        this.f4665t = 0L;
        this.f4666pa = 0;
        this.f4667lz = -1.0f;
        this.f4677u = new int[0];
        this.f4678v = new int[0];
        this.f4679c = new EnumMap<>(EnumC0874pn.class);
        this.f4659aD = new ObjectArrayList(list);
        this.f4660oV = i;
    }

    /* JADX INFO: renamed from: cD */
    private void m4488cD() {
        RandomCollection<C0893qF> randomCollection = new RandomCollection<>();
        for (C0893qF c0893qF : this.f4659aD) {
            if (c0893qF.f4682ad > 0.0d) {
                randomCollection.add(c0893qF.f4682ad, c0893qF);
            }
        }
        this.f4668b = randomCollection;
    }

    /* JADX INFO: renamed from: a */
    private int m4489a(@NotNull C0893qF c0893qF) {
        int size = this.f4659aD.size();
        for (int i = 0; i < size; i++) {
            if (this.f4659aD.get(i) == c0893qF) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    private int m4490a(@NotNull RandomSource randomSource) {
        if (this.f4668b == null) {
            m4488cD();
        }
        if (this.f4668b == null || this.f4668b.isEmpty()) {
            return -1;
        }
        return m4489a(this.f4668b.getRandom(randomSource.nextDouble()));
    }

    /* JADX INFO: renamed from: a */
    private int m4491a(@NotNull RandomSource randomSource, int i) {
        if (this.f4668b == null) {
            m4488cD();
        }
        if (this.f4668b == null || this.f4668b.isEmpty()) {
            return -1;
        }
        if (i < 0) {
            return m4489a(this.f4668b.getRandom(randomSource.nextDouble()));
        }
        for (int i2 = 0; i2 < 8; i2++) {
            int iM4489a = m4489a(this.f4668b.getRandom(randomSource.nextDouble()));
            if (iM4489a != i) {
                return iM4489a;
            }
        }
        for (int i3 = 1; i3 < this.f4659aD.size(); i3++) {
            int size = (i + i3) % this.f4659aD.size();
            if (size != i) {
                return size;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    private int m4492a(@NotNull C0893qF c0893qF, @NotNull RandomSource randomSource) {
        return c0893qF.m4569b(randomSource.nextDouble());
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4218a(@NotNull Minecraft minecraft, @NotNull C1018sY c1018sY) {
        super.mo4218a(minecraft, c1018sY);
        c1018sY.m5594a((InterfaceC0841pG) this);
        c1018sY.m5596a((InterfaceC0839pE) this);
        c1018sY.m5598a((InterfaceC0846pL) this);
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
        if (this.f4659aD.isEmpty()) {
            return;
        }
        if (this.f4661oW == -1) {
            this.f4661oW = 0;
            this.f4665t = serverLevel.getGameTime() + ((long) m4492a(this.f4659aD.get(this.f4661oW), randomSource));
            this.f4666pa = 0;
        }
        long gameTime = serverLevel.getGameTime();
        this.f4666pa++;
        if (this.f4662oX == -1 && gameTime >= this.f4665t - ((long) this.f4660oV) && this.f4659aD.size() > 1) {
            this.f4662oX = m4490a(randomSource);
            this.f4664oZ = this.f4660oV;
            this.f4663oY = 0;
            C1194vo.m6651a(new C1238wf(this.f4463y, this.f4662oX, this.f4664oZ), abstractC0787oF);
        }
        if (this.f4662oX >= 0) {
            this.f4663oY++;
            if (this.f4663oY >= this.f4664oZ) {
                this.f4661oW = this.f4662oX;
                this.f4662oX = -1;
                this.f4663oY = 0;
                this.f4664oZ = 0;
                this.f4665t = gameTime + ((long) m4492a(this.f4659aD.get(this.f4661oW), randomSource));
                this.f4666pa = 0;
            }
        }
        m4493cE();
    }

    /* JADX INFO: renamed from: cE */
    private void m4493cE() {
        C0893qF c0893qF;
        float fClamp;
        if (this.f4661oW < 0 || this.f4661oW >= this.f4659aD.size()) {
            this.f4667lz = -1.0f;
            return;
        }
        C0893qF c0893qF2 = this.f4659aD.get(this.f4661oW);
        if (this.f4662oX >= 0 && this.f4662oX < this.f4659aD.size()) {
            c0893qF = this.f4659aD.get(this.f4662oX);
        } else {
            c0893qF = null;
        }
        C0893qF c0893qF3 = c0893qF;
        Float fM4613x = c0893qF2.f4699a.m4613x();
        Float fM4613x2 = c0893qF3 != null ? c0893qF3.f4699a.m4613x() : null;
        if (fM4613x == null && fM4613x2 == null) {
            this.f4667lz = -1.0f;
            return;
        }
        if (c0893qF3 != null && this.f4664oZ > 0) {
            fClamp = Mth.clamp(this.f4663oY / this.f4664oZ, 0.0f, 1.0f);
        } else {
            fClamp = 0.0f;
        }
        float f = fClamp;
        float fFloatValue = fM4613x != null ? fM4613x.floatValue() : 64.0f;
        float fLerp = c0893qF3 != null ? Mth.lerp(f, fFloatValue, fM4613x2 != null ? fM4613x2.floatValue() : 64.0f) : fFloatValue;
        this.f4667lz = fLerp >= 64.0f ? -1.0f : fLerp;
    }

    @Override // com.boehmod.blockfront.InterfaceC0838pD
    /* JADX INFO: renamed from: aN */
    public float mo4264aN() {
        return this.f4667lz;
    }

    /* JADX INFO: renamed from: a */
    public boolean m4494a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource) {
        if (this.f4659aD.size() < 2 || this.f4661oW == -1 || this.f4662oX != -1) {
            return false;
        }
        this.f4662oX = m4491a(randomSource, this.f4661oW);
        if (this.f4662oX == -1) {
            return false;
        }
        this.f4664oZ = this.f4660oV;
        this.f4663oY = 0;
        C1194vo.m6651a(new C1238wf(this.f4463y, this.f4662oX, this.f4664oZ), abstractC0787oF);
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4220a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        C0893qF c0893qF;
        float fClamp;
        if (this.f4659aD.isEmpty() || this.f4661oW < 0 || this.f4661oW >= this.f4659aD.size()) {
            return;
        }
        this.f4666pa++;
        if (this.f4662oX >= 0) {
            this.f4663oY++;
            if (this.f4663oY >= this.f4664oZ) {
                m4499F(minecraft);
            }
        }
        C0893qF c0893qF2 = this.f4659aD.get(this.f4661oW);
        if (this.f4662oX >= 0 && this.f4662oX < this.f4659aD.size()) {
            c0893qF = this.f4659aD.get(this.f4662oX);
        } else {
            c0893qF = null;
        }
        C0893qF c0893qF3 = c0893qF;
        if (c0893qF3 != null && this.f4664oZ > 0) {
            fClamp = Mth.clamp(this.f4663oY / this.f4664oZ, 0.0f, 1.0f);
        } else {
            fClamp = 0.0f;
        }
        float f2 = fClamp;
        m4501a(abstractC0787oF.m3653a(), c0893qF2, c0893qF3, f2);
        m4502a(minecraft, c0622l, abstractC0787oF, clientLevel, localPlayer, c0893qF2, c0893qF3, f2);
        m4509a(minecraft, c0622l, clientLevel, localPlayer, c0893qF2, c0893qF3, f2, randomSource);
        m4495a(minecraft, c0622l, clientLevel, localPlayer, randomSource, c0893qF2, c0893qF3, f2);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m4495a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull RandomSource randomSource, @NotNull C0893qF c0893qF, @Nullable C0893qF c0893qF2, float f) {
        Entity cameraEntity = minecraft.getCameraEntity();
        Vec3 vec3Position = cameraEntity != null ? cameraEntity.position() : localPlayer.position();
        BlockPos blockPosBlockPosition = cameraEntity != null ? cameraEntity.blockPosition() : localPlayer.blockPosition();
        List<EnumC0874pn> listM4608N = c0893qF.f4699a.m4608N();
        List<EnumC0874pn> listM4608N2 = c0893qF2 != null ? c0893qF2.f4699a.m4608N() : List.of();
        Iterator it = this.f4679c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            EnumC0874pn enumC0874pn = (EnumC0874pn) entry.getKey();
            if (!listM4608N.contains(enumC0874pn) && !listM4608N2.contains(enumC0874pn)) {
                ((AbstractC0056aa) entry.getValue()).mo227c(minecraft, c0622l);
                it.remove();
            }
        }
        float f2 = c0893qF2 != null ? 1.0f - f : 1.0f;
        for (EnumC0874pn enumC0874pn2 : listM4608N) {
            m4496a(minecraft, c0622l, clientLevel, randomSource, vec3Position, blockPosBlockPosition, enumC0874pn2, listM4608N2.contains(enumC0874pn2) ? 1.0f : f2);
        }
        for (EnumC0874pn enumC0874pn3 : listM4608N2) {
            if (!listM4608N.contains(enumC0874pn3)) {
                m4496a(minecraft, c0622l, clientLevel, randomSource, vec3Position, blockPosBlockPosition, enumC0874pn3, f);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m4496a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @NotNull EnumC0874pn enumC0874pn, float f) {
        AbstractC0056aa abstractC0056aa = (AbstractC0056aa) this.f4679c.computeIfAbsent(enumC0874pn, C0057ab::m229a);
        if (abstractC0056aa == null) {
            return;
        }
        abstractC0056aa.mo225a(minecraft, c0622l, clientLevel, randomSource, vec3, blockPos, f);
    }

    @Override // com.boehmod.blockfront.InterfaceC0846pL
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4279a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        C0893qF c0893qF;
        float fClamp;
        if (this.f4659aD.isEmpty() || this.f4661oW < 0 || this.f4661oW >= this.f4659aD.size()) {
            return;
        }
        C0893qF c0893qF2 = this.f4659aD.get(this.f4661oW);
        if (this.f4662oX >= 0 && this.f4662oX < this.f4659aD.size()) {
            c0893qF = this.f4659aD.get(this.f4662oX);
        } else {
            c0893qF = null;
        }
        C0893qF c0893qF3 = c0893qF;
        if (c0893qF3 != null && this.f4664oZ > 0) {
            fClamp = Mth.clamp(this.f4663oY / this.f4664oZ, 0.0f, 1.0f);
        } else {
            fClamp = 0.0f;
        }
        float f2 = fClamp;
        List<EnumC0874pn> listM4608N = c0893qF2.f4699a.m4608N();
        List<EnumC0874pn> listM4608N2 = c0893qF3 != null ? c0893qF3.f4699a.m4608N() : List.of();
        float f3 = c0893qF3 != null ? 1.0f - f2 : 1.0f;
        for (EnumC0874pn enumC0874pn : listM4608N) {
            m4497a(minecraft, c0622l, guiGraphics, i, i2, f, enumC0874pn, listM4608N2.contains(enumC0874pn) ? 1.0f : f3);
        }
        for (EnumC0874pn enumC0874pn2 : listM4608N2) {
            if (!listM4608N.contains(enumC0874pn2)) {
                m4497a(minecraft, c0622l, guiGraphics, i, i2, f, enumC0874pn2, f2);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m4497a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, @NotNull EnumC0874pn enumC0874pn, float f2) {
        AbstractC0056aa abstractC0056aa;
        if (f2 > 0.0f && (abstractC0056aa = this.f4679c.get(enumC0874pn)) != null) {
            abstractC0056aa.mo226a(minecraft, c0622l, guiGraphics, i, i2, f, f2);
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0839pE
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4265a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, int i, @NotNull PoseStack poseStack, @NotNull Matrix4f matrix4f, @NotNull Matrix4f matrix4f2, float f, double d, double d2, double d3) {
        C0893qF c0893qF;
        float fClamp;
        if (this.f4659aD.isEmpty() || this.f4661oW < 0 || this.f4661oW >= this.f4659aD.size()) {
            return;
        }
        C0893qF c0893qF2 = this.f4659aD.get(this.f4661oW);
        if (this.f4662oX >= 0 && this.f4662oX < this.f4659aD.size()) {
            c0893qF = this.f4659aD.get(this.f4662oX);
        } else {
            c0893qF = null;
        }
        C0893qF c0893qF3 = c0893qF;
        if (c0893qF3 != null && this.f4664oZ > 0) {
            fClamp = Mth.clamp(this.f4663oY / this.f4664oZ, 0.0f, 1.0f);
        } else {
            fClamp = 0.0f;
        }
        float f2 = fClamp;
        C0392gi c0392giM4611a = c0893qF2.f4699a.m4611a();
        C0392gi c0392giM4611a2 = c0893qF3 != null ? c0893qF3.f4699a.m4611a() : null;
        if (c0392giM4611a != null && c0392giM4611a.equals(c0392giM4611a2)) {
            C0390gg.m1871a(c0392giM4611a, minecraft, clientLevel, i, poseStack, matrix4f, matrix4f2, f, d, d2, d3, 1.0f);
            return;
        }
        float f3 = c0893qF3 != null ? 1.0f - f2 : 1.0f;
        if (c0392giM4611a != null) {
            C0390gg.m1871a(c0392giM4611a, minecraft, clientLevel, i, poseStack, matrix4f, matrix4f2, f, d, d2, d3, f3);
        }
        if (c0392giM4611a2 != null) {
            C0390gg.m1871a(c0392giM4611a2, minecraft, clientLevel, i, poseStack, matrix4f, matrix4f2, f, d, d2, d3, f2);
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0841pG
    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: a */
    public Vector3f mo4267a(float f, float f2) {
        C0893qF c0893qF;
        float fClamp;
        Vector3f vector3f = new Vector3f();
        if (this.f4659aD.isEmpty() || this.f4661oW < 0 || this.f4661oW >= this.f4659aD.size()) {
            return vector3f;
        }
        C0893qF c0893qF2 = this.f4659aD.get(this.f4661oW);
        if (this.f4662oX >= 0 && this.f4662oX < this.f4659aD.size()) {
            c0893qF = this.f4659aD.get(this.f4662oX);
        } else {
            c0893qF = null;
        }
        C0893qF c0893qF3 = c0893qF;
        if (c0893qF3 != null && this.f4664oZ > 0) {
            fClamp = Mth.clamp(this.f4663oY / this.f4664oZ, 0.0f, 1.0f);
        } else {
            fClamp = 0.0f;
        }
        float f3 = fClamp;
        m4498a(vector3f, c0893qF2, f, f2, c0893qF3 != null ? 1.0f - f3 : 1.0f);
        if (c0893qF3 != null) {
            m4498a(vector3f, c0893qF3, f, f2, f3);
        }
        return vector3f;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private static void m4498a(@NotNull Vector3f vector3f, @NotNull C0893qF c0893qF, float f, float f2, float f3) {
        if (f3 <= 0.0f) {
            return;
        }
        C0329fY c0329fYM4609a = c0893qF.f4699a.m4609a();
        if (c0329fYM4609a != null) {
            float f4 = f3 * (1.0f - f2);
            if (f4 > 0.0f) {
                vector3f.add(c0329fYM4609a.m1694a(f, 1.0f, f4652l).mul(f4));
            }
        }
        C0329fY c0329fYM4610b = c0893qF.f4699a.m4610b();
        if (c0329fYM4610b != null) {
            float f5 = f3 * f2;
            if (f5 > 0.0f) {
                vector3f.add(c0329fYM4610b.m1694a(f, 1.0f, f4652l).mul(f5));
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: F */
    private void m4499F(@NotNull Minecraft minecraft) {
        m4508a(minecraft, this.f4669a);
        m4508a(minecraft, this.f4670b);
        this.f4669a = this.f4671c;
        this.f4670b = this.f4672d;
        this.f4671c = null;
        this.f4672d = null;
        m4507a(minecraft, this.f4673b);
        m4507a(minecraft, this.f4674c);
        this.f4673b = this.f4675d;
        this.f4674c = this.f4676e;
        this.f4675d = null;
        this.f4676e = null;
        this.f4661oW = this.f4662oX;
        this.f4662oX = -1;
        this.f4663oY = 0;
        this.f4664oZ = 0;
        this.f4666pa = 0;
        this.f4677u = this.f4678v;
        this.f4678v = new int[0];
    }

    /* JADX INFO: renamed from: a */
    private static int m4500a(int i, int i2, float f) {
        return (i & (-16777216)) | (Mth.clamp((int) Mth.lerp(f, (i >> 16) & 255, (i2 >> 16) & 255), 0, 255) << 16) | (Mth.clamp((int) Mth.lerp(f, (i >> 8) & 255, (i2 >> 8) & 255), 0, 255) << 8) | Mth.clamp((int) Mth.lerp(f, i & 255, i2 & 255), 0, 255);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private static void m4501a(@NotNull C1018sY c1018sY, @NotNull C0893qF c0893qF, @Nullable C0893qF c0893qF2, float f) {
        boolean z = c0893qF.f4689gx;
        boolean z2 = c0893qF2 != null && c0893qF2.f4689gx;
        if (z && z2) {
            c1018sY.m5630c(m4500a(c0893qF.f4690pd, c0893qF2.f4690pd, f), 1.0f);
        } else if (z) {
            c1018sY.m5630c(c0893qF.f4690pd, 1.0f - f);
        } else if (z2) {
            c1018sY.m5630c(c0893qF2.f4690pd, f);
        } else {
            c1018sY.m5631dd();
        }
        boolean z3 = c0893qF.f4691gy;
        boolean z4 = c0893qF2 != null && c0893qF2.f4691gy;
        if (z3 && z4) {
            c1018sY.m5646b(Mth.lerp(f, c0893qF.f4692lA, c0893qF2.f4692lA), Mth.lerp(f, c0893qF.f4693lB, c0893qF2.f4693lB), 1.0f);
        } else if (z3) {
            c1018sY.m5646b(c0893qF.f4692lA, c0893qF.f4693lB, 1.0f - f);
        } else if (z4) {
            c1018sY.m5646b(c0893qF2.f4692lA, c0893qF2.f4693lB, f);
        } else {
            c1018sY.m5647dg();
        }
        boolean z5 = c0893qF.f4694gz;
        boolean z6 = c0893qF2 != null && c0893qF2.f4694gz;
        if (z5 && z6) {
            c1018sY.m5622b(m4500a(c0893qF.f4695pe, c0893qF2.f4695pe, f), 1.0f);
        } else if (z5) {
            c1018sY.m5622b(c0893qF.f4695pe, 1.0f - f);
        } else if (z6) {
            c1018sY.m5622b(c0893qF2.f4695pe, f);
        } else {
            c1018sY.m5623dc();
        }
        boolean z7 = c0893qF.f4696gA;
        boolean z8 = c0893qF2 != null && c0893qF2.f4696gA;
        if (z7 && z8) {
            c1018sY.m5635d(m4500a(c0893qF.f4697pf, c0893qF2.f4697pf, f), 1.0f);
        } else if (z7) {
            c1018sY.m5635d(c0893qF.f4697pf, 1.0f - f);
        } else if (z8) {
            c1018sY.m5635d(c0893qF2.f4697pf, f);
        } else {
            c1018sY.m5636de();
        }
        Float fM4612w = c0893qF.f4699a.m4612w();
        Float fM4612w2 = c0893qF2 != null ? c0893qF2.f4699a.m4612w() : null;
        if (fM4612w != null || fM4612w2 != null) {
            float fFloatValue = fM4612w != null ? fM4612w.floatValue() : 0.0f;
            float fLerp = c0893qF2 != null ? Mth.lerp(f, fFloatValue, fM4612w2 != null ? fM4612w2.floatValue() : 0.0f) : fFloatValue;
            if (fLerp > 0.0f) {
                c1018sY.m5640o(fLerp);
                return;
            } else {
                c1018sY.m5641df();
                return;
            }
        }
        c1018sY.m5641df();
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m4502a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull C0893qF c0893qF, @Nullable C0893qF c0893qF2, float f) {
        float fM2234O = c0622l.m2683a().m2234O();
        float f2 = c0893qF2 != null ? 1.0f - f : 1.0f;
        float f3 = c0893qF2 != null ? f : 0.0f;
        float f4 = !C0799oR.m3916a((Level) clientLevel, localPlayer.getBlockX(), localPlayer.getBlockZ(), localPlayer.getBlockY()) ? fM2234O : 0.0f;
        this.f4669a = m4503a(minecraft, abstractC0787oF, c0622l, this.f4669a, c0893qF.f4685r);
        this.f4670b = m4503a(minecraft, abstractC0787oF, c0622l, this.f4670b, c0893qF.f4686s);
        m4504a(this.f4669a, f2 * (1.0f - fM2234O));
        m4504a(this.f4670b, f2 * fM2234O);
        this.f4673b = m4505a(minecraft, this.f4673b, c0893qF.f4687t);
        this.f4674c = m4505a(minecraft, this.f4674c, c0893qF.f4688u);
        m4506a(this.f4673b, f2 * (1.0f - fM2234O));
        m4506a(this.f4674c, f2 * f4);
        if (c0893qF2 != null) {
            this.f4671c = m4503a(minecraft, abstractC0787oF, c0622l, this.f4671c, c0893qF2.f4685r);
            this.f4672d = m4503a(minecraft, abstractC0787oF, c0622l, this.f4672d, c0893qF2.f4686s);
            m4504a(this.f4671c, f3 * (1.0f - fM2234O));
            m4504a(this.f4672d, f3 * fM2234O);
            this.f4675d = m4505a(minecraft, this.f4675d, c0893qF2.f4687t);
            this.f4676e = m4505a(minecraft, this.f4676e, c0893qF2.f4688u);
            m4506a(this.f4675d, f3 * (1.0f - fM2234O));
            m4506a(this.f4676e, f3 * f4);
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Nullable
    /* JADX INFO: renamed from: a */
    private static C0503in[] m4503a(@NotNull Minecraft minecraft, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull C0622l c0622l, @Nullable C0503in[] c0503inArr, @NotNull Supplier<SoundEvent> supplier) {
        if (c0503inArr != null) {
            return c0503inArr;
        }
        SoundEvent soundEvent = supplier.get();
        if (soundEvent == null) {
            return null;
        }
        C0867pg c0867pgM2698a = c0622l.m2698a();
        SoundManager soundManager = minecraft.getSoundManager();
        C0503in[] c0503inArr2 = new C0503in[3];
        for (int i = 0; i < 3; i++) {
            C0503in c0503in = new C0503in(minecraft, abstractC0787oF, soundEvent, SoundSource.AMBIENT, f4655a[i], 0.7f + (i * 0.25f), c0867pgM2698a, i);
            soundManager.play(c0503in);
            c0503inArr2[i] = c0503in;
        }
        return c0503inArr2;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private static void m4504a(@Nullable C0503in[] c0503inArr, float f) {
        if (c0503inArr == null) {
            return;
        }
        for (C0503in c0503in : c0503inArr) {
            if (c0503in != null) {
                c0503in.m2246h(f);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Nullable
    /* JADX INFO: renamed from: a */
    private static C0511iv m4505a(@NotNull Minecraft minecraft, @Nullable C0511iv c0511iv, @NotNull Supplier<SoundEvent> supplier) {
        if (c0511iv != null) {
            return c0511iv;
        }
        SoundEvent soundEvent = supplier.get();
        if (soundEvent == null) {
            return null;
        }
        C0511iv c0511iv2 = new C0511iv(soundEvent);
        minecraft.getSoundManager().play(c0511iv2);
        return c0511iv2;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private static void m4506a(@Nullable C0511iv c0511iv, float f) {
        if (c0511iv != null) {
            c0511iv.m2253h(f);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private static void m4507a(@NotNull Minecraft minecraft, @Nullable C0511iv c0511iv) {
        if (c0511iv != null) {
            minecraft.getSoundManager().stop(c0511iv);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private static void m4508a(@NotNull Minecraft minecraft, @Nullable C0503in[] c0503inArr) {
        if (c0503inArr == null) {
            return;
        }
        SoundManager soundManager = minecraft.getSoundManager();
        for (C0503in c0503in : c0503inArr) {
            if (c0503in != null) {
                soundManager.stop(c0503in);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m4509a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull C0893qF c0893qF, @Nullable C0893qF c0893qF2, float f, @NotNull RandomSource randomSource) {
        this.f4677u = m4510a(minecraft, c0622l, clientLevel, localPlayer, c0893qF, this.f4677u, c0893qF2 != null ? 1.0f - f : 1.0f, randomSource);
        if (c0893qF2 != null) {
            this.f4678v = m4510a(minecraft, c0622l, clientLevel, localPlayer, c0893qF2, this.f4678v, f, randomSource);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:97:0x00d5  */
    @net.neoforged.api.distmarker.OnlyIn(net.neoforged.api.distmarker.Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int[] m4510a(@org.jetbrains.annotations.NotNull net.minecraft.client.Minecraft r7, @org.jetbrains.annotations.NotNull com.boehmod.blockfront.C0622l r8, @org.jetbrains.annotations.NotNull net.minecraft.client.multiplayer.ClientLevel r9, @org.jetbrains.annotations.NotNull net.minecraft.client.player.LocalPlayer r10, @org.jetbrains.annotations.NotNull com.boehmod.blockfront.C0893qF r11, int[] r12, float r13, @org.jetbrains.annotations.NotNull net.minecraft.util.RandomSource r14) {
        /*
            Method dump skipped, instruction units count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.boehmod.blockfront.C0892qE.m4510a(net.minecraft.client.Minecraft, com.boehmod.blockfront.l, net.minecraft.client.multiplayer.ClientLevel, net.minecraft.client.player.LocalPlayer, com.boehmod.blockfront.qF, int[], float, net.minecraft.util.RandomSource):int[]");
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m4511a(int i, int i2) {
        if (i < 0 || i >= this.f4659aD.size()) {
            return;
        }
        this.f4662oX = i;
        this.f4664oZ = i2;
        this.f4663oY = 0;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m4512a(int i, int i2, int i3, int i4) {
        boolean z = this.f4661oW != i;
        this.f4661oW = i;
        this.f4662oX = i2;
        this.f4663oY = i3;
        this.f4664oZ = i4;
        if (z) {
            this.f4666pa = 0;
        }
        if (this.f4661oW >= 0 && this.f4661oW < this.f4659aD.size()) {
            this.f4677u = new int[this.f4659aD.get(this.f4661oW).f4698aE.size()];
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0845pK
    /* JADX INFO: renamed from: h */
    public void mo4277h(@NotNull ByteBuf byteBuf) {
        byteBuf.writeInt(this.f4661oW);
        byteBuf.writeInt(this.f4662oX);
        byteBuf.writeInt(this.f4663oY);
        byteBuf.writeInt(this.f4664oZ);
    }

    @Override // com.boehmod.blockfront.InterfaceC0845pK
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: g */
    public void mo4278g(@NotNull ByteBuf byteBuf) {
        m4512a(byteBuf.readInt(), byteBuf.readInt(), byteBuf.readInt(), byteBuf.readInt());
    }

    @Override // com.boehmod.blockfront.InterfaceC0842pH
    /* JADX INFO: renamed from: a */
    public void mo4268a(@NotNull ServerLevel serverLevel, @NotNull RandomSource randomSource) {
        if (this.f4661oW != -1 || this.f4659aD.isEmpty()) {
            return;
        }
        this.f4661oW = 0;
        this.f4665t = serverLevel.getGameTime() + ((long) m4492a(this.f4659aD.get(this.f4661oW), randomSource));
        this.f4666pa = 0;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        list.add(Component.literal("Entries: " + this.f4659aD.size()));
        list.add(Component.literal("Transition Ticks: " + this.f4660oV));
        list.add(Component.literal("Current Index: " + this.f4661oW));
        list.add(Component.literal("Next Index: " + this.f4662oX));
        if (this.f4662oX >= 0 && this.f4664oZ > 0) {
            list.add(Component.literal(String.format("Transition: %.1f%%", Float.valueOf((100.0f * this.f4663oY) / this.f4664oZ))).withStyle(ChatFormatting.GRAY));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4651eK;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo4227H());
        objectArrayList.add(new C0854pT(Component.literal("Transition Ticks"), () -> {
            return Integer.valueOf(this.f4660oV);
        }, num -> {
            this.f4660oV = num.intValue();
        }, 0, 24000));
        for (int i = 0; i < this.f4659aD.size(); i++) {
            int i2 = i;
            C0893qF c0893qF = this.f4659aD.get(i);
            int i3 = AbstractC0851pQ.f4483t[i2 % AbstractC0851pQ.f4483t.length];
            objectArrayList.add(new C0853pS(Component.literal("Entry " + i2 + " Weight"), () -> {
                return Float.valueOf((float) c0893qF.f4682ad);
            }, f -> {
                c0893qF.f4682ad = f.floatValue();
            }, 0.0f, 100.0f).m4282a(i3));
            objectArrayList.add(new C0854pT(Component.literal("Entry " + i2 + " Min Duration"), () -> {
                return Integer.valueOf(c0893qF.f4683pb);
            }, num2 -> {
                c0893qF.f4683pb = num2.intValue();
            }, 0, 1000000).m4282a(i3));
            objectArrayList.add(new C0854pT(Component.literal("Entry " + i2 + " Max Duration"), () -> {
                return Integer.valueOf(c0893qF.f4684pc);
            }, num3 -> {
                c0893qF.f4684pc = num3.intValue();
            }, 0, 1000000).m4282a(i3));
            objectArrayList.add(new C0856pV(Component.literal("Entry " + i2 + " Interior Sound"), () -> {
                return c0893qF.f4685r.get();
            }, soundEvent -> {
                c0893qF.f4685r = soundEvent != null ? () -> {
                    return soundEvent;
                } : () -> {
                    return null;
                };
            }).m4282a(i3));
            objectArrayList.add(new C0856pV(Component.literal("Entry " + i2 + " Exterior Sound"), () -> {
                return c0893qF.f4686s.get();
            }, soundEvent2 -> {
                c0893qF.f4686s = soundEvent2 != null ? () -> {
                    return soundEvent2;
                } : () -> {
                    return null;
                };
            }).m4282a(i3));
            objectArrayList.add(new C0856pV(Component.literal("Entry " + i2 + " Player Interior Sound"), () -> {
                return c0893qF.f4687t.get();
            }, soundEvent3 -> {
                c0893qF.f4687t = soundEvent3 != null ? () -> {
                    return soundEvent3;
                } : () -> {
                    return null;
                };
            }).m4282a(i3));
            objectArrayList.add(new C0856pV(Component.literal("Entry " + i2 + " Player Exterior Sound"), () -> {
                return c0893qF.f4688u.get();
            }, soundEvent4 -> {
                c0893qF.f4688u = soundEvent4 != null ? () -> {
                    return soundEvent4;
                } : () -> {
                    return null;
                };
            }).m4282a(i3));
            objectArrayList.add(new C0849pO(Component.literal("Entry " + i2 + " Has Fog Color"), () -> {
                return Boolean.valueOf(c0893qF.f4689gx);
            }, bool -> {
                c0893qF.f4689gx = bool.booleanValue();
            }).m4282a(i3));
            objectArrayList.add(new C0850pP(Component.literal("Entry " + i2 + " Fog Color"), () -> {
                return Integer.valueOf(c0893qF.f4690pd);
            }, num4 -> {
                c0893qF.f4690pd = num4.intValue();
            }).m4282a(i3));
            objectArrayList.add(new C0849pO(Component.literal("Entry " + i2 + " Has Fog Density"), () -> {
                return Boolean.valueOf(c0893qF.f4691gy);
            }, bool2 -> {
                c0893qF.f4691gy = bool2.booleanValue();
            }).m4282a(i3));
            objectArrayList.add(new C0853pS(Component.literal("Entry " + i2 + " Near Fog Density"), () -> {
                return Float.valueOf(c0893qF.f4692lA);
            }, f2 -> {
                c0893qF.f4692lA = f2.floatValue();
            }, 0.0f, 1024.0f).m4282a(i3));
            objectArrayList.add(new C0853pS(Component.literal("Entry " + i2 + " Far Fog Density"), () -> {
                return Float.valueOf(c0893qF.f4693lB);
            }, f3 -> {
                c0893qF.f4693lB = f3.floatValue();
            }, 0.0f, 1024.0f).m4282a(i3));
            objectArrayList.add(new C0849pO(Component.literal("Entry " + i2 + " Has Sky Color"), () -> {
                return Boolean.valueOf(c0893qF.f4694gz);
            }, bool3 -> {
                c0893qF.f4694gz = bool3.booleanValue();
            }).m4282a(i3));
            objectArrayList.add(new C0850pP(Component.literal("Entry " + i2 + " Sky Color"), () -> {
                return Integer.valueOf(c0893qF.f4695pe);
            }, num5 -> {
                c0893qF.f4695pe = num5.intValue();
            }).m4282a(i3));
            objectArrayList.add(new C0849pO(Component.literal("Entry " + i2 + " Has Light Color"), () -> {
                return Boolean.valueOf(c0893qF.f4696gA);
            }, bool4 -> {
                c0893qF.f4696gA = bool4.booleanValue();
            }).m4282a(i3));
            objectArrayList.add(new C0850pP(Component.literal("Entry " + i2 + " Light Color"), () -> {
                return Integer.valueOf(c0893qF.f4697pf);
            }, num6 -> {
                c0893qF.f4697pf = num6.intValue();
            }).m4282a(i3));
            objectArrayList.add(new C0852pR(Component.literal("Entry " + i2 + " Weather Type"), EnumC0874pn.class, () -> {
                if (c0893qF.f4699a.m4608N().isEmpty()) {
                    return null;
                }
                return (EnumC0874pn) c0893qF.f4699a.m4608N().getFirst();
            }, enumC0874pn -> {
                c0893qF.f4699a = new C0894qG(List.of(enumC0874pn), c0893qF.f4699a.m4609a(), c0893qF.f4699a.m4610b(), c0893qF.f4699a.m4611a(), c0893qF.f4699a.m4612w(), c0893qF.f4699a.m4613x());
            }).m4282a(i3));
            objectArrayList.add(new C0853pS(Component.literal("Entry " + i2 + " Darkness"), () -> {
                return Float.valueOf(c0893qF.f4699a.m4612w() != null ? c0893qF.f4699a.m4612w().floatValue() : 0.0f);
            }, f4 -> {
                c0893qF.f4699a = new C0894qG(c0893qF.f4699a.m4608N(), c0893qF.f4699a.m4609a(), c0893qF.f4699a.m4610b(), c0893qF.f4699a.m4611a(), f4.floatValue() > 0.0f ? f4 : null, c0893qF.f4699a.m4613x());
            }, 0.0f, 1.0f).m4282a(i3));
            objectArrayList.add(new C0853pS(Component.literal("Entry " + i2 + " Bot View Distance"), () -> {
                return Float.valueOf(c0893qF.f4699a.m4613x() != null ? c0893qF.f4699a.m4613x().floatValue() : 0.0f);
            }, f5 -> {
                c0893qF.f4699a = new C0894qG(c0893qF.f4699a.m4608N(), c0893qF.f4699a.m4609a(), c0893qF.f4699a.m4610b(), c0893qF.f4699a.m4611a(), c0893qF.f4699a.m4612w(), f5.floatValue() > 0.0f ? f5 : null);
            }, 0.0f, 64.0f).m4282a(i3));
            objectArrayList.add(new C0847pM(Component.literal("Remove Entry " + i2), () -> {
                this.f4659aD.remove(i2);
                m4488cD();
            }).m4282a(i3));
        }
        objectArrayList.add(new C0847pM(Component.literal("Add Entry"), () -> {
            this.f4659aD.add(new C0893qF());
            m4488cD();
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: cA */
    public void mo4224cA() {
        super.mo4224cA();
        this.f4661oW = -1;
        this.f4662oX = -1;
        this.f4663oY = 0;
        this.f4664oZ = 0;
        this.f4665t = 0L;
        this.f4666pa = 0;
        this.f4667lz = -1.0f;
        this.f4668b = null;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4225a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.mo4225a(minecraft, randomSource);
        m4508a(minecraft, this.f4669a);
        m4508a(minecraft, this.f4670b);
        m4508a(minecraft, this.f4671c);
        m4508a(minecraft, this.f4672d);
        this.f4669a = null;
        this.f4670b = null;
        this.f4671c = null;
        this.f4672d = null;
        m4507a(minecraft, this.f4673b);
        m4507a(minecraft, this.f4674c);
        m4507a(minecraft, this.f4675d);
        m4507a(minecraft, this.f4676e);
        this.f4673b = null;
        this.f4674c = null;
        this.f4675d = null;
        this.f4676e = null;
        this.f4661oW = -1;
        this.f4662oX = -1;
        this.f4663oY = 0;
        this.f4664oZ = 0;
        this.f4666pa = 0;
        this.f4677u = new int[0];
        this.f4678v = new int[0];
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b != null) {
            Iterator<AbstractC0056aa> it = this.f4679c.values().iterator();
            while (it.hasNext()) {
                it.next().mo227c(minecraft, c0622lM2667b);
            }
        }
        this.f4679c.clear();
        C0390gg.m1872aL();
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: c */
    private static String m4513c(@NotNull List<EnumC0874pn> list) {
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
    /* JADX INFO: renamed from: a */
    private static String m4514a(@NotNull Supplier<SoundEvent> supplier) {
        SoundEvent soundEvent = supplier.get();
        return soundEvent == null ? "none" : soundEvent.getLocation().toString();
    }

    @Override // com.boehmod.blockfront.InterfaceC0840pF
    /* JADX INFO: renamed from: a */
    public void mo4266a(@NotNull C0622l c0622l, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull List<String> list) {
        C0893qF c0893qF;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        list.add("");
        list.add("Weather:");
        if (this.f4659aD.isEmpty() || this.f4661oW < 0 || this.f4661oW >= this.f4659aD.size()) {
            list.add(String.valueOf(ChatFormatting.GRAY) + "(no entry active)");
            return;
        }
        C1018sY c1018sYM3653a = abstractC0787oF.m3653a();
        float fM2234O = c0622l.m2683a().m2234O();
        C0893qF c0893qF2 = this.f4659aD.get(this.f4661oW);
        if (this.f4662oX >= 0 && this.f4662oX < this.f4659aD.size()) {
            c0893qF = this.f4659aD.get(this.f4662oX);
        } else {
            c0893qF = null;
        }
        C0893qF c0893qF3 = c0893qF;
        if (c0893qF3 != null && this.f4664oZ > 0) {
            list.add("Entry: " + String.valueOf(ChatFormatting.GRAY) + this.f4661oW + String.valueOf(ChatFormatting.WHITE) + " -> " + String.valueOf(ChatFormatting.GRAY) + this.f4662oX + String.valueOf(ChatFormatting.WHITE) + " of " + String.valueOf(ChatFormatting.GRAY) + this.f4659aD.size());
            list.add("Transition: " + String.valueOf(ChatFormatting.GRAY) + String.format("%.1f%%", Float.valueOf((100.0f * this.f4663oY) / this.f4664oZ)) + String.valueOf(ChatFormatting.WHITE) + " (" + this.f4663oY + "/" + this.f4664oZ + "t)");
        } else {
            list.add("Entry: " + String.valueOf(ChatFormatting.GRAY) + this.f4661oW + String.valueOf(ChatFormatting.WHITE) + " of " + String.valueOf(ChatFormatting.GRAY) + this.f4659aD.size());
        }
        list.add("Active: " + String.valueOf(ChatFormatting.GRAY) + this.f4666pa + "t" + String.valueOf(ChatFormatting.WHITE) + " (range " + String.valueOf(ChatFormatting.GRAY) + c0893qF2.f4683pb + "-" + c0893qF2.f4684pc + "t" + String.valueOf(ChatFormatting.WHITE) + ")");
        list.add("Outdoor Alpha: " + String.valueOf(ChatFormatting.GRAY) + String.format("%.2f", Float.valueOf(fM2234O)));
        if (c1018sYM3653a.m5632bZ()) {
            str = "Fog Color: " + String.valueOf(ChatFormatting.GRAY) + String.format("#%06X @ %.2f", Integer.valueOf(c1018sYM3653a.m5633bQ() & ColorReferences.COLOR_WHITE), Float.valueOf(c1018sYM3653a.m5634aW()));
        } else {
            str = "Fog Color: " + String.valueOf(ChatFormatting.DARK_GRAY) + "off";
        }
        list.add(str);
        if (c1018sYM3653a.m5648cd()) {
            str2 = "Fog Density: " + String.valueOf(ChatFormatting.GRAY) + String.format("near=%.2f far=%.2f @ %.2f", Float.valueOf(c1018sYM3653a.m5650ba()), Float.valueOf(c1018sYM3653a.m5651bb()), Float.valueOf(c1018sYM3653a.m5649aZ()));
        } else {
            str2 = "Fog Density: " + String.valueOf(ChatFormatting.DARK_GRAY) + "off";
        }
        list.add(str2);
        if (c1018sYM3653a.m5624bX()) {
            str3 = "Sky Color: " + String.valueOf(ChatFormatting.GRAY) + String.format("#%06X @ %.2f", Integer.valueOf(c1018sYM3653a.m5625bO() & ColorReferences.COLOR_WHITE), Float.valueOf(c1018sYM3653a.m5626aV()));
        } else {
            str3 = "Sky Color: " + String.valueOf(ChatFormatting.DARK_GRAY) + "off";
        }
        list.add(str3);
        if (c1018sYM3653a.m5637ca()) {
            str4 = "Light Color: " + String.valueOf(ChatFormatting.GRAY) + String.format("#%06X @ %.2f", Integer.valueOf(c1018sYM3653a.m5638bR() & ColorReferences.COLOR_WHITE), Float.valueOf(c1018sYM3653a.m5639aX()));
        } else {
            str4 = "Light Color: " + String.valueOf(ChatFormatting.DARK_GRAY) + "off";
        }
        list.add(str4);
        if (c1018sYM3653a.m5643cb()) {
            str5 = "Darkness: " + String.valueOf(ChatFormatting.GRAY) + String.format("%.2f", Float.valueOf(c1018sYM3653a.m5642aY()));
        } else {
            str5 = "Darkness: " + String.valueOf(ChatFormatting.DARK_GRAY) + "off";
        }
        list.add(str5);
        list.add("Interior: " + String.valueOf(ChatFormatting.GRAY) + m4514a(c0893qF2.f4685r) + (c0893qF3 != null ? String.valueOf(ChatFormatting.WHITE) + " -> " + String.valueOf(ChatFormatting.GRAY) + m4514a(c0893qF3.f4685r) : ""));
        list.add("Exterior: " + String.valueOf(ChatFormatting.GRAY) + m4514a(c0893qF2.f4686s) + (c0893qF3 != null ? String.valueOf(ChatFormatting.WHITE) + " -> " + String.valueOf(ChatFormatting.GRAY) + m4514a(c0893qF3.f4686s) : ""));
        list.add("Weather Type: " + String.valueOf(ChatFormatting.GRAY) + m4513c(c0893qF2.f4699a.m4608N()) + (c0893qF3 != null ? String.valueOf(ChatFormatting.WHITE) + " -> " + String.valueOf(ChatFormatting.GRAY) + m4513c(c0893qF3.f4699a.m4608N()) : ""));
    }
}
