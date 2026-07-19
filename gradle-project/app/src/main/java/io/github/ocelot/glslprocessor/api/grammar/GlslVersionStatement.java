package io.github.ocelot.glslprocessor.api.grammar;

import com.boehmod.blockfront.C0093dj;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/grammar/GlslVersionStatement.class */
public final class GlslVersionStatement {
    private int version;
    private boolean core;

    public GlslVersionStatement() {
        this(C0093dj.gd, true);
    }

    public GlslVersionStatement(int version, boolean core) {
        this.version = version;
        this.core = core;
    }

    public int getVersion() {
        return this.version;
    }

    public boolean isCore() {
        return this.core;
    }

    public String getVersionStatement() {
        return this.version + (this.core ? " core" : "");
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setCore(boolean core) {
        this.core = core;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslVersionStatement that = (GlslVersionStatement) o;
        return this.version == that.version && this.core == that.core;
    }

    public int hashCode() {
        return (31 * this.version) + Boolean.hashCode(this.core);
    }

    public String toString() {
        return "GlslVersion{" + getVersionStatement() + "}";
    }
}
