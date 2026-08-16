package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.CloudItemCase;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryOpenCase;
import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dz.class */
public final class C0251dz extends C0143cG {

    /* JADX INFO: renamed from: eV */
    private static final Component f2064eV = Component.translatable("bf.screen.opencase");

    /* JADX INFO: renamed from: eW */
    private static final Component f2065eW = Component.translatable("bf.menu.armory.case.button.open").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: eX */
    private static final Component f2066eX = Component.translatable("bf.menu.armory.case.prompt.title");

    /* JADX INFO: renamed from: eY */
    private static final Component f2067eY = Component.translatable("bf.menu.button.back");

    /* JADX INFO: renamed from: eZ */
    private static final Component f2068eZ = Component.translatable("bf.message.continue");

    /* JADX INFO: renamed from: bB */
    private static final ResourceLocation f2069bB = C0532jO.m2378d("textures/gui/effects/starburst.png");

    /* JADX INFO: renamed from: f */
    private final CloudItemStack f2070f;

    /* JADX INFO: renamed from: g */
    private CloudItemStack f2071g;

    /* JADX INFO: renamed from: i */
    private C0085bB f2072i;

    /* JADX INFO: renamed from: by */
    private boolean f2073by;

    /* JADX INFO: renamed from: bz */
    private boolean f2074bz;

    /* JADX INFO: renamed from: dV */
    private float f2075dV;

    /* JADX INFO: renamed from: dW */
    private float f2076dW;

    /* JADX INFO: renamed from: bA */
    private boolean f2077bA;

    /* JADX INFO: renamed from: bB */
    private boolean f2078bB;

    public C0251dz(@NotNull CloudItemStack cloudItemStack) {
        super(f2064eV);
        this.f2073by = false;
        this.f2074bz = false;
        this.f2076dW = 0.0f;
        this.f2077bA = false;
        this.f2078bB = false;
        this.f2070f = cloudItemStack;
    }

    @Override // com.boehmod.blockfront.C0143cG
    public void init() {
        super.init();
        CloudRegistry cloudRegistryA = this.f1057f.m2855a();
        addRenderableWidget(new C0085bB(5, 18, 20, 20, Component.empty(), button -> {
            this.f1058a.setScreen(new C0248dw());
        }).m320a(f1037aH).m322a(20, 20).m328a(C0085bB.a.NONE).m326a(f2067eY));
        this.f2072i = new C0085bB((this.width / 2) - 32, this.height - 60, 65, 10, f2065eW, button2 -> {
            if (this.f2071g == null) {
                CloudItemCase cloudItemCase = (CloudItemCase) this.f2070f.getCloudItem(cloudRegistryA);
                if (cloudItemCase != null && !this.f2073by) {
                    CloudItem<?> key = cloudItemCase.getKey();
                    this.f1058a.setScreen(new C0283ee(this, f2066eX, z -> {
                        if (z) {
                            ((C0358g) this.f1057f.m2852b()).sendPacket(new PacketInventoryOpenCase(this.f2070f.getUUID()));
                            this.f2072i.active = false;
                            this.f2073by = true;
                            return;
                        }
                        this.f1058a.setScreen(new C0248dw());
                    }).m1324a(Component.translatable("bf.menu.armory.case.prompt", new Object[]{Component.literal(key.getDisplayName()).withColor(key.getRarity().getColor())})));
                    return;
                }
                return;
            }
            this.f1058a.setScreen(new C0248dw());
        });
        this.f2072i.m335e(56320);
        this.f2072i.m341f(56320);
        addRenderableWidget(this.f2072i);
        if (this.f2073by) {
            this.f2072i.active = false;
            this.f2072i.visible = false;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1435a(@NotNull ObjectList<CloudItemStack> objectList) {
        this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7975pw.get(), 1.0f));
        this.f2071g = (CloudItemStack) objectList.get(objectList.size() - 4);
        this.f2074bz = true;
        this.f2073by = false;
    }

    @Override // com.boehmod.blockfront.C0143cG
    public void tick() {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6808s;
        super.tick();
        CloudRegistry cloudRegistryA = this.f1057f.m2855a();
        this.f2076dW = this.f2075dV;
        if (this.f2074bz) {
            if (this.f2077bA) {
                if (!this.f2078bB) {
                    this.f2078bB = true;
                    CloudItem<?> cloudItem = this.f2071g.getCloudItem(cloudRegistryA);
                    if (cloudItem != null) {
                        ItemStack itemStackM2530a = C0556jm.m2530a(cloudItem, this.f2071g);
                        if (!itemStackM2530a.isEmpty()) {
                            Item item = itemStackM2530a.getItem();
                            if ((item instanceof C1117uP) && (deferredHolderM6808s = ((C1117uP) item).m6384a(itemStackM2530a).m6808s()) != null) {
                                this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6808s.get(), 1.0f, 1.0f));
                            }
                        }
                    }
                }
                if (this.f2075dV > 0.0f) {
                    this.f2075dV -= 0.1f;
                }
            } else if (this.f2075dV < 1.0f) {
                this.f2075dV += 0.05f;
            } else {
                this.f2077bA = true;
                this.f2072i.active = true;
                this.f2072i.visible = true;
                this.f2072i.setMessage(f2068eZ);
            }
        }
        if (this.f2075dV < 0.0f) {
            this.f2075dV = 0.0f;
        }
    }

    @Override // com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        CloudRegistry cloudRegistryA = this.f1057f.m2855a();
        float fM466g = C0129bt.m466g();
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        int i5 = (i3 - 237) + C0248dw.f2042hx;
        if (!this.f2077bA) {
            CloudItem<?> cloudItem = this.f2070f.getCloudItem(cloudRegistryA);
            if (cloudItem != null) {
                float fSin = 180.0f + (40.0f * (Mth.sin(fM466g / 60.0f) + 1.0f));
                C0129bt.m542b(poseStackPose, guiGraphics, f2069bB, i3, i4, fSin, fSin, fM466g / 20.0f);
                String displayName = this.f2070f.getDisplayName(cloudRegistryA);
                C0129bt.m597b(poseStackPose, this.font, guiGraphics, (Component) Component.literal(displayName).withStyle(ChatFormatting.YELLOW), i5 + (237 / 2.0f), 25 + 25, this.font.width(displayName), 10);
                C0129bt.m601b(poseStackPose, guiGraphics, C0556jm.m2530a(cloudItem, this.f2070f), i3, i4 + (5.0f * Mth.sin(fM466g / 45.0f)), 8.0f);
            }
        } else if (this.f2071g != null) {
            C0129bt.m541b(poseStackPose, guiGraphics, C0143cG.f1039aJ, i3, i4, 400, 400);
            String displayName2 = this.f2071g.getDisplayName(cloudRegistryA);
            int iWidth = this.font.width(displayName2);
            CloudItem<?> cloudItem2 = this.f2071g.getCloudItem(cloudRegistryA);
            if (cloudItem2 != null) {
                C0129bt.m597b(poseStackPose, this.font, guiGraphics, (Component) Component.literal(displayName2).withColor(cloudItem2.getRarity().getColor()), i5 + (237 / 2.0f), 25 + 25, iWidth, 10);
                C0129bt.m601b(poseStackPose, guiGraphics, C0556jm.m2530a(cloudItem2, this.f2071g), i3, i4 + (5.0f * Mth.sin(fM466g / 45.0f)), 8.0f);
            }
        }
        float fM7170f = C1270xJ.m7170f(this.f2075dV, this.f2076dW, f);
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 100.0f);
        C0129bt.m517a(guiGraphics, 0, 0, this.width, this.height, ColorReferences.COLOR_WHITE, fM7170f);
        poseStackPose.popPose();
    }
}
