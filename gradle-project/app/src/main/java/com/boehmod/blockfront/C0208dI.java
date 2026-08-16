package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.news.NewsArticleSummary;
import java.util.Iterator;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;

/* JADX INFO: renamed from: com.boehmod.blockfront.dI */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/dI.class */
public final class C0208dI extends C0244ds {

    /* JADX INFO: renamed from: fh */
    private static final Component f1609fh = Component.translatable("bf.menu.news.title");

    /* JADX INFO: renamed from: fi */
    public static final Component f1610fi = Component.translatable("bf.menu.button.nav.text.news");

    /* JADX INFO: renamed from: b */
    private C0289ek<AbstractC0298et> f1611b;

    /* JADX INFO: renamed from: hK */
    private int f1612hK;

    public C0208dI() {
        super(f1609fh, f1610fi);
        this.f1612hK = -1;
    }

    @Override // com.boehmod.blockfront.C0244ds, com.boehmod.blockfront.C0143cG
    /* JADX INFO: renamed from: H */
    public void mo777H() {
        super.mo777H();
        this.f1611b = new C0289ek<>((((this.width / 2) - C0244ds.f1978hc) + C0248dw.f2042hx) - 1, 55, C0248dw.f2040hv, 136, this);
        this.f1611b.m383g(true);
        m794a(this.f1611b);
        this.f1057f.m2863a().m1533aB();
        m1244ai();
    }

    @Override // com.boehmod.blockfront.C0244ds, com.boehmod.blockfront.C0143cG
    public void tick() {
        super.tick();
        if (this.f1611b != null && this.f1612hK != this.f1057f.m2863a().m1529am()) {
            m1244ai();
        }
    }

    /* JADX INFO: renamed from: ai */
    private void m1244ai() {
        C0276eX c0276eXM2863a = this.f1057f.m2863a();
        this.f1612hK = c0276eXM2863a.m1529am();
        List<NewsArticleSummary> listM1528i = c0276eXM2863a.m1528i();
        if (listM1528i.isEmpty()) {
            if (((C0358g) this.f1057f.m2852b()).m1722a().isVerified()) {
                this.f1611b.m1576c(List.of(I18n.get("bf.container.news.loading", new Object[0])));
                return;
            } else {
                this.f1611b.m1576c(List.of(String.valueOf(ChatFormatting.RED) + I18n.get("bf.container.news.fail.par1", new Object[0]), String.valueOf(ChatFormatting.GRAY) + I18n.get("bf.container.news.fail.par2", new Object[0])));
                return;
            }
        }
        this.f1611b.m1578ar();
        Iterator<NewsArticleSummary> it = listM1528i.iterator();
        while (it.hasNext()) {
            this.f1611b.m1577a(new C0296er(it.next()));
        }
    }
}
