package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import com.boehmod.bflib.cloud.common.item.CloudResourceLocation;
import com.boehmod.bflib.cloud.common.player.AbstractCloudInventory;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryItemDeleteRequest;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.UUID;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jg */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jg.class */
public final class C0550jg extends AbstractCloudInventory<C0555jl> {

    /* JADX INFO: renamed from: b */
    @NotNull
    private final Queue<UUID> f3278b;

    /* JADX INFO: renamed from: dz */
    static final /* synthetic */ boolean f3279dz;

    static {
        f3279dz = !C0550jg.class.desiredAssertionStatus();
    }

    public C0550jg(@NotNull C0555jl c0555jl) {
        super(c0555jl);
        this.f3278b = new LinkedList();
    }

    @NotNull
    /* JADX INFO: renamed from: p */
    public List<UUID> m2481p() {
        return this.f3278b.stream().toList();
    }

    /* JADX INFO: renamed from: f */
    public void m2482f(@NotNull List<UUID> list) {
        this.f3278b.clear();
        this.f3278b.addAll(list);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Optional<UUID> m2483a() {
        return Optional.ofNullable(this.f3278b.poll());
    }

    /* JADX INFO: renamed from: bi */
    public void m2484bi() {
        this.f3278b.clear();
    }

    @Override // com.boehmod.bflib.cloud.common.player.AbstractCloudInventory
    public void addItemStackLocal(@NotNull CloudItemStack cloudItemStack) {
        super.addItemStackLocal(cloudItemStack);
        AbstractC0531jN<?, ?, ?> abstractC0531jNM179a = C0030a.m175a().m179a();
        if (!f3279dz && abstractC0531jNM179a == null) {
            throw new AssertionError("Manager is null!");
        }
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(abstractC0531jNM179a.m2373a());
        if (cloudItem != null && !cloudItem.isDefault()) {
            this.f3278b.add(cloudItemStack.getUUID());
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2485a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull CloudItemStack cloudItemStack) {
        CloudRegistry cloudRegistryM2373a = abstractC0531jN.m2373a();
        UUID uuid = cloudItemStack.getUUID();
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(cloudRegistryM2373a);
        if (cloudItem != null && !cloudItem.isDefault()) {
            removeItemStackLocal(uuid);
            abstractC0531jN.m2342b().sendPacket(new PacketInventoryItemDeleteRequest(uuid));
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m2486a(@NotNull CloudRegistry cloudRegistry, @NotNull CloudItemStack cloudItemStack) {
        CloudItemStack cloudItemStackM2489a;
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(cloudRegistry);
        if (cloudItem != null && (cloudItemStackM2489a = m2489a(cloudRegistry, cloudItem.getMinecraftItem())) != null) {
            return cloudItemStackM2489a.equals(cloudItemStack);
        }
        return false;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public CloudItemStack m2487a(@NotNull CloudItemType cloudItemType) {
        return m2488a(cloudItemType, (String) null);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public CloudItemStack m2488a(@NotNull CloudItemType cloudItemType, @Nullable String str) {
        UUID stack = getEquippedItems(cloudItemType).getStack(str);
        if (stack == null) {
            return null;
        }
        return getStackFromUUID(stack).orElse(null);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public CloudItemStack m2489a(@NotNull CloudRegistry cloudRegistry, @NotNull CloudResourceLocation cloudResourceLocation) {
        UUID stack;
        CloudItem<?> cloudItemFromMcItem = CloudItem.getCloudItemFromMcItem(cloudRegistry, cloudResourceLocation);
        if (cloudItemFromMcItem != null && (stack = getEquippedItems(cloudItemFromMcItem.getItemType()).getStack(cloudResourceLocation)) != null) {
            return getStackFromUUID(stack).orElse(null);
        }
        return null;
    }
}
