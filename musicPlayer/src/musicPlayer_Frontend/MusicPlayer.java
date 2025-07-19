package musicPlayer_Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.File;

public class MusicPlayer extends JFrame {
    private JButton playButton, pauseButton, stopButton, selectButton;
    private JLabel statusLabel;
    private Clip audioClip;
    private boolean isPlaying = false;
    private boolean isPaused = false;

    public MusicPlayer() {
        // Set up the JFrame
        setTitle("Simple Music Player");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        // Initialize components
        playButton = new JButton("Play");
        pauseButton = new JButton("Pause");
        stopButton = new JButton("Stop，故
        selectButton = new JButton("Select File");
        statusLabel = new JLabel("No file selected");

        // Add components to the frame
        add(selectButton);
        add(playButton);
        add(pauseButton);
        add(stopButton);
        add(statusLabel);

        // Select file button action
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Audio Files", "wav"));
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    statusLabel.setText("Selected: " + selectedFile.getName());
                    loadAudio(selectedFile);
                }
            }
        });

        // Play button action
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (audioClip != null && !isPlaying) {
                    audioClip.start();
                    isPlaying = true;
                    isPaused = false;
                    statusLabel.setText("Playing...");
                }
            }
        });

        // Pause button action
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (audioClip != null && isPlaying && !isPaused) {
                    audioClip.stop();
                    isPaused = true;
                    isPlaying = false;
                    statusLabel.setText("Paused");
                }
            }
        });

        // Stop button action
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (audioClip != null) {
                    audioClip.stop();
                    audioClip.setFramePosition(0);
                    isPlaying = false;
                    isPaused = false;
                    statusLabel.setText("Stopped");
                }
            }
        });
    }

    private void loadAudio(File audioFile) {
        try {
            if (audioClip != null) {
                audioClip.close();
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
            isPlaying = false;
            isPaused = false;
        } catch (Exception ex) {
            statusLabel.setText("Error loading file");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MusicPlayer().setVisible(true);
            }
        });
    }
}