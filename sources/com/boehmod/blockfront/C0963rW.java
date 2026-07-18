package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0788oG;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.rW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rW.class */
public final class C0963rW extends AbstractC0788oG<C0962rV, C0964rX> {

    /* JADX INFO: renamed from: fe */
    private static final ResourceLocation f5094fe = C0564jv.m2555d("textures/gui/compass/waypoint_store.png");

    /* JADX INFO: renamed from: ff */
    private static final ResourceLocation f5095ff = C0564jv.m2555d("textures/misc/debug/infected_spawn.png");

    /* JADX INFO: renamed from: fg */
    private static final ResourceLocation f5096fg = C0564jv.m2555d("textures/misc/debug/infected_door.png");

    /* JADX INFO: renamed from: fh */
    private static final ResourceLocation f5097fh = C0564jv.m2555d("textures/misc/debug/infected_store.png");

    /* JADX INFO: renamed from: js */
    @NotNull
    private static final Component f5098js = Component.translatable("bf.message.gamemode.infected.dead.countdown").withStyle(ChatFormatting.GRAY);

    /* JADX INFO: renamed from: g */
    @NotNull
    private final Object2IntMap<UUID> f5099g;

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: u */
    protected List<Component> mo3666u() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(Component.translatable("bf.message.gamemode.infected.tip.0", new Object[]{Component.literal(String.valueOf(30))}));
        objectArrayList.add(Component.translatable("bf.message.gamemode.infected.tip.1"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.infected.tip.2"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.infected.tip.3"));
        return objectArrayList;
    }

    public C0963rW(@NotNull C0622l c0622l, @NotNull C0962rV c0962rV, @NotNull C0326fV c0326fV) {
        super(c0622l, c0962rV, c0326fV);
        this.f5099g = new Object2IntOpenHashMap();
        c0622l.m2709a().m3222b(new C0719mr(c0962rV));
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: w */
    protected List<AbstractC0168cg<C0962rV, C0964rX>> mo3670w() {
        return List.of(new C0163cb(), new C0106bX(), new C0107bY(), new C0105bW(), new C0167cf());
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
        for (UUID uuid : set) {
            int iM4009a = C0799oR.m4009a((AbstractC0787oF<?, ?, ?>) this.f4272f, uuid, C1089tp.f5702s);
            int orDefault = this.f5099g.getOrDefault(uuid, 0);
            int iLerp = (int) Mth.lerp(0.1f, orDefault, iM4009a);
            if (Math.abs(iLerp - orDefault) < 1) {
                this.f5099g.put(uuid, iM4009a);
            } else {
                this.f5099g.put(uuid, iLerp);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: b */
    public void mo3704b(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0324fT c0324fT, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2) {
        m5296a(minecraft, localPlayer, clientLevel, guiGraphics, font, i3, i4);
        m5295a(guiGraphics, font, poseStack, set, i);
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @Nullable
    /* JADX INFO: renamed from: a */
    public Component mo3705a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull C0324fT c0324fT) {
        if (c0622l.m2689d()) {
            return null;
        }
        return f5098js;
    }

    /* JADX INFO: renamed from: a */
    private void m5295a(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull Set<UUID> set, int i) {
        int i2 = (i - 64) - 5;
        int iM365p = C0119bk.m365p();
        int i3 = 0;
        for (UUID uuid : set) {
            MutableComponent mutableComponentWithStyle = Component.literal("$").append(C1293xp.m7912a(C0799oR.m4009a((AbstractC0787oF<?, ?, ?>) this.f4272f, uuid, C1089tp.f5702s))).withStyle(ChatFormatting.GREEN);
            int i4 = 25 + (18 * i3);
            C0119bk.m415a(guiGraphics, i2 + 1, i4, 62, 1, iM365p);
            C0119bk.m415a(guiGraphics, i2, i4 + 1, 64, 14, iM365p);
            C0119bk.m415a(guiGraphics, i2 + 1, (i4 + 16) - 1, 62, 1, iM365p);
            C0119bk.m415a(guiGraphics, i2 + 1, i4 + 1, 14, 14, iM365p);
            ResourceLocation resourceLocationMo3732a = mo3732a(uuid, (String) null, set);
            if (resourceLocationMo3732a != null) {
                poseStack.pushPose();
                poseStack.translate(r0 + 1, r0 + 1, 0.0f);
                guiGraphics.blit(resourceLocationMo3732a, 0, 0, 12, 12, 8.0f, 8.0f, 8, 8, 64, 64);
                guiGraphics.blit(resourceLocationMo3732a, 0, 0, 12, 12, 40.0f, 8.0f, 8, 8, 64, 64);
                poseStack.popPose();
            }
            C0119bk.m398d(poseStack, font, guiGraphics, mutableComponentWithStyle, i2 + 39, ((i4 + 8) - 4) + 0.5f);
            i3++;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5296a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2) {
        BlockHitResult blockHitResult = minecraft.hitResult;
        if (blockHitResult instanceof BlockHitResult) {
            BlockPos blockPos = blockHitResult.getBlockPos();
            if (clientLevel.getBlockState(blockPos).getBlock() instanceof DoorBlock) {
                int iM4009a = C0799oR.m4009a((AbstractC0787oF<?, ?, ?>) this.f4272f, localPlayer.getUUID(), C1089tp.f5702s);
                ((C0962rV) this.f4272f).f5082bp.stream().filter(c1023sd -> {
                    return c1023sd.m5703e().equals(blockPos) || c1023sd.m5703e().offset(0, 1, 0).equals(blockPos) || c1023sd.m5703e().offset(0, -1, 0).equals(blockPos);
                }).filter(c1023sd2 -> {
                    return !c1023sd2.m5704bL();
                }).forEach(c1023sd3 -> {
                    C0119bk.m383c(font, guiGraphics, (Component) Component.translatable("bf.message.gamemode.infected.door.open.ui", new Object[]{Component.literal("$" + c1023sd3.m5705bk()).withStyle(iM4009a >= c1023sd3.m5705bk() ? ChatFormatting.GREEN : ChatFormatting.DARK_RED)}), i, i2 + 20);
                });
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public void mo3715a(@NotNull AbstractC0790oI<?> abstractC0790oI, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, boolean z, float f, float f2) {
        super.mo3715a(abstractC0790oI, minecraft, clientLevel, localPlayer, renderLevelStageEvent, bufferSource, poseStack, frustum, font, guiGraphics, camera, z, f, f2);
        for (Entity entity : clientLevel.entitiesForRendering()) {
            if (entity instanceof C0700mY) {
                C0119bk.m505a(poseStack, camera, guiGraphics, f5094fe, entity.position().add(0.0d, 2.5d, 0.0d), 16, true);
            }
        }
        if (localPlayer.isCreative() && minecraft.getDebugOverlay().showDebugScreen()) {
            ObjectArrayList objectArrayList = new ObjectArrayList();
            for (C0805oX c0805oX : ((C0962rV) this.f4272f).f5083bq) {
                C0119bk.m504a(poseStack, camera, guiGraphics, f5097fh, c0805oX.m4147q() + 0.5d, c0805oX.m4148r() + 0.5d, c0805oX.m4149s() + 0.5d, 32, false);
            }
            for (C1023sd c1023sd : ((C0962rV) this.f4272f).f5082bp) {
                BlockPos blockPosM5703e = c1023sd.m5703e();
                C0119bk.m504a(poseStack, camera, guiGraphics, f5096fg, blockPosM5703e.getX() + 0.5f, blockPosM5703e.getY() + 0.5f, blockPosM5703e.getZ() + 0.5f, 32, false);
                if (!objectArrayList.contains(c1023sd.getId())) {
                    objectArrayList.add(c1023sd.getId());
                    C0119bk.m524a(poseStack, camera, font, guiGraphics, (Component) Component.literal("Zombie Zone Door"), blockPosM5703e.getX(), blockPosM5703e.getY() + 2, blockPosM5703e.getZ());
                    StringBuilder sb = new StringBuilder();
                    Iterator<String> it = c1023sd.m5702at().iterator();
                    while (it.hasNext()) {
                        sb.append(it.next() + ", ");
                    }
                    String string = sb.toString();
                    C0119bk.m524a(poseStack, camera, font, guiGraphics, (Component) Component.literal(String.format("Door ID: '%s'", String.valueOf(ChatFormatting.GRAY) + c1023sd.getId() + String.valueOf(ChatFormatting.RESET))), blockPosM5703e.getX(), blockPosM5703e.getY() + 1.5f, blockPosM5703e.getZ());
                    C0119bk.m524a(poseStack, camera, font, guiGraphics, (Component) Component.literal(String.format("Door Zones: '%s'", String.valueOf(ChatFormatting.GRAY) + string + String.valueOf(ChatFormatting.RESET))), blockPosM5703e.getX(), blockPosM5703e.getY() + 1.0f, blockPosM5703e.getZ());
                    C0119bk.m524a(poseStack, camera, font, guiGraphics, (Component) Component.literal(String.format("X: '%s', Y: '%s', Z: '%s'", String.valueOf(ChatFormatting.GRAY) + blockPosM5703e.getX() + String.valueOf(ChatFormatting.RESET), String.valueOf(ChatFormatting.GRAY) + blockPosM5703e.getY() + String.valueOf(ChatFormatting.RESET), String.valueOf(ChatFormatting.GRAY) + blockPosM5703e.getZ() + String.valueOf(ChatFormatting.RESET))), blockPosM5703e.getX(), blockPosM5703e.getY() + 0.5f, blockPosM5703e.getZ());
                }
            }
            for (C1022sc c1022sc : ((C0962rV) this.f4272f).f5081bo) {
                ObjectArrayList objectArrayList2 = new ObjectArrayList();
                Iterator<C1021sb> it2 = c1022sc.m5695as().iterator();
                while (it2.hasNext()) {
                    C0805oX c0805oXM5686e = it2.next().m5686e();
                    objectArrayList2.add(new Vec3(c0805oXM5686e.m4147q() + 0.5d, c0805oXM5686e.m4148r() + 0.5d, c0805oXM5686e.m4149s() + 0.5d));
                    C0119bk.m504a(poseStack, camera, guiGraphics, f5095ff, c0805oXM5686e.m4147q() + 0.5d, c0805oXM5686e.m4148r() + 0.5d, c0805oXM5686e.m4149s() + 0.5d, 32, false);
                    MutableComponent mutableComponentLiteral = Component.literal("Zombie Spawn");
                    if (c1022sc.m5692bK()) {
                        mutableComponentLiteral.append(Component.literal(" ACTIVE").withStyle(ChatFormatting.GREEN));
                    }
                    C0119bk.m524a(poseStack, camera, font, guiGraphics, (Component) mutableComponentLiteral, c0805oXM5686e.m4147q(), c0805oXM5686e.m4148r() + 2.0d, c0805oXM5686e.m4149s());
                    C0119bk.m524a(poseStack, camera, font, guiGraphics, (Component) Component.literal(String.format("Zone: '%s'", String.valueOf(ChatFormatting.GRAY) + c1022sc.m5694ai() + String.valueOf(ChatFormatting.RESET))), c0805oXM5686e.m4147q(), c0805oXM5686e.m4148r() + 1.5d, c0805oXM5686e.m4149s());
                    C0119bk.m524a(poseStack, camera, font, guiGraphics, (Component) Component.literal(String.format("X: '%s', Y: '%s', Z: '%s'", String.valueOf(ChatFormatting.GRAY) + ((float) c0805oXM5686e.m4147q()) + String.valueOf(ChatFormatting.RESET), String.valueOf(ChatFormatting.GRAY) + ((float) c0805oXM5686e.m4148r()) + String.valueOf(ChatFormatting.RESET), String.valueOf(ChatFormatting.GRAY) + ((float) c0805oXM5686e.m4149s()) + String.valueOf(ChatFormatting.RESET))), c0805oXM5686e.m4147q(), c0805oXM5686e.m4148r() + 1.0d, c0805oXM5686e.m4149s());
                }
                Vec3 vec3M7838a = C1290xm.m7838a((List<Vec3>) objectArrayList2);
                vec3M7838a.add(0.0d, 2.0d, 0.0d);
                C0119bk.m520a(poseStack, font, camera, guiGraphics, (Component) Component.literal("ZONE '" + c1022sc.m5694ai() + "'").withStyle(c1022sc.m5692bK() ? ChatFormatting.GREEN : ChatFormatting.RED), vec3M7838a.x, vec3M7838a.y + 1.0d, vec3M7838a.z, 2.0f);
                Iterator<C1021sb> it3 = c1022sc.m5695as().iterator();
                while (it3.hasNext()) {
                    C0119bk.m474a(camera, poseStack, vec3M7838a, it3.next().m5686e().f4424c.add(0.5d, 0.5d, 0.5d), 1.0f, c1022sc.m5692bK() ? 16711935 : -16776961);
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public boolean mo3718a(@NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        C0796oO c0796oOA;
        C0964rX c0964rXB = ((C0962rV) this.f4272f).m3582b();
        C0796oO c0796oOA2 = c0964rXB.m3793a(player.getUUID());
        String strM3053E = null;
        if ((livingEntity instanceof Player) && (c0796oOA = c0964rXB.m3793a(((Player) livingEntity).getUUID())) != null) {
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
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (Entity entity : clientLevel.entitiesForRendering()) {
            ResourceLocation resourceLocation = null;
            if ((entity instanceof Player) && set.contains(entity.getUUID()) && !entity.getScoreboardName().equals(minecraft.getUser().getName())) {
                resourceLocation = C0124bp.f865M;
            }
            if (entity instanceof C0692mQ) {
                resourceLocation = C0124bp.f866N;
            }
            if (entity instanceof C0700mY) {
                resourceLocation = f5094fe;
            }
            if (resourceLocation != null) {
                objectArrayList.add(new C0124bp(resourceLocation, entity.position()).m625a(4).m623a(entity.getYRot() - 180.0f));
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
        if (renderNameTagEvent.getEntity() instanceof Player) {
            renderNameTagEvent.setCanRender(TriState.TRUE);
        } else {
            renderNameTagEvent.setCanRender(TriState.FALSE);
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
        }).m3765a("CASH", (c0324fT2, playerInfo2, c0794oM2) -> {
            String str;
            int iM3853a = c0794oM2.m3853a(C1089tp.f5702s.getKey());
            if (iM3853a >= 1000) {
                str = "$" + (iM3853a / ShaderInjectionDefinition.DEFAULT_PRIORITY) + "." + ((iM3853a % ShaderInjectionDefinition.DEFAULT_PRIORITY) / 100) + "K";
            } else {
                str = "$" + C1293xp.m7912a(iM3853a);
            }
            return str;
        }).m3765a("K", (c0324fT3, playerInfo3, c0794oM3) -> {
            return C1293xp.m7912a(c0794oM3.m3853a(C1089tp.f5716G.getKey()));
        }).m3765a("SCORE", (c0324fT4, playerInfo4, c0794oM4) -> {
            return C1293xp.m7912a(c0794oM4.m3853a(C1089tp.f5695l.getKey()));
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public ResourceLocation mo3732a(@NotNull UUID uuid, @Nullable String str, @NotNull Set<UUID> set) {
        if (str == null || !str.equalsIgnoreCase(C0324fT.f2357Y)) {
            return C1026sf.m5717a(C0799oR.m4009a((AbstractC0787oF<?, ?, ?>) this.f4272f, uuid, C1089tp.f5727R)).getTexture();
        }
        return null;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: a */
    public Collection<? extends AbstractC0156cU> mo3743a(boolean z) {
        return m3744a((C0962rV) this.f4272f, z);
    }
}
