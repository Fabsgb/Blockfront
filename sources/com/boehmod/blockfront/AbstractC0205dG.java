package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.AbstractClanData;
import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.packet.common.discord.PacketDiscordUnlinkRequest;
import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendRemove;
import com.boehmod.bflib.cloud.packet.common.friend.PacketFriendRequest;
import com.boehmod.bflib.cloud.packet.common.patreon.PacketPatreonLinkRequest;
import com.boehmod.bflib.cloud.packet.common.patreon.PacketPatreonUnlinkRequest;
import com.boehmod.bflib.cloud.packet.common.profile.PacketCheckPrestige;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.dG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/dG.class */
public abstract class AbstractC0205dG extends C0195cx {

    /* JADX INFO: renamed from: gS */
    private static final int f1696gS = 30;

    /* JADX INFO: renamed from: j */
    @NotNull
    protected final Screen f1708j;
    public C0482iS playerCloudData;

    /* JADX INFO: renamed from: gk */
    private int f1709gk;

    /* JADX INFO: renamed from: bD */
    private final boolean f1710bD;

    /* JADX INFO: renamed from: fM */
    private static final Component f1663fM = Component.translatable("bf.message.prestige").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: fN */
    private static final Component f1664fN = Component.translatable("bf.message.clan").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: fO */
    private static final Component f1665fO = Component.translatable("bf.message.profile.base.clan.tip");

    /* JADX INFO: renamed from: fP */
    private static final Component f1666fP = Component.translatable("bf.message.add.friend").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: fQ */
    private static final Component f1667fQ = Component.translatable("bf.message.remove.friend").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: fR */
    private static final Component f1668fR = Component.translatable("bf.message.unlink").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: fS */
    private static final Component f1669fS = Component.translatable("bf.message.profile.base.unlink.tip");

    /* JADX INFO: renamed from: fT */
    private static final Component f1670fT = Component.translatable("bf.message.patreon.link").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: fU */
    private static final Component f1671fU = Component.translatable("bf.message.profile.base.patreon.link.tip");

    /* JADX INFO: renamed from: fV */
    private static final Component f1672fV = Component.translatable("bf.message.patreon.unlink").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: fW */
    private static final Component f1673fW = Component.translatable("bf.message.profile.base.patreon.unlink.tip");

    /* JADX INFO: renamed from: fX */
    private static final Component f1674fX = Component.translatable("bf.message.profile.base.unlink.title");

    /* JADX INFO: renamed from: fY */
    private static final Component f1675fY = Component.translatable("bf.message.profile.base.unlink");

    /* JADX INFO: renamed from: fZ */
    private static final Component f1676fZ = Component.translatable("bf.message.profile.base.add.friend.tip");

    /* JADX INFO: renamed from: ga */
    private static final Component f1677ga = Component.translatable("bf.message.profile.base.remove.friend.tip");

    /* JADX INFO: renamed from: gb */
    private static final Component f1678gb = Component.translatable("bf.message.prompt.friend.remove.title");

    /* JADX INFO: renamed from: gc */
    private static final Component f1679gc = Component.translatable("bf.message.prompt.friend.remove");

    /* JADX INFO: renamed from: gd */
    private static final Component f1680gd = Component.translatable("bf.message.prompt.friend.add.title");

    /* JADX INFO: renamed from: ge */
    private static final Component f1681ge = Component.translatable("bf.message.prompt.friend.add");

    /* JADX INFO: renamed from: gf */
    private static final Component f1682gf = Component.translatable("bf.message.profile.base.patreon.unlink.title");

    /* JADX INFO: renamed from: gg */
    private static final Component f1683gg = Component.translatable("bf.message.profile.base.patreon.unlink");

    /* JADX INFO: renamed from: gh */
    private static final Component f1684gh = Component.translatable("bf.message.profile.base.prestige.title").setStyle(Style.EMPTY.withColor(ColorReferences.COLOR_THEME_PRESTIGE_SOLID));

    /* JADX INFO: renamed from: gi */
    private static final Component f1685gi = Component.translatable("bf.message.profile.base.prestige.tip");

    /* JADX INFO: renamed from: gj */
    private static final Component f1686gj = Component.translatable("bf.menu.button.back");

    /* JADX INFO: renamed from: gk */
    private static final Component f1687gk = Component.translatable("bf.dropdown.button.settings");

    /* JADX INFO: renamed from: gl */
    private static final Component f1688gl = Component.translatable("bf.message.main").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: gm */
    private static final Component f1689gm = Component.translatable("bf.message.profile.base.main.tip");

    /* JADX INFO: renamed from: gn */
    private static final Component f1690gn = Component.translatable("bf.message.statistics").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: go */
    private static final Component f1691go = Component.translatable("bf.message.profile.base.stats.tip");

    /* JADX INFO: renamed from: gp */
    private static final Component f1692gp = Component.translatable("bf.message.profile.base.achievements").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: gq */
    private static final Component f1693gq = Component.translatable("bf.message.profile.base.achievements.tip");

    /* JADX INFO: renamed from: gr */
    private static final Component f1694gr = Component.translatable("bf.message.profile.base.matches").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: gs */
    private static final Component f1695gs = Component.translatable("bf.message.profile.base.matches.tip");

    /* JADX INFO: renamed from: bM */
    private static final ResourceLocation f1697bM = C0564jv.m2555d("textures/gui/menu/icons/menu.png");

    /* JADX INFO: renamed from: bN */
    private static final ResourceLocation f1698bN = C0564jv.m2555d("textures/gui/menu/icons/addfriend.png");

    /* JADX INFO: renamed from: bO */
    private static final ResourceLocation f1699bO = C0564jv.m2555d("textures/gui/menu/icons/removefriend.png");

    /* JADX INFO: renamed from: bP */
    private static final ResourceLocation f1700bP = C0564jv.m2555d("textures/gui/menu/icons/profile_main.png");

    /* JADX INFO: renamed from: bQ */
    private static final ResourceLocation f1701bQ = C0564jv.m2555d("textures/gui/menu/icons/profile_stats.png");

    /* JADX INFO: renamed from: bR */
    private static final ResourceLocation f1702bR = C0564jv.m2555d("textures/gui/menu/icons/profile_achievements.png");

    /* JADX INFO: renamed from: bS */
    private static final ResourceLocation f1703bS = C0564jv.m2555d("textures/gui/menu/icons/profile_prestige.png");

    /* JADX INFO: renamed from: bT */
    private static final ResourceLocation f1704bT = C0564jv.m2555d("textures/gui/menu/icons/profile_clan.png");

    /* JADX INFO: renamed from: bU */
    private static final ResourceLocation f1705bU = C0564jv.m2555d("textures/gui/menu/icons/profile_unlink.png");

    /* JADX INFO: renamed from: bV */
    private static final ResourceLocation f1706bV = C0564jv.m2555d("textures/gui/menu/icons/profile_patreon_link.png");

    /* JADX INFO: renamed from: bW */
    private static final ResourceLocation f1707bW = C0564jv.m2555d("textures/gui/menu/icons/profile_patreon_unlink.png");

    public AbstractC0205dG(@NotNull Screen screen, @NotNull C0482iS c0482iS, @NotNull Component component) {
        super(component);
        this.f1709gk = 15;
        this.f1708j = screen;
        this.playerCloudData = c0482iS;
        this.f1710bD = c0482iS.getUUID().equals(this.f1587b.getUser().getProfileId());
    }

    /* JADX INFO: renamed from: A */
    public boolean m1240A() {
        return this.f1710bD;
    }

    /* JADX INFO: renamed from: B */
    public boolean m1241B() {
        AbstractClanData clanData = this.playerCloudData.getClanData();
        if (clanData == null || clanData.isEmpty()) {
            return false;
        }
        return clanData.getMembers().contains(this.f1587b.getUser().getProfileId());
    }

    @Override // com.boehmod.blockfront.C0195cx
    public void init() {
        super.init();
        int i = this.width / 2;
        int width = 0;
        boolean zEquals = this.f1587b.getUser().getProfileId().equals(this.playerCloudData.getUUID());
        ObjectArrayList<C0127bs> objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0127bs(i, 40, 0, 15, f1688gl, button -> {
            this.f1587b.setScreen(new C0203dE(this.f1708j, this.playerCloudData));
        }).m645a(f1700bP).m647a(9, 9).m648b(0, -2).m652a(C0127bs.b.CENTER_BOTTOM).m659b(0.5f).m649a(0.0f, 4.0f).m653a(C0127bs.a.NONE).m651a(f1689gm));
        objectArrayList.add(new C0127bs(i, 40, 0, 15, f1690gn, button2 -> {
            this.f1587b.setScreen(new C0206dH(this.f1708j, this.playerCloudData));
        }).m645a(f1701bQ).m647a(9, 9).m648b(0, -2).m652a(C0127bs.b.CENTER_BOTTOM).m659b(0.5f).m649a(0.0f, 4.0f).m653a(C0127bs.a.NONE).m651a(f1691go));
        objectArrayList.add(new C0127bs(i, 40, 0, 15, f1692gp, button3 -> {
            this.f1587b.setScreen(new C0201dC(this.f1708j, this.playerCloudData));
        }).m645a(f1702bR).m647a(9, 9).m648b(0, -2).m652a(C0127bs.b.CENTER_BOTTOM).m659b(0.5f).m649a(0.0f, 4.0f).m653a(C0127bs.a.NONE).m651a(f1693gq));
        objectArrayList.add(new C0127bs(i, 40, 0, 15, f1694gr, button4 -> {
            this.f1587b.setScreen(new C0204dF(this.f1708j, this.playerCloudData));
        }).m645a(f1701bQ).m647a(9, 9).m648b(0, -2).m652a(C0127bs.b.CENTER_BOTTOM).m659b(0.5f).m649a(0.0f, 4.0f).m653a(C0127bs.a.NONE).m651a(f1695gs));
        objectArrayList.add(new C0127bs(i, 40, 0, 15, f1664fN, button5 -> {
            this.f1587b.setScreen(new C0202dD(this.f1708j, this.playerCloudData));
        }).m645a(f1704bT).m647a(9, 9).m648b(0, -2).m652a(C0127bs.b.CENTER_BOTTOM).m659b(0.5f).m649a(0.0f, 4.0f).m653a(C0127bs.a.NONE).m651a(f1665fO));
        if (zEquals) {
            objectArrayList.add(new C0127bs(i, 40, 0, 15, f1663fM, button6 -> {
                C0210dL c0210dL = new C0210dL(this, f1684gh, z -> {
                    if (z) {
                        C0562jt.log("Attempting to send prestige request to cloud...", new Object[0]);
                        ((C0357g) this.f1586e.m2667b()).sendPacket(new PacketCheckPrestige());
                    }
                });
                c0210dL.m1274a(Component.empty(), Component.translatable("bf.message.profile.base.prestige.par1", new Object[]{Component.literal(String.valueOf(this.playerCloudData.getPrestigeLevel() + 1)).withColor(ColorReferences.COLOR_THEME_PRESTIGE_SOLID)}), Component.empty(), Component.translatable("bf.message.profile.base.prestige.par2").withStyle(ChatFormatting.DARK_GRAY));
                this.f1587b.setScreen(c0210dL);
            }).m642a(c0127bs -> {
                return this.playerCloudData.canPrestige();
            }).m645a(f1703bS).m647a(9, 9).m648b(0, -2).m652a(C0127bs.b.CENTER_BOTTOM).m659b(0.5f).m649a(0.0f, 4.0f).m651a(f1685gi).m653a(C0127bs.a.NONE));
            if (this.playerCloudData.m2191Y()) {
                objectArrayList.add(new C0127bs(i, 40, 0, 15, f1668fR, button7 -> {
                    C0218dT c0218dT = new C0218dT(this, f1674fX, z -> {
                        if (z) {
                            C0562jt.log("Attempting to send unlink request to cloud...", new Object[0]);
                            ((C0357g) this.f1586e.m2667b()).sendPacket(new PacketDiscordUnlinkRequest());
                        }
                    });
                    c0218dT.m1273a(f1675fY);
                    this.f1587b.setScreen(c0218dT);
                }).m645a(f1705bU).m647a(9, 9).m648b(0, -2).m652a(C0127bs.b.CENTER_BOTTOM).m659b(0.5f).m649a(0.0f, 4.0f).m653a(C0127bs.a.NONE).m651a(f1669fS));
            }
            if (this.playerCloudData.m2192Z()) {
                objectArrayList.add(new C0127bs(i, 40, 0, 15, f1672fV, button8 -> {
                    C0218dT c0218dT = new C0218dT(this, f1682gf, z -> {
                        if (z) {
                            C0562jt.log("Attempting to send Patreon unlink request to cloud...", new Object[0]);
                            ((C0357g) this.f1586e.m2667b()).sendPacket(new PacketPatreonUnlinkRequest());
                        }
                    });
                    c0218dT.m1273a(f1683gg);
                    this.f1587b.setScreen(c0218dT);
                }).m645a(f1707bW).m647a(9, 9).m648b(0, -2).m652a(C0127bs.b.CENTER_BOTTOM).m659b(0.5f).m649a(0.0f, 4.0f).m653a(C0127bs.a.NONE).m651a(f1673fW));
            } else {
                objectArrayList.add(new C0127bs(i, 40, 0, 15, f1670fT, button9 -> {
                    C0562jt.log("Attempting to send Patreon link request to cloud...", new Object[0]);
                    ((C0357g) this.f1586e.m2667b()).sendPacket(new PacketPatreonLinkRequest());
                }).m645a(f1706bV).m647a(9, 9).m648b(0, -2).m652a(C0127bs.b.CENTER_BOTTOM).m659b(0.5f).m649a(0.0f, 4.0f).m653a(C0127bs.a.NONE).m651a(f1671fU));
            }
        }
        boolean zM4457c = this.f1586e.m2676a().m4457c(this.playerCloudData.getUUID());
        if (!zEquals) {
            if (!zM4457c) {
                objectArrayList.add(new C0127bs(i, 40, 0, 15, f1666fP, button10 -> {
                    C0218dT c0218dT = new C0218dT(this, f1680gd, z -> {
                        if (z) {
                            C0562jt.log("Attempting to add friend...", new Object[0]);
                            ((C0357g) this.f1586e.m2667b()).sendPacket(new PacketFriendRequest(this.playerCloudData.getUsername()));
                        }
                    });
                    c0218dT.m1273a(f1681ge);
                    this.f1587b.setScreen(c0218dT);
                }).m645a(f1698bN).m647a(9, 9).m648b(0, -2).m652a(C0127bs.b.CENTER_BOTTOM).m659b(0.5f).m649a(0.0f, 4.0f).m653a(C0127bs.a.NONE).m651a(f1676fZ));
            } else {
                objectArrayList.add(new C0127bs(i, 40, 0, 15, f1667fQ, button11 -> {
                    C0218dT c0218dT = new C0218dT(this, f1678gb, z -> {
                        if (z) {
                            C0562jt.log("Attempting to remove friend...", new Object[0]);
                            ((C0357g) this.f1586e.m2667b()).sendPacket(new PacketFriendRemove(this.playerCloudData.getUUID()));
                        }
                    });
                    c0218dT.m1273a(f1679gc);
                    this.f1587b.setScreen(c0218dT);
                }).m645a(f1699bO).m647a(9, 9).m648b(0, -2).m652a(C0127bs.b.CENTER_BOTTOM).m659b(0.5f).m649a(0.0f, 4.0f).m653a(C0127bs.a.NONE).m651a(f1677ga));
            }
        }
        for (C0127bs c0127bs2 : objectArrayList) {
            c0127bs2.setWidth(((this.font.width(c0127bs2.getMessage().getString()) + 15) / 2) + 4);
            width += c0127bs2.getWidth() + 2;
        }
        int i2 = i - (width / 2);
        int width2 = 0;
        for (C0127bs c0127bs3 : objectArrayList) {
            c0127bs3.setX(i2 + width2);
            addRenderableWidget(c0127bs3);
            width2 += c0127bs3.getWidth() + 2;
        }
    }

    @Override // com.boehmod.blockfront.C0195cx
    public void tick() {
        super.tick();
        int i = this.f1709gk;
        this.f1709gk = i + 1;
        if (i > 30) {
            this.f1709gk = 0;
            UUID uuid = this.playerCloudData.getUUID();
            C0478iO c0478iOA = ((C0357g) this.f1586e.m2667b()).m1716a();
            c0478iOA.m2165b(RequestType.PLAYER_DATA, uuid);
            c0478iOA.m2165b(RequestType.INVENTORY_MINIMAL, uuid);
            c0478iOA.m2165b(RequestType.PLAYER_STATUS, uuid);
            UUID clanId = this.playerCloudData.getClanId();
            if (clanId != null) {
                c0478iOA.m2165b(RequestType.CLAN_DATA, clanId);
            }
        }
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: G */
    public void mo744G() {
        super.mo744G();
        C0127bs c0127bs = new C0127bs(5, 18, 20, 20, Component.empty(), button -> {
            m1242J();
        });
        addRenderableWidget(c0127bs);
        c0127bs.m645a(f1564aH);
        c0127bs.m647a(20, 20);
        c0127bs.m653a(C0127bs.a.NONE);
        c0127bs.m651a(f1686gj);
        addRenderableWidget(c0127bs);
        addRenderableWidget(new C0127bs(this.width - (20 + 5), 18, 20, 20, Component.empty(), button2 -> {
            this.f1587b.setScreen(new C0136cA(this, false));
            this.f1587b.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7553pk.get(), (float) (0.8999999761581421d + (0.10000000149011612d * Math.random()))));
        }).m645a(f1697bM).m647a(20, 20).m653a(C0127bs.a.NONE).m651a(f1687gk));
    }

    /* JADX INFO: renamed from: J */
    public void m1242J() {
        Screen screen = this.f1708j;
        if (screen instanceof AbstractC0193cv) {
            ((AbstractC0193cv) screen).f1557aU = true;
        }
        this.f1587b.setScreen(this.f1708j);
    }
}
