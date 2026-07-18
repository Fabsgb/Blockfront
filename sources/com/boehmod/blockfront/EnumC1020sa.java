package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.sa */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sa.class */
public enum EnumC1020sa {
    GENERIC(1.0f, C1280xc.f7603qi, C1280xc.f7604qj, new b() { // from class: com.boehmod.blockfront.sa.1
        @Override // com.boehmod.blockfront.EnumC1020sa.b
        /* JADX INFO: renamed from: a */
        void mo5682a(C0962rV c0962rV, Level level, int i, Set<UUID> set) {
            MutableComponent mutableComponentWithStyle = Component.literal(String.valueOf(c0962rV.f5089qa)).withStyle(ChatFormatting.RED);
            MutableComponent mutableComponentWithStyle2 = Component.translatable("bf.message.gamemode.infected.wave.begun", new Object[]{mutableComponentWithStyle, Component.literal(String.valueOf(c0962rV.f5090qb)).withStyle(ChatFormatting.RED)}).withStyle(ChatFormatting.DARK_RED);
            C0799oR.m4000a((AbstractC0787oF<?, ?, ?>) c0962rV, (Component) Component.translatable("bf.message.gamemode.infected.popup.wave", new Object[]{mutableComponentWithStyle}).withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.BOLD), 80, "inf.wave");
            C0799oR.m3981a((AbstractC0787oF<?, ?, ?>) c0962rV, (Component) mutableComponentWithStyle2);
            C0805oX c0805oXC = c0962rV.m3582b().m3790c();
            if (c0805oXC != null && c0962rV.f5089qa >= 6) {
                Vec3 vec3 = c0805oXC.f4424c;
                SoundEvent soundEvent = (SoundEvent) C1280xc.f7608qn.get();
                C0799oR.m3938a(c0962rV, soundEvent, SoundSource.AMBIENT, 30.0f, vec3.add(100.0d, 0.0d, 100.0d));
                C0799oR.m3938a(c0962rV, soundEvent, SoundSource.AMBIENT, 30.0f, vec3.add(100.0d, 0.0d, -100.0d));
                C0799oR.m3938a(c0962rV, soundEvent, SoundSource.AMBIENT, 30.0f, vec3.add(-100.0d, 0.0d, -100.0d));
                C0799oR.m3938a(c0962rV, soundEvent, SoundSource.AMBIENT, 30.0f, vec3.add(-100.0d, 0.0d, 100.0d));
            }
        }

        @Override // com.boehmod.blockfront.EnumC1020sa.b
        /* JADX INFO: renamed from: a */
        void mo5683a(@NotNull AbstractC0183c<?> abstractC0183c, C0962rV c0962rV, C0692mQ c0692mQ, Level level) {
            c0692mQ.mo3119a(abstractC0183c, 0.2f + (0.025f * c0962rV.mo4694bt()));
        }
    }),
    DOGS(0.25f, C1280xc.f7606ql, C1280xc.f7607qm, new b() { // from class: com.boehmod.blockfront.sa.2
        @Override // com.boehmod.blockfront.EnumC1020sa.b
        /* JADX INFO: renamed from: a */
        void mo5682a(C0962rV c0962rV, Level level, int i, Set<UUID> set) {
            MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.gamemode.infected.wave.begun.dogs", new Object[]{Component.literal(String.valueOf(c0962rV.f5089qa)).withStyle(ChatFormatting.RED), Component.literal(String.valueOf(c0962rV.f5090qb)).withStyle(ChatFormatting.RED)}).withStyle(ChatFormatting.DARK_RED);
            C0805oX c0805oXC = c0962rV.m3582b().m3790c();
            if (c0805oXC != null) {
                level.playSound((Player) null, c0805oXC.m4150c(), (SoundEvent) C1280xc.f7733sI.get(), SoundSource.AMBIENT, 35.0f, 1.0f);
            }
            C0799oR.m4000a(c0962rV, a.f5422jt, 80, "inf.wave");
            C0799oR.m3981a((AbstractC0787oF<?, ?, ?>) c0962rV, (Component) mutableComponentWithStyle);
        }

        @Override // com.boehmod.blockfront.EnumC1020sa.b
        /* JADX INFO: renamed from: a */
        void mo5683a(@NotNull AbstractC0183c<?> abstractC0183c, C0962rV c0962rV, C0692mQ c0692mQ, Level level) {
            c0692mQ.mo3119a(abstractC0183c, 0.4f + (0.05f * c0962rV.mo4694bt()));
        }
    });

    private final float countMultiplier;
    private final DeferredHolder<SoundEvent, SoundEvent> roundStartSound;
    private final DeferredHolder<SoundEvent, SoundEvent> roundEndSound;
    private final b roundCallable;

    /* JADX INFO: renamed from: com.boehmod.blockfront.sa$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sa$b.class */
    public static abstract class b {
        /* JADX INFO: renamed from: a */
        abstract void mo5682a(C0962rV c0962rV, Level level, int i, Set<UUID> set);

        /* JADX INFO: renamed from: a */
        abstract void mo5683a(@NotNull AbstractC0183c<?> abstractC0183c, C0962rV c0962rV, C0692mQ c0692mQ, Level level);
    }

    EnumC1020sa(float f, DeferredHolder deferredHolder, DeferredHolder deferredHolder2, b bVar) {
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

        /* JADX INFO: renamed from: jt */
        public static final Component f5422jt = Component.translatable("bf.message.gamemode.infected.popup.wave.dogs").withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.BOLD);

        private a() {
        }
    }
}
