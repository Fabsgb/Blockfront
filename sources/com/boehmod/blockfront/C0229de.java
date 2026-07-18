package com.boehmod.blockfront;

import java.util.function.Consumer;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.de */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/de.class */
public final class C0229de {

    /* JADX INFO: renamed from: dT */
    @NotNull
    private final Component f1870dT;

    /* JADX INFO: renamed from: c */
    private final Button.OnPress f1871c;

    /* JADX INFO: renamed from: D */
    @Nullable
    private Component f1872D = null;

    /* JADX INFO: renamed from: cv */
    private int f1873cv = -1;

    /* JADX INFO: renamed from: cJ */
    private int f1874cJ = -1;

    /* JADX INFO: renamed from: cH */
    private int f1875cH = -1;

    /* JADX INFO: renamed from: b */
    @Nullable
    private Consumer<C0127bs> f1876b = null;

    public C0229de(@NotNull Component component, @NotNull Button.OnPress onPress) {
        this.f1870dT = component;
        this.f1871c = onPress;
    }

    /* JADX INFO: renamed from: a */
    public C0229de m1339a(@NotNull Consumer<C0127bs> consumer) {
        this.f1876b = consumer;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0229de m1340a(int i) {
        this.f1875cH = i;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0229de m1341a(@Nullable Component component) {
        this.f1872D = component;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0229de m1342a(int i, int i2) {
        this.f1873cv = i;
        this.f1874cJ = i2;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public Consumer<C0127bs> m1343a() {
        return this.f1876b;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public Component m1344c() {
        return this.f1870dT;
    }

    @Nullable
    /* JADX INFO: renamed from: j */
    public Component m1345j() {
        return this.f1872D;
    }

    /* JADX INFO: renamed from: H */
    public int m1346H() {
        return this.f1873cv;
    }

    /* JADX INFO: renamed from: I */
    public int m1347I() {
        return this.f1874cJ;
    }

    /* JADX INFO: renamed from: J */
    public int m1348J() {
        return this.f1875cH;
    }

    /* JADX INFO: renamed from: a */
    public Button.OnPress m1349a() {
        return this.f1871c;
    }
}
