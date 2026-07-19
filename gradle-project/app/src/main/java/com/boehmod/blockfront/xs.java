package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.mm.SearchRegion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xs.class */
public final class xs extends Record {

    @SerializedName("cloudIp")
    @NotNull
    private final String eG;

    @SerializedName("matchmaking")
    private final boolean jE;

    @SerializedName("matchmakingPassword")
    @NotNull
    private final String eH;

    @SerializedName("matchmakingRegion")
    @NotNull
    private final String eI;

    @SerializedName("restartAfterMatch")
    private final boolean jF;

    @SerializedName("autoUpdate")
    private final boolean jG;

    @NotNull
    private static final Gson d = new GsonBuilder().setPrettyPrinting().create();

    public xs(@NotNull String str, boolean z, @NotNull String str2, @NotNull String str3, boolean z2, boolean z3) {
        this.eG = str;
        this.jE = z;
        this.eH = str2;
        this.eI = str3;
        this.jF = z2;
        this.jG = z3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, xs.class), xs.class, "cloudIp;matchmaking;matchmakingPassword;matchmakingRegion;restartAfterMatch;autoUpdate", "FIELD:Lcom/boehmod/blockfront/xs;->eG:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xs;->jE:Z", "FIELD:Lcom/boehmod/blockfront/xs;->eH:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xs;->eI:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xs;->jF:Z", "FIELD:Lcom/boehmod/blockfront/xs;->jG:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, xs.class), xs.class, "cloudIp;matchmaking;matchmakingPassword;matchmakingRegion;restartAfterMatch;autoUpdate", "FIELD:Lcom/boehmod/blockfront/xs;->eG:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xs;->jE:Z", "FIELD:Lcom/boehmod/blockfront/xs;->eH:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xs;->eI:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xs;->jF:Z", "FIELD:Lcom/boehmod/blockfront/xs;->jG:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, xs.class, Object.class), xs.class, "cloudIp;matchmaking;matchmakingPassword;matchmakingRegion;restartAfterMatch;autoUpdate", "FIELD:Lcom/boehmod/blockfront/xs;->eG:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xs;->jE:Z", "FIELD:Lcom/boehmod/blockfront/xs;->eH:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xs;->eI:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xs;->jF:Z", "FIELD:Lcom/boehmod/blockfront/xs;->jG:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @SerializedName("cloudIp")
    @NotNull
    public String aF() {
        return this.eG;
    }

    @SerializedName("matchmaking")
    public boolean dr() {
        return this.jE;
    }

    @SerializedName("matchmakingPassword")
    @NotNull
    public String aG() {
        return this.eH;
    }

    @SerializedName("matchmakingRegion")
    @NotNull
    public String aH() {
        return this.eI;
    }

    @SerializedName("restartAfterMatch")
    public boolean ds() {
        return this.jF;
    }

    @SerializedName("autoUpdate")
    public boolean dt() {
        return this.jG;
    }

    @NotNull
    public static xs a() {
        return new xs("default", false, "password", "all", true, false);
    }

    @NotNull
    public static xs a(@NotNull File file) {
        if (!file.exists()) {
            xs xsVarA = a();
            xsVarA.m1706a(file);
            return xsVarA;
        }
        try {
            FileReader fileReader = new FileReader(file);
            try {
                xs xsVar = (xs) d.fromJson(fileReader, xs.class);
                if (xsVar != null) {
                    xs xsVar2 = new xs(xsVar.eG, xsVar.jE, xsVar.eH, xsVar.eI, xsVar.jF, xsVar.jG);
                    fileReader.close();
                    return xsVar2;
                }
                xs xsVarA2 = a();
                fileReader.close();
                return xsVarA2;
            } finally {
            }
        } catch (Exception e) {
            C0263jt.a("Failed to read server config from '" + String.valueOf(file) + "'", e, new Object[0]);
            return a();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m1706a(@NotNull File file) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            try {
                d.toJson(this, fileWriter);
                fileWriter.close();
            } finally {
            }
        } catch (IOException e) {
            C0263jt.a("Failed to write server config to '" + String.valueOf(file) + "'", e, new Object[0]);
        }
    }

    @NotNull
    public SearchRegion b() {
        return SearchRegion.fromId(this.eI);
    }
}
