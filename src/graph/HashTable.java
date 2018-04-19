package graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        tableSize = 20;
        nodeId = 0;
        table = new LinkedHash[tableSize];

        for(int i = 0; i < tableSize; i++)
            table[i] = null;
    }



    public int myhash(String key)
    {

        int hashvalue = key.hashCode();
        hashvalue = hashvalue % tableSize;

        if(hashvalue < 0)
        {
            hashvalue = hashvalue + tableSize;
        }

        return hashvalue;


    }

    public void insert(String key, int id)
    {

        int h = myhash(key) % tableSize;


        if(table[h] == null)
        {
            table[h] = new LinkedHash(key,id);
        }

        else
        {
            LinkedHash node = table[h];

            while (node.next != null && !node.key.equals(key))
            {
                node = node.next;
            }

            if (node.key.equals(key))
                node.key = key;

            else
                node.next = new LinkedHash(key, id);

        }
    }

    public int find(String key)
    {
        int find = myhash(key) % tableSize;

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
            tableSize = Integer.parseInt(br.readLine());
            String line;


            while ((line = br.readLine()) != null && size < tableSize)
            {
                size++;

                String [] splitline = line.split(" ");



                String key = splitline[0];
//                int id = myhash(key);
                insert(key, nodeId++);




            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }








}









