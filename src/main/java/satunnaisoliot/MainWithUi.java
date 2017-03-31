
package satunnaisoliot;
import java.awt.EventQueue;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import ui.UI;

public class MainWithUi {
    public static void main(String[] args) {
        setUpUserInterface();
        
    }
    
    private static void setUpUserInterface(){
        UI userInt = new UI();
        userInt.setTitle("viiteohjelma");
        userInt.setSize(500, 600);
        userInt.setLocationRelativeTo(null);
        userInt.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        EventQueue.invokeLater(() -> userInt.setVisible(true));
    }
}
