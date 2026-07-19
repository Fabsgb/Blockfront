package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryItemStickerAdd;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryItemStickerRemove;
import com.boehmod.blockfront.C0048bs;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dp.class */
public class C0098dp extends C0080cx implements dI {
    private static final Component eR;
    private static final int gu = 3;
    public static final MutableComponent i;
    public static float dQ;
    public static float dR;
    private final CloudItemStack d;
    public int gv;
    private CloudItemStack e;
    private C0048bs g;
    private C0048bs h;
    private boolean bs;
    static final /* synthetic */ boolean bt;

    static {
        bt = !C0098dp.class.desiredAssertionStatus();
        eR = Component.translatable("bf.message.prompt.item.sticker.place.title");
        i = Component.translatable("bf.screen.armory.inspect");
        dQ = 0.0f;
        dR = 0.0f;
    }

    public C0098dp(@NotNull CloudItemStack cloudItemStack) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderS;
        super(i);
        this.gv = 0;
        this.e = null;
        this.g = null;
        this.h = null;
        this.bs = false;
        this.d = cloudItemStack;
        SoundManager soundManager = this.b.getSoundManager();
        CloudRegistry cloudRegistryA = this.e.a();
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(cloudRegistryA);
        if (!bt && cloudItem == null) {
            throw new AssertionError();
        }
        ItemStack itemStackA = iT.a(cloudItem, cloudItemStack);
        if (!itemStackA.isEmpty()) {
            Item item = itemStackA.getItem();
            if ((item instanceof C0558ur) && (deferredHolderS = ((C0558ur) item).m1221a(itemStackA).s()) != null) {
                soundManager.play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderS.get(), 1.0f, 1.0f));
            }
        }
        iV.a(this.b, cloudRegistryA, cloudItemStack);
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void tick() {
        super.tick();
        if (this.bs) {
            this.b.setScreen(new C0097dn());
            return;
        }
        boolean z = !this.a.m404a(this.b).getInventory().getItems(this.e.a(), CloudItemType.STICKER).isEmpty();
        boolean zHasSticker = this.d.hasSticker(this.gv);
        this.g.active = z;
        this.h.active = zHasSticker;
        this.g.a((Component) Component.translatable(z ? "bf.screen.armory.stickers.set.tooltip" : "bf.screen.armory.stickers.set.tooltip.inactive"));
        this.h.a((Component) Component.translatable(zHasSticker ? "bf.screen.armory.stickers.remove.tooltip" : "bf.screen.armory.stickers.remove.tooltip.inactive"));
    }

    @Override // com.boehmod.blockfront.C0080cx
    /* JADX INFO: renamed from: G */
    public void mo280G() {
        super.mo280G();
        addRenderableWidget(new C0048bs(1, 50, 20, 20, Component.literal("<"), button -> {
            this.gv--;
            if (this.gv < 0) {
                this.gv = 2;
            }
        }));
        C0048bs c0048bs = new C0048bs(21, 50, 25, 20, Component.literal("SET"), button2 -> {
            ac();
        });
        this.g = c0048bs;
        addRenderableWidget(c0048bs);
        C0048bs c0048bs2 = new C0048bs(46, 50, 45, 20, Component.literal("REMOVE"), button3 -> {
            ad();
        });
        this.h = c0048bs2;
        addRenderableWidget(c0048bs2);
        addRenderableWidget(new C0048bs(91, 50, 20, 20, Component.literal(">"), button4 -> {
            this.gv++;
            if (this.gv >= 3) {
                this.gv = 0;
            }
        }));
        addRenderableWidget(new C0048bs(5, 18, 20, 20, Component.empty(), button5 -> {
            this.b.setScreen(new C0097dn());
        }).a(aH).a(20, 20).a(C0048bs.a.NONE).a((Component) Component.translatable("bf.menu.button.back")));
    }

    private void ac() {
        ObjectList<CloudItemStack> items = this.a.m404a(this.b).getInventory().getItems(this.e.a(), CloudItemType.STICKER);
        if (!items.isEmpty()) {
            this.b.setScreen(new dK(this, items, 1));
        }
    }

    private void ad() {
        dT dTVar = new dT(this, Component.translatable("bf.message.prompt.item.sticker.remove.title"), z -> {
            if (z) {
                this.b.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, 1.0f));
                ((C0163g) this.e.b()).sendPacket(new PacketInventoryItemStickerRemove(this.d.getUUID(), this.gv));
            }
            this.bs = true;
        });
        dTVar.a((Component) Component.translatable("bf.message.prompt.item.sticker.remove"));
        this.b.setScreen(dTVar);
    }

    @Override // com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i2, int i3, float f) {
        super.render(guiGraphics, i2, i3, f);
        CloudRegistry cloudRegistryA = this.e.a();
        PoseStack poseStackPose = guiGraphics.pose();
        int i4 = this.width / 2;
        int i5 = this.height / 2;
        CloudItem<?> cloudItem = this.d.getCloudItem(cloudRegistryA);
        if (cloudItem == null) {
            return;
        }
        C0040bk.b(poseStackPose, guiGraphics, C0080cx.aJ, i4, i5, 200, 200);
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 150.0f);
        dQ = 25.0f * ((-0.5f) + (i3 / this.height));
        dR = 65.0f * ((-0.5f) + (i2 / this.width));
        C0245jb.a(cloudItem).a(cloudItem, this.d, this.b, poseStackPose, guiGraphics, this.width, this.height, i2, i3, f);
        poseStackPose.popPose();
        C0040bk.b(poseStackPose, this.font, guiGraphics, (Component) Component.literal(this.d.getDisplayName(cloudRegistryA)).withColor(cloudItem.getRarity().getColor()).withStyle(C0266jw.b), i4, this.height - 55, 1.5f);
    }

    public CloudItemStack b() {
        return this.d;
    }

    @Override // com.boehmod.blockfront.dI
    public void b(@NotNull List<CloudItemStack> list) {
        if (list.isEmpty()) {
            return;
        }
        this.e = (CloudItemStack) list.getFirst();
        CloudItem<?> cloudItem = this.e.getCloudItem(this.e.a());
        if (cloudItem == null) {
            return;
        }
        String suffix = cloudItem.getSuffix();
        dT dTVar = new dT(this, eR, z -> {
            if (z && this.e != null) {
                this.b.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, 1.0f));
                ((C0163g) this.e.b()).sendPacket(new PacketInventoryItemStickerAdd(this.d.getUUID(), this.e.getUUID(), this.gv));
            }
            this.e = null;
            this.bs = true;
        });
        dTVar.a((Component) Component.translatable("bf.message.prompt.item.sticker.place", new Object[]{Component.literal(suffix).withColor(cloudItem.getRarity().getColor())}));
        this.b.setScreen(dTVar);
    }
}
