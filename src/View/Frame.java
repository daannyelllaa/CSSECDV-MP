package View;

import Controller.Main;
import Controller.PasswordUtil;
import Model.User;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Frame extends javax.swing.JFrame {

    public Frame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Container = new javax.swing.JPanel();
        HomePnl = new javax.swing.JPanel();
        Content = new javax.swing.JPanel();
        Navigation = new javax.swing.JPanel();
        adminBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        managerBtn = new javax.swing.JButton();
        staffBtn = new javax.swing.JButton();
        clientBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setMinimumSize(new java.awt.Dimension(800, 450));

        HomePnl.setBackground(new java.awt.Color(102, 102, 102));
        HomePnl.setPreferredSize(new java.awt.Dimension(801, 500));

        javax.swing.GroupLayout ContentLayout = new javax.swing.GroupLayout(Content);
        Content.setLayout(ContentLayout);
        ContentLayout.setHorizontalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );
        ContentLayout.setVerticalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Navigation.setBackground(new java.awt.Color(204, 204, 204));

        adminBtn.setBackground(new java.awt.Color(250, 250, 250));
        adminBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        adminBtn.setText("Admin Home");
        adminBtn.setFocusable(false);
        adminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SECURITY Svcs");
        jLabel1.setToolTipText("");

        managerBtn.setBackground(new java.awt.Color(250, 250, 250));
        managerBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        managerBtn.setText("Manager Home");
        managerBtn.setFocusable(false);
        managerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managerBtnActionPerformed(evt);
            }
        });

        staffBtn.setBackground(new java.awt.Color(250, 250, 250));
        staffBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        staffBtn.setText("Staff Home");
        staffBtn.setFocusable(false);
        staffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffBtnActionPerformed(evt);
            }
        });

        clientBtn.setBackground(new java.awt.Color(250, 250, 250));
        clientBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        clientBtn.setText("Client Home");
        clientBtn.setFocusable(false);
        clientBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientBtnActionPerformed(evt);
            }
        });

        logoutBtn.setBackground(new java.awt.Color(250, 250, 250));
        logoutBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        logoutBtn.setText("LOGOUT");
        logoutBtn.setFocusable(false);
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NavigationLayout = new javax.swing.GroupLayout(Navigation);
        Navigation.setLayout(NavigationLayout);
        NavigationLayout.setHorizontalGroup(
            NavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavigationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(managerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staffBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clientBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        NavigationLayout.setVerticalGroup(
            NavigationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavigationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(adminBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(managerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(staffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clientBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout HomePnlLayout = new javax.swing.GroupLayout(HomePnl);
        HomePnl.setLayout(HomePnlLayout);
        HomePnlLayout.setHorizontalGroup(
            HomePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomePnlLayout.createSequentialGroup()
                .addComponent(Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HomePnlLayout.setVerticalGroup(
            HomePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Navigation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ContainerLayout = new javax.swing.GroupLayout(Container);
        Container.setLayout(ContainerLayout);
        ContainerLayout.setHorizontalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
            .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(HomePnl, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE))
        );
        ContainerLayout.setVerticalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(HomePnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminBtnActionPerformed
        if (loggedInUser == null || loggedInUser.getRole() != 5) {
            main.sqlite.addLogs("UNAUTHORIZED",
                    loggedInUser != null ? loggedInUser.getUsername() : "unkown",
                    "Attempted to access Admin panel without Role 5",
                    new java.sql.Timestamp(new java.util.Date().getTime()).toString());
            JOptionPane.showMessageDialog(this, "Access denied.");
            return;
        }
        adminHomePnl.showPnl("home");
        contentView.show(Content, "adminHomePnl");
    }//GEN-LAST:event_adminBtnActionPerformed

    private void managerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managerBtnActionPerformed
        if (loggedInUser == null || loggedInUser.getRole() != 4) {
            main.sqlite.addLogs("UNAUTHORIZED",
                    loggedInUser != null ? loggedInUser.getUsername() : "unkown",
                    "Attempted to access Manager panel without Role 4",
                    new java.sql.Timestamp(new java.util.Date().getTime()).toString());
            JOptionPane.showMessageDialog(this, "Access denied.");
            return;
        }
        managerHomePnl.showPnl("home");
        contentView.show(Content, "managerHomePnl");
    }//GEN-LAST:event_managerBtnActionPerformed

    private void staffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffBtnActionPerformed
        if (loggedInUser == null || loggedInUser.getRole() != 3) {
            main.sqlite.addLogs("UNAUTHORIZED",
                    loggedInUser != null ? loggedInUser.getUsername() : "unkown",
                    "Attempted to access Staff panel without Role 3",
                    new java.sql.Timestamp(new java.util.Date().getTime()).toString());
            JOptionPane.showMessageDialog(this, "Access denied.");
            return;
        }
        staffHomePnl.showPnl("home");
        contentView.show(Content, "staffHomePnl");
    }//GEN-LAST:event_staffBtnActionPerformed

    private void clientBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientBtnActionPerformed
        if (loggedInUser == null || loggedInUser.getRole() != 2) {
            main.sqlite.addLogs("UNAUTHORIZED",
                    loggedInUser != null ? loggedInUser.getUsername() : "unkown",
                    "Attempted to access Client panel without Role 2",
                    new java.sql.Timestamp(new java.util.Date().getTime()).toString());
            JOptionPane.showMessageDialog(this, "Access denied.");
            return;
        }
        clientHomePnl.showPnl("home");
        contentView.show(Content, "clientHomePnl");
    }//GEN-LAST:event_clientBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // Clear session and return to login
        loggedInUser = null;
        frameView.show(Container, "loginPnl");
    }//GEN-LAST:event_logoutBtnActionPerformed

    public Main main;
    public Login loginPnl = new Login();
    public Register registerPnl = new Register();
    
    private AdminHome adminHomePnl = new AdminHome();
    private ManagerHome managerHomePnl = new ManagerHome();
    private StaffHome staffHomePnl = new StaffHome();
    private ClientHome clientHomePnl = new ClientHome();
    
    private CardLayout contentView = new CardLayout();
    private CardLayout frameView = new CardLayout();
    
    public void init(Main controller){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("CSSECDV - SECURITY Svcs");
        this.setLocationRelativeTo(null);
        
        this.main = controller;
        loginPnl.frame = this;
        registerPnl.frame = this;
        
        adminHomePnl.init(main.sqlite);
        clientHomePnl.init(main.sqlite);
        clientHomePnl.frame = this;
        managerHomePnl.init(main.sqlite);
        staffHomePnl.init(main.sqlite);
        
        adminHomePnl.mgmtProduct.frame = this;
        clientHomePnl.mgmtProduct.frame = this;
        managerHomePnl.mgmtProduct.frame = this;
        staffHomePnl.mgmtProduct.frame = this;
        
        Container.setLayout(frameView);
        Container.add(loginPnl, "loginPnl");
        Container.add(registerPnl, "registerPnl");
        Container.add(HomePnl, "homePnl");
        frameView.show(Container, "loginPnl");
        
        Content.setLayout(contentView);
        Content.add(adminHomePnl, "adminHomePnl");
        Content.add(managerHomePnl, "managerHomePnl");
        Content.add(staffHomePnl, "staffHomePnl");
        Content.add(clientHomePnl, "clientHomePnl");
        
        this.setVisible(true);
    }
    
    public void mainNav(){
        frameView.show(Container, "homePnl");
    }
    
    public void loginNav(){
        frameView.show(Container, "loginPnl");
    }
    
    public void registerNav(){
        frameView.show(Container, "registerPnl");
    }
    
    // =========================================================
    // AUTHENTICATION — loginAction
    // =========================================================
    public void loginAction(String username, String password) {
        try {
            // Step 1: Retrieve user by username using PreparedStatement
            User user = main.sqlite.getUser(username);

            // Step 2: Generic feedback — same message for all failure cases
            //         (prevents account enumeration)
            final String GENERIC_MSG = "Invalid username and/or password.";

            if (user == null) {
                // Username does not exist — log the attempt, show generic message
                String ts = new Timestamp(new Date().getTime()).toString();
                main.sqlite.addLogs("FAILED_LOGIN", username, "Login attempt with unknown username", ts);
                JOptionPane.showMessageDialog(this, GENERIC_MSG, "Login Failed",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Step 3: Check if account is already locked (role == 1)
            if (user.getRole() == 1) {
                String ts = new Timestamp(new Date().getTime()).toString();
                main.sqlite.addLogs("FAILED_LOGIN", username,
                        "Login attempt on disabled account", ts);
                JOptionPane.showMessageDialog(this, GENERIC_MSG, "Login Failed",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Step 4: Password verification using PBKDF2WithHmacSHA256
            boolean passwordMatch = PasswordUtil.verifyPassword(password, user.getPassword());

            if (!passwordMatch) {
                // Increment failed attempts
                main.sqlite.incrementFailedAttempts(username);
                int newFailCount = user.getFailedAttempts() + 1;

                String ts = new Timestamp(new Date().getTime()).toString();
                main.sqlite.addLogs("FAILED_LOGIN", username,
                        "Invalid password attempt (" + newFailCount + ")", ts);

                // Step 5: Brute-force mitigation — lock after 5 consecutive failures
                if (newFailCount >= 5) {
                    main.sqlite.lockUser(username);
                    main.sqlite.addLogs("ACCOUNT_LOCKED", username,
                            "Account locked after 5 failed attempts", ts);
                }

                JOptionPane.showMessageDialog(this, GENERIC_MSG, "Login Failed",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Step 6: Successful login — reset counter, record timestamp
            String loginTimestamp = new Timestamp(new Date().getTime()).toString();
            main.sqlite.resetFailedAttempts(username);
            main.sqlite.updateLastLogin(username, loginTimestamp);
            main.sqlite.addLogs("SUCCESS_LOGIN", username,
                    "Successful login", loginTimestamp);

            // Step 7: Store the logged-in user in Frame for use by panels
            this.loggedInUser = user;

            // Step 8: Contextual Awareness — show last-login info on successful entry
            String lastLogin = user.getLastLogin();
            if (lastLogin != null && !lastLogin.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Welcome back, " + username + "!\n\nLast successful login: " + lastLogin,
                        "Login Successful", JOptionPane.INFORMATION_MESSAGE);
            }

            // Step 9: Role-based navigation — route user to their correct home panel
            int role = user.getRole();
            frameView.show(Container, "homePnl");

            // Show only the nav button matching the user's role
            adminBtn.setVisible(false);
            managerBtn.setVisible(false);
            staffBtn.setVisible(false);
            clientBtn.setVisible(false);

            switch (role) {
                case 5: // Administrator
                    adminBtn.setVisible(true);
                    adminHomePnl.showPnl("home");
                    contentView.show(Content, "adminHomePnl");
                    break;
                case 4: // Manager
                    managerBtn.setVisible(true);
                    managerHomePnl.showPnl("home");
                    contentView.show(Content, "managerHomePnl");
                    break;
                case 3: // Staff
                    staffBtn.setVisible(true);
                    staffHomePnl.showPnl("home");
                    contentView.show(Content, "staffHomePnl");
                    break;
                case 2: // Client
                    clientBtn.setVisible(true);
                    clientHomePnl.showPnl("home");
                    contentView.show(Content, "clientHomePnl");
                    break;
                default:
                    // Unknown role — fail safely: return to login
                    main.sqlite.addLogs("UNAUTHORIZED", username,
                            "Login attempt with invalid role: " + role, loginTimestamp);
                    logoutBtnActionPerformed(null);
                    break;
            }

        } catch (Exception ex) {
            // Error handling — no stack trace exposed; redirect to safe state
            JOptionPane.showMessageDialog(this,
                    "An unexpected error occurred. Please try again.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            loginNav();
        }
    }

    // =========================================================
    // REGISTRATION — registerAction
    // =========================================================
    public void registerAction(String username, String password, String confpass) {
        try {
            String ts = new Timestamp(new Date().getTime()).toString();

            // Hash password with PBKDF2 before storage (never store plaintext)
            String hashedPassword = PasswordUtil.hashPassword(password);
            main.sqlite.addUser(username, hashedPassword);

            main.sqlite.addLogs("REGISTER", username, "New user registered", ts);
        } catch (Exception ex) {
            // Error handling — no internals exposed
            JOptionPane.showMessageDialog(this,
                    "Registration could not be completed. Please try again.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public User loggedInUser = null;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JPanel Content;
    private javax.swing.JPanel HomePnl;
    private javax.swing.JPanel Navigation;
    private javax.swing.JButton adminBtn;
    private javax.swing.JButton clientBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton managerBtn;
    private javax.swing.JButton staffBtn;
    // End of variables declaration//GEN-END:variables
}
