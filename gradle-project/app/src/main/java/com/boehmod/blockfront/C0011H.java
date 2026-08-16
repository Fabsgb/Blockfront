package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.H */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/H.class */
public final class C0011H extends Record {

    /* JADX INFO: renamed from: y */
    private final String f159y;

    /* JADX INFO: renamed from: z */
    private final String f160z;

    /* JADX INFO: renamed from: A */
    private final String f161A;

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final Codec<C0011H> f162b = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("name").forGetter((v0) -> {
            return v0.m39k();
        }), Codec.STRING.fieldOf("uuid").forGetter((v0) -> {
            return v0.m40l();
        }), Codec.STRING.fieldOf("translation").forGetter((v0) -> {
            return v0.m41m();
        })).apply(instance, C0011H::new);
    });

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final C0011H f163a = new C0011H("default", "143b454d-2366-4eee-b930-76b0e55a8f0a", "unknown");

    public C0011H(String str, String str2, String str3) {
        this.f159y = str;
        this.f160z = str2;
        this.f161A = str3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0011H.class), C0011H.class, "name;uuid;translation", "FIELD:Lcom/boehmod/blockfront/H;->y:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/H;->z:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/H;->A:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0011H.class), C0011H.class, "name;uuid;translation", "FIELD:Lcom/boehmod/blockfront/H;->y:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/H;->z:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/H;->A:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0011H.class, Object.class), C0011H.class, "name;uuid;translation", "FIELD:Lcom/boehmod/blockfront/H;->y:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/H;->z:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/H;->A:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: k */
    public String m39k() {
        return this.f159y;
    }

    /* JADX INFO: renamed from: l */
    public String m40l() {
        return this.f160z;
    }

    /* JADX INFO: renamed from: m */
    public String m41m() {
        return this.f161A;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.H$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/H$a.class */
    public static class a extends AbstractC0615ks<C0011H> {
        public a(@NotNull Minecraft minecraft) {
            super(minecraft.getResourceManager(), "credits", "credits.json", C0011H.f162b, C0011H.f163a, (v0) -> {
                return v0.m40l();
            });
        }
    }
}
