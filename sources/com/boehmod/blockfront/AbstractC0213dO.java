package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.bflib.common.PatternReferences;
import com.boehmod.blockfront.C0127bs;
import com.mojang.blaze3d.vertex.PoseStack;
import java.awt.Rectangle;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dO.class */
public abstract class AbstractC0213dO extends AbstractC0211dM {

    /* JADX INFO: renamed from: gB */
    private static final Component f1751gB = Component.translatable("bf.menu.button.close");

    /* JADX INFO: renamed from: gC */
    private static final Component f1752gC = Component.translatable("bf.menu.button.confirm");

    /* JADX INFO: renamed from: gD */
    private static final Component f1753gD = Component.translatable("bf.textprompt.empty");

    /* JADX INFO: renamed from: gE */
    private static final Component f1754gE = Component.translatable("bf.textprompt.error.anything");

    /* JADX INFO: renamed from: gF */
    private static final Component f1755gF = Component.translatable("bf.textprompt.error.alphanumeric");

    /* JADX INFO: renamed from: gG */
    private static final Component f1756gG = Component.translatable("bf.textprompt.error.numeric");

    /* JADX INFO: renamed from: gH */
    private static final Component f1757gH = Component.translatable("bf.textprompt.error.common");

    /* JADX INFO: renamed from: gI */
    private static final Component f1758gI = Component.translatable("bf.textprompt.error.mc.uuid");

    /* JADX INFO: renamed from: gJ */
    private static final Component f1759gJ = Component.translatable("bf.textprompt.error.mc.username");

    /* JADX INFO: renamed from: gK */
    private static final Component f1760gK = Component.translatable("bf.textprompt.error.uppercase");

    /* JADX INFO: renamed from: gL */
    private static final Component f1761gL = Component.translatable("bf.textprompt.error.lowercase");

    /* JADX INFO: renamed from: gM */
    private static final Component f1762gM = Component.translatable("bf.textprompt.error.mc.resource");

    /* JADX INFO: renamed from: gN */
    private static final Component f1763gN = Component.translatable("bf.textprompt.error.mc.resource");

    /* JADX INFO: renamed from: gO */
    private static final Component f1764gO = Component.translatable("bf.textprompt.error.clan.name", new Object[]{2, 4});

    /* JADX INFO: renamed from: a */
    @NotNull
    private final EnumSet<a> f1765a;

    /* JADX INFO: renamed from: f */
    public EditBox f1766f;

    /* JADX INFO: renamed from: hf */
    private int f1767hf;

    /* JADX INFO: renamed from: hg */
    public int f1768hg;

    /* JADX INFO: renamed from: hh */
    public int f1769hh;

    /* JADX INFO: renamed from: Q */
    public String f1770Q;

    /* JADX INFO: renamed from: bH */
    private boolean f1771bH;

    /* JADX INFO: renamed from: bI */
    public boolean f1772bI;

    /* JADX INFO: renamed from: hi */
    protected int f1773hi;

    /* JADX INFO: renamed from: hj */
    protected int f1774hj;

    /* JADX INFO: renamed from: cf */
    @Nullable
    protected Component f1775cf;

    /* JADX INFO: renamed from: hk */
    private int f1776hk;

    /* JADX INFO: renamed from: U */
    public abstract void mo888U();

    public AbstractC0213dO(@Nullable Screen screen, @NotNull Component component) {
        super(screen, component);
        this.f1767hf = -1;
        this.f1768hg = 200;
        this.f1769hh = 20;
        this.f1770Q = "";
        this.f1771bH = false;
        this.f1772bI = false;
        this.f1775cf = null;
        this.f1776hk = 0;
        this.f1765a = EnumSet.noneOf(a.class);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0213dO m1277a(@NotNull a aVar) {
        this.f1765a.add(aVar);
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0213dO m1278a(boolean z) {
        this.f1771bH = z;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0213dO m1279a(int i) {
        this.f1767hf = i;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0213dO m1280a(@NotNull a[] aVarArr) {
        for (a aVar : aVarArr) {
            m1277a(aVar);
        }
        return this;
    }

    /* JADX INFO: renamed from: ai */
    public void m1281ai() {
        String value = this.f1766f.getValue();
        this.f1775cf = null;
        if (value.isEmpty() && !this.f1772bI) {
            this.f1775cf = f1753gD;
        }
        boolean z = false;
        if (!value.isEmpty()) {
            Iterator it = this.f1765a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a aVar = (a) it.next();
                if (!aVar.isValid(this.f1587b, this, value)) {
                    this.f1775cf = aVar.getErrorMessage();
                } else {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            this.f1775cf = null;
        }
        if (this.f1767hf != -1 && value.length() > this.f1767hf) {
            this.f1775cf = Component.translatable("bf.textprompt.error.length", new Object[]{Integer.valueOf(this.f1767hf)});
        }
        if (this.f1775cf != null) {
            this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7551pi.get(), 1.0f));
        } else {
            mo1276J();
            mo888U();
        }
    }

    /* JADX INFO: renamed from: Q */
    public int m1282Q() {
        return this.f1767hf;
    }

    @NotNull
    /* JADX INFO: renamed from: o */
    public String m1283o() {
        return this.f1766f.getValue();
    }

    @Override // com.boehmod.blockfront.AbstractC0211dM, com.boehmod.blockfront.AbstractC0194cw, com.boehmod.blockfront.C0195cx
    public void init() {
        super.init();
        this.f1766f = new EditBox(this.font, (this.width / 2) - (this.f1768hg / 2), 85 + (11 * this.f1744B.size()), this.f1768hg, this.f1769hh, Component.empty());
        this.f1766f.setMaxLength(this.f1767hf == -1 ? 999 : this.f1767hf);
        this.f1766f.setValue(this.f1770Q);
        this.f1766f.setFocused(true);
    }

    @Override // com.boehmod.blockfront.AbstractC0211dM, com.boehmod.blockfront.AbstractC0194cw, com.boehmod.blockfront.C0195cx
    public void tick() {
        super.tick();
        if (m1189c(this.f1587b)) {
            if (this.f1776hk >= 15) {
                this.f1766f.deleteChars(-1);
            } else {
                this.f1776hk++;
            }
        } else {
            this.f1776hk = 0;
        }
        if (m1187a(this.f1587b)) {
            m1281ai();
        }
    }

    @Override // com.boehmod.blockfront.C0195cx
    public boolean keyPressed(int i, int i2, int i3) {
        this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7557po.get(), 1.0f, 1.0f));
        this.f1766f.keyPressed(i, i2, i3);
        return super.keyPressed(i, i2, i3);
    }

    public boolean charTyped(char c, int i) {
        this.f1766f.charTyped(c, i);
        return super.charTyped(c, i);
    }

    @Override // com.boehmod.blockfront.AbstractC0211dM, com.boehmod.blockfront.C0195cx
    public boolean mouseClicked(double d, double d2, int i) {
        this.f1766f.mouseClicked(d, d2, i);
        if (new Rectangle(this.f1773hi, this.f1774hj, this.f1768hg, this.f1769hh).contains(d, d2)) {
            return true;
        }
        return super.mouseClicked(d, d2, i);
    }

    @Override // com.boehmod.blockfront.AbstractC0194cw, com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = (this.width / 2) - 95;
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        this.f1766f.render(guiGraphics, i, i2, f);
        m1275c(guiGraphics, i3, 80);
        int size = 60 + (11 * this.f1744B.size()) + this.f1769hh + 70;
        if (this.f1775cf != null) {
            C0119bk.m383c(this.font, guiGraphics, (Component) this.f1775cf.copy().withStyle(ChatFormatting.RED), i3 + (this.f1768hg / 2), size);
        }
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: G */
    public void mo744G() {
        int i = (this.width / 2) - 95;
        int size = 85 + (11 * this.f1744B.size()) + this.f1769hh + 6;
        addRenderableWidget(new C0127bs(i + 2, size, 80, 20, f1751gB, button -> {
            mo1276J();
        }).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW));
        addRenderableWidget(new C0127bs(((i + AbstractC0211dM.f1737gZ) - 80) - 2, size, 80, 20, f1752gC, button2 -> {
            m1281ai();
        }).m639a(C0127bs.c.SHADOW).m653a(C0127bs.a.SHADOW).m660e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).m666f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID));
    }

    @Override // com.boehmod.blockfront.AbstractC0211dM
    /* JADX INFO: renamed from: J */
    protected void mo1276J() {
        Screen screen = this.f1563d;
        if (screen instanceof AbstractC0193cv) {
            ((AbstractC0193cv) screen).f1557aU = true;
        }
        super.mo1276J();
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.dO$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dO$a.class */
    public enum a {
        ANYTHING(PatternReferences.ANYTHING, AbstractC0213dO.f1754gE),
        ALPHANUMERIC(PatternReferences.ALPHANUMERIC, AbstractC0213dO.f1755gF),
        NUMERIC(PatternReferences.NUMERIC, AbstractC0213dO.f1756gG),
        COMMON(PatternReferences.COMMON, AbstractC0213dO.f1757gH),
        MINECRAFT_UUID(PatternReferences.UUID, AbstractC0213dO.f1758gI),
        MINECRAFT_USERNAME(PatternReferences.MINECRAFT_USERNAME, AbstractC0213dO.f1759gJ),
        NO_UPPERCASE(PatternReferences.NO_UPPERCASE, AbstractC0213dO.f1760gK),
        NO_LOWERCASE(PatternReferences.NO_LOWERCASE, AbstractC0213dO.f1761gL),
        MINECRAFT_RESOURCE(PatternReferences.MINECRAFT_RESOURCE, AbstractC0213dO.f1762gM),
        IP_ADDRESS(PatternReferences.IP_ADDRESS, AbstractC0213dO.f1763gN),
        CLAN_NAME(PatternReferences.CLAN_NAME, AbstractC0213dO.f1764gO);


        @NotNull
        private final Pattern pattern;

        @NotNull
        private final Component errorMessage;

        a(@NotNull Pattern pattern, @NotNull Component component) {
            this.pattern = pattern;
            this.errorMessage = component;
        }

        public boolean isValid(@NotNull Minecraft minecraft, @NotNull AbstractC0213dO abstractC0213dO, @NotNull String str) {
            if (this == MINECRAFT_USERNAME && !abstractC0213dO.f1771bH && minecraft.getUser().getName().equalsIgnoreCase(str)) {
                return false;
            }
            return this.pattern.matcher(str).matches();
        }

        @NotNull
        public Component getErrorMessage() {
            return this.errorMessage;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0211dM
    /* JADX INFO: renamed from: E */
    protected int mo859E() {
        return 20;
    }
}
