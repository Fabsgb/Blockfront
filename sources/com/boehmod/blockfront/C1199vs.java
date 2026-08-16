package com.boehmod.blockfront;

import java.util.function.Supplier;
import net.minecraft.world.entity.EntityType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.vs */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/vs.class */
public final class C1199vs {

    /* JADX INFO: renamed from: x */
    @Nullable
    Supplier<EntityType<? extends InterfaceC0695mS>> f6552x;

    /* JADX INFO: renamed from: a */
    private final EnumC1201vu f6553a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final EnumC1200vt f6554a;

    /* JADX INFO: renamed from: uw */
    private final int f6555uw;

    /* JADX INFO: renamed from: ux */
    private final int f6556ux;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C1202vv f6557a;

    public C1199vs(@NotNull EnumC1200vt enumC1200vt, int i) {
        this(enumC1200vt, i, 1);
    }

    public C1199vs(@NotNull EnumC1200vt enumC1200vt, int i, int i2) {
        this.f6552x = null;
        this.f6557a = null;
        this.f6554a = enumC1200vt;
        this.f6555uw = i;
        this.f6553a = EnumC1201vu.BULLET;
        this.f6556ux = i2;
    }

    public C1199vs(@NotNull EnumC1200vt enumC1200vt, int i, @Nullable Supplier<EntityType<? extends InterfaceC0695mS>> supplier) {
        this.f6552x = null;
        this.f6557a = null;
        this.f6554a = enumC1200vt;
        this.f6555uw = i;
        this.f6552x = supplier;
        this.f6556ux = 1;
        this.f6553a = EnumC1201vu.ENTITY;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC1200vt m6874a() {
        return this.f6554a;
    }

    /* JADX INFO: renamed from: cw */
    public int m6875cw() {
        return this.f6555uw;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public Supplier<EntityType<? extends InterfaceC0695mS>> m6876b() {
        return this.f6552x;
    }

    /* JADX INFO: renamed from: a */
    public EnumC1201vu m6877a() {
        return this.f6553a;
    }

    /* JADX INFO: renamed from: cx */
    public int m6878cx() {
        return this.f6556ux;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C1202vv m6879a() {
        return this.f6557a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1199vs m6880a(@Nullable C1202vv c1202vv) {
        this.f6557a = c1202vv;
        return this;
    }
}
