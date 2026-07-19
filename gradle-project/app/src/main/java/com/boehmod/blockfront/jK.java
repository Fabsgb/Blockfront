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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/jK.class */
public class jK implements Runnable {
    private static final long s = 1000;
    private volatile boolean running = true;
    private volatile boolean cU = false;

    @NotNull
    private final Map<String, Long> u = new ConcurrentHashMap();

    @NotNull
    private final Path b = Paths.get(jO.c().y(), new String[0]);

    @NotNull
    private final WatchService a = FileSystems.getDefault().newWatchService();

    private boolean a(@NotNull WatchKey watchKey, @NotNull WatchEvent<?> watchEvent) {
        String string;
        String string2 = ((Path) watchEvent.context()).getFileName().toString();
        if (!string2.endsWith(".json")) {
            return false;
        }
        Long l = this.u.get(string2);
        if (l != null) {
            if (System.currentTimeMillis() - l.longValue() < s) {
                return false;
            }
            this.u.remove(string2);
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
        C0263jt.log("[Asset Watcher] Detected change in asset '" + string2 + "' (type '" + str + "').", new Object[0]);
        MutableComponent mutableComponentTranslatable = Component.translatable("bf.message.command.assets.file.watcher", new Object[]{Component.literal(string2).withStyle(C0266jw.e), Component.literal(watchEvent.kind().name()).withStyle(C0266jw.e)});
        MinecraftServer minecraftServerA = C0262js.a();
        if (minecraftServerA == null) {
            return false;
        }
        minecraftServerA.execute(() -> {
            Iterator it = minecraftServerA.getPlayerList().getPlayers().iterator();
            while (it.hasNext()) {
                ((ServerPlayer) it.next()).sendSystemMessage(mutableComponentTranslatable);
            }
            if (!jN.a(str, strSubstring)) {
                jO.c().bn();
                C0263jt.log("[Asset Watcher] No targeted handler for type '%s', fell back to full reload.", str);
            }
        });
        return true;
    }

    public void A(boolean z) {
        C0263jt.log("[Asset Watcher] " + (z ? "Paused" : "Un-paused") + " watch for file changes.", new Object[0]);
        this.cU = z;
    }

    public void i(@NotNull String str) {
        this.u.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public void bg() {
        C0263jt.log("[Asset Watcher] Started watch for file changes.", new Object[0]);
        try {
            bi();
            while (this.running) {
                try {
                    WatchKey watchKeyPoll = this.a.poll(100L, TimeUnit.MILLISECONDS);
                    if (watchKeyPoll != null) {
                        for (WatchEvent<?> watchEvent : watchKeyPoll.pollEvents()) {
                            if (watchEvent.kind() != StandardWatchEventKinds.OVERFLOW && !this.cU && a(watchKeyPoll, watchEvent)) {
                                break;
                            }
                        }
                        watchKeyPoll.reset();
                    }
                } catch (InterruptedException e) {
                }
            }
            bh();
        } catch (IOException e2) {
            bh();
        } catch (Throwable th) {
            bh();
            throw th;
        }
    }

    public void bh() {
        C0263jt.log("[Asset Watcher] Stopping watch for file changes.", new Object[0]);
        this.running = false;
        try {
            this.a.close();
        } catch (IOException e) {
        }
    }

    private void bi() throws IOException {
        C0263jt.log("[Asset Watcher] Initializing file watcher for asset store...", new Object[0]);
        Files.walkFileTree(this.b, new SimpleFileVisitor<Path>() { // from class: com.boehmod.blockfront.jK.1
            @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public FileVisitResult preVisitDirectory(@NotNull Path path, @NotNull BasicFileAttributes basicFileAttributes) throws IOException {
                path.register(jK.this.a, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
                return FileVisitResult.CONTINUE;
            }
        });
        C0263jt.log("[Asset Watcher] Finished initializing file watcher for asset store...", new Object[0]);
    }

    @Override // java.lang.Runnable
    public void run() {
        bg();
    }
}
