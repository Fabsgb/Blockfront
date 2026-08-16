package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.blockfront.common.player.AbstractC0183b;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.xK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xK.class */
public class C1271xK {

    /* JADX INFO: renamed from: aH */
    @NotNull
    private static final StreamCodec<RegistryFriendlyByteBuf, Holder<Item>> f6837aH;

    /* JADX INFO: renamed from: jT */
    static final /* synthetic */ boolean f6838jT;

    static {
        f6838jT = !C1271xK.class.desiredAssertionStatus();
        f6837aH = ByteBufCodecs.holderRegistry(Registries.ITEM);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ItemStack m7196a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        return registryFriendlyByteBuf.readBoolean() ? (ItemStack) ItemStack.STREAM_CODEC.decode(registryFriendlyByteBuf) : ItemStack.EMPTY;
    }

    /* JADX INFO: renamed from: a */
    public static void m7197a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, @NotNull ItemStack itemStack) {
        registryFriendlyByteBuf.writeBoolean(!itemStack.isEmpty());
        if (!itemStack.isEmpty()) {
            ItemStack.STREAM_CODEC.encode(registryFriendlyByteBuf, itemStack);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static Holder<Item> m7198a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        return (Holder) f6837aH.decode(registryFriendlyByteBuf);
    }

    /* JADX INFO: renamed from: a */
    public static void m7199a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, @NotNull Holder<Item> holder) {
        f6837aH.encode(registryFriendlyByteBuf, holder);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static AbstractC0183b<?, ?, ?, ?> m7200a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f6838jT && abstractC0531jNM179a == null) {
            throw new AssertionError("Mod manager is null!");
        }
        AbstractC0183b<?, ?, ?, ?> abstractC0183bM1152b = abstractC0531jNM179a.m2351a().m1152b(friendlyByteBuf.readUUID());
        abstractC0183bM1152b.m1100e(friendlyByteBuf);
        return abstractC0183bM1152b;
    }

    /* JADX INFO: renamed from: a */
    public static void m7201a(@NotNull FriendlyByteBuf friendlyByteBuf, @NotNull AbstractC0183b<?, ?, ?, ?> abstractC0183b) {
        friendlyByteBuf.writeUUID(abstractC0183b.getUUID());
        abstractC0183b.m1099b(friendlyByteBuf);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static Holder<SoundEvent> m7202b(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        return (Holder) SoundEvent.STREAM_CODEC.decode(registryFriendlyByteBuf);
    }

    /* JADX INFO: renamed from: b */
    public static void m7203b(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, @NotNull Holder<SoundEvent> holder) {
        SoundEvent.STREAM_CODEC.encode(registryFriendlyByteBuf, holder);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ObjectList<C1114uM> m7204a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        int size = IPacket.readSize(friendlyByteBuf);
        ObjectArrayList objectArrayList = new ObjectArrayList(IPacket.presize(size));
        for (int i = 0; i < size; i++) {
            objectArrayList.add(C1114uM.m6241a(friendlyByteBuf));
        }
        return objectArrayList;
    }

    /* JADX INFO: renamed from: a */
    public static void m7205a(@NotNull FriendlyByteBuf friendlyByteBuf, @NotNull List<C1114uM> list) {
        friendlyByteBuf.writeInt(list.size());
        Iterator<C1114uM> it = list.iterator();
        while (it.hasNext()) {
            it.next().m6242a(friendlyByteBuf);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static ObjectList<C1115uN> m7206b(@NotNull FriendlyByteBuf friendlyByteBuf) {
        int size = IPacket.readSize(friendlyByteBuf);
        ObjectArrayList objectArrayList = new ObjectArrayList(IPacket.presize(size));
        for (int i = 0; i < size; i++) {
            objectArrayList.add(C1115uN.m6246a(friendlyByteBuf));
        }
        return objectArrayList;
    }

    /* JADX INFO: renamed from: b */
    public static void m7207b(@NotNull FriendlyByteBuf friendlyByteBuf, @NotNull List<C1115uN> list) {
        friendlyByteBuf.writeInt(list.size());
        Iterator<C1115uN> it = list.iterator();
        while (it.hasNext()) {
            it.next().m6247a(friendlyByteBuf);
        }
    }
}
