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

/* JADX INFO: renamed from: com.boehmod.blockfront.jK */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jK.class */
public class RunnableC0527jK implements Runnable {

    /* JADX INFO: renamed from: s */
    private static final long f3118s = 1000;
    private volatile boolean running = true;

    /* JADX INFO: renamed from: cU */
    private volatile boolean f3117cU = false;

    /* JADX INFO: renamed from: u */
    @NotNull
    private final Map<String, Long> f3119u = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b */
    @NotNull
    private final Path f3115b = Paths.get(C0531jO.m2372c().m2385y(), new String[0]);

    /* JADX INFO: renamed from: a */
    @NotNull
    private final WatchService f3116a = FileSystems.getDefault().newWatchService();

    /* JADX INFO: renamed from: a */
    private boolean m2330a(@NotNull WatchKey watchKey, @NotNull WatchEvent<?> watchEvent) {
        String string;
        String string2 = ((Path) watchEvent.context()).getFileName().toString();
        if (!string2.endsWith(".json")) {
            return false;
        }
        Long l = this.f3119u.get(string2);
        if (l != null) {
            if (System.currentTimeMillis() - l.longValue() < f3118s) {
                return false;
            }
            this.f3119u.remove(string2);
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
        C0562jt.log("[Asset Watcher] Detected change in asset '" + string2 + "' (type '" + str + "').", new Object[0]);
        MutableComponent mutableComponentTranslatable = Component.translatable("bf.message.command.assets.file.watcher", new Object[]{Component.literal(string2).withStyle(C0565jw.f3204e), Component.literal(watchEvent.kind().name()).withStyle(C0565jw.f3204e)});
        MinecraftServer minecraftServerM2514a = C0561js.m2514a();
        if (minecraftServerM2514a == null) {
            return false;
        }
        minecraftServerM2514a.execute(() -> {
            Iterator it = minecraftServerM2514a.getPlayerList().getPlayers().iterator();
            while (it.hasNext()) {
                ((ServerPlayer) it.next()).sendSystemMessage(mutableComponentTranslatable);
            }
            if (!C0530jN.m2370a(str, strSubstring)) {
                C0531jO.m2372c().m2381bn();
                C0562jt.log("[Asset Watcher] No targeted handler for type '%s', fell back to full reload.", str);
            }
        });
        return true;
    }

    /* JADX INFO: renamed from: A */
    public void m2331A(boolean z) {
        C0562jt.log("[Asset Watcher] " + (z ? "Paused" : "Un-paused") + " watch for file changes.", new Object[0]);
        this.f3117cU = z;
    }

    /* JADX INFO: renamed from: i */
    public void m2332i(@NotNull String str) {
        this.f3119u.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    /* JADX INFO: renamed from: bg */
    public void m2333bg() {
        C0562jt.log("[Asset Watcher] Started watch for file changes.", new Object[0]);
        try {
            m2335bi();
            while (this.running) {
                try {
                    WatchKey watchKeyPoll = this.f3116a.poll(100L, TimeUnit.MILLISECONDS);
                    if (watchKeyPoll != null) {
                        for (WatchEvent<?> watchEvent : watchKeyPoll.pollEvents()) {
                            if (watchEvent.kind() != StandardWatchEventKinds.OVERFLOW && !this.f3117cU && m2330a(watchKeyPoll, watchEvent)) {
                                break;
                            }
                        }
                        watchKeyPoll.reset();
                    }
                } catch (InterruptedException e) {
                }
            }
            m2334bh();
        } catch (IOException e2) {
            m2334bh();
        } catch (Throwable th) {
            m2334bh();
            throw th;
        }
    }

    /* JADX INFO: renamed from: bh */
    public void m2334bh() {
        C0562jt.log("[Asset Watcher] Stopping watch for file changes.", new Object[0]);
        this.running = false;
        try {
            this.f3116a.close();
        } catch (IOException e) {
        }
    }

    /* JADX INFO: renamed from: bi */
    private void m2335bi() throws IOException {
        C0562jt.log("[Asset Watcher] Initializing file watcher for asset store...", new Object[0]);
        Files.walkFileTree(this.f3115b, new SimpleFileVisitor<Path>() { // from class: com.boehmod.blockfront.jK.1
            @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public FileVisitResult preVisitDirectory(@NotNull Path path, @NotNull BasicFileAttributes basicFileAttributes) throws IOException {
                path.register(RunnableC0527jK.this.f3116a, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
                return FileVisitResult.CONTINUE;
            }
        });
        C0562jt.log("[Asset Watcher] Finished initializing file watcher for asset store...", new Object[0]);
    }

    @Override // java.lang.Runnable
    public void run() {
        m2333bg();
    }
}
