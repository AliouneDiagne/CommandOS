package com.commandos.proc;

import java.util.*;
import java.util.concurrent.*;

/**
 * Gestore semplificato di processi simulati (virtual processes).
 */
public class ProcessManager {
    private static final Map<Integer, Future<?>> processes = new ConcurrentHashMap<>();
    private static int lastPid = 0;

    private ProcessManager() {}

    public static int start(Runnable task) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> future = executor.submit(task);
        int pid = ++lastPid;
        processes.put(pid, future);
        return pid;
    }

    public static boolean kill(int pid) {
        Future<?> future = processes.remove(pid);
        if (future != null) {
            return future.cancel(true);
        }
        return false;
    }

    public static Set<Integer> list() {
        return Collections.unmodifiableSet(processes.keySet());
    }
}
