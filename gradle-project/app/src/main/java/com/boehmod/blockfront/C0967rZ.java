package com.boehmod.blockfront;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.rZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/rZ.class */
public class C0967rZ extends AbstractC0879pr<C1022sb> {

    /* JADX INFO: renamed from: rL */
    private static final int f5376rL = 2;

    /* JADX INFO: renamed from: rM */
    private int f5377rM;

    public C0967rZ(@NotNull C1022sb c1022sb) {
        super(c1022sb);
        this.f5377rM = 0;
    }

    public C0967rZ(@NotNull C1022sb c1022sb, @NotNull ByteBuf byteBuf) throws IOException {
        super(c1022sb, byteBuf);
        this.f5377rM = 0;
    }

    public C0967rZ(@NotNull C1022sb c1022sb, @NotNull Player player, @NotNull String str) {
        super(c1022sb, player, str);
        this.f5377rM = 0;
    }

    @Override // com.boehmod.blockfront.AbstractC0879pr
    /* JADX INFO: renamed from: c */
    protected boolean mo4538c(@NotNull LivingEntity livingEntity) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0879pr
    /* JADX INFO: renamed from: c */
    protected void mo4541c(@Nullable C0872pk c0872pk) {
        if (c0872pk != null && c0872pk.equals(this.f4803d)) {
            this.f4807pl = 0;
            this.f5377rM = 0;
        } else if (this.f4807pl > 0) {
            int i = this.f5377rM + 1;
            this.f5377rM = i;
            if (i >= 2) {
                this.f5377rM = 0;
                this.f4807pl--;
            }
        }
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
            return this.f4806g;
        }
        return null;
    }
}
