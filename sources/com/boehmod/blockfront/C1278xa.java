package com.boehmod.blockfront;

import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xa */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xa.class */
public class C1278xa {

    /* JADX INFO: renamed from: h */
    @NotNull
    public static final DeferredRegister<AttachmentType<?>> f7487h;

    /* JADX INFO: renamed from: eD */
    @NotNull
    public static final String f7488eD = "server_player_data";

    /* JADX INFO: renamed from: eE */
    @NotNull
    public static final String f7489eE = "client_player_data";

    /* JADX INFO: renamed from: eF */
    @NotNull
    public static final String f7490eF = "cloud_player_data";

    /* JADX INFO: renamed from: oh */
    @NotNull
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<C1274xO>> f7491oh;

    /* JADX INFO: renamed from: oi */
    @NotNull
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<C0324fT>> f7492oi;

    /* JADX INFO: renamed from: oj */
    @NotNull
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<C0482iS>> f7493oj;

    /* JADX INFO: renamed from: jC */
    static final /* synthetic */ boolean f7494jC;

    static {
        f7494jC = !C1278xa.class.desiredAssertionStatus();
        f7487h = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, "bf");
        f7491oh = f7487h.register(f7488eD, () -> {
            return AttachmentType.builder(iAttachmentHolder -> {
                if (iAttachmentHolder instanceof Player) {
                    Player player = (Player) iAttachmentHolder;
                    AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
                    if (abstractC0563juM168a instanceof C1300xw) {
                        return ((C1276xQ) ((C1300xw) abstractC0563juM168a).m7950a()).m1135b(player.getUUID());
                    }
                    throw new IllegalStateException("Server mod manager is not an instance of ServerModManager!");
                }
                throw new IllegalArgumentException("Server player data must be created with a player instance!");
            }).build();
        });
        f7492oi = f7487h.register(f7489eE, () -> {
            return AttachmentType.builder(iAttachmentHolder -> {
                if (iAttachmentHolder instanceof Player) {
                    Player player = (Player) iAttachmentHolder;
                    C0622l c0622lM2667b = C0622l.m2667b();
                    if (f7494jC || c0622lM2667b != null) {
                        return ((C0326fV) c0622lM2667b.m2670a()).m1135b(player.getUUID());
                    }
                    throw new AssertionError("Client mod manager is null!");
                }
                throw new IllegalArgumentException("Client player data must be created with a player instance!");
            }).build();
        });
        f7493oj = f7487h.register(f7490eF, () -> {
            return AttachmentType.builder(iAttachmentHolder -> {
                if (iAttachmentHolder instanceof Player) {
                    Player player = (Player) iAttachmentHolder;
                    AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
                    if (f7494jC || abstractC0563juM168a != null) {
                        return abstractC0563juM168a.m2528a().m1132a(player.getUUID());
                    }
                    throw new AssertionError("BlockFront manager is null!");
                }
                throw new IllegalArgumentException("Player cloud data must be created with a player instance!");
            }).build();
        });
    }
}
