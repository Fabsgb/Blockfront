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

/* JADX INFO: renamed from: com.boehmod.blockfront.rb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rb.class */
public class C0969rb extends AbstractC0858pW implements InterfaceC0861pZ, InterfaceC0915qa, InterfaceC0916qb, InterfaceC0917qc, InterfaceC0918qd, InterfaceC0921qg, InterfaceC0922qh {

    /* JADX INFO: renamed from: qS */
    private static final int f5383qS = 3;

    /* JADX INFO: renamed from: mw */
    private static final float f5384mw = 16.0f;

    /* JADX INFO: renamed from: qT */
    private static final int f5386qT = 200;

    /* JADX INFO: renamed from: mx */
    private static final float f5387mx = 64.0f;

    /* JADX INFO: renamed from: aK */
    @NotNull
    public List<C0970rc> f5389aK;

    /* JADX INFO: renamed from: qU */
    public int f5390qU;

    /* JADX INFO: renamed from: qV */
    private int f5391qV;

    /* JADX INFO: renamed from: qW */
    private int f5392qW;

    /* JADX INFO: renamed from: qX */
    private int f5393qX;

    /* JADX INFO: renamed from: qY */
    private int f5394qY;

    /* JADX INFO: renamed from: O */
    private long f5395O;

    /* JADX INFO: renamed from: qZ */
    private int f5396qZ;

    /* JADX INFO: renamed from: my */
    private float f5397my;

    /* JADX INFO: renamed from: b */
    @Nullable
    private RandomCollection<C0970rc> f5398b;

    /* JADX INFO: renamed from: a */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0469iE[] f5399a;

    /* JADX INFO: renamed from: b */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0469iE[] f5400b;

    /* JADX INFO: renamed from: c */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0469iE[] f5401c;

    /* JADX INFO: renamed from: d */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0469iE[] f5402d;

    /* JADX INFO: renamed from: b */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0477iM f5403b;

    /* JADX INFO: renamed from: c */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0477iM f5404c;

    /* JADX INFO: renamed from: d */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0477iM f5405d;

    /* JADX INFO: renamed from: e */
    @OnlyIn(Dist.CLIENT)
    @Nullable
    private C0477iM f5406e;

    /* JADX INFO: renamed from: w */
    private int[] f5407w;

    /* JADX INFO: renamed from: x */
    private int[] f5408x;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final EnumMap<EnumC0845pJ, AbstractC0063ag> f5409c;

    /* JADX INFO: renamed from: eJ */
    @NotNull
    private static final ResourceLocation f5381eJ = C0532jO.m2378d("textures/misc/debug/mapeffect/weather.png");

    /* JADX INFO: renamed from: n */
    private static final Vector3f f5382n = new Vector3f();

    /* JADX INFO: renamed from: a */
    private static final Vec3[] f5385a = {new Vec3(16.0d, 0.0d, 0.0d), new Vec3(-8.0d, 0.0d, (16.0d * Math.sqrt(3.0d)) / 2.0d), new Vec3(-8.0d, 0.0d, ((-16.0d) * Math.sqrt(3.0d)) / 2.0d)};

    /* JADX INFO: renamed from: R */
    @NotNull
    public static final MapCodec<C0969rb> f5388R = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(C0970rc.f5411K.listOf().optionalFieldOf("entries", List.of()).forGetter(c0969rb -> {
            return c0969rb.f5389aK;
        }), Codec.INT.optionalFieldOf("transitionTicks", 200).forGetter(c0969rb2 -> {
            return Integer.valueOf(c0969rb2.f5390qU);
        })).apply(instance, (v1, v2) -> {
            return new C0969rb(v1, v2);
        });
    });

    public C0969rb() {
        this.f5389aK = new ObjectArrayList();
        this.f5390qU = 200;
        this.f5391qV = -1;
        this.f5392qW = -1;
        this.f5393qX = 0;
        this.f5394qY = 0;
        this.f5395O = 0L;
        this.f5396qZ = 0;
        this.f5397my = -1.0f;
        this.f5407w = new int[0];
        this.f5408x = new int[0];
        this.f5409c = new EnumMap<>(EnumC0845pJ.class);
    }

    public C0969rb(@NotNull List<C0970rc> list, int i) {
        this.f5389aK = new ObjectArrayList();
        this.f5390qU = 200;
        this.f5391qV = -1;
        this.f5392qW = -1;
        this.f5393qX = 0;
        this.f5394qY = 0;
        this.f5395O = 0L;
        this.f5396qZ = 0;
        this.f5397my = -1.0f;
        this.f5407w = new int[0];
        this.f5408x = new int[0];
        this.f5409c = new EnumMap<>(EnumC0845pJ.class);
        this.f5389aK = new ObjectArrayList(list);
        this.f5390qU = i;
    }

    /* JADX INFO: renamed from: cP */
    private void m5383cP() {
        RandomCollection<C0970rc> randomCollection = new RandomCollection<>();
        for (C0970rc c0970rc : this.f5389aK) {
            if (c0970rc.f5412al > 0.0d) {
                randomCollection.add(c0970rc.f5412al, c0970rc);
            }
        }
        this.f5398b = randomCollection;
    }

    /* JADX INFO: renamed from: a */
    private int m5384a(@NotNull C0970rc c0970rc) {
        int size = this.f5389aK.size();
        for (int i = 0; i < size; i++) {
            if (this.f5389aK.get(i) == c0970rc) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    private int m5385a(@NotNull RandomSource randomSource) {
        if (this.f5398b == null) {
            m5383cP();
        }
        if (this.f5398b == null || this.f5398b.isEmpty()) {
            return -1;
        }
        return m5384a(this.f5398b.getRandom(randomSource.nextDouble()));
    }

    /* JADX INFO: renamed from: a */
    private int m5386a(@NotNull RandomSource randomSource, int i) {
        if (this.f5398b == null) {
            m5383cP();
        }
        if (this.f5398b == null || this.f5398b.isEmpty()) {
            return -1;
        }
        if (i < 0) {
            return m5384a(this.f5398b.getRandom(randomSource.nextDouble()));
        }
        for (int i2 = 0; i2 < 8; i2++) {
            int iM5384a = m5384a(this.f5398b.getRandom(randomSource.nextDouble()));
            if (iM5384a != i) {
                return iM5384a;
            }
        }
        for (int i3 = 1; i3 < this.f5389aK.size(); i3++) {
            int size = (i + i3) % this.f5389aK.size();
            if (size != i) {
                return size;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    private int m5387a(@NotNull C0970rc c0970rc, @NotNull RandomSource randomSource) {
        return c0970rc.m5464b(randomSource.nextDouble());
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3953a(@NotNull Minecraft minecraft, @NotNull C1096tv c1096tv) {
        super.mo3953a(minecraft, c1096tv);
        c1096tv.m6082a((InterfaceC0917qc) this);
        c1096tv.m6084a((InterfaceC0915qa) this);
        c1096tv.m6086a((InterfaceC0922qh) this);
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
        if (this.f5389aK.isEmpty()) {
            return;
        }
        if (this.f5391qV == -1) {
            this.f5391qV = 0;
            this.f5395O = serverLevel.getGameTime() + ((long) m5387a(this.f5389aK.get(this.f5391qV), randomSource));
            this.f5396qZ = 0;
        }
        long gameTime = serverLevel.getGameTime();
        this.f5396qZ++;
        if (this.f5392qW == -1 && gameTime >= this.f5395O - ((long) this.f5390qU) && this.f5389aK.size() > 1) {
            this.f5392qW = m5385a(randomSource);
            this.f5394qY = this.f5390qU;
            this.f5393qX = 0;
            C1169vO.m6646a(new C1212wE(this.f4592y, this.f5392qW, this.f5394qY), abstractC0863pb);
        }
        if (this.f5392qW >= 0) {
            this.f5393qX++;
            if (this.f5393qX >= this.f5394qY) {
                this.f5391qV = this.f5392qW;
                this.f5392qW = -1;
                this.f5393qX = 0;
                this.f5394qY = 0;
                this.f5395O = gameTime + ((long) m5387a(this.f5389aK.get(this.f5391qV), randomSource));
                this.f5396qZ = 0;
            }
        }
        m5388cQ();
    }

    /* JADX INFO: renamed from: cQ */
    private void m5388cQ() {
        C0970rc c0970rc;
        float fClamp;
        if (this.f5391qV < 0 || this.f5391qV >= this.f5389aK.size()) {
            this.f5397my = -1.0f;
            return;
        }
        C0970rc c0970rc2 = this.f5389aK.get(this.f5391qV);
        if (this.f5392qW >= 0 && this.f5392qW < this.f5389aK.size()) {
            c0970rc = this.f5389aK.get(this.f5392qW);
        } else {
            c0970rc = null;
        }
        C0970rc c0970rc3 = c0970rc;
        Float fM5508E = c0970rc2.f5429a.m5508E();
        Float fM5508E2 = c0970rc3 != null ? c0970rc3.f5429a.m5508E() : null;
        if (fM5508E == null && fM5508E2 == null) {
            this.f5397my = -1.0f;
            return;
        }
        if (c0970rc3 != null && this.f5394qY > 0) {
            fClamp = Mth.clamp(this.f5393qX / this.f5394qY, 0.0f, 1.0f);
        } else {
            fClamp = 0.0f;
        }
        float f = fClamp;
        float fFloatValue = fM5508E != null ? fM5508E.floatValue() : 64.0f;
        float fLerp = c0970rc3 != null ? Mth.lerp(f, fFloatValue, fM5508E2 != null ? fM5508E2.floatValue() : 64.0f) : fFloatValue;
        this.f5397my = fLerp >= 64.0f ? -1.0f : fLerp;
    }

    @Override // com.boehmod.blockfront.InterfaceC0861pZ
    /* JADX INFO: renamed from: aT */
    public float mo3994aT() {
        return this.f5397my;
    }

    /* JADX INFO: renamed from: a */
    public boolean m5389a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource) {
        if (this.f5389aK.size() < 2 || this.f5391qV == -1 || this.f5392qW != -1) {
            return false;
        }
        this.f5392qW = m5386a(randomSource, this.f5391qV);
        if (this.f5392qW == -1) {
            return false;
        }
        this.f5394qY = this.f5390qU;
        this.f5393qX = 0;
        C1169vO.m6646a(new C1212wE(this.f4592y, this.f5392qW, this.f5394qY), abstractC0863pb);
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3933a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        C0970rc c0970rc;
        float fClamp;
        if (this.f5389aK.isEmpty() || this.f5391qV < 0 || this.f5391qV >= this.f5389aK.size()) {
            return;
        }
        this.f5396qZ++;
        if (this.f5392qW >= 0) {
            this.f5393qX++;
            if (this.f5393qX >= this.f5394qY) {
                m5394H(minecraft);
            }
        }
        C0970rc c0970rc2 = this.f5389aK.get(this.f5391qV);
        if (this.f5392qW >= 0 && this.f5392qW < this.f5389aK.size()) {
            c0970rc = this.f5389aK.get(this.f5392qW);
        } else {
            c0970rc = null;
        }
        C0970rc c0970rc3 = c0970rc;
        if (c0970rc3 != null && this.f5394qY > 0) {
            fClamp = Mth.clamp(this.f5393qX / this.f5394qY, 0.0f, 1.0f);
        } else {
            fClamp = 0.0f;
        }
        float f2 = fClamp;
        m5396a(abstractC0863pb.m4089a(), c0970rc2, c0970rc3, f2);
        m5397a(minecraft, c0623l, abstractC0863pb, clientLevel, localPlayer, c0970rc2, c0970rc3, f2);
        m5404a(minecraft, c0623l, clientLevel, localPlayer, c0970rc2, c0970rc3, f2, randomSource);
        m5390a(minecraft, c0623l, clientLevel, localPlayer, randomSource, c0970rc2, c0970rc3, f2);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m5390a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull RandomSource randomSource, @NotNull C0970rc c0970rc, @Nullable C0970rc c0970rc2, float f) {
        Entity cameraEntity = minecraft.getCameraEntity();
        Vec3 vec3Position = cameraEntity != null ? cameraEntity.position() : localPlayer.position();
        BlockPos blockPosBlockPosition = cameraEntity != null ? cameraEntity.blockPosition() : localPlayer.blockPosition();
        List<EnumC0845pJ> listM5503P = c0970rc.f5429a.m5503P();
        List<EnumC0845pJ> listM5503P2 = c0970rc2 != null ? c0970rc2.f5429a.m5503P() : List.of();
        Iterator it = this.f5409c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            EnumC0845pJ enumC0845pJ = (EnumC0845pJ) entry.getKey();
            if (!listM5503P.contains(enumC0845pJ) && !listM5503P2.contains(enumC0845pJ)) {
                ((AbstractC0063ag) entry.getValue()).mo280c(minecraft, c0623l);
                it.remove();
            }
        }
        float f2 = c0970rc2 != null ? 1.0f - f : 1.0f;
        for (EnumC0845pJ enumC0845pJ2 : listM5503P) {
            m5391a(minecraft, c0623l, clientLevel, randomSource, vec3Position, blockPosBlockPosition, enumC0845pJ2, listM5503P2.contains(enumC0845pJ2) ? 1.0f : f2);
        }
        for (EnumC0845pJ enumC0845pJ3 : listM5503P2) {
            if (!listM5503P.contains(enumC0845pJ3)) {
                m5391a(minecraft, c0623l, clientLevel, randomSource, vec3Position, blockPosBlockPosition, enumC0845pJ3, f);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m5391a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @NotNull EnumC0845pJ enumC0845pJ, float f) {
        AbstractC0063ag abstractC0063ag = (AbstractC0063ag) this.f5409c.computeIfAbsent(enumC0845pJ, C0064ah::m282a);
        if (abstractC0063ag == null) {
            return;
        }
        abstractC0063ag.mo278a(minecraft, c0623l, clientLevel, randomSource, vec3, blockPos, f);
    }

    @Override // com.boehmod.blockfront.InterfaceC0922qh
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo5073a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        C0970rc c0970rc;
        float fClamp;
        if (this.f5389aK.isEmpty() || this.f5391qV < 0 || this.f5391qV >= this.f5389aK.size()) {
            return;
        }
        C0970rc c0970rc2 = this.f5389aK.get(this.f5391qV);
        if (this.f5392qW >= 0 && this.f5392qW < this.f5389aK.size()) {
            c0970rc = this.f5389aK.get(this.f5392qW);
        } else {
            c0970rc = null;
        }
        C0970rc c0970rc3 = c0970rc;
        if (c0970rc3 != null && this.f5394qY > 0) {
            fClamp = Mth.clamp(this.f5393qX / this.f5394qY, 0.0f, 1.0f);
        } else {
            fClamp = 0.0f;
        }
        float f2 = fClamp;
        List<EnumC0845pJ> listM5503P = c0970rc2.f5429a.m5503P();
        List<EnumC0845pJ> listM5503P2 = c0970rc3 != null ? c0970rc3.f5429a.m5503P() : List.of();
        float f3 = c0970rc3 != null ? 1.0f - f2 : 1.0f;
        for (EnumC0845pJ enumC0845pJ : listM5503P) {
            m5392a(minecraft, c0623l, guiGraphics, i, i2, f, enumC0845pJ, listM5503P2.contains(enumC0845pJ) ? 1.0f : f3);
        }
        for (EnumC0845pJ enumC0845pJ2 : listM5503P2) {
            if (!listM5503P.contains(enumC0845pJ2)) {
                m5392a(minecraft, c0623l, guiGraphics, i, i2, f, enumC0845pJ2, f2);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m5392a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, @NotNull EnumC0845pJ enumC0845pJ, float f2) {
        AbstractC0063ag abstractC0063ag;
        if (f2 > 0.0f && (abstractC0063ag = this.f5409c.get(enumC0845pJ)) != null) {
            abstractC0063ag.mo279a(minecraft, c0623l, guiGraphics, i, i2, f, f2);
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0915qa
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo5067a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, int i, @NotNull PoseStack poseStack, @NotNull Matrix4f matrix4f, @NotNull Matrix4f matrix4f2, float f, double d, double d2, double d3) {
        C0970rc c0970rc;
        float fClamp;
        if (this.f5389aK.isEmpty() || this.f5391qV < 0 || this.f5391qV >= this.f5389aK.size()) {
            return;
        }
        C0970rc c0970rc2 = this.f5389aK.get(this.f5391qV);
        if (this.f5392qW >= 0 && this.f5392qW < this.f5389aK.size()) {
            c0970rc = this.f5389aK.get(this.f5392qW);
        } else {
            c0970rc = null;
        }
        C0970rc c0970rc3 = c0970rc;
        if (c0970rc3 != null && this.f5394qY > 0) {
            fClamp = Mth.clamp(this.f5393qX / this.f5394qY, 0.0f, 1.0f);
        } else {
            fClamp = 0.0f;
        }
        float f2 = fClamp;
        C0409gy c0409gyM5506a = c0970rc2.f5429a.m5506a();
        C0409gy c0409gyM5506a2 = c0970rc3 != null ? c0970rc3.f5429a.m5506a() : null;
        if (c0409gyM5506a != null && c0409gyM5506a.equals(c0409gyM5506a2)) {
            C0407gw.m1936a(c0409gyM5506a, minecraft, clientLevel, i, poseStack, matrix4f, matrix4f2, f, d, d2, d3, 1.0f);
            return;
        }
        float f3 = c0970rc3 != null ? 1.0f - f2 : 1.0f;
        if (c0409gyM5506a != null) {
            C0407gw.m1936a(c0409gyM5506a, minecraft, clientLevel, i, poseStack, matrix4f, matrix4f2, f, d, d2, d3, f3);
        }
        if (c0409gyM5506a2 != null) {
            C0407gw.m1936a(c0409gyM5506a2, minecraft, clientLevel, i, poseStack, matrix4f, matrix4f2, f, d, d2, d3, f2);
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0917qc
    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: a */
    public Vector3f mo5069a(float f, float f2) {
        C0970rc c0970rc;
        float fClamp;
        Vector3f vector3f = new Vector3f();
        if (this.f5389aK.isEmpty() || this.f5391qV < 0 || this.f5391qV >= this.f5389aK.size()) {
            return vector3f;
        }
        C0970rc c0970rc2 = this.f5389aK.get(this.f5391qV);
        if (this.f5392qW >= 0 && this.f5392qW < this.f5389aK.size()) {
            c0970rc = this.f5389aK.get(this.f5392qW);
        } else {
            c0970rc = null;
        }
        C0970rc c0970rc3 = c0970rc;
        if (c0970rc3 != null && this.f5394qY > 0) {
            fClamp = Mth.clamp(this.f5393qX / this.f5394qY, 0.0f, 1.0f);
        } else {
            fClamp = 0.0f;
        }
        float f3 = fClamp;
        m5393a(vector3f, c0970rc2, f, f2, c0970rc3 != null ? 1.0f - f3 : 1.0f);
        if (c0970rc3 != null) {
            m5393a(vector3f, c0970rc3, f, f2, f3);
        }
        return vector3f;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private static void m5393a(@NotNull Vector3f vector3f, @NotNull C0970rc c0970rc, float f, float f2, float f3) {
        if (f3 <= 0.0f) {
            return;
        }
        C0399go c0399goM5504a = c0970rc.f5429a.m5504a();
        if (c0399goM5504a != null) {
            float f4 = f3 * (1.0f - f2);
            if (f4 > 0.0f) {
                vector3f.add(c0399goM5504a.m1904a(f, 1.0f, f5382n).mul(f4));
            }
        }
        C0399go c0399goM5505b = c0970rc.f5429a.m5505b();
        if (c0399goM5505b != null) {
            float f5 = f3 * f2;
            if (f5 > 0.0f) {
                vector3f.add(c0399goM5505b.m1904a(f, 1.0f, f5382n).mul(f5));
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: H */
    private void m5394H(@NotNull Minecraft minecraft) {
        m5403a(minecraft, this.f5399a);
        m5403a(minecraft, this.f5400b);
        this.f5399a = this.f5401c;
        this.f5400b = this.f5402d;
        this.f5401c = null;
        this.f5402d = null;
        m5402a(minecraft, this.f5403b);
        m5402a(minecraft, this.f5404c);
        this.f5403b = this.f5405d;
        this.f5404c = this.f5406e;
        this.f5405d = null;
        this.f5406e = null;
        this.f5391qV = this.f5392qW;
        this.f5392qW = -1;
        this.f5393qX = 0;
        this.f5394qY = 0;
        this.f5396qZ = 0;
        this.f5407w = this.f5408x;
        this.f5408x = new int[0];
    }

    /* JADX INFO: renamed from: a */
    private static int m5395a(int i, int i2, float f) {
        return (i & (-16777216)) | (Mth.clamp((int) Mth.lerp(f, (i >> 16) & 255, (i2 >> 16) & 255), 0, 255) << 16) | (Mth.clamp((int) Mth.lerp(f, (i >> 8) & 255, (i2 >> 8) & 255), 0, 255) << 8) | Mth.clamp((int) Mth.lerp(f, i & 255, i2 & 255), 0, 255);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private static void m5396a(@NotNull C1096tv c1096tv, @NotNull C0970rc c0970rc, @Nullable C0970rc c0970rc2, float f) {
        boolean z = c0970rc.f5419gR;
        boolean z2 = c0970rc2 != null && c0970rc2.f5419gR;
        if (z && z2) {
            c1096tv.m6118c(m5395a(c0970rc.f5420rc, c0970rc2.f5420rc, f), 1.0f);
        } else if (z) {
            c1096tv.m6118c(c0970rc.f5420rc, 1.0f - f);
        } else if (z2) {
            c1096tv.m6118c(c0970rc2.f5420rc, f);
        } else {
            c1096tv.m6119dp();
        }
        boolean z3 = c0970rc.f5421gS;
        boolean z4 = c0970rc2 != null && c0970rc2.f5421gS;
        if (z3 && z4) {
            c1096tv.m6134b(Mth.lerp(f, c0970rc.f5422mz, c0970rc2.f5422mz), Mth.lerp(f, c0970rc.f5423mA, c0970rc2.f5423mA), 1.0f);
        } else if (z3) {
            c1096tv.m6134b(c0970rc.f5422mz, c0970rc.f5423mA, 1.0f - f);
        } else if (z4) {
            c1096tv.m6134b(c0970rc2.f5422mz, c0970rc2.f5423mA, f);
        } else {
            c1096tv.m6135ds();
        }
        boolean z5 = c0970rc.f5424gT;
        boolean z6 = c0970rc2 != null && c0970rc2.f5424gT;
        if (z5 && z6) {
            c1096tv.m6110b(m5395a(c0970rc.f5425rd, c0970rc2.f5425rd, f), 1.0f);
        } else if (z5) {
            c1096tv.m6110b(c0970rc.f5425rd, 1.0f - f);
        } else if (z6) {
            c1096tv.m6110b(c0970rc2.f5425rd, f);
        } else {
            c1096tv.m6111do();
        }
        boolean z7 = c0970rc.f5426gU;
        boolean z8 = c0970rc2 != null && c0970rc2.f5426gU;
        if (z7 && z8) {
            c1096tv.m6123d(m5395a(c0970rc.f5427re, c0970rc2.f5427re, f), 1.0f);
        } else if (z7) {
            c1096tv.m6123d(c0970rc.f5427re, 1.0f - f);
        } else if (z8) {
            c1096tv.m6123d(c0970rc2.f5427re, f);
        } else {
            c1096tv.m6124dq();
        }
        Float fM5507D = c0970rc.f5429a.m5507D();
        Float fM5507D2 = c0970rc2 != null ? c0970rc2.f5429a.m5507D() : null;
        if (fM5507D != null || fM5507D2 != null) {
            float fFloatValue = fM5507D != null ? fM5507D.floatValue() : 0.0f;
            float fLerp = c0970rc2 != null ? Mth.lerp(f, fFloatValue, fM5507D2 != null ? fM5507D2.floatValue() : 0.0f) : fFloatValue;
            if (fLerp > 0.0f) {
                c1096tv.m6128n(fLerp);
                return;
            } else {
                c1096tv.m6129dr();
                return;
            }
        }
        c1096tv.m6129dr();
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m5397a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull C0970rc c0970rc, @Nullable C0970rc c0970rc2, float f) {
        float fM2289O = c0623l.m2869a().m2289O();
        float f2 = c0970rc2 != null ? 1.0f - f : 1.0f;
        float f3 = c0970rc2 != null ? f : 0.0f;
        float f4 = !C0875pn.m4352a((Level) clientLevel, localPlayer.getBlockX(), localPlayer.getBlockZ(), localPlayer.getBlockY()) ? fM2289O : 0.0f;
        this.f5399a = m5398a(minecraft, abstractC0863pb, c0623l, this.f5399a, c0970rc.f5415r);
        this.f5400b = m5398a(minecraft, abstractC0863pb, c0623l, this.f5400b, c0970rc.f5416s);
        m5399a(this.f5399a, f2 * (1.0f - fM2289O));
        m5399a(this.f5400b, f2 * fM2289O);
        this.f5403b = m5400a(minecraft, this.f5403b, c0970rc.f5417t);
        this.f5404c = m5400a(minecraft, this.f5404c, c0970rc.f5418u);
        m5401a(this.f5403b, f2 * (1.0f - fM2289O));
        m5401a(this.f5404c, f2 * f4);
        if (c0970rc2 != null) {
            this.f5401c = m5398a(minecraft, abstractC0863pb, c0623l, this.f5401c, c0970rc2.f5415r);
            this.f5402d = m5398a(minecraft, abstractC0863pb, c0623l, this.f5402d, c0970rc2.f5416s);
            m5399a(this.f5401c, f3 * (1.0f - fM2289O));
            m5399a(this.f5402d, f3 * fM2289O);
            this.f5405d = m5400a(minecraft, this.f5405d, c0970rc2.f5417t);
            this.f5406e = m5400a(minecraft, this.f5406e, c0970rc2.f5418u);
            m5401a(this.f5405d, f3 * (1.0f - fM2289O));
            m5401a(this.f5406e, f3 * f4);
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Nullable
    /* JADX INFO: renamed from: a */
    private static C0469iE[] m5398a(@NotNull Minecraft minecraft, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull C0623l c0623l, @Nullable C0469iE[] c0469iEArr, @NotNull Supplier<SoundEvent> supplier) {
        if (c0469iEArr != null) {
            return c0469iEArr;
        }
        SoundEvent soundEvent = supplier.get();
        if (soundEvent == null) {
            return null;
        }
        C0838pC c0838pCM2884a = c0623l.m2884a();
        SoundManager soundManager = minecraft.getSoundManager();
        C0469iE[] c0469iEArr2 = new C0469iE[3];
        for (int i = 0; i < 3; i++) {
            C0469iE c0469iE = new C0469iE(minecraft, abstractC0863pb, soundEvent, SoundSource.AMBIENT, f5385a[i], 0.7f + (i * 0.25f), c0838pCM2884a, i);
            soundManager.play(c0469iE);
            c0469iEArr2[i] = c0469iE;
        }
        return c0469iEArr2;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private static void m5399a(@Nullable C0469iE[] c0469iEArr, float f) {
        if (c0469iEArr == null) {
            return;
        }
        for (C0469iE c0469iE : c0469iEArr) {
            if (c0469iE != null) {
                c0469iE.m2134f(f);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Nullable
    /* JADX INFO: renamed from: a */
    private static C0477iM m5400a(@NotNull Minecraft minecraft, @Nullable C0477iM c0477iM, @NotNull Supplier<SoundEvent> supplier) {
        if (c0477iM != null) {
            return c0477iM;
        }
        SoundEvent soundEvent = supplier.get();
        if (soundEvent == null) {
            return null;
        }
        C0477iM c0477iM2 = new C0477iM(soundEvent);
        minecraft.getSoundManager().play(c0477iM2);
        return c0477iM2;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private static void m5401a(@Nullable C0477iM c0477iM, float f) {
        if (c0477iM != null) {
            c0477iM.m2142f(f);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private static void m5402a(@NotNull Minecraft minecraft, @Nullable C0477iM c0477iM) {
        if (c0477iM != null) {
            minecraft.getSoundManager().stop(c0477iM);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private static void m5403a(@NotNull Minecraft minecraft, @Nullable C0469iE[] c0469iEArr) {
        if (c0469iEArr == null) {
            return;
        }
        SoundManager soundManager = minecraft.getSoundManager();
        for (C0469iE c0469iE : c0469iEArr) {
            if (c0469iE != null) {
                soundManager.stop(c0469iE);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m5404a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull C0970rc c0970rc, @Nullable C0970rc c0970rc2, float f, @NotNull RandomSource randomSource) {
        this.f5407w = m5405a(minecraft, c0623l, clientLevel, localPlayer, c0970rc, this.f5407w, c0970rc2 != null ? 1.0f - f : 1.0f, randomSource);
        if (c0970rc2 != null) {
            this.f5408x = m5405a(minecraft, c0623l, clientLevel, localPlayer, c0970rc2, this.f5408x, f, randomSource);
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:45:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:46:0x0106  */
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private static int[] m5405a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull C0970rc c0970rc, int[] iArr, float f, @NotNull RandomSource randomSource) {
        ResourceLocation resourceLocationM5497D;
        C0506ip c0506ipM2275a;
        AbstractC0504in abstractC0504inM2280a;
        Entity cameraEntity;
        Vec3 vec3Position;
        int size = c0970rc.f5428aL.size();
        if (size == 0) {
            return iArr;
        }
        if (iArr.length != size) {
            iArr = new int[size];
        }
        for (int i = 0; i < size; i++) {
            int[] iArr2 = iArr;
            int i2 = i;
            int i3 = iArr2[i2];
            iArr2[i2] = i3 - 1;
            if (i3 <= 0) {
                C0970rc.a aVar = c0970rc.f5428aL.get(i);
                int iM5495bD = aVar.m5495bD();
                int iMax = Math.max(iM5495bD, aVar.m5496bE());
                iArr[i] = iMax == iM5495bD ? iM5495bD : iM5495bD + randomSource.nextInt((iMax - iM5495bD) + 1);
                if (f > 0.0f && (resourceLocationM5497D = aVar.m5497D()) != null) {
                    C0970rc.b bVarM5498a = aVar.m5498a();
                    if (bVarM5498a != C0970rc.b.ANY) {
                        boolean zM2286a = c0623l.m2869a().m2286a(clientLevel, localPlayer);
                        if ((bVarM5498a != C0970rc.b.INTERIOR || zM2286a) && (bVarM5498a != C0970rc.b.EXTERIOR || !zM2286a)) {
                            c0506ipM2275a = C0506ip.m2275a(resourceLocationM5497D);
                            if (c0506ipM2275a != null && (abstractC0504inM2280a = c0506ipM2275a.m2280a()) != null) {
                                cameraEntity = minecraft.getCameraEntity();
                                if (cameraEntity != null) {
                                    vec3Position = cameraEntity.position();
                                } else {
                                    vec3Position = localPlayer.position();
                                }
                                abstractC0504inM2280a.mo2265a(minecraft, vec3Position, clientLevel, localPlayer, f);
                            }
                        }
                    } else {
                        c0506ipM2275a = C0506ip.m2275a(resourceLocationM5497D);
                        if (c0506ipM2275a != null) {
                            cameraEntity = minecraft.getCameraEntity();
                            if (cameraEntity != null) {
                                vec3Position = cameraEntity.position();
                            } else {
                                vec3Position = localPlayer.position();
                            }
                            abstractC0504inM2280a.mo2265a(minecraft, vec3Position, clientLevel, localPlayer, f);
                        }
                    }
                }
            }
        }
        return iArr;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m5406a(int i, int i2) {
        if (i < 0 || i >= this.f5389aK.size()) {
            return;
        }
        this.f5392qW = i;
        this.f5394qY = i2;
        this.f5393qX = 0;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m5407a(int i, int i2, int i3, int i4) {
        boolean z = this.f5391qV != i;
        this.f5391qV = i;
        this.f5392qW = i2;
        this.f5393qX = i3;
        this.f5394qY = i4;
        if (z) {
            this.f5396qZ = 0;
        }
        if (this.f5391qV >= 0 && this.f5391qV < this.f5389aK.size()) {
            this.f5407w = new int[this.f5389aK.get(this.f5391qV).f5428aL.size()];
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0921qg
    /* JADX INFO: renamed from: h */
    public void mo5071h(@NotNull ByteBuf byteBuf) {
        byteBuf.writeInt(this.f5391qV);
        byteBuf.writeInt(this.f5392qW);
        byteBuf.writeInt(this.f5393qX);
        byteBuf.writeInt(this.f5394qY);
    }

    @Override // com.boehmod.blockfront.InterfaceC0921qg
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: g */
    public void mo5072g(@NotNull ByteBuf byteBuf) {
        m5407a(byteBuf.readInt(), byteBuf.readInt(), byteBuf.readInt(), byteBuf.readInt());
    }

    @Override // com.boehmod.blockfront.InterfaceC0918qd
    /* JADX INFO: renamed from: a */
    public void mo5070a(@NotNull ServerLevel serverLevel, @NotNull RandomSource randomSource) {
        if (this.f5391qV != -1 || this.f5389aK.isEmpty()) {
            return;
        }
        this.f5391qV = 0;
        this.f5395O = serverLevel.getGameTime() + ((long) m5387a(this.f5389aK.get(this.f5391qV), randomSource));
        this.f5396qZ = 0;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        list.add(Component.literal("Entries: " + this.f5389aK.size()));
        list.add(Component.literal("Transition Ticks: " + this.f5390qU));
        list.add(Component.literal("Current Index: " + this.f5391qV));
        list.add(Component.literal("Next Index: " + this.f5392qW));
        if (this.f5392qW >= 0 && this.f5394qY > 0) {
            list.add(Component.literal(String.format("Transition: %.1f%%", Float.valueOf((100.0f * this.f5393qX) / this.f5394qY))).withStyle(ChatFormatting.GRAY));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f5381eJ;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo3946J());
        objectArrayList.add(new C0930qp(Component.literal("Transition Ticks"), () -> {
            return Integer.valueOf(this.f5390qU);
        }, num -> {
            this.f5390qU = num.intValue();
        }, 0, 24000));
        for (int i = 0; i < this.f5389aK.size(); i++) {
            int i2 = i;
            C0970rc c0970rc = this.f5389aK.get(i);
            int i3 = AbstractC0927qm.f5122v[i2 % AbstractC0927qm.f5122v.length];
            objectArrayList.add(new C0929qo(Component.literal("Entry " + i2 + " Weight"), () -> {
                return Float.valueOf((float) c0970rc.f5412al);
            }, f -> {
                c0970rc.f5412al = f.floatValue();
            }, 0.0f, 100.0f).m5076a(i3));
            objectArrayList.add(new C0930qp(Component.literal("Entry " + i2 + " Min Duration"), () -> {
                return Integer.valueOf(c0970rc.f5413ra);
            }, num2 -> {
                c0970rc.f5413ra = num2.intValue();
            }, 0, 1000000).m5076a(i3));
            objectArrayList.add(new C0930qp(Component.literal("Entry " + i2 + " Max Duration"), () -> {
                return Integer.valueOf(c0970rc.f5414rb);
            }, num3 -> {
                c0970rc.f5414rb = num3.intValue();
            }, 0, 1000000).m5076a(i3));
            objectArrayList.add(new C0932qr(Component.literal("Entry " + i2 + " Interior Sound"), () -> {
                return c0970rc.f5415r.get();
            }, soundEvent -> {
                c0970rc.f5415r = soundEvent != null ? () -> {
                    return soundEvent;
                } : () -> {
                    return null;
                };
            }).m5076a(i3));
            objectArrayList.add(new C0932qr(Component.literal("Entry " + i2 + " Exterior Sound"), () -> {
                return c0970rc.f5416s.get();
            }, soundEvent2 -> {
                c0970rc.f5416s = soundEvent2 != null ? () -> {
                    return soundEvent2;
                } : () -> {
                    return null;
                };
            }).m5076a(i3));
            objectArrayList.add(new C0932qr(Component.literal("Entry " + i2 + " Player Interior Sound"), () -> {
                return c0970rc.f5417t.get();
            }, soundEvent3 -> {
                c0970rc.f5417t = soundEvent3 != null ? () -> {
                    return soundEvent3;
                } : () -> {
                    return null;
                };
            }).m5076a(i3));
            objectArrayList.add(new C0932qr(Component.literal("Entry " + i2 + " Player Exterior Sound"), () -> {
                return c0970rc.f5418u.get();
            }, soundEvent4 -> {
                c0970rc.f5418u = soundEvent4 != null ? () -> {
                    return soundEvent4;
                } : () -> {
                    return null;
                };
            }).m5076a(i3));
            objectArrayList.add(new C0925qk(Component.literal("Entry " + i2 + " Has Fog Color"), () -> {
                return Boolean.valueOf(c0970rc.f5419gR);
            }, bool -> {
                c0970rc.f5419gR = bool.booleanValue();
            }).m5076a(i3));
            objectArrayList.add(new C0926ql(Component.literal("Entry " + i2 + " Fog Color"), () -> {
                return Integer.valueOf(c0970rc.f5420rc);
            }, num4 -> {
                c0970rc.f5420rc = num4.intValue();
            }).m5076a(i3));
            objectArrayList.add(new C0925qk(Component.literal("Entry " + i2 + " Has Fog Density"), () -> {
                return Boolean.valueOf(c0970rc.f5421gS);
            }, bool2 -> {
                c0970rc.f5421gS = bool2.booleanValue();
            }).m5076a(i3));
            objectArrayList.add(new C0929qo(Component.literal("Entry " + i2 + " Near Fog Density"), () -> {
                return Float.valueOf(c0970rc.f5422mz);
            }, f2 -> {
                c0970rc.f5422mz = f2.floatValue();
            }, -1024.0f, 1024.0f).m5076a(i3));
            objectArrayList.add(new C0929qo(Component.literal("Entry " + i2 + " Far Fog Density"), () -> {
                return Float.valueOf(c0970rc.f5423mA);
            }, f3 -> {
                c0970rc.f5423mA = f3.floatValue();
            }, -1024.0f, 1024.0f).m5076a(i3));
            objectArrayList.add(new C0925qk(Component.literal("Entry " + i2 + " Has Sky Color"), () -> {
                return Boolean.valueOf(c0970rc.f5424gT);
            }, bool3 -> {
                c0970rc.f5424gT = bool3.booleanValue();
            }).m5076a(i3));
            objectArrayList.add(new C0926ql(Component.literal("Entry " + i2 + " Sky Color"), () -> {
                return Integer.valueOf(c0970rc.f5425rd);
            }, num5 -> {
                c0970rc.f5425rd = num5.intValue();
            }).m5076a(i3));
            objectArrayList.add(new C0925qk(Component.literal("Entry " + i2 + " Has Light Color"), () -> {
                return Boolean.valueOf(c0970rc.f5426gU);
            }, bool4 -> {
                c0970rc.f5426gU = bool4.booleanValue();
            }).m5076a(i3));
            objectArrayList.add(new C0926ql(Component.literal("Entry " + i2 + " Light Color"), () -> {
                return Integer.valueOf(c0970rc.f5427re);
            }, num6 -> {
                c0970rc.f5427re = num6.intValue();
            }).m5076a(i3));
            objectArrayList.add(new C0928qn(Component.literal("Entry " + i2 + " Weather Type"), EnumC0845pJ.class, () -> {
                if (c0970rc.f5429a.m5503P().isEmpty()) {
                    return null;
                }
                return (EnumC0845pJ) c0970rc.f5429a.m5503P().getFirst();
            }, enumC0845pJ -> {
                c0970rc.f5429a = new C0971rd(List.of(enumC0845pJ), c0970rc.f5429a.m5504a(), c0970rc.f5429a.m5505b(), c0970rc.f5429a.m5506a(), c0970rc.f5429a.m5507D(), c0970rc.f5429a.m5508E());
            }).m5076a(i3));
            objectArrayList.add(new C0929qo(Component.literal("Entry " + i2 + " Darkness"), () -> {
                return Float.valueOf(c0970rc.f5429a.m5507D() != null ? c0970rc.f5429a.m5507D().floatValue() : 0.0f);
            }, f4 -> {
                c0970rc.f5429a = new C0971rd(c0970rc.f5429a.m5503P(), c0970rc.f5429a.m5504a(), c0970rc.f5429a.m5505b(), c0970rc.f5429a.m5506a(), f4.floatValue() > 0.0f ? f4 : null, c0970rc.f5429a.m5508E());
            }, 0.0f, 1.0f).m5076a(i3));
            objectArrayList.add(new C0929qo(Component.literal("Entry " + i2 + " Bot View Distance"), () -> {
                return Float.valueOf(c0970rc.f5429a.m5508E() != null ? c0970rc.f5429a.m5508E().floatValue() : 0.0f);
            }, f5 -> {
                c0970rc.f5429a = new C0971rd(c0970rc.f5429a.m5503P(), c0970rc.f5429a.m5504a(), c0970rc.f5429a.m5505b(), c0970rc.f5429a.m5506a(), c0970rc.f5429a.m5507D(), f5.floatValue() > 0.0f ? f5 : null);
            }, 0.0f, 64.0f).m5076a(i3));
            objectArrayList.add(new C0923qi(Component.literal("Remove Entry " + i2), () -> {
                this.f5389aK.remove(i2);
                m5383cP();
            }).m5076a(i3));
        }
        objectArrayList.add(new C0923qi(Component.literal("Add Entry"), () -> {
            this.f5389aK.add(new C0970rc());
            m5383cP();
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: cM */
    public void mo3956cM() {
        super.mo3956cM();
        this.f5391qV = -1;
        this.f5392qW = -1;
        this.f5393qX = 0;
        this.f5394qY = 0;
        this.f5395O = 0L;
        this.f5396qZ = 0;
        this.f5397my = -1.0f;
        this.f5398b = null;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3939a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.mo3939a(minecraft, randomSource);
        m5403a(minecraft, this.f5399a);
        m5403a(minecraft, this.f5400b);
        m5403a(minecraft, this.f5401c);
        m5403a(minecraft, this.f5402d);
        this.f5399a = null;
        this.f5400b = null;
        this.f5401c = null;
        this.f5402d = null;
        m5402a(minecraft, this.f5403b);
        m5402a(minecraft, this.f5404c);
        m5402a(minecraft, this.f5405d);
        m5402a(minecraft, this.f5406e);
        this.f5403b = null;
        this.f5404c = null;
        this.f5405d = null;
        this.f5406e = null;
        this.f5391qV = -1;
        this.f5392qW = -1;
        this.f5393qX = 0;
        this.f5394qY = 0;
        this.f5396qZ = 0;
        this.f5407w = new int[0];
        this.f5408x = new int[0];
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b != null) {
            Iterator<AbstractC0063ag> it = this.f5409c.values().iterator();
            while (it.hasNext()) {
                it.next().mo280c(minecraft, c0623lM2852b);
            }
        }
        this.f5409c.clear();
        C0407gw.m1937aR();
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: c */
    private static String m5408c(@NotNull List<EnumC0845pJ> list) {
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
    private static String m5409a(@NotNull Supplier<SoundEvent> supplier) {
        SoundEvent soundEvent = supplier.get();
        return soundEvent == null ? "none" : soundEvent.getLocation().toString();
    }

    @Override // com.boehmod.blockfront.InterfaceC0916qb
    /* JADX INFO: renamed from: a */
    public void mo5068a(@NotNull C0623l c0623l, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull List<String> list) {
        C0970rc c0970rc;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        list.add("");
        list.add("Weather:");
        if (this.f5389aK.isEmpty() || this.f5391qV < 0 || this.f5391qV >= this.f5389aK.size()) {
            list.add(String.valueOf(ChatFormatting.GRAY) + "(no entry active)");
            return;
        }
        C1096tv c1096tvM4089a = abstractC0863pb.m4089a();
        float fM2289O = c0623l.m2869a().m2289O();
        C0970rc c0970rc2 = this.f5389aK.get(this.f5391qV);
        if (this.f5392qW >= 0 && this.f5392qW < this.f5389aK.size()) {
            c0970rc = this.f5389aK.get(this.f5392qW);
        } else {
            c0970rc = null;
        }
        C0970rc c0970rc3 = c0970rc;
        if (c0970rc3 != null && this.f5394qY > 0) {
            float f = (100.0f * this.f5393qX) / this.f5394qY;
            list.add("Entry: " + String.valueOf(ChatFormatting.GRAY) + this.f5391qV + String.valueOf(ChatFormatting.WHITE) + " -> " + String.valueOf(ChatFormatting.GRAY) + this.f5392qW + String.valueOf(ChatFormatting.WHITE) + " of " + String.valueOf(ChatFormatting.GRAY) + this.f5389aK.size());
            list.add("Transition: " + String.valueOf(ChatFormatting.GRAY) + String.format("%.1f%%", Float.valueOf(f)) + String.valueOf(ChatFormatting.WHITE) + " (" + this.f5393qX + "/" + this.f5394qY + "t)");
        } else {
            list.add("Entry: " + String.valueOf(ChatFormatting.GRAY) + this.f5391qV + String.valueOf(ChatFormatting.WHITE) + " of " + String.valueOf(ChatFormatting.GRAY) + this.f5389aK.size());
        }
        list.add("Active: " + String.valueOf(ChatFormatting.GRAY) + this.f5396qZ + "t" + String.valueOf(ChatFormatting.WHITE) + " (range " + String.valueOf(ChatFormatting.GRAY) + c0970rc2.f5413ra + "-" + c0970rc2.f5414rb + "t" + String.valueOf(ChatFormatting.WHITE) + ")");
        list.add("Outdoor Alpha: " + String.valueOf(ChatFormatting.GRAY) + String.format("%.2f", Float.valueOf(fM2289O)));
        if (c1096tvM4089a.m6120cj()) {
            str = "Fog Color: " + String.valueOf(ChatFormatting.GRAY) + String.format("#%06X @ %.2f", Integer.valueOf(c1096tvM4089a.m6121cf() & ColorReferences.COLOR_WHITE), Float.valueOf(c1096tvM4089a.m6122bc()));
        } else {
            str = "Fog Color: " + String.valueOf(ChatFormatting.DARK_GRAY) + "off";
        }
        list.add(str);
        if (c1096tvM4089a.m6136cn()) {
            str2 = "Fog Density: " + String.valueOf(ChatFormatting.GRAY) + String.format("near=%.2f far=%.2f @ %.2f", Float.valueOf(c1096tvM4089a.m6138bg()), Float.valueOf(c1096tvM4089a.m6139bh()), Float.valueOf(c1096tvM4089a.m6137bf()));
        } else {
            str2 = "Fog Density: " + String.valueOf(ChatFormatting.DARK_GRAY) + "off";
        }
        list.add(str2);
        if (c1096tvM4089a.m6112ch()) {
            str3 = "Sky Color: " + String.valueOf(ChatFormatting.GRAY) + String.format("#%06X @ %.2f", Integer.valueOf(c1096tvM4089a.m6113cd() & ColorReferences.COLOR_WHITE), Float.valueOf(c1096tvM4089a.m6114bb()));
        } else {
            str3 = "Sky Color: " + String.valueOf(ChatFormatting.DARK_GRAY) + "off";
        }
        list.add(str3);
        if (c1096tvM4089a.m6125ck()) {
            str4 = "Light Color: " + String.valueOf(ChatFormatting.GRAY) + String.format("#%06X @ %.2f", Integer.valueOf(c1096tvM4089a.m6126cg() & ColorReferences.COLOR_WHITE), Float.valueOf(c1096tvM4089a.m6127bd()));
        } else {
            str4 = "Light Color: " + String.valueOf(ChatFormatting.DARK_GRAY) + "off";
        }
        list.add(str4);
        if (c1096tvM4089a.m6131cl()) {
            str5 = "Darkness: " + String.valueOf(ChatFormatting.GRAY) + String.format("%.2f", Float.valueOf(c1096tvM4089a.m6130be()));
        } else {
            str5 = "Darkness: " + String.valueOf(ChatFormatting.DARK_GRAY) + "off";
        }
        list.add(str5);
        list.add("Interior: " + String.valueOf(ChatFormatting.GRAY) + m5409a(c0970rc2.f5415r) + (c0970rc3 != null ? String.valueOf(ChatFormatting.WHITE) + " -> " + String.valueOf(ChatFormatting.GRAY) + m5409a(c0970rc3.f5415r) : ""));
        list.add("Exterior: " + String.valueOf(ChatFormatting.GRAY) + m5409a(c0970rc2.f5416s) + (c0970rc3 != null ? String.valueOf(ChatFormatting.WHITE) + " -> " + String.valueOf(ChatFormatting.GRAY) + m5409a(c0970rc3.f5416s) : ""));
        list.add("Weather Type: " + String.valueOf(ChatFormatting.GRAY) + m5408c(c0970rc2.f5429a.m5503P()) + (c0970rc3 != null ? String.valueOf(ChatFormatting.WHITE) + " -> " + String.valueOf(ChatFormatting.GRAY) + m5408c(c0970rc3.f5429a.m5503P()) : ""));
    }
}
