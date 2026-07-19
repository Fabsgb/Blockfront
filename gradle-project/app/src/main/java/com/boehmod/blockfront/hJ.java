package com.boehmod.blockfront;

import android.database.CursorJoiner;
import com.boehmod.blockfront.hL;
import com.google.gson.JsonObject;
import java.lang.Enum;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hJ.class */
public class hJ<E extends Enum<E> & hL> extends hM {

    /* JADX INFO: Incorrect field signature: [TE; */
    @NotNull
    private final Enum[] a;

    /* JADX INFO: Incorrect field signature: TE; */
    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final Enum f148a;

    /* JADX INFO: Incorrect field signature: TE; */
    @NotNull
    private Enum b;

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;Ljava/lang/String;Lcom/boehmod/blockfront/hP;TE;)V */
    public hJ(@NotNull String str, @NotNull String str2, @NotNull hP hPVar, @NotNull Enum r10) {
        super(str, str2, hPVar, false);
        this.a = (Enum[]) r10.getDeclaringClass().getEnumConstants();
        this.f148a = r10;
        this.b = r10;
    }

    /* JADX WARN: Incorrect return type in method signature: ()TE; */
    @NotNull
    public Enum a() {
        return this.b;
    }

    /* JADX WARN: Incorrect types in method signature: (TE;)V */
    public void a(@NotNull Enum r4) {
        if (this.b == r4) {
            return;
        }
        this.b = r4;
        hN.cI = true;
        this.db = 1.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.boehmod.blockfront.hM
    public void a(@NotNull JsonObject jsonObject) {
        if (!jsonObject.has(getKey())) {
            this.b = this.f148a;
            return;
        }
        String asString = jsonObject.get(getKey()).getAsString();
        for (CursorJoiner.Result result : this.a) {
            if (((hL) result).getSettingsKey().equals(asString)) {
                this.b = result;
                return;
            }
        }
        this.b = this.f148a;
    }

    @Override // com.boehmod.blockfront.hM
    public void b(@NotNull JsonObject jsonObject) {
        jsonObject.addProperty(getKey(), ((hL) this.b).getSettingsKey());
    }
}
