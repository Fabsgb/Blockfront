package com.boehmod.blockfront;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.Watchable;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.kg */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/kg.class */
public class RunnableC0603kg implements Runnable {

    /* JADX INFO: renamed from: M */
    private static final long f3495M = 1000;
    private volatile boolean running = true;

    /* JADX INFO: renamed from: dd */
    private volatile boolean f3494dd = false;

    /* JADX INFO: renamed from: u */
    @NotNull
    private final Map<String, Long> f3496u = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c */
    @NotNull
    private final Path f3492c = Paths.get(C0607kk.m2734c().m2747F(), new String[0]);

    /* JADX INFO: renamed from: a */
    @NotNull
    private final WatchService f3493a = FileSystems.getDefault().newWatchService();

    /* JADX INFO: renamed from: a */
    private boolean m2690a(@NotNull WatchKey watchKey, @NotNull WatchEvent<?> watchEvent) {
        String string;
        String string2 = ((Path) watchEvent.context()).getFileName().toString();
        if (!string2.endsWith(".json")) {
            return false;
        }
        Long l = this.f3496u.get(string2);
        if (l != null) {
            if (System.currentTimeMillis() - l.longValue() < f3495M) {
                return false;
            }
            this.f3496u.remove(string2);
        }
        int iLastIndexOf = string2.lastIndexOf(46);
        String strSubstring = iLastIndexOf >= 0 ? string2.substring(0, iLastIndexOf) : string2;
        Watchable watchable = watchKey.watchable();
        if (watchable instanceof Path) {
            string = ((Path) watchable).getFileName().toString();
        } else {
            string = "";
        }
        String str = string;
        C0530jM.log("[Asset Watcher] Detected change in asset '" + string2 + "' (type '" + str + "').", new Object[0]);
        MutableComponent mutableComponentTranslatable = Component.translatable("bf.message.command.assets.file.watcher", new Object[]{Component.literal(string2).withStyle(C0533jP.f3188e), Component.literal(watchEvent.kind().name()).withStyle(C0533jP.f3188e)});
        MinecraftServer minecraftServerM2335a = C0529jL.m2335a();
        if (minecraftServerM2335a == null) {
            return false;
        }
        minecraftServerM2335a.execute(() -> {
            Iterator it = minecraftServerM2335a.getPlayerList().getPlayers().iterator();
            while (it.hasNext()) {
                ((ServerPlayer) it.next()).sendSystemMessage(mutableComponentTranslatable);
            }
            if (!C0606kj.m2732b(str, strSubstring)) {
                C0607kk.m2734c().m2743by();
                C0530jM.log("[Asset Watcher] No targeted handler for type '%s', fell back to full reload.", str);
            }
        });
        return true;
    }

    /* JADX INFO: renamed from: A */
    public void m2691A(boolean z) {
        C0530jM.log("[Asset Watcher] " + (z ? "Paused" : "Un-paused") + " watch for file changes.", new Object[0]);
        this.f3494dd = z;
    }

    /* JADX INFO: renamed from: i */
    public void m2692i(@NotNull String str) {
        this.f3496u.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    /* JADX INFO: renamed from: br */
    public void m2693br() {
        C0530jM.log("[Asset Watcher] Started watch for file changes.", new Object[0]);
        try {
            m2695bt();
            while (this.running) {
                try {
                    WatchKey watchKeyPoll = this.f3493a.poll(100L, TimeUnit.MILLISECONDS);
                    if (watchKeyPoll != null) {
                        for (WatchEvent<?> watchEvent : watchKeyPoll.pollEvents()) {
                            if (watchEvent.kind() != StandardWatchEventKinds.OVERFLOW && !this.f3494dd && m2690a(watchKeyPoll, watchEvent)) {
                                break;
                            }
                        }
                        watchKeyPoll.reset();
                    }
                } catch (InterruptedException e) {
                }
            }
            m2694bs();
        } catch (IOException e2) {
            m2694bs();
        } catch (Throwable th) {
            m2694bs();
            throw th;
        }
    }

    /* JADX INFO: renamed from: bs */
    public void m2694bs() {
        C0530jM.log("[Asset Watcher] Stopping watch for file changes.", new Object[0]);
        this.running = false;
        try {
            this.f3493a.close();
        } catch (IOException e) {
        }
    }

    /* JADX INFO: renamed from: bt */
    private void m2695bt() throws IOException {
        C0530jM.log("[Asset Watcher] Initializing file watcher for asset store...", new Object[0]);
        Files.walkFileTree(this.f3492c, new SimpleFileVisitor<Path>() { // from class: com.boehmod.blockfront.kg.1
            @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public FileVisitResult preVisitDirectory(@NotNull Path path, @NotNull BasicFileAttributes basicFileAttributes) throws IOException {
                path.register(RunnableC0603kg.this.f3493a, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
                return FileVisitResult.CONTINUE;
            }
        });
        C0530jM.log("[Asset Watcher] Finished initializing file watcher for asset store...", new Object[0]);
    }

    @Override // java.lang.Runnable
    public void run() {
        m2693br();
    }
}
