package com.example.main.controller;

import com.example.main.dao.Data;
import com.example.main.model.Styles;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;

public class ConnectionController {
    //TextFields
    @FXML
    private PasswordField password;
    @FXML
    private TextField serverName;
    @FXML
    private TextField portNumber;
    @FXML
    private TextField dBName;
    @FXML
    private TextField userName;
    @FXML

    public void initialize(){
    }

    public void beginStart(){
        URL url = getClass().getResource("/com/example/main/addConnection.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        try {
            Parent root = loader.load();
            ConnectionController controller = loader.getController();
            //Setting id_textField to id.
            Stage stage = new Stage();
            stage.setTitle("Add Connection");
            Scene scene = new Scene(root);
            if(Styles.getTheme() == "Dark") {
                scene.getStylesheets().add(getClass().getResource("/com/example/main/css/style.css").toExternalForm());
            }
            stage.setScene(scene);
            //overloading default close operations
            stage.setOnCloseRequest(e->{
                e.consume();
                //Transferring closing protocols to Close_program()
                closeProgram(stage);
            });
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return boolean
     */
    public void saveButton(){
        if(validate()){
            Data.setServerName(serverName.getText());
            Data.setPort(portNumber.getText());
            Data.setDatabaseName(dBName.getText());
            Data.setUname(userName.getText());
            Data.setPasswd(password.getText());
            closeProgram((Stage) userName.getScene().getWindow());
        }
    }


    /**
     * Takes Stage instance as arg
     * This function takes a stage instance as argument and calls its close() function. This fixed an issue with calling
     * Close_program from within BeginStart() as a Stage instance with a value of null would be called instead.
     * @param stage Stage
     */
    public void closeProgram(Stage stage){
        stage.close();
    }

    public void cancelButton(){
        closeProgram((Stage) userName.getScene().getWindow());
    }

    public void testConnection(){
        if(validate()){
            Data.setServerName(serverName.getText());
            Data.setPort(portNumber.getText());
            Data.setDatabaseName(dBName.getText());
            Data.setUname(userName.getText());
            Data.setPasswd(password.getText());
            if(Data.checkConnection() != null){
                Error successBox = new Error();
                successBox.beginStart("Connection Succeeded!", "Success");
            }

//
//            try {
//                if (DataConnection.getDBName() != null) {
//                    ErrorDialogueBox errorDialogueBox = new ErrorDialogueBox();
//                    errorDialogueBox.BeginStart("Connection Succeeded!", "Connection Successfull");
//                }else{
//                    ErrorDialogueBox err = new ErrorDialogueBox();
//                    err.BeginStart("Error! Failed to connect to database");
//                }
//            }catch (Exception e){
//                ErrorDialogueBox err = new ErrorDialogueBox();
//                err.BeginStart("Error! Failed to connect to database");
//            }
//
//            //restoring previous state
//            DataConnection.setUname(uname);
//            DataConnection.setPasswd(passwd);
//            DataConnection.setServerName(server_Name);
//            DataConnection.setPort(port);
//            DataConnection.setDatabaseName(database_Name);
        }


    }
    public boolean validate(){
        if(serverName.getText() == null || serverName.getText().isEmpty()){
            genError("Error! 'Server' cannot be blank");
            serverName.setStyle("-fx-text-box-border: red");
        }

        else if(portNumber.getText() == null || portNumber.getText().isEmpty()){
            genError("Error! 'Port Number' cannot be blank");
            portNumber.setStyle("-fx-text-box-border: red");
            serverName.setStyle("");
        }

        else if(dBName.getText() == null || dBName.getText().isEmpty()){
            genError("Error! 'Database Name' cannot be blank");
            dBName.setStyle("-fx-text-box-border: red");
            serverName.setStyle("");
            portNumber.setStyle("");
        }

        else if(userName.getText() == null || userName.getText().isEmpty()){
            genError("Error! 'User Name' field cannot be blank");
            userName.setStyle("-fx-text-box-border: red");
            serverName.setStyle("");
            portNumber.setStyle("");
            dBName.setStyle("");
        }
        else {
            serverName.setStyle("");
            portNumber.setStyle("");
            dBName.setStyle("");
            userName.setStyle("");
            return true;
        }
        return false;
    }

    public void genError(String error){
        Error errorDialogueBox = new Error();
        errorDialogueBox.beginStart(error);
    }



}
