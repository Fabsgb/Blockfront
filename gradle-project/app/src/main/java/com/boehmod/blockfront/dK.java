package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dK.class */
public class dK extends C0080cx {
    private static final Component gu = Component.translatable("bf.menu.button.back");
    private static final Component gv = Component.translatable("bf.menu.inventory.prompt.title");
    private static final Component gw = Component.translatable("bf.message.select");
    private static final Component gx = Component.translatable("bf.message.inventory.prompt.title").withStyle(ChatFormatting.BOLD);
    private static final int gT = 50;

    @NotNull
    private final List<CloudItemStack> z;
    private final int gU;
    private boolean aU;
    private dX<a> a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Button f112a;

    @NotNull
    private final Screen k;

    public dK(@NotNull Screen screen, @NotNull List<CloudItemStack> list, int i) {
        super(gv);
        this.z = new ObjectArrayList();
        this.aU = false;
        this.k = screen;
        this.z.clear();
        this.z.addAll(list);
        this.gU = i;
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void init() {
        int i = (this.width / 4) * 3;
        this.a = new dX<>((this.width / 2) - (i / 2), ((this.height / 2) - 25) + 10, i, 50, this);
        super.init();
        if (this.aU) {
            this.b.setScreen(this.k);
        } else {
            this.aU = true;
        }
    }

    @Override // com.boehmod.blockfront.C0080cx
    /* JADX INFO: renamed from: G */
    public void mo280G() {
        super.mo280G();
        C0048bs c0048bs = new C0048bs((this.width / 2) - 60, this.height - 70, C0163g.g, 20, gw, button -> {
            List<CloudItemStack> objectArrayList = new ObjectArrayList<>();
            dI dIVar = this.k;
            if (dIVar instanceof dI) {
                dI dIVar2 = dIVar;
                for (a aVar : this.a.g()) {
                    if ((aVar instanceof a) && aVar.ba) {
                        objectArrayList.add(aVar.h);
                    }
                }
                this.b.setScreen(this.k);
                dIVar2.b(objectArrayList);
            }
        });
        this.f112a = c0048bs;
        addRenderableWidget(c0048bs);
        addRenderableWidget(new C0048bs(5, 18, 20, 20, Component.empty(), button2 -> {
            this.b.setScreen(this.k);
        }).a(aH).a(20, 20).a(C0048bs.a.NONE).a(gu));
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void E() {
        super.E();
        Iterator<CloudItemStack> it = this.z.iterator();
        while (it.hasNext()) {
            this.a.a(new a(this, it.next(), 50, 50));
            this.a.al();
        }
        a(this.a);
    }

    @Override // com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        fV fVVar = (fV) this.e.a();
        PoseStack poseStackPose = guiGraphics.pose();
        float fG = C0040bk.g();
        int i3 = this.width / 2;
        int iP = P();
        iS iSVarM404a = fVVar.m404a(this.b);
        if (this.f112a != null) {
            this.f112a.active = iP > 0 && iP <= this.gU;
        }
        if (this.a != null) {
            C0040bk.c(guiGraphics, this.a.n() - 1, this.a.o() - 1, this.a.t() + 2, this.a.height() + 2, C0040bk.p());
            this.a.a(this.b, this.e, fVVar, poseStackPose, guiGraphics, this.font, iSVarM404a, i, i2, fG, f);
        }
        MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.inventory.prompt.description", new Object[]{Component.literal(String.valueOf(this.gU)).withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID)}).withStyle(ChatFormatting.GRAY);
        C0040bk.c(this.font, guiGraphics, gx, i3, 60);
        C0040bk.c(this.font, guiGraphics, (Component) mutableComponentWithStyle, i3, 80);
    }

    private int P() {
        return (int) this.a.g().stream().filter(aVar -> {
            return (aVar instanceof a) && aVar.ba;
        }).count();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dK$a.class */
    public static class a extends AbstractC0116eg {

        @NotNull
        private final CloudItemStack h;

        @NotNull
        private final dK a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NotNull
        private final C0050bu f113a;
        private final int gV;
        private final int gW;
        private boolean ba = false;

        public a(@NotNull dK dKVar, @NotNull CloudItemStack cloudItemStack, int i, int i2) {
            this.a = dKVar;
            this.h = cloudItemStack;
            this.gV = i;
            this.gW = i2;
            this.f113a = new C0050bu(dKVar, cloudItemStack, 0, 0, i, i2, false, false);
        }

        @Override // com.boehmod.blockfront.AbstractC0116eg
        public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, int i, int i2, int i3) {
            super.a(minecraft, c0297l, fVVar, i, i2, i3);
            if (v()) {
                this.ba = !this.ba;
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pp.get(), 1.0f));
            }
        }

        @Override // com.boehmod.blockfront.AbstractC0116eg
        public void n(@NotNull Minecraft minecraft) {
        }

        @Override // com.boehmod.blockfront.AbstractC0116eg
        public void a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull GuiGraphics guiGraphics, @NotNull fV fVVar, @NotNull Font font, int i, int i2, float f, float f2) {
            super.a(poseStack, minecraft, c0297l, guiGraphics, fVVar, font, i, i2, f, f2);
            poseStack.pushPose();
            poseStack.translate(this.hI, this.hJ, 0.0f);
            this.f113a.a(minecraft, guiGraphics, font, i, i2, f2);
            poseStack.popPose();
            if (this.ba) {
                C0040bk.a(guiGraphics, this.hI, this.hJ, mo265t(), 1, ColorReferences.COLOR_THEME_YELLOW_SOLID);
                C0040bk.a(guiGraphics, this.hI, (this.hJ + height()) - 1, mo265t(), 1, ColorReferences.COLOR_THEME_YELLOW_SOLID);
                C0040bk.a(guiGraphics, this.hI, this.hJ, 1, height(), ColorReferences.COLOR_THEME_YELLOW_SOLID);
                C0040bk.a(guiGraphics, (this.hI + mo265t()) - 1, this.hJ, 1, height(), ColorReferences.COLOR_THEME_YELLOW_SOLID);
            }
        }

        @Override // com.boehmod.blockfront.AbstractC0116eg
        public boolean v() {
            return this.ba || this.a.P() < this.a.gU;
        }

        @Override // com.boehmod.blockfront.AbstractC0116eg
        public int height() {
            return this.gW;
        }

        @Override // com.boehmod.blockfront.AbstractC0116eg
        /* JADX INFO: renamed from: t */
        public int mo265t() {
            return this.gV;
        }
    }
}
