package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import com.boehmod.blockfront.C0127bs;
import java.util.Locale;
import java.util.UUID;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dn */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dn.class */
public final class C0238dn extends C0234dj {

    /* JADX INFO: renamed from: gp */
    public static final int f1975gp = 16;

    /* JADX INFO: renamed from: gq */
    public static final int f1976gq = 233;

    /* JADX INFO: renamed from: gr */
    public static final int f1977gr = 136;

    /* JADX INFO: renamed from: gs */
    public static final int f1978gs = 114;

    /* JADX INFO: renamed from: gt */
    public static final int f1979gt = 16;

    /* JADX INFO: renamed from: eO */
    private static final Component f1973eO = Component.translatable("bf.screen.menu.armory");

    /* JADX INFO: renamed from: eP */
    private static final Component f1974eP = Component.translatable("bf.menu.button.nav.text.armory");

    /* JADX INFO: renamed from: a */
    @NotNull
    public static CloudItemType f1980a = CloudItemType.ALL;

    public C0238dn() {
        super(f1973eO, f1974eP);
    }

    @Override // com.boehmod.blockfront.C0195cx
    public void init() {
        super.init();
        UUID profileId = this.f1587b.getUser().getProfileId();
        C0478iO c0478iOA = ((C0357g) this.f1586e.m2667b()).m1716a();
        c0478iOA.m2165b(RequestType.PLAYER_INVENTORY_DEFAULTS, profileId);
        c0478iOA.m2165b(RequestType.PLAYER_INVENTORY_SHOWCASE, profileId);
    }

    @Override // com.boehmod.blockfront.C0234dj, com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: G */
    public void mo744G() {
        super.mo744G();
        int i = ((this.width / 2) - C0234dj.f1918gc) + f1976gq + f1978gs + 3;
        int i2 = 0;
        for (CloudItemType cloudItemType : CloudItemType.values()) {
            if (cloudItemType.isArmoryFilter()) {
                int i3 = i2;
                i2++;
                addRenderableWidget(new C0127bs(i, 56 + (19 * i3), 16, 16, Component.empty(), button -> {
                    m1391a(cloudItemType);
                }).m653a(C0127bs.a.NONE).m651a((Component) Component.literal(cloudItemType.name())).m645a(C0564jv.m2555d("textures/gui/menu/icons/armory_filter_" + cloudItemType.toString().toLowerCase(Locale.ROOT) + ".png")).m646d(16).m642a(c0127bs -> {
                    return f1980a != cloudItemType;
                }));
            }
        }
    }

    @Override // com.boehmod.blockfront.C0234dj, com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: E */
    public void mo775E() {
        super.mo775E();
        addRenderableWidget(new C0290em(((this.width / 2) - C0234dj.f1918gc) + f1978gs, 56, f1976gq, 136));
    }

    /* JADX INFO: renamed from: a */
    public void m1391a(@NotNull CloudItemType cloudItemType) {
        f1980a = cloudItemType;
        if (this.f1587b.screen instanceof C0238dn) {
            C0290em.f2200hS = 0;
            this.f1587b.setScreen(new C0238dn());
        }
    }
}
