package com.boehmod.bflib.cloud.common.item.pattern;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/item/pattern/SkinPattern.class */
public final class SkinPattern extends Record {

    @Nonnull
    private final String name;
    private final int width;
    private final int height;

    public SkinPattern(@Nonnull String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, SkinPattern.class), SkinPattern.class, "name;width;height", "FIELD:Lcom/boehmod/bflib/cloud/common/item/pattern/SkinPattern;->name:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/item/pattern/SkinPattern;->width:I", "FIELD:Lcom/boehmod/bflib/cloud/common/item/pattern/SkinPattern;->height:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, SkinPattern.class), SkinPattern.class, "name;width;height", "FIELD:Lcom/boehmod/bflib/cloud/common/item/pattern/SkinPattern;->name:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/item/pattern/SkinPattern;->width:I", "FIELD:Lcom/boehmod/bflib/cloud/common/item/pattern/SkinPattern;->height:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, SkinPattern.class, Object.class), SkinPattern.class, "name;width;height", "FIELD:Lcom/boehmod/bflib/cloud/common/item/pattern/SkinPattern;->name:Ljava/lang/String;", "FIELD:Lcom/boehmod/bflib/cloud/common/item/pattern/SkinPattern;->width:I", "FIELD:Lcom/boehmod/bflib/cloud/common/item/pattern/SkinPattern;->height:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    @Nonnull
    public String name() {
        return this.name;
    }

    public int width() {
        return this.width;
    }

    public int height() {
        return this.height;
    }
}
