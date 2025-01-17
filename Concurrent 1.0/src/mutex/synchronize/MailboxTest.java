package mutex.synchronize;

import utils.Log;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class MailboxTest {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new People().start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (Integer id : Mailboxes.getIds()) {
            new Postman(id, "内容" + id).start();
        }

    }

    // classes

    static class People extends Thread {
        @Override
        public void run() {
            GuardedObject guardedObject = Mailboxes.createGuardedObject();
            Log.debug("开始收信 id: {}", guardedObject.getId());
            Object mail = guardedObject.get(5000);
            Log.debug("收到信 id:{}, 内容:{}", guardedObject.getId(), mail);
        }
    }

    static class Postman extends Thread {
        private final int id;
        private final String mail;

        public Postman(int id, String mail) {
            this.id = id;
            this.mail = mail;
        }

        @Override
        public void run() {
            GuardedObject guardedObject = Mailboxes.getGuardedObject(id);
            Log.debug("送信 id:{}, 内容:{}", id, mail);
            guardedObject.complete(mail);
        }
    }

    static class Mailboxes {
        private static final Map<Integer, GuardedObject> boxes = new ConcurrentHashMap<>();
        private static int id = 1;

        private static synchronized int generateId() {
            return id++;
        }

        public static GuardedObject getGuardedObject(int id) {
            return boxes.remove(id);
        }

        public static GuardedObject createGuardedObject() {
            GuardedObject guardedObject = new GuardedObject(generateId());
            boxes.put(guardedObject.getId(), guardedObject);
            return guardedObject;
        }

        public static Set<Integer> getIds() {
            return boxes.keySet();
        }
    }

    static class GuardedObject {
        private final int id;
        private Object response;

        public GuardedObject(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public synchronized Object get() {
            while (response == null) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return response;
        }

        public synchronized Object get(long timeout) {
            long begin = System.currentTimeMillis();
            long passTime = 0;

            while (response == null) {
                long waitTime = timeout - passTime;

                if (waitTime <= 0) {
                    break;
                }

                try {
                    this.wait(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                passTime = System.currentTimeMillis() - begin;
            }

            return response;
        }

        public synchronized void complete(Object response) {
            this.response = response;
            this.notifyAll();
        }
    }
}