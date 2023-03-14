/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ddavid
 */
public class HMRunner {
   
    
    public static void main(String[] args) {
        HangMan m = new HangMan();
        //test if updateScore is returning properly when won is false
        if(Logic.updateScore(0,false)!=0){
     		 System.out.println("FAILED! 0:false -> should return 0");
     	 }
     	 
     	 if(Logic.updateScore(1,false)!=1){
     		 System.out.println("FAILED! 1:false -> should return 1");
     	 }
     	 
     	 if(Logic.updateScore(-1,false)!=-1){
     		 System.out.println("FAILED! -1:false -> should return -1");
     	 }
     	 
        //test if updateScore returns correct result when won is true
     	 if(Logic.updateScore(0,true)!=1){
     		 System.out.println("FAILED! 0:true -> should return 1");
     	 }

    }
    
}
