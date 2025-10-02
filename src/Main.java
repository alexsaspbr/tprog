public class Main {
    public static void main(String[] args) {

        //Threads
        Thread thread = new Thread(() -> System.out.printf("[thread %s] Ola\n", Thread.currentThread().getName()));
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getState());
            throw new RuntimeException(e);
        }
        Thread thread2 = new Thread(() -> System.out.printf("[thread %s] Turma 1418\n", Thread.currentThread().getName()));

        thread2.start();
        thread.start();
        //thread2.join();
        //thread.join();
        System.out.printf("[thread %s] Mundo\n", Thread.currentThread().getName());

    }
}