package com.boehmod.blockfront;

import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.un, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/un.class */
public class C0554un {

    @NotNull
    public static final String dk = "default";

    @NotNull
    public static final C0554un a = new C0554un(Component.translatable("bf.item.gun.barrel.type.default"));

    @NotNull
    private final Component jD;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private uR f308a = null;
    private boolean hL = true;

    public C0554un(@NotNull Component component) {
        this.jD = component;
    }

    @NotNull
    public Component getDisplayName() {
        return this.jD;
    }

    @NotNull
    public C0554un a(boolean z) {
        this.hL = z;
        return this;
    }

    public boolean cn() {
        return this.hL;
    }

    @NotNull
    public C0554un a(@Nullable uR uRVar) {
        this.f308a = uRVar;
        return this;
    }

    @Nullable
    public uR a() {
        return this.f308a;
    }
}
