package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0788oG;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import net.neoforged.neoforge.common.util.TriState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.rJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/rJ.class */
public final class C0950rJ extends AbstractC0788oG<C0949rI, C0951rK> {

    /* JADX INFO: renamed from: fa */
    @NotNull
    private static final ResourceLocation f5043fa = C0564jv.m2555d("textures/gui/game/topelement/kills.png");

    public C0950rJ(@NotNull C0622l c0622l, @NotNull C0949rI c0949rI, @NotNull C0326fV c0326fV) {
        super(c0622l, c0949rI, c0326fV);
        c0622l.m2709a().m3222b(new C0719mr(c0949rI));
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: u */
    protected List<Component> mo3666u() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(Component.translatable("bf.message.gamemode.ffa.tip.0", new Object[]{Component.literal(String.valueOf(30))}));
        objectArrayList.add(Component.translatable("bf.message.gamemode.ffa.tip.1"));
        objectArrayList.add(Component.translatable("bf.message.gamemode.ffa.tip.2"));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: w */
    protected List<AbstractC0168cg<C0949rI, C0951rK>> mo3670w() {
        return List.of(new C0163cb(), new C0164cc(f5043fa, C1089tp.f5713D, 30), new C0167cf());
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public boolean mo3676a(@NotNull AbstractClientPlayer abstractClientPlayer) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: b */
    public void mo3704b(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0324fT c0324fT, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2) {
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public boolean mo3718a(@NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: bk */
    public boolean mo3721bk() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: bi */
    public boolean mo3719bi() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: b */
    public List<C0124bp> mo3730b(@NotNull Minecraft minecraft, @NotNull Set<UUID> set, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        return new ObjectArrayList();
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: bh */
    public boolean mo3717bh() {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: a */
    public void mo3731a(@NotNull Minecraft minecraft, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Player player, @NotNull ClientLevel clientLevel) {
        C0796oO c0796oOA;
        C0951rK c0951rKB = ((C0949rI) this.f4272f).m3582b();
        String strM3053E = null;
        C0796oO c0796oOA2 = c0951rKB.m3793a(player.getUUID());
        Player entity = renderNameTagEvent.getEntity();
        if ((entity instanceof Player) && (c0796oOA = c0951rKB.m3793a(entity.getUUID())) != null) {
            strM3053E = c0796oOA.getName();
        }
        C0680mE entity2 = renderNameTagEvent.getEntity();
        if (entity2 instanceof C0680mE) {
            strM3053E = entity2.m3053E();
        }
        if (strM3053E != null && c0796oOA2 != null && strM3053E.equals(c0796oOA2.getName()) && player.distanceTo(renderNameTagEvent.getEntity()) <= 20.0f) {
            renderNameTagEvent.setCanRender(TriState.TRUE);
        } else {
            renderNameTagEvent.setCanRender(TriState.FALSE);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    /* JADX INFO: renamed from: g */
    public boolean mo3710g(@NotNull Player player) {
        return ((C0949rI) this.f4272f).mo3560a() != EnumC0795oN.GAME;
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0788oG.a mo3711a() {
        return new AbstractC0788oG.a().m3765a("PING", (c0324fT, playerInfo, c0794oM) -> {
            return playerInfo != null ? C1293xp.m7912a(playerInfo.getLatency()) : "???";
        }).m3765a("K", (c0324fT2, playerInfo2, c0794oM2) -> {
            return C1293xp.m7912a(c0794oM2.m3853a(C1089tp.f5713D.getKey()));
        }).m3765a("A", (c0324fT3, playerInfo3, c0794oM3) -> {
            return C1293xp.m7912a(c0794oM3.m3853a(C1089tp.f5722M.getKey()));
        }).m3765a("SCORE", (c0324fT4, playerInfo4, c0794oM4) -> {
            return C1293xp.m7912a(c0794oM4.m3853a(C1089tp.f5695l.getKey()));
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0788oG
    @NotNull
    /* JADX INFO: renamed from: a */
    public Collection<? extends AbstractC0156cU> mo3743a(boolean z) {
        return m3744a((C0949rI) this.f4272f, z);
    }
}
