package it.unibo.mvc;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private final Controller controller = new Controller();
    private final JFrame frame = new JFrame();
    private final JPanel canvas = new JPanel(new BorderLayout());
    private final JTextArea textArea = new JTextArea();
    private final JButton saveButton = new JButton("Save");

    /**
     * constructor.
     */
    public SimpleGUI() {
        canvas.add(textArea, BorderLayout.CENTER);
        canvas.add(saveButton, BorderLayout.SOUTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
     * show the window.
     * set the preffered size and layout for frame.
     */
    public void display() {
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Starts the graphical application.
     */
    public void main() {
        final SimpleGUI textPanel = new SimpleGUI();
        textPanel.display();
    }

}

