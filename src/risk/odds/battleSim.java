/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package risk.odds;

import java.util.Random;

/**
 *
 * @author Philip
 */
public class battleSim {

public static void main(String [] args){


final int iterations=100000;
int Atotal = 0, Dtotal=0, attack_Win=0, defence_Win=0;
int attack1=0, attack2=0, attack3=0;
int defend1=0, defend2=0, defend3=0;
int[] a={20,25};
int[] b={-1,0,1}; 
int attack_Units=5;
int defence_Units=3;
int defence_Advantage=0;

for(int index=1;index<16;index++){
    System.out.println("DEFENSE " + index );

for(int p=0;p<a.length;p++){
    
    for(int q=0;q<b.length;q++){
        
       defence_Win=0;
        attack_Win=0;
        Atotal=0;
        Dtotal=0;
        for(int i=0;i<iterations;i++){
            
            attack_Units=a[p];
            defence_Advantage=b[q];
            defence_Units=index;
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

            }
        System.out.println(((double)attack_Win/iterations)*100);
}
}
}
}
    
    public static int getDice(){
		Random r = new Random();
                Random r2= new Random();
                r.setSeed(r2.nextLong());
		int temp=r.nextInt(7);
		while(temp==0){
			temp=r.nextInt(7);
		}
		return temp;
	}
}
