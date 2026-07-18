package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0788oG;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.su */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/su.class */
public final class C1041su extends AbstractC0788oG<C1040st, C1042sv> {
    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: u */
    protected List<Component> mo3666u() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(Component.translatable("bf.message.gamemode.tdm.tip.0", new Object[]{Component.literal(String.valueOf(50)).withStyle(ChatFormatting.WHITE)}));
        objectArrayList.add(Component.translatable("bf.message.gamemode.tdm.tip.1"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.tdm.tip.2"));
        return objectArrayList;
    }

    public C1041su(@NotNull C0622l c0622l, @NotNull C1040st c1040st, @NotNull C0326fV c0326fV) {
        super(c0622l, c1040st, c0326fV);
        c0622l.m2709a().m3222b(new C0719mr(c1040st));
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: w */
    protected List<AbstractC0168cg<C1040st, C1042sv>> mo3670w() {
        return List.of(new C0163cb(), new C0166ce(), new C0167cf());
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public boolean mo3676a(@NotNull AbstractClientPlayer abstractClientPlayer) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: b */
    public void mo3704b(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0324fT c0324fT, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public void mo3715a(@NotNull AbstractC0790oI<?> abstractC0790oI, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, boolean z, float f, float f2) {
        super.mo3715a(abstractC0790oI, minecraft, clientLevel, localPlayer, renderLevelStageEvent, bufferSource, poseStack, frustum, font, guiGraphics, camera, z, f, f2);
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public boolean mo3718a(@NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        C0796oO c0796oOA;
        C1042sv c1042svB = ((C1040st) this.f4272f).m3582b();
        C0796oO c0796oOA2 = c1042svB.m3793a(player.getUUID());
        String strM3053E = null;
        if ((livingEntity instanceof Player) && (c0796oOA = c1042svB.m3793a(((Player) livingEntity).getUUID())) != null) {
            strM3053E = c0796oOA.getName();
        }
        if (livingEntity instanceof C0680mE) {
            strM3053E = ((C0680mE) livingEntity).m3053E();
        }
        if (c0796oOA2 != null && strM3053E != null) {
            return c0796oOA2.getName().equalsIgnoreCase(strM3053E);
        }
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: bk */
    public boolean mo3721bk() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: b */
    public List<C0124bp> mo3730b(@NotNull Minecraft minecraft, @NotNull Set<UUID> set, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        C0796oO c0796oOA = ((C1040st) this.f4272f).m3582b().m3793a(localPlayer.getUUID());
        if (c0796oOA == null) {
            return objectArrayList;
        }
        UUID profileId = minecraft.getUser().getProfileId();
        for (Player player : clientLevel.players()) {
            UUID uuid = player.getUUID();
            if (set.contains(uuid) && !uuid.equals(profileId)) {
                boolean z = true;
                boolean zContains = c0796oOA.m3872h().contains(uuid);
                ResourceLocation resourceLocation = zContains ? C0124bp.f865M : C0124bp.f866N;
                if (!zContains && ((C0324fT) this.f4311b.m1133a(player)).m1646af() <= 0) {
                    z = false;
                }
                if (z) {
                    objectArrayList.add(new C0124bp(resourceLocation, player.position()).m625a(4).m623a(player.getYRot() - 180.0f));
                }
            }
        }
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: bh */
    public boolean mo3717bh() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public void mo3731a(@NotNull Minecraft minecraft, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        C0796oO c0796oOA;
        C1042sv c1042svB = ((C1040st) this.f4272f).m3582b();
        String strM3053E = null;
        C0796oO c0796oOA2 = c1042svB.m3793a(player.getUUID());
        Player entity = renderNameTagEvent.getEntity();
        if ((entity instanceof Player) && (c0796oOA = c1042svB.m3793a(entity.getUUID())) != null) {
            strM3053E = c0796oOA.getName();
        }
        C0680mE entity2 = renderNameTagEvent.getEntity();
        if (entity2 instanceof C0680mE) {
            strM3053E = entity2.m3053E();
        }
        if (strM3053E != null && c0796oOA2 != null && strM3053E.equals(c0796oOA2.getName()) && player.hasLineOfSight(renderNameTagEvent.getEntity()) && player.distanceTo(renderNameTagEvent.getEntity()) <= 20.0f) {
            renderNameTagEvent.setCanRender(TriState.TRUE);
        } else {
            renderNameTagEvent.setCanRender(TriState.FALSE);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: g */
    public boolean mo3710g(@NotNull Player player) {
        return (player.getVehicle() == null && ((C1040st) this.f4272f).mo3560a() == EnumC0795oN.GAME) ? false : true;
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
        }).m3765a("SCORE", (c0324fT4, playerInfo4, c0794oM4) -> {
            return C1293xp.m7912a(c0794oM4.m3853a(C1089tp.f5695l.getKey()));
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: a */
    public Collection<? extends AbstractC0156cU> mo3743a(boolean z) {
        return m3744a((C1040st) this.f4272f, z);
    }
}
