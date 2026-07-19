package com.boehmod.blockfront;

import com.boehmod.blockfront.cK;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cM.class */
@OnlyIn(Dist.CLIENT)
public final class cM extends Screen {

    @Nullable
    private final Screen h;

    public cM(@Nullable Screen screen) {
        super(Component.translatable("bf.menu.title.edit.templates"));
        this.h = screen;
    }

    protected void init() {
        ObjectArrayList objectArrayList = new ObjectArrayList(C0378o.a());
        objectArrayList.sort(Comparator.naturalOrder());
        Minecraft minecraft = Minecraft.getInstance();
        if (objectArrayList.isEmpty()) {
            minecraft.setScreen(this.h);
        } else {
            minecraft.setScreen(new cN(this.h, Component.translatable("bf.menu.title.edit.templates"), objectArrayList, str -> {
                return str;
            }, cK::a, null, str2 -> {
                pA pAVarA = C0378o.a(str2);
                if (pAVarA == null) {
                    return;
                }
                this.minecraft.setScreen(new cK(null, pAVarA, cK.b.EDIT_TEMPLATE, str2));
            }));
        }
    }

    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
    }
}
