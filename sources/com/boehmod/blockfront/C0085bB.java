package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Objects;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bB.class */
public class C0085bB extends Button {

    /* JADX INFO: renamed from: S */
    @NotNull
    private static final ResourceLocation f529S = C0532jO.m2378d("textures/gui/effects/fade_red.png");

    /* JADX INFO: renamed from: T */
    @Nullable
    protected ResourceLocation f530T;

    /* JADX INFO: renamed from: dt */
    protected int f531dt;

    /* JADX INFO: renamed from: P */
    @Nullable
    protected ResourceLocation f532P;

    /* JADX INFO: renamed from: da */
    protected float f533da;

    /* JADX INFO: renamed from: U */
    @Nullable
    protected ResourceLocation f534U;

    /* JADX INFO: renamed from: du */
    protected int f535du;

    /* JADX INFO: renamed from: dv */
    protected int f536dv;

    /* JADX INFO: renamed from: dw */
    protected int f537dw;

    /* JADX INFO: renamed from: dx */
    protected int f538dx;

    /* JADX INFO: renamed from: db */
    protected float f539db;

    /* JADX INFO: renamed from: dc */
    protected float f540dc;

    /* JADX INFO: renamed from: a */
    private c f541a;

    /* JADX INFO: renamed from: dy */
    private int f542dy;

    /* JADX INFO: renamed from: dz */
    private int f543dz;

    /* JADX INFO: renamed from: dA */
    private int f544dA;

    /* JADX INFO: renamed from: dB */
    private int f545dB;

    /* JADX INFO: renamed from: dn */
    private int f546dn;

    /* JADX INFO: renamed from: aE */
    private boolean f547aE;

    /* JADX INFO: renamed from: dd */
    private float f548dd;

    /* JADX INFO: renamed from: D */
    @Nullable
    private Component f549D;

    /* JADX INFO: renamed from: a */
    @Nullable
    private Predicate<C0085bB> f550a;

    /* JADX INFO: renamed from: aF */
    private boolean f551aF;

    /* JADX INFO: renamed from: a */
    @NotNull
    private b f552a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private a f553a;

    /* JADX INFO: renamed from: aG */
    private boolean f554aG;

    /* JADX INFO: renamed from: aH */
    private boolean f555aH;

    /* JADX INFO: renamed from: a */
    @Nullable
    private InterfaceC0135bz f556a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private Button.OnPress f557b;

    /* JADX INFO: renamed from: a */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f558a;

    /* JADX INFO: renamed from: com.boehmod.blockfront.bB$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bB$a.class */
    public enum a {
        DEFAULT,
        SHADOW,
        FANCY,
        NONE
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.bB$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bB$b.class */
    public enum b {
        LEFT,
        CENTER,
        RIGHT,
        CENTER_BOTTOM
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.bB$c */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bB$c.class */
    public enum c {
        DEFAULT,
        SHADOW
    }

    public C0085bB(int i, int i2, int i3, int i4, @NotNull Component component, @NotNull Button.OnPress onPress) {
        super(i, i2, i3, i4, component, onPress, DEFAULT_NARRATION);
        this.f530T = null;
        this.f531dt = ColorReferences.COLOR_WHITE_SOLID;
        this.f532P = null;
        this.f533da = 1.0f;
        this.f534U = null;
        this.f535du = 0;
        this.f536dv = 0;
        this.f537dw = 0;
        this.f538dx = 0;
        this.f539db = 0.0f;
        this.f540dc = 0.0f;
        this.f541a = c.DEFAULT;
        this.f542dy = ColorReferences.COLOR_WHITE_SOLID;
        this.f543dz = -7829368;
        this.f544dA = ColorReferences.COLOR_KILL_FEED_ENTRY_OUTLINE_COLOR_DEFAULT_BOTTOM;
        this.f545dB = C1270xJ.m7159a(C0129bt.m465t(), 85.0f);
        this.f546dn = C0129bt.m465t();
        this.f547aE = true;
        this.f548dd = 1.0f;
        this.f549D = null;
        this.f550a = null;
        this.f551aF = false;
        this.f552a = b.CENTER;
        this.f553a = a.DEFAULT;
        this.f554aG = true;
        this.f555aH = false;
        this.f558a = C1312xz.f7970pr;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0085bB m313a(int i) {
        this.f542dy = i;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0085bB m314a(c cVar) {
        this.f541a = cVar;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0085bB m315b(int i) {
        this.f543dz = i;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public C0085bB m316c(int i) {
        this.f544dA = i;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0085bB m317a(@NotNull Predicate<C0085bB> predicate) {
        this.f550a = predicate;
        this.active = predicate.test(this);
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0085bB m318a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f558a = deferredHolder;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0085bB m319a(@NotNull Button.OnPress onPress) {
        this.f557b = onPress;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0085bB m320a(@NotNull ResourceLocation resourceLocation) {
        this.f530T = resourceLocation;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public C0085bB m321d(int i) {
        return m322a(i, i);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0085bB m322a(int i, int i2) {
        this.f535du = i;
        this.f536dv = i2;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0085bB m323b(int i, int i2) {
        this.f537dw = i;
        this.f538dx = i2;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0085bB m324a(float f, float f2) {
        this.f539db = f;
        this.f540dc = f2;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0085bB mo325a() {
        this.f554aG = false;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0085bB m326a(@Nullable Component component) {
        this.f549D = component;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0085bB m327a(@NotNull b bVar) {
        this.f552a = bVar;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0085bB m328a(@NotNull a aVar) {
        this.f553a = aVar;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0085bB m329a(@NotNull InterfaceC0135bz interfaceC0135bz) {
        this.f556a = interfaceC0135bz;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0085bB m330b(@NotNull ResourceLocation resourceLocation) {
        return m331a(resourceLocation, resourceLocation);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0085bB m331a(@NotNull ResourceLocation resourceLocation, @NotNull ResourceLocation resourceLocation2) {
        this.f532P = resourceLocation;
        this.f534U = resourceLocation2;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0085bB m332a(float f) {
        this.f533da = Mth.clamp(f, 0.0f, 1.0f);
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0085bB m333a(boolean z) {
        this.f551aF = z;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0085bB m334b(float f) {
        this.f548dd = f;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public C0085bB m335e(int i) {
        this.f546dn = i;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0085bB m336b() {
        this.f547aE = false;
        return this;
    }

    public void playDownSound(@NotNull SoundManager soundManager) {
        if (this.f558a != null) {
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) this.f558a.get(), (float) (0.800000011920929d + (0.20000000298023224d * Math.random()))));
        }
    }

    public void renderWidget(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        float fM466g = C0129bt.m466g();
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        boolean z = minecraft.screen != null && minecraft.screen.renderables.contains(this);
        Screen screen = minecraft.screen;
        if ((screen instanceof C0143cG) && ((C0143cG) screen).m795a(this)) {
            z = true;
        }
        this.isHovered = this.active && z && i >= getX() && i2 >= getY() && i < getX() + this.width && i2 < getY() + this.height;
        if (this.f550a != null) {
            this.active = this.f550a.test(this);
        }
        if (this.visible) {
            if (this.isHovered) {
                if (!this.f555aH && this.f554aG && this.active) {
                    this.f555aH = true;
                    minecraft.getNarrator().sayNow(Component.literal(ChatFormatting.stripFormatting(getMessage().getString() + (this.f549D != null ? ", " + this.f549D.getString() : ""))));
                    minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7971ps.get(), (float) (0.8999999761581421d + (0.10000000149011612d * Math.random()))));
                    if (this.f557b != null) {
                        this.f557b.onPress(this);
                    }
                }
            } else {
                this.f555aH = false;
            }
            PoseStack poseStackPose = guiGraphics.pose();
            mo311a(guiGraphics, poseStackPose, i, i2, fM466g, f);
            mo337a(poseStackPose, font, guiGraphics, i, i2, f);
        }
    }

    /* JADX INFO: renamed from: a */
    public void mo337a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        int width = getWidth() / 2;
        int i3 = this.height / 2;
        MutableComponent mutableComponentCopy = getMessage().copy();
        float fM342q = m342q();
        float fWidth = font.width(mutableComponentCopy) * fM342q;
        Objects.requireNonNull(font);
        float f2 = 9.0f * this.f548dd;
        float x = 0.0f;
        float y = 0.0f;
        switch (this.f552a) {
            case LEFT:
                x = getX() + 4;
                y = getY() + 4;
                break;
            case CENTER:
                x = (getX() + width) - (fWidth / 2.0f);
                y = (getY() + i3) - (f2 / 2.0f);
                break;
            case RIGHT:
                x = ((getX() + getWidth()) - fWidth) - 4.0f;
                y = getY() + 4;
                break;
            case CENTER_BOTTOM:
                x = (getX() + width) - (fWidth / 2.0f);
                y = ((getY() + this.height) - f2) - 4.0f;
                break;
        }
        float f3 = x + this.f539db;
        float f4 = y + this.f540dc;
        switch (this.f541a) {
            case DEFAULT:
                C0129bt.m488a(poseStack, font, guiGraphics, (Component) mutableComponentCopy, f3, f4, mo312v(), fM342q);
                break;
            case SHADOW:
                C0129bt.m489b(poseStack, font, guiGraphics, (Component) mutableComponentCopy, f3, f4, mo312v(), fM342q);
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m338a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        Screen screen = minecraft.screen;
        boolean z = (screen instanceof C0143cG) && ((C0143cG) screen).m795a(this);
        if (minecraft.screen != null) {
            if (z || minecraft.screen.renderables.contains(this)) {
                m339a(poseStack, font, guiGraphics, f);
                m344a(font, guiGraphics, i, i2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m339a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, float f) {
        int notificationCount;
        if (this.f556a != null && (notificationCount = this.f556a.getNotificationCount()) > 0) {
            int x = getX() + this.width;
            int y = getY();
            float fSin = Mth.sin(f / 10.0f);
            MutableComponent mutableComponentWithColor = Component.literal(String.valueOf(notificationCount)).withStyle(C0533jP.f3185b).withColor(ColorReferences.COLOR_WHITE);
            C0129bt.m541b(poseStack, guiGraphics, f529S, x, y, 12, 12);
            C0129bt.m545b(poseStack, guiGraphics, f529S, x, y, 24, 24, 0.0f, fSin);
            C0129bt.m515a(guiGraphics, x - 3, y - 3, 6, 6, ColorReferences.COLOR_BLACK_SOLID + C0129bt.f861cu);
            C0129bt.m486a(poseStack, font, guiGraphics, (Component) mutableComponentWithColor, x - 1, y - 1.5f, 0.5f);
        }
    }

    /* JADX INFO: renamed from: a */
    public void mo311a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, int i, int i2, float f, float f2) {
        int iMo343w = mo343w();
        int height = getHeight();
        int width = getWidth();
        int x = getX();
        int y = getY();
        switch (this.f553a.ordinal()) {
            case 1:
                C0129bt.m591c(guiGraphics, x, y, width, height, iMo343w);
                break;
            case 2:
                C0129bt.m518b(guiGraphics, x, y, width, height, iMo343w);
                break;
            case 3:
                break;
            default:
                C0129bt.m515a(guiGraphics, x, y, width, height, iMo343w);
                break;
        }
        ResourceLocation resourceLocation = (!this.isHovered || this.f534U == null) ? this.f532P : this.f534U;
        ResourceLocation resourceLocation2 = resourceLocation;
        if (resourceLocation2 != null) {
            C0129bt.m533a(poseStack, guiGraphics, resourceLocation2, x, y, width, height, this.f533da);
        }
        m340a(poseStack, guiGraphics);
        if (this.f551aF) {
            C0129bt.m515a(guiGraphics, x, y, width, height, C0129bt.m465t());
        }
    }

    /* JADX INFO: renamed from: a */
    public void m340a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics) {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        if (this.f530T != null) {
            C0129bt.m547b(poseStack, guiGraphics, this.f530T, getX() + width + this.f537dw, getY() + height + this.f538dx, this.f535du, this.f536dv, 0.0f, (isHoveredOrFocused() || !this.active) ? 0.5f : 1.0f, this.f531dt);
        }
    }

    /* JADX INFO: renamed from: v */
    public int mo312v() {
        if (!this.active) {
            return this.f544dA;
        }
        if (this.f547aE) {
            return this.isHovered ? this.f543dz : this.f542dy;
        }
        return this.f542dy;
    }

    /* JADX INFO: renamed from: f */
    public C0085bB m341f(int i) {
        this.f545dB = i;
        return this;
    }

    /* JADX INFO: renamed from: q */
    public float m342q() {
        return this.f548dd;
    }

    /* JADX INFO: renamed from: w */
    public int mo343w() {
        return this.isHovered ? this.f545dB : this.f546dn;
    }

    /* JADX INFO: renamed from: a */
    public void m344a(@NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2) {
        if (this.f549D != null && this.active && this.visible && this.isHovered) {
            guiGraphics.renderTooltip(font, this.f549D, i, i2);
        }
    }

    public int getHeight() {
        return this.height;
    }
}
