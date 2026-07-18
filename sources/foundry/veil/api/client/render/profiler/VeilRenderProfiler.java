package foundry.veil.api.client.render.profiler;

import foundry.veil.impl.client.render.profiler.VeilRenderProfilerImpl;
import java.util.function.Supplier;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/profiler/VeilRenderProfiler.class */
public interface VeilRenderProfiler {
    void push(String str, RenderProfilerCounter... renderProfilerCounterArr);

    void push(Supplier<String> supplier, RenderProfilerCounter... renderProfilerCounterArr);

    void pop();

    void popPush(String str, RenderProfilerCounter... renderProfilerCounterArr);

    void popPush(Supplier<String> supplier, RenderProfilerCounter... renderProfilerCounterArr);

    static VeilRenderProfiler get() {
        return VeilRenderProfilerImpl.get();
    }
}
