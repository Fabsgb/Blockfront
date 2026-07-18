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

/* JADX INFO: renamed from: com.boehmod.blockfront.si */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/si.class */
public class C1029si extends AbstractC1081th<C0962rV, C0964rX> {

    /* JADX INFO: renamed from: ql */
    public static final int f5442ql = 20;

    public C1029si() {
        super(20);
    }

    @Override // com.boehmod.blockfront.AbstractC1081th, com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public void mo5141a(@NotNull C1085tl<C0962rV, C0964rX> c1085tl) {
        C0962rV c0962rV = (C0962rV) c1085tl.m5989c();
        ServerLevel serverLevelM5993a = c1085tl.m5993a();
        c0962rV.f5082bp.forEach(c1023sd -> {
            c1023sd.m5701a(serverLevelM5993a, false);
        });
        C0799oR.m3922a(serverLevelM5993a, c0962rV, (AbstractC0790oI<?>) c1085tl.m5990c());
        c0962rV.m5266cK();
        c0962rV.m5250a(serverLevelM5993a, (C0805oX) c0962rV.f5083bq.getFirst());
    }

    @Override // com.boehmod.blockfront.AbstractC1081th, com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: a */
    public void mo5146a(@NotNull C1085tl<C0962rV, C0964rX> c1085tl, @NotNull EnumC0800oS enumC0800oS, @NotNull ServerPlayer serverPlayer) {
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    /* JADX INFO: renamed from: e */
    public void mo5222e(@NotNull C1085tl<C0962rV, C0964rX> c1085tl) {
        C0962rV c0962rV = (C0962rV) c1085tl.m5989c();
        Set<UUID> setM5994m = c1085tl.m5994m();
        C0799oR.m3957b(c1085tl.m5992b(), setM5994m);
        C0799oR.m3934a(c0962rV, (SoundEvent) c0962rV.f5093a.getRoundStartSound().get(), SoundSource.MUSIC);
        C0799oR.m4000a((AbstractC0787oF<?, ?, ?>) c0962rV, (Component) Component.translatable("bf.message.gamemode.infected.popup.wave", new Object[]{Component.literal(String.valueOf(c0962rV.f5089qa)).withStyle(ChatFormatting.RED)}).withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.BOLD), 80, "inf.wave");
        C0799oR.m3947a(c1085tl.m5993a(), setM5994m, c1085tl.m5992b());
    }

    @Override // com.boehmod.blockfront.AbstractC1084tk
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1084tk<C0962rV, C0964rX> mo5148a(@NotNull C0962rV c0962rV) {
        return new C1028sh();
    }
}
