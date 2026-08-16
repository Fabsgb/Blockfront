package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.CloudRegistry;
import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudItemStack;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.dx */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dx.class */
public final class C0249dx extends C0143cG {

    /* JADX INFO: renamed from: eT */
    private static final Component f2045eT;

    /* JADX INFO: renamed from: dT */
    public static float f2046dT;

    /* JADX INFO: renamed from: dU */
    public static float f2047dU;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final CloudItemStack f2048c;

    /* JADX INFO: renamed from: bN */
    public float f2049bN;

    /* JADX INFO: renamed from: bO */
    public float f2050bO;

    /* JADX INFO: renamed from: bv */
    static final /* synthetic */ boolean f2051bv;

    static {
        f2051bv = !C0249dx.class.desiredAssertionStatus();
        f2045eT = Component.translatable("bf.screen.armory.inspect");
        f2046dT = 0.0f;
        f2047dU = 0.0f;
    }

    public C0249dx(@NotNull CloudItemStack cloudItemStack) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6808s;
        super(f2045eT);
        this.f2049bN = 0.0f;
        this.f2050bO = 0.0f;
        this.f2048c = cloudItemStack;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2051bv && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        CloudRegistry cloudRegistryA = c0623lM2852b.m2855a();
        SoundManager soundManager = this.f1058a.getSoundManager();
        CloudItem<?> cloudItem = this.f2048c.getCloudItem(cloudRegistryA);
        if (cloudItem != null) {
            ItemStack itemStackM2530a = C0556jm.m2530a(cloudItem, cloudItemStack);
            if (!itemStackM2530a.isEmpty()) {
                Item item = itemStackM2530a.getItem();
                if ((item instanceof C1117uP) && (deferredHolderM6808s = ((C1117uP) item).m6384a(itemStackM2530a).m6808s()) != null) {
                    soundManager.play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6808s.get(), 1.0f, 1.0f));
                }
            }
        }
        C0558jo.m2537a(this.f1058a, cloudRegistryA, cloudItemStack);
    }

    @Override // com.boehmod.blockfront.C0143cG
    public void tick() {
        super.tick();
        CloudRegistry cloudRegistryA = this.f1057f.m2855a();
        Vec3 vec3Scale = new Vec3(f2046dT - this.f2049bN, 0.0d, f2047dU - this.f2050bO).scale(10.0d);
        CloudItem<?> cloudItem = this.f2048c.getCloudItem(cloudRegistryA);
        if (cloudItem != null) {
            Item itemM2533a = C0556jm.m2533a(cloudItem);
            if (itemM2533a instanceof C1117uP) {
                C1117uP c1117uP = (C1117uP) itemM2533a;
                c1117uP.f6252ny += Mth.abs((float) (vec3Scale.x + vec3Scale.z)) * 0.001f;
                c1117uP.f6253nz = c1117uP.f6252ny;
                c1117uP.f6252ny = Mth.lerp(0.1f, c1117uP.f6252ny, 0.0f);
            }
        }
        this.f2049bN = f2046dT;
        this.f2050bO = f2047dU;
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: K */
    public void mo776K() {
        super.mo776K();
        addRenderableWidget(new C0085bB(5, 18, 20, 20, Component.empty(), button -> {
            this.f1058a.setScreen(new C0248dw());
        }).m320a(f1037aH).m322a(20, 20).m328a(C0085bB.a.NONE).m326a((Component) Component.translatable("bf.menu.button.back")));
    }

    @Override // com.boehmod.blockfront.C0143cG, com.boehmod.blockfront.C0144cH
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        super.render(guiGraphics, i, i2, f);
        CloudRegistry cloudRegistryA = this.f1057f.m2855a();
        int i3 = this.width / 2;
        int i4 = this.height / 2;
        CloudItem<?> cloudItem = this.f2048c.getCloudItem(cloudRegistryA);
        if (cloudItem == null) {
            return;
        }
        PoseStack poseStackPose = guiGraphics.pose();
        Style styleWithColor = Style.EMPTY.withColor(cloudItem.getRarity().getColor());
        C0129bt.m541b(poseStackPose, guiGraphics, C0143cG.f1039aJ, i3, i4, 200, 200);
        C0564ju.m2556a(cloudItem).mo2304a(cloudItem, this.f2048c, this.f1058a, poseStackPose, guiGraphics, this.width, this.height, i, i2, f);
        C0129bt.m491b(poseStackPose, this.font, guiGraphics, (Component) Component.literal(this.f2048c.getDisplayName(cloudRegistryA)).withStyle(styleWithColor).withStyle(C0533jP.f3185b), i3, this.height - 55, 1.5f);
    }

    /* JADX INFO: renamed from: b */
    public CloudItemStack m1423b() {
        return this.f2048c;
    }
}
