package foundry.veil.impl;

import foundry.veil.Veil;
import java.util.Deque;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/ThreadTaskScheduler.class */
public class ThreadTaskScheduler {
    private final int threadCount;
    private final Supplier<Runnable> source;
    private final Semaphore semaphore = new Semaphore(0);
    private final CompletableFuture<?> completedFuture = new CompletableFuture<>();
    private final Deque<Runnable> queue = new ConcurrentLinkedDeque();
    private final AtomicBoolean running = new AtomicBoolean(true);
    private final AtomicBoolean cancelled = new AtomicBoolean(false);
    private final AtomicInteger finished = new AtomicInteger(0);

    public ThreadTaskScheduler(String name, int threadCount, Supplier<Runnable> source) {
        this.source = source;
        int spawnedThreads = 0;
        for (int i = 0; i < threadCount; i++) {
            Runnable work = source.get();
            if (work == null) {
                this.running.set(false);
                this.semaphore.release(spawnedThreads);
                break;
            }
            this.queue.add(work);
            this.semaphore.release();
            Thread thread = new Thread(this::run, name + "Thread#" + i);
            thread.setPriority(1);
            thread.start();
            spawnedThreads++;
        }
        this.threadCount = spawnedThreads;
    }

    private void run() {
        while (true) {
            try {
                this.semaphore.acquire();
                Runnable task = this.queue.poll();
                if (task != null) {
                    Runnable next = this.source.get();
                    if (next == null) {
                        if (this.running.compareAndSet(true, false)) {
                            this.semaphore.release(this.threadCount);
                        }
                    } else {
                        this.queue.add(next);
                        this.semaphore.release();
                    }
                }
                if (task == null) {
                    if (!this.running.get()) {
                        break;
                    }
                } else {
                    try {
                        task.run();
                    } catch (Throwable t) {
                        Veil.LOGGER.error("Error running task", t);
                    }
                }
            } catch (InterruptedException e) {
            }
        }
        if (this.finished.incrementAndGet() >= this.threadCount) {
            this.completedFuture.complete(null);
        }
    }

    public void cancel() {
        if (this.running.compareAndSet(true, false)) {
            this.cancelled.set(true);
            this.semaphore.release(this.threadCount);
        }
    }

    public CompletableFuture<?> getCompletedFuture() {
        return this.completedFuture;
    }

    public boolean isCancelled() {
        return this.cancelled.get();
    }
}
