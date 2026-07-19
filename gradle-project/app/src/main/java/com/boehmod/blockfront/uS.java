package com.boehmod.blockfront;

import java.util.function.Supplier;
import net.minecraft.world.entity.EntityType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/uS.class */
public final class uS {

    @Nullable
    Supplier<EntityType<? extends InterfaceC0347mw>> x;
    private final uU a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final uT f306a;
    private final int ss;
    private final int st;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private uV f307a;

    public uS(@NotNull uT uTVar, int i) {
        this(uTVar, i, 1);
    }

    public uS(@NotNull uT uTVar, int i, int i2) {
        this.x = null;
        this.f307a = null;
        this.f306a = uTVar;
        this.ss = i;
        this.a = uU.BULLET;
        this.st = i2;
    }

    public uS(@NotNull uT uTVar, int i, @Nullable Supplier<EntityType<? extends InterfaceC0347mw>> supplier) {
        this.x = null;
        this.f307a = null;
        this.f306a = uTVar;
        this.ss = i;
        this.x = supplier;
        this.st = 1;
        this.a = uU.ENTITY;
    }

    @NotNull
    public uT a() {
        return this.f306a;
    }

    public int cg() {
        return this.ss;
    }

    @Nullable
    public Supplier<EntityType<? extends InterfaceC0347mw>> b() {
        return this.x;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public uU m1177a() {
        return this.a;
    }

    public int ch() {
        return this.st;
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public uV m1178a() {
        return this.f307a;
    }

    @NotNull
    public uS a(@Nullable uV uVVar) {
        this.f307a = uVVar;
        return this;
    }
}
