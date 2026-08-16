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

/* JADX INFO: renamed from: com.boehmod.blockfront.cl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cl.class */
public class C0174cl<G extends AbstractC0863pb<G, P, ?>, P extends AbstractC0866pe<G>> extends AbstractC0166cd<G, P> {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1060tL f1357a;

    /* JADX INFO: renamed from: dW */
    private final int f1358dW;

    public C0174cl(@NotNull ResourceLocation resourceLocation, @NotNull C1060tL c1060tL, int i) {
        this.f1357a = c1060tL;
        this.f1358dW = i;
        super.m1052a(resourceLocation);
    }

    public C0174cl(@NotNull ResourceLocation resourceLocation, @NotNull C1060tL c1060tL) {
        this(resourceLocation, c1060tL, 0);
    }

    @Override // com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: a */
    public void mo1042a(@NotNull Minecraft minecraft, @NotNull G g, @NotNull P p, @NotNull AbstractC0864pc<G, P> abstractC0864pc, @NotNull LocalPlayer localPlayer) {
        MutableComponent mutableComponentLiteral;
        int iM4445a = C0875pn.m4445a((AbstractC0863pb<?, ?, ?>) g, localPlayer.getUUID(), this.f1357a);
        if (this.f1358dW > 0) {
            mutableComponentLiteral = Component.literal(C1273xM.m7239b(iM4445a)).append(Component.literal(" / ").withStyle(ChatFormatting.GRAY)).append(Component.literal(C1273xM.m7239b(this.f1358dW)));
        } else {
            mutableComponentLiteral = Component.literal(C1273xM.m7239b(iM4445a));
        }
        m1054a((Component) mutableComponentLiteral);
    }
}
