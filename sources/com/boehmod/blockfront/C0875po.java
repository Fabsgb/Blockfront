package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0183c;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import java.util.Objects;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.po */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/po.class */
public class C0875po {

    /* JADX INFO: renamed from: f */
    @NotNull
    public final Object2IntMap<a> f4587f = new Object2IntOpenHashMap();

    /* JADX INFO: renamed from: nL */
    private final int f4588nL;

    public C0875po(int i) {
        this.f4588nL = i;
    }

    /* JADX INFO: renamed from: bf */
    public void m4416bf() {
        this.f4587f.clear();
    }

    /* JADX INFO: renamed from: b */
    public boolean m4417b(@NotNull UUID uuid, @NotNull UUID uuid2) {
        a aVar = new a(uuid, uuid2);
        return this.f4587f.containsKey(aVar) && this.f4587f.getInt(aVar) >= this.f4588nL;
    }

    /* JADX INFO: renamed from: a */
    public void m4418a(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull UUID uuid, @NotNull UUID uuid2, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        a aVar = new a(uuid, uuid2);
        a aVar2 = new a(uuid2, uuid);
        C0482iS c0482iSM1132a = abstractC0183c.m1132a(uuid);
        C0482iS c0482iSM1132a2 = abstractC0183c.m1132a(uuid2);
        String username = c0482iSM1132a.getUsername();
        String username2 = c0482iSM1132a2.getUsername();
        if (this.f4587f.containsKey(aVar2) && this.f4587f.getInt(aVar2) > 0) {
            if (this.f4587f.getInt(aVar2) >= this.f4588nL) {
                m4419b(abstractC0183c, uuid2, uuid, abstractC0787oF);
            }
            this.f4587f.removeInt(aVar2);
        }
        if (this.f4587f.containsKey(aVar)) {
            int i = this.f4587f.getInt(aVar) + 1;
            this.f4587f.put(aVar, i);
            if (i == this.f4588nL) {
                C0799oR.m3931a(uuid2, (SoundEvent) C1280xc.f7589pU.get(), SoundSource.MASTER, 1.5f);
                C0799oR.m3944a(uuid2, new C1010sQ(Component.translatable("bf.popup.message.dominating", new Object[]{username}).withStyle(ChatFormatting.GOLD), 60));
                C0799oR.m3931a(uuid, (SoundEvent) C1280xc.f7589pU.get(), SoundSource.MASTER, 1.5f);
                C0799oR.m3944a(uuid, new C1010sQ(Component.translatable("bf.popup.message.dominating.by", new Object[]{username2}).withStyle(ChatFormatting.RED).withStyle(ChatFormatting.BOLD), 60));
                C0799oR.m3981a(abstractC0787oF, (Component) Component.translatable("bf.message.gamemode.dominating", new Object[]{Component.literal(username2).withColor(ColorReferences.COLOR_WHITE), Component.literal(username).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED));
                return;
            }
            return;
        }
        this.f4587f.put(aVar, 0);
    }

    /* JADX INFO: renamed from: b */
    public void m4419b(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull UUID uuid, @NotNull UUID uuid2, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        C0482iS c0482iSM1132a = abstractC0183c.m1132a(uuid);
        C0482iS c0482iSM1132a2 = abstractC0183c.m1132a(uuid2);
        String username = c0482iSM1132a.getUsername();
        String username2 = c0482iSM1132a2.getUsername();
        SoundEvent soundEvent = (SoundEvent) C1280xc.f7590pV.get();
        C0799oR.m3927a(uuid, soundEvent, SoundSource.MASTER);
        C0799oR.m3944a(uuid, new C1010sQ(Component.translatable("bf.popup.message.revenge", new Object[]{username2}).withStyle(ChatFormatting.GOLD), 60));
        C0799oR.m3927a(uuid2, soundEvent, SoundSource.MASTER);
        C0799oR.m3944a(uuid2, new C1010sQ(Component.translatable("bf.popup.message.revenge.by", new Object[]{username}).withStyle(ChatFormatting.RED).withStyle(ChatFormatting.BOLD), 60));
        C0799oR.m3981a(abstractC0787oF, (Component) Component.translatable("bf.message.gamemode.revenge", new Object[]{Component.literal(username).withColor(ColorReferences.COLOR_WHITE), Component.literal(username2).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED));
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.po$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/po$a.class */
    public static class a {

        /* JADX INFO: renamed from: u */
        @NotNull
        private final UUID f4589u;

        /* JADX INFO: renamed from: v */
        @NotNull
        private final UUID f4590v;

        public a(@NotNull UUID uuid, @NotNull UUID uuid2) {
            this.f4589u = uuid;
            this.f4590v = uuid2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Objects.equals(this.f4589u, aVar.f4589u) && Objects.equals(this.f4590v, aVar.f4590v);
        }

        public int hashCode() {
            return Objects.hash(this.f4589u, this.f4590v) + Objects.hash(this.f4590v, this.f4589u);
        }
    }
}
