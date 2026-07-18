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

/* JADX INFO: renamed from: com.boehmod.blockfront.cX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cX.class */
public class C0159cX extends AbstractC0156cU {

    /* JADX INFO: renamed from: fE */
    private static final int f1295fE = 200;

    /* JADX INFO: renamed from: fF */
    private static final int f1296fF = 30;

    /* JADX INFO: renamed from: fG */
    private static final int f1297fG = 120;

    /* JADX INFO: renamed from: fH */
    private static final int f1298fH = 165;

    /* JADX INFO: renamed from: fI */
    private static final int f1299fI = 10;

    /* JADX INFO: renamed from: fJ */
    private static final int f1300fJ = 170;

    /* JADX INFO: renamed from: dL */
    private static final float f1301dL = -5.0f;

    /* JADX INFO: renamed from: dM */
    private static final float f1302dM = -15.0f;

    /* JADX INFO: renamed from: dv */
    private static final Component f1303dv = Component.translatable("bf.message.game.match.summary.top.subtitle").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: dw */
    private static final Component f1304dw = Component.translatable("bf.message.game.match.summary.top.subtitle.tip");

    /* JADX INFO: renamed from: dx */
    private static final Component f1305dx = Component.translatable("bf.message.game.match.summary.top.title").withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: be */
    @NotNull
    private static final ResourceLocation f1306be = C0564jv.m2555d("textures/gui/backshadow.png");

    /* JADX INFO: renamed from: bf */
    @NotNull
    private static final ResourceLocation f1307bf = C0564jv.m2555d("textures/gui/cornershadow.png");

    /* JADX INFO: renamed from: bg */
    @NotNull
    private static final ResourceLocation f1308bg = C0564jv.m2555d("textures/gui/game/summary/top_player_background.png");

    /* JADX INFO: renamed from: e */
    @NotNull
    private final Set<UUID> f1309e;

    /* JADX INFO: renamed from: x */
    @NotNull
    private final ObjectList<a> f1310x;

    /* JADX INFO: renamed from: fK */
    private int f1311fK;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C1088to f1312b;

    public C0159cX(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull C1088to c1088to) {
        super(abstractC0787oF.m3628e());
        this.f1309e = new LinkedHashSet();
        this.f1310x = new ObjectArrayList();
        this.f1311fK = 0;
        ObjectArrayList objectArrayList = new ObjectArrayList(C0799oR.m3952a(abstractC0787oF, 3, c1088to, abstractC0787oF.m3582b().m3809h()));
        Collections.reverse(objectArrayList);
        this.f1309e.addAll(objectArrayList);
        this.f1312b = c1088to;
    }

    @Override // com.boehmod.blockfront.AbstractC0156cU, com.boehmod.blockfront.C0195cx
    public void tick() {
        SoundEvent soundEvent;
        super.tick();
        ObjectListIterator it = this.f1310x.iterator();
        while (it.hasNext()) {
            ((a) it.next()).tick();
        }
        int i = this.f1311fK;
        this.f1311fK = i + 1;
        if (i >= 30 && !this.f1309e.isEmpty()) {
            this.f1311fK = 0;
            AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = this.f1586e.m2688a();
            Iterator<UUID> it2 = this.f1309e.iterator();
            if (it2.hasNext()) {
                UUID next = it2.next();
                it2.remove();
                int iM4009a = 0;
                if (abstractC0787oFM2688a != null) {
                    iM4009a = C0799oR.m4009a(abstractC0787oFM2688a, next, this.f1312b);
                }
                boolean zIsEmpty = this.f1309e.isEmpty();
                this.f1310x.add(new a(next, iM4009a));
                if (zIsEmpty) {
                    soundEvent = (SoundEvent) C1280xc.f7535oS.get();
                } else {
                    soundEvent = (SoundEvent) C1280xc.f7534oR.get();
                }
                this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI(soundEvent, 1.0f));
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0156cU, com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        int size = (this.width / 2) - (((120 * this.f1310x.size()) + (10 * (this.f1310x.size() - 1))) / 2);
        int i3 = this.height / 2;
        int size2 = this.f1310x.size();
        int i4 = 0;
        ObjectListIterator it = this.f1310x.iterator();
        while (it.hasNext()) {
            ((a) it.next()).m996a(this.f1587b, this.f1586e, guiGraphics, this.font, size + (i4 * 130), i3 - 82, i4 == size2 - 1, f);
            i4++;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0156cU
    @NotNull
    /* JADX INFO: renamed from: a */
    protected SoundEvent mo982a() {
        return (SoundEvent) C1280xc.f7533oQ.get();
    }

    @Override // com.boehmod.blockfront.AbstractC0156cU
    /* JADX INFO: renamed from: G */
    protected int mo983G() {
        return 200;
    }

    @Override // com.boehmod.blockfront.AbstractC0156cU
    @NotNull
    /* JADX INFO: renamed from: g */
    protected Component mo984g() {
        return f1305dx;
    }

    @Override // com.boehmod.blockfront.AbstractC0156cU
    @NotNull
    /* JADX INFO: renamed from: h */
    protected Component mo985h() {
        return f1303dv;
    }

    @Override // com.boehmod.blockfront.AbstractC0156cU
    @NotNull
    /* JADX INFO: renamed from: i */
    protected Component mo986i() {
        return f1304dw;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.cX$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cX$a.class */
    public static final class a {

        /* JADX INFO: renamed from: bh */
        @NotNull
        private static final ResourceLocation f1313bh = C0564jv.m2555d("textures/gui/game/summary/top_player_stat_background.png");

        /* JADX INFO: renamed from: f */
        private final UUID f1314f;

        /* JADX INFO: renamed from: fL */
        private final int f1315fL;

        /* JADX INFO: renamed from: db */
        private float f1316db = 1.0f;

        /* JADX INFO: renamed from: dc */
        private float f1317dc = 1.0f;

        public a(@NotNull UUID uuid, int i) {
            this.f1314f = uuid;
            this.f1315fL = i;
        }

        private void tick() {
            this.f1317dc = this.f1316db;
            this.f1316db = Mth.clamp(this.f1316db + 0.1f, 0.0f, 0.5f);
        }

        /* JADX INFO: renamed from: a */
        private void m996a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, boolean z, float f) {
            C0326fV c0326fV = (C0326fV) c0622l.m2670a();
            PoseStack poseStackPose = guiGraphics.pose();
            C0119bk.m491c(guiGraphics, i, i2, 120, C0159cX.f1298fH, C0119bk.m365p());
            C0119bk.m517a(guiGraphics, i, i2, 120, C0159cX.f1298fH);
            C0119bk.m433a(poseStackPose, guiGraphics, C0159cX.f1308bg, i, i2, 120, C0159cX.f1298fH, 0.4f);
            C0119bk.m417a(guiGraphics, i, i2, 120, C0159cX.f1298fH, ColorReferences.COLOR_TEAM_ALLIES_SOLID, 0.25f);
            C0482iS c0482iSA = c0326fV.mo1137a(this.f1314f);
            PlayerRank rank = c0482iSA.getRank();
            C0477iN inventory = c0482iSA.getInventory();
            if (z) {
                C0119bk.m417a(guiGraphics, i, i2, 120, C0159cX.f1298fH, ColorReferences.COLOR_WHITE_SOLID, C1290xm.m7843e(this.f1316db, this.f1317dc, f));
            }
            C0119bk.m439b(poseStackPose, guiGraphics, C0159cX.f1306be, i + 60, i2 + 82, 150);
            C0119bk.m367a(poseStackPose, guiGraphics, i + 3, i2 + 3, C0238dn.f1978gs, 159);
            C0119bk.m431a(poseStackPose, guiGraphics, C0159cX.f1307bf, i, i2, 120, C0159cX.f1298fH);
            C0099bQ c0099bQM316a = C0119bk.f736a.m316a(minecraft, c0482iSA.m2195a());
            if (c0099bQM316a != null) {
                int i3 = i + 60;
                C0119bk.m495a(c0326fV, poseStackPose, guiGraphics, minecraft, (LivingEntity) c0099bQM316a, i3, i2 + 82 + C0159cX.f1300fJ, 120.0f, C0159cX.f1301dL, C0159cX.f1302dM, 0.0f, f);
                poseStackPose.pushPose();
                poseStackPose.translate(0.0f, 0.0f, 1000.0f);
                C0119bk.m423a(guiGraphics, i, (i2 + C0159cX.f1298fH) - 50, 120, 50, ColorReferences.COLOR_BLACK_TRANSPARENT, ColorReferences.COLOR_BLACK_SOLID);
                C0119bk.m391b(poseStackPose, font, guiGraphics, (Component) Component.literal(c0482iSA.getUsername()).withStyle(C0565jw.f3201b), i3, (i2 + C0159cX.f1298fH) - 45, 1.5f);
                C0119bk.m394c(poseStackPose, font, guiGraphics, (Component) Component.literal(C1293xp.m7917p(rank.getTitle())).withStyle(ChatFormatting.GRAY), i3, (i2 + C0159cX.f1298fH) - 29, 1.0f);
                poseStackPose.popPose();
            }
            guiGraphics.disableScissor();
            poseStackPose.pushPose();
            poseStackPose.translate(0.0f, 0.0f, 1000.0f);
            int i4 = 2;
            int prestigeLevel = c0482iSA.getPrestigeLevel();
            boolean z2 = prestigeLevel > 0;
            if (z2) {
                i4 = 2 + 1;
            }
            int i5 = ((i + 60) - (((32 * i4) + (16 * (i4 - 1))) / 2)) + 16;
            int i6 = (i2 + C0159cX.f1298fH) - 1;
            C0119bk.m439b(poseStackPose, guiGraphics, f1313bh, i5, i6, 32);
            C0119bk.m439b(poseStackPose, guiGraphics, C0564jv.m2555d("textures/misc/ranks/" + rank.getTexture() + ".png"), i5, i6, 32);
            int i7 = i5 + 32 + 16;
            C0119bk.m439b(poseStackPose, guiGraphics, f1313bh, i7, i6, 32);
            C0119bk.m382c(poseStackPose, font, guiGraphics, (Component) Component.literal(C1293xp.m7912a(this.f1315fL)).withColor(ColorReferences.COLOR_STOPWATCH), i7, i6 - 3);
            if (z2) {
                int i8 = i5 + 96;
                C0119bk.m439b(poseStackPose, guiGraphics, f1313bh, i8, i6, 32);
                C0119bk.m382c(poseStackPose, font, guiGraphics, (Component) Component.literal("P" + prestigeLevel).withColor(9633658), i8, i6 - 3);
            }
            CloudItemStack cloudItemStackM2160a = inventory.m2160a(CloudItemType.COIN);
            CloudRegistry cloudRegistryA = c0622l.m2670a();
            if (cloudItemStackM2160a != null) {
                CloudItem<?> cloudItem = cloudItemStackM2160a.getCloudItem(cloudRegistryA);
                if (cloudItem instanceof AbstractCloudItemCoin) {
                    AbstractCloudItemCoin abstractCloudItemCoin = (AbstractCloudItemCoin) cloudItem;
                    C0544jb.m2468a(abstractCloudItemCoin).mo2466a(abstractCloudItemCoin, cloudItemStackM2160a, poseStackPose, minecraft, guiGraphics, i, i2, 16.0f, 16.0f, 1.0f);
                }
            }
            poseStackPose.popPose();
        }
    }
}
