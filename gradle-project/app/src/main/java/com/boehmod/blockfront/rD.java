package com.boehmod.blockfront;

import com.boehmod.blockfront.oG;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import javax.annotation.Nonnull;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import net.neoforged.neoforge.common.util.TriState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rD.class */
public final class rD extends oH<rB, rE> implements qJ {

    @Nonnull
    private static final Component jb = Component.translatable("bf.message.spawn.axis");

    @Nonnull
    private static final Component jc = Component.translatable("bf.message.spawn.allies");

    @Nonnull
    private static final ResourceLocation eV = C0265jv.d("textures/misc/worldpoint/ammo.png");

    @Nonnull
    private static final ResourceLocation eW = C0265jv.d("textures/gui/game/radio/bg.png");

    @Nonnull
    private static final ResourceLocation eX = C0265jv.d("textures/gui/compass/waypoint_pp_enemy_shoot.png");

    @Nonnull
    private static final ResourceLocation eY = C0265jv.d("textures/gui/compass/waypoint_pp_shoot.png");

    @Nonnull
    private static final ResourceLocation eZ = C0265jv.d("textures/misc/bfneutralicon.png");

    @Override // com.boehmod.blockfront.oG
    @NotNull
    protected List<Component> u() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(Component.translatable("bf.message.gamemode.domination.tip.0"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.domination.tip.1"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.domination.tip.2"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.domination.tip.3", new Object[]{Component.literal(C0637xp.a(500L)).withStyle(ChatFormatting.WHITE)}));
        objectArrayList.add(Component.translatable("bf.message.gamemode.domination.tip.4", new Object[]{wM.i.getKey().getDisplayName().copy().withStyle(ChatFormatting.WHITE), wM.h.getKey().getDisplayName().copy().withStyle(ChatFormatting.WHITE)}));
        return objectArrayList;
    }

    public rD(@NotNull C0297l c0297l, @NotNull rB rBVar, @NotNull fV fVVar) {
        super(c0297l, rBVar, fVVar);
        c0297l.m602a().b(new C0342mr(rBVar));
    }

    @Override // com.boehmod.blockfront.oG
    @NotNull
    protected List<AbstractC0063cg<rB, rE>> w() {
        return List.of(new C0058cb(), new C0060cd(rB.pJ, 64, C0529tp.cZ, false), new bT(), new C0060cd(rB.pJ, 64, C0529tp.da, true), new C0062cf());
    }

    @Override // com.boehmod.blockfront.oG
    public boolean a(@NotNull AbstractClientPlayer abstractClientPlayer) {
        return true;
    }

    @Override // com.boehmod.blockfront.oH, com.boehmod.blockfront.oG
    public void a(@NotNull Minecraft minecraft, @NotNull Random random, @NotNull RandomSource randomSource, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0297l c0297l, @NotNull fT fTVar, @NotNull Set<UUID> set, float f, @NotNull Vec3 vec3, @NotNull BlockPos blockPos) {
        super.a(minecraft, random, randomSource, localPlayer, clientLevel, c0297l, fTVar, set, f, vec3, blockPos);
        this.b = ((rB) this.f).a((Player) localPlayer, set);
        Iterator<rC> it = ((rB) this.f).O().iterator();
        while (it.hasNext()) {
            it.next().a(localPlayer, clientLevel, (oF<?, ?, ?>) this.f);
        }
    }

    @Override // com.boehmod.blockfront.oG
    public void a(@NotNull oI<?> oIVar, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, boolean z, float f, float f2) {
        super.a(oIVar, minecraft, clientLevel, localPlayer, renderLevelStageEvent, bufferSource, poseStack, frustum, font, guiGraphics, camera, z, f, f2);
        Iterator<rC> it = ((rB) this.f).O().iterator();
        while (it.hasNext()) {
            it.next().a(frustum, guiGraphics, font, camera, f);
        }
        boolean zShouldRenderHitBoxes = minecraft.getEntityRenderDispatcher().shouldRenderHitBoxes();
        if (hN.k.T()) {
            for (C0045bp c0045bp : d()) {
                AABB aabbD = c0045bp.d();
                if (zShouldRenderHitBoxes) {
                    LevelRenderer.renderLineBox(poseStack, bufferSource.getBuffer(RenderType.lines()), aabbD, 1.0f, 1.0f, 1.0f, 1.0f);
                }
                if (c0045bp.p() && frustum.isVisible(aabbD)) {
                    Vec3 vec3M239c = c0045bp.m239c();
                    float fZ = z((float) localPlayer.position().distanceTo(vec3M239c));
                    if (fZ > 0.0f) {
                        C0040bk.a(poseStack, camera, guiGraphics, c0045bp.getTexture(), vec3M239c.x, vec3M239c.y, vec3M239c.z, 20, 20, 0.5f * fZ, false);
                    }
                }
            }
        }
        if (zShouldRenderHitBoxes) {
            Iterator<rC> it2 = ((rB) this.f).O().iterator();
            while (it2.hasNext()) {
                LevelRenderer.renderLineBox(poseStack, bufferSource.getBuffer(RenderType.lines()), it2.next().d(), 1.0f, 1.0f, 1.0f, 1.0f);
            }
        }
        if (minecraft.getDebugOverlay().showDebugScreen() && localPlayer.isCreative()) {
            Vec3 vec3 = null;
            Iterator<rC> it3 = ((rB) this.f).O().iterator();
            while (it3.hasNext()) {
                Vec3 vec32 = it3.next().c;
                if (vec3 != null) {
                    C0040bk.a(camera, poseStack, vec32, vec3, 1.0f, 16711680);
                }
                vec3 = vec32;
            }
        }
    }

    @Override // com.boehmod.blockfront.oG
    public boolean a(@NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        oO oOVarA;
        rE rEVarB = ((rB) this.f).b();
        oO oOVarA2 = rEVarB.a(player.getUUID());
        String strE = null;
        if ((livingEntity instanceof Player) && (oOVarA = rEVarB.a(((Player) livingEntity).getUUID())) != null) {
            strE = oOVarA.getName();
        }
        if (livingEntity instanceof mE) {
            strE = ((mE) livingEntity).E();
        }
        if (oOVarA2 != null && strE != null) {
            return oOVarA2.getName().equalsIgnoreCase(strE);
        }
        return false;
    }

    @Override // com.boehmod.blockfront.oG
    public boolean bk() {
        return true;
    }

    @Override // com.boehmod.blockfront.oG
    @NotNull
    public List<C0045bp> b(@NotNull Minecraft minecraft, @NotNull Set<UUID> set, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        rE rEVarB = ((rB) this.f).b();
        oO oOVarA = rEVarB.a(localPlayer.getUUID());
        if (oOVarA == null) {
            return new ObjectArrayList();
        }
        oO oOVarA2 = rEVarB.a(C0529tp.da);
        oO oOVarA3 = rEVarB.a(C0529tp.cZ);
        if (oOVarA2 == null || oOVarA3 == null) {
            return new ObjectArrayList();
        }
        ObjectArrayList objectArrayList = new ObjectArrayList();
        ObjectArrayList objectArrayList2 = new ObjectArrayList();
        for (oX oXVar : oOVarA3.B()) {
            objectArrayList2.add(new Vec2((int) oXVar.c.x, (int) oXVar.c.z));
        }
        ObjectArrayList objectArrayList3 = new ObjectArrayList();
        for (oX oXVar2 : oOVarA2.B()) {
            objectArrayList3.add(new Vec2((int) oXVar2.c.x, (int) oXVar2.c.z));
        }
        int size = objectArrayList2.size();
        int size2 = objectArrayList3.size();
        float f = 0.0f;
        Iterator it = objectArrayList2.iterator();
        while (it.hasNext()) {
            f += ((Vec2) it.next()).x;
        }
        float fMax = f / Math.max(size, 1);
        float f2 = 0.0f;
        Iterator it2 = objectArrayList2.iterator();
        while (it2.hasNext()) {
            f2 += ((Vec2) it2.next()).y;
        }
        objectArrayList.add(new C0045bp(C0025aw.o, new Vec2(fMax, f2 / Math.max(size, 1))).a(9).a(jc));
        float f3 = 0.0f;
        Iterator it3 = objectArrayList3.iterator();
        while (it3.hasNext()) {
            f3 += ((Vec2) it3.next()).x;
        }
        float fMax2 = f3 / Math.max(size2, 1);
        float f4 = 0.0f;
        Iterator it4 = objectArrayList3.iterator();
        while (it4.hasNext()) {
            f4 += ((Vec2) it4.next()).y;
        }
        objectArrayList.add(new C0045bp(C0025aw.p, new Vec2(fMax2, f4 / Math.max(size2, 1))).a(9).a(jb));
        for (C0413ph c0413ph : x()) {
            Vec3 vec3C = c0413ph.c();
            objectArrayList.add(new C0045bp(eW, vec3C).a(28));
            objectArrayList.add(new C0045bp(c0413ph.getIcon(), vec3C).a(14));
        }
        for (rC rCVar : ((rB) this.f).O()) {
            int color = rCVar.getColor();
            ResourceLocation icon = rCVar.getIcon();
            if (icon != null) {
                objectArrayList.add(new C0045bp(icon, rCVar.c).a(eZ, color).a(6).a(Component.literal(rCVar.bP)).b(A((float) rCVar.c.distanceTo(localPlayer.position()))));
            }
        }
        for (oW oWVar : ((rB) this.f).ao()) {
            objectArrayList.add(new C0045bp(eV, oWVar.c.add(0.0d, 0.5d, 0.0d)).a(4).a().b(z((float) oWVar.c.distanceTo(localPlayer.position()))));
        }
        for (mE mEVar : clientLevel.entitiesForRendering()) {
            UUID uuid = mEVar.getUUID();
            if ((set.contains(uuid) && !uuid.equals(minecraft.getUser().getProfileId())) || (mEVar instanceof mE)) {
                boolean z = true;
                boolean zContains = oOVarA.h().contains(uuid);
                if (mEVar instanceof mE) {
                    zContains = mEVar.E().equalsIgnoreCase(oOVarA.getName());
                }
                ResourceLocation resourceLocation = zContains ? C0045bp.M : C0045bp.N;
                if (!zContains && (mEVar instanceof Player)) {
                    if (((fT) this.b.a((Player) mEVar)).af() <= 0) {
                        z = false;
                    }
                }
                if (mEVar instanceof mE) {
                    mE mEVar2 = mEVar;
                    if (!oOVarA.getName().equalsIgnoreCase(mEVar2.E())) {
                        if (mEVar2.aw() > 0) {
                            resourceLocation = eX;
                        } else if (!localPlayer.hasLineOfSight(mEVar2)) {
                            z = false;
                        }
                    } else if (mEVar2.aw() > 0) {
                        resourceLocation = eY;
                    }
                }
                if (z) {
                    objectArrayList.add(new C0045bp(resourceLocation, mEVar.position()).a(4).a(mEVar.getYRot() - 180.0f));
                }
            }
        }
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.oG
    public boolean bh() {
        return false;
    }

    @Override // com.boehmod.blockfront.oG
    public void a(@NotNull Minecraft minecraft, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        oO oOVarA;
        rE rEVarB = ((rB) this.f).b();
        String strE = null;
        oO oOVarA2 = rEVarB.a(player.getUUID());
        Player entity = renderNameTagEvent.getEntity();
        if ((entity instanceof Player) && (oOVarA = rEVarB.a(entity.getUUID())) != null) {
            strE = oOVarA.getName();
        }
        mE entity2 = renderNameTagEvent.getEntity();
        if (entity2 instanceof mE) {
            strE = entity2.E();
        }
        if (strE != null && oOVarA2 != null && strE.equals(oOVarA2.getName()) && player.hasLineOfSight(renderNameTagEvent.getEntity()) && player.distanceTo(renderNameTagEvent.getEntity()) <= 20.0f) {
            renderNameTagEvent.setCanRender(TriState.TRUE);
        } else {
            renderNameTagEvent.setCanRender(TriState.FALSE);
        }
    }

    @Override // com.boehmod.blockfront.oG
    public boolean g(@NotNull Player player) {
        return (player.getVehicle() == null && ((rB) this.f).a() == oN.GAME) ? false : true;
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
        return a((rB) this.f, z);
    }

    @Override // com.boehmod.blockfront.qJ
    public void e(@NotNull Minecraft minecraft, @NotNull C0297l c0297l) {
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null) {
            return;
        }
        HitResult hitResultA = tM.a(localPlayer, 64.0d, 0.0f);
        if (hitResultA.getType() == HitResult.Type.MISS) {
            return;
        }
        Vec3 location = hitResultA.getLocation();
        UUID uuid = localPlayer.getUUID();
        sS sSVarA = a(location, 2.0d);
        if (sSVarA != null && sSVarA.h().equals(uuid)) {
            C0582vo.c(new vO(sSVarA.i(), location));
        } else {
            C0582vo.c(new vM(location));
        }
    }

    @Override // com.boehmod.blockfront.qJ
    public boolean a(@NotNull sS sSVar, @NotNull UUID uuid, @NotNull Vec3 vec3) {
        return ((float) sSVar.c().distanceTo(vec3)) <= 2.0f && sSVar.h().equals(uuid);
    }
}
