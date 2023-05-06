import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TamagotchiGUI extends JFrame implements ActionListener {
    private JLabel imageLabel;
    private JButton feedButton;
    private JButton sleepButton;
    private JButton playButton;
    private JLabel headerText;
    private JLabel statusText; // New label for status text
    private Pet pet; // Instance of the Pet class

    public TamagotchiGUI(Pet pet) {
        // Set the frame properties
        setTitle("Tamagotchi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setBackground(Color.LIGHT_GRAY);

        // Create the components
        imageLabel = new JLabel(new ImageIcon("Idle.gif"));
        feedButton = new JButton("Feed");
        sleepButton = new JButton("Sleep");
        playButton = new JButton("Play");
        headerText = new JLabel("Tamagotchi");
        headerText.setFont(headerText.getFont().deriveFont(20.0f));
        statusText = new JLabel(); // Initialize status text label

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(feedButton);
        buttonPanel.add(sleepButton);
        buttonPanel.add(playButton);

        // Create a panel for the header and status text
        JPanel textPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 0, 10, 0);
        textPanel.add(headerText, constraints);
        constraints.gridy = 1;
        textPanel.add(statusText, constraints);

        // Create a panel for the image and text panels
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(imageLabel, BorderLayout.CENTER);
        mainPanel.add(textPanel, BorderLayout.NORTH);

        // Add the components to the frame
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Assign the Pet object to the instance variable
        this.pet = pet;

        // Add action listeners to the buttons
        feedButton.addActionListener(this);
        sleepButton.addActionListener(this);
        playButton.addActionListener(this);

        // Show the frame
        setVisible(true);

        updateStatusText(); // Update the initial status text
    }

    // Handle button clicks
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == feedButton) {
            // Feed the Tamagotchi
            pet.eat();
        } else if (e.getSource() == sleepButton) {
            // Put the Tamagotchi to sleep
            pet.sleep();
        } else if (e.getSource() == playButton) {
            // Play with the Tamagotchi
            pet.play();
        }

        updateStatusText(); // Update the status text after each action
    }

    // Update the status text label
    private void updateStatusText() {
        if(pet.getHungriness() >= 7){
            imageLabel.setIcon(new ImageIcon("Hungry.gif"));
        } else if(pet.getSleepiness() >= 7){
            imageLabel.setIcon(new ImageIcon("Sleepy.gif"));
        } else if(pet.isHappy()){
            imageLabel.setIcon(new ImageIcon("Happy.gif"));
        } else if(pet.isSad()){
            imageLabel.setIcon(new ImageIcon("Sad.gif"));
        } else {
            imageLabel.setIcon(new ImageIcon("Idle.gif"));
        }
        
        String status = "Hu: " + pet.getHungriness() + ", Sl: " + pet.getSleepiness() + ", Ha: " + pet.getHappiness();
        statusText.setText(status);
    }

    public static void main(String[] args) {
        // Create a new instance of the Pet class
        Pet rosco = new Pet("Rosco", PetType.Type.DOG);
        // Create the GUI
        TamagotchiGUI gui = new TamagotchiGUI(rosco);
    }
}
