package com.boehmod.blockfront;

import javax.annotation.Nonnull;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.sounds.SoundEvent;

/* JADX INFO: renamed from: com.boehmod.blockfront.ey */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ey.class */
public class C0303ey extends AbstractC0261eI {

    /* JADX INFO: renamed from: ee */
    private float f2359ee;

    /* JADX INFO: renamed from: cd */
    private boolean f2360cd;

    /* JADX INFO: renamed from: ce */
    static final /* synthetic */ boolean f2361ce;

    static {
        f2361ce = !C0303ey.class.desiredAssertionStatus();
    }

    public C0303ey(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4, 0);
        this.f2359ee = 0.0f;
        this.f2360cd = false;
        m1637av();
    }

    /* JADX INFO: renamed from: av */
    private void m1637av() {
        AbstractC0864pc<?, ?> abstractC0864pcM2878a;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b != null && (abstractC0864pcM2878a = c0623lM2852b.m2878a()) != null && abstractC0864pcM2878a.m4159bv()) {
            m1485c(abstractC0864pcM2878a.m4161aP());
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0261eI
    /* JADX INFO: renamed from: H */
    protected boolean mo1482H() {
        AbstractC0864pc<?, ?> abstractC0864pcM2878a;
        C0623l c0623lM2852b = C0623l.m2852b();
        return c0623lM2852b == null || (abstractC0864pcM2878a = c0623lM2852b.m2878a()) == null || !abstractC0864pcM2878a.m4159bv();
    }

    @Override // com.boehmod.blockfront.AbstractC0261eI
    public void onClick(double d, double d2, int i) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b == null) {
            return;
        }
        AbstractC0864pc<?, ?> abstractC0864pcM2878a = c0623lM2852b.m2878a();
        if (abstractC0864pcM2878a == null || !abstractC0864pcM2878a.m4159bv()) {
            super.onClick(d, d2, i);
        }
    }

    /* JADX INFO: renamed from: m */
    public void m1638m(@Nonnull Minecraft minecraft) {
        float fT = m1486t();
        if (this.f2359ee != fT) {
            this.f2359ee = fT;
            if (!this.f2360cd) {
                this.f2360cd = true;
            } else {
                m1639a(fT, minecraft);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m1639a(float f, @Nonnull Minecraft minecraft) {
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7971ps.get(), 1.0f + (f / 5.0f), 1.0f));
    }

    @Override // com.boehmod.blockfront.AbstractC0261eI
    /* JADX INFO: renamed from: b */
    protected void mo1481b(float f) {
        AbstractC0864pc<?, ?> abstractC0864pcM2878a;
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2361ce && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0623lM2852b.m2875d() || (abstractC0864pcM2878a = c0623lM2852b.m2878a()) == null || abstractC0864pcM2878a.m4159bv() || (abstractC0863pbM2874a = c0623lM2852b.m2874a()) == null) {
            return;
        }
        Minecraft minecraft = Minecraft.getInstance();
        String name = abstractC0863pbM2874a.m4027a().getName();
        String strM4030T = abstractC0863pbM2874a.m4030T();
        LocalPlayer localPlayer = minecraft.player;
        C0872pk c0872pkM4229a = localPlayer != null ? abstractC0863pbM2874a.m4018b().m4229a(localPlayer.getUUID()) : null;
        C1169vO.m6648c(new C1225wR(name, strM4030T, c0872pkM4229a != null ? c0872pkM4229a.getName() : "", f));
        abstractC0864pcM2878a.m4160O(true);
        abstractC0864pcM2878a.m4162l(f);
    }
}
