package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.connection.ConnectionStatus;
import com.boehmod.bflib.common.ColorReferences;
import it.unimi.dsi.fastutil.Pair;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dg */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dg.class */
public enum EnumC0231dg {
    CONNECTING("bf.message.intro.online.connecting", "bf.message.intro.online.connecting.tip", "textures/gui/intro/stage_connecting.png") { // from class: com.boehmod.blockfront.dg.1
        @Override // com.boehmod.blockfront.EnumC0231dg
        @NotNull
        public Pair<Component, Component> getDisplayComponents(@NotNull Component component, @NotNull Component component2, float f) {
            return Pair.of(Component.translatable(getTitleKey(), new Object[]{component, component2}).withColor(ColorReferences.COLOR_TEAM_ALLIES), Component.translatable(getTipKey(), new Object[]{component}).withStyle(ChatFormatting.GRAY));
        }
    },
    ENCRYPTING("bf.message.intro.online.encrypting", "bf.message.intro.online.encrypting.tip", "textures/gui/intro/stage_encrypting.png") { // from class: com.boehmod.blockfront.dg.2
        @Override // com.boehmod.blockfront.EnumC0231dg
        @NotNull
        public Pair<Component, Component> getDisplayComponents(@NotNull Component component, @NotNull Component component2, float f) {
            return Pair.of(Component.translatable(getTitleKey(), new Object[]{component, component2}).withColor(ColorReferences.COLOR_TEAM_ALLIES), Component.translatable(getTipKey(), new Object[]{component}).withStyle(ChatFormatting.GRAY));
        }
    },
    VERIFYING("bf.message.intro.online.verifying", "bf.message.intro.online.verifying.tip", "textures/gui/intro/stage_verifying.png") { // from class: com.boehmod.blockfront.dg.3
        @Override // com.boehmod.blockfront.EnumC0231dg
        @NotNull
        public Pair<Component, Component> getDisplayComponents(@NotNull Component component, @NotNull Component component2, float f) {
            return Pair.of(Component.translatable(getTitleKey(), new Object[]{component, component2, C0116bh.m346a(f)}).withColor(ColorReferences.COLOR_TEAM_ALLIES), Component.translatable(getTipKey()).withStyle(ChatFormatting.GRAY));
        }
    },
    SYNCING("bf.message.intro.online.syncing", "bf.message.intro.online.syncing.tip", "textures/gui/intro/stage_syncing.png") { // from class: com.boehmod.blockfront.dg.4
        @Override // com.boehmod.blockfront.EnumC0231dg
        @NotNull
        public Pair<Component, Component> getDisplayComponents(@NotNull Component component, @NotNull Component component2, float f) {
            return Pair.of(Component.translatable(getTitleKey(), new Object[]{component, C0116bh.m346a(f)}).withColor(ColorReferences.COLOR_TEAM_ALLIES), Component.translatable(getTipKey()).withStyle(ChatFormatting.GRAY));
        }
    };


    @NotNull
    private final String titleKey;

    @NotNull
    private final String tipKey;

    @NotNull
    final ResourceLocation iconTexture;

    @NotNull
    public abstract Pair<Component, Component> getDisplayComponents(@NotNull Component component, @NotNull Component component2, float f);

    EnumC0231dg(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        this.titleKey = str;
        this.tipKey = str2;
        this.iconTexture = C0564jv.m2555d(str3);
    }

    @NotNull
    public String getTitleKey() {
        return this.titleKey;
    }

    @NotNull
    public String getTipKey() {
        return this.tipKey;
    }

    @NotNull
    public ResourceLocation getIconTexture() {
        return this.iconTexture;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @NotNull
    public static EnumC0231dg getCurrentStage(@NotNull ConnectionStatus connectionStatus) throws MatchException {
        switch (connectionStatus) {
            case CLOSED:
                return CONNECTING;
            case CONNECTED_NOT_ENCRYPTED:
                return ENCRYPTING;
            case CONNECTED_NOT_VERIFIED:
                return VERIFYING;
            case CONNECTED_VERIFIED:
                return SYNCING;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }
}
