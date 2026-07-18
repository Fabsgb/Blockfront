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

/* JADX INFO: renamed from: com.boehmod.blockfront.sY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sY.class */
public class C1018sY {

    /* JADX INFO: renamed from: cS */
    public static final String f5378cS = "default";

    /* JADX INFO: renamed from: ac */
    @NotNull
    public static final Codec<C1018sY> f5379ac = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("name").forGetter((v0) -> {
            return v0.getName();
        }), C0836pB.f4476H.listOf().optionalFieldOf("mapEffects", List.of()).forGetter((v0) -> {
            return v0.m5618aC();
        }), C0605kj.f3312n.listOf().optionalFieldOf("mapEffectTemplates", List.of()).forGetter((v0) -> {
            return v0.m5616aB();
        })).apply(instance, C1018sY::m5588a);
    });

    /* JADX INFO: renamed from: Z */
    private int f5380Z;

    /* JADX INFO: renamed from: cT */
    private final String f5390cT;

    /* JADX INFO: renamed from: bH */
    @NotNull
    private final List<AbstractC0835pA> f5381bH = new ObjectArrayList();

    /* JADX INFO: renamed from: bI */
    @NotNull
    private final List<C0605kj> f5382bI = new ObjectArrayList();

    /* JADX INFO: renamed from: Y */
    @NotNull
    private final Map<UUID, C0605kj> f5383Y = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: bJ */
    @NotNull
    private final List<AbstractC0835pA> f5384bJ = new ObjectArrayList();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Reference2ObjectMap<RenderLevelStageEvent.Stage, List<InterfaceC0843pI>> f5385a = new Reference2ObjectOpenHashMap();

    /* JADX INFO: renamed from: bK */
    @NotNull
    private final List<InterfaceC0841pG> f5386bK = new ObjectArrayList();

    /* JADX INFO: renamed from: bL */
    @NotNull
    private final List<InterfaceC0839pE> f5387bL = new ObjectArrayList();

    /* JADX INFO: renamed from: bM */
    @NotNull
    private final List<InterfaceC0846pL> f5388bM = new ObjectArrayList();

    /* JADX INFO: renamed from: ez */
    @Nullable
    private ResourceLocation f5389ez = null;

    /* JADX INFO: renamed from: lU */
    private float f5391lU = 0.0f;

    /* JADX INFO: renamed from: lA */
    private float f5392lA = 0.0f;

    /* JADX INFO: renamed from: lB */
    private float f5393lB = 0.0f;

    /* JADX INFO: renamed from: lV */
    private float f5394lV = 0.0f;

    /* JADX INFO: renamed from: ro */
    private int f5395ro = ColorReferences.COLOR_WHITE;

    /* JADX INFO: renamed from: hw */
    private boolean f5396hw = false;

    /* JADX INFO: renamed from: rp */
    private int f5397rp = ColorReferences.COLOR_WHITE;

    /* JADX INFO: renamed from: lW */
    private float f5398lW = 0.0f;

    /* JADX INFO: renamed from: rq */
    private int f5399rq = ColorReferences.COLOR_WHITE;

    /* JADX INFO: renamed from: lX */
    private float f5400lX = 0.0f;

    /* JADX INFO: renamed from: rr */
    private int f5401rr = ColorReferences.COLOR_WHITE;

    /* JADX INFO: renamed from: lY */
    private float f5402lY = 0.0f;

    /* JADX INFO: renamed from: aF */
    private double f5403aF = -1.0d;

    /* JADX INFO: renamed from: gw */
    private boolean f5404gw = false;

    /* JADX INFO: renamed from: gv */
    private boolean f5405gv = false;

    /* JADX INFO: renamed from: l */
    @NotNull
    private final C0597kb f5406l = new C0597kb();

    @NotNull
    /* JADX INFO: renamed from: a */
    private static C1018sY m5588a(String str, List<AbstractC0835pA> list, List<C0605kj> list2) {
        C1018sY c1018sY = new C1018sY(str);
        c1018sY.f5381bH.addAll(list);
        c1018sY.f5384bJ.addAll(list);
        c1018sY.f5382bI.addAll(list2);
        c1018sY.m5606db();
        return c1018sY;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public boolean m5589a(@NotNull RenderLevelStageEvent.Stage stage) {
        List list = (List) this.f5385a.get(stage);
        return (list == null || list.isEmpty()) ? false : true;
    }

    public C1018sY(@NotNull String str) {
        this.f5390cT = str;
    }

    public C1018sY(@NotNull ByteBuf byteBuf) throws IOException {
        this.f5390cT = IPacket.readString(byteBuf);
        this.f5384bJ.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.f5384bJ.add((AbstractC0835pA) C0836pB.f4477d.decode(byteBuf));
        }
        m5606db();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0597kb m5590a() {
        return this.f5406l;
    }

    @NotNull
    public String getName() {
        return this.f5390cT;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public void m5591a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        double d = -1.0d;
        for (AbstractC0835pA abstractC0835pA : this.f5384bJ) {
            abstractC0835pA.mo4217a(serverLevel, abstractC0563ju, abstractC0787oF, serverLevel.getRandom(), set);
            if (abstractC0835pA instanceof InterfaceC0838pD) {
                double dMo4264aN = ((InterfaceC0838pD) abstractC0835pA).mo4264aN();
                if (dMo4264aN > 0.0d && (d < 0.0d || dMo4264aN < d)) {
                    d = dMo4264aN;
                }
            }
        }
        this.f5403aF = d;
    }

    /* JADX INFO: renamed from: t */
    public double m5592t() {
        return this.f5403aF;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: G */
    public void m5593G(@NotNull Minecraft minecraft) {
        this.f5391lU = 0.0f;
        this.f5392lA = 0.0f;
        this.f5393lB = 0.0f;
        this.f5398lW = 0.0f;
        this.f5399rq = ColorReferences.COLOR_WHITE;
        this.f5394lV = 0.0f;
        this.f5395ro = ColorReferences.COLOR_WHITE;
        this.f5396hw = false;
        this.f5397rp = ColorReferences.COLOR_WHITE;
        this.f5400lX = 0.0f;
        this.f5401rr = ColorReferences.COLOR_WHITE;
        this.f5402lY = 0.0f;
        this.f5404gw = false;
        this.f5405gv = false;
        this.f5380Z = 0;
        this.f5389ez = null;
        this.f5386bK.clear();
        this.f5387bL.clear();
        this.f5388bM.clear();
        Iterator<AbstractC0835pA> it = this.f5384bJ.iterator();
        while (it.hasNext()) {
            it.next().mo4218a(minecraft, this);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m5594a(@NotNull InterfaceC0841pG interfaceC0841pG) {
        this.f5386bK.add(interfaceC0841pG);
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: ay */
    public List<InterfaceC0841pG> m5595ay() {
        return this.f5386bK;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m5596a(@NotNull InterfaceC0839pE interfaceC0839pE) {
        this.f5387bL.add(interfaceC0839pE);
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: az */
    public List<InterfaceC0839pE> m5597az() {
        return this.f5387bL;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m5598a(@NotNull InterfaceC0846pL interfaceC0846pL) {
        this.f5388bM.add(interfaceC0846pL);
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: aA */
    public List<InterfaceC0846pL> m5599aA() {
        return this.f5388bM;
    }

    /* JADX INFO: renamed from: da */
    public void m5600da() {
        Iterator<AbstractC0835pA> it = this.f5384bJ.iterator();
        while (it.hasNext()) {
            it.next().mo4224cA();
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m5601a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, float f) {
        boolean zUseFancyGraphics = Minecraft.useFancyGraphics();
        for (AbstractC0835pA abstractC0835pA : this.f5384bJ) {
            if (abstractC0835pA.f4467gl && (zUseFancyGraphics || !abstractC0835pA.mo4223bw())) {
                abstractC0835pA.mo4220a(minecraft, c0622l, randomSource, abstractC0787oF, localPlayer, clientLevel, f);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m5602a(@NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, float f, float f2) {
        List<InterfaceC0843pI> list = (List) this.f5385a.get(renderLevelStageEvent.getStage());
        if (list != null) {
            boolean zUseFancyGraphics = Minecraft.useFancyGraphics();
            ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
            for (InterfaceC0843pI interfaceC0843pI : list) {
                AbstractC0835pA abstractC0835pA = (AbstractC0835pA) interfaceC0843pI;
                if (abstractC0835pA.f4467gl && (zUseFancyGraphics || !abstractC0835pA.mo4223bw())) {
                    interfaceC0843pI.mo4270a(minecraft, c0622l, localPlayer, clientLevel, blockRenderDispatcher, bufferSource, threadLocalRandomCurrent, renderLevelStageEvent, guiGraphics, poseStack, camera, f, f2);
                }
            }
        }
        if (renderLevelStageEvent.getStage() == RenderLevelStageEvent.Stage.AFTER_PARTICLES) {
            m5603a(renderLevelStageEvent, minecraft, localPlayer, clientLevel, bufferSource, guiGraphics.pose(), guiGraphics, font, camera, f2);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m5603a(@NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull Minecraft minecraft, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, float f) {
        if (renderLevelStageEvent.getStage() != RenderLevelStageEvent.Stage.AFTER_PARTICLES || clientLevel == null || localPlayer == null || !localPlayer.isCreative()) {
            return;
        }
        if (minecraft.getDebugOverlay().showDebugScreen()) {
            for (C0680mE c0680mE : clientLevel.entitiesForRendering()) {
                if (c0680mE instanceof C0680mE) {
                    C0119bk.m474a(camera, poseStack, c0680mE.getEyePosition(f), c0680mE.m3076b().getCenter(), 1.0f, 16776960);
                }
            }
        }
        Vec3 viewVector = localPlayer.getViewVector(1.0f);
        Vec3 eyePosition = localPlayer.getEyePosition(1.0f);
        Vec3 vec3Add = eyePosition.add(viewVector.scale(64.0d));
        for (AbstractC0835pA abstractC0835pA : this.f5384bJ) {
            abstractC0835pA.mo4221a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, abstractC0835pA.m4215i().clip(eyePosition, vec3Add).isPresent());
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5604a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2) {
        if (!localPlayer.isCreative()) {
            return;
        }
        Vec3 viewVector = localPlayer.getViewVector(1.0f);
        Vec3 eyePosition = localPlayer.getEyePosition(1.0f);
        Vec3 vec3Add = eyePosition.add(viewVector.scale(64.0d));
        ObjectArrayList<Pair> objectArrayList = new ObjectArrayList();
        for (AbstractC0835pA abstractC0835pA : this.f5384bJ) {
            if (!abstractC0835pA.m4215i().clip(eyePosition, vec3Add).isEmpty()) {
                ObjectArrayList objectArrayList2 = new ObjectArrayList();
                abstractC0835pA.mo4222a(minecraft, c0622l, localPlayer, clientLevel, (List<Component>) objectArrayList2);
                objectArrayList.add(Pair.of(abstractC0835pA.mo4216x(), objectArrayList2));
            }
        }
        if (objectArrayList.isEmpty()) {
            return;
        }
        int i3 = i + 16;
        int i4 = i2 + 16;
        int i5 = 0;
        int iM365p = C0119bk.m365p();
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
            C0119bk.m491c(guiGraphics, i6, i9, i8 + 3, i7, iM365p);
            C0119bk.m429a(poseStack, guiGraphics, resourceLocation, i3, i9, 32);
            int i10 = 0;
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                C0119bk.m379b(font, guiGraphics, (Component) it2.next(), i6 + 2, i9 + i10 + 2);
                Objects.requireNonNull(font);
                i10 += 9;
            }
            i5 += i7 + 3;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5605a(@NotNull AbstractC0835pA abstractC0835pA) {
        this.f5381bH.add(abstractC0835pA);
        this.f5384bJ.add(abstractC0835pA);
        m5606db();
    }

    /* JADX INFO: renamed from: db */
    private void m5606db() {
        if (C0561js.m2512ab()) {
            this.f5385a.clear();
            for (Object obj : this.f5384bJ) {
                if (obj instanceof InterfaceC0843pI) {
                    InterfaceC0843pI interfaceC0843pI = (InterfaceC0843pI) obj;
                    ((List) this.f5385a.computeIfAbsent(interfaceC0843pI.mo4269a(), obj2 -> {
                        return new ObjectArrayList();
                    })).add(interfaceC0843pI);
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m5607a(@NotNull String str, boolean z) {
        for (AbstractC0835pA abstractC0835pA : this.f5384bJ) {
            if (str.equals(abstractC0835pA.f4465bW) || str.equals(abstractC0835pA.f4463y.toString())) {
                abstractC0835pA.f4467gl = z;
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC0835pA m5608a(@NotNull UUID uuid) {
        for (AbstractC0835pA abstractC0835pA : this.f5384bJ) {
            if (abstractC0835pA.f4463y.equals(uuid)) {
                return abstractC0835pA;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public void m5609b(@NotNull AbstractC0835pA abstractC0835pA) {
        this.f5381bH.remove(abstractC0835pA);
        this.f5383Y.remove(abstractC0835pA.f4463y);
        this.f5384bJ.remove(abstractC0835pA);
        m5606db();
    }

    /* JADX INFO: renamed from: c */
    public void m5610c(@NotNull AbstractC0835pA abstractC0835pA) {
        int i = 0;
        while (true) {
            if (i >= this.f5381bH.size()) {
                break;
            }
            if (!this.f5381bH.get(i).f4463y.equals(abstractC0835pA.f4463y)) {
                i++;
            } else {
                this.f5381bH.set(i, abstractC0835pA);
                break;
            }
        }
        for (int i2 = 0; i2 < this.f5384bJ.size(); i2++) {
            if (this.f5384bJ.get(i2).f4463y.equals(abstractC0835pA.f4463y)) {
                this.f5384bJ.set(i2, abstractC0835pA);
                m5606db();
                return;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m5611b(@NotNull C0531jO c0531jO) {
        if (!this.f5383Y.isEmpty()) {
            this.f5384bJ.removeIf(abstractC0835pA -> {
                return this.f5383Y.containsKey(abstractC0835pA.f4463y);
            });
            this.f5383Y.clear();
        }
        for (int i = 0; i < this.f5382bI.size(); i++) {
            C0605kj c0605kj = this.f5382bI.get(i);
            AbstractC0835pA abstractC0835pAM2650a = c0605kj.m2650a(c0531jO, i);
            if (abstractC0835pAM2650a != null) {
                this.f5384bJ.add(abstractC0835pAM2650a);
                this.f5383Y.put(abstractC0835pAM2650a.f4463y, c0605kj);
            }
        }
        m5606db();
    }

    /* JADX INFO: renamed from: p */
    public boolean m5612p(@NotNull UUID uuid) {
        return this.f5383Y.containsKey(uuid);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0605kj m5613a(@NotNull UUID uuid) {
        return this.f5383Y.get(uuid);
    }

    /* JADX INFO: renamed from: a */
    public void m5614a(@NotNull C0605kj c0605kj) {
        this.f5382bI.add(c0605kj);
    }

    /* JADX INFO: renamed from: b */
    public void m5615b(@NotNull C0605kj c0605kj) {
        this.f5382bI.remove(c0605kj);
        this.f5383Y.entrySet().removeIf(entry -> {
            if (entry.getValue() == c0605kj) {
                this.f5384bJ.removeIf(abstractC0835pA -> {
                    return abstractC0835pA.f4463y.equals(entry.getKey());
                });
                return true;
            }
            return false;
        });
        m5606db();
    }

    @NotNull
    /* JADX INFO: renamed from: aB */
    public List<C0605kj> m5616aB() {
        return this.f5382bI;
    }

    @NotNull
    /* JADX INFO: renamed from: p */
    public Map<UUID, C0605kj> m5617p() {
        return this.f5383Y;
    }

    @NotNull
    /* JADX INFO: renamed from: aC */
    public List<AbstractC0835pA> m5618aC() {
        return this.f5381bH;
    }

    @NotNull
    /* JADX INFO: renamed from: ax */
    public List<AbstractC0835pA> m5619ax() {
        return this.f5384bJ;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1018sY m5620a(int i) {
        this.f5380Z = i;
        return this;
    }

    /* JADX INFO: renamed from: bj */
    public int m5621bj() {
        return this.f5380Z;
    }

    /* JADX INFO: renamed from: b */
    public void m5622b(int i, float f) {
        this.f5395ro = i;
        this.f5394lV = f;
    }

    /* JADX INFO: renamed from: dc */
    public void m5623dc() {
        this.f5394lV = 0.0f;
        this.f5395ro = ColorReferences.COLOR_WHITE;
    }

    /* JADX INFO: renamed from: bX */
    public boolean m5624bX() {
        return this.f5394lV > 0.0f;
    }

    /* JADX INFO: renamed from: bO */
    public int m5625bO() {
        return this.f5395ro;
    }

    /* JADX INFO: renamed from: aV */
    public float m5626aV() {
        return this.f5394lV;
    }

    /* JADX INFO: renamed from: H */
    public void m5627H(int i) {
        this.f5396hw = true;
        this.f5397rp = i;
    }

    /* JADX INFO: renamed from: bY */
    public boolean m5628bY() {
        return this.f5396hw;
    }

    /* JADX INFO: renamed from: bP */
    public int m5629bP() {
        return this.f5397rp;
    }

    /* JADX INFO: renamed from: c */
    public void m5630c(int i, float f) {
        this.f5399rq = i;
        this.f5398lW = f;
    }

    /* JADX INFO: renamed from: dd */
    public void m5631dd() {
        this.f5398lW = 0.0f;
        this.f5399rq = ColorReferences.COLOR_WHITE;
    }

    /* JADX INFO: renamed from: bZ */
    public boolean m5632bZ() {
        return this.f5398lW > 0.0f;
    }

    /* JADX INFO: renamed from: bQ */
    public int m5633bQ() {
        return this.f5399rq;
    }

    /* JADX INFO: renamed from: aW */
    public float m5634aW() {
        return this.f5398lW;
    }

    /* JADX INFO: renamed from: d */
    public void m5635d(int i, float f) {
        this.f5401rr = i;
        this.f5400lX = f;
    }

    /* JADX INFO: renamed from: de */
    public void m5636de() {
        this.f5400lX = 0.0f;
        this.f5401rr = ColorReferences.COLOR_WHITE;
    }

    /* JADX INFO: renamed from: ca */
    public boolean m5637ca() {
        return this.f5400lX > 0.0f;
    }

    /* JADX INFO: renamed from: bR */
    public int m5638bR() {
        return this.f5401rr;
    }

    /* JADX INFO: renamed from: aX */
    public float m5639aX() {
        return this.f5400lX;
    }

    /* JADX INFO: renamed from: o */
    public void m5640o(float f) {
        this.f5402lY = Mth.clamp(f, 0.0f, 1.0f);
    }

    /* JADX INFO: renamed from: df */
    public void m5641df() {
        this.f5402lY = 0.0f;
    }

    /* JADX INFO: renamed from: aY */
    public float m5642aY() {
        return this.f5402lY;
    }

    /* JADX INFO: renamed from: cb */
    public boolean m5643cb() {
        return this.f5402lY > 0.0f;
    }

    /* JADX INFO: renamed from: S */
    public void m5644S(boolean z) {
        this.f5404gw = z;
    }

    /* JADX INFO: renamed from: cc */
    public boolean m5645cc() {
        return this.f5404gw;
    }

    /* JADX INFO: renamed from: b */
    public void m5646b(float f, float f2, float f3) {
        this.f5392lA = f;
        this.f5393lB = f2;
        this.f5391lU = f3;
    }

    /* JADX INFO: renamed from: dg */
    public void m5647dg() {
        this.f5391lU = 0.0f;
        this.f5392lA = 0.0f;
        this.f5393lB = 0.0f;
    }

    /* JADX INFO: renamed from: cd */
    public boolean m5648cd() {
        return this.f5391lU > 0.0f;
    }

    /* JADX INFO: renamed from: aZ */
    public float m5649aZ() {
        return this.f5391lU;
    }

    /* JADX INFO: renamed from: ba */
    public float m5650ba() {
        return this.f5392lA;
    }

    /* JADX INFO: renamed from: bb */
    public float m5651bb() {
        return this.f5393lB;
    }

    /* JADX INFO: renamed from: T */
    public void m5652T(boolean z) {
        this.f5405gv = z;
    }

    /* JADX INFO: renamed from: ce */
    public boolean m5653ce() {
        return this.f5405gv;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1018sY m5654a(@Nullable ResourceLocation resourceLocation) {
        this.f5389ez = resourceLocation;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: M */
    public ResourceLocation m5655M() {
        return this.f5389ez;
    }

    /* JADX INFO: renamed from: c */
    public void m5656c(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeString(byteBuf, this.f5390cT);
        int size = this.f5384bJ.size();
        byteBuf.writeInt(size);
        for (int i = 0; i < size; i++) {
            C0836pB.f4477d.encode(byteBuf, this.f5384bJ.get(i));
        }
    }

    /* JADX INFO: renamed from: cA */
    public void m5657cA() {
        Iterator<AbstractC0835pA> it = this.f5384bJ.iterator();
        while (it.hasNext()) {
            it.next().mo4224cA();
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m5658a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        Iterator<AbstractC0835pA> it = this.f5384bJ.iterator();
        while (it.hasNext()) {
            it.next().mo4225a(minecraft, randomSource);
        }
    }
}
