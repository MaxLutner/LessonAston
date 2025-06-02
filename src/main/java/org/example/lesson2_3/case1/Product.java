package org.example.lesson2_3.case1;

public class Product {
    private String productionName;
    private String productionData;
    private String productor;
    private String originCountry;
    private float price;
    private Boolean bookingStatus;
    public Product(String productionName, String productionData, String productor, String originCountry, float price, Boolean bookingStatus){
        this.productionName=productionName;
        this.productionData=productionData;
        this.productor=productor;
        this.originCountry=originCountry;
        this.price=price;
        this.bookingStatus=bookingStatus;
    }
    public void getProduct(){
        System.out.println("Название: "+productionName);
        System.out.println("Дата производства: " +productionData);
        System.out.println("Производитель: "+productor);
        System.out.println("Страна происхождения: "+originCountry);
        System.out.println("Цена: "+price);
        System.out.println("Забронирован покупателем: " +bookingStatus);
        System.out.println("-----------------------------------");

    }
}
