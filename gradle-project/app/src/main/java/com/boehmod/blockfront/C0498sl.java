package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0040bk;
import com.boehmod.blockfront.oG;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.sl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sl.class */
public final class C0498sl extends oH<C0496sj, C0500sn> {

    @NotNull
    private static final ResourceLocation fj = C0265jv.d("textures/misc/bfneutralicon.png");

    @NotNull
    private static final ResourceLocation fk = C0265jv.d("textures/gui/menu/icons/reinforcements.png");
    private static final int qN = 16;

    @NotNull
    private static final String cA = "of.respawn";

    @NotNull
    private static final String cB = "of.rally.regroup";

    @NotNull
    private static final String cC = "of.boundary.grace";

    @NotNull
    private static final String cD = "of.prepare";
    private static final float lI = 30.0f;
    private static final float lJ = 45.0f;
    private static final double aE = 32.0d;
    private static final float lK = 0.25f;
    private static final float lL = 1.0f;
    private static final float lM = 1.5f;

    @NotNull
    private final C0040bk.d c;
    private static final float lN = 0.6f;
    private static final float lO = 0.2f;
    private static final int qO = 16;
    private static final int qP = 4;
    private static final float lP = 2.0f;
    private static final float lQ = 0.1f;

    @NotNull
    private final C0040bk.d d;
    private boolean hc;
    private int qQ;
    private float lR;
    private float lS;

    public C0498sl(@NotNull C0297l c0297l, @NotNull C0496sj c0496sj, @NotNull fV fVVar) {
        super(c0297l, c0496sj, fVVar);
        this.c = C0040bk.d.a().a(1.0d).a(true, false, false).a(C0040bk.b.TOP);
        this.d = C0040bk.d.a().a(4.0d);
        this.hc = false;
        this.qQ = 0;
        this.lR = 0.0f;
        this.lS = 0.0f;
        c0297l.m602a().b(new C0342mr(c0496sj));
    }

    @Override // com.boehmod.blockfront.oG
    @NotNull
    protected List<Component> u() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(Component.translatable("bf.message.gamemode.of.tip.0"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.of.tip.1"));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.oG
    @NotNull
    protected List<AbstractC0063cg<C0496sj, C0500sn>> w() {
        return List.of(new C0058cb(), new bT(), new C0057ca(), new bZ());
    }

    @Override // com.boehmod.blockfront.oH
    @NotNull
    /* JADX INFO: renamed from: a */
    protected oO mo779a(@NotNull oV<?> oVVar, @NotNull oO oOVar) {
        oO oOVarF = ((C0496sj) this.f).f();
        return oOVarF != null ? oOVarF : oOVar;
    }

    @Override // com.boehmod.blockfront.oG
    protected void a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull List<C0407pb> list) {
        oO oOVarA;
        super.a(minecraft, localPlayer, list);
        if (((C0496sj) this.f).a() == oN.GAME && (oOVarA = ((C0496sj) this.f).b().a(localPlayer.getUUID())) != null) {
            int iBK = ((C0496sj) this.f).bK();
            if (iBK > 0) {
                a(list, cD, (Component) Component.translatable(oOVarA.equals(((C0496sj) this.f).f()) ? "bf.message.gamemode.of.prepare.attack" : "bf.message.gamemode.of.prepare.defend", new Object[]{Component.literal(String.valueOf(iBK)).withColor(ColorReferences.COLOR_STOPWATCH)}).withStyle(ChatFormatting.WHITE));
                return;
            }
            if (oR.a((Player) localPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) this.b.a((Player) localPlayer))) {
                int iBI = oOVarA.equals(((C0496sj) this.f).f()) ? ((C0496sj) this.f).bI() : ((C0496sj) this.f).bJ();
                if (iBI > 0) {
                    a(list, cA, a(iBI));
                    return;
                }
                return;
            }
            if (((C0496sj) this.f).bM()) {
                a(list, cC, (Component) Component.translatable(oOVarA.equals(((C0496sj) this.f).f()) ? "bf.message.gamemode.of.boundary.advance" : "bf.message.gamemode.of.boundary.fallback", new Object[]{Component.literal(String.valueOf(((C0496sj) this.f).bE())).withStyle(ChatFormatting.WHITE)}).withStyle(ChatFormatting.RED));
            } else if (oOVarA.equals(((C0496sj) this.f).m1123g()) && ((C0496sj) this.f).bP()) {
                MutableComponent mutableComponentWithColor = Component.translatable("bf.message.gamemode.of.rally.regroup", new Object[]{Component.translatable("bf.message.gamemode.of.rally.regroup.reinforcements").withColor(ColorReferences.COLOR_THEME_YELLOW)}).withColor(ColorReferences.COLOR_WHITE);
                C0499sm c0499smM1124a = ((C0496sj) this.f).m1124a();
                a(list, cB, (Component) mutableComponentWithColor, c0499smM1124a != null ? c0499smM1124a.i.c : null, ColorReferences.COLOR_THEME_YELLOW_SOLID, ColorReferences.COLOR_WHITE_SOLID);
            }
        }
    }

    @NotNull
    private static Component a(int i) {
        return Component.translatable("bf.message.gamemode.of.waves.countdown", new Object[]{Component.literal(Integer.toString(i)).withStyle(ChatFormatting.WHITE)}).withStyle(ChatFormatting.GRAY);
    }

    @Override // com.boehmod.blockfront.oH, com.boehmod.blockfront.oG
    public void b(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull fT fTVar, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2) {
        super.b(minecraft, c0297l, localPlayer, clientLevel, fTVar, guiGraphics, font, poseStack, multiBufferSource, set, i, i2, i3, i4, f, f2);
        a(minecraft, localPlayer, guiGraphics, poseStack, i, i2, f2);
        b(guiGraphics, poseStack, font, i, i2, f2);
    }

    private void b(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        float fE = C0634xm.e(this.lR, this.lS, f);
        if (fE <= 0.0f) {
            return;
        }
        C0040bk.a(guiGraphics, 0, 0, i, i2, ColorReferences.COLOR_BLACK_SOLID, fE);
        if (this.hc) {
            float f2 = i / 2.0f;
            float f3 = i2 / 2.0f;
            MutableComponent mutableComponentWithStyle = Component.literal(String.valueOf(Math.max(1, (this.qQ + 19) / 20))).withStyle(ChatFormatting.WHITE);
            MutableComponent mutableComponentWithStyle2 = Component.translatable("bf.message.gamemode.of.boundary.title").withStyle(C0266jw.b).withStyle(ChatFormatting.WHITE);
            MutableComponent mutableComponentWithStyle3 = Component.translatable("bf.message.gamemode.of.boundary.abandon", new Object[]{mutableComponentWithStyle}).withStyle(ChatFormatting.RED);
            C0040bk.b(poseStack, font, guiGraphics, (Component) mutableComponentWithStyle2, f2, f3 - 14.0f, 2.0f);
            C0040bk.d(poseStack, font, guiGraphics, mutableComponentWithStyle3, f2, f3 + 8.0f);
        }
    }

    private void a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, int i, int i2, float f) {
        C0499sm c0499smM1124a;
        if (((C0496sj) this.f).a() == oN.GAME && ((C0496sj) this.f).bP()) {
            oO oOVarM1123g = ((C0496sj) this.f).m1123g();
            oO oOVarA = ((C0496sj) this.f).b().a(localPlayer.getUUID());
            if (oOVarM1123g == null || !oOVarM1123g.equals(oOVarA) || (c0499smM1124a = ((C0496sj) this.f).m1124a()) == null) {
                return;
            }
            C0040bk.a(poseStack, guiGraphics, fk, c0499smM1124a.i.c.add(0.0d, 1.0d, 0.0d), minecraft.gameRenderer.getMainCamera(), i, i2, 16, 16, (1.0f + Mth.sin(C0040bk.g() / 2.0f)) / 2.0f, ColorReferences.COLOR_THEME_YELLOW_SOLID, f);
        }
    }

    @Override // com.boehmod.blockfront.oG
    public boolean a(@NotNull AbstractClientPlayer abstractClientPlayer) {
        return true;
    }

    @Override // com.boehmod.blockfront.oH, com.boehmod.blockfront.oG
    public void a(@NotNull Minecraft minecraft, @NotNull Random random, @NotNull RandomSource randomSource, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0297l c0297l, @NotNull fT fTVar, @NotNull Set<UUID> set, float f, @NotNull Vec3 vec3, @NotNull BlockPos blockPos) {
        C0497sk c0497sk;
        super.a(minecraft, random, randomSource, localPlayer, clientLevel, c0297l, fTVar, set, f, vec3, blockPos);
        C0499sm c0499smM1124a = ((C0496sj) this.f).m1124a();
        C0497sk c0497sk2 = c0499smM1124a != null ? c0499smM1124a.a : null;
        if (c0497sk2 != null && c0497sk2.a(localPlayer.level(), c0497sk2.a(3), set).contains(localPlayer)) {
            c0497sk = c0497sk2;
        } else {
            c0497sk = null;
        }
        this.b = c0497sk;
        Iterator<C0497sk> it = ((C0496sj) this.f).O().iterator();
        while (it.hasNext()) {
            it.next().a(localPlayer, clientLevel, (oF<?, ?, ?>) this.f);
        }
        a(localPlayer, fTVar);
    }

    private void a(@NotNull LocalPlayer localPlayer, @NotNull fT fTVar) {
        int iMax;
        boolean z = false;
        if (((C0496sj) this.f).a() == oN.GAME && !((C0496sj) this.f).bM() && !oR.a((Player) localPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) fTVar)) {
            oO oOVarA = ((C0496sj) this.f).b().a(localPlayer.getUUID());
            oY oYVarA = oOVarA != null ? ((C0496sj) this.f).a(oOVarA) : null;
            z = (oYVarA == null || oYVarA.bu() || oYVarA.a((float) localPlayer.getX(), (float) localPlayer.getZ())) ? false : true;
        }
        boolean z2 = this.hc;
        this.hc = z;
        if (z != z2) {
            Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) (z ? C0624xc.pL : C0624xc.pK).get(), 1.0f));
        }
        if (z) {
            if (z2) {
                iMax = Math.max(0, this.qQ - 1);
            } else {
                iMax = 200;
            }
            this.qQ = iMax;
        } else {
            this.qQ = 0;
        }
        float f = z ? 0.6f : 0.0f;
        this.lS = this.lR;
        this.lR = C0634xm.g(this.lR, f, 0.2f);
    }

    @Override // com.boehmod.blockfront.oG
    public boolean bj() {
        return !this.hc;
    }

    @Override // com.boehmod.blockfront.oG
    public void a(@NotNull oI<?> oIVar, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, boolean z, float f, float f2) {
        super.a(oIVar, minecraft, clientLevel, localPlayer, renderLevelStageEvent, bufferSource, poseStack, frustum, font, guiGraphics, camera, z, f, f2);
        C0499sm c0499smM1124a = ((C0496sj) this.f).m1124a();
        if (c0499smM1124a != null) {
            c0499smM1124a.a.a(frustum, guiGraphics, font, camera, f);
            if (((C0496sj) this.f).a() == oN.GAME && ((C0496sj) this.f).bP()) {
                oO oOVarM1123g = ((C0496sj) this.f).m1123g();
                oO oOVarA = ((C0496sj) this.f).b().a(localPlayer.getUUID());
                if (oOVarM1123g != null && oOVarM1123g.equals(oOVarA)) {
                    a(camera, poseStack, frustum, localPlayer, c0499smM1124a.i.b(5));
                }
            }
        }
        if (hN.k.T()) {
            for (C0045bp c0045bp : d()) {
                AABB aabbD = c0045bp.d();
                if (c0045bp.p() && frustum.isVisible(aabbD)) {
                    Vec3 vec3M239c = c0045bp.m239c();
                    float fZ = z((float) localPlayer.position().distanceTo(vec3M239c));
                    if (fZ > 0.0f) {
                        C0040bk.a(poseStack, camera, guiGraphics, c0045bp.getTexture(), vec3M239c.x, vec3M239c.y, vec3M239c.z, 20, 20, 0.5f * fZ, false);
                    }
                }
            }
        }
        if (z) {
            a(localPlayer, poseStack, camera, font, guiGraphics);
        }
    }

    private void a(@NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull Font font, @NotNull GuiGraphics guiGraphics) {
        double y = localPlayer.getY();
        for (C0499sm c0499sm : ((C0496sj) this.f).au()) {
            String str = c0499sm.a.bP != null ? c0499sm.a.bP : "?";
            a(poseStack, camera, font, guiGraphics, c0499sm.c, str + " (attacker)", y, ColorReferences.COLOR_THEME_RED_SOLID);
            a(poseStack, camera, font, guiGraphics, c0499sm.d, str + " (defender)", y, ColorReferences.COLOR_THEME_GREEN_SOLID);
        }
    }

    private void a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull oY oYVar, @NotNull String str, double d, int i) {
        if (oYVar.bu()) {
            return;
        }
        C0040bk.a(camera, poseStack, oYVar, d - 16.0d, d + 16.0d, this.d.a(i, 0.1f).a(i, 1.0f, 2.0f));
        Vec2 vec2B = oYVar.b();
        C0040bk.a(poseStack, font, camera, guiGraphics, (Component) Component.literal(str), vec2B.x, d + 1.0d, vec2B.y, 1.0f, i, false);
    }

    private void a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull LocalPlayer localPlayer, @NotNull AABB aabb) {
        if (frustum.isVisible(aabb)) {
            float fI = C0634xm.i((float) Math.sqrt(aabb.distanceToSqr(camera.getPosition())), lI, lJ);
            if (fI <= 0.0f) {
                return;
            }
            C0040bk.a(camera, poseStack, aabb, this.c.a(ColorReferences.COLOR_THEME_YELLOW_SOLID, 0.25f).a(ColorReferences.COLOR_THEME_YELLOW_SOLID, 1.0f, 1.5f).a(localPlayer.position(), aE).a(0.0f).b(fI));
        }
    }

    @Override // com.boehmod.blockfront.oG
    @NotNull
    public List<C0045bp> b(@NotNull Minecraft minecraft, @NotNull Set<UUID> set, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        oO oOVarA = ((C0496sj) this.f).b().a(localPlayer.getUUID());
        if (oOVarA == null) {
            return new ObjectArrayList();
        }
        ObjectArrayList objectArrayList = new ObjectArrayList();
        C0499sm c0499smM1124a = ((C0496sj) this.f).m1124a();
        if (c0499smM1124a != null) {
            C0497sk c0497sk = c0499smM1124a.a;
            ResourceLocation icon = c0497sk.getIcon();
            objectArrayList.add(new C0045bp(icon != null ? icon : fj, c0497sk.c).a(fj, c0497sk.getColor()).a(6).a((Component) Component.literal(c0497sk.bP)).b(A((float) c0497sk.c.distanceTo(localPlayer.position()))));
        }
        for (Entity entity : clientLevel.entitiesForRendering()) {
            UUID uuid = entity.getUUID();
            if ((entity instanceof Player) && set.contains(uuid) && !uuid.equals(minecraft.getUser().getProfileId()) && oOVarA.h().contains(uuid)) {
                objectArrayList.add(new C0045bp(C0045bp.M, entity.position()).a(4).a(entity.getYRot() - 180.0f));
            }
        }
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.oG
    public boolean a(@NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        oO oOVarA;
        C0500sn c0500snB = ((C0496sj) this.f).b();
        oO oOVarA2 = c0500snB.a(player.getUUID());
        return oOVarA2 != null && (livingEntity instanceof Player) && (oOVarA = c0500snB.a(((Player) livingEntity).getUUID())) != null && oOVarA2.getName().equalsIgnoreCase(oOVarA.getName());
    }

    @Override // com.boehmod.blockfront.oG
    public void a(@NotNull Minecraft minecraft, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        oO oOVarA;
        C0500sn c0500snB = ((C0496sj) this.f).b();
        oO oOVarA2 = c0500snB.a(player.getUUID());
        Player entity = renderNameTagEvent.getEntity();
        if (entity instanceof Player) {
            Player player2 = entity;
            if (oOVarA2 != null && (oOVarA = c0500snB.a(player2.getUUID())) != null && oOVarA.getName().equalsIgnoreCase(oOVarA2.getName()) && player.hasLineOfSight(renderNameTagEvent.getEntity()) && player.distanceTo(renderNameTagEvent.getEntity()) <= 20.0f) {
                renderNameTagEvent.setCanRender(TriState.TRUE);
                return;
            }
        }
        renderNameTagEvent.setCanRender(TriState.FALSE);
    }

    @Override // com.boehmod.blockfront.oG
    public boolean g(@NotNull Player player) {
        return ((C0496sj) this.f).a() != oN.GAME;
    }

    @Override // com.boehmod.blockfront.oG
    public boolean bh() {
        return false;
    }

    @Override // com.boehmod.blockfront.oG
    public boolean bk() {
        return true;
    }

    @Override // com.boehmod.blockfront.oG
    @NotNull
    /* JADX INFO: renamed from: a */
    public oG.a mo770a() {
        return new oG.a().a("PING", (fTVar, playerInfo, oMVar) -> {
            return playerInfo != null ? C0637xp.a(playerInfo.getLatency()) : "???";
        }).a("K", (fTVar2, playerInfo2, oMVar2) -> {
            return C0637xp.a(oMVar2.a(C0529tp.D.getKey()));
        }).a("A", (fTVar3, playerInfo3, oMVar3) -> {
            return C0637xp.a(oMVar3.a(C0529tp.M.getKey()));
        }).a("OBJ", (fTVar4, playerInfo4, oMVar4) -> {
            return C0637xp.a(oMVar4.a(C0529tp.q.getKey()));
        }).a("SCORE", (fTVar5, playerInfo5, oMVar5) -> {
            return C0637xp.a(oMVar5.a(C0529tp.l.getKey()));
        });
    }

    @Override // com.boehmod.blockfront.oG
    @NotNull
    public Collection<? extends cU> a(boolean z) {
        return a((C0496sj) this.f, z);
    }
}
