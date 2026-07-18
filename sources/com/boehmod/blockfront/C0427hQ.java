package com.boehmod.blockfront;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hQ.class */
public class C0427hQ {

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final Gson f2787a = new GsonBuilder().setPrettyPrinting().create();

    /* JADX INFO: renamed from: d */
    public static void m2004d(@NotNull C0622l c0622l) {
        File fileM2006a = m2006a(c0622l);
        JsonObject jsonObject = new JsonObject();
        C0424hN.f2712R.forEach(c0423hM -> {
            c0423hM.mo1990b(jsonObject);
        });
        try {
            FileWriter fileWriter = new FileWriter(fileM2006a);
            try {
                f2787a.toJson(jsonObject, fileWriter);
                fileWriter.close();
            } finally {
            }
        } catch (IOException e) {
            C0562jt.m2516a("Failed to save settings to '" + String.valueOf(fileM2006a) + "'", e, new Object[0]);
        }
        C0424hN.f2773cI = false;
    }

    /* JADX INFO: renamed from: e */
    public static void m2005e(@NotNull C0622l c0622l) {
        JsonObject jsonObjectM2007a = m2007a(m2006a(c0622l));
        C0424hN.f2712R.forEach(c0423hM -> {
            c0423hM.mo1989a(jsonObjectM2007a);
        });
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static File m2006a(@NotNull C0622l c0622l) {
        String str = c0622l.m2678c() + "client/";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str + "settings.json");
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static JsonObject m2007a(@NotNull File file) {
        if (!file.exists()) {
            return new JsonObject();
        }
        try {
            FileReader fileReader = new FileReader(file);
            try {
                JsonObject jsonObject = (JsonObject) f2787a.fromJson(fileReader, JsonObject.class);
                JsonObject jsonObject2 = jsonObject != null ? jsonObject : new JsonObject();
                fileReader.close();
                return jsonObject2;
            } finally {
            }
        } catch (Exception e) {
            C0562jt.m2516a("Failed to load settings from '" + String.valueOf(file) + "'", e, new Object[0]);
            return new JsonObject();
        }
    }
}
