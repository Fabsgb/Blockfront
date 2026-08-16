package com.boehmod.blockfront;

import java.util.Locale;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.D */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/D.class */
public final class C0007D implements InterfaceC0009F<C0994s> {

    /* JADX INFO: renamed from: ak */
    private static final int f139ak = 375;

    /* JADX INFO: renamed from: d */
    private static final long f140d = 1200;

    /* JADX INFO: renamed from: al */
    private static final int f141al = 100;

    /* JADX INFO: renamed from: ab */
    private int f142ab = 0;

    @Override // com.boehmod.blockfront.InterfaceC0009F
    @Nullable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String mo14a(@NotNull Minecraft minecraft, @NotNull C0994s c0994s) {
        int i = this.f142ab;
        this.f142ab = i - 1;
        if (i > 0) {
            return null;
        }
        this.f142ab = f139ak;
        C1154v.b bVarM6583a = C1154v.m6583a();
        if (bVarM6583a.m6584a() < f140d || bVarM6583a.m6585h() < 100) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 : bVarM6583a.m6589a()) {
            if (!sb.isEmpty()) {
                sb.append('/');
            }
            sb.append(i2);
        }
        return String.format(Locale.ROOT, "n=%d m=%d run=%d med=%.2f max=%.2f skip=%s", Long.valueOf(bVarM6583a.m6584a()), Integer.valueOf(bVarM6583a.m6585h()), Integer.valueOf(bVarM6583a.m6586i()), Double.valueOf(bVarM6583a.m6587a()), Double.valueOf(bVarM6583a.m6588b()), sb);
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0994s.a mo11a() {
        return C0994s.a.RUNTIME;
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    /* JADX INFO: renamed from: g */
    public int mo12g() {
        return 9;
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0994s.b mo13a() {
        return C0994s.b.SILENT;
    }
}
