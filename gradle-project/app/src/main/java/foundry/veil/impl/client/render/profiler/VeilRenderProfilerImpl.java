package foundry.veil.impl.client.render.profiler;

import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.profiler.RenderProfilerCounter;
import foundry.veil.api.client.render.profiler.VeilRenderProfiler;
import foundry.veil.impl.client.editor.PipelineStatisticsViewer;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL15C;
import org.lwjgl.opengl.GL33C;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/profiler/VeilRenderProfilerImpl.class */
@ApiStatus.Internal
public final class VeilRenderProfilerImpl {
    private static final Map<String, PathEntry> ENTRIES = new Object2ObjectOpenHashMap();
    private static final List<String> paths = new LinkedList();
    private static final BitSet ENABLED_STATISTICS = new BitSet(RenderProfilerCounter.ALL.length);
    private static final Set<String> ENABLED_PATHS = new HashSet();
    private static String path = "";
    private static int[] queries;

    private VeilRenderProfilerImpl() {
    }

    public static VeilRenderProfiler get() {
        return isEnabled() ? ActiveProfiler.INSTANCE : InactiveProfiler.INSTANCE;
    }

    public static void setEnabled(Collection<String> enabledPaths, RenderProfilerCounter[] statistics) {
        ENABLED_PATHS.clear();
        ENABLED_PATHS.addAll(enabledPaths);
        ENABLED_STATISTICS.clear();
        for (RenderProfilerCounter statistic : statistics) {
            ENABLED_STATISTICS.set(statistic.ordinal());
        }
    }

    public static void endFrame() {
        if (!paths.isEmpty()) {
            Veil.LOGGER.error("Mismatched push() and pop()");
            paths.clear();
        }
        ENTRIES.clear();
        if (queries != null && !isEnabled()) {
            GL15C.glDeleteQueries(queries);
            queries = null;
        }
    }

    private static boolean isEnabled() {
        return VeilRenderSystem.pipelineStatisticsQuerySupported() && VeilRenderSystem.renderer().getEditorManager().isVisible(inspector -> {
            return inspector instanceof PipelineStatisticsViewer;
        });
    }

    public static List<ResultField> getCounters(String sectionPath, RenderProfilerCounter sortedStatistic) {
        List<ResultField> list = new LinkedList<>();
        if (!sectionPath.isEmpty()) {
            sectionPath = sectionPath + "\u001e";
        }
        long[] globalCount = new long[RenderProfilerCounter.ALL.length];
        long[] localCount = new long[RenderProfilerCounter.ALL.length];
        for (Map.Entry<String, PathEntry> entry : ENTRIES.entrySet()) {
            String section = entry.getKey();
            boolean directChild = isDirectChild(sectionPath, section);
            boolean isRoot = section.indexOf(30) == -1;
            if (directChild || isRoot) {
                PathEntry value = entry.getValue();
                long[] counters = value.accumulatedCounters;
                for (RenderProfilerCounter statistic : value.statistics) {
                    int index = statistic.ordinal();
                    long counter = counters[index];
                    if (directChild) {
                        localCount[index] = localCount[index] + counter;
                    }
                    if (isRoot) {
                        globalCount[index] = globalCount[index] + counter;
                    }
                }
            }
        }
        for (Map.Entry<String, PathEntry> entry2 : ENTRIES.entrySet()) {
            String section2 = entry2.getKey();
            if (isDirectChild(sectionPath, section2)) {
                PathEntry value2 = entry2.getValue();
                list.add(new ResultField(section2.substring(sectionPath.length()), value2.accumulatedCounters, localCount, globalCount, value2.statistics, sortedStatistic));
            }
        }
        return list;
    }

    private static boolean isDirectChild(String sectionPath, String entry) {
        return entry.length() > sectionPath.length() && entry.startsWith(sectionPath) && entry.indexOf(30, sectionPath.length() + 1) < 0;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/profiler/VeilRenderProfilerImpl$ResultField.class */
    public static final class ResultField extends Record implements Comparable<ResultField> {
        private final String name;
        private final long[] count;
        private final long[] localCount;
        private final long[] globalCount;
        private final RenderProfilerCounter[] statistics;
        private final RenderProfilerCounter sortedStatistic;

        public ResultField(String name, long[] count, long[] localCount, long[] globalCount, RenderProfilerCounter[] statistics, RenderProfilerCounter sortedStatistic) {
            this.name = name;
            this.count = count;
            this.localCount = localCount;
            this.globalCount = globalCount;
            this.statistics = statistics;
            this.sortedStatistic = sortedStatistic;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ResultField.class), ResultField.class, "name;count;localCount;globalCount;statistics;sortedStatistic", "FIELD:Lfoundry/veil/impl/client/render/profiler/VeilRenderProfilerImpl$ResultField;->name:Ljava/lang/String;", "FIELD:Lfoundry/veil/impl/client/render/profiler/VeilRenderProfilerImpl$ResultField;->count:[J", "FIELD:Lfoundry/veil/impl/client/render/profiler/VeilRenderProfilerImpl$ResultField;->localCount:[J", "FIELD:Lfoundry/veil/impl/client/render/profiler/VeilRenderProfilerImpl$ResultField;->globalCount:[J", "FIELD:Lfoundry/veil/impl/client/render/profiler/VeilRenderProfilerImpl$ResultField;->statistics:[Lfoundry/veil/api/client/render/profiler/RenderProfilerCounter;", "FIELD:Lfoundry/veil/impl/client/render/profiler/VeilRenderProfilerImpl$ResultField;->sortedStatistic:Lfoundry/veil/api/client/render/profiler/RenderProfilerCounter;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ResultField.class), ResultField.class, "name;count;localCount;globalCount;statistics;sortedStatistic", "FIELD:Lfoundry/veil/impl/client/render/profiler/VeilRenderProfilerImpl$ResultField;->name:Ljava/lang/String;", "FIELD:Lfoundry/veil/impl/client/render/profiler/VeilRenderProfilerImpl$ResultField;->count:[J", "FIELD:Lfoundry/veil/impl/client/render/profiler/VeilRenderProfilerImpl$ResultField;->localCount:[J", "FIELD:Lfoundry/veil/impl/client/render/profiler/VeilRenderProfilerImpl$ResultField;->globalCount:[J", "FIELD:Lfoundry/veil/impl/client/render/profiler/VeilRenderProfilerImpl$ResultField;->statistics:[Lfoundry/veil/api/client/render/profiler/RenderProfilerCounter;", "FIELD:Lfoundry/veil/impl/client/render/profiler/VeilRenderProfilerImpl$ResultField;->sortedStatistic:Lfoundry/veil/api/client/render/profiler/RenderProfilerCounter;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ResultField.class, Object.class), ResultField.class, "name;count;localCount;globalCount;statistics;sortedStatistic", "FIELD:Lfoundry/veil/impl/client/render/profiler/VeilRenderProfilerImpl$ResultField;->name:Ljava/lang/String;", "FIELD:Lfoundry/veil/impl/client/render/profiler/VeilRenderProfilerImpl$ResultField;->count:[J", "FIELD:Lfoundry/veil/impl/client/render/profiler/VeilRenderProfilerImpl$ResultField;->localCount:[J", "FIELD:Lfoundry/veil/impl/client/render/profiler/VeilRenderProfilerImpl$ResultField;->globalCount:[J", "FIELD:Lfoundry/veil/impl/client/render/profiler/VeilRenderProfilerImpl$ResultField;->statistics:[Lfoundry/veil/api/client/render/profiler/RenderProfilerCounter;", "FIELD:Lfoundry/veil/impl/client/render/profiler/VeilRenderProfilerImpl$ResultField;->sortedStatistic:Lfoundry/veil/api/client/render/profiler/RenderProfilerCounter;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public String name() {
            return this.name;
        }

        public long[] count() {
            return this.count;
        }

        public long[] localCount() {
            return this.localCount;
        }

        public long[] globalCount() {
            return this.globalCount;
        }

        public RenderProfilerCounter[] statistics() {
            return this.statistics;
        }

        public RenderProfilerCounter sortedStatistic() {
            return this.sortedStatistic;
        }

        public double getPercentage(RenderProfilerCounter statistic) {
            long total = this.localCount[statistic.ordinal()];
            if (total == 0) {
                return 0.0d;
            }
            return (100.0d * this.count[statistic.ordinal()]) / total;
        }

        public double getGlobalPercentage(RenderProfilerCounter statistic) {
            long total = this.globalCount[statistic.ordinal()];
            if (total == 0) {
                return 0.0d;
            }
            return (100.0d * this.count[statistic.ordinal()]) / total;
        }

        @Override // java.lang.Comparable
        public int compareTo(ResultField other) {
            int index = this.sortedStatistic.ordinal();
            if (other.count[index] < this.count[index]) {
                return -1;
            }
            if (other.count[index] > this.count[index]) {
                return 1;
            }
            return other.name.compareTo(this.name);
        }

        public int getColor() {
            return (this.name.hashCode() & 11184810) + 4473924;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/profiler/VeilRenderProfilerImpl$PathEntry.class */
    public static class PathEntry {
        private final RenderProfilerCounter[] statistics;
        private final long[] accumulatedCounters = new long[RenderProfilerCounter.ALL.length];
        private boolean tracking = false;

        public PathEntry(RenderProfilerCounter[] statistics) {
            this.statistics = statistics;
        }

        public void begin() {
            if (VeilRenderProfilerImpl.queries == null) {
                int[] iArr = new int[RenderProfilerCounter.ALL.length];
                VeilRenderProfilerImpl.queries = iArr;
                GL15C.glGenQueries(iArr);
            }
            for (RenderProfilerCounter statistic : this.statistics) {
                if (VeilRenderProfilerImpl.ENABLED_STATISTICS.get(statistic.ordinal())) {
                    GL15C.glBeginQuery(statistic.getId(), VeilRenderProfilerImpl.queries[statistic.ordinal()]);
                }
            }
            this.tracking = true;
        }

        public void stop() {
            for (RenderProfilerCounter statistic : this.statistics) {
                if (VeilRenderProfilerImpl.ENABLED_STATISTICS.get(statistic.ordinal())) {
                    GL15C.glEndQuery(statistic.getId());
                    int index = statistic.ordinal();
                    long count = GL33C.glGetQueryObjecti64(VeilRenderProfilerImpl.queries[index], 34918);
                    long[] jArr = this.accumulatedCounters;
                    jArr[index] = jArr[index] + count;
                }
            }
        }

        public void end(@Nullable PathEntry previous) {
            for (RenderProfilerCounter statistic : this.statistics) {
                if (VeilRenderProfilerImpl.ENABLED_STATISTICS.get(statistic.ordinal())) {
                    GL15C.glEndQuery(statistic.getId());
                    int index = statistic.ordinal();
                    long count = GL33C.glGetQueryObjecti64(VeilRenderProfilerImpl.queries[index], 34918);
                    if (previous != null) {
                        long[] jArr = previous.accumulatedCounters;
                        jArr[index] = jArr[index] + count;
                    }
                    long[] jArr2 = this.accumulatedCounters;
                    jArr2[index] = jArr2[index] + count;
                }
            }
            this.tracking = false;
            if (previous != null) {
                previous.begin();
            }
        }

        public long[] getAccumulatedCounters() {
            return this.accumulatedCounters;
        }

        public RenderProfilerCounter[] getStatistics() {
            return this.statistics;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/profiler/VeilRenderProfilerImpl$ActiveProfiler.class */
    private enum ActiveProfiler implements VeilRenderProfiler {
        INSTANCE;

        @Override // foundry.veil.api.client.render.profiler.VeilRenderProfiler
        public void push(String name, RenderProfilerCounter... statistics) {
            if (statistics.length == 0) {
                statistics = RenderProfilerCounter.ALL;
            }
            PathEntry old = VeilRenderProfilerImpl.ENTRIES.get(VeilRenderProfilerImpl.path);
            if (!VeilRenderProfilerImpl.path.isEmpty()) {
                VeilRenderProfilerImpl.path += "\u001e" + name;
            } else {
                VeilRenderProfilerImpl.path = name;
            }
            VeilRenderProfilerImpl.paths.add(VeilRenderProfilerImpl.path);
            PathEntry entry = VeilRenderProfilerImpl.ENTRIES.get(VeilRenderProfilerImpl.path);
            if (entry == null) {
                entry = new PathEntry(statistics);
                VeilRenderProfilerImpl.ENTRIES.put(VeilRenderProfilerImpl.path, entry);
            }
            if (VeilRenderProfilerImpl.ENABLED_PATHS.contains(VeilRenderProfilerImpl.path)) {
                if (old != null && old.tracking) {
                    old.stop();
                }
                entry.begin();
            }
        }

        @Override // foundry.veil.api.client.render.profiler.VeilRenderProfiler
        public void push(Supplier<String> name, RenderProfilerCounter... statistics) {
            push(name.get(), statistics);
        }

        @Override // foundry.veil.api.client.render.profiler.VeilRenderProfiler
        public void pop() {
            if (VeilRenderProfilerImpl.paths.isEmpty()) {
                Veil.LOGGER.error("Tried to pop one too many times! Mismatched push() and pop()?");
                return;
            }
            PathEntry current = VeilRenderProfilerImpl.ENTRIES.get(VeilRenderProfilerImpl.path);
            VeilRenderProfilerImpl.paths.removeLast();
            VeilRenderProfilerImpl.path = VeilRenderProfilerImpl.paths.isEmpty() ? "" : (String) VeilRenderProfilerImpl.paths.getLast();
            PathEntry previous = VeilRenderProfilerImpl.ENTRIES.get(VeilRenderProfilerImpl.path);
            if (current != null && current.tracking) {
                current.end((previous == null || !previous.tracking) ? null : previous);
            }
        }

        @Override // foundry.veil.api.client.render.profiler.VeilRenderProfiler
        public void popPush(String name, RenderProfilerCounter... statistics) {
            pop();
            push(name, statistics);
        }

        @Override // foundry.veil.api.client.render.profiler.VeilRenderProfiler
        public void popPush(Supplier<String> name, RenderProfilerCounter... statistics) {
            pop();
            push(name.get(), statistics);
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/profiler/VeilRenderProfilerImpl$InactiveProfiler.class */
    private enum InactiveProfiler implements VeilRenderProfiler {
        INSTANCE;

        @Override // foundry.veil.api.client.render.profiler.VeilRenderProfiler
        public void push(String name, RenderProfilerCounter... statistics) {
        }

        @Override // foundry.veil.api.client.render.profiler.VeilRenderProfiler
        public void push(Supplier<String> name, RenderProfilerCounter... statistics) {
        }

        @Override // foundry.veil.api.client.render.profiler.VeilRenderProfiler
        public void pop() {
        }

        @Override // foundry.veil.api.client.render.profiler.VeilRenderProfiler
        public void popPush(String name, RenderProfilerCounter... statistics) {
        }

        @Override // foundry.veil.api.client.render.profiler.VeilRenderProfiler
        public void popPush(Supplier<String> name, RenderProfilerCounter... statistics) {
        }
    }
}
