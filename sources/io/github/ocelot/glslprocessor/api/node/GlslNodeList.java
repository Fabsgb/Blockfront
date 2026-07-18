package io.github.ocelot.glslprocessor.api.node;

import io.github.ocelot.glslprocessor.api.GlslInjectionPoint;
import io.github.ocelot.glslprocessor.api.node.function.GlslFunctionNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.UnaryOperator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:META-INF/jarjar/glsl-processor-0.2.3.jar:io/github/ocelot/glslprocessor/api/node/GlslNodeList.class */
public class GlslNodeList implements List<GlslNode> {
    private final ArrayList<GlslNode> nodes;

    public GlslNodeList() {
        this.nodes = new ArrayList<>();
    }

    public GlslNodeList(Collection<GlslNode> nodes) {
        this.nodes = new ArrayList<>(nodes);
    }

    private int getInjectionIndex(GlslInjectionPoint point) {
        switch (point) {
            case BEFORE_DECLARATIONS:
                for (int i = 0; i < this.nodes.size(); i++) {
                    if (!(this.nodes.get(i) instanceof GlslFunctionNode)) {
                        return i;
                    }
                }
                return 0;
            case AFTER_DECLARATIONS:
                for (int i2 = 0; i2 < this.nodes.size(); i2++) {
                    if (this.nodes.get(i2) instanceof GlslFunctionNode) {
                        return i2 + 1;
                    }
                }
                return 0;
            case BEFORE_MAIN:
                for (int i3 = 0; i3 < this.nodes.size(); i3++) {
                    GlslNode glslNode = this.nodes.get(i3);
                    if (glslNode instanceof GlslFunctionNode) {
                        GlslFunctionNode functionNode = (GlslFunctionNode) glslNode;
                        if ("main".equals(functionNode.getHeader().getName())) {
                            return i3;
                        }
                    }
                }
                return 0;
            case AFTER_MAIN:
                for (int i4 = 0; i4 < this.nodes.size(); i4++) {
                    GlslNode glslNode2 = this.nodes.get(i4);
                    if (glslNode2 instanceof GlslFunctionNode) {
                        GlslFunctionNode functionNode2 = (GlslFunctionNode) glslNode2;
                        if ("main".equals(functionNode2.getHeader().getName())) {
                            return i4 + 1;
                        }
                    }
                }
                return 0;
            case BEFORE_FUNCTIONS:
                for (int i5 = 0; i5 < this.nodes.size(); i5++) {
                    if (!(this.nodes.get(i5) instanceof GlslFunctionNode)) {
                        return i5;
                    }
                }
                return 0;
            case AFTER_FUNCTIONS:
                for (int i6 = 0; i6 < this.nodes.size(); i6++) {
                    if (!(this.nodes.get(i6) instanceof GlslFunctionNode)) {
                        return i6 + 1;
                    }
                }
                return 0;
            default:
                return 0;
        }
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.nodes.size();
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.nodes.isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object o) {
        if (!(o instanceof GlslNode)) {
            return false;
        }
        GlslNode node = (GlslNode) o;
        return this.nodes.contains(node);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<GlslNode> iterator() {
        return this.nodes.iterator();
    }

    @Override // java.util.List, java.util.Collection
    @NotNull
    public Object[] toArray() {
        return this.nodes.toArray();
    }

    @Override // java.util.List, java.util.Collection
    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        return (T[]) this.nodes.toArray(tArr);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(GlslNode glslNode) {
        return this.nodes.add(glslNode);
    }

    @Override // java.util.List
    public void add(int index, GlslNode element) {
        this.nodes.add(index, element);
    }

    public void add(GlslInjectionPoint point, GlslNode element) {
        this.nodes.add(getInjectionIndex(point), element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object o) {
        if (!(o instanceof GlslNode)) {
            return false;
        }
        GlslNode node = (GlslNode) o;
        return this.nodes.remove(node);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@NotNull Collection<?> c) {
        return new HashSet(this.nodes).containsAll(c);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(@NotNull Collection<? extends GlslNode> c) {
        return this.nodes.addAll(c);
    }

    @Override // java.util.List
    public boolean addAll(int index, @NotNull Collection<? extends GlslNode> c) {
        return this.nodes.addAll(index, c);
    }

    public void addAll(GlslInjectionPoint point, Collection<GlslNode> nodes) {
        this.nodes.addAll(getInjectionIndex(point), nodes);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(@NotNull Collection<?> c) {
        return this.nodes.removeAll(c);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@NotNull Collection<?> c) {
        return this.nodes.retainAll(c);
    }

    @Override // java.util.List
    public void replaceAll(@NotNull UnaryOperator<GlslNode> operator) {
        this.nodes.replaceAll(operator);
    }

    @Override // java.util.List
    public void sort(@Nullable Comparator<? super GlslNode> c) {
        this.nodes.sort(c);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.nodes.clear();
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlslNodeList glslNodes = (GlslNodeList) o;
        return this.nodes.equals(glslNodes.nodes);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.nodes.hashCode();
    }

    @Override // java.util.List
    public GlslNode get(int index) {
        return this.nodes.get(index);
    }

    @Override // java.util.List
    public GlslNode set(int index, GlslNode element) {
        return this.nodes.set(index, element);
    }

    @Override // java.util.List
    public GlslNode remove(int index) {
        return this.nodes.remove(index);
    }

    @Override // java.util.List
    public int indexOf(Object o) {
        return this.nodes.indexOf(o);
    }

    @Override // java.util.List
    public int lastIndexOf(Object o) {
        return this.nodes.lastIndexOf(o);
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<GlslNode> listIterator() {
        return this.nodes.listIterator();
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<GlslNode> listIterator(int index) {
        return this.nodes.listIterator(index);
    }

    @Override // java.util.List
    @NotNull
    public List<GlslNode> subList(int fromIndex, int toIndex) {
        return this.nodes.subList(fromIndex, toIndex);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NotNull
    public Spliterator<GlslNode> spliterator() {
        return this.nodes.spliterator();
    }

    public String toString() {
        return this.nodes.toString();
    }
}
