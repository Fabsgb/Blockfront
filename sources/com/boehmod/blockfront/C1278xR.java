package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ConnectionType;
import com.boehmod.bflib.cloud.packet.IPacket;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xR.class */
public final class C1278xR extends AbstractC0546jc<C1280xT> {
    public C1278xR(@NotNull C1280xT c1280xT) {
        super(c1280xT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0546jc
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0551jh<C1280xT> mo1738a(C1280xT c1280xT) {
        return new C0551jh<>(c1280xT);
    }

    @Override // com.boehmod.blockfront.AbstractC0546jc
    public void sendPacket(@NotNull IPacket iPacket) {
        ((C1278xR) ((C1280xT) this.f3263b).m7289b()).mo1729a().sendPacket(iPacket);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.UUID] */
    @Override // com.boehmod.blockfront.InterfaceC0554jk
    @NotNull
    /* JADX INFO: renamed from: a */
    public UUID mo1729a() {
        return ((C1280xT) this.f3263b).m2366c();
    }

    @Override // com.boehmod.blockfront.InterfaceC0554jk
    @NotNull
    public String getUsername() {
        return "MM_Server";
    }

    @Override // com.boehmod.blockfront.InterfaceC0554jk
    public byte[] getHardwareId() {
        return C0553jj.m2501a();
    }

    @Override // com.boehmod.blockfront.InterfaceC0554jk
    @NotNull
    /* JADX INFO: renamed from: a */
    public String mo1731a() {
        return ((C1280xT) this.f3263b).m7290a();
    }

    @Override // com.boehmod.blockfront.InterfaceC0554jk
    @NotNull
    /* JADX INFO: renamed from: b */
    public String mo1732b() {
        return ((C1280xT) this.f3263b).m7289b().m7255aN();
    }

    @Override // com.boehmod.blockfront.InterfaceC0554jk
    /* JADX INFO: renamed from: c */
    public int mo1733c() {
        return C0030a.f271a;
    }

    @Override // com.boehmod.blockfront.InterfaceC0554jk
    /* JADX INFO: renamed from: a */
    public boolean mo1736a() {
        return ((C1280xT) this.f3263b).mo2374f();
    }

    @Override // com.boehmod.blockfront.InterfaceC0554jk
    @NotNull
    public ConnectionType getType() {
        return ConnectionType.SERVER;
    }

    @Override // com.boehmod.blockfront.InterfaceC0554jk
    /* JADX INFO: renamed from: b */
    public int mo1730b() {
        MinecraftServer minecraftServerM2335a = C0529jL.m2335a();
        if (minecraftServerM2335a == null) {
            return -1;
        }
        return minecraftServerM2335a.getPort();
    }

    @Override // com.boehmod.blockfront.InterfaceC0554jk
    @NotNull
    public String getVersion() {
        return C0030a.f265c;
    }

    @Override // com.boehmod.blockfront.InterfaceC0554jk
    @NotNull
    public String getVersionHash() {
        return "";
    }
}
