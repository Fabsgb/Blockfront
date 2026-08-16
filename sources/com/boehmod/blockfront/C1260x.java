package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import it.unimi.dsi.fastutil.objects.ObjectLists;
import java.lang.management.ManagementFactory;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.x */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/x.class */
public final class C1260x implements InterfaceC0009F<C0994s> {

    /* JADX INFO: renamed from: r */
    @NotNull
    private static final String f6803r = "-javaagent:";

    /* JADX INFO: renamed from: d */
    @NotNull
    private static final ObjectList<String> f6804d = ObjectLists.unmodifiable(new ObjectArrayList(new String[]{"-agentpath:", "-agentlib:"}));

    /* JADX INFO: renamed from: e */
    @NotNull
    private static final ObjectList<String> f6805e = ObjectLists.unmodifiable(new ObjectArrayList(new String[]{"com.modrinth.theseus.agent.TheseusAgent"}));

    /* JADX INFO: renamed from: a */
    private static boolean m7121a(@NotNull String str) {
        String strSubstring = str.substring(f6803r.length());
        int iIndexOf = strSubstring.indexOf(61);
        try {
            JarFile jarFile = new JarFile(iIndexOf < 0 ? strSubstring : strSubstring.substring(0, iIndexOf));
            try {
                Manifest manifest = jarFile.getManifest();
                if (manifest != null) {
                    String value = manifest.getMainAttributes().getValue("Premain-Class");
                    boolean z = value != null && f6805e.contains(value);
                    jarFile.close();
                    return z;
                }
                jarFile.close();
                return false;
            } catch (Throwable th) {
                try {
                    jarFile.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            return true;
        }
        return true;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static ObjectList<String> m7122a() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (String str : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
            if (str.startsWith(f6803r)) {
                if (!m7121a(str)) {
                    objectArrayList.add(str);
                }
            } else {
                ObjectListIterator it = f6804d.iterator();
                while (it.hasNext()) {
                    if (str.startsWith((String) it.next())) {
                        objectArrayList.add(str);
                        break;
                    }
                }
            }
        }
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    @Nullable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String mo14a(@NotNull Minecraft minecraft, @NotNull C0994s c0994s) {
        if (!C0529jL.m2334ag()) {
            return null;
        }
        ObjectList<String> objectListM7122a = m7122a();
        if (objectListM7122a.isEmpty()) {
            return null;
        }
        return String.join((CharSequence) ", ", (Iterable<? extends CharSequence>) objectListM7122a);
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0994s.a mo11a() {
        return C0994s.a.STARTUP;
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    /* JADX INFO: renamed from: g */
    public int mo12g() {
        return 6;
    }
}
