package model;

import controller.PlataformaController;
import controller.Utilitario;
import model.Backup.SalvarObjeto;
import model.Usuarios.Streamer;
import model.Usuarios.Viewer;
import view.PlataformaView;

import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Plataforma {

    // Constantes
    private static final String VIEWER_FILE_PATH = "src/model/Backup/viewerSalvo.obj";
    private static final String STREAMER_FILE_PATH = "src/model/Backup/streamerSalvo.obj";
    private static final String VOD_FILE_PATH = "src/model/Backup/vodSalvo.obj";

    // Listas de objetos
    public static List<Viewer> viewers = new ArrayList<>();
    public static List<Streamer> streamers = new ArrayList<>();
    public static List<Vod> vods = new ArrayList<>();
    public static List<Vod> vodJogos = new ArrayList<>();
    public static List<Vod> vodConversa = new ArrayList<>();
    public static List<Vod> vodEstudo = new ArrayList<>();

    // Adicionar contas iniciais
    public static void addContas() {
        Streamer pelfs = new Streamer(true, "eoselfs@tmail.com", "segredo", "Pelfs", 1500000, viewers);
        Streamer bitcel = new Streamer(false, "bitcel@tmail.com", "segredo", "Bitcel", 2000000, viewers);
        Streamer aaronzuka = new Streamer(true, "aaronzuka69@tmail.com", "segredo", "Aaronzuka", 3000000, viewers);
        Streamer notathingshow = new Streamer(false, "notalive@tmail.com", "segredo", "NotaThingShow", 29, viewers);
        Streamer marcojogador = new Streamer(true, "Markplier@tmail.com", "segredo", "Marcojogador", 606000, viewers);

        streamers.add(pelfs);
        streamers.add(bitcel);
        streamers.add(aaronzuka);
        streamers.add(notathingshow);
        streamers.add(marcojogador);

        Viewer teste = new Viewer("teste@tmail.com", "a", "a", streamers);
        viewers.add(teste);
    }

    // Verificar conta por nickname e senha
    public static void verificarConta(String nick, String senha) {
        for (Streamer streamer : streamers) {
            if (streamer.getNickname().equals(nick) && streamer.getSenha().equals(senha)) {
                System.out.println("# Conectado com sucesso #");
                PlataformaView.homeStreamerView(streamer);
                return;
            }
        }

        for (Viewer viewer : viewers) {
            if (viewer.getNickname().equals(nick) && viewer.getSenha().equals(senha)) {
                System.out.println("# Conectado com sucesso #");
                PlataformaView.homeViewer(viewer);
                return;
            }
        }

        System.out.println("# Nome de usuário ou senha incorretos. #");
        PlataformaView.inicioView();
    }

    // Criar conta Viewer
    public static void criarContaViewer(String email, String senha, String nick) {
        Viewer novoViewer = new Viewer(email, senha, nick, null);
        viewers.add(novoViewer);
        SalvarObjeto.salvarViewer(novoViewer, VIEWER_FILE_PATH);

        System.out.println("# Usuário criado com sucesso! #");
        PlataformaView.homeViewer(novoViewer);
    }

    // Verificar se email já está em uso
    public static String verificarEmail(String email) {
        while (emailJaEmUso(email)) {
            System.out.println("# Esse e-mail já está em uso! #");
            email = Utilitario.getInputString("Digite outro e-mail ou realize o login: ");
        }
        return email;
    }

    private static boolean emailJaEmUso(String email) {
        return viewers.stream().anyMatch(viewer -> viewer.getEmail().equals(email)) ||
               streamers.stream().anyMatch(streamer -> streamer.getEmail().equals(email));
    }

    // Verificar se nickname já está em uso
    public static String verificarNick(String nick) {
        while (nickJaEmUso(nick)) {
            System.out.println("# Esse nome já está em uso! #");
            nick = Utilitario.getInputString("Insira outro nome de usuário: ");
        }
        return nick;
    }

    private static boolean nickJaEmUso(String nick) {
        return viewers.stream().anyMatch(viewer -> viewer.getNickname().equals(nick)) ||
               streamers.stream().anyMatch(streamer -> streamer.getNickname().equals(nick));
    }

    // Criar conta Streamer
    public static void criarContaStreamer(String email, String senha, String nick) {
        Streamer novoStreamer = new Streamer(false, email, senha, nick, 0, null);
        streamers.add(novoStreamer);
        SalvarObjeto.salvarStreamer(novoStreamer, STREAMER_FILE_PATH);

        System.out.println("# Usuário criado com sucesso! #");
        PlataformaView.homeStreamerView(novoStreamer);
    }

    // Mostrar canais ao vivo
    public static void mostrarCanaisAoVivo() {
        System.out.println("");
        streamers.stream().filter(Streamer::getLive).forEach(s -> System.out.println("Canal: " + s.getNickname()));
        System.out.println("");
    }

    // Assistir live
    public static void assistirLive(Viewer viewer, String nick) {
        for (Streamer s : streamers) {
            if (s.getNickname().equals(nick)) {
                System.out.println("\n# Você está assistindo ao canal: " + s.getNickname());
                System.out.println("### Digite '!sub' para se inscrever, '!sair' para sair da live ###\n");
                Chat.chat(s, viewer);
                return;
            }
        }
        System.out.println("# Canal não encontrado #");
    }

    // Mostrar canais inscritos
    public static void mostrarCanaisInscritos(Viewer viewer) {
        System.out.print(viewer);
        if (viewer.getCanaisInscritos().isEmpty()) {
            PlataformaView.homeViewer(viewer);
        } else {
            PlataformaController.entrarNoCanalControl(viewer);
        }
    }

    // Verificar streamer por nick
    public static void verificarStreamerPorNick(Viewer viewer, String nick) {
        for (Streamer streamer : viewer.getCanaisInscritos()) {
            if (streamer.getNickname().equals(nick)) {
                System.out.println("# Canal encontrado");
                PlataformaView.dentroDoCanalInscrito(viewer, streamer);
                return;
            }
        }
        System.out.println("# Canal inválido, verifique se digitou corretamente #");
        PlataformaController.entrarNoCanalControl(viewer);
    }

    // Inscrever no canal
    public static void inscreverNoCanal(Viewer viewer, Streamer streamer) {
        viewer.getCanaisInscritos().add(streamer);
        addInscrito(streamer, viewer);
        System.out.println("\n# Se inscreveu :D #\n");
        mostrarCanaisInscritos(viewer);
    }

    // Desinscrever do canal
    public static void desinscreverDoCanal(Viewer viewer, Streamer streamer) {
        viewer.getCanaisInscritos().remove(streamer);
        removerInscrito(streamer, viewer);
        System.out.println("\n# Se desinscreveu D: #\n");
        PlataformaView.dentroDoCanalNaoInscrito(viewer, streamer);
    }

    // Adicionar inscrito
    public static void addInscrito(Streamer streamer, Viewer viewer) {
        streamer.getInscritos().add(viewer);
        streamer.adicionarUmIscrito();
    }

    // Remover inscrito
    public static void removerInscrito(Streamer streamer, Viewer viewer) {
        streamer.getInscritos().remove(viewer);
        streamer.removerUmInscrito();
    }

    // Buscar canais
    public static void buscarCanais(Viewer viewer) {
        streamers.forEach(streamer -> {
            String status = streamer.getLive() ? "Canais em live: " : "Canais OffStream: ";
            System.out.println("# " + status + streamer.getNickname());
        });
        PlataformaView.homeViewer(viewer);
    }

    // Remover viewer
    public static void removerViewer(Viewer viewer) {
        viewers.remove(viewer);
        PlataformaView.inicioView();
    }

    // Remover streamer
    public static void removerStreamer(Streamer streamer) {
        streamers.remove(streamer);
        PlataformaView.inicioView();
    }

    // Mostrar analytics
    public static void mostrarAnalytics(Streamer streamer) {
        System.out.println(streamer);
        System.out.println("\n# Quantidade de Lives feitas: " + contarVods(streamer) + " #\n");
        PlataformaView.homeStreamerView(streamer);
    }

    // Contar VODs
    public static int contarVods(Streamer streamer) {
        int cont = 0;
        for (Vod v : vods) {
            if (streamer.equals(v.getStreamer())) {
                cont++;
                System.out.println(v);
            }
        }
        return cont;
    }

    // Adicionar VODs
    public static void adicionarVodJogos(Vod vod) {
        vodJogos.add(vod);
        vods.add(vod);
    }

    public static void adicionarVodConversa(Vod vod) {
        vodConversa.add(vod);
        vods.add(vod);
    }

    public static void adicionarVodEstudo(Vod vod) {
        vodEstudo.add(vod);
        vods.add(vod);
    }

    // Reviver objetos
    public static Streamer reviverStreamer(String caminho) {
        return (Streamer) reviverObjeto(caminho, "Streamer");
    }

    public static Viewer reviverViewer(String caminho) {
        return (Viewer) reviverObjeto(caminho, "Viewer");
    }

    public static Vod reviverVod(String caminho) {
        return (Vod) reviverObjeto(caminho, "Vod");
    }

    private static Object reviverObjeto(String caminho, String tipo) {
        try (FileInputStream fileIn = new FileInputStream(caminho);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            Object objetoRevivido = objectIn.readObject();
            System.out.println("\n# " + tipo + " revivido com sucesso de " + caminho + " #\n");
            return objetoRevivido;
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + caminho);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("# Não deu pra reviver #");
        }
        return null;
    }

    public static void reviverContas() {
        System.out.println("#######################");
        Streamer streamerRevivido = reviverStreamer(STREAMER_FILE_PATH);
        Viewer viewerRevivido = reviverViewer(VIEWER_FILE_PATH);
        Vod vodRevivido = reviverVod(VOD_FILE_PATH);

        if (streamerRevivido != null) {
            System.out.println("# Revivido: " + streamerRevivido.getNickname());
        }

        if (viewerRevivido != null) {
            System.out.println("# Revivido: " + viewerRevivido.getNickname());
        }

        if (vodRevivido != null) {
            System.out.println("# Revivido: " + vodRevivido);
        }

        PlataformaView.inicioView();
    }
}
