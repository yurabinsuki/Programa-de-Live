package controller;
import view.VodView;

public class VodController {
    
    public static String definirCategoriaControl(){
        VodView.definirCategoriaView();

        int resp = Utilitario.getInputInt("# Digite: ");

        String categoria = "";
        switch (resp) {
            case 1:
                categoria = "JOGOS";
                break;
            case 2:
                categoria = "CONVERSA";
                break;
            case 3:
                categoria = "ESTUDO";
                break;
            default:
            System.out.println("# Categoria inválida, escolha entre [1, 2 e 3] #");
            definirCategoriaControl();
                break;
        }

        return categoria;

    }


}
