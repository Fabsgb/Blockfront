package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.AbstractC0866pe;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ck */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ck.class */
public class C0173ck<G extends AbstractC0863pb<G, P, ?>, P extends AbstractC0866pe<G>> extends AbstractC0166cd<G, P> {

    /* JADX INFO: renamed from: aj */
    @NotNull
    private static final ResourceLocation f1352aj;

    /* JADX INFO: renamed from: ak */
    @NotNull
    private static final ResourceLocation f1353ak;

    /* JADX INFO: renamed from: aU */
    @NotNull
    private static final Component f1354aU;

    /* JADX INFO: renamed from: aV */
    @NotNull
    private static final Component f1355aV;

    /* JADX INFO: renamed from: aU */
    static final /* synthetic */ boolean f1356aU;

    static {
        f1356aU = !C0173ck.class.desiredAssertionStatus();
        f1352aj = C0532jO.m2378d("textures/text/team_allies.png");
        f1353ak = C0532jO.m2378d("textures/text/team_axis.png");
        f1354aU = Component.translatable("bf.message.no.team");
        f1355aV = Component.translatable("bf.message.spectating").withStyle(ChatFormatting.GRAY);
    }

    @Override // com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: a */
    public void mo1042a(@NotNull Minecraft minecraft, @NotNull G g, @NotNull P p, @NotNull AbstractC0864pc<G, P> abstractC0864pc, @NotNull LocalPlayer localPlayer) {
        C0872pk c0872pkM4229a = g.m4018b().m4229a(localPlayer.getUUID());
        if (c0872pkM4229a != null) {
            MutableComponent mutableComponentWithColor = Component.literal(c0872pkM4229a.getName()).withColor(c0872pkM4229a.getColor());
            m1052a(c0872pkM4229a.m4316bz() ? f1352aj : f1353ak);
            m1054a((Component) mutableComponentWithColor);
            return;
        }
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f1356aU && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        boolean zM2876e = c0623lM2852b.m2876e();
        m1052a((ResourceLocation) null);
        m1054a(zM2876e ? f1355aV : f1354aU);
    }
}
