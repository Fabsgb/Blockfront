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

/* JADX INFO: renamed from: com.boehmod.blockfront.sb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sb.class */
public final class C1021sb extends Record {

    /* JADX INFO: renamed from: cx */
    private final String f5423cx;

    /* JADX INFO: renamed from: j */
    private final C0805oX f5424j;

    /* JADX INFO: renamed from: Y */
    @NotNull
    public static final Codec<C1021sb> f5425Y = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("zoneID").forGetter((v0) -> {
            return v0.m5685ah();
        }), C0805oX.f4422s.fieldOf("position").forGetter((v0) -> {
            return v0.m5686e();
        })).apply(instance, C1021sb::new);
    });

    public C1021sb(String str, C0805oX c0805oX) {
        this.f5423cx = str;
        this.f5424j = c0805oX;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1021sb.class), C1021sb.class, "zoneID;position", "FIELD:Lcom/boehmod/blockfront/sb;->cx:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/sb;->j:Lcom/boehmod/blockfront/oX;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1021sb.class), C1021sb.class, "zoneID;position", "FIELD:Lcom/boehmod/blockfront/sb;->cx:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/sb;->j:Lcom/boehmod/blockfront/oX;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1021sb.class, Object.class), C1021sb.class, "zoneID;position", "FIELD:Lcom/boehmod/blockfront/sb;->cx:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/sb;->j:Lcom/boehmod/blockfront/oX;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: ah */
    public String m5685ah() {
        return this.f5423cx;
    }

    /* JADX INFO: renamed from: e */
    public C0805oX m5686e() {
        return this.f5424j;
    }

    public C1021sb(@NotNull ByteBuf byteBuf) throws IOException {
        this(IPacket.readString(byteBuf), new C0805oX(byteBuf));
    }

    /* JADX INFO: renamed from: c */
    public void m5684c(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeString(byteBuf, this.f5423cx);
        this.f5424j.mo4111c(byteBuf);
    }
}
