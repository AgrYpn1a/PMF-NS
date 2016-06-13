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
public class SSL 
{
    // a type class
    private class SSLNode 
    {
        private int info;
        public SSLNode next;
        
        // constructor
        public SSLNode(int info)
        {
            this.info = info;
            this.next = null;
        }
    }
    
    public SSLNode head;
    public SSLNode tail;
    private int length;
    
    // constructor
    public SSL()
    {
        this.head = null;
    }
    
    public int length()
    {
        return this.length;
    }
    
    // methods
    public SSL add(int info)
    {
        SSLNode n = new SSLNode(info);
        
        // set tail
        if(this.head == null)
            this.tail = n;
        
        n.next = this.head;
        this.head = n;
        
        this.length++;
        
        return this;
    }
    
    public SSL addOnTail(int info)
    {
        if(this.head == null)
            this.add(info);
        else
        {
            SSLNode n = new SSLNode(info);
            this.tail.next = n;
            this.tail = n;
        }
        
        return this;
    }
    
    public SSL printAsc()
    {
        System.out.println();
        System.out.print("[ ");
        _printAsc(this.head);
        System.out.print("]");
        System.out.println();
        return this;
    }
    
    private void _printAsc(SSLNode current)
    {
        if(current != null)
        {
            System.out.print(current.info + " ");
            _printAsc(current.next);
        }
    }
    
    public SSL printDesc()
    {
        System.out.println();
        System.out.print("[ ");
        _printDesc(this.head);
        System.out.print("]");
        System.out.println();
    
        return this;
    }
    
    private void _printDesc(SSLNode current)
    {
        if(current != null)
        {
            _printDesc(current.next);
            System.out.print(current.info + " ");
        }
    }        
}
