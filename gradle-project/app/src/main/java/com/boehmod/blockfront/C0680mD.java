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

/* JADX INFO: renamed from: com.boehmod.blockfront.mD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mD.class */
public class C0680mD {

    /* JADX INFO: renamed from: p */
    @NotNull
    public static final Codec<C0680mD> f3735p = RecordCodecBuilder.create(instance -> {
        return instance.group(C0679mC.f3718o.listOf().fieldOf("shots").forGetter((v0) -> {
            return v0.m3031u();
        }), Codec.BOOL.fieldOf("loop").forGetter((v0) -> {
            return v0.m3033aF();
        }), Codec.BOOL.fieldOf("showUI").forGetter((v0) -> {
            return v0.m3032aE();
        }), Codec.BOOL.fieldOf("allowSkip").forGetter((v0) -> {
            return v0.m3034aG();
        }), Codec.BOOL.fieldOf("fadeWhenFinished").forGetter((v0) -> {
            return v0.m3035aH();
        }), Codec.BOOL.optionalFieldOf("showPlayer", false).forGetter((v0) -> {
            return v0.m3036aI();
        })).apply(instance, (list, bool, bool2, bool3, bool4, bool5) -> {
            C0680mD c0680mD = new C0680mD();
            c0680mD.f3736U.addAll(list);
            c0680mD.f3737eC = bool.booleanValue();
            c0680mD.f3738eD = bool2.booleanValue();
            c0680mD.f3739eE = bool3.booleanValue();
            c0680mD.f3740eF = bool4.booleanValue();
            c0680mD.f3741eG = bool5.booleanValue();
            return c0680mD;
        });
    });

    /* JADX INFO: renamed from: U */
    private final ObjectList<C0679mC> f3736U = new ObjectArrayList();

    /* JADX INFO: renamed from: eC */
    private boolean f3737eC = false;

    /* JADX INFO: renamed from: eD */
    private boolean f3738eD = false;

    /* JADX INFO: renamed from: eE */
    private boolean f3739eE = false;

    /* JADX INFO: renamed from: eF */
    private boolean f3740eF = false;

    /* JADX INFO: renamed from: eG */
    private boolean f3741eG = false;

    /* JADX INFO: renamed from: a */
    public static a m3030a() {
        return new a();
    }

    /* JADX INFO: renamed from: u */
    public List<C0679mC> m3031u() {
        return this.f3736U;
    }

    /* JADX INFO: renamed from: aE */
    public boolean m3032aE() {
        return this.f3738eD;
    }

    /* JADX INFO: renamed from: aF */
    public boolean m3033aF() {
        return this.f3737eC;
    }

    /* JADX INFO: renamed from: aG */
    public boolean m3034aG() {
        return this.f3739eE;
    }

    /* JADX INFO: renamed from: aH */
    public boolean m3035aH() {
        return this.f3740eF;
    }

    /* JADX INFO: renamed from: aI */
    public boolean m3036aI() {
        return this.f3741eG;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C0680mD m3037a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        try {
            C0680mD c0680mD = new C0680mD();
            c0680mD.m3040b(registryFriendlyByteBuf);
            return c0680mD;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3038b(@NotNull ByteBuf byteBuf) throws IOException {
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            C0679mC c0679mC = new C0679mC();
            c0679mC.m3013b(byteBuf);
            this.f3736U.add(c0679mC);
        }
        this.f3737eC = IPacket.readBoolean(byteBuf);
        this.f3738eD = IPacket.readBoolean(byteBuf);
        this.f3739eE = IPacket.readBoolean(byteBuf);
        this.f3740eF = IPacket.readBoolean(byteBuf);
        this.f3741eG = IPacket.readBoolean(byteBuf);
    }

    /* JADX INFO: renamed from: c */
    public void m3039c(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeInt(this.f3736U.size());
        ObjectListIterator it = this.f3736U.iterator();
        while (it.hasNext()) {
            ((C0679mC) it.next()).m3014c(byteBuf);
        }
        IPacket.writeBoolean(byteBuf, this.f3737eC);
        IPacket.writeBoolean(byteBuf, this.f3738eD);
        IPacket.writeBoolean(byteBuf, this.f3739eE);
        IPacket.writeBoolean(byteBuf, this.f3740eF);
        IPacket.writeBoolean(byteBuf, this.f3741eG);
    }

    /* JADX INFO: renamed from: b */
    public void m3040b(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) throws IOException {
        int varInt = registryFriendlyByteBuf.readVarInt();
        for (int i = 0; i < varInt; i++) {
            C0679mC c0679mC = new C0679mC();
            c0679mC.m3009b(registryFriendlyByteBuf);
            this.f3736U.add(c0679mC);
        }
        this.f3737eC = registryFriendlyByteBuf.readBoolean();
        this.f3738eD = registryFriendlyByteBuf.readBoolean();
        this.f3739eE = registryFriendlyByteBuf.readBoolean();
        this.f3740eF = registryFriendlyByteBuf.readBoolean();
        this.f3741eG = registryFriendlyByteBuf.readBoolean();
    }

    /* JADX INFO: renamed from: a */
    public void m3041a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) throws IOException {
        registryFriendlyByteBuf.writeVarInt(this.f3736U.size());
        ObjectListIterator it = this.f3736U.iterator();
        while (it.hasNext()) {
            ((C0679mC) it.next()).m3010a(registryFriendlyByteBuf);
        }
        registryFriendlyByteBuf.writeBoolean(this.f3737eC);
        registryFriendlyByteBuf.writeBoolean(this.f3738eD);
        registryFriendlyByteBuf.writeBoolean(this.f3739eE);
        registryFriendlyByteBuf.writeBoolean(this.f3740eF);
        registryFriendlyByteBuf.writeBoolean(this.f3741eG);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.mD$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mD$a.class */
    public static class a {

        /* JADX INFO: renamed from: a */
        private final C0680mD f3742a = new C0680mD();

        /* JADX INFO: renamed from: a */
        public a m3044a(C0679mC c0679mC) {
            this.f3742a.f3736U.add(c0679mC);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m3045a(boolean z) {
            this.f3742a.f3738eD = z;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public a m3046b(boolean z) {
            this.f3742a.f3739eE = z;
            return this;
        }

        /* JADX INFO: renamed from: c */
        public a m3047c(boolean z) {
            this.f3742a.f3737eC = z;
            return this;
        }

        /* JADX INFO: renamed from: d */
        public a m3048d(boolean z) {
            this.f3742a.f3740eF = z;
            return this;
        }

        /* JADX INFO: renamed from: e */
        public a m3049e(boolean z) {
            this.f3742a.f3741eG = z;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0680mD m3050a() {
            return this.f3742a;
        }
    }
}
