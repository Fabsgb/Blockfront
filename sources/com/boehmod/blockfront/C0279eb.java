package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Optional;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.eb */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eb.class */
public final class C0279eb extends AbstractC0284eg {

    /* JADX INFO: renamed from: ca */
    @NotNull
    private static final ResourceLocation f2122ca;

    /* JADX INFO: renamed from: hn */
    public static final Component f2123hn;

    /* JADX INFO: renamed from: m */
    @NotNull
    private final Screen f2124m;

    /* JADX INFO: renamed from: h */
    @NotNull
    private final UUID f2125h;

    /* JADX INFO: renamed from: e */
    @NotNull
    private final C0482iS f2126e;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final b f2127a;

    /* JADX INFO: renamed from: bO */
    static final /* synthetic */ boolean f2128bO;

    /* JADX INFO: renamed from: com.boehmod.blockfront.eb$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eb$a.class */
    public interface a {
        /* JADX INFO: renamed from: a */
        Component mo1481a(@NotNull C0326fV c0326fV, @NotNull UUID uuid);

        /* JADX INFO: renamed from: a */
        Component mo1482a(@NotNull C0326fV c0326fV, @NotNull UUID uuid, boolean z);

        /* JADX INFO: renamed from: a */
        int mo1483a(@NotNull C0326fV c0326fV, @NotNull UUID uuid, boolean z);

        /* JADX INFO: renamed from: a */
        void mo1484a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, C0326fV c0326fV, PoseStack poseStack, @NotNull GuiGraphics guiGraphics, UUID uuid, int i, int i2, int i3, int i4);
    }

    static {
        f2128bO = !C0279eb.class.desiredAssertionStatus();
        f2122ca = C0564jv.m2555d("textures/gui/invites/friend.png");
        f2123hn = Component.translatable("bf.status.friend.request").withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID);
    }

    public C0279eb(@NotNull Screen screen, @NotNull UUID uuid, @NotNull b bVar) {
        this.f2124m = screen;
        this.f2125h = uuid;
        this.f2127a = bVar;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2128bO && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        this.f2126e = ((C0326fV) c0622lM2667b.m2670a()).mo1137a(uuid);
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: b */
    public void mo1479b(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull GuiGraphics guiGraphics, @NotNull C0326fV c0326fV, @NotNull Font font, int i, int i2, float f, float f2) {
        super.mo1479b(poseStack, minecraft, c0622l, guiGraphics, c0326fV, font, i, i2, f, f2);
        if (m1499D() && this.f2127a == b.FRIEND) {
            guiGraphics.renderTooltip(font, c0326fV.mo1137a(this.f2125h).m2196c(), Optional.empty(), i, i2);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: a */
    public void mo1480a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        int iHeight = height() - 2;
        this.f2127a.slotInfo.mo1484a(minecraft, c0622l, c0326fV, poseStack, guiGraphics, this.f2125h, this.f2166hI + 1, this.f2167hJ + 1, iHeight, iHeight);
        C0119bk.m496a(c0326fV, guiGraphics, font, this.f2125h, this.f2127a, this.f2166hI + iHeight + 1, this.f2167hJ, height(), m1499D());
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: a */
    public void mo817a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, int i, int i2, int i3) {
        int iMo1311k = (int) this.f2165a.mo1311k(1.0f);
        switch (this.f2127a) {
            case FRIEND:
                minecraft.setScreen(new C0133by(this.f2124m, this.f2166hI + mo812t(), this.f2167hJ - iMo1311k, 100, 15, this.f2126e));
                break;
            case FRIEND_REQUEST:
                minecraft.setScreen(new C0134bz(this.f2124m, this.f2166hI + mo812t(), this.f2167hJ - iMo1311k, 100, 15, this.f2126e));
                break;
            case CLAN_MEMBER:
                minecraft.setScreen(new C0132bx(this.f2124m, this.f2166hI + mo812t(), this.f2167hJ - iMo1311k, 100, 15, this.f2126e));
                break;
            case CLAN_INVITE:
                minecraft.setScreen(new C0131bw(this.f2124m, this.f2166hI + mo812t(), this.f2167hJ - iMo1311k, 100, 15, this.f2125h));
                break;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: n */
    public void mo810n(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: v */
    public boolean mo811v() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    public int height() {
        return 22;
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: t */
    public int mo812t() {
        return this.f2165a.m699t();
    }

    @Override // com.boehmod.blockfront.AbstractC0284eg
    /* JADX INFO: renamed from: S */
    public int mo1300S() {
        return 1;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.eb$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eb$b.class */
    public enum b {
        FRIEND(new a() { // from class: com.boehmod.blockfront.eb.b.1
            @Override // com.boehmod.blockfront.C0279eb.a
            /* JADX INFO: renamed from: a */
            public Component mo1481a(@NotNull C0326fV c0326fV, @NotNull UUID uuid) {
                return Component.literal(c0326fV.mo1137a(uuid).getUsername());
            }

            @Override // com.boehmod.blockfront.C0279eb.a
            /* JADX INFO: renamed from: a */
            public Component mo1482a(@NotNull C0326fV c0326fV, @NotNull UUID uuid, boolean z) {
                C0482iS c0482iSA = c0326fV.mo1137a(uuid);
                if (z) {
                    return c0482iSA.m2190k().copy().withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID);
                }
                return c0482iSA.m2190k();
            }

            @Override // com.boehmod.blockfront.C0279eb.a
            /* JADX INFO: renamed from: a */
            public int mo1483a(@NotNull C0326fV c0326fV, @NotNull UUID uuid, boolean z) {
                return z ? ColorReferences.COLOR_THEME_YELLOW_SOLID : c0326fV.mo1137a(uuid).getStatus().getOnlineStatus().getColor() - 16777216;
            }

            @Override // com.boehmod.blockfront.C0279eb.a
            /* JADX INFO: renamed from: a */
            public void mo1484a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, PoseStack poseStack, @NotNull GuiGraphics guiGraphics, UUID uuid, int i, int i2, int i3, int i4) {
                C0119bk.m485a(minecraft, c0622l, poseStack, guiGraphics, c0326fV.mo1137a(uuid).m2195a(), i, i2, i4);
            }
        }),
        FRIEND_REQUEST(new a() { // from class: com.boehmod.blockfront.eb.b.2
            @Override // com.boehmod.blockfront.C0279eb.a
            /* JADX INFO: renamed from: a */
            public Component mo1481a(@NotNull C0326fV c0326fV, @NotNull UUID uuid) {
                return Component.literal(c0326fV.mo1137a(uuid).getUsername());
            }

            @Override // com.boehmod.blockfront.C0279eb.a
            /* JADX INFO: renamed from: a */
            public Component mo1482a(@NotNull C0326fV c0326fV, @NotNull UUID uuid, boolean z) {
                return C0279eb.f2123hn;
            }

            @Override // com.boehmod.blockfront.C0279eb.a
            /* JADX INFO: renamed from: a */
            public int mo1483a(@NotNull C0326fV c0326fV, @NotNull UUID uuid, boolean z) {
                return z ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_WHITE_SOLID;
            }

            @Override // com.boehmod.blockfront.C0279eb.a
            /* JADX INFO: renamed from: a */
            public void mo1484a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, C0326fV c0326fV, PoseStack poseStack, @NotNull GuiGraphics guiGraphics, UUID uuid, int i, int i2, int i3, int i4) {
                C0119bk.m431a(poseStack, guiGraphics, C0279eb.f2122ca, i, i2, i3, i4);
            }
        }),
        CLAN_MEMBER(new a() { // from class: com.boehmod.blockfront.eb.b.3
            @Override // com.boehmod.blockfront.C0279eb.a
            /* JADX INFO: renamed from: a */
            public Component mo1481a(@NotNull C0326fV c0326fV, @NotNull UUID uuid) {
                return Component.literal(c0326fV.mo1137a(uuid).getUsername());
            }

            @Override // com.boehmod.blockfront.C0279eb.a
            /* JADX INFO: renamed from: a */
            public Component mo1482a(@NotNull C0326fV c0326fV, @NotNull UUID uuid, boolean z) {
                C0482iS c0482iSA = c0326fV.mo1137a(uuid);
                return c0482iSA.m2190k().copy().withColor(z ? ColorReferences.COLOR_THEME_CLANS_HOVERED_SOLID : c0482iSA.getStatus().getOnlineStatus().isOnline() ? ColorReferences.COLOR_THEME_CLANS_SOLID : ColorReferences.COLOR_THEME_CLANS_MUTED_SOLID);
            }

            @Override // com.boehmod.blockfront.C0279eb.a
            /* JADX INFO: renamed from: a */
            public int mo1483a(@NotNull C0326fV c0326fV, @NotNull UUID uuid, boolean z) {
                return z ? ColorReferences.COLOR_THEME_CLANS_HOVERED_SOLID : c0326fV.mo1137a(uuid).getStatus().getOnlineStatus().isOnline() ? ColorReferences.COLOR_THEME_CLANS_SOLID : ColorReferences.COLOR_THEME_CLANS_MUTED_SOLID;
            }

            @Override // com.boehmod.blockfront.C0279eb.a
            /* JADX INFO: renamed from: a */
            public void mo1484a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, C0326fV c0326fV, PoseStack poseStack, @NotNull GuiGraphics guiGraphics, UUID uuid, int i, int i2, int i3, int i4) {
                C0119bk.m485a(minecraft, c0622l, poseStack, guiGraphics, c0326fV.mo1137a(uuid).m2195a(), i, i2, i4);
            }
        }),
        CLAN_INVITE(new a() { // from class: com.boehmod.blockfront.eb.b.4
            @Override // com.boehmod.blockfront.C0279eb.a
            /* JADX INFO: renamed from: a */
            public Component mo1481a(@NotNull C0326fV c0326fV, @NotNull UUID uuid) {
                return Component.literal(c0326fV.mo1137a(uuid).getName());
            }

            @Override // com.boehmod.blockfront.C0279eb.a
            /* JADX INFO: renamed from: a */
            public Component mo1482a(@NotNull C0326fV c0326fV, @NotNull UUID uuid, boolean z) {
                return Component.literal(c0326fV.mo1137a(c0326fV.mo1137a(uuid).getOwner()).getUsername());
            }

            @Override // com.boehmod.blockfront.C0279eb.a
            /* JADX INFO: renamed from: a */
            public int mo1483a(@NotNull C0326fV c0326fV, @NotNull UUID uuid, boolean z) {
                return z ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_THEME_CLANS_HOVERED_SOLID;
            }

            @Override // com.boehmod.blockfront.C0279eb.a
            /* JADX INFO: renamed from: a */
            public void mo1484a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, C0326fV c0326fV, PoseStack poseStack, @NotNull GuiGraphics guiGraphics, UUID uuid, int i, int i2, int i3, int i4) {
                C0119bk.m437a(poseStack, guiGraphics, C0279eb.f2122ca, i, i2, i3, i4, 0.0f, 1.0f, ColorReferences.COLOR_THEME_CLANS_HOVERED_SOLID);
            }
        });

        private final a slotInfo;

        b(@NotNull a aVar) {
            this.slotInfo = aVar;
        }

        public a getSlotInfo() {
            return this.slotInfo;
        }
    }
}
