package com.boehmod.blockfront;

import javax.annotation.Nonnull;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.sounds.SoundEvent;

/* JADX INFO: renamed from: com.boehmod.blockfront.el */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/el.class */
public class C0289el extends AbstractC0299ev {

    /* JADX INFO: renamed from: eb */
    private float f2186eb;

    /* JADX INFO: renamed from: bV */
    private boolean f2187bV;

    /* JADX INFO: renamed from: bW */
    static final /* synthetic */ boolean f2188bW;

    static {
        f2188bW = !C0289el.class.desiredAssertionStatus();
    }

    public C0289el(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4, 0);
        this.f2186eb = 0.0f;
        this.f2187bV = false;
        m1525aq();
    }

    /* JADX INFO: renamed from: aq */
    private void m1525aq() {
        AbstractC0788oG<?, ?> abstractC0788oGM2692a;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b != null && (abstractC0788oGM2692a = c0622lM2667b.m2692a()) != null && abstractC0788oGM2692a.m3723bl()) {
            m1581c(abstractC0788oGM2692a.m3725aJ());
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0299ev
    /* JADX INFO: renamed from: G */
    protected boolean mo1526G() {
        AbstractC0788oG<?, ?> abstractC0788oGM2692a;
        C0622l c0622lM2667b = C0622l.m2667b();
        return c0622lM2667b == null || (abstractC0788oGM2692a = c0622lM2667b.m2692a()) == null || !abstractC0788oGM2692a.m3723bl();
    }

    @Override // com.boehmod.blockfront.AbstractC0299ev
    public void onClick(double d, double d2, int i) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b == null) {
            return;
        }
        AbstractC0788oG<?, ?> abstractC0788oGM2692a = c0622lM2667b.m2692a();
        if (abstractC0788oGM2692a == null || !abstractC0788oGM2692a.m3723bl()) {
            super.onClick(d, d2, i);
        }
    }

    /* JADX INFO: renamed from: l */
    public void m1527l(@Nonnull Minecraft minecraft) {
        float fT = m1582t();
        if (this.f2186eb != fT) {
            this.f2186eb = fT;
            if (!this.f2187bV) {
                this.f2187bV = true;
            } else {
                m1528a(fT, minecraft);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m1528a(float f, @Nonnull Minecraft minecraft) {
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7559pq.get(), 1.0f + (f / 5.0f), 1.0f));
    }

    @Override // com.boehmod.blockfront.AbstractC0299ev
    /* JADX INFO: renamed from: b */
    protected void mo1529b(float f) {
        AbstractC0788oG<?, ?> abstractC0788oGM2692a;
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2188bW && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0622lM2667b.m2689d() || (abstractC0788oGM2692a = c0622lM2667b.m2692a()) == null || abstractC0788oGM2692a.m3723bl() || (abstractC0787oFM2688a = c0622lM2667b.m2688a()) == null) {
            return;
        }
        Minecraft minecraft = Minecraft.getInstance();
        String name = abstractC0787oFM2688a.m3591a().getName();
        String strM3594M = abstractC0787oFM2688a.m3594M();
        LocalPlayer localPlayer = minecraft.player;
        C0796oO c0796oOM3793a = localPlayer != null ? abstractC0787oFM2688a.m3582b().m3793a(localPlayer.getUUID()) : null;
        C1194vo.m6653c(new C1252wt(name, strM3594M, c0796oOM3793a != null ? c0796oOM3793a.getName() : "", f));
        abstractC0788oGM2692a.m3724N(true);
        abstractC0788oGM2692a.m3726m(f);
    }
}
