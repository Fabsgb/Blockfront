package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.phys.Vec2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.th */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/th.class */
public enum EnumC1082th {
    PENDING("Pending", ColorReferences.COLOR_THEME_TTT_PENDING, ColorReferences.COLOR_THEME_TTT_PENDING_SUB, EnumC1083ti.NEUTRAL, "", "", null, false, false),
    INNOCENT("Innocent", ColorReferences.COLOR_THEME_TTT_INNOCENT, ColorReferences.COLOR_THEME_TTT_INNOCENT_SUB, EnumC1083ti.GOOD, "bf.message.gamemode.ttt.role.innocent.title", "bf.message.gamemode.ttt.role.innocent.desc", C0532jO.m2378d("textures/gui/game/troubletown/innocent.png"), false, false),
    TRAITOR("Traitor", ColorReferences.COLOR_THEME_TTT_TRAITOR, ColorReferences.COLOR_THEME_TTT_TRAITOR_SUB, EnumC1083ti.BAD, "bf.message.gamemode.ttt.role.traitor.title", "bf.message.gamemode.ttt.role.traitor.desc", C0532jO.m2378d("textures/gui/game/troubletown/traitor.png"), true, true),
    DETECTIVE("Detective", ColorReferences.COLOR_THEME_TTT_DETECTIVE, ColorReferences.COLOR_THEME_TTT_DETECTIVE_SUB, EnumC1083ti.GOOD, "bf.message.gamemode.ttt.role.detective.title", "bf.message.gamemode.ttt.role.detective.desc", C0532jO.m2378d("textures/gui/game/troubletown/detective.png"), true, false),
    JESTER("Jester", ColorReferences.COLOR_THEME_TTT_JESTER, ColorReferences.COLOR_THEME_TTT_JESTER_SUB, EnumC1083ti.GOOD, "bf.message.gamemode.ttt.role.jester.title", "bf.message.gamemode.ttt.role.jester.desc", C0532jO.m2378d("textures/gui/game/troubletown/jester.png"), true, true);


    @NotNull
    private final String key;
    private final int color;
    private final int subColor;

    @NotNull
    private final EnumC1083ti team;

    @NotNull
    private final Component title;

    @NotNull
    private final Component description;

    @Nullable
    private final ResourceLocation texture;

    @NotNull
    private final List<C0886py> roleItems = new ObjectArrayList();
    private final boolean hideRank;
    private final boolean displayOnNameplate;

    static {
        TRAITOR.addRoleItem(new C0886py((Item) C1308xv.f7713S.get(), 1, new Vec2(0.0f, 2.0f)));
        TRAITOR.addRoleItem(new C0886py((Item) C1308xv.f7718X.get(), 1, new Vec2(-1.0f, 1.0f)));
        TRAITOR.addRoleItem(new C0886py((Item) C1308xv.f7715U.get(), 1, new Vec2(0.0f, 1.0f)));
        TRAITOR.addRoleItem(new C0886py((Item) C1308xv.f7717W.get(), 1, new Vec2(1.0f, 1.0f)));
        TRAITOR.addRoleItem(new C0886py((Item) C1308xv.f7684p.get(), 1, new Vec2(-1.0f, 0.0f)));
        TRAITOR.addRoleItem(new C0886py((Item) C1308xv.f7685q.get(), 1, new Vec2(1.0f, 0.0f)));
        TRAITOR.addRoleItem(new C0886py((Item) C1308xv.f7839nc.get(), 3, new Vec2(-1.0f, -1.0f)));
        TRAITOR.addRoleItem(new C0886py((Item) C1308xv.f7725ae.get(), 5, new Vec2(0.0f, -1.0f)));
        TRAITOR.addRoleItem(new C0886py((Item) C1308xv.f7691w.get(), 6, new Vec2(1.0f, -1.0f)));
        DETECTIVE.addRoleItem(new C0886py((Item) C1308xv.f7684p.get(), 1, new Vec2(-1.0f, 1.0f)));
        DETECTIVE.addRoleItem(new C0886py((Item) C1308xv.f7685q.get(), 2, new Vec2(0.0f, 1.0f)));
        DETECTIVE.addRoleItem(new C0886py((Item) C1308xv.f7692x.get(), 1, new Vec2(1.0f, 1.0f)).m4635a(1));
    }

    EnumC1082th(String str, @NotNull int i, @NotNull int i2, @NotNull EnumC1083ti enumC1083ti, @Nullable String str2, String str3, ResourceLocation resourceLocation, boolean z, boolean z2) {
        this.key = str;
        this.color = i;
        this.subColor = i2;
        this.team = enumC1083ti;
        this.title = Component.translatable(str2).withColor(TextColor.fromRgb(i).getValue());
        this.description = Component.translatable(str3).withColor(i2).withStyle(new ChatFormatting[0]);
        this.texture = resourceLocation;
        this.hideRank = z2;
        this.displayOnNameplate = z;
    }

    @NotNull
    public static EnumC1082th fromKey(String str) {
        for (EnumC1082th enumC1082th : values()) {
            if (enumC1082th.getKey().equalsIgnoreCase(str)) {
                return enumC1082th;
            }
        }
        return PENDING;
    }

    public boolean displayOnNameplate() {
        return this.displayOnNameplate;
    }

    @Nullable
    public ResourceLocation getTexture() {
        return this.texture;
    }

    public void addRoleItem(@NotNull C0886py c0886py) {
        this.roleItems.add(c0886py);
    }

    @NotNull
    public EnumC1083ti getTeam() {
        return this.team;
    }

    @NotNull
    public String getKey() {
        return this.key;
    }

    public int getColor() {
        return this.color;
    }

    public int getSubColor() {
        return this.subColor;
    }

    @NotNull
    public Component getTitle() {
        return this.title;
    }

    @NotNull
    public Component getDescription() {
        return this.description;
    }

    @NotNull
    public List<C0886py> getRoleItems() {
        return this.roleItems;
    }

    public boolean hideRank() {
        return this.hideRank;
    }

    @Nullable
    public C0886py getRoleItem(int i) {
        if (i >= this.roleItems.size()) {
            return null;
        }
        return this.roleItems.get(i);
    }
}
