package com.boehmod.blockfront;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ic */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ic.class */
public class C0493ic extends C0494id {

    /* JADX INFO: renamed from: c */
    @NotNull
    private final LongSet f3002c;

    public C0493ic(@NotNull String str, @NotNull String str2, @NotNull C0497ig c0497ig) {
        super(str, str2, c0497ig, false);
        this.f3002c = new LongOpenHashSet();
    }

    /* JADX INFO: renamed from: b */
    public boolean m2224b(long j) {
        return this.f3002c.contains(j);
    }

    /* JADX INFO: renamed from: c */
    public boolean m2225c(long j) {
        if (!this.f3002c.add(j)) {
            return false;
        }
        C0495ie.f3075cR = true;
        return true;
    }

    /* JADX INFO: renamed from: n */
    public void m2226n(int i) {
        if (this.f3002c.size() <= i) {
            return;
        }
        long[] longArray = this.f3002c.toLongArray();
        Arrays.sort(longArray);
        this.f3002c.clear();
        for (int length = longArray.length - i; length < longArray.length; length++) {
            this.f3002c.add(longArray[length]);
        }
        C0495ie.f3075cR = true;
    }

    @Override // com.boehmod.blockfront.C0494id
    /* JADX INFO: renamed from: a */
    public void mo2020a(@NotNull JsonObject jsonObject) {
        this.f3002c.clear();
        if (jsonObject.has(getKey())) {
            JsonElement jsonElement = jsonObject.get(getKey());
            if (jsonElement.isJsonArray()) {
                Iterator it = jsonElement.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    this.f3002c.add(((JsonElement) it.next()).getAsLong());
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.C0494id
    /* JADX INFO: renamed from: b */
    public void mo2021b(@NotNull JsonObject jsonObject) {
        JsonArray jsonArray = new JsonArray();
        LongSet longSet = this.f3002c;
        Objects.requireNonNull(jsonArray);
        longSet.forEach((v1) -> {
            r1.add(v1);
        });
        jsonObject.add(getKey(), jsonArray);
    }
}
