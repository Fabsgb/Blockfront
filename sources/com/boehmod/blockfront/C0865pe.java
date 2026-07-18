package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pe */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pe.class */
public final class C0865pe extends C0805oX {

    /* JADX INFO: renamed from: v */
    @NotNull
    public static final Codec<C0865pe> f4534v = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.DOUBLE.fieldOf("x").forGetter(c0865pe -> {
            return Double.valueOf(c0865pe.f4424c.x);
        }), Codec.DOUBLE.fieldOf("y").forGetter(c0865pe2 -> {
            return Double.valueOf(c0865pe2.f4424c.y);
        }), Codec.DOUBLE.fieldOf("z").forGetter(c0865pe3 -> {
            return Double.valueOf(c0865pe3.f4424c.z);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0865pe4 -> {
            return Float.valueOf(c0865pe4.f4423h.x);
        }), Codec.FLOAT.fieldOf("yaw").forGetter(c0865pe5 -> {
            return Float.valueOf(c0865pe5.f4423h.y);
        }), Codec.FLOAT.fieldOf("yawHead").forGetter(c0865pe6 -> {
            return Float.valueOf(c0865pe6.f4536ky);
        }), Codec.STRING.fieldOf("skin").forGetter(c0865pe7 -> {
            return c0865pe7.skin;
        }), C0866pf.f4539w.fieldOf("loadout").forGetter(c0865pe8 -> {
            return c0865pe8.f4537a;
        }), C0836pB.f4470C.listOf().fieldOf("waypoints").forGetter(c0865pe9 -> {
            return c0865pe9.f4535aB.stream().map(aVar -> {
                return aVar.f4538o;
            }).toList();
        })).apply(instance, (d, d2, d3, f, f2, f3, str, c0866pf, list) -> {
            C0865pe c0865pe10 = new C0865pe(d.doubleValue(), d2.doubleValue(), d3.doubleValue(), f.floatValue(), f2.floatValue(), f3.floatValue(), str, c0866pf);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                c0865pe10.f4535aB.add(new a((Vec3) it.next()));
            }
            return c0865pe10;
        });
    });

    /* JADX INFO: renamed from: aB */
    public final List<a> f4535aB;

    /* JADX INFO: renamed from: ky */
    public float f4536ky;
    public String skin;

    /* JADX INFO: renamed from: a */
    public C0866pf f4537a;

    public C0865pe() {
        this.f4535aB = new ObjectArrayList();
    }

    public C0865pe(double d, double d2, double d3, float f, float f2, float f3, String str, C0866pf c0866pf) {
        super(d, d2, d3, f, f2);
        this.f4535aB = new ObjectArrayList();
        this.f4536ky = f3;
        this.skin = str;
        this.f4537a = c0866pf;
    }

    public C0865pe(@NotNull Player player, @NotNull String str, @NotNull C0866pf c0866pf) {
        super(player, player.getXRot(), player.getYRot());
        this.f4535aB = new ObjectArrayList();
        this.f4536ky = player.getYHeadRot();
        this.skin = str;
        this.f4537a = c0866pf;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.pe$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pe$a.class */
    public static class a {

        /* JADX INFO: renamed from: o */
        public Vec3 f4538o;

        public a(Vec3 vec3) {
            this.f4538o = vec3;
        }
    }
}
