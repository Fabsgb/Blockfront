package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sc.class */
public class C1022sc {

    /* JADX INFO: renamed from: Z */
    @NotNull
    public static final Codec<C1022sc> f5426Z = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("id").forGetter(c1022sc -> {
            return c1022sc.f5428id;
        }), C1021sb.f5425Y.listOf().fieldOf("spawns").forGetter(c1022sc2 -> {
            return c1022sc2.f5427bu;
        })).apply(instance, (str, list) -> {
            C1022sc c1022sc3 = new C1022sc(str);
            c1022sc3.f5427bu.addAll(list);
            return c1022sc3;
        });
    });

    /* JADX INFO: renamed from: bu */
    private final List<C1021sb> f5427bu;

    /* JADX INFO: renamed from: id */
    private String f5428id;

    /* JADX INFO: renamed from: eR */
    private boolean f5429eR;

    public C1022sc() {
        this("unknown");
    }

    public C1022sc(String str) {
        this.f5427bu = new ObjectArrayList();
        this.f5429eR = false;
        this.f5428id = str;
    }

    /* JADX INFO: renamed from: b */
    public void m5688b(@NotNull ByteBuf byteBuf) throws IOException {
        this.f5428id = IPacket.readString(byteBuf);
        this.f5429eR = IPacket.readBoolean(byteBuf);
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.f5427bu.add(new C1021sb(byteBuf));
        }
    }

    /* JADX INFO: renamed from: c */
    public void m5689c(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeString(byteBuf, this.f5428id);
        IPacket.writeBoolean(byteBuf, this.f5429eR);
        byteBuf.writeInt(this.f5427bu.size());
        Iterator<C1021sb> it = this.f5427bu.iterator();
        while (it.hasNext()) {
            it.next().m5684c(byteBuf);
        }
    }

    /* JADX INFO: renamed from: cL */
    public void m5690cL() {
        this.f5429eR = false;
    }

    /* JADX INFO: renamed from: a */
    public C1021sb m5691a() {
        return this.f5427bu.get(ThreadLocalRandom.current().nextInt(this.f5427bu.size()));
    }

    /* JADX INFO: renamed from: bK */
    public boolean m5692bK() {
        return this.f5429eR;
    }

    /* JADX INFO: renamed from: Q */
    public void m5693Q(boolean z) {
        this.f5429eR = z;
    }

    /* JADX INFO: renamed from: ai */
    public String m5694ai() {
        return this.f5428id;
    }

    /* JADX INFO: renamed from: as */
    public List<C1021sb> m5695as() {
        return this.f5427bu;
    }
}
