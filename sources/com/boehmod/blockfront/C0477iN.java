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

/* JADX INFO: renamed from: com.boehmod.blockfront.iN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iN.class */
public final class C0477iN extends AbstractCloudInventory<C0482iS> {

    /* JADX INFO: renamed from: b */
    @NotNull
    private final Queue<UUID> f2927b;

    /* JADX INFO: renamed from: do */
    static final /* synthetic */ boolean f2928do;

    static {
        f2928do = !C0477iN.class.desiredAssertionStatus();
    }

    public C0477iN(@NotNull C0482iS c0482iS) {
        super(c0482iS);
        this.f2927b = new LinkedList();
    }

    @NotNull
    /* JADX INFO: renamed from: n */
    public List<UUID> m2154n() {
        return this.f2927b.stream().toList();
    }

    /* JADX INFO: renamed from: e */
    public void m2155e(@NotNull List<UUID> list) {
        this.f2927b.clear();
        this.f2927b.addAll(list);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Optional<UUID> m2156a() {
        return Optional.ofNullable(this.f2927b.poll());
    }

    /* JADX INFO: renamed from: aW */
    public void m2157aW() {
        this.f2927b.clear();
    }

    @Override // com.boehmod.bflib.cloud.common.player.AbstractCloudInventory
    public void addItemStackLocal(@NotNull CloudItemStack cloudItemStack) {
        super.addItemStackLocal(cloudItemStack);
        AbstractC0563ju<?, ?, ?> abstractC0563juM168a = C0029a.m164a().m168a();
        if (!f2928do && abstractC0563juM168a == null) {
            throw new AssertionError("Manager is null!");
        }
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(abstractC0563juM168a.m2550a());
        if (cloudItem != null && !cloudItem.isDefault()) {
            this.f2927b.add(cloudItemStack.getUUID());
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2158a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull CloudItemStack cloudItemStack) {
        CloudRegistry cloudRegistryM2550a = abstractC0563ju.m2550a();
        UUID uuid = cloudItemStack.getUUID();
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(cloudRegistryM2550a);
        if (cloudItem != null && !cloudItem.isDefault()) {
            removeItemStackLocal(uuid);
            abstractC0563ju.m2520b().sendPacket(new PacketInventoryItemDeleteRequest(uuid));
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m2159a(@NotNull CloudRegistry cloudRegistry, @NotNull CloudItemStack cloudItemStack) {
        CloudItemStack cloudItemStackM2162a;
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(cloudRegistry);
        if (cloudItem != null && (cloudItemStackM2162a = m2162a(cloudRegistry, cloudItem.getMinecraftItem())) != null) {
            return cloudItemStackM2162a.equals(cloudItemStack);
        }
        return false;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public CloudItemStack m2160a(@NotNull CloudItemType cloudItemType) {
        return m2161a(cloudItemType, (String) null);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public CloudItemStack m2161a(@NotNull CloudItemType cloudItemType, @Nullable String str) {
        UUID stack = getEquippedItems(cloudItemType).getStack(str);
        if (stack == null) {
            return null;
        }
        return getStackFromUUID(stack).orElse(null);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public CloudItemStack m2162a(@NotNull CloudRegistry cloudRegistry, @NotNull CloudResourceLocation cloudResourceLocation) {
        UUID stack;
        CloudItem<?> cloudItemFromMcItem = CloudItem.getCloudItemFromMcItem(cloudRegistry, cloudResourceLocation);
        if (cloudItemFromMcItem != null && (stack = getEquippedItems(cloudItemFromMcItem.getItemType()).getStack(cloudResourceLocation)) != null) {
            return getStackFromUUID(stack).orElse(null);
        }
        return null;
    }
}
