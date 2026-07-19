package com.boehmod.bflib.cloud.common;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/RequestType.class */
public enum RequestType {
    NONE(RequestScope.ANY),
    PLAYER_DATA(RequestScope.ANY),
    PLAYER_INVENTORY(RequestScope.SELF_ONLY),
    CLOUD_STATS(RequestScope.ANY),
    PLAYER_INVENTORY_DEFAULTS(RequestScope.SELF_ONLY),
    PLAYER_INVENTORY_SHOWCASE(RequestScope.SELF_ONLY),
    PLAYER_FRIENDS(RequestScope.SELF_ONLY),
    CLAN_DATA(RequestScope.ANY),
    PLAYER_CHALLENGES(RequestScope.SELF_ONLY),
    PLAYER_STATUS(RequestScope.FRIENDS_AND_PARTY),
    INVENTORY_MINIMAL(RequestScope.ANY),
    PLAYER_MATCHES(RequestScope.ANY);

    private final RequestScope scope;

    RequestType(RequestScope scope) {
        this.scope = scope;
    }

    public RequestScope getScope() {
        return this.scope;
    }
}
