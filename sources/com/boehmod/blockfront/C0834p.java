package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0567jy;
import java.util.Objects;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.p */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/p.class */
public final class C0834p extends AbstractC0567jy {

    /* JADX INFO: renamed from: a */
    @Nullable
    private SoundInstance f4460a;

    public C0834p(@NotNull String str) {
        super(str);
        this.f4460a = null;
    }

    @Override // com.boehmod.blockfront.AbstractC0567jy
    /* JADX INFO: renamed from: d */
    public int mo2566d() {
        if (m2562a() == AbstractC0567jy.a.READY) {
            return 9633658;
        }
        return ColorReferences.COLOR_THEME_YELLOW;
    }

    /* JADX INFO: renamed from: e */
    public int m4208e() {
        return m2562a() == AbstractC0567jy.a.READY ? ColorReferences.COLOR_THEME_PRESTIGE_SOLID : ColorReferences.COLOR_THEME_YELLOW_SOLID;
    }

    @Override // com.boehmod.blockfront.AbstractC0567jy
    /* JADX INFO: renamed from: f */
    protected void mo2573f() {
        C0287ej.m1508a(Minecraft.getInstance(), (Component) Component.translatable("bf.menu.text.update.title", new Object[]{Component.literal(m2559s()).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.YELLOW), EnumC0286ei.MOD_UPDATE_NOTIFICATION);
    }

    @Override // com.boehmod.blockfront.AbstractC0567jy
    /* JADX INFO: renamed from: a */
    protected void mo2574a(@NotNull AbstractC0567jy.a aVar) {
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.execute(() -> {
            switch (aVar) {
                case PREPARING:
                    m4209e(minecraft);
                    break;
                case READY:
                    m4210f(minecraft);
                    break;
                case FAILED:
                    m4211g(minecraft);
                    break;
            }
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0567jy
    /* JADX INFO: renamed from: g */
    protected void mo2572g() {
        Minecraft minecraft = Minecraft.getInstance();
        Objects.requireNonNull(minecraft);
        minecraft.execute(minecraft::stop);
    }

    /* JADX INFO: renamed from: e */
    private void m4209e(@NotNull Minecraft minecraft) {
        SoundManager soundManager = minecraft.getSoundManager();
        soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7528oL.get(), 1.0f, 1.0f));
        m4212h(minecraft);
        this.f4460a = new SimpleSoundInstance(((SoundEvent) C1280xc.f7527oK.get()).getLocation(), SoundSource.MASTER, 1.0f, 1.0f, SoundInstance.createUnseededRandom(), true, 0, SoundInstance.Attenuation.NONE, 0.0d, 0.0d, 0.0d, true);
        soundManager.play(this.f4460a);
    }

    /* JADX INFO: renamed from: f */
    private void m4210f(@NotNull Minecraft minecraft) {
        m4212h(minecraft);
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7526oJ.get(), 1.0f, 1.0f));
    }

    /* JADX INFO: renamed from: g */
    private void m4211g(@NotNull Minecraft minecraft) {
        m4212h(minecraft);
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) SoundEvents.NOTE_BLOCK_BASS.value(), 0.5f, 1.0f));
    }

    /* JADX INFO: renamed from: h */
    private void m4212h(@NotNull Minecraft minecraft) {
        SoundInstance soundInstance = this.f4460a;
        if (soundInstance != null) {
            minecraft.getSoundManager().stop(soundInstance);
            this.f4460a = null;
        }
    }
}
