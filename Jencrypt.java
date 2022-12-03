import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Jencrypt{

    public static void operate(int key){

        JFileChooser filechooser = new JFileChooser();
        filechooser.showOpenDialog(null);
        File file = filechooser.getSelectedFile();
        try{
            FileInputStream fis = new FileInputStream(file);
            byte []data = new byte[fis.available()];
            fis.read(data);
            int i = 0;
            for(byte b : data){
                System.out.println(b);
                data[i] = (byte)(b ^ key);
                i++;
            }

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Encryption Done");

        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args){
        
        JFrame frame = new JFrame();
        frame.setTitle("Image Encryption");
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Roboto",Font.BOLD,25);
        JButton button = new JButton();
        button.setText("Open Img");
        button.setFont(font);

        JTextField textfield = new JTextField(10);
        textfield.setFont(font);
        frame.setLayout(new FlowLayout());

        button.addActionListener(e->{
            System.out.println("Button Clicked");
            String text = textfield.getText();
            int temp = Integer.parseInt(text);
            operate(temp);
        });

        frame.add(button);
        frame.add(textfield);

        frame.setVisible(true);

    }
}