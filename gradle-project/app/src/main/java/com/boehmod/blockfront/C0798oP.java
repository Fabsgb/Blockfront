package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.oP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/oP.class */
public final class C0798oP {

    /* JADX INFO: renamed from: gl */
    static final /* synthetic */ boolean f4344gl;

    static {
        f4344gl = !C0798oP.class.desiredAssertionStatus();
    }

    /* JADX INFO: renamed from: a */
    public static void m3684a(@NotNull PlayerEvent.PlayerLoggedInEvent playerLoggedInEvent) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f4344gl && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        ServerPlayer entity = playerLoggedInEvent.getEntity();
        Level levelServerLevel = entity.serverLevel();
        UUID uuid = entity.getUUID();
        AbstractC0184c abstractC0184cM2351a = abstractC0531jNM179a.m2351a();
        MinecraftServer server = entity.getServer();
        if ((abstractC0531jNM179a instanceof C1280xT) && ((C1280xT) abstractC0531jNM179a).mo2374f() && server != null && server.isDedicatedServer()) {
            C0875pn.m4384a((AbstractC0184c<?>) abstractC0184cM2351a, (ServerLevel) levelServerLevel, entity);
            C0875pn.m4467a(abstractC0531jNM179a, (AbstractC0184c<?>) abstractC0184cM2351a, (ServerLevel) levelServerLevel, entity);
            abstractC0531jNM179a.m2342b().m2472a().m2492b(RequestType.PLAYER_DATA, uuid);
        }
        abstractC0184cM2351a.m1156a(abstractC0531jNM179a, levelServerLevel);
    }
}
