package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.status.PublicPlayerStatus;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.en */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/en.class */
public final class C0292en extends AbstractC0298et {

    /* JADX INFO: renamed from: bY */
    @NotNull
    private static final ResourceLocation f2287bY;

    /* JADX INFO: renamed from: hv */
    public static final Component f2288hv;

    /* JADX INFO: renamed from: l */
    @NotNull
    private final Screen f2289l;

    /* JADX INFO: renamed from: h */
    @NotNull
    private final UUID f2290h;

    /* JADX INFO: renamed from: e */
    @NotNull
    private final C0555jl f2291e;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final b f2292a;

    /* JADX INFO: renamed from: bX */
    static final /* synthetic */ boolean f2293bX;

    /* JADX INFO: renamed from: com.boehmod.blockfront.en$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/en$a.class */
    public interface a {
        /* JADX INFO: renamed from: a */
        Component mo1597a(@NotNull C0396gl c0396gl, @NotNull UUID uuid);

        /* JADX INFO: renamed from: a */
        Component mo1598a(@NotNull C0396gl c0396gl, @NotNull UUID uuid, boolean z);

        /* JADX INFO: renamed from: a */
        int mo1599a(@NotNull C0396gl c0396gl, @NotNull UUID uuid, boolean z);

        /* JADX INFO: renamed from: a */
        void mo1600a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, C0396gl c0396gl, PoseStack poseStack, @NotNull GuiGraphics guiGraphics, UUID uuid, int i, int i2, int i3, int i4);
    }

    static {
        f2293bX = !C0292en.class.desiredAssertionStatus();
        f2287bY = C0532jO.m2378d("textures/gui/invites/friend.png");
        f2288hv = Component.translatable("bf.status.friend.request").withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID);
    }

    public C0292en(@NotNull Screen screen, @NotNull UUID uuid, @NotNull b bVar) {
        this.f2289l = screen;
        this.f2290h = uuid;
        this.f2292a = bVar;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2293bX && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        this.f2291e = ((C0396gl) c0623lM2852b.m2855a()).mo1154a(uuid);
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: b */
    public void mo1591b(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull GuiGraphics guiGraphics, @NotNull C0396gl c0396gl, @NotNull Font font, int i, int i2, float f, float f2) {
        super.mo1591b(poseStack, minecraft, c0623l, guiGraphics, c0396gl, font, i, i2, f, f2);
        if (m1615E() && this.f2292a == b.FRIEND) {
            guiGraphics.renderTooltip(font, c0396gl.mo1154a(this.f2290h).m2523g(), Optional.empty(), i, i2);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: a */
    public void mo1596a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        int iHeight = height() - 2;
        this.f2292a.slotInfo.mo1600a(minecraft, c0623l, c0396gl, poseStack, guiGraphics, this.f2290h, this.f2339iY + 1, this.f2340iZ + 1, iHeight, iHeight);
        C0129bt.m596a(c0396gl, guiGraphics, font, this.f2290h, this.f2292a, this.f2339iY + iHeight + 1, this.f2340iZ, height(), m1615E());
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: a */
    public void mo871a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, int i, int i2, int i3) {
        int iMo1572j = (int) this.f2338a.mo1572j(1.0f);
        switch (this.f2292a) {
            case FRIEND:
                minecraft.setScreen(new C0091bH(this.f2289l, this.f2339iY + mo866x(), this.f2340iZ - iMo1572j, 100, 15, this.f2291e));
                break;
            case FRIEND_REQUEST:
                minecraft.setScreen(new C0092bI(this.f2289l, this.f2339iY + mo866x(), this.f2340iZ - iMo1572j, 100, 15, this.f2291e));
                break;
            case CLAN_MEMBER:
                minecraft.setScreen(new C0090bG(this.f2289l, this.f2339iY + mo866x(), this.f2340iZ - iMo1572j, 100, 15, this.f2291e));
                break;
            case CLAN_INVITE:
                minecraft.setScreen(new C0089bF(this.f2289l, this.f2339iY + mo866x(), this.f2340iZ - iMo1572j, 100, 15, this.f2290h));
                break;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: o */
    public void mo864o(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: w */
    public boolean mo865w() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    public int height() {
        return 22;
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: x */
    public int mo866x() {
        return this.f2338a.m374x();
    }

    @Override // com.boehmod.blockfront.AbstractC0298et
    /* JADX INFO: renamed from: U */
    public int mo1248U() {
        return 1;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.en$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/en$b.class */
    public enum b {
        FRIEND(new a() { // from class: com.boehmod.blockfront.en.b.1
            @Override // com.boehmod.blockfront.C0292en.a
            /* JADX INFO: renamed from: a */
            public Component mo1597a(@NotNull C0396gl c0396gl, @NotNull UUID uuid) {
                return Component.literal(c0396gl.mo1154a(uuid).getUsername());
            }

            @Override // com.boehmod.blockfront.C0292en.a
            /* JADX INFO: renamed from: a */
            public Component mo1598a(@NotNull C0396gl c0396gl, @NotNull UUID uuid, boolean z) {
                C0555jl c0555jlA = c0396gl.mo1154a(uuid);
                if (z) {
                    return c0555jlA.m2517k().copy().withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID);
                }
                return c0555jlA.m2517k();
            }

            @Override // com.boehmod.blockfront.C0292en.a
            /* JADX INFO: renamed from: a */
            public int mo1599a(@NotNull C0396gl c0396gl, @NotNull UUID uuid, boolean z) {
                return z ? ColorReferences.COLOR_THEME_YELLOW_SOLID : c0396gl.mo1154a(uuid).getStatus().getOnlineStatus().getColor() - 16777216;
            }

            @Override // com.boehmod.blockfront.C0292en.a
            /* JADX INFO: renamed from: a */
            public void mo1600a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, PoseStack poseStack, @NotNull GuiGraphics guiGraphics, UUID uuid, int i, int i2, int i3, int i4) {
                C0129bt.m585a(minecraft, c0623l, poseStack, guiGraphics, c0396gl.mo1154a(uuid).m2522a(), i, i2, i4);
            }
        }),
        FRIEND_REQUEST(new a() { // from class: com.boehmod.blockfront.en.b.2
            @Override // com.boehmod.blockfront.C0292en.a
            /* JADX INFO: renamed from: a */
            public Component mo1597a(@NotNull C0396gl c0396gl, @NotNull UUID uuid) {
                return Component.literal(c0396gl.mo1154a(uuid).getUsername());
            }

            @Override // com.boehmod.blockfront.C0292en.a
            /* JADX INFO: renamed from: a */
            public Component mo1598a(@NotNull C0396gl c0396gl, @NotNull UUID uuid, boolean z) {
                return C0292en.f2288hv;
            }

            @Override // com.boehmod.blockfront.C0292en.a
            /* JADX INFO: renamed from: a */
            public int mo1599a(@NotNull C0396gl c0396gl, @NotNull UUID uuid, boolean z) {
                return z ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_WHITE_SOLID;
            }

            @Override // com.boehmod.blockfront.C0292en.a
            /* JADX INFO: renamed from: a */
            public void mo1600a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, C0396gl c0396gl, PoseStack poseStack, @NotNull GuiGraphics guiGraphics, UUID uuid, int i, int i2, int i3, int i4) {
                C0129bt.m531a(poseStack, guiGraphics, C0292en.f2287bY, i, i2, i3, i4);
            }
        }),
        CLAN_MEMBER(new a() { // from class: com.boehmod.blockfront.en.b.3
            @Override // com.boehmod.blockfront.C0292en.a
            /* JADX INFO: renamed from: a */
            public Component mo1597a(@NotNull C0396gl c0396gl, @NotNull UUID uuid) {
                return Component.literal(c0396gl.mo1154a(uuid).getUsername());
            }

            @Override // com.boehmod.blockfront.C0292en.a
            /* JADX INFO: renamed from: a */
            public Component mo1598a(@NotNull C0396gl c0396gl, @NotNull UUID uuid, boolean z) {
                int i;
                C0555jl c0555jlA = c0396gl.mo1154a(uuid);
                PublicPlayerStatus status = c0555jlA.getStatus();
                if (z) {
                    i = ColorReferences.COLOR_THEME_CLANS_HOVERED_SOLID;
                } else {
                    i = status.getOnlineStatus().isOnline() ? ColorReferences.COLOR_THEME_CLANS_SOLID : ColorReferences.COLOR_THEME_CLANS_MUTED_SOLID;
                }
                return c0555jlA.m2517k().copy().withColor(i);
            }

            @Override // com.boehmod.blockfront.C0292en.a
            /* JADX INFO: renamed from: a */
            public int mo1599a(@NotNull C0396gl c0396gl, @NotNull UUID uuid, boolean z) {
                PublicPlayerStatus status = c0396gl.mo1154a(uuid).getStatus();
                if (z) {
                    return ColorReferences.COLOR_THEME_CLANS_HOVERED_SOLID;
                }
                return status.getOnlineStatus().isOnline() ? ColorReferences.COLOR_THEME_CLANS_SOLID : ColorReferences.COLOR_THEME_CLANS_MUTED_SOLID;
            }

            @Override // com.boehmod.blockfront.C0292en.a
            /* JADX INFO: renamed from: a */
            public void mo1600a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, C0396gl c0396gl, PoseStack poseStack, @NotNull GuiGraphics guiGraphics, UUID uuid, int i, int i2, int i3, int i4) {
                C0129bt.m585a(minecraft, c0623l, poseStack, guiGraphics, c0396gl.mo1154a(uuid).m2522a(), i, i2, i4);
            }
        }),
        CLAN_INVITE(new a() { // from class: com.boehmod.blockfront.en.b.4
            @Override // com.boehmod.blockfront.C0292en.a
            /* JADX INFO: renamed from: a */
            public Component mo1597a(@NotNull C0396gl c0396gl, @NotNull UUID uuid) {
                return Component.literal(c0396gl.mo1154a(uuid).getName());
            }

            @Override // com.boehmod.blockfront.C0292en.a
            /* JADX INFO: renamed from: a */
            public Component mo1598a(@NotNull C0396gl c0396gl, @NotNull UUID uuid, boolean z) {
                return Component.literal(c0396gl.mo1154a(c0396gl.mo1154a(uuid).getOwner()).getUsername());
            }

            @Override // com.boehmod.blockfront.C0292en.a
            /* JADX INFO: renamed from: a */
            public int mo1599a(@NotNull C0396gl c0396gl, @NotNull UUID uuid, boolean z) {
                return z ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_THEME_CLANS_HOVERED_SOLID;
            }

            @Override // com.boehmod.blockfront.C0292en.a
            /* JADX INFO: renamed from: a */
            public void mo1600a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, C0396gl c0396gl, PoseStack poseStack, @NotNull GuiGraphics guiGraphics, UUID uuid, int i, int i2, int i3, int i4) {
                C0129bt.m537a(poseStack, guiGraphics, C0292en.f2287bY, i, i2, i3, i4, 0.0f, 1.0f, ColorReferences.COLOR_THEME_CLANS_HOVERED_SOLID);
            }
        });

        private final a slotInfo;

        b(a aVar) {
            this.slotInfo = aVar;
        }

        public a getSlotInfo() {
            return this.slotInfo;
        }
    }
}
