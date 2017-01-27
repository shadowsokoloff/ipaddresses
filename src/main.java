import java.io.BufferedReader;
import java.io.InputStreamReader;


public class main {
    public static void main(String[] args) throws java.io.IOException{
        //Вводим адреса
        String firstIp = inputIp("Введите первый ip-адрес");
        String secondIp = inputIp("Введите второй ip-адрес");
        //Конвертируем адреса в long
        long firstIpLong = ipToLong(firstIp);
        long secondIpLong = ipToLong(secondIp);
        //создаем массив промежутка адрессов в long
        long longAddresses[] = makeIpArray(firstIpLong, secondIpLong);
        

        for (int i = 0; i < longAddresses.length; i++) {
            System.out.println(longAddresses[i]);
        }





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
    //ввод адресов
    public static String inputIp(String message) throws java.io.IOException
    {
        System.out.println(message);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String ip = reader.readLine();
        return ip;
    }

    public static long[] makeIpArray (long firstIp, long secondIp)
    {
        //Вычисляем диапозон между адресами
        int d = (int)secondIp - (int)firstIp;
        long[] longAddresses = new long[d];

        for (int i = 0; i < longAddresses.length ; i++)
        {
            longAddresses[i] = firstIp + i;
        }
        return longAddresses;
    }



}
