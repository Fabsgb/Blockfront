package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ConnectionType;
import com.boehmod.bflib.cloud.packet.IPacket;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xu */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xu.class */
public final class C1298xu extends AbstractC0473iJ<C1300xw> {
    public C1298xu(@NotNull C1300xw c1300xw) {
        super(c1300xw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.AbstractC0473iJ
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0478iO<C1300xw> mo1732a(C1300xw c1300xw) {
        return new C0478iO<>(c1300xw);
    }

    @Override // com.boehmod.blockfront.AbstractC0473iJ
    public void sendPacket(@NotNull IPacket iPacket) {
        ((C1298xu) ((C1300xw) this.f2914b).m7961b()).mo1723a().sendPacket(iPacket);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.UUID] */
    @Override // com.boehmod.blockfront.InterfaceC0481iR
    @NotNull
    /* JADX INFO: renamed from: a */
    public UUID mo1723a() {
        return ((C1300xw) this.f2914b).m2543c();
    }

    @Override // com.boehmod.blockfront.InterfaceC0481iR
    @NotNull
    public String getUsername() {
        return "MM_Server";
    }

    @Override // com.boehmod.blockfront.InterfaceC0481iR
    public byte[] getHardwareId() {
        return C0480iQ.m2174a();
    }

    @Override // com.boehmod.blockfront.InterfaceC0481iR
    @NotNull
    /* JADX INFO: renamed from: a */
    public String mo1725a() {
        return ((C1300xw) this.f2914b).m7962a();
    }

    @Override // com.boehmod.blockfront.InterfaceC0481iR
    @NotNull
    /* JADX INFO: renamed from: b */
    public String mo1726b() {
        return ((C1300xw) this.f2914b).m7961b().m7928aG();
    }

    @Override // com.boehmod.blockfront.InterfaceC0481iR
    /* JADX INFO: renamed from: c */
    public int mo1727c() {
        return C0029a.f254a;
    }

    @Override // com.boehmod.blockfront.InterfaceC0481iR
    /* JADX INFO: renamed from: a */
    public boolean mo1730a() {
        return ((C1300xw) this.f2914b).mo2551f();
    }

    @Override // com.boehmod.blockfront.InterfaceC0481iR
    @NotNull
    public ConnectionType getType() {
        return ConnectionType.SERVER;
    }

    @Override // com.boehmod.blockfront.InterfaceC0481iR
    /* JADX INFO: renamed from: b */
    public int mo1724b() {
        MinecraftServer minecraftServerM2514a = C0561js.m2514a();
        if (minecraftServerM2514a == null) {
            return -1;
        }
        return minecraftServerM2514a.getPort();
    }

    @Override // com.boehmod.blockfront.InterfaceC0481iR
    @NotNull
    public String getVersion() {
        return C0029a.f248c;
    }

    @Override // com.boehmod.blockfront.InterfaceC0481iR
    @NotNull
    public String getVersionHash() {
        return "";
    }
}
