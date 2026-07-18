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

/* JADX INFO: renamed from: com.boehmod.blockfront.bP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bP.class */
public class C0098bP extends ClientPacketListener {

    /* JADX INFO: renamed from: e */
    private static final Map<String, String> f635e = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: a */
    private static RegistryAccess.Frozen f636a;

    public C0098bP(@NotNull Minecraft minecraft) {
        super(minecraft, new Connection(PacketFlow.CLIENTBOUND), m305a(minecraft));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static CommonListenerCookie m305a(@NotNull Minecraft minecraft) {
        return new CommonListenerCookie(minecraft.getGameProfile(), m308a(minecraft), m306a().freeze(), FeatureFlagSet.of(), "local", m307a(), new C0235dk(), (Map) null, (ChatComponent.State) null, false, f635e, ServerLinks.EMPTY, ConnectionType.OTHER);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static RegistryAccess.Frozen m306a() {
        if (f636a != null) {
            return f636a;
        }
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0101bS(Registries.DAMAGE_TYPE));
        objectArrayList.add(new C0101bS(Registries.BIOME));
        RegistryAccess.Frozen frozenFreeze = new RegistryAccess.ImmutableRegistryAccess(objectArrayList).freeze();
        f636a = frozenFreeze;
        return frozenFreeze;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ServerData m307a() {
        return new ServerData("Local", C0082b.f536f, ServerData.Type.OTHER);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static WorldSessionTelemetryManager m308a(@NotNull Minecraft minecraft) {
        return minecraft.getTelemetryManager().createWorldSessionManager(false, Duration.ZERO, (String) null);
    }

    @NotNull
    public RegistryAccess.Frozen registryAccess() {
        return f636a;
    }
}
