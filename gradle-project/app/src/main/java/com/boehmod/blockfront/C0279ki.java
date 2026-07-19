package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.commands.CommandSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ki, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ki.class */
public final class C0279ki implements jU {

    @NotNull
    public static final Codec<C0279ki> l = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.optionalFieldOf("type", "single").forGetter(c0279ki -> {
            return "single";
        }), pB.H.fieldOf("mapEffect").forGetter(c0279ki2 -> {
            return c0279ki2.e;
        })).apply(instance, (str, pAVar) -> {
            return new C0279ki(pAVar);
        });
    });

    @NotNull
    private final pA e;

    @NotNull
    private final C0272kb a = new C0272kb();

    public C0279ki(@NotNull pA pAVar) {
        this.e = pAVar;
    }

    @NotNull
    public pA a() {
        return this.e;
    }

    @Override // com.boehmod.blockfront.jU
    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0272kb mo565a() {
        return this.a;
    }

    @Override // com.boehmod.blockfront.jU
    public void c(@NotNull CommandSource commandSource) {
    }

    @Override // com.boehmod.blockfront.jU
    public void bp() {
    }
}
