import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class DatingAppUI extends JFrame {
    private JLabel profilePictureLabel;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel interestsLabel;
    private JButton likeButton;
    private JButton dislikeButton;

    public DatingAppUI() {
        setTitle("Dating App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        nameLabel = new JLabel("Name: John Doe");
        ageLabel = new JLabel("Age: 30");
        interestsLabel = new JLabel("Interests: Hiking, Cooking");
        likeButton = new JButton("Like");
        dislikeButton = new JButton("Dislike");

        likeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLikeButton();
            }
        });

        dislikeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleDislikeButton();
            }
        });

        // Load image from URL
        try {
            URL imageUrl = new URL("https://www.google.com/url?sa=i&url=https%3A%2F%2Ftimesofindia.indiatimes.com%2Ftv%2Fnews%2Fhindi%2Fbigg-boss-11s-priyank-sharma-to-enter-bharti-singh-haarsh-limbhaachiyas-show%2Farticleshow%2F68777431.cms&psig=AOvVaw1EgABDDSFR-zbYHYNDC9eh&ust=1695819286061000&source=images&cd=vfe&opi=89978449&ved=0CBAQjRxqFwoTCOizrqSpyIEDFQAAAAAdAAAAABAE");
            ImageIcon icon = new ImageIcon(imageUrl);
            profilePictureLabel = new JLabel(icon);
        } catch (IOException e) {
            e.printStackTrace();
            profilePictureLabel = new JLabel("Profile Picture");
        }

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        panel.add(profilePictureLabel);
        panel.add(nameLabel);
        panel.add(ageLabel);
        panel.add(interestsLabel);
        panel.add(likeButton);
        panel.add(dislikeButton);

        add(panel);
        setVisible(true);
    }

    private void handleLikeButton() {
        JOptionPane.showMessageDialog(this, "You liked this profile!");
    }

    private void handleDislikeButton() {
        JOptionPane.showMessageDialog(this, "You disliked this profile!");
    }

    public static void main(String[] args) {
        new DatingAppUI();
    }
}

