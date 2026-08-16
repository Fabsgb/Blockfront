package com.boehmod.blockfront;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ih */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ih.class */
public class C0498ih {

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final Gson f3089a = new GsonBuilder().setPrettyPrinting().create();

    /* JADX INFO: renamed from: e */
    public static void m2238e(@NotNull C0623l c0623l) {
        File fileM2240a = m2240a(c0623l);
        JsonObject jsonObject = new JsonObject();
        C0495ie.f3013U.forEach(c0494id -> {
            c0494id.mo2021b(jsonObject);
        });
        try {
            FileWriter fileWriter = new FileWriter(fileM2240a);
            try {
                f3089a.toJson(jsonObject, fileWriter);
                fileWriter.close();
            } catch (Throwable th) {
                try {
                    fileWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            C0530jM.m2338a("Failed to save settings to '" + String.valueOf(fileM2240a) + "'", e, new Object[0]);
        }
        C0495ie.f3075cR = false;
    }

    /* JADX INFO: renamed from: f */
    public static void m2239f(@NotNull C0623l c0623l) {
        JsonObject jsonObjectM2241a = m2241a(m2240a(c0623l));
        C0495ie.f3013U.forEach(c0494id -> {
            c0494id.mo2020a(jsonObjectM2241a);
        });
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static File m2240a(@NotNull C0623l c0623l) {
        String str = c0623l.m2864c() + "client/";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str + "settings.json");
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static JsonObject m2241a(@NotNull File file) {
        if (!file.exists()) {
            return new JsonObject();
        }
        try {
            FileReader fileReader = new FileReader(file);
            try {
                JsonObject jsonObject = (JsonObject) f3089a.fromJson(fileReader, JsonObject.class);
                JsonObject jsonObject2 = jsonObject != null ? jsonObject : new JsonObject();
                fileReader.close();
                return jsonObject2;
            } catch (Throwable th) {
                try {
                    fileReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            C0530jM.m2338a("Failed to load settings from '" + String.valueOf(file) + "'", e, new Object[0]);
            return new JsonObject();
        }
    }
}
