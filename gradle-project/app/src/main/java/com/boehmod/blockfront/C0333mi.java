package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.Camera;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.ReceivingLevelScreen;
import net.minecraft.client.multiplayer.ClientChunkCache;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.mi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mi.class */
public class C0333mi {
    private static final int kr = 20;

    @NotNull
    private static final ResourceLocation dp;

    @NotNull
    private static final ResourceLocation dq;

    @NotNull
    private static final ResourceLocation dr;

    @NotNull
    private static final Component ij;
    private static final int ks = 20;
    private static final int kt = 6;
    private static final int ku = 2;
    private static final int kv = 100;

    @NotNull
    private final C0297l f;

    @Nullable
    private C0332mh a;
    private int kw;
    private float hI;
    private boolean en;
    private float aD;
    private float aE;
    private float hJ;
    private float hK;

    @Nullable
    private mZ b;
    private boolean ep;
    private int kz;
    private Vec3 H;
    private Vec3 I;
    private float hL;
    private float hM;
    private float hN;
    private float hO;
    private float hG;
    private float hP;
    static final /* synthetic */ boolean eq;

    @NotNull
    private final List<AbstractC0339mo> ae = new ObjectArrayList();

    @NotNull
    private final List<AbstractC0339mo> af = new ObjectArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private C0337mm f247a = null;
    private int kx = 20;
    private int ky = 0;
    private boolean eo = false;
    private int kA = -1;

    static {
        eq = !C0333mi.class.desiredAssertionStatus();
        dp = C0265jv.d("textures/gui/menu/icons/mouse.png");
        dq = C0265jv.d("textures/gui/menu/icons/mouse_button_right.png");
        dr = C0265jv.d("textures/gui/shadoweffect.png");
        ij = Component.translatable("bf.message.skip");
    }

    public C0333mi(@NotNull C0297l c0297l) {
        this.f = c0297l;
    }

    @Nullable
    public C0332mh b() {
        return this.a;
    }

    public void a(@NotNull AbstractC0339mo abstractC0339mo) {
        this.ae.add(abstractC0339mo);
    }

    public void b(@NotNull AbstractC0339mo abstractC0339mo) {
        this.af.add(abstractC0339mo);
    }

    private void b(@NotNull Minecraft minecraft, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel) {
        this.ae.removeIf(abstractC0339mo -> {
            return abstractC0339mo.a(minecraft, this.f, localPlayer, clientLevel);
        });
        this.af.removeIf(abstractC0339mo2 -> {
            return abstractC0339mo2.a(minecraft, this.f, localPlayer, clientLevel);
        });
    }

    public void a(@NotNull Minecraft minecraft, @NotNull C0332mh c0332mh, @Nullable C0337mm c0337mm) {
        u(minecraft);
        this.f247a = c0337mm;
        this.kA = ((Integer) minecraft.options.fov().get()).intValue();
        this.a = c0332mh;
        this.en = true;
        minecraft.options.setCameraType(CameraType.FIRST_PERSON);
        Iterator<C0331mg> it = c0332mh.s().iterator();
        while (it.hasNext()) {
            it.next().j(minecraft.player);
        }
        a(minecraft, (C0331mg) c0332mh.s().getFirst());
    }

    public void u(@NotNull Minecraft minecraft) {
        if (this.en) {
            this.en = false;
            if (minecraft.getConnection() != null) {
                C0582vo.c(new vR());
            }
            if (this.f247a != null && this.f247a.az()) {
                this.f.a().aQ();
            }
            v(minecraft);
            if (this.a != null && this.a.aw()) {
                this.hJ = 1.0f;
                this.hK = 1.0f;
            }
            if (this.b != null && this.b.isAlive()) {
                this.b.discard();
                this.b = null;
            }
            if (minecraft.player != null) {
                iG.a(minecraft, (Entity) minecraft.player);
            }
            C0297l c0297lB = C0297l.b();
            if (!eq && c0297lB == null) {
                throw new AssertionError("Client mod manager is null");
            }
            c0297lB.d();
        }
    }

    private void v(@NotNull Minecraft minecraft) {
        this.kx = 20;
        this.kw = 0;
        this.hI = 0.0f;
        this.f247a = null;
        this.ep = false;
        this.kz = 0;
        if (this.kA != -1) {
            minecraft.options.fov().set(Integer.valueOf(this.kA));
        }
    }

    private void a(@NotNull Minecraft minecraft, @NotNull C0331mg c0331mg) {
        this.H = c0331mg.f244a.c;
        this.I = this.H;
        float f = c0331mg.f244a.h.x;
        this.hO = f;
        this.hN = f;
        float f2 = c0331mg.f244a.h.y;
        this.hM = f2;
        this.hL = f2;
        float fAh = c0331mg.ah();
        this.hP = fAh;
        this.hG = fAh;
        this.hI = 0.0f;
        a(c0331mg);
        minecraft.options.fov().set(Integer.valueOf(Math.max(c0331mg.aq(), 30)));
        if (this.a != null && this.a.ax()) {
            this.ep = false;
            return;
        }
        C0582vo.c(new vS(c0331mg.a()));
        this.kz = 0;
        this.ep = minecraft.level == null || !a(minecraft.level);
    }

    private void a(@NotNull C0331mg c0331mg) {
        Iterator<String> it = c0331mg.r().iterator();
        while (it.hasNext()) {
            String[] strArrSplit = it.next().split(" ");
            if (strArrSplit.length != 0) {
                switch (strArrSplit[0]) {
                    case "summary":
                        oG<?, ?> oGVarM593a = this.f.m593a();
                        if (oGVarM593a == null) {
                            break;
                        } else {
                            oGVarM593a.m774a().V(false);
                            break;
                        }
                        break;
                }
            }
        }
    }

    public void a(@NotNull Minecraft minecraft, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel) {
        b(minecraft, localPlayer, clientLevel);
        if (!this.en) {
            this.hK = this.hJ;
            this.hJ = C0634xm.g(this.hJ, 0.0f, 0.1f);
            return;
        }
        if (clientLevel == null || localPlayer == null) {
            u(minecraft);
            return;
        }
        this.aE = this.aD;
        this.aD = an();
        this.kx--;
        int i = this.ky;
        this.ky = i - 1;
        if (i <= 0) {
            this.ky = 6;
            this.eo = !this.eo;
        }
        if (minecraft.screen instanceof ReceivingLevelScreen) {
            return;
        }
        e(clientLevel);
        if (this.ep) {
            this.aE = 1.0f;
            this.aD = 1.0f;
            if (!a(clientLevel)) {
                int i2 = this.kz + 1;
                this.kz = i2;
                if (i2 < 100) {
                    return;
                }
            }
            x(minecraft);
        }
        w(minecraft);
        if (this.a != null && this.a.av() && this.ky <= 0 && minecraft.mouseHandler.isLeftPressed()) {
            u(minecraft);
        }
    }

    private void w(@NotNull Minecraft minecraft) {
        if (this.a == null) {
            return;
        }
        List<C0331mg> listS = this.a.s();
        if (this.kw >= listS.size()) {
            if (this.a.au()) {
                this.kw = 0;
                a(minecraft, (C0331mg) listS.getFirst());
            } else {
                u(minecraft);
                return;
            }
        }
        C0331mg c0331mg = listS.get(this.kw);
        this.I = this.H;
        this.hM = this.hL;
        this.hO = this.hN;
        this.hP = this.hG;
        this.hI += 1.0f / (c0331mg.al() * 20.0f);
        if (this.hI >= 1.0f) {
            this.kw++;
            if (this.kw < listS.size()) {
                a(minecraft, listS.get(this.kw));
                return;
            }
            return;
        }
        oX oXVarM683a = c0331mg.m683a(this.hI);
        this.H = new Vec3(oXVarM683a.q(), oXVarM683a.r(), oXVarM683a.s());
        this.hL = oXVarM683a.h.y;
        this.hN = oXVarM683a.h.x;
        this.hG = c0331mg.am();
    }

    public void a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, 400.0f);
        b(minecraft, poseStack, guiGraphics, font, i, i2, f);
        if (!this.en) {
            float fE = C0634xm.e(this.hJ, this.hK, f);
            if (fE > 0.0f) {
                C0040bk.a(guiGraphics, 0, 0, i, i2, 0, fE);
                return;
            }
            return;
        }
        if (minecraft.screen instanceof ReceivingLevelScreen) {
            C0040bk.a(guiGraphics, 0, 0, i, i2, ColorReferences.COLOR_BLACK_SOLID);
        }
        if (this.b != null) {
            this.b.absMoveTo(C0634xm.a(this.H.x, this.I.x, f), C0634xm.a(this.H.y, this.I.y, f), C0634xm.a(this.H.z, this.I.z, f), C0634xm.f(this.hL, this.hM, f), C0634xm.f(this.hN, this.hO, f));
        }
        C0040bk.a(poseStack, guiGraphics, dr, 0, 0, i, i2);
        float fE2 = C0634xm.e(this.aD, this.aE, f);
        if (fE2 > 0.0f) {
            C0040bk.a(guiGraphics, 0, 0, i, i2, ColorReferences.COLOR_BLACK_SOLID, fE2);
        }
        if (this.a != null && this.a.av() && this.kx <= 0) {
            a(poseStack, guiGraphics, font, i, i2);
        }
        poseStack.popPose();
    }

    private void b(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        Iterator<AbstractC0339mo> it = this.ae.iterator();
        while (it.hasNext()) {
            it.next().d(minecraft, poseStack, guiGraphics, font, i, i2, f);
        }
    }

    public void c(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        Iterator<AbstractC0339mo> it = this.af.iterator();
        while (it.hasNext()) {
            it.next().d(minecraft, poseStack, guiGraphics, font, i, i2, f);
        }
    }

    private void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2) {
        Component component = ij;
        int iWidth = ((i - font.width(component)) - 10) + 1;
        Objects.requireNonNull(font);
        int i3 = ((i2 - 9) - 10) + 1;
        C0040bk.a(font, guiGraphics, component, iWidth, i3);
        int i4 = (iWidth - 16) - 3;
        Objects.requireNonNull(font);
        int i5 = (i3 + ((9 - 16) / 2)) - 1;
        C0040bk.a(poseStack, guiGraphics, dp, i4, i5, 16, 16);
        if (this.eo) {
            C0040bk.a(poseStack, guiGraphics, dq, i4, i5, 16, 16);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera) {
        C0331mg c0331mg;
        if (this.a == null) {
            return;
        }
        List<C0331mg> listS = this.a.s();
        if (this.kw < listS.size() && (c0331mg = listS.get(this.kw)) != null) {
            c0331mg.a(poseStack, font, guiGraphics, camera);
        }
    }

    private float an() {
        if (this.a == null) {
            return 0.0f;
        }
        List<C0331mg> listS = this.a.s();
        if (this.kw >= listS.size()) {
            return 0.0f;
        }
        C0331mg c0331mg = listS.get(this.kw);
        float fAl = c0331mg.al();
        float fAj = c0331mg.aj();
        if (fAj > 0.0f) {
            float f = this.hI / (fAj / fAl);
            if (f < 1.0f) {
                return 1.0f - f;
            }
        }
        float fAk = c0331mg.ak();
        if (fAk > 0.0f) {
            float f2 = 1.0f - (fAk / fAl);
            if (this.hI > f2) {
                return (this.hI - f2) / (1.0f - f2);
            }
            return 0.0f;
        }
        return 0.0f;
    }

    private boolean a(@NotNull ClientLevel clientLevel) {
        if (this.H == null) {
            return true;
        }
        ChunkPos chunkPos = new ChunkPos(BlockPos.containing(this.H));
        ClientChunkCache chunkSource = clientLevel.getChunkSource();
        for (int i = -2; i <= 2; i++) {
            for (int i2 = -2; i2 <= 2; i2++) {
                if (!chunkSource.hasChunk(chunkPos.x + i, chunkPos.z + i2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void x(@NotNull Minecraft minecraft) {
        this.ep = false;
        minecraft.levelRenderer.allChanged();
    }

    private void e(@NotNull ClientLevel clientLevel) {
        if (this.b == null || !this.b.isAlive()) {
            this.b = (mZ) ((EntityType) wX.kB.get()).create(clientLevel);
            if (this.b != null) {
                this.b.a(EnumC0352na.CINEMATIC);
                iG.a(this.b, clientLevel);
            }
        }
    }

    public float o(float f) {
        return C0634xm.f(this.hG, this.hP, f);
    }

    public boolean ay() {
        return this.en;
    }

    public float ao() {
        return this.hI;
    }

    public int ar() {
        return this.kw;
    }

    @Nullable
    public mZ a() {
        return this.b;
    }
}
