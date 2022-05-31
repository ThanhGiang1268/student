/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_contact_app;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.*;

/**
 *
 * @author Administrator
 */
public class Myfunc {

    public ImageIcon setsizePic(String picPath, byte[] BLOBpic, int width, int height) {
        ImageIcon myImg;
        if (picPath != null) {
            myImg = new ImageIcon(picPath);
        } else {
            myImg = new ImageIcon(BLOBpic);
        }

        Image img = myImg.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon myPicture = new ImageIcon(img);
        return myPicture;
    }

    public String browseImage(JLabel lbl) {
        String path = "";
        JFileChooser filec = new JFileChooser();
        filec.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("*.image", "png", "jpg", "gif");
        filec.addChoosableFileFilter(fileFilter);

        int fileState = filec.showSaveDialog(null);

        if (fileState == JFileChooser.APPROVE_OPTION) {
            File selectedFile = filec.getSelectedFile();
            path = selectedFile.getAbsolutePath();

            lbl.setIcon(setsizePic(path, null, lbl.getWidth(), lbl.getHeight()));

        } else if (fileState == JFileChooser.CANCEL_OPTION) {
            System.out.println("No image selected");
        }
        return path;
    }
}
