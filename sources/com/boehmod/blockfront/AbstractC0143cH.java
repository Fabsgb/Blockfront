package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PlayerRank;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.AbstractC0788oG;
import com.boehmod.blockfront.C0127bs;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cH.class */
public abstract class AbstractC0143cH<G extends AbstractC0787oF<G, ?, ?>, C extends AbstractC0788oG<G, ?>> extends C0195cx {

    /* JADX INFO: renamed from: el */
    protected static final int f1103el = 110;

    /* JADX INFO: renamed from: em */
    protected static final int f1104em = 20;

    /* JADX INFO: renamed from: en */
    protected static final int f1105en = 100;

    /* JADX INFO: renamed from: eo */
    protected static final int f1106eo = 160;

    /* JADX INFO: renamed from: ep */
    protected static final int f1107ep = 39;

    /* JADX INFO: renamed from: eq */
    protected static final int f1108eq = 140;

    /* JADX INFO: renamed from: b */
    @NotNull
    protected final C0796oO f1110b;

    /* JADX INFO: renamed from: b */
    @NotNull
    protected final G f1111b;

    /* JADX INFO: renamed from: b */
    @NotNull
    protected final C f1112b;

    /* JADX INFO: renamed from: g */
    @Nullable
    protected final Screen f1113g;

    /* JADX INFO: renamed from: a */
    @Nullable
    protected AbstractC0223dY<C0145cJ> f1114a;

    /* JADX INFO: renamed from: a */
    @Nullable
    protected C0145cJ f1115a;

    /* JADX INFO: renamed from: cM */
    @Nullable
    protected Component f1116cM;

    /* JADX INFO: renamed from: er */
    protected int f1117er;

    /* JADX INFO: renamed from: cE */
    private static final Component f1092cE = Component.translatable("bf.screen.ingame.select.class");

    /* JADX INFO: renamed from: cF */
    private static final Component f1093cF = Component.translatable("bf.message.select.class");

    /* JADX INFO: renamed from: aX */
    private static final ResourceLocation f1094aX = C0564jv.m2555d("textures/gui/game/loadout/required_rank.png");

    /* JADX INFO: renamed from: aY */
    private static final ResourceLocation f1095aY = C0564jv.m2555d("textures/gui/menu/icons/friends.png");

    /* JADX INFO: renamed from: aZ */
    private static final ResourceLocation f1096aZ = C0564jv.m2555d("textures/gui/game/loadout/required_exp.png");

    /* JADX INFO: renamed from: cG */
    private static final Component f1097cG = Component.translatable("bf.message.select.class.tip.click.left").withStyle(ChatFormatting.GRAY);

    /* JADX INFO: renamed from: cH */
    private static final Component f1098cH = Component.translatable("bf.message.select.class.tip.click.right").withStyle(ChatFormatting.GRAY);

    /* JADX INFO: renamed from: cI */
    private static final Component f1099cI = Component.translatable("bf.message.select.class.tip", new Object[]{f1097cG, f1098cH}).withStyle(ChatFormatting.DARK_GRAY);

    /* JADX INFO: renamed from: cJ */
    private static final Component f1100cJ = Component.literal("< ").append(Component.translatable("bf.menu.button.back"));

    /* JADX INFO: renamed from: cK */
    private static final Component f1101cK = Component.translatable("bf.message.selected");

    /* JADX INFO: renamed from: cL */
    private static final Component f1102cL = Component.translatable("bf.message.class");

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final MutableComponent f1109b = Component.translatable("bf.daily_challenge.eligible").withStyle(ChatFormatting.BOLD).withColor(ColorReferences.COLOR_THEME_YELLOW);

    /* JADX INFO: renamed from: a */
    public abstract void mo797a(@NotNull C0145cJ c0145cJ);

    public AbstractC0143cH(@Nullable Screen screen, @NotNull G g, @NotNull C c, @NotNull C0796oO c0796oO) {
        super(f1092cE);
        this.f1115a = null;
        this.f1116cM = null;
        this.f1117er = 0;
        this.f1113g = screen;
        this.f1110b = c0796oO;
        this.f1111b = g;
        this.f1112b = c;
    }

    /* JADX INFO: renamed from: b */
    public void m790b(@NotNull Component component) {
        this.f1116cM = component;
        this.f1117er = 60;
    }

    /* JADX INFO: renamed from: Q */
    public void m791Q() {
        this.f1587b.setScreen(this.f1113g);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0145cJ m792a() {
        return this.f1115a;
    }

    /* JADX INFO: renamed from: a */
    public void m793a(@NotNull C1015sV c1015sV, @NotNull ObjectList<C0866pf> objectList, @NotNull String[] strArr, int i) {
        if (this.f1114a == null) {
            return;
        }
        this.f1114a.m1316a(new C0145cJ(this, c1015sV, objectList, strArr, 110, 20, i));
    }

    /* JADX INFO: renamed from: a */
    private void m794a(@NotNull LocalPlayer localPlayer, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, int i, int i2, int i3, int i4, float f, float f2) {
        AbstractC0788oG<?, ?> abstractC0788oGM2692a;
        C0796oO c0796oOM3793a;
        if (this.f1115a == null) {
            return;
        }
        C0866pf c0866pfM801a = this.f1115a.m801a();
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        C0099bQ c0099bQM315a = C0119bk.f736a.m315a(this.f1587b);
        if (!c0866pfM801a.m4339c().isEmpty()) {
            c0099bQM315a.setItemInHand(InteractionHand.MAIN_HAND, c0866pfM801a.m4339c());
        }
        C0119bk.m517a(guiGraphics, i3 + m798x(), i4, 100, f1106eo);
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = this.f1586e.m2688a();
        if (abstractC0787oFM2688a == null || (abstractC0788oGM2692a = this.f1586e.m2692a()) == null || (c0796oOM3793a = abstractC0787oFM2688a.m3582b().m3793a(localPlayer.getUUID())) == null) {
            return;
        }
        C0482iS c0482iSM1676a = this.f1585a.m1676a(this.f1587b);
        C0119bk.m445b(poseStack, guiGraphics, c0796oOM3793a.m3860a(abstractC0787oFM2688a).m5976a().m5670N(), i3 + 50, (i4 + 80) - 10, 85, 85, 0.0f, 0.5f);
        C0119bk.m441b(poseStack, guiGraphics, C0195cx.f1566aJ, i3 + 50, i4 + 80 + 20, 100, 100);
        C0119bk.m441b(poseStack, guiGraphics, C0195cx.f1566aJ, i3 + 50, i4 + 80 + 20, 100, 100);
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, 100.0f);
        C0119bk.m494a(this.f1585a, poseStack, guiGraphics, this.f1587b, (LivingEntity) c0099bQM315a, i3 + 50, i4 + f1106eo + 60, 90.0f, 5.0f * Mth.sin(f / 40.0f), (-(6 * (c0866pfM801a.hashCode() % 5))) + (15.0f * Mth.sin(f / 50.0f)), f2);
        poseStack.popPose();
        guiGraphics.disableScissor();
        c0099bQM315a.setItemInHand(InteractionHand.MAIN_HAND, mainHandItem);
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, 200.0f);
        m795a(poseStack, guiGraphics, c0796oOM3793a, i, i2, i3, i4);
        m796a(poseStack, guiGraphics, abstractC0788oGM2692a, localPlayer, c0482iSM1676a, c0866pfM801a, i3, i4);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    private void m795a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull C0796oO c0796oO, int i, int i2, int i3, int i4) {
        MutableComponent mutableComponentTranslatable;
        if (this.f1115a == null) {
            return;
        }
        C0119bk.m423a(guiGraphics, i3, i4 + 100, 100, 60, ColorReferences.COLOR_BLACK_TRANSPARENT, ColorReferences.COLOR_BLACK_SOLID);
        C0119bk.m370a(this.font, guiGraphics, (Component) Component.translatable(this.f1115a.m805a().m5516al()).withStyle(ChatFormatting.BOLD).withStyle(c0796oO.m3876a()), i - 20, i2 - 65);
        G g = this.f1111b;
        boolean z = (g instanceof InterfaceC0902qO) && ((InterfaceC0902qO) g).mo4669by();
        int i5 = z ? -15 : 0;
        ObjectList<String> objectListM2131a = C0471iH.m2131a(this.font, C0471iH.m2130a((List<String>) new ObjectArrayList(Arrays.asList(this.f1115a.m804a()))), AbstractC0211dM.f1737gZ);
        int size = objectListM2131a.size();
        int i6 = i - 22;
        int i7 = i4 + f1106eo;
        poseStack.pushPose();
        poseStack.translate(0.0f, i5 - (size * 5), 0.0f);
        if (this.f1115a.m808u()) {
            C0119bk.m387a(poseStack, this.font, guiGraphics, (Component) f1109b, i6, i7 - 6, 0.5f);
        }
        for (int i8 = 0; i8 < size; i8++) {
            C0119bk.m387a(poseStack, this.font, guiGraphics, (Component) Component.literal((String) objectListM2131a.get(i8)), i6, i7 + (i8 * 5), 0.5f);
        }
        poseStack.popPose();
        int i9 = i - 22;
        int i10 = i2 + 64;
        G g2 = this.f1111b;
        if (g2 instanceof InterfaceC0902qO) {
            InterfaceC0902qO interfaceC0902qO = (InterfaceC0902qO) g2;
            if (z) {
                MutableComponent mutableComponentWithStyle = Component.literal(String.valueOf(this.f1115a.m803y())).withStyle(ChatFormatting.WHITE);
                int iMo4673a = interfaceC0902qO.mo4673a(this.f1115a.m805a());
                if (iMo4673a > 0) {
                    mutableComponentTranslatable = Component.translatable("bf.message.class.limit", new Object[]{mutableComponentWithStyle, Component.literal(String.valueOf(iMo4673a)).withStyle(ChatFormatting.WHITE)});
                } else {
                    mutableComponentTranslatable = mutableComponentWithStyle;
                }
                C0119bk.m370a(this.font, guiGraphics, (Component) mutableComponentTranslatable, i9 + 18, i10 + 4);
                C0119bk.m431a(poseStack, guiGraphics, f1095aY, i9, i10, 16, 16);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m796a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull AbstractC0788oG<?, ?> abstractC0788oG, @NotNull LocalPlayer localPlayer, C0482iS c0482iS, @NotNull C0866pf c0866pf, int i, int i2) {
        C1015sV c1015sVM805a;
        if (this.f1115a == null) {
            return;
        }
        G g = this.f1111b;
        if (!(g instanceof InterfaceC0902qO)) {
            return;
        }
        InterfaceC0902qO interfaceC0902qO = (InterfaceC0902qO) g;
        if (abstractC0788oG.m3740bm() && (c1015sVM805a = this.f1115a.m805a()) != null) {
            int i3 = 0;
            if (interfaceC0902qO.mo4671bA()) {
                PlayerRank playerRankM5524a = c1015sVM805a.m5524a();
                boolean zM5525a = c1015sVM805a.m5525a(this.f1585a, localPlayer);
                if (playerRankM5524a != PlayerRank.RECRUIT && !zM5525a) {
                    MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.selected.required.rank", new Object[]{c1015sVM805a.m5524a().getTitle()}).withColor(0).withStyle(ChatFormatting.BOLD);
                    int i4 = i + 1;
                    int i5 = i2 + f1106eo;
                    C0119bk.m491c(guiGraphics, i4, i5, 98, 8, ColorReferences.COLOR_THEME_YELLOW_SOLID);
                    C0119bk.m391b(poseStack, this.font, guiGraphics, (Component) mutableComponentWithStyle, i4 + 49 + 3, i5 + 2, 0.5f);
                    C0119bk.m431a(poseStack, guiGraphics, f1094aX, i4 + 1, i5 + 1, 6, 6);
                    i3 = 0 + 8;
                }
            }
            int iM4333bl = c0866pf.m4333bl();
            if (interfaceC0902qO.mo4670bz() && iM4333bl != 0) {
                int expForClass = c0482iS.getExpForClass(c1015sVM805a.m5523bN());
                String strM7912a = C1293xp.m7912a(expForClass);
                String strM7912a2 = C1293xp.m7912a(iM4333bl);
                int i6 = expForClass >= iM4333bl ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_BLACK_SOLID + C0119bk.f726bC;
                MutableComponent mutableComponentWithStyle2 = Component.literal(strM7912a + " / " + strM7912a2 + " EXP").withColor(0).withStyle(ChatFormatting.BOLD);
                int i7 = i + 1;
                int i8 = i2 + f1106eo + i3;
                C0119bk.m491c(guiGraphics, i7, i8, 98, 15, i6);
                C0119bk.m391b(poseStack, this.font, guiGraphics, (Component) mutableComponentWithStyle2, i7 + 49 + 6, i8 + 2, 0.5f);
                C0119bk.m431a(poseStack, guiGraphics, f1096aZ, i7 + 1, i8 + 1, 13, 13);
                int i9 = (i8 + 15) - 7;
                int i10 = ((i7 + 49) - 35) + 6;
                C0119bk.m415a(guiGraphics, i10, i9, 70, 4, ColorReferences.COLOR_BLACK_SOLID);
                C0119bk.m417a(guiGraphics, i10 + 1, i9 + 1, 68, 2, ColorReferences.COLOR_WHITE_SOLID, 0.4f);
                C0119bk.m414a(poseStack, guiGraphics, i10 + 1, i9 + 1, 68.0f * (Mth.clamp(expForClass, 0, iM4333bl) / iM4333bl), 2.0f, ColorReferences.COLOR_WHITE_SOLID);
            }
        }
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: E */
    public void mo775E() {
        super.mo775E();
        int i = this.width / 2;
        int i2 = this.height / 2;
        this.f1114a = new C0224dZ(((i - 110) - 30) + m798x(), i2 - 80, 110, 159, this);
        this.f1114a.m1313a(true);
        m1195a(this.f1114a.m684b());
    }

    @Override // com.boehmod.blockfront.C0195cx
    public void init() {
        super.init();
        addRenderableWidget(new C0127bs((this.width / 2) - 150, 18, 40, 10, f1100cJ, button -> {
            m791Q();
        }).m653a(C0127bs.a.NONE));
    }

    @Override // com.boehmod.blockfront.C0195cx
    public boolean keyPressed(int i, int i2, int i3) {
        m791Q();
        return true;
    }

    @Override // com.boehmod.blockfront.C0195cx
    public void tick() {
        super.tick();
        if (this.f1586e.m2709a().m3241ay()) {
            this.f1587b.setScreen((Screen) null);
        } else if (this.f1117er > 0) {
            this.f1117er--;
        }
    }

    @Override // com.boehmod.blockfront.C0195cx
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int iM365p = C0119bk.m365p();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        C0119bk.m491c(guiGraphics, 0, 0, this.width, 30, iM365p);
        C0119bk.m491c(guiGraphics, 0, this.height - 30, this.width, 30, iM365p);
        C0119bk.m383c(this.font, guiGraphics, f1099cI, this.width / 2, this.height - 20);
        poseStackPose.pushPose();
        poseStackPose.translate(m798x(), 0.0f, 0.0f);
        C0119bk.m491c(guiGraphics, (i3 - 110) - 30, i4 - 80, 110, f1106eo, iM365p);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        LocalPlayer localPlayer = this.f1587b.player;
        if (localPlayer == null) {
            return;
        }
        C0482iS c0482iSM1676a = this.f1585a.m1676a(this.f1587b);
        float fM366g = C0119bk.m366g();
        PoseStack poseStackPose = guiGraphics.pose();
        int iM365p = C0119bk.m365p();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        if (this.f1117er > 0 && this.f1116cM != null) {
            List listSplit = this.font.split(this.f1116cM, 220);
            int size = listSplit.size();
            int i5 = 10 - size;
            for (int i6 = 0; i6 < size; i6++) {
                guiGraphics.drawString(this.font, (FormattedCharSequence) listSplit.get(i6), (int) (i3 - (this.font.width(r0) / 2.0f)), i5 + (i6 * 10), ColorReferences.COLOR_WHITE);
            }
        } else {
            C0119bk.m391b(poseStackPose, this.font, guiGraphics, f1093cF, i3, 10, 1.5f);
        }
        poseStackPose.pushPose();
        poseStackPose.translate(m798x(), 0.0f, 0.0f);
        if (this.f1114a != null) {
            for (S s : this.f1114a.m1324g()) {
                if (s.m1499D() && this.f1115a != s) {
                    this.f1115a = s;
                    this.f1585a.m1675a(this.f1587b).m1657aJ();
                }
            }
        }
        int i7 = i3 - 25;
        int i8 = i4 - 80;
        C0119bk.m491c(guiGraphics, i7, i8, 100, f1106eo, iM365p);
        C0119bk.m370a(this.font, guiGraphics, f1101cK, i7 + 5, i8 + 5);
        int i9 = i3 + 80;
        int i10 = i4 - 60;
        C0119bk.m491c(guiGraphics, i9, i10, f1107ep, f1108eq, iM365p);
        C0119bk.m370a(this.font, guiGraphics, f1102cL, i9 + 5, i10 + 5);
        if (this.f1115a != null && this.f1115a.m801a() != null) {
            m794a(localPlayer, guiGraphics, poseStackPose, i3, i4, i7, i8, fM366g, f);
            C0866pf c0866pfM801a = this.f1115a.m801a();
            ObjectArrayList objectArrayList = new ObjectArrayList();
            objectArrayList.add(c0866pfM801a.m4339c());
            objectArrayList.add(c0866pfM801a.m4340d());
            objectArrayList.add(c0866pfM801a.m4341e());
            objectArrayList.add(c0866pfM801a.m4342f());
            objectArrayList.addAll(c0866pfM801a.m4338F());
            int size2 = objectArrayList.size();
            for (int i11 = 0; i11 < size2; i11++) {
                ItemStack itemStack = (ItemStack) objectArrayList.get(i11);
                if (itemStack != null) {
                    float f2 = 1.5f;
                    if (itemStack.getItem() instanceof C1136uj) {
                        f2 = 1.0f;
                    }
                    int i12 = i10 + 20 + (i11 * 15);
                    float f3 = i9 + 19.5f;
                    float f4 = i12 + 5;
                    C0119bk.m501a(poseStackPose, guiGraphics, itemStack, f3, f4, f2);
                    if (C0145cJ.m816a(itemStack, c0482iSM1676a)) {
                        C0119bk.m429a(poseStackPose, guiGraphics, C0564jv.m2555d("textures/gui/game/loadout/challenge.png"), i9, i12, 4);
                    }
                    int count = itemStack.getCount();
                    if (count > 1) {
                        poseStackPose.pushPose();
                        poseStackPose.translate(0.0f, 0.0f, 300.0f);
                        C0119bk.m378b(poseStackPose, this.font, guiGraphics, (Component) Component.literal(String.valueOf(count)), f3 + 3.0f, f4 + 3.0f);
                        poseStackPose.popPose();
                    }
                }
            }
        }
        for (C0127bs c0127bs : this.renderables) {
            if (c0127bs instanceof C0127bs) {
                c0127bs.m663a(this.f1587b, poseStackPose, this.font, guiGraphics, i, i2, fM366g);
            }
        }
        poseStackPose.popPose();
    }

    /* JADX INFO: renamed from: x */
    public int m798x() {
        return 0;
    }
}
