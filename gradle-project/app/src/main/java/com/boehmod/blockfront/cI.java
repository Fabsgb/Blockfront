package com.boehmod.blockfront;

import com.boehmod.blockfront.oF;
import com.boehmod.blockfront.oG;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cI.class */
public class cI<G extends oF<G, ?, ?>, C extends oG<G, ?>> extends cH<G, C> {
    public cI(@Nullable Screen screen, @NotNull oO oOVar, @NotNull G g, @NotNull C c) {
        super(screen, g, c, oOVar);
    }

    @Override // com.boehmod.blockfront.cH, com.boehmod.blockfront.C0080cx
    public void E() {
        super.E();
        Map<sV, ObjectList<C0411pf>> mapM772a = this.f75b.m772a(this.f73b);
        Set<sV> setE = this.f74b.e();
        for (Map.Entry<sV, ObjectList<C0411pf>> entry : mapM772a.entrySet()) {
            ObjectList<C0411pf> value = entry.getValue();
            sV key = entry.getKey();
            if (key != null && !setE.contains(key)) {
                a(key, value, new String[]{String.valueOf(ChatFormatting.BOLD) + I18n.get(key.al(), new Object[0]) + String.valueOf(ChatFormatting.WHITE) + " - ", I18n.get(key.p(), new Object[0])}, oR.a((oF<?, ?, ?>) this.f74b, key, this.f73b));
            }
        }
        addRenderableWidget(new C0123en((this.width - 16) - 10, 56, 16, 16));
    }

    @Override // com.boehmod.blockfront.cH
    public void a(@NotNull cJ cJVar) {
        if (this.b.player == null) {
            return;
        }
        oI oIVarB = this.f74b.b();
        UUID uuid = this.b.player.getUUID();
        oO oOVarA = oIVarB.a(uuid);
        if (oOVarA == null) {
            return;
        }
        if (oOVarA.a((oF<?, ?, ?>) this.f74b).a(cJVar.m264a(), cJVar.z()) != null) {
            oM oMVarA = this.f74b.a(uuid);
            oMVarA.m787a(C0529tp.i.getKey(), cJVar.m264a().bN());
            oMVarA.m787a(C0529tp.j.getKey(), cJVar.z());
            this.f75b.mG = 20;
        }
        hQ.d(this.e);
        C0582vo.c(new C0616wv(cJVar.m264a(), cJVar.z()));
        Q();
        C0558ur.rY = 20;
    }
}
