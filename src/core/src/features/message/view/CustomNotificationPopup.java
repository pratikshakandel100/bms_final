/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package features.message.view;

import java.awt.*;
import javax.swing.*;

public class CustomNotificationPopup {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Notification Popup Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            
            // Set the background color of the frame to white
            frame.getContentPane().setBackground(Color.WHITE);

            // Create a button to trigger the notification popup
            JButton notificationButton = new JButton("Show Notifications");
            notificationButton.addActionListener(e -> showNotificationPopup(frame));

            frame.setLayout(new FlowLayout());
            frame.add(notificationButton);
            frame.setVisible(true);
        });
    }

    private static void showNotificationPopup(JFrame parent) {
        // Create a JDialog for the popup with a wider size
        JDialog popup = new JDialog(parent, "Notifications", false);
        popup.setUndecorated(true); // Remove title bar
        popup.setSize(600, 300); // Increased width of the popup
        popup.setLayout(new BorderLayout());

        // Close button
        JButton closeButton = new JButton("X");
        closeButton.setPreferredSize(new Dimension(60, 30));
        closeButton.setFocusable(false);
        closeButton.addActionListener(e -> popup.dispose());

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.add(new JLabel("Notifications"), BorderLayout.WEST);
        headerPanel.add(closeButton, BorderLayout.EAST);

        // Panel to hold all notifications
        JPanel notificationPanel = new JPanel();
        notificationPanel.setLayout(new BoxLayout(notificationPanel, BoxLayout.Y_AXIS));

        // Add sample notifications
        for (int i = 0; i < 5; i++) {
            notificationPanel.add(createNotificationCard("User " + (i + 1),
                    "answered to your comment answered to your comment", i + " days ago", popup));
        }

        // Wrap notifications in a JScrollPane
        JScrollPane scrollPane = new JScrollPane(notificationPanel);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);


        // Add components to the popup
        popup.add(headerPanel, BorderLayout.NORTH);
        popup.add(scrollPane, BorderLayout.CENTER);

        // Display the popup
        popup.setLocationRelativeTo(parent);
        popup.setVisible(true);
    }

    private static JPanel createNotificationCard(String userName, String action, String time, JDialog popup) {
        JPanel notificationCard = new JPanel(new BorderLayout());
        notificationCard.setBorder(BorderFactory.createEmptyBorder(3, 3,3, 1));
        notificationCard.setBackground(Color.LIGHT_GRAY);

        // Profile picture
        JLabel profilePic = new JLabel();
        profilePic.setIcon(new ImageIcon(new ImageIcon(
        CustomNotificationPopup.class.getResource("/Images/notificationicon.png"))
        .getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        profilePic.setBorder(BorderFactory.createEmptyBorder(1, 1,1, 3));
        profilePic.setBackground(Color.LIGHT_GRAY);


        // Text content
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        JLabel userLabel = new JLabel(userName);
        userLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel actionLabel = new JLabel(action);
        actionLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        JLabel timeLabel = new JLabel(time);
        timeLabel.setFont(new Font("Arial", Font.ITALIC, 10));
        textPanel.add(userLabel);
        textPanel.add(actionLabel);
        textPanel.add(timeLabel);

        // Buttons for Mark as Seen and Delete (small size, horizontal placement)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton markAsSeenButton = new JButton("Read");
        JButton deleteButton = new JButton("Delete");

        // Making buttons smaller
        markAsSeenButton.setPreferredSize(new Dimension(80, 25));
        deleteButton.setPreferredSize(new Dimension(80, 25));

        markAsSeenButton.setFocusable(false);
        deleteButton.setFocusable(false);

        // Add ActionListener for Mark as Seen
        markAsSeenButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(popup, userName + "'s notification marked as seen.");
        });

        // Add ActionListener for Delete
        deleteButton.addActionListener(e -> {
            notificationCard.getParent().remove(notificationCard); // Remove the notification
            notificationCard.getParent().revalidate();            // Refresh the panel
            notificationCard.getParent().repaint();
        });

        buttonPanel.add(markAsSeenButton);
        buttonPanel.add(deleteButton);

        // Assemble the notification card
        notificationCard.add(profilePic, BorderLayout.WEST);
        notificationCard.add(textPanel, BorderLayout.CENTER);
        notificationCard.add(buttonPanel, BorderLayout.EAST);

        return notificationCard;
    }
}
