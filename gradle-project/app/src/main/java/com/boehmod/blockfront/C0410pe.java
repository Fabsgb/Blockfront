package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pe, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pe.class */
public final class C0410pe extends oX {

    @NotNull
    public static final Codec<C0410pe> v = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.DOUBLE.fieldOf("x").forGetter(c0410pe -> {
            return Double.valueOf(c0410pe.c.x);
        }), Codec.DOUBLE.fieldOf("y").forGetter(c0410pe2 -> {
            return Double.valueOf(c0410pe2.c.y);
        }), Codec.DOUBLE.fieldOf("z").forGetter(c0410pe3 -> {
            return Double.valueOf(c0410pe3.c.z);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0410pe4 -> {
            return Float.valueOf(c0410pe4.h.x);
        }), Codec.FLOAT.fieldOf("yaw").forGetter(c0410pe5 -> {
            return Float.valueOf(c0410pe5.h.y);
        }), Codec.FLOAT.fieldOf("yawHead").forGetter(c0410pe6 -> {
            return Float.valueOf(c0410pe6.ky);
        }), Codec.STRING.fieldOf("skin").forGetter(c0410pe7 -> {
            return c0410pe7.skin;
        }), C0411pf.w.fieldOf("loadout").forGetter(c0410pe8 -> {
            return c0410pe8.a;
        }), pB.C.listOf().fieldOf("waypoints").forGetter(c0410pe9 -> {
            return c0410pe9.aB.stream().map(aVar -> {
                return aVar.o;
            }).toList();
        })).apply(instance, (d, d2, d3, f, f2, f3, str, c0411pf, list) -> {
            C0410pe c0410pe10 = new C0410pe(d.doubleValue(), d2.doubleValue(), d3.doubleValue(), f.floatValue(), f2.floatValue(), f3.floatValue(), str, c0411pf);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                c0410pe10.aB.add(new a((Vec3) it.next()));
            }
            return c0410pe10;
        });
    });
    public final List<a> aB;
    public float ky;
    public String skin;
    public C0411pf a;

    public C0410pe() {
        this.aB = new ObjectArrayList();
    }

    public C0410pe(double d, double d2, double d3, float f, float f2, float f3, String str, C0411pf c0411pf) {
        super(d, d2, d3, f, f2);
        this.aB = new ObjectArrayList();
        this.ky = f3;
        this.skin = str;
        this.a = c0411pf;
    }

    public C0410pe(@NotNull Player player, @NotNull String str, @NotNull C0411pf c0411pf) {
        super(player, player.getXRot(), player.getYRot());
        this.aB = new ObjectArrayList();
        this.ky = player.getYHeadRot();
        this.skin = str;
        this.a = c0411pf;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.pe$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pe$a.class */
    public static class a {
        public Vec3 o;

        public a(Vec3 vec3) {
            this.o = vec3;
        }
    }
}
