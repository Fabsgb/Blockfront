package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p001mm.MatchParty;
import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendJoinGame;
import com.boehmod.bflib.cloud.packet.common.p002mm.PacketMMSearchHostCanceled;
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
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.eD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eD.class */
public final class C0256eD extends AbstractC0302ex {

    /* JADX INFO: renamed from: jo */
    private static final int f2102jo = 872415231;

    /* JADX INFO: renamed from: jp */
    public static final int f2103jp = 1;

    /* JADX INFO: renamed from: jq */
    public static final int f2104jq = 1;

    /* JADX INFO: renamed from: jr */
    public static final int f2105jr = 16;

    /* JADX INFO: renamed from: eg */
    private static final float f2109eg = 0.5f;

    /* JADX INFO: renamed from: ci */
    private boolean f2113ci;

    /* JADX INFO: renamed from: fv */
    private int f2114fv;

    /* JADX INFO: renamed from: js */
    private int f2115js;

    /* JADX INFO: renamed from: I */
    @NotNull
    private List<UUID> f2116I;

    /* JADX INFO: renamed from: co */
    @NotNull
    private static final ResourceLocation f2100co = C0532jO.m2378d("textures/gui/menu/icons/party_leave.png");

    /* JADX INFO: renamed from: cp */
    @NotNull
    private static final ResourceLocation f2101cp = C0532jO.m2378d("textures/gui/menu/icons/party_create.png");

    /* JADX INFO: renamed from: hK */
    @NotNull
    private static final Component f2106hK = Component.translatable("bf.menu.lobby.button.party.create");

    /* JADX INFO: renamed from: hL */
    @NotNull
    private static final Component f2107hL = Component.translatable("bf.menu.lobby.button.party.leave");

    /* JADX INFO: renamed from: hM */
    @NotNull
    private static final Component f2108hM = Component.translatable("bf.message.party.leader").withStyle(ChatFormatting.AQUA);

    /* JADX INFO: renamed from: cq */
    @NotNull
    private static final ResourceLocation f2110cq = C0532jO.m2378d("textures/gui/indicator.png");

    /* JADX INFO: renamed from: cr */
    @NotNull
    private static final ResourceLocation f2111cr = C0532jO.m2378d("textures/gui/menu/icons/play.png");

    /* JADX INFO: renamed from: hN */
    @NotNull
    private static final Component f2112hN = Component.translatable("bf.dropdown.text.game.join");

    public C0256eD(int i, int i2) {
        super(i, i2, m1456aj(), m1457g(1), Component.empty());
        this.f2113ci = false;
        this.f2114fv = -1;
        this.f2115js = -1;
        this.f2116I = new ObjectArrayList();
    }

    @Override // com.boehmod.blockfront.AbstractC0302ex
    /* JADX INFO: renamed from: a */
    protected void mo1440a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull C0555jl c0555jl, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        PoseStack poseStackPose = guiGraphics.pose();
        MatchParty matchPartyOrElse = c0555jl.getParty().orElse(null);
        this.f2116I = m1455a(matchPartyOrElse);
        this.f2113ci = m1452a(minecraft, c0396gl, matchPartyOrElse);
        setWidth(m1456aj());
        setHeight(m1457g(this.f2116I.size() + 1 + (this.f2113ci ? 1 : 0)));
        this.f2114fv = isHovered() ? m1453a(matchPartyOrElse, i, i2, this.f2113ci) : -1;
        if (this.f2114fv >= 0 && this.f2114fv != this.f2115js) {
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7971ps.get(), (float) (0.8999999761581421d + (0.10000000149011612d * Math.random()))));
        }
        this.f2115js = this.f2114fv;
        m1454a(minecraft, c0623l, poseStackPose, guiGraphics, matchPartyOrElse, getX(), getY(), this.f2114fv, false, false, 16, this.f2113ci);
    }

    @Override // com.boehmod.blockfront.AbstractC0302ex
    @NotNull
    /* JADX INFO: renamed from: a */
    protected List<Component> mo1441a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0555jl c0555jl) {
        if (this.f2114fv < 0) {
            return List.of();
        }
        C0396gl c0396gl = (C0396gl) c0623l.m2855a();
        ObjectArrayList objectArrayList = new ObjectArrayList();
        if (this.f2114fv == 0) {
            objectArrayList.add(c0555jl.getParty().isPresent() ? f2107hL : f2106hK);
        } else if (this.f2113ci && this.f2114fv == this.f2116I.size() + 1) {
            objectArrayList.add(f2112hN);
        } else {
            MatchParty matchPartyOrElse = c0555jl.getParty().orElse(null);
            UUID uuid = this.f2116I.get(this.f2114fv - 1);
            C0555jl c0555jlA = c0396gl.mo1154a(uuid);
            objectArrayList.add(Component.literal(c0555jlA.getUsername()));
            objectArrayList.add(c0555jlA.m2517k());
            if (matchPartyOrElse != null && matchPartyOrElse.isHost(uuid)) {
                objectArrayList.add(f2108hM);
            }
        }
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0302ex
    /* JADX INFO: renamed from: F */
    protected boolean mo1444F() {
        return true;
    }

    public void onClick(double d, double d2) {
        Minecraft minecraft = Minecraft.getInstance();
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b == null) {
            return;
        }
        C0396gl c0396gl = (C0396gl) c0623lM2852b.m2855a();
        MatchParty matchPartyOrElse = c0396gl.m1886a(minecraft).getParty().orElse(null);
        boolean zM1452a = m1452a(minecraft, c0396gl, matchPartyOrElse);
        int iM1453a = m1453a(matchPartyOrElse, d, d2, zM1452a);
        if (iM1453a == 0) {
            C0358g c0358g = (C0358g) c0623lM2852b.m2852b();
            if (matchPartyOrElse != null) {
                c0358g.sendPacket(new PacketPartyLeave());
            } else {
                c0358g.sendPacket(new PacketPartyCreate());
            }
            c0358g.sendPacket(new PacketMMSearchHostCanceled());
            c0623lM2852b.m2885a().m2587a(false);
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7970pr.get(), 1.0f));
            return;
        }
        List<UUID> listM1455a = m1455a(matchPartyOrElse);
        if (zM1452a && iM1453a == listM1455a.size() + 1) {
            UUID host = matchPartyOrElse.getHost();
            c0623lM2852b.m2885a().m2581b(c0396gl.mo1154a(host).getUsername());
            ((C0358g) c0623lM2852b.m2852b()).sendPacket(new PacketFriendJoinGame(host));
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7970pr.get(), 1.0f));
            return;
        }
        if (iM1453a > 0 && iM1453a <= listM1455a.size()) {
            UUID uuid = listM1455a.get(iM1453a - 1);
            C0555jl c0555jlA = c0396gl.mo1154a(uuid);
            UUID profileId = minecraft.getUser().getProfileId();
            boolean z = matchPartyOrElse != null && matchPartyOrElse.isHost(uuid);
            boolean z2 = (matchPartyOrElse == null || !matchPartyOrElse.isHost(profileId) || uuid.equals(profileId)) ? false : true;
            minecraft.setScreen(new C0093bJ(minecraft.screen, (int) (d + 2.0d), (int) (d2 + 2.0d), c0555jlA, z && !uuid.equals(profileId) && c0555jlA.getStatus().isInGame(), z2));
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m1452a(@NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @Nullable MatchParty matchParty) {
        if (matchParty == null) {
            return false;
        }
        UUID host = matchParty.getHost();
        if (host.equals(minecraft.getUser().getProfileId())) {
            return false;
        }
        return c0396gl.mo1154a(host).getStatus().isInGame();
    }

    /* JADX INFO: renamed from: a */
    private int m1453a(@Nullable MatchParty matchParty, double d, double d2, boolean z) {
        int size = m1455a(matchParty).size() + 1 + (z ? 1 : 0);
        int x = getX() + 1;
        if (d < x || d >= x + 16) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            int iM1463a = m1463a(getY(), i, 16);
            if (d2 >= iM1463a && d2 < iM1463a + 16) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    public static void m1454a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @Nullable MatchParty matchParty, int i, int i2, int i3, boolean z, boolean z2, int i4, boolean z3) {
        List<UUID> listM1455a = m1455a(matchParty);
        int size = z ? listM1455a.size() : listM1455a.size() + 1 + (z3 ? 1 : 0);
        if (size <= 0) {
            return;
        }
        int iM1461c = z2 ? m1461c(size, i4) : m1462i(i4);
        int iM1462i = z2 ? m1462i(i4) : m1461c(size, i4);
        C0129bt.m593c(guiGraphics, i, i2, iM1461c, iM1462i, C0129bt.m465t(), 0.5f);
        int i5 = z ? 0 : 1;
        if (!z) {
            int iM1463a = z2 ? m1463a(i, 0, i4) : i + 1;
            int iM1463a2 = z2 ? i2 + 1 : m1463a(i2, 0, i4);
            C0129bt.m529a(poseStack, guiGraphics, matchParty == null ? f2101cp : f2100co, iM1463a, iM1463a2, i4);
            if (i3 == 0) {
                C0129bt.m515a(guiGraphics, iM1463a, iM1463a2, i4, i4, 872415231);
            }
        }
        C0396gl c0396gl = (C0396gl) c0623l.m2855a();
        for (int i6 = 0; i6 < listM1455a.size(); i6++) {
            UUID uuid = listM1455a.get(i6);
            int i7 = i6 + i5;
            int iM1463a3 = z2 ? m1463a(i, i7, i4) : i + 1;
            int iM1463a4 = z2 ? i2 + 1 : m1463a(i2, i7, i4);
            GameProfile gameProfileM2522a = c0396gl.mo1154a(uuid).m2522a();
            if (z) {
                RenderSystem.enableBlend();
                RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 0.5f);
            }
            C0129bt.m585a(minecraft, c0623l, poseStack, guiGraphics, gameProfileM2522a, iM1463a3, iM1463a4, i4);
            if (matchParty != null && matchParty.isHost(uuid)) {
                C0129bt.m537a(poseStack, guiGraphics, f2110cq, iM1463a3 - 1, iM1463a4 - 1, 3, 3, 0.0f, 1.0f, ChatFormatting.AQUA.getColor().intValue());
            }
            if (!z && i3 == i7) {
                C0129bt.m515a(guiGraphics, iM1463a3, iM1463a4, i4, i4, 872415231);
            }
        }
        if (!z && z3) {
            int size2 = listM1455a.size() + 1;
            int iM1463a5 = z2 ? m1463a(i, size2, i4) : i + 1;
            int iM1463a6 = z2 ? i2 + 1 : m1463a(i2, size2, i4);
            C0129bt.m529a(poseStack, guiGraphics, f2111cr, iM1463a5, iM1463a6, i4);
            if (i3 == size2) {
                C0129bt.m515a(guiGraphics, iM1463a5, iM1463a6, i4, i4, 872415231);
            }
        }
        if (z && z2 && matchParty != null && matchParty.isSearching()) {
            MutableComponent mutableComponentLiteral = Component.literal(" " + c0623l.m2885a().m2575a().toString().toUpperCase(Locale.ROOT));
            MutableComponent mutableComponentTranslatable = Component.translatable("bf.menu.lobby.searching");
            MutableComponent mutableComponentWithStyle = mutableComponentTranslatable.copy().append(mutableComponentLiteral).append(C0125bp.m439a(C0129bt.m466g())).withStyle(ChatFormatting.AQUA);
            int iWidth = minecraft.font.width(mutableComponentTranslatable) + 32;
            int i8 = i + iM1461c + 2;
            Objects.requireNonNull(minecraft.font);
            int i9 = ((i2 + (iM1462i / 2)) - (9 / 2)) - 2;
            C0129bt.m591c(guiGraphics, i8, i9, iWidth, iM1462i, C0129bt.m465t());
            C0129bt.m499a(poseStack, minecraft.font, guiGraphics, (Component) mutableComponentWithStyle, i8 + (iWidth / 2), i9 + 3);
        }
        if (z) {
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
            RenderSystem.disableBlend();
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static List<UUID> m1455a(@Nullable MatchParty matchParty) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        if (matchParty == null) {
            return objectArrayList;
        }
        objectArrayList.add(matchParty.getHost());
        objectArrayList.addAll(matchParty.getMembers());
        return objectArrayList;
    }

    /* JADX INFO: renamed from: aj */
    public static int m1456aj() {
        return m1462i(16);
    }

    /* JADX INFO: renamed from: g */
    public static int m1457g(int i) {
        return m1461c(i, 16);
    }

    /* JADX INFO: renamed from: a */
    public static int m1458a(@Nullable MatchParty matchParty, boolean z, int i) {
        return z ? m1461c(m1455a(matchParty).size(), i) : m1462i(i);
    }

    /* JADX INFO: renamed from: b */
    public static int m1459b(@Nullable MatchParty matchParty, boolean z, int i) {
        return z ? m1462i(i) : m1461c(m1455a(matchParty).size(), i);
    }

    /* JADX INFO: renamed from: h */
    public static int m1460h(int i) {
        return i - 2;
    }

    /* JADX INFO: renamed from: c */
    private static int m1461c(int i, int i2) {
        return 2 + (i * i2) + ((i - 1) * 1);
    }

    /* JADX INFO: renamed from: i */
    private static int m1462i(int i) {
        return i + 2;
    }

    /* JADX INFO: renamed from: a */
    private static int m1463a(int i, int i2, int i3) {
        return i + 1 + (i2 * (i3 + 1));
    }
}
