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

/* JADX INFO: renamed from: com.boehmod.blockfront.bL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bL.class */
public final class C0095bL extends AbstractC0094bK {

    /* JADX INFO: renamed from: as */
    private static final Component f632as = Component.translatable("bf.message.inspect");

    /* JADX INFO: renamed from: at */
    private static final Component f633at = Component.translatable("bf.message.unequip");

    /* JADX INFO: renamed from: au */
    private static final Component f634au = Component.translatable("bf.message.equip");

    /* JADX INFO: renamed from: av */
    private static final Component f635av = Component.translatable("bf.message.showcase.add");

    /* JADX INFO: renamed from: aw */
    private static final Component f636aw = Component.translatable("bf.message.showcase.remove");

    /* JADX INFO: renamed from: ax */
    private static final Component f637ax = Component.translatable("bf.message.stickers");

    /* JADX INFO: renamed from: ay */
    private static final Component f638ay = Component.translatable("bf.message.delete");

    /* JADX INFO: renamed from: az */
    private static final Component f639az = Component.translatable("bf.screen.dropdown.item");

    /* JADX INFO: renamed from: aA */
    private static final Component f640aA = Component.translatable("bf.message.prompt.item.delete.title");

    /* JADX INFO: renamed from: aB */
    private static final Component f641aB = Component.translatable("bf.message.prompt.item.delete");

    public C0095bL(@NotNull Screen screen, @NotNull CloudItemStack cloudItemStack, int i, int i2, int i3, int i4) {
        super(screen, i, i2, i3, i4, f639az, cloudItemStack);
        CloudRegistry cloudRegistryA = this.f1057f.m2855a();
        C0550jg inventory = this.f1056a.m1886a(this.f1058a).getInventory();
        Component component = inventory.m2486a(cloudRegistryA, cloudItemStack) ? f633at : f634au;
        Component component2 = inventory.isItemShowcased(cloudItemStack.getUUID()) ? f636aw : f635av;
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(cloudRegistryA);
        if (cloudItem == null) {
            return;
        }
        m770a(f632as);
        m772a(component, cloudItem.canEquip());
        m772a(component2, cloudItem.canShowcase());
        m772a(f637ax, cloudItem.getItemType() == CloudItemType.GUN);
        m772a(f638ay, !cloudItem.isDefault());
    }

    @Override // com.boehmod.blockfront.AbstractC0139cC
    /* JADX INFO: renamed from: g */
    public void mo390g(int i) {
        UUID uuid = this.f1056a.m1886a(this.f1058a).getUUID();
        C0358g c0358g = (C0358g) this.f1057f.m2852b();
        C0551jh c0551jhA = c0358g.m1722a();
        switch (i) {
            case 1:
                this.f1058a.setScreen(new C0249dx(this.f631b));
                break;
            case 2:
                c0358g.sendPacket(new PacketInventorySetItemDefault(this.f631b.getUUID()));
                c0551jhA.m2492b(RequestType.PLAYER_INVENTORY_DEFAULTS, uuid);
                C0557jn.m2536a(this.f1058a, this.f1057f, this.f631b);
                break;
            case 3:
                c0358g.sendPacket(new PacketInventoryItemShowcase(this.f631b.getUUID()));
                c0551jhA.m2492b(RequestType.PLAYER_INVENTORY_SHOWCASE, uuid);
                C0557jn.m2536a(this.f1058a, this.f1057f, this.f631b);
                break;
            case 4:
                this.f1058a.setScreen(new C0250dy(this.f631b));
                break;
            case 5:
                C0283ee c0283ee = new C0283ee(this.f1035c, f640aA, z -> {
                    if (z) {
                        this.f1056a.m1886a(this.f1058a).getInventory().m2485a(this.f1057f, this.f631b);
                    }
                });
                c0283ee.m1324a(f641aB);
                this.f1058a.setScreen(c0283ee);
                break;
        }
    }
}
