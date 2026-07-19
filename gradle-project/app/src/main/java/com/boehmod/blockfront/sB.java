package com.boehmod.blockfront;

import com.boehmod.blockfront.oG;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
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
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import net.neoforged.neoforge.common.util.TriState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sB.class */
public final class sB extends oG<sA, sC> {
    private static final ResourceLocation fl = C0265jv.d("textures/skins/game/troubletown/innocent.png");
    private static final ResourceLocation fm = C0265jv.d("textures/skins/game/troubletown/detective.png");
    private static final ResourceLocation fn = C0265jv.d("textures/misc/worldpoint/murder_info.png");

    @Override // com.boehmod.blockfront.oG
    @NotNull
    protected List<Component> u() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(Component.translatable("bf.message.gamemode.troubletown.tip.0"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.troubletown.tip.1"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.troubletown.tip.2"));
        return objectArrayList;
    }

    public sB(@NotNull C0297l c0297l, @NotNull sA sAVar, @NotNull fV fVVar) {
        super(c0297l, sAVar, fVVar);
        c0297l.m602a().b(new C0342mr(sAVar));
    }

    @Override // com.boehmod.blockfront.oG
    @NotNull
    protected List<AbstractC0063cg<sA, sC>> w() {
        return List.of(new C0065ci(), new C0064ch(), new C0062cf());
    }

    @Override // com.boehmod.blockfront.oG
    public boolean a(@NotNull AbstractClientPlayer abstractClientPlayer) {
        return false;
    }

    @Override // com.boehmod.blockfront.oG
    public void b(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull fT fTVar, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2) {
        a(font, localPlayer, clientLevel, guiGraphics, i3, i4);
    }

    @Override // com.boehmod.blockfront.oG
    public boolean a(@NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        return false;
    }

    @Override // com.boehmod.blockfront.oG
    public void a(@NotNull oI<?> oIVar, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, boolean z, float f, float f2) {
        super.a(oIVar, minecraft, clientLevel, localPlayer, renderLevelStageEvent, bufferSource, poseStack, frustum, font, guiGraphics, camera, z, f, f2);
        fT fTVarA = this.b.a(minecraft);
        sK sKVarA = ((sA) this.f).a(localPlayer.getUUID());
        boolean zA = oR.a((Player) localPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) fTVarA);
        for (Entity entity : clientLevel.entitiesForRendering()) {
            if (entity instanceof Player) {
                Player player = (Player) entity;
                if (!player.equals(localPlayer) && localPlayer.hasLineOfSight(entity)) {
                    a(this.b, guiGraphics, poseStack, camera, entity, player, sKVarA, f2, zA);
                }
            }
        }
        ObjectListIterator it = ((sA) this.f).X.iterator();
        while (it.hasNext()) {
            a(localPlayer, poseStack, guiGraphics, font, camera, (C0512sz) it.next());
        }
    }

    private void a(@NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, @NotNull C0512sz c0512sz) {
        double d = c0512sz.c.x;
        double d2 = c0512sz.c.y;
        double d3 = c0512sz.c.z;
        C0040bk.a(poseStack, camera, guiGraphics, fn, d, d2, d3, 32, 32, 0.5f, true);
        if (Mth.sqrt((float) localPlayer.distanceToSqr(c0512sz.c)) > 2.0d) {
            return;
        }
        sK sKVarA = ((sA) this.f).a(c0512sz.getUUID());
        if (c0512sz.bQ()) {
            MutableComponent mutableComponentTranslatable = Component.translatable("bf.message.gamemode.ttt.murderinfo.title", new Object[]{Component.literal(c0512sz.getUsername()).withStyle(ChatFormatting.GRAY)});
            MutableComponent mutableComponentTranslatable2 = Component.translatable("bf.message.gamemode.ttt.murderinfo.role", new Object[]{Component.literal(sKVarA.getKey()).withColor(sKVarA.getColor())});
            C0040bk.a(poseStack, font, camera, guiGraphics, (Component) mutableComponentTranslatable, d, d2 + 1.0d, d3, 0.5f);
            C0040bk.a(poseStack, font, camera, guiGraphics, (Component) mutableComponentTranslatable2, d, d2 + 0.800000011920929d, d3, 0.5f);
            if (!c0512sz.aj().isEmpty()) {
                C0040bk.a(poseStack, font, camera, guiGraphics, (Component) Component.translatable("bf.message.gamemode.ttt.murderinfo.weapon", new Object[]{Component.translatable(c0512sz.aj()).withStyle(ChatFormatting.GRAY)}), d, d2 + 0.6000000238418579d, d3, 0.5f);
                return;
            } else {
                C0040bk.a(poseStack, font, camera, guiGraphics, (Component) Component.translatable("bf.message.gamemode.ttt.murderinfo.weapon.unknown").withStyle(ChatFormatting.GRAY), d, d2 + 0.6000000238418579d, d3, 0.5f);
                return;
            }
        }
        C0040bk.a(poseStack, font, camera, guiGraphics, (Component) Component.translatable("bf.message.gamemode.ttt.murderinfo.title.unidentified").withStyle(ChatFormatting.RED), d, d2 + 0.5d, d3, 0.5f);
    }

    private void a(@NotNull fV fVVar, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull Entity entity, @NotNull Player player, @NotNull sK sKVar, float f, boolean z) {
        ResourceLocation texture;
        UUID uuid = player.getUUID();
        if (oR.a(player, (fT) fVVar.a(player))) {
            return;
        }
        sK sKVarA = ((sA) this.f).a(uuid);
        if (sKVarA.displayOnNameplate()) {
            Vec3 eyePosition = entity.getEyePosition(f);
            boolean z2 = false;
            if (sKVarA == sK.DETECTIVE) {
                z2 = true;
            } else if (sKVarA == sK.TRAITOR && (sKVar == sK.TRAITOR || z)) {
                z2 = true;
            } else if (sKVarA == sK.JESTER && (sKVar == sK.TRAITOR || z)) {
                z2 = true;
            }
            if (z2 && (texture = sKVarA.getTexture()) != null) {
                C0040bk.a(poseStack, camera, guiGraphics, texture, eyePosition.x, eyePosition.y + 1.149999976158142d, eyePosition.z, 32, 32);
            }
        }
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
        sC sCVarB = ((sA) this.f).b();
        String strE = null;
        oO oOVarA2 = sCVarB.a(player.getUUID());
        Player entity = renderNameTagEvent.getEntity();
        if ((entity instanceof Player) && (oOVarA = sCVarB.a(entity.getUUID())) != null) {
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
        return (player.getVehicle() == null && ((sA) this.f).a() == oN.GAME) ? false : true;
    }

    @Override // com.boehmod.blockfront.oG
    @NotNull
    /* JADX INFO: renamed from: a */
    public oG.a mo770a() {
        return new oG.a().a("PING", (fTVar, playerInfo, oMVar) -> {
            return playerInfo != null ? C0637xp.a(playerInfo.getLatency()) : "???";
        }).a("SCORE", (fTVar2, playerInfo2, oMVar2) -> {
            Minecraft minecraft = Minecraft.getInstance();
            if (minecraft.player == null) {
                return "-";
            }
            return oR.a((Player) minecraft.player, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) this.b.a(minecraft)) ? C0637xp.a(oMVar2.a(C0529tp.l.getKey())) : "-";
        });
    }

    @Override // com.boehmod.blockfront.oG
    public ResourceLocation a(@NotNull UUID uuid, @NotNull String str, @NotNull Set<UUID> set) {
        return ((sA) this.f).a(uuid) == sK.DETECTIVE ? fm : fl;
    }

    private void a(@NotNull Font font, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull GuiGraphics guiGraphics, int i, int i2) {
        Vec3 eyePosition = localPlayer.getEyePosition();
        Vec3 lookAngle = localPlayer.getLookAngle();
        Vec3 vec3Add = eyePosition.add(lookAngle.x * 100.0d, lookAngle.y * 100.0d, lookAngle.z * 100.0d);
        EntityHitResult entityHitResult = ProjectileUtil.getEntityHitResult(clientLevel, localPlayer, eyePosition, vec3Add, new AABB(eyePosition, vec3Add).inflate(1.0d), entity -> {
            if (!(entity instanceof Player)) {
                return false;
            }
            Player player = (Player) entity;
            return !oR.a(player, (fT) this.b.a(player));
        });
        if (entityHitResult != null) {
            Entity entity2 = entityHitResult.getEntity();
            if (entity2 instanceof Player) {
                Player player = (Player) entity2;
                if (localPlayer.hasLineOfSight(player)) {
                    MutableComponent mutableComponentA = a(player);
                    C0040bk.c(font, guiGraphics, (Component) Component.literal(player.getScoreboardName()), i, i2 + 15);
                    C0040bk.c(font, guiGraphics, (Component) mutableComponentA, i, i2 + 25);
                }
            }
        }
    }

    @NotNull
    public MutableComponent a(@NotNull Player player) {
        float health = player.getHealth();
        String str = "bf.message.gamemode.ttt.health.healthy";
        ChatFormatting chatFormatting = ChatFormatting.GREEN;
        if (health < 20.0f) {
            if (health >= 14.0f) {
                str = "bf.message.gamemode.ttt.health.hurt";
                chatFormatting = ChatFormatting.YELLOW;
            } else if (health >= 10.0f) {
                str = "bf.message.gamemode.ttt.health.wounded";
                chatFormatting = ChatFormatting.GOLD;
            } else if (health >= 4.0f) {
                str = "bf.message.gamemode.ttt.health.wounded.badly";
                chatFormatting = ChatFormatting.RED;
            } else {
                str = "bf.message.gamemode.ttt.health.near.death";
                chatFormatting = ChatFormatting.DARK_RED;
            }
        }
        return Component.translatable(str).withStyle(chatFormatting);
    }

    @Override // com.boehmod.blockfront.oG
    @NotNull
    public Collection<? extends cU> a(boolean z) {
        return a((sA) this.f, z);
    }
}
