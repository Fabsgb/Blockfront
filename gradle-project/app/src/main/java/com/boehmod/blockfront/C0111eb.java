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

/* JADX INFO: renamed from: com.boehmod.blockfront.eb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eb.class */
public final class C0111eb extends AbstractC0116eg {

    @NotNull
    private static final ResourceLocation ca;
    public static final Component hn;

    @NotNull
    private final Screen m;

    @NotNull
    private final UUID h;

    @NotNull
    private final iS e;

    @NotNull
    private final b a;
    static final /* synthetic */ boolean bO;

    /* JADX INFO: renamed from: com.boehmod.blockfront.eb$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eb$a.class */
    public interface a {
        Component a(@NotNull fV fVVar, @NotNull UUID uuid);

        Component a(@NotNull fV fVVar, @NotNull UUID uuid, boolean z);

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        int mo377a(@NotNull fV fVVar, @NotNull UUID uuid, boolean z);

        void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, fV fVVar, PoseStack poseStack, @NotNull GuiGraphics guiGraphics, UUID uuid, int i, int i2, int i3, int i4);
    }

    static {
        bO = !C0111eb.class.desiredAssertionStatus();
        ca = C0265jv.d("textures/gui/invites/friend.png");
        hn = Component.translatable("bf.status.friend.request").withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID);
    }

    public C0111eb(@NotNull Screen screen, @NotNull UUID uuid, @NotNull b bVar) {
        this.m = screen;
        this.h = uuid;
        this.a = bVar;
        C0297l c0297lB = C0297l.b();
        if (!bO && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        this.e = ((fV) c0297lB.a()).mo306a(uuid);
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public void b(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull GuiGraphics guiGraphics, @NotNull fV fVVar, @NotNull Font font, int i, int i2, float f, float f2) {
        super.b(poseStack, minecraft, c0297l, guiGraphics, fVVar, font, i, i2, f, f2);
        if (D() && this.a == b.FRIEND) {
            guiGraphics.renderTooltip(font, fVVar.mo306a(this.h).c(), Optional.empty(), i, i2);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, int i, int i2, float f) {
        int iHeight = height() - 2;
        this.a.slotInfo.a(minecraft, c0297l, fVVar, poseStack, guiGraphics, this.h, this.hI + 1, this.hJ + 1, iHeight, iHeight);
        C0040bk.a(fVVar, guiGraphics, font, this.h, this.a, this.hI + iHeight + 1, this.hJ, height(), D());
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, int i, int i2, int i3) {
        int iK = (int) this.a.k(1.0f);
        switch (this.a) {
            case FRIEND:
                minecraft.setScreen(new C0054by(this.m, this.hI + mo265t(), this.hJ - iK, 100, 15, this.e));
                break;
            case FRIEND_REQUEST:
                minecraft.setScreen(new C0055bz(this.m, this.hI + mo265t(), this.hJ - iK, 100, 15, this.e));
                break;
            case CLAN_MEMBER:
                minecraft.setScreen(new C0053bx(this.m, this.hI + mo265t(), this.hJ - iK, 100, 15, this.e));
                break;
            case CLAN_INVITE:
                minecraft.setScreen(new C0052bw(this.m, this.hI + mo265t(), this.hJ - iK, 100, 15, this.h));
                break;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public void n(@NotNull Minecraft minecraft) {
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public boolean v() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public int height() {
        return 22;
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    /* JADX INFO: renamed from: t */
    public int mo265t() {
        return this.a.t();
    }

    @Override // com.boehmod.blockfront.AbstractC0116eg
    public int S() {
        return 1;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.eb$b */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eb$b.class */
    public enum b {
        FRIEND(new a() { // from class: com.boehmod.blockfront.eb.b.1
            @Override // com.boehmod.blockfront.C0111eb.a
            public Component a(@NotNull fV fVVar, @NotNull UUID uuid) {
                return Component.literal(fVVar.mo306a(uuid).getUsername());
            }

            @Override // com.boehmod.blockfront.C0111eb.a
            public Component a(@NotNull fV fVVar, @NotNull UUID uuid, boolean z) {
                iS iSVarA = fVVar.mo306a(uuid);
                if (z) {
                    return iSVarA.k().copy().withColor(ColorReferences.COLOR_THEME_YELLOW_SOLID);
                }
                return iSVarA.k();
            }

            @Override // com.boehmod.blockfront.C0111eb.a
            /* JADX INFO: renamed from: a */
            public int mo377a(@NotNull fV fVVar, @NotNull UUID uuid, boolean z) {
                return z ? ColorReferences.COLOR_THEME_YELLOW_SOLID : fVVar.mo306a(uuid).getStatus().getOnlineStatus().getColor() - 16777216;
            }

            @Override // com.boehmod.blockfront.C0111eb.a
            public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, PoseStack poseStack, @NotNull GuiGraphics guiGraphics, UUID uuid, int i, int i2, int i3, int i4) {
                C0040bk.a(minecraft, c0297l, poseStack, guiGraphics, fVVar.mo306a(uuid).m491a(), i, i2, i4);
            }
        }),
        FRIEND_REQUEST(new a() { // from class: com.boehmod.blockfront.eb.b.2
            @Override // com.boehmod.blockfront.C0111eb.a
            public Component a(@NotNull fV fVVar, @NotNull UUID uuid) {
                return Component.literal(fVVar.mo306a(uuid).getUsername());
            }

            @Override // com.boehmod.blockfront.C0111eb.a
            public Component a(@NotNull fV fVVar, @NotNull UUID uuid, boolean z) {
                return C0111eb.hn;
            }

            @Override // com.boehmod.blockfront.C0111eb.a
            /* JADX INFO: renamed from: a */
            public int mo377a(@NotNull fV fVVar, @NotNull UUID uuid, boolean z) {
                return z ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_WHITE_SOLID;
            }

            @Override // com.boehmod.blockfront.C0111eb.a
            public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, fV fVVar, PoseStack poseStack, @NotNull GuiGraphics guiGraphics, UUID uuid, int i, int i2, int i3, int i4) {
                C0040bk.a(poseStack, guiGraphics, C0111eb.ca, i, i2, i3, i4);
            }
        }),
        CLAN_MEMBER(new a() { // from class: com.boehmod.blockfront.eb.b.3
            @Override // com.boehmod.blockfront.C0111eb.a
            public Component a(@NotNull fV fVVar, @NotNull UUID uuid) {
                return Component.literal(fVVar.mo306a(uuid).getUsername());
            }

            @Override // com.boehmod.blockfront.C0111eb.a
            public Component a(@NotNull fV fVVar, @NotNull UUID uuid, boolean z) {
                iS iSVarA = fVVar.mo306a(uuid);
                return iSVarA.k().copy().withColor(z ? ColorReferences.COLOR_THEME_CLANS_HOVERED_SOLID : iSVarA.getStatus().getOnlineStatus().isOnline() ? ColorReferences.COLOR_THEME_CLANS_SOLID : ColorReferences.COLOR_THEME_CLANS_MUTED_SOLID);
            }

            @Override // com.boehmod.blockfront.C0111eb.a
            /* JADX INFO: renamed from: a */
            public int mo377a(@NotNull fV fVVar, @NotNull UUID uuid, boolean z) {
                return z ? ColorReferences.COLOR_THEME_CLANS_HOVERED_SOLID : fVVar.mo306a(uuid).getStatus().getOnlineStatus().isOnline() ? ColorReferences.COLOR_THEME_CLANS_SOLID : ColorReferences.COLOR_THEME_CLANS_MUTED_SOLID;
            }

            @Override // com.boehmod.blockfront.C0111eb.a
            public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, fV fVVar, PoseStack poseStack, @NotNull GuiGraphics guiGraphics, UUID uuid, int i, int i2, int i3, int i4) {
                C0040bk.a(minecraft, c0297l, poseStack, guiGraphics, fVVar.mo306a(uuid).m491a(), i, i2, i4);
            }
        }),
        CLAN_INVITE(new a() { // from class: com.boehmod.blockfront.eb.b.4
            @Override // com.boehmod.blockfront.C0111eb.a
            public Component a(@NotNull fV fVVar, @NotNull UUID uuid) {
                return Component.literal(fVVar.mo306a(uuid).getName());
            }

            @Override // com.boehmod.blockfront.C0111eb.a
            public Component a(@NotNull fV fVVar, @NotNull UUID uuid, boolean z) {
                return Component.literal(fVVar.mo306a(fVVar.mo306a(uuid).getOwner()).getUsername());
            }

            @Override // com.boehmod.blockfront.C0111eb.a
            /* JADX INFO: renamed from: a */
            public int mo377a(@NotNull fV fVVar, @NotNull UUID uuid, boolean z) {
                return z ? ColorReferences.COLOR_THEME_YELLOW_SOLID : ColorReferences.COLOR_THEME_CLANS_HOVERED_SOLID;
            }

            @Override // com.boehmod.blockfront.C0111eb.a
            public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, fV fVVar, PoseStack poseStack, @NotNull GuiGraphics guiGraphics, UUID uuid, int i, int i2, int i3, int i4) {
                C0040bk.a(poseStack, guiGraphics, C0111eb.ca, i, i2, i3, i4, 0.0f, 1.0f, ColorReferences.COLOR_THEME_CLANS_HOVERED_SOLID);
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
