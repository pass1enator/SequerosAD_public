package ies.pedro.sequerosgoogle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SequerosGoogleController {
    public MenuItem select;
    public VBox principal;
    public TableView tableView;
    public TextField textFieldSearch;
    public Button buttonSearch;
    public MenuItem load;
    public MenuItem saveAs;
    public MenuItem exit;
    public MenuItem newIndex;
    private Index index;
    private Stage primaryStage;
    private ObservableList<Reference> listado;
    private Alert a;

    public void initialize() {
        this.index = new Index();
        a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("File Error");
        FileChooser fileChooser1 = new FileChooser();
        fileChooser1.setInitialDirectory(new File("./"));
        this.select.setOnAction(actionEvent -> {
            final FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("TXT", "*.txt")

            );
            List<File> files = fileChooser.showOpenMultipleDialog(this.principal.getScene().getWindow());
            if (files != null) {

                try {
                    this.index.addFilestoIndex(files);
                } catch (FileNotFoundException e) {
                    a.setContentText(e.getMessage());
                }
            }
        });
        this.saveAs.setOnAction(
                actionEvent -> {
                    final FileChooser fileChooser = new FileChooser();
                    fileChooser.getExtensionFilters().addAll(
                            new FileChooser.ExtensionFilter("TXT", "*.txt")

                    );
                    File file = fileChooser.showSaveDialog(this.principal.getScene().getWindow());
                    if (file != null) {
                        try {
                            this.index.saveIndex(file);
                        } catch (IOException e) {
                            a.show();
                        }
                    }
                }
        );
        this.exit.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });
        this.newIndex.setOnAction(actionEvent -> {
            if (this.index != null)
                this.index.clear();
        });
        this.load.setOnAction(actionEvent -> {
            final FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("TXT", "*.txt")

            );
            File file = fileChooser.showOpenDialog(this.principal.getScene().getWindow());
            if (file != null) {
                this.index.loadIndex(file);
            }
        });
        this.configTable();
        this.configSearch();
    }

    private void configSearch() {
        this.buttonSearch.setOnMouseClicked(mouseEvent -> {
            //se busca, se borra el listado y se ponen los nuevos
            String word = textFieldSearch.getText().toString().toLowerCase();
            ArrayList<Reference> l = this.index.findWord(word);
            this.listado.clear();
            if (l != null)
                this.listado.addAll(l);
        });
    }

    private void configTable() {
        listado = FXCollections.observableArrayList();
        TableColumn<Reference, String> fileCol = new TableColumn<>("File");
        TableColumn<Reference, Double> positionCol = new TableColumn<>("Position");
        TableColumn<Reference, String> contextCol = new TableColumn<>("Context");

        // Establecer cómo obtener los valores para cada columna
        fileCol.setCellValueFactory(new PropertyValueFactory<>("filename"));
        positionCol.setCellValueFactory(new PropertyValueFactory<>("position"));
        contextCol.setCellValueFactory(new PropertyValueFactory<>("resume"));

        // Añadir las columnas al TableView
        this.tableView.getColumns().addAll(fileCol, positionCol, contextCol);
        this.tableView.setItems(listado);
    }
}