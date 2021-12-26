package home;

import Cart.ShoppingCart;
import home.Product;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import javax.swing.text.Element;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HomeController {

    @FXML
    private GridPane productGridPane;

    @FXML
    public void initialize() throws FileNotFoundException {
        productGridPane.getChildren().clear();
        VBox productView1=productView(Product.ALPENGOLD);
        productGridPane.add(productView1,0,0);

        VBox productView2=productView(Product.MILK);
        productGridPane.add(productView2,1,0);

        VBox productView3=productView(Product.LAYS);
        productGridPane.add(productView3,2,0);

        VBox productView4=productView(Product.FANTA);
        productGridPane.add(productView4,0,1);

        VBox productView5=productView(Product.COLA);
        productGridPane.add(productView5,1,1);

        VBox productView6=productView(Product.PALMOLIVE);
        productGridPane.add(productView6,2,1);

        VBox productView7=productView(Product.PRINGLES);
        productGridPane.add(productView7,0,2);

        VBox productView8=productView(Product.TIDE);
        productGridPane.add(productView8,1,2);

        VBox productView9=productView(Product.ICECREAM);
        productGridPane.add(productView9,2,2);


    }
    private VBox productView(Product product) throws FileNotFoundException{
        VBox layout=new VBox();
        layout.setAlignment(Pos.CENTER);

        FileInputStream input= new FileInputStream("C:\\Users\\Александр\\IdeaProjects\\main\\src\\img\\"+product.getImageFile());
        Image image= new Image(input);
        ImageView imageView= new ImageView(image);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        Label productName=new Label(product.name());
        Label price=new Label(product.getPrice()+"KGS");
        Button addButton= new  Button ("Add to Cart");
        addButton.setUserData(product.name());

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Node sourceComponent =(Node)actionEvent.getSource();
                String productName= (String)sourceComponent.getUserData();
                ShoppingCart shoppingCart= ShoppingCart.getInstance();
                shoppingCart.addProduct(product.name());
            }
        });

        layout.getChildren().addAll(imageView,productName,price,addButton);
        return layout;

    }
}