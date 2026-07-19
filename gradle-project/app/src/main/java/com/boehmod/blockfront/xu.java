package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ConnectionType;
import com.boehmod.bflib.cloud.packet.IPacket;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xu.class */
public final class xu extends iJ<xw> {
    public xu(@NotNull xw xwVar) {
        super(xwVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.boehmod.blockfront.iJ
    @NotNull
    public iO<xw> a(xw xwVar) {
        return new iO<>(xwVar);
    }

    @Override // com.boehmod.blockfront.iJ
    public void sendPacket(@NotNull IPacket iPacket) {
        ((xu) ((xw) this.b).b()).mo409a().sendPacket(iPacket);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.UUID] */
    @Override // com.boehmod.blockfront.iR
    @NotNull
    /* JADX INFO: renamed from: a */
    public UUID mo409a() {
        return ((xw) this.b).c();
    }

    @Override // com.boehmod.blockfront.iR
    @NotNull
    public String getUsername() {
        return "MM_Server";
    }

    @Override // com.boehmod.blockfront.iR
    public byte[] getHardwareId() {
        return iQ.a();
    }

    @Override // com.boehmod.blockfront.iR
    @NotNull
    /* JADX INFO: renamed from: a */
    public String mo410a() {
        return ((xw) this.b).m1711a();
    }

    @Override // com.boehmod.blockfront.iR
    @NotNull
    /* JADX INFO: renamed from: b */
    public String mo411b() {
        return ((xw) this.b).b().aG();
    }

    @Override // com.boehmod.blockfront.iR
    public int c() {
        return C0002a.f32a;
    }

    @Override // com.boehmod.blockfront.iR
    /* JADX INFO: renamed from: a */
    public boolean mo412a() {
        return ((xw) this.b).f();
    }

    @Override // com.boehmod.blockfront.iR
    @NotNull
    public ConnectionType getType() {
        return ConnectionType.SERVER;
    }

    @Override // com.boehmod.blockfront.iR
    public int b() {
        MinecraftServer minecraftServerA = C0262js.a();
        if (minecraftServerA == null) {
            return -1;
        }
        return minecraftServerA.getPort();
    }

    @Override // com.boehmod.blockfront.iR
    @NotNull
    public String getVersion() {
        return C0002a.c;
    }

    @Override // com.boehmod.blockfront.iR
    @NotNull
    public String getVersionHash() {
        return "";
    }
}
