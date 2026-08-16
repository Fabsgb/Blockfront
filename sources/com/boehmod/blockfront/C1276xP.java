package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p001mm.SearchRegion;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.xP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xP.class */
public final class C1276xP extends Record {

    /* JADX INFO: renamed from: eR */
    @SerializedName("cloudIp")
    @NotNull
    private final String f6871eR;

    /* JADX INFO: renamed from: jU */
    @SerializedName("matchmaking")
    private final boolean f6872jU;

    /* JADX INFO: renamed from: eS */
    @SerializedName("matchmakingPassword")
    @NotNull
    private final String f6873eS;

    /* JADX INFO: renamed from: eT */
    @SerializedName("matchmakingRegion")
    @NotNull
    private final String f6874eT;

    /* JADX INFO: renamed from: jV */
    @SerializedName("restartAfterMatch")
    private final boolean f6875jV;

    /* JADX INFO: renamed from: jW */
    @SerializedName("autoUpdate")
    private final boolean f6876jW;

    /* JADX INFO: renamed from: d */
    @NotNull
    private static final Gson f6877d = new GsonBuilder().setPrettyPrinting().create();

    /* JADX INFO: renamed from: eU */
    @NotNull
    public static final String f6878eU = "password";

    public C1276xP(@NotNull String str, boolean z, @NotNull String str2, @NotNull String str3, boolean z2, boolean z3) {
        this.f6871eR = str;
        this.f6872jU = z;
        this.f6873eS = str2;
        this.f6874eT = str3;
        this.f6875jV = z2;
        this.f6876jW = z3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C1276xP.class), C1276xP.class, "cloudIp;matchmaking;matchmakingPassword;matchmakingRegion;restartAfterMatch;autoUpdate", "FIELD:Lcom/boehmod/blockfront/xP;->eR:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xP;->jU:Z", "FIELD:Lcom/boehmod/blockfront/xP;->eS:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xP;->eT:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xP;->jV:Z", "FIELD:Lcom/boehmod/blockfront/xP;->jW:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C1276xP.class), C1276xP.class, "cloudIp;matchmaking;matchmakingPassword;matchmakingRegion;restartAfterMatch;autoUpdate", "FIELD:Lcom/boehmod/blockfront/xP;->eR:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xP;->jU:Z", "FIELD:Lcom/boehmod/blockfront/xP;->eS:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xP;->eT:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xP;->jV:Z", "FIELD:Lcom/boehmod/blockfront/xP;->jW:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C1276xP.class, Object.class), C1276xP.class, "cloudIp;matchmaking;matchmakingPassword;matchmakingRegion;restartAfterMatch;autoUpdate", "FIELD:Lcom/boehmod/blockfront/xP;->eR:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xP;->jU:Z", "FIELD:Lcom/boehmod/blockfront/xP;->eS:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xP;->eT:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/xP;->jV:Z", "FIELD:Lcom/boehmod/blockfront/xP;->jW:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @SerializedName("cloudIp")
    @NotNull
    /* JADX INFO: renamed from: aM */
    public String m7253aM() {
        return this.f6871eR;
    }

    @SerializedName("matchmaking")
    /* JADX INFO: renamed from: dA */
    public boolean m7254dA() {
        return this.f6872jU;
    }

    @SerializedName("matchmakingPassword")
    @NotNull
    /* JADX INFO: renamed from: aN */
    public String m7255aN() {
        return this.f6873eS;
    }

    @SerializedName("matchmakingRegion")
    @NotNull
    /* JADX INFO: renamed from: aO */
    public String m7256aO() {
        return this.f6874eT;
    }

    @SerializedName("restartAfterMatch")
    /* JADX INFO: renamed from: dB */
    public boolean m7257dB() {
        return this.f6875jV;
    }

    @SerializedName("autoUpdate")
    /* JADX INFO: renamed from: dC */
    public boolean m7258dC() {
        return this.f6876jW;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C1276xP m7249a() {
        return new C1276xP("default", false, f6878eU, "all", true, false);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static C1276xP m7250a(@NotNull File file) {
        if (!file.exists()) {
            C1276xP c1276xPM7249a = m7249a();
            c1276xPM7249a.m7251a(file);
            return c1276xPM7249a;
        }
        try {
            FileReader fileReader = new FileReader(file);
            try {
                C1276xP c1276xP = (C1276xP) f6877d.fromJson(fileReader, C1276xP.class);
                if (c1276xP != null) {
                    boolean z = c1276xP.f6872jU && !f6878eU.equals(c1276xP.f6873eS);
                    if (c1276xP.f6872jU && !z) {
                        C0530jM.log("[Matchmaking] Disabled: 'matchmakingPassword' in '%s' is still the default. Set a real password to enable matchmaking.", file);
                    }
                    C1276xP c1276xP2 = new C1276xP(c1276xP.f6871eR, z, c1276xP.f6873eS, c1276xP.f6874eT, c1276xP.f6875jV, c1276xP.f6876jW);
                    fileReader.close();
                    return c1276xP2;
                }
                C1276xP c1276xPM7249a2 = m7249a();
                fileReader.close();
                return c1276xPM7249a2;
            } catch (Throwable th) {
                try {
                    fileReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            C0530jM.m2338a("Failed to read server config from '" + String.valueOf(file) + "'", e, new Object[0]);
            return m7249a();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m7251a(@NotNull File file) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            try {
                f6877d.toJson(this, fileWriter);
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
            C0530jM.m2338a("Failed to write server config to '" + String.valueOf(file) + "'", e, new Object[0]);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public SearchRegion m7252b() {
        return SearchRegion.fromId(this.f6874eT);
    }
}
