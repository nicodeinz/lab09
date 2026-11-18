package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
/**
 * A very simple program using a graphical interface.
 * 
 */

public final class SimpleGUIWithFileChooser {

    private final Controller controller = new Controller();
    private final JFrame frame = new JFrame();
    private final JPanel upper = new JPanel(new BorderLayout());
    private final JPanel canvas = new JPanel(new BorderLayout());
    private final JTextField textUp = new JTextField();
    private final JButton browse = new JButton("browse");
    private final JTextArea textArea = new JTextArea();
    private final JButton saveButton = new JButton("Save");

    /**
     * create the new interface.
     */
    public SimpleGUIWithFileChooser() {
        textUp.setEditable(false);
        textUp.setText(controller.getPathString());

        upper.add(textUp, BorderLayout.CENTER);
        upper.add(browse, BorderLayout.LINE_END);

        canvas.add(upper, BorderLayout.NORTH);
        canvas.add(textArea, BorderLayout.CENTER);
        canvas.add(saveButton, BorderLayout.SOUTH);

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        browse.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser chooser = new JFileChooser();
                final int result = chooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    controller.setFile(chooser.getSelectedFile());
                    textUp.setText(controller.getPathString());
                } else if (result != JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(frame, "An error has occurred", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.write(textArea.getText());
                } catch (final IOException ex) {
                    JOptionPane.showMessageDialog(
                        frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }

    /**
     * view the interface.
     * */
    public void display() {
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * main.
     * */
    public static void main() {
        new SimpleGUIWithFileChooser().display();
    }

}
