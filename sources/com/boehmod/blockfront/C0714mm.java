package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import net.minecraft.network.RegistryFriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mm.class */
public class C0714mm {

    /* JADX INFO: renamed from: er */
    private boolean f3825er = false;

    /* JADX INFO: renamed from: B */
    public void m3247B(boolean z) {
        this.f3825er = z;
    }

    /* JADX INFO: renamed from: az */
    public boolean m3248az() {
        return this.f3825er;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0714mm m3249a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        try {
            C0714mm c0714mm = new C0714mm();
            c0714mm.m3252b(registryFriendlyByteBuf);
            return c0714mm;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3250b(@NotNull ByteBuf byteBuf) throws IOException {
        this.f3825er = IPacket.readBoolean(byteBuf);
    }

    /* JADX INFO: renamed from: c */
    public void m3251c(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeBoolean(byteBuf, this.f3825er);
    }

    /* JADX INFO: renamed from: b */
    public void m3252b(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) throws IOException {
        this.f3825er = registryFriendlyByteBuf.readBoolean();
    }

    /* JADX INFO: renamed from: a */
    public void m3253a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) throws IOException {
        registryFriendlyByteBuf.writeBoolean(this.f3825er);
    }
}
