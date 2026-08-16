package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import net.neoforged.neoforge.common.util.TriState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sI.class */
public final class C1003sI extends AbstractC0865pd<C1001sG, C1005sK> {

    /* JADX INFO: renamed from: fi */
    @NotNull
    private static final ResourceLocation f5533fi = C0532jO.m2378d("textures/misc/bfneutralicon.png");

    /* JADX INFO: renamed from: fj */
    @NotNull
    private static final ResourceLocation f5534fj = C0532jO.m2378d("textures/gui/menu/icons/reinforcements.png");

    /* JADX INFO: renamed from: sO */
    private static final int f5535sO = 16;

    /* JADX INFO: renamed from: cK */
    @NotNull
    private static final String f5536cK = "of.respawn";

    /* JADX INFO: renamed from: cL */
    @NotNull
    private static final String f5537cL = "of.rally.regroup";

    /* JADX INFO: renamed from: cM */
    @NotNull
    private static final String f5538cM = "of.boundary.grace";

    /* JADX INFO: renamed from: cN */
    @NotNull
    private static final String f5539cN = "of.prepare";

    /* JADX INFO: renamed from: mH */
    private static final float f5540mH = 30.0f;

    /* JADX INFO: renamed from: mI */
    private static final float f5541mI = 45.0f;

    /* JADX INFO: renamed from: aR */
    private static final double f5542aR = 32.0d;

    /* JADX INFO: renamed from: mJ */
    private static final float f5543mJ = 0.25f;

    /* JADX INFO: renamed from: mK */
    private static final float f5544mK = 1.0f;

    /* JADX INFO: renamed from: mL */
    private static final float f5545mL = 1.5f;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final C0129bt.d f5546c;

    /* JADX INFO: renamed from: mM */
    private static final float f5547mM = 0.6f;

    /* JADX INFO: renamed from: mN */
    private static final float f5548mN = 0.2f;

    /* JADX INFO: renamed from: sP */
    private static final int f5549sP = 16;

    /* JADX INFO: renamed from: sQ */
    private static final int f5550sQ = 4;

    /* JADX INFO: renamed from: mO */
    private static final float f5551mO = 2.0f;

    /* JADX INFO: renamed from: mP */
    private static final float f5552mP = 0.1f;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final C0129bt.d f5553d;

    /* JADX INFO: renamed from: hw */
    private boolean f5554hw;

    /* JADX INFO: renamed from: sR */
    private int f5555sR;

    /* JADX INFO: renamed from: mQ */
    private float f5556mQ;

    /* JADX INFO: renamed from: mR */
    private float f5557mR;

    public C1003sI(@NotNull C0623l c0623l, @NotNull C1001sG c1001sG, @NotNull C0396gl c0396gl) {
        super(c0623l, c1001sG, c0396gl);
        this.f5546c = C0129bt.d.m675a().m679a(1.0d).m684a(true, false, false).m680a(C0129bt.b.TOP);
        this.f5553d = C0129bt.d.m675a().m679a(4.0d);
        this.f5554hw = false;
        this.f5555sR = 0;
        this.f5556mQ = 0.0f;
        this.f5557mR = 0.0f;
        c0623l.m2895a().m3053b(new C0690mN(c1001sG));
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    @NotNull
    /* JADX INFO: renamed from: w */
    protected List<Component> mo4102w() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(Component.translatable("bf.message.gamemode.of.tip.0"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.of.tip.1"));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    @NotNull
    /* JADX INFO: renamed from: y */
    protected List<AbstractC0188cp<C1001sG, C1005sK>> mo4106y() {
        return List.of(new C0173ck(), new C0165cc(), new C0172cj(), new C0171ci());
    }

    @Override // com.boehmod.blockfront.AbstractC0865pd
    @NotNull
    /* JADX INFO: renamed from: a */
    protected C0872pk mo4204a(@NotNull AbstractC0879pr<?> abstractC0879pr, @NotNull C0872pk c0872pk) {
        C0872pk c0872pkM5637f = ((C1001sG) this.f4666f).m5637f();
        return c0872pkM5637f != null ? c0872pkM5637f : c0872pk;
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    protected void mo4107a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull List<C0885px> list) {
        C0872pk c0872pkA;
        super.mo4107a(minecraft, localPlayer, list);
        if (((C1001sG) this.f4666f).mo3996a() == EnumC0871pj.GAME && (c0872pkA = ((C1001sG) this.f4666f).m4018b().m4229a(localPlayer.getUUID())) != null) {
            int iM5647bZ = ((C1001sG) this.f4666f).m5647bZ();
            if (iM5647bZ > 0) {
                m4108a(list, f5539cN, (Component) Component.translatable(c0872pkA.equals(((C1001sG) this.f4666f).m5637f()) ? "bf.message.gamemode.of.prepare.attack" : "bf.message.gamemode.of.prepare.defend", new Object[]{Component.literal(String.valueOf(iM5647bZ)).withColor(ColorReferences.COLOR_STOPWATCH)}).withStyle(ChatFormatting.WHITE));
                return;
            }
            if (C0875pn.m4488a((Player) localPlayer, (AbstractC0183b<?, ?, ?, ?>) this.f4705b.m1150a((Player) localPlayer))) {
                int iM5645bX = c0872pkA.equals(((C1001sG) this.f4666f).m5637f()) ? ((C1001sG) this.f4666f).m5645bX() : ((C1001sG) this.f4666f).m5646bY();
                if (iM5645bX > 0) {
                    m4108a(list, f5536cK, m5675a(iM5645bX));
                    return;
                }
                return;
            }
            if (((C1001sG) this.f4666f).m5628bW()) {
                m4108a(list, f5538cM, (Component) Component.translatable(c0872pkA.equals(((C1001sG) this.f4666f).m5637f()) ? "bf.message.gamemode.of.boundary.advance" : "bf.message.gamemode.of.boundary.fallback", new Object[]{Component.literal(String.valueOf(((C1001sG) this.f4666f).m5629bT())).withStyle(ChatFormatting.WHITE)}).withStyle(ChatFormatting.RED));
            } else if (c0872pkA.equals(((C1001sG) this.f4666f).m5638g()) && ((C1001sG) this.f4666f).m5644bZ()) {
                MutableComponent mutableComponentWithColor = Component.translatable("bf.message.gamemode.of.rally.regroup", new Object[]{Component.translatable("bf.message.gamemode.of.rally.regroup.reinforcements").withColor(ColorReferences.COLOR_THEME_YELLOW)}).withColor(ColorReferences.COLOR_WHITE);
                C1004sJ c1004sJM5639a = ((C1001sG) this.f4666f).m5639a();
                m4109a(list, f5537cL, (Component) mutableComponentWithColor, c1004sJM5639a != null ? c1004sJM5639a.f5561i.f4827c : null, ColorReferences.COLOR_THEME_YELLOW_SOLID, ColorReferences.COLOR_WHITE_SOLID);
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static Component m5675a(int i) {
        return Component.translatable("bf.message.gamemode.of.waves.countdown", new Object[]{Component.literal(Integer.toString(i)).withStyle(ChatFormatting.WHITE)}).withStyle(ChatFormatting.GRAY);
    }

    @Override // com.boehmod.blockfront.AbstractC0865pd, com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: b */
    public void mo4140b(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0394gj c0394gj, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2) {
        super.mo4140b(minecraft, c0623l, localPlayer, clientLevel, c0394gj, guiGraphics, font, poseStack, multiBufferSource, set, i, i2, i3, i4, f, f2);
        m5677a(minecraft, localPlayer, guiGraphics, poseStack, i, i2, f2);
        m5676b(guiGraphics, poseStack, font, i, i2, f2);
    }

    /* JADX INFO: renamed from: b */
    private void m5676b(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        float fM7170f = C1270xJ.m7170f(this.f5556mQ, this.f5557mR, f);
        if (fM7170f <= 0.0f) {
            return;
        }
        C0129bt.m517a(guiGraphics, 0, 0, i, i2, ColorReferences.COLOR_BLACK_SOLID, fM7170f);
        if (this.f5554hw) {
            float f2 = i / 2.0f;
            float f3 = i2 / 2.0f;
            MutableComponent mutableComponentWithStyle = Component.literal(String.valueOf(Math.max(1, (this.f5555sR + 19) / 20))).withStyle(ChatFormatting.WHITE);
            MutableComponent mutableComponentWithStyle2 = Component.translatable("bf.message.gamemode.of.boundary.title").withStyle(C0533jP.f3185b).withStyle(ChatFormatting.WHITE);
            MutableComponent mutableComponentWithStyle3 = Component.translatable("bf.message.gamemode.of.boundary.abandon", new Object[]{mutableComponentWithStyle}).withStyle(ChatFormatting.RED);
            C0129bt.m490b(poseStack, font, guiGraphics, (Component) mutableComponentWithStyle2, f2, f3 - 14.0f, 2.0f);
            C0129bt.m498d(poseStack, font, guiGraphics, (Component) mutableComponentWithStyle3, f2, f3 + 8.0f);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5677a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, int i, int i2, float f) {
        C1004sJ c1004sJM5639a;
        if (((C1001sG) this.f4666f).mo3996a() == EnumC0871pj.GAME && ((C1001sG) this.f4666f).m5644bZ()) {
            C0872pk c0872pkM5638g = ((C1001sG) this.f4666f).m5638g();
            C0872pk c0872pkA = ((C1001sG) this.f4666f).m4018b().m4229a(localPlayer.getUUID());
            if (c0872pkM5638g == null || !c0872pkM5638g.equals(c0872pkA) || (c1004sJM5639a = ((C1001sG) this.f4666f).m5639a()) == null) {
                return;
            }
            C0129bt.m652a(poseStack, guiGraphics, f5534fj, c1004sJM5639a.f5561i.f4827c.add(0.0d, 1.0d, 0.0d), minecraft.gameRenderer.getMainCamera(), i, i2, 16, 16, (1.0f + Mth.sin(C0129bt.m466g() / 2.0f)) / 2.0f, ColorReferences.COLOR_THEME_YELLOW_SOLID, f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public boolean mo4112a(@NotNull AbstractClientPlayer abstractClientPlayer) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0865pd, com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public void mo4118a(@NotNull Minecraft minecraft, @NotNull Random random, @NotNull RandomSource randomSource, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0623l c0623l, @NotNull C0394gj c0394gj, @NotNull Set<UUID> set, float f, @NotNull Vec3 vec3, @NotNull BlockPos blockPos) {
        C1002sH c1002sH;
        super.mo4118a(minecraft, random, randomSource, localPlayer, clientLevel, c0623l, c0394gj, set, f, vec3, blockPos);
        C1004sJ c1004sJM5639a = ((C1001sG) this.f4666f).m5639a();
        C1002sH c1002sH2 = c1004sJM5639a != null ? c1004sJM5639a.f5558a : null;
        if (c1002sH2 != null && c1002sH2.m4570a(localPlayer.level(), c1002sH2.m4534a(3), set).contains(localPlayer)) {
            c1002sH = c1002sH2;
        } else {
            c1002sH = null;
        }
        this.f4720b = c1002sH;
        Iterator<C1002sH> it = ((C1001sG) this.f4666f).mo5353Q().iterator();
        while (it.hasNext()) {
            it.next().m4545a(localPlayer, clientLevel, (AbstractC0863pb<?, ?, ?>) this.f4666f);
        }
        m5678a(localPlayer, c0394gj);
    }

    /* JADX INFO: renamed from: a */
    private void m5678a(@NotNull LocalPlayer localPlayer, @NotNull C0394gj c0394gj) {
        int iMax;
        boolean z = false;
        if (((C1001sG) this.f4666f).mo3996a() == EnumC0871pj.GAME && !((C1001sG) this.f4666f).m5628bW() && !C0875pn.m4488a((Player) localPlayer, (AbstractC0183b<?, ?, ?, ?>) c0394gj)) {
            C0872pk c0872pkA = ((C1001sG) this.f4666f).m4018b().m4229a(localPlayer.getUUID());
            C0882pu c0882puM5627a = c0872pkA != null ? ((C1001sG) this.f4666f).m5627a(c0872pkA) : null;
            z = (c0882puM5627a == null || c0882puM5627a.m4608bE() || c0882puM5627a.m4604a((float) localPlayer.getX(), (float) localPlayer.getZ())) ? false : true;
        }
        boolean z2 = this.f5554hw;
        this.f5554hw = z;
        if (z != z2) {
            Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) (z ? C1312xz.f7992pN : C1312xz.f7991pM).get(), 1.0f));
        }
        if (z) {
            if (z2) {
                iMax = Math.max(0, this.f5555sR - 1);
            } else {
                iMax = 200;
            }
            this.f5555sR = iMax;
        } else {
            this.f5555sR = 0;
        }
        float f = z ? 0.6f : 0.0f;
        this.f5557mR = this.f5556mQ;
        this.f5556mQ = C1270xJ.m7183h(this.f5556mQ, f, 0.2f);
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: bt */
    public boolean mo4156bt() {
        return !this.f5554hw;
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public void mo4151a(@NotNull AbstractC0866pe<?> abstractC0866pe, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, boolean z, float f, float f2) {
        super.mo4151a(abstractC0866pe, minecraft, clientLevel, localPlayer, renderLevelStageEvent, bufferSource, poseStack, frustum, font, guiGraphics, camera, z, f, f2);
        C1004sJ c1004sJM5639a = ((C1001sG) this.f4666f).m5639a();
        if (c1004sJM5639a != null) {
            c1004sJM5639a.f5558a.m4546a(frustum, guiGraphics, camera, f);
            c1004sJM5639a.f5558a.m4547a(frustum, poseStack, font, camera, bufferSource);
            c1004sJM5639a.f5558a.m4548b(frustum, poseStack, font, camera, bufferSource);
            if (((C1001sG) this.f4666f).mo3996a() == EnumC0871pj.GAME && ((C1001sG) this.f4666f).m5644bZ()) {
                C0872pk c0872pkM5638g = ((C1001sG) this.f4666f).m5638g();
                C0872pk c0872pkA = ((C1001sG) this.f4666f).m4018b().m4229a(localPlayer.getUUID());
                if (c0872pkM5638g != null && c0872pkM5638g.equals(c0872pkA)) {
                    m5681a(camera, poseStack, frustum, localPlayer, c1004sJM5639a.f5561i.m4583b(5));
                }
            }
        }
        if (C0495ie.f3031k.m2230U()) {
            for (C0134by c0134by : m4117d()) {
                AABB aabbM725d = c0134by.m725d();
                if (c0134by.m737q() && frustum.isVisible(aabbM725d)) {
                    Vec3 vec3M738c = c0134by.m738c();
                    float fC = m4164C((float) localPlayer.position().distanceTo(vec3M738c));
                    if (fC > 0.0f) {
                        C0129bt.m610a(poseStack, camera, guiGraphics, c0134by.getTexture(), vec3M738c.x, vec3M738c.y, vec3M738c.z, 20, 20, 0.5f * fC, false);
                    }
                }
            }
        }
        if (z) {
            m5679a(localPlayer, poseStack, camera, font, guiGraphics);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5679a(@NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull Font font, @NotNull GuiGraphics guiGraphics) {
        double y = localPlayer.getY();
        for (C1004sJ c1004sJ : ((C1001sG) this.f4666f).m5640aw()) {
            String str = c1004sJ.f5558a.f4796bZ != null ? c1004sJ.f5558a.f4796bZ : "?";
            m5680a(poseStack, camera, font, guiGraphics, c1004sJ.f5562c, str + " (attacker)", y, ColorReferences.COLOR_THEME_RED_SOLID);
            m5680a(poseStack, camera, font, guiGraphics, c1004sJ.f5563d, str + " (defender)", y, ColorReferences.COLOR_THEME_GREEN_SOLID);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5680a(@NotNull PoseStack poseStack, @NotNull Camera camera, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull C0882pu c0882pu, @NotNull String str, double d, int i) {
        if (c0882pu.m4608bE()) {
            return;
        }
        C0129bt.m577a(camera, poseStack, c0882pu, d - 16.0d, d + 16.0d, this.f5553d.m676a(i, 0.1f).m677a(i, 1.0f, 2.0f));
        Vec2 vec2M4603b = c0882pu.m4603b();
        C0129bt.m623a(poseStack, font, camera, guiGraphics, (Component) Component.literal(str), vec2M4603b.x, d + 1.0d, vec2M4603b.y, 1.0f, i, false);
    }

    /* JADX INFO: renamed from: a */
    private void m5681a(@NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull LocalPlayer localPlayer, @NotNull AABB aabb) {
        if (frustum.isVisible(aabb)) {
            float fM7190j = C1270xJ.m7190j((float) Math.sqrt(aabb.distanceToSqr(camera.getPosition())), f5540mH, f5541mI);
            if (fM7190j <= 0.0f) {
                return;
            }
            C0129bt.m583a(camera, poseStack, aabb, this.f5546c.m676a(ColorReferences.COLOR_THEME_YELLOW_SOLID, 0.25f).m677a(ColorReferences.COLOR_THEME_YELLOW_SOLID, 1.0f, 1.5f).m682a(localPlayer.position(), f5542aR).m683a(0.0f).m685b(fM7190j));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    @NotNull
    /* JADX INFO: renamed from: b */
    public List<C0134by> mo4166b(@NotNull Minecraft minecraft, @NotNull Set<UUID> set, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        C0872pk c0872pkA = ((C1001sG) this.f4666f).m4018b().m4229a(localPlayer.getUUID());
        if (c0872pkA == null) {
            return new ObjectArrayList();
        }
        ObjectArrayList objectArrayList = new ObjectArrayList();
        C1004sJ c1004sJM5639a = ((C1001sG) this.f4666f).m5639a();
        if (c1004sJM5639a != null) {
            C1002sH c1002sH = c1004sJM5639a.f5558a;
            ResourceLocation icon = c1002sH.getIcon();
            objectArrayList.add(new C0134by(icon != null ? icon : f5533fi, c1002sH.f4827c).m726a(f5533fi, c1002sH.getColor()).m730a(6).m729a((Component) Component.literal(c1002sH.f4796bZ)).m735b(m4206D((float) c1002sH.f4827c.distanceTo(localPlayer.position()))));
        }
        for (Entity entity : clientLevel.entitiesForRendering()) {
            UUID uuid = entity.getUUID();
            if ((entity instanceof Player) && set.contains(uuid) && !uuid.equals(minecraft.getUser().getProfileId()) && c0872pkA.m4308h().contains(uuid)) {
                objectArrayList.add(new C0134by(C0134by.f1000M, entity.position()).m730a(4).m728a(entity.getYRot() - 180.0f));
            }
        }
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public boolean mo4154a(@NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        C0872pk c0872pkA;
        C1005sK c1005sKB = ((C1001sG) this.f4666f).m4018b();
        C0872pk c0872pkA2 = c1005sKB.m4229a(player.getUUID());
        return c0872pkA2 != null && (livingEntity instanceof Player) && (c0872pkA = c1005sKB.m4229a(((Player) livingEntity).getUUID())) != null && c0872pkA2.getName().equalsIgnoreCase(c0872pkA.getName());
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: a */
    public void mo4167a(@NotNull Minecraft minecraft, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        C0872pk c0872pkA;
        C1005sK c1005sKB = ((C1001sG) this.f4666f).m4018b();
        C0872pk c0872pkA2 = c1005sKB.m4229a(player.getUUID());
        Player entity = renderNameTagEvent.getEntity();
        if (entity instanceof Player) {
            Player player2 = entity;
            if (c0872pkA2 != null && (c0872pkA = c1005sKB.m4229a(player2.getUUID())) != null && c0872pkA.getName().equalsIgnoreCase(c0872pkA2.getName()) && player.hasLineOfSight(renderNameTagEvent.getEntity()) && player.distanceTo(renderNameTagEvent.getEntity()) <= 20.0f) {
                renderNameTagEvent.setCanRender(TriState.TRUE);
                return;
            }
        }
        renderNameTagEvent.setCanRender(TriState.FALSE);
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: g */
    public boolean mo4146g(@NotNull Player player) {
        return ((C1001sG) this.f4666f).mo3996a() != EnumC0871pj.GAME;
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: br */
    public boolean mo4153br() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0864pc
    /* JADX INFO: renamed from: bu */
    public boolean mo4157bu() {
        return true;
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
        return m4180a((C1001sG) this.f4666f, z);
    }
}
