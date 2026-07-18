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

/* JADX INFO: renamed from: com.boehmod.blockfront.mi */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mi.class */
public class C0710mi {

    /* JADX INFO: renamed from: kr */
    private static final int f3790kr = 20;

    /* JADX INFO: renamed from: dp */
    @NotNull
    private static final ResourceLocation f3791dp;

    /* JADX INFO: renamed from: dq */
    @NotNull
    private static final ResourceLocation f3792dq;

    /* JADX INFO: renamed from: dr */
    @NotNull
    private static final ResourceLocation f3793dr;

    /* JADX INFO: renamed from: ij */
    @NotNull
    private static final Component f3794ij;

    /* JADX INFO: renamed from: ks */
    private static final int f3795ks = 20;

    /* JADX INFO: renamed from: kt */
    private static final int f3796kt = 6;

    /* JADX INFO: renamed from: ku */
    private static final int f3797ku = 2;

    /* JADX INFO: renamed from: kv */
    private static final int f3798kv = 100;

    /* JADX INFO: renamed from: f */
    @NotNull
    private final C0622l f3799f;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0709mh f3800a;

    /* JADX INFO: renamed from: kw */
    private int f3802kw;

    /* JADX INFO: renamed from: hI */
    private float f3803hI;

    /* JADX INFO: renamed from: en */
    private boolean f3804en;

    /* JADX INFO: renamed from: aD */
    private float f3808aD;

    /* JADX INFO: renamed from: aE */
    private float f3809aE;

    /* JADX INFO: renamed from: hJ */
    private float f3810hJ;

    /* JADX INFO: renamed from: hK */
    private float f3811hK;

    /* JADX INFO: renamed from: b */
    @Nullable
    private C0701mZ f3812b;

    /* JADX INFO: renamed from: ep */
    private boolean f3813ep;

    /* JADX INFO: renamed from: kz */
    private int f3814kz;

    /* JADX INFO: renamed from: H */
    private Vec3 f3815H;

    /* JADX INFO: renamed from: I */
    private Vec3 f3816I;

    /* JADX INFO: renamed from: hL */
    private float f3818hL;

    /* JADX INFO: renamed from: hM */
    private float f3819hM;

    /* JADX INFO: renamed from: hN */
    private float f3820hN;

    /* JADX INFO: renamed from: hO */
    private float f3821hO;

    /* JADX INFO: renamed from: hG */
    private float f3822hG;

    /* JADX INFO: renamed from: hP */
    private float f3823hP;

    /* JADX INFO: renamed from: eq */
    static final /* synthetic */ boolean f3824eq;

    /* JADX INFO: renamed from: ae */
    @NotNull
    private final List<AbstractC0716mo> f3788ae = new ObjectArrayList();

    /* JADX INFO: renamed from: af */
    @NotNull
    private final List<AbstractC0716mo> f3789af = new ObjectArrayList();

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0714mm f3801a = null;

    /* JADX INFO: renamed from: kx */
    private int f3805kx = 20;

    /* JADX INFO: renamed from: ky */
    private int f3806ky = 0;

    /* JADX INFO: renamed from: eo */
    private boolean f3807eo = false;

    /* JADX INFO: renamed from: kA */
    private int f3817kA = -1;

    static {
        f3824eq = !C0710mi.class.desiredAssertionStatus();
        f3791dp = C0564jv.m2555d("textures/gui/menu/icons/mouse.png");
        f3792dq = C0564jv.m2555d("textures/gui/menu/icons/mouse_button_right.png");
        f3793dr = C0564jv.m2555d("textures/gui/shadoweffect.png");
        f3794ij = Component.translatable("bf.message.skip");
    }

    public C0710mi(@NotNull C0622l c0622l) {
        this.f3799f = c0622l;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public C0709mh m3220b() {
        return this.f3800a;
    }

    /* JADX INFO: renamed from: a */
    public void m3221a(@NotNull AbstractC0716mo abstractC0716mo) {
        this.f3788ae.add(abstractC0716mo);
    }

    /* JADX INFO: renamed from: b */
    public void m3222b(@NotNull AbstractC0716mo abstractC0716mo) {
        this.f3789af.add(abstractC0716mo);
    }

    /* JADX INFO: renamed from: b */
    private void m3223b(@NotNull Minecraft minecraft, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel) {
        this.f3788ae.removeIf(abstractC0716mo -> {
            return abstractC0716mo.mo3254a(minecraft, this.f3799f, localPlayer, clientLevel);
        });
        this.f3789af.removeIf(abstractC0716mo2 -> {
            return abstractC0716mo2.mo3254a(minecraft, this.f3799f, localPlayer, clientLevel);
        });
    }

    /* JADX INFO: renamed from: a */
    public void m3224a(@NotNull Minecraft minecraft, @NotNull C0709mh c0709mh, @Nullable C0714mm c0714mm) {
        m3225u(minecraft);
        this.f3801a = c0714mm;
        this.f3817kA = ((Integer) minecraft.options.fov().get()).intValue();
        this.f3800a = c0709mh;
        this.f3804en = true;
        minecraft.options.setCameraType(CameraType.FIRST_PERSON);
        Iterator<C0708mg> it = c0709mh.m3200s().iterator();
        while (it.hasNext()) {
            it.next().m3170j(minecraft.player);
        }
        m3227a(minecraft, (C0708mg) c0709mh.m3200s().getFirst());
    }

    /* JADX INFO: renamed from: u */
    public void m3225u(@NotNull Minecraft minecraft) {
        if (this.f3804en) {
            this.f3804en = false;
            if (minecraft.getConnection() != null) {
                C1194vo.m6653c(new C1171vR());
            }
            if (this.f3801a != null && this.f3801a.m3248az()) {
                this.f3799f.m2670a().m2019aQ();
            }
            m3226v(minecraft);
            if (this.f3800a != null && this.f3800a.m3204aw()) {
                this.f3810hJ = 1.0f;
                this.f3811hK = 1.0f;
            }
            if (this.f3812b != null && this.f3812b.isAlive()) {
                this.f3812b.discard();
                this.f3812b = null;
            }
            if (minecraft.player != null) {
                C0470iG.m2123a(minecraft, (Entity) minecraft.player);
            }
            C0622l c0622lM2667b = C0622l.m2667b();
            if (!f3824eq && c0622lM2667b == null) {
                throw new AssertionError("Client mod manager is null");
            }
            c0622lM2667b.m2675d();
        }
    }

    /* JADX INFO: renamed from: v */
    private void m3226v(@NotNull Minecraft minecraft) {
        this.f3805kx = 20;
        this.f3802kw = 0;
        this.f3803hI = 0.0f;
        this.f3801a = null;
        this.f3813ep = false;
        this.f3814kz = 0;
        if (this.f3817kA != -1) {
            minecraft.options.fov().set(Integer.valueOf(this.f3817kA));
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3227a(@NotNull Minecraft minecraft, @NotNull C0708mg c0708mg) {
        this.f3815H = c0708mg.f3770a.f4424c;
        this.f3816I = this.f3815H;
        float f = c0708mg.f3770a.f4423h.x;
        this.f3821hO = f;
        this.f3820hN = f;
        float f2 = c0708mg.f3770a.f4423h.y;
        this.f3819hM = f2;
        this.f3818hL = f2;
        float fM3154ah = c0708mg.m3154ah();
        this.f3823hP = fM3154ah;
        this.f3822hG = fM3154ah;
        this.f3803hI = 0.0f;
        m3228a(c0708mg);
        minecraft.options.fov().set(Integer.valueOf(Math.max(c0708mg.m3166aq(), 30)));
        if (this.f3800a != null && this.f3800a.m3205ax()) {
            this.f3813ep = false;
            return;
        }
        C1194vo.m6653c(new C1172vS(c0708mg.m3174a()));
        this.f3814kz = 0;
        this.f3813ep = minecraft.level == null || !m3237a(minecraft.level);
    }

    /* JADX INFO: renamed from: a */
    private void m3228a(@NotNull C0708mg c0708mg) {
        Iterator<String> it = c0708mg.m3169r().iterator();
        while (it.hasNext()) {
            String[] strArrSplit = it.next().split(" ");
            if (strArrSplit.length != 0) {
                switch (strArrSplit[0]) {
                    case "summary":
                        AbstractC0788oG<?, ?> abstractC0788oGM2692a = this.f3799f.m2692a();
                        if (abstractC0788oGM2692a == null) {
                            break;
                        } else {
                            abstractC0788oGM2692a.m3746a().m6015V(false);
                            break;
                        }
                        break;
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3229a(@NotNull Minecraft minecraft, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel) {
        m3223b(minecraft, localPlayer, clientLevel);
        if (!this.f3804en) {
            this.f3811hK = this.f3810hJ;
            this.f3810hJ = C1290xm.m7856g(this.f3810hJ, 0.0f, 0.1f);
            return;
        }
        if (clientLevel == null || localPlayer == null) {
            m3225u(minecraft);
            return;
        }
        this.f3809aE = this.f3808aD;
        this.f3808aD = m3236an();
        this.f3805kx--;
        int i = this.f3806ky;
        this.f3806ky = i - 1;
        if (i <= 0) {
            this.f3806ky = 6;
            this.f3807eo = !this.f3807eo;
        }
        if (minecraft.screen instanceof ReceivingLevelScreen) {
            return;
        }
        m3239e(clientLevel);
        if (this.f3813ep) {
            this.f3809aE = 1.0f;
            this.f3808aD = 1.0f;
            if (!m3237a(clientLevel)) {
                int i2 = this.f3814kz + 1;
                this.f3814kz = i2;
                if (i2 < 100) {
                    return;
                }
            }
            m3238x(minecraft);
        }
        m3230w(minecraft);
        if (this.f3800a != null && this.f3800a.m3203av() && this.f3806ky <= 0 && minecraft.mouseHandler.isLeftPressed()) {
            m3225u(minecraft);
        }
    }

    /* JADX INFO: renamed from: w */
    private void m3230w(@NotNull Minecraft minecraft) {
        if (this.f3800a == null) {
            return;
        }
        List<C0708mg> listM3200s = this.f3800a.m3200s();
        if (this.f3802kw >= listM3200s.size()) {
            if (this.f3800a.m3202au()) {
                this.f3802kw = 0;
                m3227a(minecraft, (C0708mg) listM3200s.getFirst());
            } else {
                m3225u(minecraft);
                return;
            }
        }
        C0708mg c0708mg = listM3200s.get(this.f3802kw);
        this.f3816I = this.f3815H;
        this.f3819hM = this.f3818hL;
        this.f3821hO = this.f3820hN;
        this.f3823hP = this.f3822hG;
        this.f3803hI += 1.0f / (c0708mg.m3176al() * 20.0f);
        if (this.f3803hI >= 1.0f) {
            this.f3802kw++;
            if (this.f3802kw < listM3200s.size()) {
                m3227a(minecraft, listM3200s.get(this.f3802kw));
                return;
            }
            return;
        }
        C0805oX c0805oXM3171a = c0708mg.m3171a(this.f3803hI);
        this.f3815H = new Vec3(c0805oXM3171a.m4147q(), c0805oXM3171a.m4148r(), c0805oXM3171a.m4149s());
        this.f3818hL = c0805oXM3171a.f4423h.y;
        this.f3820hN = c0805oXM3171a.f4423h.x;
        this.f3822hG = c0708mg.m3181am();
    }

    /* JADX INFO: renamed from: a */
    public void m3231a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, 400.0f);
        m3232b(minecraft, poseStack, guiGraphics, font, i, i2, f);
        if (!this.f3804en) {
            float fM7843e = C1290xm.m7843e(this.f3810hJ, this.f3811hK, f);
            if (fM7843e > 0.0f) {
                C0119bk.m417a(guiGraphics, 0, 0, i, i2, 0, fM7843e);
                return;
            }
            return;
        }
        if (minecraft.screen instanceof ReceivingLevelScreen) {
            C0119bk.m415a(guiGraphics, 0, 0, i, i2, ColorReferences.COLOR_BLACK_SOLID);
        }
        if (this.f3812b != null) {
            this.f3812b.absMoveTo(C1290xm.m7842a(this.f3815H.x, this.f3816I.x, f), C1290xm.m7842a(this.f3815H.y, this.f3816I.y, f), C1290xm.m7842a(this.f3815H.z, this.f3816I.z, f), C1290xm.m7844f(this.f3818hL, this.f3819hM, f), C1290xm.m7844f(this.f3820hN, this.f3821hO, f));
        }
        C0119bk.m431a(poseStack, guiGraphics, f3793dr, 0, 0, i, i2);
        float fM7843e2 = C1290xm.m7843e(this.f3808aD, this.f3809aE, f);
        if (fM7843e2 > 0.0f) {
            C0119bk.m417a(guiGraphics, 0, 0, i, i2, ColorReferences.COLOR_BLACK_SOLID, fM7843e2);
        }
        if (this.f3800a != null && this.f3800a.m3203av() && this.f3805kx <= 0) {
            m3234a(poseStack, guiGraphics, font, i, i2);
        }
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: b */
    private void m3232b(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        Iterator<AbstractC0716mo> it = this.f3788ae.iterator();
        while (it.hasNext()) {
            it.next().mo3255d(minecraft, poseStack, guiGraphics, font, i, i2, f);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m3233c(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        Iterator<AbstractC0716mo> it = this.f3789af.iterator();
        while (it.hasNext()) {
            it.next().mo3255d(minecraft, poseStack, guiGraphics, font, i, i2, f);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3234a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2) {
        Component component = f3794ij;
        int iWidth = ((i - font.width(component)) - 10) + 1;
        Objects.requireNonNull(font);
        int i3 = ((i2 - 9) - 10) + 1;
        C0119bk.m370a(font, guiGraphics, component, iWidth, i3);
        int i4 = (iWidth - 16) - 3;
        Objects.requireNonNull(font);
        int i5 = (i3 + ((9 - 16) / 2)) - 1;
        C0119bk.m431a(poseStack, guiGraphics, f3791dp, i4, i5, 16, 16);
        if (this.f3807eo) {
            C0119bk.m431a(poseStack, guiGraphics, f3792dq, i4, i5, 16, 16);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    public void m3235b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera) {
        C0708mg c0708mg;
        if (this.f3800a == null) {
            return;
        }
        List<C0708mg> listM3200s = this.f3800a.m3200s();
        if (this.f3802kw < listM3200s.size() && (c0708mg = listM3200s.get(this.f3802kw)) != null) {
            c0708mg.m3180a(poseStack, font, guiGraphics, camera);
        }
    }

    /* JADX INFO: renamed from: an */
    private float m3236an() {
        if (this.f3800a == null) {
            return 0.0f;
        }
        List<C0708mg> listM3200s = this.f3800a.m3200s();
        if (this.f3802kw >= listM3200s.size()) {
            return 0.0f;
        }
        C0708mg c0708mg = listM3200s.get(this.f3802kw);
        float fM3176al = c0708mg.m3176al();
        float fM3167aj = c0708mg.m3167aj();
        if (fM3167aj > 0.0f) {
            float f = this.f3803hI / (fM3167aj / fM3176al);
            if (f < 1.0f) {
                return 1.0f - f;
            }
        }
        float fM3168ak = c0708mg.m3168ak();
        if (fM3168ak > 0.0f) {
            float f2 = 1.0f - (fM3168ak / fM3176al);
            if (this.f3803hI > f2) {
                return (this.f3803hI - f2) / (1.0f - f2);
            }
            return 0.0f;
        }
        return 0.0f;
    }

    /* JADX INFO: renamed from: a */
    private boolean m3237a(@NotNull ClientLevel clientLevel) {
        if (this.f3815H == null) {
            return true;
        }
        ChunkPos chunkPos = new ChunkPos(BlockPos.containing(this.f3815H));
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

    /* JADX INFO: renamed from: x */
    private void m3238x(@NotNull Minecraft minecraft) {
        this.f3813ep = false;
        minecraft.levelRenderer.allChanged();
    }

    /* JADX INFO: renamed from: e */
    private void m3239e(@NotNull ClientLevel clientLevel) {
        if (this.f3812b == null || !this.f3812b.isAlive()) {
            this.f3812b = (C0701mZ) ((EntityType) C1230wX.f7029kB.get()).create(clientLevel);
            if (this.f3812b != null) {
                this.f3812b.m3148a(EnumC0755na.CINEMATIC);
                C0470iG.m2121a(this.f3812b, clientLevel);
            }
        }
    }

    /* JADX INFO: renamed from: o */
    public float m3240o(float f) {
        return C1290xm.m7844f(this.f3822hG, this.f3823hP, f);
    }

    /* JADX INFO: renamed from: ay */
    public boolean m3241ay() {
        return this.f3804en;
    }

    /* JADX INFO: renamed from: ao */
    public float m3242ao() {
        return this.f3803hI;
    }

    /* JADX INFO: renamed from: ar */
    public int m3243ar() {
        return this.f3802kw;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0701mZ m3244a() {
        return this.f3812b;
    }
}
