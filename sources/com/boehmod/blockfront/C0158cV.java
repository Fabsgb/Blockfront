package com.boehmod.blockfront;

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

/* JADX INFO: renamed from: com.boehmod.blockfront.cV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cV.class */
@OnlyIn(Dist.CLIENT)
public final class C0158cV extends Screen {

    /* JADX INFO: renamed from: g */
    @Nullable
    private final Screen f1292g;

    public C0158cV(@Nullable Screen screen) {
        super(Component.translatable("bf.menu.title.edit.templates"));
        this.f1292g = screen;
    }

    protected void init() {
        ObjectArrayList objectArrayList = new ObjectArrayList(C0782o.m3663a());
        objectArrayList.sort(Comparator.naturalOrder());
        Minecraft minecraft = Minecraft.getInstance();
        if (objectArrayList.isEmpty()) {
            minecraft.setScreen(this.f1292g);
        } else {
            minecraft.setScreen(new C0159cW(this.f1292g, Component.translatable("bf.menu.title.edit.templates"), objectArrayList, str -> {
                return str;
            }, C0156cT::m896a, null, str2 -> {
                AbstractC0858pW abstractC0858pWM3662a = C0782o.m3662a(str2);
                if (abstractC0858pWM3662a == null) {
                    return;
                }
                this.minecraft.setScreen(new C0156cT(null, abstractC0858pWM3662a, C0156cT.b.EDIT_TEMPLATE, str2));
            }));
        }
    }

    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
    }
}
