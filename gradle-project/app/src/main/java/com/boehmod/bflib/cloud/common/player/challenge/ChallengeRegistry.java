package com.boehmod.bflib.cloud.common.player.challenge;

import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import javax.annotation.Nullable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/player/challenge/ChallengeRegistry.class */
public class ChallengeRegistry {

    @NotNull
    private static final Logger LOGGER = LogManager.getLogger("Challenge");

    @NotNull
    private static final Int2ObjectMap<Class<? extends Challenge>> PACKET_HASH_TO_CLASS_MAP = Int2ObjectMaps.synchronize(new Int2ObjectOpenHashMap());

    @NotNull
    private static final Object2ObjectMap<Class<? extends Challenge>, PacketIdentifier> PACKET_CLASS_TO_IDENTIFIER_MAP = Object2ObjectMaps.synchronize(new Object2ObjectOpenHashMap());

    static {
        registerChallenge(KillCountChallenge.f17ID, KillCountChallenge.class);
        registerChallenge(ItemKillChallenge.f16ID, ItemKillChallenge.class);
        registerChallenge(WeaponTypeKillChallenge.f18ID, WeaponTypeKillChallenge.class);
    }

    public static void registerChallenge(@NotNull PacketIdentifier identifier, @NotNull Class<? extends Challenge> challengeClass) {
        int hash = identifier.hash();
        if (PACKET_HASH_TO_CLASS_MAP.containsKey(hash)) {
            Class<? extends Challenge> existing = (Class) PACKET_HASH_TO_CLASS_MAP.get(hash);
            if (!existing.equals(challengeClass)) {
                LOGGER.error("[Packet] Collision detected! Hash '{}' is already assigned to '{}' and cannot be reassigned to '{}'.", Integer.valueOf(hash), existing.getName(), challengeClass.getName());
                throw new IllegalStateException("Hash collision detected for packet identifier: " + String.valueOf(identifier));
            }
        }
        LOGGER.info("[Packet] Registering packet mapping for '{}' with Hash '{}'", challengeClass.getName(), Integer.valueOf(hash));
        PACKET_HASH_TO_CLASS_MAP.put(hash, challengeClass);
        PACKET_CLASS_TO_IDENTIFIER_MAP.put(challengeClass, identifier);
    }

    @Nullable
    public static Challenge parseChallenge(int type, @NotNull String data) {
        Class<? extends Challenge> challengeClass = (Class) PACKET_HASH_TO_CLASS_MAP.get(type);
        if (challengeClass == null) {
            LOGGER.error("Failed to find challenge class for type '{}'", Integer.valueOf(type));
            return null;
        }
        JsonObject jsonObject = JsonParser.parseString(data).getAsJsonObject();
        try {
            return (Challenge) challengeClass.getConstructor(JsonObject.class).newInstance(jsonObject);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            LOGGER.error("Failed to parse challenge for class {} ({}).", challengeClass.getName(), Integer.valueOf(type), e);
            return null;
        }
    }

    public static int getChallengeId(@NotNull Class<? extends Challenge> challengeClass) {
        return ((PacketIdentifier) PACKET_CLASS_TO_IDENTIFIER_MAP.get(challengeClass)).hash();
    }

    public static void writeChallenge(@NotNull Challenge challenge, @NotNull ByteBuf byteBuffer) throws IOException {
        PacketIdentifier identifier = (PacketIdentifier) PACKET_CLASS_TO_IDENTIFIER_MAP.get(challenge.getClass());
        if (identifier == null) {
            throw new IOException("Unrecognized packet class " + challenge.getClass().getName());
        }
        byteBuffer.writeInt(identifier.hash());
        challenge.writeChallenge(byteBuffer);
    }

    @Nullable
    public static Challenge readChallenge(@NotNull ByteBuf byteBuf) throws IOException {
        try {
            int packetHash = byteBuf.readInt();
            Class<? extends Challenge> challengeClass = (Class) PACKET_HASH_TO_CLASS_MAP.get(packetHash);
            if (challengeClass == null) {
                throw new IOException("Unrecognized packet hash " + packetHash);
            }
            return (Challenge) challengeClass.getConstructor(ByteBuf.class).newInstance(byteBuf);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            LOGGER.error("Failed to instantiate challenge.", e);
            return null;
        } catch (SocketException | SocketTimeoutException e2) {
            LOGGER.error("Failed to read challenge because connection was closed abruptly.");
            return null;
        }
    }
}
