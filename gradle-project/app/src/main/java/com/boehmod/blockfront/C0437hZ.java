package com.boehmod.blockfront;

import android.database.CursorJoiner;
import com.boehmod.blockfront.InterfaceC0492ib;
import com.google.gson.JsonObject;
import java.lang.Enum;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.hZ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hZ.class */
public class C0437hZ<E extends Enum<E> & InterfaceC0492ib> extends C0494id {

    /* JADX INFO: Incorrect field signature: [TE; */
    /* JADX INFO: renamed from: a */
    @NotNull
    private final Enum[] f2789a;

    /* JADX INFO: Incorrect field signature: TE; */
    /* JADX INFO: renamed from: a */
    @NotNull
    private final Enum f2790a;

    /* JADX INFO: Incorrect field signature: TE; */
    /* JADX INFO: renamed from: b */
    @NotNull
    private Enum f2791b;

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;Ljava/lang/String;Lcom/boehmod/blockfront/ig;TE;)V */
    public C0437hZ(@NotNull String str, @NotNull String str2, @NotNull C0497ig c0497ig, @NotNull Enum r10) {
        super(str, str2, c0497ig, false);
        this.f2789a = (Enum[]) r10.getDeclaringClass().getEnumConstants();
        this.f2790a = r10;
        this.f2791b = r10;
    }

    /* JADX WARN: Incorrect return type in method signature: ()TE; */
    @NotNull
    /* JADX INFO: renamed from: a */
    public Enum m2018a() {
        return this.f2791b;
    }

    /* JADX WARN: Incorrect types in method signature: (TE;)V */
    /* JADX INFO: renamed from: a */
    public void m2019a(@NotNull Enum r4) {
        if (this.f2791b == r4) {
            return;
        }
        this.f2791b = r4;
        C0495ie.f3075cR = true;
        this.f3009dh = 1.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.boehmod.blockfront.C0494id
    /* JADX INFO: renamed from: a */
    public void mo2020a(@NotNull JsonObject jsonObject) {
        if (!jsonObject.has(getKey())) {
            this.f2791b = this.f2790a;
            return;
        }
        String asString = jsonObject.get(getKey()).getAsString();
        for (CursorJoiner.Result result : this.f2789a) {
            if (((InterfaceC0492ib) result).getSettingsKey().equals(asString)) {
                this.f2791b = result;
                return;
            }
        }
        this.f2791b = this.f2790a;
    }

    @Override // com.boehmod.blockfront.C0494id
    /* JADX INFO: renamed from: b */
    public void mo2021b(@NotNull JsonObject jsonObject) {
        jsonObject.addProperty(getKey(), ((InterfaceC0492ib) this.f2791b).getSettingsKey());
    }
}
