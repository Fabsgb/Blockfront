package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.commands.CommandSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ki */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ki.class */
public final class C0604ki implements InterfaceC0537jU {

    /* JADX INFO: renamed from: l */
    @NotNull
    public static final Codec<C0604ki> f3308l = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.optionalFieldOf("type", "single").forGetter(c0604ki -> {
            return "single";
        }), C0836pB.f4476H.fieldOf("mapEffect").forGetter(c0604ki2 -> {
            return c0604ki2.f3309e;
        })).apply(instance, (str, abstractC0835pA) -> {
            return new C0604ki(abstractC0835pA);
        });
    });

    /* JADX INFO: renamed from: e */
    @NotNull
    private final AbstractC0835pA f3309e;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0597kb f3310a = new C0597kb();

    public C0604ki(@NotNull AbstractC0835pA abstractC0835pA) {
        this.f3309e = abstractC0835pA;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AbstractC0835pA m2645a() {
        return this.f3309e;
    }

    @Override // com.boehmod.blockfront.InterfaceC0537jU
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0597kb mo2429a() {
        return this.f3310a;
    }

    @Override // com.boehmod.blockfront.InterfaceC0537jU
    /* JADX INFO: renamed from: c */
    public void mo2430c(@NotNull CommandSource commandSource) {
    }

    @Override // com.boehmod.blockfront.InterfaceC0537jU
    /* JADX INFO: renamed from: bp */
    public void mo2431bp() {
    }
}
