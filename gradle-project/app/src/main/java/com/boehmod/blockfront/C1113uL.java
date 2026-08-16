package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.uL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uL.class */
public class C1113uL {

    /* JADX INFO: renamed from: dv */
    @NotNull
    public static final String f6023dv = "default";

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final C1113uL f6024a = new C1113uL(Component.translatable("bf.item.gun.barrel.type.default"));

    /* JADX INFO: renamed from: jQ */
    @NotNull
    private final Component f6026jQ;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C1198vr f6025a = null;

    /* JADX INFO: renamed from: if */
    private boolean f6027if = true;

    public C1113uL(@NotNull Component component) {
        this.f6026jQ = component;
    }

    @NotNull
    public Component getDisplayName() {
        return this.f6026jQ;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1113uL m6237a(boolean z) {
        this.f6027if = z;
        return this;
    }

    /* JADX INFO: renamed from: cx */
    public boolean m6238cx() {
        return this.f6027if;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1113uL m6239a(@Nullable C1198vr c1198vr) {
        this.f6025a = c1198vr;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C1198vr m6240a() {
        return this.f6025a;
    }
}
