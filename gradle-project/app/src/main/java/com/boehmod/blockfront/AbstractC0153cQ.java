package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PlayerRank;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.AbstractC0864pc;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.cQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cQ.class */
public abstract class AbstractC0153cQ<G extends AbstractC0863pb<G, ?, ?>, C extends AbstractC0864pc<G, ?>> extends C0143cG {

    /* JADX INFO: renamed from: fl */
    protected static final int f1193fl = 110;

    /* JADX INFO: renamed from: fm */
    protected static final int f1194fm = 20;

    /* JADX INFO: renamed from: fn */
    protected static final int f1195fn = 100;

    /* JADX INFO: renamed from: fo */
    protected static final int f1196fo = 160;

    /* JADX INFO: renamed from: fp */
    protected static final int f1197fp = 39;

    /* JADX INFO: renamed from: fq */
    protected static final int f1198fq = 140;

    /* JADX INFO: renamed from: b */
    @NotNull
    protected final C0872pk f1200b;

    /* JADX INFO: renamed from: b */
    @NotNull
    protected final G f1201b;

    /* JADX INFO: renamed from: b */
    @NotNull
    protected final C f1202b;

    /* JADX INFO: renamed from: f */
    @Nullable
    protected final Screen f1203f;

    /* JADX INFO: renamed from: a */
    @Nullable
    protected AbstractC0288ej<C0155cS> f1204a;

    /* JADX INFO: renamed from: a */
    @Nullable
    protected C0155cS f1205a;

    /* JADX INFO: renamed from: cO */
    @Nullable
    protected Component f1206cO;

    /* JADX INFO: renamed from: fr */
    protected int f1207fr;

    /* JADX INFO: renamed from: cG */
    private static final Component f1182cG = Component.translatable("bf.screen.ingame.select.class");

    /* JADX INFO: renamed from: cH */
    private static final Component f1183cH = Component.translatable("bf.message.select.class");

    /* JADX INFO: renamed from: aV */
    private static final ResourceLocation f1184aV = C0532jO.m2378d("textures/gui/game/loadout/required_rank.png");

    /* JADX INFO: renamed from: aW */
    private static final ResourceLocation f1185aW = C0532jO.m2378d("textures/gui/menu/icons/friends.png");

    /* JADX INFO: renamed from: aX */
    private static final ResourceLocation f1186aX = C0532jO.m2378d("textures/gui/game/loadout/required_exp.png");

    /* JADX INFO: renamed from: cI */
    private static final Component f1187cI = Component.translatable("bf.message.select.class.tip.click.left").withStyle(ChatFormatting.GRAY);

    /* JADX INFO: renamed from: cJ */
    private static final Component f1188cJ = Component.translatable("bf.message.select.class.tip.click.right").withStyle(ChatFormatting.GRAY);

    /* JADX INFO: renamed from: cK */
    private static final Component f1189cK = Component.translatable("bf.message.select.class.tip", new Object[]{f1187cI, f1188cJ}).withStyle(ChatFormatting.DARK_GRAY);

    /* JADX INFO: renamed from: cL */
    private static final Component f1190cL = Component.literal("< ").append(Component.translatable("bf.menu.button.back"));

    /* JADX INFO: renamed from: cM */
    private static final Component f1191cM = Component.translatable("bf.message.selected");

    /* JADX INFO: renamed from: cN */
    private static final Component f1192cN = Component.translatable("bf.message.class");

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final MutableComponent f1199b = Component.translatable("bf.daily_challenge.eligible").withStyle(ChatFormatting.BOLD).withColor(ColorReferences.COLOR_THEME_YELLOW);

    /* JADX INFO: renamed from: a */
    public abstract void mo851a(@NotNull C0155cS c0155cS);

    public AbstractC0153cQ(@Nullable Screen screen, @NotNull G g, @NotNull C c, @NotNull C0872pk c0872pk) {
        super(f1182cG);
        this.f1205a = null;
        this.f1206cO = null;
        this.f1207fr = 0;
        this.f1203f = screen;
        this.f1200b = c0872pk;
        this.f1201b = g;
        this.f1202b = c;
    }

    /* JADX INFO: renamed from: b */
    public void m844b(@NotNull Component component) {
        this.f1206cO = component;
        this.f1207fr = 60;
    }

    /* JADX INFO: renamed from: U */
    public void m845U() {
        this.f1058a.setScreen(this.f1203f);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0155cS m846a() {
        return this.f1205a;
    }

    /* JADX INFO: renamed from: a */
    public void m847a(@NotNull C1093ts c1093ts, @NotNull ObjectList<C0837pB> objectList, @NotNull String[] strArr, int i) {
        if (this.f1204a == null) {
            return;
        }
        this.f1204a.m1577a(new C0155cS(this, c1093ts, objectList, strArr, 110, 20, i));
    }

    /* JADX INFO: renamed from: a */
    private void m848a(@NotNull LocalPlayer localPlayer, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, int i, int i2, int i3, int i4, float f, float f2) {
        AbstractC0864pc<?, ?> abstractC0864pcM2878a;
        C0872pk c0872pkM4229a;
        if (this.f1205a == null) {
            return;
        }
        C0837pB c0837pBM855a = this.f1205a.m855a();
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        C0109bZ c0109bZM1038a = C0129bt.f871a.m1038a(this.f1058a);
        if (!c0837pBM855a.m3824e().isEmpty()) {
            c0109bZM1038a.setItemInHand(InteractionHand.MAIN_HAND, c0837pBM855a.m3824e());
        }
        C0129bt.m618a(guiGraphics, i3 + m852B(), i4, 100, f1196fo);
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = this.f1057f.m2874a();
        if (abstractC0863pbM2874a == null || (abstractC0864pcM2878a = this.f1057f.m2878a()) == null || (c0872pkM4229a = abstractC0863pbM2874a.m4018b().m4229a(localPlayer.getUUID())) == null) {
            return;
        }
        C0555jl c0555jlM1886a = this.f1056a.m1886a(this.f1058a);
        C0129bt.m545b(poseStack, guiGraphics, c0872pkM4229a.m4296a(abstractC0863pbM2874a).m6179a().m6158O(), i3 + 50, (i4 + 80) - 10, 85, 85, 0.0f, 0.5f);
        C0129bt.m541b(poseStack, guiGraphics, C0143cG.f1039aJ, i3 + 50, i4 + 80 + 20, 100, 100);
        C0129bt.m541b(poseStack, guiGraphics, C0143cG.f1039aJ, i3 + 50, i4 + 80 + 20, 100, 100);
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, 100.0f);
        C0129bt.m594a(this.f1056a, poseStack, guiGraphics, this.f1058a, (LivingEntity) c0109bZM1038a, i3 + 50, i4 + f1196fo + 60, 90.0f, 5.0f * Mth.sin(f / 40.0f), (-(6 * (c0837pBM855a.hashCode() % 5))) + (15.0f * Mth.sin(f / 50.0f)), f2);
        poseStack.popPose();
        guiGraphics.disableScissor();
        c0109bZM1038a.setItemInHand(InteractionHand.MAIN_HAND, mainHandItem);
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, 200.0f);
        m849a(poseStack, guiGraphics, c0872pkM4229a, i, i2, i3, i4);
        m850a(poseStack, guiGraphics, abstractC0864pcM2878a, localPlayer, c0555jlM1886a, c0837pBM855a, i3, i4);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    private void m849a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull C0872pk c0872pk, int i, int i2, int i3, int i4) {
        MutableComponent mutableComponentTranslatable;
        if (this.f1205a == null) {
            return;
        }
        C0129bt.m523a(guiGraphics, i3, i4 + 100, 100, 60, ColorReferences.COLOR_BLACK_TRANSPARENT, ColorReferences.COLOR_BLACK_SOLID);
        C0129bt.m470a(this.font, guiGraphics, (Component) Component.translatable(this.f1205a.m859a().m6004as()).withStyle(ChatFormatting.BOLD).withStyle(c0872pk.m4312a()), i - 20, i2 - 65);
        G g = this.f1201b;
        boolean z = (g instanceof InterfaceC0979rl) && ((InterfaceC0979rl) g).mo5343bI();
        int i5 = z ? -15 : 0;
        ObjectList<String> objectListM2458a = C0544ja.m2458a(this.font, C0544ja.m2457a((List<String>) new ObjectArrayList(Arrays.asList(this.f1205a.m858a()))), AbstractC0223dX.f1766ij);
        int size = objectListM2458a.size();
        int i6 = i - 22;
        int i7 = i4 + f1196fo;
        poseStack.pushPose();
        poseStack.translate(0.0f, i5 - (size * 5), 0.0f);
        if (this.f1205a.m862v()) {
            C0129bt.m487a(poseStack, this.font, guiGraphics, (Component) f1199b, i6, i7 - 6, 0.5f);
        }
        for (int i8 = 0; i8 < size; i8++) {
            C0129bt.m487a(poseStack, this.font, guiGraphics, (Component) Component.literal((String) objectListM2458a.get(i8)), i6, i7 + (i8 * 5), 0.5f);
        }
        poseStack.popPose();
        int i9 = i - 22;
        int i10 = i2 + 64;
        G g2 = this.f1201b;
        if (g2 instanceof InterfaceC0979rl) {
            InterfaceC0979rl interfaceC0979rl = (InterfaceC0979rl) g2;
            if (z) {
                MutableComponent mutableComponentWithStyle = Component.literal(String.valueOf(this.f1205a.m857C())).withStyle(ChatFormatting.WHITE);
                int iMo5347a = interfaceC0979rl.mo5347a(this.f1205a.m859a());
                if (iMo5347a > 0) {
                    mutableComponentTranslatable = Component.translatable("bf.message.class.limit", new Object[]{mutableComponentWithStyle, Component.literal(String.valueOf(iMo5347a)).withStyle(ChatFormatting.WHITE)});
                } else {
                    mutableComponentTranslatable = mutableComponentWithStyle;
                }
                C0129bt.m470a(this.font, guiGraphics, (Component) mutableComponentTranslatable, i9 + 18, i10 + 4);
                C0129bt.m531a(poseStack, guiGraphics, f1185aW, i9, i10, 16, 16);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m850a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull AbstractC0864pc<?, ?> abstractC0864pc, @NotNull LocalPlayer localPlayer, C0555jl c0555jl, @NotNull C0837pB c0837pB, int i, int i2) {
        C1093ts c1093tsM859a;
        if (this.f1205a == null) {
            return;
        }
        G g = this.f1201b;
        if (!(g instanceof InterfaceC0979rl)) {
            return;
        }
        InterfaceC0979rl interfaceC0979rl = (InterfaceC0979rl) g;
        if (abstractC0864pc.m4176bw() && (c1093tsM859a = this.f1205a.m859a()) != null) {
            int i3 = 0;
            if (interfaceC0979rl.mo5345bK()) {
                PlayerRank playerRankM6012a = c1093tsM859a.m6012a();
                boolean zM6013a = c1093tsM859a.m6013a(this.f1056a, localPlayer);
                if (playerRankM6012a != PlayerRank.RECRUIT && !zM6013a) {
                    MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.selected.required.rank", new Object[]{c1093tsM859a.m6012a().getTitle()}).withColor(0).withStyle(ChatFormatting.BOLD);
                    int i4 = i + 1;
                    int i5 = i2 + f1196fo;
                    C0129bt.m591c(guiGraphics, i4, i5, 98, 8, ColorReferences.COLOR_THEME_YELLOW_SOLID);
                    C0129bt.m491b(poseStack, this.font, guiGraphics, (Component) mutableComponentWithStyle, i4 + 49 + 3, i5 + 2, 0.5f);
                    C0129bt.m531a(poseStack, guiGraphics, f1184aV, i4 + 1, i5 + 1, 6, 6);
                    i3 = 0 + 8;
                }
            }
            int iM3818bA = c0837pB.m3818bA();
            if (interfaceC0979rl.mo5344bJ() && iM3818bA != 0) {
                int expForClass = c0555jl.getExpForClass(c1093tsM859a.m6011cc());
                String strM7239b = C1273xM.m7239b(expForClass);
                String strM7239b2 = C1273xM.m7239b(iM3818bA);
                int i6 = expForClass >= iM3818bA ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_BLACK_SOLID + C0129bt.f861cu;
                MutableComponent mutableComponentWithStyle2 = Component.literal(strM7239b + " / " + strM7239b2 + " EXP").withColor(0).withStyle(ChatFormatting.BOLD);
                int i7 = i + 1;
                int i8 = i2 + f1196fo + i3;
                C0129bt.m591c(guiGraphics, i7, i8, 98, 15, i6);
                C0129bt.m491b(poseStack, this.font, guiGraphics, (Component) mutableComponentWithStyle2, i7 + 49 + 6, i8 + 2, 0.5f);
                C0129bt.m531a(poseStack, guiGraphics, f1186aX, i7 + 1, i8 + 1, 13, 13);
                int i9 = (i8 + 15) - 7;
                int i10 = ((i7 + 49) - 35) + 6;
                C0129bt.m515a(guiGraphics, i10, i9, 70, 4, ColorReferences.COLOR_BLACK_SOLID);
                C0129bt.m517a(guiGraphics, i10 + 1, i9 + 1, 68, 2, ColorReferences.COLOR_WHITE_SOLID, 0.4f);
                C0129bt.m514a(poseStack, guiGraphics, i10 + 1, i9 + 1, 68.0f * (Mth.clamp(expForClass, 0, iM3818bA) / iM3818bA), 2.0f, ColorReferences.COLOR_WHITE_SOLID);
            }
        }
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: H */
    public void mo777H() {
        super.mo777H();
        int i = this.width / 2;
        int i2 = this.height / 2;
        this.f1204a = new C0289ek(((i - 110) - 30) + m852B(), i2 - 80, 110, 159, this);
        this.f1204a.m1574a(true);
        m794a(this.f1204a.m359b());
    }

    @Override // com.boehmod.blockfront.C0143cG
    public void init() {
        super.init();
        addRenderableWidget(new C0085bB((this.width / 2) - 150, 18, 40, 10, f1190cL, button -> {
            m845U();
        }).m328a(C0085bB.a.NONE));
    }

    @Override // com.boehmod.blockfront.C0143cG
    public boolean keyPressed(int i, int i2, int i3) {
        m845U();
        return true;
    }

    @Override // com.boehmod.blockfront.C0143cG
    public void tick() {
        super.tick();
        if (this.f1057f.m2895a().m3074aJ()) {
            this.f1058a.setScreen((Screen) null);
        } else if (this.f1207fr > 0) {
            this.f1207fr--;
        }
    }

    @Override // com.boehmod.blockfront.C0143cG
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int iM465t = C0129bt.m465t();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        C0129bt.m591c(guiGraphics, 0, 0, this.width, 30, iM465t);
        C0129bt.m591c(guiGraphics, 0, this.height - 30, this.width, 30, iM465t);
        C0129bt.m483c(this.font, guiGraphics, f1189cK, this.width / 2, this.height - 20);
        poseStackPose.pushPose();
        poseStackPose.translate(m852B(), 0.0f, 0.0f);
        C0129bt.m591c(guiGraphics, (i3 - 110) - 30, i4 - 80, 110, f1196fo, iM465t);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        LocalPlayer localPlayer = this.f1058a.player;
        if (localPlayer == null) {
            return;
        }
        C0555jl c0555jlM1886a = this.f1056a.m1886a(this.f1058a);
        float fM466g = C0129bt.m466g();
        PoseStack poseStackPose = guiGraphics.pose();
        int iM465t = C0129bt.m465t();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        if (this.f1207fr > 0 && this.f1206cO != null) {
            List listSplit = this.font.split(this.f1206cO, 220);
            int size = listSplit.size();
            int i5 = 10 - size;
            for (int i6 = 0; i6 < size; i6++) {
                FormattedCharSequence formattedCharSequence = (FormattedCharSequence) listSplit.get(i6);
                guiGraphics.drawString(this.font, formattedCharSequence, (int) (i3 - (this.font.width(formattedCharSequence) / 2.0f)), i5 + (i6 * 10), ColorReferences.COLOR_WHITE);
            }
        } else {
            C0129bt.m491b(poseStackPose, this.font, guiGraphics, f1183cH, i3, 10, 1.5f);
        }
        poseStackPose.pushPose();
        poseStackPose.translate(m852B(), 0.0f, 0.0f);
        if (this.f1204a != null) {
            for (S s : this.f1204a.m1585h()) {
                if (s.m1615E() && this.f1205a != s) {
                    this.f1205a = s;
                    this.f1056a.m1885a(this.f1058a).m1867aP();
                }
            }
        }
        int i7 = i3 - 25;
        int i8 = i4 - 80;
        C0129bt.m591c(guiGraphics, i7, i8, 100, f1196fo, iM465t);
        C0129bt.m470a(this.font, guiGraphics, f1191cM, i7 + 5, i8 + 5);
        int i9 = i3 + 80;
        int i10 = i4 - 60;
        C0129bt.m591c(guiGraphics, i9, i10, f1197fp, f1198fq, iM465t);
        C0129bt.m470a(this.font, guiGraphics, f1192cN, i9 + 5, i10 + 5);
        if (this.f1205a != null && this.f1205a.m855a() != null) {
            m848a(localPlayer, guiGraphics, poseStackPose, i3, i4, i7, i8, fM466g, f);
            C0837pB c0837pBM855a = this.f1205a.m855a();
            ObjectArrayList objectArrayList = new ObjectArrayList();
            objectArrayList.add(c0837pBM855a.m3824e());
            objectArrayList.add(c0837pBM855a.m3825f());
            objectArrayList.add(c0837pBM855a.m3826g());
            objectArrayList.add(c0837pBM855a.m3827h());
            objectArrayList.addAll(c0837pBM855a.m3823H());
            int size2 = objectArrayList.size();
            for (int i11 = 0; i11 < size2; i11++) {
                ItemStack itemStack = (ItemStack) objectArrayList.get(i11);
                if (itemStack != null) {
                    float f2 = 1.5f;
                    if (itemStack.getItem() instanceof C1109uH) {
                        f2 = 1.0f;
                    }
                    int i12 = i10 + 20 + (i11 * 15);
                    float f3 = i9 + 19.5f;
                    float f4 = i12 + 5;
                    C0126bq.m441a(poseStackPose, guiGraphics, itemStack, f3, f4, f2);
                    if (C0155cS.m870a(itemStack, c0555jlM1886a)) {
                        C0129bt.m529a(poseStackPose, guiGraphics, C0532jO.m2378d("textures/gui/game/loadout/challenge.png"), i9, i12, 4);
                    }
                    int count = itemStack.getCount();
                    if (count > 1) {
                        poseStackPose.pushPose();
                        poseStackPose.translate(0.0f, 0.0f, 300.0f);
                        C0129bt.m478b(poseStackPose, this.font, guiGraphics, (Component) Component.literal(String.valueOf(count)), f3 + 3.0f, f4 + 3.0f);
                        poseStackPose.popPose();
                    }
                }
            }
        }
        for (C0085bB c0085bB : this.renderables) {
            if (c0085bB instanceof C0085bB) {
                c0085bB.m338a(this.f1058a, poseStackPose, this.font, guiGraphics, i, i2, fM466g);
            }
        }
        poseStackPose.popPose();
    }

    /* JADX INFO: renamed from: B */
    public int m852B() {
        return 0;
    }
}
