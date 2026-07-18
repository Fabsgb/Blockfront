package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.bflib.cloud.common.item.types.CloudItemCase;
import com.boehmod.bflib.cloud.packet.common.inventory.PacketInventoryOpenCase;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.dq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dq.class */
public final class C0241dq extends C0195cx {

    /* JADX INFO: renamed from: eS */
    private static final Component f2000eS = Component.translatable("bf.screen.opencase");

    /* JADX INFO: renamed from: eT */
    private static final Component f2001eT = Component.translatable("bf.menu.armory.case.button.open").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: eU */
    private static final Component f2002eU = Component.translatable("bf.menu.armory.case.prompt.title");

    /* JADX INFO: renamed from: eV */
    private static final Component f2003eV = Component.translatable("bf.menu.button.back");

    /* JADX INFO: renamed from: eW */
    private static final Component f2004eW = Component.translatable("bf.message.continue");

    /* JADX INFO: renamed from: bD */
    private static final ResourceLocation f2005bD = C0564jv.m2555d("textures/gui/effects/starburst.png");

    /* JADX INFO: renamed from: f */
    private final CloudItemStack f2006f;

    /* JADX INFO: renamed from: g */
    private CloudItemStack f2007g;

    /* JADX INFO: renamed from: i */
    private C0127bs f2008i;

    /* JADX INFO: renamed from: bu */
    private boolean f2009bu;

    /* JADX INFO: renamed from: bv */
    private boolean f2010bv;

    /* JADX INFO: renamed from: dS */
    private float f2011dS;

    /* JADX INFO: renamed from: dT */
    private float f2012dT;

    /* JADX INFO: renamed from: bw */
    private boolean f2013bw;

    /* JADX INFO: renamed from: bx */
    private boolean f2014bx;

    public C0241dq(@NotNull CloudItemStack cloudItemStack) {
        super(f2000eS);
        this.f2009bu = false;
        this.f2010bv = false;
        this.f2012dT = 0.0f;
        this.f2013bw = false;
        this.f2014bx = false;
        this.f2006f = cloudItemStack;
    }

    @Override // com.boehmod.blockfront.C0195cx
    public void init() {
        super.init();
        CloudRegistry cloudRegistryA = this.f1586e.m2670a();
        addRenderableWidget(new C0127bs(5, 18, 20, 20, Component.empty(), button -> {
            this.f1587b.setScreen(new C0238dn());
        }).m645a(f1564aH).m647a(20, 20).m653a(C0127bs.a.NONE).m651a(f2003eV));
        this.f2008i = new C0127bs((this.width / 2) - 32, this.height - 60, 65, 10, f2001eT, button2 -> {
            if (this.f2007g == null) {
                CloudItemCase cloudItemCase = (CloudItemCase) this.f2006f.getCloudItem(cloudRegistryA);
                if (cloudItemCase != null && !this.f2009bu) {
                    CloudItem<?> key = cloudItemCase.getKey();
                    this.f1587b.setScreen(new C0218dT(this, f2002eU, z -> {
                        if (z) {
                            ((C0357g) this.f1586e.m2667b()).sendPacket(new PacketInventoryOpenCase(this.f2006f.getUUID()));
                            this.f2008i.active = false;
                            this.f2009bu = true;
                            return;
                        }
                        this.f1587b.setScreen(new C0238dn());
                    }).m1273a(Component.translatable("bf.menu.armory.case.prompt", new Object[]{Component.literal(key.getDisplayName()).withColor(key.getRarity().getColor())})));
                    return;
                }
                return;
            }
            this.f1587b.setScreen(new C0238dn());
        });
        this.f2008i.m660e(56320);
        this.f2008i.m666f(56320);
        addRenderableWidget(this.f2008i);
        if (this.f2009bu) {
            this.f2008i.active = false;
            this.f2008i.visible = false;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1406a(@NotNull ObjectList<CloudItemStack> objectList) {
        this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7563pu.get(), 1.0f));
        this.f2007g = (CloudItemStack) objectList.get(objectList.size() - 4);
        this.f2010bv = true;
        this.f2009bu = false;
    }

    @Override // com.boehmod.blockfront.C0195cx
    public void tick() {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6155s;
        super.tick();
        CloudRegistry cloudRegistryA = this.f1586e.m2670a();
        this.f2012dT = this.f2011dS;
        if (this.f2010bv) {
            if (this.f2013bw) {
                if (!this.f2014bx) {
                    this.f2014bx = true;
                    CloudItem<?> cloudItem = this.f2007g.getCloudItem(cloudRegistryA);
                    if (cloudItem != null) {
                        ItemStack itemStackM2203a = C0483iT.m2203a(cloudItem, this.f2007g);
                        if (!itemStackM2203a.isEmpty()) {
                            Item item = itemStackM2203a.getItem();
                            if ((item instanceof C1144ur) && (deferredHolderM6155s = ((C1144ur) item).m6408a(itemStackM2203a).m6155s()) != null) {
                                this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6155s.get(), 1.0f, 1.0f));
                            }
                        }
                    }
                }
                if (this.f2011dS > 0.0f) {
                    this.f2011dS -= 0.1f;
                }
            } else if (this.f2011dS < 1.0f) {
                this.f2011dS += 0.05f;
            } else {
                this.f2013bw = true;
                this.f2008i.active = true;
                this.f2008i.visible = true;
                this.f2008i.setMessage(f2004eW);
            }
        }
        if (this.f2011dS < 0.0f) {
            this.f2011dS = 0.0f;
        }
    }

    @Override // com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        CloudRegistry cloudRegistryA = this.f1586e.m2670a();
        float fM366g = C0119bk.m366g();
        PoseStack poseStackPose = guiGraphics.pose();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        int i5 = (i3 - 237) + C0238dn.f1978gs;
        if (!this.f2013bw) {
            CloudItem<?> cloudItem = this.f2006f.getCloudItem(cloudRegistryA);
            if (cloudItem != null) {
                float fSin = 180.0f + (40.0f * (Mth.sin(fM366g / 60.0f) + 1.0f));
                C0119bk.m442b(poseStackPose, guiGraphics, f2005bD, i3, i4, fSin, fSin, fM366g / 20.0f);
                String displayName = this.f2006f.getDisplayName(cloudRegistryA);
                C0119bk.m497b(poseStackPose, this.font, guiGraphics, (Component) Component.literal(displayName).withStyle(ChatFormatting.YELLOW), i5 + (237 / 2.0f), 25 + 25, this.font.width(displayName), 10);
                C0119bk.m501a(poseStackPose, guiGraphics, C0483iT.m2203a(cloudItem, this.f2006f), i3, i4 + (5.0f * Mth.sin(fM366g / 45.0f)), 8.0f);
            }
        } else if (this.f2007g != null) {
            C0119bk.m441b(poseStackPose, guiGraphics, C0195cx.f1566aJ, i3, i4, 400, 400);
            String displayName2 = this.f2007g.getDisplayName(cloudRegistryA);
            int iWidth = this.font.width(displayName2);
            CloudItem<?> cloudItem2 = this.f2007g.getCloudItem(cloudRegistryA);
            if (cloudItem2 != null) {
                C0119bk.m497b(poseStackPose, this.font, guiGraphics, (Component) Component.literal(displayName2).withColor(cloudItem2.getRarity().getColor()), i5 + (237 / 2.0f), 25 + 25, iWidth, 10);
                C0119bk.m501a(poseStackPose, guiGraphics, C0483iT.m2203a(cloudItem2, this.f2007g), i3, i4 + (5.0f * Mth.sin(fM366g / 45.0f)), 8.0f);
            }
        }
        float fM7843e = C1290xm.m7843e(this.f2011dS, this.f2012dT, f);
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 100.0f);
        C0119bk.m417a(guiGraphics, 0, 0, this.width, this.height, ColorReferences.COLOR_WHITE, fM7843e);
        poseStackPose.popPose();
    }
}
