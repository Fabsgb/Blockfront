package com.boehmod.blockfront;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.util.Iterator;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hR.class */
public class hR extends hM {

    @NotNull
    private final ObjectSet<String> a;

    public hR(@NotNull String str, @NotNull String str2, @NotNull hP hPVar) {
        super(str, str2, hPVar, false);
        this.a = new ObjectOpenHashSet();
    }

    public boolean f(@NotNull String str) {
        return this.a.contains(str);
    }

    public boolean g(@NotNull String str) {
        if (!this.a.add(str)) {
            return false;
        }
        hN.cI = true;
        return true;
    }

    @Override // com.boehmod.blockfront.hM
    public void a(@NotNull JsonObject jsonObject) {
        this.a.clear();
        if (jsonObject.has(getKey())) {
            JsonElement jsonElement = jsonObject.get(getKey());
            if (jsonElement.isJsonArray()) {
                Iterator it = jsonElement.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    this.a.add(((JsonElement) it.next()).getAsString());
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.hM
    public void b(@NotNull JsonObject jsonObject) {
        JsonArray jsonArray = new JsonArray();
        ObjectSet<String> objectSet = this.a;
        Objects.requireNonNull(jsonArray);
        objectSet.forEach(jsonArray::add);
        jsonObject.add(getKey(), jsonArray);
    }
}
