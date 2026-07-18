package com.boehmod.bflib.common;

import it.unimi.dsi.fastutil.doubles.Double2ObjectRBTreeMap;
import it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap;
import java.util.concurrent.ThreadLocalRandom;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/common/RandomCollection.class */
public final class RandomCollection<E> {

    @NotNull
    private final Double2ObjectRBTreeMap<E> map;
    private double totalWeight;

    public RandomCollection() {
        this.map = new Double2ObjectRBTreeMap<>();
        this.totalWeight = 0.0d;
    }

    public RandomCollection(@NotNull E[] items, double[] weights) {
        this.map = new Double2ObjectRBTreeMap<>();
        if (items.length != weights.length) {
            throw new IllegalArgumentException("Invalid input parameters");
        }
        this.totalWeight = 0.0d;
        int bound = items.length;
        for (int i = 0; i < bound; i++) {
            add(weights[i], items[i]);
        }
    }

    @NotNull
    public RandomCollection<E> add(double weight, @NotNull E result) {
        if (weight <= 0.0d) {
            throw new IllegalArgumentException("Weight must be greater than zero");
        }
        this.totalWeight += weight;
        this.map.put(this.totalWeight, result);
        return this;
    }

    @NotNull
    public E getRandom() {
        return getRandom(ThreadLocalRandom.current().nextDouble());
    }

    @NotNull
    public E getRandom(double d) {
        if (this.totalWeight == 0.0d) {
            throw new IllegalStateException("Cannot get random item from an empty collection");
        }
        Double2ObjectSortedMap double2ObjectSortedMapTailMap = this.map.tailMap(d * this.totalWeight);
        if (double2ObjectSortedMapTailMap.isEmpty()) {
            return (E) this.map.lastEntry().getValue();
        }
        return (E) double2ObjectSortedMapTailMap.firstEntry().getValue();
    }

    public int size() {
        return this.map.size();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @NotNull
    public Double2ObjectRBTreeMap<E> getMap() {
        return this.map;
    }

    public void clear() {
        this.map.clear();
        this.totalWeight = 0.0d;
    }
}
