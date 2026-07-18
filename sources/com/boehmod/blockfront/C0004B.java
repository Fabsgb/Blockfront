package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.B */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/B.class */
public final class C0004B extends Record {

    /* JADX INFO: renamed from: t */
    private final String f121t;

    /* JADX INFO: renamed from: u */
    private final String f122u;

    /* JADX INFO: renamed from: v */
    private final String f123v;

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final Codec<C0004B> f124b = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("name").forGetter((v0) -> {
            return v0.m7g();
        }), Codec.STRING.fieldOf("uuid").forGetter((v0) -> {
            return v0.m8h();
        }), Codec.STRING.fieldOf("translation").forGetter((v0) -> {
            return v0.m9i();
        })).apply(instance, C0004B::new);
    });

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final C0004B f125a = new C0004B("default", "143b454d-2366-4eee-b930-76b0e55a8f0a", "unknown");

    public C0004B(String str, String str2, String str3) {
        this.f121t = str;
        this.f122u = str2;
        this.f123v = str3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0004B.class), C0004B.class, "name;uuid;translation", "FIELD:Lcom/boehmod/blockfront/B;->t:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/B;->u:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/B;->v:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0004B.class), C0004B.class, "name;uuid;translation", "FIELD:Lcom/boehmod/blockfront/B;->t:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/B;->u:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/B;->v:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0004B.class, Object.class), C0004B.class, "name;uuid;translation", "FIELD:Lcom/boehmod/blockfront/B;->t:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/B;->u:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/B;->v:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: g */
    public String m7g() {
        return this.f121t;
    }

    /* JADX INFO: renamed from: h */
    public String m8h() {
        return this.f122u;
    }

    /* JADX INFO: renamed from: i */
    public String m9i() {
        return this.f123v;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.B$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/B$a.class */
    public static class a extends AbstractC0539jW<C0004B> {
        public a(@NotNull Minecraft minecraft) {
            super(minecraft.getResourceManager(), "credits", "credits.json", C0004B.f124b, C0004B.f125a, (v0) -> {
                return v0.m8h();
            });
        }
    }
}
