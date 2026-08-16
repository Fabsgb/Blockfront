package com.boehmod.blockfront;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.sH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sH.class */
public class C1002sH extends AbstractC0879pr<C1005sK> {

    /* JADX INFO: renamed from: sN */
    private static final int f5532sN = 30;

    public C1002sH(@NotNull C1005sK c1005sK) {
        super(c1005sK);
    }

    public C1002sH(@NotNull C1005sK c1005sK, @NotNull ByteBuf byteBuf) throws IOException {
        super(c1005sK, byteBuf);
    }

    public C1002sH(@NotNull C1005sK c1005sK, @NotNull Player player, @NotNull String str) {
        super(c1005sK, player, str);
    }

    @Override // com.boehmod.blockfront.AbstractC0879pr
    /* JADX INFO: renamed from: c */
    protected boolean mo4538c(@NotNull LivingEntity livingEntity) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0879pr
    /* JADX INFO: renamed from: a */
    protected boolean mo4539a(@NotNull C0872pk c0872pk, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        if (abstractC0863pb instanceof C1001sG) {
            C0872pk c0872pkM5637f = ((C1001sG) abstractC0863pb).m5637f();
            return c0872pkM5637f != null && c0872pkM5637f.equals(c0872pk);
        }
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0879pr
    /* JADX INFO: renamed from: bD */
    protected boolean mo4540bD() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0879pr
    /* JADX INFO: renamed from: j */
    protected int mo4543j(int i) {
        return 1;
    }

    @Override // com.boehmod.blockfront.AbstractC0879pr
    /* JADX INFO: renamed from: bs */
    public int mo4544bs() {
        return 30;
    }

    @Override // com.boehmod.blockfront.AbstractC0879pr
    @Nullable
    /* JADX INFO: renamed from: c */
    public C0872pk mo4542c() {
        C0872pk c0872pk = this.f4804e;
        if (c0872pk != null) {
            return c0872pk;
        }
        if (this.f4807pl > 0) {
            return ((C1001sG) m4536b().m4207a()).m5637f();
        }
        return null;
    }
}
