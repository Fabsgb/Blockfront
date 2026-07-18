package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p000mm.SearchRegion;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.xs */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xs.class */
public final class C1296xs extends Record {

    /* JADX INFO: renamed from: eG */
    @SerializedName("cloudIp")
    @NotNull
    private final String f8674eG;

    /* JADX INFO: renamed from: jE */
    @SerializedName("matchmaking")
    private final boolean f8675jE;

    /* JADX INFO: renamed from: eH */
    @SerializedName("matchmakingPassword")
    @NotNull
    private final String f8676eH;

    /* JADX INFO: renamed from: eI */
    @SerializedName("matchmakingRegion")
    @NotNull
    private final String f8677eI;

    /* JADX INFO: renamed from: jF */
    @SerializedName("restartAfterMatch")
    private final boolean f8678jF;

    /* JADX INFO: renamed from: jG */
    @SerializedName("autoUpdate")
    private final boolean f8679jG;

    /* JADX INFO: renamed from: d */
    @NotNull
    private static final Gson f8680d = new GsonBuilder().setPrettyPrinting().create();

    public C1296xs(@NotNull String str, boolean z, @NotNull String str2, @NotNull String str3, boolean z2, boolean z3) {
        this.f8674eG = str;
        this.f8675jE = z;
        this.f8676eH = str2;
        this.f8677eI = str3;
        this.f8678jF = z2;
        this.f8679jG = z3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1296xs.class), C1296xs.class, "cloudIp;matchmaking;matchmakingPassword;matchmakingRegion;restartAfterMatch;autoUpdate", "FIELD:Lcom/boehmod/blockfront/xs;->eG:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xs;->jE:Z", "FIELD:Lcom/boehmod/blockfront/xs;->eH:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xs;->eI:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xs;->jF:Z", "FIELD:Lcom/boehmod/blockfront/xs;->jG:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1296xs.class), C1296xs.class, "cloudIp;matchmaking;matchmakingPassword;matchmakingRegion;restartAfterMatch;autoUpdate", "FIELD:Lcom/boehmod/blockfront/xs;->eG:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xs;->jE:Z", "FIELD:Lcom/boehmod/blockfront/xs;->eH:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xs;->eI:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xs;->jF:Z", "FIELD:Lcom/boehmod/blockfront/xs;->jG:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1296xs.class, Object.class), C1296xs.class, "cloudIp;matchmaking;matchmakingPassword;matchmakingRegion;restartAfterMatch;autoUpdate", "FIELD:Lcom/boehmod/blockfront/xs;->eG:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xs;->jE:Z", "FIELD:Lcom/boehmod/blockfront/xs;->eH:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xs;->eI:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xs;->jF:Z", "FIELD:Lcom/boehmod/blockfront/xs;->jG:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @SerializedName("cloudIp")
    @NotNull
    /* JADX INFO: renamed from: aF */
    public String m7926aF() {
        return this.f8674eG;
    }

    @SerializedName("matchmaking")
    /* JADX INFO: renamed from: dr */
    public boolean m7927dr() {
        return this.f8675jE;
    }

    @SerializedName("matchmakingPassword")
    @NotNull
    /* JADX INFO: renamed from: aG */
    public String m7928aG() {
        return this.f8676eH;
    }

    @SerializedName("matchmakingRegion")
    @NotNull
    /* JADX INFO: renamed from: aH */
    public String m7929aH() {
        return this.f8677eI;
    }

    @SerializedName("restartAfterMatch")
    /* JADX INFO: renamed from: ds */
    public boolean m7930ds() {
        return this.f8678jF;
    }

    @SerializedName("autoUpdate")
    /* JADX INFO: renamed from: dt */
    public boolean m7931dt() {
        return this.f8679jG;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C1296xs m7922a() {
        return new C1296xs("default", false, "password", "all", true, false);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C1296xs m7923a(@NotNull File file) {
        if (!file.exists()) {
            C1296xs c1296xsM7922a = m7922a();
            c1296xsM7922a.m7924a(file);
            return c1296xsM7922a;
        }
        try {
            FileReader fileReader = new FileReader(file);
            try {
                C1296xs c1296xs = (C1296xs) f8680d.fromJson(fileReader, C1296xs.class);
                if (c1296xs != null) {
                    C1296xs c1296xs2 = new C1296xs(c1296xs.f8674eG, c1296xs.f8675jE, c1296xs.f8676eH, c1296xs.f8677eI, c1296xs.f8678jF, c1296xs.f8679jG);
                    fileReader.close();
                    return c1296xs2;
                }
                C1296xs c1296xsM7922a2 = m7922a();
                fileReader.close();
                return c1296xsM7922a2;
            } finally {
            }
        } catch (Exception e) {
            C0562jt.m2516a("Failed to read server config from '" + String.valueOf(file) + "'", e, new Object[0]);
            return m7922a();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m7924a(@NotNull File file) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            try {
                f8680d.toJson(this, fileWriter);
                fileWriter.close();
            } finally {
            }
        } catch (IOException e) {
            C0562jt.m2516a("Failed to write server config to '" + String.valueOf(file) + "'", e, new Object[0]);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public SearchRegion m7925b() {
        return SearchRegion.fromId(this.f8677eI);
    }
}
