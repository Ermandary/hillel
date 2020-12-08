package myThreadPool;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MyThreadPool {
    private final Deque<Runnable> taskQueue = new ArrayDeque<>();
    private final List<Thread> threadList = new ArrayList<>();
    private volatile long tmp3 = 0;

    public MyThreadPool() {
        this(10);
    }

    public MyThreadPool(int threadCount) {
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(this::run);
            thread.setDaemon(true);
            threadList.add(thread);
        }
        for (int i = 0; i < threadCount; i++) {
            threadList.get(i).start();
        }
    }

    public void addTask(Runnable runnable) {
        taskQueue.add(runnable);
    }

    public boolean isFree() {
        return taskQueue.isEmpty();
    }

    public void waitAll() {
        for (int i = 0; i < threadList.size() - 1; i++) {
            try {
                threadList.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        for (int i = 0; i < threadList.size() - 1; i++) {
            threadList.get(i).interrupt();
        }
    }

    private void run() {
        while (!Thread.interrupted()) {
            if (taskQueue.isEmpty()) {
                Thread.yield();
            } else {
                tmp3++;
                taskQueue.pollFirst().run();
            }
        }
    }
}
