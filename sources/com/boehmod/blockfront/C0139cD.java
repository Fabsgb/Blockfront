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

/* JADX INFO: renamed from: com.boehmod.blockfront.cD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cD.class */
public final class C0139cD extends C0196cy {

    /* JADX INFO: renamed from: a */
    private static final Style f1060a = Style.EMPTY.withColor(TextColor.fromRgb(ColorReferences.COLOR_TEAM_ALLIES));

    /* JADX INFO: renamed from: ej */
    public static final int f1061ej = 30;

    /* JADX INFO: renamed from: q */
    @NotNull
    public List<C0138cC> f1062q;

    public C0139cD() {
        super(Component.translatable("bf.menu.button.credits"));
        this.f1062q = new ObjectArrayList();
        this.f1586e.m2682a().m2436b().forEach(c0004b -> {
            String strM7g = c0004b.m7g();
            String strM9i = c0004b.m9i();
            try {
                UUID uuidFromString = UUID.fromString(c0004b.m8h());
                C0138cC c0138cC = new C0138cC(uuidFromString, strM7g, strM9i);
                C0119bk.m529a(this.f1587b, this.f1586e, uuidFromString);
                this.f1062q.add(c0138cC);
            } catch (IllegalArgumentException e) {
                C0562jt.m2516a("Failed to parse UUID for mod credit: " + strM7g, e, new Object[0]);
            }
        });
    }

    public void tick() {
        super.tick();
        if (!this.f1062q.isEmpty()) {
            if (((C0138cC) this.f1062q.getFirst()).m769d(this.f1587b)) {
                this.f1062q.removeFirst();
                return;
            }
            return;
        }
        this.f1587b.setScreen(new WinScreen(false, () -> {
            this.f1587b.setScreen(new C0235dk());
        }));
    }

    @Override // com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        if (this.f1062q.isEmpty()) {
            return;
        }
        C0138cC c0138cC = (C0138cC) this.f1062q.getFirst();
        float fM771j = c0138cC.m771j(f);
        PoseStack poseStackPose = guiGraphics.pose();
        C0119bk.m415a(guiGraphics, 0, 0, this.width, this.height, ColorReferences.COLOR_BLACK_SOLID);
        m772a(poseStackPose, guiGraphics, c0138cC, f);
        C0119bk.m417a(guiGraphics, 0, 0, this.width, this.height, 0, fM771j);
    }

    /* JADX INFO: renamed from: a */
    private void m772a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull C0138cC c0138cC, float f) {
        int i = this.width / 2;
        int i2 = this.height / 2;
        float fM771j = c0138cC.m771j(f);
        MutableComponent style = Component.translatable(c0138cC.m770l()).setStyle(f1060a);
        GameProfile gameProfile = new GameProfile(c0138cC.getUUID(), c0138cC.getName());
        poseStack.pushPose();
        poseStack.translate(0.0f, 20.0f * fM771j, 0.0f);
        C0119bk.m485a(this.f1587b, this.f1586e, poseStack, guiGraphics, gameProfile, i - 15.0f, i2 - 20, 30);
        C0119bk.m423a(guiGraphics, 0, ((i2 - 30) - 10) - 70, this.width, 70, ColorReferences.COLOR_BLACK_TRANSPARENT, ColorReferences.COLOR_BLACK_SOLID);
        C0119bk.m383c(this.font, guiGraphics, (Component) Component.literal(c0138cC.getName()).withColor(ColorReferences.COLOR_WHITE), i, i2 + 20);
        C0119bk.m383c(this.font, guiGraphics, (Component) style, i, i2 + 33);
        int iWidth = (this.font.width(style) * 2) / 2;
        int i3 = i - iWidth;
        int i4 = i2 + 30;
        C0119bk.m424b(poseStack, guiGraphics, i3, i4, iWidth, 1.0f, ColorReferences.COLOR_BLACK_TRANSPARENT, ColorReferences.COLOR_WHITE_SOLID);
        C0119bk.m424b(poseStack, guiGraphics, i3 + iWidth, i4, iWidth, 1.0f, ColorReferences.COLOR_WHITE_SOLID, ColorReferences.COLOR_BLACK_TRANSPARENT);
        poseStack.popPose();
    }
}
