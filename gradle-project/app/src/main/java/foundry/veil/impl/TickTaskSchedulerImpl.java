package foundry.veil.impl;

import foundry.veil.Veil;
import foundry.veil.api.TickTaskScheduler;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/TickTaskSchedulerImpl.class */
@ApiStatus.Internal
public class TickTaskSchedulerImpl implements TickTaskScheduler {
    private final Queue<Task<?>> tasks = new PriorityBlockingQueue();
    private long tick = 0;
    private volatile boolean stopped = false;

    public void run() {
        Iterator<Task<?>> iterator = this.tasks.iterator();
        while (iterator.hasNext()) {
            Task<?> task = iterator.next();
            if (task.isDone()) {
                iterator.remove();
            } else {
                if (this.tick < ((Task) task).executionTick) {
                    break;
                }
                try {
                    ((Task) task).runnable.run();
                    task.finish(null);
                } catch (Throwable t) {
                    Veil.LOGGER.error("Failed to execute task", t);
                    task.finish(t);
                }
                iterator.remove();
            }
        }
        this.tick++;
    }

    public void shutdown() {
        this.stopped = true;
        Iterator<Task<?>> iterator = this.tasks.iterator();
        while (iterator.hasNext()) {
            Task<?> task = iterator.next();
            if (task.isDone()) {
                iterator.remove();
            } else {
                try {
                    ((Task) task).runnable.run();
                    task.finish(null);
                } catch (Throwable t) {
                    Veil.LOGGER.error("Failed to execute task", t);
                    task.finish(t);
                }
                iterator.remove();
            }
        }
        if (!this.tasks.isEmpty()) {
            throw new IllegalStateException(this.tasks.size() + " tasks were first over!");
        }
    }

    private void validate(Object command) {
        Objects.requireNonNull(command);
        if (this.stopped) {
            throw new RejectedExecutionException();
        }
    }

    @Override // foundry.veil.api.TickTaskScheduler, java.util.concurrent.Executor
    public void execute(@NotNull Runnable command) {
        validate(command);
        this.tasks.add(new Task<>(this, command, 0L));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // foundry.veil.api.TickTaskScheduler
    public TickTaskScheduler.TickTask<?> schedule(@NotNull Runnable runnable, long j) {
        validate(runnable);
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        TickTaskImpl tickTaskImpl = new TickTaskImpl(this);
        Task<?> task = new Task<>(this, () -> {
            try {
                runnable.run();
            } catch (Throwable t) {
                tickTaskImpl.future.completeExceptionally(t);
            }
        }, this.tick + j);
        this.tasks.add(task);
        tickTaskImpl.setTask(task);
        tickTaskImpl.future.exceptionally((Function<Throwable, ? extends V>) e -> {
            if (tickTaskImpl.future.isCancelled()) {
                task.cancel(false);
                return null;
            }
            return null;
        });
        return tickTaskImpl;
    }

    @Override // foundry.veil.api.TickTaskScheduler
    public <V> TickTaskScheduler.TickTask<V> schedule(@NotNull Callable<V> callable, long delay) {
        validate(callable);
        if (delay < 0) {
            throw new IllegalArgumentException();
        }
        TickTaskImpl<V> tickTask = new TickTaskImpl<>(this);
        Task<?> task = new Task<>(this, () -> {
            try {
                tickTask.future.complete((V) callable.call());
            } catch (Throwable th) {
                tickTask.future.completeExceptionally(th);
            }
        }, this.tick + delay);
        this.tasks.add(task);
        tickTask.setTask(task);
        ((TickTaskImpl) tickTask).future.exceptionally(e -> {
            if (tickTask.future.isCancelled()) {
                task.cancel(false);
                return null;
            }
            return null;
        });
        return tickTask;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // foundry.veil.api.TickTaskScheduler
    public TickTaskScheduler.TickTask<?> scheduleAtFixedRate(@NotNull Runnable runnable, long j, long j2) {
        validate(runnable);
        if (j < 0 || j2 < 0) {
            throw new IllegalArgumentException();
        }
        TickTaskImpl tickTaskImpl = new TickTaskImpl(this);
        Task<?> taskSchedule = schedule(tickTaskImpl, runnable, new AtomicBoolean(), j, j2);
        this.tasks.add(taskSchedule);
        tickTaskImpl.setTask(taskSchedule);
        tickTaskImpl.future.exceptionally((Function<Throwable, ? extends V>) e -> {
            if (tickTaskImpl.future.isCancelled()) {
                taskSchedule.cancel(false);
                return null;
            }
            return null;
        });
        return tickTaskImpl;
    }

    private <V> Task<V> schedule(TickTaskImpl<V> tickTask, Runnable command, AtomicBoolean cancelled, long delay, long period) {
        return new Task<>(() -> {
            try {
                command.run();
                if (!this.stopped) {
                    Task<?> taskSchedule = schedule(tickTask, command, cancelled, period, period);
                    this.tasks.add(taskSchedule);
                    tickTask.setTask(taskSchedule);
                }
            } catch (Throwable t) {
                tickTask.future.completeExceptionally(t);
            }
        }, cancelled, this.tick + delay);
    }

    @Override // foundry.veil.api.TickTaskScheduler
    public boolean isShutdown() {
        return this.stopped;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/TickTaskSchedulerImpl$TickTaskImpl.class */
    private class TickTaskImpl<V> implements TickTaskScheduler.TickTask<V> {
        private final CompletableFuture<V> future = new CompletableFuture<>();
        private Task<?> task = null;

        private TickTaskImpl(TickTaskSchedulerImpl tickTaskSchedulerImpl) {
        }

        @Override // foundry.veil.api.TickTaskScheduler.TickTask
        public long getDelay() {
            return this.task.getDelay();
        }

        @Override // foundry.veil.api.TickTaskScheduler.TickTask
        public CompletableFuture<V> toCompletableFuture() {
            return this.future;
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(@NotNull TimeUnit unit) {
            return this.task.getDelay(unit);
        }

        @Override // java.lang.Comparable
        public int compareTo(@NotNull Delayed o) {
            return this.task.compareTo(o);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean mayInterruptIfRunning) {
            return this.task.cancel(mayInterruptIfRunning);
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.task.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.task.isDone();
        }

        @Override // java.util.concurrent.Future
        public V get() throws ExecutionException {
            return (V) this.task.get();
        }

        @Override // java.util.concurrent.Future
        public V get(long j, @NotNull TimeUnit timeUnit) throws ExecutionException {
            return (V) this.task.get(j, timeUnit);
        }

        public void setTask(Task<?> task) {
            this.task = task;
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/TickTaskSchedulerImpl$Task.class */
    private class Task<V> implements ScheduledFuture<V> {
        private final Runnable runnable;
        private final AtomicBoolean cancelled;
        private final long executionTick;
        private boolean complete;
        private Throwable error;

        private Task(TickTaskSchedulerImpl tickTaskSchedulerImpl, Runnable task, long executionTick) {
            this(task, new AtomicBoolean(), executionTick);
        }

        private Task(Runnable task, AtomicBoolean cancelled, long executionTick) {
            this.runnable = task;
            this.cancelled = cancelled;
            this.executionTick = executionTick;
        }

        public void finish(@Nullable Throwable error) {
            this.complete = true;
            this.error = error;
        }

        public long getDelay() {
            return this.executionTick - TickTaskSchedulerImpl.this.tick;
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(@NotNull TimeUnit unit) {
            return TimeUnit.MILLISECONDS.convert((this.executionTick - TickTaskSchedulerImpl.this.tick) * 50, unit);
        }

        @Override // java.lang.Comparable
        public int compareTo(@NotNull Delayed o) {
            return Long.compareUnsigned(this.executionTick, ((Task) o).executionTick);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean mayInterruptIfRunning) {
            return this.cancelled.compareAndSet(false, true);
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.cancelled.get();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.complete || this.cancelled.get();
        }

        @Override // java.util.concurrent.Future
        public V get() throws ExecutionException {
            if (this.error != null) {
                throw new ExecutionException(this.error);
            }
            return null;
        }

        @Override // java.util.concurrent.Future
        public V get(long timeout, @NotNull TimeUnit unit) throws ExecutionException {
            return get();
        }
    }
}
