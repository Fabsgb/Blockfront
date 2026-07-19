package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryItemShowcase;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventorySetItemDefault;
import java.util.UUID;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bC.class */
public final class bC extends bB {
    private static final Component as = Component.translatable("bf.message.inspect");
    private static final Component at = Component.translatable("bf.message.unequip");
    private static final Component au = Component.translatable("bf.message.equip");
    private static final Component av = Component.translatable("bf.message.showcase.add");
    private static final Component aw = Component.translatable("bf.message.showcase.remove");
    private static final Component ax = Component.translatable("bf.message.stickers");
    private static final Component ay = Component.translatable("bf.message.delete");
    private static final Component az = Component.translatable("bf.screen.dropdown.item");
    private static final Component aA = Component.translatable("bf.message.prompt.item.delete.title");
    private static final Component aB = Component.translatable("bf.message.prompt.item.delete");

    public bC(@NotNull Screen screen, @NotNull CloudItemStack cloudItemStack, int i, int i2, int i3, int i4) {
        super(screen, i, i2, i3, i4, az, cloudItemStack);
        CloudRegistry cloudRegistryA = this.e.a();
        iN inventory = this.a.m404a(this.b).getInventory();
        Component component = inventory.a(cloudRegistryA, cloudItemStack) ? at : au;
        Component component2 = inventory.isItemShowcased(cloudItemStack.getUUID()) ? aw : av;
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(cloudRegistryA);
        if (cloudItem == null) {
            return;
        }
        a(as);
        a(component, cloudItem.canEquip());
        a(component2, cloudItem.canShowcase());
        a(ax, cloudItem.getItemType() == CloudItemType.GUN);
        a(ay, !cloudItem.isDefault());
    }

    @Override // com.boehmod.blockfront.AbstractC0076ct
    public void g(int i) {
        UUID uuid = this.a.m404a(this.b).getUUID();
        C0163g c0163g = (C0163g) this.e.b();
        iO iOVarA = c0163g.a();
        switch (i) {
            case 1:
                this.b.setScreen(new Cdo(this.b));
                break;
            case 2:
                c0163g.sendPacket(new PacketInventorySetItemDefault(this.b.getUUID()));
                iOVarA.b(RequestType.PLAYER_INVENTORY_DEFAULTS, uuid);
                iU.a(this.b, this.e, this.b);
                break;
            case 3:
                c0163g.sendPacket(new PacketInventoryItemShowcase(this.b.getUUID()));
                iOVarA.b(RequestType.PLAYER_INVENTORY_SHOWCASE, uuid);
                iU.a(this.b, this.e, this.b);
                break;
            case 4:
                this.b.setScreen(new C0098dp(this.b));
                break;
            case 5:
                dT dTVar = new dT(this.c, aA, z -> {
                    if (z) {
                        this.a.m404a(this.b).getInventory().a(this.e, this.b);
                    }
                });
                dTVar.a(aB);
                this.b.setScreen(dTVar);
                break;
        }
    }
}
