package com.boehmod.blockfront;

import java.util.function.Consumer;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.dn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dn.class */
public final class C0239dn {

    /* JADX INFO: renamed from: dV */
    @NotNull
    private final Component f1930dV;

    /* JADX INFO: renamed from: c */
    private final Button.OnPress f1931c;

    /* JADX INFO: renamed from: D */
    @Nullable
    private Component f1932D = null;

    /* JADX INFO: renamed from: dn */
    private int f1933dn = -1;

    /* JADX INFO: renamed from: dB */
    private int f1934dB = -1;

    /* JADX INFO: renamed from: dz */
    private int f1935dz = -1;

    /* JADX INFO: renamed from: b */
    @Nullable
    private Consumer<C0085bB> f1936b = null;

    public C0239dn(@NotNull Component component, @NotNull Button.OnPress onPress) {
        this.f1930dV = component;
        this.f1931c = onPress;
    }

    /* JADX INFO: renamed from: a */
    public C0239dn m1365a(@NotNull Consumer<C0085bB> consumer) {
        this.f1936b = consumer;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0239dn m1366a(int i) {
        this.f1935dz = i;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0239dn m1367a(@Nullable Component component) {
        this.f1932D = component;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0239dn m1368a(int i, int i2) {
        this.f1933dn = i;
        this.f1934dB = i2;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public Consumer<C0085bB> m1369a() {
        return this.f1936b;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public Component m1370c() {
        return this.f1930dV;
    }

    @Nullable
    /* JADX INFO: renamed from: j */
    public Component m1371j() {
        return this.f1932D;
    }

    /* JADX INFO: renamed from: L */
    public int m1372L() {
        return this.f1933dn;
    }

    /* JADX INFO: renamed from: M */
    public int m1373M() {
        return this.f1934dB;
    }

    /* JADX INFO: renamed from: N */
    public int m1374N() {
        return this.f1935dz;
    }

    /* JADX INFO: renamed from: a */
    public Button.OnPress m1375a() {
        return this.f1931c;
    }
}
