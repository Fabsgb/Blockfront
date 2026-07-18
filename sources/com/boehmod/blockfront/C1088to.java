package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.common.server.PacketPlayerDataIncreaseValue;
import java.util.UUID;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.to */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/to.class */
public class C1088to {

    /* JADX INFO: renamed from: cY */
    @NotNull
    private final String f5681cY;

    /* JADX INFO: renamed from: hA */
    private boolean f5682hA;

    /* JADX INFO: renamed from: a */
    @NotNull
    private a f5683a = (abstractC0563ju, c1088to, abstractC0787oF, uuid, i, i2, itemStack, i3) -> {
        abstractC0563ju.m2520b().sendPacket(new PacketPlayerDataIncreaseValue(uuid, getKey(), i));
    };

    /* JADX INFO: renamed from: com.boehmod.blockfront.to$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/to$a.class */
    public interface a {
        void onGlobalStat(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull C1088to c1088to, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull UUID uuid, int i, int i2, @Nullable ItemStack itemStack, int i3);
    }

    public C1088to(@NotNull String str) {
        this.f5681cY = str;
    }

    /* JADX INFO: renamed from: a */
    public C1088to m6002a(@NotNull a aVar) {
        this.f5683a = aVar;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m6003a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull UUID uuid, int i, int i2, @Nullable ItemStack itemStack, int i3) {
        this.f5683a.onGlobalStat(abstractC0563ju, this, abstractC0787oF, uuid, i, i2, itemStack, i3);
    }

    @NotNull
    public String getKey() {
        return this.f5681cY;
    }

    /* JADX INFO: renamed from: cf */
    public boolean m6004cf() {
        return this.f5682hA;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1088to m6005a(boolean z) {
        this.f5682hA = z;
        return this;
    }
}
