package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class Controller {

    @FXML
    TextField tfID, tfBName, tfAID, tfAName;

    @FXML
    VBox itemHolder = new VBox();

    @FXML
    Button btnDel, btnAdd;

    public void addManyItems(List<Book> list){
        for(Book i : list){
            addItem(i);
        }
    }
    public void addItem(Book book){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Item.fxml"));
            Node node = loader.load();
            Item itemController = loader.getController();
            itemController.setBook(book);
            itemHolder.getChildren().add(node);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void removeAll(){
        for (int i = itemHolder.getChildren().size() - 1; i >= 0; i--){
            itemHolder.getChildren().remove(i);
        }
    }
    public void addNewItem(ActionEvent event){
        Author author = new Author(
            Integer.parseInt(this.tfAID.getText()),
            this.tfAName.getText()
        );
        Book book = new Book(
                Integer.parseInt(this.tfID.getText()),
                this.tfBName.getText(),
                author
        );
        addItem(book);
    }
}
