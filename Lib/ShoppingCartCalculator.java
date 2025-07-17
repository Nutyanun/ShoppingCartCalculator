import java.util.ArrayList;

public class ShoppingCartCalculator {

    /**
     * ฟังชันก์สำหรับการคำนวณราคาสุทธิของสินค้าในตะกร้า โดย 1 ตะกร้ามีได้หลายสินค้า และมีเงื่อนไขว่าถ้าหากตะกร้าเป็น null หรือ empty ตะกร้าจะรีเทิร์น 0.0
     * ในส่วนของกฎส่วนลด BOGO จะเป็นโปรโมชั่นซื้อ 1 แถม 1 หากซื้อสินค้าที่มีรหัส BOGO สองชิ้น ตะกร้าจะรีเทิร์นราคาสินค้า 1 ชิ้น สุดท้ายส่วนลด BULK จะเป็น
     * โปรโมชั่นซื้อตั้งแต่ 6 ชิ้นขึ้นไป จะได้รับส่วนลด 10% จากราคารวมของสินค้า หากซื้อสินค้าที่มีรหัส BULK 6 ชิ้น ตะกร้าจะรีเทิร์น ราคารวมสินค้า 6 ชิ้นที่ลบกับส่วนลด 10% ของราคารวมสินค้า 6 ชิ้น
     * @param sku คือรหัสการซื้อ 
     * @param name คือชื่อสินค้า
     * @param price คือราคาต่อชิ้น
     * @param quantity  คือจำนวนที่ซื้อ ที่จะนำไปคำนวณราคา
     * @return ราคาสุทธิของสินค้าในตะกร้า
     */
    public static double calculateTotalPrice(ArrayList<CartItem> items) {
        double total = 0 ;
        if(items == null || items.isEmpty()){
            return 0.0 ;
        }

        for(int i = 0 ; i < items.size() ; i++){
            double price = 0.00 ;
            int quantity = 0 ;

            if("BOGO" == items.get(i).sku()){
                quantity = items.get(i).quantity()/2 ;
                price = quantity*items.get(i).price();
            }
            else if("BULK" == items.get(i).sku()){
                if(items.get(i).quantity() >=6){
                    price = (items.get(i).price()*items.get(i).quantity())*0.9 ; 
                } 
                else{
                    price = (items.get(i).price()*items.get(i).quantity()) ;
                }
            }
            else{
                price = items.get(i).price()*items.get(i).quantity();
            }
            total += price;
        }
        
        return total;
    }
}