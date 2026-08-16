package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.common.ColorReferences;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.dV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dV.class */
public class C0221dV extends C0143cG {

    /* JADX INFO: renamed from: gA */
    private static final Component f1742gA = Component.translatable("bf.menu.button.back");

    /* JADX INFO: renamed from: gB */
    private static final Component f1743gB = Component.translatable("bf.menu.inventory.prompt.title");

    /* JADX INFO: renamed from: gC */
    private static final Component f1744gC = Component.translatable("bf.message.select");

    /* JADX INFO: renamed from: gD */
    private static final Component f1745gD = Component.translatable("bf.message.inventory.prompt.title").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: id */
    private static final int f1746id = 50;

    /* JADX INFO: renamed from: B */
    @NotNull
    private final List<CloudItemStack> f1747B;

    /* JADX INFO: renamed from: ie */
    private final int f1748ie;

    /* JADX INFO: renamed from: bK */
    private boolean f1749bK;

    /* JADX INFO: renamed from: a */
    private C0287ei<a> f1750a;

    /* JADX INFO: renamed from: a */
    private Button f1751a;

    /* JADX INFO: renamed from: j */
    @NotNull
    private final Screen f1752j;

    public C0221dV(@NotNull Screen screen, @NotNull List<CloudItemStack> list, int i) {
        super(f1743gB);
        this.f1747B = new ObjectArrayList();
        this.f1749bK = false;
        this.f1752j = screen;
        this.f1747B.clear();
        this.f1747B.addAll(list);
        this.f1748ie = i;
    }

    @Override // com.boehmod.blockfront.C0143cG
    public void init() {
        int i = (this.width / 4) * 3;
        this.f1750a = new C0287ei<>((this.width / 2) - (i / 2), ((this.height / 2) - 25) + 10, i, 50, this);
        super.init();
        if (this.f1749bK) {
            this.f1058a.setScreen(this.f1752j);
        } else {
            this.f1749bK = true;
        }
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: K */
    public void mo776K() {
        super.mo776K();
        C0085bB c0085bB = new C0085bB((this.width / 2) - 60, this.height - 70, C0358g.f2490g, 20, f1744gC, button -> {
            List<CloudItemStack> objectArrayList = new ObjectArrayList<>();
            InterfaceC0219dT interfaceC0219dT = this.f1752j;
            if (interfaceC0219dT instanceof InterfaceC0219dT) {
                InterfaceC0219dT interfaceC0219dT2 = interfaceC0219dT;
                for (a aVar : this.f1750a.m1585h()) {
                    if ((aVar instanceof a) && aVar.f1758be) {
                        objectArrayList.add(aVar.f1753h);
                    }
                }
                this.f1058a.setScreen(this.f1752j);
                interfaceC0219dT2.mo1313b(objectArrayList);
            }
        });
        this.f1751a = c0085bB;
        addRenderableWidget(c0085bB);
        addRenderableWidget(new C0085bB(5, 18, 20, 20, Component.empty(), button2 -> {
            this.f1058a.setScreen(this.f1752j);
        }).m320a(f1037aH).m322a(20, 20).m328a(C0085bB.a.NONE).m326a(f1742gA));
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: H */
    public void mo777H() {
        super.mo777H();
        Iterator<CloudItemStack> it = this.f1747B.iterator();
        while (it.hasNext()) {
            this.f1750a.m1577a(new a(this, it.next(), 50, 50));
            this.f1750a.mo1567aq();
        }
        m794a(this.f1750a);
    }

    @Override // com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        C0396gl c0396gl = (C0396gl) this.f1057f.m2855a();
        PoseStack poseStackPose = guiGraphics.pose();
        float fM466g = C0129bt.m466g();
        int i3 = this.width / 2;
        int iM1314Z = m1314Z();
        C0555jl c0555jlM1886a = c0396gl.m1886a(this.f1058a);
        if (this.f1751a != null) {
            this.f1751a.active = iM1314Z > 0 && iM1314Z <= this.f1748ie;
        }
        if (this.f1750a != null) {
            C0129bt.m591c(guiGraphics, this.f1750a.m381r() - 1, this.f1750a.m385s() - 1, this.f1750a.m374x() + 2, this.f1750a.height() + 2, C0129bt.m465t());
            this.f1750a.mo362a(this.f1058a, this.f1057f, c0396gl, poseStackPose, guiGraphics, this.font, c0555jlM1886a, i, i2, fM466g, f);
        }
        MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.inventory.prompt.description", new Object[]{Component.literal(String.valueOf(this.f1748ie)).withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID)}).withStyle(ChatFormatting.GRAY);
        C0129bt.m483c(this.font, guiGraphics, f1745gD, i3, 60);
        C0129bt.m483c(this.font, guiGraphics, (Component) mutableComponentWithStyle, i3, 80);
    }

    /* JADX INFO: renamed from: Z */
    private int m1314Z() {
        return (int) this.f1750a.m1585h().stream().filter(aVar -> {
            return (aVar instanceof a) && aVar.f1758be;
        }).count();
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.dV$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dV$a.class */
    public static class a extends AbstractC0298et {

        /* JADX INFO: renamed from: h */
        @NotNull
        private final CloudItemStack f1753h;

        /* JADX INFO: renamed from: a */
        @NotNull
        private final C0221dV f1754a;

        /* JADX INFO: renamed from: a */
        @NotNull
        private final C0087bD f1755a;

        /* JADX INFO: renamed from: if */
        private final int f1756if;

        /* JADX INFO: renamed from: ig */
        private final int f1757ig;

        /* JADX INFO: renamed from: be */
        private boolean f1758be = false;

        public a(@NotNull C0221dV c0221dV, @NotNull CloudItemStack cloudItemStack, int i, int i2) {
            this.f1754a = c0221dV;
            this.f1753h = cloudItemStack;
            this.f1756if = i;
            this.f1757ig = i2;
            this.f1755a = new C0087bD(c0221dV, cloudItemStack, 0, 0, i, i2, false, false);
        }

        @Override // com.boehmod.blockfront.AbstractC0298et
        /* JADX INFO: renamed from: a */
        public void mo871a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, int i, int i2, int i3) {
            super.mo871a(minecraft, c0623l, c0396gl, i, i2, i3);
            if (mo865w()) {
                this.f1758be = !this.f1758be;
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7970pr.get(), 1.0f));
            }
        }

        @Override // com.boehmod.blockfront.AbstractC0298et
        /* JADX INFO: renamed from: o */
        public void mo864o(@NotNull Minecraft minecraft) {
        }

        @Override // com.boehmod.blockfront.AbstractC0298et
        /* JADX INFO: renamed from: a */
        public void mo854a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull GuiGraphics guiGraphics, @NotNull C0396gl c0396gl, @NotNull Font font, int i, int i2, float f, float f2) {
            super.mo854a(poseStack, minecraft, c0623l, guiGraphics, c0396gl, font, i, i2, f, f2);
            poseStack.pushPose();
            poseStack.translate(this.f2339iY, this.f2340iZ, 0.0f);
            this.f1755a.m349a(minecraft, guiGraphics, font, i, i2, f2);
            poseStack.popPose();
            if (this.f1758be) {
                C0129bt.m515a(guiGraphics, this.f2339iY, this.f2340iZ, mo866x(), 1, ColorReferences.COLOR_THEME_YELLOW_SOLID);
                C0129bt.m515a(guiGraphics, this.f2339iY, (this.f2340iZ + height()) - 1, mo866x(), 1, ColorReferences.COLOR_THEME_YELLOW_SOLID);
                C0129bt.m515a(guiGraphics, this.f2339iY, this.f2340iZ, 1, height(), ColorReferences.COLOR_THEME_YELLOW_SOLID);
                C0129bt.m515a(guiGraphics, (this.f2339iY + mo866x()) - 1, this.f2340iZ, 1, height(), ColorReferences.COLOR_THEME_YELLOW_SOLID);
            }
        }

        @Override // com.boehmod.blockfront.AbstractC0298et
        /* JADX INFO: renamed from: w */
        public boolean mo865w() {
            return this.f1758be || this.f1754a.m1314Z() < this.f1754a.f1748ie;
        }

        @Override // com.boehmod.blockfront.AbstractC0298et
        public int height() {
            return this.f1757ig;
        }

        @Override // com.boehmod.blockfront.AbstractC0298et
        /* JADX INFO: renamed from: x */
        public int mo866x() {
            return this.f1756if;
        }
    }
}
