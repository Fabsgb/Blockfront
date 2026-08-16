package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryItemStickerAdd;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryItemStickerRemove;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.dy */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dy.class */
public class C0250dy extends C0143cG implements InterfaceC0219dT {

    /* JADX INFO: renamed from: eU */
    private static final Component f2052eU;

    /* JADX INFO: renamed from: hz */
    private static final int f2053hz = 3;

    /* JADX INFO: renamed from: i */
    public static final MutableComponent f2054i;

    /* JADX INFO: renamed from: dT */
    public static float f2055dT;

    /* JADX INFO: renamed from: dU */
    public static float f2056dU;

    /* JADX INFO: renamed from: d */
    private final CloudItemStack f2057d;

    /* JADX INFO: renamed from: hA */
    public int f2058hA;

    /* JADX INFO: renamed from: e */
    private CloudItemStack f2059e;

    /* JADX INFO: renamed from: g */
    private C0085bB f2060g;

    /* JADX INFO: renamed from: h */
    private C0085bB f2061h;

    /* JADX INFO: renamed from: bw */
    private boolean f2062bw;

    /* JADX INFO: renamed from: bx */
    static final /* synthetic */ boolean f2063bx;

    static {
        f2063bx = !C0250dy.class.desiredAssertionStatus();
        f2052eU = Component.translatable("bf.message.prompt.item.sticker.place.title");
        f2054i = Component.translatable("bf.screen.armory.inspect");
        f2055dT = 0.0f;
        f2056dU = 0.0f;
    }

    public C0250dy(@NotNull CloudItemStack cloudItemStack) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6808s;
        super(f2054i);
        this.f2058hA = 0;
        this.f2059e = null;
        this.f2060g = null;
        this.f2061h = null;
        this.f2062bw = false;
        this.f2057d = cloudItemStack;
        SoundManager soundManager = this.f1058a.getSoundManager();
        CloudRegistry cloudRegistryA = this.f1057f.m2855a();
        CloudItem<?> cloudItem = cloudItemStack.getCloudItem(cloudRegistryA);
        if (!f2063bx && cloudItem == null) {
            throw new AssertionError();
        }
        ItemStack itemStackM2530a = C0556jm.m2530a(cloudItem, cloudItemStack);
        if (!itemStackM2530a.isEmpty()) {
            Item item = itemStackM2530a.getItem();
            if ((item instanceof C1117uP) && (deferredHolderM6808s = ((C1117uP) item).m6384a(itemStackM2530a).m6808s()) != null) {
                soundManager.play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6808s.get(), 1.0f, 1.0f));
            }
        }
        C0558jo.m2537a(this.f1058a, cloudRegistryA, cloudItemStack);
    }

    @Override // com.boehmod.blockfront.C0143cG
    public void tick() {
        super.tick();
        if (this.f2062bw) {
            this.f1058a.setScreen(new C0248dw());
            return;
        }
        boolean z = !this.f1056a.m1886a(this.f1058a).getInventory().getItems(this.f1057f.m2855a(), CloudItemType.STICKER).isEmpty();
        boolean zHasSticker = this.f2057d.hasSticker(this.f2058hA);
        this.f2060g.active = z;
        this.f2061h.active = zHasSticker;
        this.f2060g.m326a((Component) Component.translatable(z ? "bf.screen.armory.stickers.set.tooltip" : "bf.screen.armory.stickers.set.tooltip.inactive"));
        this.f2061h.m326a((Component) Component.translatable(zHasSticker ? "bf.screen.armory.stickers.remove.tooltip" : "bf.screen.armory.stickers.remove.tooltip.inactive"));
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: K */
    public void mo776K() {
        super.mo776K();
        addRenderableWidget(new C0085bB(1, 50, 20, 20, Component.literal("<"), button -> {
            this.f2058hA--;
            if (this.f2058hA < 0) {
                this.f2058hA = 2;
            }
        }));
        C0085bB c0085bB = new C0085bB(21, 50, 25, 20, Component.literal("SET"), button2 -> {
            m1425ag();
        });
        this.f2060g = c0085bB;
        addRenderableWidget(c0085bB);
        C0085bB c0085bB2 = new C0085bB(46, 50, 45, 20, Component.literal("REMOVE"), button3 -> {
            m1426ah();
        });
        this.f2061h = c0085bB2;
        addRenderableWidget(c0085bB2);
        addRenderableWidget(new C0085bB(91, 50, 20, 20, Component.literal(">"), button4 -> {
            this.f2058hA++;
            if (this.f2058hA >= 3) {
                this.f2058hA = 0;
            }
        }));
        addRenderableWidget(new C0085bB(5, 18, 20, 20, Component.empty(), button5 -> {
            this.f1058a.setScreen(new C0248dw());
        }).m320a(f1037aH).m322a(20, 20).m328a(C0085bB.a.NONE).m326a((Component) Component.translatable("bf.menu.button.back")));
    }

    /* JADX INFO: renamed from: ag */
    private void m1425ag() {
        ObjectList<CloudItemStack> items = this.f1056a.m1886a(this.f1058a).getInventory().getItems(this.f1057f.m2855a(), CloudItemType.STICKER);
        if (!items.isEmpty()) {
            this.f1058a.setScreen(new C0221dV(this, items, 1));
        }
    }

    /* JADX INFO: renamed from: ah */
    private void m1426ah() {
        C0283ee c0283ee = new C0283ee(this, Component.translatable("bf.message.prompt.item.sticker.remove.title"), z -> {
            if (z) {
                this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, 1.0f));
                ((C0358g) this.f1057f.m2852b()).sendPacket(new PacketInventoryItemStickerRemove(this.f2057d.getUUID(), this.f2058hA));
            }
            this.f2062bw = true;
        });
        c0283ee.m1324a((Component) Component.translatable("bf.message.prompt.item.sticker.remove"));
        this.f1058a.setScreen(c0283ee);
    }

    @Override // com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        CloudRegistry cloudRegistryA = this.f1057f.m2855a();
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        CloudItem<?> cloudItem = this.f2057d.getCloudItem(cloudRegistryA);
        if (cloudItem == null) {
            return;
        }
        C0129bt.m541b(poseStackPose, guiGraphics, C0143cG.f1039aJ, i3, i4, 200, 200);
        poseStackPose.pushPose();
        float f2 = (-0.5f) + (i2 / this.height);
        float f3 = (-0.5f) + (i / this.width);
        poseStackPose.translate(0.0f, 0.0f, 150.0f);
        f2055dT = 25.0f * f2;
        f2056dU = 65.0f * f3;
        C0564ju.m2556a(cloudItem).mo2304a(cloudItem, this.f2057d, this.f1058a, poseStackPose, guiGraphics, this.width, this.height, i, i2, f);
        poseStackPose.popPose();
        C0129bt.m491b(poseStackPose, this.font, guiGraphics, (Component) Component.literal(this.f2057d.getDisplayName(cloudRegistryA)).withColor(cloudItem.getRarity().getColor()).withStyle(C0533jP.f3185b), i3, this.height - 55, 1.5f);
    }

    /* JADX INFO: renamed from: b */
    public CloudItemStack m1427b() {
        return this.f2057d;
    }

    @Override // com.boehmod.blockfront.InterfaceC0219dT
    /* JADX INFO: renamed from: b */
    public void mo1313b(@NotNull List<CloudItemStack> list) {
        if (list.isEmpty()) {
            return;
        }
        this.f2059e = (CloudItemStack) list.getFirst();
        CloudItem<?> cloudItem = this.f2059e.getCloudItem(this.f1057f.m2855a());
        if (cloudItem == null) {
            return;
        }
        String suffix = cloudItem.getSuffix();
        C0283ee c0283ee = new C0283ee(this, f2052eU, z -> {
            if (z && this.f2059e != null) {
                this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, 1.0f));
                ((C0358g) this.f1057f.m2852b()).sendPacket(new PacketInventoryItemStickerAdd(this.f2057d.getUUID(), this.f2059e.getUUID(), this.f2058hA));
            }
            this.f2059e = null;
            this.f2062bw = true;
        });
        c0283ee.m1324a((Component) Component.translatable("bf.message.prompt.item.sticker.place", new Object[]{Component.literal(suffix).withColor(cloudItem.getRarity().getColor())}));
        this.f1058a.setScreen(c0283ee);
    }
}
