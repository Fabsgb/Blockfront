package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import java.util.Locale;
import java.util.UUID;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dw.class */
public final class C0248dw extends C0244ds {

    /* JADX INFO: renamed from: hu */
    public static final int f2039hu = 16;

    /* JADX INFO: renamed from: hv */
    public static final int f2040hv = 233;

    /* JADX INFO: renamed from: hw */
    public static final int f2041hw = 136;

    /* JADX INFO: renamed from: hx */
    public static final int f2042hx = 114;

    /* JADX INFO: renamed from: hy */
    public static final int f2043hy = 16;

    /* JADX INFO: renamed from: eR */
    private static final Component f2037eR = Component.translatable("bf.screen.menu.armory");

    /* JADX INFO: renamed from: eS */
    private static final Component f2038eS = Component.translatable("bf.menu.button.nav.text.armory");

    /* JADX INFO: renamed from: a */
    @NotNull
    public static CloudItemType f2044a = CloudItemType.ALL;

    public C0248dw() {
        super(f2037eR, f2038eS);
    }

    @Override // com.boehmod.blockfront.C0143cG
    public void init() {
        super.init();
        UUID profileId = this.f1058a.getUser().getProfileId();
        C0551jh c0551jhA = ((C0358g) this.f1057f.m2852b()).m1722a();
        c0551jhA.m2492b(RequestType.PLAYER_INVENTORY_DEFAULTS, profileId);
        c0551jhA.m2492b(RequestType.PLAYER_INVENTORY_SHOWCASE, profileId);
    }

    @Override // com.boehmod.blockfront.C0244ds, com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: K */
    public void mo776K() {
        super.mo776K();
        int i = ((this.width / 2) - C0244ds.f1978hc) + f2040hv + f2042hx + 3;
        int i2 = 0;
        for (CloudItemType cloudItemType : CloudItemType.values()) {
            if (cloudItemType.isArmoryFilter()) {
                int i3 = i2;
                i2++;
                addRenderableWidget(new C0085bB(i, 56 + (19 * i3), 16, 16, Component.empty(), button -> {
                    m1420a(cloudItemType);
                }).m328a(C0085bB.a.NONE).m326a((Component) Component.literal(cloudItemType.name())).m320a(C0532jO.m2378d("textures/gui/menu/icons/armory_filter_" + cloudItemType.toString().toLowerCase(Locale.ROOT) + ".png")).m321d(16).m317a(c0085bB -> {
                    return f2044a != cloudItemType;
                }));
            }
        }
    }

    @Override // com.boehmod.blockfront.C0244ds, com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: H */
    public void mo777H() {
        super.mo777H();
        addRenderableWidget(new C0304ez(((this.width / 2) - C0244ds.f1978hc) + f2042hx, 56, f2040hv, 136));
    }

    /* JADX INFO: renamed from: a */
    public void m1420a(@NotNull CloudItemType cloudItemType) {
        f2044a = cloudItemType;
        if (this.f1058a.screen instanceof C0248dw) {
            C0304ez.f2373ji = 0;
            this.f1058a.setScreen(new C0248dw());
        }
    }
}
