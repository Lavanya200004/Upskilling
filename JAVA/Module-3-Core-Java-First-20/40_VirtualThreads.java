class VirtualThreads {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= 100000; i++) {
            int threadNumber = i;
            Thread.startVirtualThread(() -> {
                if (threadNumber <= 10) {
                    System.out.println("Virtual thread " + threadNumber + " running");
                }
            });
        }

        Thread.sleep(1000);

        long endTime = System.currentTimeMillis();
        System.out.println("Launched 100000 virtual threads.");
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }
}
