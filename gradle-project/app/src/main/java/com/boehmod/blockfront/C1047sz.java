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

/* JADX INFO: renamed from: com.boehmod.blockfront.sz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sz.class */
public class C1047sz {

    /* JADX INFO: renamed from: Z */
    @NotNull
    public static final Codec<C1047sz> f5693Z = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("id").forGetter(c1047sz -> {
            return c1047sz.f5695id;
        }), C1046sy.f5692Y.listOf().fieldOf("spawns").forGetter(c1047sz2 -> {
            return c1047sz2.f5694bB;
        })).apply(instance, (str, list) -> {
            C1047sz c1047sz3 = new C1047sz(str);
            c1047sz3.f5694bB.addAll(list);
            return c1047sz3;
        });
    });

    /* JADX INFO: renamed from: bB */
    private final List<C1046sy> f5694bB;

    /* JADX INFO: renamed from: id */
    private String f5695id;

    /* JADX INFO: renamed from: fl */
    private boolean f5696fl;

    public C1047sz() {
        this("unknown");
    }

    public C1047sz(String str) {
        this.f5694bB = new ObjectArrayList();
        this.f5696fl = false;
        this.f5695id = str;
    }

    /* JADX INFO: renamed from: b */
    public void m5851b(@NotNull ByteBuf byteBuf) throws IOException {
        this.f5695id = IPacket.readString(byteBuf);
        this.f5696fl = IPacket.readBoolean(byteBuf);
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.f5694bB.add(new C1046sy(byteBuf));
        }
    }

    /* JADX INFO: renamed from: c */
    public void m5852c(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeString(byteBuf, this.f5695id);
        IPacket.writeBoolean(byteBuf, this.f5696fl);
        byteBuf.writeInt(this.f5694bB.size());
        Iterator<C1046sy> it = this.f5694bB.iterator();
        while (it.hasNext()) {
            it.next().m5847c(byteBuf);
        }
    }

    /* JADX INFO: renamed from: cX */
    public void m5853cX() {
        this.f5696fl = false;
    }

    /* JADX INFO: renamed from: a */
    public C1046sy m5854a() {
        return this.f5694bB.get(ThreadLocalRandom.current().nextInt(this.f5694bB.size()));
    }

    /* JADX INFO: renamed from: bU */
    public boolean m5855bU() {
        return this.f5696fl;
    }

    /* JADX INFO: renamed from: R */
    public void m5856R(boolean z) {
        this.f5696fl = z;
    }

    /* JADX INFO: renamed from: ap */
    public String m5857ap() {
        return this.f5695id;
    }

    /* JADX INFO: renamed from: au */
    public List<C1046sy> m5858au() {
        return this.f5694bB;
    }
}
