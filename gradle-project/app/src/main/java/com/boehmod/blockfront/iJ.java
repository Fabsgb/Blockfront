package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.connection.ConnectionStatus;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.blockfront.AbstractC0264ju;
import com.boehmod.blockfront.cloud.connection.ModConnection;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iJ.class */
public abstract class iJ<M extends AbstractC0264ju<?, ?, ?>> implements iR {

    @NotNull
    private final ModConnection a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final iO<M> f169a;

    @NotNull
    protected final M b;

    @NotNull
    protected abstract iO<M> a(M m);

    public abstract void sendPacket(@NotNull IPacket iPacket);

    public iJ(@NotNull M m) {
        this.b = m;
        this.f169a = a(m);
        this.a = new ModConnection(this, m);
    }

    @OverridingMethodsMustInvokeSuper
    public void onUpdate() {
        this.a.onUpdateCore();
        if (this.a.getStatus().isVerified()) {
            this.f169a.onUpdate();
        }
    }

    @NotNull
    public ModConnection a() {
        return this.a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public iO<M> m484a() {
        return this.f169a;
    }

    public void aU() {
        disconnect("Shutting down.", true);
        this.a.shutdown();
    }

    public void disconnect(@NotNull String str, boolean z) {
        this.a.disconnect(str, z);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ConnectionStatus m485a() {
        return this.a.getStatus();
    }

    @Override // com.boehmod.blockfront.iR
    @OverridingMethodsMustInvokeSuper
    public void a(@NotNull String str) {
        C0263jt.log("Disconnected from Cloud. (%s)", str);
    }
}
