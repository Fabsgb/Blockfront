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

/* JADX INFO: renamed from: com.boehmod.blockfront.tK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tK.class */
public class C1059tK extends C1060tL {

    /* JADX INFO: renamed from: dh */
    @NotNull
    private final String f5724dh;

    /* JADX INFO: renamed from: tx */
    private final int f5725tx;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ChatFormatting f5726a;

    /* JADX INFO: renamed from: aU */
    @Nullable
    private final DeferredHolder<SoundEvent, SoundEvent> f5727aU;

    C1059tK(@NotNull String str, @NotNull String str2, int i, @NotNull ChatFormatting chatFormatting, @Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        super(str);
        this.f5724dh = str2;
        this.f5725tx = i;
        this.f5726a = chatFormatting;
        this.f5727aU = deferredHolder;
    }

    C1059tK(@NotNull String str, @NotNull String str2, int i, @NotNull ChatFormatting chatFormatting) {
        this(str, str2, i, chatFormatting, null);
    }

    /* JADX INFO: renamed from: a */
    public void m5881a(@NotNull UUID uuid, int i) {
        if (this.f5727aU != null) {
            C0875pn.m4363a(uuid, (SoundEvent) this.f5727aU.get(), SoundSource.NEUTRAL);
        }
        C0875pn.m4380a(uuid, new C1088tn(Component.translatable(this.f5724dh, new Object[]{Component.literal(String.valueOf(i)).withColor(ColorReferences.COLOR_WHITE)}).withStyle(this.f5726a), this.f5725tx));
    }
}
