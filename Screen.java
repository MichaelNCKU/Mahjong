package maJong;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Screen extends JFrame implements ActionListener {

	public static void main(String[] args) {
		// initial environment setting start from here
		JFrame frame = new JFrame();
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close screen setting
		frame.setTitle("麻將三缺一");
		frame.setLayout(null); // figure position setting
//		frame.getContentPane().setBackground(Color.WHITE);  //background color

		// show players
		try {
			// front player
			ImageIcon front_player = new ImageIcon(new URL("https://is.gd/h3mqyx"));
			front_player.setImage(front_player.getImage().getScaledInstance(500, 50, Image.SCALE_DEFAULT));
			JLabel lb = new JLabel(front_player);
			lb.setLocation(200, 200); // 設定位置
			frame.add(lb);

			// left player
			ImageIcon left_player = new ImageIcon(new URL("https://is.gd/MNHQUU"));
			left_player.setImage(left_player.getImage().getScaledInstance(50, 500, Image.SCALE_DEFAULT));
			JLabel lb2 = new JLabel(left_player);
//			lb.setBounds(200, 200, 100, 500); // 設定位置
			frame.add(lb2);

			// right player
			ImageIcon right_player = new ImageIcon(new URL("https://is.gd/MNHQUU"));
			right_player.setImage(right_player.getImage().getScaledInstance(50, 500, Image.SCALE_DEFAULT));
			JLabel lb3 = new JLabel(right_player);
			frame.add(lb3, BorderLayout.EAST);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		//eat,pong,gong area
		String[] popcard = {"D4","D5"};
		String[] temp_address = new String[2];
		ImageIcon[] icon = new ImageIcon[2];
		for(int i=0; i<temp_address.length; i++) {
			temp_address[i] = find_address(popcard[i]);
		}
		////////////////////////////////////////
		int rows = 1;   //we assume the no. of rows and cols are known and each chunk has equal width and height
        int cols = 2;
        int chunks = rows * cols;

        int chunkWidth, chunkHeight;
        int type;
        //fetching image files
//        File[] imgFiles = new File[chunks];
//        for (int i = 0; i < chunks; i++) {
//            imgFiles[i] = new File(temp_address[i]);
//        }

       //creating a bufferd image array from image files
        BufferedImage[] buffImages = new BufferedImage[chunks];
        for (int i = 0; i < chunks; i++) {
            try {
				buffImages[i] = ImageIO.read(new File(temp_address[i]));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
        }
        type = buffImages[0].getType();
        chunkWidth = buffImages[0].getWidth();
        chunkHeight = buffImages[0].getHeight();

        //Initializing the final image
        BufferedImage finalImg = new BufferedImage(chunkWidth*cols, chunkHeight*rows, type);

        int num = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                finalImg.createGraphics().drawImage(buffImages[num], chunkWidth * j, chunkHeight * i, null);
                num++;
            }
        }
        ImageIcon temp_icon = new ImageIcon(finalImg);
        JButton eat_btn_1 = new JButton(temp_icon);
        frame.add(eat_btn_1);
        
       //////////////////////////////////////////////////////////////////////
		
		
		

		// initial environment setting end

		String[] handcard = { "B2", "B4", "B5", "B6", "C7", "C8", "C9", "D1", "D2", "WE", "WW", "WS", "DG", "DG", "DW",
				"WN" }; // testing handcard

		// get handcard address
		String[] address = new String[16]; // address array
		for (int i = 0; i < handcard.length; i++)
			address[i] = find_address(handcard[i]);

		// get button array
		JButton[] btn = new JButton[16];
		for (int i = 0; i < address.length; i++)
			btn[i] = get_button(address[i]);

		// initial handcard display
		for (int i = 0; i < btn.length; i++)
			display(btn[i], frame, i);

		
		
		
		
		frame.setVisible(true); // show screen

	}// main end

	// get address array
	public static String find_address(String handcard) {
		Map<String, String> map_B = new HashMap<>();
		Map<String, String> map_C = new HashMap<>();
		Map<String, String> map_D = new HashMap<>();
		Map<String, String> map_W = new HashMap<>();

		try {
			map_B.put("B1", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\B1.jpg");
			map_B.put("B2", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\B2.jpg");
			map_B.put("B3", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\B3.jpg");
			map_B.put("B4", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\B4.jpg");
			map_B.put("B5", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\B5.jpg");
			map_B.put("B6", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\B6.jpg");
			map_B.put("B7", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\B7.jpg");
			map_B.put("B8", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\B8.jpg");
			map_B.put("B9", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\B9.jpg");
			map_C.put("C1", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\C1.jpg");
			map_C.put("C2", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\C2.jpg");
			map_C.put("C3", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\C3.jpg");
			map_C.put("C4", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\C4.jpg");
			map_C.put("C5", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\C5.jpg");
			map_C.put("C6", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\C6.jpg");
			map_C.put("C7", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\C7.jpg");
			map_C.put("C8", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\C8.jpg");
			map_C.put("C9", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\C9.jpg");
			map_D.put("D1", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\D1.jpg");
			map_D.put("D2", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\D2.jpg");
			map_D.put("D3", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\D3.jpg");
			map_D.put("D4", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\D4.jpg");
			map_D.put("D5", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\D5.jpg");
			map_D.put("D6", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\D6.jpg");
			map_D.put("D7", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\D7.jpg");
			map_D.put("D8", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\D8.jpg");
			map_D.put("D9", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\D9.jpg");
			map_D.put("DR", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\DR.jpg");
			map_D.put("DW", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\DW.png");
			map_D.put("DG", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\DG.jpg");
			map_W.put("WW", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\WW.jpg");
			map_W.put("WE", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\WE.jpg");
			map_W.put("WN", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\WN.jpg");
			map_W.put("WS", "D:\\Users\\USER\\eclipse-workspace\\MaJong\\src\\maJong\\mahjong_pic\\WS.jpg");
		} catch (Exception e) {
			e.printStackTrace();
		}

		String address = null;

		if (handcard.charAt(0) == 'B') {
			address = map_B.get(handcard);
		} else if (handcard.charAt(0) == 'C') {
			address = map_C.get(handcard);
		} else if (handcard.charAt(0) == 'D') {
			address = map_D.get(handcard);
		} else if (handcard.charAt(0) == 'W') {
			address = map_W.get(handcard);
		}

		return address;

	}

	// get button array
	public static JButton get_button(String address) {
		JButton btn = new JButton();
		try {
			ImageIcon icon = new ImageIcon(ImageIO.read(new File(address)));
			icon.setImage(icon.getImage().getScaledInstance(40, 60, Image.SCALE_DEFAULT)); // 改變icon大小
			btn = new JButton(icon);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return btn;
	}

	// initial location display
	public static void display(JButton btn, JFrame frame, int i) {
		initial_coordination(btn, i);
		frame.add(btn);
	}

	public static void pop_up(JButton btn, JFrame frame, int i) {
		hint_coordination(btn, i);
		frame.add(btn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	// initial coordination of player card
	public static void initial_coordination(JButton btn, int i) {
		int[][] coordinate1 = { { 50, 500 }, { 90, 500 }, { 130, 500 }, { 170, 500 }, { 210, 500 }, { 250, 500 },
				{ 290, 500 }, { 330, 500 }, { 370, 500 }, { 410, 500 }, { 450, 500 }, { 490, 500 }, { 530, 500 },
				{ 570, 500 }, { 610, 500 }, { 650, 500 }, { 690, 500 } };
		btn.setBounds(coordinate1[i][0], coordinate1[i][1], 40, 60);
	}

	// hint coordination of player card
	public static void hint_coordination(JButton btn, int i) {
		int[][] coordinate1 = { { 50, 470 }, { 90, 470 }, { 130, 470 }, { 170, 470 }, { 210, 470 }, { 250, 470 },
				{ 290, 470 }, { 330, 470 }, { 370, 470 }, { 410, 470 }, { 450, 470 }, { 490, 470 }, { 530, 470 },
				{ 570, 470 }, { 610, 470 }, { 650, 470 }, { 690, 470 } };
		btn.setBounds(coordinate1[i][0], coordinate1[i][1], 40, 60);
	}

}
