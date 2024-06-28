package view;
import model.Vod;

public class VodView {


    public static void definirCategoriaView(){
        System.out.println("\n# Selecione a categoria da live: #");
        System.out.println("# 1. Jogos");
        System.out.println("# 2. Conversa");
        System.out.println("# 3. Estudo");
        System.out.println("####################################\n");
    }
    
    public static void mostrarVodView(Vod vod){
        System.out.println("\n#~~~~~~~~~~~~~~~~~~#");
        System.out.println("# Exibindo a live: " + vod.getTitulo() + " do Streamer: " + vod.getStreamer());
        System.out.println("#####################################\n");
    }
}
