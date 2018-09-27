import java.util.*;



/* Title: Polish Calculator
     * Authors: Lalinde, Juliana and Urrego, Isabel
     * Date: September 26, 2018
     * Taken from:https://github.com/julianalalindev/ST0245-032/blob/master/talleres/taller08/Taller8.java
     */

public class Taller8 {
        public static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }
    
    public static int Polish(String string){
        String[] s= string.split(" ");
        Stack<String> aux= new Stack<String>();
        String temp;
        int num=0;
        for(int i=0; i<s.length; i++){
            temp=s[s.length-1-i];
            if(isInteger(temp)){
                aux.push(temp);
            }else{
                if(temp.equals("+")){

                    num= Integer.parseInt(aux.pop())+ Integer.parseInt(aux.pop());
                }
                if(temp.equals("-")){
                    num= -(Integer.parseInt(aux.pop())- Integer.parseInt(aux.pop()));
                }
                if(temp.equals("*")){
                    num= Integer.parseInt(aux.pop())* Integer.parseInt(aux.pop());
                }
                if(temp.equals("/")){
                    num= Integer.parseInt(aux.pop())/ Integer.parseInt(aux.pop());
                }
                if(temp.equals("%")){
                    num= Integer.parseInt(aux.pop())% Integer.parseInt(aux.pop());
                }
            }
        }
        return num;
    }
}
