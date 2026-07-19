package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.server.PacketPlayerDataIncreaseValue;
import java.util.UUID;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.to, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/to.class */
public class C0528to {

    @NotNull
    private final String cY;
    private boolean hA;

    @NotNull
    private a a = (abstractC0264ju, c0528to, oFVar, uuid, i, i2, itemStack, i3) -> {
        abstractC0264ju.m529b().sendPacket(new PacketPlayerDataIncreaseValue(uuid, getKey(), i));
    };

    /* JADX INFO: renamed from: com.boehmod.blockfront.to$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/to$a.class */
    public interface a {
        void onGlobalStat(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull C0528to c0528to, @NotNull oF<?, ?, ?> oFVar, @NotNull UUID uuid, int i, int i2, @Nullable ItemStack itemStack, int i3);
    }

    public C0528to(@NotNull String str) {
        this.cY = str;
    }

    public C0528to a(@NotNull a aVar) {
        this.a = aVar;
        return this;
    }

    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull UUID uuid, int i, int i2, @Nullable ItemStack itemStack, int i3) {
        this.a.onGlobalStat(abstractC0264ju, this, oFVar, uuid, i, i2, itemStack, i3);
    }

    @NotNull
    public String getKey() {
        return this.cY;
    }

    public boolean cf() {
        return this.hA;
    }

    @NotNull
    public C0528to a(boolean z) {
        this.hA = z;
        return this;
    }
}
