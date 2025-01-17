package mutex.synchronize;

import utils.Log;

import java.util.LinkedList;

import static utils.Time.sleep;

public class MessageQueueTest {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue(2);

        for (int i = 0; i < 3; i++) {
            int id = i;
            new Thread(() -> {
                messageQueue.put(new Message(id, "值" + id));
            }, "生产者" + i).start();
        }

        new Thread(() -> {
            while (true) {
                sleep(2000);
                Message message = messageQueue.take();
            }

        }, "消费者").start();
    }

    // classes

    static class MessageQueue {
        private final LinkedList<Message> list = new LinkedList<>();
        private final int capacity;

        public MessageQueue(int capacity) {
            this.capacity = capacity;
        }

        // 获取消息
        public Message take() {
            synchronized (list) {
                while (list.isEmpty()) {
                    try {
                        Log.debug("Queue is empty");
                        list.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                Message message = list.removeFirst();
                Log.debug("Message consumed: {}", message);
                list.notifyAll();
                return message;
            }
        }

        // 存入消息
        public void put(Message message){
            synchronized (list) {
                while (list.size() == capacity) {
                    try {
                        Log.debug("Queue is full");
                        list.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                list.addLast(message);
                Log.debug("Message added: {}", message);
                list.notifyAll();
            }
        }
    }

    static class Message {
        private final int id;
        private final Object value;

        public Message(int id, Object value) {
            this.id = id;
            this.value = value;
        }

        public int getId() {
            return id;
        }

        public Object getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Message{" +
                    "id=" + id +
                    ", value=" + value +
                    '}';
        }
    }
}
