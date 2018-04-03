/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


/**
 *
 * @author metho
 */
public class Senha {
    private String[] cores1 = {"azul", "amarelo", "verde", "vermelho", "rosa", "laranja"};
    private ArrayList<String> senha = new ArrayList();
    private ArrayList<String> cores = new ArrayList();
   
    public String[] senhaRandomica1(){      
        String[] senhaRand = new String[4];
        for(int i=0; i<4; i++){
            senhaRand[i]=corRand();
        }
        return senhaRand;
    }
    public ArrayList<String> senhaRandomica(){
        HashSet<String> senhaRand1 = new HashSet();
        ArrayList<String> senhaRand = new ArrayList();
        
        senhaRand1 = __preencheHash();
        senhaRand =new ArrayList(senhaRand1);
        
        while(senhaRand.size() != 4){
            senhaRand1 = __preencheHash();
            senhaRand =new ArrayList(senhaRand1);
        }
        

        
        return senhaRand;
    }
    
    public HashSet<String> __preencheHash(){
        HashSet<String> senhaHash = new HashSet();
        for(int i=0; i<4; i++){
            //senhaRand.set(i, cores.get(rand.nextInt(6)));
            //senhaRand.add(i, corRand());
            senhaHash.add(corRand());
        }
        return senhaHash;
    }
    
    public String corRand(){
        int a = (int) (Math.random() * 6);
        String cor = cores1[a];
        return cor;
    }

    public void compara(int[] senha, int[] senhaTentativa){
        
    }
    
}
