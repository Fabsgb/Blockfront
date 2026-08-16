package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0184c;
import java.util.Set;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sx.class */
public enum EnumC1045sx {
    GENERIC(1.0f, C1312xz.f8015qk, C1312xz.f8016ql, new b() { // from class: com.boehmod.blockfront.sx.1
        @Override // com.boehmod.blockfront.EnumC1045sx.b
        /* JADX INFO: renamed from: a */
        void mo5845a(C1040ss c1040ss, Level level, int i, Set<UUID> set) {
            MutableComponent mutableComponentWithStyle = Component.literal(String.valueOf(c1040ss.f5666sb)).withStyle(ChatFormatting.RED);
            MutableComponent mutableComponentWithStyle2 = Component.translatable("bf.message.gamemode.infected.wave.begun", new Object[]{mutableComponentWithStyle, Component.literal(String.valueOf(c1040ss.f5667sc)).withStyle(ChatFormatting.RED)}).withStyle(ChatFormatting.DARK_RED);
            C0875pn.m4436a((AbstractC0863pb<?, ?, ?>) c1040ss, (Component) Component.translatable("bf.message.gamemode.infected.popup.wave", new Object[]{mutableComponentWithStyle}).withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.BOLD), 80, "inf.wave");
            C0875pn.m4417a((AbstractC0863pb<?, ?, ?>) c1040ss, (Component) mutableComponentWithStyle2);
            C0881pt c0881ptC = c1040ss.m4018b().m4226c();
            if (c0881ptC != null && c1040ss.f5666sb >= 6) {
                Vec3 vec3 = c0881ptC.f4827c;
                SoundEvent soundEvent = (SoundEvent) C1312xz.f8020qp.get();
                C0875pn.m4374a(c1040ss, soundEvent, SoundSource.AMBIENT, 30.0f, vec3.add(100.0d, 0.0d, 100.0d));
                C0875pn.m4374a(c1040ss, soundEvent, SoundSource.AMBIENT, 30.0f, vec3.add(100.0d, 0.0d, -100.0d));
                C0875pn.m4374a(c1040ss, soundEvent, SoundSource.AMBIENT, 30.0f, vec3.add(-100.0d, 0.0d, -100.0d));
                C0875pn.m4374a(c1040ss, soundEvent, SoundSource.AMBIENT, 30.0f, vec3.add(-100.0d, 0.0d, 100.0d));
            }
        }

        @Override // com.boehmod.blockfront.EnumC1045sx.b
        /* JADX INFO: renamed from: a */
        void mo5846a(@NotNull AbstractC0184c<?> abstractC0184c, C1040ss c1040ss, C0768nm c0768nm, Level level) {
            c0768nm.mo3626a(abstractC0184c, 0.2f + (0.025f * c1040ss.mo5565bI()));
        }
    }),
    DOGS(0.25f, C1312xz.f8018qn, C1312xz.f8019qo, new b() { // from class: com.boehmod.blockfront.sx.2
        @Override // com.boehmod.blockfront.EnumC1045sx.b
        /* JADX INFO: renamed from: a */
        void mo5845a(C1040ss c1040ss, Level level, int i, Set<UUID> set) {
            MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.gamemode.infected.wave.begun.dogs", new Object[]{Component.literal(String.valueOf(c1040ss.f5666sb)).withStyle(ChatFormatting.RED), Component.literal(String.valueOf(c1040ss.f5667sc)).withStyle(ChatFormatting.RED)}).withStyle(ChatFormatting.DARK_RED);
            C0881pt c0881ptC = c1040ss.m4018b().m4226c();
            if (c0881ptC != null) {
                level.playSound((Player) null, c0881ptC.m4587c(), (SoundEvent) C1312xz.f8144sJ.get(), SoundSource.AMBIENT, 35.0f, 1.0f);
            }
            C0875pn.m4436a(c1040ss, a.f5689jG, 80, "inf.wave");
            C0875pn.m4417a((AbstractC0863pb<?, ?, ?>) c1040ss, (Component) mutableComponentWithStyle);
        }

        @Override // com.boehmod.blockfront.EnumC1045sx.b
        /* JADX INFO: renamed from: a */
        void mo5846a(@NotNull AbstractC0184c<?> abstractC0184c, C1040ss c1040ss, C0768nm c0768nm, Level level) {
            c0768nm.mo3626a(abstractC0184c, 0.4f + (0.05f * c1040ss.mo5565bI()));
        }
    });

    private final float countMultiplier;
    private final DeferredHolder<SoundEvent, SoundEvent> roundStartSound;
    private final DeferredHolder<SoundEvent, SoundEvent> roundEndSound;
    private final b roundCallable;

    /* JADX INFO: renamed from: com.boehmod.blockfront.sx$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sx$b.class */
    public static abstract class b {
        /* JADX INFO: renamed from: a */
        abstract void mo5845a(C1040ss c1040ss, Level level, int i, Set<UUID> set);

        /* JADX INFO: renamed from: a */
        abstract void mo5846a(@NotNull AbstractC0184c<?> abstractC0184c, C1040ss c1040ss, C0768nm c0768nm, Level level);
    }

    EnumC1045sx(float f, DeferredHolder deferredHolder, DeferredHolder deferredHolder2, b bVar) {
        this.countMultiplier = f;
        this.roundStartSound = deferredHolder;
        this.roundEndSound = deferredHolder2;
        this.roundCallable = bVar;
    }

    public b getRoundCallable() {
        return this.roundCallable;
    }

    public float getCountMultiplier() {
        return this.countMultiplier;
    }

    public final DeferredHolder<SoundEvent, SoundEvent> getRoundStartSound() {
        return this.roundStartSound;
    }

    public final DeferredHolder<SoundEvent, SoundEvent> getRoundEndSound() {
        return this.roundEndSound;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.sx$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sx$a.class */
    private static class a {

        /* JADX INFO: renamed from: jG */
        public static final Component f5689jG = Component.translatable("bf.message.gamemode.infected.popup.wave.dogs").withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.BOLD);

        private a() {
        }
    }
}
