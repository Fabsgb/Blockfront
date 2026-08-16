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

/* JADX INFO: renamed from: com.boehmod.blockfront.dR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dR.class */
public abstract class AbstractC0217dR extends C0143cG {

    /* JADX INFO: renamed from: ic */
    private static final int f1725ic = 30;

    /* JADX INFO: renamed from: i */
    @NotNull
    protected final Screen f1737i;
    public C0555jl playerCloudData;

    /* JADX INFO: renamed from: hk */
    private int f1738hk;

    /* JADX INFO: renamed from: bJ */
    private final boolean f1739bJ;

    /* JADX INFO: renamed from: fS */
    private static final Component f1692fS = Component.translatable("bf.message.prestige").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: fT */
    private static final Component f1693fT = Component.translatable("bf.message.clan").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: fU */
    private static final Component f1694fU = Component.translatable("bf.message.profile.base.clan.tip");

    /* JADX INFO: renamed from: fV */
    private static final Component f1695fV = Component.translatable("bf.message.add.friend").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: fW */
    private static final Component f1696fW = Component.translatable("bf.message.remove.friend").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: fX */
    private static final Component f1697fX = Component.translatable("bf.message.unlink").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: fY */
    private static final Component f1698fY = Component.translatable("bf.message.profile.base.unlink.tip");

    /* JADX INFO: renamed from: fZ */
    private static final Component f1699fZ = Component.translatable("bf.message.patreon.link").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: ga */
    private static final Component f1700ga = Component.translatable("bf.message.profile.base.patreon.link.tip");

    /* JADX INFO: renamed from: gb */
    private static final Component f1701gb = Component.translatable("bf.message.patreon.unlink").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: gc */
    private static final Component f1702gc = Component.translatable("bf.message.profile.base.patreon.unlink.tip");

    /* JADX INFO: renamed from: gd */
    private static final Component f1703gd = Component.translatable("bf.message.profile.base.unlink.title");

    /* JADX INFO: renamed from: ge */
    private static final Component f1704ge = Component.translatable("bf.message.profile.base.unlink");

    /* JADX INFO: renamed from: gf */
    private static final Component f1705gf = Component.translatable("bf.message.profile.base.add.friend.tip");

    /* JADX INFO: renamed from: gg */
    private static final Component f1706gg = Component.translatable("bf.message.profile.base.remove.friend.tip");

    /* JADX INFO: renamed from: gh */
    private static final Component f1707gh = Component.translatable("bf.message.prompt.friend.remove.title");

    /* JADX INFO: renamed from: gi */
    private static final Component f1708gi = Component.translatable("bf.message.prompt.friend.remove");

    /* JADX INFO: renamed from: gj */
    private static final Component f1709gj = Component.translatable("bf.message.prompt.friend.add.title");

    /* JADX INFO: renamed from: gk */
    private static final Component f1710gk = Component.translatable("bf.message.prompt.friend.add");

    /* JADX INFO: renamed from: gl */
    private static final Component f1711gl = Component.translatable("bf.message.profile.base.patreon.unlink.title");

    /* JADX INFO: renamed from: gm */
    private static final Component f1712gm = Component.translatable("bf.message.profile.base.patreon.unlink");

    /* JADX INFO: renamed from: gn */
    private static final Component f1713gn = Component.translatable("bf.message.profile.base.prestige.title").setStyle(Style.EMPTY.withColor(ColorReferences.COLOR_THEME_PRESTIGE_SOLID));

    /* JADX INFO: renamed from: go */
    private static final Component f1714go = Component.translatable("bf.message.profile.base.prestige.tip");

    /* JADX INFO: renamed from: gp */
    private static final Component f1715gp = Component.translatable("bf.menu.button.back");

    /* JADX INFO: renamed from: gq */
    private static final Component f1716gq = Component.translatable("bf.dropdown.button.settings");

    /* JADX INFO: renamed from: gr */
    private static final Component f1717gr = Component.translatable("bf.message.main").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: gs */
    private static final Component f1718gs = Component.translatable("bf.message.profile.base.main.tip");

    /* JADX INFO: renamed from: gt */
    private static final Component f1719gt = Component.translatable("bf.message.statistics").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: gu */
    private static final Component f1720gu = Component.translatable("bf.message.profile.base.stats.tip");

    /* JADX INFO: renamed from: gv */
    private static final Component f1721gv = Component.translatable("bf.message.profile.base.achievements").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: gw */
    private static final Component f1722gw = Component.translatable("bf.message.profile.base.achievements.tip");

    /* JADX INFO: renamed from: gx */
    private static final Component f1723gx = Component.translatable("bf.message.profile.base.matches").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: gy */
    private static final Component f1724gy = Component.translatable("bf.message.profile.base.matches.tip");

    /* JADX INFO: renamed from: bK */
    private static final ResourceLocation f1726bK = C0532jO.m2378d("textures/gui/menu/icons/menu.png");

    /* JADX INFO: renamed from: bL */
    private static final ResourceLocation f1727bL = C0532jO.m2378d("textures/gui/menu/icons/addfriend.png");

    /* JADX INFO: renamed from: bM */
    private static final ResourceLocation f1728bM = C0532jO.m2378d("textures/gui/menu/icons/removefriend.png");

    /* JADX INFO: renamed from: bN */
    private static final ResourceLocation f1729bN = C0532jO.m2378d("textures/gui/menu/icons/profile_main.png");

    /* JADX INFO: renamed from: bO */
    private static final ResourceLocation f1730bO = C0532jO.m2378d("textures/gui/menu/icons/profile_stats.png");

    /* JADX INFO: renamed from: bP */
    private static final ResourceLocation f1731bP = C0532jO.m2378d("textures/gui/menu/icons/profile_achievements.png");

    /* JADX INFO: renamed from: bQ */
    private static final ResourceLocation f1732bQ = C0532jO.m2378d("textures/gui/menu/icons/profile_prestige.png");

    /* JADX INFO: renamed from: bR */
    private static final ResourceLocation f1733bR = C0532jO.m2378d("textures/gui/menu/icons/profile_clan.png");

    /* JADX INFO: renamed from: bS */
    private static final ResourceLocation f1734bS = C0532jO.m2378d("textures/gui/menu/icons/profile_unlink.png");

    /* JADX INFO: renamed from: bT */
    private static final ResourceLocation f1735bT = C0532jO.m2378d("textures/gui/menu/icons/profile_patreon_link.png");

    /* JADX INFO: renamed from: bU */
    private static final ResourceLocation f1736bU = C0532jO.m2378d("textures/gui/menu/icons/profile_patreon_unlink.png");

    public AbstractC0217dR(@NotNull Screen screen, @NotNull C0555jl c0555jl, @NotNull Component component) {
        super(component);
        this.f1738hk = 15;
        this.f1737i = screen;
        this.playerCloudData = c0555jl;
        this.f1739bJ = c0555jl.getUUID().equals(this.f1058a.getUser().getProfileId());
    }

    /* JADX INFO: renamed from: B */
    public boolean m1291B() {
        return this.f1739bJ;
    }

    /* JADX INFO: renamed from: C */
    public boolean m1292C() {
        AbstractClanData clanData = this.playerCloudData.getClanData();
        if (clanData == null || clanData.isEmpty()) {
            return false;
        }
        return clanData.getMembers().contains(this.f1058a.getUser().getProfileId());
    }

    @Override // com.boehmod.blockfront.C0143cG
    public void init() {
        super.init();
        int i = this.width / 2;
        int width = 0;
        boolean zEquals = this.f1058a.getUser().getProfileId().equals(this.playerCloudData.getUUID());
        ObjectArrayList<C0085bB> objectArrayList = new ObjectArrayList();
        objectArrayList.add(new C0085bB(i, 40, 0, 15, f1717gr, button -> {
            this.f1058a.setScreen(new C0215dP(this.f1737i, this.playerCloudData));
        }).m320a(f1729bN).m322a(9, 9).m323b(0, -2).m327a(C0085bB.b.CENTER_BOTTOM).m334b(0.5f).m324a(0.0f, 4.0f).m328a(C0085bB.a.NONE).m326a(f1718gs));
        objectArrayList.add(new C0085bB(i, 40, 0, 15, f1719gt, button2 -> {
            this.f1058a.setScreen(new C0218dS(this.f1737i, this.playerCloudData));
        }).m320a(f1730bO).m322a(9, 9).m323b(0, -2).m327a(C0085bB.b.CENTER_BOTTOM).m334b(0.5f).m324a(0.0f, 4.0f).m328a(C0085bB.a.NONE).m326a(f1720gu));
        objectArrayList.add(new C0085bB(i, 40, 0, 15, f1721gv, button3 -> {
            this.f1058a.setScreen(new C0213dN(this.f1737i, this.playerCloudData));
        }).m320a(f1731bP).m322a(9, 9).m323b(0, -2).m327a(C0085bB.b.CENTER_BOTTOM).m334b(0.5f).m324a(0.0f, 4.0f).m328a(C0085bB.a.NONE).m326a(f1722gw));
        objectArrayList.add(new C0085bB(i, 40, 0, 15, f1723gx, button4 -> {
            this.f1058a.setScreen(new C0216dQ(this.f1737i, this.playerCloudData));
        }).m320a(f1730bO).m322a(9, 9).m323b(0, -2).m327a(C0085bB.b.CENTER_BOTTOM).m334b(0.5f).m324a(0.0f, 4.0f).m328a(C0085bB.a.NONE).m326a(f1724gy));
        objectArrayList.add(new C0085bB(i, 40, 0, 15, f1693fT, button5 -> {
            this.f1058a.setScreen(new C0214dO(this.f1737i, this.playerCloudData));
        }).m320a(f1733bR).m322a(9, 9).m323b(0, -2).m327a(C0085bB.b.CENTER_BOTTOM).m334b(0.5f).m324a(0.0f, 4.0f).m328a(C0085bB.a.NONE).m326a(f1694fU));
        if (zEquals) {
            objectArrayList.add(new C0085bB(i, 40, 0, 15, f1692fS, button6 -> {
                C0222dW c0222dW = new C0222dW(this, f1713gn, z -> {
                    if (z) {
                        C0530jM.log("Attempting to send prestige request to cloud...", new Object[0]);
                        ((C0358g) this.f1057f.m2852b()).sendPacket(new PacketCheckPrestige());
                    }
                });
                c0222dW.m1325a(Component.empty(), Component.translatable("bf.message.profile.base.prestige.par1", new Object[]{Component.literal(String.valueOf(this.playerCloudData.getPrestigeLevel() + 1)).withColor(ColorReferences.COLOR_THEME_PRESTIGE_SOLID)}), Component.empty(), Component.translatable("bf.message.profile.base.prestige.par2").withStyle(ChatFormatting.DARK_GRAY));
                this.f1058a.setScreen(c0222dW);
            }).m317a(c0085bB -> {
                return this.playerCloudData.canPrestige();
            }).m320a(f1732bQ).m322a(9, 9).m323b(0, -2).m327a(C0085bB.b.CENTER_BOTTOM).m334b(0.5f).m324a(0.0f, 4.0f).m326a(f1714go).m328a(C0085bB.a.NONE));
            if (this.playerCloudData.m2518ab()) {
                objectArrayList.add(new C0085bB(i, 40, 0, 15, f1697fX, button7 -> {
                    C0283ee c0283ee = new C0283ee(this, f1703gd, z -> {
                        if (z) {
                            C0530jM.log("Attempting to send unlink request to cloud...", new Object[0]);
                            ((C0358g) this.f1057f.m2852b()).sendPacket(new PacketDiscordUnlinkRequest());
                        }
                    });
                    c0283ee.m1324a(f1704ge);
                    this.f1058a.setScreen(c0283ee);
                }).m320a(f1734bS).m322a(9, 9).m323b(0, -2).m327a(C0085bB.b.CENTER_BOTTOM).m334b(0.5f).m324a(0.0f, 4.0f).m328a(C0085bB.a.NONE).m326a(f1698fY));
            }
            if (this.playerCloudData.m2519ac()) {
                objectArrayList.add(new C0085bB(i, 40, 0, 15, f1701gb, button8 -> {
                    C0283ee c0283ee = new C0283ee(this, f1711gl, z -> {
                        if (z) {
                            C0530jM.log("Attempting to send Patreon unlink request to cloud...", new Object[0]);
                            ((C0358g) this.f1057f.m2852b()).sendPacket(new PacketPatreonUnlinkRequest());
                        }
                    });
                    c0283ee.m1324a(f1712gm);
                    this.f1058a.setScreen(c0283ee);
                }).m320a(f1736bU).m322a(9, 9).m323b(0, -2).m327a(C0085bB.b.CENTER_BOTTOM).m334b(0.5f).m324a(0.0f, 4.0f).m328a(C0085bB.a.NONE).m326a(f1702gc));
            } else {
                objectArrayList.add(new C0085bB(i, 40, 0, 15, f1699fZ, button9 -> {
                    C0530jM.log("Attempting to send Patreon link request to cloud...", new Object[0]);
                    ((C0358g) this.f1057f.m2852b()).sendPacket(new PacketPatreonLinkRequest());
                }).m320a(f1735bT).m322a(9, 9).m323b(0, -2).m327a(C0085bB.b.CENTER_BOTTOM).m334b(0.5f).m324a(0.0f, 4.0f).m328a(C0085bB.a.NONE).m326a(f1700ga));
            }
        }
        boolean zM4640c = this.f1057f.m2861a().m4640c(this.playerCloudData.getUUID());
        if (!zEquals) {
            if (!zM4640c) {
                objectArrayList.add(new C0085bB(i, 40, 0, 15, f1695fV, button10 -> {
                    C0283ee c0283ee = new C0283ee(this, f1709gj, z -> {
                        if (z) {
                            C0530jM.log("Attempting to add friend...", new Object[0]);
                            ((C0358g) this.f1057f.m2852b()).sendPacket(new PacketFriendRequest(this.playerCloudData.getUsername()));
                        }
                    });
                    c0283ee.m1324a(f1710gk);
                    this.f1058a.setScreen(c0283ee);
                }).m320a(f1727bL).m322a(9, 9).m323b(0, -2).m327a(C0085bB.b.CENTER_BOTTOM).m334b(0.5f).m324a(0.0f, 4.0f).m328a(C0085bB.a.NONE).m326a(f1705gf));
            } else {
                objectArrayList.add(new C0085bB(i, 40, 0, 15, f1696fW, button11 -> {
                    C0283ee c0283ee = new C0283ee(this, f1707gh, z -> {
                        if (z) {
                            C0530jM.log("Attempting to remove friend...", new Object[0]);
                            ((C0358g) this.f1057f.m2852b()).sendPacket(new PacketFriendRemove(this.playerCloudData.getUUID()));
                        }
                    });
                    c0283ee.m1324a(f1708gi);
                    this.f1058a.setScreen(c0283ee);
                }).m320a(f1728bM).m322a(9, 9).m323b(0, -2).m327a(C0085bB.b.CENTER_BOTTOM).m334b(0.5f).m324a(0.0f, 4.0f).m328a(C0085bB.a.NONE).m326a(f1706gg));
            }
        }
        for (C0085bB c0085bB2 : objectArrayList) {
            c0085bB2.setWidth(((this.font.width(c0085bB2.getMessage().getString()) + 15) / 2) + 4);
            width += c0085bB2.getWidth() + 2;
        }
        int i2 = i - (width / 2);
        int width2 = 0;
        for (C0085bB c0085bB3 : objectArrayList) {
            c0085bB3.setX(i2 + width2);
            addRenderableWidget(c0085bB3);
            width2 += c0085bB3.getWidth() + 2;
        }
    }

    @Override // com.boehmod.blockfront.C0143cG
    public void tick() {
        super.tick();
        int i = this.f1738hk;
        this.f1738hk = i + 1;
        if (i > 30) {
            this.f1738hk = 0;
            UUID uuid = this.playerCloudData.getUUID();
            C0551jh c0551jhA = ((C0358g) this.f1057f.m2852b()).m1722a();
            c0551jhA.m2492b(RequestType.PLAYER_DATA, uuid);
            c0551jhA.m2492b(RequestType.INVENTORY_MINIMAL, uuid);
            c0551jhA.m2492b(RequestType.PLAYER_STATUS, uuid);
            UUID clanId = this.playerCloudData.getClanId();
            if (clanId != null) {
                c0551jhA.m2492b(RequestType.CLAN_DATA, clanId);
            }
        }
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: K */
    public void mo776K() {
        super.mo776K();
        C0085bB c0085bB = new C0085bB(5, 18, 20, 20, Component.empty(), button -> {
            m1293N();
        });
        addRenderableWidget(c0085bB);
        c0085bB.m320a(f1037aH);
        c0085bB.m322a(20, 20);
        c0085bB.m328a(C0085bB.a.NONE);
        c0085bB.m326a(f1715gp);
        addRenderableWidget(c0085bB);
        addRenderableWidget(new C0085bB(this.width - (20 + 5), 18, 20, 20, Component.empty(), button2 -> {
            this.f1058a.setScreen(new C0146cJ(this));
            this.f1058a.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7965pm.get(), (float) (0.8999999761581421d + (0.10000000149011612d * Math.random()))));
        }).m320a(f1726bK).m322a(20, 20).m328a(C0085bB.a.NONE).m326a(f1716gq));
    }

    /* JADX INFO: renamed from: N */
    public void m1293N() {
        this.f1058a.setScreen(this.f1737i);
    }
}
