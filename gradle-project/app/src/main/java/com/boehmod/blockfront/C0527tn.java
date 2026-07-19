package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tn.class */
public class C0527tn extends C0528to {

    @NotNull
    private final String cX;
    private final int rw;

    @NotNull
    private final ChatFormatting a;

    @Nullable
    private final DeferredHolder<SoundEvent, SoundEvent> aU;

    C0527tn(@NotNull String str, @NotNull String str2, int i, @NotNull ChatFormatting chatFormatting, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        super(str);
        this.cX = str2;
        this.rw = i;
        this.a = chatFormatting;
        this.aU = deferredHolder;
    }

    C0527tn(@NotNull String str, @NotNull String str2, int i, @NotNull ChatFormatting chatFormatting) {
        this(str, str2, i, chatFormatting, null);
    }

    public void a(@NotNull UUID uuid, int i) {
        if (this.aU != null) {
            oR.a(uuid, (SoundEvent) this.aU.get(), SoundSource.NEUTRAL);
        }
        oR.a(uuid, new sQ(Component.translatable(this.cX, new Object[]{Component.literal(String.valueOf(i)).withColor(ColorReferences.COLOR_WHITE)}).withStyle(this.a), this.rw));
    }
}
