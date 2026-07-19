package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PlayerRank;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
import com.boehmod.blockfront.oF;
import com.boehmod.blockfront.oG;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cH.class */
public abstract class cH<G extends oF<G, ?, ?>, C extends oG<G, ?>> extends C0080cx {
    protected static final int el = 110;
    protected static final int em = 20;
    protected static final int en = 100;
    protected static final int eo = 160;
    protected static final int ep = 39;
    protected static final int eq = 140;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NotNull
    protected final oO f73b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NotNull
    protected final G f74b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NotNull
    protected final C f75b;

    @Nullable
    protected final Screen g;

    @Nullable
    protected dY<cJ> a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    protected cJ f76a;

    @Nullable
    protected Component cM;
    protected int er;
    private static final Component cE = Component.translatable("bf.screen.ingame.select.class");
    private static final Component cF = Component.translatable("bf.message.select.class");
    private static final ResourceLocation aX = C0265jv.d("textures/gui/game/loadout/required_rank.png");
    private static final ResourceLocation aY = C0265jv.d("textures/gui/menu/icons/friends.png");
    private static final ResourceLocation aZ = C0265jv.d("textures/gui/game/loadout/required_exp.png");
    private static final Component cG = Component.translatable("bf.message.select.class.tip.click.left").withStyle(ChatFormatting.GRAY);
    private static final Component cH = Component.translatable("bf.message.select.class.tip.click.right").withStyle(ChatFormatting.GRAY);
    private static final Component cI = Component.translatable("bf.message.select.class.tip", new Object[]{cG, cH}).withStyle(ChatFormatting.DARK_GRAY);
    private static final Component cJ = Component.literal("< ").append(Component.translatable("bf.menu.button.back"));
    private static final Component cK = Component.translatable("bf.message.selected");
    private static final Component cL = Component.translatable("bf.message.class");

    @NotNull
    private static final MutableComponent b = Component.translatable("bf.daily_challenge.eligible").withStyle(ChatFormatting.BOLD).withColor(ColorReferences.COLOR_THEME_YELLOW);

    public abstract void a(@NotNull cJ cJVar);

    public cH(@Nullable Screen screen, @NotNull G g, @NotNull C c, @NotNull oO oOVar) {
        super(cE);
        this.f76a = null;
        this.cM = null;
        this.er = 0;
        this.g = screen;
        this.f73b = oOVar;
        this.f74b = g;
        this.f75b = c;
    }

    public void b(@NotNull Component component) {
        this.cM = component;
        this.er = 60;
    }

    public void Q() {
        this.b.setScreen(this.g);
    }

    @Nullable
    public cJ a() {
        return this.f76a;
    }

    public void a(@NotNull sV sVVar, @NotNull ObjectList<C0411pf> objectList, @NotNull String[] strArr, int i) {
        if (this.a == null) {
            return;
        }
        this.a.a(new cJ(this, sVVar, objectList, strArr, 110, 20, i));
    }

    private void a(@NotNull LocalPlayer localPlayer, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, int i, int i2, int i3, int i4, float f, float f2) {
        oG<?, ?> oGVarM593a;
        oO oOVarA;
        if (this.f76a == null) {
            return;
        }
        C0411pf c0411pfA = this.f76a.a();
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        bQ bQVarA = C0040bk.a.a(this.b);
        if (!c0411pfA.c().isEmpty()) {
            bQVarA.setItemInHand(InteractionHand.MAIN_HAND, c0411pfA.c());
        }
        C0040bk.a(guiGraphics, i3 + x(), i4, 100, eo);
        oF<?, ?, ?> oFVarM591a = this.e.m591a();
        if (oFVarM591a == null || (oGVarM593a = this.e.m593a()) == null || (oOVarA = oFVarM591a.b().a(localPlayer.getUUID())) == null) {
            return;
        }
        iS iSVarM404a = this.a.m404a(this.b);
        C0040bk.b(poseStack, guiGraphics, oOVarA.a(oFVarM591a).m1156a().N(), i3 + 50, (i4 + 80) - 10, 85, 85, 0.0f, 0.5f);
        C0040bk.b(poseStack, guiGraphics, C0080cx.aJ, i3 + 50, i4 + 80 + 20, 100, 100);
        C0040bk.b(poseStack, guiGraphics, C0080cx.aJ, i3 + 50, i4 + 80 + 20, 100, 100);
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, 100.0f);
        C0040bk.a(this.a, poseStack, guiGraphics, this.b, (LivingEntity) bQVarA, i3 + 50, i4 + eo + 60, 90.0f, 5.0f * Mth.sin(f / 40.0f), (-(6 * (c0411pfA.hashCode() % 5))) + (15.0f * Mth.sin(f / 50.0f)), f2);
        poseStack.popPose();
        guiGraphics.disableScissor();
        bQVarA.setItemInHand(InteractionHand.MAIN_HAND, mainHandItem);
        poseStack.pushPose();
        poseStack.translate(0.0f, 0.0f, 200.0f);
        a(poseStack, guiGraphics, oOVarA, i, i2, i3, i4);
        a(poseStack, guiGraphics, oGVarM593a, localPlayer, iSVarM404a, c0411pfA, i3, i4);
        poseStack.popPose();
    }

    private void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull oO oOVar, int i, int i2, int i3, int i4) {
        MutableComponent mutableComponentTranslatable;
        if (this.f76a == null) {
            return;
        }
        C0040bk.a(guiGraphics, i3, i4 + 100, 100, 60, ColorReferences.COLOR_BLACK_TRANSPARENT, ColorReferences.COLOR_BLACK_SOLID);
        C0040bk.a(this.font, guiGraphics, (Component) Component.translatable(this.f76a.m264a().al()).withStyle(ChatFormatting.BOLD).withStyle(oOVar.a()), i - 20, i2 - 65);
        G g = this.f74b;
        boolean z = (g instanceof qO) && ((qO) g).by();
        int i5 = z ? -15 : 0;
        ObjectList<String> objectListA = iH.a(this.font, iH.a((List<String>) new ObjectArrayList(Arrays.asList(this.f76a.m263a()))), dM.gZ);
        int size = objectListA.size();
        int i6 = i - 22;
        int i7 = i4 + eo;
        poseStack.pushPose();
        poseStack.translate(0.0f, i5 - (size * 5), 0.0f);
        if (this.f76a.u()) {
            C0040bk.a(poseStack, this.font, guiGraphics, (Component) b, i6, i7 - 6, 0.5f);
        }
        for (int i8 = 0; i8 < size; i8++) {
            C0040bk.a(poseStack, this.font, guiGraphics, (Component) Component.literal((String) objectListA.get(i8)), i6, i7 + (i8 * 5), 0.5f);
        }
        poseStack.popPose();
        int i9 = i - 22;
        int i10 = i2 + 64;
        G g2 = this.f74b;
        if (g2 instanceof qO) {
            qO qOVar = (qO) g2;
            if (z) {
                MutableComponent mutableComponentWithStyle = Component.literal(String.valueOf(this.f76a.y())).withStyle(ChatFormatting.WHITE);
                int iA = qOVar.a(this.f76a.m264a());
                if (iA > 0) {
                    mutableComponentTranslatable = Component.translatable("bf.message.class.limit", new Object[]{mutableComponentWithStyle, Component.literal(String.valueOf(iA)).withStyle(ChatFormatting.WHITE)});
                } else {
                    mutableComponentTranslatable = mutableComponentWithStyle;
                }
                C0040bk.a(this.font, guiGraphics, (Component) mutableComponentTranslatable, i9 + 18, i10 + 4);
                C0040bk.a(poseStack, guiGraphics, aY, i9, i10, 16, 16);
            }
        }
    }

    private void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull oG<?, ?> oGVar, @NotNull LocalPlayer localPlayer, iS iSVar, @NotNull C0411pf c0411pf, int i, int i2) {
        sV sVVarM264a;
        if (this.f76a == null) {
            return;
        }
        G g = this.f74b;
        if (!(g instanceof qO)) {
            return;
        }
        qO qOVar = (qO) g;
        if (oGVar.bm() && (sVVarM264a = this.f76a.m264a()) != null) {
            int i3 = 0;
            if (qOVar.bA()) {
                PlayerRank playerRankA = sVVarM264a.a();
                boolean zA = sVVarM264a.a(this.a, localPlayer);
                if (playerRankA != PlayerRank.RECRUIT && !zA) {
                    MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.selected.required.rank", new Object[]{sVVarM264a.a().getTitle()}).withColor(0).withStyle(ChatFormatting.BOLD);
                    int i4 = i + 1;
                    int i5 = i2 + eo;
                    C0040bk.c(guiGraphics, i4, i5, 98, 8, ColorReferences.COLOR_THEME_YELLOW_SOLID);
                    C0040bk.b(poseStack, this.font, guiGraphics, (Component) mutableComponentWithStyle, i4 + 49 + 3, i5 + 2, 0.5f);
                    C0040bk.a(poseStack, guiGraphics, aX, i4 + 1, i5 + 1, 6, 6);
                    i3 = 0 + 8;
                }
            }
            int iBl = c0411pf.bl();
            if (qOVar.bz() && iBl != 0) {
                int expForClass = iSVar.getExpForClass(sVVarM264a.bN());
                String strA = C0637xp.a(expForClass);
                String strA2 = C0637xp.a(iBl);
                int i6 = expForClass >= iBl ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_BLACK_SOLID + C0040bk.bC;
                MutableComponent mutableComponentWithStyle2 = Component.literal(strA + " / " + strA2 + " EXP").withColor(0).withStyle(ChatFormatting.BOLD);
                int i7 = i + 1;
                int i8 = i2 + eo + i3;
                C0040bk.c(guiGraphics, i7, i8, 98, 15, i6);
                C0040bk.b(poseStack, this.font, guiGraphics, (Component) mutableComponentWithStyle2, i7 + 49 + 6, i8 + 2, 0.5f);
                C0040bk.a(poseStack, guiGraphics, aZ, i7 + 1, i8 + 1, 13, 13);
                int i9 = (i8 + 15) - 7;
                int i10 = ((i7 + 49) - 35) + 6;
                C0040bk.a(guiGraphics, i10, i9, 70, 4, ColorReferences.COLOR_BLACK_SOLID);
                C0040bk.a(guiGraphics, i10 + 1, i9 + 1, 68, 2, ColorReferences.COLOR_WHITE_SOLID, 0.4f);
                C0040bk.a(poseStack, guiGraphics, i10 + 1, i9 + 1, 68.0f * (Mth.clamp(expForClass, 0, iBl) / iBl), 2.0f, ColorReferences.COLOR_WHITE_SOLID);
            }
        }
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void E() {
        super.E();
        int i = this.width / 2;
        int i2 = this.height / 2;
        this.a = new dZ(((i - 110) - 30) + x(), i2 - 80, 110, 159, this);
        this.a.a(true);
        a(this.a.b());
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void init() {
        super.init();
        addRenderableWidget(new C0048bs((this.width / 2) - 150, 18, 40, 10, cJ, button -> {
            Q();
        }).a(C0048bs.a.NONE));
    }

    @Override // com.boehmod.blockfront.C0080cx
    public boolean keyPressed(int i, int i2, int i3) {
        Q();
        return true;
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void tick() {
        super.tick();
        if (this.e.m602a().ay()) {
            this.b.setScreen((Screen) null);
        } else if (this.er > 0) {
            this.er--;
        }
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderBackground(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int iP = C0040bk.p();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        C0040bk.c(guiGraphics, 0, 0, this.width, 30, iP);
        C0040bk.c(guiGraphics, 0, this.height - 30, this.width, 30, iP);
        C0040bk.c(this.font, guiGraphics, cI, this.width / 2, this.height - 20);
        poseStackPose.pushPose();
        poseStackPose.translate(x(), 0.0f, 0.0f);
        C0040bk.c(guiGraphics, (i3 - 110) - 30, i4 - 80, 110, eo, iP);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        LocalPlayer localPlayer = this.b.player;
        if (localPlayer == null) {
            return;
        }
        iS iSVarM404a = this.a.m404a(this.b);
        float fG = C0040bk.g();
        PoseStack poseStackPose = guiGraphics.pose();
        int iP = C0040bk.p();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        if (this.er > 0 && this.cM != null) {
            List listSplit = this.font.split(this.cM, 220);
            int size = listSplit.size();
            int i5 = 10 - size;
            for (int i6 = 0; i6 < size; i6++) {
                guiGraphics.drawString(this.font, (FormattedCharSequence) listSplit.get(i6), (int) (i3 - (this.font.width(r0) / 2.0f)), i5 + (i6 * 10), ColorReferences.COLOR_WHITE);
            }
        } else {
            C0040bk.b(poseStackPose, this.font, guiGraphics, cF, i3, 10, 1.5f);
        }
        poseStackPose.pushPose();
        poseStackPose.translate(x(), 0.0f, 0.0f);
        if (this.a != null) {
            for (S s : this.a.g()) {
                if (s.D() && this.f76a != s) {
                    this.f76a = s;
                    this.a.a(this.b).aJ();
                }
            }
        }
        int i7 = i3 - 25;
        int i8 = i4 - 80;
        C0040bk.c(guiGraphics, i7, i8, 100, eo, iP);
        C0040bk.a(this.font, guiGraphics, cK, i7 + 5, i8 + 5);
        int i9 = i3 + 80;
        int i10 = i4 - 60;
        C0040bk.c(guiGraphics, i9, i10, ep, eq, iP);
        C0040bk.a(this.font, guiGraphics, cL, i9 + 5, i10 + 5);
        if (this.f76a != null && this.f76a.a() != null) {
            a(localPlayer, guiGraphics, poseStackPose, i3, i4, i7, i8, fG, f);
            C0411pf c0411pfA = this.f76a.a();
            ObjectArrayList objectArrayList = new ObjectArrayList();
            objectArrayList.add(c0411pfA.c());
            objectArrayList.add(c0411pfA.d());
            objectArrayList.add(c0411pfA.e());
            objectArrayList.add(c0411pfA.f());
            objectArrayList.addAll(c0411pfA.F());
            int size2 = objectArrayList.size();
            for (int i11 = 0; i11 < size2; i11++) {
                ItemStack itemStack = (ItemStack) objectArrayList.get(i11);
                if (itemStack != null) {
                    float f2 = 1.5f;
                    if (itemStack.getItem() instanceof C0550uj) {
                        f2 = 1.0f;
                    }
                    int i12 = i10 + 20 + (i11 * 15);
                    float f3 = i9 + 19.5f;
                    float f4 = i12 + 5;
                    C0040bk.a(poseStackPose, guiGraphics, itemStack, f3, f4, f2);
                    if (cJ.a(itemStack, iSVarM404a)) {
                        C0040bk.a(poseStackPose, guiGraphics, C0265jv.d("textures/gui/game/loadout/challenge.png"), i9, i12, 4);
                    }
                    int count = itemStack.getCount();
                    if (count > 1) {
                        poseStackPose.pushPose();
                        poseStackPose.translate(0.0f, 0.0f, 300.0f);
                        C0040bk.b(poseStackPose, this.font, guiGraphics, (Component) Component.literal(String.valueOf(count)), f3 + 3.0f, f4 + 3.0f);
                        poseStackPose.popPose();
                    }
                }
            }
        }
        for (C0048bs c0048bs : this.renderables) {
            if (c0048bs instanceof C0048bs) {
                c0048bs.a(this.b, poseStackPose, this.font, guiGraphics, i, i2, fG);
            }
        }
        poseStackPose.popPose();
    }

    public int x() {
        return 0;
    }
}
