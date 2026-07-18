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

/* JADX INFO: renamed from: com.boehmod.blockfront.sK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sK.class */
public enum EnumC1004sK {
    PENDING("Pending", ColorReferences.COLOR_THEME_TTT_PENDING, ColorReferences.COLOR_THEME_TTT_PENDING_SUB, EnumC1005sL.NEUTRAL, "", "", null, false, false),
    INNOCENT("Innocent", ColorReferences.COLOR_THEME_TTT_INNOCENT, ColorReferences.COLOR_THEME_TTT_INNOCENT_SUB, EnumC1005sL.GOOD, "bf.message.gamemode.ttt.role.innocent.title", "bf.message.gamemode.ttt.role.innocent.desc", C0564jv.m2555d("textures/gui/game/troubletown/innocent.png"), false, false),
    TRAITOR("Traitor", ColorReferences.COLOR_THEME_TTT_TRAITOR, ColorReferences.COLOR_THEME_TTT_TRAITOR_SUB, EnumC1005sL.BAD, "bf.message.gamemode.ttt.role.traitor.title", "bf.message.gamemode.ttt.role.traitor.desc", C0564jv.m2555d("textures/gui/game/troubletown/traitor.png"), true, true),
    DETECTIVE("Detective", ColorReferences.COLOR_THEME_TTT_DETECTIVE, ColorReferences.COLOR_THEME_TTT_DETECTIVE_SUB, EnumC1005sL.GOOD, "bf.message.gamemode.ttt.role.detective.title", "bf.message.gamemode.ttt.role.detective.desc", C0564jv.m2555d("textures/gui/game/troubletown/detective.png"), true, false),
    JESTER("Jester", ColorReferences.COLOR_THEME_TTT_JESTER, ColorReferences.COLOR_THEME_TTT_JESTER_SUB, EnumC1005sL.GOOD, "bf.message.gamemode.ttt.role.jester.title", "bf.message.gamemode.ttt.role.jester.desc", C0564jv.m2555d("textures/gui/game/troubletown/jester.png"), true, true);


    @NotNull
    private final String key;
    private final int color;
    private final int subColor;

    @NotNull
    private final EnumC1005sL team;

    @NotNull
    private final Component title;

    @NotNull
    private final Component description;

    @Nullable
    private final ResourceLocation texture;

    @NotNull
    private final List<C0863pc> roleItems = new ObjectArrayList();
    private final boolean hideRank;
    private final boolean displayOnNameplate;

    static {
        TRAITOR.addRoleItem(new C0863pc((Item) C1231wY.f7148S.get(), 1, new Vec2(0.0f, 2.0f)));
        TRAITOR.addRoleItem(new C0863pc((Item) C1231wY.f7153X.get(), 1, new Vec2(-1.0f, 1.0f)));
        TRAITOR.addRoleItem(new C0863pc((Item) C1231wY.f7150U.get(), 1, new Vec2(0.0f, 1.0f)));
        TRAITOR.addRoleItem(new C0863pc((Item) C1231wY.f7152W.get(), 1, new Vec2(1.0f, 1.0f)));
        TRAITOR.addRoleItem(new C0863pc((Item) C1231wY.f7119p.get(), 1, new Vec2(-1.0f, 0.0f)));
        TRAITOR.addRoleItem(new C0863pc((Item) C1231wY.f7120q.get(), 1, new Vec2(1.0f, 0.0f)));
        TRAITOR.addRoleItem(new C0863pc((Item) C1231wY.f7274nc.get(), 3, new Vec2(-1.0f, -1.0f)));
        TRAITOR.addRoleItem(new C0863pc((Item) C1231wY.f7160ae.get(), 5, new Vec2(0.0f, -1.0f)));
        TRAITOR.addRoleItem(new C0863pc((Item) C1231wY.f7126w.get(), 6, new Vec2(1.0f, -1.0f)));
        DETECTIVE.addRoleItem(new C0863pc((Item) C1231wY.f7119p.get(), 1, new Vec2(-1.0f, 1.0f)));
        DETECTIVE.addRoleItem(new C0863pc((Item) C1231wY.f7120q.get(), 2, new Vec2(0.0f, 1.0f)));
        DETECTIVE.addRoleItem(new C0863pc((Item) C1231wY.f7127x.get(), 1, new Vec2(1.0f, 1.0f)).m4310a(1));
    }

    EnumC1004sK(@NotNull String str, int i, int i2, @NotNull EnumC1005sL enumC1005sL, @NotNull String str2, @NotNull String str3, @Nullable ResourceLocation resourceLocation, boolean z, boolean z2) {
        this.key = str;
        this.color = i;
        this.subColor = i2;
        this.team = enumC1005sL;
        this.title = Component.translatable(str2).withColor(TextColor.fromRgb(i).getValue());
        this.description = Component.translatable(str3).withColor(i2).withStyle(new ChatFormatting[0]);
        this.texture = resourceLocation;
        this.hideRank = z2;
        this.displayOnNameplate = z;
    }

    @NotNull
    public static EnumC1004sK fromKey(String str) {
        for (EnumC1004sK enumC1004sK : values()) {
            if (enumC1004sK.getKey().equalsIgnoreCase(str)) {
                return enumC1004sK;
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

    public void addRoleItem(@NotNull C0863pc c0863pc) {
        this.roleItems.add(c0863pc);
    }

    @NotNull
    public EnumC1005sL getTeam() {
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
    public List<C0863pc> getRoleItems() {
        return this.roleItems;
    }

    public boolean hideRank() {
        return this.hideRank;
    }

    @Nullable
    public C0863pc getRoleItem(int i) {
        if (i >= this.roleItems.size()) {
            return null;
        }
        return this.roleItems.get(i);
    }
}
