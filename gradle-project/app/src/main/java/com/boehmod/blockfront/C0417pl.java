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

/* JADX INFO: renamed from: com.boehmod.blockfront.pl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pl.class */
public final class C0417pl extends oX {

    @NotNull
    public static final Codec<C0417pl> A = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.DOUBLE.fieldOf("x").forGetter(c0417pl -> {
            return Double.valueOf(c0417pl.c.x);
        }), Codec.DOUBLE.fieldOf("y").forGetter(c0417pl2 -> {
            return Double.valueOf(c0417pl2.c.y);
        }), Codec.DOUBLE.fieldOf("z").forGetter(c0417pl3 -> {
            return Double.valueOf(c0417pl3.c.z);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0417pl4 -> {
            return Float.valueOf(c0417pl4.h.x);
        }), Codec.FLOAT.fieldOf("yaw").forGetter(c0417pl5 -> {
            return Float.valueOf(c0417pl5.h.y);
        }), Codec.BOOL.fieldOf("isAllies").forGetter(c0417pl6 -> {
            return Boolean.valueOf(c0417pl6.gj);
        }), ResourceLocation.CODEC.fieldOf("entity").forGetter(c0417pl7 -> {
            return C0636xo.a(c0417pl7.c);
        })).apply(instance, (d, d2, d3, f, f2, bool, resourceLocation) -> {
            return new C0417pl(d.doubleValue(), d2.doubleValue(), d3.doubleValue(), f.floatValue(), f2.floatValue(), bool.booleanValue(), C0636xo.a(resourceLocation));
        });
    });
    private static final int nI = 30;

    @NotNull
    private final UUID t;
    public Supplier<? extends EntityType<?>> c;
    public boolean gj;
    private int nJ;

    public C0417pl() {
        this.t = UUID.randomUUID();
        this.nJ = 30;
    }

    public C0417pl(double d, double d2, double d3, float f, float f2, boolean z, @NotNull Supplier<? extends EntityType<?>> supplier) {
        super(d, d2, d3, f, f2);
        this.t = UUID.randomUUID();
        this.nJ = 30;
        this.gj = z;
        this.c = supplier;
    }

    public C0417pl(@NotNull Player player, boolean z, @NotNull Supplier<? extends EntityType<?>> supplier) {
        super(player);
        this.t = UUID.randomUUID();
        this.nJ = 30;
        this.gj = z;
        this.c = supplier;
    }

    public void a(@NotNull oF<?, ?, ?> oFVar, @NotNull Level level) {
        int i = this.nJ;
        this.nJ = i - 1;
        if (i <= 0) {
            this.nJ = 30;
            if (!m865a(oFVar, level)) {
                b(oFVar, level);
            }
        }
    }

    public void b(@NotNull oF<?, ?, ?> oFVar, @NotNull Level level) {
        Entity entityCreate;
        if (level.isLoaded(BlockPos.containing(this.c)) && (entityCreate = this.c.get().create(level)) != null) {
            if (entityCreate instanceof C0349my) {
                ((C0349my) entityCreate).e(oFVar);
                if (entityCreate instanceof AbstractC0376ny) {
                    AbstractC0376ny abstractC0376ny = (AbstractC0376ny) entityCreate;
                    abstractC0376ny.b(this.t);
                    abstractC0376ny.a(this.gj ? oFVar.m755a() : oFVar.m756b());
                }
            }
            level.addFreshEntity(entityCreate);
            entityCreate.setPos(this.c);
            entityCreate.setYRot(this.h.y);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private boolean m865a(@NotNull oF<?, ?, ?> oFVar, @NotNull Level level) {
        oX oXVarC = oFVar.b().c();
        if (oXVarC == null) {
            return true;
        }
        for (AbstractC0376ny abstractC0376ny : level.getEntitiesOfClass(AbstractC0376ny.class, new AABB(oXVarC.c()).inflate(oFVar.aV()))) {
            if (!abstractC0376ny.aP() && this.t.equals(abstractC0376ny.d())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.boehmod.blockfront.oX
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0417pl d() {
        return new C0417pl(this.c.x, this.c.y, this.c.z, this.h.x, this.h.y, this.gj, this.c);
    }
}
