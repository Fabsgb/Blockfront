package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p000mm.SearchRegion;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
import com.boehmod.blockfront.C1016sW;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dl.class */
public final class C0236dl extends AbstractC0194cw {

    /* JADX INFO: renamed from: eC */
    private static final Component f1954eC = Component.translatable("bf.screen.menu.lobby.edit");

    /* JADX INFO: renamed from: eD */
    private static final Component f1955eD = Component.translatable("bf.menu.button.nav.text.lobby");

    /* JADX INFO: renamed from: eE */
    private static final Component f1956eE = Component.translatable("bf.message.server.all");

    /* JADX INFO: renamed from: eF */
    private static final Component f1957eF = Component.translatable("bf.message.server.us");

    /* JADX INFO: renamed from: eG */
    private static final Component f1958eG = Component.translatable("bf.message.server.eu");

    /* JADX INFO: renamed from: bA */
    private static final ResourceLocation f1959bA = C0564jv.m2555d("textures/gui/flag_all.png");

    /* JADX INFO: renamed from: bB */
    private static final ResourceLocation f1960bB = C0564jv.m2555d("textures/gui/flag_us.png");

    /* JADX INFO: renamed from: bC */
    private static final ResourceLocation f1961bC = C0564jv.m2555d("textures/gui/flag_eu.png");

    /* JADX INFO: renamed from: a */
    @NotNull
    private C1016sW.a f1962a;

    /* JADX INFO: renamed from: b */
    private AbstractC0223dY<C0280ec> f1963b;

    /* JADX INFO: renamed from: cS */
    private float f1964cS;

    /* JADX INFO: renamed from: cT */
    private float f1965cT;

    public C0236dl(@NotNull Screen screen) {
        super(screen, f1954eC, f1955eD);
        this.f1962a = C1016sW.a.ALL;
        this.f1964cS = 0.0f;
        this.f1965cT = 0.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0194cw, com.boehmod.blockfront.C0195cx
    public void tick() {
        super.tick();
        this.f1965cT = this.f1964cS;
        this.f1964cS = Mth.lerp(0.4f, this.f1964cS, 1.0f);
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: E */
    public void mo775E() {
        super.mo775E();
        this.f1963b = new C0222dX(0, 25, this.width, 185, this);
        m1195a(this.f1963b);
        m1383a(this.f1962a);
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: G */
    public void mo744G() {
        super.mo744G();
        m1381ab();
        addRenderableWidget(new C0127bs((this.width / 2) - 37, (this.height - 16) - 10, 75, 16, Component.translatable("bf.menu.button.cancel"), button -> {
            this.f1587b.setScreen(this.f1563d);
        }).m653a(C0127bs.a.SHADOW));
    }

    /* JADX INFO: renamed from: aa */
    private void m1380aa() {
        SearchRegion searchRegionM2586a = this.f1586e.m2699a().m2586a();
        C0326fV c0326fV = (C0326fV) this.f1586e.m2670a();
        int i = this.width / 2;
        int i2 = this.height - 56;
        int width = 0;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0127bs(i, i2, 35, 14, Component.empty(), button -> {
            m1382a(c0326fV, SearchRegion.ALL);
        }).m655b(f1959bA).m658a(searchRegionM2586a != SearchRegion.ALL).m651a(f1956eE));
        objectArrayList.add(new C0127bs(i, i2, 35, 14, Component.empty(), button2 -> {
            m1382a(c0326fV, SearchRegion.US);
        }).m655b(f1960bB).m658a(searchRegionM2586a != SearchRegion.US).m651a(f1957eF));
        objectArrayList.add(new C0127bs(i, i2, 35, 14, Component.empty(), button3 -> {
            m1382a(c0326fV, SearchRegion.EU);
        }).m655b(f1961bC).m658a(searchRegionM2586a != SearchRegion.EU).m651a(f1958eG));
        ObjectListIterator it = objectArrayList.iterator();
        while (it.hasNext()) {
            width += ((C0127bs) it.next()).getWidth() + 3;
        }
        int i3 = (i - (width / 2)) + 1;
        int width2 = 0;
        ObjectListIterator it2 = objectArrayList.iterator();
        while (it2.hasNext()) {
            C0127bs c0127bs = (C0127bs) it2.next();
            c0127bs.setX(i3 + width2);
            addRenderableWidget(c0127bs);
            width2 += c0127bs.getWidth() + 3;
        }
    }

    /* JADX INFO: renamed from: ab */
    public void m1381ab() {
        int length = (this.width / 2) - (((C1016sW.a.values().length * 50) - 2) / 2);
        for (C1016sW.a aVar : C1016sW.a.values()) {
            addRenderableWidget(new C0127bs(length, 2, 48, 20, aVar.getTitle().copy(), button -> {
                m1383a(aVar);
            }).m651a(aVar.getTip()).m652a(C0127bs.b.CENTER).m653a(C0127bs.a.NONE));
            length += 50;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1382a(@NotNull C0326fV c0326fV, @NotNull SearchRegion searchRegion) {
        this.f1586e.m2699a().m2587a(searchRegion);
        ((C0357g) this.f1586e.m2667b()).m1718a(c0326fV, this.f1587b, this.f1586e);
        this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7551pi.get(), 1.0f));
        this.f1587b.setScreen(new C0236dl(this.f1563d));
    }

    /* JADX INFO: renamed from: a */
    private void m1383a(@NotNull C1016sW.a aVar) {
        this.f1962a = aVar;
        this.f1963b.m1317am();
        if (!this.f1585a.m1676a(this.f1587b).hasCompletedBootcamp()) {
            C0280ec c0280ec = new C0280ec(C1016sW.f5343b);
            c0280ec.m1495c(Component.translatable("bf.container.gamemode.click", new Object[]{C1016sW.f5343b.getDisplayName().copy().withColor(ColorReferences.COLOR_TEAM_ALLIES)}));
            this.f1963b.m1316a(c0280ec);
            return;
        }
        for (C1016sW c1016sW : C1016sW.m5532a(aVar)) {
            if (!c1016sW.m5541bW()) {
                C0280ec c0280ec2 = new C0280ec(c1016sW);
                MutableComponent mutableComponentWithColor = c1016sW.getDisplayName().copy().withColor(ColorReferences.COLOR_TEAM_ALLIES);
                MutableComponent mutableComponentEmpty = Component.empty();
                if (c1016sW.m5539bV()) {
                    mutableComponentEmpty.append(" (").append(Component.translatable("bf.container.gamemode.experimental")).append(")").withStyle(ChatFormatting.GRAY);
                }
                c0280ec2.m1495c(Component.translatable("bf.container.gamemode.click", new Object[]{mutableComponentWithColor}).append(mutableComponentEmpty));
                this.f1963b.m1316a(c0280ec2);
            }
        }
        this.f1584bj = aVar.getTitle();
    }

    @Override // com.boehmod.blockfront.AbstractC0194cw
    /* JADX INFO: renamed from: a */
    public void mo615a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        C0119bk.m417a(guiGraphics, 0, 0, this.width, this.height, C0119bk.m365p(), 0.4f * C1290xm.m7843e(this.f1965cT, this.f1964cS, f));
        C0119bk.m491c(guiGraphics, 0, 0, this.width, 20, C0119bk.m365p());
    }
}
