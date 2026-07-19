package com.boehmod.blockfront;

import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xa.class */
public class C0622xa {

    @NotNull
    public static final DeferredRegister<AttachmentType<?>> h;

    @NotNull
    public static final String eD = "server_player_data";

    @NotNull
    public static final String eE = "client_player_data";

    @NotNull
    public static final String eF = "cloud_player_data";

    @NotNull
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<xO>> oh;

    @NotNull
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<fT>> oi;

    @NotNull
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<iS>> oj;
    static final /* synthetic */ boolean jC;

    static {
        jC = !C0622xa.class.desiredAssertionStatus();
        h = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, "bf");
        oh = h.register(eD, () -> {
            return AttachmentType.builder(iAttachmentHolder -> {
                if (iAttachmentHolder instanceof Player) {
                    Player player = (Player) iAttachmentHolder;
                    AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
                    if (abstractC0264juM166a instanceof xw) {
                        return ((xQ) ((xw) abstractC0264juM166a).a()).b(player.getUUID());
                    }
                    throw new IllegalStateException("Server mod manager is not an instance of ServerModManager!");
                }
                throw new IllegalArgumentException("Server player data must be created with a player instance!");
            }).build();
        });
        oi = h.register(eE, () -> {
            return AttachmentType.builder(iAttachmentHolder -> {
                if (iAttachmentHolder instanceof Player) {
                    Player player = (Player) iAttachmentHolder;
                    C0297l c0297lB = C0297l.b();
                    if (jC || c0297lB != null) {
                        return ((fV) c0297lB.a()).b(player.getUUID());
                    }
                    throw new AssertionError("Client mod manager is null!");
                }
                throw new IllegalArgumentException("Client player data must be created with a player instance!");
            }).build();
        });
        oj = h.register(eF, () -> {
            return AttachmentType.builder(iAttachmentHolder -> {
                if (iAttachmentHolder instanceof Player) {
                    Player player = (Player) iAttachmentHolder;
                    AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
                    if (jC || abstractC0264juM166a != null) {
                        return abstractC0264juM166a.m531a().a(player.getUUID());
                    }
                    throw new AssertionError("BlockFront manager is null!");
                }
                throw new IllegalArgumentException("Player cloud data must be created with a player instance!");
            }).build();
        });
    }
}
