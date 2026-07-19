package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.mm.MatchParty;
import com.boehmod.bflib.cloud.common.player.PlayerRank;
import com.boehmod.bflib.common.ColorReferences;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec2;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gJ.class */
public class gJ extends gK<Player> {
    @Override // com.boehmod.blockfront.gK
    public /* bridge */ /* synthetic */ sV a(@NotNull LivingEntity livingEntity, @NotNull oF oFVar) {
        return m420a((Player) livingEntity, (oF<?, ?, ?>) oFVar);
    }

    @Override // com.boehmod.blockfront.gK
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ String mo418a(@NotNull LivingEntity livingEntity, @NotNull oF oFVar) {
        return a((Player) livingEntity, (oF<?, ?, ?>) oFVar);
    }

    @Override // com.boehmod.blockfront.gK
    public /* bridge */ /* synthetic */ void a(@NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull GuiGraphics guiGraphics, @NotNull LivingEntity livingEntity, @NotNull oF oFVar, @NotNull oI oIVar, LocalPlayer localPlayer, @NotNull Vec2 vec2, int i, int i2, int i3, float f, float f2, float f3, float f4, float f5) {
        a(c0297l, fVVar, guiGraphics, (Player) livingEntity, (oF<?, ?, ?>) oFVar, (oI<?>) oIVar, localPlayer, vec2, i, i2, i3, f, f2, f3, f4, f5);
    }

    @Override // com.boehmod.blockfront.gK
    public /* bridge */ /* synthetic */ boolean a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull fV fVVar, @Nullable LocalPlayer localPlayer, @NotNull LivingEntity livingEntity, @NotNull oF oFVar, @NotNull oG oGVar, @NotNull oO oOVar) {
        return a(renderNameTagEvent, minecraft, fVVar, localPlayer, (Player) livingEntity, (oF<?, ?, ?>) oFVar, (oG<?, ?>) oGVar, oOVar);
    }

    @Override // com.boehmod.blockfront.gK, com.boehmod.blockfront.gI
    public /* bridge */ /* synthetic */ boolean a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull fV fVVar, @Nullable LocalPlayer localPlayer, @NotNull Entity entity, @NotNull oF oFVar, @NotNull oG oGVar, @NotNull oO oOVar) {
        return a(renderNameTagEvent, minecraft, fVVar, localPlayer, (Player) entity, (oF<?, ?, ?>) oFVar, (oG<?, ?>) oGVar, oOVar);
    }

    public static boolean c(@NotNull Player player) {
        return player.getHealth() < 15.0f;
    }

    @Nullable
    public static sV a(@NotNull oF<?, ?, ?> oFVar, @NotNull UUID uuid) {
        sV sVVarA;
        int iA = oR.a(oFVar, uuid, C0529tp.i);
        if (iA == -1 || (sVVarA = sV.a(iA)) == null || !sVVarA.bT()) {
            return null;
        }
        return sVVarA;
    }

    public boolean a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull fV fVVar, @Nullable LocalPlayer localPlayer, @NotNull Player player, @NotNull oF<?, ?, ?> oFVar, @NotNull oG<?, ?> oGVar, @NotNull oO oOVar) {
        UUID uuid = player.getUUID();
        fT fTVar = (fT) fVVar.a(player);
        if (oR.a(player, fTVar)) {
            return false;
        }
        if (localPlayer != null && localPlayer.getUUID().equals(uuid)) {
            return false;
        }
        if ((fTVar.ah() <= 0 && localPlayer != null && !localPlayer.hasLineOfSight(player)) || !a(player, oFVar).equals(oOVar.getName()) || player.getVehicle() != null) {
            return false;
        }
        iS iSVarA = fVVar.a(player);
        PlayerRank rank = iSVarA.getRank();
        Component componentB = iSVarA.b();
        if (iSVarA.getClanId() != null) {
            componentB = iL.a(iSVarA).append(" ").append(componentB);
        }
        MutableComponent mutableComponentCopy = componentB.copy();
        Optional<MatchParty> party = fVVar.m404a(minecraft).getParty();
        if (party.isPresent() && party.get().isPresent(uuid)) {
            mutableComponentCopy.append(" ").append(party.get().isHost(uuid) ? C0040bk.x : C0040bk.y);
        }
        renderNameTagEvent.setContent(Component.literal(rank.getGraphic() + " ").append(mutableComponentCopy));
        return true;
    }

    public void a(@NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull GuiGraphics guiGraphics, @NotNull Player player, @NotNull oF<?, ?, ?> oFVar, @NotNull oI<?> oIVar, LocalPlayer localPlayer, @NotNull Vec2 vec2, int i, int i2, int i3, float f, float f2, float f3, float f4, float f5) {
        ResourceLocation icon = m420a(player, oFVar).getIcon();
        ResourceLocation resourceLocation = cK;
        float fAbs = 0.5f;
        if (localPlayer != null) {
            fT fTVar = (fT) fVVar.a(player);
            if (fTVar.ah() > 0) {
                icon = fTVar.j();
                i = ColorReferences.COLOR_THEME_YELLOW_SOLID;
                fAbs = Math.abs(Mth.sin(f5 / 10.0f));
            }
        }
        a(guiGraphics, i, i2, i3, f, vec2, f2, f3, f4, icon, resourceLocation, fAbs);
    }

    public String a(@NotNull Player player, @NotNull oF<?, ?, ?> oFVar) {
        oO oOVarA = oFVar.b().a(player.getUUID());
        return oOVarA == null ? "unknown" : oOVarA.getName();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public sV m420a(@NotNull Player player, @NotNull oF<?, ?, ?> oFVar) {
        int iA = oFVar.a(player.getUUID()).a(C0529tp.k.getKey(), -1);
        List<sV> listAv = sV.av();
        return (iA < 0 || iA >= listAv.size()) ? sV.c() : listAv.get(iA);
    }
}
