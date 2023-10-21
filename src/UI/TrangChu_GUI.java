package UI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ScrollPaneConstants;

public class TrangChu_GUI extends JPanel {
	private JLabel iconPhongBan;
    private JLabel iconToNhom;
    private JLabel iconNhanVien;
    private JLabel iconCongNhan;
    private JPanel pnTongSoLuong;
    private JLabel lblPhongBan;
    private JLabel lblToNhom;
    private JLabel lblNhanVien;
    private JLabel lblCongNhan;
    private JLabel lblTongPhongBan;
    private JLabel lblTongToNhom;
    private JLabel lblTongNhanVien;
    private JLabel lblTongCongNhan;
    private Custom_UI.RoundedBorder pnPhongBan;
    private Custom_UI.RoundedBorder pnToNhom;
    private Custom_UI.RoundedBorder pnNhanVien;
    private Custom_UI.RoundedBorder pnCongNhan;
    private JScrollPane scrollPane;
    private JPanel panelAnh;
    private JLabel lblAnhSP;
    private JLabel lblAnhCN;
    
    public TrangChu_GUI() {
    	setBackground(new Color(255, 255, 255));
    	initComponents();
    }
    

	 private void initComponents() {
	    setSize(1290, 750);

		setLayout(null);
		pnTongSoLuong = new JPanel();
		pnTongSoLuong.setBounds(0, 0, 1290, 242);
		
        pnNhanVien = new Custom_UI.RoundedBorder();
        pnNhanVien.setBounds(664, 40, 260, 160);
        lblNhanVien = new JLabel();
        lblNhanVien.setBounds(-20, -10, 300, 60);
        iconNhanVien = new JLabel();
        iconNhanVien.setBounds(20, 60, 120, 120);
        lblTongNhanVien = new JLabel();
        lblTongNhanVien.setBounds(170, 80, 90, 60);
        
        pnToNhom = new Custom_UI.RoundedBorder();
        pnToNhom.setBounds(354, 40, 260, 160);
        lblToNhom = new JLabel();
        lblToNhom.setBounds(-10, 0, 270, 40);
        iconToNhom = new JLabel();
        iconToNhom.setBounds(20, 60, 120, 120);
        lblTongToNhom = new JLabel();
        lblTongToNhom.setBounds(160, 70, 80, 60);
        
        pnPhongBan = new Custom_UI.RoundedBorder();
        pnPhongBan.setBounds(47, 40, 260, 160);
        lblTongPhongBan = new JLabel();
        lblTongPhongBan.setBounds(150, 70, 120, 60);
        lblPhongBan = new JLabel();
        lblPhongBan.setBounds(0, 0, 220, 40);
        iconPhongBan = new JLabel();
        iconPhongBan.setBounds(20, 60, 120, 128);
        
        pnCongNhan = new Custom_UI.RoundedBorder();
        pnCongNhan.setBounds(971, 40, 260, 160);
        lblCongNhan = new JLabel();
        lblCongNhan.setBounds(30, 0, 220, 50);
        iconCongNhan = new JLabel();
        iconCongNhan.setBounds(20, 60, 120, 120);
        lblTongCongNhan = new JLabel();
        lblTongCongNhan.setBounds(170, 70, 90, 60);

        pnTongSoLuong.setBackground(new Color(255, 255, 255));
        pnTongSoLuong.setPreferredSize(new Dimension(1250, 300));
        pnTongSoLuong.setLayout(null);

        pnPhongBan.setBackground(new Color(102, 255, 204));
        pnPhongBan.setLayout(null);

        lblTongPhongBan.setFont(new Font("Times New Roman", Font.BOLD, 32)); 
        lblTongPhongBan.setForeground(new Color(255, 255, 255));
        lblTongPhongBan.setHorizontalAlignment(SwingConstants.LEFT);
        lblTongPhongBan.setText("1000");
        pnPhongBan.add(lblTongPhongBan);

        lblPhongBan.setFont(new Font("Times New Roman", Font.BOLD, 26)); 
        lblPhongBan.setForeground(new Color(255, 255, 255));
        lblPhongBan.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhongBan.setText("Tổng phòng ban");
        pnPhongBan.add(lblPhongBan);

        iconPhongBan.setFont(new Font("Segoe UI", 1, 26)); 
        iconPhongBan.setForeground(new Color(255, 255, 255));
        iconPhongBan.setHorizontalAlignment(SwingConstants.LEFT);
        iconPhongBan.setIcon(new ImageIcon(TrangChu_GUI.class.getResource("/image/trangChu/slphongban.png")));
        pnPhongBan.add(iconPhongBan);

        pnTongSoLuong.add(pnPhongBan);

        pnToNhom.setBackground(new Color(102, 102, 255));
        pnToNhom.setLayout(null);

        lblToNhom.setFont(new Font("Times New Roman", Font.BOLD, 26)); 
        lblToNhom.setForeground(new Color(255, 255, 255));
        lblToNhom.setHorizontalAlignment(SwingConstants.CENTER);
        lblToNhom.setText("Tổng tổ nhóm");
        pnToNhom.add(lblToNhom);

        iconToNhom.setFont(new Font("Segoe UI", 1, 26)); 
        iconToNhom.setForeground(new Color(255, 255, 255));
        iconToNhom.setHorizontalAlignment(SwingConstants.LEFT);
        iconToNhom.setIcon(new ImageIcon(getClass().getResource("/image/trangChu/sltonhom.png"))); 
        pnToNhom.add(iconToNhom);

        lblTongToNhom.setFont(new Font("Times New Roman", Font.BOLD, 32));
        lblTongToNhom.setForeground(new Color(255, 255, 255));
        lblTongToNhom.setHorizontalAlignment(SwingConstants.LEFT);
        lblTongToNhom.setText("1000");
        pnToNhom.add(lblTongToNhom);

        pnTongSoLuong.add(pnToNhom);

        pnNhanVien.setBackground(new Color(255, 0, 153));
        pnNhanVien.setLayout(null);

        lblNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 26)); 
        lblNhanVien.setForeground(new Color(255, 255, 255));
        lblNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        lblNhanVien.setText("Tổng nhân viên");
        pnNhanVien.add(lblNhanVien);

        iconNhanVien.setFont(new Font("Segoe UI", 1, 26)); 
        iconNhanVien.setForeground(new Color(255, 255, 255));
        iconNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
        iconNhanVien.setIcon(new ImageIcon(TrangChu_GUI.class.getResource("/image/trangChu/slnhanvien.png"))); 
        pnNhanVien.add(iconNhanVien);

        lblTongNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 32)); 
        lblTongNhanVien.setForeground(new Color(255, 255, 255));
        lblTongNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
        lblTongNhanVien.setText("1000");
        pnNhanVien.add(lblTongNhanVien);

        pnTongSoLuong.add(pnNhanVien);

        pnCongNhan.setBackground(new Color(153, 204, 204));
        pnCongNhan.setLayout(null);

        lblCongNhan.setFont(new Font("Times New Roman", Font.BOLD, 26)); 
        lblCongNhan.setForeground(new Color(255, 255, 255));
        lblCongNhan.setHorizontalAlignment(SwingConstants.CENTER);
        lblCongNhan.setText("Tổng công nhân");
        pnCongNhan.add(lblCongNhan);

        iconCongNhan.setFont(new Font("Segoe UI", 1, 26)); 
        iconCongNhan.setForeground(new Color(255, 255, 255));
        iconCongNhan.setHorizontalAlignment(SwingConstants.LEFT);
        iconCongNhan.setIcon(new ImageIcon(TrangChu_GUI.class.getResource("/image/trangChu/slcongnhan.png")));
        pnCongNhan.add(iconCongNhan);

        lblTongCongNhan.setFont(new Font("Times New Roman", Font.BOLD, 32)); 
        lblTongCongNhan.setForeground(new Color(255, 255, 255));
        lblTongCongNhan.setHorizontalAlignment(SwingConstants.LEFT);
        lblTongCongNhan.setText("1000");
        pnCongNhan.add(lblTongCongNhan);

        pnTongSoLuong.add(pnCongNhan);

        add(pnTongSoLuong,BorderLayout.PAGE_START);
        
        JPanel panelGioiThieu = new JPanel();
        panelGioiThieu.setBackground(Color.WHITE);
        panelGioiThieu.setForeground(Color.WHITE);
        panelGioiThieu.setBounds(48, 243, 567, 344);
        add(panelGioiThieu);
        panelGioiThieu.setLayout(null);
        
        JLabel lblGioiThieu = new JLabel("Giới thiệu");
        lblGioiThieu.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblGioiThieu.setBounds(0, 0, 95, 24);
        panelGioiThieu.add(lblGioiThieu);
        
        // Tạo một JTextArea với tự động xuống dòng
        JTextArea textGioiThieu = new JTextArea();
        textGioiThieu.setLineWrap(true);
        textGioiThieu.setWrapStyleWord(true);
        textGioiThieu.setBounds(10, 45, 543, 288);
        panelGioiThieu.add(textGioiThieu);
        
        textGioiThieu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
        textGioiThieu.setForeground(Color.BLACK);

        // Đặt màu nền và màu viền
        textGioiThieu.setBackground(new Color(255, 255, 240));
        textGioiThieu.setBorder(new LineBorder(new Color(245, 245, 245), 3));
        
        // Thêm nội dung giới thiệu vào JTextArea
        String noiDungGioiThieu = " Chào mừng bạn đến với Hệ thống Quản lý Lương Sản phẩm của công ty PacePro - một giải pháp đột phá để quản lý và tối ưu hóa tiền lương cho nhân viên hành chánh và công nhân. Với sự tích hợp hoàn hảo giữa quản lý hợp đồng, sản xuất sản phẩm và tính toán lương, chúng tôi cam kết giúp công ty của bạn đạt được hiệu suất và hiệu quả tài chính tối đa.\r\n"
        		+ "\r\n"
        		+ " Hệ thống của chúng tôi không chỉ ghi nhận chi tiết đầy đủ về hợp đồng và sản phẩm, mà còn theo dõi công đoạn sản xuất và kết quả làm việc của từng nhân viên. Với khả năng tính toán linh hoạt và tự động, chúng tôi giúp đảm bảo rằng công nhân và nhân viên hành chánh của bạn nhận được mức lương xứng đáng với công sức và thời gian làm việc của họ.\r\n"
        		+ "\r\n"
        		+ " Bên cạnh việc quản lý lương hàng ngày, hệ thống của chúng tôi cũng hỗ trợ tính toán lương ngoài giờ, quản lý các khoản phụ cấp chức vụ, và tạo phiếu lương tự động. Chúng tôi đặt sự tiện lợi và chính xác lên hàng đầu để giúp bạn tiết kiệm thời gian và giảm thiểu sai sót trong quá trình tính toán lương.\r\n"
        		+ "\r\n"
        		+ " Dễ dàng sử dụng và tích hợp, hệ thống quản lý lương sản phẩm của PacePro giúp công ty bạn thúc đẩy sự chuyên nghiệp và hiệu suất trong việc quản lý tài chính và nguồn nhân lực. Hãy để chúng tôi đồng hành cùng bạn trong việc quản lý tiền lương một cách thông minh và hiệu quả hơn bao giờ hết.";
        textGioiThieu.setText(noiDungGioiThieu);

        // Tạo JScrollPane với thanh cuộn dọc
        JScrollPane scrollPane = new JScrollPane(textGioiThieu);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setViewportBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(0, 255, 255), new Color(220, 20, 60), new Color(255, 0, 255), new Color(50, 205, 50)));
        scrollPane.setEnabled(false);
        scrollPane.setBounds(0, 45, 567, 299);
        panelGioiThieu.add(scrollPane);
        
        
        panelAnh = new JPanel();
        panelAnh.setBounds(664, 243, 567, 344);
        add(panelAnh);
        panelAnh.setLayout(null);
        
        lblAnhSP = new JLabel("");
        lblAnhSP.setIcon(new ImageIcon(TrangChu_GUI.class.getResource("/image/trangChu/anhSanPham.PNG")));
        lblAnhSP.setBounds(0, 190, 260, 154);
        panelAnh.add(lblAnhSP);
        
        lblAnhCN = new JLabel("");
        lblAnhCN.setIcon(new ImageIcon(TrangChu_GUI.class.getResource("/image/trangChu/anhCongNhan.PNG")));
        lblAnhCN.setBounds(307, 190, 260, 154);
        panelAnh.add(lblAnhCN);
        
        JLabel lblAnhHD = new JLabel("");
        lblAnhHD.setIcon(new ImageIcon(TrangChu_GUI.class.getResource("/image/trangChu/anhHopDong.PNG")));
        lblAnhHD.setBounds(0, 0, 260, 154);
        panelAnh.add(lblAnhHD);
        
        JLabel lblAnhNV = new JLabel("");
        lblAnhNV.setIcon(new ImageIcon(TrangChu_GUI.class.getResource("/image/trangChu/anhNhanVien.PNG")));
        lblAnhNV.setBounds(307, 0, 260, 154);
        panelAnh.add(lblAnhNV);
        
        JLabel lblTVNhom = new JLabel("Thành viên nhóm 5");
        lblTVNhom.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lblTVNhom.setBounds(519, 610, 254, 50);
        add(lblTVNhom);
        
        JLabel lblName = new JLabel("Hoàng Huy Tới");
        lblName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        lblName.setBounds(48, 679, 146, 35);
        add(lblName);
        
        JLabel lblName1 = new JLabel("Huỳnh Công Vương");
        lblName1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        lblName1.setBounds(352, 679, 177, 35);
        add(lblName1);
        
        JLabel lblName2 = new JLabel("Lê Phan Ngọc Minh");
        lblName2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        lblName2.setBounds(723, 679, 177, 35);
        add(lblName2);
        
        JLabel lblName3 = new JLabel("Nguyễn Việt Hùng");
        lblName3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
        lblName3.setBounds(1054, 679, 177, 35);
        add(lblName3);

		
//        setUndecorated(true);
	}
	 
	 public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						TrangChu_GUI frame = new TrangChu_GUI();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
}
