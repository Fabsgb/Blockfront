package com.boehmod.blockfront;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.util.Iterator;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ii */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ii.class */
public class C0499ii extends C0494id {

    /* JADX INFO: renamed from: d */
    @NotNull
    private final ObjectSet<String> f3090d;

    public C0499ii(@NotNull String str, @NotNull String str2, @NotNull C0497ig c0497ig) {
        super(str, str2, c0497ig, false);
        this.f3090d = new ObjectOpenHashSet();
    }

    /* JADX INFO: renamed from: h */
    public boolean m2244h(@NotNull String str) {
        return this.f3090d.contains(str);
    }

    /* JADX INFO: renamed from: i */
    public boolean m2245i(@NotNull String str) {
        if (!this.f3090d.add(str)) {
            return false;
        }
        C0495ie.f3075cR = true;
        return true;
    }

    @Override // com.boehmod.blockfront.C0494id
    /* JADX INFO: renamed from: a */
    public void mo2020a(@NotNull JsonObject jsonObject) {
        this.f3090d.clear();
        if (jsonObject.has(getKey())) {
            JsonElement jsonElement = jsonObject.get(getKey());
            if (jsonElement.isJsonArray()) {
                Iterator it = jsonElement.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    this.f3090d.add(((JsonElement) it.next()).getAsString());
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.C0494id
    /* JADX INFO: renamed from: b */
    public void mo2021b(@NotNull JsonObject jsonObject) {
        JsonArray jsonArray = new JsonArray();
        ObjectSet<String> objectSet = this.f3090d;
        Objects.requireNonNull(jsonArray);
        objectSet.forEach(jsonArray::add);
        jsonObject.add(getKey(), jsonArray);
    }
}
