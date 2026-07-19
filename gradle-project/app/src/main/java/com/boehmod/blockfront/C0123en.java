package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.challenge.Challenge;
import com.boehmod.bflib.common.ColorReferences;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.en, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/en.class */
public class C0123en extends AbstractC0120ek {
    private static final int hW = 2005436552;

    @NotNull
    private static final ResourceLocation ck = C0265jv.d("textures/gui/menu/icons/challenges.png");

    @NotNull
    private static final Component hu = Component.translatable("bf.menu.dailychallenge.title").withColor(ColorReferences.COLOR_THEME_YELLOW);

    @NotNull
    private static final Component hv = Component.translatable("bf.menu.dailychallenge.description").withStyle(ChatFormatting.GRAY);

    public C0123en(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4, hu);
        a();
    }

    @Override // com.boehmod.blockfront.AbstractC0120ek
    protected void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull iS iSVar, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        boolean z = a(c0297l) && !iSVar.getChallenges().isEmpty();
        C0040bk.c(guiGraphics, getX(), getY(), this.width, this.height, C0040bk.p());
        C0040bk.a(guiGraphics, getX(), getY(), this.width, this.height, z ? ColorReferences.COLOR_THEME_YELLOW_SOLID : hW);
        C0040bk.a(guiGraphics.pose(), guiGraphics, ck, getX(), getY(), this.width, this.height);
    }

    @Override // com.boehmod.blockfront.AbstractC0120ek
    @NotNull
    protected List<Component> a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull iS iSVar) {
        ObjectList<Challenge> challenges = iSVar.getChallenges();
        ObjectArrayList objectArrayList = new ObjectArrayList();
        if (!a(c0297l) || challenges.isEmpty()) {
            objectArrayList.add(hu);
            objectArrayList.add(hv);
        } else {
            long jCount = challenges.stream().filter((v0) -> {
                return v0.isCompleted();
            }).count();
            MutableComponent mutableComponentCopy = hu.copy();
            challenges.size();
            objectArrayList.add(mutableComponentCopy.append(Component.literal(" (" + jCount + "/" + objectArrayList + ")").withStyle(ChatFormatting.GRAY)));
            ObjectListIterator it = challenges.iterator();
            while (it.hasNext()) {
                Challenge challenge = (Challenge) it.next();
                objectArrayList.add(Component.literal(iK.a(challenge).getString()).withStyle(challenge.isCompleted() ? ChatFormatting.GREEN : ChatFormatting.GRAY));
            }
        }
        return objectArrayList;
    }

    private static boolean a(@NotNull C0297l c0297l) {
        return ((C0163g) c0297l.b()).a().isConnected();
    }
}
