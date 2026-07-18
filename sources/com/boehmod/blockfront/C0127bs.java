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

/* JADX INFO: renamed from: com.boehmod.blockfront.bs */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bs.class */
public class C0127bs extends Button {

    /* JADX INFO: renamed from: S */
    @NotNull
    private static final ResourceLocation f890S = C0564jv.m2555d("textures/gui/effects/fade_red.png");

    /* JADX INFO: renamed from: T */
    @Nullable
    protected ResourceLocation f891T;

    /* JADX INFO: renamed from: cB */
    protected int f892cB;

    /* JADX INFO: renamed from: P */
    @Nullable
    protected ResourceLocation f893P;

    /* JADX INFO: renamed from: cU */
    protected float f894cU;

    /* JADX INFO: renamed from: U */
    @Nullable
    protected ResourceLocation f895U;

    /* JADX INFO: renamed from: cC */
    protected int f896cC;

    /* JADX INFO: renamed from: cD */
    protected int f897cD;

    /* JADX INFO: renamed from: cE */
    protected int f898cE;

    /* JADX INFO: renamed from: cF */
    protected int f899cF;

    /* JADX INFO: renamed from: cV */
    protected float f900cV;

    /* JADX INFO: renamed from: cW */
    protected float f901cW;

    /* JADX INFO: renamed from: a */
    private c f902a;

    /* JADX INFO: renamed from: cG */
    private int f903cG;

    /* JADX INFO: renamed from: cH */
    private int f904cH;

    /* JADX INFO: renamed from: cI */
    private int f905cI;

    /* JADX INFO: renamed from: cJ */
    private int f906cJ;

    /* JADX INFO: renamed from: cv */
    private int f907cv;

    /* JADX INFO: renamed from: az */
    private boolean f908az;

    /* JADX INFO: renamed from: cX */
    private float f909cX;

    /* JADX INFO: renamed from: D */
    @Nullable
    private Component f910D;

    /* JADX INFO: renamed from: a */
    @Nullable
    private Predicate<C0127bs> f911a;

    /* JADX INFO: renamed from: aA */
    private boolean f912aA;

    /* JADX INFO: renamed from: a */
    @NotNull
    private b f913a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private a f914a;

    /* JADX INFO: renamed from: aB */
    private boolean f915aB;

    /* JADX INFO: renamed from: aC */
    private boolean f916aC;

    /* JADX INFO: renamed from: a */
    @Nullable
    private InterfaceC0125bq f917a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private Button.OnPress f918b;

    /* JADX INFO: renamed from: a */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f919a;

    /* JADX INFO: renamed from: com.boehmod.blockfront.bs$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bs$a.class */
    public enum a {
        DEFAULT,
        SHADOW,
        FANCY,
        NONE
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.bs$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bs$b.class */
    public enum b {
        LEFT,
        CENTER,
        RIGHT,
        CENTER_BOTTOM
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.bs$c */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bs$c.class */
    public enum c {
        DEFAULT,
        SHADOW
    }

    public C0127bs(int i, int i2, int i3, int i4, @NotNull Component component, @NotNull Button.OnPress onPress) {
        super(i, i2, i3, i4, component, onPress, DEFAULT_NARRATION);
        this.f891T = null;
        this.f892cB = ColorReferences.COLOR_WHITE_SOLID;
        this.f893P = null;
        this.f894cU = 1.0f;
        this.f895U = null;
        this.f896cC = 0;
        this.f897cD = 0;
        this.f898cE = 0;
        this.f899cF = 0;
        this.f900cV = 0.0f;
        this.f901cW = 0.0f;
        this.f902a = c.DEFAULT;
        this.f903cG = ColorReferences.COLOR_WHITE_SOLID;
        this.f904cH = -7829368;
        this.f905cI = ColorReferences.COLOR_KILL_FEED_ENTRY_OUTLINE_COLOR_DEFAULT_BOTTOM;
        this.f906cJ = C1290xm.m7833a(C0119bk.m365p(), 85.0f);
        this.f907cv = C0119bk.m365p();
        this.f908az = true;
        this.f909cX = 1.0f;
        this.f910D = null;
        this.f911a = null;
        this.f912aA = false;
        this.f913a = b.CENTER;
        this.f914a = a.DEFAULT;
        this.f915aB = true;
        this.f916aC = false;
        this.f919a = C1280xc.f7558pp;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0127bs m638a(int i) {
        this.f903cG = i;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0127bs m639a(c cVar) {
        this.f902a = cVar;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0127bs m640b(int i) {
        this.f904cH = i;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public C0127bs m641c(int i) {
        this.f905cI = i;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0127bs m642a(@NotNull Predicate<C0127bs> predicate) {
        this.f911a = predicate;
        this.active = predicate.test(this);
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0127bs m643a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f919a = deferredHolder;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0127bs m644a(@NotNull Button.OnPress onPress) {
        this.f918b = onPress;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0127bs m645a(@NotNull ResourceLocation resourceLocation) {
        this.f891T = resourceLocation;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public C0127bs m646d(int i) {
        return m647a(i, i);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0127bs m647a(int i, int i2) {
        this.f896cC = i;
        this.f897cD = i2;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0127bs m648b(int i, int i2) {
        this.f898cE = i;
        this.f899cF = i2;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0127bs m649a(float f, float f2) {
        this.f900cV = f;
        this.f901cW = f2;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0127bs mo650a() {
        this.f915aB = false;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0127bs m651a(@Nullable Component component) {
        this.f910D = component;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0127bs m652a(@NotNull b bVar) {
        this.f913a = bVar;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0127bs m653a(@NotNull a aVar) {
        this.f914a = aVar;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0127bs m654a(@NotNull InterfaceC0125bq interfaceC0125bq) {
        this.f917a = interfaceC0125bq;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0127bs m655b(@NotNull ResourceLocation resourceLocation) {
        return m656a(resourceLocation, resourceLocation);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0127bs m656a(@NotNull ResourceLocation resourceLocation, @NotNull ResourceLocation resourceLocation2) {
        this.f893P = resourceLocation;
        this.f895U = resourceLocation2;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0127bs m657a(float f) {
        this.f894cU = Mth.clamp(f, 0.0f, 1.0f);
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0127bs m658a(boolean z) {
        this.f912aA = z;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0127bs m659b(float f) {
        this.f909cX = f;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public C0127bs m660e(int i) {
        this.f907cv = i;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0127bs m661b() {
        this.f908az = false;
        return this;
    }

    public void playDownSound(@NotNull SoundManager soundManager) {
        if (this.f919a != null) {
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) this.f919a.get(), (float) (0.800000011920929d + (0.20000000298023224d * Math.random()))));
        }
    }

    public void renderWidget(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        float fM366g = C0119bk.m366g();
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        boolean z = minecraft.screen != null && minecraft.screen.renderables.contains(this);
        Screen screen = minecraft.screen;
        if ((screen instanceof C0195cx) && ((C0195cx) screen).m1196a(this)) {
            z = true;
        }
        this.isHovered = this.active && z && i >= getX() && i2 >= getY() && i < getX() + this.width && i2 < getY() + this.height;
        if (this.f911a != null) {
            this.active = this.f911a.test(this);
        }
        if (this.visible) {
            if (this.isHovered) {
                if (!this.f916aC && this.f915aB && this.active) {
                    this.f916aC = true;
                    minecraft.getNarrator().sayNow(Component.literal(ChatFormatting.stripFormatting(getMessage().getString() + (this.f910D != null ? ", " + this.f910D.getString() : ""))));
                    minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7559pq.get(), (float) (0.8999999761581421d + (0.10000000149011612d * Math.random()))));
                    if (this.f918b != null) {
                        this.f918b.onPress(this);
                    }
                }
            } else {
                this.f916aC = false;
            }
            PoseStack poseStackPose = guiGraphics.pose();
            mo636a(guiGraphics, poseStackPose, i, i2, fM366g, f);
            mo662a(poseStackPose, font, guiGraphics, i, i2, f);
        }
    }

    /* JADX INFO: renamed from: a */
    public void mo662a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        int width = getWidth() / 2;
        int i3 = this.height / 2;
        MutableComponent mutableComponentCopy = getMessage().copy();
        float fM667q = m667q();
        float fWidth = font.width(mutableComponentCopy) * fM667q;
        Objects.requireNonNull(font);
        float f2 = 9.0f * this.f909cX;
        float x = 0.0f;
        float y = 0.0f;
        switch (this.f913a) {
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
        float f3 = x + this.f900cV;
        float f4 = y + this.f901cW;
        switch (this.f902a) {
            case DEFAULT:
                C0119bk.m388a(poseStack, font, guiGraphics, (Component) mutableComponentCopy, f3, f4, mo637r(), fM667q);
                break;
            case SHADOW:
                C0119bk.m389b(poseStack, font, guiGraphics, (Component) mutableComponentCopy, f3, f4, mo637r(), fM667q);
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m663a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        Screen screen = minecraft.screen;
        boolean z = (screen instanceof C0195cx) && ((C0195cx) screen).m1196a(this);
        if (minecraft.screen != null) {
            if (z || minecraft.screen.renderables.contains(this)) {
                m664a(poseStack, font, guiGraphics, f);
                m669a(font, guiGraphics, i, i2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m664a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, float f) {
        int notificationCount;
        if (this.f917a != null && (notificationCount = this.f917a.getNotificationCount()) > 0) {
            int x = getX() + this.width;
            int y = getY();
            float fSin = Mth.sin(f / 10.0f);
            MutableComponent mutableComponentWithColor = Component.literal(String.valueOf(notificationCount)).withStyle(C0565jw.f3201b).withColor(ColorReferences.COLOR_WHITE);
            C0119bk.m441b(poseStack, guiGraphics, f890S, x, y, 12, 12);
            C0119bk.m445b(poseStack, guiGraphics, f890S, x, y, 24, 24, 0.0f, fSin);
            C0119bk.m415a(guiGraphics, x - 3, y - 3, 6, 6, ColorReferences.COLOR_BLACK_SOLID + C0119bk.f726bC);
            C0119bk.m386a(poseStack, font, guiGraphics, (Component) mutableComponentWithColor, x - 1, y - 1.5f, 0.5f);
        }
    }

    /* JADX INFO: renamed from: a */
    public void mo636a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, int i, int i2, float f, float f2) {
        int iMo668s = mo668s();
        int height = getHeight();
        int width = getWidth();
        int x = getX();
        int y = getY();
        switch (this.f914a.ordinal()) {
            case 1:
                C0119bk.m491c(guiGraphics, x, y, width, height, iMo668s);
                break;
            case 2:
                C0119bk.m415a(guiGraphics, x + 1, y, width - 2, 1, iMo668s);
                C0119bk.m415a(guiGraphics, x, y + 1, width, height - 2, iMo668s);
                C0119bk.m415a(guiGraphics, x + 1, (y + height) - 1, width - 2, 1, iMo668s);
                break;
            case 3:
                break;
            default:
                C0119bk.m415a(guiGraphics, x, y, width, height, iMo668s);
                break;
        }
        ResourceLocation resourceLocation = (!this.isHovered || this.f895U == null) ? this.f893P : this.f895U;
        ResourceLocation resourceLocation2 = resourceLocation;
        if (resourceLocation2 != null) {
            C0119bk.m433a(poseStack, guiGraphics, resourceLocation2, x, y, width, height, this.f894cU);
        }
        m665a(poseStack, guiGraphics);
        if (this.f912aA) {
            C0119bk.m415a(guiGraphics, x, y, width, height, C0119bk.m365p());
        }
    }

    /* JADX INFO: renamed from: a */
    public void m665a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics) {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        if (this.f891T != null) {
            C0119bk.m447b(poseStack, guiGraphics, this.f891T, getX() + width + this.f898cE, getY() + height + this.f899cF, this.f896cC, this.f897cD, 0.0f, (isHoveredOrFocused() || !this.active) ? 0.5f : 1.0f, this.f892cB);
        }
    }

    /* JADX INFO: renamed from: r */
    public int mo637r() {
        if (!this.active) {
            return this.f905cI;
        }
        if (this.f908az) {
            return this.isHovered ? this.f904cH : this.f903cG;
        }
        return this.f903cG;
    }

    /* JADX INFO: renamed from: f */
    public C0127bs m666f(int i) {
        this.f906cJ = i;
        return this;
    }

    /* JADX INFO: renamed from: q */
    public float m667q() {
        return this.f909cX;
    }

    /* JADX INFO: renamed from: s */
    public int mo668s() {
        return this.isHovered ? this.f906cJ : this.f907cv;
    }

    /* JADX INFO: renamed from: a */
    public void m669a(@NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2) {
        if (this.f910D != null && this.active && this.visible && this.isHovered) {
            guiGraphics.renderTooltip(font, this.f910D, i, i2);
        }
    }

    public int getHeight() {
        return this.height;
    }
}
