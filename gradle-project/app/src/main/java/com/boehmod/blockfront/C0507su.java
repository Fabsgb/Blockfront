package com.boehmod.blockfront;

import com.boehmod.blockfront.oG;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collection;
import java.util.List;
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
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import net.neoforged.neoforge.common.util.TriState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.su, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/su.class */
public final class C0507su extends oG<C0506st, C0508sv> {
    @Override // com.boehmod.blockfront.oG
    @NotNull
    protected List<Component> u() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(Component.translatable("bf.message.gamemode.tdm.tip.0", new Object[]{Component.literal(String.valueOf(50)).withStyle(ChatFormatting.WHITE)}));
        objectArrayList.add(Component.translatable("bf.message.gamemode.tdm.tip.1"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.tdm.tip.2"));
        return objectArrayList;
    }

    public C0507su(@NotNull C0297l c0297l, @NotNull C0506st c0506st, @NotNull fV fVVar) {
        super(c0297l, c0506st, fVVar);
        c0297l.m602a().b(new C0342mr(c0506st));
    }

    @Override // com.boehmod.blockfront.oG
    @NotNull
    protected List<AbstractC0063cg<C0506st, C0508sv>> w() {
        return List.of(new C0058cb(), new C0061ce(), new C0062cf());
    }

    @Override // com.boehmod.blockfront.oG
    public boolean a(@NotNull AbstractClientPlayer abstractClientPlayer) {
        return true;
    }

    @Override // com.boehmod.blockfront.oG
    public void b(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull fT fTVar, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.oG
    public void a(@NotNull oI<?> oIVar, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, boolean z, float f, float f2) {
        super.a(oIVar, minecraft, clientLevel, localPlayer, renderLevelStageEvent, bufferSource, poseStack, frustum, font, guiGraphics, camera, z, f, f2);
    }

    @Override // com.boehmod.blockfront.oG
    public boolean a(@NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        oO oOVarA;
        C0508sv c0508svB = ((C0506st) this.f).b();
        oO oOVarA2 = c0508svB.a(player.getUUID());
        String strE = null;
        if ((livingEntity instanceof Player) && (oOVarA = c0508svB.a(((Player) livingEntity).getUUID())) != null) {
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
        ObjectArrayList objectArrayList = new ObjectArrayList();
        oO oOVarA = ((C0506st) this.f).b().a(localPlayer.getUUID());
        if (oOVarA == null) {
            return objectArrayList;
        }
        UUID profileId = minecraft.getUser().getProfileId();
        for (Player player : clientLevel.players()) {
            UUID uuid = player.getUUID();
            if (set.contains(uuid) && !uuid.equals(profileId)) {
                boolean z = true;
                boolean zContains = oOVarA.h().contains(uuid);
                ResourceLocation resourceLocation = zContains ? C0045bp.M : C0045bp.N;
                if (!zContains && ((fT) this.b.a(player)).af() <= 0) {
                    z = false;
                }
                if (z) {
                    objectArrayList.add(new C0045bp(resourceLocation, player.position()).a(4).a(player.getYRot() - 180.0f));
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
        C0508sv c0508svB = ((C0506st) this.f).b();
        String strE = null;
        oO oOVarA2 = c0508svB.a(player.getUUID());
        Player entity = renderNameTagEvent.getEntity();
        if ((entity instanceof Player) && (oOVarA = c0508svB.a(entity.getUUID())) != null) {
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
        return (player.getVehicle() == null && ((C0506st) this.f).a() == oN.GAME) ? false : true;
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
        }).a("SCORE", (fTVar4, playerInfo4, oMVar4) -> {
            return C0637xp.a(oMVar4.a(C0529tp.l.getKey()));
        });
    }

    @Override // com.boehmod.blockfront.oG
    @NotNull
    public Collection<? extends cU> a(boolean z) {
        return a((C0506st) this.f, z);
    }
}
