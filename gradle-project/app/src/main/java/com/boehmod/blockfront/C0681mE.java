package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.ChatFormatting;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.mE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mE.class */
public class C0681mE {

    /* JADX INFO: renamed from: mo */
    private static final int f3745mo = 20;

    /* JADX INFO: renamed from: dp */
    @NotNull
    private static final ResourceLocation f3746dp;

    /* JADX INFO: renamed from: iu */
    @NotNull
    private static final Component f3747iu;

    /* JADX INFO: renamed from: iv */
    @NotNull
    private static final Component f3748iv;

    /* JADX INFO: renamed from: mp */
    private static final int f3749mp = 20;

    /* JADX INFO: renamed from: mq */
    private static final int f3750mq = 2;

    /* JADX INFO: renamed from: mr */
    private static final int f3751mr = 100;

    /* JADX INFO: renamed from: h */
    @NotNull
    private final C0623l f3752h;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0680mD f3753a;

    /* JADX INFO: renamed from: ms */
    private int f3755ms;

    /* JADX INFO: renamed from: iA */
    private float f3756iA;

    /* JADX INFO: renamed from: eH */
    private boolean f3757eH;

    /* JADX INFO: renamed from: aI */
    private float f3760aI;

    /* JADX INFO: renamed from: aJ */
    private float f3761aJ;

    /* JADX INFO: renamed from: iB */
    private float f3762iB;

    /* JADX INFO: renamed from: iC */
    private float f3763iC;

    /* JADX INFO: renamed from: b */
    @Nullable
    private C0777nv f3764b;

    /* JADX INFO: renamed from: eJ */
    private boolean f3765eJ;

    /* JADX INFO: renamed from: mu */
    private int f3766mu;

    /* JADX INFO: renamed from: I */
    private Vec3 f3767I;

    /* JADX INFO: renamed from: J */
    private Vec3 f3768J;

    /* JADX INFO: renamed from: iD */
    private float f3770iD;

    /* JADX INFO: renamed from: iE */
    private float f3771iE;

    /* JADX INFO: renamed from: iF */
    private float f3772iF;

    /* JADX INFO: renamed from: iG */
    private float f3773iG;

    /* JADX INFO: renamed from: iy */
    private float f3774iy;

    /* JADX INFO: renamed from: iH */
    private float f3775iH;

    /* JADX INFO: renamed from: eK */
    static final /* synthetic */ boolean f3776eK;

    /* JADX INFO: renamed from: al */
    @NotNull
    private final List<AbstractC0687mK> f3743al = new ObjectArrayList();

    /* JADX INFO: renamed from: am */
    @NotNull
    private final List<AbstractC0687mK> f3744am = new ObjectArrayList();

    /* JADX INFO: renamed from: a */
    @Nullable
    private C0685mI f3754a = null;

    /* JADX INFO: renamed from: mt */
    private int f3758mt = 20;

    /* JADX INFO: renamed from: eI */
    private boolean f3759eI = false;

    /* JADX INFO: renamed from: mv */
    private int f3769mv = -1;

    static {
        f3776eK = !C0681mE.class.desiredAssertionStatus();
        f3746dp = C0532jO.m2378d("textures/gui/shadoweffect.png");
        f3747iu = Component.translatable("bf.message.cinematic.skip.mouse").withStyle(ChatFormatting.WHITE);
        f3748iv = Component.translatable("bf.message.cinematic.skip", new Object[]{f3747iu}).withStyle(ChatFormatting.GRAY);
    }

    public C0681mE(@NotNull C0623l c0623l) {
        this.f3752h = c0623l;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public C0680mD m3051b() {
        return this.f3753a;
    }

    /* JADX INFO: renamed from: a */
    public void m3052a(@NotNull AbstractC0687mK abstractC0687mK) {
        this.f3743al.add(abstractC0687mK);
    }

    /* JADX INFO: renamed from: b */
    public void m3053b(@NotNull AbstractC0687mK abstractC0687mK) {
        this.f3744am.add(abstractC0687mK);
    }

    /* JADX INFO: renamed from: b */
    private void m3054b(@NotNull Minecraft minecraft, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel) {
        this.f3743al.removeIf(abstractC0687mK -> {
            return abstractC0687mK.mo3087a(minecraft, this.f3752h, localPlayer, clientLevel);
        });
        this.f3744am.removeIf(abstractC0687mK2 -> {
            return abstractC0687mK2.mo3087a(minecraft, this.f3752h, localPlayer, clientLevel);
        });
    }

    /* JADX INFO: renamed from: a */
    public void m3055a(@NotNull Minecraft minecraft, @NotNull C0680mD c0680mD, @Nullable C0685mI c0685mI) {
        m3056w(minecraft);
        this.f3754a = c0685mI;
        this.f3769mv = ((Integer) minecraft.options.fov().get()).intValue();
        this.f3753a = c0680mD;
        this.f3757eH = true;
        minecraft.options.setCameraType(CameraType.FIRST_PERSON);
        Iterator<C0679mC> it = c0680mD.m3031u().iterator();
        while (it.hasNext()) {
            it.next().m3001j(minecraft.player);
        }
        m3058a(minecraft, (C0679mC) c0680mD.m3031u().getFirst());
    }

    /* JADX INFO: renamed from: w */
    public void m3056w(@NotNull Minecraft minecraft) {
        if (this.f3757eH) {
            this.f3757eH = false;
            if (minecraft.getConnection() != null) {
                C1169vO.m6648c(new C1251wr());
            }
            if (this.f3754a != null && this.f3754a.m3081aK()) {
                this.f3752h.m2855a().m2253aY();
            }
            m3057x(minecraft);
            if (this.f3753a != null && this.f3753a.m3035aH()) {
                this.f3762iB = 1.0f;
                this.f3763iC = 1.0f;
            }
            if (this.f3764b != null && this.f3764b.isAlive()) {
                this.f3764b.discard();
                this.f3764b = null;
            }
            if (minecraft.player != null) {
                C0490iZ.m2215a(minecraft, (Entity) minecraft.player);
            }
            C0623l c0623lM2852b = C0623l.m2852b();
            if (!f3776eK && c0623lM2852b == null) {
                throw new AssertionError("Client mod manager is null");
            }
            c0623lM2852b.m2860d();
        }
    }

    /* JADX INFO: renamed from: x */
    private void m3057x(@NotNull Minecraft minecraft) {
        this.f3758mt = 20;
        this.f3759eI = false;
        this.f3755ms = 0;
        this.f3756iA = 0.0f;
        this.f3754a = null;
        this.f3765eJ = false;
        this.f3766mu = 0;
        if (this.f3769mv != -1) {
            minecraft.options.fov().set(Integer.valueOf(this.f3769mv));
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3058a(@NotNull Minecraft minecraft, @NotNull C0679mC c0679mC) {
        this.f3767I = c0679mC.f3725a.f4827c;
        this.f3768J = this.f3767I;
        float f = c0679mC.f3725a.f4826h.x;
        this.f3773iG = f;
        this.f3772iF = f;
        float f2 = c0679mC.f3725a.f4826h.y;
        this.f3771iE = f2;
        this.f3770iD = f2;
        float fM2985an = c0679mC.m2985an();
        this.f3775iH = fM2985an;
        this.f3774iy = fM2985an;
        this.f3756iA = 0.0f;
        m3059a(c0679mC);
        minecraft.options.fov().set(Integer.valueOf(Math.max(c0679mC.m2997aF(), 30)));
        if (this.f3753a != null && this.f3753a.m3036aI()) {
            this.f3765eJ = false;
            return;
        }
        C1169vO.m6648c(new C1252ws(c0679mC.m3005a()));
        this.f3766mu = 0;
        this.f3765eJ = minecraft.level == null || !m3069a(minecraft.level);
    }

    /* JADX INFO: renamed from: a */
    private void m3059a(@NotNull C0679mC c0679mC) {
        Iterator<String> it = c0679mC.m3000t().iterator();
        while (it.hasNext()) {
            String[] strArrSplit = it.next().split(" ");
            if (strArrSplit.length != 0) {
                switch (strArrSplit[0]) {
                    case "summary":
                        AbstractC0864pc<?, ?> abstractC0864pcM2878a = this.f3752h.m2878a();
                        if (abstractC0864pcM2878a == null) {
                            break;
                        } else {
                            abstractC0864pcM2878a.m4182a().m5901W(false);
                            break;
                        }
                        break;
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3060a(@NotNull Minecraft minecraft, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel) {
        m3054b(minecraft, localPlayer, clientLevel);
        if (!this.f3757eH) {
            this.f3763iC = this.f3762iB;
            this.f3762iB = C1270xJ.m7183h(this.f3762iB, 0.0f, 0.1f);
            return;
        }
        if (clientLevel == null || localPlayer == null) {
            m3056w(minecraft);
            return;
        }
        this.f3761aJ = this.f3760aI;
        this.f3760aI = m3068at();
        this.f3758mt--;
        if (minecraft.screen instanceof ReceivingLevelScreen) {
            return;
        }
        m3071e(clientLevel);
        if (this.f3765eJ) {
            this.f3761aJ = 1.0f;
            this.f3760aI = 1.0f;
            if (!m3069a(clientLevel)) {
                int i = this.f3766mu + 1;
                this.f3766mu = i;
                if (i < 100) {
                    return;
                }
            }
            m3070z(minecraft);
        }
        m3061y(minecraft);
        if (this.f3759eI) {
            this.f3759eI = false;
            m3056w(minecraft);
        }
    }

    /* JADX INFO: renamed from: y */
    private void m3061y(@NotNull Minecraft minecraft) {
        if (this.f3753a == null) {
            return;
        }
        List<C0679mC> listM3031u = this.f3753a.m3031u();
        if (this.f3755ms >= listM3031u.size()) {
            if (this.f3753a.m3033aF()) {
                this.f3755ms = 0;
                m3058a(minecraft, (C0679mC) listM3031u.getFirst());
            } else {
                m3056w(minecraft);
                return;
            }
        }
        C0679mC c0679mC = listM3031u.get(this.f3755ms);
        this.f3768J = this.f3767I;
        this.f3771iE = this.f3770iD;
        this.f3773iG = this.f3772iF;
        this.f3775iH = this.f3774iy;
        this.f3756iA += 1.0f / (c0679mC.m3007ar() * 20.0f);
        if (this.f3756iA >= 1.0f) {
            this.f3755ms++;
            if (this.f3755ms < listM3031u.size()) {
                m3058a(minecraft, listM3031u.get(this.f3755ms));
                return;
            }
            return;
        }
        C0881pt c0881ptM3002a = c0679mC.m3002a(this.f3756iA);
        this.f3767I = new Vec3(c0881ptM3002a.m4584s(), c0881ptM3002a.m4585t(), c0881ptM3002a.m4586u());
        this.f3770iD = c0881ptM3002a.f4826h.y;
        this.f3772iF = c0881ptM3002a.f4826h.x;
        this.f3774iy = c0679mC.m3012as();
    }

    /* JADX INFO: renamed from: a */
    public void m3062a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, 400.0f);
        m3063b(minecraft, poseStack, guiGraphics, font, i, i2, f);
        if (!this.f3757eH) {
            float fM7170f = C1270xJ.m7170f(this.f3762iB, this.f3763iC, f);
            if (fM7170f > 0.0f) {
                C0129bt.m517a(guiGraphics, 0, 0, i, i2, 0, fM7170f);
                return;
            }
            return;
        }
        if (minecraft.screen instanceof ReceivingLevelScreen) {
            C0129bt.m515a(guiGraphics, 0, 0, i, i2, ColorReferences.COLOR_BLACK_SOLID);
        }
        if (this.f3764b != null) {
            this.f3764b.absMoveTo(C1270xJ.m7169a(this.f3767I.x, this.f3768J.x, f), C1270xJ.m7169a(this.f3767I.y, this.f3768J.y, f), C1270xJ.m7169a(this.f3767I.z, this.f3768J.z, f), C1270xJ.m7171g(this.f3770iD, this.f3771iE, f), C1270xJ.m7171g(this.f3772iF, this.f3773iG, f));
        }
        C0129bt.m531a(poseStack, guiGraphics, f3746dp, 0, 0, i, i2);
        if (this.f3753a != null && this.f3753a.m3034aG() && this.f3758mt <= 0 && 1.0f - m3065p(f) > 0.04f) {
            m3066b(guiGraphics, font, i, i2);
        }
        float fM7170f2 = C1270xJ.m7170f(this.f3760aI, this.f3761aJ, f);
        if (fM7170f2 > 0.0f) {
            C0129bt.m517a(guiGraphics, 0, 0, i, i2, ColorReferences.COLOR_BLACK_SOLID, fM7170f2);
        }
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: b */
    private void m3063b(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        Iterator<AbstractC0687mK> it = this.f3743al.iterator();
        while (it.hasNext()) {
            it.next().mo3088d(minecraft, poseStack, guiGraphics, font, i, i2, f);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m3064c(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        Iterator<AbstractC0687mK> it = this.f3744am.iterator();
        while (it.hasNext()) {
            it.next().mo3088d(minecraft, poseStack, guiGraphics, font, i, i2, f);
        }
    }

    /* JADX INFO: renamed from: p */
    private float m3065p(float f) {
        float fMax = 0.0f;
        Iterator<AbstractC0687mK> it = this.f3743al.iterator();
        while (it.hasNext()) {
            fMax = Math.max(fMax, it.next().mo3089r(f));
        }
        Iterator<AbstractC0687mK> it2 = this.f3744am.iterator();
        while (it2.hasNext()) {
            fMax = Math.max(fMax, it2.next().mo3089r(f));
        }
        return Math.min(fMax, 1.0f);
    }

    /* JADX INFO: renamed from: b */
    private void m3066b(@NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2) {
        C0129bt.m479b(font, guiGraphics, f3748iv, (i - font.width(f3748iv)) - 8, i2 - 16);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    public void m3067b(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera) {
        C0679mC c0679mC;
        if (this.f3753a == null) {
            return;
        }
        List<C0679mC> listM3031u = this.f3753a.m3031u();
        if (this.f3755ms < listM3031u.size() && (c0679mC = listM3031u.get(this.f3755ms)) != null) {
            c0679mC.m3011a(poseStack, font, guiGraphics, camera);
        }
    }

    /* JADX INFO: renamed from: at */
    private float m3068at() {
        if (this.f3753a == null) {
            return 0.0f;
        }
        List<C0679mC> listM3031u = this.f3753a.m3031u();
        if (this.f3755ms >= listM3031u.size()) {
            return 0.0f;
        }
        C0679mC c0679mC = listM3031u.get(this.f3755ms);
        float fM3007ar = c0679mC.m3007ar();
        float fM2998ap = c0679mC.m2998ap();
        if (fM2998ap > 0.0f) {
            float f = this.f3756iA / (fM2998ap / fM3007ar);
            if (f < 1.0f) {
                return 1.0f - f;
            }
        }
        float fM2999aq = c0679mC.m2999aq();
        if (fM2999aq > 0.0f) {
            float f2 = 1.0f - (fM2999aq / fM3007ar);
            if (this.f3756iA > f2) {
                return (this.f3756iA - f2) / (1.0f - f2);
            }
            return 0.0f;
        }
        return 0.0f;
    }

    /* JADX INFO: renamed from: a */
    private boolean m3069a(@NotNull ClientLevel clientLevel) {
        if (this.f3767I == null) {
            return true;
        }
        ChunkPos chunkPos = new ChunkPos(BlockPos.containing(this.f3767I));
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

    /* JADX INFO: renamed from: z */
    private void m3070z(@NotNull Minecraft minecraft) {
        this.f3765eJ = false;
        minecraft.levelRenderer.allChanged();
    }

    /* JADX INFO: renamed from: e */
    private void m3071e(@NotNull ClientLevel clientLevel) {
        if (this.f3764b == null || !this.f3764b.isAlive()) {
            this.f3764b = (C0777nv) ((EntityType) C1307xu.f7594kB.get()).create(clientLevel);
            if (this.f3764b != null) {
                this.f3764b.m3655a(EnumC0778nw.CINEMATIC);
                C0490iZ.m2213a(this.f3764b, clientLevel);
            }
        }
    }

    /* JADX INFO: renamed from: q */
    public float m3072q(float f) {
        return C1270xJ.m7171g(this.f3774iy, this.f3775iH, f);
    }

    /* JADX INFO: renamed from: g */
    public boolean m3073g(@NotNull Minecraft minecraft) {
        if (!this.f3757eH || this.f3753a == null || !this.f3753a.m3034aG() || minecraft.screen != null || this.f3758mt > 0) {
            return false;
        }
        this.f3759eI = true;
        return true;
    }

    /* JADX INFO: renamed from: aJ */
    public boolean m3074aJ() {
        return this.f3757eH;
    }

    /* JADX INFO: renamed from: au */
    public float m3075au() {
        return this.f3756iA;
    }

    /* JADX INFO: renamed from: aG */
    public int m3076aG() {
        return this.f3755ms;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0777nv m3077a() {
        return this.f3764b;
    }
}
