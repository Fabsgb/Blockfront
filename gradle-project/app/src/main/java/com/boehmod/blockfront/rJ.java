package com.boehmod.blockfront;

import com.boehmod.blockfront.oG;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import net.neoforged.neoforge.common.util.TriState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rJ.class */
public final class rJ extends oG<rI, rK> {

    @NotNull
    private static final ResourceLocation fa = C0265jv.d("textures/gui/game/topelement/kills.png");

    public rJ(@NotNull C0297l c0297l, @NotNull rI rIVar, @NotNull fV fVVar) {
        super(c0297l, rIVar, fVVar);
        c0297l.m602a().b(new C0342mr(rIVar));
    }

    @Override // com.boehmod.blockfront.oG
    @NotNull
    protected List<Component> u() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(Component.translatable("bf.message.gamemode.ffa.tip.0", new Object[]{Component.literal(String.valueOf(30))}));
        objectArrayList.add(Component.translatable("bf.message.gamemode.ffa.tip.1"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.ffa.tip.2"));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.oG
    @NotNull
    protected List<AbstractC0063cg<rI, rK>> w() {
        return List.of(new C0058cb(), new C0059cc(fa, C0529tp.D, 30), new C0062cf());
    }

    @Override // com.boehmod.blockfront.oG
    public boolean a(@NotNull AbstractClientPlayer abstractClientPlayer) {
        return true;
    }

    @Override // com.boehmod.blockfront.oG
    public void b(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull fT fTVar, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.oG
    public boolean a(@NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        return false;
    }

    @Override // com.boehmod.blockfront.oG
    public boolean bk() {
        return true;
    }

    @Override // com.boehmod.blockfront.oG
    public boolean bi() {
        return false;
    }

    @Override // com.boehmod.blockfront.oG
    @NotNull
    public List<C0045bp> b(@NotNull Minecraft minecraft, @NotNull Set<UUID> set, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        return new ObjectArrayList();
    }

    @Override // com.boehmod.blockfront.oG
    public boolean bh() {
        return false;
    }

    @Override // com.boehmod.blockfront.oG
    public void a(@NotNull Minecraft minecraft, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        oO oOVarA;
        rK rKVarB = ((rI) this.f).b();
        String strE = null;
        oO oOVarA2 = rKVarB.a(player.getUUID());
        Player entity = renderNameTagEvent.getEntity();
        if ((entity instanceof Player) && (oOVarA = rKVarB.a(entity.getUUID())) != null) {
            strE = oOVarA.getName();
        }
        mE entity2 = renderNameTagEvent.getEntity();
        if (entity2 instanceof mE) {
            strE = entity2.E();
        }
        if (strE != null && oOVarA2 != null && strE.equals(oOVarA2.getName()) && player.distanceTo(renderNameTagEvent.getEntity()) <= 20.0f) {
            renderNameTagEvent.setCanRender(TriState.TRUE);
        } else {
            renderNameTagEvent.setCanRender(TriState.FALSE);
        }
    }

    @Override // com.boehmod.blockfront.oG
    public boolean g(@NotNull Player player) {
        return ((rI) this.f).a() != oN.GAME;
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
        return a((rI) this.f, z);
    }
}
