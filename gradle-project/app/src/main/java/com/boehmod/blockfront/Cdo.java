package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.blockfront.C0048bs;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.do, reason: invalid class name */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/do.class */
public final class Cdo extends C0080cx {
    private static final Component eQ;
    public static float dQ;
    public static float dR;

    @NotNull
    private final CloudItemStack c;
    public float bH;
    public float bI;
    static final /* synthetic */ boolean br;

    static {
        br = !Cdo.class.desiredAssertionStatus();
        eQ = Component.translatable("bf.screen.armory.inspect");
        dQ = 0.0f;
        dR = 0.0f;
    }

    public Cdo(@NotNull CloudItemStack cloudItemStack) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderS;
        super(eQ);
        this.bH = 0.0f;
        this.bI = 0.0f;
        this.c = cloudItemStack;
        C0297l c0297lB = C0297l.b();
        if (!br && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        CloudRegistry cloudRegistryA = c0297lB.a();
        SoundManager soundManager = this.b.getSoundManager();
        CloudItem<?> cloudItem = this.c.getCloudItem(cloudRegistryA);
        if (cloudItem != null) {
            ItemStack itemStackA = iT.a(cloudItem, cloudItemStack);
            if (!itemStackA.isEmpty()) {
                Item item = itemStackA.getItem();
                if ((item instanceof C0558ur) && (deferredHolderS = ((C0558ur) item).m1221a(itemStackA).s()) != null) {
                    soundManager.play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderS.get(), 1.0f, 1.0f));
                }
            }
        }
        iV.a(this.b, cloudRegistryA, cloudItemStack);
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void tick() {
        super.tick();
        CloudRegistry cloudRegistryA = this.e.a();
        Vec3 vec3Scale = new Vec3(dQ - this.bH, 0.0d, dR - this.bI).scale(10.0d);
        CloudItem<?> cloudItem = this.c.getCloudItem(cloudRegistryA);
        if (cloudItem != null) {
            Item itemA = iT.a(cloudItem);
            if (itemA instanceof C0558ur) {
                C0558ur c0558ur = (C0558ur) itemA;
                c0558ur.mz += Mth.abs((float) (vec3Scale.x + vec3Scale.z)) * 0.001f;
                c0558ur.mA = c0558ur.mz;
                c0558ur.mz = Mth.lerp(0.1f, c0558ur.mz, 0.0f);
            }
        }
        this.bH = dQ;
        this.bI = dR;
    }

    @Override // com.boehmod.blockfront.C0080cx
    /* JADX INFO: renamed from: G */
    public void mo280G() {
        super.mo280G();
        addRenderableWidget(new C0048bs(5, 18, 20, 20, Component.empty(), button -> {
            this.b.setScreen(new C0097dn());
        }).a(aH).a(20, 20).a(C0048bs.a.NONE).a((Component) Component.translatable("bf.menu.button.back")));
    }

    @Override // com.boehmod.blockfront.C0080cx, com.boehmod.blockfront.C0081cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        CloudRegistry cloudRegistryA = this.e.a();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        CloudItem<?> cloudItem = this.c.getCloudItem(cloudRegistryA);
        if (cloudItem == null) {
            return;
        }
        PoseStack poseStackPose = guiGraphics.pose();
        Style styleWithColor = Style.EMPTY.withColor(cloudItem.getRarity().getColor());
        C0040bk.b(poseStackPose, guiGraphics, C0080cx.aJ, i3, i4, 200, 200);
        C0245jb.a(cloudItem).a(cloudItem, this.c, this.b, poseStackPose, guiGraphics, this.width, this.height, i, i2, f);
        C0040bk.b(poseStackPose, this.font, guiGraphics, (Component) Component.literal(this.c.getDisplayName(cloudRegistryA)).withStyle(styleWithColor).withStyle(C0266jw.b), i3, this.height - 55, 1.5f);
    }

    public CloudItemStack b() {
        return this.c;
    }
}
