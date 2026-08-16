package com.boehmod.blockfront;

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

/* JADX INFO: renamed from: com.boehmod.blockfront.st */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/st.class */
public final class C1041st extends AbstractC0864pc<C1040ss, C1042su> {

    /* JADX INFO: renamed from: fd */
    private static final ResourceLocation f5671fd = C0532jO.m2378d("textures/gui/compass/waypoint_store.png");

    /* JADX INFO: renamed from: fe */
    private static final ResourceLocation f5672fe = C0532jO.m2378d("textures/misc/debug/infected_spawn.png");

    /* JADX INFO: renamed from: ff */
    private static final ResourceLocation f5673ff = C0532jO.m2378d("textures/misc/debug/infected_door.png");

    /* JADX INFO: renamed from: fg */
    private static final ResourceLocation f5674fg = C0532jO.m2378d("textures/misc/debug/infected_store.png");

    /* JADX INFO: renamed from: jF */
    @NotNull
    private static final Component f5675jF = Component.translatable("bf.message.gamemode.infected.dead.countdown").withStyle(ChatFormatting.GRAY);

    /* JADX INFO: renamed from: g */
    @NotNull
    private final Object2IntMap<UUID> f5676g;

    @Override // com.boehmod.blockfront.AbstractC0864pc
    @NotNull
    /* JADX INFO: renamed from: w */
    protected List<Component> mo4102w() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(Component.translatable("bf.message.gamemode.infected.tip.0", new Object[]{Component.literal(String.valueOf(30))}));
        objectArrayList.add(Component.translatable("bf.message.gamemode.infected.tip.1"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.infected.tip.2"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.infected.tip.3"));
        return objectArrayList;
    }

    public C1041st(@NotNull C0623l c0623l, @NotNull C1040ss c1040ss, @NotNull C0396gl c0396gl) {
        super(c0623l, c1040ss, c0396gl);
        this.f5676g = new Object2IntOpenHashMap();
        c0623l.m2895a().m3053b(new C0690mN(c1040ss));
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    @NotNull
    /* JADX INFO: renamed from: y */
    protected List<AbstractC0188cp<C1040ss, C1042su>> mo4106y() {
        return List.of(new C0173ck(), new C0169cg(), new C0170ch(), new C0168cf(), new C0181co());
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
        for (UUID uuid : set) {
            int iM4445a = C0875pn.m4445a((AbstractC0863pb<?, ?, ?>) this.f4666f, uuid, C1062tN.f5755s);
            int orDefault = this.f5676g.getOrDefault(uuid, 0);
            int iLerp = (int) Mth.lerp(0.1f, orDefault, iM4445a);
            if (Math.abs(iLerp - orDefault) < 1) {
                this.f5676g.put(uuid, iM4445a);
            } else {
                this.f5676g.put(uuid, iLerp);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: b */
    public void mo4140b(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0394gj c0394gj, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2) {
        m5833a(minecraft, localPlayer, clientLevel, guiGraphics, font, i3, i4);
        m5832a(guiGraphics, font, poseStack, set, i);
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    @Nullable
    /* JADX INFO: renamed from: a */
    public Component mo4141a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull C0394gj c0394gj) {
        if (c0623l.m2875d()) {
            return null;
        }
        return f5675jF;
    }

    /* JADX INFO: renamed from: a */
    private void m5832a(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull Set<UUID> set, int i) {
        int i2 = (i - 64) - 5;
        int iM465t = C0129bt.m465t();
        int i3 = 0;
        for (UUID uuid : set) {
            MutableComponent mutableComponentWithStyle = Component.literal("$").append(C1273xM.m7239b(C0875pn.m4445a((AbstractC0863pb<?, ?, ?>) this.f4666f, uuid, C1062tN.f5755s))).withStyle(ChatFormatting.GREEN);
            int i4 = 25 + (18 * i3);
            C0129bt.m518b(guiGraphics, i2, i4, 64, 16, iM465t);
            int i5 = i2 + 1;
            int i6 = i4 + 1;
            C0129bt.m515a(guiGraphics, i5, i6, 14, 14, iM465t);
            ResourceLocation resourceLocationMo4168a = mo4168a(uuid, (String) null, set);
            if (resourceLocationMo4168a != null) {
                poseStack.pushPose();
                poseStack.translate(i5 + 1, i6 + 1, 0.0f);
                guiGraphics.blit(resourceLocationMo4168a, 0, 0, 12, 12, 8.0f, 8.0f, 8, 8, 64, 64);
                guiGraphics.blit(resourceLocationMo4168a, 0, 0, 12, 12, 40.0f, 8.0f, 8, 8, 64, 64);
                poseStack.popPose();
            }
            C0129bt.m498d(poseStack, font, guiGraphics, (Component) mutableComponentWithStyle, i2 + 39, ((i4 + 8) - 4) + 0.5f);
            i3++;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5833a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2) {
        BlockHitResult blockHitResult = minecraft.hitResult;
        if (blockHitResult instanceof BlockHitResult) {
            BlockPos blockPos = blockHitResult.getBlockPos();
            if (clientLevel.getBlockState(blockPos).getBlock() instanceof DoorBlock) {
                int iM4445a = C0875pn.m4445a((AbstractC0863pb<?, ?, ?>) this.f4666f, localPlayer.getUUID(), C1062tN.f5755s);
                ((C1040ss) this.f4666f).f5659bw.stream().filter(c0995sA -> {
                    return c0995sA.m5588e().equals(blockPos) || c0995sA.m5588e().offset(0, 1, 0).equals(blockPos) || c0995sA.m5588e().offset(0, -1, 0).equals(blockPos);
                }).filter(c0995sA2 -> {
                    return !c0995sA2.m5589bV();
                }).forEach(c0995sA3 -> {
                    C0129bt.m483c(font, guiGraphics, (Component) Component.translatable("bf.message.gamemode.infected.door.open.ui", new Object[]{Component.literal("$" + c0995sA3.m5590bz()).withStyle(iM4445a >= c0995sA3.m5590bz() ? ChatFormatting.GREEN : ChatFormatting.DARK_RED)}), i, i2 + 20);
                });
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public void mo4151a(@NotNull AbstractC0866pe<?> abstractC0866pe, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, boolean z, float f, float f2) {
        super.mo4151a(abstractC0866pe, minecraft, clientLevel, localPlayer, renderLevelStageEvent, bufferSource, poseStack, frustum, font, guiGraphics, camera, z, f, f2);
        for (Entity entity : clientLevel.entitiesForRendering()) {
            if (entity instanceof C0776nu) {
                C0129bt.m605a(poseStack, camera, guiGraphics, f5671fd, entity.position().add(0.0d, 2.5d, 0.0d), 16, true);
            }
        }
        if (localPlayer.isCreative() && minecraft.getDebugOverlay().showDebugScreen()) {
            ObjectArrayList objectArrayList = new ObjectArrayList();
            for (C0881pt c0881pt : ((C1040ss) this.f4666f).f5660bx) {
                C0129bt.m604a(poseStack, camera, guiGraphics, f5674fg, c0881pt.m4584s() + 0.5d, c0881pt.m4585t() + 0.5d, c0881pt.m4586u() + 0.5d, 32, false);
            }
            for (C0995sA c0995sA : ((C1040ss) this.f4666f).f5659bw) {
                BlockPos blockPosM5588e = c0995sA.m5588e();
                C0129bt.m604a(poseStack, camera, guiGraphics, f5673ff, blockPosM5588e.getX() + 0.5f, blockPosM5588e.getY() + 0.5f, blockPosM5588e.getZ() + 0.5f, 32, false);
                if (!objectArrayList.contains(c0995sA.getId())) {
                    objectArrayList.add(c0995sA.getId());
                    C0129bt.m626a(poseStack, camera, font, guiGraphics, (Component) Component.literal("Zombie Zone Door"), blockPosM5588e.getX(), blockPosM5588e.getY() + 2, blockPosM5588e.getZ());
                    StringBuilder sb = new StringBuilder();
                    Iterator<String> it = c0995sA.m5587av().iterator();
                    while (it.hasNext()) {
                        sb.append(it.next() + ", ");
                    }
                    String string = sb.toString();
                    C0129bt.m626a(poseStack, camera, font, guiGraphics, (Component) Component.literal(String.format("Door ID: '%s'", String.valueOf(ChatFormatting.GRAY) + c0995sA.getId() + String.valueOf(ChatFormatting.RESET))), blockPosM5588e.getX(), blockPosM5588e.getY() + 1.5f, blockPosM5588e.getZ());
                    C0129bt.m626a(poseStack, camera, font, guiGraphics, (Component) Component.literal(String.format("Door Zones: '%s'", String.valueOf(ChatFormatting.GRAY) + string + String.valueOf(ChatFormatting.RESET))), blockPosM5588e.getX(), blockPosM5588e.getY() + 1.0f, blockPosM5588e.getZ());
                    C0129bt.m626a(poseStack, camera, font, guiGraphics, (Component) Component.literal(String.format("X: '%s', Y: '%s', Z: '%s'", String.valueOf(ChatFormatting.GRAY) + blockPosM5588e.getX() + String.valueOf(ChatFormatting.RESET), String.valueOf(ChatFormatting.GRAY) + blockPosM5588e.getY() + String.valueOf(ChatFormatting.RESET), String.valueOf(ChatFormatting.GRAY) + blockPosM5588e.getZ() + String.valueOf(ChatFormatting.RESET))), blockPosM5588e.getX(), blockPosM5588e.getY() + 0.5f, blockPosM5588e.getZ());
                }
            }
            for (C1047sz c1047sz : ((C1040ss) this.f4666f).f5658bv) {
                ObjectArrayList objectArrayList2 = new ObjectArrayList();
                Iterator<C1046sy> it2 = c1047sz.m5858au().iterator();
                while (it2.hasNext()) {
                    C0881pt c0881ptM5849e = it2.next().m5849e();
                    objectArrayList2.add(new Vec3(c0881ptM5849e.m4584s() + 0.5d, c0881ptM5849e.m4585t() + 0.5d, c0881ptM5849e.m4586u() + 0.5d));
                    C0129bt.m604a(poseStack, camera, guiGraphics, f5672fe, c0881ptM5849e.m4584s() + 0.5d, c0881ptM5849e.m4585t() + 0.5d, c0881ptM5849e.m4586u() + 0.5d, 32, false);
                    MutableComponent mutableComponentLiteral = Component.literal("Zombie Spawn");
                    if (c1047sz.m5855bU()) {
                        mutableComponentLiteral.append(Component.literal(" ACTIVE").withStyle(ChatFormatting.GREEN));
                    }
                    C0129bt.m626a(poseStack, camera, font, guiGraphics, (Component) mutableComponentLiteral, c0881ptM5849e.m4584s(), c0881ptM5849e.m4585t() + 2.0d, c0881ptM5849e.m4586u());
                    C0129bt.m626a(poseStack, camera, font, guiGraphics, (Component) Component.literal(String.format("Zone: '%s'", String.valueOf(ChatFormatting.GRAY) + c1047sz.m5857ap() + String.valueOf(ChatFormatting.RESET))), c0881ptM5849e.m4584s(), c0881ptM5849e.m4585t() + 1.5d, c0881ptM5849e.m4586u());
                    C0129bt.m626a(poseStack, camera, font, guiGraphics, (Component) Component.literal(String.format("X: '%s', Y: '%s', Z: '%s'", String.valueOf(ChatFormatting.GRAY) + ((float) c0881ptM5849e.m4584s()) + String.valueOf(ChatFormatting.RESET), String.valueOf(ChatFormatting.GRAY) + ((float) c0881ptM5849e.m4585t()) + String.valueOf(ChatFormatting.RESET), String.valueOf(ChatFormatting.GRAY) + ((float) c0881ptM5849e.m4586u()) + String.valueOf(ChatFormatting.RESET))), c0881ptM5849e.m4584s(), c0881ptM5849e.m4585t() + 1.0d, c0881ptM5849e.m4586u());
                }
                Vec3 vec3M7164a = C1270xJ.m7164a((List<Vec3>) objectArrayList2);
                vec3M7164a.add(0.0d, 2.0d, 0.0d);
                C0129bt.m621a(poseStack, font, camera, guiGraphics, (Component) Component.literal("ZONE '" + c1047sz.m5857ap() + "'").withStyle(c1047sz.m5855bU() ? ChatFormatting.GREEN : ChatFormatting.RED), vec3M7164a.x, vec3M7164a.y + 1.0d, vec3M7164a.z, 2.0f);
                Iterator<C1046sy> it3 = c1047sz.m5858au().iterator();
                while (it3.hasNext()) {
                    C0129bt.m574a(camera, poseStack, vec3M7164a, it3.next().m5849e().f4827c.add(0.5d, 0.5d, 0.5d), 1.0f, c1047sz.m5855bU() ? 16711935 : -16776961);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public boolean mo4154a(@NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        C0872pk c0872pkA;
        C1042su c1042suB = ((C1040ss) this.f4666f).m4018b();
        C0872pk c0872pkA2 = c1042suB.m4229a(player.getUUID());
        String strM3560L = null;
        if ((livingEntity instanceof Player) && (c0872pkA = c1042suB.m4229a(((Player) livingEntity).getUUID())) != null) {
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
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (Entity entity : clientLevel.entitiesForRendering()) {
            ResourceLocation resourceLocation = null;
            if ((entity instanceof Player) && set.contains(entity.getUUID()) && !entity.getScoreboardName().equals(minecraft.getUser().getName())) {
                resourceLocation = C0134by.f1000M;
            }
            if (entity instanceof C0768nm) {
                resourceLocation = C0134by.f1001N;
            }
            if (entity instanceof C0776nu) {
                resourceLocation = f5671fd;
            }
            if (resourceLocation != null) {
                objectArrayList.add(new C0134by(resourceLocation, entity.position()).m730a(4).m728a(entity.getYRot() - 180.0f));
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
        if (renderNameTagEvent.getEntity() instanceof Player) {
            renderNameTagEvent.setCanRender(TriState.TRUE);
        } else {
            renderNameTagEvent.setCanRender(TriState.FALSE);
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
        }).m4201a("CASH", (c0394gj2, playerInfo2, c0870pi2) -> {
            String str;
            int iM4289a = c0870pi2.m4289a(C1062tN.f5755s.getKey());
            if (iM4289a >= 1000) {
                str = "$" + (iM4289a / ShaderInjectionDefinition.DEFAULT_PRIORITY) + "." + ((iM4289a % ShaderInjectionDefinition.DEFAULT_PRIORITY) / 100) + "K";
            } else {
                str = "$" + C1273xM.m7239b(iM4289a);
            }
            return str;
        }).m4201a("K", (c0394gj3, playerInfo3, c0870pi3) -> {
            return C1273xM.m7239b(c0870pi3.m4289a(C1062tN.f5769G.getKey()));
        }).m4201a("SCORE", (c0394gj4, playerInfo4, c0870pi4) -> {
            return C1273xM.m7239b(c0870pi4.m4289a(C1062tN.f5748l.getKey()));
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public ResourceLocation mo4168a(@NotNull UUID uuid, @Nullable String str, @NotNull Set<UUID> set) {
        if (str == null || !str.equalsIgnoreCase(C0394gj.f2552af)) {
            return C0997sC.m5602a(C0875pn.m4445a((AbstractC0863pb<?, ?, ?>) this.f4666f, uuid, C1062tN.f5780R)).getTexture();
        }
        return null;
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    @NotNull
    /* JADX INFO: renamed from: a */
    public Collection<? extends AbstractC0229dd> mo4179a(boolean z) {
        return m4180a((C1040ss) this.f4666f, z);
    }
}
