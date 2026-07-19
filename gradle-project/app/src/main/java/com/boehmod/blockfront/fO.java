package com.boehmod.blockfront;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fO.class */
public class fO {
    private static fO b;

    @NotNull
    private final fK a = new fK();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final fR f124a = new fR();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final fP f125a = new fP();

    private fO() {
    }

    public static fO b() {
        if (b == null) {
            b = new fO();
        }
        return b;
    }

    public void a(@NotNull fN fNVar) {
        this.a.a(fNVar);
    }

    public void a(@NotNull fG fGVar) {
        this.f124a.a(fGVar);
    }

    public void a(@NotNull InterfaceC0160fx interfaceC0160fx) {
        this.f125a.a(interfaceC0160fx);
    }

    public void onUpdate() {
        this.a.tick();
        this.f124a.tick();
        this.f125a.tick();
    }

    public void a(@NotNull Minecraft minecraft, @NotNull GameRenderer gameRenderer, @NotNull Camera camera, float f) {
        this.a.a(minecraft, gameRenderer, camera, f);
        this.f124a.a(minecraft, gameRenderer, camera, f);
        this.f125a.a(minecraft, gameRenderer, camera, f);
    }

    public void aE() {
        this.a.aE();
        this.f124a.aE();
        this.f125a.aE();
    }

    public int ae() {
        return this.a.ae() + this.f124a.ae() + this.f125a.ae();
    }

    public void aG() {
        this.a.aF();
        this.f124a.aF();
        this.f125a.aF();
    }
}
