package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.connection.ConnectionStatus;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.blockfront.AbstractC0563ju;
import com.boehmod.blockfront.cloud.connection.ModConnection;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iJ.class */
public abstract class AbstractC0473iJ<M extends AbstractC0563ju<?, ?, ?>> implements InterfaceC0481iR {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ModConnection f2912a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0478iO<M> f2913a;

    /* JADX INFO: renamed from: b */
    @NotNull
    protected final M f2914b;

    @NotNull
    /* JADX INFO: renamed from: a */
    protected abstract C0478iO<M> mo1732a(M m);

    public abstract void sendPacket(@NotNull IPacket iPacket);

    public AbstractC0473iJ(@NotNull M m) {
        this.f2914b = m;
        this.f2913a = mo1732a(m);
        this.f2912a = new ModConnection(this, m);
    }

    @OverridingMethodsMustInvokeSuper
    public void onUpdate() {
        this.f2912a.onUpdateCore();
        if (this.f2912a.getStatus().isVerified()) {
            this.f2913a.onUpdate();
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public ModConnection m2144a() {
        return this.f2912a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0478iO<M> m2145a() {
        return this.f2913a;
    }

    /* JADX INFO: renamed from: aU */
    public void m2146aU() {
        disconnect("Shutting down.", true);
        this.f2912a.shutdown();
    }

    public void disconnect(@NotNull String str, boolean z) {
        this.f2912a.disconnect(str, z);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public ConnectionStatus m2147a() {
        return this.f2912a.getStatus();
    }

    @Override // com.boehmod.blockfront.InterfaceC0481iR
    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo1729a(@NotNull String str) {
        C0562jt.log("Disconnected from Cloud. (%s)", str);
    }
}
