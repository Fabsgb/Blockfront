package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.AbstractClanData;
import com.boehmod.blockfront.C0127bs;
import com.boehmod.blockfront.C0279eb;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.cu */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cu.class */
public final class C0192cu extends AbstractC0193cv {

    /* JADX INFO: renamed from: bd */
    private static final Component f1544bd = Component.translatable("bf.screen.overlay.friends");

    /* JADX INFO: renamed from: be */
    private static final Component f1545be = Component.translatable("bf.message.prompt.friend.add.title").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: bf */
    private static final Component f1546bf = Component.translatable("bf.message.prompt.friend.add.description");

    /* JADX INFO: renamed from: bg */
    private static final Component f1547bg = Component.translatable("bf.message.profile").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: bh */
    private static final Component f1548bh = Component.translatable("bf.message.profile.description", new Object[]{C0029a.f246a});

    /* JADX INFO: renamed from: bi */
    private static final Component f1549bi = Component.translatable("bf.dropdown.text.my.friends").withStyle(C0565jw.f3201b);

    /* JADX INFO: renamed from: aF */
    private static final ResourceLocation f1550aF = C0564jv.m2555d("textures/gui/menu/icons/addfriend.png");

    /* JADX INFO: renamed from: aG */
    private static final ResourceLocation f1551aG = C0564jv.m2555d("textures/gui/menu/icons/myprofile.png");

    /* JADX INFO: renamed from: dR */
    private static final int f1552dR = 20;

    /* JADX INFO: renamed from: a */
    @Nullable
    private static C0224dZ<AbstractC0284eg> f1553a;

    /* JADX INFO: renamed from: dS */
    private int f1554dS;

    public C0192cu(Screen screen, boolean z) {
        super(screen, f1544bd, z);
        this.f1554dS = 0;
    }

    @Override // com.boehmod.blockfront.AbstractC0193cv, com.boehmod.blockfront.C0195cx
    public void tick() {
        super.tick();
        int i = this.f1554dS;
        this.f1554dS = i + 1;
        if (i > 20) {
            m1179H();
            this.f1554dS = 0;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0193cv
    /* JADX INFO: renamed from: h */
    public float mo1178h(float f) {
        return -super.mo1178h(f);
    }

    @Override // com.boehmod.blockfront.AbstractC0193cv
    /* JADX INFO: renamed from: a */
    public void mo743a(@NotNull GuiGraphics guiGraphics, float f) {
        super.mo743a(guiGraphics, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int i = this.width / 4;
        poseStackPose.pushPose();
        C0119bk.m491c(guiGraphics, 0, 0, i, this.height, C0119bk.m365p());
        C0119bk.m496a(this.f1585a, guiGraphics, this.font, this.f1587b.getUser().getProfileId(), C0279eb.b.FRIEND, 0, 12, 20, false);
        C0119bk.m485a(this.f1587b, this.f1586e, poseStackPose, guiGraphics, this.f1587b.getGameProfile(), (i - 18) - 2, 14.0f, 18);
        C0119bk.m383c(this.font, guiGraphics, f1549bi, i / 2, 4);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.AbstractC0193cv
    /* JADX INFO: renamed from: a */
    public boolean mo344a(double d, double d2) {
        return d > ((double) (((float) this.width) / 4.0f));
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: G */
    public void mo744G() {
        super.mo744G();
        int i = (this.width / 4) / 2;
        addRenderableWidget(new C0127bs(0, 34, i, 16, f1545be, button -> {
            this.f1587b.setScreen(new C0214dP(this));
        }).m645a(f1550aF).m647a(12, 12).m648b(0, -3).m652a(C0127bs.b.CENTER_BOTTOM).m649a(0.0f, 3.0f).m659b(0.5f).m651a(f1546bf));
        addRenderableWidget(new C0127bs(i, 34, i, 16, f1547bg, button2 -> {
            this.f1587b.setScreen(new C0203dE(this, this.f1585a.m1676a(this.f1587b)));
        }).m645a(f1551aG).m647a(12, 12).m648b(0, -3).m652a(C0127bs.b.CENTER_BOTTOM).m649a(0.0f, 3.0f).m659b(0.5f).m651a(f1548bh));
    }

    @Override // com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: E */
    public void mo775E() {
        super.mo775E();
        int i = this.width / 4;
        if (f1553a == null) {
            f1553a = new C0224dZ<>(0, 50, i, this.height - 50, this);
        }
        f1553a.m711a(this);
        f1553a.m1314e(i);
        f1553a.m703f(this.height - 50);
        m1179H();
        m1195a(f1553a);
    }

    /* JADX INFO: renamed from: H */
    private void m1179H() {
        C0887q c0887qM2676a = this.f1586e.m2676a();
        C0482iS c0482iSM1676a = this.f1585a.m1676a(this.f1587b);
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
        ObjectOpenHashSet objectOpenHashSet2 = new ObjectOpenHashSet();
        Set<UUID> setM4458a = c0887qM2676a.m4458a();
        for (UUID uuid : setM4458a) {
            if (this.f1585a.mo1137a(uuid).getStatus().getOnlineStatus().isOnline()) {
                objectOpenHashSet.add(uuid);
            } else {
                objectOpenHashSet2.add(uuid);
            }
        }
        ObjectOpenHashSet objectOpenHashSet3 = new ObjectOpenHashSet();
        ObjectOpenHashSet objectOpenHashSet4 = new ObjectOpenHashSet();
        ObjectOpenHashSet<UUID> objectOpenHashSet5 = new ObjectOpenHashSet();
        objectOpenHashSet4.removeAll(objectOpenHashSet2);
        AbstractClanData clanData = c0482iSM1676a.getClanData();
        if (clanData != null) {
            objectOpenHashSet5.addAll(clanData.getMembers());
        }
        for (UUID uuid2 : objectOpenHashSet5) {
            if (this.f1585a.mo1137a(uuid2).getStatus().getOnlineStatus().isOnline()) {
                objectOpenHashSet3.add(uuid2);
            } else {
                objectOpenHashSet4.add(uuid2);
            }
        }
        ObjectOpenHashSet objectOpenHashSet6 = new ObjectOpenHashSet(c0887qM2676a.m4459b());
        ObjectOpenHashSet objectOpenHashSet7 = new ObjectOpenHashSet(c0887qM2676a.m4460c());
        ObjectArrayList objectArrayList = new ObjectArrayList();
        String str = String.format("%s/%s (Max: %s)", Integer.valueOf(objectOpenHashSet.size()), Integer.valueOf(setM4458a.size()), Integer.valueOf(c0482iSM1676a.m2194ak()));
        String str2 = String.format("%s/%s (Max: %s)", Integer.valueOf(objectOpenHashSet4.size()), Integer.valueOf(objectOpenHashSet5.size()), 6);
        objectArrayList.add(new C0285eh(""));
        objectArrayList.add(new C0285eh(String.valueOf(ChatFormatting.BOLD) + I18n.get("bf.dropdown.text.my.friends", new Object[0])));
        objectArrayList.add(new C0285eh(str));
        Iterator it = objectOpenHashSet.iterator();
        while (it.hasNext()) {
            objectArrayList.add(new C0279eb(this, (UUID) it.next(), C0279eb.b.FRIEND));
        }
        if (!objectOpenHashSet3.isEmpty()) {
            String name = clanData != null ? clanData.getName() : "Clan";
            objectArrayList.add(new C0285eh(""));
            objectArrayList.add(new C0285eh(String.valueOf(ChatFormatting.BOLD) + I18n.get("bf.dropdown.text.clan.members", new Object[]{name}) + String.valueOf(ChatFormatting.RESET) + " " + str2));
            Iterator it2 = objectOpenHashSet3.iterator();
            while (it2.hasNext()) {
                objectArrayList.add(new C0279eb(this, (UUID) it2.next(), C0279eb.b.CLAN_MEMBER));
            }
        }
        if (!objectOpenHashSet2.isEmpty() || !objectOpenHashSet4.isEmpty()) {
            objectArrayList.add(new C0285eh(""));
            objectArrayList.add(new C0285eh(String.valueOf(ChatFormatting.BOLD) + Component.translatable("bf.dropdown.text.offline").getString()));
        }
        Iterator it3 = objectOpenHashSet2.iterator();
        while (it3.hasNext()) {
            objectArrayList.add(new C0279eb(this, (UUID) it3.next(), C0279eb.b.FRIEND));
        }
        Iterator it4 = objectOpenHashSet4.iterator();
        while (it4.hasNext()) {
            objectArrayList.add(new C0279eb(this, (UUID) it4.next(), C0279eb.b.CLAN_MEMBER));
        }
        if (!c0887qM2676a.m4459b().isEmpty()) {
            objectArrayList.add(new C0285eh(""));
            objectArrayList.add(new C0285eh(String.valueOf(ChatFormatting.BOLD) + I18n.get("bf.dropdown.text.requests.friends", new Object[0])));
        }
        ObjectArrayList objectArrayList2 = new ObjectArrayList(objectOpenHashSet6);
        objectArrayList2.sort(null);
        Iterator it5 = objectArrayList2.iterator();
        while (it5.hasNext()) {
            objectArrayList.add(new C0279eb(this, (UUID) it5.next(), C0279eb.b.FRIEND_REQUEST));
        }
        if (!objectOpenHashSet7.isEmpty()) {
            objectArrayList.add(new C0285eh(""));
            objectArrayList.add(new C0285eh(String.valueOf(ChatFormatting.BOLD) + I18n.get("bf.dropdown.text.requests.clans", new Object[0])));
            ObjectIterator it6 = objectOpenHashSet7.iterator();
            while (it6.hasNext()) {
                objectArrayList.add(new C0279eb(this, (UUID) it6.next(), C0279eb.b.CLAN_INVITE));
            }
        }
        if (f1553a != null) {
            try {
                f1553a.m1325d((List) objectArrayList);
            } catch (ConcurrentModificationException e) {
            }
            f1553a.mo1306al();
        }
    }
}
