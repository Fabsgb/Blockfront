package com.boehmod.blockfront;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ge */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ge.class */
public class C0389ge {

    /* JADX INFO: renamed from: b */
    private static C0389ge f2538b;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0385ga f2539a = new C0385ga();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0392gh f2540a = new C0392gh();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0390gf f2541a = new C0390gf();

    private C0389ge() {
    }

    /* JADX INFO: renamed from: b */
    public static C0389ge m1838b() {
        if (f2538b == null) {
            f2538b = new C0389ge();
        }
        return f2538b;
    }

    /* JADX INFO: renamed from: a */
    public void m1839a(@NotNull InterfaceC0388gd interfaceC0388gd) {
        this.f2539a.m1687a(interfaceC0388gd);
    }

    /* JADX INFO: renamed from: a */
    public void m1840a(@NotNull InterfaceC0328fW interfaceC0328fW) {
        this.f2540a.m1687a(interfaceC0328fW);
    }

    /* JADX INFO: renamed from: a */
    public void m1841a(@NotNull InterfaceC0319fN interfaceC0319fN) {
        this.f2541a.m1687a(interfaceC0319fN);
    }

    public void onUpdate() {
        this.f2539a.tick();
        this.f2540a.tick();
        this.f2541a.tick();
    }

    /* JADX INFO: renamed from: a */
    public void m1842a(@NotNull Minecraft minecraft, @NotNull GameRenderer gameRenderer, @NotNull Camera camera, float f) {
        this.f2539a.m1682a(minecraft, gameRenderer, camera, f);
        this.f2540a.m1682a(minecraft, gameRenderer, camera, f);
        this.f2541a.m1682a(minecraft, gameRenderer, camera, f);
    }

    /* JADX INFO: renamed from: aK */
    public void m1843aK() {
        this.f2539a.m1688aK();
        this.f2540a.m1688aK();
        this.f2541a.m1688aK();
    }

    /* JADX INFO: renamed from: aq */
    public int m1844aq() {
        return this.f2539a.m1689aq() + this.f2540a.m1689aq() + this.f2541a.m1689aq();
    }

    /* JADX INFO: renamed from: aM */
    public void m1845aM() {
        this.f2539a.m1690aL();
        this.f2540a.m1690aL();
        this.f2541a.m1690aL();
    }
}
