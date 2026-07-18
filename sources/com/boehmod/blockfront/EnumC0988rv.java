package com.boehmod.blockfront;

import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rv */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rv.class */
public enum EnumC0988rv {
    WAYPOINT_OBSERVE("observe", false, false, true, "bf.message.radio.waypoint.observe"),
    WAYPOINT_MOVE("move", false, false, true, "bf.message.radio.waypoint.move"),
    WAYPOINT_ATTACK("attack", false, false, true, "bf.message.radio.waypoint.attack"),
    AIR_STRIKE("airstrike", true, true, false, "bf.message.radio.airstrike"),
    PRECISION_AIR_STRIKE("precisionstrike", true, true, false, "bf.message.radio.airstrike.precision"),
    SMOKE_STRIKE("smokestrike", true, false, false, "bf.message.radio.smokestrike");

    private final boolean hasTimeLimit;
    private final boolean spawnProtected;

    @NotNull
    private final String locale;

    @NotNull
    private final String iconName;

    @NotNull
    private final ResourceLocation icon;
    private final boolean isWaypoint;

    EnumC0988rv(@NotNull String str, boolean z, boolean z2, boolean z3, @NotNull String str2) {
        this.hasTimeLimit = z;
        this.spawnProtected = z2;
        this.isWaypoint = z3;
        this.locale = str2;
        this.iconName = str;
        this.icon = C0564jv.m2555d("textures/gui/game/radio/" + str + ".png");
    }

    @NotNull
    public String getIconName() {
        return this.iconName;
    }

    public boolean hasSpawnProtection() {
        return this.spawnProtected;
    }

    public boolean hasTimeLimit() {
        return this.hasTimeLimit;
    }

    public boolean isWaypoint() {
        return this.isWaypoint;
    }

    public boolean hasCooldown() {
        return this.isWaypoint || this.hasTimeLimit;
    }

    @NotNull
    public C1088to getCooldownStat() {
        return this.isWaypoint ? C1089tp.f5707x : C1089tp.f5706w;
    }

    public int getMaxCooldown() {
        if (this.isWaypoint) {
            return 100;
        }
        return C1089tp.f5684rx;
    }

    @NotNull
    public String getLocale() {
        return this.locale;
    }

    @NotNull
    public ResourceLocation getIcon() {
        return this.icon;
    }
}
