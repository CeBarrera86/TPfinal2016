package Operacion;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Beat.BPMObserver;
import Beat.ControllerInterface;
import Beat.DJTestDrive;
import Heart.HeartTestDrive;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class OperacionView extends JFrame implements ActionListener, CuerpoObserver{
	ControllerInterface  controller;
	OperacionModelInterface model;
	
	public Image imagenFondo;
	public URL fondo;
	private JPanel contentPane;
	
	boolean juegoTerminado=false;
	
	JButton btnNewButton = new JButton("Curar");
	JButton btnNewButton_1 = new JButton("Curar");
	JButton btnCurar = new JButton("Curar");
	JButton btnCurar_1 = new JButton("Curar");
	JButton btnCurar_2 = new JButton("Curar");
	JButton btnCurar_3 = new JButton("Curar");
	JButton btnCurar_4 = new JButton("Curar");
	
	JButton btnRecomenzar = new JButton("Recomenzar");
	
	JLabel lblProblemaCardiaco = new JLabel("Vena Cava Superior");
	JLabel lblNewLabel = new JLabel("");
	
	Random rand=new Random();
	String problema;
	int causa=0;


	/**
	 * Create the frame.
	 */
	public OperacionView(ControllerInterface controller, OperacionModelInterface model) {
		this.controller=controller;
		this.model = model;
		model.registerObserver((CuerpoObserver)this);
		
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Ravie", Font.PLAIN, 16));
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
		
		btnRecomenzar.addActionListener(this);
		
		btnRecomenzar.setFont(new Font("Tahoma", Font.BOLD, 11));
				
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
							.addComponent(btnCurar))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnCurar_4)
							.addPreferredGap(ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
							.addComponent(btnCurar_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnCurar_3)
							.addPreferredGap(ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
							.addComponent(btnCurar_2)))
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addComponent(lblProblemaCardiaco)
					.addPreferredGap(ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(31))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(72)
					.addComponent(lblNewLabel)
					.addContainerGap(312, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(139)
					.addComponent(btnRecomenzar)
					.addContainerGap(142, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1)
						.addComponent(lblProblemaCardiaco))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(25)
							.addComponent(btnNewButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(45)
							.addComponent(btnCurar)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(32)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
							.addComponent(btnCurar_4)
							.addGap(76)
							.addComponent(btnCurar_3)
							.addGap(48))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(87)
							.addComponent(btnCurar_1)
							.addPreferredGap(ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
							.addComponent(btnCurar_2)
							.addGap(40))))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(339, Short.MAX_VALUE)
					.addComponent(btnRecomenzar))
		);
		panel.setLayout(gl_panel);
	}
	
	public void cambiarProblema(){
		causa=rand.nextInt(7);
		if(causa==0){
			problema="Vena Cava Superior";
		}
		else if(causa==1){
			problema="Aorta";
		}
		else if(causa==2){
			problema="Corazon";
		}
		else if(causa==3){
			problema="Aorta Descendente";
		}
		else if(causa==4){
			problema="Riñon Izquierdo";
		}
		else if(causa==5){
			problema="Riñon Derecho";
		}
		else if(causa==6){
			problema="Vena Cava Inferior";
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println(juegoTerminado);
		if(!juegoTerminado){
		if(e.getSource() == btnNewButton){
        	if(causa==0){
        		controller.setBPM(60); 
        		cambiarProblema();
        		lblProblemaCardiaco.setText(problema);
        	}
        	else{
        		controller.setBPMdead();
        		//lblNewLabel.setText("Your Pacient is DEAD!!");
        	}
        }
        else if(e.getSource() == btnNewButton_1){
        	if(causa==1){
        		controller.setBPM(60); 
        		cambiarProblema();
        		lblProblemaCardiaco.setText(problema);
        	}
        	else{
        		controller.setBPMdead();
        		//lblNewLabel.setText("Your Pacient is DEAD!!");
        	}
        }
        else if(e.getSource() == btnCurar){
        	if(causa==2){
        		controller.setBPM(60); 
        		cambiarProblema();
        		lblProblemaCardiaco.setText(problema);
        	}
        	else{
        		controller.setBPMdead();
        		//lblNewLabel.setText("Your Pacient is DEAD!!");
        	}
        }
        else if(e.getSource() == btnCurar_1){
        	if(causa==3){
        		controller.setBPM(60); 
        		cambiarProblema();
        		lblProblemaCardiaco.setText(problema);
        	}
        	else{
        		controller.setBPMdead();
        		//lblNewLabel.setText("Your Pacient is DEAD!!");
        	}
        }
        else if(e.getSource() == btnCurar_2){
        	if(causa==4){
        		controller.setBPM(60); 
        		cambiarProblema();
        		lblProblemaCardiaco.setText(problema);
        	}
        	else{
        		controller.setBPMdead();
        		//lblNewLabel.setText("Your Pacient is DEAD!!");
        	}
        }
        else if(e.getSource() == btnCurar_3){
        	if(causa==5){
        		controller.setBPM(60); 
        		cambiarProblema();
        		lblProblemaCardiaco.setText(problema);
        	}
        	else{
        		controller.setBPMdead();
        		//lblNewLabel.setText("Your Pacient is DEAD!!");
        	}
        }
        else if(e.getSource() == btnCurar_4){
        	if(causa==6){
        		controller.setBPM(60); 
        		cambiarProblema();
        		lblProblemaCardiaco.setText(problema);
        	}
        	else{
        		controller.setBPMdead();
        		//lblNewLabel.setText("Your Pacient is DEAD!!");
        	}
        }
		}
		if(e.getSource() == btnRecomenzar){
        	model.recomenzar();
        }
	}

	@Override
	public void updateCuerpo(boolean b) {
		if(!b){                                           //MUERTE!
			juegoTerminado=true;
			lblNewLabel.setText("Your Patient is DEAD!!");
			//controller.setBPMdead();	
		}
		else{                                              //REINICIAR
			juegoTerminado=false;
			lblNewLabel.setText("");
		}
	}
}
