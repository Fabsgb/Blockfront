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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sY.class */
public class sY {
    public static final String cS = "default";

    @NotNull
    public static final Codec<sY> ac = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("name").forGetter((v0) -> {
            return v0.getName();
        }), pB.H.listOf().optionalFieldOf("mapEffects", List.of()).forGetter((v0) -> {
            return v0.aC();
        }), C0280kj.n.listOf().optionalFieldOf("mapEffectTemplates", List.of()).forGetter((v0) -> {
            return v0.aB();
        })).apply(instance, sY::a);
    });
    private int Z;
    private final String cT;

    @NotNull
    private final List<pA> bH = new ObjectArrayList();

    @NotNull
    private final List<C0280kj> bI = new ObjectArrayList();

    @NotNull
    private final Map<UUID, C0280kj> Y = new Object2ObjectOpenHashMap();

    @NotNull
    private final List<pA> bJ = new ObjectArrayList();

    @NotNull
    private final Reference2ObjectMap<RenderLevelStageEvent.Stage, List<pI>> a = new Reference2ObjectOpenHashMap();

    @NotNull
    private final List<pG> bK = new ObjectArrayList();

    @NotNull
    private final List<pE> bL = new ObjectArrayList();

    @NotNull
    private final List<pL> bM = new ObjectArrayList();

    @Nullable
    private ResourceLocation ez = null;
    private float lU = 0.0f;
    private float lA = 0.0f;
    private float lB = 0.0f;
    private float lV = 0.0f;
    private int ro = ColorReferences.COLOR_WHITE;
    private boolean hw = false;
    private int rp = ColorReferences.COLOR_WHITE;
    private float lW = 0.0f;
    private int rq = ColorReferences.COLOR_WHITE;
    private float lX = 0.0f;
    private int rr = ColorReferences.COLOR_WHITE;
    private float lY = 0.0f;
    private double aF = -1.0d;
    private boolean gw = false;
    private boolean gv = false;

    @NotNull
    private final C0272kb l = new C0272kb();

    @NotNull
    private static sY a(String str, List<pA> list, List<C0280kj> list2) {
        sY sYVar = new sY(str);
        sYVar.bH.addAll(list);
        sYVar.bJ.addAll(list);
        sYVar.bI.addAll(list2);
        sYVar.db();
        return sYVar;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean a(@NotNull RenderLevelStageEvent.Stage stage) {
        List list = (List) this.a.get(stage);
        return (list == null || list.isEmpty()) ? false : true;
    }

    public sY(@NotNull String str) {
        this.cT = str;
    }

    public sY(@NotNull ByteBuf byteBuf) throws IOException {
        this.cT = IPacket.readString(byteBuf);
        this.bJ.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.bJ.add((pA) pB.d.decode(byteBuf));
        }
        db();
    }

    @NotNull
    public C0272kb a() {
        return this.l;
    }

    @NotNull
    public String getName() {
        return this.cT;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(@NotNull oF<?, ?, ?> oFVar, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        double d = -1.0d;
        for (pA pAVar : this.bJ) {
            pAVar.a(serverLevel, abstractC0264ju, oFVar, serverLevel.getRandom(), set);
            if (pAVar instanceof pD) {
                double dAN = ((pD) pAVar).aN();
                if (dAN > 0.0d && (d < 0.0d || dAN < d)) {
                    d = dAN;
                }
            }
        }
        this.aF = d;
    }

    public double t() {
        return this.aF;
    }

    @OnlyIn(Dist.CLIENT)
    public void G(@NotNull Minecraft minecraft) {
        this.lU = 0.0f;
        this.lA = 0.0f;
        this.lB = 0.0f;
        this.lW = 0.0f;
        this.rq = ColorReferences.COLOR_WHITE;
        this.lV = 0.0f;
        this.ro = ColorReferences.COLOR_WHITE;
        this.hw = false;
        this.rp = ColorReferences.COLOR_WHITE;
        this.lX = 0.0f;
        this.rr = ColorReferences.COLOR_WHITE;
        this.lY = 0.0f;
        this.gw = false;
        this.gv = false;
        this.Z = 0;
        this.ez = null;
        this.bK.clear();
        this.bL.clear();
        this.bM.clear();
        Iterator<pA> it = this.bJ.iterator();
        while (it.hasNext()) {
            it.next().a(minecraft, this);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull pG pGVar) {
        this.bK.add(pGVar);
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    public List<pG> ay() {
        return this.bK;
    }

    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull pE pEVar) {
        this.bL.add(pEVar);
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    public List<pE> az() {
        return this.bL;
    }

    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull pL pLVar) {
        this.bM.add(pLVar);
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    public List<pL> aA() {
        return this.bM;
    }

    public void da() {
        Iterator<pA> it = this.bJ.iterator();
        while (it.hasNext()) {
            it.next().cA();
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull RandomSource randomSource, float f) {
        boolean zUseFancyGraphics = Minecraft.useFancyGraphics();
        for (pA pAVar : this.bJ) {
            if (pAVar.gl && (zUseFancyGraphics || !pAVar.bw())) {
                pAVar.a(minecraft, c0297l, randomSource, oFVar, localPlayer, clientLevel, f);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull BlockRenderDispatcher blockRenderDispatcher, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, float f, float f2) {
        List<pI> list = (List) this.a.get(renderLevelStageEvent.getStage());
        if (list != null) {
            boolean zUseFancyGraphics = Minecraft.useFancyGraphics();
            ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
            for (pI pIVar : list) {
                pA pAVar = (pA) pIVar;
                if (pAVar.gl && (zUseFancyGraphics || !pAVar.bw())) {
                    pIVar.a(minecraft, c0297l, localPlayer, clientLevel, blockRenderDispatcher, bufferSource, threadLocalRandomCurrent, renderLevelStageEvent, guiGraphics, poseStack, camera, f, f2);
                }
            }
        }
        if (renderLevelStageEvent.getStage() == RenderLevelStageEvent.Stage.AFTER_PARTICLES) {
            a(renderLevelStageEvent, minecraft, localPlayer, clientLevel, bufferSource, guiGraphics.pose(), guiGraphics, font, camera, f2);
        }
    }

    @OnlyIn(Dist.CLIENT)
    private void a(@NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull Minecraft minecraft, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, float f) {
        if (renderLevelStageEvent.getStage() != RenderLevelStageEvent.Stage.AFTER_PARTICLES || clientLevel == null || localPlayer == null || !localPlayer.isCreative()) {
            return;
        }
        if (minecraft.getDebugOverlay().showDebugScreen()) {
            for (mE mEVar : clientLevel.entitiesForRendering()) {
                if (mEVar instanceof mE) {
                    C0040bk.a(camera, poseStack, mEVar.getEyePosition(f), mEVar.m674b().getCenter(), 1.0f, 16776960);
                }
            }
        }
        Vec3 viewVector = localPlayer.getViewVector(1.0f);
        Vec3 eyePosition = localPlayer.getEyePosition(1.0f);
        Vec3 vec3Add = eyePosition.add(viewVector.scale(64.0d));
        for (pA pAVar : this.bJ) {
            pAVar.a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, pAVar.i().clip(eyePosition, vec3Add).isPresent());
        }
    }

    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2) {
        if (!localPlayer.isCreative()) {
            return;
        }
        Vec3 viewVector = localPlayer.getViewVector(1.0f);
        Vec3 eyePosition = localPlayer.getEyePosition(1.0f);
        Vec3 vec3Add = eyePosition.add(viewVector.scale(64.0d));
        ObjectArrayList<Pair> objectArrayList = new ObjectArrayList();
        for (pA pAVar : this.bJ) {
            if (!pAVar.i().clip(eyePosition, vec3Add).isEmpty()) {
                ObjectArrayList objectArrayList2 = new ObjectArrayList();
                pAVar.a(minecraft, c0297l, localPlayer, clientLevel, (List<Component>) objectArrayList2);
                objectArrayList.add(Pair.of(pAVar.x(), objectArrayList2));
            }
        }
        if (objectArrayList.isEmpty()) {
            return;
        }
        int i3 = i + 16;
        int i4 = i2 + 16;
        int i5 = 0;
        int iP = C0040bk.p();
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
            C0040bk.c(guiGraphics, i6, i9, i8 + 3, i7, iP);
            C0040bk.a(poseStack, guiGraphics, resourceLocation, i3, i9, 32);
            int i10 = 0;
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                C0040bk.b(font, guiGraphics, (Component) it2.next(), i6 + 2, i9 + i10 + 2);
                Objects.requireNonNull(font);
                i10 += 9;
            }
            i5 += i7 + 3;
        }
    }

    public void a(@NotNull pA pAVar) {
        this.bH.add(pAVar);
        this.bJ.add(pAVar);
        db();
    }

    private void db() {
        if (C0262js.ab()) {
            this.a.clear();
            for (Object obj : this.bJ) {
                if (obj instanceof pI) {
                    pI pIVar = (pI) obj;
                    ((List) this.a.computeIfAbsent(pIVar.a(), obj2 -> {
                        return new ObjectArrayList();
                    })).add(pIVar);
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull String str, boolean z) {
        for (pA pAVar : this.bJ) {
            if (str.equals(pAVar.bW) || str.equals(pAVar.y.toString())) {
                pAVar.gl = z;
            }
        }
    }

    @Nullable
    public pA a(@NotNull UUID uuid) {
        for (pA pAVar : this.bJ) {
            if (pAVar.y.equals(uuid)) {
                return pAVar;
            }
        }
        return null;
    }

    public void b(@NotNull pA pAVar) {
        this.bH.remove(pAVar);
        this.Y.remove(pAVar.y);
        this.bJ.remove(pAVar);
        db();
    }

    public void c(@NotNull pA pAVar) {
        int i = 0;
        while (true) {
            if (i >= this.bH.size()) {
                break;
            }
            if (!this.bH.get(i).y.equals(pAVar.y)) {
                i++;
            } else {
                this.bH.set(i, pAVar);
                break;
            }
        }
        for (int i2 = 0; i2 < this.bJ.size(); i2++) {
            if (this.bJ.get(i2).y.equals(pAVar.y)) {
                this.bJ.set(i2, pAVar);
                db();
                return;
            }
        }
    }

    public void b(@NotNull jO jOVar) {
        if (!this.Y.isEmpty()) {
            this.bJ.removeIf(pAVar -> {
                return this.Y.containsKey(pAVar.y);
            });
            this.Y.clear();
        }
        for (int i = 0; i < this.bI.size(); i++) {
            C0280kj c0280kj = this.bI.get(i);
            pA pAVarA = c0280kj.a(jOVar, i);
            if (pAVarA != null) {
                this.bJ.add(pAVarA);
                this.Y.put(pAVarA.y, c0280kj);
            }
        }
        db();
    }

    public boolean p(@NotNull UUID uuid) {
        return this.Y.containsKey(uuid);
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0280kj m1103a(@NotNull UUID uuid) {
        return this.Y.get(uuid);
    }

    public void a(@NotNull C0280kj c0280kj) {
        this.bI.add(c0280kj);
    }

    public void b(@NotNull C0280kj c0280kj) {
        this.bI.remove(c0280kj);
        this.Y.entrySet().removeIf(entry -> {
            if (entry.getValue() == c0280kj) {
                this.bJ.removeIf(pAVar -> {
                    return pAVar.y.equals(entry.getKey());
                });
                return true;
            }
            return false;
        });
        db();
    }

    @NotNull
    public List<C0280kj> aB() {
        return this.bI;
    }

    @NotNull
    public Map<UUID, C0280kj> p() {
        return this.Y;
    }

    @NotNull
    public List<pA> aC() {
        return this.bH;
    }

    @NotNull
    public List<pA> ax() {
        return this.bJ;
    }

    @NotNull
    public sY a(int i) {
        this.Z = i;
        return this;
    }

    public int bj() {
        return this.Z;
    }

    public void b(int i, float f) {
        this.ro = i;
        this.lV = f;
    }

    public void dc() {
        this.lV = 0.0f;
        this.ro = ColorReferences.COLOR_WHITE;
    }

    public boolean bX() {
        return this.lV > 0.0f;
    }

    public int bO() {
        return this.ro;
    }

    public float aV() {
        return this.lV;
    }

    public void H(int i) {
        this.hw = true;
        this.rp = i;
    }

    public boolean bY() {
        return this.hw;
    }

    public int bP() {
        return this.rp;
    }

    public void c(int i, float f) {
        this.rq = i;
        this.lW = f;
    }

    public void dd() {
        this.lW = 0.0f;
        this.rq = ColorReferences.COLOR_WHITE;
    }

    public boolean bZ() {
        return this.lW > 0.0f;
    }

    public int bQ() {
        return this.rq;
    }

    public float aW() {
        return this.lW;
    }

    public void d(int i, float f) {
        this.rr = i;
        this.lX = f;
    }

    public void de() {
        this.lX = 0.0f;
        this.rr = ColorReferences.COLOR_WHITE;
    }

    public boolean ca() {
        return this.lX > 0.0f;
    }

    public int bR() {
        return this.rr;
    }

    public float aX() {
        return this.lX;
    }

    public void o(float f) {
        this.lY = Mth.clamp(f, 0.0f, 1.0f);
    }

    public void df() {
        this.lY = 0.0f;
    }

    public float aY() {
        return this.lY;
    }

    public boolean cb() {
        return this.lY > 0.0f;
    }

    public void S(boolean z) {
        this.gw = z;
    }

    public boolean cc() {
        return this.gw;
    }

    public void b(float f, float f2, float f3) {
        this.lA = f;
        this.lB = f2;
        this.lU = f3;
    }

    public void dg() {
        this.lU = 0.0f;
        this.lA = 0.0f;
        this.lB = 0.0f;
    }

    public boolean cd() {
        return this.lU > 0.0f;
    }

    public float aZ() {
        return this.lU;
    }

    public float ba() {
        return this.lA;
    }

    public float bb() {
        return this.lB;
    }

    public void T(boolean z) {
        this.gv = z;
    }

    public boolean ce() {
        return this.gv;
    }

    @NotNull
    public sY a(@Nullable ResourceLocation resourceLocation) {
        this.ez = resourceLocation;
        return this;
    }

    @Nullable
    public ResourceLocation M() {
        return this.ez;
    }

    public void c(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeString(byteBuf, this.cT);
        int size = this.bJ.size();
        byteBuf.writeInt(size);
        for (int i = 0; i < size; i++) {
            pB.d.encode(byteBuf, this.bJ.get(i));
        }
    }

    public void cA() {
        Iterator<pA> it = this.bJ.iterator();
        while (it.hasNext()) {
            it.next().cA();
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        Iterator<pA> it = this.bJ.iterator();
        while (it.hasNext()) {
            it.next().a(minecraft, randomSource);
        }
    }
}
