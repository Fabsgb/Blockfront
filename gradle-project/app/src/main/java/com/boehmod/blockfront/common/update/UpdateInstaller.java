package com.boehmod.blockfront.common.update;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/common/update/UpdateInstaller.class */
public final class UpdateInstaller {
    private static final long EXIT_WAIT_MILLIS = 120000;
    private static final int DELETE_RETRIES = 60;
    private static final long RETRY_DELAY_MILLIS = 500;

    private UpdateInstaller() {
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length != 4) {
            log("Usage: UpdateInstaller <pid> <oldJar> <stagedJar> <modsDir>");
            System.exit(2);
        }
        long j = Long.parseLong(strArr[0]);
        Path pathOf = Path.of(strArr[1], new String[0]);
        Path pathOf2 = Path.of(strArr[2], new String[0]);
        Path pathOf3 = Path.of(strArr[3], new String[0]);
        log("Waiting for game process " + j + " to exit...");
        waitForExit(j);
        log("Removing old jar '" + String.valueOf(pathOf) + "'...");
        if (!retryDelete(pathOf)) {
            log("Failed to remove the old jar. The staged update remains at '" + String.valueOf(pathOf2) + "'.");
            System.exit(1);
        }
        Path pathResolve = pathOf3.resolve(pathOf2.getFileName());
        log("Installing '" + String.valueOf(pathOf2) + "' to '" + String.valueOf(pathResolve) + "'...");
        Files.move(pathOf2, pathResolve, StandardCopyOption.REPLACE_EXISTING);
        log("Update installed successfully.");
    }

    private static void waitForExit(long j) throws InterruptedException {
        long jCurrentTimeMillis = System.currentTimeMillis() + EXIT_WAIT_MILLIS;
        while (System.currentTimeMillis() < jCurrentTimeMillis) {
            Optional optionalOf = ProcessHandle.of(j);
            if (optionalOf.isEmpty() || !((ProcessHandle) optionalOf.get()).isAlive()) {
                return;
            } else {
                Thread.sleep(RETRY_DELAY_MILLIS);
            }
        }
    }

    private static boolean retryDelete(Path path) throws InterruptedException {
        for (int i = 0; i < 60; i++) {
            try {
                Files.deleteIfExists(path);
                return true;
            } catch (IOException e) {
                Thread.sleep(RETRY_DELAY_MILLIS);
            }
        }
        return false;
    }

    private static void log(String str) {
        System.out.println("[BlockFront Updater] " + str);
    }
}
