package StockAlert;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StocksToWatch {
    String stockName;
    int targetBuyValue;
}
