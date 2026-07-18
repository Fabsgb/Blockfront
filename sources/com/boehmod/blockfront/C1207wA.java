package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wA.class */
public final class C1207wA implements CustomPacketPayload {

    /* JADX INFO: renamed from: sT */
    private static final int f6343sT = 2;

    /* JADX INFO: renamed from: aD */
    @NotNull
    public static final CustomPacketPayload.Type<C1207wA> f6344aD;

    /* JADX INFO: renamed from: aE */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1207wA> f6345aE;

    /* JADX INFO: renamed from: jl */
    static final /* synthetic */ boolean f6346jl;

    static {
        f6346jl = !C1207wA.class.desiredAssertionStatus();
        f6344aD = new CustomPacketPayload.Type<>(C0564jv.m2555d("packet_gun_dry_fire"));
        f6345aE = CustomPacketPayload.codec((v0, v1) -> {
            v0.m6715d(v1);
        }, C1207wA::new);
    }

    public C1207wA() {
    }

    public C1207wA(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    /* JADX INFO: renamed from: d */
    public void m6715d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6344aD;
    }

    /* JADX INFO: renamed from: a */
    public static void m6716a(C1207wA c1207wA, @NotNull IPayloadContext iPayloadContext) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6374a;
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f6346jl && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0183c abstractC0183cM2528a = abstractC0563juM168a.m2528a();
        Player player = iPayloadContext.player();
        AbstractC0182b abstractC0182bM1136a = abstractC0183cM2528a.m1136a(player);
        if (abstractC0182bM1136a.m1093dm()) {
            return;
        }
        ItemStack selected = player.getInventory().getSelected();
        if (selected.isEmpty()) {
            return;
        }
        Item item = selected.getItem();
        if (item instanceof C1144ur) {
            C1144ur c1144ur = (C1144ur) item;
            if (C1144ur.m6303e(selected) || (deferredHolderM6374a = c1144ur.m6374a(selected)) == null) {
                return;
            }
            Level level = player.level();
            if (abstractC0182bM1136a.m1119a(level.getGameTime(), Math.max(1, c1144ur.m6348bX() - 2))) {
                Vec3 eyePosition = player.getEyePosition();
                level.playSound(player, eyePosition.x, eyePosition.y, eyePosition.z, (SoundEvent) deferredHolderM6374a.get(), SoundSource.PLAYERS, 0.25f, 1.0f);
            }
        }
    }
}
