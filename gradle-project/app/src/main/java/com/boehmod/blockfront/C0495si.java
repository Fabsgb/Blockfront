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

/* JADX INFO: renamed from: com.boehmod.blockfront.si, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/si.class */
public class C0495si extends AbstractC0521th<rV, rX> {
    public static final int ql = 20;

    public C0495si() {
        super(20);
    }

    @Override // com.boehmod.blockfront.AbstractC0521th, com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<rV, rX> c0525tl) {
        rV rVVar = (rV) c0525tl.c();
        ServerLevel serverLevelA = c0525tl.a();
        rVVar.bp.forEach(c0490sd -> {
            c0490sd.a(serverLevelA, false);
        });
        oR.a(serverLevelA, rVVar, (oI<?>) c0525tl.m1161c());
        rVVar.cK();
        rVVar.a(serverLevelA, (oX) rVVar.bq.getFirst());
    }

    @Override // com.boehmod.blockfront.AbstractC0521th, com.boehmod.blockfront.AbstractC0524tk
    public void a(@NotNull C0525tl<rV, rX> c0525tl, @NotNull oS oSVar, @NotNull ServerPlayer serverPlayer) {
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    public void e(@NotNull C0525tl<rV, rX> c0525tl) {
        rV rVVar = (rV) c0525tl.c();
        Set<UUID> setM = c0525tl.m();
        oR.b(c0525tl.m1162b(), setM);
        oR.a(rVVar, (SoundEvent) rVVar.f297a.getRoundStartSound().get(), SoundSource.MUSIC);
        oR.a((oF<?, ?, ?>) rVVar, (Component) Component.translatable("bf.message.gamemode.infected.popup.wave", new Object[]{Component.literal(String.valueOf(rVVar.qa)).withStyle(ChatFormatting.RED)}).withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.BOLD), 80, "inf.wave");
        oR.a(c0525tl.a(), setM, c0525tl.m1162b());
    }

    @Override // com.boehmod.blockfront.AbstractC0524tk
    @NotNull
    public AbstractC0524tk<rV, rX> a(@NotNull rV rVVar) {
        return new C0494sh();
    }
}
