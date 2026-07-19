package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.CloudItemCase;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryOpenCase;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.dq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dq.class */
public final class C0099dq extends C0080cx {
    private static final Component eS = Component.translatable("bf.screen.opencase");
    private static final Component eT = Component.translatable("bf.menu.armory.case.button.open").withStyle(ChatFormatting.BOLD);
    private static final Component eU = Component.translatable("bf.menu.armory.case.prompt.title");
    private static final Component eV = Component.translatable("bf.menu.button.back");
    private static final Component eW = Component.translatable("bf.message.continue");
    private static final ResourceLocation bD = C0265jv.d("textures/gui/effects/starburst.png");
    private final CloudItemStack f;
    private CloudItemStack g;
    private C0048bs i;
    private boolean bu;
    private boolean bv;
    private float dS;
    private float dT;
    private boolean bw;
    private boolean bx;

    public C0099dq(@NotNull CloudItemStack cloudItemStack) {
        super(eS);
        this.bu = false;
        this.bv = false;
        this.dT = 0.0f;
        this.bw = false;
        this.bx = false;
        this.f = cloudItemStack;
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void init() {
        super.init();
        CloudRegistry cloudRegistryA = this.e.a();
        addRenderableWidget(new C0048bs(5, 18, 20, 20, Component.empty(), button -> {
            this.b.setScreen(new C0097dn());
        }).a(aH).a(20, 20).a(C0048bs.a.NONE).a(eV));
        this.i = new C0048bs((this.width / 2) - 32, this.height - 60, 65, 10, eT, button2 -> {
            if (this.g == null) {
                CloudItemCase cloudItemCase = (CloudItemCase) this.f.getCloudItem(cloudRegistryA);
                if (cloudItemCase != null && !this.bu) {
                    CloudItem<?> key = cloudItemCase.getKey();
                    this.b.setScreen(new dT(this, eU, z -> {
                        if (z) {
                            ((C0163g) this.e.b()).sendPacket(new PacketInventoryOpenCase(this.f.getUUID()));
                            this.i.active = false;
                            this.bu = true;
                            return;
                        }
                        this.b.setScreen(new C0097dn());
                    }).a(Component.translatable("bf.menu.armory.case.prompt", new Object[]{Component.literal(key.getDisplayName()).withColor(key.getRarity().getColor())})));
                    return;
                }
                return;
            }
            this.b.setScreen(new C0097dn());
        });
        this.i.e(56320);
        this.i.f(56320);
        addRenderableWidget(this.i);
        if (this.bu) {
            this.i.active = false;
            this.i.visible = false;
        }
    }

    public void a(@NotNull ObjectList<CloudItemStack> objectList) {
        this.b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pu.get(), 1.0f));
        this.g = (CloudItemStack) objectList.get(objectList.size() - 4);
        this.bv = true;
        this.bu = false;
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void tick() {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderS;
        super.tick();
        CloudRegistry cloudRegistryA = this.e.a();
        this.dT = this.dS;
        if (this.bv) {
            if (this.bw) {
                if (!this.bx) {
                    this.bx = true;
                    CloudItem<?> cloudItem = this.g.getCloudItem(cloudRegistryA);
                    if (cloudItem != null) {
                        ItemStack itemStackA = iT.a(cloudItem, this.g);
                        if (!itemStackA.isEmpty()) {
                            Item item = itemStackA.getItem();
                            if ((item instanceof C0558ur) && (deferredHolderS = ((C0558ur) item).m1221a(itemStackA).s()) != null) {
                                this.b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderS.get(), 1.0f, 1.0f));
                            }
                        }
                    }
                }
                if (this.dS > 0.0f) {
                    this.dS -= 0.1f;
                }
            } else if (this.dS < 1.0f) {
                this.dS += 0.05f;
            } else {
                this.bw = true;
                this.i.active = true;
                this.i.visible = true;
                this.i.setMessage(eW);
            }
        }
        if (this.dS < 0.0f) {
            this.dS = 0.0f;
        }
    }

    @Override // com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        CloudRegistry cloudRegistryA = this.e.a();
        float fG = C0040bk.g();
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        int i5 = (i3 - 237) + C0097dn.gs;
        if (!this.bw) {
            CloudItem<?> cloudItem = this.f.getCloudItem(cloudRegistryA);
            if (cloudItem != null) {
                float fSin = 180.0f + (40.0f * (Mth.sin(fG / 60.0f) + 1.0f));
                C0040bk.b(poseStackPose, guiGraphics, bD, i3, i4, fSin, fSin, fG / 20.0f);
                String displayName = this.f.getDisplayName(cloudRegistryA);
                C0040bk.b(poseStackPose, this.font, guiGraphics, (Component) Component.literal(displayName).withStyle(ChatFormatting.YELLOW), i5 + (237 / 2.0f), 25 + 25, this.font.width(displayName), 10);
                C0040bk.a(poseStackPose, guiGraphics, iT.a(cloudItem, this.f), i3, i4 + (5.0f * Mth.sin(fG / 45.0f)), 8.0f);
            }
        } else if (this.g != null) {
            C0040bk.b(poseStackPose, guiGraphics, C0080cx.aJ, i3, i4, 400, 400);
            String displayName2 = this.g.getDisplayName(cloudRegistryA);
            int iWidth = this.font.width(displayName2);
            CloudItem<?> cloudItem2 = this.g.getCloudItem(cloudRegistryA);
            if (cloudItem2 != null) {
                C0040bk.b(poseStackPose, this.font, guiGraphics, (Component) Component.literal(displayName2).withColor(cloudItem2.getRarity().getColor()), i5 + (237 / 2.0f), 25 + 25, iWidth, 10);
                C0040bk.a(poseStackPose, guiGraphics, iT.a(cloudItem2, this.g), i3, i4 + (5.0f * Mth.sin(fG / 45.0f)), 8.0f);
            }
        }
        float fE = C0634xm.e(this.dS, this.dT, f);
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 100.0f);
        C0040bk.a(guiGraphics, 0, 0, this.width, this.height, ColorReferences.COLOR_WHITE, fE);
        poseStackPose.popPose();
    }
}
