class Accountant{
    public static int sum(int x, int y) {
        ParallelCalculator calculator = new ParallelCalculator((operand1, operand2) -> operand1 + operand2, x, y);
        Thread thread = new Thread(calculator);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return calculator.result;
    }
}
