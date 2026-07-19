package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2i;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oZ.class */
public enum oZ {
    NO("callout_no", "bf.message.gamemode.callout.no", new Vector2i(-1, 1)),
    FORWARD("callout_forward", "bf.message.gamemode.callout.forward", new Vector2i(0, 1)),
    YES("callout_yes", "bf.message.gamemode.callout.yes", new Vector2i(1, 1)),
    ENEMY("callout_enemy", "bf.message.gamemode.callout.enemy", new Vector2i(-2, 0)),
    AMMO("callout_ammo", "bf.message.gamemode.callout.ammo", "ammo", SoundEvents.NOTE_BLOCK_PLING, new Vector2i(-1, 0)),
    MEDIC("callout_medic", "bf.message.gamemode.callout.medic", "medic", SoundEvents.NOTE_BLOCK_PLING, new Vector2i(1, 0)),
    THANK_YOU("callout_thank_you", "bf.message.gamemode.callout.thank_you", new Vector2i(2, 0)),
    GOOD_WORK("callout_good_work", "bf.message.gamemode.callout.good_work", new Vector2i(-1, -1)),
    RETREAT("callout_retreat", "bf.message.gamemode.callout.retreat", new Vector2i(0, -1)),
    SUPPRESS("callout_suppress", "bf.message.gamemode.callout.suppress", new Vector2i(1, -1));


    @NotNull
    private final String translation;

    @Nullable
    private final String waypoint;

    @Nullable
    private final ResourceLocation waypointTexture;

    @Nullable
    private final Holder.Reference<SoundEvent> soundEvent;

    @NotNull
    private final Vector2i buttonPosition;

    @NotNull
    private final ResourceLocation texture;

    oZ(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable Holder.Reference reference, @NotNull Vector2i vector2i) {
        this.translation = str2;
        this.waypoint = str3;
        this.soundEvent = reference;
        this.buttonPosition = vector2i;
        this.texture = C0265jv.d("textures/gui/callout/" + str + ".png");
        if (str3 != null) {
            this.waypointTexture = C0265jv.d("textures/gui/callout/waypoint/" + str3 + ".png");
        } else {
            this.waypointTexture = null;
        }
    }

    oZ(@NotNull String str, @NotNull String str2, @NotNull Vector2i vector2i) {
        this(str, str2, null, null, vector2i);
    }

    @NotNull
    public Vector2i getButtonPosition() {
        return this.buttonPosition;
    }

    @NotNull
    public ResourceLocation getTexture() {
        return this.texture;
    }

    @Nullable
    public ResourceLocation getWaypointTexture() {
        return this.waypointTexture;
    }

    @NotNull
    public String getTranslation() {
        return this.translation;
    }

    @Nullable
    public String getWaypoint() {
        return this.waypoint;
    }

    @Nullable
    public Holder.Reference<SoundEvent> getSoundEvent() {
        return this.soundEvent;
    }
}
