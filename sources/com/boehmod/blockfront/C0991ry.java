package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0788oG;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.ry */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ry.class */
public final class C0991ry extends AbstractC0788oG<C0990rx, C0992rz> {

    /* JADX INFO: renamed from: eU */
    private static final ResourceLocation f5251eU = C0564jv.m2555d("textures/skins/game/nations/us/recruit/0.png");

    /* JADX INFO: renamed from: cu */
    private static final String f5252cu = "reload_tip";

    /* JADX INFO: renamed from: gO */
    private boolean f5253gO;

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: u */
    protected List<Component> mo3666u() {
        return List.of();
    }

    public C0991ry(@NotNull C0622l c0622l, @NotNull C0990rx c0990rx, @NotNull C0326fV c0326fV) {
        super(c0622l, c0990rx, c0326fV);
        this.f5253gO = false;
        c0622l.m2709a().m3222b(new C0715mn(c0990rx));
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: w */
    protected List<AbstractC0168cg<C0990rx, C0992rz>> mo3670w() {
        return List.of();
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public boolean mo3676a(@NotNull AbstractClientPlayer abstractClientPlayer) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public void mo3682a(@NotNull Minecraft minecraft, @NotNull Random random, @NotNull RandomSource randomSource, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0622l c0622l, @NotNull C0324fT c0324fT, @NotNull Set<UUID> set, float f, @NotNull Vec3 vec3, @NotNull BlockPos blockPos) {
        super.mo3682a(minecraft, random, randomSource, localPlayer, clientLevel, c0622l, c0324fT, set, f, vec3, blockPos);
        if (!this.f5253gO) {
            this.f5253gO = true;
            minecraft.getSoundManager().play(SimpleSoundInstance.forMusic((SoundEvent) C1280xc.f7503om.get()));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: b */
    public void mo3704b(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0324fT c0324fT, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    protected void mo3671a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull List<C0862pb> list) {
        super.mo3671a(minecraft, localPlayer, list);
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        if (!mainHandItem.isEmpty()) {
            Item item = mainHandItem.getItem();
            if ((item instanceof C1144ur) && C1144ur.m6301a(mainHandItem) < ((C1144ur) item).m6318a(mainHandItem).m6424cb()) {
                m3672a(list, f5252cu, (Component) Component.translatable("bf.item.gun.reload.tip", new Object[]{Component.literal(C1219wM.f6916a.getKey().getDisplayName().getString().toUpperCase(Locale.ROOT)).withStyle(ChatFormatting.GRAY)}));
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public void mo3715a(@NotNull AbstractC0790oI<?> abstractC0790oI, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, boolean z, float f, float f2) {
        super.mo3715a(abstractC0790oI, minecraft, clientLevel, localPlayer, renderLevelStageEvent, bufferSource, poseStack, frustum, font, guiGraphics, camera, z, f, f2);
        ((C0990rx) this.f4272f).m5425ak().forEach(c0871pk -> {
            C0119bk.m540a(c0871pk, poseStack, guiGraphics, camera, clientLevel, localPlayer, f);
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public boolean mo3718a(@NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        return true;
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
        UUID profileId = minecraft.getUser().getProfileId();
        for (Player player : clientLevel.entitiesForRendering()) {
            boolean z = false;
            if (player instanceof Player) {
                UUID uuid = player.getUUID();
                z = true;
                if (!set.contains(uuid) || uuid.equals(profileId)) {
                }
            }
            if (z || (player instanceof C0678mC)) {
                objectArrayList.add(new C0124bp(C0124bp.f865M, player.position()).m625a(4).m623a(player.getYRot() - 180.0f));
            }
        }
        for (C0871pk c0871pk : ((C0990rx) this.f4272f).m5425ak()) {
            objectArrayList.add(new C0124bp(C0564jv.m2555d("textures/misc/waypoints/" + c0871pk.f4575bU + ".png"), c0871pk.f4424c).m625a(4));
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
        Player entity = renderNameTagEvent.getEntity();
        if (entity instanceof Player) {
            Player player2 = entity;
            if (player2.distanceTo(player) > 5.0f || !player2.hasLineOfSight(player)) {
                renderNameTagEvent.setCanRender(TriState.FALSE);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: g */
    public boolean mo3710g(@NotNull Player player) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0788oG.a mo3711a() {
        return new AbstractC0788oG.a().m3765a("PING", (c0324fT, playerInfo, c0794oM) -> {
            return playerInfo != null ? C1293xp.m7912a(playerInfo.getLatency()) : "???";
        }).m3765a("SCORE", (c0324fT2, playerInfo2, c0794oM2) -> {
            return C1293xp.m7912a(c0794oM2.m3853a(C1089tp.f5695l.getKey()));
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public ResourceLocation mo3732a(@NotNull UUID uuid, @Nullable String str, @NotNull Set<UUID> set) {
        return f5251eU;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: a */
    public Collection<? extends AbstractC0156cU> mo3743a(boolean z) {
        return m3744a((C0990rx) this.f4272f, z);
    }
}
