package com.boehmod.blockfront;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.fO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/fO.class */
public class C0319fO {

    /* JADX INFO: renamed from: b */
    private static C0319fO f2343b;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0315fK f2344a = new C0315fK();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0322fR f2345a = new C0322fR();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0320fP f2346a = new C0320fP();

    private C0319fO() {
    }

    /* JADX INFO: renamed from: b */
    public static C0319fO m1628b() {
        if (f2343b == null) {
            f2343b = new C0319fO();
        }
        return f2343b;
    }

    /* JADX INFO: renamed from: a */
    public void m1629a(@NotNull InterfaceC0318fN interfaceC0318fN) {
        this.f2344a.m1617a(interfaceC0318fN);
    }

    /* JADX INFO: renamed from: a */
    public void m1630a(@NotNull InterfaceC0311fG interfaceC0311fG) {
        this.f2345a.m1617a(interfaceC0311fG);
    }

    /* JADX INFO: renamed from: a */
    public void m1631a(@NotNull InterfaceC0354fx interfaceC0354fx) {
        this.f2346a.m1617a(interfaceC0354fx);
    }

    public void onUpdate() {
        this.f2344a.tick();
        this.f2345a.tick();
        this.f2346a.tick();
    }

    /* JADX INFO: renamed from: a */
    public void m1632a(@NotNull Minecraft minecraft, @NotNull GameRenderer gameRenderer, @NotNull Camera camera, float f) {
        this.f2344a.m1612a(minecraft, gameRenderer, camera, f);
        this.f2345a.m1612a(minecraft, gameRenderer, camera, f);
        this.f2346a.m1612a(minecraft, gameRenderer, camera, f);
    }

    /* JADX INFO: renamed from: aE */
    public void m1633aE() {
        this.f2344a.m1618aE();
        this.f2345a.m1618aE();
        this.f2346a.m1618aE();
    }

    /* JADX INFO: renamed from: ae */
    public int m1634ae() {
        return this.f2344a.m1619ae() + this.f2345a.m1619ae() + this.f2346a.m1619ae();
    }

    /* JADX INFO: renamed from: aG */
    public void m1635aG() {
        this.f2344a.m1620aF();
        this.f2345a.m1620aF();
        this.f2346a.m1620aF();
    }
}
