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

        //Выводим адреса
        System.out.println(firstIp);
        System.out.println(secondIp);
    }
}
