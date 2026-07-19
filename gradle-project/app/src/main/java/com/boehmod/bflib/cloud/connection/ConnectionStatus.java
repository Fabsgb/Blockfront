package com.boehmod.bflib.cloud.connection;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/connection/ConnectionStatus.class */
public enum ConnectionStatus {
    CONNECTED_NOT_ENCRYPTED,
    CONNECTED_NOT_VERIFIED,
    CONNECTED_VERIFIED,
    CLOSED;

    public boolean isVerified() {
        return this == CONNECTED_VERIFIED;
    }

    public boolean isClosed() {
        return this == CLOSED;
    }

    public boolean isConnected() {
        return this == CONNECTED_VERIFIED || this == CONNECTED_NOT_VERIFIED;
    }
}
