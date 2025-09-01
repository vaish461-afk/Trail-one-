import java.util.Scanner;
public class checksum 
{
    int i , cs, temp=0, sum =0, rcvcs;
    Scanner sc = new Scanner(System.in);
    int sender_checksum(int data[], int n)
    {
        for(i=0;i<n;i++)
            sum = sum +data[i];
        System.out.println("Sum of data : "+sum);
        cs=~sum;
        return cs;
    } 
    void reciever_checksum(int data[],int n, int cs)
    {
        System.out.println("Is error in the code is required yes/no [1/0] : ");
        int choice = sc.nextInt();
        if(choice ==1)
        {
            System.out.println("Enter position of error : ");
            int pos= sc.nextInt();
            System.out.println("Enter new element : ");
            int new_element = sc.nextInt();
            data[pos]=new_element;
        }
        temp=0;
        for(i=0;i<n;i++)
        {
            temp+=data[i];
        }
        sum = temp+cs;
        rcvcs =~sum;
        if(rcvcs == 0)
        {
            System.out.println("Reciever's side checksum is "+rcvcs+" no error in the data !");
        }
        else
        {
            System.out.println("Reciever's side checksum is "+rcvcs+" , Hence that is errorneous in data !");
        }
    }
    
    public static void main(String args[])
    {
        int i , n;
        int[] data = new int[30];
        checksum obj = new checksum();
        System.out.println("Enter the number of elements in the data : ");
        n = obj.sc.nextInt();
        System.out.println("Enter the data : ");
        for(i=0;i<n;i++)
            data[i] = obj.sc.nextInt();
        obj.cs = obj.sender_checksum(data,n);
        System.out.println("Sender side checksum is : "+obj.cs);
        obj.reciever_checksum(data,n,obj.cs);

    }
}

// Output:
// Enter the number of elements in the data :
// 4
// Enter the data :
// 1
// 2
// 3
// 4
// 10
// Is error in the code is required yes/no [1/0] :
// 1
// Enter position of error :
// 2
// Enter new element :
// 5
// Reciever's side checksum is -10 , Hence that is errorneous in data !
// Enter the number of elements in the data :
// 4
// Enter the data :
// 1
// 2
// 3
// 4
// 10
// Is error in the code is required yes/no [1/0] :
// 0
// Reciever's side checksum is 10
//  No error in the data !
