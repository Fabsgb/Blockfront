package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p000mm.MatchParty;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.gJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gJ.class */
public class C0367gJ extends AbstractC0368gK<Player> {
    @Override // com.boehmod.blockfront.AbstractC0368gK
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ C1015sV mo1751a(@NotNull LivingEntity livingEntity, @NotNull AbstractC0787oF abstractC0787oF) {
        return m1764a((Player) livingEntity, (AbstractC0787oF<?, ?, ?>) abstractC0787oF);
    }

    @Override // com.boehmod.blockfront.AbstractC0368gK
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ String mo1752a(@NotNull LivingEntity livingEntity, @NotNull AbstractC0787oF abstractC0787oF) {
        return m1763a((Player) livingEntity, (AbstractC0787oF<?, ?, ?>) abstractC0787oF);
    }

    @Override // com.boehmod.blockfront.AbstractC0368gK
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo1765a(@NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull GuiGraphics guiGraphics, @NotNull LivingEntity livingEntity, @NotNull AbstractC0787oF abstractC0787oF, @NotNull AbstractC0790oI abstractC0790oI, LocalPlayer localPlayer, @NotNull Vec2 vec2, int i, int i2, int i3, float f, float f2, float f3, float f4, float f5) {
        m1762a(c0622l, c0326fV, guiGraphics, (Player) livingEntity, (AbstractC0787oF<?, ?, ?>) abstractC0787oF, (AbstractC0790oI<?>) abstractC0790oI, localPlayer, vec2, i, i2, i3, f, f2, f3, f4, f5);
    }

    @Override // com.boehmod.blockfront.AbstractC0368gK
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo1753a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @Nullable LocalPlayer localPlayer, @NotNull LivingEntity livingEntity, @NotNull AbstractC0787oF abstractC0787oF, @NotNull AbstractC0788oG abstractC0788oG, @NotNull C0796oO c0796oO) {
        return m1761a(renderNameTagEvent, minecraft, c0326fV, localPlayer, (Player) livingEntity, (AbstractC0787oF<?, ?, ?>) abstractC0787oF, (AbstractC0788oG<?, ?>) abstractC0788oG, c0796oO);
    }

    @Override // com.boehmod.blockfront.AbstractC0368gK, com.boehmod.blockfront.AbstractC0366gI
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo1754a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @Nullable LocalPlayer localPlayer, @NotNull Entity entity, @NotNull AbstractC0787oF abstractC0787oF, @NotNull AbstractC0788oG abstractC0788oG, @NotNull C0796oO c0796oO) {
        return m1761a(renderNameTagEvent, minecraft, c0326fV, localPlayer, (Player) entity, (AbstractC0787oF<?, ?, ?>) abstractC0787oF, (AbstractC0788oG<?, ?>) abstractC0788oG, c0796oO);
    }

    /* JADX INFO: renamed from: c */
    public static boolean m1759c(@NotNull Player player) {
        return player.getHealth() < 15.0f;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1015sV m1760a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull UUID uuid) {
        C1015sV c1015sVM5528a;
        int iM4009a = C0799oR.m4009a(abstractC0787oF, uuid, C1089tp.f5692i);
        if (iM4009a == -1 || (c1015sVM5528a = C1015sV.m5528a(iM4009a)) == null || !c1015sVM5528a.m5520bT()) {
            return null;
        }
        return c1015sVM5528a;
    }

    /* JADX INFO: renamed from: a */
    public boolean m1761a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @Nullable LocalPlayer localPlayer, @NotNull Player player, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0788oG<?, ?> abstractC0788oG, @NotNull C0796oO c0796oO) {
        UUID uuid = player.getUUID();
        C0324fT c0324fT = (C0324fT) c0326fV.m1133a(player);
        if (C0799oR.m4052a(player, c0324fT)) {
            return false;
        }
        if (localPlayer != null && localPlayer.getUUID().equals(uuid)) {
            return false;
        }
        if ((c0324fT.m1666ah() <= 0 && localPlayer != null && !localPlayer.hasLineOfSight(player)) || !m1763a(player, abstractC0787oF).equals(c0796oO.getName()) || player.getVehicle() != null) {
            return false;
        }
        C0482iS c0482iSA = c0326fV.m1133a(player);
        PlayerRank rank = c0482iSA.getRank();
        Component componentM2188b = c0482iSA.m2188b();
        if (c0482iSA.getClanId() != null) {
            componentM2188b = C0475iL.m2150a(c0482iSA).append(" ").append(componentM2188b);
        }
        MutableComponent mutableComponentCopy = componentM2188b.copy();
        Optional<MatchParty> party = c0326fV.m1676a(minecraft).getParty();
        if (party.isPresent() && party.get().isPresent(uuid)) {
            mutableComponentCopy.append(" ").append(party.get().isHost(uuid) ? C0119bk.f742x : C0119bk.f743y);
        }
        renderNameTagEvent.setContent(Component.literal(rank.getGraphic() + " ").append(mutableComponentCopy));
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void m1762a(@NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull GuiGraphics guiGraphics, @NotNull Player player, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull AbstractC0790oI<?> abstractC0790oI, LocalPlayer localPlayer, @NotNull Vec2 vec2, int i, int i2, int i3, float f, float f2, float f3, float f4, float f5) {
        ResourceLocation icon = m1764a(player, abstractC0787oF).getIcon();
        ResourceLocation resourceLocation = f2455cK;
        float fAbs = 0.5f;
        if (localPlayer != null) {
            C0324fT c0324fT = (C0324fT) c0326fV.m1133a(player);
            if (c0324fT.m1666ah() > 0) {
                icon = c0324fT.m1644j();
                i = ColorReferences.COLOR_THEME_YELLOW_SOLID;
                fAbs = Math.abs(Mth.sin(f5 / 10.0f));
            }
        }
        m1757a(guiGraphics, i, i2, i3, f, vec2, f2, f3, f4, icon, resourceLocation, fAbs);
    }

    /* JADX INFO: renamed from: a */
    public String m1763a(@NotNull Player player, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        C0796oO c0796oOM3793a = abstractC0787oF.m3582b().m3793a(player.getUUID());
        return c0796oOM3793a == null ? "unknown" : c0796oOM3793a.getName();
    }

    /* JADX INFO: renamed from: a */
    public C1015sV m1764a(@NotNull Player player, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        int iM3854a = abstractC0787oF.m3598a(player.getUUID()).m3854a(C1089tp.f5694k.getKey(), -1);
        List<C1015sV> listM5513av = C1015sV.m5513av();
        return (iM3854a < 0 || iM3854a >= listM5513av.size()) ? C1015sV.m5514c() : listM5513av.get(iM3854a);
    }
}
