package com.ui;


import com.socket.Message;
import com.socket.MyConnection;
import com.socket.SocketClient;
import com.socket.User;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
//import oracle.jrockit.jfr.JFR;

public class ChatFrame extends javax.swing.JFrame {

    public SocketClient client;
    public int port;
    public String serverAddr, username, password;
    public Thread clientThread;
    public DefaultListModel model;
    public File file;
    User user;
    ArrayList<User> userlist;
    public ChatFrame(User user) {
        initComponents();
       
        this.user=user;
        username=user.getUsername();
        password=user.getPassword();
        this.setTitle(user.getFirstname()+" "+ user.getLastname());
        model.addElement("All");
        jList1.setSelectedIndex(0);
         serverAddr = "localhost"; port = Integer.parseInt("13000");
         try{
                client = new SocketClient(this);
                clientThread = new Thread(client);
                clientThread.start();
       
            }
            catch(Exception ex){
                jTextArea1.append("[Application > Me] : Server not found\n");
            }
           client.send(new Message("login", username, password, "SERVER"));
           String path=user.getProfilepic();
        pp.setIcon(ResizeImage(path));
        jLabel2.setText(user.getFirstname());
        jLabel3.setText(user.getLastname());
        
        try {
            userlist=MyConnection.createlist();
            for(User u : userlist){
                if(u.getUsername().equals(username)){
                    
                }else{
                list1.add(u.getUsername());
                }
            }
            loadpcm();
        } catch (IOException ex) {
            Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            
            Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.addWindowListener(new WindowListener() {

            @Override public void windowOpened(WindowEvent e) {}
            @Override public void windowClosing(WindowEvent e) { try{ client.send(new Message("message", username, ".bye", "SERVER")); clientThread.interrupt();  }catch(Exception ex){} }
            @Override public void windowClosed(WindowEvent e) {}
            @Override public void windowIconified(WindowEvent e) {}
            @Override public void windowDeiconified(WindowEvent e) {}
            @Override public void windowActivated(WindowEvent e) {}
            @Override public void windowDeactivated(WindowEvent e) {}
        });
    }
    
    public boolean isWin32(){
        return System.getProperty("os.name").startsWith("Windows");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jTextField5 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton_MYProfile_ = new javax.swing.JButton();
        jButton_LOGOUT = new javax.swing.JButton();
        pp = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        list1 = new java.awt.List();
        jLabel3 = new javax.swing.JLabel();
        jButton_Profile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        jTextArea1.setBackground(new java.awt.Color(102, 102, 102));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel5.setText("Message : ");

        jButton4.setBackground(new java.awt.Color(51, 0, 153));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Send Message ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(51, 0, 153));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("...");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(51, 0, 153));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Send");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel6.setText("File :");

        jButton_MYProfile_.setBackground(new java.awt.Color(51, 0, 153));
        jButton_MYProfile_.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_MYProfile_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_MYProfile_.setText("My Profile");
        jButton_MYProfile_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MYProfile_ActionPerformed(evt);
            }
        });

        jButton_LOGOUT.setBackground(new java.awt.Color(51, 51, 51));
        jButton_LOGOUT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_LOGOUT.setForeground(new java.awt.Color(255, 255, 255));
        jButton_LOGOUT.setText("Log out");
        jButton_LOGOUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LOGOUTActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Eras Bold ITC", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 153));

        jList1.setModel((model = new DefaultListModel()));
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jTabbedPane1.addTab("online", jScrollPane2);

        list1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list1MouseClicked(evt);
            }
        });
        list1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list1ActionPerformed(evt);
            }
        });
        jTabbedPane1.addTab("All", list1);

        jLabel3.setFont(new java.awt.Font("Eras Bold ITC", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 153));

        jButton_Profile.setBackground(new java.awt.Color(51, 0, 153));
        jButton_Profile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Profile.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Profile.setText("Profile");
        jButton_Profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ProfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(pp, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator1)
                                .addGap(106, 106, 106))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addComponent(jButton_MYProfile_)
                                .addGap(30, 30, 30)
                                .addComponent(jButton_LOGOUT, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_Profile)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 25, Short.MAX_VALUE)
                        .addComponent(pp, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton_MYProfile_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_LOGOUT, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator1)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton_Profile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("online");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String msg = jTextField4.getText();
        int i=jTabbedPane1.getSelectedIndex();
        if (i==0){
        String target = jList1.getSelectedValue().toString();
         if(!msg.isEmpty() && !target.isEmpty()){
        try {
            MyConnection.savepcm(username, msg, target);
        } catch (SQLException ex) {
            Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       
            jTextField4.setText("");
            client.send(new Message("message", username, msg, target));
        }}
        else{
            String target=list1.getSelectedItem();
             if(!msg.isEmpty() && !target.isEmpty()){ 
            try {
            MyConnection.savepcm(username, msg, target);
        } catch (SQLException ex) {
            Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
          jTextField4.setText("");
        jTextArea1.append("ME : " + msg);             }
             }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showDialog(this, "Select File");
        file = fileChooser.getSelectedFile();
        
        if(file != null){
            if(!file.getName().isEmpty()){
                jButton6.setEnabled(true); String str;
                
                if(jTextField5.getText().length() > 30){
                    String t = file.getPath();
                    str = t.substring(0, 20) + " [...] " + t.substring(t.length() - 20, t.length());
                }
                else{
                    str = file.getPath();
                }
                jTextField5.setText(str);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
            long size = file.length();
            if(size < 120 * 1024 * 1024){
                client.send(new Message("upload_req", username, file.getName(), jList1.getSelectedValue().toString()));
            }
            else{
                jTextArea1.append("[Application > Me] : File is size too large\n");
            }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton_MYProfile_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_MYProfile_ActionPerformed
            HomeFrame hf = new HomeFrame(user);
        hf.setVisible(true);
        hf.pack();
        hf.setLocationRelativeTo(null);
        hf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.dispose();
    }//GEN-LAST:event_jButton_MYProfile_ActionPerformed

    private void jButton_LOGOUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LOGOUTActionPerformed
         new LoginForm().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jButton_LOGOUTActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        jTextArea1.setText(null);
        try {
            loadpcm();
        } catch (IOException ex) {
            Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void list1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list1ActionPerformed

    private void list1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list1MouseClicked
        try {
            jTextArea1.setText(null);
            Statement st = null;
            String sender;
            String message;
            String receiver;
            st = MyConnection.getConnection().createStatement();
            ResultSet srs = st.executeQuery("SELECT * FROM public_chat");
            while (srs.next()) {
                sender = srs.getString("sender");
                message = srs.getString("message");
                receiver = srs.getString("receiver");
                if(list1.getSelectedItem().equals("All")){
                    if (receiver.equals("All")) {
                        if(sender.equals(user.getUsername())){
                            jTextArea1.append("ME : " + message + "\n");
                        }else
                            jTextArea1.append( sender +" : " + message + "\n");
                    } 
                }else{
                    if((sender.equals(user.getUsername())) && (receiver.equals(list1.getSelectedItem()))){
                        jTextArea1.append("ME : " + message + "\n");
                    }
                    if(receiver.equals(user.getUsername())){
                        if ((sender.equals(list1.getSelectedItem()))) {
                            jTextArea1.append( sender +" : " + message + "\n");
                        }
                    }}}
        } catch (SQLException ex) {
            Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_list1MouseClicked

    private void jButton_ProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ProfileActionPerformed
int i=jTabbedPane1.getSelectedIndex();
  String uname1 = null;
        if (i==0){         
        uname1=jList1.getSelectedValue().toString();
        }
        else{
           uname1= list1.getSelectedItem();
        }
        if(uname1.equals("All")){
            JOptionPane.showMessageDialog(null, "All is not a user", "No Profile", 2);
        }else{
                User user1=new User();
                try {
  
                    user1=MyConnection.getUser(uname1, MyConnection.createlist());
                } catch (SQLException ex) {
                    Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
        Profile p = new Profile(user1);
        p.setVisible(true);
        p.pack();
        p.setLocationRelativeTo(null);
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton_ProfileActionPerformed
public void loadpcm() throws IOException, SQLException {
        
            Statement st = null;
            String sender;
            String message;
            String receiver;
            st = MyConnection.getConnection().createStatement();
            ResultSet srs = st.executeQuery("SELECT * FROM public_chat");
            while (srs.next()) {
                sender = srs.getString("sender");
                message = srs.getString("message");
                receiver = srs.getString("receiver");
                if(jList1.getSelectedValue().toString().equals("All")){
                   if (receiver.equals("All")) {
                       if(sender.equals(user.getUsername())){
                           jTextArea1.append("ME : " + message + "\n");
                       }else
                   jTextArea1.append( sender +" : " + message + "\n");
               } 
                }else{
                if((sender.equals(user.getUsername()) && (receiver.equals(jList1.getSelectedValue().toString())))){
                    jTextArea1.append("ME : " + message + "\n");             
                }
                if((receiver.equals(user.getUsername()) && (sender.equals(jList1.getSelectedValue().toString())))){
                    jTextArea1.append( sender +" : " + message + "\n");             
                }
                }
            }
        
    }
public ImageIcon ResizeImage(String ImagePath)
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(pp.getWidth(), pp.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch(Exception ex){
        
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String uname="sarah";
                User user=new User();
                try {
                    user=MyConnection.getUser(uname, MyConnection.createlist());
                } catch (SQLException ex) {
                    Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                new ChatFrame(user).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton4;
    public javax.swing.JButton jButton5;
    public javax.swing.JButton jButton6;
    private javax.swing.JButton jButton_LOGOUT;
    private javax.swing.JButton jButton_MYProfile_;
    private javax.swing.JButton jButton_Profile;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTextArea jTextArea1;
    public javax.swing.JTextField jTextField4;
    public javax.swing.JTextField jTextField5;
    private java.awt.List list1;
    private javax.swing.JLabel pp;
    // End of variables declaration//GEN-END:variables
}
