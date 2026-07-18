package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.un */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/un.class */
public class C1140un {

    /* JADX INFO: renamed from: dk */
    @NotNull
    public static final String f5957dk = "default";

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final C1140un f5958a = new C1140un(Component.translatable("bf.item.gun.barrel.type.default"));

    /* JADX INFO: renamed from: jD */
    @NotNull
    private final Component f5960jD;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C1118uR f5959a = null;

    /* JADX INFO: renamed from: hL */
    private boolean f5961hL = true;

    public C1140un(@NotNull Component component) {
        this.f5960jD = component;
    }

    @NotNull
    public Component getDisplayName() {
        return this.f5960jD;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1140un m6273a(boolean z) {
        this.f5961hL = z;
        return this;
    }

    /* JADX INFO: renamed from: cn */
    public boolean m6274cn() {
        return this.f5961hL;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1140un m6275a(@Nullable C1118uR c1118uR) {
        this.f5959a = c1118uR;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C1118uR m6276a() {
        return this.f5959a;
    }
}
