import java.io.BufferedReader;
import java.io.InputStreamReader;


public class main {
    public static void main(String[] args) throws java.io.IOException{

        //Вводим адреса
        String firstIp = inputIp("Введите первый ip-адрес");
        String secondIp = inputIp("Введите второй ip-адрес");

        //Конвертируем адреса в long
        Long firstIpLong = ipToLong(firstIp);
        Long secondIpLong = ipToLong(secondIp);

        //создаем массив промежутка адрессов в long
        Long longAddresses[] = makeIpArray(firstIpLong, secondIpLong);


        //выводим массив адресов
       printArray(longAddresses);
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

    //Создаем массив адресов типа long
    public static Long[] makeIpArray (Long firstIpLong, Long secondIpLong)
    {
        //Вычисляем диапозон между адресами
        long firstIp = (long)firstIpLong;
        long secondIp = (long)secondIpLong;
        int d = (int)secondIp - (int)firstIp;
        Long[] longAddresses = new Long[d+1];
        boolean b = false;
        int adressesLength = longAddresses.length;

        for (int i = 0; i < adressesLength ; i++)
        {

             if ((firstIp + i)%256==255) {
                longAddresses[i] = firstIp + i + 2;
                b=true;
                adressesLength-=2;
            }
             if (b) {
                longAddresses[i] = firstIp + i + 2;
            }
            else {
            longAddresses[i] = firstIp + i;}

            if(i == adressesLength-1)
            {
                longAddresses[i] = null;
            }
        }
        return longAddresses;
    }

    //конвертируем адреса в строку
    public static String longToIp(long ip) {
        StringBuilder result = new StringBuilder(15);
        for (int i = 0; i < 4; i++) {
            result.insert(0,Long.toString(ip & 0xff));
            if (i < 3) {
                result.insert(0,'.');
            }
            ip = ip >> 8;
        }
        return result.toString();
    }

    //вывод на экран элементов массива
    public static void printArray(Long longAddresses[])
    {
        for (int i = 1; i < longAddresses.length; i++) {
            if(longAddresses[i]==null)
            {
                break;
            }
            System.out.println(longToIp(longAddresses[i]));
        }
    }


}
