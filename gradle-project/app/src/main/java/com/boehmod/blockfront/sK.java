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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sK.class */
public enum sK {
    PENDING("Pending", ColorReferences.COLOR_THEME_TTT_PENDING, ColorReferences.COLOR_THEME_TTT_PENDING_SUB, sL.NEUTRAL, "", "", null, false, false),
    INNOCENT("Innocent", ColorReferences.COLOR_THEME_TTT_INNOCENT, ColorReferences.COLOR_THEME_TTT_INNOCENT_SUB, sL.GOOD, "bf.message.gamemode.ttt.role.innocent.title", "bf.message.gamemode.ttt.role.innocent.desc", C0265jv.d("textures/gui/game/troubletown/innocent.png"), false, false),
    TRAITOR("Traitor", ColorReferences.COLOR_THEME_TTT_TRAITOR, ColorReferences.COLOR_THEME_TTT_TRAITOR_SUB, sL.BAD, "bf.message.gamemode.ttt.role.traitor.title", "bf.message.gamemode.ttt.role.traitor.desc", C0265jv.d("textures/gui/game/troubletown/traitor.png"), true, true),
    DETECTIVE("Detective", ColorReferences.COLOR_THEME_TTT_DETECTIVE, ColorReferences.COLOR_THEME_TTT_DETECTIVE_SUB, sL.GOOD, "bf.message.gamemode.ttt.role.detective.title", "bf.message.gamemode.ttt.role.detective.desc", C0265jv.d("textures/gui/game/troubletown/detective.png"), true, false),
    JESTER("Jester", ColorReferences.COLOR_THEME_TTT_JESTER, ColorReferences.COLOR_THEME_TTT_JESTER_SUB, sL.GOOD, "bf.message.gamemode.ttt.role.jester.title", "bf.message.gamemode.ttt.role.jester.desc", C0265jv.d("textures/gui/game/troubletown/jester.png"), true, true);


    @NotNull
    private final String key;
    private final int color;
    private final int subColor;

    @NotNull
    private final sL team;

    @NotNull
    private final Component title;

    @NotNull
    private final Component description;

    @Nullable
    private final ResourceLocation texture;

    @NotNull
    private final List<C0408pc> roleItems = new ObjectArrayList();
    private final boolean hideRank;
    private final boolean displayOnNameplate;

    static {
        TRAITOR.addRoleItem(new C0408pc((Item) wY.S.get(), 1, new Vec2(0.0f, 2.0f)));
        TRAITOR.addRoleItem(new C0408pc((Item) wY.X.get(), 1, new Vec2(-1.0f, 1.0f)));
        TRAITOR.addRoleItem(new C0408pc((Item) wY.U.get(), 1, new Vec2(0.0f, 1.0f)));
        TRAITOR.addRoleItem(new C0408pc((Item) wY.W.get(), 1, new Vec2(1.0f, 1.0f)));
        TRAITOR.addRoleItem(new C0408pc((Item) wY.p.get(), 1, new Vec2(-1.0f, 0.0f)));
        TRAITOR.addRoleItem(new C0408pc((Item) wY.q.get(), 1, new Vec2(1.0f, 0.0f)));
        TRAITOR.addRoleItem(new C0408pc((Item) wY.nc.get(), 3, new Vec2(-1.0f, -1.0f)));
        TRAITOR.addRoleItem(new C0408pc((Item) wY.ae.get(), 5, new Vec2(0.0f, -1.0f)));
        TRAITOR.addRoleItem(new C0408pc((Item) wY.w.get(), 6, new Vec2(1.0f, -1.0f)));
        DETECTIVE.addRoleItem(new C0408pc((Item) wY.p.get(), 1, new Vec2(-1.0f, 1.0f)));
        DETECTIVE.addRoleItem(new C0408pc((Item) wY.q.get(), 2, new Vec2(0.0f, 1.0f)));
        DETECTIVE.addRoleItem(new C0408pc((Item) wY.x.get(), 1, new Vec2(1.0f, 1.0f)).a(1));
    }

    sK(@NotNull String str, int i, int i2, @NotNull sL sLVar, @NotNull String str2, @NotNull String str3, @Nullable ResourceLocation resourceLocation, boolean z, boolean z2) {
        this.key = str;
        this.color = i;
        this.subColor = i2;
        this.team = sLVar;
        this.title = Component.translatable(str2).withColor(TextColor.fromRgb(i).getValue());
        this.description = Component.translatable(str3).withColor(i2).withStyle(new ChatFormatting[0]);
        this.texture = resourceLocation;
        this.hideRank = z2;
        this.displayOnNameplate = z;
    }

    @NotNull
    public static sK fromKey(String str) {
        for (sK sKVar : values()) {
            if (sKVar.getKey().equalsIgnoreCase(str)) {
                return sKVar;
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

    public void addRoleItem(@NotNull C0408pc c0408pc) {
        this.roleItems.add(c0408pc);
    }

    @NotNull
    public sL getTeam() {
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
    public List<C0408pc> getRoleItems() {
        return this.roleItems;
    }

    public boolean hideRank() {
        return this.hideRank;
    }

    @Nullable
    public C0408pc getRoleItem(int i) {
        if (i >= this.roleItems.size()) {
            return null;
        }
        return this.roleItems.get(i);
    }
}
