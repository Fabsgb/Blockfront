package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.PlayerStatExtra;
import java.util.UUID;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.tL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tL.class */
public class C1060tL {

    /* JADX INFO: renamed from: di */
    @NotNull
    private final String f5728di;

    /* JADX INFO: renamed from: hU */
    private boolean f5729hU;

    /* JADX INFO: renamed from: a */
    @NotNull
    private a f5730a = (abstractC0531jN, c1060tL, abstractC0863pb, uuid, i, i2, itemStack, i3) -> {
        abstractC0531jN.m2343a().m5887a(uuid, getKey(), i, PlayerStatExtra.EMPTY);
    };

    /* JADX INFO: renamed from: com.boehmod.blockfront.tL$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/tL$a.class */
    public interface a {
        void onGlobalStat(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull C1060tL c1060tL, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull UUID uuid, int i, int i2, @Nullable ItemStack itemStack, int i3);
    }

    public C1060tL(@NotNull String str) {
        this.f5728di = str;
    }

    /* JADX INFO: renamed from: a */
    public C1060tL m5882a(@NotNull a aVar) {
        this.f5730a = aVar;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m5883a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull UUID uuid, int i, int i2, @Nullable ItemStack itemStack, int i3) {
        this.f5730a.onGlobalStat(abstractC0531jN, this, abstractC0863pb, uuid, i, i2, itemStack, i3);
    }

    @NotNull
    public String getKey() {
        return this.f5728di;
    }

    /* JADX INFO: renamed from: cp */
    public boolean m5884cp() {
        return this.f5729hU;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1060tL m5885a(boolean z) {
        this.f5729hU = z;
        return this;
    }
}
