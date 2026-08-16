package com.boehmod.blockfront;

import java.util.Set;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sF */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sF.class */
public class C1000sF extends AbstractC1053tE<C1040ss, C1042su> {

    /* JADX INFO: renamed from: sm */
    public static final int f5489sm = 20;

    public C1000sF() {
        super(20);
    }

    @Override // com.boehmod.blockfront.AbstractC1053tE, com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public void mo5312a(@NotNull C1057tI<C1040ss, C1042su> c1057tI) {
        C1040ss c1040ss = (C1040ss) c1057tI.m5869c();
        ServerLevel serverLevelM5873a = c1057tI.m5873a();
        c1040ss.f5659bw.forEach(c0995sA -> {
            c0995sA.m5586a(serverLevelM5873a, false);
        });
        C0875pn.m4358a(serverLevelM5873a, c1040ss, (AbstractC0866pe<?>) c1057tI.m5870c());
        c1040ss.m5803cW();
        c1040ss.m5787a(serverLevelM5873a, (C0881pt) c1040ss.f5660bx.getFirst());
    }

    @Override // com.boehmod.blockfront.AbstractC1053tE, com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public void mo5317a(@NotNull C1057tI<C1040ss, C1042su> c1057tI, @NotNull EnumC0876po enumC0876po, @NotNull ServerPlayer serverPlayer) {
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: e */
    public void mo5605e(@NotNull C1057tI<C1040ss, C1042su> c1057tI) {
        C1040ss c1040ss = (C1040ss) c1057tI.m5869c();
        Set<UUID> setM5874m = c1057tI.m5874m();
        C0875pn.m4393b(c1057tI.m5872b(), setM5874m);
        C0875pn.m4370a(c1040ss, (SoundEvent) c1040ss.f5670a.getRoundStartSound().get(), SoundSource.MUSIC);
        C0875pn.m4436a((AbstractC0863pb<?, ?, ?>) c1040ss, (Component) Component.translatable("bf.message.gamemode.infected.popup.wave", new Object[]{Component.literal(String.valueOf(c1040ss.f5666sb)).withStyle(ChatFormatting.RED)}).withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.BOLD), 80, "inf.wave");
        C0875pn.m4383a(c1057tI.m5873a(), setM5874m, c1057tI.m5872b());
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1056tH<C1040ss, C1042su> mo5319a(@NotNull C1040ss c1040ss) {
        return new C0999sE();
    }
}
