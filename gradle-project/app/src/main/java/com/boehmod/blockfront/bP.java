package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.time.Duration;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.CommonListenerCookie;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.telemetry.WorldSessionTelemetryManager;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.server.ServerLinks;
import net.minecraft.world.flag.FeatureFlagSet;
import net.neoforged.neoforge.network.connection.ConnectionType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bP.class */
public class bP extends ClientPacketListener {
    private static final Map<String, String> e = new Object2ObjectOpenHashMap();
    private static RegistryAccess.Frozen a;

    public bP(@NotNull Minecraft minecraft) {
        super(minecraft, new Connection(PacketFlow.CLIENTBOUND), a(minecraft));
    }

    @NotNull
    public static CommonListenerCookie a(@NotNull Minecraft minecraft) {
        return new CommonListenerCookie(minecraft.getGameProfile(), m214a(minecraft), a().freeze(), FeatureFlagSet.of(), "local", m213a(), new C0094dk(), (Map) null, (ChatComponent.State) null, false, e, ServerLinks.EMPTY, ConnectionType.OTHER);
    }

    @NotNull
    public static RegistryAccess.Frozen a() {
        if (a != null) {
            return a;
        }
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(new bS(Registries.DAMAGE_TYPE));
        objectArrayList.add(new bS(Registries.BIOME));
        RegistryAccess.Frozen frozenFreeze = new RegistryAccess.ImmutableRegistryAccess(objectArrayList).freeze();
        a = frozenFreeze;
        return frozenFreeze;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static ServerData m213a() {
        return new ServerData("Local", C0029b.f, ServerData.Type.OTHER);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static WorldSessionTelemetryManager m214a(@NotNull Minecraft minecraft) {
        return minecraft.getTelemetryManager().createWorldSessionManager(false, Duration.ZERO, (String) null);
    }

    @NotNull
    public RegistryAccess.Frozen registryAccess() {
        return a;
    }
}
