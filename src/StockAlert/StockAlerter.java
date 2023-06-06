package StockAlert;

public class StockAlerter {
    /** Stocks under radar:
     * TSLA, crm salesforce stock, MSFT, tsmc stock, NVDA, shopify stock
     * @param args
     */

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        StocksToWatch[] stocksToWatch = new StocksToWatch[6];
        stocksToWatch[0] = new StocksToWatch("TSLA", 160);
        stocksToWatch[1] = new StocksToWatch("crm salesforce stock", 180);
        stocksToWatch[2] = new StocksToWatch("MSFT", 200);
        stocksToWatch[3] = new StocksToWatch("tsmc stock", 480);
        stocksToWatch[4] = new StocksToWatch("NVDA", 300);
        stocksToWatch[5] = new StocksToWatch("shopify stock", 65);

        System.out.println("Stocks to watch:");
        for (int i = 0; i < stocksToWatch.length; i++) {
            int currentValue = 170;
            if (stocksToWatch[i].getTargetBuyValue() <= currentValue) {
                System.out.println(ANSI_BLUE+"Not a right time to buy this stock :" + stocksToWatch[i]+ANSI_RESET);
                //send out email: https://www.oracle.com/java/technologies/javamail.html
                // good to start with email: https://www.tutorialspoint.com/javamail_api/javamail_api_send_html_in_email.htm
                // sms to notify customer: https://www.twilio.com/docs/sms/quickstart/java, costs and a bit more complex.

            } else {
                System.out.println(ANSI_GREEN+"This stock to buy: " + stocksToWatch[i] + ", current value: " + currentValue+ANSI_RESET);
            }

        }
    }
}
