package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.ArrayDeque;
import java.util.Collection;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hU.class */
public class hU {

    @NotNull
    private final ObjectList<a> C = new ObjectArrayList();

    private hU() {
    }

    @NotNull
    public static hU a() {
        return new hU();
    }

    public hU a(@NotNull uW uWVar) {
        this.C.add(new a(uWVar, false, false, 0));
        return this;
    }

    public hU b(@NotNull uW uWVar) {
        this.C.add(new a(uWVar, false, true, 0));
        return this;
    }

    public hU c(@NotNull uW uWVar) {
        this.C.add(new a(uWVar, true, false, 0));
        return this;
    }

    public hU d(@NotNull uW uWVar) {
        this.C.add(new a(uWVar, true, true, 0));
        return this;
    }

    public hU a(int i) {
        this.C.add(new a(null, false, false, i * 20));
        return this;
    }

    public void a(@NotNull hT hTVar, @NotNull Minecraft minecraft) {
        hTVar.a(new ArrayDeque((Collection) this.C));
        hTVar.t(minecraft);
    }

    public void c(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.C.size());
        ObjectListIterator it = this.C.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            friendlyByteBuf.writeBoolean(aVar.a != null);
            if (aVar.a != null) {
                friendlyByteBuf.writeInt(aVar.a.ordinal());
            }
            friendlyByteBuf.writeBoolean(aVar.cL);
            friendlyByteBuf.writeBoolean(aVar.cM);
            friendlyByteBuf.writeInt(aVar.jq);
        }
    }

    @NotNull
    public static hU a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        hU hUVar = new hU();
        int i = friendlyByteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            hUVar.C.add(new a(friendlyByteBuf.readBoolean() ? uW.values()[friendlyByteBuf.readInt()] : null, friendlyByteBuf.readBoolean(), friendlyByteBuf.readBoolean(), friendlyByteBuf.readInt()));
        }
        return hUVar;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hU$a.class */
    public static class a {

        @Nullable
        public final uW a;
        public final boolean cL;
        public final boolean cM;
        public final int jq;

        a(@Nullable uW uWVar, boolean z, boolean z2, int i) {
            this.a = uWVar;
            this.cL = z;
            this.cM = z2;
            this.jq = i;
        }
    }
}
