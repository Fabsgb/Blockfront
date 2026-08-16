package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import net.minecraft.SharedConstants;
import net.minecraft.client.Minecraft;
import net.neoforged.fml.ModList;
import net.neoforged.neoforgespi.language.IModInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.w */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/w.class */
public final class C1207w implements InterfaceC0009F<C0994s> {

    /* JADX INFO: renamed from: Y */
    private static final int f6570Y = 250;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final IntSet f6571a = new IntOpenHashSet(new int[]{1596600775, -1957884270, -1049597195, 1050399304, 2047205814});

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final Class<?>[] f6572a = {C0994s.class, C1048t.class, C1154v.class};

    /* JADX INFO: renamed from: Z */
    private static final int f6573Z = -2128831035;

    /* JADX INFO: renamed from: aa */
    private static final int f6574aa = 16777619;

    /* JADX INFO: renamed from: ab */
    private int f6575ab = 0;

    @Override // com.boehmod.blockfront.InterfaceC0009F
    @Nullable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String mo14a(@NotNull Minecraft minecraft, @NotNull C0994s c0994s) {
        int i = this.f6575ab;
        this.f6575ab = i - 1;
        if (i > 0) {
            return null;
        }
        this.f6575ab = f6570Y;
        int iM6900a = m6900a(c0994s);
        if (f6571a.contains(iM6900a)) {
            return null;
        }
        return Integer.toHexString(iM6900a);
    }

    /* JADX INFO: renamed from: a */
    private static int m6900a(@NotNull C0994s c0994s) {
        int iM6902a = m6902a(m6902a(f6573Z, SharedConstants.getCurrentVersion().getId()), C0030a.f265c);
        ObjectArrayList objectArrayList = new ObjectArrayList();
        Iterator it = ModList.get().getMods().iterator();
        while (it.hasNext()) {
            objectArrayList.add(((IModInfo) it.next()).getModId().toLowerCase(Locale.ROOT));
        }
        objectArrayList.sort(Comparator.naturalOrder());
        int iM6901a = m6901a(iM6902a, objectArrayList.size());
        ObjectListIterator it2 = objectArrayList.iterator();
        while (it2.hasNext()) {
            iM6901a = m6902a(iM6901a, (String) it2.next());
        }
        for (Class<?> cls : f6572a) {
            iM6901a = m6901a(m6901a(iM6901a, cls.getDeclaredMethods().length), cls.getDeclaredFields().length);
        }
        return m6901a(iM6901a, c0994s.m5574f());
    }

    /* JADX INFO: renamed from: a */
    private static int m6901a(int i, int i2) {
        return (i ^ i2) * f6574aa;
    }

    /* JADX INFO: renamed from: a */
    private static int m6902a(int i, @NotNull String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            i = m6901a(i, str.charAt(i2));
        }
        return i;
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0994s.a mo11a() {
        return C0994s.a.ALL;
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0994s.b mo13a() {
        return C0994s.b.SILENT;
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    /* JADX INFO: renamed from: g */
    public int mo12g() {
        return 10;
    }
}
