package com.boehmod.blockfront;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/cQ.class */
public final class cQ extends cP {
    public cQ(Screen screen, List<C0408pc> list, oF<?, ?, ?> oFVar) {
        super(screen, list, oFVar);
        list.forEach(c0408pc -> {
            Item item = c0408pc.a().getItem();
            a(c0408pc, new String[]{item.getName(item.getDefaultInstance()).getString(), String.valueOf(ChatFormatting.GREEN) + "$" + C0637xp.a(c0408pc.bk())});
        });
    }

    @Override // com.boehmod.blockfront.cP
    public void init() {
        super.init();
    }

    @Override // com.boehmod.blockfront.cP
    public void a(@NotNull Item item, int i) {
        C0582vo.c(new wE(item));
        this.b.setScreen((Screen) null);
        C0558ur.rY = 20;
    }
}
