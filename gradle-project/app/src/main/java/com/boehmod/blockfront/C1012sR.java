package com.boehmod.blockfront;

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

/* JADX INFO: renamed from: com.boehmod.blockfront.sR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sR.class */
public final class C1012sR extends AbstractC0864pc<C1011sQ, C1013sS> {
    @Override // com.boehmod.blockfront.AbstractC0864pc
    @NotNull
    /* JADX INFO: renamed from: w */
    protected List<Component> mo4102w() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(Component.translatable("bf.message.gamemode.tdm.tip.0", new Object[]{Component.literal(String.valueOf(50)).withStyle(ChatFormatting.WHITE)}));
        objectArrayList.add(Component.translatable("bf.message.gamemode.tdm.tip.1"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.tdm.tip.2"));
        return objectArrayList;
    }

    public C1012sR(@NotNull C0623l c0623l, @NotNull C1011sQ c1011sQ, @NotNull C0396gl c0396gl) {
        super(c0623l, c1011sQ, c0396gl);
        c0623l.m2895a().m3053b(new C0690mN(c1011sQ));
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    @NotNull
    /* JADX INFO: renamed from: y */
    protected List<AbstractC0188cp<C1011sQ, C1013sS>> mo4106y() {
        return List.of(new C0173ck(), new C0180cn(), new C0181co());
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public boolean mo4112a(@NotNull AbstractClientPlayer abstractClientPlayer) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: b */
    public void mo4140b(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0394gj c0394gj, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public void mo4151a(@NotNull AbstractC0866pe<?> abstractC0866pe, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, boolean z, float f, float f2) {
        super.mo4151a(abstractC0866pe, minecraft, clientLevel, localPlayer, renderLevelStageEvent, bufferSource, poseStack, frustum, font, guiGraphics, camera, z, f, f2);
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public boolean mo4154a(@NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        C0872pk c0872pkA;
        C1013sS c1013sSB = ((C1011sQ) this.f4666f).m4018b();
        C0872pk c0872pkA2 = c1013sSB.m4229a(player.getUUID());
        String strM3560L = null;
        if ((livingEntity instanceof Player) && (c0872pkA = c1013sSB.m4229a(((Player) livingEntity).getUUID())) != null) {
            strM3560L = c0872pkA.getName();
        }
        if (livingEntity instanceof C0756na) {
            strM3560L = ((C0756na) livingEntity).m3560L();
        }
        if (c0872pkA2 != null && strM3560L != null) {
            return c0872pkA2.getName().equalsIgnoreCase(strM3560L);
        }
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: bu */
    public boolean mo4157bu() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    @NotNull
    /* JADX INFO: renamed from: b */
    public List<C0134by> mo4166b(@NotNull Minecraft minecraft, @NotNull Set<UUID> set, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        C0872pk c0872pkA = ((C1011sQ) this.f4666f).m4018b().m4229a(localPlayer.getUUID());
        if (c0872pkA == null) {
            return objectArrayList;
        }
        UUID profileId = minecraft.getUser().getProfileId();
        for (Player player : clientLevel.players()) {
            UUID uuid = player.getUUID();
            if (set.contains(uuid) && !uuid.equals(profileId)) {
                boolean z = true;
                boolean zContains = c0872pkA.m4308h().contains(uuid);
                ResourceLocation resourceLocation = zContains ? C0134by.f1000M : C0134by.f1001N;
                if (!zContains && ((C0394gj) this.f4705b.m1150a(player)).m1856ar() <= 0) {
                    z = false;
                }
                if (z) {
                    objectArrayList.add(new C0134by(resourceLocation, player.position()).m730a(4).m728a(player.getYRot() - 180.0f));
                }
            }
        }
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: br */
    public boolean mo4153br() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public void mo4167a(@NotNull Minecraft minecraft, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        C0872pk c0872pkA;
        C1013sS c1013sSB = ((C1011sQ) this.f4666f).m4018b();
        String strM3560L = null;
        C0872pk c0872pkA2 = c1013sSB.m4229a(player.getUUID());
        Player entity = renderNameTagEvent.getEntity();
        if ((entity instanceof Player) && (c0872pkA = c1013sSB.m4229a(entity.getUUID())) != null) {
            strM3560L = c0872pkA.getName();
        }
        C0756na entity2 = renderNameTagEvent.getEntity();
        if (entity2 instanceof C0756na) {
            strM3560L = entity2.m3560L();
        }
        if (strM3560L != null && c0872pkA2 != null && strM3560L.equals(c0872pkA2.getName()) && player.hasLineOfSight(renderNameTagEvent.getEntity()) && player.distanceTo(renderNameTagEvent.getEntity()) <= 20.0f) {
            renderNameTagEvent.setCanRender(TriState.TRUE);
        } else {
            renderNameTagEvent.setCanRender(TriState.FALSE);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: g */
    public boolean mo4146g(@NotNull Player player) {
        return (player.getVehicle() == null && ((C1011sQ) this.f4666f).mo3996a() == EnumC0871pj.GAME) ? false : true;
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0864pc.a mo4147a() {
        return new AbstractC0864pc.a().m4201a("PING", (c0394gj, playerInfo, c0870pi) -> {
            return playerInfo != null ? C1273xM.m7239b(playerInfo.getLatency()) : "???";
        }).m4201a("K", (c0394gj2, playerInfo2, c0870pi2) -> {
            return C1273xM.m7239b(c0870pi2.m4289a(C1062tN.f5766D.getKey()));
        }).m4201a("A", (c0394gj3, playerInfo3, c0870pi3) -> {
            return C1273xM.m7239b(c0870pi3.m4289a(C1062tN.f5775M.getKey()));
        }).m4201a("SCORE", (c0394gj4, playerInfo4, c0870pi4) -> {
            return C1273xM.m7239b(c0870pi4.m4289a(C1062tN.f5748l.getKey()));
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    @NotNull
    /* JADX INFO: renamed from: a */
    public Collection<? extends AbstractC0229dd> mo4179a(boolean z) {
        return m4180a((C1011sQ) this.f4666f, z);
    }
}
