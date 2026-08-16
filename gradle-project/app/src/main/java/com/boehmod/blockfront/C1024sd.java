package com.boehmod.blockfront;

import java.util.Set;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sd */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sd.class */
public class C1024sd extends AbstractC1056tH<C0966rY, C1022sb> implements InterfaceC1054tF<C0966rY, C1022sb> {

    /* JADX INFO: renamed from: hl */
    private boolean f5609hl = false;

    /* JADX INFO: renamed from: hm */
    private boolean f5610hm = false;

    /* JADX INFO: renamed from: hn */
    private boolean f5611hn = false;

    /* JADX INFO: renamed from: ho */
    private boolean f5612ho = false;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C0873pl f5613b = new C0873pl(20, 0).m4326a(20);

    /* JADX INFO: renamed from: hp */
    static final /* synthetic */ boolean f5614hp;

    static {
        f5614hp = !C1024sd.class.desiredAssertionStatus();
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public void mo5312a(@NotNull C1057tI<C0966rY, C1022sb> c1057tI) {
        C0875pn.m4361a(c1057tI.m5874m(), C0502il.m2254a().m2255a(EnumC1203vw.START).m2259a(5));
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: b */
    public void mo5313b(@NotNull C1057tI<C0966rY, C1022sb> c1057tI) {
        C0966rY c0966rY = (C0966rY) c1057tI.m5869c();
        C1022sb c1022sb = (C1022sb) c1057tI.m5870c();
        ServerLevel serverLevelM5873a = c1057tI.m5873a();
        Set<UUID> setM5874m = c1057tI.m5874m();
        this.f5613b.m4328c(setM5874m);
        C0872pk c0872pkA = c1022sb.m4242a(C1062tN.f5783dl);
        if (!f5614hp && c0872pkA == null) {
            throw new AssertionError();
        }
        int iM4302a = c0872pkA.m4302a(C1062tN.f5748l);
        C0872pk c0872pkA2 = c1022sb.m4242a(C1062tN.f5782dk);
        if (!f5614hp && c0872pkA2 == null) {
            throw new AssertionError();
        }
        int iM4302a2 = c0872pkA2.m4302a(C1062tN.f5748l);
        C0875pn.m4393b(c1057tI.m5872b(), setM5874m);
        c0966rY.m5329aq().forEach(c0880ps -> {
            c0880ps.m4560a(serverLevelM5873a, (Set<UUID>) setM5874m);
        });
        c0966rY.m5321b(c1057tI.m5871b(), c1057tI.m5872b(), serverLevelM5873a, setM5874m);
        c0966rY.m5331g(serverLevelM5873a);
        int iM4335bq = this.f5613b.m4335bq();
        boolean z = iM4302a >= 440 || iM4302a2 >= 440 || iM4335bq <= 120;
        boolean z2 = iM4302a >= 460 || iM4302a2 >= 460 || iM4335bq <= 60;
        boolean z3 = iM4302a >= 480 || iM4302a2 >= 480 || iM4335bq <= 30;
        if (z && !this.f5610hm) {
            this.f5610hm = true;
            C0875pn.m4361a(setM5874m, C0502il.m2254a().m2257c(EnumC1203vw.SUSPENSE_ONE));
        }
        if (z2 && !this.f5611hn) {
            this.f5611hn = true;
            C0875pn.m4361a(setM5874m, C0502il.m2254a().m2257c(EnumC1203vw.SUSPENSE_TWO));
        }
        if (z3 && !this.f5612ho) {
            this.f5612ho = true;
            C0875pn.m4361a(setM5874m, C0502il.m2254a().m2257c(EnumC1203vw.SUSPENSE_THREE));
        }
        if (!this.f5609hl) {
            if (iM4302a >= 250) {
                this.f5609hl = true;
                C0875pn.m4436a((AbstractC0863pb<?, ?, ?>) c0966rY, (Component) Component.translatable("bf.message.gamemode.winning", new Object[]{Component.literal(c0872pkA.m4296a((AbstractC0863pb<?, ?, ?>) c0966rY).m6179a().getName()).withStyle(ChatFormatting.GRAY)}).withStyle(c0872pkA.m4312a()), 80, "game.winning");
            } else if (iM4302a2 >= 250) {
                this.f5609hl = true;
                C0875pn.m4436a((AbstractC0863pb<?, ?, ?>) c0966rY, (Component) Component.translatable("bf.message.gamemode.winning", new Object[]{Component.literal(c0872pkA2.m4296a((AbstractC0863pb<?, ?, ?>) c0966rY).m6179a().getName()).withStyle(ChatFormatting.GRAY)}).withStyle(c0872pkA2.m4312a()), 80, "game.winning");
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public boolean mo5314a(@NotNull C1057tI<C0966rY, C1022sb> c1057tI) {
        return ((C1022sb) c1057tI.m5870c()).mo4260a(c1057tI.m5873a(), c1057tI.m5874m(), this.f5613b) != null;
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1056tH<C0966rY, C1022sb> mo5319a(@NotNull C0966rY c0966rY) {
        return new C1023sc();
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0871pj mo5316a() {
        return EnumC0871pj.GAME;
    }

    @Override // com.boehmod.blockfront.AbstractC1056tH
    /* JADX INFO: renamed from: a */
    public void mo5317a(@NotNull C1057tI<C0966rY, C1022sb> c1057tI, @NotNull EnumC0876po enumC0876po, @NotNull ServerPlayer serverPlayer) {
        if (enumC0876po == EnumC0876po.NEW) {
            C0966rY.m5320a((C0966rY) c1057tI.m5869c(), c1057tI.m5871b(), serverPlayer.getUUID(), true);
            C0875pn.m4362a(serverPlayer.getUUID(), C0502il.m2254a().m2256b(EnumC1203vw.START_GENERIC).m2259a(5));
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC1054tF
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0873pl mo5608a(@NotNull C0966rY c0966rY) {
        return this.f5613b;
    }
}
