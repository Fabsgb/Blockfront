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
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.server.ServerLinks;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.neoforged.neoforge.network.connection.ConnectionType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bY.class */
public class C0108bY extends ClientPacketListener {

    /* JADX INFO: renamed from: e */
    private static final Map<String, String> f704e = new Object2ObjectOpenHashMap();

    /* JADX INFO: renamed from: a */
    private static RegistryAccess.Frozen f705a;

    public C0108bY(@NotNull Minecraft minecraft) {
        super(minecraft, new Connection(PacketFlow.CLIENTBOUND), m410a(minecraft));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static CommonListenerCookie m410a(@NotNull Minecraft minecraft) {
        return new CommonListenerCookie(minecraft.getGameProfile(), m413a(minecraft), m411a().freeze(), FeatureFlagSet.of(), "local", m412a(), new C0245dt(), (Map) null, (ChatComponent.State) null, false, f704e, ServerLinks.EMPTY, ConnectionType.OTHER);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static RegistryAccess.Frozen m411a() {
        if (f705a != null) {
            return f705a;
        }
        ObjectArrayList objectArrayList = new ObjectArrayList();
        C0164cb c0164cb = new C0164cb(Registries.DIMENSION_TYPE);
        Registry.register(c0164cb, BuiltinDimensionTypes.OVERWORLD, C0107bX.f703a);
        objectArrayList.add(new C0164cb(Registries.DAMAGE_TYPE));
        objectArrayList.add(new C0164cb(Registries.BIOME));
        objectArrayList.add(c0164cb);
        RegistryAccess.Frozen frozenFreeze = new RegistryAccess.ImmutableRegistryAccess(objectArrayList).freeze();
        f705a = frozenFreeze;
        return frozenFreeze;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ServerData m412a() {
        return new ServerData("Local", C0083b.f497g, ServerData.Type.OTHER);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static WorldSessionTelemetryManager m413a(@NotNull Minecraft minecraft) {
        return minecraft.getTelemetryManager().createWorldSessionManager(false, Duration.ZERO, (String) null);
    }

    @NotNull
    public RegistryAccess.Frozen registryAccess() {
        return f705a;
    }
}
