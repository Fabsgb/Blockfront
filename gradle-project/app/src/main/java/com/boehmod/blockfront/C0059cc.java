package com.boehmod.blockfront;

import com.boehmod.blockfront.oF;
import com.boehmod.blockfront.oI;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cc.class */
public class C0059cc<G extends oF<G, P, ?>, P extends oI<G>> extends bU<G, P> {

    @NotNull
    private final C0528to a;
    private final int dd;

    public C0059cc(@NotNull ResourceLocation resourceLocation, @NotNull C0528to c0528to, int i) {
        this.a = c0528to;
        this.dd = i;
        super.a(resourceLocation);
    }

    public C0059cc(@NotNull ResourceLocation resourceLocation, @NotNull C0528to c0528to) {
        this(resourceLocation, c0528to, 0);
    }

    @Override // com.boehmod.blockfront.AbstractC0063cg
    public void a(@NotNull Minecraft minecraft, @NotNull G g, @NotNull P p, @NotNull oG<G, P> oGVar, @NotNull LocalPlayer localPlayer) {
        MutableComponent mutableComponentLiteral;
        int iA = oR.a((oF<?, ?, ?>) g, localPlayer.getUUID(), this.a);
        if (this.dd > 0) {
            mutableComponentLiteral = Component.literal(C0637xp.a(iA)).append(Component.literal(" / ").withStyle(ChatFormatting.GRAY)).append(Component.literal(C0637xp.a(this.dd)));
        } else {
            mutableComponentLiteral = Component.literal(C0637xp.a(iA));
        }
        a((Component) mutableComponentLiteral);
    }
}
