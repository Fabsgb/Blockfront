package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.Pair;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.Reference2ObjectMap;
import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.tv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tv.class */
public class C1096tv {

    /* JADX INFO: renamed from: dc */
    public static final String f5942dc = "default";

    /* JADX INFO: renamed from: ac */
    @NotNull
    public static final Codec<C1096tv> f5943ac = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("name").forGetter((v0) -> {
            return v0.getName();
        }), C0859pX.f4605H.listOf().optionalFieldOf("mapEffects", List.of()).forGetter((v0) -> {
            return v0.m6106aE();
        }), C0576kF.f3344n.listOf().optionalFieldOf("mapEffectTemplates", List.of()).forGetter((v0) -> {
            return v0.m6104aD();
        })).apply(instance, C1096tv::m6076a);
    });

    /* JADX INFO: renamed from: aN */
    private int f5944aN;

    /* JADX INFO: renamed from: dd */
    private final String f5954dd;

    /* JADX INFO: renamed from: bO */
    @NotNull
    private final List<AbstractC0858pW> f5945bO = new ObjectArrayList();

    /* JADX INFO: renamed from: bP */
    @NotNull
    private final List<C0576kF> f5946bP = new ObjectArrayList();

    /* JADX INFO: renamed from: Y */
    @NotNull
    private final Map<UUID, C0576kF> f5947Y = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: bQ */
    @NotNull
    private final List<AbstractC0858pW> f5948bQ = new ObjectArrayList();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Reference2ObjectMap<RenderLevelStageEvent.Stage, List<InterfaceC0919qe>> f5949a = new Reference2ObjectOpenHashMap();

    /* JADX INFO: renamed from: bR */
    @NotNull
    private final List<InterfaceC0917qc> f5950bR = new ObjectArrayList();

    /* JADX INFO: renamed from: bS */
    @NotNull
    private final List<InterfaceC0915qa> f5951bS = new ObjectArrayList();

    /* JADX INFO: renamed from: bT */
    @NotNull
    private final List<InterfaceC0922qh> f5952bT = new ObjectArrayList();

    /* JADX INFO: renamed from: ey */
    @Nullable
    private ResourceLocation f5953ey = null;

    /* JADX INFO: renamed from: mT */
    private float f5955mT = 0.0f;

    /* JADX INFO: renamed from: mz */
    private float f5956mz = 0.0f;

    /* JADX INFO: renamed from: mA */
    private float f5957mA = 0.0f;

    /* JADX INFO: renamed from: mU */
    private float f5958mU = 0.0f;

    /* JADX INFO: renamed from: tp */
    private int f5959tp = ColorReferences.COLOR_WHITE;

    /* JADX INFO: renamed from: hQ */
    private boolean f5960hQ = false;

    /* JADX INFO: renamed from: tq */
    private int f5961tq = ColorReferences.COLOR_WHITE;

    /* JADX INFO: renamed from: mV */
    private float f5962mV = 0.0f;

    /* JADX INFO: renamed from: tr */
    private int f5963tr = ColorReferences.COLOR_WHITE;

    /* JADX INFO: renamed from: mW */
    private float f5964mW = 0.0f;

    /* JADX INFO: renamed from: ts */
    private int f5965ts = ColorReferences.COLOR_WHITE;

    /* JADX INFO: renamed from: mX */
    private float f5966mX = 0.0f;

    /* JADX INFO: renamed from: aS */
    private double f5967aS = -1.0d;

    /* JADX INFO: renamed from: gQ */
    private boolean f5968gQ = false;

    /* JADX INFO: renamed from: gP */
    private boolean f5969gP = false;

    /* JADX INFO: renamed from: l */
    @NotNull
    private final C0620kx f5970l = new C0620kx();

    @NotNull
    /* JADX INFO: renamed from: a */
    private static C1096tv m6076a(String str, List<AbstractC0858pW> list, List<C0576kF> list2) {
        C1096tv c1096tv = new C1096tv(str);
        c1096tv.f5945bO.addAll(list);
        c1096tv.f5948bQ.addAll(list);
        c1096tv.f5946bP.addAll(list2);
        c1096tv.m6094dn();
        return c1096tv;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public boolean m6077a(@NotNull RenderLevelStageEvent.Stage stage) {
        List list = (List) this.f5949a.get(stage);
        return (list == null || list.isEmpty()) ? false : true;
    }

    public C1096tv(@NotNull String str) {
        this.f5954dd = str;
    }

    public C1096tv(@NotNull ByteBuf byteBuf) throws IOException {
        this.f5954dd = IPacket.readString(byteBuf);
        this.f5948bQ.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.f5948bQ.add((AbstractC0858pW) C0859pX.f4606d.decode(byteBuf));
        }
        m6094dn();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0620kx m6078a() {
        return this.f5970l;
    }

    @NotNull
    public String getName() {
        return this.f5954dd;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public void m6079a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        double d = -1.0d;
        for (AbstractC0858pW abstractC0858pW : this.f5948bQ) {
            abstractC0858pW.mo3952a(serverLevel, abstractC0531jN, abstractC0863pb, serverLevel.getRandom(), set);
            if (abstractC0858pW instanceof InterfaceC0861pZ) {
                double dMo3994aT = ((InterfaceC0861pZ) abstractC0858pW).mo3994aT();
                if (dMo3994aT > 0.0d && (d < 0.0d || dMo3994aT < d)) {
                    d = dMo3994aT;
                }
            }
        }
        this.f5967aS = d;
    }

    /* JADX INFO: renamed from: v */
    public double m6080v() {
        return this.f5967aS;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: I */
    public void m6081I(@NotNull Minecraft minecraft) {
        this.f5955mT = 0.0f;
        this.f5956mz = 0.0f;
        this.f5957mA = 0.0f;
        this.f5962mV = 0.0f;
        this.f5963tr = ColorReferences.COLOR_WHITE;
        this.f5958mU = 0.0f;
        this.f5959tp = ColorReferences.COLOR_WHITE;
        this.f5960hQ = false;
        this.f5961tq = ColorReferences.COLOR_WHITE;
        this.f5964mW = 0.0f;
        this.f5965ts = ColorReferences.COLOR_WHITE;
        this.f5966mX = 0.0f;
        this.f5968gQ = false;
        this.f5969gP = false;
        this.f5944aN = 0;
        this.f5953ey = null;
        this.f5950bR.clear();
        this.f5951bS.clear();
        this.f5952bT.clear();
        Iterator<AbstractC0858pW> it = this.f5948bQ.iterator();
        while (it.hasNext()) {
            it.next().mo3953a(minecraft, this);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m6082a(@NotNull InterfaceC0917qc interfaceC0917qc) {
        this.f5950bR.add(interfaceC0917qc);
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: aA */
    public List<InterfaceC0917qc> m6083aA() {
        return this.f5950bR;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m6084a(@NotNull InterfaceC0915qa interfaceC0915qa) {
        this.f5951bS.add(interfaceC0915qa);
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: aB */
    public List<InterfaceC0915qa> m6085aB() {
        return this.f5951bS;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m6086a(@NotNull InterfaceC0922qh interfaceC0922qh) {
        this.f5952bT.add(interfaceC0922qh);
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: aC */
    public List<InterfaceC0922qh> m6087aC() {
        return this.f5952bT;
    }

    /* JADX INFO: renamed from: dm */
    public void m6088dm() {
        Iterator<AbstractC0858pW> it = this.f5948bQ.iterator();
        while (it.hasNext()) {
            it.next().mo3956cM();
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m6089a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, float f) {
        boolean zUseFancyGraphics = Minecraft.useFancyGraphics();
        for (AbstractC0858pW abstractC0858pW : this.f5948bQ) {
            if (abstractC0858pW.f4596gF && (zUseFancyGraphics || !abstractC0858pW.mo3955bG())) {
                abstractC0858pW.mo3933a(minecraft, c0623l, randomSource, abstractC0863pb, localPlayer, clientLevel, f);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m6090a(@NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, float f, float f2) {
        List<InterfaceC0919qe> list = (List) this.f5949a.get(renderLevelStageEvent.getStage());
        if (list != null) {
            boolean zUseFancyGraphics = Minecraft.useFancyGraphics();
            ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
            for (InterfaceC0919qe interfaceC0919qe : list) {
                AbstractC0858pW abstractC0858pW = (AbstractC0858pW) interfaceC0919qe;
                if (abstractC0858pW.f4596gF && (zUseFancyGraphics || !abstractC0858pW.mo3955bG())) {
                    interfaceC0919qe.mo4650a(minecraft, c0623l, localPlayer, clientLevel, blockRenderDispatcher, bufferSource, threadLocalRandomCurrent, renderLevelStageEvent, guiGraphics, poseStack, camera, f, f2);
                }
            }
        }
        if (renderLevelStageEvent.getStage() == RenderLevelStageEvent.Stage.AFTER_PARTICLES) {
            m6091a(renderLevelStageEvent, minecraft, localPlayer, clientLevel, bufferSource, guiGraphics.pose(), guiGraphics, font, camera, f2);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m6091a(@NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull Minecraft minecraft, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, float f) {
        if (renderLevelStageEvent.getStage() != RenderLevelStageEvent.Stage.AFTER_PARTICLES || clientLevel == null || localPlayer == null || !localPlayer.isCreative()) {
            return;
        }
        if (minecraft.getDebugOverlay().showDebugScreen()) {
            for (C0756na c0756na : clientLevel.entitiesForRendering()) {
                if (c0756na instanceof C0756na) {
                    C0129bt.m574a(camera, poseStack, c0756na.getEyePosition(f), c0756na.m3583b().getCenter(), 1.0f, 16776960);
                }
            }
        }
        Vec3 viewVector = localPlayer.getViewVector(1.0f);
        Vec3 eyePosition = localPlayer.getEyePosition(1.0f);
        Vec3 vec3Add = eyePosition.add(viewVector.scale(64.0d));
        for (AbstractC0858pW abstractC0858pW : this.f5948bQ) {
            abstractC0858pW.mo3944a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, abstractC0858pW.m3950i().clip(eyePosition, vec3Add).isPresent());
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6092a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2) {
        if (!localPlayer.isCreative()) {
            return;
        }
        Vec3 viewVector = localPlayer.getViewVector(1.0f);
        Vec3 eyePosition = localPlayer.getEyePosition(1.0f);
        Vec3 vec3Add = eyePosition.add(viewVector.scale(64.0d));
        ObjectArrayList<Pair> objectArrayList = new ObjectArrayList();
        for (AbstractC0858pW abstractC0858pW : this.f5948bQ) {
            if (!abstractC0858pW.m3950i().clip(eyePosition, vec3Add).isEmpty()) {
                ObjectArrayList objectArrayList2 = new ObjectArrayList();
                abstractC0858pW.mo3938a(minecraft, c0623l, localPlayer, clientLevel, (List<Component>) objectArrayList2);
                objectArrayList.add(Pair.of(abstractC0858pW.mo3951y(), objectArrayList2));
            }
        }
        if (objectArrayList.isEmpty()) {
            return;
        }
        int i3 = i + 16;
        int i4 = i2 + 16;
        int i5 = 0;
        int iM465t = C0129bt.m465t();
        for (Pair pair : objectArrayList) {
            ResourceLocation resourceLocation = (ResourceLocation) pair.first();
            List list = (List) pair.second();
            int i6 = i3 + 32 + 2;
            int size = list.size();
            Objects.requireNonNull(font);
            int i7 = (size * 9) + 2;
            int i8 = 0;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iWidth = font.width((Component) it.next());
                if (iWidth > i8) {
                    i8 = iWidth;
                }
            }
            int i9 = i4 + i5;
            C0129bt.m591c(guiGraphics, i6, i9, i8 + 3, i7, iM465t);
            C0129bt.m529a(poseStack, guiGraphics, resourceLocation, i3, i9, 32);
            int i10 = 0;
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                C0129bt.m479b(font, guiGraphics, (Component) it2.next(), i6 + 2, i9 + i10 + 2);
                Objects.requireNonNull(font);
                i10 += 9;
            }
            i5 += i7 + 3;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6093a(@NotNull AbstractC0858pW abstractC0858pW) {
        this.f5945bO.add(abstractC0858pW);
        this.f5948bQ.add(abstractC0858pW);
        m6094dn();
    }

    /* JADX INFO: renamed from: dn */
    private void m6094dn() {
        if (C0529jL.m2332ae()) {
            this.f5949a.clear();
            for (Object obj : this.f5948bQ) {
                if (obj instanceof InterfaceC0919qe) {
                    InterfaceC0919qe interfaceC0919qe = (InterfaceC0919qe) obj;
                    ((List) this.f5949a.computeIfAbsent(interfaceC0919qe.mo4651a(), obj2 -> {
                        return new ObjectArrayList();
                    })).add(interfaceC0919qe);
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m6095a(@NotNull String str, boolean z) {
        for (AbstractC0858pW abstractC0858pW : this.f5948bQ) {
            if (str.equals(abstractC0858pW.f4594cg) || str.equals(abstractC0858pW.f4592y.toString())) {
                abstractC0858pW.f4596gF = z;
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0858pW m6096a(@NotNull UUID uuid) {
        for (AbstractC0858pW abstractC0858pW : this.f5948bQ) {
            if (abstractC0858pW.f4592y.equals(uuid)) {
                return abstractC0858pW;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public void m6097b(@NotNull AbstractC0858pW abstractC0858pW) {
        this.f5945bO.remove(abstractC0858pW);
        this.f5947Y.remove(abstractC0858pW.f4592y);
        this.f5948bQ.remove(abstractC0858pW);
        m6094dn();
    }

    /* JADX INFO: renamed from: c */
    public void m6098c(@NotNull AbstractC0858pW abstractC0858pW) {
        for (int i = 0; i < this.f5945bO.size(); i++) {
            if (this.f5945bO.get(i).f4592y.equals(abstractC0858pW.f4592y)) {
                this.f5945bO.set(i, abstractC0858pW);
                break;
            }
        }
        for (int i2 = 0; i2 < this.f5948bQ.size(); i2++) {
            if (this.f5948bQ.get(i2).f4592y.equals(abstractC0858pW.f4592y)) {
                this.f5948bQ.set(i2, abstractC0858pW);
                m6094dn();
                return;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m6099b(@NotNull C0607kk c0607kk) {
        if (!this.f5947Y.isEmpty()) {
            this.f5948bQ.removeIf(abstractC0858pW -> {
                return this.f5947Y.containsKey(abstractC0858pW.f4592y);
            });
            this.f5947Y.clear();
        }
        for (int i = 0; i < this.f5946bP.size(); i++) {
            C0576kF c0576kF = this.f5946bP.get(i);
            AbstractC0858pW abstractC0858pWM2603a = c0576kF.m2603a(c0607kk, i);
            if (abstractC0858pWM2603a != null) {
                this.f5948bQ.add(abstractC0858pWM2603a);
                this.f5947Y.put(abstractC0858pWM2603a.f4592y, c0576kF);
            }
        }
        m6094dn();
    }

    /* JADX INFO: renamed from: p */
    public boolean m6100p(@NotNull UUID uuid) {
        return this.f5947Y.containsKey(uuid);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0576kF m6101a(@NotNull UUID uuid) {
        return this.f5947Y.get(uuid);
    }

    /* JADX INFO: renamed from: a */
    public void m6102a(@NotNull C0576kF c0576kF) {
        this.f5946bP.add(c0576kF);
    }

    /* JADX INFO: renamed from: b */
    public void m6103b(@NotNull C0576kF c0576kF) {
        this.f5946bP.remove(c0576kF);
        this.f5947Y.entrySet().removeIf(entry -> {
            if (entry.getValue() == c0576kF) {
                this.f5948bQ.removeIf(abstractC0858pW -> {
                    return abstractC0858pW.f4592y.equals(entry.getKey());
                });
                return true;
            }
            return false;
        });
        m6094dn();
    }

    @NotNull
    /* JADX INFO: renamed from: aD */
    public List<C0576kF> m6104aD() {
        return this.f5946bP;
    }

    @NotNull
    /* JADX INFO: renamed from: p */
    public Map<UUID, C0576kF> m6105p() {
        return this.f5947Y;
    }

    @NotNull
    /* JADX INFO: renamed from: aE */
    public List<AbstractC0858pW> m6106aE() {
        return this.f5945bO;
    }

    @NotNull
    /* JADX INFO: renamed from: az */
    public List<AbstractC0858pW> m6107az() {
        return this.f5948bQ;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1096tv m6108a(int i) {
        this.f5944aN = i;
        return this;
    }

    /* JADX INFO: renamed from: by */
    public int m6109by() {
        return this.f5944aN;
    }

    /* JADX INFO: renamed from: b */
    public void m6110b(int i, float f) {
        this.f5959tp = i;
        this.f5958mU = f;
    }

    /* JADX INFO: renamed from: do */
    public void m6111do() {
        this.f5958mU = 0.0f;
        this.f5959tp = ColorReferences.COLOR_WHITE;
    }

    /* JADX INFO: renamed from: ch */
    public boolean m6112ch() {
        return this.f5958mU > 0.0f;
    }

    /* JADX INFO: renamed from: cd */
    public int m6113cd() {
        return this.f5959tp;
    }

    /* JADX INFO: renamed from: bb */
    public float m6114bb() {
        return this.f5958mU;
    }

    /* JADX INFO: renamed from: I */
    public void m6115I(int i) {
        this.f5960hQ = true;
        this.f5961tq = i;
    }

    /* JADX INFO: renamed from: ci */
    public boolean m6116ci() {
        return this.f5960hQ;
    }

    /* JADX INFO: renamed from: ce */
    public int m6117ce() {
        return this.f5961tq;
    }

    /* JADX INFO: renamed from: c */
    public void m6118c(int i, float f) {
        this.f5963tr = i;
        this.f5962mV = f;
    }

    /* JADX INFO: renamed from: dp */
    public void m6119dp() {
        this.f5962mV = 0.0f;
        this.f5963tr = ColorReferences.COLOR_WHITE;
    }

    /* JADX INFO: renamed from: cj */
    public boolean m6120cj() {
        return this.f5962mV > 0.0f;
    }

    /* JADX INFO: renamed from: cf */
    public int m6121cf() {
        return this.f5963tr;
    }

    /* JADX INFO: renamed from: bc */
    public float m6122bc() {
        return this.f5962mV;
    }

    /* JADX INFO: renamed from: d */
    public void m6123d(int i, float f) {
        this.f5965ts = i;
        this.f5964mW = f;
    }

    /* JADX INFO: renamed from: dq */
    public void m6124dq() {
        this.f5964mW = 0.0f;
        this.f5965ts = ColorReferences.COLOR_WHITE;
    }

    /* JADX INFO: renamed from: ck */
    public boolean m6125ck() {
        return this.f5964mW > 0.0f;
    }

    /* JADX INFO: renamed from: cg */
    public int m6126cg() {
        return this.f5965ts;
    }

    /* JADX INFO: renamed from: bd */
    public float m6127bd() {
        return this.f5964mW;
    }

    /* JADX INFO: renamed from: n */
    public void m6128n(float f) {
        this.f5966mX = Mth.clamp(f, 0.0f, 1.0f);
    }

    /* JADX INFO: renamed from: dr */
    public void m6129dr() {
        this.f5966mX = 0.0f;
    }

    /* JADX INFO: renamed from: be */
    public float m6130be() {
        return this.f5966mX;
    }

    /* JADX INFO: renamed from: cl */
    public boolean m6131cl() {
        return this.f5966mX > 0.0f;
    }

    /* JADX INFO: renamed from: T */
    public void m6132T(boolean z) {
        this.f5968gQ = z;
    }

    /* JADX INFO: renamed from: cm */
    public boolean m6133cm() {
        return this.f5968gQ;
    }

    /* JADX INFO: renamed from: b */
    public void m6134b(float f, float f2, float f3) {
        this.f5956mz = f;
        this.f5957mA = f2;
        this.f5955mT = f3;
    }

    /* JADX INFO: renamed from: ds */
    public void m6135ds() {
        this.f5955mT = 0.0f;
        this.f5956mz = 0.0f;
        this.f5957mA = 0.0f;
    }

    /* JADX INFO: renamed from: cn */
    public boolean m6136cn() {
        return this.f5955mT > 0.0f;
    }

    /* JADX INFO: renamed from: bf */
    public float m6137bf() {
        return this.f5955mT;
    }

    /* JADX INFO: renamed from: bg */
    public float m6138bg() {
        return this.f5956mz;
    }

    /* JADX INFO: renamed from: bh */
    public float m6139bh() {
        return this.f5957mA;
    }

    /* JADX INFO: renamed from: U */
    public void m6140U(boolean z) {
        this.f5969gP = z;
    }

    /* JADX INFO: renamed from: co */
    public boolean m6141co() {
        return this.f5969gP;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1096tv m6142a(@Nullable ResourceLocation resourceLocation) {
        this.f5953ey = resourceLocation;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: N */
    public ResourceLocation m6143N() {
        return this.f5953ey;
    }

    /* JADX INFO: renamed from: c */
    public void m6144c(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeString(byteBuf, this.f5954dd);
        int size = this.f5948bQ.size();
        byteBuf.writeInt(size);
        for (int i = 0; i < size; i++) {
            C0859pX.f4606d.encode(byteBuf, this.f5948bQ.get(i));
        }
    }

    /* JADX INFO: renamed from: cM */
    public void m6145cM() {
        Iterator<AbstractC0858pW> it = this.f5948bQ.iterator();
        while (it.hasNext()) {
            it.next().mo3956cM();
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m6146a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        Iterator<AbstractC0858pW> it = this.f5948bQ.iterator();
        while (it.hasNext()) {
            it.next().mo3939a(minecraft, randomSource);
        }
    }
}
