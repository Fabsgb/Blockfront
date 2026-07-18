package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0788oG;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.rD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rD.class */
public final class C0944rD extends AbstractC0789oH<C0942rB, C0945rE> implements InterfaceC0897qJ {

    /* JADX INFO: renamed from: jb */
    @Nonnull
    private static final Component f5024jb = Component.translatable("bf.message.spawn.axis");

    /* JADX INFO: renamed from: jc */
    @Nonnull
    private static final Component f5025jc = Component.translatable("bf.message.spawn.allies");

    /* JADX INFO: renamed from: eV */
    @Nonnull
    private static final ResourceLocation f5026eV = C0564jv.m2555d("textures/misc/worldpoint/ammo.png");

    /* JADX INFO: renamed from: eW */
    @Nonnull
    private static final ResourceLocation f5027eW = C0564jv.m2555d("textures/gui/game/radio/bg.png");

    /* JADX INFO: renamed from: eX */
    @Nonnull
    private static final ResourceLocation f5028eX = C0564jv.m2555d("textures/gui/compass/waypoint_pp_enemy_shoot.png");

    /* JADX INFO: renamed from: eY */
    @Nonnull
    private static final ResourceLocation f5029eY = C0564jv.m2555d("textures/gui/compass/waypoint_pp_shoot.png");

    /* JADX INFO: renamed from: eZ */
    @Nonnull
    private static final ResourceLocation f5030eZ = C0564jv.m2555d("textures/misc/bfneutralicon.png");

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: u */
    protected List<Component> mo3666u() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(Component.translatable("bf.message.gamemode.domination.tip.0"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.domination.tip.1"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.domination.tip.2"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.domination.tip.3", new Object[]{Component.literal(C1293xp.m7912a(500L)).withStyle(ChatFormatting.WHITE)}));
        objectArrayList.add(Component.translatable("bf.message.gamemode.domination.tip.4", new Object[]{C1219wM.f6925i.getKey().getDisplayName().copy().withStyle(ChatFormatting.WHITE), C1219wM.f6923h.getKey().getDisplayName().copy().withStyle(ChatFormatting.WHITE)}));
        return objectArrayList;
    }

    public C0944rD(@NotNull C0622l c0622l, @NotNull C0942rB c0942rB, @NotNull C0326fV c0326fV) {
        super(c0622l, c0942rB, c0326fV);
        c0622l.m2709a().m3222b(new C0719mr(c0942rB));
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: w */
    protected List<AbstractC0168cg<C0942rB, C0945rE>> mo3670w() {
        return List.of(new C0163cb(), new C0165cd(C0942rB.f5014pJ, 64, C1089tp.f5729cZ, false), new C0102bT(), new C0165cd(C0942rB.f5014pJ, 64, C1089tp.f5730da, true), new C0167cf());
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public boolean mo3676a(@NotNull AbstractClientPlayer abstractClientPlayer) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0789oH, com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public void mo3682a(@NotNull Minecraft minecraft, @NotNull Random random, @NotNull RandomSource randomSource, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0622l c0622l, @NotNull C0324fT c0324fT, @NotNull Set<UUID> set, float f, @NotNull Vec3 vec3, @NotNull BlockPos blockPos) {
        super.mo3682a(minecraft, random, randomSource, localPlayer, clientLevel, c0622l, c0324fT, set, f, vec3, blockPos);
        this.f4325b = ((C0942rB) this.f4272f).m5156a((Player) localPlayer, set);
        Iterator<C0943rC> it = ((C0942rB) this.f4272f).mo4668O().iterator();
        while (it.hasNext()) {
            it.next().m4108a(localPlayer, clientLevel, (AbstractC0787oF<?, ?, ?>) this.f4272f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public void mo3715a(@NotNull AbstractC0790oI<?> abstractC0790oI, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, boolean z, float f, float f2) {
        super.mo3715a(abstractC0790oI, minecraft, clientLevel, localPlayer, renderLevelStageEvent, bufferSource, poseStack, frustum, font, guiGraphics, camera, z, f, f2);
        Iterator<C0943rC> it = ((C0942rB) this.f4272f).mo4668O().iterator();
        while (it.hasNext()) {
            it.next().m4109a(frustum, guiGraphics, font, camera, f);
        }
        boolean zShouldRenderHitBoxes = minecraft.getEntityRenderDispatcher().shouldRenderHitBoxes();
        if (C0424hN.f2730k.m1996T()) {
            for (C0124bp c0124bp : m3681d()) {
                AABB aabbM620d = c0124bp.m620d();
                if (zShouldRenderHitBoxes) {
                    LevelRenderer.renderLineBox(poseStack, bufferSource.getBuffer(RenderType.lines()), aabbM620d, 1.0f, 1.0f, 1.0f, 1.0f);
                }
                if (c0124bp.m632p() && frustum.isVisible(aabbM620d)) {
                    Vec3 vec3M633c = c0124bp.m633c();
                    float fZ = m3728z((float) localPlayer.position().distanceTo(vec3M633c));
                    if (fZ > 0.0f) {
                        C0119bk.m510a(poseStack, camera, guiGraphics, c0124bp.getTexture(), vec3M633c.x, vec3M633c.y, vec3M633c.z, 20, 20, 0.5f * fZ, false);
                    }
                }
            }
        }
        if (zShouldRenderHitBoxes) {
            Iterator<C0943rC> it2 = ((C0942rB) this.f4272f).mo4668O().iterator();
            while (it2.hasNext()) {
                LevelRenderer.renderLineBox(poseStack, bufferSource.getBuffer(RenderType.lines()), it2.next().m4097d(), 1.0f, 1.0f, 1.0f, 1.0f);
            }
        }
        if (minecraft.getDebugOverlay().showDebugScreen() && localPlayer.isCreative()) {
            Vec3 vec3 = null;
            Iterator<C0943rC> it3 = ((C0942rB) this.f4272f).mo4668O().iterator();
            while (it3.hasNext()) {
                Vec3 vec32 = it3.next().f4424c;
                if (vec3 != null) {
                    C0119bk.m474a(camera, poseStack, vec32, vec3, 1.0f, 16711680);
                }
                vec3 = vec32;
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public boolean mo3718a(@NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        C0796oO c0796oOA;
        C0945rE c0945rEB = ((C0942rB) this.f4272f).m3582b();
        C0796oO c0796oOA2 = c0945rEB.m3793a(player.getUUID());
        String strM3053E = null;
        if ((livingEntity instanceof Player) && (c0796oOA = c0945rEB.m3793a(((Player) livingEntity).getUUID())) != null) {
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
        C0945rE c0945rEB = ((C0942rB) this.f4272f).m3582b();
        C0796oO c0796oOA = c0945rEB.m3793a(localPlayer.getUUID());
        if (c0796oOA == null) {
            return new ObjectArrayList();
        }
        C0796oO c0796oOA2 = c0945rEB.m3806a(C1089tp.f5730da);
        C0796oO c0796oOA3 = c0945rEB.m3806a(C1089tp.f5729cZ);
        if (c0796oOA2 == null || c0796oOA3 == null) {
            return new ObjectArrayList();
        }
        ObjectArrayList objectArrayList = new ObjectArrayList();
        ObjectArrayList objectArrayList2 = new ObjectArrayList();
        for (C0805oX c0805oX : c0796oOA3.m3873B()) {
            objectArrayList2.add(new Vec2((int) c0805oX.f4424c.x, (int) c0805oX.f4424c.z));
        }
        ObjectArrayList objectArrayList3 = new ObjectArrayList();
        for (C0805oX c0805oX2 : c0796oOA2.m3873B()) {
            objectArrayList3.add(new Vec2((int) c0805oX2.f4424c.x, (int) c0805oX2.f4424c.z));
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
        objectArrayList.add(new C0124bp(C0078aw.f469o, new Vec2(fMax, f2 / Math.max(size, 1))).m625a(9).m624a(f5025jc));
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
        objectArrayList.add(new C0124bp(C0078aw.f470p, new Vec2(fMax2, f4 / Math.max(size2, 1))).m625a(9).m624a(f5024jb));
        for (C0868ph c0868ph : m3707x()) {
            Vec3 vec3M4361c = c0868ph.m4361c();
            objectArrayList.add(new C0124bp(f5027eW, vec3M4361c).m625a(28));
            objectArrayList.add(new C0124bp(c0868ph.getIcon(), vec3M4361c).m625a(14));
        }
        for (C0943rC c0943rC : ((C0942rB) this.f4272f).mo4668O()) {
            int color = c0943rC.getColor();
            ResourceLocation icon = c0943rC.getIcon();
            if (icon != null) {
                objectArrayList.add(new C0124bp(icon, c0943rC.f4424c).m621a(f5030eZ, color).m625a(6).m624a(Component.literal(c0943rC.f4399bP)).m630b(m3770A((float) c0943rC.f4424c.distanceTo(localPlayer.position()))));
            }
        }
        for (C0804oW c0804oW : ((C0942rB) this.f4272f).m5158ao()) {
            objectArrayList.add(new C0124bp(f5026eV, c0804oW.f4424c.add(0.0d, 0.5d, 0.0d)).m625a(4).m622a().m630b(m3728z((float) c0804oW.f4424c.distanceTo(localPlayer.position()))));
        }
        for (C0680mE c0680mE : clientLevel.entitiesForRendering()) {
            UUID uuid = c0680mE.getUUID();
            if ((set.contains(uuid) && !uuid.equals(minecraft.getUser().getProfileId())) || (c0680mE instanceof C0680mE)) {
                boolean z = true;
                boolean zContains = c0796oOA.m3872h().contains(uuid);
                if (c0680mE instanceof C0680mE) {
                    zContains = c0680mE.m3053E().equalsIgnoreCase(c0796oOA.getName());
                }
                ResourceLocation resourceLocation = zContains ? C0124bp.f865M : C0124bp.f866N;
                if (!zContains && (c0680mE instanceof Player)) {
                    if (((C0324fT) this.f4311b.m1133a((Player) c0680mE)).m1646af() <= 0) {
                        z = false;
                    }
                }
                if (c0680mE instanceof C0680mE) {
                    C0680mE c0680mE2 = c0680mE;
                    if (!c0796oOA.getName().equalsIgnoreCase(c0680mE2.m3053E())) {
                        if (c0680mE2.m3057aw() > 0) {
                            resourceLocation = f5028eX;
                        } else if (!localPlayer.hasLineOfSight(c0680mE2)) {
                            z = false;
                        }
                    } else if (c0680mE2.m3057aw() > 0) {
                        resourceLocation = f5029eY;
                    }
                }
                if (z) {
                    objectArrayList.add(new C0124bp(resourceLocation, c0680mE.position()).m625a(4).m623a(c0680mE.getYRot() - 180.0f));
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
        C0945rE c0945rEB = ((C0942rB) this.f4272f).m3582b();
        String strM3053E = null;
        C0796oO c0796oOA2 = c0945rEB.m3793a(player.getUUID());
        Player entity = renderNameTagEvent.getEntity();
        if ((entity instanceof Player) && (c0796oOA = c0945rEB.m3793a(entity.getUUID())) != null) {
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
        return (player.getVehicle() == null && ((C0942rB) this.f4272f).mo3560a() == EnumC0795oN.GAME) ? false : true;
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
        }).m3765a("OBJ", (c0324fT4, playerInfo4, c0794oM4) -> {
            return C1293xp.m7912a(c0794oM4.m3853a(C1089tp.f5700q.getKey()));
        }).m3765a("SCORE", (c0324fT5, playerInfo5, c0794oM5) -> {
            return C1293xp.m7912a(c0794oM5.m3853a(C1089tp.f5695l.getKey()));
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: a */
    public Collection<? extends AbstractC0156cU> mo3743a(boolean z) {
        return m3744a((C0942rB) this.f4272f, z);
    }

    @Override // com.boehmod.blockfront.InterfaceC0897qJ
    /* JADX INFO: renamed from: e */
    public void mo4648e(@NotNull Minecraft minecraft, @NotNull C0622l c0622l) {
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null) {
            return;
        }
        HitResult hitResultM5896a = C1060tM.m5896a(localPlayer, 64.0d, 0.0f);
        if (hitResultM5896a.getType() == HitResult.Type.MISS) {
            return;
        }
        Vec3 location = hitResultM5896a.getLocation();
        UUID uuid = localPlayer.getUUID();
        AbstractC1012sS abstractC1012sSA = m3749a(location, 2.0d);
        if (abstractC1012sSA != null && abstractC1012sSA.m5481h().equals(uuid)) {
            C1194vo.m6653c(new C1168vO(abstractC1012sSA.m5482i(), location));
        } else {
            C1194vo.m6653c(new C1166vM(location));
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0897qJ
    /* JADX INFO: renamed from: a */
    public boolean mo4649a(@NotNull AbstractC1012sS abstractC1012sS, @NotNull UUID uuid, @NotNull Vec3 vec3) {
        return ((float) abstractC1012sS.m5484c().distanceTo(vec3)) <= 2.0f && abstractC1012sS.m5481h().equals(uuid);
    }
}
