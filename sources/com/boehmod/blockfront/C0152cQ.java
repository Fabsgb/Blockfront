package com.boehmod.blockfront;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cQ.class */
public final class C0152cQ extends AbstractC0151cP {
    public C0152cQ(Screen screen, List<C0863pc> list, AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        super(screen, list, abstractC0787oF);
        list.forEach(c0863pc -> {
            Item item = c0863pc.m4311a().getItem();
            m975a(c0863pc, new String[]{item.getName(item.getDefaultInstance()).getString(), String.valueOf(ChatFormatting.GREEN) + "$" + C1293xp.m7912a(c0863pc.m4312bk())});
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0151cP
    public void init() {
        super.init();
    }

    @Override // com.boehmod.blockfront.AbstractC0151cP
    /* JADX INFO: renamed from: a */
    public void mo977a(@NotNull Item item, int i) {
        C1194vo.m6653c(new C1211wE(item));
        this.f1587b.setScreen((Screen) null);
        C1144ur.f6002rY = 20;
    }
}
