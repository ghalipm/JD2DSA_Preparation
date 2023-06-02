package StockAlert;

public class StockAlerter {
    public static void main(String[] args) {
        StocksToWatch[] stocksToWatch = new StocksToWatch[6];
        stocksToWatch[0] = new StocksToWatch();
        stocksToWatch[0].stockName = "TSLA";
        stocksToWatch[1] = new StocksToWatch();
        stocksToWatch[1].stockName = "crm salesforce stock";
        stocksToWatch[2] = new StocksToWatch();
        stocksToWatch[2].stockName = "MSFT";
        stocksToWatch[3] = new StocksToWatch();
        stocksToWatch[3].stockName = "tsmc stock";
        stocksToWatch[4] = new StocksToWatch();
        stocksToWatch[4].stockName = "NVDA";
        stocksToWatch[5] = new StocksToWatch();
        stocksToWatch[5].stockName = "shopify stock";

        System.out.println("Stocks to watch:");
        for (int i = 0; i < stocksToWatch.length; i++) {
            System.out.println(stocksToWatch[i].stockName);
        }
    }
}
