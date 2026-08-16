package foundry.veil.impl.client.render.perspective;

import it.unimi.dsi.fastutil.ints.IntArraySet;
import it.unimi.dsi.fastutil.ints.IntSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.function.Consumer;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.ViewArea;
import net.minecraft.client.renderer.chunk.SectionRenderDispatcher;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ChunkTrackingView;
import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/perspective/VeilSectionOcclusionGraph.class */
public class VeilSectionOcclusionGraph {
    private static final int MINIMUM_ADVANCED_CULLING_DISTANCE = 60;
    private final NodeQueue nodeQueue = new NodeQueue(64);
    private ViewArea viewArea;
    private int viewDistance;
    private static final Direction[] DIRECTIONS = Direction.values();
    private static final double CEILED_SECTION_DIAGONAL = Math.ceil(Math.sqrt(3.0d) * 16.0d);

    public void update(ViewArea viewArea, boolean smartCull, LevelPerspectiveCamera camera, Frustum frustum, List<SectionRenderDispatcher.RenderSection> sections) {
        this.viewArea = viewArea;
        this.viewDistance = Math.min(viewArea.getViewDistance(), Mth.ceil(camera.getRenderDistance()));
        GraphStorage graphState = new GraphStorage(viewArea.sections.length);
        initializeQueueForFullUpdate(camera, viewArea);
        this.nodeQueue.forEach(node -> {
            graphState.sectionToNodeMap.put(node.section, node);
        });
        runUpdates(graphState, viewArea, camera.getPosition(), frustum, this.nodeQueue, smartCull, sections);
    }

    public void reset() {
        this.nodeQueue.trim(64);
    }

    private void initializeQueueForFullUpdate(Camera camera, ViewArea viewArea) {
        this.nodeQueue.clear();
        BlockPos pos = camera.getBlockPosition();
        SectionRenderDispatcher.RenderSection renderSection = viewArea.getRenderSectionAt(pos);
        if (renderSection != null) {
            this.nodeQueue.add(new Node(renderSection, 0));
            return;
        }
        Vec3 cameraPos = camera.getPosition();
        LevelHeightAccessor level = viewArea.getLevelHeightAccessor();
        boolean aboveVoid = pos.getY() > level.getMinBuildHeight();
        int startY = aboveVoid ? level.getMaxBuildHeight() - 8 : level.getMinBuildHeight() + 8;
        int startX = Mth.floor(cameraPos.x / 16.0d) << 4;
        int startZ = Mth.floor(cameraPos.z / 16.0d) << 4;
        int radius = this.viewDistance;
        List<Node> list = new ArrayList<>(4 * radius * radius);
        BlockPos.MutableBlockPos renderSectionPos = new BlockPos.MutableBlockPos();
        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                SectionRenderDispatcher.RenderSection section = viewArea.getRenderSectionAt(renderSectionPos.set((startX + x) << 12, startY, (startZ + z) << 12));
                if (section != null && isInViewDistance(pos, section.getOrigin())) {
                    Direction direction = aboveVoid ? Direction.DOWN : Direction.UP;
                    Node node = new Node(section, 0);
                    node.addSourceDirection(direction);
                    node.addDirection(direction);
                    if (x > 0) {
                        node.addDirection(Direction.EAST);
                    } else if (x < 0) {
                        node.addDirection(Direction.WEST);
                    }
                    if (z > 0) {
                        node.addDirection(Direction.SOUTH);
                    } else if (z < 0) {
                        node.addDirection(Direction.NORTH);
                    }
                    list.add(node);
                }
            }
        }
        list.sort(Comparator.comparingDouble(node2 -> {
            BlockPos origin = node2.section.getOrigin();
            return pos.distToCenterSqr(((double) origin.getX()) + 8.5d, ((double) origin.getY()) + 8.5d, ((double) origin.getZ()) + 8.5d);
        }));
        this.nodeQueue.addAll(list);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x035e  */
    /* JADX WARN: Code duplicated, block: B:110:0x0369 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x018c  */
    /* JADX WARN: Code duplicated, block: B:92:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:94:0x0309  */
    /* JADX WARN: Code duplicated, block: B:95:0x0313  */
    /* JADX WARN: Code duplicated, block: B:97:0x033b  */
    /* JADX WARN: Code duplicated, block: B:98:0x0353  */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01c5, code lost:
    
        r0 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void runUpdates(foundry.veil.impl.client.render.perspective.VeilSectionOcclusionGraph.GraphStorage r12, net.minecraft.client.renderer.ViewArea r13, net.minecraft.world.phys.Vec3 r14, net.minecraft.client.renderer.culling.Frustum r15, java.util.Queue<foundry.veil.impl.client.render.perspective.VeilSectionOcclusionGraph.Node> r16, boolean r17, java.util.List<net.minecraft.client.renderer.chunk.SectionRenderDispatcher.RenderSection> r18) {
        /*
            Method dump skipped, instruction units count: 883
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: foundry.veil.impl.client.render.perspective.VeilSectionOcclusionGraph.runUpdates(foundry.veil.impl.client.render.perspective.VeilSectionOcclusionGraph$GraphStorage, net.minecraft.client.renderer.ViewArea, net.minecraft.world.phys.Vec3, net.minecraft.client.renderer.culling.Frustum, java.util.Queue, boolean, java.util.List):void");
    }

    private boolean isInViewDistance(BlockPos pos, BlockPos origin) {
        int centerX = pos.getX() >> 4;
        int centerZ = pos.getZ() >> 4;
        int x = origin.getX() >> 4;
        int z = origin.getZ() >> 4;
        return ChunkTrackingView.isWithinDistance(centerX, centerZ, this.viewDistance, x, z, false);
    }

    @Nullable
    private SectionRenderDispatcher.RenderSection getRelativeFrom(BlockPos pos, SectionRenderDispatcher.RenderSection section, Direction direction) {
        BlockPos origin = section.getRelativeOrigin(direction);
        if (isInViewDistance(pos, origin) && Mth.abs(pos.getY() - origin.getY()) <= (this.viewDistance << 4)) {
            return this.viewArea.getRenderSectionAt(origin);
        }
        return null;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/perspective/VeilSectionOcclusionGraph$GraphStorage.class */
    private static class GraphStorage {
        public final SectionToNodeMap sectionToNodeMap;
        public final IntSet renderSections;

        public GraphStorage(int size) {
            this.sectionToNodeMap = new SectionToNodeMap(size);
            this.renderSections = new IntArraySet(size);
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/perspective/VeilSectionOcclusionGraph$Node.class */
    private static class Node {
        private final SectionRenderDispatcher.RenderSection section;
        private int sourceDirections;
        private int directions;
        private final int step;

        private Node(SectionRenderDispatcher.RenderSection section, int step) {
            this.section = section;
            this.step = step;
        }

        private void addDirection(Direction direction) {
            this.directions |= 1 << direction.ordinal();
        }

        private void addSourceDirection(Direction sourceDirection) {
            this.sourceDirections |= 1 << sourceDirection.ordinal();
        }

        public int hashCode() {
            return this.section.getOrigin().hashCode();
        }

        public boolean equals(Object object) {
            return this.section.getOrigin().equals(((Node) object).section.getOrigin());
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/perspective/VeilSectionOcclusionGraph$SectionToNodeMap.class */
    private static class SectionToNodeMap {
        private final Node[] nodes;

        private SectionToNodeMap(int size) {
            this.nodes = new Node[size];
        }

        public void put(SectionRenderDispatcher.RenderSection section, Node node) {
            this.nodes[section.index] = node;
        }

        @Nullable
        public Node get(SectionRenderDispatcher.RenderSection section) {
            int index = section.index;
            if (index < 0 || index >= this.nodes.length) {
                return null;
            }
            return this.nodes[index];
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/render/perspective/VeilSectionOcclusionGraph$NodeQueue.class */
    private static class NodeQueue implements Queue<Node> {
        private Node[] data;
        private int size = 0;
        private int readPointer;

        public NodeQueue(int initialCapacity) {
            this.data = new Node[initialCapacity];
        }

        public void trim(int size) {
            if (this.data.length > size) {
                this.data = new Node[size];
            }
            this.size = 0;
            this.readPointer = 0;
        }

        @Override // java.util.Collection
        public int size() {
            return this.size;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.readPointer >= this.size;
        }

        @Override // java.util.Collection
        public boolean contains(Object o) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.lang.Iterable
        @NotNull
        public Iterator<Node> iterator() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        @NotNull
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        @NotNull
        public <T> T[] toArray(@NotNull T[] a) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Queue, java.util.Collection
        public boolean add(Node node) {
            if (this.size >= this.data.length) {
                this.data = (Node[]) Arrays.copyOf(this.data, this.data.length * 2);
            }
            Node[] nodeArr = this.data;
            int i = this.size;
            this.size = i + 1;
            nodeArr[i] = node;
            return true;
        }

        @Override // java.util.Collection
        public boolean remove(Object o) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean containsAll(@NotNull Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(@NotNull Collection<? extends Node> c) {
            if (isEmpty() && (c instanceof ArrayList)) {
                ArrayList<? extends Node> arrayList = (ArrayList) c;
                this.data = (Node[]) arrayList.toArray(x$0 -> {
                    return new Node[x$0];
                });
                return true;
            }
            if (this.size + c.size() > this.data.length) {
                this.data = (Node[]) Arrays.copyOf(this.data, this.size + c.size());
            }
            for (Node node : c) {
                Node[] nodeArr = this.data;
                int i = this.size;
                this.size = i + 1;
                nodeArr[i] = node;
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(@NotNull Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean retainAll(@NotNull Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            this.size = 0;
            this.readPointer = 0;
        }

        @Override // java.util.Queue
        public boolean offer(Node node) {
            return add(node);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Queue
        public Node remove() {
            if (this.readPointer < this.size) {
                Node[] nodeArr = this.data;
                int i = this.readPointer;
                this.readPointer = i + 1;
                return nodeArr[i];
            }
            throw new NoSuchElementException();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Queue
        public Node poll() {
            if (this.readPointer < this.size) {
                Node[] nodeArr = this.data;
                int i = this.readPointer;
                this.readPointer = i + 1;
                return nodeArr[i];
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Queue
        public Node element() {
            if (this.readPointer < this.size) {
                return this.data[this.readPointer];
            }
            throw new NoSuchElementException();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Queue
        public Node peek() {
            if (this.readPointer >= this.size) {
                return null;
            }
            return this.data[this.readPointer];
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Node> action) {
            for (int i = this.readPointer; i < this.size; i++) {
                action.accept(this.data[i]);
            }
        }
    }
}
