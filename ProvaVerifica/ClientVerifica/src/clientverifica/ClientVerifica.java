    package clientverifica;

    import javafx.application.Application;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.stage.Stage;

    /**
     *
     * @author Florian
     */
    public class ClientVerifica extends Application {

        @Override
        public void start(Stage stage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("finestra.fxml"));
            Scene scene = new Scene(root);

            stage.setTitle("Verifica Client-Socket Trevisan Francesco");
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }
