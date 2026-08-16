package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import net.minecraft.network.RegistryFriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mI.class */
public class C0685mI {

    /* JADX INFO: renamed from: eL */
    private boolean f3777eL = false;

    /* JADX INFO: renamed from: B */
    public void m3080B(boolean z) {
        this.f3777eL = z;
    }

    /* JADX INFO: renamed from: aK */
    public boolean m3081aK() {
        return this.f3777eL;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0685mI m3082a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        try {
            C0685mI c0685mI = new C0685mI();
            c0685mI.m3085b(registryFriendlyByteBuf);
            return c0685mI;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3083b(@NotNull ByteBuf byteBuf) throws IOException {
        this.f3777eL = IPacket.readBoolean(byteBuf);
    }

    /* JADX INFO: renamed from: c */
    public void m3084c(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeBoolean(byteBuf, this.f3777eL);
    }

    /* JADX INFO: renamed from: b */
    public void m3085b(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) throws IOException {
        this.f3777eL = registryFriendlyByteBuf.readBoolean();
    }

    /* JADX INFO: renamed from: a */
    public void m3086a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) throws IOException {
        registryFriendlyByteBuf.writeBoolean(this.f3777eL);
    }
}
