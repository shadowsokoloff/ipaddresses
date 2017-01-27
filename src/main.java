import java.io.BufferedReader;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) throws java.io.IOException{
        //Вводим первый ip-адрес
        System.out.println("Введите первый ip-адрес");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstIp = reader.readLine();

        //Вводим второй ip-адрес
        System.out.println("Введите второй ip-адрес");
        String secondIp = reader.readLine();



        System.out.println(ipToLong(firstIp));
        System.out.println(ipToLong(secondIp));


    }
    
    //Конвертируем ip-адреса в Long
    public static long ipToLong(String ipAddresses)
    {
        String[] ipAddressesInArray = ipAddresses.split("\\.");

        long result = 0;
        for (int i = 0; i < ipAddressesInArray.length; i++) {

            int power = 3 - i;
            int ip = Integer.parseInt(ipAddressesInArray[i]);
            result += ip * Math.pow(256, power);
        }
        return result;
    }



}
