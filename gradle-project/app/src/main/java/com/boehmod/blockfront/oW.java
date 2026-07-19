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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oW.class */
public final class oW extends oX {

    @NotNull
    public static final Codec<oW> r = oX.s.xmap(oXVar -> {
        return new oW(oXVar.c.x, oXVar.c.y, oXVar.c.z, oXVar.h.x, oXVar.h.y);
    }, oWVar -> {
        return new oX(oWVar.c.x, oWVar.c.y, oWVar.c.z, oWVar.h.x, oWVar.h.y);
    });
    private static final int np = 5;
    private static final int nq = 6;
    private int nr;

    @NotNull
    private final Set<UUID> n;

    public oW() {
        this.nr = 0;
        this.n = new ObjectOpenHashSet();
    }

    public oW(double d, double d2, double d3, float f, float f2) {
        super(d, d2, d3, f, f2);
        this.nr = 0;
        this.n = new ObjectOpenHashSet();
    }

    public oW(@NotNull Player player) {
        super(player);
        this.nr = 0;
        this.n = new ObjectOpenHashSet();
    }

    public void a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        int i = this.nr;
        this.nr = i + 1;
        if (i <= 5) {
            return;
        }
        this.nr = 0;
        List<ServerPlayer> listA = a(serverLevel, 6, set);
        this.n.removeIf(uuid -> {
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
                    if (item instanceof C0558ur) {
                        C0558ur c0558ur = (C0558ur) item;
                        if (oR.b(itemStack)) {
                            z = true;
                            oR.a(serverPlayer, (Component) Component.literal(String.valueOf((char) 57353)).withColor(ColorReferences.COLOR_WHITE).append(" "), (Component) Component.translatable("bf.message.gamemode.ammopoint.refill", new Object[]{c0558ur.getName(itemStack).copy().withColor(ColorReferences.COLOR_WHITE)}));
                        } else if (!c0558ur.ct() && C0558ur.m1200b(itemStack) != c0558ur.m1206a(itemStack).cc() && !this.n.contains(serverPlayer.getUUID())) {
                            z2 = true;
                            oR.a(serverPlayer, (Component) Component.literal(String.valueOf((char) 57353)).withColor(ColorReferences.COLOR_WHITE).append(" "), (Component) Component.translatable("bf.message.gamemode.ammopoint.norefill", new Object[]{c0558ur.getName(itemStack).copy().withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED));
                        }
                    }
                }
            }
            if (z2) {
                this.n.add(serverPlayer.getUUID());
            }
            if (z) {
                oR.a(serverPlayer, (SoundEvent) C0624xc.pS.get(), SoundSource.NEUTRAL);
            }
        }
    }

    @Override // com.boehmod.blockfront.oX
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public oW d() {
        return new oW(this.c.x, this.c.y, this.c.z, this.h.x, this.h.y);
    }
}
