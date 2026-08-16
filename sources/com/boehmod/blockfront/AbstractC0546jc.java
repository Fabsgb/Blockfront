package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.connection.ConnectionStatus;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.blockfront.AbstractC0531jN;
import com.boehmod.blockfront.cloud.connection.ModConnection;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jc.class */
public abstract class AbstractC0546jc<M extends AbstractC0531jN<?, ?, ?>> implements InterfaceC0554jk {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ModConnection f3261a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0551jh<M> f3262a;

    /* JADX INFO: renamed from: b */
    @NotNull
    protected final M f3263b;

    @NotNull
    /* JADX INFO: renamed from: a */
    protected abstract C0551jh<M> mo1738a(M m);

    public abstract void sendPacket(@NotNull IPacket iPacket);

    public AbstractC0546jc(@NotNull M m) {
        this.f3263b = m;
        this.f3262a = mo1738a(m);
        this.f3261a = new ModConnection(this, m);
    }

    @OverridingMethodsMustInvokeSuper
    public void onUpdate() {
        this.f3261a.onUpdateCore();
        if (this.f3261a.getStatus().isVerified()) {
            this.f3262a.onUpdate();
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public ModConnection m2471a() {
        return this.f3261a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0551jh<M> m2472a() {
        return this.f3262a;
    }

    /* JADX INFO: renamed from: bg */
    public void m2473bg() {
        disconnect("Shutting down.", true);
        this.f3261a.shutdown();
    }

    public void disconnect(@NotNull String str, boolean z) {
        this.f3261a.disconnect(str, z);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public ConnectionStatus m2474a() {
        return this.f3261a.getStatus();
    }

    @Override // com.boehmod.blockfront.InterfaceC0554jk
    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo1735a(@NotNull String str) {
        C0530jM.log("Disconnected from Cloud. (%s)", str);
    }
}
