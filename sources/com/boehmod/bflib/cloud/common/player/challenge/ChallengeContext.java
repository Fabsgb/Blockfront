package com.boehmod.bflib.cloud.common.player.challenge;

import com.boehmod.bflib.cloud.common.item.CloudResourceLocation;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/player/challenge/ChallengeContext.class */
public final class ChallengeContext extends Record {

    @Nullable
    private final CloudResourceLocation item;

    @Nullable
    private final GunType gunType;
    public static final ChallengeContext EMPTY = new ChallengeContext(null, null);

    public ChallengeContext(@Nullable CloudResourceLocation item, @Nullable GunType gunType) {
        this.item = item;
        this.gunType = gunType;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ChallengeContext.class), ChallengeContext.class, "item;gunType", "FIELD:Lcom/boehmod/bflib/cloud/common/player/challenge/ChallengeContext;->item:Lcom/boehmod/bflib/cloud/common/item/CloudResourceLocation;", "FIELD:Lcom/boehmod/bflib/cloud/common/player/challenge/ChallengeContext;->gunType:Lcom/boehmod/bflib/cloud/common/player/challenge/GunType;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ChallengeContext.class), ChallengeContext.class, "item;gunType", "FIELD:Lcom/boehmod/bflib/cloud/common/player/challenge/ChallengeContext;->item:Lcom/boehmod/bflib/cloud/common/item/CloudResourceLocation;", "FIELD:Lcom/boehmod/bflib/cloud/common/player/challenge/ChallengeContext;->gunType:Lcom/boehmod/bflib/cloud/common/player/challenge/GunType;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ChallengeContext.class, Object.class), ChallengeContext.class, "item;gunType", "FIELD:Lcom/boehmod/bflib/cloud/common/player/challenge/ChallengeContext;->item:Lcom/boehmod/bflib/cloud/common/item/CloudResourceLocation;", "FIELD:Lcom/boehmod/bflib/cloud/common/player/challenge/ChallengeContext;->gunType:Lcom/boehmod/bflib/cloud/common/player/challenge/GunType;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Nullable
    public CloudResourceLocation item() {
        return this.item;
    }

    @Nullable
    public GunType gunType() {
        return this.gunType;
    }
}
