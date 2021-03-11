import java.util.Scanner;
import java.util.Arrays;
class Hotel{
    private int regNo;
    private String hotelName;
    private String roomType;
    private int price;
    private boolean wifiFacility;
    
    public boolean getWifiFacility(){
        return this.wifiFacility;
    }
    public int getPrice(){
        return this.price;
    }
    public String getHotelName(){
        return this.hotelName;
    }
    public String getRoomType(){
        return this.roomType;
    }
    public Hotel(int no, String name, String type, int price, boolean wifi){
        this.regNo = no;
        this.hotelName = name;
        this.roomType= type;
        this.price = price;
        this.wifiFacility = wifi;
    }
    
}
public class MyClass{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        Hotel[] hotels = new Hotel[4];
        for(int i =0;i<4;i++){
            int no = sc.nextInt(); sc.nextLine();
            String name = sc.nextLine();
            String type = sc.nextLine();
            int price = sc.nextInt(); sc.nextLine();
            boolean wifi = sc.nextBoolean(); sc.nextLine();
            hotels[i] = new Hotel(no, name, type,price,wifi);
            
        }
        String roomType = sc.nextLine();
        
        double res1 = findAveragePriceForGivenType(hotels, roomType);
        if(res1>0) System.out.println(res1);
        else System.out.println("No Such Hotel.");
        
        Hotel res2 = findHotelWithSecondHighestPackagePrice(hotels);
        if(res2 == null) System.out.println("No wifi available.");
        else System.out.println(res2.getHotelName() +"\n"+ res2.getPrice());
        
    }
    public static double findAveragePriceForGivenType(Hotel[] hotels,String roomType){
        double sum = 0;
        double count=0;
        for(Hotel hotel:hotels){
            if(roomType.equalsIgnoreCase(hotel.getRoomType()) && hotel.getWifiFacility()){
                sum = sum + hotel.getPrice();
                count++;
            }
        }
        if(count == 0) return count;
        else return sum/count;
    }
    public static Hotel findHotelWithSecondHighestPackagePrice(Hotel[] hotels){
        Hotel[] result = new Hotel[0];
        for(Hotel hotel:hotels){
            if(hotel.getWifiFacility()){
                result = Arrays.copyOf(result, result.length+1);
                result[result.length-1] = hotel;
            }
        }
        for(int i = 0;i<result.length-1;i++){
            for(int j = i+1;j<result.length;j++){
                if(result[i].getPrice()<result[j].getPrice()){
                    Hotel temp = result[i];
                    result[i]=result[j];
                    result[j] = temp;
                }
            }
        }
        if(result.length !=0) return result[1];
        else return null;
    }
}
