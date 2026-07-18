package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.UUID;
import java.util.function.Supplier;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pl */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pl.class */
public final class C0872pl extends C0805oX {

    /* JADX INFO: renamed from: A */
    @NotNull
    public static final Codec<C0872pl> f4577A = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.DOUBLE.fieldOf("x").forGetter(c0872pl -> {
            return Double.valueOf(c0872pl.f4424c.x);
        }), Codec.DOUBLE.fieldOf("y").forGetter(c0872pl2 -> {
            return Double.valueOf(c0872pl2.f4424c.y);
        }), Codec.DOUBLE.fieldOf("z").forGetter(c0872pl3 -> {
            return Double.valueOf(c0872pl3.f4424c.z);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0872pl4 -> {
            return Float.valueOf(c0872pl4.f4423h.x);
        }), Codec.FLOAT.fieldOf("yaw").forGetter(c0872pl5 -> {
            return Float.valueOf(c0872pl5.f4423h.y);
        }), Codec.BOOL.fieldOf("isAllies").forGetter(c0872pl6 -> {
            return Boolean.valueOf(c0872pl6.f4581gj);
        }), ResourceLocation.CODEC.fieldOf("entity").forGetter(c0872pl7 -> {
            return C1292xo.m7894a(c0872pl7.f4580c);
        })).apply(instance, (d, d2, d3, f, f2, bool, resourceLocation) -> {
            return new C0872pl(d.doubleValue(), d2.doubleValue(), d3.doubleValue(), f.floatValue(), f2.floatValue(), bool.booleanValue(), C1292xo.m7895a(resourceLocation));
        });
    });

    /* JADX INFO: renamed from: nI */
    private static final int f4578nI = 30;

    /* JADX INFO: renamed from: t */
    @NotNull
    private final UUID f4579t;

    /* JADX INFO: renamed from: c */
    public Supplier<? extends EntityType<?>> f4580c;

    /* JADX INFO: renamed from: gj */
    public boolean f4581gj;

    /* JADX INFO: renamed from: nJ */
    private int f4582nJ;

    public C0872pl() {
        this.f4579t = UUID.randomUUID();
        this.f4582nJ = 30;
    }

    public C0872pl(double d, double d2, double d3, float f, float f2, boolean z, @NotNull Supplier<? extends EntityType<?>> supplier) {
        super(d, d2, d3, f, f2);
        this.f4579t = UUID.randomUUID();
        this.f4582nJ = 30;
        this.f4581gj = z;
        this.f4580c = supplier;
    }

    public C0872pl(@NotNull Player player, boolean z, @NotNull Supplier<? extends EntityType<?>> supplier) {
        super(player);
        this.f4579t = UUID.randomUUID();
        this.f4582nJ = 30;
        this.f4581gj = z;
        this.f4580c = supplier;
    }

    /* JADX INFO: renamed from: a */
    public void m4393a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Level level) {
        int i = this.f4582nJ;
        this.f4582nJ = i - 1;
        if (i <= 0) {
            this.f4582nJ = 30;
            if (!m4395a(abstractC0787oF, level)) {
                m4394b(abstractC0787oF, level);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m4394b(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Level level) {
        Entity entityCreate;
        if (level.isLoaded(BlockPos.containing(this.f4424c)) && (entityCreate = this.f4580c.get().create(level)) != null) {
            if (entityCreate instanceof C0726my) {
                ((C0726my) entityCreate).mo3282e(abstractC0787oF);
                if (entityCreate instanceof AbstractC0779ny) {
                    AbstractC0779ny abstractC0779ny = (AbstractC0779ny) entityCreate;
                    abstractC0779ny.m3495b(this.f4579t);
                    abstractC0779ny.m3496a(this.f4581gj ? abstractC0787oF.m3623a() : abstractC0787oF.m3624b());
                }
            }
            level.addFreshEntity(entityCreate);
            entityCreate.setPos(this.f4424c);
            entityCreate.setYRot(this.f4423h.y);
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m4395a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull Level level) {
        C0805oX c0805oXM3790c = abstractC0787oF.m3582b().m3790c();
        if (c0805oXM3790c == null) {
            return true;
        }
        for (AbstractC0779ny abstractC0779ny : level.getEntitiesOfClass(AbstractC0779ny.class, new AABB(c0805oXM3790c.m4150c()).inflate(abstractC0787oF.m3596aV()))) {
            if (!abstractC0779ny.m3504aP() && this.f4579t.equals(abstractC0779ny.m3494d())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.boehmod.blockfront.C0805oX
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0872pl mo4124d() {
        return new C0872pl(this.f4424c.x, this.f4424c.y, this.f4424c.z, this.f4423h.x, this.f4423h.y, this.f4581gj, this.f4580c);
    }
}
