package com.boehmod.blockfront;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.util.Iterator;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hR.class */
public class C0428hR extends C0423hM {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ObjectSet<String> f2788a;

    public C0428hR(@NotNull String str, @NotNull String str2, @NotNull C0426hP c0426hP) {
        super(str, str2, c0426hP, false);
        this.f2788a = new ObjectOpenHashSet();
    }

    /* JADX INFO: renamed from: f */
    public boolean m2010f(@NotNull String str) {
        return this.f2788a.contains(str);
    }

    /* JADX INFO: renamed from: g */
    public boolean m2011g(@NotNull String str) {
        if (!this.f2788a.add(str)) {
            return false;
        }
        C0424hN.f2773cI = true;
        return true;
    }

    @Override // com.boehmod.blockfront.C0423hM
    /* JADX INFO: renamed from: a */
    public void mo1989a(@NotNull JsonObject jsonObject) {
        this.f2788a.clear();
        if (jsonObject.has(getKey())) {
            JsonElement jsonElement = jsonObject.get(getKey());
            if (jsonElement.isJsonArray()) {
                Iterator it = jsonElement.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    this.f2788a.add(((JsonElement) it.next()).getAsString());
                }
            }
        }
    }

    @Override // com.boehmod.blockfront.C0423hM
    /* JADX INFO: renamed from: b */
    public void mo1990b(@NotNull JsonObject jsonObject) {
        JsonArray jsonArray = new JsonArray();
        ObjectSet<String> objectSet = this.f2788a;
        Objects.requireNonNull(jsonArray);
        objectSet.forEach(jsonArray::add);
        jsonObject.add(getKey(), jsonArray);
    }
}
