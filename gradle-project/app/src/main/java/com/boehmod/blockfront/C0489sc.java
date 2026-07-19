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

/* JADX INFO: renamed from: com.boehmod.blockfront.sc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sc.class */
public class C0489sc {

    @NotNull
    public static final Codec<C0489sc> Z = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("id").forGetter(c0489sc -> {
            return c0489sc.id;
        }), C0488sb.Y.listOf().fieldOf("spawns").forGetter(c0489sc2 -> {
            return c0489sc2.bu;
        })).apply(instance, (str, list) -> {
            C0489sc c0489sc3 = new C0489sc(str);
            c0489sc3.bu.addAll(list);
            return c0489sc3;
        });
    });
    private final List<C0488sb> bu;
    private String id;
    private boolean eR;

    public C0489sc() {
        this("unknown");
    }

    public C0489sc(String str) {
        this.bu = new ObjectArrayList();
        this.eR = false;
        this.id = str;
    }

    public void b(@NotNull ByteBuf byteBuf) throws IOException {
        this.id = IPacket.readString(byteBuf);
        this.eR = IPacket.readBoolean(byteBuf);
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.bu.add(new C0488sb(byteBuf));
        }
    }

    public void c(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeString(byteBuf, this.id);
        IPacket.writeBoolean(byteBuf, this.eR);
        byteBuf.writeInt(this.bu.size());
        Iterator<C0488sb> it = this.bu.iterator();
        while (it.hasNext()) {
            it.next().c(byteBuf);
        }
    }

    public void cL() {
        this.eR = false;
    }

    public C0488sb a() {
        return this.bu.get(ThreadLocalRandom.current().nextInt(this.bu.size()));
    }

    public boolean bK() {
        return this.eR;
    }

    public void Q(boolean z) {
        this.eR = z;
    }

    public String ai() {
        return this.id;
    }

    public List<C0488sb> as() {
        return this.bu;
    }
}
