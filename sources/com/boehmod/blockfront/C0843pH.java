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

/* JADX INFO: renamed from: com.boehmod.blockfront.pH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pH.class */
public final class C0843pH extends C0881pt {

    /* JADX INFO: renamed from: A */
    @NotNull
    public static final Codec<C0843pH> f4546A = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.DOUBLE.fieldOf("x").forGetter(c0843pH -> {
            return Double.valueOf(c0843pH.f4827c.x);
        }), Codec.DOUBLE.fieldOf("y").forGetter(c0843pH2 -> {
            return Double.valueOf(c0843pH2.f4827c.y);
        }), Codec.DOUBLE.fieldOf("z").forGetter(c0843pH3 -> {
            return Double.valueOf(c0843pH3.f4827c.z);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0843pH4 -> {
            return Float.valueOf(c0843pH4.f4826h.x);
        }), Codec.FLOAT.fieldOf("yaw").forGetter(c0843pH5 -> {
            return Float.valueOf(c0843pH5.f4826h.y);
        }), Codec.BOOL.fieldOf("isAllies").forGetter(c0843pH6 -> {
            return Boolean.valueOf(c0843pH6.f4550gD);
        }), ResourceLocation.CODEC.fieldOf("entity").forGetter(c0843pH7 -> {
            return C1272xL.m7221a(c0843pH7.f4549c);
        })).apply(instance, (d, d2, d3, f, f2, bool, resourceLocation) -> {
            return new C0843pH(d.doubleValue(), d2.doubleValue(), d3.doubleValue(), f.floatValue(), f2.floatValue(), bool.booleanValue(), C1272xL.m7222a(resourceLocation));
        });
    });

    /* JADX INFO: renamed from: pH */
    private static final int f4547pH = 30;

    /* JADX INFO: renamed from: t */
    @NotNull
    private final UUID f4548t;

    /* JADX INFO: renamed from: c */
    public Supplier<? extends EntityType<?>> f4549c;

    /* JADX INFO: renamed from: gD */
    public boolean f4550gD;

    /* JADX INFO: renamed from: pI */
    private int f4551pI;

    public C0843pH() {
        this.f4548t = UUID.randomUUID();
        this.f4551pI = 30;
    }

    public C0843pH(double d, double d2, double d3, float f, float f2, boolean z, @NotNull Supplier<? extends EntityType<?>> supplier) {
        super(d, d2, d3, f, f2);
        this.f4548t = UUID.randomUUID();
        this.f4551pI = 30;
        this.f4550gD = z;
        this.f4549c = supplier;
    }

    public C0843pH(@NotNull Player player, boolean z, @NotNull Supplier<? extends EntityType<?>> supplier) {
        super(player);
        this.f4548t = UUID.randomUUID();
        this.f4551pI = 30;
        this.f4550gD = z;
        this.f4549c = supplier;
    }

    /* JADX INFO: renamed from: a */
    public void m3881a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Level level) {
        int i = this.f4551pI;
        this.f4551pI = i - 1;
        if (i <= 0) {
            this.f4551pI = 30;
            if (!m3883a(abstractC0863pb, level)) {
                m3882b(abstractC0863pb, level);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3882b(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Level level) {
        Entity entityCreate;
        if (level.isLoaded(BlockPos.containing(this.f4827c)) && (entityCreate = this.f4549c.get().create(level)) != null) {
            if (entityCreate instanceof C0697mU) {
                ((C0697mU) entityCreate).mo3117e(abstractC0863pb);
                if (entityCreate instanceof AbstractC0750nU) {
                    AbstractC0750nU abstractC0750nU = (AbstractC0750nU) entityCreate;
                    abstractC0750nU.m3428b(this.f4548t);
                    abstractC0750nU.m3429a(this.f4550gD ? abstractC0863pb.m4059a() : abstractC0863pb.m4060b());
                }
            }
            level.addFreshEntity(entityCreate);
            entityCreate.setPos(this.f4827c);
            entityCreate.setYRot(this.f4826h.y);
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m3883a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull Level level) {
        C0881pt c0881ptM4226c = abstractC0863pb.m4018b().m4226c();
        if (c0881ptM4226c == null) {
            return true;
        }
        for (AbstractC0750nU abstractC0750nU : level.getEntitiesOfClass(AbstractC0750nU.class, new AABB(c0881ptM4226c.m4587c()).inflate(abstractC0863pb.m4032bk()))) {
            if (!abstractC0750nU.m3441aZ() && this.f4548t.equals(abstractC0750nU.m3427d())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.boehmod.blockfront.C0881pt
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0843pH mo3849d() {
        return new C0843pH(this.f4827c.x, this.f4827c.y, this.f4827c.z, this.f4826h.x, this.f4826h.y, this.f4550gD, this.f4549c);
    }
}
