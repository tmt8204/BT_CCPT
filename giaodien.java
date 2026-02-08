import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class giaodien extends JFrame {
    private JPanel chatPanel;
    private JTextField messageInput;
    private JScrollPane chatScrollPane;
    private static final Color PRIMARY_COLOR = new Color(138, 43, 226);
    private static final Color SECONDARY_COLOR = new Color(75, 0, 130);
    private static final Color LIGHT_BG = new Color(248, 248, 255);
    private static final Color DARK_TEXT = new Color(33, 33, 33);
    private static final Color LIGHT_TEXT = new Color(117, 117, 117);

    public giaodien() {
        setTitle("GUMMY Messenger");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1450, 800);
        setLocationRelativeTo(null);
        setResizable(true);
        setBackground(LIGHT_BG);

        // Top navbar
        JPanel topPanel = createTopNavbar();
        add(topPanel, BorderLayout.NORTH);

        // Main container with 3 columns
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(LIGHT_BG);

        JPanel leftPanel = createLeftPanel();
        JPanel middlePanel = createMiddlePanel();
        JPanel rightPanel = createRightPanel();

        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(middlePanel, BorderLayout.CENTER);
        mainPanel.add(rightPanel, BorderLayout.EAST);

        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private JPanel createTopNavbar() {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(255, 192, 203));
        topPanel.setPreferredSize(new Dimension(1450, 60));
        topPanel.setBorder(new EmptyBorder(10, 20, 10, 20));

        // Logo
        JLabel logo = new JLabel("GUMMY");
        logo.setFont(new Font("Arial", Font.BOLD, 20));
        logo.setForeground(new Color(255, 20, 147));

        // Search
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.setBackground(new Color(255, 255, 255));
        searchPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        searchPanel.setPreferredSize(new Dimension(150, 35));
        JTextField searchField = new JTextField("🔍");
        searchField.setFont(new Font("Arial", Font.PLAIN, 11));
        searchField.setBorder(BorderFactory.createEmptyBorder());
        searchPanel.add(searchField, BorderLayout.CENTER);

        // Icons center
        JPanel centerIconsPanel = new JPanel();
        centerIconsPanel.setBackground(new Color(255, 192, 203));
        String[] centerIcons = { "🏠", "👥", "🎬", "👨‍👩‍👧‍👦", "➕" };
        for (String icon : centerIcons) {
            JLabel iconLabel = new JLabel(icon);
            iconLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            iconLabel.setBorder(new EmptyBorder(0, 15, 0, 15));
            centerIconsPanel.add(iconLabel);
        }

        // Icons right
        JPanel rightIconsPanel = new JPanel();
        rightIconsPanel.setBackground(new Color(255, 192, 203));
        String[] rightIcons = { "💬", "🔔", "👤" };
        for (String icon : rightIcons) {
            JLabel iconLabel = new JLabel(icon);
            iconLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            iconLabel.setBorder(new EmptyBorder(0, 10, 0, 10));
            rightIconsPanel.add(iconLabel);
        }

        topPanel.add(logo, BorderLayout.WEST);
        topPanel.add(searchPanel, BorderLayout.WEST);
        topPanel.add(centerIconsPanel, BorderLayout.CENTER);
        topPanel.add(rightIconsPanel, BorderLayout.EAST);

        return topPanel;
    }

    private JPanel createLeftPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(255, 192, 203));
        panel.setPreferredSize(new Dimension(200, 740));
        panel.setBorder(new EmptyBorder(15, 15, 15, 15));

        // Navigation items
        String[] navItems = { "Bảng tin", "Hộ số của tôi", "Bạn bè", "Cộng đồng", "Phương tiện", "Cài đặt" };
        for (String item : navItems) {
            JButton navBtn = new JButton("  " + item);
            navBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
            navBtn.setMaximumSize(new Dimension(170, 45));
            navBtn.setBackground(new Color(255, 182, 193));
            navBtn.setForeground(new Color(80, 20, 40));
            navBtn.setBorder(new RoundedBorder(10));
            navBtn.setFont(new Font("Arial", Font.PLAIN, 12));
            navBtn.setFocusPainted(false);
            navBtn.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    navBtn.setBackground(new Color(255, 160, 180));
                }

                public void mouseExited(MouseEvent e) {
                    navBtn.setBackground(new Color(255, 182, 193));
                }
            });
            panel.add(navBtn);
            panel.add(Box.createVerticalStrut(10));
        }

        panel.add(Box.createVerticalGlue());
        return panel;
    }

    private JPanel createMiddlePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(255, 192, 203));
        panel.setPreferredSize(new Dimension(350, 740));
        panel.setBorder(new EmptyBorder(15, 15, 15, 15));

        // Tabs
        JPanel tabsPanel = new JPanel();
        tabsPanel.setBackground(new Color(255, 192, 203));
        JButton tinNhanTab = new JButton("Tin nhân");
        JButton nhomsTab = new JButton("Nhóm");
        tinNhanTab.setFont(new Font("Arial", Font.BOLD, 12));
        nhomsTab.setFont(new Font("Arial", Font.PLAIN, 12));
        tinNhanTab.setBackground(new Color(180, 180, 200));
        nhomsTab.setBackground(new Color(200, 200, 200));
        tinNhanTab.setBorder(new EmptyBorder(5, 15, 5, 15));
        nhomsTab.setBorder(new EmptyBorder(5, 15, 5, 15));
        tinNhanTab.setFocusPainted(false);
        nhomsTab.setFocusPainted(false);
        tabsPanel.add(tinNhanTab);
        tabsPanel.add(nhomsTab);
        panel.add(tabsPanel, BorderLayout.NORTH);

        // Title
        JLabel titleLabel = new JLabel("Tín nhân của bạn");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(80, 20, 40));
        titleLabel.setBorder(new EmptyBorder(10, 0, 10, 0));

        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(new Color(255, 192, 203));
        titlePanel.add(titleLabel, BorderLayout.NORTH);

        // Conversation List
        DefaultListModel<ConversationItem> listModel = new DefaultListModel<>();
        listModel.addElement(new ConversationItem("🔍 Tìm kiếm trên Gummy", "", false));
        listModel.addElement(new ConversationItem("Minh Quang", "Ban: Bye bye", true));

        JList<ConversationItem> conversationList = new JList<>(listModel);
        conversationList.setBackground(new Color(255, 182, 193));
        conversationList.setFont(new Font("Arial", Font.PLAIN, 12));
        conversationList.setCellRenderer(new ConversationCellRenderer());
        conversationList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conversationList.setSelectedIndex(1);

        JScrollPane scrollPane = new JScrollPane(conversationList);
        scrollPane.setBackground(new Color(255, 192, 203));
        scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));

        panel.add(titlePanel, BorderLayout.CENTER);
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(new Color(255, 192, 203));
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        panel.add(contentPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createRightPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(200, 230, 201));
        panel.setPreferredSize(new Dimension(500, 740));
        panel.setBorder(new EmptyBorder(10, 15, 10, 15));

        // Header
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(200, 230, 201));
        headerPanel.setBorder(new EmptyBorder(0, 0, 10, 0));

        // Avatar
        JPanel avatarPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(new Color(30, 50, 150));
                g2d.fillOval(2, 2, 46, 46);
                g2d.setColor(Color.WHITE);
                g2d.setFont(new Font("Arial", Font.BOLD, 18));
                g2d.drawString("M", 18, 32);
            }
        };
        avatarPanel.setPreferredSize(new Dimension(50, 50));
        avatarPanel.setBackground(new Color(200, 230, 201));

        JPanel userInfoPanel = new JPanel(new BorderLayout());
        userInfoPanel.setBackground(new Color(200, 230, 201));
        JLabel nameLabel = new JLabel("Minh Quang");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setForeground(new Color(0, 100, 0));
        JLabel statusLabel = new JLabel("Đang hoạt động");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        statusLabel.setForeground(new Color(80, 150, 80));
        userInfoPanel.add(nameLabel, BorderLayout.NORTH);
        userInfoPanel.add(statusLabel, BorderLayout.SOUTH);
        userInfoPanel.setBorder(new EmptyBorder(5, 10, 0, 0));

        headerPanel.add(avatarPanel, BorderLayout.WEST);
        headerPanel.add(userInfoPanel, BorderLayout.CENTER);

        panel.add(headerPanel, BorderLayout.NORTH);

        // Chat area
        chatPanel = new JPanel();
        chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));
        chatPanel.setBackground(new Color(245, 255, 250));
        chatPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Add messages
        addChatMessage(chatPanel, "Chào bạn", true);
        addChatMessage(chatPanel, "Where are you from?", false);
        addChatMessage(chatPanel, "Wow! I love Việt Nam", true);
        addChatMessage(chatPanel, "Tôi đó Việt Nam", false);
        addChatMessage(chatPanel, "Yes yes, me too", false);
        addChatMessage(chatPanel, "I am fine", true);
        addChatMessage(chatPanel, "Bye bye", false);

        chatPanel.add(Box.createVerticalGlue());

        chatScrollPane = new JScrollPane(chatPanel);
        chatScrollPane.setBackground(new Color(245, 255, 250));
        chatScrollPane.setBorder(new EmptyBorder(0, 0, 10, 0));
        chatScrollPane.getVerticalScrollBar().setValue(chatScrollPane.getVerticalScrollBar().getMaximum());

        panel.add(chatScrollPane, BorderLayout.CENTER);

        // Input area
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBackground(new Color(200, 230, 201));

        messageInput = new JTextField();
        messageInput.setText("Viết tin nhắn...");
        messageInput.setFont(new Font("Arial", Font.PLAIN, 12));
        messageInput.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(150, 150, 150), 1),
                new EmptyBorder(8, 12, 8, 12)));
        messageInput.setBackground(new Color(255, 255, 255));
        messageInput.setForeground(new Color(150, 150, 150));
        messageInput.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (messageInput.getText().equals("Viết tin nhắn...")) {
                    messageInput.setText("");
                    messageInput.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (messageInput.getText().isEmpty()) {
                    messageInput.setText("Viết tin nhắn...");
                    messageInput.setForeground(new Color(150, 150, 150));
                }
            }
        });
        messageInput.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });

        JPanel iconPanel = new JPanel();
        iconPanel.setBackground(new Color(200, 230, 201));
        JLabel attachIcon = new JLabel("📎");
        attachIcon.setFont(new Font("Arial", Font.PLAIN, 14));
        JLabel smileyIcon = new JLabel("😊");
        smileyIcon.setFont(new Font("Arial", Font.PLAIN, 14));
        iconPanel.add(attachIcon);
        iconPanel.add(smileyIcon);
        iconPanel.setBorder(new EmptyBorder(0, 10, 0, 0));

        inputPanel.add(messageInput, BorderLayout.CENTER);
        inputPanel.add(iconPanel, BorderLayout.EAST);

        panel.add(inputPanel, BorderLayout.SOUTH);

        return panel;
    }

    private void addChatMessage(JPanel panel, String message, boolean isReceived) {
        JPanel messageContainerPanel = new JPanel(new BorderLayout());
        messageContainerPanel.setBackground(new Color(245, 255, 250));
        messageContainerPanel.setMaximumSize(new Dimension(450, 70));
        messageContainerPanel.setBorder(new EmptyBorder(3, 0, 3, 0));

        if (isReceived) {
            // Receiver message with avatar
            JPanel avatarSmall = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2d.setColor(new Color(30, 50, 150));
                    g2d.fillOval(0, 0, 32, 32);
                    g2d.setColor(Color.WHITE);
                    g2d.setFont(new Font("Arial", Font.BOLD, 14));
                    g2d.drawString("M", 10, 22);
                }
            };
            avatarSmall.setPreferredSize(new Dimension(32, 32));
            avatarSmall.setBackground(new Color(245, 255, 250));

            JLabel messageBubble = new JLabel(
                    "<html><body style='word-wrap: break-word;'>" + message + "</body></html>");
            messageBubble.setFont(new Font("Arial", Font.PLAIN, 12));
            messageBubble.setBorder(new EmptyBorder(6, 10, 6, 10));
            messageBubble.setOpaque(true);
            messageBubble.setBackground(new Color(200, 200, 200));
            messageBubble.setForeground(Color.BLACK);

            messageContainerPanel.add(avatarSmall, BorderLayout.WEST);
            messageContainerPanel.add(messageBubble, BorderLayout.CENTER);
        } else {
            // Sender message (right aligned)
            JLabel messageBubble = new JLabel(
                    "<html><body style='word-wrap: break-word;'>" + message + "</body></html>");
            messageBubble.setFont(new Font("Arial", Font.PLAIN, 12));
            messageBubble.setBorder(new EmptyBorder(6, 10, 6, 10));
            messageBubble.setOpaque(true);
            messageBubble.setBackground(new Color(200, 220, 255));
            messageBubble.setForeground(Color.BLACK);

            JPanel rightAlignPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
            rightAlignPanel.setBackground(new Color(245, 255, 250));
            rightAlignPanel.add(messageBubble);

            messageContainerPanel.add(rightAlignPanel, BorderLayout.CENTER);
        }

        panel.add(messageContainerPanel);
    }

    private void sendMessage() {
        String message = messageInput.getText().trim();
        if (!message.isEmpty() && !message.equals("Viết tin nhắn...")) {
            addChatMessage(chatPanel, message, false);
            messageInput.setText("");
            chatPanel.revalidate();
            chatPanel.repaint();
            chatScrollPane.getVerticalScrollBar().setValue(chatScrollPane.getVerticalScrollBar().getMaximum());
        }
    }

    static class RoundedBorder extends AbstractBorder {
        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setStroke(new BasicStroke(1));
            g2d.setColor(new Color(200, 200, 200));
            g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(5, 10, 5, 10);
        }
    }

    static class ConversationItem {
        String name;
        String lastMessage;
        boolean hasAvatar;

        ConversationItem(String name, String lastMessage, boolean hasAvatar) {
            this.name = name;
            this.lastMessage = lastMessage;
            this.hasAvatar = hasAvatar;
        }
    }

    static class ConversationCellRenderer extends JPanel implements ListCellRenderer<ConversationItem> {
        private JLabel nameLabel = new JLabel();
        private JLabel messageLabel = new JLabel();

        @Override
        public Component getListCellRendererComponent(JList<? extends ConversationItem> list, ConversationItem value,
                int index, boolean isSelected, boolean cellHasFocus) {
            setLayout(new BorderLayout());
            setOpaque(true);

            if (value.hasAvatar) {
                // Avatar panel
                JPanel avatarPanel = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        Graphics2D g2d = (Graphics2D) g;
                        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        g2d.setColor(new Color(30, 50, 150));
                        g2d.fillOval(4, 4, 32, 32);
                        g2d.setColor(Color.WHITE);
                        g2d.setFont(new Font("Arial", Font.BOLD, 14));
                        g2d.drawString("M", 16, 24);
                    }
                };
                avatarPanel.setPreferredSize(new Dimension(40, 40));
                avatarPanel.setBackground(isSelected ? new Color(255, 160, 180) : new Color(255, 182, 193));

                // Text panel
                JPanel textPanel = new JPanel(new BorderLayout());
                textPanel.setBackground(isSelected ? new Color(255, 160, 180) : new Color(255, 182, 193));
                nameLabel.setText(value.name);
                nameLabel.setFont(new Font("Arial", Font.BOLD, 12));
                nameLabel.setForeground(new Color(80, 20, 40));

                messageLabel.setText(value.lastMessage);
                messageLabel.setFont(new Font("Arial", Font.PLAIN, 10));
                messageLabel.setForeground(new Color(100, 50, 80));

                textPanel.add(nameLabel, BorderLayout.NORTH);
                textPanel.add(messageLabel, BorderLayout.SOUTH);
                textPanel.setBorder(new EmptyBorder(5, 10, 5, 0));

                add(avatarPanel, BorderLayout.WEST);
                add(textPanel, BorderLayout.CENTER);
            } else {
                // Search bar
                nameLabel.setText(value.name);
                nameLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                nameLabel.setForeground(new Color(100, 50, 80));
                nameLabel.setBackground(isSelected ? new Color(255, 160, 180) : new Color(200, 200, 200));
                add(nameLabel, BorderLayout.CENTER);
            }

            setBorder(new EmptyBorder(8, 8, 8, 8));
            setBackground(isSelected ? new Color(255, 160, 180) : new Color(255, 182, 193));

            return this;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new giaodien());
    }
}
