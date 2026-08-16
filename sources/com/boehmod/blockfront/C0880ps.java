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

/* JADX INFO: renamed from: com.boehmod.blockfront.ps */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ps.class */
public final class C0880ps extends C0881pt {

    /* JADX INFO: renamed from: r */
    @NotNull
    public static final Codec<C0880ps> f4820r = C0881pt.f4825s.xmap(c0881pt -> {
        return new C0880ps(c0881pt.f4827c.x, c0881pt.f4827c.y, c0881pt.f4827c.z, c0881pt.f4826h.x, c0881pt.f4826h.y);
    }, c0880ps -> {
        return new C0881pt(c0880ps.f4827c.x, c0880ps.f4827c.y, c0880ps.f4827c.z, c0880ps.f4826h.x, c0880ps.f4826h.y);
    });

    /* JADX INFO: renamed from: po */
    private static final int f4821po = 5;

    /* JADX INFO: renamed from: pp */
    private static final int f4822pp = 6;

    /* JADX INFO: renamed from: pq */
    private int f4823pq;

    /* JADX INFO: renamed from: o */
    @NotNull
    private final Set<UUID> f4824o;

    public C0880ps() {
        this.f4823pq = 0;
        this.f4824o = new ObjectOpenHashSet();
    }

    public C0880ps(double d, double d2, double d3, float f, float f2) {
        super(d, d2, d3, f, f2);
        this.f4823pq = 0;
        this.f4824o = new ObjectOpenHashSet();
    }

    public C0880ps(@NotNull Player player) {
        super(player);
        this.f4823pq = 0;
        this.f4824o = new ObjectOpenHashSet();
    }

    /* JADX INFO: renamed from: a */
    public void m4560a(@NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        int i = this.f4823pq;
        this.f4823pq = i + 1;
        if (i <= 5) {
            return;
        }
        this.f4823pq = 0;
        List<ServerPlayer> listA = m4571a(serverLevel, 6, set);
        this.f4824o.removeIf(uuid -> {
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
                    if (item instanceof C1117uP) {
                        C1117uP c1117uP = (C1117uP) item;
                        if (C0875pn.m4468b(itemStack)) {
                            z = true;
                            C0875pn.m4409a(serverPlayer, (Component) Component.literal(String.valueOf((char) 57353)).withColor(ColorReferences.COLOR_WHITE).append(" "), (Component) Component.translatable("bf.message.gamemode.ammopoint.refill", new Object[]{c1117uP.getName(itemStack).copy().withColor(ColorReferences.COLOR_WHITE)}));
                        } else if (!c1117uP.m6324cC() && C1117uP.m6268d(itemStack) != c1117uP.m6283a(itemStack).m6403cr() && !this.f4824o.contains(serverPlayer.getUUID())) {
                            z2 = true;
                            C0875pn.m4409a(serverPlayer, (Component) Component.literal(String.valueOf((char) 57353)).withColor(ColorReferences.COLOR_WHITE).append(" "), (Component) Component.translatable("bf.message.gamemode.ammopoint.norefill", new Object[]{c1117uP.getName(itemStack).copy().withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED));
                        }
                    }
                }
            }
            if (z2) {
                this.f4824o.add(serverPlayer.getUUID());
            }
            if (z) {
                C0875pn.m4364a(serverPlayer, (SoundEvent) C1312xz.f7999pU.get(), SoundSource.NEUTRAL);
            }
        }
    }

    @Override // com.boehmod.blockfront.C0881pt
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0880ps mo3849d() {
        return new C0880ps(this.f4827c.x, this.f4827c.y, this.f4827c.z, this.f4826h.x, this.f4826h.y);
    }
}
