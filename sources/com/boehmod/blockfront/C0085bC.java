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

/* JADX INFO: renamed from: com.boehmod.blockfront.bC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bC.class */
public final class C0085bC extends AbstractC0084bB {

    /* JADX INFO: renamed from: as */
    private static final Component f563as = Component.translatable("bf.message.inspect");

    /* JADX INFO: renamed from: at */
    private static final Component f564at = Component.translatable("bf.message.unequip");

    /* JADX INFO: renamed from: au */
    private static final Component f565au = Component.translatable("bf.message.equip");

    /* JADX INFO: renamed from: av */
    private static final Component f566av = Component.translatable("bf.message.showcase.add");

    /* JADX INFO: renamed from: aw */
    private static final Component f567aw = Component.translatable("bf.message.showcase.remove");

    /* JADX INFO: renamed from: ax */
    private static final Component f568ax = Component.translatable("bf.message.stickers");

    /* JADX INFO: renamed from: ay */
    private static final Component f569ay = Component.translatable("bf.message.delete");

    /* JADX INFO: renamed from: az */
    private static final Component f570az = Component.translatable("bf.screen.dropdown.item");

    /* JADX INFO: renamed from: aA */
    private static final Component f571aA = Component.translatable("bf.message.prompt.item.delete.title");

    /* JADX INFO: renamed from: aB */
    private static final Component f572aB = Component.translatable("bf.message.prompt.item.delete");

    public C0085bC(@NotNull Screen screen, @NotNull CloudItemStack cloudItemStack, int i, int i2, int i3, int i4) {
        super(screen, i, i2, i3, i4, f570az, cloudItemStack);
        CloudRegistry cloudRegistryA = this.f1586e.m2670a();
        C0477iN inventory = this.f1585a.m1676a(this.f1587b).getInventory();
        Component component = inventory.m2159a(cloudRegistryA, cloudItemStack) ? f564at : f565au;
        Component component2 = inventory.isItemShowcased(cloudItemStack.getUUID()) ? f567aw : f566av;
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(cloudRegistryA);
        if (cloudItem == null) {
            return;
        }
        m1173a(f563as);
        m1175a(component, cloudItem.canEquip());
        m1175a(component2, cloudItem.canShowcase());
        m1175a(f568ax, cloudItem.getItemType() == CloudItemType.GUN);
        m1175a(f569ay, !cloudItem.isDefault());
    }

    @Override // com.boehmod.blockfront.AbstractC0191ct
    /* JADX INFO: renamed from: g */
    public void mo286g(int i) {
        UUID uuid = this.f1585a.m1676a(this.f1587b).getUUID();
        C0357g c0357g = (C0357g) this.f1586e.m2667b();
        C0478iO c0478iOA = c0357g.m1716a();
        switch (i) {
            case 1:
                this.f1587b.setScreen(new C0239do(this.f562b));
                break;
            case 2:
                c0357g.sendPacket(new PacketInventorySetItemDefault(this.f562b.getUUID()));
                c0478iOA.m2165b(RequestType.PLAYER_INVENTORY_DEFAULTS, uuid);
                C0484iU.m2209a(this.f1587b, this.f1586e, this.f562b);
                break;
            case 3:
                c0357g.sendPacket(new PacketInventoryItemShowcase(this.f562b.getUUID()));
                c0478iOA.m2165b(RequestType.PLAYER_INVENTORY_SHOWCASE, uuid);
                C0484iU.m2209a(this.f1587b, this.f1586e, this.f562b);
                break;
            case 4:
                this.f1587b.setScreen(new C0240dp(this.f562b));
                break;
            case 5:
                C0218dT c0218dT = new C0218dT(this.f1556c, f571aA, z -> {
                    if (z) {
                        this.f1585a.m1676a(this.f1587b).getInventory().m2158a(this.f1586e, this.f562b);
                    }
                });
                c0218dT.m1273a(f572aB);
                this.f1587b.setScreen(c0218dT);
                break;
        }
    }
}
