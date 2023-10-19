package Custom_UI;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JSeparator;

/**
 *
 * @author December
 */
public class MenuItem extends javax.swing.JPanel {

	private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JLabel lbIcon;
    private JLabel lbName;
    
    public void setShowing(boolean showing) {
        this.showing = showing;
    }
    private final ArrayList<MenuItem> subMenu = new ArrayList<>();
    private ActionListener act;
    
    public MenuItem(Icon icon, String menuName, ActionListener act, MenuItem... subMenu) {
        initComponents();
        lbIcon.setIcon(icon);
        lbName.setText(menuName);
        if (act != null) {
            this.act = act;
        }
        int size=80;
        this.setSize(new Dimension(Integer.MAX_VALUE, size));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, size));
        this.setMinimumSize(new Dimension(Integer.MAX_VALUE, size));
        for (int i = 0; i < subMenu.length; i++) {
            this.subMenu.add(subMenu[i]);
            subMenu[i].setVisible(false);
        }
    }
    public void setIcon(Icon icon){
        lbIcon.setIcon(icon);
    }
    private void showMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < subMenu.size(); i++) {
                    sleep();
                    subMenu.get(i).setVisible(true);
                }
                showing = true;
                getParent().repaint();
                getParent().revalidate();
            }
        }).start();
    }

    private void hideMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = subMenu.size() - 1; i >= 0; i--) {
                    sleep();
                    subMenu.get(i).setVisible(false);
                    subMenu.get(i).hideMenu();
                }
                getParent().repaint();
                getParent().revalidate();
                showing = false;
            }
        }).start();
    }

    private void sleep() {
        try {
            Thread.sleep(20);
        } catch (Exception e) {
        }
    }

    
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        lbIcon = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(32767, 32767));
        setPreferredSize(new java.awt.Dimension(210, 65));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/congnhan.png"))); 
        add(lbIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 70));

        lbName.setFont(new java.awt.Font("Segoe UI", 0, 16));
        lbName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbName.setText("Menu name here....");
        lbName.setPreferredSize(new java.awt.Dimension(113, 50));
        add(lbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 170, -1));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 250, -1));
    }

    private boolean showing = false;
    private void formMousePressed(java.awt.event.MouseEvent evt) {
        if (showing) {
            hideMenu();
            showing = false;
        } else {
            showMenu();
            showing = true;
        }
        if(this.act !=null){
            act.actionPerformed(null);
        }
    }
    public ArrayList<MenuItem> getSubMenu() {
        return subMenu;
    }
}
