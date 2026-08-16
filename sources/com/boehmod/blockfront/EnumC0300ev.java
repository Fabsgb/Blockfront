package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ev */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ev.class */
public enum EnumC0300ev {
    CLIENT_NOTIFICATION(-9143992),
    MOD_UPDATE_NOTIFICATION(ColorReferences.COLOR_THEME_YELLOW_SOLID, "update"),
    CHALLENGE_NOTIFICATION(ColorReferences.COLOR_THEME_YELLOW_SOLID, "challenge");

    private final int color;

    @NotNull
    private final ResourceLocation icon;

    EnumC0300ev(int i) {
        this(i, "bf");
    }

    EnumC0300ev(int i, String str) {
        this.color = i;
        this.icon = C0532jO.m2378d("textures/gui/toast/" + str + ".png");
    }

    public int getColor() {
        return this.color;
    }

    @NotNull
    public ResourceLocation getIcon() {
        return this.icon;
    }
}
