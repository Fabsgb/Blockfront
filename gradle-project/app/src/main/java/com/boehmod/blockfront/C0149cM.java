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

/* JADX INFO: renamed from: com.boehmod.blockfront.cM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cM.class */
public final class C0149cM extends C0144cH {

    /* JADX INFO: renamed from: a */
    private static final Style f1150a = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES));

    /* JADX INFO: renamed from: fj */
    public static final int f1151fj = 30;

    /* JADX INFO: renamed from: s */
    @NotNull
    public List<C0148cL> f1152s;

    public C0149cM() {
        super(Component.translatable("bf.menu.button.credits"));
        this.f1152s = new ObjectArrayList();
        this.f1057f.m2868a().m2795b().forEach(c0011h -> {
            String strM39k = c0011h.m39k();
            String strM41m = c0011h.m41m();
            try {
                UUID uuidFromString = UUID.fromString(c0011h.m40l());
                C0148cL c0148cL = new C0148cL(uuidFromString, strM39k, strM41m);
                C0129bt.m631a(this.f1058a, this.f1057f, uuidFromString);
                this.f1152s.add(c0148cL);
            } catch (IllegalArgumentException e) {
                C0530jM.m2338a("Failed to parse UUID for mod credit: " + strM39k, e, new Object[0]);
            }
        });
    }

    public void tick() {
        super.tick();
        if (!this.f1152s.isEmpty()) {
            if (((C0148cL) this.f1152s.getFirst()).m824d(this.f1058a)) {
                this.f1152s.removeFirst();
                return;
            }
            return;
        }
        this.f1058a.setScreen(new WinScreen(false, () -> {
            this.f1058a.setScreen(new C0245dt());
        }));
    }

    @Override // com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        if (this.f1152s.isEmpty()) {
            return;
        }
        C0148cL c0148cL = (C0148cL) this.f1152s.getFirst();
        float fM826i = c0148cL.m826i(f);
        PoseStack poseStackPose = guiGraphics.pose();
        C0129bt.m515a(guiGraphics, 0, 0, this.width, this.height, ColorReferences.COLOR_BLACK_SOLID);
        m827a(poseStackPose, guiGraphics, c0148cL, f);
        C0129bt.m517a(guiGraphics, 0, 0, this.width, this.height, 0, fM826i);
    }

    /* JADX INFO: renamed from: a */
    private void m827a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull C0148cL c0148cL, float f) {
        int i = this.width / 2;
        int i2 = this.height / 2;
        float fM826i = c0148cL.m826i(f);
        MutableComponent style = Component.translatable(c0148cL.m825p()).setStyle(f1150a);
        GameProfile gameProfile = new GameProfile(c0148cL.getUUID(), c0148cL.getName());
        poseStack.pushPose();
        poseStack.translate(0.0f, 20.0f * fM826i, 0.0f);
        C0129bt.m585a(this.f1058a, this.f1057f, poseStack, guiGraphics, gameProfile, i - 15.0f, i2 - 20, 30);
        C0129bt.m523a(guiGraphics, 0, ((i2 - 30) - 10) - 70, this.width, 70, ColorReferences.COLOR_BLACK_TRANSPARENT, ColorReferences.COLOR_BLACK_SOLID);
        C0129bt.m483c(this.font, guiGraphics, (Component) Component.literal(c0148cL.getName()).withColor(ColorReferences.COLOR_WHITE), i, i2 + 20);
        C0129bt.m483c(this.font, guiGraphics, (Component) style, i, i2 + 33);
        int iWidth = (this.font.width(style) * 2) / 2;
        int i3 = i - iWidth;
        int i4 = i2 + 30;
        C0129bt.m524b(poseStack, guiGraphics, i3, i4, iWidth, 1.0f, ColorReferences.COLOR_BLACK_TRANSPARENT, ColorReferences.COLOR_WHITE_SOLID);
        C0129bt.m524b(poseStack, guiGraphics, i3 + iWidth, i4, iWidth, 1.0f, ColorReferences.COLOR_WHITE_SOLID, ColorReferences.COLOR_BLACK_TRANSPARENT);
        poseStack.popPose();
    }
}
