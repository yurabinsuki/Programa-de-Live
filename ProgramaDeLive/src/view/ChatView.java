package view;

import model.Usuarios.Viewer;

public class ChatView {
    
    public static void subView(Viewer viewer){
        System.out.println("\n# " + viewer.getNickname() + " Deu um SUB! #\n");
    }
}
