package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
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
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/p.class */
public final class C0835p extends AbstractC0535jR {

    /* JADX INFO: renamed from: a */
    @Nullable
    private SoundInstance f4501a;

    public C0835p(@NotNull String str) {
        super(str);
        this.f4501a = null;
    }

    @Override // com.boehmod.blockfront.AbstractC0535jR
    /* JADX INFO: renamed from: d */
    public int mo2389d() {
        if (m2387a() == AbstractC0535jR.a.READY) {
            return 9633658;
        }
        return ColorReferences.COLOR_THEME_YELLOW;
    }

    @Override // com.boehmod.blockfront.AbstractC0535jR
    /* JADX INFO: renamed from: e */
    public int mo2390e() {
        return m2387a() == AbstractC0535jR.a.READY ? ColorReferences.COLOR_THEME_PRESTIGE_SOLID : ColorReferences.COLOR_THEME_YELLOW_SOLID;
    }

    @Override // com.boehmod.blockfront.AbstractC0535jR
    /* JADX INFO: renamed from: f */
    protected void mo2397f() {
        C0301ew.m1624a(Minecraft.getInstance(), (Component) Component.translatable("bf.menu.text.update.title", new Object[]{Component.literal(m2383w()).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.YELLOW), EnumC0300ev.MOD_UPDATE_NOTIFICATION);
    }

    @Override // com.boehmod.blockfront.AbstractC0535jR
    /* JADX INFO: renamed from: a */
    protected void mo2398a(@NotNull AbstractC0535jR.a aVar) {
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.execute(() -> {
            switch (aVar) {
                case PREPARING:
                    m3794e(minecraft);
                    break;
                case READY:
                    m3795f(minecraft);
                    break;
                case FAILED:
                    m3796g(minecraft);
                    break;
            }
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0535jR
    /* JADX INFO: renamed from: g */
    protected void mo2396g() {
        Minecraft minecraft = Minecraft.getInstance();
        Objects.requireNonNull(minecraft);
        minecraft.execute(minecraft::stop);
    }

    /* JADX INFO: renamed from: e */
    private void m3794e(@NotNull Minecraft minecraft) {
        SoundManager soundManager = minecraft.getSoundManager();
        soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7940oN.get(), 1.0f, 1.0f));
        m3797h(minecraft);
        this.f4501a = new SimpleSoundInstance(((SoundEvent) C1312xz.f7939oM.get()).getLocation(), SoundSource.MASTER, 1.0f, 1.0f, SoundInstance.createUnseededRandom(), true, 0, SoundInstance.Attenuation.NONE, 0.0d, 0.0d, 0.0d, true);
        soundManager.play(this.f4501a);
    }

    /* JADX INFO: renamed from: f */
    private void m3795f(@NotNull Minecraft minecraft) {
        m3797h(minecraft);
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7938oL.get(), 1.0f, 1.0f));
    }

    /* JADX INFO: renamed from: g */
    private void m3796g(@NotNull Minecraft minecraft) {
        m3797h(minecraft);
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) SoundEvents.NOTE_BLOCK_BASS.value(), 0.5f, 1.0f));
    }

    /* JADX INFO: renamed from: h */
    private void m3797h(@NotNull Minecraft minecraft) {
        SoundInstance soundInstance = this.f4501a;
        if (soundInstance != null) {
            minecraft.getSoundManager().stop(soundInstance);
            this.f4501a = null;
        }
    }
}
