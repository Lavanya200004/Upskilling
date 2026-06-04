class MessagePrinter extends Thread {
    private final String message;

    MessagePrinter(String message) {
        this.message = message;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(message + " - " + i);
        }
    }
}

class ThreadCreation {
    public static void main(String[] args) {
        MessagePrinter firstThread = new MessagePrinter("First thread");
        MessagePrinter secondThread = new MessagePrinter("Second thread");

        firstThread.start();
        secondThread.start();
    }
}
