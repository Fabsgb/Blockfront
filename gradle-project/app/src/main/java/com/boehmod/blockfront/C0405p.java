package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0268jy;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/p.class */
public final class C0405p extends AbstractC0268jy {

    @Nullable
    private SoundInstance a;

    public C0405p(@NotNull String str) {
        super(str);
        this.a = null;
    }

    @Override // com.boehmod.blockfront.AbstractC0268jy
    public int d() {
        if (a() == AbstractC0268jy.a.READY) {
            return 9633658;
        }
        return ColorReferences.COLOR_THEME_YELLOW;
    }

    public int e() {
        return a() == AbstractC0268jy.a.READY ? ColorReferences.COLOR_THEME_PRESTIGE_SOLID : ColorReferences.COLOR_THEME_YELLOW_SOLID;
    }

    @Override // com.boehmod.blockfront.AbstractC0268jy
    protected void f() {
        C0119ej.a(Minecraft.getInstance(), (Component) Component.translatable("bf.menu.text.update.title", new Object[]{Component.literal(s()).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.YELLOW), EnumC0118ei.MOD_UPDATE_NOTIFICATION);
    }

    @Override // com.boehmod.blockfront.AbstractC0268jy
    protected void a(@NotNull AbstractC0268jy.a aVar) {
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.execute(() -> {
            switch (aVar) {
                case PREPARING:
                    e(minecraft);
                    break;
                case READY:
                    f(minecraft);
                    break;
                case FAILED:
                    g(minecraft);
                    break;
            }
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0268jy
    protected void g() {
        Minecraft minecraft = Minecraft.getInstance();
        Objects.requireNonNull(minecraft);
        minecraft.execute(minecraft::stop);
    }

    private void e(@NotNull Minecraft minecraft) {
        SoundManager soundManager = minecraft.getSoundManager();
        soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.oL.get(), 1.0f, 1.0f));
        h(minecraft);
        this.a = new SimpleSoundInstance(((SoundEvent) C0624xc.oK.get()).getLocation(), SoundSource.MASTER, 1.0f, 1.0f, SoundInstance.createUnseededRandom(), true, 0, SoundInstance.Attenuation.NONE, 0.0d, 0.0d, 0.0d, true);
        soundManager.play(this.a);
    }

    private void f(@NotNull Minecraft minecraft) {
        h(minecraft);
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.oJ.get(), 1.0f, 1.0f));
    }

    private void g(@NotNull Minecraft minecraft) {
        h(minecraft);
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) SoundEvents.NOTE_BLOCK_BASS.value(), 0.5f, 1.0f));
    }

    private void h(@NotNull Minecraft minecraft) {
        SoundInstance soundInstance = this.a;
        if (soundInstance != null) {
            minecraft.getSoundManager().stop(soundInstance);
            this.a = null;
        }
    }
}
