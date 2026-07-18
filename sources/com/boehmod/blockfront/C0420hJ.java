package com.boehmod.blockfront;

import android.database.CursorJoiner;
import com.boehmod.blockfront.InterfaceC0422hL;
import com.google.gson.JsonObject;
import java.lang.Enum;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hJ.class */
public class C0420hJ<E extends Enum<E> & InterfaceC0422hL> extends C0423hM {

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Enum[] f2695a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Enum f2696a;

    /* JADX INFO: renamed from: b */
    @NotNull
    private Enum f2697b;

    public C0420hJ(@NotNull String str, @NotNull String str2, @NotNull C0426hP c0426hP, @NotNull Enum r10) {
        super(str, str2, c0426hP, false);
        this.f2695a = (Enum[]) r10.getDeclaringClass().getEnumConstants();
        this.f2696a = r10;
        this.f2697b = r10;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Enum m1987a() {
        return this.f2697b;
    }

    /* JADX INFO: renamed from: a */
    public void m1988a(@NotNull Enum r4) {
        if (this.f2697b == r4) {
            return;
        }
        this.f2697b = r4;
        C0424hN.f2773cI = true;
        this.f2708db = 1.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.boehmod.blockfront.C0423hM
    /* JADX INFO: renamed from: a */
    public void mo1989a(@NotNull JsonObject jsonObject) {
        if (!jsonObject.has(getKey())) {
            this.f2697b = this.f2696a;
            return;
        }
        String asString = jsonObject.get(getKey()).getAsString();
        for (CursorJoiner.Result result : this.f2695a) {
            if (((InterfaceC0422hL) result).getSettingsKey().equals(asString)) {
                this.f2697b = result;
                return;
            }
        }
        this.f2697b = this.f2696a;
    }

    @Override // com.boehmod.blockfront.C0423hM
    /* JADX INFO: renamed from: b */
    public void mo1990b(@NotNull JsonObject jsonObject) {
        jsonObject.addProperty(getKey(), ((InterfaceC0422hL) this.f2697b).getSettingsKey());
    }
}
