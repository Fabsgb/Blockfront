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

/* JADX INFO: renamed from: com.boehmod.blockfront.qY */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qY.class */
public class C0913qY extends AbstractC0858pW {

    /* JADX INFO: renamed from: eF */
    @NotNull
    private static final ResourceLocation f5101eF = C0532jO.m2378d("textures/misc/debug/mapeffect/condition.png");

    /* JADX INFO: renamed from: O */
    @NotNull
    public static final MapCodec<C0913qY> f5102O = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.STRING.optionalFieldOf("targetEffectId", "").forGetter(c0913qY -> {
            return c0913qY.f5103cm;
        }), a.CODEC.optionalFieldOf("condition", a.GAME_STARTED).forGetter(c0913qY2 -> {
            return c0913qY2.f5104a;
        })).apply(instance, C0913qY::new);
    });

    /* JADX INFO: renamed from: cm */
    @NotNull
    public String f5103cm;

    /* JADX INFO: renamed from: a */
    @NotNull
    public a f5104a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private transient C1096tv f5105b;

    public C0913qY() {
        this("", a.GAME_STARTED);
    }

    public C0913qY(@NotNull String str, @NotNull a aVar) {
        this.f5103cm = str;
        this.f5104a = aVar;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3953a(@NotNull Minecraft minecraft, @NotNull C1096tv c1096tv) {
        super.mo3953a(minecraft, c1096tv);
        this.f5105b = c1096tv;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3933a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        if (this.f5105b == null || this.f5103cm.isEmpty()) {
            return;
        }
        this.f5105b.m6095a(this.f5103cm, this.f5104a.isMet(abstractC0863pb));
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo3946J());
        objectArrayList.add(new C0933qs(Component.literal("Target Effect ID"), () -> {
            return this.f5103cm;
        }, str -> {
            this.f5103cm = str;
        }));
        objectArrayList.add(new C0928qn(Component.literal("Condition"), a.class, () -> {
            return this.f5104a;
        }, aVar -> {
            this.f5104a = aVar;
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        list.add(Component.literal("Target: ").append(Component.literal(this.f5103cm.isEmpty() ? "<none>" : this.f5103cm).withStyle(ChatFormatting.GRAY)));
        list.add(Component.literal("Condition: ").append(Component.literal(this.f5104a.name()).withStyle(ChatFormatting.GRAY)));
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f5101eF;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.qY$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qY$a.class */
    public enum a {
        GAME_STARTED(abstractC0863pb -> {
            return abstractC0863pb.m4023a() == EnumC0871pj.GAME;
        });


        @NotNull
        public static final Codec<a> CODEC = Codec.STRING.xmap(a::valueOf, (v0) -> {
            return v0.name();
        });

        @NotNull
        private final Predicate<AbstractC0863pb<?, ?, ?>> predicate;

        a(Predicate predicate) {
            this.predicate = predicate;
        }

        public boolean isMet(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
            return this.predicate.test(abstractC0863pb);
        }
    }
}
