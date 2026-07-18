package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qB */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qB.class */
public class C0889qB extends AbstractC0835pA {

    /* JADX INFO: renamed from: eG */
    @NotNull
    private static final ResourceLocation f4630eG = C0564jv.m2555d("textures/misc/debug/mapeffect/condition.png");

    /* JADX INFO: renamed from: N */
    @NotNull
    public static final MapCodec<C0889qB> f4631N = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.STRING.optionalFieldOf("targetEffectId", "").forGetter(c0889qB -> {
            return c0889qB.f4632cc;
        }), a.CODEC.optionalFieldOf("condition", a.GAME_STARTED).forGetter(c0889qB2 -> {
            return c0889qB2.f4633a;
        })).apply(instance, C0889qB::new);
    });

    /* JADX INFO: renamed from: cc */
    @NotNull
    public String f4632cc;

    /* JADX INFO: renamed from: a */
    @NotNull
    public a f4633a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private transient C1018sY f4634b;

    public C0889qB() {
        this("", a.GAME_STARTED);
    }

    public C0889qB(@NotNull String str, @NotNull a aVar) {
        this.f4632cc = str;
        this.f4633a = aVar;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4218a(@NotNull Minecraft minecraft, @NotNull C1018sY c1018sY) {
        super.mo4218a(minecraft, c1018sY);
        this.f4634b = c1018sY;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4220a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        if (this.f4634b == null || this.f4632cc.isEmpty()) {
            return;
        }
        this.f4634b.m5607a(this.f4632cc, this.f4633a.isMet(abstractC0787oF));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo4227H());
        objectArrayList.add(new C0857pW(Component.literal("Target Effect ID"), () -> {
            return this.f4632cc;
        }, str -> {
            this.f4632cc = str;
        }));
        objectArrayList.add(new C0852pR(Component.literal("Condition"), a.class, () -> {
            return this.f4633a;
        }, aVar -> {
            this.f4633a = aVar;
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        list.add(Component.literal("Target: ").append(Component.literal(this.f4632cc.isEmpty() ? "<none>" : this.f4632cc).withStyle(ChatFormatting.GRAY)));
        list.add(Component.literal("Condition: ").append(Component.literal(this.f4633a.name()).withStyle(ChatFormatting.GRAY)));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4630eG;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.qB$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qB$a.class */
    public enum a {
        GAME_STARTED(abstractC0787oF -> {
            return abstractC0787oF.m3587a() == EnumC0795oN.GAME;
        });


        @NotNull
        public static final Codec<a> CODEC = Codec.STRING.xmap(a::valueOf, (v0) -> {
            return v0.name();
        });

        @NotNull
        private final Predicate<AbstractC0787oF<?, ?, ?>> predicate;

        a(@NotNull Predicate predicate) {
            this.predicate = predicate;
        }

        public boolean isMet(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
            return this.predicate.test(abstractC0787oF);
        }
    }
}
