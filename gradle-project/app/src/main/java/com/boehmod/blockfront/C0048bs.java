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

/* JADX INFO: renamed from: com.boehmod.blockfront.bs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bs.class */
public class C0048bs extends Button {

    @NotNull
    private static final ResourceLocation S = C0265jv.d("textures/gui/effects/fade_red.png");

    @Nullable
    protected ResourceLocation T;
    protected int cB;

    @Nullable
    protected ResourceLocation P;
    protected float cU;

    @Nullable
    protected ResourceLocation U;
    protected int cC;
    protected int cD;
    protected int cE;
    protected int cF;
    protected float cV;
    protected float cW;
    private c a;
    private int cG;
    private int cH;
    private int cI;
    private int cJ;
    private int cv;
    private boolean az;
    private float cX;

    @Nullable
    private Component D;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private Predicate<C0048bs> f65a;
    private boolean aA;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private b f66a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private a f67a;
    private boolean aB;
    private boolean aC;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private InterfaceC0046bq f68a;

    @Nullable
    private Button.OnPress b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f69a;

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

    public C0048bs(int i, int i2, int i3, int i4, @NotNull Component component, @NotNull Button.OnPress onPress) {
        super(i, i2, i3, i4, component, onPress, DEFAULT_NARRATION);
        this.T = null;
        this.cB = ColorReferences.COLOR_WHITE_SOLID;
        this.P = null;
        this.cU = 1.0f;
        this.U = null;
        this.cC = 0;
        this.cD = 0;
        this.cE = 0;
        this.cF = 0;
        this.cV = 0.0f;
        this.cW = 0.0f;
        this.a = c.DEFAULT;
        this.cG = ColorReferences.COLOR_WHITE_SOLID;
        this.cH = -7829368;
        this.cI = ColorReferences.COLOR_KILL_FEED_ENTRY_OUTLINE_COLOR_DEFAULT_BOTTOM;
        this.cJ = C0634xm.a(C0040bk.p(), 85.0f);
        this.cv = C0040bk.p();
        this.az = true;
        this.cX = 1.0f;
        this.D = null;
        this.f65a = null;
        this.aA = false;
        this.f66a = b.CENTER;
        this.f67a = a.DEFAULT;
        this.aB = true;
        this.aC = false;
        this.f69a = C0624xc.pp;
    }

    @NotNull
    public C0048bs a(int i) {
        this.cG = i;
        return this;
    }

    @NotNull
    public C0048bs a(c cVar) {
        this.a = cVar;
        return this;
    }

    @NotNull
    public C0048bs b(int i) {
        this.cH = i;
        return this;
    }

    @NotNull
    public C0048bs c(int i) {
        this.cI = i;
        return this;
    }

    @NotNull
    public C0048bs a(@NotNull Predicate<C0048bs> predicate) {
        this.f65a = predicate;
        this.active = predicate.test(this);
        return this;
    }

    @NotNull
    public C0048bs a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f69a = deferredHolder;
        return this;
    }

    @NotNull
    public C0048bs a(@NotNull Button.OnPress onPress) {
        this.b = onPress;
        return this;
    }

    @NotNull
    public C0048bs a(@NotNull ResourceLocation resourceLocation) {
        this.T = resourceLocation;
        return this;
    }

    @NotNull
    public C0048bs d(int i) {
        return a(i, i);
    }

    @NotNull
    public C0048bs a(int i, int i2) {
        this.cC = i;
        this.cD = i2;
        return this;
    }

    @NotNull
    public C0048bs b(int i, int i2) {
        this.cE = i;
        this.cF = i2;
        return this;
    }

    @NotNull
    public C0048bs a(float f, float f2) {
        this.cV = f;
        this.cW = f2;
        return this;
    }

    @NotNull
    public C0048bs a() {
        this.aB = false;
        return this;
    }

    @NotNull
    public C0048bs a(@Nullable Component component) {
        this.D = component;
        return this;
    }

    @NotNull
    public C0048bs a(@NotNull b bVar) {
        this.f66a = bVar;
        return this;
    }

    @NotNull
    public C0048bs a(@NotNull a aVar) {
        this.f67a = aVar;
        return this;
    }

    @NotNull
    public C0048bs a(@NotNull InterfaceC0046bq interfaceC0046bq) {
        this.f68a = interfaceC0046bq;
        return this;
    }

    @NotNull
    public C0048bs b(@NotNull ResourceLocation resourceLocation) {
        return a(resourceLocation, resourceLocation);
    }

    @NotNull
    public C0048bs a(@NotNull ResourceLocation resourceLocation, @NotNull ResourceLocation resourceLocation2) {
        this.P = resourceLocation;
        this.U = resourceLocation2;
        return this;
    }

    @NotNull
    public C0048bs a(float f) {
        this.cU = Mth.clamp(f, 0.0f, 1.0f);
        return this;
    }

    @NotNull
    public C0048bs a(boolean z) {
        this.aA = z;
        return this;
    }

    @NotNull
    public C0048bs b(float f) {
        this.cX = f;
        return this;
    }

    @NotNull
    public C0048bs e(int i) {
        this.cv = i;
        return this;
    }

    @NotNull
    public C0048bs b() {
        this.az = false;
        return this;
    }

    public void playDownSound(@NotNull SoundManager soundManager) {
        if (this.f69a != null) {
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) this.f69a.get(), (float) (0.800000011920929d + (0.20000000298023224d * Math.random()))));
        }
    }

    public void renderWidget(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        float fG = C0040bk.g();
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        boolean z = minecraft.screen != null && minecraft.screen.renderables.contains(this);
        Screen screen = minecraft.screen;
        if ((screen instanceof C0080cx) && ((C0080cx) screen).a(this)) {
            z = true;
        }
        this.isHovered = this.active && z && i >= getX() && i2 >= getY() && i < getX() + this.width && i2 < getY() + this.height;
        if (this.f65a != null) {
            this.active = this.f65a.test(this);
        }
        if (this.visible) {
            if (this.isHovered) {
                if (!this.aC && this.aB && this.active) {
                    this.aC = true;
                    minecraft.getNarrator().sayNow(Component.literal(ChatFormatting.stripFormatting(getMessage().getString() + (this.D != null ? ", " + this.D.getString() : ""))));
                    minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pq.get(), (float) (0.8999999761581421d + (0.10000000149011612d * Math.random()))));
                    if (this.b != null) {
                        this.b.onPress(this);
                    }
                }
            } else {
                this.aC = false;
            }
            PoseStack poseStackPose = guiGraphics.pose();
            a(guiGraphics, poseStackPose, i, i2, fG, f);
            a(poseStackPose, font, guiGraphics, i, i2, f);
        }
    }

    public void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        int width = getWidth() / 2;
        int i3 = this.height / 2;
        MutableComponent mutableComponentCopy = getMessage().copy();
        float fQ = q();
        float fWidth = font.width(mutableComponentCopy) * fQ;
        Objects.requireNonNull(font);
        float f2 = 9.0f * this.cX;
        float x = 0.0f;
        float y = 0.0f;
        switch (this.f66a) {
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
        float f3 = x + this.cV;
        float f4 = y + this.cW;
        switch (this.a) {
            case DEFAULT:
                C0040bk.a(poseStack, font, guiGraphics, (Component) mutableComponentCopy, f3, f4, r(), fQ);
                break;
            case SHADOW:
                C0040bk.b(poseStack, font, guiGraphics, (Component) mutableComponentCopy, f3, f4, r(), fQ);
                break;
        }
    }

    public void a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        Screen screen = minecraft.screen;
        boolean z = (screen instanceof C0080cx) && ((C0080cx) screen).a(this);
        if (minecraft.screen != null) {
            if (z || minecraft.screen.renderables.contains(this)) {
                a(poseStack, font, guiGraphics, f);
                a(font, guiGraphics, i, i2);
            }
        }
    }

    private void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, float f) {
        int notificationCount;
        if (this.f68a != null && (notificationCount = this.f68a.getNotificationCount()) > 0) {
            int x = getX() + this.width;
            int y = getY();
            float fSin = Mth.sin(f / 10.0f);
            MutableComponent mutableComponentWithColor = Component.literal(String.valueOf(notificationCount)).withStyle(C0266jw.b).withColor(ColorReferences.COLOR_WHITE);
            C0040bk.b(poseStack, guiGraphics, S, x, y, 12, 12);
            C0040bk.b(poseStack, guiGraphics, S, x, y, 24, 24, 0.0f, fSin);
            C0040bk.a(guiGraphics, x - 3, y - 3, 6, 6, ColorReferences.COLOR_BLACK_SOLID + C0040bk.bC);
            C0040bk.a(poseStack, font, guiGraphics, (Component) mutableComponentWithColor, x - 1, y - 1.5f, 0.5f);
        }
    }

    public void a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, int i, int i2, float f, float f2) {
        int iS = s();
        int height = getHeight();
        int width = getWidth();
        int x = getX();
        int y = getY();
        switch (this.f67a.ordinal()) {
            case 1:
                C0040bk.c(guiGraphics, x, y, width, height, iS);
                break;
            case 2:
                C0040bk.a(guiGraphics, x + 1, y, width - 2, 1, iS);
                C0040bk.a(guiGraphics, x, y + 1, width, height - 2, iS);
                C0040bk.a(guiGraphics, x + 1, (y + height) - 1, width - 2, 1, iS);
                break;
            case 3:
                break;
            default:
                C0040bk.a(guiGraphics, x, y, width, height, iS);
                break;
        }
        ResourceLocation resourceLocation = (!this.isHovered || this.U == null) ? this.P : this.U;
        ResourceLocation resourceLocation2 = resourceLocation;
        if (resourceLocation2 != null) {
            C0040bk.a(poseStack, guiGraphics, resourceLocation2, x, y, width, height, this.cU);
        }
        a(poseStack, guiGraphics);
        if (this.aA) {
            C0040bk.a(guiGraphics, x, y, width, height, C0040bk.p());
        }
    }

    public void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics) {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        if (this.T != null) {
            C0040bk.b(poseStack, guiGraphics, this.T, getX() + width + this.cE, getY() + height + this.cF, this.cC, this.cD, 0.0f, (isHoveredOrFocused() || !this.active) ? 0.5f : 1.0f, this.cB);
        }
    }

    public int r() {
        if (!this.active) {
            return this.cI;
        }
        if (this.az) {
            return this.isHovered ? this.cH : this.cG;
        }
        return this.cG;
    }

    public C0048bs f(int i) {
        this.cJ = i;
        return this;
    }

    public float q() {
        return this.cX;
    }

    public int s() {
        return this.isHovered ? this.cJ : this.cv;
    }

    public void a(@NotNull Font font, @NotNull GuiGraphics guiGraphics, int i, int i2) {
        if (this.D != null && this.active && this.visible && this.isHovered) {
            guiGraphics.renderTooltip(font, this.D, i, i2);
        }
    }

    public int getHeight() {
        return this.height;
    }
}
