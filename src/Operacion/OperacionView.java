package Operacion;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Beat.DJTestDrive;
import Heart.HeartTestDrive;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class OperacionView extends JFrame implements ActionListener{
	public Image imagenFondo;
	public URL fondo;
	private JPanel contentPane;
	JButton btnNewButton = new JButton("Curar");
	JButton btnNewButton_1 = new JButton("Curar");
	JButton btnCurar = new JButton("Curar");
	JButton btnCurar_1 = new JButton("Curar");
	JButton btnCurar_2 = new JButton("Curar");
	JButton btnCurar_3 = new JButton("Curar");
	JButton btnCurar_4 = new JButton("Curar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperacionView frame = new OperacionView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OperacionView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 400, 400);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		fondo=this.getClass().getResource("/Operacion/CuerpoHumano.jpg");
		imagenFondo= new ImageIcon(fondo).getImage();
		
		JPanel panel = new JPanel(){
			public void paintComponent(Graphics g){
				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			}		
		};
		//Container contenedor= getContentPane();
		//contenedor.add(panel);
		contentPane.add(panel, BorderLayout.CENTER);
		
		btnNewButton.addActionListener(this);
		
		btnNewButton_1.addActionListener(this);
		
		btnCurar.addActionListener(this);
		
		btnCurar_1.addActionListener(this);
		
		btnCurar_2.addActionListener(this);
		
		btnCurar_3.addActionListener(this);
		
		btnCurar_4.addActionListener(this);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
							.addComponent(btnCurar)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addGap(31))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btnCurar_4)
							.addPreferredGap(ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
							.addComponent(btnCurar_1)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btnCurar_3)
							.addPreferredGap(ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
							.addComponent(btnCurar_2)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnNewButton_1)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(25)
							.addComponent(btnNewButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(45)
							.addComponent(btnCurar)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(87)
							.addComponent(btnCurar_1)
							.addPreferredGap(ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
							.addComponent(btnCurar_2)
							.addGap(39))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCurar_4)
							.addGap(76)
							.addComponent(btnCurar_3)
							.addGap(48))))
		);
		panel.setLayout(gl_panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNewButton){
        	System.out.println("1");
        	         	
        }
        else if(e.getSource() == btnNewButton_1){
        	System.out.println("2");

        }
        else if(e.getSource() == btnCurar){
        	System.out.println("3");

        }
        else if(e.getSource() == btnCurar_1){
        	System.out.println("4");

        }
        else if(e.getSource() == btnCurar_2){
        	System.out.println("5");

        }
        else if(e.getSource() == btnCurar_3){
        	System.out.println("6");

        }
        else if(e.getSource() == btnCurar_4){
        	System.out.println("7");

        }
	}

}
