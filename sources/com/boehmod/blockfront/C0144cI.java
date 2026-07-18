package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.AbstractC0788oG;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cI.class */
public class C0144cI<G extends AbstractC0787oF<G, ?, ?>, C extends AbstractC0788oG<G, ?>> extends AbstractC0143cH<G, C> {
    public C0144cI(@Nullable Screen screen, @NotNull C0796oO c0796oO, @NotNull G g, @NotNull C c) {
        super(screen, g, c, c0796oO);
    }

    @Override // com.boehmod.blockfront.AbstractC0143cH, com.boehmod.blockfront.C0195cx
    /* JADX INFO: renamed from: E */
    public void mo775E() {
        super.mo775E();
        Map<C1015sV, ObjectList<C0866pf>> mapM3734a = this.f1112b.m3734a(this.f1110b);
        Set<C1015sV> setMo3561e = this.f1111b.mo3561e();
        for (Map.Entry<C1015sV, ObjectList<C0866pf>> entry : mapM3734a.entrySet()) {
            ObjectList<C0866pf> value = entry.getValue();
            C1015sV key = entry.getKey();
            if (key != null && !setMo3561e.contains(key)) {
                m793a(key, value, new String[]{String.valueOf(ChatFormatting.BOLD) + I18n.get(key.m5516al(), new Object[0]) + String.valueOf(ChatFormatting.WHITE) + " - ", I18n.get(key.m5517p(), new Object[0])}, C0799oR.m4030a((AbstractC0787oF<?, ?, ?>) this.f1111b, key, this.f1110b));
            }
        }
        addRenderableWidget(new C0291en((this.width - 16) - 10, 56, 16, 16));
    }

    @Override // com.boehmod.blockfront.AbstractC0143cH
    /* JADX INFO: renamed from: a */
    public void mo797a(@NotNull C0145cJ c0145cJ) {
        if (this.f1587b.player == null) {
            return;
        }
        AbstractC0790oI abstractC0790oIM3582b = this.f1111b.m3582b();
        UUID uuid = this.f1587b.player.getUUID();
        C0796oO c0796oOM3793a = abstractC0790oIM3582b.m3793a(uuid);
        if (c0796oOM3793a == null) {
            return;
        }
        if (c0796oOM3793a.m3860a((AbstractC0787oF<?, ?, ?>) this.f1111b).m5981a(c0145cJ.m805a(), c0145cJ.m806z()) != null) {
            C0794oM c0794oMM3598a = this.f1111b.m3598a(uuid);
            c0794oMM3598a.m3855a(C1089tp.f5692i.getKey(), c0145cJ.m805a().m5523bN());
            c0794oMM3598a.m3855a(C1089tp.f5693j.getKey(), c0145cJ.m806z());
            this.f1112b.f4294mG = 20;
        }
        C0427hQ.m2004d(this.f1586e);
        C1194vo.m6653c(new C1254wv(c0145cJ.m805a(), c0145cJ.m806z()));
        m791Q();
        C1144ur.f6002rY = 20;
    }
}
