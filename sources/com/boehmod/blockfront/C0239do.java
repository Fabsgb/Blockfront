package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
import com.boehmod.blockfront.C0127bs;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.do */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/do.class */
public final class C0239do extends C0195cx {

    /* JADX INFO: renamed from: eQ */
    private static final Component f1981eQ;

    /* JADX INFO: renamed from: dQ */
    public static float f1982dQ;

    /* JADX INFO: renamed from: dR */
    public static float f1983dR;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final CloudItemStack f1984c;

    /* JADX INFO: renamed from: bH */
    public float f1985bH;

    /* JADX INFO: renamed from: bI */
    public float f1986bI;

    /* JADX INFO: renamed from: br */
    static final /* synthetic */ boolean f1987br;

    static {
        f1987br = !C0239do.class.desiredAssertionStatus();
        f1981eQ = Component.translatable("bf.screen.armory.inspect");
        f1982dQ = 0.0f;
        f1983dR = 0.0f;
    }

    public C0239do(@NotNull CloudItemStack cloudItemStack) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6155s;
        super(f1981eQ);
        this.f1985bH = 0.0f;
        this.f1986bI = 0.0f;
        this.f1984c = cloudItemStack;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f1987br && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        CloudRegistry cloudRegistryA = c0622lM2667b.m2670a();
        SoundManager soundManager = this.f1587b.getSoundManager();
        CloudItem<?> cloudItem = this.f1984c.getCloudItem(cloudRegistryA);
        if (cloudItem != null) {
            ItemStack itemStackM2203a = C0483iT.m2203a(cloudItem, cloudItemStack);
            if (!itemStackM2203a.isEmpty()) {
                Item item = itemStackM2203a.getItem();
                if ((item instanceof C1144ur) && (deferredHolderM6155s = ((C1144ur) item).m6408a(itemStackM2203a).m6155s()) != null) {
                    soundManager.play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6155s.get(), 1.0f, 1.0f));
                }
            }
        }
        C0485iV.m2210a(this.f1587b, cloudRegistryA, cloudItemStack);
    }

    @Override // com.boehmod.blockfront.C0195cx
    public void tick() {
        super.tick();
        CloudRegistry cloudRegistryA = this.f1586e.m2670a();
        Vec3 vec3Scale = new Vec3(f1982dQ - this.f1985bH, 0.0d, f1983dR - this.f1986bI).scale(10.0d);
        CloudItem<?> cloudItem = this.f1984c.getCloudItem(cloudRegistryA);
        if (cloudItem != null) {
            Item itemM2206a = C0483iT.m2206a(cloudItem);
            if (itemM2206a instanceof C1144ur) {
                C1144ur c1144ur = (C1144ur) itemM2206a;
                c1144ur.f5613mz += Mth.abs((float) (vec3Scale.x + vec3Scale.z)) * 0.001f;
                c1144ur.f5614mA = c1144ur.f5613mz;
                c1144ur.f5613mz = Mth.lerp(0.1f, c1144ur.f5613mz, 0.0f);
            }
        }
        this.f1985bH = f1982dQ;
        this.f1986bI = f1983dR;
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: G */
    public void mo744G() {
        super.mo744G();
        addRenderableWidget(new C0127bs(5, 18, 20, 20, Component.empty(), button -> {
            this.f1587b.setScreen(new C0238dn());
        }).m645a(f1564aH).m647a(20, 20).m653a(C0127bs.a.NONE).m651a((Component) Component.translatable("bf.menu.button.back")));
    }

    @Override // com.boehmod.blockfront.C0195cx, com.boehmod.blockfront.C0196cy
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        CloudRegistry cloudRegistryA = this.f1586e.m2670a();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        CloudItem<?> cloudItem = this.f1984c.getCloudItem(cloudRegistryA);
        if (cloudItem == null) {
            return;
        }
        PoseStack poseStackPose = guiGraphics.pose();
        Style styleWithColor = Style.EMPTY.withColor(cloudItem.getRarity().getColor());
        C0119bk.m441b(poseStackPose, guiGraphics, C0195cx.f1566aJ, i3, i4, 200, 200);
        C0544jb.m2468a(cloudItem).mo2228a(cloudItem, this.f1984c, this.f1587b, poseStackPose, guiGraphics, this.width, this.height, i, i2, f);
        C0119bk.m391b(poseStackPose, this.font, guiGraphics, (Component) Component.literal(this.f1984c.getDisplayName(cloudRegistryA)).withStyle(styleWithColor).withStyle(C0565jw.f3201b), i3, this.height - 55, 1.5f);
    }

    /* JADX INFO: renamed from: b */
    public CloudItemStack m1394b() {
        return this.f1984c;
    }
}
