package graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.LinkedList;



class LinkedHash
{
    String key;
    int id;
    LinkedHash next;



    LinkedHash (String key, int id)
    {
        this.key = key;
        this.id = id;
        this.next = null;


    }





}

/** Custom implementation of a hash table using open hashing, separate chaining.
 *  Each key is a String (name of the city), each value is an integer (node id). */
public class HashTable
{
	 // FILL IN CODE: add variables and methods


    private int tableSize;
    private int size;
    private int nodeId;
    private LinkedHash [] table;



    public HashTable ()
    {
        size = 0;

        try (FileReader f = new FileReader("USA.txt");
             BufferedReader br = new BufferedReader(f))
        {
            br.readLine();
            tableSize = Integer.parseInt(br.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        nodeId = 0;
        table = new LinkedHash[tableSize];

        for(int i = 0; i < tableSize; i++)
            table[i] = null;
    }




    public BigInteger hash(String key)
    {

        int c;
        BigInteger r = new BigInteger("0");
        BigInteger a = new BigInteger("33");

        for(int i = 0; i <key.length(); i++)
        {
            c = (int)key.charAt(i);
            BigInteger big = new BigInteger(String.valueOf(c));
            r = big.add(r.multiply(a));

        }


        return r;


    }

    public void insert(String key, int id)
    {

        BigInteger bigTable = new BigInteger(String.valueOf(tableSize));
        BigInteger hashing = hash(key);
        int i = (hashing.mod(bigTable)).intValue();



        if(table[i] == null)
        {
            table[i] = new LinkedHash(key,id);


        }

        else
        {

            LinkedHash nh = new LinkedHash(key,id);
            nh.next = table[i];
            table[i] = nh;


        }

    }


//    public void remove(String key)
//    {
//        BigInteger bigTable = new BigInteger(String.valueOf(tableSize));
//        BigInteger hashing = hash(key);
//        int remove = (hashing.mod(bigTable)).intValue();;
//        if (table[remove] != null)
//        {
//            LinkedHash prev = null;
//            LinkedHash curr = table[remove];
//            while (curr.next != null && !curr.key.equals(key))
//            {
//                prev = curr;
//                curr = curr.next;
//            }
//            if (curr.key.equals(key))
//            {
//                if (prev == null)
//                    table[remove] = curr.next;
//                else
//                    prev.next = curr.next;
//                size--;
//            }
//        }
//    }



    public int find(String key)
    {


        BigInteger bigTable = new BigInteger(String.valueOf(tableSize));
        BigInteger hashing = hash(key);
        int find = (hashing.mod(bigTable)).intValue();;

        if(table[find] == null)
            return -1;

        else
        {
            LinkedHash node = table[find];

            while(node != null && !node.key.equals(key))
            {
                node = node.next;
            }

            if(node == null)
                return -1;

            else
                return node.id;
        }
    }

    public void print()
    {
        for (int i = 0; i < tableSize; i++)
        {
            System.out.print("\nBucket "+ (i) +" : ");
            LinkedHash node = table[i];
            while (node != null)
            {
                System.out.print(node.key +" " + node.id + " ");
                node = node.next;
            }
        }
    }



    public void loadCities(String File)
    {
        try (FileReader f = new FileReader(File);
             BufferedReader br = new BufferedReader(f))
        {
            br.readLine();
            br.readLine();
            String line;


            while ((line = br.readLine()) != null && size < tableSize)
            {
                size++;

                String [] splitline = line.split(" ");



                String key = splitline[0];
                insert(key, nodeId++);




            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }








}









