package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.AbstractC0182b;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.xn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xn.class */
public class C1291xn {

    /* JADX INFO: renamed from: aK */
    private static final StreamCodec<RegistryFriendlyByteBuf, Holder<Item>> f8640aK;

    /* JADX INFO: renamed from: jD */
    static final /* synthetic */ boolean f8641jD;

    static {
        f8641jD = !C1291xn.class.desiredAssertionStatus();
        f8640aK = ByteBufCodecs.holderRegistry(Registries.ITEM);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ItemStack m7869a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        return registryFriendlyByteBuf.readBoolean() ? (ItemStack) ItemStack.STREAM_CODEC.decode(registryFriendlyByteBuf) : ItemStack.EMPTY;
    }

    /* JADX INFO: renamed from: a */
    public static void m7870a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, @NotNull ItemStack itemStack) {
        registryFriendlyByteBuf.writeBoolean(!itemStack.isEmpty());
        if (!itemStack.isEmpty()) {
            ItemStack.STREAM_CODEC.encode(registryFriendlyByteBuf, itemStack);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Holder<Item> m7871a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        return (Holder) f8640aK.decode(registryFriendlyByteBuf);
    }

    /* JADX INFO: renamed from: a */
    public static void m7872a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, @NotNull Holder<Item> holder) {
        f8640aK.encode(registryFriendlyByteBuf, holder);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static AbstractC0182b<?, ?, ?, ?> m7873a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f8641jD && abstractC0563juM168a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0182b<?, ?, ?, ?> abstractC0182bM1135b = abstractC0563juM168a.m2528a().m1135b(friendlyByteBuf.readUUID());
        abstractC0182bM1135b.m1083e(friendlyByteBuf);
        return abstractC0182bM1135b;
    }

    /* JADX INFO: renamed from: a */
    public static void m7874a(@NotNull FriendlyByteBuf friendlyByteBuf, @NotNull AbstractC0182b<?, ?, ?, ?> abstractC0182b) {
        friendlyByteBuf.writeUUID(abstractC0182b.getUUID());
        abstractC0182b.m1082b(friendlyByteBuf);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static Holder<SoundEvent> m7875b(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        return (Holder) SoundEvent.STREAM_CODEC.decode(registryFriendlyByteBuf);
    }

    /* JADX INFO: renamed from: b */
    public static void m7876b(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, @NotNull Holder<SoundEvent> holder) {
        SoundEvent.STREAM_CODEC.encode(registryFriendlyByteBuf, holder);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ObjectList<C1141uo> m7877a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        int i = friendlyByteBuf.readInt();
        ObjectArrayList objectArrayList = new ObjectArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            objectArrayList.add(C1141uo.m6277a(friendlyByteBuf));
        }
        return objectArrayList;
    }

    /* JADX INFO: renamed from: a */
    public static void m7878a(@NotNull FriendlyByteBuf friendlyByteBuf, @NotNull List<C1141uo> list) {
        friendlyByteBuf.writeInt(list.size());
        Iterator<C1141uo> it = list.iterator();
        while (it.hasNext()) {
            it.next().m6278a(friendlyByteBuf);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static ObjectList<C1142up> m7879b(@NotNull FriendlyByteBuf friendlyByteBuf) {
        int i = friendlyByteBuf.readInt();
        ObjectArrayList objectArrayList = new ObjectArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            objectArrayList.add(C1142up.m6282a(friendlyByteBuf));
        }
        return objectArrayList;
    }

    /* JADX INFO: renamed from: b */
    public static void m7880b(@NotNull FriendlyByteBuf friendlyByteBuf, @NotNull List<C1142up> list) {
        friendlyByteBuf.writeInt(list.size());
        Iterator<C1142up> it = list.iterator();
        while (it.hasNext()) {
            it.next().m6283a(friendlyByteBuf);
        }
    }
}
