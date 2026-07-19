package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.io.IOException;
import java.util.List;
import net.minecraft.network.RegistryFriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mh.class */
public class C0332mh {

    @NotNull
    public static final Codec<C0332mh> p = RecordCodecBuilder.create(instance -> {
        return instance.group(C0331mg.o.listOf().fieldOf("shots").forGetter((v0) -> {
            return v0.s();
        }), Codec.BOOL.fieldOf("loop").forGetter((v0) -> {
            return v0.au();
        }), Codec.BOOL.fieldOf("showUI").forGetter((v0) -> {
            return v0.at();
        }), Codec.BOOL.fieldOf("allowSkip").forGetter((v0) -> {
            return v0.av();
        }), Codec.BOOL.fieldOf("fadeWhenFinished").forGetter((v0) -> {
            return v0.aw();
        }), Codec.BOOL.optionalFieldOf("showPlayer", false).forGetter((v0) -> {
            return v0.ax();
        })).apply(instance, (list, bool, bool2, bool3, bool4, bool5) -> {
            C0332mh c0332mh = new C0332mh();
            c0332mh.L.addAll(list);
            c0332mh.ei = bool.booleanValue();
            c0332mh.ej = bool2.booleanValue();
            c0332mh.ek = bool3.booleanValue();
            c0332mh.el = bool4.booleanValue();
            c0332mh.em = bool5.booleanValue();
            return c0332mh;
        });
    });
    private final ObjectList<C0331mg> L = new ObjectArrayList();
    private boolean ei = false;
    private boolean ej = false;
    private boolean ek = false;
    private boolean el = false;
    private boolean em = false;

    public static a a() {
        return new a();
    }

    public List<C0331mg> s() {
        return this.L;
    }

    public boolean at() {
        return this.ej;
    }

    public boolean au() {
        return this.ei;
    }

    public boolean av() {
        return this.ek;
    }

    public boolean aw() {
        return this.el;
    }

    public boolean ax() {
        return this.em;
    }

    @NotNull
    public static C0332mh a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        try {
            C0332mh c0332mh = new C0332mh();
            c0332mh.b(registryFriendlyByteBuf);
            return c0332mh;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void b(@NotNull ByteBuf byteBuf) throws IOException {
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            C0331mg c0331mg = new C0331mg();
            c0331mg.b(byteBuf);
            this.L.add(c0331mg);
        }
        this.ei = IPacket.readBoolean(byteBuf);
        this.ej = IPacket.readBoolean(byteBuf);
        this.ek = IPacket.readBoolean(byteBuf);
        this.el = IPacket.readBoolean(byteBuf);
        this.em = IPacket.readBoolean(byteBuf);
    }

    public void c(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeInt(this.L.size());
        ObjectListIterator it = this.L.iterator();
        while (it.hasNext()) {
            ((C0331mg) it.next()).c(byteBuf);
        }
        IPacket.writeBoolean(byteBuf, this.ei);
        IPacket.writeBoolean(byteBuf, this.ej);
        IPacket.writeBoolean(byteBuf, this.ek);
        IPacket.writeBoolean(byteBuf, this.el);
        IPacket.writeBoolean(byteBuf, this.em);
    }

    public void b(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) throws IOException {
        int varInt = registryFriendlyByteBuf.readVarInt();
        for (int i = 0; i < varInt; i++) {
            C0331mg c0331mg = new C0331mg();
            c0331mg.b(registryFriendlyByteBuf);
            this.L.add(c0331mg);
        }
        this.ei = registryFriendlyByteBuf.readBoolean();
        this.ej = registryFriendlyByteBuf.readBoolean();
        this.ek = registryFriendlyByteBuf.readBoolean();
        this.el = registryFriendlyByteBuf.readBoolean();
        this.em = registryFriendlyByteBuf.readBoolean();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m694a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) throws IOException {
        registryFriendlyByteBuf.writeVarInt(this.L.size());
        ObjectListIterator it = this.L.iterator();
        while (it.hasNext()) {
            ((C0331mg) it.next()).a(registryFriendlyByteBuf);
        }
        registryFriendlyByteBuf.writeBoolean(this.ei);
        registryFriendlyByteBuf.writeBoolean(this.ej);
        registryFriendlyByteBuf.writeBoolean(this.ek);
        registryFriendlyByteBuf.writeBoolean(this.el);
        registryFriendlyByteBuf.writeBoolean(this.em);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.mh$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mh$a.class */
    public static class a {
        private final C0332mh a = new C0332mh();

        public a a(C0331mg c0331mg) {
            this.a.L.add(c0331mg);
            return this;
        }

        public a a(boolean z) {
            this.a.ej = z;
            return this;
        }

        public a b(boolean z) {
            this.a.ek = z;
            return this;
        }

        public a c(boolean z) {
            this.a.ei = z;
            return this;
        }

        public a d(boolean z) {
            this.a.el = z;
            return this;
        }

        public a e(boolean z) {
            this.a.em = z;
            return this;
        }

        public C0332mh a() {
            return this.a;
        }
    }
}
