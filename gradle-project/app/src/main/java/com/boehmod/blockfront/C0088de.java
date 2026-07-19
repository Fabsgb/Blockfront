package com.boehmod.blockfront;

import java.util.function.Consumer;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.de, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/de.class */
public final class C0088de {

    @NotNull
    private final Component dT;
    private final Button.OnPress c;

    @Nullable
    private Component D = null;
    private int cv = -1;
    private int cJ = -1;
    private int cH = -1;

    @Nullable
    private Consumer<C0048bs> b = null;

    public C0088de(@NotNull Component component, @NotNull Button.OnPress onPress) {
        this.dT = component;
        this.c = onPress;
    }

    public C0088de a(@NotNull Consumer<C0048bs> consumer) {
        this.b = consumer;
        return this;
    }

    @NotNull
    public C0088de a(int i) {
        this.cH = i;
        return this;
    }

    @NotNull
    public C0088de a(@Nullable Component component) {
        this.D = component;
        return this;
    }

    @NotNull
    public C0088de a(int i, int i2) {
        this.cv = i;
        this.cJ = i2;
        return this;
    }

    @Nullable
    public Consumer<C0048bs> a() {
        return this.b;
    }

    @NotNull
    public Component c() {
        return this.dT;
    }

    @Nullable
    public Component j() {
        return this.D;
    }

    public int H() {
        return this.cv;
    }

    public int I() {
        return this.cJ;
    }

    public int J() {
        return this.cH;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Button.OnPress m346a() {
        return this.c;
    }
}
