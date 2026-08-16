package com.boehmod.blockfront;

import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xx.class */
public class C1310xx {

    /* JADX INFO: renamed from: h */
    @NotNull
    public static final DeferredRegister<AttachmentType<?>> f7899h;

    /* JADX INFO: renamed from: eO */
    @NotNull
    public static final String f7900eO = "server_player_data";

    /* JADX INFO: renamed from: eP */
    @NotNull
    public static final String f7901eP = "client_player_data";

    /* JADX INFO: renamed from: eQ */
    @NotNull
    public static final String f7902eQ = "cloud_player_data";

    /* JADX INFO: renamed from: oj */
    @NotNull
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<C1326ym>> f7903oj;

    /* JADX INFO: renamed from: ok */
    @NotNull
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<C0394gj>> f7904ok;

    /* JADX INFO: renamed from: ol */
    @NotNull
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<C0555jl>> f7905ol;

    /* JADX INFO: renamed from: jS */
    static final /* synthetic */ boolean f7906jS;

    static {
        f7906jS = !C1310xx.class.desiredAssertionStatus();
        f7899h = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, "bf");
        f7903oj = f7899h.register(f7900eO, () -> {
            return AttachmentType.builder(iAttachmentHolder -> {
                if (iAttachmentHolder instanceof Player) {
                    Player player = (Player) iAttachmentHolder;
                    AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
                    if (abstractC0531jNM179a instanceof C1280xT) {
                        return ((C1328yo) ((C1280xT) abstractC0531jNM179a).m7277a()).m1152b(player.getUUID());
                    }
                    throw new IllegalStateException("Server mod manager is not an instance of ServerModManager!");
                }
                throw new IllegalArgumentException("Server player data must be created with a player instance!");
            }).build();
        });
        f7904ok = f7899h.register(f7901eP, () -> {
            return AttachmentType.builder(iAttachmentHolder -> {
                if (iAttachmentHolder instanceof Player) {
                    Player player = (Player) iAttachmentHolder;
                    C0623l c0623lM2852b = C0623l.m2852b();
                    if (f7906jS || c0623lM2852b != null) {
                        return ((C0396gl) c0623lM2852b.m2855a()).m1152b(player.getUUID());
                    }
                    throw new AssertionError("Client mod manager is null!");
                }
                throw new IllegalArgumentException("Client player data must be created with a player instance!");
            }).build();
        });
        f7905ol = f7899h.register(f7902eQ, () -> {
            return AttachmentType.builder(iAttachmentHolder -> {
                if (iAttachmentHolder instanceof Player) {
                    Player player = (Player) iAttachmentHolder;
                    AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
                    if (f7906jS || abstractC0531jNM179a != null) {
                        return abstractC0531jNM179a.m2351a().m1149a(player.getUUID());
                    }
                    throw new AssertionError("BlockFront manager is null!");
                }
                throw new IllegalArgumentException("Player cloud data must be created with a player instance!");
            }).build();
        });
    }
}
