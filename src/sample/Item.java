package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Item {
    @FXML
    Label lbID, lbBName, lbAName;

    @FXML
    Button btnSelect;

    private Book book;

    public Book getBook() {
        return book;
    }

    private int selectCount = 0;

    public void setBook(Book book) {
        this.book = book;
        this.lbID.setText(String.valueOf(book.getId()));
        this.lbBName.setText(book.getName());
        this.lbAName.setText(book.getAuthor().getName());
    }

    public void itemDetail(ActionEvent event){
        selectCount++;
        if(selectCount == 2){
            selectCount = 0;
            //open new detail view
            System.out.println("detail of book with id " + this.book.getId() );
        }
    }
    public void mouseExit(MouseEvent event){
        selectCount = 0;
    }
}
