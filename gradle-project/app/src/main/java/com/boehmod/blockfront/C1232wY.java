package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.wY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/wY.class */
public final class C1232wY implements CustomPacketPayload {

    /* JADX INFO: renamed from: uX */
    private static final int f6682uX = 2;

    /* JADX INFO: renamed from: aB */
    @NotNull
    public static final CustomPacketPayload.Type<C1232wY> f6683aB;

    /* JADX INFO: renamed from: aC */
    @NotNull
    public static final StreamCodec<FriendlyByteBuf, C1232wY> f6684aC;

    /* JADX INFO: renamed from: jD */
    static final /* synthetic */ boolean f6685jD;

    static {
        f6685jD = !C1232wY.class.desiredAssertionStatus();
        f6683aB = new CustomPacketPayload.Type<>(C0532jO.m2378d("packet_gun_dry_fire"));
        f6684aC = CustomPacketPayload.codec((v0, v1) -> {
            v0.m7006d(v1);
        }, C1232wY::new);
    }

    public C1232wY() {
    }

    public C1232wY(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    /* JADX INFO: renamed from: d */
    public void m7006d(@NotNull FriendlyByteBuf friendlyByteBuf) {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return f6683aB;
    }

    /* JADX INFO: renamed from: a */
    public static void m7007a(C1232wY c1232wY, @NotNull IPayloadContext iPayloadContext) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6348a;
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f6685jD && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0184c abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
        Player player = iPayloadContext.player();
        AbstractC0183b abstractC0183bM1153a = abstractC0184cM2351a.m1153a(player);
        if (abstractC0183bM1153a.m1110dv()) {
            return;
        }
        ItemStack selected = player.getInventory().getSelected();
        if (selected.isEmpty()) {
            return;
        }
        Item item = selected.getItem();
        if (item instanceof C1117uP) {
            C1117uP c1117uP = (C1117uP) item;
            if (C1117uP.m6267e(selected) || (deferredHolderM6348a = c1117uP.m6348a(selected)) == null) {
                return;
            }
            Level level = player.level();
            if (abstractC0183bM1153a.m1136a(level.getGameTime(), Math.max(1, c1117uP.m6321cm() - 2))) {
                Vec3 eyePosition = player.getEyePosition();
                level.playSound(player, eyePosition.x, eyePosition.y, eyePosition.z, (SoundEvent) deferredHolderM6348a.get(), SoundSource.PLAYERS, 0.25f, 1.0f);
            }
        }
    }
}
