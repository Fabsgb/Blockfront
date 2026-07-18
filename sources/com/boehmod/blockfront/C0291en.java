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

/* JADX INFO: renamed from: com.boehmod.blockfront.en */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/en.class */
public class C0291en extends AbstractC0288ek {

    /* JADX INFO: renamed from: hW */
    private static final int f2210hW = 2005436552;

    /* JADX INFO: renamed from: ck */
    @NotNull
    private static final ResourceLocation f2209ck = C0564jv.m2555d("textures/gui/menu/icons/challenges.png");

    /* JADX INFO: renamed from: hu */
    @NotNull
    private static final Component f2211hu = Component.translatable("bf.menu.dailychallenge.title").withColor(ColorReferences.COLOR_THEME_YELLOW);

    /* JADX INFO: renamed from: hv */
    @NotNull
    private static final Component f2212hv = Component.translatable("bf.menu.dailychallenge.description").withStyle(ChatFormatting.GRAY);

    public C0291en(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4, f2211hu);
        m1518a();
    }

    @Override // com.boehmod.blockfront.AbstractC0288ek
    /* JADX INFO: renamed from: a */
    protected void mo1521a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull C0482iS c0482iS, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        boolean z = m1542a(c0622l) && !c0482iS.getChallenges().isEmpty();
        C0119bk.m491c(guiGraphics, getX(), getY(), this.width, this.height, C0119bk.m365p());
        C0119bk.m415a(guiGraphics, getX(), getY(), this.width, this.height, z ? ColorReferences.COLOR_THEME_YELLOW_SOLID : f2210hW);
        C0119bk.m431a(guiGraphics.pose(), guiGraphics, f2209ck, getX(), getY(), this.width, this.height);
    }

    @Override // com.boehmod.blockfront.AbstractC0288ek
    @NotNull
    /* JADX INFO: renamed from: a */
    protected List<Component> mo1522a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0482iS c0482iS) {
        ObjectList<Challenge> challenges = c0482iS.getChallenges();
        ObjectArrayList objectArrayList = new ObjectArrayList();
        if (!m1542a(c0622l) || challenges.isEmpty()) {
            objectArrayList.add(f2211hu);
            objectArrayList.add(f2212hv);
        } else {
            long jCount = challenges.stream().filter((v0) -> {
                return v0.isCompleted();
            }).count();
            MutableComponent mutableComponentCopy = f2211hu.copy();
            challenges.size();
            objectArrayList.add(mutableComponentCopy.append(Component.literal(" (" + jCount + "/" + objectArrayList + ")").withStyle(ChatFormatting.GRAY)));
            ObjectListIterator it = challenges.iterator();
            while (it.hasNext()) {
                Challenge challenge = (Challenge) it.next();
                objectArrayList.add(Component.literal(C0474iK.m2148a(challenge).getString()).withStyle(challenge.isCompleted() ? ChatFormatting.GREEN : ChatFormatting.GRAY));
            }
        }
        return objectArrayList;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m1542a(@NotNull C0622l c0622l) {
        return ((C0357g) c0622l.m2667b()).m1716a().isConnected();
    }
}
