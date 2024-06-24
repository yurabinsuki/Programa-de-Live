import Classes.Usuarios.Streamer;
import Classes.Usuarios.Viewer;
import java.util.ArrayList;
import java.util.List;

public class Main {

    //Rolagem de comentarios aleatorios 1% de chance do ze na asianbunnyx
    //Contador de tempo stremado da live (a cada 20 segndos)
    //Ping de doações fakes
    //Ping de Inscrições
    //"On live" e "OffStream"


    public static void main(String[] args) throws Exception {

        List<Viewer> viewers = new ArrayList<>();
        List<Streamer> streamers = new ArrayList<>();

        Viewer viewer1 = new Viewer("asas", "asas", "asas", streamers);

        Streamer testStreamer = new Streamer(false, "aaa@a.com", "senha", "streamer", 0, 0, null);
        Streamer testStreamer2 = new Streamer(false, "bbb@a.com", "senha", "streamer2", 0, 0, null);

        System.out.println(testStreamer);
        System.out.println(testStreamer.getId());
        System.out.println(testStreamer2.getId());

        List<Streamer> canaisViewer1 = new ArrayList<>();
        canaisViewer1.add(testStreamer);
        canaisViewer1.add(testStreamer2);

        Viewer testViewer = new Viewer("askdsdk", "asdasd", "robertinho", canaisViewer1);

        System.out.println(testViewer);
        //System.out.print(testViewer);
        System.out.println(testStreamer);
        testStreamer.addInscrito(viewer1);

        System.out.println("\nApós\n");

        System.out.println(testStreamer);
        testStreamer.rmvInscrito("robertinho");

        System.out.println("\nApós\n");

        System.out.println(testStreamer);

        testStreamer.abrirLive();
        testStreamer.chat();
    }
}
