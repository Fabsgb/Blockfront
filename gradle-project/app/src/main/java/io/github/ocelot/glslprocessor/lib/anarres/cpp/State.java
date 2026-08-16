package io.github.ocelot.glslprocessor.lib.anarres.cpp;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/lib/anarres/cpp/State.class */
@ApiStatus.Internal
class State {
    boolean parent;
    boolean active;
    boolean sawElse;

    State() {
        this.parent = true;
        this.active = true;
        this.sawElse = false;
    }

    State(State parent) {
        this.parent = parent.isParentActive() && parent.isActive();
        this.active = true;
        this.sawElse = false;
    }

    void setParentActive(boolean b) {
        this.parent = b;
    }

    boolean isParentActive() {
        return this.parent;
    }

    void setActive(boolean b) {
        this.active = b;
    }

    boolean isActive() {
        return this.active;
    }

    void setSawElse() {
        this.sawElse = true;
    }

    boolean sawElse() {
        return this.sawElse;
    }

    public String toString() {
        return "parent=" + this.parent + ", active=" + this.active + ", sawelse=" + this.sawElse;
    }
}
