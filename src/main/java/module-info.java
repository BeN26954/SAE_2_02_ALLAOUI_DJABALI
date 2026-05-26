module code_sae.sae {
    requires javafx.controls;
    requires javafx.fxml;


    opens code_sae.sae to javafx.fxml;
    exports code_sae.sae;
}