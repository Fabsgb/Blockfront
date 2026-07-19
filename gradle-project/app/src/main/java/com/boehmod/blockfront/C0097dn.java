package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.common.item.CloudItemType;
import com.boehmod.blockfront.C0048bs;
import java.util.Locale;
import java.util.UUID;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dn.class */
public final class C0097dn extends C0093dj {
    public static final int gp = 16;
    public static final int gq = 233;
    public static final int gr = 136;
    public static final int gs = 114;
    public static final int gt = 16;
    private static final Component eO = Component.translatable("bf.screen.menu.armory");
    private static final Component eP = Component.translatable("bf.menu.button.nav.text.armory");

    @NotNull
    public static CloudItemType a = CloudItemType.ALL;

    public C0097dn() {
        super(eO, eP);
    }

    @Override // com.boehmod.blockfront.C0080cx
    public void init() {
        super.init();
        UUID profileId = this.b.getUser().getProfileId();
        iO iOVarA = ((C0163g) this.e.b()).a();
        iOVarA.b(RequestType.PLAYER_INVENTORY_DEFAULTS, profileId);
        iOVarA.b(RequestType.PLAYER_INVENTORY_SHOWCASE, profileId);
    }

    @Override // com.boehmod.blockfront.C0093dj, com.boehmod.blockfront.C0080cx
    /* JADX INFO: renamed from: G */
    public void mo280G() {
        super.mo280G();
        int i = ((this.width / 2) - C0093dj.gc) + gq + gs + 3;
        int i2 = 0;
        for (CloudItemType cloudItemType : CloudItemType.values()) {
            if (cloudItemType.isArmoryFilter()) {
                int i3 = i2;
                i2++;
                addRenderableWidget(new C0048bs(i, 56 + (19 * i3), 16, 16, Component.empty(), button -> {
                    a(cloudItemType);
                }).a(C0048bs.a.NONE).a((Component) Component.literal(cloudItemType.name())).a(C0265jv.d("textures/gui/menu/icons/armory_filter_" + cloudItemType.toString().toLowerCase(Locale.ROOT) + ".png")).d(16).a(c0048bs -> {
                    return a != cloudItemType;
                }));
            }
        }
    }

    @Override // com.boehmod.blockfront.C0093dj, com.boehmod.blockfront.C0080cx
    public void E() {
        super.E();
        addRenderableWidget(new C0122em(((this.width / 2) - C0093dj.gc) + gs, 56, gq, 136));
    }

    public void a(@NotNull CloudItemType cloudItemType) {
        a = cloudItemType;
        if (this.b.screen instanceof C0097dn) {
            C0122em.hS = 0;
            this.b.setScreen(new C0097dn());
        }
    }
}
