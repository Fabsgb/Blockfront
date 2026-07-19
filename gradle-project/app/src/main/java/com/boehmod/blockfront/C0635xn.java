package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xn.class */
public class C0635xn {
    private static final StreamCodec<RegistryFriendlyByteBuf, Holder<Item>> aK;
    static final /* synthetic */ boolean jD;

    static {
        jD = !C0635xn.class.desiredAssertionStatus();
        aK = ByteBufCodecs.holderRegistry(Registries.ITEM);
    }

    @NotNull
    public static ItemStack a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        return registryFriendlyByteBuf.readBoolean() ? (ItemStack) ItemStack.STREAM_CODEC.decode(registryFriendlyByteBuf) : ItemStack.EMPTY;
    }

    public static void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, @NotNull ItemStack itemStack) {
        registryFriendlyByteBuf.writeBoolean(!itemStack.isEmpty());
        if (!itemStack.isEmpty()) {
            ItemStack.STREAM_CODEC.encode(registryFriendlyByteBuf, itemStack);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Holder<Item> m1693a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        return (Holder) aK.decode(registryFriendlyByteBuf);
    }

    public static void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, @NotNull Holder<Item> holder) {
        aK.encode(registryFriendlyByteBuf, holder);
    }

    @NotNull
    public static com.boehmod.blockfront.common.player.b<?, ?, ?, ?> a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!jD && abstractC0264juM166a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        com.boehmod.blockfront.common.player.b<?, ?, ?, ?> bVarB = abstractC0264juM166a.m531a().b(friendlyByteBuf.readUUID());
        bVarB.e(friendlyByteBuf);
        return bVarB;
    }

    public static void a(@NotNull FriendlyByteBuf friendlyByteBuf, @NotNull com.boehmod.blockfront.common.player.b<?, ?, ?, ?> bVar) {
        friendlyByteBuf.writeUUID(bVar.getUUID());
        bVar.b(friendlyByteBuf);
    }

    @NotNull
    public static Holder<SoundEvent> b(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        return (Holder) SoundEvent.STREAM_CODEC.decode(registryFriendlyByteBuf);
    }

    public static void b(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, @NotNull Holder<SoundEvent> holder) {
        SoundEvent.STREAM_CODEC.encode(registryFriendlyByteBuf, holder);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static ObjectList<C0555uo> m1694a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        int i = friendlyByteBuf.readInt();
        ObjectArrayList objectArrayList = new ObjectArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            objectArrayList.add(C0555uo.a(friendlyByteBuf));
        }
        return objectArrayList;
    }

    public static void a(@NotNull FriendlyByteBuf friendlyByteBuf, @NotNull List<C0555uo> list) {
        friendlyByteBuf.writeInt(list.size());
        Iterator<C0555uo> it = list.iterator();
        while (it.hasNext()) {
            it.next().m1194a(friendlyByteBuf);
        }
    }

    @NotNull
    public static ObjectList<C0556up> b(@NotNull FriendlyByteBuf friendlyByteBuf) {
        int i = friendlyByteBuf.readInt();
        ObjectArrayList objectArrayList = new ObjectArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            objectArrayList.add(C0556up.a(friendlyByteBuf));
        }
        return objectArrayList;
    }

    public static void b(@NotNull FriendlyByteBuf friendlyByteBuf, @NotNull List<C0556up> list) {
        friendlyByteBuf.writeInt(list.size());
        Iterator<C0556up> it = list.iterator();
        while (it.hasNext()) {
            it.next().m1195a(friendlyByteBuf);
        }
    }
}
