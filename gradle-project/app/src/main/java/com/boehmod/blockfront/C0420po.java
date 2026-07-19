package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import java.util.Objects;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.po, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/po.class */
public class C0420po {

    @NotNull
    public final Object2IntMap<a> f = new Object2IntOpenHashMap();
    private final int nL;

    public C0420po(int i) {
        this.nL = i;
    }

    public void bf() {
        this.f.clear();
    }

    public boolean b(@NotNull UUID uuid, @NotNull UUID uuid2) {
        a aVar = new a(uuid, uuid2);
        return this.f.containsKey(aVar) && this.f.getInt(aVar) >= this.nL;
    }

    public void a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull UUID uuid, @NotNull UUID uuid2, @NotNull oF<?, ?, ?> oFVar) {
        a aVar = new a(uuid, uuid2);
        a aVar2 = new a(uuid2, uuid);
        iS iSVarA = cVar.a(uuid);
        iS iSVarA2 = cVar.a(uuid2);
        String username = iSVarA.getUsername();
        String username2 = iSVarA2.getUsername();
        if (this.f.containsKey(aVar2) && this.f.getInt(aVar2) > 0) {
            if (this.f.getInt(aVar2) >= this.nL) {
                b(cVar, uuid2, uuid, oFVar);
            }
            this.f.removeInt(aVar2);
        }
        if (this.f.containsKey(aVar)) {
            int i = this.f.getInt(aVar) + 1;
            this.f.put(aVar, i);
            if (i == this.nL) {
                oR.a(uuid2, (SoundEvent) C0624xc.pU.get(), SoundSource.MASTER, 1.5f);
                oR.a(uuid2, new sQ(Component.translatable("bf.popup.message.dominating", new Object[]{username}).withStyle(ChatFormatting.GOLD), 60));
                oR.a(uuid, (SoundEvent) C0624xc.pU.get(), SoundSource.MASTER, 1.5f);
                oR.a(uuid, new sQ(Component.translatable("bf.popup.message.dominating.by", new Object[]{username2}).withStyle(ChatFormatting.RED).withStyle(ChatFormatting.BOLD), 60));
                oR.a(oFVar, (Component) Component.translatable("bf.message.gamemode.dominating", new Object[]{Component.literal(username2).withColor(ColorReferences.COLOR_WHITE), Component.literal(username).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED));
                return;
            }
            return;
        }
        this.f.put(aVar, 0);
    }

    public void b(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull UUID uuid, @NotNull UUID uuid2, @NotNull oF<?, ?, ?> oFVar) {
        iS iSVarA = cVar.a(uuid);
        iS iSVarA2 = cVar.a(uuid2);
        String username = iSVarA.getUsername();
        String username2 = iSVarA2.getUsername();
        SoundEvent soundEvent = (SoundEvent) C0624xc.pV.get();
        oR.a(uuid, soundEvent, SoundSource.MASTER);
        oR.a(uuid, new sQ(Component.translatable("bf.popup.message.revenge", new Object[]{username2}).withStyle(ChatFormatting.GOLD), 60));
        oR.a(uuid2, soundEvent, SoundSource.MASTER);
        oR.a(uuid2, new sQ(Component.translatable("bf.popup.message.revenge.by", new Object[]{username}).withStyle(ChatFormatting.RED).withStyle(ChatFormatting.BOLD), 60));
        oR.a(oFVar, (Component) Component.translatable("bf.message.gamemode.revenge", new Object[]{Component.literal(username).withColor(ColorReferences.COLOR_WHITE), Component.literal(username2).withColor(ColorReferences.COLOR_WHITE)}).withStyle(ChatFormatting.RED));
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.po$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/po$a.class */
    public static class a {

        @NotNull
        private final UUID u;

        @NotNull
        private final UUID v;

        public a(@NotNull UUID uuid, @NotNull UUID uuid2) {
            this.u = uuid;
            this.v = uuid2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Objects.equals(this.u, aVar.u) && Objects.equals(this.v, aVar.v);
        }

        public int hashCode() {
            return Objects.hash(this.u, this.v) + Objects.hash(this.v, this.u);
        }
    }
}
