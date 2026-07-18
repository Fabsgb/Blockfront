package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.dK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dK.class */
public class C0209dK extends C0195cx {

    /* JADX INFO: renamed from: gu */
    private static final Component f1713gu = Component.translatable("bf.menu.button.back");

    /* JADX INFO: renamed from: gv */
    private static final Component f1714gv = Component.translatable("bf.menu.inventory.prompt.title");

    /* JADX INFO: renamed from: gw */
    private static final Component f1715gw = Component.translatable("bf.message.select");

    /* JADX INFO: renamed from: gx */
    private static final Component f1716gx = Component.translatable("bf.message.inventory.prompt.title").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: gT */
    private static final int f1717gT = 50;

    /* JADX INFO: renamed from: z */
    @NotNull
    private final List<CloudItemStack> f1718z;

    /* JADX INFO: renamed from: gU */
    private final int f1719gU;

    /* JADX INFO: renamed from: aU */
    private boolean f1720aU;

    /* JADX INFO: renamed from: a */
    private C0222dX<a> f1721a;

    /* JADX INFO: renamed from: a */
    private Button f1722a;

    /* JADX INFO: renamed from: k */
    @NotNull
    private final Screen f1723k;

    public C0209dK(@NotNull Screen screen, @NotNull List<CloudItemStack> list, int i) {
        super(f1714gv);
        this.f1718z = new ObjectArrayList();
        this.f1720aU = false;
        this.f1723k = screen;
        this.f1718z.clear();
        this.f1718z.addAll(list);
        this.f1719gU = i;
    }

    @Override // com.boehmod.blockfront.C0195cx
    public void init() {
        int i = (this.width / 4) * 3;
        this.f1721a = new C0222dX<>((this.width / 2) - (i / 2), ((this.height / 2) - 25) + 10, i, 50, this);
        super.init();
        if (this.f1720aU) {
            this.f1587b.setScreen(this.f1723k);
        } else {
            this.f1720aU = true;
        }
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: G */
    public void mo744G() {
        super.mo744G();
        C0127bs c0127bs = new C0127bs((this.width / 2) - 60, this.height - 70, C0357g.f2439g, 20, f1715gw, button -> {
            List<CloudItemStack> objectArrayList = new ObjectArrayList<>();
            InterfaceC0207dI interfaceC0207dI = this.f1723k;
            if (interfaceC0207dI instanceof InterfaceC0207dI) {
                InterfaceC0207dI interfaceC0207dI2 = interfaceC0207dI;
                for (a aVar : this.f1721a.m1324g()) {
                    if ((aVar instanceof a) && aVar.f1729ba) {
                        objectArrayList.add(aVar.f1724h);
                    }
                }
                this.f1587b.setScreen(this.f1723k);
                interfaceC0207dI2.mo1262b(objectArrayList);
            }
        });
        this.f1722a = c0127bs;
        addRenderableWidget(c0127bs);
        addRenderableWidget(new C0127bs(5, 18, 20, 20, Component.empty(), button2 -> {
            this.f1587b.setScreen(this.f1723k);
        }).m645a(f1564aH).m647a(20, 20).m653a(C0127bs.a.NONE).m651a(f1713gu));
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: E */
    public void mo775E() {
        super.mo775E();
        Iterator<CloudItemStack> it = this.f1718z.iterator();
        while (it.hasNext()) {
            this.f1721a.m1316a(new a(this, it.next(), 50, 50));
            this.f1721a.mo1306al();
        }
        m1195a(this.f1721a);
    }

    @Override // com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        C0326fV c0326fV = (C0326fV) this.f1586e.m2670a();
        PoseStack poseStackPose = guiGraphics.pose();
        float fM366g = C0119bk.m366g();
        int i3 = this.width / 2;
        int iM1263P = m1263P();
        C0482iS c0482iSM1676a = c0326fV.m1676a(this.f1587b);
        if (this.f1722a != null) {
            this.f1722a.active = iM1263P > 0 && iM1263P <= this.f1719gU;
        }
        if (this.f1721a != null) {
            C0119bk.m491c(guiGraphics, this.f1721a.m709n() - 1, this.f1721a.m710o() - 1, this.f1721a.m699t() + 2, this.f1721a.height() + 2, C0119bk.m365p());
            this.f1721a.mo687a(this.f1587b, this.f1586e, c0326fV, poseStackPose, guiGraphics, this.font, c0482iSM1676a, i, i2, fM366g, f);
        }
        MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.inventory.prompt.description", new Object[]{Component.literal(String.valueOf(this.f1719gU)).withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID)}).withStyle(ChatFormatting.GRAY);
        C0119bk.m383c(this.font, guiGraphics, f1716gx, i3, 60);
        C0119bk.m383c(this.font, guiGraphics, (Component) mutableComponentWithStyle, i3, 80);
    }

    /* JADX INFO: renamed from: P */
    private int m1263P() {
        return (int) this.f1721a.m1324g().stream().filter(aVar -> {
            return (aVar instanceof a) && aVar.f1729ba;
        }).count();
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.dK$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dK$a.class */
    public static class a extends AbstractC0284eg {

        /* JADX INFO: renamed from: h */
        @NotNull
        private final CloudItemStack f1724h;

        /* JADX INFO: renamed from: a */
        @NotNull
        private final C0209dK f1725a;

        /* JADX INFO: renamed from: a */
        @NotNull
        private final C0129bu f1726a;

        /* JADX INFO: renamed from: gV */
        private final int f1727gV;

        /* JADX INFO: renamed from: gW */
        private final int f1728gW;

        /* JADX INFO: renamed from: ba */
        private boolean f1729ba = false;

        public a(@NotNull C0209dK c0209dK, @NotNull CloudItemStack cloudItemStack, int i, int i2) {
            this.f1725a = c0209dK;
            this.f1724h = cloudItemStack;
            this.f1727gV = i;
            this.f1728gW = i2;
            this.f1726a = new C0129bu(c0209dK, cloudItemStack, 0, 0, i, i2, false, false);
        }

        @Override // com.boehmod.blockfront.AbstractC0284eg
        /* JADX INFO: renamed from: a */
        public void mo817a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, int i, int i2, int i3) {
            super.mo817a(minecraft, c0622l, c0326fV, i, i2, i3);
            if (mo811v()) {
                this.f1729ba = !this.f1729ba;
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7558pp.get(), 1.0f));
            }
        }

        @Override // com.boehmod.blockfront.AbstractC0284eg
        /* JADX INFO: renamed from: n */
        public void mo810n(@NotNull Minecraft minecraft) {
        }

        @Override // com.boehmod.blockfront.AbstractC0284eg
        /* JADX INFO: renamed from: a */
        public void mo800a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull GuiGraphics guiGraphics, @NotNull C0326fV c0326fV, @NotNull Font font, int i, int i2, float f, float f2) {
            super.mo800a(poseStack, minecraft, c0622l, guiGraphics, c0326fV, font, i, i2, f, f2);
            poseStack.pushPose();
            poseStack.translate(this.f2166hI, this.f2167hJ, 0.0f);
            this.f1726a.m674a(minecraft, guiGraphics, font, i, i2, f2);
            poseStack.popPose();
            if (this.f1729ba) {
                C0119bk.m415a(guiGraphics, this.f2166hI, this.f2167hJ, mo812t(), 1, ColorReferences.COLOR_THEME_YELLOW_SOLID);
                C0119bk.m415a(guiGraphics, this.f2166hI, (this.f2167hJ + height()) - 1, mo812t(), 1, ColorReferences.COLOR_THEME_YELLOW_SOLID);
                C0119bk.m415a(guiGraphics, this.f2166hI, this.f2167hJ, 1, height(), ColorReferences.COLOR_THEME_YELLOW_SOLID);
                C0119bk.m415a(guiGraphics, (this.f2166hI + mo812t()) - 1, this.f2167hJ, 1, height(), ColorReferences.COLOR_THEME_YELLOW_SOLID);
            }
        }

        @Override // com.boehmod.blockfront.AbstractC0284eg
        /* JADX INFO: renamed from: v */
        public boolean mo811v() {
            return this.f1729ba || this.f1725a.m1263P() < this.f1725a.f1719gU;
        }

        @Override // com.boehmod.blockfront.AbstractC0284eg
        public int height() {
            return this.f1728gW;
        }

        @Override // com.boehmod.blockfront.AbstractC0284eg
        /* JADX INFO: renamed from: t */
        public int mo812t() {
            return this.f1727gV;
        }
    }
}
