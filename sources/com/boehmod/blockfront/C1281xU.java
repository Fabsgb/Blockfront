package com.boehmod.blockfront;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.Properties;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xU */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xU.class */
public class C1281xU {
    /* JADX INFO: renamed from: d */
    public static void m7291d(@NotNull C1280xT c1280xT) {
        if (c1280xT.mo2374f()) {
            try {
                FileInputStream fileInputStream = new FileInputStream("server.properties");
                try {
                    int i = 25565;
                    boolean z = false;
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    C0530jM.log("Original port is " + 25565, new Object[0]);
                    while (!m7292c(i)) {
                        z = true;
                        i++;
                    }
                    properties.setProperty("server-port", String.valueOf(i));
                    if (z) {
                        C0530jM.log("Server port is in use! Switched server port to '" + i + "'", new Object[0]);
                    } else {
                        C0530jM.log("Server port '" + i + "' not in use! Ignoring.", new Object[0]);
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream("server.properties");
                    try {
                        properties.store(fileOutputStream, (String) null);
                        fileOutputStream.close();
                        C0530jM.log("Successfully checked and patched server port!", new Object[0]);
                        fileInputStream.close();
                    } catch (Throwable th) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } catch (IOException e) {
                C0530jM.m2338a("Error while checking server port.", e, new Object[0]);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public static boolean m7292c(int i) {
        ServerSocket serverSocket = null;
        DatagramSocket datagramSocket = null;
        try {
            serverSocket = new ServerSocket(i);
            serverSocket.setReuseAddress(true);
            datagramSocket = new DatagramSocket(i);
            datagramSocket.setReuseAddress(true);
            if (datagramSocket != null) {
                datagramSocket.close();
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                }
            }
            return true;
        } catch (IOException e2) {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
            if (serverSocket == null) {
                return false;
            }
            try {
                serverSocket.close();
                return false;
            } catch (IOException e3) {
                return false;
            }
        } catch (Throwable th) {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e4) {
                }
            }
            throw th;
        }
    }
}
