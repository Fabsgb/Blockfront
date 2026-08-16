package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0184c;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import java.util.Objects;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pK.class */
public class C0846pK {

    /* JADX INFO: renamed from: f */
    @NotNull
    public final Object2IntMap<a> f4556f = new Object2IntOpenHashMap();

    /* JADX INFO: renamed from: pK */
    private final int f4557pK;

    public C0846pK(int i) {
        this.f4557pK = i;
    }

    /* JADX INFO: renamed from: bd */
    public void m3904bd() {
        this.f4556f.clear();
    }

    /* JADX INFO: renamed from: b */
    public boolean m3905b(@NotNull UUID uuid, @NotNull UUID uuid2) {
        a aVar = new a(uuid, uuid2);
        return this.f4556f.containsKey(aVar) && this.f4556f.getInt(aVar) >= this.f4557pK;
    }

    /* JADX INFO: renamed from: a */
    public void m3906a(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull UUID uuid, @NotNull UUID uuid2, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        a aVar = new a(uuid, uuid2);
        a aVar2 = new a(uuid2, uuid);
        C0555jl c0555jlM1149a = abstractC0184c.m1149a(uuid);
        C0555jl c0555jlM1149a2 = abstractC0184c.m1149a(uuid2);
        String username = c0555jlM1149a.getUsername();
        String username2 = c0555jlM1149a2.getUsername();
        if (this.f4556f.containsKey(aVar2) && this.f4556f.getInt(aVar2) > 0) {
            if (this.f4556f.getInt(aVar2) >= this.f4557pK) {
                m3907b(abstractC0184c, uuid2, uuid, abstractC0863pb);
            }
            this.f4556f.removeInt(aVar2);
        }
        if (this.f4556f.containsKey(aVar)) {
            int i = this.f4556f.getInt(aVar) + 1;
            this.f4556f.put(aVar, i);
            if (i == this.f4557pK) {
                C0875pn.m4367a(uuid2, (SoundEvent) C1312xz.f8001pW.get(), SoundSource.MASTER, 1.5f);
                C0875pn.m4380a(uuid2, new C1088tn(Component.translatable("bf.popup.message.dominating", new Object[]{username}).withStyle(ChatFormatting.GOLD), 60));
                C0875pn.m4367a(uuid, (SoundEvent) C1312xz.f8001pW.get(), SoundSource.MASTER, 1.5f);
                C0875pn.m4380a(uuid, new C1088tn(Component.translatable("bf.popup.message.dominating.by", new Object[]{username2}).withStyle(ChatFormatting.RED).withStyle(ChatFormatting.BOLD), 60));
                C0875pn.m4417a(abstractC0863pb, (Component) Component.translatable("bf.message.gamemode.dominating", new Object[]{Component.literal(username2).withColor(ColorReferences.COLOR_WHITE), Component.literal(username).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED));
                return;
            }
            return;
        }
        this.f4556f.put(aVar, 0);
    }

    /* JADX INFO: renamed from: b */
    public void m3907b(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull UUID uuid, @NotNull UUID uuid2, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        C0555jl c0555jlM1149a = abstractC0184c.m1149a(uuid);
        C0555jl c0555jlM1149a2 = abstractC0184c.m1149a(uuid2);
        String username = c0555jlM1149a.getUsername();
        String username2 = c0555jlM1149a2.getUsername();
        SoundEvent soundEvent = (SoundEvent) C1312xz.f8002pX.get();
        C0875pn.m4363a(uuid, soundEvent, SoundSource.MASTER);
        C0875pn.m4380a(uuid, new C1088tn(Component.translatable("bf.popup.message.revenge", new Object[]{username2}).withStyle(ChatFormatting.GOLD), 60));
        C0875pn.m4363a(uuid2, soundEvent, SoundSource.MASTER);
        C0875pn.m4380a(uuid2, new C1088tn(Component.translatable("bf.popup.message.revenge.by", new Object[]{username}).withStyle(ChatFormatting.RED).withStyle(ChatFormatting.BOLD), 60));
        C0875pn.m4417a(abstractC0863pb, (Component) Component.translatable("bf.message.gamemode.revenge", new Object[]{Component.literal(username).withColor(ColorReferences.COLOR_WHITE), Component.literal(username2).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED));
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.pK$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pK$a.class */
    public static class a {

        /* JADX INFO: renamed from: u */
        @NotNull
        private final UUID f4558u;

        /* JADX INFO: renamed from: v */
        @NotNull
        private final UUID f4559v;

        public a(@NotNull UUID uuid, @NotNull UUID uuid2) {
            this.f4558u = uuid;
            this.f4559v = uuid2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Objects.equals(this.f4558u, aVar.f4558u) && Objects.equals(this.f4559v, aVar.f4559v);
        }

        public int hashCode() {
            return Objects.hash(this.f4558u, this.f4559v) + Objects.hash(this.f4559v, this.f4558u);
        }
    }
}
