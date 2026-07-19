package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.mm.SearchRegion;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
import com.boehmod.blockfront.sW;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.dl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dl.class */
public final class C0095dl extends AbstractC0079cw {
    private static final Component eC = Component.translatable("bf.screen.menu.lobby.edit");
    private static final Component eD = Component.translatable("bf.menu.button.nav.text.lobby");
    private static final Component eE = Component.translatable("bf.message.server.all");
    private static final Component eF = Component.translatable("bf.message.server.us");
    private static final Component eG = Component.translatable("bf.message.server.eu");
    private static final ResourceLocation bA = C0265jv.d("textures/gui/flag_all.png");
    private static final ResourceLocation bB = C0265jv.d("textures/gui/flag_us.png");
    private static final ResourceLocation bC = C0265jv.d("textures/gui/flag_eu.png");

    @NotNull
    private sW.a a;
    private dY<C0112ec> b;
    private float cS;
    private float cT;

    public C0095dl(@NotNull Screen screen) {
        super(screen, eC, eD);
        this.a = sW.a.ALL;
        this.cS = 0.0f;
        this.cT = 0.0f;
    }

    @Override // com.boehmod.blockfront.AbstractC0079cw, com.boehmod.blockfront.C0080cx
    public void tick() {
        super.tick();
        this.cT = this.cS;
        this.cS = Mth.lerp(0.4f, this.cS, 1.0f);
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void E() {
        super.E();
        this.b = new dX(0, 25, this.width, 185, this);
        a(this.b);
        a(this.a);
    }

    @Override // com.boehmod.blockfront.C0080cx
    /* JADX INFO: renamed from: G */
    public void mo280G() {
        super.mo280G();
        ab();
        addRenderableWidget(new C0048bs((this.width / 2) - 37, (this.height - 16) - 10, 75, 16, Component.translatable("bf.menu.button.cancel"), button -> {
            this.b.setScreen(this.d);
        }).a(C0048bs.a.SHADOW));
    }

    private void aa() {
        SearchRegion searchRegionM543a = this.e.m596a().m543a();
        fV fVVar = (fV) this.e.a();
        int i = this.width / 2;
        int i2 = this.height - 56;
        int width = 0;
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0048bs(i, i2, 35, 14, Component.empty(), button -> {
            a(fVVar, SearchRegion.ALL);
        }).b(bA).a(searchRegionM543a != SearchRegion.ALL).a(eE));
        objectArrayList.add(new C0048bs(i, i2, 35, 14, Component.empty(), button2 -> {
            a(fVVar, SearchRegion.US);
        }).b(bB).a(searchRegionM543a != SearchRegion.US).a(eF));
        objectArrayList.add(new C0048bs(i, i2, 35, 14, Component.empty(), button3 -> {
            a(fVVar, SearchRegion.EU);
        }).b(bC).a(searchRegionM543a != SearchRegion.EU).a(eG));
        ObjectListIterator it = objectArrayList.iterator();
        while (it.hasNext()) {
            width += ((C0048bs) it.next()).getWidth() + 3;
        }
        int i3 = (i - (width / 2)) + 1;
        int width2 = 0;
        ObjectListIterator it2 = objectArrayList.iterator();
        while (it2.hasNext()) {
            C0048bs c0048bs = (C0048bs) it2.next();
            c0048bs.setX(i3 + width2);
            addRenderableWidget(c0048bs);
            width2 += c0048bs.getWidth() + 3;
        }
    }

    public void ab() {
        int length = (this.width / 2) - (((sW.a.values().length * 50) - 2) / 2);
        for (sW.a aVar : sW.a.values()) {
            addRenderableWidget(new C0048bs(length, 2, 48, 20, aVar.getTitle().copy(), button -> {
                a(aVar);
            }).a(aVar.getTip()).a(C0048bs.b.CENTER).a(C0048bs.a.NONE));
            length += 50;
        }
    }

    public void a(@NotNull fV fVVar, @NotNull SearchRegion searchRegion) {
        this.e.m596a().a(searchRegion);
        ((C0163g) this.e.b()).a(fVVar, this.b, this.e);
        this.b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pi.get(), 1.0f));
        this.b.setScreen(new C0095dl(this.d));
    }

    private void a(@NotNull sW.a aVar) {
        this.a = aVar;
        this.b.am();
        if (!this.a.m404a(this.b).hasCompletedBootcamp()) {
            C0112ec c0112ec = new C0112ec(sW.b);
            c0112ec.c(Component.translatable("bf.container.gamemode.click", new Object[]{sW.b.getDisplayName().copy().withColor(ColorReferences.COLOR_TEAM_ALLIES)}));
            this.b.a(c0112ec);
            return;
        }
        for (sW sWVar : sW.a(aVar)) {
            if (!sWVar.bW()) {
                C0112ec c0112ec2 = new C0112ec(sWVar);
                MutableComponent mutableComponentWithColor = sWVar.getDisplayName().copy().withColor(ColorReferences.COLOR_TEAM_ALLIES);
                MutableComponent mutableComponentEmpty = Component.empty();
                if (sWVar.bV()) {
                    mutableComponentEmpty.append(" (").append(Component.translatable("bf.container.gamemode.experimental")).append(")").withStyle(ChatFormatting.GRAY);
                }
                c0112ec2.c(Component.translatable("bf.container.gamemode.click", new Object[]{mutableComponentWithColor}).append(mutableComponentEmpty));
                this.b.a(c0112ec2);
            }
        }
        this.bj = aVar.getTitle();
    }

    @Override // com.boehmod.blockfront.AbstractC0079cw
    public void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        C0040bk.a(guiGraphics, 0, 0, this.width, this.height, C0040bk.p(), 0.4f * C0634xm.e(this.cT, this.cS, f));
        C0040bk.c(guiGraphics, 0, 0, this.width, 20, C0040bk.p());
    }
}
