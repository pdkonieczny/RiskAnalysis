package risk.odds;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;


public class battle {
	final int iterations=10000;
	int Atotal = 0, Dtotal=0, attack_Win=0, defence_Win=0;
	int attack1=0, attack2=0, attack3=0;
	int defend1=0, defend2=0, defend3=0;
	int[] a={1,2,3,4,5,10,15,20,30,50};
	int[] b={-1,0,1}; 
	int attack_Units=0;
	int defence_Units=0;
	int defence_Advantage=0;
	MyButton blistener;
	JLabel units,status;
	JButton battle,war,retreat;
	JFrame frame;
	
	public static void main(String [] args){
		battle b = new battle();
		}
	
	public void starting(){
		frame = new JFrame("Battle");
		String te = JOptionPane.showInputDialog(frame, "How many units are ATTACKING? ");
		attack_Units=Integer.parseInt(te);
		
		te = JOptionPane.showInputDialog(frame, "How many units are DEFENDING? ");
		defence_Units=Integer.parseInt(te);
		
		te = JOptionPane.showInputDialog(frame, "What is the defending advatage (1 for Defending, -1 for Attacking, 0 for even ");
		defence_Advantage=Integer.parseInt(te);
		
		
	    JPanel buttonPanel= new JPanel();
	    frame.setLayout(new GridLayout(3,1));
	    units= new JLabel("Attacking Units: "+attack_Units+" Defending Units: "+defence_Units);
	    status= new JLabel("Battle set to begin...");
	    buttonPanel.setLayout(new GridLayout(1,3));
	    battle= new JButton("ATTACK 3 Units!");
	    blistener=new MyButton();
	    battle.addActionListener(blistener);
	    
	    war= new JButton("FIGHT Entire Invasion");
	    war.addActionListener(blistener);
	    
	    retreat= new JButton("Retreat");
	    retreat.addActionListener(blistener);
	    
	    buttonPanel.add(battle);
	    buttonPanel.add(war);
	    buttonPanel.add(retreat);
	    frame.add(units);
	    frame.add(status);
	    frame.add(buttonPanel);
	    frame.setSize(600, 300);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public battle(){
		starting();
		
			
				
	}
	
	public static int getDice(){
		Random r = new Random();
		int temp=r.nextInt(7);
		while(temp==0){
			temp=r.nextInt(7);
		}
		return temp;
	}
	private class MyButton implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(battle)){
				int battleResult=0;
				if(attack_Units>2){
					attack1=getDice();}
					else{attack1=0;}
					if(attack_Units>1){attack2=getDice();}
					else{attack2=0;}
					attack3=getDice();
					if(defence_Units>1){defend1=getDice();}
					else{defend1=0;}
					defend2=getDice();
					if(attack1<attack2){
						int temp=attack1;
						attack1=attack2;
						attack2=temp;
					}
					if(attack2<attack3){
						int temp=attack2;
						attack2=attack3;
						attack3=temp;
					}
					if(attack1<attack2){
						int temp=attack1;
						attack1=attack2;
						attack2=temp;
					}
					if(defend1<defend2){
						int temp=defend1;
						defend1=defend2;
						defend2=temp;
					}
					if(defend1+defence_Advantage>=attack1){
						battleResult++;
						attack_Units--;
					}else{
						battleResult--;
						defence_Units--;
					}
					if(attack2!=0 && defend2!=0){
					if(defend2>=attack2 ){
						battleResult++;
						attack_Units--;
					}else{
						battleResult--;
						defence_Units--;
					}}

					if(battleResult>0){
						status.setText("attacker rolled: "+attack1+" "+ attack2+" "+ attack3 +" defense rolled: "+ defend1+ " "+defend2+" DEFENCE DOUBLE KILL");
					}
					else if(battleResult<0){
						status.setText("attacker rolled: "+attack1+" "+ attack2+" "+ attack3 +" defense rolled: "+ defend1+ " "+defend2+"    ATTACK DOUBLE KILL");
					}
					else{
						status.setText("attacker rolled: "+attack1+" "+ attack2+" "+ attack3 +" defense rolled: "+ defend1+ " "+defend2+"     SPLIT");

					}
					units.setText("Attacking Units: "+attack_Units+" Defending Units: "+defence_Units);
					if(attack_Units==0 || defence_Units==0){
						JOptionPane.showMessageDialog(frame, "THE WAR IS OVER...  Attacking Units left: "+attack_Units+" Defending Units left: "+ defence_Units);
						frame.dispose();
						starting();
					}
					 
				
				
				
			}else if(e.getSource().equals(war)){
				while(attack_Units>0 && defence_Units>0){
					int battleResult=0;
					if(attack_Units>2){
					attack1=getDice();}
					else{attack1=0;}
					if(attack_Units>1){attack2=getDice();}
					else{attack2=0;}
					attack3=getDice();
					if(defence_Units>1){defend1=getDice();}
					else{defend1=0;}
					defend2=getDice();
					if(attack1<attack2){
						int temp=attack1;
						attack1=attack2;
						attack2=temp;
					}
					if(attack2<attack3){
						int temp=attack2;
						attack2=attack3;
						attack3=temp;
					}
					if(attack1<attack2){
						int temp=attack1;
						attack1=attack2;
						attack2=temp;
					}
					if(defend1<defend2){
						int temp=defend1;
						defend1=defend2;
						defend2=temp;
					}
					if(defend1+defence_Advantage>=attack1){
						battleResult++;
						attack_Units--;
					}else{
						battleResult--;
						defence_Units--;
					}
					if(attack2!=0 && defend2!=0){
					if(defend2>=attack2 ){
						battleResult++;
						attack_Units--;
					}else{
						battleResult--;
						defence_Units--;
					}}

					if(battleResult>0){
						//System.out.println("DEFENCE DOUBLE KILL: "+"Attack Units: "+attack_Units+" Defense Units: "+defence_Units);
					}
					else if(battleResult<0){
							//System.out.println("ATTACK DOUBLE KILL: "+"Attack Units: "+attack_Units+" Defense Units: "+defence_Units);
					}
					else{
						//System.out.println("SPLIT: "+"Attack Units: "+attack_Units+" Defense Units: "+defence_Units);

					}
					//System.out.println(attack1+" "+ attack2+" "+ attack3);
					//System.out.println(defend1+" "+ defend2);
					
					

				}
				if(attack_Units==0){
					defence_Win++;
				}else{attack_Win++;}
				Atotal+=attack_Units;
				Dtotal+=defence_Units;
				
			//	System.out.println("Attack Units: "+attack_Units+" Defense Units: "+defence_Units);
				JOptionPane.showMessageDialog(frame, "THE WAR IS OVER...  Attacking Units left: "+attack_Units+" Defending Units left: "+ defence_Units);
				frame.dispose();
				starting();
			}else{
				JOptionPane.showMessageDialog(frame, "Attacking Units left: "+attack_Units+" Defending Units left: "+ defence_Units);
				frame.dispose();
				starting();
			}
			
			
		}
		
		
	}
}

