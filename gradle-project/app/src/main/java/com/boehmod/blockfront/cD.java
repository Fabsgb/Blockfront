package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.authlib.GameProfile;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.UUID;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.WinScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cD.class */
public final class cD extends C0081cy {
    private static final Style a = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES));
    public static final int ej = 30;

    @NotNull
    public List<cC> q;

    public cD() {
        super(Component.translatable("bf.menu.button.credits"));
        this.q = new ObjectArrayList();
        this.e.m586a().b().forEach(b -> {
            String strG = b.g();
            String strI = b.i();
            try {
                UUID uuidFromString = UUID.fromString(b.h());
                cC cCVar = new cC(uuidFromString, strG, strI);
                C0040bk.a(this.b, this.e, uuidFromString);
                this.q.add(cCVar);
            } catch (IllegalArgumentException e) {
                C0263jt.a("Failed to parse UUID for mod credit: " + strG, e, new Object[0]);
            }
        });
    }

    public void tick() {
        super.tick();
        if (!this.q.isEmpty()) {
            if (((cC) this.q.getFirst()).d(this.b)) {
                this.q.removeFirst();
                return;
            }
            return;
        }
        this.b.setScreen(new WinScreen(false, () -> {
            this.b.setScreen(new C0094dk());
        }));
    }

    @Override // com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        if (this.q.isEmpty()) {
            return;
        }
        cC cCVar = (cC) this.q.getFirst();
        float fJ = cCVar.j(f);
        PoseStack poseStackPose = guiGraphics.pose();
        C0040bk.a(guiGraphics, 0, 0, this.width, this.height, ColorReferences.COLOR_BLACK_SOLID);
        a(poseStackPose, guiGraphics, cCVar, f);
        C0040bk.a(guiGraphics, 0, 0, this.width, this.height, 0, fJ);
    }

    private void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull cC cCVar, float f) {
        int i = this.width / 2;
        int i2 = this.height / 2;
        float fJ = cCVar.j(f);
        MutableComponent style = Component.translatable(cCVar.l()).setStyle(a);
        GameProfile gameProfile = new GameProfile(cCVar.getUUID(), cCVar.getName());
        poseStack.pushPose();
        poseStack.translate(0.0f, 20.0f * fJ, 0.0f);
        C0040bk.a(this.b, this.e, poseStack, guiGraphics, gameProfile, i - 15.0f, i2 - 20, 30);
        C0040bk.a(guiGraphics, 0, ((i2 - 30) - 10) - 70, this.width, 70, ColorReferences.COLOR_BLACK_TRANSPARENT, ColorReferences.COLOR_BLACK_SOLID);
        C0040bk.c(this.font, guiGraphics, (Component) Component.literal(cCVar.getName()).withColor(ColorReferences.COLOR_WHITE), i, i2 + 20);
        C0040bk.c(this.font, guiGraphics, (Component) style, i, i2 + 33);
        int iWidth = (this.font.width(style) * 2) / 2;
        int i3 = i - iWidth;
        int i4 = i2 + 30;
        C0040bk.b(poseStack, guiGraphics, i3, i4, iWidth, 1.0f, ColorReferences.COLOR_BLACK_TRANSPARENT, ColorReferences.COLOR_WHITE_SOLID);
        C0040bk.b(poseStack, guiGraphics, i3 + iWidth, i4, iWidth, 1.0f, ColorReferences.COLOR_WHITE_SOLID, ColorReferences.COLOR_BLACK_TRANSPARENT);
        poseStack.popPose();
    }
}
