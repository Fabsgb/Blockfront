package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.bflib.common.PatternReferences;
import com.boehmod.blockfront.C0048bs;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dO.class */
public abstract class dO extends dM {
    private static final Component gB = Component.translatable("bf.menu.button.close");
    private static final Component gC = Component.translatable("bf.menu.button.confirm");
    private static final Component gD = Component.translatable("bf.textprompt.empty");
    private static final Component gE = Component.translatable("bf.textprompt.error.anything");
    private static final Component gF = Component.translatable("bf.textprompt.error.alphanumeric");
    private static final Component gG = Component.translatable("bf.textprompt.error.numeric");
    private static final Component gH = Component.translatable("bf.textprompt.error.common");
    private static final Component gI = Component.translatable("bf.textprompt.error.mc.uuid");
    private static final Component gJ = Component.translatable("bf.textprompt.error.mc.username");
    private static final Component gK = Component.translatable("bf.textprompt.error.uppercase");
    private static final Component gL = Component.translatable("bf.textprompt.error.lowercase");
    private static final Component gM = Component.translatable("bf.textprompt.error.mc.resource");
    private static final Component gN = Component.translatable("bf.textprompt.error.mc.resource");
    private static final Component gO = Component.translatable("bf.textprompt.error.clan.name", new Object[]{2, 4});

    @NotNull
    private final EnumSet<a> a;
    public EditBox f;
    private int hf;
    public int hg;
    public int hh;
    public String Q;
    private boolean bH;
    public boolean bI;
    protected int hi;
    protected int hj;

    @Nullable
    protected Component cf;
    private int hk;

    public abstract void U();

    public dO(@Nullable Screen screen, @NotNull Component component) {
        super(screen, component);
        this.hf = -1;
        this.hg = 200;
        this.hh = 20;
        this.Q = "";
        this.bH = false;
        this.bI = false;
        this.cf = null;
        this.hk = 0;
        this.a = EnumSet.noneOf(a.class);
    }

    @NotNull
    public dO a(@NotNull a aVar) {
        this.a.add(aVar);
        return this;
    }

    @NotNull
    public dO a(boolean z) {
        this.bH = z;
        return this;
    }

    @NotNull
    public dO a(int i) {
        this.hf = i;
        return this;
    }

    @NotNull
    public dO a(@NotNull a[] aVarArr) {
        for (a aVar : aVarArr) {
            a(aVar);
        }
        return this;
    }

    public void ai() {
        String value = this.f.getValue();
        this.cf = null;
        if (value.isEmpty() && !this.bI) {
            this.cf = gD;
        }
        boolean z = false;
        if (!value.isEmpty()) {
            Iterator it = this.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a aVar = (a) it.next();
                if (!aVar.isValid(this.b, this, value)) {
                    this.cf = aVar.getErrorMessage();
                } else {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            this.cf = null;
        }
        if (this.hf != -1 && value.length() > this.hf) {
            this.cf = Component.translatable("bf.textprompt.error.length", new Object[]{Integer.valueOf(this.hf)});
        }
        if (this.cf != null) {
            this.b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pi.get(), 1.0f));
        } else {
            J();
            U();
        }
    }

    public int Q() {
        return this.hf;
    }

    @NotNull
    public String o() {
        return this.f.getValue();
    }

    @Override // com.boehmod.blockfront.dM, com.boehmod.blockfront.AbstractC0079cw, com.boehmod.blockfront.C0080cx
    public void init() {
        super.init();
        this.f = new EditBox(this.font, (this.width / 2) - (this.hg / 2), 85 + (11 * this.B.size()), this.hg, this.hh, Component.empty());
        this.f.setMaxLength(this.hf == -1 ? 999 : this.hf);
        this.f.setValue(this.Q);
        this.f.setFocused(true);
    }

    @Override // com.boehmod.blockfront.dM, com.boehmod.blockfront.AbstractC0079cw, com.boehmod.blockfront.C0080cx
    public void tick() {
        super.tick();
        if (c(this.b)) {
            if (this.hk >= 15) {
                this.f.deleteChars(-1);
            } else {
                this.hk++;
            }
        } else {
            this.hk = 0;
        }
        if (a(this.b)) {
            ai();
        }
    }

    @Override // com.boehmod.blockfront.C0080cx
    public boolean keyPressed(int i, int i2, int i3) {
        this.b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.po.get(), 1.0f, 1.0f));
        this.f.keyPressed(i, i2, i3);
        return super.keyPressed(i, i2, i3);
    }

    public boolean charTyped(char c, int i) {
        this.f.charTyped(c, i);
        return super.charTyped(c, i);
    }

    @Override // com.boehmod.blockfront.dM, com.boehmod.blockfront.C0080cx
    public boolean mouseClicked(double d, double d2, int i) {
        this.f.mouseClicked(d, d2, i);
        if (new Rectangle(this.hi, this.hj, this.hg, this.hh).contains(d, d2)) {
            return true;
        }
        return super.mouseClicked(d, d2, i);
    }

    @Override // com.boehmod.blockfront.AbstractC0079cw, com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = (this.width / 2) - 95;
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        this.f.render(guiGraphics, i, i2, f);
        c(guiGraphics, i3, 80);
        int size = 60 + (11 * this.B.size()) + this.hh + 70;
        if (this.cf != null) {
            C0040bk.c(this.font, guiGraphics, (Component) this.cf.copy().withStyle(ChatFormatting.RED), i3 + (this.hg / 2), size);
        }
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.C0080cx
    /* JADX INFO: renamed from: G */
    public void mo280G() {
        int i = (this.width / 2) - 95;
        int size = 85 + (11 * this.B.size()) + this.hh + 6;
        addRenderableWidget(new C0048bs(i + 2, size, 80, 20, gB, button -> {
            J();
        }).a(C0048bs.c.SHADOW).a(C0048bs.a.SHADOW));
        addRenderableWidget(new C0048bs(((i + dM.gZ) - 80) - 2, size, 80, 20, gC, button2 -> {
            ai();
        }).a(C0048bs.c.SHADOW).a(C0048bs.a.SHADOW).e(ColorReferences.COLOR_TEAM_ALLIES_SOLID).f(ColorReferences.COLOR_TEAM_ALLIES_HOVERED_SOLID));
    }

    @Override // com.boehmod.blockfront.dM
    protected void J() {
        Screen screen = this.d;
        if (screen instanceof AbstractC0078cv) {
            ((AbstractC0078cv) screen).aU = true;
        }
        super.J();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dO$a.class */
    public enum a {
        ANYTHING(PatternReferences.ANYTHING, dO.gE),
        ALPHANUMERIC(PatternReferences.ALPHANUMERIC, dO.gF),
        NUMERIC(PatternReferences.NUMERIC, dO.gG),
        COMMON(PatternReferences.COMMON, dO.gH),
        MINECRAFT_UUID(PatternReferences.UUID, dO.gI),
        MINECRAFT_USERNAME(PatternReferences.MINECRAFT_USERNAME, dO.gJ),
        NO_UPPERCASE(PatternReferences.NO_UPPERCASE, dO.gK),
        NO_LOWERCASE(PatternReferences.NO_LOWERCASE, dO.gL),
        MINECRAFT_RESOURCE(PatternReferences.MINECRAFT_RESOURCE, dO.gM),
        IP_ADDRESS(PatternReferences.IP_ADDRESS, dO.gN),
        CLAN_NAME(PatternReferences.CLAN_NAME, dO.gO);


        @NotNull
        private final Pattern pattern;

        @NotNull
        private final Component errorMessage;

        a(@NotNull Pattern pattern, @NotNull Component component) {
            this.pattern = pattern;
            this.errorMessage = component;
        }

        public boolean isValid(@NotNull Minecraft minecraft, @NotNull dO dOVar, @NotNull String str) {
            if (this == MINECRAFT_USERNAME && !dOVar.bH && minecraft.getUser().getName().equalsIgnoreCase(str)) {
                return false;
            }
            return this.pattern.matcher(str).matches();
        }

        @NotNull
        public Component getErrorMessage() {
            return this.errorMessage;
        }
    }

    @Override // com.boehmod.blockfront.dM
    protected int E() {
        return 20;
    }
}
