import java.util.HashMap;
import java.util.Map;

public class OrderItem {
	private Map<Product, Integer> items;
	public OrderItem( Map<Product, Integer> items) {
		this.items = new HashMap<>(items);
	}
	public double calculateTotal() {
		double total = 0.0;
		
		for(Map.Entry<Product, Integer> entry: items.entrySet()) {
			Product product = entry.getKey();
			int quantity = entry.getValue();
			total += product.getPrice()*quantity;
		}
		return total;
	}
}