package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oW.class */
public final class C0804oW extends C0805oX {

    /* JADX INFO: renamed from: r */
    @NotNull
    public static final Codec<C0804oW> f4417r = C0805oX.f4422s.xmap(c0805oX -> {
        return new C0804oW(c0805oX.f4424c.x, c0805oX.f4424c.y, c0805oX.f4424c.z, c0805oX.f4423h.x, c0805oX.f4423h.y);
    }, c0804oW -> {
        return new C0805oX(c0804oW.f4424c.x, c0804oW.f4424c.y, c0804oW.f4424c.z, c0804oW.f4423h.x, c0804oW.f4423h.y);
    });

    /* JADX INFO: renamed from: np */
    private static final int f4418np = 5;

    /* JADX INFO: renamed from: nq */
    private static final int f4419nq = 6;

    /* JADX INFO: renamed from: nr */
    private int f4420nr;

    /* JADX INFO: renamed from: n */
    @NotNull
    private final Set<UUID> f4421n;

    public C0804oW() {
        this.f4420nr = 0;
        this.f4421n = new ObjectOpenHashSet();
    }

    public C0804oW(double d, double d2, double d3, float f, float f2) {
        super(d, d2, d3, f, f2);
        this.f4420nr = 0;
        this.f4421n = new ObjectOpenHashSet();
    }

    public C0804oW(@NotNull Player player) {
        super(player);
        this.f4420nr = 0;
        this.f4421n = new ObjectOpenHashSet();
    }

    /* JADX INFO: renamed from: a */
    public void m4122a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        int i = this.f4420nr;
        this.f4420nr = i + 1;
        if (i <= 5) {
            return;
        }
        this.f4420nr = 0;
        List<ServerPlayer> listA = m4134a(serverLevel, 6, set);
        this.f4421n.removeIf(uuid -> {
            return listA.stream().noneMatch(serverPlayer -> {
                return serverPlayer.getUUID().equals(uuid);
            });
        });
        for (ServerPlayer serverPlayer : listA) {
            boolean z = false;
            boolean z2 = false;
            for (ItemStack itemStack : serverPlayer.getInventory().items) {
                if (!itemStack.isEmpty()) {
                    Item item = itemStack.getItem();
                    if (item instanceof C1144ur) {
                        C1144ur c1144ur = (C1144ur) item;
                        if (C0799oR.m4032b(itemStack)) {
                            z = true;
                            C0799oR.m3973a(serverPlayer, (Component) Component.literal(String.valueOf((char) 57353)).withColor(ColorReferences.COLOR_WHITE).append(" "), (Component) Component.translatable("bf.message.gamemode.ammopoint.refill", new Object[]{c1144ur.getName(itemStack).copy().withColor(ColorReferences.COLOR_WHITE)}));
                        } else if (!c1144ur.m6350ct() && C1144ur.m6304b(itemStack) != c1144ur.m6318a(itemStack).m6425cc() && !this.f4421n.contains(serverPlayer.getUUID())) {
                            z2 = true;
                            C0799oR.m3973a(serverPlayer, (Component) Component.literal(String.valueOf((char) 57353)).withColor(ColorReferences.COLOR_WHITE).append(" "), (Component) Component.translatable("bf.message.gamemode.ammopoint.norefill", new Object[]{c1144ur.getName(itemStack).copy().withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED));
                        }
                    }
                }
            }
            if (z2) {
                this.f4421n.add(serverPlayer.getUUID());
            }
            if (z) {
                C0799oR.m3928a(serverPlayer, (SoundEvent) C1280xc.f7587pS.get(), SoundSource.NEUTRAL);
            }
        }
    }

    @Override // com.boehmod.blockfront.C0805oX
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0804oW mo4124d() {
        return new C0804oW(this.f4424c.x, this.f4424c.y, this.f4424c.z, this.f4423h.x, this.f4423h.y);
    }
}
