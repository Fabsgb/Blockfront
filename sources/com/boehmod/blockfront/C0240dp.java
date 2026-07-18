package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryItemStickerAdd;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryItemStickerRemove;
import com.boehmod.blockfront.C0127bs;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.dp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dp.class */
public class C0240dp extends C0195cx implements InterfaceC0207dI {

    /* JADX INFO: renamed from: eR */
    private static final Component f1988eR;

    /* JADX INFO: renamed from: gu */
    private static final int f1989gu = 3;

    /* JADX INFO: renamed from: i */
    public static final MutableComponent f1990i;

    /* JADX INFO: renamed from: dQ */
    public static float f1991dQ;

    /* JADX INFO: renamed from: dR */
    public static float f1992dR;

    /* JADX INFO: renamed from: d */
    private final CloudItemStack f1993d;

    /* JADX INFO: renamed from: gv */
    public int f1994gv;

    /* JADX INFO: renamed from: e */
    private CloudItemStack f1995e;

    /* JADX INFO: renamed from: g */
    private C0127bs f1996g;

    /* JADX INFO: renamed from: h */
    private C0127bs f1997h;

    /* JADX INFO: renamed from: bs */
    private boolean f1998bs;

    /* JADX INFO: renamed from: bt */
    static final /* synthetic */ boolean f1999bt;

    static {
        f1999bt = !C0240dp.class.desiredAssertionStatus();
        f1988eR = Component.translatable("bf.message.prompt.item.sticker.place.title");
        f1990i = Component.translatable("bf.screen.armory.inspect");
        f1991dQ = 0.0f;
        f1992dR = 0.0f;
    }

    public C0240dp(@NotNull CloudItemStack cloudItemStack) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6155s;
        super(f1990i);
        this.f1994gv = 0;
        this.f1995e = null;
        this.f1996g = null;
        this.f1997h = null;
        this.f1998bs = false;
        this.f1993d = cloudItemStack;
        SoundManager soundManager = this.f1587b.getSoundManager();
        CloudRegistry cloudRegistryA = this.f1586e.m2670a();
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(cloudRegistryA);
        if (!f1999bt && cloudItem == null) {
            throw new AssertionError();
        }
        ItemStack itemStackM2203a = C0483iT.m2203a(cloudItem, cloudItemStack);
        if (!itemStackM2203a.isEmpty()) {
            Item item = itemStackM2203a.getItem();
            if ((item instanceof C1144ur) && (deferredHolderM6155s = ((C1144ur) item).m6408a(itemStackM2203a).m6155s()) != null) {
                soundManager.play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6155s.get(), 1.0f, 1.0f));
            }
        }
        C0485iV.m2210a(this.f1587b, cloudRegistryA, cloudItemStack);
    }

    @Override // com.boehmod.blockfront.C0195cx
    public void tick() {
        super.tick();
        if (this.f1998bs) {
            this.f1587b.setScreen(new C0238dn());
            return;
        }
        boolean z = !this.f1585a.m1676a(this.f1587b).getInventory().getItems(this.f1586e.m2670a(), CloudItemType.STICKER).isEmpty();
        boolean zHasSticker = this.f1993d.hasSticker(this.f1994gv);
        this.f1996g.active = z;
        this.f1997h.active = zHasSticker;
        this.f1996g.m651a((Component) Component.translatable(z ? "bf.screen.armory.stickers.set.tooltip" : "bf.screen.armory.stickers.set.tooltip.inactive"));
        this.f1997h.m651a((Component) Component.translatable(zHasSticker ? "bf.screen.armory.stickers.remove.tooltip" : "bf.screen.armory.stickers.remove.tooltip.inactive"));
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: G */
    public void mo744G() {
        super.mo744G();
        addRenderableWidget(new C0127bs(1, 50, 20, 20, Component.literal("<"), button -> {
            this.f1994gv--;
            if (this.f1994gv < 0) {
                this.f1994gv = 2;
            }
        }));
        C0127bs c0127bs = new C0127bs(21, 50, 25, 20, Component.literal("SET"), button2 -> {
            m1396ac();
        });
        this.f1996g = c0127bs;
        addRenderableWidget(c0127bs);
        C0127bs c0127bs2 = new C0127bs(46, 50, 45, 20, Component.literal("REMOVE"), button3 -> {
            m1397ad();
        });
        this.f1997h = c0127bs2;
        addRenderableWidget(c0127bs2);
        addRenderableWidget(new C0127bs(91, 50, 20, 20, Component.literal(">"), button4 -> {
            this.f1994gv++;
            if (this.f1994gv >= 3) {
                this.f1994gv = 0;
            }
        }));
        addRenderableWidget(new C0127bs(5, 18, 20, 20, Component.empty(), button5 -> {
            this.f1587b.setScreen(new C0238dn());
        }).m645a(f1564aH).m647a(20, 20).m653a(C0127bs.a.NONE).m651a((Component) Component.translatable("bf.menu.button.back")));
    }

    /* JADX INFO: renamed from: ac */
    private void m1396ac() {
        ObjectList<CloudItemStack> items = this.f1585a.m1676a(this.f1587b).getInventory().getItems(this.f1586e.m2670a(), CloudItemType.STICKER);
        if (!items.isEmpty()) {
            this.f1587b.setScreen(new C0209dK(this, items, 1));
        }
    }

    /* JADX INFO: renamed from: ad */
    private void m1397ad() {
        C0218dT c0218dT = new C0218dT(this, Component.translatable("bf.message.prompt.item.sticker.remove.title"), z -> {
            if (z) {
                this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, 1.0f));
                ((C0357g) this.f1586e.m2667b()).sendPacket(new PacketInventoryItemStickerRemove(this.f1993d.getUUID(), this.f1994gv));
            }
            this.f1998bs = true;
        });
        c0218dT.m1273a((Component) Component.translatable("bf.message.prompt.item.sticker.remove"));
        this.f1587b.setScreen(c0218dT);
    }

    @Override // com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        CloudRegistry cloudRegistryA = this.f1586e.m2670a();
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        CloudItem<?> cloudItem = this.f1993d.getCloudItem(cloudRegistryA);
        if (cloudItem == null) {
            return;
        }
        C0119bk.m441b(poseStackPose, guiGraphics, C0195cx.f1566aJ, i3, i4, 200, 200);
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 150.0f);
        f1991dQ = 25.0f * ((-0.5f) + (i2 / this.height));
        f1992dR = 65.0f * ((-0.5f) + (i / this.width));
        C0544jb.m2468a(cloudItem).mo2228a(cloudItem, this.f1993d, this.f1587b, poseStackPose, guiGraphics, this.width, this.height, i, i2, f);
        poseStackPose.popPose();
        C0119bk.m391b(poseStackPose, this.font, guiGraphics, (Component) Component.literal(this.f1993d.getDisplayName(cloudRegistryA)).withColor(cloudItem.getRarity().getColor()).withStyle(C0565jw.f3201b), i3, this.height - 55, 1.5f);
    }

    /* JADX INFO: renamed from: b */
    public CloudItemStack m1398b() {
        return this.f1993d;
    }

    @Override // com.boehmod.blockfront.InterfaceC0207dI
    /* JADX INFO: renamed from: b */
    public void mo1262b(@NotNull List<CloudItemStack> list) {
        if (list.isEmpty()) {
            return;
        }
        this.f1995e = (CloudItemStack) list.getFirst();
        CloudItem<?> cloudItem = this.f1995e.getCloudItem(this.f1586e.m2670a());
        if (cloudItem == null) {
            return;
        }
        String suffix = cloudItem.getSuffix();
        C0218dT c0218dT = new C0218dT(this, f1988eR, z -> {
            if (z && this.f1995e != null) {
                this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, 1.0f));
                ((C0357g) this.f1586e.m2667b()).sendPacket(new PacketInventoryItemStickerAdd(this.f1993d.getUUID(), this.f1995e.getUUID(), this.f1994gv));
            }
            this.f1995e = null;
            this.f1998bs = true;
        });
        c0218dT.m1273a((Component) Component.translatable("bf.message.prompt.item.sticker.place", new Object[]{Component.literal(suffix).withColor(cloudItem.getRarity().getColor())}));
        this.f1587b.setScreen(c0218dT);
    }
}
