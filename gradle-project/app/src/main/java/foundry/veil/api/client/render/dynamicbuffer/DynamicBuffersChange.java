package foundry.veil.api.client.render.dynamicbuffer;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/dynamicbuffer/DynamicBuffersChange.class */
public final class DynamicBuffersChange extends Record {
    private final int previouslyEnabledBuffersMask;
    private final int enabledBuffersMask;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, DynamicBuffersChange.class), DynamicBuffersChange.class, "previouslyEnabledBuffersMask;enabledBuffersMask", "FIELD:Lfoundry/veil/api/client/render/dynamicbuffer/DynamicBuffersChange;->previouslyEnabledBuffersMask:I", "FIELD:Lfoundry/veil/api/client/render/dynamicbuffer/DynamicBuffersChange;->enabledBuffersMask:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, DynamicBuffersChange.class), DynamicBuffersChange.class, "previouslyEnabledBuffersMask;enabledBuffersMask", "FIELD:Lfoundry/veil/api/client/render/dynamicbuffer/DynamicBuffersChange;->previouslyEnabledBuffersMask:I", "FIELD:Lfoundry/veil/api/client/render/dynamicbuffer/DynamicBuffersChange;->enabledBuffersMask:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, DynamicBuffersChange.class, Object.class), DynamicBuffersChange.class, "previouslyEnabledBuffersMask;enabledBuffersMask", "FIELD:Lfoundry/veil/api/client/render/dynamicbuffer/DynamicBuffersChange;->previouslyEnabledBuffersMask:I", "FIELD:Lfoundry/veil/api/client/render/dynamicbuffer/DynamicBuffersChange;->enabledBuffersMask:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public int previouslyEnabledBuffersMask() {
        return this.previouslyEnabledBuffersMask;
    }

    public int enabledBuffersMask() {
        return this.enabledBuffersMask;
    }

    @ApiStatus.Internal
    public DynamicBuffersChange(int previouslyEnabledBuffersMask, int enabledBuffersMask) {
        this.previouslyEnabledBuffersMask = previouslyEnabledBuffersMask;
        this.enabledBuffersMask = enabledBuffersMask;
    }

    public DynamicBufferType[] getPreviouslyEnabledBuffers() {
        return DynamicBufferType.decode(this.previouslyEnabledBuffersMask);
    }

    public DynamicBufferType[] getEnabledBuffers() {
        return DynamicBufferType.decode(this.enabledBuffersMask);
    }

    public boolean hasChanged(DynamicBufferType buffer) {
        int mask = buffer.getMask();
        return ((this.enabledBuffersMask & mask) ^ (this.previouslyEnabledBuffersMask & mask)) != 0;
    }

    public boolean isEnabled(DynamicBufferType buffer) {
        return (this.enabledBuffersMask & buffer.getMask()) != 0;
    }

    public boolean wasPreviouslyEnabled(DynamicBufferType buffer) {
        return (this.previouslyEnabledBuffersMask & buffer.getMask()) != 0;
    }
}
