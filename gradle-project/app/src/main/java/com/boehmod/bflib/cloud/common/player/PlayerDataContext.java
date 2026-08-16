package com.boehmod.bflib.cloud.common.player;

import com.boehmod.bflib.cloud.common.ConnectionType;
import com.boehmod.bflib.cloud.connection.Connection;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/player/PlayerDataContext.class */
public final class PlayerDataContext extends Record {
    private final boolean isSelf;

    @NotNull
    private final PlayerDataContextType type;

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/player/PlayerDataContext$PlayerDataContextType.class */
    public enum PlayerDataContextType {
        PLAYER_REQUEST,
        SERVER_REQUEST
    }

    public PlayerDataContext(boolean isSelf, @NotNull PlayerDataContextType type) {
        this.isSelf = isSelf;
        this.type = type;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, PlayerDataContext.class), PlayerDataContext.class, "isSelf;type", "FIELD:Lcom/boehmod/bflib/cloud/common/player/PlayerDataContext;->isSelf:Z", "FIELD:Lcom/boehmod/bflib/cloud/common/player/PlayerDataContext;->type:Lcom/boehmod/bflib/cloud/common/player/PlayerDataContext$PlayerDataContextType;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, PlayerDataContext.class), PlayerDataContext.class, "isSelf;type", "FIELD:Lcom/boehmod/bflib/cloud/common/player/PlayerDataContext;->isSelf:Z", "FIELD:Lcom/boehmod/bflib/cloud/common/player/PlayerDataContext;->type:Lcom/boehmod/bflib/cloud/common/player/PlayerDataContext$PlayerDataContextType;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, PlayerDataContext.class, Object.class), PlayerDataContext.class, "isSelf;type", "FIELD:Lcom/boehmod/bflib/cloud/common/player/PlayerDataContext;->isSelf:Z", "FIELD:Lcom/boehmod/bflib/cloud/common/player/PlayerDataContext;->type:Lcom/boehmod/bflib/cloud/common/player/PlayerDataContext$PlayerDataContextType;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @NotNull
    public static PlayerDataContext create(@NotNull Connection<?> connection, @NotNull UUID playerDataUUID) {
        return createFor(connection.getUUID(), playerDataUUID, connection.getType());
    }

    @NotNull
    public static PlayerDataContext createFor(@NotNull UUID requestingPlayerUUID, @NotNull UUID playerDataUUID, @NotNull ConnectionType connectionType) {
        PlayerDataContextType playerDataContextType;
        boolean isSelf = playerDataUUID.equals(requestingPlayerUUID);
        if (connectionType == ConnectionType.SERVER) {
            playerDataContextType = PlayerDataContextType.SERVER_REQUEST;
        } else {
            playerDataContextType = PlayerDataContextType.PLAYER_REQUEST;
        }
        PlayerDataContextType contextType = playerDataContextType;
        return new PlayerDataContext(isSelf, contextType);
    }

    public boolean isSelf() {
        return this.isSelf;
    }

    @NotNull
    public PlayerDataContextType type() {
        return this.type;
    }
}
