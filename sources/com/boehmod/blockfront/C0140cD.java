package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.AbstractClanData;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.cD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cD.class */
public final class C0140cD extends AbstractC0141cE {

    /* JADX INFO: renamed from: bf */
    private static final Component f1024bf = Component.translatable("bf.screen.overlay.friends");

    /* JADX INFO: renamed from: bg */
    private static final Component f1025bg = Component.translatable("bf.message.prompt.friend.add.title").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: bh */
    private static final Component f1026bh = Component.translatable("bf.message.prompt.friend.add.description");

    /* JADX INFO: renamed from: bi */
    private static final Component f1027bi = Component.translatable("bf.message.profile").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: bj */
    private static final Component f1028bj = Component.translatable("bf.message.profile.description", new Object[]{C0030a.f263a});

    /* JADX INFO: renamed from: bk */
    private static final Component f1029bk = Component.translatable("bf.dropdown.text.my.friends").withStyle(C0533jP.f3185b);

    /* JADX INFO: renamed from: aF */
    private static final ResourceLocation f1030aF = C0532jO.m2378d("textures/gui/menu/icons/addfriend.png");

    /* JADX INFO: renamed from: aG */
    private static final ResourceLocation f1031aG = C0532jO.m2378d("textures/gui/menu/icons/myprofile.png");

    /* JADX INFO: renamed from: eR */
    private static final int f1032eR = 20;

    /* JADX INFO: renamed from: a */
    @Nullable
    private static C0289ek<AbstractC0298et> f1033a;

    /* JADX INFO: renamed from: eS */
    private int f1034eS;

    public C0140cD(Screen screen) {
        super(screen, f1024bf);
        this.f1034eS = 0;
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF, com.boehmod.blockfront.C0143cG
    public void tick() {
        super.tick();
        int i = this.f1034eS;
        this.f1034eS = i + 1;
        if (i > 20) {
            m778L();
            this.f1034eS = 0;
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0142cF
    /* JADX INFO: renamed from: a */
    public void mo775a(@NotNull GuiGraphics guiGraphics, float f) {
        super.mo775a(guiGraphics, f);
        PoseStack poseStackPose = guiGraphics.pose();
        int i = this.width / 4;
        poseStackPose.pushPose();
        C0129bt.m591c(guiGraphics, 0, 0, i, this.height, C0129bt.m465t());
        C0129bt.m596a(this.f1056a, guiGraphics, this.font, this.f1058a.getUser().getProfileId(), C0292en.b.FRIEND, 0, 12, 20, false);
        C0129bt.m585a(this.f1058a, this.f1057f, poseStackPose, guiGraphics, this.f1058a.getGameProfile(), (i - 18) - 2, 14.0f, 18);
        C0129bt.m483c(this.font, guiGraphics, f1029bk, i / 2, 4);
        poseStackPose.popPose();
    }

    @Override // com.boehmod.blockfront.AbstractC0141cE
    /* JADX INFO: renamed from: a */
    public boolean mo437a(double d, double d2) {
        return d > ((double) (((float) this.width) / 4.0f));
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: K */
    public void mo776K() {
        super.mo776K();
        int i = (this.width / 4) / 2;
        addRenderableWidget(new C0085bB(0, 34, i, 16, f1025bg, button -> {
            this.f1058a.setScreen(new C0279ea(this));
        }).m320a(f1030aF).m322a(12, 12).m323b(0, -3).m327a(C0085bB.b.CENTER_BOTTOM).m324a(0.0f, 3.0f).m334b(0.5f).m326a(f1026bh));
        addRenderableWidget(new C0085bB(i, 34, i, 16, f1027bi, button2 -> {
            this.f1058a.setScreen(new C0215dP(this, this.f1056a.m1886a(this.f1058a)));
        }).m320a(f1031aG).m322a(12, 12).m323b(0, -3).m327a(C0085bB.b.CENTER_BOTTOM).m324a(0.0f, 3.0f).m334b(0.5f).m326a(f1028bj));
    }

    @Override // com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: H */
    public void mo777H() {
        super.mo777H();
        int i = this.width / 4;
        if (f1033a == null) {
            f1033a = new C0289ek<>(0, 50, i, this.height - 50, this);
        }
        f1033a.m386a(this);
        f1033a.m1575e(i);
        f1033a.m378f(this.height - 50);
        m778L();
        m794a(f1033a);
    }

    /* JADX INFO: renamed from: L */
    private void m778L() {
        C0888q c0888qM2861a = this.f1057f.m2861a();
        C0555jl c0555jlM1886a = this.f1056a.m1886a(this.f1058a);
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
        ObjectOpenHashSet objectOpenHashSet2 = new ObjectOpenHashSet();
        Set<UUID> setM4641a = c0888qM2861a.m4641a();
        for (UUID uuid : setM4641a) {
            if (this.f1056a.mo1154a(uuid).getStatus().getOnlineStatus().isOnline()) {
                objectOpenHashSet.add(uuid);
            } else {
                objectOpenHashSet2.add(uuid);
            }
        }
        ObjectOpenHashSet objectOpenHashSet3 = new ObjectOpenHashSet();
        ObjectOpenHashSet objectOpenHashSet4 = new ObjectOpenHashSet();
        ObjectOpenHashSet<UUID> objectOpenHashSet5 = new ObjectOpenHashSet();
        objectOpenHashSet4.removeAll(objectOpenHashSet2);
        AbstractClanData clanData = c0555jlM1886a.getClanData();
        if (clanData != null) {
            objectOpenHashSet5.addAll(clanData.getMembers());
        }
        for (UUID uuid2 : objectOpenHashSet5) {
            if (this.f1056a.mo1154a(uuid2).getStatus().getOnlineStatus().isOnline()) {
                objectOpenHashSet3.add(uuid2);
            } else {
                objectOpenHashSet4.add(uuid2);
            }
        }
        ObjectOpenHashSet objectOpenHashSet6 = new ObjectOpenHashSet(c0888qM2861a.m4642b());
        ObjectOpenHashSet objectOpenHashSet7 = new ObjectOpenHashSet(c0888qM2861a.m4643c());
        ObjectArrayList objectArrayList = new ObjectArrayList();
        String str = String.format("%s/%s (Max: %s)", Integer.valueOf(objectOpenHashSet.size()), Integer.valueOf(setM4641a.size()), Integer.valueOf(c0555jlM1886a.m2521aA()));
        String str2 = String.format("%s/%s (Max: %s)", Integer.valueOf(objectOpenHashSet4.size()), Integer.valueOf(objectOpenHashSet5.size()), 6);
        objectArrayList.add(new C0299eu(""));
        objectArrayList.add(new C0299eu(String.valueOf(ChatFormatting.BOLD) + I18n.get("bf.dropdown.text.my.friends", new Object[0])));
        objectArrayList.add(new C0299eu(str));
        Iterator it = objectOpenHashSet.iterator();
        while (it.hasNext()) {
            objectArrayList.add(new C0292en(this, (UUID) it.next(), C0292en.b.FRIEND));
        }
        if (!objectOpenHashSet3.isEmpty()) {
            String name = clanData != null ? clanData.getName() : "Clan";
            objectArrayList.add(new C0299eu(""));
            objectArrayList.add(new C0299eu(String.valueOf(ChatFormatting.BOLD) + I18n.get("bf.dropdown.text.clan.members", new Object[]{name}) + String.valueOf(ChatFormatting.RESET) + " " + str2));
            Iterator it2 = objectOpenHashSet3.iterator();
            while (it2.hasNext()) {
                objectArrayList.add(new C0292en(this, (UUID) it2.next(), C0292en.b.CLAN_MEMBER));
            }
        }
        if (!objectOpenHashSet2.isEmpty() || !objectOpenHashSet4.isEmpty()) {
            objectArrayList.add(new C0299eu(""));
            objectArrayList.add(new C0299eu(String.valueOf(ChatFormatting.BOLD) + Component.translatable("bf.dropdown.text.offline").getString()));
        }
        Iterator it3 = objectOpenHashSet2.iterator();
        while (it3.hasNext()) {
            objectArrayList.add(new C0292en(this, (UUID) it3.next(), C0292en.b.FRIEND));
        }
        Iterator it4 = objectOpenHashSet4.iterator();
        while (it4.hasNext()) {
            objectArrayList.add(new C0292en(this, (UUID) it4.next(), C0292en.b.CLAN_MEMBER));
        }
        if (!c0888qM2861a.m4642b().isEmpty()) {
            objectArrayList.add(new C0299eu(""));
            objectArrayList.add(new C0299eu(String.valueOf(ChatFormatting.BOLD) + I18n.get("bf.dropdown.text.requests.friends", new Object[0])));
        }
        ObjectArrayList objectArrayList2 = new ObjectArrayList(objectOpenHashSet6);
        objectArrayList2.sort(null);
        Iterator it5 = objectArrayList2.iterator();
        while (it5.hasNext()) {
            objectArrayList.add(new C0292en(this, (UUID) it5.next(), C0292en.b.FRIEND_REQUEST));
        }
        if (!objectOpenHashSet7.isEmpty()) {
            objectArrayList.add(new C0299eu(""));
            objectArrayList.add(new C0299eu(String.valueOf(ChatFormatting.BOLD) + I18n.get("bf.dropdown.text.requests.clans", new Object[0])));
            ObjectIterator it6 = objectOpenHashSet7.iterator();
            while (it6.hasNext()) {
                objectArrayList.add(new C0292en(this, (UUID) it6.next(), C0292en.b.CLAN_INVITE));
            }
        }
        if (f1033a != null) {
            try {
                f1033a.m1586d((List) objectArrayList);
            } catch (ConcurrentModificationException e) {
            }
            f1033a.mo1567aq();
        }
    }
}
