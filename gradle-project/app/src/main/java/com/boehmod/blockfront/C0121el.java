package com.boehmod.blockfront;

import javax.annotation.Nonnull;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.sounds.SoundEvent;

/* JADX INFO: renamed from: com.boehmod.blockfront.el, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/el.class */
public class C0121el extends AbstractC0131ev {
    private float eb;
    private boolean bV;
    static final /* synthetic */ boolean bW;

    static {
        bW = !C0121el.class.desiredAssertionStatus();
    }

    public C0121el(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4, 0);
        this.eb = 0.0f;
        this.bV = false;
        aq();
    }

    private void aq() {
        oG<?, ?> oGVarM593a;
        C0297l c0297lB = C0297l.b();
        if (c0297lB != null && (oGVarM593a = c0297lB.m593a()) != null && oGVarM593a.bl()) {
            c(oGVarM593a.aJ());
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0131ev
    protected boolean G() {
        oG<?, ?> oGVarM593a;
        C0297l c0297lB = C0297l.b();
        return c0297lB == null || (oGVarM593a = c0297lB.m593a()) == null || !oGVarM593a.bl();
    }

    @Override // com.boehmod.blockfront.AbstractC0131ev
    public void onClick(double d, double d2, int i) {
        C0297l c0297lB = C0297l.b();
        if (c0297lB == null) {
            return;
        }
        oG<?, ?> oGVarM593a = c0297lB.m593a();
        if (oGVarM593a == null || !oGVarM593a.bl()) {
            super.onClick(d, d2, i);
        }
    }

    public void l(@Nonnull Minecraft minecraft) {
        float fT = t();
        if (this.eb != fT) {
            this.eb = fT;
            if (!this.bV) {
                this.bV = true;
            } else {
                a(fT, minecraft);
            }
        }
    }

    protected void a(float f, @Nonnull Minecraft minecraft) {
        minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pq.get(), 1.0f + (f / 5.0f), 1.0f));
    }

    @Override // com.boehmod.blockfront.AbstractC0131ev
    protected void b(float f) {
        oG<?, ?> oGVarM593a;
        oF<?, ?, ?> oFVarM591a;
        C0297l c0297lB = C0297l.b();
        if (!bW && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        if (c0297lB.m592d() || (oGVarM593a = c0297lB.m593a()) == null || oGVarM593a.bl() || (oFVarM591a = c0297lB.m591a()) == null) {
            return;
        }
        Minecraft minecraft = Minecraft.getInstance();
        String name = oFVarM591a.m751a().getName();
        String strM = oFVarM591a.M();
        LocalPlayer localPlayer = minecraft.player;
        oO oOVarA = localPlayer != null ? oFVarM591a.b().a(localPlayer.getUUID()) : null;
        C0582vo.c(new C0614wt(name, strM, oOVarA != null ? oOVarA.getName() : "", f));
        oGVarM593a.N(true);
        oGVarM593a.m(f);
    }
}
