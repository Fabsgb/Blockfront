package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import com.boehmod.bflib.cloud.common.item.types.AbstractCloudItemCoin;
import com.boehmod.bflib.cloud.common.player.PlayerRank;
import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dg */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dg.class */
public class C0232dg extends AbstractC0229dd {

    /* JADX INFO: renamed from: gE */
    private static final int f1866gE = 200;

    /* JADX INFO: renamed from: gF */
    private static final int f1867gF = 30;

    /* JADX INFO: renamed from: gG */
    private static final int f1868gG = 120;

    /* JADX INFO: renamed from: gH */
    private static final int f1869gH = 165;

    /* JADX INFO: renamed from: gI */
    private static final int f1870gI = 10;

    /* JADX INFO: renamed from: gJ */
    private static final int f1871gJ = 170;

    /* JADX INFO: renamed from: dO */
    private static final float f1872dO = -5.0f;

    /* JADX INFO: renamed from: dP */
    private static final float f1873dP = -15.0f;

    /* JADX INFO: renamed from: dx */
    private static final Component f1874dx = Component.translatable("bf.message.game.match.summary.top.subtitle").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: dy */
    private static final Component f1875dy = Component.translatable("bf.message.game.match.summary.top.subtitle.tip");

    /* JADX INFO: renamed from: dz */
    private static final Component f1876dz = Component.translatable("bf.message.game.match.summary.top.title").withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: bc */
    @NotNull
    private static final ResourceLocation f1877bc = C0532jO.m2378d("textures/gui/backshadow.png");

    /* JADX INFO: renamed from: bd */
    @NotNull
    private static final ResourceLocation f1878bd = C0532jO.m2378d("textures/gui/cornershadow.png");

    /* JADX INFO: renamed from: be */
    @NotNull
    private static final ResourceLocation f1879be = C0532jO.m2378d("textures/gui/game/summary/top_player_background.png");

    /* JADX INFO: renamed from: d */
    @NotNull
    private final Set<UUID> f1880d;

    /* JADX INFO: renamed from: G */
    @NotNull
    private final ObjectList<a> f1881G;

    /* JADX INFO: renamed from: gK */
    private int f1882gK;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C1060tL f1883b;

    public C0232dg(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull C1060tL c1060tL) {
        super(abstractC0863pb.m4064e());
        this.f1880d = new LinkedHashSet();
        this.f1881G = new ObjectArrayList();
        this.f1882gK = 0;
        ObjectArrayList objectArrayList = new ObjectArrayList(C0875pn.m4388a(abstractC0863pb, 3, c1060tL, abstractC0863pb.m4018b().m4245h()));
        Collections.reverse(objectArrayList);
        this.f1880d.addAll(objectArrayList);
        this.f1883b = c1060tL;
    }

    @Override // com.boehmod.blockfront.AbstractC0229dd, com.boehmod.blockfront.C0143cG
    public void tick() {
        SoundEvent soundEvent;
        super.tick();
        ObjectListIterator it = this.f1881G.iterator();
        while (it.hasNext()) {
            ((a) it.next()).tick();
        }
        int i = this.f1882gK;
        this.f1882gK = i + 1;
        if (i >= 30 && !this.f1880d.isEmpty()) {
            this.f1882gK = 0;
            AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = this.f1057f.m2874a();
            Iterator<UUID> it2 = this.f1880d.iterator();
            if (it2.hasNext()) {
                UUID next = it2.next();
                it2.remove();
                int iM4445a = 0;
                if (abstractC0863pbM2874a != null) {
                    iM4445a = C0875pn.m4445a(abstractC0863pbM2874a, next, this.f1883b);
                }
                boolean zIsEmpty = this.f1880d.isEmpty();
                this.f1881G.add(new a(next, iM4445a));
                if (zIsEmpty) {
                    soundEvent = (SoundEvent) C1312xz.f7947oU.get();
                } else {
                    soundEvent = (SoundEvent) C1312xz.f7946oT.get();
                }
                this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI(soundEvent, 1.0f));
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0229dd, com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        int size = (this.width / 2) - (((120 * this.f1881G.size()) + (10 * (this.f1881G.size() - 1))) / 2);
        int i3 = this.height / 2;
        int size2 = this.f1881G.size();
        int i4 = 0;
        ObjectListIterator it = this.f1881G.iterator();
        while (it.hasNext()) {
            ((a) it.next()).m1351a(this.f1058a, this.f1057f, guiGraphics, this.font, size + (i4 * 130), i3 - 82, i4 == size2 - 1, f);
            i4++;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0229dd
    @NotNull
    /* JADX INFO: renamed from: a */
    protected SoundEvent mo1337a() {
        return (SoundEvent) C1312xz.f7945oS.get();
    }

    @Override // com.boehmod.blockfront.AbstractC0229dd
    /* JADX INFO: renamed from: K */
    protected int mo1338K() {
        return 200;
    }

    @Override // com.boehmod.blockfront.AbstractC0229dd
    @NotNull
    /* JADX INFO: renamed from: g */
    protected Component mo1339g() {
        return f1876dz;
    }

    @Override // com.boehmod.blockfront.AbstractC0229dd
    @NotNull
    /* JADX INFO: renamed from: h */
    protected Component mo1340h() {
        return f1874dx;
    }

    @Override // com.boehmod.blockfront.AbstractC0229dd
    @NotNull
    /* JADX INFO: renamed from: i */
    protected Component mo1341i() {
        return f1875dy;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.dg$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dg$a.class */
    public static final class a {

        /* JADX INFO: renamed from: bf */
        @NotNull
        private static final ResourceLocation f1884bf = C0532jO.m2378d("textures/gui/game/summary/top_player_stat_background.png");

        /* JADX INFO: renamed from: f */
        private final UUID f1885f;

        /* JADX INFO: renamed from: gL */
        private final int f1886gL;

        /* JADX INFO: renamed from: dh */
        private float f1887dh = 1.0f;

        /* JADX INFO: renamed from: di */
        private float f1888di = 1.0f;

        public a(@NotNull UUID uuid, int i) {
            this.f1885f = uuid;
            this.f1886gL = i;
        }

        private void tick() {
            this.f1888di = this.f1887dh;
            this.f1887dh = Mth.clamp(this.f1887dh + 0.1f, 0.0f, 0.5f);
        }

        /* JADX INFO: renamed from: a */
        private void m1351a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, boolean z, float f) {
            C0396gl c0396gl = (C0396gl) c0623l.m2855a();
            PoseStack poseStackPose = guiGraphics.pose();
            C0129bt.m591c(guiGraphics, i, i2, 120, C0232dg.f1869gH, C0129bt.m465t());
            C0129bt.m618a(guiGraphics, i, i2, 120, C0232dg.f1869gH);
            C0129bt.m533a(poseStackPose, guiGraphics, C0232dg.f1879be, i, i2, 120, C0232dg.f1869gH, 0.4f);
            C0129bt.m517a(guiGraphics, i, i2, 120, C0232dg.f1869gH, ColorReferences.COLOR_TEAM_ALLIES_SOLID, 0.25f);
            C0555jl c0555jlA = c0396gl.mo1154a(this.f1885f);
            PlayerRank rank = c0555jlA.getRank();
            C0550jg inventory = c0555jlA.getInventory();
            if (z) {
                C0129bt.m517a(guiGraphics, i, i2, 120, C0232dg.f1869gH, ColorReferences.COLOR_WHITE_SOLID, C1270xJ.m7170f(this.f1887dh, this.f1888di, f));
            }
            C0129bt.m539b(poseStackPose, guiGraphics, C0232dg.f1877bc, i + 60, i2 + 82, 150);
            C0129bt.m467a(poseStackPose, guiGraphics, i + 3, i2 + 3, C0248dw.f2042hx, 159);
            C0129bt.m531a(poseStackPose, guiGraphics, C0232dg.f1878bd, i, i2, 120, C0232dg.f1869gH);
            C0109bZ c0109bZM1039a = C0129bt.f871a.m1039a(minecraft, c0555jlA.m2522a());
            if (c0109bZM1039a != null) {
                int i3 = i + 60;
                C0129bt.m595a(c0396gl, poseStackPose, guiGraphics, minecraft, (LivingEntity) c0109bZM1039a, i3, i2 + 82 + C0232dg.f1871gJ, 120.0f, C0232dg.f1872dO, C0232dg.f1873dP, 0.0f, f);
                poseStackPose.pushPose();
                poseStackPose.translate(0.0f, 0.0f, 1000.0f);
                C0129bt.m523a(guiGraphics, i, (i2 + C0232dg.f1869gH) - 50, 120, 50, ColorReferences.COLOR_BLACK_TRANSPARENT, ColorReferences.COLOR_BLACK_SOLID);
                C0129bt.m491b(poseStackPose, font, guiGraphics, (Component) Component.literal(c0555jlA.getUsername()).withStyle(C0533jP.f3185b), i3, (i2 + C0232dg.f1869gH) - 45, 1.5f);
                C0129bt.m494c(poseStackPose, font, guiGraphics, (Component) Component.literal(C1273xM.m7244p(rank.getTitle())).withStyle(ChatFormatting.GRAY), i3, (i2 + C0232dg.f1869gH) - 29, 1.0f);
                poseStackPose.popPose();
            }
            guiGraphics.disableScissor();
            poseStackPose.pushPose();
            poseStackPose.translate(0.0f, 0.0f, 1000.0f);
            int i4 = 2;
            int prestigeLevel = c0555jlA.getPrestigeLevel();
            boolean z2 = prestigeLevel > 0;
            if (z2) {
                i4 = 2 + 1;
            }
            int i5 = ((i + 60) - (((32 * i4) + (16 * (i4 - 1))) / 2)) + 16;
            int i6 = (i2 + C0232dg.f1869gH) - 1;
            C0129bt.m539b(poseStackPose, guiGraphics, f1884bf, i5, i6, 32);
            C0129bt.m539b(poseStackPose, guiGraphics, C0532jO.m2378d("textures/misc/ranks/" + rank.getTexture() + ".png"), i5, i6, 32);
            int i7 = i5 + 32 + 16;
            C0129bt.m539b(poseStackPose, guiGraphics, f1884bf, i7, i6, 32);
            C0129bt.m482c(poseStackPose, font, guiGraphics, (Component) Component.literal(C1273xM.m7239b(this.f1886gL)).withColor(ColorReferences.COLOR_STOPWATCH), i7, i6 - 3);
            if (z2) {
                int i8 = i5 + 96;
                C0129bt.m539b(poseStackPose, guiGraphics, f1884bf, i8, i6, 32);
                C0129bt.m482c(poseStackPose, font, guiGraphics, (Component) Component.literal("P" + prestigeLevel).withColor(9633658), i8, i6 - 3);
            }
            CloudItemStack cloudItemStackM2487a = inventory.m2487a(CloudItemType.COIN);
            CloudRegistry cloudRegistryA = c0623l.m2855a();
            if (cloudItemStackM2487a != null) {
                CloudItem<?> cloudItem = cloudItemStackM2487a.getCloudItem(cloudRegistryA);
                if (cloudItem instanceof AbstractCloudItemCoin) {
                    AbstractCloudItemCoin abstractCloudItemCoin = (AbstractCloudItemCoin) cloudItem;
                    C0564ju.m2556a(abstractCloudItemCoin).mo2310a(abstractCloudItemCoin, cloudItemStackM2487a, poseStackPose, minecraft, guiGraphics, i, i2, 16.0f, 16.0f, 1.0f);
                }
            }
            poseStackPose.popPose();
        }
    }
}
