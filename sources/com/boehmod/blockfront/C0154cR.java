package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.AbstractC0864pc;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cR.class */
public class C0154cR<G extends AbstractC0863pb<G, ?, ?>, C extends AbstractC0864pc<G, ?>> extends AbstractC0153cQ<G, C> {
    public C0154cR(@Nullable Screen screen, @NotNull C0872pk c0872pk, @NotNull G g, @NotNull C c) {
        super(screen, g, c, c0872pk);
    }

    @Override // com.boehmod.blockfront.AbstractC0153cQ, com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: H */
    public void mo777H() {
        super.mo777H();
        Map<C1093ts, ObjectList<C0837pB>> mapM4170a = this.f1202b.m4170a(this.f1200b);
        Set<C1093ts> setMo3997e = this.f1201b.mo3997e();
        for (Map.Entry<C1093ts, ObjectList<C0837pB>> entry : mapM4170a.entrySet()) {
            ObjectList<C0837pB> value = entry.getValue();
            C1093ts key = entry.getKey();
            if (key != null && !setMo3997e.contains(key)) {
                m847a(key, value, new String[]{String.valueOf(ChatFormatting.BOLD) + I18n.get(key.m6004as(), new Object[0]) + String.valueOf(ChatFormatting.WHITE) + " - ", I18n.get(key.m6005t(), new Object[0])}, C0875pn.m4466a((AbstractC0863pb<?, ?, ?>) this.f1201b, key, this.f1200b));
            }
        }
        addRenderableWidget(new C0253eA((this.width - 16) - 10, 56, 16, 16));
    }

    @Override // com.boehmod.blockfront.AbstractC0153cQ
    /* JADX INFO: renamed from: a */
    public void mo851a(@NotNull C0155cS c0155cS) {
        if (this.f1058a.player == null) {
            return;
        }
        AbstractC0866pe abstractC0866peM4018b = this.f1201b.m4018b();
        UUID uuid = this.f1058a.player.getUUID();
        C0872pk c0872pkM4229a = abstractC0866peM4018b.m4229a(uuid);
        if (c0872pkM4229a == null) {
            return;
        }
        if (c0872pkM4229a.m4296a((AbstractC0863pb<?, ?, ?>) this.f1201b).m6184a(c0155cS.m859a(), c0155cS.m860D()) != null) {
            C0870pi c0870piM4034a = this.f1201b.m4034a(uuid);
            c0870piM4034a.m4291a(C1062tN.f5745i.getKey(), c0155cS.m859a().m6011cc());
            c0870piM4034a.m4291a(C1062tN.f5746j.getKey(), c0155cS.m860D());
            this.f1202b.f4688oE = 20;
        }
        C0498ih.m2238e(this.f1057f);
        C1169vO.m6648c(new C1227wT(c0155cS.m859a(), c0155cS.m860D()));
        m845U();
        C1117uP.f6071ue = 20;
    }
}
