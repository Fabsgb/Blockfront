package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0788oG;
import com.boehmod.blockfront.common.player.AbstractC0182b;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.sB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sB.class */
public final class C0995sB extends AbstractC0788oG<C0994sA, C0996sC> {

    /* JADX INFO: renamed from: fl */
    private static final ResourceLocation f5266fl = C0564jv.m2555d("textures/skins/game/troubletown/innocent.png");

    /* JADX INFO: renamed from: fm */
    private static final ResourceLocation f5267fm = C0564jv.m2555d("textures/skins/game/troubletown/detective.png");

    /* JADX INFO: renamed from: fn */
    private static final ResourceLocation f5268fn = C0564jv.m2555d("textures/misc/worldpoint/murder_info.png");

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: u */
    protected List<Component> mo3666u() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(Component.translatable("bf.message.gamemode.troubletown.tip.0"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.troubletown.tip.1"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.troubletown.tip.2"));
        return objectArrayList;
    }

    public C0995sB(@NotNull C0622l c0622l, @NotNull C0994sA c0994sA, @NotNull C0326fV c0326fV) {
        super(c0622l, c0994sA, c0326fV);
        c0622l.m2709a().m3222b(new C0719mr(c0994sA));
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: w */
    protected List<AbstractC0168cg<C0994sA, C0996sC>> mo3670w() {
        return List.of(new C0170ci(), new C0169ch(), new C0167cf());
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public boolean mo3676a(@NotNull AbstractClientPlayer abstractClientPlayer) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: b */
    public void mo3704b(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0324fT c0324fT, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2) {
        m5452a(font, localPlayer, clientLevel, guiGraphics, i3, i4);
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public boolean mo3718a(@NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public void mo3715a(@NotNull AbstractC0790oI<?> abstractC0790oI, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, boolean z, float f, float f2) {
        super.mo3715a(abstractC0790oI, minecraft, clientLevel, localPlayer, renderLevelStageEvent, bufferSource, poseStack, frustum, font, guiGraphics, camera, z, f, f2);
        C0324fT c0324fTM1675a = this.f4311b.m1675a(minecraft);
        EnumC1004sK enumC1004sKM5440a = ((C0994sA) this.f4272f).m5440a(localPlayer.getUUID());
        boolean zM4052a = C0799oR.m4052a((Player) localPlayer, (AbstractC0182b<?, ?, ?, ?>) c0324fTM1675a);
        for (Entity entity : clientLevel.entitiesForRendering()) {
            if (entity instanceof Player) {
                Player player = (Player) entity;
                if (!player.equals(localPlayer) && localPlayer.hasLineOfSight(entity)) {
                    m5451a(this.f4311b, guiGraphics, poseStack, camera, entity, player, enumC1004sKM5440a, f2, zM4052a);
                }
            }
        }
        ObjectListIterator it = ((C0994sA) this.f4272f).f5264X.iterator();
        while (it.hasNext()) {
            m5450a(localPlayer, poseStack, guiGraphics, font, camera, (C1046sz) it.next());
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5450a(@NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, @NotNull C1046sz c1046sz) {
        double d = c1046sz.f4424c.x;
        double d2 = c1046sz.f4424c.y;
        double d3 = c1046sz.f4424c.z;
        C0119bk.m510a(poseStack, camera, guiGraphics, f5268fn, d, d2, d3, 32, 32, 0.5f, true);
        if (Mth.sqrt((float) localPlayer.distanceToSqr(c1046sz.f4424c)) > 2.0d) {
            return;
        }
        EnumC1004sK enumC1004sKM5440a = ((C0994sA) this.f4272f).m5440a(c1046sz.getUUID());
        if (c1046sz.m5820bQ()) {
            MutableComponent mutableComponentTranslatable = Component.translatable("bf.message.gamemode.ttt.murderinfo.title", new Object[]{Component.literal(c1046sz.getUsername()).withStyle(ChatFormatting.GRAY)});
            MutableComponent mutableComponentTranslatable2 = Component.translatable("bf.message.gamemode.ttt.murderinfo.role", new Object[]{Component.literal(enumC1004sKM5440a.getKey()).withColor(enumC1004sKM5440a.getColor())});
            C0119bk.m520a(poseStack, font, camera, guiGraphics, (Component) mutableComponentTranslatable, d, d2 + 1.0d, d3, 0.5f);
            C0119bk.m520a(poseStack, font, camera, guiGraphics, (Component) mutableComponentTranslatable2, d, d2 + 0.800000011920929d, d3, 0.5f);
            if (!c1046sz.m5819aj().isEmpty()) {
                C0119bk.m520a(poseStack, font, camera, guiGraphics, (Component) Component.translatable("bf.message.gamemode.ttt.murderinfo.weapon", new Object[]{Component.translatable(c1046sz.m5819aj()).withStyle(ChatFormatting.GRAY)}), d, d2 + 0.6000000238418579d, d3, 0.5f);
                return;
            } else {
                C0119bk.m520a(poseStack, font, camera, guiGraphics, (Component) Component.translatable("bf.message.gamemode.ttt.murderinfo.weapon.unknown").withStyle(ChatFormatting.GRAY), d, d2 + 0.6000000238418579d, d3, 0.5f);
                return;
            }
        }
        C0119bk.m520a(poseStack, font, camera, guiGraphics, (Component) Component.translatable("bf.message.gamemode.ttt.murderinfo.title.unidentified").withStyle(ChatFormatting.RED), d, d2 + 0.5d, d3, 0.5f);
    }

    /* JADX INFO: renamed from: a */
    private void m5451a(@NotNull C0326fV c0326fV, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull Entity entity, @NotNull Player player, @NotNull EnumC1004sK enumC1004sK, float f, boolean z) {
        ResourceLocation texture;
        UUID uuid = player.getUUID();
        if (C0799oR.m4052a(player, (C0324fT) c0326fV.m1133a(player))) {
            return;
        }
        EnumC1004sK enumC1004sKM5440a = ((C0994sA) this.f4272f).m5440a(uuid);
        if (enumC1004sKM5440a.displayOnNameplate()) {
            Vec3 eyePosition = entity.getEyePosition(f);
            boolean z2 = false;
            if (enumC1004sKM5440a == EnumC1004sK.DETECTIVE) {
                z2 = true;
            } else if (enumC1004sKM5440a == EnumC1004sK.TRAITOR && (enumC1004sK == EnumC1004sK.TRAITOR || z)) {
                z2 = true;
            } else if (enumC1004sKM5440a == EnumC1004sK.JESTER && (enumC1004sK == EnumC1004sK.TRAITOR || z)) {
                z2 = true;
            }
            if (z2 && (texture = enumC1004sKM5440a.getTexture()) != null) {
                C0119bk.m507a(poseStack, camera, guiGraphics, texture, eyePosition.x, eyePosition.y + 1.149999976158142d, eyePosition.z, 32, 32);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: bk */
    public boolean mo3721bk() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: bi */
    public boolean mo3719bi() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: b */
    public List<C0124bp> mo3730b(@NotNull Minecraft minecraft, @NotNull Set<UUID> set, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        return new ObjectArrayList();
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
        C0996sC c0996sCB = ((C0994sA) this.f4272f).m3582b();
        String strM3053E = null;
        C0796oO c0796oOA2 = c0996sCB.m3793a(player.getUUID());
        Player entity = renderNameTagEvent.getEntity();
        if ((entity instanceof Player) && (c0796oOA = c0996sCB.m3793a(entity.getUUID())) != null) {
            strM3053E = c0796oOA.getName();
        }
        C0680mE entity2 = renderNameTagEvent.getEntity();
        if (entity2 instanceof C0680mE) {
            strM3053E = entity2.m3053E();
        }
        if (strM3053E != null && c0796oOA2 != null && strM3053E.equals(c0796oOA2.getName()) && player.distanceTo(renderNameTagEvent.getEntity()) <= 20.0f) {
            renderNameTagEvent.setCanRender(TriState.TRUE);
        } else {
            renderNameTagEvent.setCanRender(TriState.FALSE);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: g */
    public boolean mo3710g(@NotNull Player player) {
        return (player.getVehicle() == null && ((C0994sA) this.f4272f).mo3560a() == EnumC0795oN.GAME) ? false : true;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0788oG.a mo3711a() {
        return new AbstractC0788oG.a().m3765a("PING", (c0324fT, playerInfo, c0794oM) -> {
            return playerInfo != null ? C1293xp.m7912a(playerInfo.getLatency()) : "???";
        }).m3765a("SCORE", (c0324fT2, playerInfo2, c0794oM2) -> {
            Minecraft minecraft = Minecraft.getInstance();
            if (minecraft.player == null) {
                return "-";
            }
            return C0799oR.m4052a((Player) minecraft.player, (AbstractC0182b<?, ?, ?, ?>) this.f4311b.m1675a(minecraft)) ? C1293xp.m7912a(c0794oM2.m3853a(C1089tp.f5695l.getKey())) : "-";
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public ResourceLocation mo3732a(@NotNull UUID uuid, @NotNull String str, @NotNull Set<UUID> set) {
        return ((C0994sA) this.f4272f).m5440a(uuid) == EnumC1004sK.DETECTIVE ? f5267fm : f5266fl;
    }

    /* JADX INFO: renamed from: a */
    private void m5452a(@NotNull Font font, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull GuiGraphics guiGraphics, int i, int i2) {
        Vec3 eyePosition = localPlayer.getEyePosition();
        Vec3 lookAngle = localPlayer.getLookAngle();
        Vec3 vec3Add = eyePosition.add(lookAngle.x * 100.0d, lookAngle.y * 100.0d, lookAngle.z * 100.0d);
        EntityHitResult entityHitResult = ProjectileUtil.getEntityHitResult(clientLevel, localPlayer, eyePosition, vec3Add, new AABB(eyePosition, vec3Add).inflate(1.0d), entity -> {
            if (!(entity instanceof Player)) {
                return false;
            }
            Player player = (Player) entity;
            return !C0799oR.m4052a(player, (C0324fT) this.f4311b.m1133a(player));
        });
        if (entityHitResult != null) {
            Entity entity2 = entityHitResult.getEntity();
            if (entity2 instanceof Player) {
                Player player = (Player) entity2;
                if (localPlayer.hasLineOfSight(player)) {
                    MutableComponent mutableComponentM5453a = m5453a(player);
                    C0119bk.m383c(font, guiGraphics, (Component) Component.literal(player.getScoreboardName()), i, i2 + 15);
                    C0119bk.m383c(font, guiGraphics, (Component) mutableComponentM5453a, i, i2 + 25);
                }
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public MutableComponent m5453a(@NotNull Player player) {
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

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: a */
    public Collection<? extends AbstractC0156cU> mo3743a(boolean z) {
        return m3744a((C0994sA) this.f4272f, z);
    }
}
