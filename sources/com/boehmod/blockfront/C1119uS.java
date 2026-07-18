package com.boehmod.blockfront;

import java.util.function.Supplier;
import net.minecraft.world.entity.EntityType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.uS */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uS.class */
public final class C1119uS {

    /* JADX INFO: renamed from: x */
    @Nullable
    Supplier<EntityType<? extends InterfaceC0724mw>> f5913x;

    /* JADX INFO: renamed from: a */
    private final EnumC1121uU f5914a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final EnumC1120uT f5915a;

    /* JADX INFO: renamed from: ss */
    private final int f5916ss;

    /* JADX INFO: renamed from: st */
    private final int f5917st;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C1122uV f5918a;

    public C1119uS(@NotNull EnumC1120uT enumC1120uT, int i) {
        this(enumC1120uT, i, 1);
    }

    public C1119uS(@NotNull EnumC1120uT enumC1120uT, int i, int i2) {
        this.f5913x = null;
        this.f5918a = null;
        this.f5915a = enumC1120uT;
        this.f5916ss = i;
        this.f5914a = EnumC1121uU.BULLET;
        this.f5917st = i2;
    }

    public C1119uS(@NotNull EnumC1120uT enumC1120uT, int i, @Nullable Supplier<EntityType<? extends InterfaceC0724mw>> supplier) {
        this.f5913x = null;
        this.f5918a = null;
        this.f5915a = enumC1120uT;
        this.f5916ss = i;
        this.f5913x = supplier;
        this.f5917st = 1;
        this.f5914a = EnumC1121uU.ENTITY;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC1120uT m6221a() {
        return this.f5915a;
    }

    /* JADX INFO: renamed from: cg */
    public int m6222cg() {
        return this.f5916ss;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public Supplier<EntityType<? extends InterfaceC0724mw>> m6223b() {
        return this.f5913x;
    }

    /* JADX INFO: renamed from: a */
    public EnumC1121uU m6224a() {
        return this.f5914a;
    }

    /* JADX INFO: renamed from: ch */
    public int m6225ch() {
        return this.f5917st;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C1122uV m6226a() {
        return this.f5918a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1119uS m6227a(@Nullable C1122uV c1122uV) {
        this.f5918a = c1122uV;
        return this;
    }
}
