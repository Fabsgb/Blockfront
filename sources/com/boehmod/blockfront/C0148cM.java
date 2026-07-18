package com.boehmod.blockfront;

import com.boehmod.blockfront.C0146cK;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Comparator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.cM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cM.class */
@OnlyIn(Dist.CLIENT)
public final class C0148cM extends Screen {

    /* JADX INFO: renamed from: h */
    @Nullable
    private final Screen f1202h;

    public C0148cM(@Nullable Screen screen) {
        super(Component.translatable("bf.menu.title.edit.templates"));
        this.f1202h = screen;
    }

    protected void init() {
        ObjectArrayList objectArrayList = new ObjectArrayList(C0781o.m3547a());
        objectArrayList.sort(Comparator.naturalOrder());
        Minecraft minecraft = Minecraft.getInstance();
        if (objectArrayList.isEmpty()) {
            minecraft.setScreen(this.f1202h);
        } else {
            minecraft.setScreen(new C0149cN(this.f1202h, Component.translatable("bf.menu.title.edit.templates"), objectArrayList, str -> {
                return str;
            }, C0146cK::m842a, null, str2 -> {
                AbstractC0835pA abstractC0835pAM3546a = C0781o.m3546a(str2);
                if (abstractC0835pAM3546a == null) {
                    return;
                }
                this.minecraft.setScreen(new C0146cK(null, abstractC0835pAM3546a, C0146cK.b.EDIT_TEMPLATE, str2));
            }));
        }
    }

    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
    }
}
