package com.boehmod.blockfront;

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

/* JADX INFO: renamed from: com.boehmod.blockfront.sa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sa.class */
public enum EnumC0487sa {
    GENERIC(1.0f, C0624xc.qi, C0624xc.qj, new b() { // from class: com.boehmod.blockfront.sa.1
        @Override // com.boehmod.blockfront.EnumC0487sa.b
        void a(rV rVVar, Level level, int i, Set<UUID> set) {
            MutableComponent mutableComponentWithStyle = Component.literal(String.valueOf(rVVar.qa)).withStyle(ChatFormatting.RED);
            MutableComponent mutableComponentWithStyle2 = Component.translatable("bf.message.gamemode.infected.wave.begun", new Object[]{mutableComponentWithStyle, Component.literal(String.valueOf(rVVar.qb)).withStyle(ChatFormatting.RED)}).withStyle(ChatFormatting.DARK_RED);
            oR.a((oF<?, ?, ?>) rVVar, (Component) Component.translatable("bf.message.gamemode.infected.popup.wave", new Object[]{mutableComponentWithStyle}).withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.BOLD), 80, "inf.wave");
            oR.a((oF<?, ?, ?>) rVVar, (Component) mutableComponentWithStyle2);
            oX oXVarC = rVVar.b().c();
            if (oXVarC != null && rVVar.qa >= 6) {
                Vec3 vec3 = oXVarC.c;
                SoundEvent soundEvent = (SoundEvent) C0624xc.qn.get();
                oR.a(rVVar, soundEvent, SoundSource.AMBIENT, 30.0f, vec3.add(100.0d, 0.0d, 100.0d));
                oR.a(rVVar, soundEvent, SoundSource.AMBIENT, 30.0f, vec3.add(100.0d, 0.0d, -100.0d));
                oR.a(rVVar, soundEvent, SoundSource.AMBIENT, 30.0f, vec3.add(-100.0d, 0.0d, -100.0d));
                oR.a(rVVar, soundEvent, SoundSource.AMBIENT, 30.0f, vec3.add(-100.0d, 0.0d, 100.0d));
            }
        }

        @Override // com.boehmod.blockfront.EnumC0487sa.b
        void a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, rV rVVar, mQ mQVar, Level level) {
            mQVar.a(cVar, 0.2f + (0.025f * rVVar.bt()));
        }
    }),
    DOGS(0.25f, C0624xc.ql, C0624xc.qm, new b() { // from class: com.boehmod.blockfront.sa.2
        @Override // com.boehmod.blockfront.EnumC0487sa.b
        void a(rV rVVar, Level level, int i, Set<UUID> set) {
            MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.gamemode.infected.wave.begun.dogs", new Object[]{Component.literal(String.valueOf(rVVar.qa)).withStyle(ChatFormatting.RED), Component.literal(String.valueOf(rVVar.qb)).withStyle(ChatFormatting.RED)}).withStyle(ChatFormatting.DARK_RED);
            oX oXVarC = rVVar.b().c();
            if (oXVarC != null) {
                level.playSound((Player) null, oXVarC.c(), (SoundEvent) C0624xc.sI.get(), SoundSource.AMBIENT, 35.0f, 1.0f);
            }
            oR.a(rVVar, a.jt, 80, "inf.wave");
            oR.a((oF<?, ?, ?>) rVVar, (Component) mutableComponentWithStyle);
        }

        @Override // com.boehmod.blockfront.EnumC0487sa.b
        void a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, rV rVVar, mQ mQVar, Level level) {
            mQVar.a(cVar, 0.4f + (0.05f * rVVar.bt()));
        }
    });

    private final float countMultiplier;
    private final DeferredHolder<SoundEvent, SoundEvent> roundStartSound;
    private final DeferredHolder<SoundEvent, SoundEvent> roundEndSound;
    private final b roundCallable;

    /* JADX INFO: renamed from: com.boehmod.blockfront.sa$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sa$b.class */
    public static abstract class b {
        abstract void a(rV rVVar, Level level, int i, Set<UUID> set);

        abstract void a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, rV rVVar, mQ mQVar, Level level);
    }

    EnumC0487sa(float f, DeferredHolder deferredHolder, DeferredHolder deferredHolder2, b bVar) {
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

    /* JADX INFO: renamed from: com.boehmod.blockfront.sa$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sa$a.class */
    private static class a {
        public static final Component jt = Component.translatable("bf.message.gamemode.infected.popup.wave.dogs").withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.BOLD);

        private a() {
        }
    }
}
