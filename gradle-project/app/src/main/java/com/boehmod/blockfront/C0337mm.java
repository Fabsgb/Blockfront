package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import net.minecraft.network.RegistryFriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mm.class */
public class C0337mm {
    private boolean er = false;

    public void B(boolean z) {
        this.er = z;
    }

    public boolean az() {
        return this.er;
    }

    @NotNull
    public static C0337mm a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        try {
            C0337mm c0337mm = new C0337mm();
            c0337mm.b(registryFriendlyByteBuf);
            return c0337mm;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void b(@NotNull ByteBuf byteBuf) throws IOException {
        this.er = IPacket.readBoolean(byteBuf);
    }

    public void c(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeBoolean(byteBuf, this.er);
    }

    public void b(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) throws IOException {
        this.er = registryFriendlyByteBuf.readBoolean();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m700a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) throws IOException {
        registryFriendlyByteBuf.writeBoolean(this.er);
    }
}
