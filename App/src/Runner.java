import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Arrays;


public class Runner extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Group backG = new Group();
        Scene backS = new Scene(backG, 320, 240);

        String CheckString = "java";

        Text disp = new Text("____");
        disp.setX(75);
        disp.setY(50);

        TextField tf = new TextField();
        EventHandler<ActionEvent> check = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                disp.setText(checkLet(tf.getText(), CheckString, disp.getText()));
            }
        };
        tf.setMaxWidth(40);
        tf.setLayoutY(100);
        tf.setLayoutX(100);
        tf.setOnAction(check);


        backG.getChildren().add(disp);
        backG.getChildren().add(tf);
        stage.setScene(backS);
        stage.show();
    }

    public String checkLet(String s, String cs, String ds){
        if(!cs.contains(s)){
            return ds;
        }
        int[] indexArr = getIndex(s, cs);
        int spot = 0;
        for(int i : indexArr){
            ds += ds.substring(0, indexArr[spot]) +  cs.substring(indexArr[spot], indexArr[spot]+1) + ds.substring(indexArr[spot]+1);
            System.out.println(spot);
            System.out.println(ds);
            spot++;
        }
        return ds;
    }

    public int[] getIndex(String s, String cs){
        int length = 0;

        int index = cs.indexOf(s);
        while (index != -1) {
            index = cs.indexOf(s, index + 1);
            length++;
        }

        int[] indexArr = new int[length];

        int spot = 0;

        index = cs.indexOf(s);
        while (index != -1) {
            indexArr[spot] = index;
            index = cs.indexOf(s, index + 1);
            spot++;
        }

        return indexArr;
    }
}
