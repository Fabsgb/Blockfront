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

/* JADX INFO: renamed from: com.boehmod.blockfront.tn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tn.class */
public class C1087tn extends C1088to {

    /* JADX INFO: renamed from: cX */
    @NotNull
    private final String f5677cX;

    /* JADX INFO: renamed from: rw */
    private final int f5678rw;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ChatFormatting f5679a;

    /* JADX INFO: renamed from: aU */
    @Nullable
    private final DeferredHolder<SoundEvent, SoundEvent> f5680aU;

    C1087tn(@NotNull String str, @NotNull String str2, int i, @NotNull ChatFormatting chatFormatting, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        super(str);
        this.f5677cX = str2;
        this.f5678rw = i;
        this.f5679a = chatFormatting;
        this.f5680aU = deferredHolder;
    }

    C1087tn(@NotNull String str, @NotNull String str2, int i, @NotNull ChatFormatting chatFormatting) {
        this(str, str2, i, chatFormatting, null);
    }

    /* JADX INFO: renamed from: a */
    public void m6001a(@NotNull UUID uuid, int i) {
        if (this.f5680aU != null) {
            C0799oR.m3927a(uuid, (SoundEvent) this.f5680aU.get(), SoundSource.NEUTRAL);
        }
        C0799oR.m3944a(uuid, new C1010sQ(Component.translatable(this.f5677cX, new Object[]{Component.literal(String.valueOf(i)).withColor(ColorReferences.COLOR_WHITE)}).withStyle(this.f5679a), this.f5678rw));
    }
}
