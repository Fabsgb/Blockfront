package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0788oG;
import com.boehmod.blockfront.C0119bk;
import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import net.neoforged.neoforge.common.util.TriState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sl.class */
public final class C1032sl extends AbstractC0789oH<C1030sj, C1034sn> {

    /* JADX INFO: renamed from: fj */
    @NotNull
    private static final ResourceLocation f5486fj = C0564jv.m2555d("textures/misc/bfneutralicon.png");

    /* JADX INFO: renamed from: fk */
    @NotNull
    private static final ResourceLocation f5487fk = C0564jv.m2555d("textures/gui/menu/icons/reinforcements.png");

    /* JADX INFO: renamed from: qN */
    private static final int f5488qN = 16;

    /* JADX INFO: renamed from: cA */
    @NotNull
    private static final String f5489cA = "of.respawn";

    /* JADX INFO: renamed from: cB */
    @NotNull
    private static final String f5490cB = "of.rally.regroup";

    /* JADX INFO: renamed from: cC */
    @NotNull
    private static final String f5491cC = "of.boundary.grace";

    /* JADX INFO: renamed from: cD */
    @NotNull
    private static final String f5492cD = "of.prepare";

    /* JADX INFO: renamed from: lI */
    private static final float f5493lI = 30.0f;

    /* JADX INFO: renamed from: lJ */
    private static final float f5494lJ = 45.0f;

    /* JADX INFO: renamed from: aE */
    private static final double f5495aE = 32.0d;

    /* JADX INFO: renamed from: lK */
    private static final float f5496lK = 0.25f;

    /* JADX INFO: renamed from: lL */
    private static final float f5497lL = 1.0f;

    /* JADX INFO: renamed from: lM */
    private static final float f5498lM = 1.5f;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final C0119bk.d f5499c;

    /* JADX INFO: renamed from: lN */
    private static final float f5500lN = 0.6f;

    /* JADX INFO: renamed from: lO */
    private static final float f5501lO = 0.2f;

    /* JADX INFO: renamed from: qO */
    private static final int f5502qO = 16;

    /* JADX INFO: renamed from: qP */
    private static final int f5503qP = 4;

    /* JADX INFO: renamed from: lP */
    private static final float f5504lP = 2.0f;

    /* JADX INFO: renamed from: lQ */
    private static final float f5505lQ = 0.1f;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final C0119bk.d f5506d;

    /* JADX INFO: renamed from: hc */
    private boolean f5507hc;

    /* JADX INFO: renamed from: qQ */
    private int f5508qQ;

    /* JADX INFO: renamed from: lR */
    private float f5509lR;

    /* JADX INFO: renamed from: lS */
    private float f5510lS;

    public C1032sl(@NotNull C0622l c0622l, @NotNull C1030sj c1030sj, @NotNull C0326fV c0326fV) {
        super(c0622l, c1030sj, c0326fV);
        this.f5499c = C0119bk.d.m570a().m574a(1.0d).m579a(true, false, false).m575a(C0119bk.b.TOP);
        this.f5506d = C0119bk.d.m570a().m574a(4.0d);
        this.f5507hc = false;
        this.f5508qQ = 0;
        this.f5509lR = 0.0f;
        this.f5510lS = 0.0f;
        c0622l.m2709a().m3222b(new C0719mr(c1030sj));
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: u */
    protected List<Component> mo3666u() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(Component.translatable("bf.message.gamemode.of.tip.0"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.of.tip.1"));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: w */
    protected List<AbstractC0168cg<C1030sj, C1034sn>> mo3670w() {
        return List.of(new C0163cb(), new C0102bT(), new C0162ca(), new C0108bZ());
    }

    @Override // com.boehmod.blockfront.AbstractC0789oH
    @NotNull
    /* JADX INFO: renamed from: a */
    protected C0796oO mo3768a(@NotNull AbstractC0803oV<?> abstractC0803oV, @NotNull C0796oO c0796oO) {
        C0796oO c0796oOM5749f = ((C1030sj) this.f4272f).m5749f();
        return c0796oOM5749f != null ? c0796oOM5749f : c0796oO;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    protected void mo3671a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull List<C0862pb> list) {
        C0796oO c0796oOA;
        super.mo3671a(minecraft, localPlayer, list);
        if (((C1030sj) this.f4272f).mo3560a() == EnumC0795oN.GAME && (c0796oOA = ((C1030sj) this.f4272f).m3582b().m3793a(localPlayer.getUUID())) != null) {
            int iM5759bK = ((C1030sj) this.f4272f).m5759bK();
            if (iM5759bK > 0) {
                m3672a(list, f5492cD, (Component) Component.translatable(c0796oOA.equals(((C1030sj) this.f4272f).m5749f()) ? "bf.message.gamemode.of.prepare.attack" : "bf.message.gamemode.of.prepare.defend", new Object[]{Component.literal(String.valueOf(iM5759bK)).withColor(ColorReferences.COLOR_STOPWATCH)}).withStyle(ChatFormatting.WHITE));
                return;
            }
            if (C0799oR.m4052a((Player) localPlayer, (AbstractC0182b<?, ?, ?, ?>) this.f4311b.m1133a((Player) localPlayer))) {
                int iM5757bI = c0796oOA.equals(((C1030sj) this.f4272f).m5749f()) ? ((C1030sj) this.f4272f).m5757bI() : ((C1030sj) this.f4272f).m5758bJ();
                if (iM5757bI > 0) {
                    m3672a(list, f5489cA, m5787a(iM5757bI));
                    return;
                }
                return;
            }
            if (((C1030sj) this.f4272f).m5740bM()) {
                m3672a(list, f5491cC, (Component) Component.translatable(c0796oOA.equals(((C1030sj) this.f4272f).m5749f()) ? "bf.message.gamemode.of.boundary.advance" : "bf.message.gamemode.of.boundary.fallback", new Object[]{Component.literal(String.valueOf(((C1030sj) this.f4272f).m5741bE())).withStyle(ChatFormatting.WHITE)}).withStyle(ChatFormatting.RED));
            } else if (c0796oOA.equals(((C1030sj) this.f4272f).m5750g()) && ((C1030sj) this.f4272f).m5756bP()) {
                MutableComponent mutableComponentWithColor = Component.translatable("bf.message.gamemode.of.rally.regroup", new Object[]{Component.translatable("bf.message.gamemode.of.rally.regroup.reinforcements").withColor(ColorReferences.COLOR_THEME_YELLOW)}).withColor(ColorReferences.COLOR_WHITE);
                C1033sm c1033smM5751a = ((C1030sj) this.f4272f).m5751a();
                m3673a(list, f5490cB, (Component) mutableComponentWithColor, c1033smM5751a != null ? c1033smM5751a.f5514i.f4424c : null, ColorReferences.COLOR_THEME_YELLOW_SOLID, ColorReferences.COLOR_WHITE_SOLID);
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Component m5787a(int i) {
        return Component.translatable("bf.message.gamemode.of.waves.countdown", new Object[]{Component.literal(Integer.toString(i)).withStyle(ChatFormatting.WHITE)}).withStyle(ChatFormatting.GRAY);
    }

    @Override // com.boehmod.blockfront.AbstractC0789oH, com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: b */
    public void mo3704b(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0324fT c0324fT, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2) {
        super.mo3704b(minecraft, c0622l, localPlayer, clientLevel, c0324fT, guiGraphics, font, poseStack, multiBufferSource, set, i, i2, i3, i4, f, f2);
        m5789a(minecraft, localPlayer, guiGraphics, poseStack, i, i2, f2);
        m5788b(guiGraphics, poseStack, font, i, i2, f2);
    }

    /* JADX INFO: renamed from: b */
    private void m5788b(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        float fM7843e = C1290xm.m7843e(this.f5509lR, this.f5510lS, f);
        if (fM7843e <= 0.0f) {
            return;
        }
        C0119bk.m417a(guiGraphics, 0, 0, i, i2, ColorReferences.COLOR_BLACK_SOLID, fM7843e);
        if (this.f5507hc) {
            float f2 = i / 2.0f;
            float f3 = i2 / 2.0f;
            MutableComponent mutableComponentWithStyle = Component.literal(String.valueOf(Math.max(1, (this.f5508qQ + 19) / 20))).withStyle(ChatFormatting.WHITE);
            MutableComponent mutableComponentWithStyle2 = Component.translatable("bf.message.gamemode.of.boundary.title").withStyle(C0565jw.f3201b).withStyle(ChatFormatting.WHITE);
            MutableComponent mutableComponentWithStyle3 = Component.translatable("bf.message.gamemode.of.boundary.abandon", new Object[]{mutableComponentWithStyle}).withStyle(ChatFormatting.RED);
            C0119bk.m390b(poseStack, font, guiGraphics, (Component) mutableComponentWithStyle2, f2, f3 - 14.0f, 2.0f);
            C0119bk.m398d(poseStack, font, guiGraphics, mutableComponentWithStyle3, f2, f3 + 8.0f);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5789a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, int i, int i2, float f) {
        C1033sm c1033smM5751a;
        if (((C1030sj) this.f4272f).mo3560a() == EnumC0795oN.GAME && ((C1030sj) this.f4272f).m5756bP()) {
            C0796oO c0796oOM5750g = ((C1030sj) this.f4272f).m5750g();
            C0796oO c0796oOA = ((C1030sj) this.f4272f).m3582b().m3793a(localPlayer.getUUID());
            if (c0796oOM5750g == null || !c0796oOM5750g.equals(c0796oOA) || (c1033smM5751a = ((C1030sj) this.f4272f).m5751a()) == null) {
                return;
            }
            C0119bk.m549a(poseStack, guiGraphics, f5487fk, c1033smM5751a.f5514i.f4424c.add(0.0d, 1.0d, 0.0d), minecraft.gameRenderer.getMainCamera(), i, i2, 16, 16, (1.0f + Mth.sin(C0119bk.m366g() / 2.0f)) / 2.0f, ColorReferences.COLOR_THEME_YELLOW_SOLID, f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public boolean mo3676a(@NotNull AbstractClientPlayer abstractClientPlayer) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0789oH, com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public void mo3682a(@NotNull Minecraft minecraft, @NotNull Random random, @NotNull RandomSource randomSource, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0622l c0622l, @NotNull C0324fT c0324fT, @NotNull Set<UUID> set, float f, @NotNull Vec3 vec3, @NotNull BlockPos blockPos) {
        C1031sk c1031sk;
        super.mo3682a(minecraft, random, randomSource, localPlayer, clientLevel, c0622l, c0324fT, set, f, vec3, blockPos);
        C1033sm c1033smM5751a = ((C1030sj) this.f4272f).m5751a();
        C1031sk c1031sk2 = c1033smM5751a != null ? c1033smM5751a.f5511a : null;
        if (c1031sk2 != null && c1031sk2.m4133a(localPlayer.level(), c1031sk2.m4098a(3), set).contains(localPlayer)) {
            c1031sk = c1031sk2;
        } else {
            c1031sk = null;
        }
        this.f4325b = c1031sk;
        Iterator<C1031sk> it = ((C1030sj) this.f4272f).mo4668O().iterator();
        while (it.hasNext()) {
            it.next().m4108a(localPlayer, clientLevel, (AbstractC0787oF<?, ?, ?>) this.f4272f);
        }
        m5790a(localPlayer, c0324fT);
    }

    /* JADX INFO: renamed from: a */
    private void m5790a(@NotNull LocalPlayer localPlayer, @NotNull C0324fT c0324fT) {
        int iMax;
        boolean z = false;
        if (((C1030sj) this.f4272f).mo3560a() == EnumC0795oN.GAME && !((C1030sj) this.f4272f).m5740bM() && !C0799oR.m4052a((Player) localPlayer, (AbstractC0182b<?, ?, ?, ?>) c0324fT)) {
            C0796oO c0796oOA = ((C1030sj) this.f4272f).m3582b().m3793a(localPlayer.getUUID());
            C0806oY c0806oYM5739a = c0796oOA != null ? ((C1030sj) this.f4272f).m5739a(c0796oOA) : null;
            z = (c0806oYM5739a == null || c0806oYM5739a.m4171bu() || c0806oYM5739a.m4167a((float) localPlayer.getX(), (float) localPlayer.getZ())) ? false : true;
        }
        boolean z2 = this.f5507hc;
        this.f5507hc = z;
        if (z != z2) {
            Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) (z ? C1280xc.f7580pL : C1280xc.f7579pK).get(), 1.0f));
        }
        if (z) {
            if (z2) {
                iMax = Math.max(0, this.f5508qQ - 1);
            } else {
                iMax = 200;
            }
            this.f5508qQ = iMax;
        } else {
            this.f5508qQ = 0;
        }
        float f = z ? 0.6f : 0.0f;
        this.f5510lS = this.f5509lR;
        this.f5509lR = C1290xm.m7856g(this.f5509lR, f, 0.2f);
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: bj */
    public boolean mo3720bj() {
        return !this.f5507hc;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public void mo3715a(@NotNull AbstractC0790oI<?> abstractC0790oI, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, boolean z, float f, float f2) {
        super.mo3715a(abstractC0790oI, minecraft, clientLevel, localPlayer, renderLevelStageEvent, bufferSource, poseStack, frustum, font, guiGraphics, camera, z, f, f2);
        C1033sm c1033smM5751a = ((C1030sj) this.f4272f).m5751a();
        if (c1033smM5751a != null) {
            c1033smM5751a.f5511a.m4109a(frustum, guiGraphics, font, camera, f);
            if (((C1030sj) this.f4272f).mo3560a() == EnumC0795oN.GAME && ((C1030sj) this.f4272f).m5756bP()) {
                C0796oO c0796oOM5750g = ((C1030sj) this.f4272f).m5750g();
                C0796oO c0796oOA = ((C1030sj) this.f4272f).m3582b().m3793a(localPlayer.getUUID());
                if (c0796oOM5750g != null && c0796oOM5750g.equals(c0796oOA)) {
                    m5793a(camera, poseStack, frustum, localPlayer, c1033smM5751a.f5514i.m4146b(5));
                }
            }
        }
        if (C0424hN.f2730k.m1996T()) {
            for (C0124bp c0124bp : m3681d()) {
                AABB aabbM620d = c0124bp.m620d();
                if (c0124bp.m632p() && frustum.isVisible(aabbM620d)) {
                    Vec3 vec3M633c = c0124bp.m633c();
                    float fZ = m3728z((float) localPlayer.position().distanceTo(vec3M633c));
                    if (fZ > 0.0f) {
                        C0119bk.m510a(poseStack, camera, guiGraphics, c0124bp.getTexture(), vec3M633c.x, vec3M633c.y, vec3M633c.z, 20, 20, 0.5f * fZ, false);
                    }
                }
            }
        }
        if (z) {
            m5791a(localPlayer, poseStack, camera, font, guiGraphics);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5791a(@NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull Font font, @NotNull GuiGraphics guiGraphics) {
        double y = localPlayer.getY();
        for (C1033sm c1033sm : ((C1030sj) this.f4272f).m5752au()) {
            String str = c1033sm.f5511a.f4399bP != null ? c1033sm.f5511a.f4399bP : "?";
            m5792a(poseStack, camera, font, guiGraphics, c1033sm.f5515c, str + " (attacker)", y, ColorReferences.COLOR_THEME_RED_SOLID);
            m5792a(poseStack, camera, font, guiGraphics, c1033sm.f5516d, str + " (defender)", y, ColorReferences.COLOR_THEME_GREEN_SOLID);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5792a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull C0806oY c0806oY, @NotNull String str, double d, int i) {
        if (c0806oY.m4171bu()) {
            return;
        }
        C0119bk.m477a(camera, poseStack, c0806oY, d - 16.0d, d + 16.0d, this.f5506d.m571a(i, 0.1f).m572a(i, 1.0f, 2.0f));
        Vec2 vec2M4166b = c0806oY.m4166b();
        C0119bk.m522a(poseStack, font, camera, guiGraphics, (Component) Component.literal(str), vec2M4166b.x, d + 1.0d, vec2M4166b.y, 1.0f, i, false);
    }

    /* JADX INFO: renamed from: a */
    private void m5793a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull LocalPlayer localPlayer, @NotNull AABB aabb) {
        if (frustum.isVisible(aabb)) {
            float fM7863i = C1290xm.m7863i((float) Math.sqrt(aabb.distanceToSqr(camera.getPosition())), f5493lI, f5494lJ);
            if (fM7863i <= 0.0f) {
                return;
            }
            C0119bk.m483a(camera, poseStack, aabb, this.f5499c.m571a(ColorReferences.COLOR_THEME_YELLOW_SOLID, 0.25f).m572a(ColorReferences.COLOR_THEME_YELLOW_SOLID, 1.0f, 1.5f).m577a(localPlayer.position(), f5495aE).m578a(0.0f).m580b(fM7863i));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: b */
    public List<C0124bp> mo3730b(@NotNull Minecraft minecraft, @NotNull Set<UUID> set, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        C0796oO c0796oOA = ((C1030sj) this.f4272f).m3582b().m3793a(localPlayer.getUUID());
        if (c0796oOA == null) {
            return new ObjectArrayList();
        }
        ObjectArrayList objectArrayList = new ObjectArrayList();
        C1033sm c1033smM5751a = ((C1030sj) this.f4272f).m5751a();
        if (c1033smM5751a != null) {
            C1031sk c1031sk = c1033smM5751a.f5511a;
            ResourceLocation icon = c1031sk.getIcon();
            objectArrayList.add(new C0124bp(icon != null ? icon : f5486fj, c1031sk.f4424c).m621a(f5486fj, c1031sk.getColor()).m625a(6).m624a((Component) Component.literal(c1031sk.f4399bP)).m630b(m3770A((float) c1031sk.f4424c.distanceTo(localPlayer.position()))));
        }
        for (Entity entity : clientLevel.entitiesForRendering()) {
            UUID uuid = entity.getUUID();
            if ((entity instanceof Player) && set.contains(uuid) && !uuid.equals(minecraft.getUser().getProfileId()) && c0796oOA.m3872h().contains(uuid)) {
                objectArrayList.add(new C0124bp(C0124bp.f865M, entity.position()).m625a(4).m623a(entity.getYRot() - 180.0f));
            }
        }
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public boolean mo3718a(@NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        C0796oO c0796oOA;
        C1034sn c1034snB = ((C1030sj) this.f4272f).m3582b();
        C0796oO c0796oOA2 = c1034snB.m3793a(player.getUUID());
        return c0796oOA2 != null && (livingEntity instanceof Player) && (c0796oOA = c1034snB.m3793a(((Player) livingEntity).getUUID())) != null && c0796oOA2.getName().equalsIgnoreCase(c0796oOA.getName());
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public void mo3731a(@NotNull Minecraft minecraft, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        C0796oO c0796oOA;
        C1034sn c1034snB = ((C1030sj) this.f4272f).m3582b();
        C0796oO c0796oOA2 = c1034snB.m3793a(player.getUUID());
        Player entity = renderNameTagEvent.getEntity();
        if (entity instanceof Player) {
            Player player2 = entity;
            if (c0796oOA2 != null && (c0796oOA = c1034snB.m3793a(player2.getUUID())) != null && c0796oOA.getName().equalsIgnoreCase(c0796oOA2.getName()) && player.hasLineOfSight(renderNameTagEvent.getEntity()) && player.distanceTo(renderNameTagEvent.getEntity()) <= 20.0f) {
                renderNameTagEvent.setCanRender(TriState.TRUE);
                return;
            }
        }
        renderNameTagEvent.setCanRender(TriState.FALSE);
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: g */
    public boolean mo3710g(@NotNull Player player) {
        return ((C1030sj) this.f4272f).mo3560a() != EnumC0795oN.GAME;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: bh */
    public boolean mo3717bh() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: bk */
    public boolean mo3721bk() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0788oG.a mo3711a() {
        return new AbstractC0788oG.a().m3765a("PING", (c0324fT, playerInfo, c0794oM) -> {
            return playerInfo != null ? C1293xp.m7912a(playerInfo.getLatency()) : "???";
        }).m3765a("K", (c0324fT2, playerInfo2, c0794oM2) -> {
            return C1293xp.m7912a(c0794oM2.m3853a(C1089tp.f5713D.getKey()));
        }).m3765a("A", (c0324fT3, playerInfo3, c0794oM3) -> {
            return C1293xp.m7912a(c0794oM3.m3853a(C1089tp.f5722M.getKey()));
        }).m3765a("OBJ", (c0324fT4, playerInfo4, c0794oM4) -> {
            return C1293xp.m7912a(c0794oM4.m3853a(C1089tp.f5700q.getKey()));
        }).m3765a("SCORE", (c0324fT5, playerInfo5, c0794oM5) -> {
            return C1293xp.m7912a(c0794oM5.m3853a(C1089tp.f5695l.getKey()));
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: a */
    public Collection<? extends AbstractC0156cU> mo3743a(boolean z) {
        return m3744a((C1030sj) this.f4272f, z);
    }
}
