package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
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
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import net.neoforged.neoforge.common.util.TriState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rP.class */
public final class rP extends oG<rO, rR> {
    private static final Component je = Component.literal("<<< ").withStyle(ChatFormatting.RED).withStyle(ChatFormatting.BOLD);
    private static final Component jf = Component.literal(" >>>").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.GREEN);
    private static final Component jg = Component.translatable("bf.message.gamemode.gungame.weapon.previous").withColor(ColorReferences.COLOR_WHITE).withStyle(ChatFormatting.BOLD);
    private static final Component jh = Component.translatable("bf.message.gamemode.gungame.weapon.next").withColor(ColorReferences.COLOR_WHITE).withStyle(ChatFormatting.BOLD);
    private static final Component ji = Component.translatable("bf.message.gamemode.gungame.weapon.current").withStyle(C0266jw.b);
    private static final Component jj = Component.empty().append(jh).append(jf).withColor(ColorReferences.COLOR_WHITE).withStyle(ChatFormatting.BOLD);
    private static final Component jk = Component.empty().append(je).append(jg).withColor(ColorReferences.COLOR_WHITE).withStyle(ChatFormatting.BOLD);
    private static final Component jl = Component.translatable("bf.message.gamemode.gungame.kill.last.title").withStyle(C0266jw.b);
    private static final Component jm = Component.translatable("bf.message.gamemode.gungame.kill.last.subtitle").withStyle(ChatFormatting.YELLOW);
    private static final ResourceLocation fb = C0265jv.d("textures/gui/backshadow.png");
    private static final ResourceLocation fc = C0265jv.d("textures/gui/effects/fade.png");
    private static final ResourceLocation fd = C0265jv.d("textures/gui/effects/starburst.png");

    @Override // com.boehmod.blockfront.oG
    @NotNull
    protected List<Component> u() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(Component.translatable("bf.message.gamemode.gungame.tip.0"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.gungame.tip.1"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.gungame.tip.2"));
        return objectArrayList;
    }

    public rP(@NotNull C0297l c0297l, @NotNull rO rOVar, @NotNull fV fVVar) {
        super(c0297l, rOVar, fVVar);
        c0297l.m602a().b(new C0342mr(rOVar));
    }

    private void a(@NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, Font font, int i, float f) {
        int iA = oR.a((oF<?, ?, ?>) this.f, localPlayer.getUUID(), C0529tp.C);
        if (iA > ((rO) this.f).bm.size()) {
            return;
        }
        C0558ur c0558urA = ((rO) this.f).a(iA);
        C0558ur c0558urC = ((rO) this.f).c(iA);
        C0558ur c0558urB = ((rO) this.f).b(iA);
        boolean z = iA >= ((rO) this.f).bm.size();
        C0040bk.b(poseStack, guiGraphics, fb, i, -10, 256, 256, 0.3f);
        C0040bk.b(poseStack, guiGraphics, fc, i, -10, 256, 256);
        C0040bk.b(poseStack, guiGraphics, fc, i, -10.0f, 128.0f, 128.0f, 0.5f);
        C0040bk.b(poseStack, guiGraphics, fd, i, -60.0f, 256.0f, 256.0f, f / 5.0f, 0.5f);
        if (z) {
            C0040bk.b(poseStack, font, guiGraphics, jl, i, 20, 2.0f);
            C0040bk.b(poseStack, font, guiGraphics, jm, i, 45, 1.0f);
            return;
        }
        if (c0558urA != null) {
            C0040bk.a(poseStack, guiGraphics, new ItemStack(c0558urA), i, 50.0f, 4.0f);
        }
        if (c0558urB != null) {
            int i2 = i + 60;
            C0040bk.a(poseStack, guiGraphics, new ItemStack(c0558urB), i2, 50.0f, 2.0f);
            C0040bk.b(poseStack, font, guiGraphics, jj, i2, 60, 0.5f);
        }
        if (c0558urC != null) {
            int i3 = i - 60;
            C0040bk.a(poseStack, guiGraphics, new ItemStack(c0558urC), i3, 50.0f, 2.0f);
            C0040bk.b(poseStack, font, guiGraphics, jk, i3, 60, 0.5f);
        }
        if (c0558urA != null) {
            C0040bk.b(poseStack, font, guiGraphics, ji, i, 20, 1.5f);
            C0040bk.c(font, guiGraphics, (Component) Component.translatable(c0558urA.asItem().getDescriptionId()).withStyle(ChatFormatting.BOLD), i, 70);
        }
    }

    @Override // com.boehmod.blockfront.oG
    @NotNull
    protected List<AbstractC0063cg<rO, rR>> w() {
        return List.of(new C0058cb(), new C0062cf());
    }

    @Override // com.boehmod.blockfront.oG
    public boolean a(@NotNull AbstractClientPlayer abstractClientPlayer) {
        return true;
    }

    @Override // com.boehmod.blockfront.oG
    public void b(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull fT fTVar, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2) {
        if (((rO) this.f).a() == oN.GAME) {
            a(localPlayer, poseStack, guiGraphics, font, i3, f);
        }
    }

    @Override // com.boehmod.blockfront.oG
    public void a(@NotNull oI<?> oIVar, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, boolean z, float f, float f2) {
        super.a(oIVar, minecraft, clientLevel, localPlayer, renderLevelStageEvent, bufferSource, poseStack, frustum, font, guiGraphics, camera, z, f, f2);
    }

    @Override // com.boehmod.blockfront.oG
    public boolean a(@NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        oO oOVarA;
        rR rRVarB = ((rO) this.f).b();
        oO oOVarA2 = rRVarB.a(player.getUUID());
        String strE = null;
        if ((livingEntity instanceof Player) && (oOVarA = rRVarB.a(((Player) livingEntity).getUUID())) != null) {
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
        oO oOVarA = ((rO) this.f).b().a(localPlayer.getUUID());
        if (oOVarA == null) {
            return new ObjectArrayList();
        }
        Set<UUID> setH = oOVarA.h();
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (Player player : clientLevel.players()) {
            UUID uuid = player.getUUID();
            if (set.contains(uuid) && !player.equals(localPlayer)) {
                boolean z = true;
                boolean zContains = setH.contains(uuid);
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
        rR rRVarB = ((rO) this.f).b();
        String strE = null;
        oO oOVarA2 = rRVarB.a(player.getUUID());
        Player entity = renderNameTagEvent.getEntity();
        if ((entity instanceof Player) && (oOVarA = rRVarB.a(entity.getUUID())) != null) {
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
        return (player.getVehicle() == null && ((rO) this.f).a() == oN.GAME) ? false : true;
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
        return a((rO) this.f, z);
    }
}
