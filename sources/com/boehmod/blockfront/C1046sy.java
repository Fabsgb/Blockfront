package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sy */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sy.class */
public final class C1046sy extends Record {

    /* JADX INFO: renamed from: cH */
    private final String f5690cH;

    /* JADX INFO: renamed from: j */
    private final C0881pt f5691j;

    /* JADX INFO: renamed from: Y */
    @NotNull
    public static final Codec<C1046sy> f5692Y = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("zoneID").forGetter((v0) -> {
            return v0.m5848ao();
        }), C0881pt.f4825s.fieldOf("position").forGetter((v0) -> {
            return v0.m5849e();
        })).apply(instance, C1046sy::new);
    });

    public C1046sy(String str, C0881pt c0881pt) {
        this.f5690cH = str;
        this.f5691j = c0881pt;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1046sy.class), C1046sy.class, "zoneID;position", "FIELD:Lcom/boehmod/blockfront/sy;->cH:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/sy;->j:Lcom/boehmod/blockfront/pt;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1046sy.class), C1046sy.class, "zoneID;position", "FIELD:Lcom/boehmod/blockfront/sy;->cH:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/sy;->j:Lcom/boehmod/blockfront/pt;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1046sy.class, Object.class), C1046sy.class, "zoneID;position", "FIELD:Lcom/boehmod/blockfront/sy;->cH:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/sy;->j:Lcom/boehmod/blockfront/pt;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: ao */
    public String m5848ao() {
        return this.f5690cH;
    }

    /* JADX INFO: renamed from: e */
    public C0881pt m5849e() {
        return this.f5691j;
    }

    public C1046sy(@NotNull ByteBuf byteBuf) throws IOException {
        this(IPacket.readString(byteBuf), new C0881pt(byteBuf));
    }

    /* JADX INFO: renamed from: c */
    public void m5847c(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeString(byteBuf, this.f5690cH);
        this.f5691j.mo3870c(byteBuf);
    }
}
