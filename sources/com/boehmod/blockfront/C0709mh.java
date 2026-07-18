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

/* JADX INFO: renamed from: com.boehmod.blockfront.mh */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mh.class */
public class C0709mh {

    /* JADX INFO: renamed from: p */
    @NotNull
    public static final Codec<C0709mh> f3780p = RecordCodecBuilder.create(instance -> {
        return instance.group(C0708mg.f3763o.listOf().fieldOf("shots").forGetter((v0) -> {
            return v0.m3200s();
        }), Codec.BOOL.fieldOf("loop").forGetter((v0) -> {
            return v0.m3202au();
        }), Codec.BOOL.fieldOf("showUI").forGetter((v0) -> {
            return v0.m3201at();
        }), Codec.BOOL.fieldOf("allowSkip").forGetter((v0) -> {
            return v0.m3203av();
        }), Codec.BOOL.fieldOf("fadeWhenFinished").forGetter((v0) -> {
            return v0.m3204aw();
        }), Codec.BOOL.optionalFieldOf("showPlayer", false).forGetter((v0) -> {
            return v0.m3205ax();
        })).apply(instance, (list, bool, bool2, bool3, bool4, bool5) -> {
            C0709mh c0709mh = new C0709mh();
            c0709mh.f3781L.addAll(list);
            c0709mh.f3782ei = bool.booleanValue();
            c0709mh.f3783ej = bool2.booleanValue();
            c0709mh.f3784ek = bool3.booleanValue();
            c0709mh.f3785el = bool4.booleanValue();
            c0709mh.f3786em = bool5.booleanValue();
            return c0709mh;
        });
    });

    /* JADX INFO: renamed from: L */
    private final ObjectList<C0708mg> f3781L = new ObjectArrayList();

    /* JADX INFO: renamed from: ei */
    private boolean f3782ei = false;

    /* JADX INFO: renamed from: ej */
    private boolean f3783ej = false;

    /* JADX INFO: renamed from: ek */
    private boolean f3784ek = false;

    /* JADX INFO: renamed from: el */
    private boolean f3785el = false;

    /* JADX INFO: renamed from: em */
    private boolean f3786em = false;

    /* JADX INFO: renamed from: a */
    public static a m3199a() {
        return new a();
    }

    /* JADX INFO: renamed from: s */
    public List<C0708mg> m3200s() {
        return this.f3781L;
    }

    /* JADX INFO: renamed from: at */
    public boolean m3201at() {
        return this.f3783ej;
    }

    /* JADX INFO: renamed from: au */
    public boolean m3202au() {
        return this.f3782ei;
    }

    /* JADX INFO: renamed from: av */
    public boolean m3203av() {
        return this.f3784ek;
    }

    /* JADX INFO: renamed from: aw */
    public boolean m3204aw() {
        return this.f3785el;
    }

    /* JADX INFO: renamed from: ax */
    public boolean m3205ax() {
        return this.f3786em;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0709mh m3206a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        try {
            C0709mh c0709mh = new C0709mh();
            c0709mh.m3209b(registryFriendlyByteBuf);
            return c0709mh;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3207b(@NotNull ByteBuf byteBuf) throws IOException {
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            C0708mg c0708mg = new C0708mg();
            c0708mg.m3182b(byteBuf);
            this.f3781L.add(c0708mg);
        }
        this.f3782ei = IPacket.readBoolean(byteBuf);
        this.f3783ej = IPacket.readBoolean(byteBuf);
        this.f3784ek = IPacket.readBoolean(byteBuf);
        this.f3785el = IPacket.readBoolean(byteBuf);
        this.f3786em = IPacket.readBoolean(byteBuf);
    }

    /* JADX INFO: renamed from: c */
    public void m3208c(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeInt(this.f3781L.size());
        ObjectListIterator it = this.f3781L.iterator();
        while (it.hasNext()) {
            ((C0708mg) it.next()).m3183c(byteBuf);
        }
        IPacket.writeBoolean(byteBuf, this.f3782ei);
        IPacket.writeBoolean(byteBuf, this.f3783ej);
        IPacket.writeBoolean(byteBuf, this.f3784ek);
        IPacket.writeBoolean(byteBuf, this.f3785el);
        IPacket.writeBoolean(byteBuf, this.f3786em);
    }

    /* JADX INFO: renamed from: b */
    public void m3209b(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) throws IOException {
        int varInt = registryFriendlyByteBuf.readVarInt();
        for (int i = 0; i < varInt; i++) {
            C0708mg c0708mg = new C0708mg();
            c0708mg.m3178b(registryFriendlyByteBuf);
            this.f3781L.add(c0708mg);
        }
        this.f3782ei = registryFriendlyByteBuf.readBoolean();
        this.f3783ej = registryFriendlyByteBuf.readBoolean();
        this.f3784ek = registryFriendlyByteBuf.readBoolean();
        this.f3785el = registryFriendlyByteBuf.readBoolean();
        this.f3786em = registryFriendlyByteBuf.readBoolean();
    }

    /* JADX INFO: renamed from: a */
    public void m3210a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) throws IOException {
        registryFriendlyByteBuf.writeVarInt(this.f3781L.size());
        ObjectListIterator it = this.f3781L.iterator();
        while (it.hasNext()) {
            ((C0708mg) it.next()).m3179a(registryFriendlyByteBuf);
        }
        registryFriendlyByteBuf.writeBoolean(this.f3782ei);
        registryFriendlyByteBuf.writeBoolean(this.f3783ej);
        registryFriendlyByteBuf.writeBoolean(this.f3784ek);
        registryFriendlyByteBuf.writeBoolean(this.f3785el);
        registryFriendlyByteBuf.writeBoolean(this.f3786em);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.mh$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mh$a.class */
    public static class a {

        /* JADX INFO: renamed from: a */
        private final C0709mh f3787a = new C0709mh();

        /* JADX INFO: renamed from: a */
        public a m3213a(C0708mg c0708mg) {
            this.f3787a.f3781L.add(c0708mg);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m3214a(boolean z) {
            this.f3787a.f3783ej = z;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public a m3215b(boolean z) {
            this.f3787a.f3784ek = z;
            return this;
        }

        /* JADX INFO: renamed from: c */
        public a m3216c(boolean z) {
            this.f3787a.f3782ei = z;
            return this;
        }

        /* JADX INFO: renamed from: d */
        public a m3217d(boolean z) {
            this.f3787a.f3785el = z;
            return this;
        }

        /* JADX INFO: renamed from: e */
        public a m3218e(boolean z) {
            this.f3787a.f3786em = z;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0709mh m3219a() {
            return this.f3787a;
        }
    }
}
