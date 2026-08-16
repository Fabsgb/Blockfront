package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pA.class */
public final class C0836pA extends C0881pt {

    /* JADX INFO: renamed from: v */
    @NotNull
    public static final Codec<C0836pA> f4503v = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.DOUBLE.fieldOf("x").forGetter(c0836pA -> {
            return Double.valueOf(c0836pA.f4827c.x);
        }), Codec.DOUBLE.fieldOf("y").forGetter(c0836pA2 -> {
            return Double.valueOf(c0836pA2.f4827c.y);
        }), Codec.DOUBLE.fieldOf("z").forGetter(c0836pA3 -> {
            return Double.valueOf(c0836pA3.f4827c.z);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0836pA4 -> {
            return Float.valueOf(c0836pA4.f4826h.x);
        }), Codec.FLOAT.fieldOf("yaw").forGetter(c0836pA5 -> {
            return Float.valueOf(c0836pA5.f4826h.y);
        }), Codec.FLOAT.fieldOf("yawHead").forGetter(c0836pA6 -> {
            return Float.valueOf(c0836pA6.f4505lt);
        }), Codec.STRING.fieldOf("skin").forGetter(c0836pA7 -> {
            return c0836pA7.skin;
        }), C0837pB.f4508w.fieldOf("loadout").forGetter(c0836pA8 -> {
            return c0836pA8.f4506a;
        }), C0859pX.f4599C.listOf().fieldOf("waypoints").forGetter(c0836pA9 -> {
            return c0836pA9.f4504aI.stream().map(aVar -> {
                return aVar.f4507o;
            }).toList();
        })).apply(instance, (d, d2, d3, f, f2, f3, str, c0837pB, list) -> {
            C0836pA c0836pA10 = new C0836pA(d.doubleValue(), d2.doubleValue(), d3.doubleValue(), f.floatValue(), f2.floatValue(), f3.floatValue(), str, c0837pB);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                c0836pA10.f4504aI.add(new a((Vec3) it.next()));
            }
            return c0836pA10;
        });
    });

    /* JADX INFO: renamed from: aI */
    public final List<a> f4504aI;

    /* JADX INFO: renamed from: lt */
    public float f4505lt;
    public String skin;

    /* JADX INFO: renamed from: a */
    public C0837pB f4506a;

    public C0836pA() {
        this.f4504aI = new ObjectArrayList();
    }

    public C0836pA(double d, double d2, double d3, float f, float f2, float f3, String str, C0837pB c0837pB) {
        super(d, d2, d3, f, f2);
        this.f4504aI = new ObjectArrayList();
        this.f4505lt = f3;
        this.skin = str;
        this.f4506a = c0837pB;
    }

    public C0836pA(@NotNull Player player, @NotNull String str, @NotNull C0837pB c0837pB) {
        super(player, player.getXRot(), player.getYRot());
        this.f4504aI = new ObjectArrayList();
        this.f4505lt = player.getYHeadRot();
        this.skin = str;
        this.f4506a = c0837pB;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.pA$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pA$a.class */
    public static class a {

        /* JADX INFO: renamed from: o */
        public Vec3 f4507o;

        public a(Vec3 vec3) {
            this.f4507o = vec3;
        }
    }
}
