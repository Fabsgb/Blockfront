package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.commands.CommandSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kE */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kE.class */
public final class C0575kE implements InterfaceC0613kq {

    /* JADX INFO: renamed from: l */
    @NotNull
    public static final Codec<C0575kE> f3340l = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.optionalFieldOf("type", "single").forGetter(c0575kE -> {
            return "single";
        }), C0859pX.f4605H.fieldOf("mapEffect").forGetter(c0575kE2 -> {
            return c0575kE2.f3341e;
        })).apply(instance, (str, abstractC0858pW) -> {
            return new C0575kE(abstractC0858pW);
        });
    });

    /* JADX INFO: renamed from: e */
    @NotNull
    private final AbstractC0858pW f3341e;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0620kx f3342a = new C0620kx();

    public C0575kE(@NotNull AbstractC0858pW abstractC0858pW) {
        this.f3341e = abstractC0858pW;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0858pW m2595a() {
        return this.f3341e;
    }

    @Override // com.boehmod.blockfront.InterfaceC0613kq
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0620kx mo2596a() {
        return this.f3342a;
    }

    @Override // com.boehmod.blockfront.InterfaceC0613kq
    /* JADX INFO: renamed from: c */
    public void mo2597c(@NotNull CommandSource commandSource) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0613kq
    /* JADX INFO: renamed from: bA */
    public void mo2598bA() {
    }
}
