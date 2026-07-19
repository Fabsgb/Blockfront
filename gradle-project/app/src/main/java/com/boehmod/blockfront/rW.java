package com.boehmod.blockfront;

import com.boehmod.blockfront.oG;
import com.mojang.blaze3d.vertex.PoseStack;
import foundry.veil.impl.client.render.shader.injection.util.ShaderInjectionDefinition;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import javax.annotation.Nullable;
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
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import net.neoforged.neoforge.common.util.TriState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rW.class */
public final class rW extends oG<rV, rX> {
    private static final ResourceLocation fe = C0265jv.d("textures/gui/compass/waypoint_store.png");
    private static final ResourceLocation ff = C0265jv.d("textures/misc/debug/infected_spawn.png");
    private static final ResourceLocation fg = C0265jv.d("textures/misc/debug/infected_door.png");
    private static final ResourceLocation fh = C0265jv.d("textures/misc/debug/infected_store.png");

    @NotNull
    private static final Component js = Component.translatable("bf.message.gamemode.infected.dead.countdown").withStyle(ChatFormatting.GRAY);

    @NotNull
    private final Object2IntMap<UUID> g;

    @Override // com.boehmod.blockfront.oG
    @NotNull
    protected List<Component> u() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(Component.translatable("bf.message.gamemode.infected.tip.0", new Object[]{Component.literal(String.valueOf(30))}));
        objectArrayList.add(Component.translatable("bf.message.gamemode.infected.tip.1"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.infected.tip.2"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.infected.tip.3"));
        return objectArrayList;
    }

    public rW(@NotNull C0297l c0297l, @NotNull rV rVVar, @NotNull fV fVVar) {
        super(c0297l, rVVar, fVVar);
        this.g = new Object2IntOpenHashMap();
        c0297l.m602a().b(new C0342mr(rVVar));
    }

    @Override // com.boehmod.blockfront.oG
    @NotNull
    protected List<AbstractC0063cg<rV, rX>> w() {
        return List.of(new C0058cb(), new bX(), new bY(), new bW(), new C0062cf());
    }

    @Override // com.boehmod.blockfront.oG
    public boolean a(@NotNull AbstractClientPlayer abstractClientPlayer) {
        return false;
    }

    @Override // com.boehmod.blockfront.oG
    public void a(@NotNull Minecraft minecraft, @NotNull Random random, @NotNull RandomSource randomSource, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0297l c0297l, @NotNull fT fTVar, @NotNull Set<UUID> set, float f, @NotNull Vec3 vec3, @NotNull BlockPos blockPos) {
        super.a(minecraft, random, randomSource, localPlayer, clientLevel, c0297l, fTVar, set, f, vec3, blockPos);
        for (UUID uuid : set) {
            int iA = oR.a((oF<?, ?, ?>) this.f, uuid, C0529tp.s);
            int orDefault = this.g.getOrDefault(uuid, 0);
            int iLerp = (int) Mth.lerp(0.1f, orDefault, iA);
            if (Math.abs(iLerp - orDefault) < 1) {
                this.g.put(uuid, iA);
            } else {
                this.g.put(uuid, iLerp);
            }
        }
    }

    @Override // com.boehmod.blockfront.oG
    public void b(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull fT fTVar, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2) {
        a(minecraft, localPlayer, clientLevel, guiGraphics, font, i3, i4);
        a(guiGraphics, font, poseStack, set, i);
    }

    @Override // com.boehmod.blockfront.oG
    @Nullable
    public Component a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull fT fTVar) {
        if (c0297l.m592d()) {
            return null;
        }
        return js;
    }

    private void a(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull Set<UUID> set, int i) {
        int i2 = (i - 64) - 5;
        int iP = C0040bk.p();
        int i3 = 0;
        for (UUID uuid : set) {
            MutableComponent mutableComponentWithStyle = Component.literal("$").append(C0637xp.a(oR.a((oF<?, ?, ?>) this.f, uuid, C0529tp.s))).withStyle(ChatFormatting.GREEN);
            int i4 = 25 + (18 * i3);
            C0040bk.a(guiGraphics, i2 + 1, i4, 62, 1, iP);
            C0040bk.a(guiGraphics, i2, i4 + 1, 64, 14, iP);
            C0040bk.a(guiGraphics, i2 + 1, (i4 + 16) - 1, 62, 1, iP);
            C0040bk.a(guiGraphics, i2 + 1, i4 + 1, 14, 14, iP);
            ResourceLocation resourceLocationA = a(uuid, (String) null, set);
            if (resourceLocationA != null) {
                poseStack.pushPose();
                poseStack.translate(r0 + 1, r0 + 1, 0.0f);
                guiGraphics.blit(resourceLocationA, 0, 0, 12, 12, 8.0f, 8.0f, 8, 8, 64, 64);
                guiGraphics.blit(resourceLocationA, 0, 0, 12, 12, 40.0f, 8.0f, 8, 8, 64, 64);
                poseStack.popPose();
            }
            C0040bk.d(poseStack, font, guiGraphics, mutableComponentWithStyle, i2 + 39, ((i4 + 8) - 4) + 0.5f);
            i3++;
        }
    }

    private void a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2) {
        BlockHitResult blockHitResult = minecraft.hitResult;
        if (blockHitResult instanceof BlockHitResult) {
            BlockPos blockPos = blockHitResult.getBlockPos();
            if (clientLevel.getBlockState(blockPos).getBlock() instanceof DoorBlock) {
                int iA = oR.a((oF<?, ?, ?>) this.f, localPlayer.getUUID(), C0529tp.s);
                ((rV) this.f).bp.stream().filter(c0490sd -> {
                    return c0490sd.e().equals(blockPos) || c0490sd.e().offset(0, 1, 0).equals(blockPos) || c0490sd.e().offset(0, -1, 0).equals(blockPos);
                }).filter(c0490sd2 -> {
                    return !c0490sd2.bL();
                }).forEach(c0490sd3 -> {
                    C0040bk.c(font, guiGraphics, (Component) Component.translatable("bf.message.gamemode.infected.door.open.ui", new Object[]{Component.literal("$" + c0490sd3.bk()).withStyle(iA >= c0490sd3.bk() ? ChatFormatting.GREEN : ChatFormatting.DARK_RED)}), i, i2 + 20);
                });
            }
        }
    }

    @Override // com.boehmod.blockfront.oG
    public void a(@NotNull oI<?> oIVar, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, boolean z, float f, float f2) {
        super.a(oIVar, minecraft, clientLevel, localPlayer, renderLevelStageEvent, bufferSource, poseStack, frustum, font, guiGraphics, camera, z, f, f2);
        for (Entity entity : clientLevel.entitiesForRendering()) {
            if (entity instanceof mY) {
                C0040bk.a(poseStack, camera, guiGraphics, fe, entity.position().add(0.0d, 2.5d, 0.0d), 16, true);
            }
        }
        if (localPlayer.isCreative() && minecraft.getDebugOverlay().showDebugScreen()) {
            ObjectArrayList objectArrayList = new ObjectArrayList();
            for (oX oXVar : ((rV) this.f).bq) {
                C0040bk.a(poseStack, camera, guiGraphics, fh, oXVar.q() + 0.5d, oXVar.r() + 0.5d, oXVar.s() + 0.5d, 32, false);
            }
            for (C0490sd c0490sd : ((rV) this.f).bp) {
                BlockPos blockPosE = c0490sd.e();
                C0040bk.a(poseStack, camera, guiGraphics, fg, blockPosE.getX() + 0.5f, blockPosE.getY() + 0.5f, blockPosE.getZ() + 0.5f, 32, false);
                if (!objectArrayList.contains(c0490sd.getId())) {
                    objectArrayList.add(c0490sd.getId());
                    C0040bk.a(poseStack, camera, font, guiGraphics, (Component) Component.literal("Zombie Zone Door"), blockPosE.getX(), blockPosE.getY() + 2, blockPosE.getZ());
                    StringBuilder sb = new StringBuilder();
                    Iterator<String> it = c0490sd.at().iterator();
                    while (it.hasNext()) {
                        sb.append(it.next() + ", ");
                    }
                    String string = sb.toString();
                    C0040bk.a(poseStack, camera, font, guiGraphics, (Component) Component.literal(String.format("Door ID: '%s'", String.valueOf(ChatFormatting.GRAY) + c0490sd.getId() + String.valueOf(ChatFormatting.RESET))), blockPosE.getX(), blockPosE.getY() + 1.5f, blockPosE.getZ());
                    C0040bk.a(poseStack, camera, font, guiGraphics, (Component) Component.literal(String.format("Door Zones: '%s'", String.valueOf(ChatFormatting.GRAY) + string + String.valueOf(ChatFormatting.RESET))), blockPosE.getX(), blockPosE.getY() + 1.0f, blockPosE.getZ());
                    C0040bk.a(poseStack, camera, font, guiGraphics, (Component) Component.literal(String.format("X: '%s', Y: '%s', Z: '%s'", String.valueOf(ChatFormatting.GRAY) + blockPosE.getX() + String.valueOf(ChatFormatting.RESET), String.valueOf(ChatFormatting.GRAY) + blockPosE.getY() + String.valueOf(ChatFormatting.RESET), String.valueOf(ChatFormatting.GRAY) + blockPosE.getZ() + String.valueOf(ChatFormatting.RESET))), blockPosE.getX(), blockPosE.getY() + 0.5f, blockPosE.getZ());
                }
            }
            for (C0489sc c0489sc : ((rV) this.f).bo) {
                ObjectArrayList objectArrayList2 = new ObjectArrayList();
                Iterator<C0488sb> it2 = c0489sc.as().iterator();
                while (it2.hasNext()) {
                    oX oXVarE = it2.next().e();
                    objectArrayList2.add(new Vec3(oXVarE.q() + 0.5d, oXVarE.r() + 0.5d, oXVarE.s() + 0.5d));
                    C0040bk.a(poseStack, camera, guiGraphics, ff, oXVarE.q() + 0.5d, oXVarE.r() + 0.5d, oXVarE.s() + 0.5d, 32, false);
                    MutableComponent mutableComponentLiteral = Component.literal("Zombie Spawn");
                    if (c0489sc.bK()) {
                        mutableComponentLiteral.append(Component.literal(" ACTIVE").withStyle(ChatFormatting.GREEN));
                    }
                    C0040bk.a(poseStack, camera, font, guiGraphics, (Component) mutableComponentLiteral, oXVarE.q(), oXVarE.r() + 2.0d, oXVarE.s());
                    C0040bk.a(poseStack, camera, font, guiGraphics, (Component) Component.literal(String.format("Zone: '%s'", String.valueOf(ChatFormatting.GRAY) + c0489sc.ai() + String.valueOf(ChatFormatting.RESET))), oXVarE.q(), oXVarE.r() + 1.5d, oXVarE.s());
                    C0040bk.a(poseStack, camera, font, guiGraphics, (Component) Component.literal(String.format("X: '%s', Y: '%s', Z: '%s'", String.valueOf(ChatFormatting.GRAY) + ((float) oXVarE.q()) + String.valueOf(ChatFormatting.RESET), String.valueOf(ChatFormatting.GRAY) + ((float) oXVarE.r()) + String.valueOf(ChatFormatting.RESET), String.valueOf(ChatFormatting.GRAY) + ((float) oXVarE.s()) + String.valueOf(ChatFormatting.RESET))), oXVarE.q(), oXVarE.r() + 1.0d, oXVarE.s());
                }
                Vec3 vec3A = C0634xm.a((List<Vec3>) objectArrayList2);
                vec3A.add(0.0d, 2.0d, 0.0d);
                C0040bk.a(poseStack, font, camera, guiGraphics, (Component) Component.literal("ZONE '" + c0489sc.ai() + "'").withStyle(c0489sc.bK() ? ChatFormatting.GREEN : ChatFormatting.RED), vec3A.x, vec3A.y + 1.0d, vec3A.z, 2.0f);
                Iterator<C0488sb> it3 = c0489sc.as().iterator();
                while (it3.hasNext()) {
                    C0040bk.a(camera, poseStack, vec3A, it3.next().e().c.add(0.5d, 0.5d, 0.5d), 1.0f, c0489sc.bK() ? 16711935 : -16776961);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.oG
    public boolean a(@NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        oO oOVarA;
        rX rXVarB = ((rV) this.f).b();
        oO oOVarA2 = rXVarB.a(player.getUUID());
        String strE = null;
        if ((livingEntity instanceof Player) && (oOVarA = rXVarB.a(((Player) livingEntity).getUUID())) != null) {
            strE = oOVarA.getName();
        }
        if (livingEntity instanceof mE) {
            strE = ((mE) livingEntity).E();
        }
        if (oOVarA2 != null && strE != null) {
            return oOVarA2.getName().equalsIgnoreCase(strE);
        }
        return false;
    }

    @Override // com.boehmod.blockfront.oG
    public boolean bk() {
        return true;
    }

    @Override // com.boehmod.blockfront.oG
    @NotNull
    public List<C0045bp> b(@NotNull Minecraft minecraft, @NotNull Set<UUID> set, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (Entity entity : clientLevel.entitiesForRendering()) {
            ResourceLocation resourceLocation = null;
            if ((entity instanceof Player) && set.contains(entity.getUUID()) && !entity.getScoreboardName().equals(minecraft.getUser().getName())) {
                resourceLocation = C0045bp.M;
            }
            if (entity instanceof mQ) {
                resourceLocation = C0045bp.N;
            }
            if (entity instanceof mY) {
                resourceLocation = fe;
            }
            if (resourceLocation != null) {
                objectArrayList.add(new C0045bp(resourceLocation, entity.position()).a(4).a(entity.getYRot() - 180.0f));
            }
        }
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.oG
    public boolean bh() {
        return false;
    }

    @Override // com.boehmod.blockfront.oG
    public void a(@NotNull Minecraft minecraft, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        if (renderNameTagEvent.getEntity() instanceof Player) {
            renderNameTagEvent.setCanRender(TriState.TRUE);
        } else {
            renderNameTagEvent.setCanRender(TriState.FALSE);
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
        }).a("CASH", (fTVar2, playerInfo2, oMVar2) -> {
            String str;
            int iA = oMVar2.a(C0529tp.s.getKey());
            if (iA >= 1000) {
                str = "$" + (iA / ShaderInjectionDefinition.DEFAULT_PRIORITY) + "." + ((iA % ShaderInjectionDefinition.DEFAULT_PRIORITY) / 100) + "K";
            } else {
                str = "$" + C0637xp.a(iA);
            }
            return str;
        }).a("K", (fTVar3, playerInfo3, oMVar3) -> {
            return C0637xp.a(oMVar3.a(C0529tp.G.getKey()));
        }).a("SCORE", (fTVar4, playerInfo4, oMVar4) -> {
            return C0637xp.a(oMVar4.a(C0529tp.l.getKey()));
        });
    }

    @Override // com.boehmod.blockfront.oG
    public ResourceLocation a(@NotNull UUID uuid, @Nullable String str, @NotNull Set<UUID> set) {
        if (str == null || !str.equalsIgnoreCase(fT.Y)) {
            return C0492sf.a(oR.a((oF<?, ?, ?>) this.f, uuid, C0529tp.R)).getTexture();
        }
        return null;
    }

    @Override // com.boehmod.blockfront.oG
    @NotNull
    public Collection<? extends cU> a(boolean z) {
        return a((rV) this.f, z);
    }
}
