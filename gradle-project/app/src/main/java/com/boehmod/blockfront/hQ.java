package com.boehmod.blockfront;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hQ.class */
public class hQ {

    @NotNull
    private static final Gson a = new GsonBuilder().setPrettyPrinting().create();

    public static void d(@NotNull C0297l c0297l) {
        File fileA = a(c0297l);
        JsonObject jsonObject = new JsonObject();
        hN.R.forEach(hMVar -> {
            hMVar.b(jsonObject);
        });
        try {
            FileWriter fileWriter = new FileWriter(fileA);
            try {
                a.toJson(jsonObject, fileWriter);
                fileWriter.close();
            } finally {
            }
        } catch (IOException e) {
            C0263jt.a("Failed to save settings to '" + String.valueOf(fileA) + "'", e, new Object[0]);
        }
        hN.cI = false;
    }

    public static void e(@NotNull C0297l c0297l) {
        JsonObject jsonObjectA = a(a(c0297l));
        hN.R.forEach(hMVar -> {
            hMVar.a(jsonObjectA);
        });
    }

    @NotNull
    private static File a(@NotNull C0297l c0297l) {
        String str = c0297l.c() + "client/";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str + "settings.json");
    }

    @NotNull
    private static JsonObject a(@NotNull File file) {
        if (!file.exists()) {
            return new JsonObject();
        }
        try {
            FileReader fileReader = new FileReader(file);
            try {
                JsonObject jsonObject = (JsonObject) a.fromJson(fileReader, JsonObject.class);
                JsonObject jsonObject2 = jsonObject != null ? jsonObject : new JsonObject();
                fileReader.close();
                return jsonObject2;
            } finally {
            }
        } catch (Exception e) {
            C0263jt.a("Failed to load settings from '" + String.valueOf(file) + "'", e, new Object[0]);
            return new JsonObject();
        }
    }
}
