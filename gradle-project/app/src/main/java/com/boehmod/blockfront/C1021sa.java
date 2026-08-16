package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import javax.annotation.Nonnull;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import net.neoforged.neoforge.common.util.TriState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sa */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sa.class */
public final class C1021sa extends AbstractC0865pd<C0966rY, C1022sb> implements InterfaceC0974rg {

    /* JADX INFO: renamed from: jo */
    @Nonnull
    private static final Component f5600jo = Component.translatable("bf.message.spawn.axis");

    /* JADX INFO: renamed from: jp */
    @Nonnull
    private static final Component f5601jp = Component.translatable("bf.message.spawn.allies");

    /* JADX INFO: renamed from: eU */
    @Nonnull
    private static final ResourceLocation f5602eU = C0532jO.m2378d("textures/misc/worldpoint/ammo.png");

    /* JADX INFO: renamed from: eV */
    @Nonnull
    private static final ResourceLocation f5603eV = C0532jO.m2378d("textures/gui/game/radio/bg.png");

    /* JADX INFO: renamed from: eW */
    @Nonnull
    private static final ResourceLocation f5604eW = C0532jO.m2378d("textures/gui/compass/waypoint_pp_enemy_shoot.png");

    /* JADX INFO: renamed from: eX */
    @Nonnull
    private static final ResourceLocation f5605eX = C0532jO.m2378d("textures/gui/compass/waypoint_pp_shoot.png");

    /* JADX INFO: renamed from: eY */
    @Nonnull
    private static final ResourceLocation f5606eY = C0532jO.m2378d("textures/misc/bfneutralicon.png");

    @Override // com.boehmod.blockfront.AbstractC0864pc
    @NotNull
    /* JADX INFO: renamed from: w */
    protected List<Component> mo4102w() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(Component.translatable("bf.message.gamemode.domination.tip.0"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.domination.tip.1"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.domination.tip.2"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.domination.tip.3", new Object[]{Component.literal(C1273xM.m7239b(500L)).withStyle(ChatFormatting.WHITE)}));
        objectArrayList.add(Component.translatable("bf.message.gamemode.domination.tip.4", new Object[]{C1296xj.f7488i.getKey().getDisplayName().copy().withStyle(ChatFormatting.WHITE), C1296xj.f7486h.getKey().getDisplayName().copy().withStyle(ChatFormatting.WHITE)}));
        return objectArrayList;
    }

    public C1021sa(@NotNull C0623l c0623l, @NotNull C0966rY c0966rY, @NotNull C0396gl c0396gl) {
        super(c0623l, c0966rY, c0396gl);
        c0623l.m2895a().m3053b(new C0690mN(c0966rY));
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    @NotNull
    /* JADX INFO: renamed from: y */
    protected List<AbstractC0188cp<C0966rY, C1022sb>> mo4106y() {
        return List.of(new C0173ck(), new C0179cm(C0966rY.f5366rI, 64, C1062tN.f5782dk, false), new C0165cc(), new C0179cm(C0966rY.f5366rI, 64, C1062tN.f5783dl, true), new C0181co());
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public boolean mo4112a(@NotNull AbstractClientPlayer abstractClientPlayer) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0865pd, com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public void mo4118a(@NotNull Minecraft minecraft, @NotNull Random random, @NotNull RandomSource randomSource, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0623l c0623l, @NotNull C0394gj c0394gj, @NotNull Set<UUID> set, float f, @NotNull Vec3 vec3, @NotNull BlockPos blockPos) {
        super.mo4118a(minecraft, random, randomSource, localPlayer, clientLevel, c0623l, c0394gj, set, f, vec3, blockPos);
        this.f4720b = ((C0966rY) this.f4666f).m5327a((Player) localPlayer, set);
        Iterator<C0967rZ> it = ((C0966rY) this.f4666f).mo5353Q().iterator();
        while (it.hasNext()) {
            it.next().m4545a(localPlayer, clientLevel, (AbstractC0863pb<?, ?, ?>) this.f4666f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public void mo4151a(@NotNull AbstractC0866pe<?> abstractC0866pe, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, boolean z, float f, float f2) {
        super.mo4151a(abstractC0866pe, minecraft, clientLevel, localPlayer, renderLevelStageEvent, bufferSource, poseStack, frustum, font, guiGraphics, camera, z, f, f2);
        Iterator<C0967rZ> it = ((C0966rY) this.f4666f).mo5353Q().iterator();
        while (it.hasNext()) {
            it.next().m4546a(frustum, guiGraphics, camera, f);
        }
        Iterator<C0967rZ> it2 = ((C0966rY) this.f4666f).mo5353Q().iterator();
        while (it2.hasNext()) {
            it2.next().m4547a(frustum, poseStack, font, camera, bufferSource);
        }
        Iterator<C0967rZ> it3 = ((C0966rY) this.f4666f).mo5353Q().iterator();
        while (it3.hasNext()) {
            it3.next().m4548b(frustum, poseStack, font, camera, bufferSource);
        }
        boolean zShouldRenderHitBoxes = minecraft.getEntityRenderDispatcher().shouldRenderHitBoxes();
        if (C0495ie.f3031k.m2230U()) {
            for (C0134by c0134by : m4117d()) {
                AABB aabbM725d = c0134by.m725d();
                if (zShouldRenderHitBoxes) {
                    LevelRenderer.renderLineBox(poseStack, bufferSource.getBuffer(RenderType.lines()), aabbM725d, 1.0f, 1.0f, 1.0f, 1.0f);
                }
                if (c0134by.m737q() && frustum.isVisible(aabbM725d)) {
                    Vec3 vec3M738c = c0134by.m738c();
                    float fC = m4164C((float) localPlayer.position().distanceTo(vec3M738c));
                    if (fC > 0.0f) {
                        C0129bt.m610a(poseStack, camera, guiGraphics, c0134by.getTexture(), vec3M738c.x, vec3M738c.y, vec3M738c.z, 20, 20, 0.5f * fC, false);
                    }
                }
            }
        }
        if (zShouldRenderHitBoxes) {
            Iterator<C0967rZ> it4 = ((C0966rY) this.f4666f).mo5353Q().iterator();
            while (it4.hasNext()) {
                LevelRenderer.renderLineBox(poseStack, bufferSource.getBuffer(RenderType.lines()), it4.next().m4533d(), 1.0f, 1.0f, 1.0f, 1.0f);
            }
        }
        if (minecraft.getDebugOverlay().showDebugScreen() && localPlayer.isCreative()) {
            Vec3 vec3 = null;
            Iterator<C0967rZ> it5 = ((C0966rY) this.f4666f).mo5353Q().iterator();
            while (it5.hasNext()) {
                Vec3 vec4 = it5.next().f4827c;
                if (vec3 != null) {
                    C0129bt.m574a(camera, poseStack, vec4, vec3, 1.0f, 16711680);
                }
                vec3 = vec4;
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public boolean mo4154a(@NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        C0872pk c0872pkA;
        C1022sb c1022sbB = ((C0966rY) this.f4666f).m4018b();
        C0872pk c0872pkA2 = c1022sbB.m4229a(player.getUUID());
        String strM3560L = null;
        if ((livingEntity instanceof Player) && (c0872pkA = c1022sbB.m4229a(((Player) livingEntity).getUUID())) != null) {
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
        C1022sb c1022sbB = ((C0966rY) this.f4666f).m4018b();
        C0872pk c0872pkA = c1022sbB.m4229a(localPlayer.getUUID());
        if (c0872pkA == null) {
            return new ObjectArrayList();
        }
        C0872pk c0872pkA2 = c1022sbB.m4242a(C1062tN.f5783dl);
        C0872pk c0872pkA3 = c1022sbB.m4242a(C1062tN.f5782dk);
        if (c0872pkA2 == null || c0872pkA3 == null) {
            return new ObjectArrayList();
        }
        ObjectArrayList objectArrayList = new ObjectArrayList();
        ObjectArrayList objectArrayList2 = new ObjectArrayList();
        for (C0881pt c0881pt : c0872pkA3.m4309D()) {
            objectArrayList2.add(new Vec2((int) c0881pt.f4827c.x, (int) c0881pt.f4827c.z));
        }
        ObjectArrayList objectArrayList3 = new ObjectArrayList();
        for (C0881pt c0881pt2 : c0872pkA2.m4309D()) {
            objectArrayList3.add(new Vec2((int) c0881pt2.f4827c.x, (int) c0881pt2.f4827c.z));
        }
        int size = objectArrayList2.size();
        int size2 = objectArrayList3.size();
        float f = 0.0f;
        Iterator it = objectArrayList2.iterator();
        while (it.hasNext()) {
            f += ((Vec2) it.next()).x;
        }
        float fMax = f / Math.max(size, 1);
        float f2 = 0.0f;
        Iterator it2 = objectArrayList2.iterator();
        while (it2.hasNext()) {
            f2 += ((Vec2) it2.next()).y;
        }
        objectArrayList.add(new C0134by(C0034aD.f291o, new Vec2(fMax, f2 / Math.max(size, 1))).m730a(9).m729a(f5601jp));
        float f3 = 0.0f;
        Iterator it3 = objectArrayList3.iterator();
        while (it3.hasNext()) {
            f3 += ((Vec2) it3.next()).x;
        }
        float fMax2 = f3 / Math.max(size2, 1);
        float f4 = 0.0f;
        Iterator it4 = objectArrayList3.iterator();
        while (it4.hasNext()) {
            f4 += ((Vec2) it4.next()).y;
        }
        objectArrayList.add(new C0134by(C0034aD.f292p, new Vec2(fMax2, f4 / Math.max(size2, 1))).m730a(9).m729a(f5600jo));
        for (C0839pD c0839pD : m4143z()) {
            Vec3 vec3M3846c = c0839pD.m3846c();
            objectArrayList.add(new C0134by(f5603eV, vec3M3846c).m730a(28));
            objectArrayList.add(new C0134by(c0839pD.getIcon(), vec3M3846c).m730a(14));
        }
        for (C0967rZ c0967rZ : ((C0966rY) this.f4666f).mo5353Q()) {
            int color = c0967rZ.getColor();
            ResourceLocation icon = c0967rZ.getIcon();
            if (icon != null) {
                objectArrayList.add(new C0134by(icon, c0967rZ.f4827c).m726a(f5606eY, color).m730a(6).m729a(Component.literal(c0967rZ.f4796bZ)).m735b(m4206D((float) c0967rZ.f4827c.distanceTo(localPlayer.position()))));
            }
        }
        for (C0880ps c0880ps : ((C0966rY) this.f4666f).m5329aq()) {
            objectArrayList.add(new C0134by(f5602eU, c0880ps.f4827c.add(0.0d, 0.5d, 0.0d)).m730a(4).m727a().m735b(m4164C((float) c0880ps.f4827c.distanceTo(localPlayer.position()))));
        }
        for (C0756na c0756na : clientLevel.entitiesForRendering()) {
            UUID uuid = c0756na.getUUID();
            if ((set.contains(uuid) && !uuid.equals(minecraft.getUser().getProfileId())) || (c0756na instanceof C0756na)) {
                boolean z = true;
                boolean zContains = c0872pkA.m4308h().contains(uuid);
                if (c0756na instanceof C0756na) {
                    zContains = c0756na.m3560L().equalsIgnoreCase(c0872pkA.getName());
                }
                ResourceLocation resourceLocation = zContains ? C0134by.f1000M : C0134by.f1001N;
                if (!zContains && (c0756na instanceof Player)) {
                    if (((C0394gj) this.f4705b.m1150a((Player) c0756na)).m1856ar() <= 0) {
                        z = false;
                    }
                }
                if (c0756na instanceof C0756na) {
                    C0756na c0756na2 = c0756na;
                    if (!c0872pkA.getName().equalsIgnoreCase(c0756na2.m3560L())) {
                        if (c0756na2.m3564aL() > 0) {
                            resourceLocation = f5604eW;
                        } else if (!localPlayer.hasLineOfSight(c0756na2)) {
                            z = false;
                        }
                    } else if (c0756na2.m3564aL() > 0) {
                        resourceLocation = f5605eX;
                    }
                }
                if (z) {
                    objectArrayList.add(new C0134by(resourceLocation, c0756na.position()).m730a(4).m728a(c0756na.getYRot() - 180.0f));
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
        C1022sb c1022sbB = ((C0966rY) this.f4666f).m4018b();
        String strM3560L = null;
        C0872pk c0872pkA2 = c1022sbB.m4229a(player.getUUID());
        Player entity = renderNameTagEvent.getEntity();
        if ((entity instanceof Player) && (c0872pkA = c1022sbB.m4229a(entity.getUUID())) != null) {
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
        return (player.getVehicle() == null && ((C0966rY) this.f4666f).mo3996a() == EnumC0871pj.GAME) ? false : true;
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
        }).m4201a("OBJ", (c0394gj4, playerInfo4, c0870pi4) -> {
            return C1273xM.m7239b(c0870pi4.m4289a(C1062tN.f5753q.getKey()));
        }).m4201a("SCORE", (c0394gj5, playerInfo5, c0870pi5) -> {
            return C1273xM.m7239b(c0870pi5.m4289a(C1062tN.f5748l.getKey()));
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    @NotNull
    /* JADX INFO: renamed from: a */
    public Collection<? extends AbstractC0229dd> mo4179a(boolean z) {
        return m4180a((C0966rY) this.f4666f, z);
    }

    @Override // com.boehmod.blockfront.InterfaceC0974rg
    /* JADX INFO: renamed from: e */
    public void mo5543e(@NotNull Minecraft minecraft, @NotNull C0623l c0623l) {
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null) {
            return;
        }
        HitResult hitResultM6531a = C1138uk.m6531a(localPlayer, 64.0d, 0.0f);
        if (hitResultM6531a.getType() == HitResult.Type.MISS) {
            return;
        }
        Vec3 location = hitResultM6531a.getLocation();
        UUID uuid = localPlayer.getUUID();
        AbstractC1090tp abstractC1090tpA = m4185a(location, 2.0d);
        if (abstractC1090tpA != null && abstractC1090tpA.m5969h().equals(uuid)) {
            C1169vO.m6648c(new C1247wn(abstractC1090tpA.m5970i(), location));
        } else {
            C1169vO.m6648c(new C1245wl(location));
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0974rg
    /* JADX INFO: renamed from: a */
    public boolean mo5544a(@NotNull AbstractC1090tp abstractC1090tp, @NotNull UUID uuid, @NotNull Vec3 vec3) {
        return ((float) abstractC1090tp.m5972c().distanceTo(vec3)) <= 2.0f && abstractC1090tp.m5969h().equals(uuid);
    }
}
