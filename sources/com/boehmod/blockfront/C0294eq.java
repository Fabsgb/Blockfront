package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p000mm.MatchParty;
import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendJoinGame;
import com.boehmod.bflib.cloud.packet.common.p001mm.PacketMMSearchHostCanceled;
import com.boehmod.bflib.cloud.packet.common.party.PacketPartyCreate;
import com.boehmod.bflib.cloud.packet.common.party.PacketPartyLeave;
import com.mojang.authlib.GameProfile;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.eq */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eq.class */
public final class C0294eq extends AbstractC0288ek {

    /* JADX INFO: renamed from: hY */
    private static final int f2232hY = 872415231;

    /* JADX INFO: renamed from: hZ */
    public static final int f2233hZ = 1;

    /* JADX INFO: renamed from: ia */
    public static final int f2234ia = 1;

    /* JADX INFO: renamed from: ib */
    public static final int f2235ib = 16;

    /* JADX INFO: renamed from: ed */
    private static final float f2239ed = 0.5f;

    /* JADX INFO: renamed from: ca */
    private boolean f2243ca;

    /* JADX INFO: renamed from: ev */
    private int f2244ev;

    /* JADX INFO: renamed from: ic */
    private int f2245ic;

    /* JADX INFO: renamed from: G */
    @NotNull
    private List<UUID> f2246G;

    /* JADX INFO: renamed from: cp */
    @NotNull
    private static final ResourceLocation f2230cp = C0564jv.m2555d("textures/gui/menu/icons/party_leave.png");

    /* JADX INFO: renamed from: cq */
    @NotNull
    private static final ResourceLocation f2231cq = C0564jv.m2555d("textures/gui/menu/icons/party_create.png");

    /* JADX INFO: renamed from: hB */
    @NotNull
    private static final Component f2236hB = Component.translatable("bf.menu.lobby.button.party.create");

    /* JADX INFO: renamed from: hC */
    @NotNull
    private static final Component f2237hC = Component.translatable("bf.menu.lobby.button.party.leave");

    /* JADX INFO: renamed from: hD */
    @NotNull
    private static final Component f2238hD = Component.translatable("bf.message.party.leader").withStyle(ChatFormatting.AQUA);

    /* JADX INFO: renamed from: cr */
    @NotNull
    private static final ResourceLocation f2240cr = C0564jv.m2555d("textures/gui/indicator.png");

    /* JADX INFO: renamed from: cs */
    @NotNull
    private static final ResourceLocation f2241cs = C0564jv.m2555d("textures/gui/menu/icons/play.png");

    /* JADX INFO: renamed from: hE */
    @NotNull
    private static final Component f2242hE = Component.translatable("bf.dropdown.text.game.join");

    public C0294eq(int i, int i2) {
        super(i, i2, m1554Z(), m1555g(1), Component.empty());
        this.f2243ca = false;
        this.f2244ev = -1;
        this.f2245ic = -1;
        this.f2246G = new ObjectArrayList();
    }

    @Override // com.boehmod.blockfront.AbstractC0288ek
    /* JADX INFO: renamed from: a */
    protected void mo1521a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull C0482iS c0482iS, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        PoseStack poseStackPose = guiGraphics.pose();
        MatchParty matchPartyOrElse = c0482iS.getParty().orElse(null);
        this.f2246G = m1553a(matchPartyOrElse);
        this.f2243ca = m1550a(minecraft, c0326fV, matchPartyOrElse);
        setWidth(m1554Z());
        setHeight(m1555g(this.f2246G.size() + 1 + (this.f2243ca ? 1 : 0)));
        this.f2244ev = isHovered() ? m1551a(matchPartyOrElse, i, i2, this.f2243ca) : -1;
        if (this.f2244ev >= 0 && this.f2244ev != this.f2245ic) {
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7559pq.get(), (float) (0.8999999761581421d + (0.10000000149011612d * Math.random()))));
        }
        this.f2245ic = this.f2244ev;
        m1552a(minecraft, c0622l, poseStackPose, guiGraphics, matchPartyOrElse, getX(), getY(), this.f2244ev, false, false, 16, this.f2243ca);
    }

    @Override // com.boehmod.blockfront.AbstractC0288ek
    @NotNull
    /* JADX INFO: renamed from: a */
    protected List<Component> mo1522a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0482iS c0482iS) {
        if (this.f2244ev < 0) {
            return List.of();
        }
        C0326fV c0326fV = (C0326fV) c0622l.m2670a();
        ObjectArrayList objectArrayList = new ObjectArrayList();
        if (this.f2244ev == 0) {
            objectArrayList.add(c0482iS.getParty().isPresent() ? f2237hC : f2236hB);
        } else if (this.f2243ca && this.f2244ev == this.f2246G.size() + 1) {
            objectArrayList.add(f2242hE);
        } else {
            MatchParty matchPartyOrElse = c0482iS.getParty().orElse(null);
            UUID uuid = this.f2246G.get(this.f2244ev - 1);
            C0482iS c0482iSA = c0326fV.mo1137a(uuid);
            objectArrayList.add(Component.literal(c0482iSA.getUsername()));
            objectArrayList.add(c0482iSA.m2190k());
            if (matchPartyOrElse != null && matchPartyOrElse.isHost(uuid)) {
                objectArrayList.add(f2238hD);
            }
        }
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0288ek
    /* JADX INFO: renamed from: E */
    protected boolean mo1520E() {
        return true;
    }

    public void onClick(double d, double d2) {
        Minecraft minecraft = Minecraft.getInstance();
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b == null) {
            return;
        }
        C0326fV c0326fV = (C0326fV) c0622lM2667b.m2670a();
        MatchParty matchPartyOrElse = c0326fV.m1676a(minecraft).getParty().orElse(null);
        boolean zM1550a = m1550a(minecraft, c0326fV, matchPartyOrElse);
        int iM1551a = m1551a(matchPartyOrElse, d, d2, zM1550a);
        if (iM1551a == 0) {
            C0357g c0357g = (C0357g) c0622lM2667b.m2667b();
            if (matchPartyOrElse != null) {
                c0357g.sendPacket(new PacketPartyLeave());
            } else {
                c0357g.sendPacket(new PacketPartyCreate());
            }
            c0357g.sendPacket(new PacketMMSearchHostCanceled());
            c0622lM2667b.m2699a().m2598a(false);
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7558pp.get(), 1.0f));
            return;
        }
        List<UUID> listM1553a = m1553a(matchPartyOrElse);
        if (zM1550a && iM1551a == listM1553a.size() + 1) {
            UUID host = matchPartyOrElse.getHost();
            C0482iS c0482iSA = c0326fV.mo1137a(host);
            ClientLevel clientLevel = minecraft.level;
            if (clientLevel != null) {
                c0622lM2667b.m2669b(minecraft, clientLevel);
            }
            c0622lM2667b.m2699a().m2592b(c0482iSA.getUsername());
            ((C0357g) c0622lM2667b.m2667b()).sendPacket(new PacketFriendJoinGame(host));
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7558pp.get(), 1.0f));
            return;
        }
        if (iM1551a > 0 && iM1551a <= listM1553a.size()) {
            UUID uuid = listM1553a.get(iM1551a - 1);
            C0482iS c0482iSA2 = c0326fV.mo1137a(uuid);
            UUID profileId = minecraft.getUser().getProfileId();
            boolean z = matchPartyOrElse != null && matchPartyOrElse.isHost(uuid);
            boolean z2 = (matchPartyOrElse == null || !matchPartyOrElse.isHost(profileId) || uuid.equals(profileId)) ? false : true;
            minecraft.setScreen(new C0083bA(minecraft.screen, (int) (d + 2.0d), (int) (d2 + 2.0d), c0482iSA2, z && !uuid.equals(profileId) && c0482iSA2.getStatus().isInGame(), z2));
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m1550a(@NotNull Minecraft minecraft, @NotNull C0326fV c0326fV, @Nullable MatchParty matchParty) {
        if (matchParty == null) {
            return false;
        }
        UUID host = matchParty.getHost();
        if (host.equals(minecraft.getUser().getProfileId())) {
            return false;
        }
        return c0326fV.mo1137a(host).getStatus().isInGame();
    }

    /* JADX INFO: renamed from: a */
    private int m1551a(@Nullable MatchParty matchParty, double d, double d2, boolean z) {
        int size = m1553a(matchParty).size() + 1 + (z ? 1 : 0);
        if (d < getX() + 1 || d >= r0 + 16) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (d2 >= m1561a(getY(), i, 16) && d2 < r0 + 16) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    public static void m1552a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @Nullable MatchParty matchParty, int i, int i2, int i3, boolean z, boolean z2, int i4, boolean z3) {
        List<UUID> listM1553a = m1553a(matchParty);
        int size = z ? listM1553a.size() : listM1553a.size() + 1 + (z3 ? 1 : 0);
        if (size <= 0) {
            return;
        }
        int iM1559b = z2 ? m1559b(size, i4) : m1560i(i4);
        int iM1560i = z2 ? m1560i(i4) : m1559b(size, i4);
        C0119bk.m493c(guiGraphics, i, i2, iM1559b, iM1560i, C0119bk.m365p(), 0.5f);
        int i5 = z ? 0 : 1;
        if (!z) {
            int iM1561a = z2 ? m1561a(i, 0, i4) : i + 1;
            int iM1561a2 = z2 ? i2 + 1 : m1561a(i2, 0, i4);
            C0119bk.m429a(poseStack, guiGraphics, matchParty == null ? f2231cq : f2230cp, iM1561a, iM1561a2, i4);
            if (i3 == 0) {
                C0119bk.m415a(guiGraphics, iM1561a, iM1561a2, i4, i4, 872415231);
            }
        }
        C0326fV c0326fV = (C0326fV) c0622l.m2670a();
        for (int i6 = 0; i6 < listM1553a.size(); i6++) {
            UUID uuid = listM1553a.get(i6);
            int i7 = i6 + i5;
            int iM1561a3 = z2 ? m1561a(i, i7, i4) : i + 1;
            int iM1561a4 = z2 ? i2 + 1 : m1561a(i2, i7, i4);
            GameProfile gameProfileM2195a = c0326fV.mo1137a(uuid).m2195a();
            if (z) {
                RenderSystem.enableBlend();
                RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 0.5f);
            }
            C0119bk.m485a(minecraft, c0622l, poseStack, guiGraphics, gameProfileM2195a, iM1561a3, iM1561a4, i4);
            if (matchParty != null && matchParty.isHost(uuid)) {
                C0119bk.m437a(poseStack, guiGraphics, f2240cr, iM1561a3 - 1, iM1561a4 - 1, 3, 3, 0.0f, 1.0f, ChatFormatting.AQUA.getColor().intValue());
            }
            if (!z && i3 == i7) {
                C0119bk.m415a(guiGraphics, iM1561a3, iM1561a4, i4, i4, 872415231);
            }
        }
        if (!z && z3) {
            int size2 = listM1553a.size() + 1;
            int iM1561a5 = z2 ? m1561a(i, size2, i4) : i + 1;
            int iM1561a6 = z2 ? i2 + 1 : m1561a(i2, size2, i4);
            C0119bk.m429a(poseStack, guiGraphics, f2241cs, iM1561a5, iM1561a6, i4);
            if (i3 == size2) {
                C0119bk.m415a(guiGraphics, iM1561a5, iM1561a6, i4, i4, 872415231);
            }
        }
        if (z && z2 && matchParty != null && matchParty.isSearching()) {
            MutableComponent mutableComponentLiteral = Component.literal(" " + c0622l.m2699a().m2586a().toString().toUpperCase(Locale.ROOT));
            MutableComponent mutableComponentTranslatable = Component.translatable("bf.menu.lobby.searching");
            MutableComponent mutableComponentWithStyle = mutableComponentTranslatable.copy().append(mutableComponentLiteral).append(C0116bh.m346a(C0119bk.m366g())).withStyle(ChatFormatting.AQUA);
            int iWidth = minecraft.font.width(mutableComponentTranslatable) + 32;
            int i8 = i + iM1559b + 2;
            Objects.requireNonNull(minecraft.font);
            int i9 = ((i2 + (iM1560i / 2)) - (9 / 2)) - 2;
            C0119bk.m491c(guiGraphics, i8, i9, iWidth, iM1560i, C0119bk.m365p());
            C0119bk.m399a(poseStack, minecraft.font, guiGraphics, (Component) mutableComponentWithStyle, i8 + (iWidth / 2), i9 + 3);
        }
        if (z) {
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
            RenderSystem.disableBlend();
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static List<UUID> m1553a(@Nullable MatchParty matchParty) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        if (matchParty == null) {
            return objectArrayList;
        }
        objectArrayList.add(matchParty.getHost());
        objectArrayList.addAll(matchParty.getMembers());
        return objectArrayList;
    }

    /* JADX INFO: renamed from: Z */
    public static int m1554Z() {
        return m1560i(16);
    }

    /* JADX INFO: renamed from: g */
    public static int m1555g(int i) {
        return m1559b(i, 16);
    }

    /* JADX INFO: renamed from: a */
    public static int m1556a(@Nullable MatchParty matchParty, boolean z, int i) {
        return z ? m1559b(m1553a(matchParty).size(), i) : m1560i(i);
    }

    /* JADX INFO: renamed from: b */
    public static int m1557b(@Nullable MatchParty matchParty, boolean z, int i) {
        return z ? m1560i(i) : m1559b(m1553a(matchParty).size(), i);
    }

    /* JADX INFO: renamed from: h */
    public static int m1558h(int i) {
        return i - 2;
    }

    /* JADX INFO: renamed from: b */
    private static int m1559b(int i, int i2) {
        return 2 + (i * i2) + ((i - 1) * 1);
    }

    /* JADX INFO: renamed from: i */
    private static int m1560i(int i) {
        return i + 2;
    }

    /* JADX INFO: renamed from: a */
    private static int m1561a(int i, int i2, int i3) {
        return i + 1 + (i2 * (i3 + 1));
    }
}
