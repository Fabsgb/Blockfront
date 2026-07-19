package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.mm.MatchParty;
import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendJoinGame;
import com.boehmod.bflib.cloud.packet.common.mm.PacketMMSearchHostCanceled;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.eq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eq.class */
public final class C0126eq extends AbstractC0120ek {
    private static final int hY = 872415231;
    public static final int hZ = 1;
    public static final int ia = 1;
    public static final int ib = 16;
    private static final float ed = 0.5f;
    private boolean ca;
    private int ev;
    private int ic;

    @NotNull
    private List<UUID> G;

    @NotNull
    private static final ResourceLocation cp = C0265jv.d("textures/gui/menu/icons/party_leave.png");

    @NotNull
    private static final ResourceLocation cq = C0265jv.d("textures/gui/menu/icons/party_create.png");

    @NotNull
    private static final Component hB = Component.translatable("bf.menu.lobby.button.party.create");

    @NotNull
    private static final Component hC = Component.translatable("bf.menu.lobby.button.party.leave");

    @NotNull
    private static final Component hD = Component.translatable("bf.message.party.leader").withStyle(ChatFormatting.AQUA);

    @NotNull
    private static final ResourceLocation cr = C0265jv.d("textures/gui/indicator.png");

    @NotNull
    private static final ResourceLocation cs = C0265jv.d("textures/gui/menu/icons/play.png");

    @NotNull
    private static final Component hE = Component.translatable("bf.dropdown.text.game.join");

    public C0126eq(int i, int i2) {
        super(i, i2, Z(), g(1), Component.empty());
        this.ca = false;
        this.ev = -1;
        this.ic = -1;
        this.G = new ObjectArrayList();
    }

    @Override // com.boehmod.blockfront.AbstractC0120ek
    protected void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull iS iSVar, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        PoseStack poseStackPose = guiGraphics.pose();
        MatchParty matchPartyOrElse = iSVar.getParty().orElse(null);
        this.G = a(matchPartyOrElse);
        this.ca = a(minecraft, fVVar, matchPartyOrElse);
        setWidth(Z());
        setHeight(g(this.G.size() + 1 + (this.ca ? 1 : 0)));
        this.ev = isHovered() ? a(matchPartyOrElse, i, i2, this.ca) : -1;
        if (this.ev >= 0 && this.ev != this.ic) {
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pq.get(), (float) (0.8999999761581421d + (0.10000000149011612d * Math.random()))));
        }
        this.ic = this.ev;
        a(minecraft, c0297l, poseStackPose, guiGraphics, matchPartyOrElse, getX(), getY(), this.ev, false, false, 16, this.ca);
    }

    @Override // com.boehmod.blockfront.AbstractC0120ek
    @NotNull
    protected List<Component> a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull iS iSVar) {
        if (this.ev < 0) {
            return List.of();
        }
        fV fVVar = (fV) c0297l.a();
        ObjectArrayList objectArrayList = new ObjectArrayList();
        if (this.ev == 0) {
            objectArrayList.add(iSVar.getParty().isPresent() ? hC : hB);
        } else if (this.ca && this.ev == this.G.size() + 1) {
            objectArrayList.add(hE);
        } else {
            MatchParty matchPartyOrElse = iSVar.getParty().orElse(null);
            UUID uuid = this.G.get(this.ev - 1);
            iS iSVarA = fVVar.mo306a(uuid);
            objectArrayList.add(Component.literal(iSVarA.getUsername()));
            objectArrayList.add(iSVarA.k());
            if (matchPartyOrElse != null && matchPartyOrElse.isHost(uuid)) {
                objectArrayList.add(hD);
            }
        }
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0120ek
    protected boolean E() {
        return true;
    }

    public void onClick(double d, double d2) {
        Minecraft minecraft = Minecraft.getInstance();
        C0297l c0297lB = C0297l.b();
        if (c0297lB == null) {
            return;
        }
        fV fVVar = (fV) c0297lB.a();
        MatchParty matchPartyOrElse = fVVar.m404a(minecraft).getParty().orElse(null);
        boolean zA = a(minecraft, fVVar, matchPartyOrElse);
        int iA = a(matchPartyOrElse, d, d2, zA);
        if (iA == 0) {
            C0163g c0163g = (C0163g) c0297lB.b();
            if (matchPartyOrElse != null) {
                c0163g.sendPacket(new PacketPartyLeave());
            } else {
                c0163g.sendPacket(new PacketPartyCreate());
            }
            c0163g.sendPacket(new PacketMMSearchHostCanceled());
            c0297lB.m596a().a(false);
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pp.get(), 1.0f));
            return;
        }
        List<UUID> listA = a(matchPartyOrElse);
        if (zA && iA == listA.size() + 1) {
            UUID host = matchPartyOrElse.getHost();
            iS iSVarA = fVVar.mo306a(host);
            ClientLevel clientLevel = minecraft.level;
            if (clientLevel != null) {
                c0297lB.b(minecraft, clientLevel);
            }
            c0297lB.m596a().b(iSVarA.getUsername());
            ((C0163g) c0297lB.b()).sendPacket(new PacketFriendJoinGame(host));
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pp.get(), 1.0f));
            return;
        }
        if (iA > 0 && iA <= listA.size()) {
            UUID uuid = listA.get(iA - 1);
            iS iSVarA2 = fVVar.mo306a(uuid);
            UUID profileId = minecraft.getUser().getProfileId();
            boolean z = matchPartyOrElse != null && matchPartyOrElse.isHost(uuid);
            boolean z2 = (matchPartyOrElse == null || !matchPartyOrElse.isHost(profileId) || uuid.equals(profileId)) ? false : true;
            minecraft.setScreen(new bA(minecraft.screen, (int) (d + 2.0d), (int) (d2 + 2.0d), iSVarA2, z && !uuid.equals(profileId) && iSVarA2.getStatus().isInGame(), z2));
        }
    }

    private static boolean a(@NotNull Minecraft minecraft, @NotNull fV fVVar, @Nullable MatchParty matchParty) {
        if (matchParty == null) {
            return false;
        }
        UUID host = matchParty.getHost();
        if (host.equals(minecraft.getUser().getProfileId())) {
            return false;
        }
        return fVVar.mo306a(host).getStatus().isInGame();
    }

    private int a(@Nullable MatchParty matchParty, double d, double d2, boolean z) {
        int size = a(matchParty).size() + 1 + (z ? 1 : 0);
        if (d < getX() + 1 || d >= r0 + 16) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (d2 >= a(getY(), i, 16) && d2 < r0 + 16) {
                return i;
            }
        }
        return -1;
    }

    public static void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @Nullable MatchParty matchParty, int i, int i2, int i3, boolean z, boolean z2, int i4, boolean z3) {
        List<UUID> listA = a(matchParty);
        int size = z ? listA.size() : listA.size() + 1 + (z3 ? 1 : 0);
        if (size <= 0) {
            return;
        }
        int iB = z2 ? b(size, i4) : i(i4);
        int i5 = z2 ? i(i4) : b(size, i4);
        C0040bk.c(guiGraphics, i, i2, iB, i5, C0040bk.p(), 0.5f);
        int i6 = z ? 0 : 1;
        if (!z) {
            int iA = z2 ? a(i, 0, i4) : i + 1;
            int iA2 = z2 ? i2 + 1 : a(i2, 0, i4);
            C0040bk.a(poseStack, guiGraphics, matchParty == null ? cq : cp, iA, iA2, i4);
            if (i3 == 0) {
                C0040bk.a(guiGraphics, iA, iA2, i4, i4, 872415231);
            }
        }
        fV fVVar = (fV) c0297l.a();
        for (int i7 = 0; i7 < listA.size(); i7++) {
            UUID uuid = listA.get(i7);
            int i8 = i7 + i6;
            int iA3 = z2 ? a(i, i8, i4) : i + 1;
            int iA4 = z2 ? i2 + 1 : a(i2, i8, i4);
            GameProfile gameProfileM491a = fVVar.mo306a(uuid).m491a();
            if (z) {
                RenderSystem.enableBlend();
                RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 0.5f);
            }
            C0040bk.a(minecraft, c0297l, poseStack, guiGraphics, gameProfileM491a, iA3, iA4, i4);
            if (matchParty != null && matchParty.isHost(uuid)) {
                C0040bk.a(poseStack, guiGraphics, cr, iA3 - 1, iA4 - 1, 3, 3, 0.0f, 1.0f, ChatFormatting.AQUA.getColor().intValue());
            }
            if (!z && i3 == i8) {
                C0040bk.a(guiGraphics, iA3, iA4, i4, i4, 872415231);
            }
        }
        if (!z && z3) {
            int size2 = listA.size() + 1;
            int iA5 = z2 ? a(i, size2, i4) : i + 1;
            int iA6 = z2 ? i2 + 1 : a(i2, size2, i4);
            C0040bk.a(poseStack, guiGraphics, cs, iA5, iA6, i4);
            if (i3 == size2) {
                C0040bk.a(guiGraphics, iA5, iA6, i4, i4, 872415231);
            }
        }
        if (z && z2 && matchParty != null && matchParty.isSearching()) {
            MutableComponent mutableComponentLiteral = Component.literal(" " + c0297l.m596a().m543a().toString().toUpperCase(Locale.ROOT));
            MutableComponent mutableComponentTranslatable = Component.translatable("bf.menu.lobby.searching");
            MutableComponent mutableComponentWithStyle = mutableComponentTranslatable.copy().append(mutableComponentLiteral).append(C0037bh.a(C0040bk.g())).withStyle(ChatFormatting.AQUA);
            int iWidth = minecraft.font.width(mutableComponentTranslatable) + 32;
            int i9 = i + iB + 2;
            Objects.requireNonNull(minecraft.font);
            int i10 = ((i2 + (i5 / 2)) - (9 / 2)) - 2;
            C0040bk.c(guiGraphics, i9, i10, iWidth, i5, C0040bk.p());
            C0040bk.a(poseStack, minecraft.font, guiGraphics, (Component) mutableComponentWithStyle, i9 + (iWidth / 2), i10 + 3);
        }
        if (z) {
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
            RenderSystem.disableBlend();
        }
    }

    @NotNull
    public static List<UUID> a(@Nullable MatchParty matchParty) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        if (matchParty == null) {
            return objectArrayList;
        }
        objectArrayList.add(matchParty.getHost());
        objectArrayList.addAll(matchParty.getMembers());
        return objectArrayList;
    }

    public static int Z() {
        return i(16);
    }

    public static int g(int i) {
        return b(i, 16);
    }

    public static int a(@Nullable MatchParty matchParty, boolean z, int i) {
        return z ? b(a(matchParty).size(), i) : i(i);
    }

    public static int b(@Nullable MatchParty matchParty, boolean z, int i) {
        return z ? i(i) : b(a(matchParty).size(), i);
    }

    public static int h(int i) {
        return i - 2;
    }

    private static int b(int i, int i2) {
        return 2 + (i * i2) + ((i - 1) * 1);
    }

    private static int i(int i) {
        return i + 2;
    }

    private static int a(int i, int i2, int i3) {
        return i + 1 + (i2 * (i3 + 1));
    }
}
