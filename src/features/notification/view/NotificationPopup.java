package features.notification.view;

import core.BaseApp;
import core.Session;
import features.auth.model.User;
import features.notification.controller.NotificationController;
import features.notification.model.Notification;
import java.awt.*;
import javax.swing.*;
import java.util.List;

public class NotificationPopup {
    
    public void openPopup(JFrame frame) {
        List<Notification> notificationList = fetchAllUserNotification();
        showNotificationPopup(frame,notificationList);
    }
    
    private List<Notification> fetchAllUserNotification(){
        NotificationController nc = BaseApp.getNotificationController();
        return nc.getAllUserNotification(Session.getSession().getLoggedInUser().getUserId());
    }
    
    private void showNotificationPopup(JFrame parent,List<Notification> notificationList) {
        // Create a JDialog for the popup with a wider size
        JDialog popup = new JDialog(parent, "Notifications", false);
        popup.setUndecorated(true); // Remove title bar
        popup.setSize(600, 300); // Increased width of the popup
        popup.setLayout(new BorderLayout());

        // Close button
        JButton closeButton = new JButton("X");
        closeButton.setPreferredSize(new Dimension(65, 30));
        closeButton.setFocusable(false);
        closeButton.addActionListener(e -> popup.dispose());

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.add(new JLabel("Notifications"), BorderLayout.WEST);
        headerPanel.add(closeButton, BorderLayout.EAST);

        // Panel to hold all notifications
        JPanel notificationPanel = new JPanel();
        notificationPanel.setLayout(new BoxLayout(notificationPanel, BoxLayout.Y_AXIS));

        notificationList.forEach(notification ->{
            notificationPanel.add(createNotificationCard(notification,popup));
        });

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

    private static JPanel createNotificationCard(Notification notification, JDialog popup) {
        User loggedInUser = Session.getSession().getLoggedInUser();
        JPanel notificationCard = new JPanel(new BorderLayout());
        notificationCard.setBorder(BorderFactory.createEmptyBorder(3, 3,3, 1));
        notificationCard.setBackground(Color.LIGHT_GRAY);

        // Profile picture
        JLabel profilePic = new JLabel();
        profilePic.setIcon(new ImageIcon(new ImageIcon(
        NotificationPopup.class.getResource("/Images/icons8-notification-21.png"))
        .getImage().getScaledInstance(21, 21, Image.SCALE_SMOOTH)));
        profilePic.setBorder(BorderFactory.createEmptyBorder(1, 1,1, 1));
        profilePic.setBackground(Color.LIGHT_GRAY);


        // Text content
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        JLabel userLabel = new JLabel(notification.getTitle());
        userLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel actionLabel = new JLabel(notification.getMessage());
        actionLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        JLabel timeLabel = new JLabel(notification.getCreatedAt().toString());
        timeLabel.setFont(new Font("Arial", Font.ITALIC, 10));
        textPanel.add(userLabel);
        textPanel.add(actionLabel);
        textPanel.add(timeLabel);

        // Buttons for Mark as Seen and Delete (small size, horizontal placement)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        boolean notificationStatus = notification.isSeen() == true;
        NotificationStatus buttonText = notificationStatus?NotificationStatus.UNREAD:NotificationStatus.READ;
        JButton markAsSeenButton = new JButton(buttonText.name());
        JButton deleteButton = new JButton("Delete");

        // Making buttons smaller
        markAsSeenButton.setPreferredSize(new Dimension(85, 25));
        deleteButton.setPreferredSize(new Dimension(80, 25));

        markAsSeenButton.setFocusable(false);
        deleteButton.setFocusable(false);

        // Add ActionListener for Mark as Seen
        markAsSeenButton.addActionListener(e -> {
            NotificationController nc = BaseApp.getNotificationController();
            NotificationStatus newButtonText = buttonText == NotificationStatus.READ ? NotificationStatus.UNREAD : NotificationStatus.READ;
            markAsSeenButton.setText(newButtonText.name());
            nc.markNotificationAsSeen(notification.getId());
            notificationCard.getParent().revalidate();
            notificationCard.getParent().repaint();
        });
        

        // Add ActionListener for Delete
        deleteButton.addActionListener(e -> {
            NotificationController nc = BaseApp.getNotificationController();
            nc.deleteNotification(notification.getId());
            notificationCard.getParent().remove(notificationCard); // Remove the notification
            notificationCard.revalidate();            // Refresh the panel
            notificationCard.repaint();
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
