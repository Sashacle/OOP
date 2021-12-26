package home;

public enum Product {
    ALPENGOLD("alpengold.jpg",80),MILK("milk.png",105),LAYS("lays.jpg",90), FANTA("fanta.png",50),COLA("cola.png",85), PALMOLIVE("palmolive.png",95),PRINGLES("pringles.png",110),TIDE("tide.png",115), ICECREAM("ice-cream.jpg",50);

    private String imageFile;
    private float price;

    Product(String imageFile,float price){
        this.imageFile = imageFile;
        this.price = price;
    }

    public String getImageFile() {
        return imageFile;
    }

    public float getPrice() {
        return price;
    }
}