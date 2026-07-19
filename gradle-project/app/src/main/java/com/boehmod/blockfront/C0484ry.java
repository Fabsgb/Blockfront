package com.boehmod.blockfront;

import com.boehmod.blockfront.oG;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Random;
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
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import net.neoforged.neoforge.common.util.TriState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.ry, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ry.class */
public final class C0484ry extends oG<C0483rx, C0485rz> {
    private static final ResourceLocation eU = C0265jv.d("textures/skins/game/nations/us/recruit/0.png");
    private static final String cu = "reload_tip";
    private boolean gO;

    @Override // com.boehmod.blockfront.oG
    @NotNull
    protected List<Component> u() {
        return List.of();
    }

    public C0484ry(@NotNull C0297l c0297l, @NotNull C0483rx c0483rx, @NotNull fV fVVar) {
        super(c0297l, c0483rx, fVVar);
        this.gO = false;
        c0297l.m602a().b(new C0338mn(c0483rx));
    }

    @Override // com.boehmod.blockfront.oG
    @NotNull
    protected List<AbstractC0063cg<C0483rx, C0485rz>> w() {
        return List.of();
    }

    @Override // com.boehmod.blockfront.oG
    public boolean a(@NotNull AbstractClientPlayer abstractClientPlayer) {
        return false;
    }

    @Override // com.boehmod.blockfront.oG
    public void a(@NotNull Minecraft minecraft, @NotNull Random random, @NotNull RandomSource randomSource, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0297l c0297l, @NotNull fT fTVar, @NotNull Set<UUID> set, float f, @NotNull Vec3 vec3, @NotNull BlockPos blockPos) {
        super.a(minecraft, random, randomSource, localPlayer, clientLevel, c0297l, fTVar, set, f, vec3, blockPos);
        if (!this.gO) {
            this.gO = true;
            minecraft.getSoundManager().play(SimpleSoundInstance.forMusic((SoundEvent) C0624xc.om.get()));
        }
    }

    @Override // com.boehmod.blockfront.oG
    public void b(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull fT fTVar, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.oG
    protected void a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull List<C0407pb> list) {
        super.a(minecraft, localPlayer, list);
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        if (!mainHandItem.isEmpty()) {
            Item item = mainHandItem.getItem();
            if ((item instanceof C0558ur) && C0558ur.a(mainHandItem) < ((C0558ur) item).m1206a(mainHandItem).cb()) {
                a(list, cu, (Component) Component.translatable("bf.item.gun.reload.tip", new Object[]{Component.literal(wM.a.getKey().getDisplayName().getString().toUpperCase(Locale.ROOT)).withStyle(ChatFormatting.GRAY)}));
            }
        }
    }

    @Override // com.boehmod.blockfront.oG
    public void a(@NotNull oI<?> oIVar, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, boolean z, float f, float f2) {
        super.a(oIVar, minecraft, clientLevel, localPlayer, renderLevelStageEvent, bufferSource, poseStack, frustum, font, guiGraphics, camera, z, f, f2);
        ((C0483rx) this.f).ak().forEach(c0416pk -> {
            C0040bk.a(c0416pk, poseStack, guiGraphics, camera, clientLevel, localPlayer, f);
        });
    }

    @Override // com.boehmod.blockfront.oG
    public boolean a(@NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        return true;
    }

    @Override // com.boehmod.blockfront.oG
    public boolean bk() {
        return true;
    }

    @Override // com.boehmod.blockfront.oG
    @NotNull
    public List<C0045bp> b(@NotNull Minecraft minecraft, @NotNull Set<UUID> set, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        UUID profileId = minecraft.getUser().getProfileId();
        for (Player player : clientLevel.entitiesForRendering()) {
            boolean z = false;
            if (player instanceof Player) {
                UUID uuid = player.getUUID();
                z = true;
                if (!set.contains(uuid) || uuid.equals(profileId)) {
                }
            }
            if (z || (player instanceof mC)) {
                objectArrayList.add(new C0045bp(C0045bp.M, player.position()).a(4).a(player.getYRot() - 180.0f));
            }
        }
        for (C0416pk c0416pk : ((C0483rx) this.f).ak()) {
            objectArrayList.add(new C0045bp(C0265jv.d("textures/misc/waypoints/" + c0416pk.bU + ".png"), c0416pk.c).a(4));
        }
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.oG
    public boolean bh() {
        return false;
    }

    @Override // com.boehmod.blockfront.oG
    public void a(@NotNull Minecraft minecraft, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        Player entity = renderNameTagEvent.getEntity();
        if (entity instanceof Player) {
            Player player2 = entity;
            if (player2.distanceTo(player) > 5.0f || !player2.hasLineOfSight(player)) {
                renderNameTagEvent.setCanRender(TriState.FALSE);
            }
        }
    }

    @Override // com.boehmod.blockfront.oG
    public boolean g(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.oG
    @NotNull
    /* JADX INFO: renamed from: a */
    public oG.a mo770a() {
        return new oG.a().a("PING", (fTVar, playerInfo, oMVar) -> {
            return playerInfo != null ? C0637xp.a(playerInfo.getLatency()) : "???";
        }).a("SCORE", (fTVar2, playerInfo2, oMVar2) -> {
            return C0637xp.a(oMVar2.a(C0529tp.l.getKey()));
        });
    }

    @Override // com.boehmod.blockfront.oG
    public ResourceLocation a(@NotNull UUID uuid, @Nullable String str, @NotNull Set<UUID> set) {
        return eU;
    }

    @Override // com.boehmod.blockfront.oG
    @NotNull
    public Collection<? extends cU> a(boolean z) {
        return a((C0483rx) this.f, z);
    }
}
