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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cX.class */
public class cX extends cU {
    private static final int fE = 200;
    private static final int fF = 30;
    private static final int fG = 120;
    private static final int fH = 165;
    private static final int fI = 10;
    private static final int fJ = 170;
    private static final float dL = -5.0f;
    private static final float dM = -15.0f;
    private static final Component dv = Component.translatable("bf.message.game.match.summary.top.subtitle").withStyle(ChatFormatting.BOLD);
    private static final Component dw = Component.translatable("bf.message.game.match.summary.top.subtitle.tip");
    private static final Component dx = Component.translatable("bf.message.game.match.summary.top.title").withStyle(C0266jw.b);

    @NotNull
    private static final ResourceLocation be = C0265jv.d("textures/gui/backshadow.png");

    @NotNull
    private static final ResourceLocation bf = C0265jv.d("textures/gui/cornershadow.png");

    @NotNull
    private static final ResourceLocation bg = C0265jv.d("textures/gui/game/summary/top_player_background.png");

    @NotNull
    private final Set<UUID> e;

    @NotNull
    private final ObjectList<a> x;
    private int fK;

    @NotNull
    private final C0528to b;

    public cX(@NotNull oF<?, ?, ?> oFVar, @NotNull C0528to c0528to) {
        super(oFVar.m757e());
        this.e = new LinkedHashSet();
        this.x = new ObjectArrayList();
        this.fK = 0;
        ObjectArrayList objectArrayList = new ObjectArrayList(oR.a(oFVar, 3, c0528to, oFVar.b().h()));
        Collections.reverse(objectArrayList);
        this.e.addAll(objectArrayList);
        this.b = c0528to;
    }

    @Override // com.boehmod.blockfront.cU, com.boehmod.blockfront.C0080cx
    public void tick() {
        SoundEvent soundEvent;
        super.tick();
        ObjectListIterator it = this.x.iterator();
        while (it.hasNext()) {
            ((a) it.next()).tick();
        }
        int i = this.fK;
        this.fK = i + 1;
        if (i >= 30 && !this.e.isEmpty()) {
            this.fK = 0;
            oF<?, ?, ?> oFVarM591a = this.e.m591a();
            Iterator<UUID> it2 = this.e.iterator();
            if (it2.hasNext()) {
                UUID next = it2.next();
                it2.remove();
                int iA = 0;
                if (oFVarM591a != null) {
                    iA = oR.a(oFVarM591a, next, this.b);
                }
                boolean zIsEmpty = this.e.isEmpty();
                this.x.add(new a(next, iA));
                if (zIsEmpty) {
                    soundEvent = (SoundEvent) C0624xc.oS.get();
                } else {
                    soundEvent = (SoundEvent) C0624xc.oR.get();
                }
                this.b.getSoundManager().play(SimpleSoundInstance.forUI(soundEvent, 1.0f));
            }
        }
    }

    @Override // com.boehmod.blockfront.cU, com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        int size = (this.width / 2) - (((120 * this.x.size()) + (10 * (this.x.size() - 1))) / 2);
        int i3 = this.height / 2;
        int size2 = this.x.size();
        int i4 = 0;
        ObjectListIterator it = this.x.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(this.b, this.e, guiGraphics, this.font, size + (i4 * 130), i3 - 82, i4 == size2 - 1, f);
            i4++;
        }
    }

    @Override // com.boehmod.blockfront.cU
    @NotNull
    protected SoundEvent a() {
        return (SoundEvent) C0624xc.oQ.get();
    }

    @Override // com.boehmod.blockfront.cU
    protected int G() {
        return 200;
    }

    @Override // com.boehmod.blockfront.cU
    @NotNull
    protected Component g() {
        return dx;
    }

    @Override // com.boehmod.blockfront.cU
    @NotNull
    protected Component h() {
        return dv;
    }

    @Override // com.boehmod.blockfront.cU
    @NotNull
    protected Component i() {
        return dw;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cX$a.class */
    public static final class a {

        @NotNull
        private static final ResourceLocation bh = C0265jv.d("textures/gui/game/summary/top_player_stat_background.png");
        private final UUID f;
        private final int fL;
        private float db = 1.0f;
        private float dc = 1.0f;

        public a(@NotNull UUID uuid, int i) {
            this.f = uuid;
            this.fL = i;
        }

        private void tick() {
            this.dc = this.db;
            this.db = Mth.clamp(this.db + 0.1f, 0.0f, 0.5f);
        }

        private void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, boolean z, float f) {
            fV fVVar = (fV) c0297l.a();
            PoseStack poseStackPose = guiGraphics.pose();
            C0040bk.c(guiGraphics, i, i2, 120, cX.fH, C0040bk.p());
            C0040bk.a(guiGraphics, i, i2, 120, cX.fH);
            C0040bk.a(poseStackPose, guiGraphics, cX.bg, i, i2, 120, cX.fH, 0.4f);
            C0040bk.a(guiGraphics, i, i2, 120, cX.fH, ColorReferences.COLOR_TEAM_ALLIES_SOLID, 0.25f);
            iS iSVarA = fVVar.mo306a(this.f);
            PlayerRank rank = iSVarA.getRank();
            iN inventory = iSVarA.getInventory();
            if (z) {
                C0040bk.a(guiGraphics, i, i2, 120, cX.fH, ColorReferences.COLOR_WHITE_SOLID, C0634xm.e(this.db, this.dc, f));
            }
            C0040bk.b(poseStackPose, guiGraphics, cX.be, i + 60, i2 + 82, 150);
            C0040bk.a(poseStackPose, guiGraphics, i + 3, i2 + 3, C0097dn.gs, 159);
            C0040bk.a(poseStackPose, guiGraphics, cX.bf, i, i2, 120, cX.fH);
            bQ bQVarA = C0040bk.a.a(minecraft, iSVarA.m491a());
            if (bQVarA != null) {
                int i3 = i + 60;
                C0040bk.a(fVVar, poseStackPose, guiGraphics, minecraft, (LivingEntity) bQVarA, i3, i2 + 82 + cX.fJ, 120.0f, cX.dL, cX.dM, 0.0f, f);
                poseStackPose.pushPose();
                poseStackPose.translate(0.0f, 0.0f, 1000.0f);
                C0040bk.a(guiGraphics, i, (i2 + cX.fH) - 50, 120, 50, ColorReferences.COLOR_BLACK_TRANSPARENT, ColorReferences.COLOR_BLACK_SOLID);
                C0040bk.b(poseStackPose, font, guiGraphics, (Component) Component.literal(iSVarA.getUsername()).withStyle(C0266jw.b), i3, (i2 + cX.fH) - 45, 1.5f);
                C0040bk.c(poseStackPose, font, guiGraphics, (Component) Component.literal(C0637xp.p(rank.getTitle())).withStyle(ChatFormatting.GRAY), i3, (i2 + cX.fH) - 29, 1.0f);
                poseStackPose.popPose();
            }
            guiGraphics.disableScissor();
            poseStackPose.pushPose();
            poseStackPose.translate(0.0f, 0.0f, 1000.0f);
            int i4 = 2;
            int prestigeLevel = iSVarA.getPrestigeLevel();
            boolean z2 = prestigeLevel > 0;
            if (z2) {
                i4 = 2 + 1;
            }
            int i5 = ((i + 60) - (((32 * i4) + (16 * (i4 - 1))) / 2)) + 16;
            int i6 = (i2 + cX.fH) - 1;
            C0040bk.b(poseStackPose, guiGraphics, bh, i5, i6, 32);
            C0040bk.b(poseStackPose, guiGraphics, C0265jv.d("textures/misc/ranks/" + rank.getTexture() + ".png"), i5, i6, 32);
            int i7 = i5 + 32 + 16;
            C0040bk.b(poseStackPose, guiGraphics, bh, i7, i6, 32);
            C0040bk.c(poseStackPose, font, guiGraphics, (Component) Component.literal(C0637xp.a(this.fL)).withColor(ColorReferences.COLOR_STOPWATCH), i7, i6 - 3);
            if (z2) {
                int i8 = i5 + 96;
                C0040bk.b(poseStackPose, guiGraphics, bh, i8, i6, 32);
                C0040bk.c(poseStackPose, font, guiGraphics, (Component) Component.literal("P" + prestigeLevel).withColor(9633658), i8, i6 - 3);
            }
            CloudItemStack cloudItemStackA = inventory.a(CloudItemType.COIN);
            CloudRegistry cloudRegistryA = c0297l.a();
            if (cloudItemStackA != null) {
                CloudItem<?> cloudItem = cloudItemStackA.getCloudItem(cloudRegistryA);
                if (cloudItem instanceof AbstractCloudItemCoin) {
                    AbstractCloudItemCoin abstractCloudItemCoin = (AbstractCloudItemCoin) cloudItem;
                    C0245jb.a(abstractCloudItemCoin).a(abstractCloudItemCoin, cloudItemStackA, poseStackPose, minecraft, guiGraphics, i, i2, 16.0f, 16.0f, 1.0f);
                }
            }
            poseStackPose.popPose();
        }
    }
}
