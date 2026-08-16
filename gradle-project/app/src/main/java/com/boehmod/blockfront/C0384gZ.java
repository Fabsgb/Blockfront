package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p001mm.MatchParty;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.gZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gZ.class */
public class C0384gZ extends AbstractC0438ha<Player> {
    @Override // com.boehmod.blockfront.AbstractC0438ha
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ C1093ts mo1818a(@NotNull LivingEntity livingEntity, @NotNull AbstractC0863pb abstractC0863pb) {
        return m1831a((Player) livingEntity, (AbstractC0863pb<?, ?, ?>) abstractC0863pb);
    }

    @Override // com.boehmod.blockfront.AbstractC0438ha
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ String mo1819a(@NotNull LivingEntity livingEntity, @NotNull AbstractC0863pb abstractC0863pb) {
        return m1830a((Player) livingEntity, (AbstractC0863pb<?, ?, ?>) abstractC0863pb);
    }

    @Override // com.boehmod.blockfront.AbstractC0438ha
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo1832a(@NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull GuiGraphics guiGraphics, @NotNull LivingEntity livingEntity, @NotNull AbstractC0863pb abstractC0863pb, @NotNull AbstractC0866pe abstractC0866pe, LocalPlayer localPlayer, @NotNull Vec2 vec2, int i, int i2, int i3, float f, float f2, float f3, float f4, float f5) {
        m1829a(c0623l, c0396gl, guiGraphics, (Player) livingEntity, (AbstractC0863pb<?, ?, ?>) abstractC0863pb, (AbstractC0866pe<?>) abstractC0866pe, localPlayer, vec2, i, i2, i3, f, f2, f3, f4, f5);
    }

    @Override // com.boehmod.blockfront.AbstractC0438ha
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo1820a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @Nullable LocalPlayer localPlayer, @NotNull LivingEntity livingEntity, @NotNull AbstractC0863pb abstractC0863pb, @NotNull AbstractC0864pc abstractC0864pc, @NotNull C0872pk c0872pk) {
        return m1828a(renderNameTagEvent, minecraft, c0396gl, localPlayer, (Player) livingEntity, (AbstractC0863pb<?, ?, ?>) abstractC0863pb, (AbstractC0864pc<?, ?>) abstractC0864pc, c0872pk);
    }

    @Override // com.boehmod.blockfront.AbstractC0438ha, com.boehmod.blockfront.AbstractC0383gY
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo1821a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @Nullable LocalPlayer localPlayer, @NotNull Entity entity, @NotNull AbstractC0863pb abstractC0863pb, @NotNull AbstractC0864pc abstractC0864pc, @NotNull C0872pk c0872pk) {
        return m1828a(renderNameTagEvent, minecraft, c0396gl, localPlayer, (Player) entity, (AbstractC0863pb<?, ?, ?>) abstractC0863pb, (AbstractC0864pc<?, ?>) abstractC0864pc, c0872pk);
    }

    /* JADX INFO: renamed from: c */
    public static boolean m1826c(@NotNull Player player) {
        return player.getHealth() < 15.0f;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static C1093ts m1827a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull UUID uuid) {
        C1093ts c1093tsM6016a;
        int iM4445a = C0875pn.m4445a(abstractC0863pb, uuid, C1062tN.f5745i);
        if (iM4445a == -1 || (c1093tsM6016a = C1093ts.m6016a(iM4445a)) == null || !c1093tsM6016a.m6008cd()) {
            return null;
        }
        return c1093tsM6016a;
    }

    /* JADX INFO: renamed from: a */
    public boolean m1828a(@NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @Nullable LocalPlayer localPlayer, @NotNull Player player, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0864pc<?, ?> abstractC0864pc, @NotNull C0872pk c0872pk) {
        UUID uuid = player.getUUID();
        C0394gj c0394gj = (C0394gj) c0396gl.m1150a(player);
        if (C0875pn.m4488a(player, c0394gj)) {
            return false;
        }
        if (localPlayer != null && localPlayer.getUUID().equals(uuid)) {
            return false;
        }
        if ((c0394gj.m1876at() <= 0 && localPlayer != null && !localPlayer.hasLineOfSight(player)) || !m1830a(player, abstractC0863pb).equals(c0872pk.getName()) || player.getVehicle() != null) {
            return false;
        }
        C0555jl c0555jlA = c0396gl.m1150a(player);
        PlayerRank rank = c0555jlA.getRank();
        Component componentM2515b = c0555jlA.m2515b();
        if (c0555jlA.getClanId() != null) {
            componentM2515b = C0548je.m2477a(c0555jlA).append(" ").append(componentM2515b);
        }
        MutableComponent mutableComponentCopy = componentM2515b.copy();
        Optional<MatchParty> party = c0396gl.m1886a(minecraft).getParty();
        if (party.isPresent() && party.get().isPresent(uuid)) {
            mutableComponentCopy.append(" ").append(party.get().isHost(uuid) ? C0129bt.f877x : C0129bt.f878y);
        }
        renderNameTagEvent.setContent(Component.literal(rank.getGraphic() + " ").append(mutableComponentCopy));
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void m1829a(@NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull GuiGraphics guiGraphics, @NotNull Player player, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull AbstractC0866pe<?> abstractC0866pe, LocalPlayer localPlayer, @NotNull Vec2 vec2, int i, int i2, int i3, float f, float f2, float f3, float f4, float f5) {
        ResourceLocation icon = m1831a(player, abstractC0863pb).getIcon();
        ResourceLocation resourceLocation = f2793cK;
        float fAbs = 0.5f;
        if (localPlayer != null) {
            C0394gj c0394gj = (C0394gj) c0396gl.m1150a(player);
            if (c0394gj.m1876at() > 0) {
                icon = c0394gj.m1854k();
                i = ColorReferences.COLOR_THEME_YELLOW_SOLID;
                fAbs = Math.abs(Mth.sin(f5 / 10.0f));
            }
        }
        m1824a(guiGraphics, i, i2, i3, f, vec2, f2, f3, f4, icon, resourceLocation, fAbs);
    }

    /* JADX INFO: renamed from: a */
    public String m1830a(@NotNull Player player, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        C0872pk c0872pkM4229a = abstractC0863pb.m4018b().m4229a(player.getUUID());
        return c0872pkM4229a == null ? "unknown" : c0872pkM4229a.getName();
    }

    /* JADX INFO: renamed from: a */
    public C1093ts m1831a(@NotNull Player player, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        int iM4290a = abstractC0863pb.m4034a(player.getUUID()).m4290a(C1062tN.f5747k.getKey(), -1);
        List<C1093ts> listM6001ax = C1093ts.m6001ax();
        return (iM4290a < 0 || iM4290a >= listM6001ax.size()) ? C1093ts.m6002c() : listM6001ax.get(iM4290a);
    }
}
