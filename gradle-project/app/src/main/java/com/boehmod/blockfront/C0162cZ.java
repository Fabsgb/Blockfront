package com.boehmod.blockfront;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.cZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cZ.class */
public final class C0162cZ extends AbstractC0161cY {
    public C0162cZ(Screen screen, List<C0886py> list, AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        super(screen, list, abstractC0863pb);
        list.forEach(c0886py -> {
            Item item = c0886py.m4636c().getItem();
            m1029a(c0886py, new String[]{item.getName(item.getDefaultInstance()).getString(), String.valueOf(ChatFormatting.GREEN) + "$" + C1273xM.m7239b(c0886py.m4637bz())});
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0161cY
    public void init() {
        super.init();
    }

    @Override // com.boehmod.blockfront.AbstractC0161cY
    /* JADX INFO: renamed from: a */
    public void mo1031a(@NotNull Item item, int i) {
        C1169vO.m6648c(new C1288xb(item));
        this.f1058a.setScreen((Screen) null);
        C1117uP.f6071ue = 20;
    }
}
