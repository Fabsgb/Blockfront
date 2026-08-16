package com.boehmod.blockfront;

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

/* JADX INFO: renamed from: com.boehmod.blockfront.rV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rV.class */
public final class C0963rV extends AbstractC0864pc<C0962rU, C0964rW> {

    /* JADX INFO: renamed from: eT */
    private static final ResourceLocation f5355eT = C0532jO.m2378d("textures/skins/game/nations/us/recruit/0.png");

    /* JADX INFO: renamed from: cE */
    private static final String f5356cE = "reload_tip";

    /* JADX INFO: renamed from: hi */
    private boolean f5357hi;

    @Override // com.boehmod.blockfront.AbstractC0864pc
    @NotNull
    /* JADX INFO: renamed from: w */
    protected List<Component> mo4102w() {
        return List.of();
    }

    public C0963rV(@NotNull C0623l c0623l, @NotNull C0962rU c0962rU, @NotNull C0396gl c0396gl) {
        super(c0623l, c0962rU, c0396gl);
        this.f5357hi = false;
        c0623l.m2895a().m3053b(new C0686mJ(c0962rU));
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    @NotNull
    /* JADX INFO: renamed from: y */
    protected List<AbstractC0188cp<C0962rU, C0964rW>> mo4106y() {
        return List.of();
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public boolean mo4112a(@NotNull AbstractClientPlayer abstractClientPlayer) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public void mo4118a(@NotNull Minecraft minecraft, @NotNull Random random, @NotNull RandomSource randomSource, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0623l c0623l, @NotNull C0394gj c0394gj, @NotNull Set<UUID> set, float f, @NotNull Vec3 vec3, @NotNull BlockPos blockPos) {
        super.mo4118a(minecraft, random, randomSource, localPlayer, clientLevel, c0623l, c0394gj, set, f, vec3, blockPos);
        if (!this.f5357hi) {
            this.f5357hi = true;
            minecraft.getSoundManager().play(SimpleSoundInstance.forMusic((SoundEvent) C1312xz.f7915oo.get()));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: b */
    public void mo4140b(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0394gj c0394gj, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    protected void mo4107a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull List<C0885px> list) {
        super.mo4107a(minecraft, localPlayer, list);
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        if (!mainHandItem.isEmpty()) {
            Item item = mainHandItem.getItem();
            if ((item instanceof C1117uP) && C1117uP.m6265c(mainHandItem) < ((C1117uP) item).m6283a(mainHandItem).m6402cq()) {
                m4108a(list, f5356cE, (Component) Component.translatable("bf.item.gun.reload.tip", new Object[]{Component.literal(C1296xj.f7479a.getKey().getDisplayName().getString().toUpperCase(Locale.ROOT)).withStyle(ChatFormatting.GRAY)}));
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public void mo4151a(@NotNull AbstractC0866pe<?> abstractC0866pe, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, boolean z, float f, float f2) {
        super.mo4151a(abstractC0866pe, minecraft, clientLevel, localPlayer, renderLevelStageEvent, bufferSource, poseStack, frustum, font, guiGraphics, camera, z, f, f2);
        ((C0962rU) this.f4666f).m5304am().forEach(c0842pG -> {
            C0129bt.m643a(c0842pG, poseStack, guiGraphics, camera, clientLevel, localPlayer, f);
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public boolean mo4154a(@NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        return true;
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
        UUID profileId = minecraft.getUser().getProfileId();
        for (Player player : clientLevel.entitiesForRendering()) {
            boolean z = false;
            if (player instanceof Player) {
                UUID uuid = player.getUUID();
                z = true;
                if (!set.contains(uuid) || uuid.equals(profileId)) {
                }
            }
            if (z || (player instanceof C0701mY)) {
                objectArrayList.add(new C0134by(C0134by.f1000M, player.position()).m730a(4).m728a(player.getYRot() - 180.0f));
            }
        }
        for (C0842pG c0842pG : ((C0962rU) this.f4666f).m5304am()) {
            objectArrayList.add(new C0134by(C0532jO.m2378d("textures/misc/waypoints/" + c0842pG.f4544ce + ".png"), c0842pG.f4827c).m730a(4));
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
        Player entity = renderNameTagEvent.getEntity();
        if (entity instanceof Player) {
            Player player2 = entity;
            if (player2.distanceTo(player) > 5.0f || !player2.hasLineOfSight(player)) {
                renderNameTagEvent.setCanRender(TriState.FALSE);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: g */
    public boolean mo4146g(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0864pc.a mo4147a() {
        return new AbstractC0864pc.a().m4201a("PING", (c0394gj, playerInfo, c0870pi) -> {
            return playerInfo != null ? C1273xM.m7239b(playerInfo.getLatency()) : "???";
        }).m4201a("SCORE", (c0394gj2, playerInfo2, c0870pi2) -> {
            return C1273xM.m7239b(c0870pi2.m4289a(C1062tN.f5748l.getKey()));
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public ResourceLocation mo4168a(@NotNull UUID uuid, @Nullable String str, @NotNull Set<UUID> set) {
        return f5355eT;
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    @NotNull
    /* JADX INFO: renamed from: a */
    public Collection<? extends AbstractC0229dd> mo4179a(boolean z) {
        return m4180a((C0962rU) this.f4666f, z);
    }
}
