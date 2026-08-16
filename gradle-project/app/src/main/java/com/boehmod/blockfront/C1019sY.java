package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.sY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sY.class */
public final class C1019sY extends AbstractC0864pc<C1018sX, C1020sZ> {

    /* JADX INFO: renamed from: fk */
    private static final ResourceLocation f5595fk = C0532jO.m2378d("textures/skins/game/troubletown/innocent.png");

    /* JADX INFO: renamed from: fl */
    private static final ResourceLocation f5596fl = C0532jO.m2378d("textures/skins/game/troubletown/detective.png");

    /* JADX INFO: renamed from: fm */
    private static final ResourceLocation f5597fm = C0532jO.m2378d("textures/misc/worldpoint/murder_info.png");

    @Override // com.boehmod.blockfront.AbstractC0864pc
    @NotNull
    /* JADX INFO: renamed from: w */
    protected List<Component> mo4102w() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(Component.translatable("bf.message.gamemode.troubletown.tip.0"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.troubletown.tip.1"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.troubletown.tip.2"));
        return objectArrayList;
    }

    public C1019sY(@NotNull C0623l c0623l, @NotNull C1018sX c1018sX, @NotNull C0396gl c0396gl) {
        super(c0623l, c1018sX, c0396gl);
        c0623l.m2895a().m3053b(new C0690mN(c1018sX));
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    @NotNull
    /* JADX INFO: renamed from: y */
    protected List<AbstractC0188cp<C1018sX, C1020sZ>> mo4106y() {
        return List.of(new C0190cr(), new C0189cq(), new C0181co());
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public boolean mo4112a(@NotNull AbstractClientPlayer abstractClientPlayer) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: b */
    public void mo4140b(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0394gj c0394gj, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2) {
        m5730a(font, localPlayer, clientLevel, guiGraphics, i3, i4);
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public boolean mo4154a(@NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public void mo4151a(@NotNull AbstractC0866pe<?> abstractC0866pe, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, boolean z, float f, float f2) {
        super.mo4151a(abstractC0866pe, minecraft, clientLevel, localPlayer, renderLevelStageEvent, bufferSource, poseStack, frustum, font, guiGraphics, camera, z, f, f2);
        C0394gj c0394gjM1885a = this.f4705b.m1885a(minecraft);
        EnumC1082th enumC1082thM5718a = ((C1018sX) this.f4666f).m5718a(localPlayer.getUUID());
        boolean zM4488a = C0875pn.m4488a((Player) localPlayer, (AbstractC0183b<?, ?, ?, ?>) c0394gjM1885a);
        for (Entity entity : clientLevel.entitiesForRendering()) {
            if (entity instanceof Player) {
                Player player = (Player) entity;
                if (!player.equals(localPlayer) && localPlayer.hasLineOfSight(entity)) {
                    m5729a(this.f4705b, guiGraphics, poseStack, camera, entity, player, enumC1082thM5718a, f2, zM4488a);
                }
            }
        }
        ObjectListIterator it = ((C1018sX) this.f4666f).f5593ag.iterator();
        while (it.hasNext()) {
            m5728a(localPlayer, poseStack, guiGraphics, font, camera, (C1017sW) it.next());
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5728a(@NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, @NotNull C1017sW c1017sW) {
        double d = c1017sW.f4827c.x;
        double d2 = c1017sW.f4827c.y;
        double d3 = c1017sW.f4827c.z;
        C0129bt.m610a(poseStack, camera, guiGraphics, f5597fm, d, d2, d3, 32, 32, 0.5f, true);
        if (Mth.sqrt((float) localPlayer.distanceToSqr(c1017sW.f4827c)) > 2.0d) {
            return;
        }
        EnumC1082th enumC1082thM5718a = ((C1018sX) this.f4666f).m5718a(c1017sW.getUUID());
        if (c1017sW.m5709ca()) {
            MutableComponent mutableComponentTranslatable = Component.translatable("bf.message.gamemode.ttt.murderinfo.title", new Object[]{Component.literal(c1017sW.getUsername()).withStyle(ChatFormatting.GRAY)});
            MutableComponent mutableComponentTranslatable2 = Component.translatable("bf.message.gamemode.ttt.murderinfo.role", new Object[]{Component.literal(enumC1082thM5718a.getKey()).withColor(enumC1082thM5718a.getColor())});
            C0129bt.m621a(poseStack, font, camera, guiGraphics, (Component) mutableComponentTranslatable, d, d2 + 1.0d, d3, 0.5f);
            C0129bt.m621a(poseStack, font, camera, guiGraphics, (Component) mutableComponentTranslatable2, d, d2 + 0.800000011920929d, d3, 0.5f);
            if (!c1017sW.m5708aq().isEmpty()) {
                C0129bt.m621a(poseStack, font, camera, guiGraphics, (Component) Component.translatable("bf.message.gamemode.ttt.murderinfo.weapon", new Object[]{Component.translatable(c1017sW.m5708aq()).withStyle(ChatFormatting.GRAY)}), d, d2 + 0.6000000238418579d, d3, 0.5f);
                return;
            } else {
                C0129bt.m621a(poseStack, font, camera, guiGraphics, (Component) Component.translatable("bf.message.gamemode.ttt.murderinfo.weapon.unknown").withStyle(ChatFormatting.GRAY), d, d2 + 0.6000000238418579d, d3, 0.5f);
                return;
            }
        }
        C0129bt.m621a(poseStack, font, camera, guiGraphics, (Component) Component.translatable("bf.message.gamemode.ttt.murderinfo.title.unidentified").withStyle(ChatFormatting.RED), d, d2 + 0.5d, d3, 0.5f);
    }

    /* JADX INFO: renamed from: a */
    private void m5729a(@NotNull C0396gl c0396gl, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull Entity entity, @NotNull Player player, @NotNull EnumC1082th enumC1082th, float f, boolean z) {
        ResourceLocation texture;
        UUID uuid = player.getUUID();
        if (C0875pn.m4488a(player, (C0394gj) c0396gl.m1150a(player))) {
            return;
        }
        EnumC1082th enumC1082thM5718a = ((C1018sX) this.f4666f).m5718a(uuid);
        if (enumC1082thM5718a.displayOnNameplate()) {
            Vec3 eyePosition = entity.getEyePosition(f);
            boolean z2 = false;
            if (enumC1082thM5718a == EnumC1082th.DETECTIVE) {
                z2 = true;
            } else if (enumC1082thM5718a == EnumC1082th.TRAITOR && (enumC1082th == EnumC1082th.TRAITOR || z)) {
                z2 = true;
            } else if (enumC1082thM5718a == EnumC1082th.JESTER && (enumC1082th == EnumC1082th.TRAITOR || z)) {
                z2 = true;
            }
            if (z2 && (texture = enumC1082thM5718a.getTexture()) != null) {
                C0129bt.m607a(poseStack, camera, guiGraphics, texture, eyePosition.x, eyePosition.y + 1.149999976158142d, eyePosition.z, 32, 32);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: bu */
    public boolean mo4157bu() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: bs */
    public boolean mo4155bs() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    @NotNull
    /* JADX INFO: renamed from: b */
    public List<C0134by> mo4166b(@NotNull Minecraft minecraft, @NotNull Set<UUID> set, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        return new ObjectArrayList();
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
        C1020sZ c1020sZB = ((C1018sX) this.f4666f).m4018b();
        String strM3560L = null;
        C0872pk c0872pkA2 = c1020sZB.m4229a(player.getUUID());
        Player entity = renderNameTagEvent.getEntity();
        if ((entity instanceof Player) && (c0872pkA = c1020sZB.m4229a(entity.getUUID())) != null) {
            strM3560L = c0872pkA.getName();
        }
        C0756na entity2 = renderNameTagEvent.getEntity();
        if (entity2 instanceof C0756na) {
            strM3560L = entity2.m3560L();
        }
        if (strM3560L != null && c0872pkA2 != null && strM3560L.equals(c0872pkA2.getName()) && player.distanceTo(renderNameTagEvent.getEntity()) <= 20.0f) {
            renderNameTagEvent.setCanRender(TriState.TRUE);
        } else {
            renderNameTagEvent.setCanRender(TriState.FALSE);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: g */
    public boolean mo4146g(@NotNull Player player) {
        return (player.getVehicle() == null && ((C1018sX) this.f4666f).mo3996a() == EnumC0871pj.GAME) ? false : true;
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0864pc.a mo4147a() {
        return new AbstractC0864pc.a().m4201a("PING", (c0394gj, playerInfo, c0870pi) -> {
            return playerInfo != null ? C1273xM.m7239b(playerInfo.getLatency()) : "???";
        }).m4201a("SCORE", (c0394gj2, playerInfo2, c0870pi2) -> {
            Minecraft minecraft = Minecraft.getInstance();
            if (minecraft.player == null) {
                return "-";
            }
            return C0875pn.m4488a((Player) minecraft.player, (AbstractC0183b<?, ?, ?, ?>) this.f4705b.m1885a(minecraft)) ? C1273xM.m7239b(c0870pi2.m4289a(C1062tN.f5748l.getKey())) : "-";
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public ResourceLocation mo4168a(@NotNull UUID uuid, @NotNull String str, @NotNull Set<UUID> set) {
        return ((C1018sX) this.f4666f).m5718a(uuid) == EnumC1082th.DETECTIVE ? f5596fl : f5595fk;
    }

    /* JADX INFO: renamed from: a */
    private void m5730a(@NotNull Font font, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull GuiGraphics guiGraphics, int i, int i2) {
        Vec3 eyePosition = localPlayer.getEyePosition();
        Vec3 lookAngle = localPlayer.getLookAngle();
        Vec3 vec3Add = eyePosition.add(lookAngle.x * 100.0d, lookAngle.y * 100.0d, lookAngle.z * 100.0d);
        EntityHitResult entityHitResult = ProjectileUtil.getEntityHitResult(clientLevel, localPlayer, eyePosition, vec3Add, new AABB(eyePosition, vec3Add).inflate(1.0d), entity -> {
            if (!(entity instanceof Player)) {
                return false;
            }
            Player player = (Player) entity;
            return !C0875pn.m4488a(player, (C0394gj) this.f4705b.m1150a(player));
        });
        if (entityHitResult != null) {
            Entity entity2 = entityHitResult.getEntity();
            if (entity2 instanceof Player) {
                Player player = (Player) entity2;
                if (localPlayer.hasLineOfSight(player)) {
                    MutableComponent mutableComponentM5731a = m5731a(player);
                    C0129bt.m483c(font, guiGraphics, (Component) Component.literal(player.getScoreboardName()), i, i2 + 15);
                    C0129bt.m483c(font, guiGraphics, (Component) mutableComponentM5731a, i, i2 + 25);
                }
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public MutableComponent m5731a(@NotNull Player player) {
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

    @Override // com.boehmod.blockfront.AbstractC0864pc
    @NotNull
    /* JADX INFO: renamed from: a */
    public Collection<? extends AbstractC0229dd> mo4179a(boolean z) {
        return m4180a((C1018sX) this.f4666f, z);
    }
}
