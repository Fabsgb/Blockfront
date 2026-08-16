package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.bflib.common.PatternReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import java.awt.Rectangle;
import java.util.EnumSet;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.dZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dZ.class */
public abstract class AbstractC0225dZ extends AbstractC0223dX {

    /* JADX INFO: renamed from: gH */
    private static final Component f1780gH = Component.translatable("bf.menu.button.close");

    /* JADX INFO: renamed from: gI */
    private static final Component f1781gI = Component.translatable("bf.menu.button.confirm");

    /* JADX INFO: renamed from: gJ */
    private static final Component f1782gJ = Component.translatable("bf.textprompt.empty");

    /* JADX INFO: renamed from: gK */
    private static final Component f1783gK = Component.translatable("bf.textprompt.error.anything");

    /* JADX INFO: renamed from: gL */
    private static final Component f1784gL = Component.translatable("bf.textprompt.error.alphanumeric");

    /* JADX INFO: renamed from: gM */
    private static final Component f1785gM = Component.translatable("bf.textprompt.error.numeric");

    /* JADX INFO: renamed from: gN */
    private static final Component f1786gN = Component.translatable("bf.textprompt.error.common");

    /* JADX INFO: renamed from: gO */
    private static final Component f1787gO = Component.translatable("bf.textprompt.error.mc.uuid");

    /* JADX INFO: renamed from: gP */
    private static final Component f1788gP = Component.translatable("bf.textprompt.error.mc.username");

    /* JADX INFO: renamed from: gQ */
    private static final Component f1789gQ = Component.translatable("bf.textprompt.error.uppercase");

    /* JADX INFO: renamed from: gR */
    private static final Component f1790gR = Component.translatable("bf.textprompt.error.lowercase");

    /* JADX INFO: renamed from: gS */
    private static final Component f1791gS = Component.translatable("bf.textprompt.error.mc.resource");

    /* JADX INFO: renamed from: gT */
    private static final Component f1792gT = Component.translatable("bf.textprompt.error.mc.resource");

    /* JADX INFO: renamed from: gU */
    private static final Component f1793gU = Component.translatable("bf.textprompt.error.clan.name", new Object[]{2, 4});

    /* JADX INFO: renamed from: a */
    @NotNull
    private final EnumSet<a> f1794a;

    /* JADX INFO: renamed from: f */
    public EditBox f1795f;

    /* JADX INFO: renamed from: ip */
    private int f1796ip;

    /* JADX INFO: renamed from: iq */
    public int f1797iq;

    /* JADX INFO: renamed from: ir */
    public int f1798ir;

    /* JADX INFO: renamed from: X */
    public String f1799X;

    /* JADX INFO: renamed from: bO */
    private boolean f1800bO;

    /* JADX INFO: renamed from: bP */
    public boolean f1801bP;

    /* JADX INFO: renamed from: is */
    protected int f1802is;

    /* JADX INFO: renamed from: it */
    protected int f1803it;

    /* JADX INFO: renamed from: ch */
    @Nullable
    protected Component f1804ch;

    /* JADX INFO: renamed from: iu */
    private int f1805iu;

    /* JADX INFO: renamed from: Y */
    public abstract void mo942Y();

    public AbstractC0225dZ(@Nullable Screen screen, @NotNull Component component) {
        super(screen, component);
        this.f1796ip = -1;
        this.f1797iq = 200;
        this.f1798ir = 20;
        this.f1799X = "";
        this.f1800bO = false;
        this.f1801bP = false;
        this.f1804ch = null;
        this.f1805iu = 0;
        this.f1794a = EnumSet.noneOf(a.class);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0225dZ m1328a(@NotNull a aVar) {
        this.f1794a.add(aVar);
        return this;
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0225dZ mo783a(boolean z) {
        this.f1800bO = z;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0225dZ m1329a(int i) {
        this.f1796ip = i;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0225dZ m1330a(@NotNull a[] aVarArr) {
        for (a aVar : aVarArr) {
            m1328a(aVar);
        }
        return this;
    }

    /* JADX INFO: renamed from: an */
    public void m1331an() {
        String value = this.f1795f.getValue();
        this.f1804ch = null;
        if (value.isEmpty() && !this.f1801bP) {
            this.f1804ch = f1782gJ;
        }
        boolean z = false;
        if (!value.isEmpty()) {
            for (a aVar : this.f1794a) {
                if (!aVar.isValid(this.f1058a, this, value)) {
                    this.f1804ch = aVar.getErrorMessage();
                } else {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            this.f1804ch = null;
        }
        if (this.f1796ip != -1 && value.length() > this.f1796ip) {
            this.f1804ch = Component.translatable("bf.textprompt.error.length", new Object[]{Integer.valueOf(this.f1796ip)});
        }
        if (this.f1804ch != null) {
            this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7963pk.get(), 1.0f));
        } else {
            m1327N();
            mo942Y();
        }
    }

    /* JADX INFO: renamed from: aa */
    public int m1332aa() {
        return this.f1796ip;
    }

    @NotNull
    /* JADX INFO: renamed from: s */
    public String m1333s() {
        return this.f1795f.getValue();
    }

    @Override // com.boehmod.blockfront.AbstractC0223dX, com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG
    public void init() {
        super.init();
        this.f1795f = new EditBox(this.font, (this.width / 2) - (this.f1797iq / 2), 85 + (11 * this.f1773D.size()), this.f1797iq, this.f1798ir, Component.empty());
        this.f1795f.setMaxLength(this.f1796ip == -1 ? 999 : this.f1796ip);
        this.f1795f.setValue(this.f1799X);
        this.f1795f.setFocused(true);
    }

    @Override // com.boehmod.blockfront.AbstractC0223dX, com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG
    public void tick() {
        super.tick();
        if (m788c(this.f1058a)) {
            if (this.f1805iu >= 15) {
                this.f1795f.deleteChars(-1);
            } else {
                this.f1805iu++;
            }
        } else {
            this.f1805iu = 0;
        }
        if (m786a(this.f1058a)) {
            m1331an();
        }
    }

    @Override // com.boehmod.blockfront.C0143cG
    public boolean keyPressed(int i, int i2, int i3) {
        this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7969pq.get(), 1.0f, 1.0f));
        this.f1795f.keyPressed(i, i2, i3);
        return super.keyPressed(i, i2, i3);
    }

    public boolean charTyped(char c, int i) {
        this.f1795f.charTyped(c, i);
        return super.charTyped(c, i);
    }

    @Override // com.boehmod.blockfront.AbstractC0223dX, com.boehmod.blockfront.C0143cG
    public boolean mouseClicked(double d, double d2, int i) {
        this.f1795f.mouseClicked(d, d2, i);
        if (new Rectangle(this.f1802is, this.f1803it, this.f1797iq, this.f1798ir).contains(d, d2)) {
            return true;
        }
        return super.mouseClicked(d, d2, i);
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = (this.width / 2) - 95;
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        this.f1795f.render(guiGraphics, i, i2, f);
        m1326c(guiGraphics, i3, 80);
        int size = 60 + (11 * this.f1773D.size()) + this.f1798ir + 70;
        if (this.f1804ch != null) {
            C0129bt.m483c(this.font, guiGraphics, (Component) this.f1804ch.copy().withStyle(ChatFormatting.RED), i3 + (this.f1797iq / 2), size);
        }
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: K */
    public void mo776K() {
        int i = (this.width / 2) - 95;
        int size = 85 + (11 * this.f1773D.size()) + this.f1798ir + 6;
        addRenderableWidget(new C0085bB(i + 2, size, 80, 20, f1780gH, button -> {
            m1327N();
        }).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW));
        addRenderableWidget(new C0085bB(((i + AbstractC0223dX.f1766ij) - 80) - 2, size, 80, 20, f1781gI, button2 -> {
            m1331an();
        }).m314a(C0085bB.c.SHADOW).m328a(C0085bB.a.SHADOW).m335e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).m341f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID));
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.dZ$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dZ$a.class */
    public enum a {
        ANYTHING(PatternReferences.ANYTHING, AbstractC0225dZ.f1783gK),
        ALPHANUMERIC(PatternReferences.ALPHANUMERIC, AbstractC0225dZ.f1784gL),
        NUMERIC(PatternReferences.NUMERIC, AbstractC0225dZ.f1785gM),
        COMMON(PatternReferences.COMMON, AbstractC0225dZ.f1786gN),
        MINECRAFT_UUID(PatternReferences.UUID, AbstractC0225dZ.f1787gO),
        MINECRAFT_USERNAME(PatternReferences.MINECRAFT_USERNAME, AbstractC0225dZ.f1788gP),
        NO_UPPERCASE(PatternReferences.NO_UPPERCASE, AbstractC0225dZ.f1789gQ),
        NO_LOWERCASE(PatternReferences.NO_LOWERCASE, AbstractC0225dZ.f1790gR),
        MINECRAFT_RESOURCE(PatternReferences.MINECRAFT_RESOURCE, AbstractC0225dZ.f1791gS),
        IP_ADDRESS(PatternReferences.IP_ADDRESS, AbstractC0225dZ.f1792gT),
        CLAN_NAME(PatternReferences.CLAN_NAME, AbstractC0225dZ.f1793gU);


        @NotNull
        private final Pattern pattern;

        @NotNull
        private final Component errorMessage;

        a(Pattern pattern, Component component) {
            this.pattern = pattern;
            this.errorMessage = component;
        }

        public boolean isValid(@NotNull Minecraft minecraft, @NotNull AbstractC0225dZ abstractC0225dZ, @NotNull String str) {
            if (this == MINECRAFT_USERNAME && !abstractC0225dZ.f1800bO && minecraft.getUser().getName().equalsIgnoreCase(str)) {
                return false;
            }
            return this.pattern.matcher(str).matches();
        }

        @NotNull
        public Component getErrorMessage() {
            return this.errorMessage;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0223dX
    /* JADX INFO: renamed from: I */
    protected int mo913I() {
        return 20;
    }
}
