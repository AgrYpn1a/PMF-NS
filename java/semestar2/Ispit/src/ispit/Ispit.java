/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ispit;

/**
 *
 * @author Rastko
 */
public class Ispit 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // SSL test
        SSL ssl = new SSL();
        ssl.add(1).add(2).add(3).addOnTail(5).printAsc().printDesc();
    }
    
}
