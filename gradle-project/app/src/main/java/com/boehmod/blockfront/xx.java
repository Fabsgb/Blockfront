package com.boehmod.blockfront;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.Properties;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xx.class */
public class xx {
    public static void d(@NotNull xw xwVar) {
        if (xwVar.f()) {
            try {
                FileInputStream fileInputStream = new FileInputStream("server.properties");
                try {
                    int i = 25565;
                    boolean z = false;
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    C0263jt.log("Original port is " + 25565, new Object[0]);
                    while (!c(i)) {
                        z = true;
                        i++;
                    }
                    properties.setProperty("server-port", String.valueOf(i));
                    if (z) {
                        C0263jt.log("Server port is in use! Switched server port to '" + i + "'", new Object[0]);
                    } else {
                        C0263jt.log("Server port '" + i + "' not in use! Ignoring.", new Object[0]);
                    }
                    fileInputStream.close();
                    FileOutputStream fileOutputStream = new FileOutputStream("server.properties");
                    properties.store(fileOutputStream, (String) null);
                    fileOutputStream.close();
                    C0263jt.log("Successfully checked and patched server port!", new Object[0]);
                    fileInputStream.close();
                } finally {
                }
            } catch (IOException e) {
                C0263jt.a("Error while checking server port.", e, new Object[0]);
            }
        }
    }

    public static boolean c(int i) {
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
