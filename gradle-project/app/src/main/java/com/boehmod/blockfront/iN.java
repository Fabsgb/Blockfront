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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iN.class */
public final class iN extends AbstractCloudInventory<iS> {

    @NotNull
    private final Queue<UUID> b;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    static final /* synthetic */ boolean f170do;

    static {
        f170do = !iN.class.desiredAssertionStatus();
    }

    public iN(@NotNull iS iSVar) {
        super(iSVar);
        this.b = new LinkedList();
    }

    @NotNull
    public List<UUID> n() {
        return this.b.stream().toList();
    }

    public void e(@NotNull List<UUID> list) {
        this.b.clear();
        this.b.addAll(list);
    }

    @NotNull
    public Optional<UUID> a() {
        return Optional.ofNullable(this.b.poll());
    }

    public void aW() {
        this.b.clear();
    }

    @Override // com.boehmod.bflib.cloud.common.player.AbstractCloudInventory
    public void addItemStackLocal(@NotNull CloudItemStack cloudItemStack) {
        super.addItemStackLocal(cloudItemStack);
        AbstractC0264ju<?, ?, ?> abstractC0264juM166a = C0002a.a().m166a();
        if (!f170do && abstractC0264juM166a == null) {
            throw new AssertionError("Manager is null!");
        }
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(abstractC0264juM166a.m537a());
        if (cloudItem != null && !cloudItem.isDefault()) {
            this.b.add(cloudItemStack.getUUID());
        }
    }

    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull CloudItemStack cloudItemStack) {
        CloudRegistry cloudRegistryM537a = abstractC0264ju.m537a();
        UUID uuid = cloudItemStack.getUUID();
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(cloudRegistryM537a);
        if (cloudItem != null && !cloudItem.isDefault()) {
            removeItemStackLocal(uuid);
            abstractC0264ju.m529b().sendPacket(new PacketInventoryItemDeleteRequest(uuid));
        }
    }

    public boolean a(@NotNull CloudRegistry cloudRegistry, @NotNull CloudItemStack cloudItemStack) {
        CloudItemStack cloudItemStackA;
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(cloudRegistry);
        if (cloudItem != null && (cloudItemStackA = a(cloudRegistry, cloudItem.getMinecraftItem())) != null) {
            return cloudItemStackA.equals(cloudItemStack);
        }
        return false;
    }

    @Nullable
    public CloudItemStack a(@NotNull CloudItemType cloudItemType) {
        return a(cloudItemType, (String) null);
    }

    @Nullable
    public CloudItemStack a(@NotNull CloudItemType cloudItemType, @Nullable String str) {
        UUID stack = getEquippedItems(cloudItemType).getStack(str);
        if (stack == null) {
            return null;
        }
        return getStackFromUUID(stack).orElse(null);
    }

    @Nullable
    public CloudItemStack a(@NotNull CloudRegistry cloudRegistry, @NotNull CloudResourceLocation cloudResourceLocation) {
        UUID stack;
        CloudItem<?> cloudItemFromMcItem = CloudItem.getCloudItemFromMcItem(cloudRegistry, cloudResourceLocation);
        if (cloudItemFromMcItem != null && (stack = getEquippedItems(cloudItemFromMcItem.getItemType()).getStack(cloudResourceLocation)) != null) {
            return getStackFromUUID(stack).orElse(null);
        }
        return null;
    }
}
