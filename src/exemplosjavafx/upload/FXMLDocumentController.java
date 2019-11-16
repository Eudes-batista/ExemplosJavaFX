package exemplosjavafx.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private ImageView imageView;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("png,jpg,jpeg", "png", "jpg", "jpeg"));
        fileChooser.setTitle("Selecione uma imagem");

        File file = fileChooser.showOpenDialog(new Stage());

        if (file != null) {
            try {
                boolean upload = this.fazerUpload(file);
                if (upload) {
                    FileInputStream fileInputStream = new FileInputStream(new File("imagens/" + file.getName()));
                    this.imageView.setImage(new Image(fileInputStream));
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("SUCCESS");
                    alert.setContentText("Upload realizado com sucesso!!");
                    alert.show();
                }
            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText(ex.getMessage());
                alert.show();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private boolean fazerUpload(File fileImage) throws FileNotFoundException {
        try {
            Path path = Paths.get("imagens");
            if (Files.notExists(path)) {
                Files.createDirectory(path);
            }
            byte[] readAllBytes = Files.readAllBytes(fileImage.toPath());
            FileOutputStream fileOutputStream = new FileOutputStream(path.toFile().getAbsolutePath() + "/" + fileImage.getName());
            fileOutputStream.write(readAllBytes);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

}
