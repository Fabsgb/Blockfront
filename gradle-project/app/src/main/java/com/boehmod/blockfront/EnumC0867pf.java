package com.boehmod.blockfront;

/* JADX INFO: renamed from: com.boehmod.blockfront.pf */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pf.class */
public enum EnumC0867pf {
    NONE,
    ALL,
    TEAM_ONLY;

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public boolean shouldShow(boolean z) throws MatchException {
        switch (this) {
            case NONE:
                return false;
            case ALL:
                return true;
            case TEAM_ONLY:
                return z;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }
}
