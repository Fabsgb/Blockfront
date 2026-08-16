package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p000ac.RuntimeSources;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.util.Map;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.E */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/E.class */
public final class C0008E implements InterfaceC0009F<C0994s> {

    /* JADX INFO: renamed from: am */
    private static final int f143am = 375;

    /* JADX INFO: renamed from: an */
    private static final int f144an = 10;

    /* JADX INFO: renamed from: ab */
    private int f145ab = 0;

    /* JADX INFO: renamed from: a */
    private static void m29a(@NotNull String str, @NotNull String str2, @NotNull ObjectOpenHashSet<String> objectOpenHashSet, @NotNull ObjectList<String> objectList) {
        if (objectList.size() < 10 && !RuntimeSources.isKnownClassName(str) && objectOpenHashSet.add(str)) {
            objectList.add(str + " @ " + str2);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    private static ObjectList<String> m30d() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        ObjectOpenHashSet objectOpenHashSet = new ObjectOpenHashSet();
        boolean z = false;
        try {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                if (objectArrayList.size() >= 10) {
                    break;
                }
                Thread key = entry.getKey();
                String name = key.getName();
                if (RuntimeSources.THREAD_ATTACH_LISTENER.equals(name)) {
                    z = true;
                }
                m29a(key.getClass().getName(), name, objectOpenHashSet, objectArrayList);
                ClassLoader contextClassLoader = key.getContextClassLoader();
                if (contextClassLoader != null) {
                    m29a(contextClassLoader.getClass().getName(), name, objectOpenHashSet, objectArrayList);
                }
                for (StackTraceElement stackTraceElement : entry.getValue()) {
                    m29a(stackTraceElement.getClassName(), name, objectOpenHashSet, objectArrayList);
                }
            }
            if (z && !objectArrayList.isEmpty()) {
                objectArrayList.addFirst(RuntimeSources.THREAD_ATTACH_LISTENER);
            }
            return objectArrayList;
        } catch (Throwable th) {
            return objectArrayList;
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    @Nullable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String mo14a(@NotNull Minecraft minecraft, @NotNull C0994s c0994s) {
        if (!C0529jL.m2334ag()) {
            return null;
        }
        int i = this.f145ab;
        this.f145ab = i - 1;
        if (i > 0) {
            return null;
        }
        this.f145ab = f143am;
        ObjectList<String> objectListM30d = m30d();
        if (objectListM30d.isEmpty()) {
            return null;
        }
        return String.join((CharSequence) ", ", (Iterable<? extends CharSequence>) objectListM30d);
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0994s.a mo11a() {
        return C0994s.a.RUNTIME;
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    /* JADX INFO: renamed from: g */
    public int mo12g() {
        return 8;
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0994s.b mo13a() {
        return C0994s.b.SILENT;
    }
}
