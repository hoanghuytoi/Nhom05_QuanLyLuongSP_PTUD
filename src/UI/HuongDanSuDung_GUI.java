package UI;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import Custom_UI.ScrollBarCustom;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HuongDanSuDung_GUI extends JPanel {
    private JLabel lblHDSD;
    private JPanel panel;
    private JLabel lblPhongBan;
    private JLabel lblToNhom;
    private JLabel lblHopDong;
    private JLabel lblSanPham;
    private JLabel lblNhanVien;
	private JLabel lblCongNhan;
	private JLabel lblThongKe;
	private JPanel panelBody;
	private JScrollPane scrollPane;

    public HuongDanSuDung_GUI() {
        setBackground(new Color(255, 255, 255));
        initComponents();
        showImages("/image/hdsd/PB.png");

    }

    private void initComponents() {
        setSize(1290, 750);
        setLayout(null);

        lblHDSD = new JLabel("HƯỚNG DẪN SỬ DỤNG ");
        lblHDSD.setIcon(new ImageIcon(HuongDanSuDung_GUI.class.getResource("/image/icon/hotro.png")));
        lblHDSD.setBounds(499, 11, 359, 51);
        lblHDSD.setHorizontalAlignment(SwingConstants.CENTER);
        lblHDSD.setFont(new Font("Times New Roman", Font.BOLD, 25));
        add(lblHDSD);

        panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 165, 0)));
        panel.setBounds(86, 83, 200, 618);
        add(panel);
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        // Menu items
        lblPhongBan = createMenuItem("Phòng ban");
        lblToNhom = createMenuItem("Tổ nhóm");
        lblHopDong = createMenuItem("Hơp đồng");
        lblSanPham = createMenuItem("Sản phẩm");
        lblNhanVien = createMenuItem("Nhân viên");     
        lblCongNhan = createMenuItem("Công nhân");
        lblThongKe = createMenuItem("Thống kê");

        panel.add(lblPhongBan);
        lblPhongBan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	showImages("/image/hdsd/PB.png");
            }
        });
        
        panel.add(lblToNhom);
        lblToNhom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	showImages("/image/hdsd/TN.png");
            }
        });
        
        panel.add(lblHopDong);
        lblHopDong.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	showImages("/image/hdsd/HD.png");
            }
        });
        
        panel.add(lblSanPham);
        lblSanPham.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showImages("/image/hdsd/SP.png", "/image/hdsd/CDSP.png", "/image/hdsd/TKSP.png");
            }
        });
        
        panel.add(lblNhanVien);
        lblNhanVien.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showImages("/image/hdsd/NV.png", "/image/hdsd/CCNV.png", "/image/hdsd/LNV.png", "/image/hdsd/TKNV.png");
            }
        });
        
        panel.add(lblCongNhan);
        lblCongNhan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showImages("/image/hdsd/CN.png", "/image/hdsd/PCCN.png", "/image/hdsd/CCCN.png", "/image/hdsd/LCN.png", "/image/hdsd/TKCN.png");
            }
        });
        
        panel.add(lblThongKe);
        lblThongKe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showImages("/image/hdsd/TKDT.png", "/image/hdsd/TKeNV.png", "/image/hdsd/TKeCN.png");
            }
        });
        
        panelBody = new JPanel();
        panelBody.setBorder(new MatteBorder(3, 5, 3, 3, (Color) new Color(255, 215, 0)));
        panelBody.setBackground(new Color(255, 255, 255));
        panelBody.setLayout(new BorderLayout());

        scrollPane = new JScrollPane(panelBody);
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(286, 83, 948, 618);

        ScrollBarCustom scrollBar = new ScrollBarCustom();
		scrollBar.setForeground(Color.RED);
		scrollPane.setVerticalScrollBar(scrollBar);
		
        add(scrollPane);
    }

    private JLabel createMenuItem(String text) {
        JLabel lblMenuItem = new JLabel(" " + text);
        lblMenuItem.setIcon(new ImageIcon(HuongDanSuDung_GUI.class.getResource("/image/icon/dot.png")));
        lblMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
        lblMenuItem.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        lblMenuItem.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        return lblMenuItem;
    }

    private void showImages(String... imagePaths) {
        panelBody.removeAll();

        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.WHITE);
        imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS)); // Sử dụng BoxLayout cho sắp xếp theo chiều dọc

        for (String imagePath : imagePaths) {
            JLabel imageLabel = new JLabel();
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath));
            imageLabel.setIcon(imageIcon);

            // Tạo một Box để chứa imageLabel và canh giữa nó
            Box box = Box.createHorizontalBox();
            box.add(Box.createHorizontalGlue()); // Canh giữa
            box.add(imageLabel);
            box.add(Box.createHorizontalGlue()); // Canh giữa

            imagePanel.add(box);

            // Thêm khoảng cách tùy chọn giữa các ảnh
            imagePanel.add(Box.createRigidArea(new Dimension(0, 10))); // Điều chỉnh khoảng cách nếu cần thiết
        }

        // Đưa imagePanel vào JScrollPane và thêm vào panelBody
        JScrollPane scrollPane = new JScrollPane(imagePanel);
        panelBody.add(scrollPane, BorderLayout.CENTER);

        panelBody.revalidate();
        panelBody.repaint();
    }

}
