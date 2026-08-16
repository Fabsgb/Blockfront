package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.news.NewsArticleSummary;
import com.boehmod.bflib.cloud.packet.common.news.PacketNewsArticleRequest;
import com.boehmod.bflib.cloud.packet.common.news.PacketNewsImageRequest;
import com.boehmod.bflib.cloud.packet.common.news.PacketNewsListRequest;
import com.mojang.blaze3d.platform.NativeImage;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import java.io.ByteArrayInputStream;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.eX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eX.class */
public final class C0276eX {

    /* JADX INFO: renamed from: jH */
    private static final int f2190jH = 200;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final a f2191a = new a(null, 0, 0);

    /* JADX INFO: renamed from: g */
    @NotNull
    private final C0623l f2192g;

    /* JADX INFO: renamed from: K */
    @NotNull
    private List<NewsArticleSummary> f2193K = List.of();

    /* JADX INFO: renamed from: jI */
    private int f2194jI = 0;

    /* JADX INFO: renamed from: cr */
    private boolean f2195cr = false;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final Long2ObjectMap<String> f2196b = new Long2ObjectOpenHashMap();

    /* JADX INFO: renamed from: c */
    @NotNull
    private final Long2ObjectMap<a> f2197c = new Long2ObjectOpenHashMap();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final LongSet f2198a = new LongOpenHashSet();

    /* JADX INFO: renamed from: b */
    @NotNull
    private final LongSet f2199b = new LongOpenHashSet();

    /* JADX INFO: renamed from: com.boehmod.blockfront.eX$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eX$a.class */
    public static final class a extends Record {

        /* JADX INFO: renamed from: cx */
        @Nullable
        private final ResourceLocation f2200cx;

        /* JADX INFO: renamed from: jJ */
        private final int f2201jJ;

        /* JADX INFO: renamed from: jK */
        private final int f2202jK;

        public a(@Nullable ResourceLocation resourceLocation, int i, int i2) {
            this.f2200cx = resourceLocation;
            this.f2201jJ = i;
            this.f2202jK = i2;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "location;width;height", "FIELD:Lcom/boehmod/blockfront/eX$a;->cx:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/eX$a;->jJ:I", "FIELD:Lcom/boehmod/blockfront/eX$a;->jK:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "location;width;height", "FIELD:Lcom/boehmod/blockfront/eX$a;->cx:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/eX$a;->jJ:I", "FIELD:Lcom/boehmod/blockfront/eX$a;->jK:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "location;width;height", "FIELD:Lcom/boehmod/blockfront/eX$a;->cx:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/eX$a;->jJ:I", "FIELD:Lcom/boehmod/blockfront/eX$a;->jK:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        @Nullable
        /* JADX INFO: renamed from: j */
        public ResourceLocation m1540j() {
            return this.f2200cx;
        }

        /* JADX INFO: renamed from: x */
        public int m1541x() {
            return this.f2201jJ;
        }

        public int height() {
            return this.f2202jK;
        }
    }

    public C0276eX(@NotNull C0623l c0623l) {
        this.f2192g = c0623l;
    }

    @NotNull
    /* JADX INFO: renamed from: i */
    public List<NewsArticleSummary> m1528i() {
        return this.f2193K;
    }

    /* JADX INFO: renamed from: am */
    public int m1529am() {
        return this.f2194jI;
    }

    /* JADX INFO: renamed from: an */
    public int m1530an() {
        int i = 0;
        Iterator<NewsArticleSummary> it = this.f2193K.iterator();
        while (it.hasNext()) {
            if (!C0495ie.f3073a.m2224b(it.next().m0id())) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    public boolean m1531a(long j) {
        return C0495ie.f3073a.m2224b(j);
    }

    /* JADX INFO: renamed from: b */
    public void m1532b(long j) {
        if (C0495ie.f3073a.m2225c(j)) {
            C0495ie.f3073a.m2226n(200);
            C0498ih.m2238e(this.f2192g);
        }
    }

    /* JADX INFO: renamed from: aB */
    public void m1533aB() {
        ((C0358g) this.f2192g.m2852b()).sendPacket(new PacketNewsListRequest());
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public a m1534a(long j) {
        a aVar = (a) this.f2197c.get(j);
        if (aVar != null) {
            return aVar;
        }
        if (this.f2198a.add(j)) {
            ((C0358g) this.f2192g.m2852b()).sendPacket(new PacketNewsImageRequest(j));
            return null;
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public String m1535a(long j) {
        String str = (String) this.f2196b.get(j);
        if (str != null) {
            return str;
        }
        if (this.f2199b.add(j)) {
            ((C0358g) this.f2192g.m2852b()).sendPacket(new PacketNewsArticleRequest(j));
            return null;
        }
        return null;
    }

    /* JADX INFO: renamed from: N */
    public boolean m1536N() {
        return this.f2195cr;
    }

    /* JADX INFO: renamed from: e */
    public void m1537e(@NotNull List<NewsArticleSummary> list) {
        this.f2193K = List.copyOf(list);
        this.f2194jI++;
        this.f2195cr = true;
    }

    /* JADX INFO: renamed from: a */
    public void m1538a(long j, @NotNull String str) {
        this.f2196b.put(j, str);
    }

    /* JADX INFO: renamed from: a */
    public void m1539a(@NotNull Minecraft minecraft, long j, byte[] bArr) {
        if (bArr.length == 0) {
            this.f2197c.put(j, f2191a);
            return;
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                NativeImage nativeImage = NativeImage.read(byteArrayInputStream);
                this.f2197c.put(j, new a(minecraft.getTextureManager().register("bf_news_" + j, new DynamicTexture(nativeImage)), nativeImage.getWidth(), nativeImage.getHeight()));
                byteArrayInputStream.close();
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            C0530jM.m2338a("Failed to register news image for article '" + j + "'.", e, new Object[0]);
            this.f2197c.put(j, f2191a);
        }
    }
}
