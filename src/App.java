import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    private static List<Person> lista = new ArrayList<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Digite: 1 - Adiconar uma Pessoa | 2 - Ver lista de Homens | 3 - Ver lista de Mulheres");
        String answer = s.nextLine();

        while(!isValidOption(answer)){
            System.out.println("***************************************************************");
            System.out.println("Você digitou um valor inválido!");
            System.out.println("***************************************************************");
            System.out.println("Digite: 1 - Adiconar uma Pessoa | 2 - Ver lista de Homens | 3 - Ver lista de Mulheres");
            answer = s.nextLine();
        }

        while(isValidOption(answer)){
            if("1".equals(answer)){
                addPerson();
            } else if("2".equals(answer)){
                seeMenList();
            } else if("3".equals(answer)){
                seeWomenList();
            }
            System.out.println("Digite: 1 - Adiconar uma Pessoa | 2 - Ver lista de Homens | 3 - Ver lista de Mulheres");
            answer = s.nextLine();
        }

    }

    private static void seeMenList() {
        List<Person> menList = lista.stream()
                .filter(person -> person.getSex().equals("masculino"))
                .collect(Collectors.toList());
        if(menList.isEmpty()){
            System.out.println("---------------------------------------------------------------");
            System.out.println("A lista de homens está vazia!");
            System.out.println("---------------------------------------------------------------");
        } else{
            menList.forEach(person -> System.out.println(person));
        }
    }

    private static void seeWomenList() {
        List<Person> womenList = lista.stream()
                .filter(person -> person.getSex().equals("feminino"))
                .collect(Collectors.toList());
        if(womenList.isEmpty()){
            System.out.println("---------------------------------------------------------------");
            System.out.println("A lista de mulheres está vazia!");
            System.out.println("---------------------------------------------------------------");
        } else{
            womenList.forEach(person -> System.out.println(person));
        }
    }

    private static void addPerson() {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o nome da pessoa");
        String name = s.nextLine();
        System.out.println("Digite o sexo dessa pessoa - Masculino | Feminino");
        String sex = s.nextLine();
        if(sex.equalsIgnoreCase("masculino")){
            Person homem = new Person(name.toLowerCase().trim(), sex.toLowerCase().trim());
            lista.add(homem);
            System.out.println("---------------------------------------------------------------");
            System.out.println(name + " foi adicionado a lista de Homens");
            System.out.println("---------------------------------------------------------------");

        }else if(sex.equalsIgnoreCase("feminino")){
            Person mulher = new Person(name.toLowerCase().trim(), sex.toLowerCase().trim());
            lista.add(mulher);
            System.out.println("---------------------------------------------------------------");
            System.out.println(name + " foi adicionado a lista de Mulheres");
            System.out.println("---------------------------------------------------------------");
        } else{
            System.out.println("***************************************************************");
            System.out.println("Você digitou um valor inválido!");
            System.out.println("***************************************************************");
        }
    }

    private static boolean isValidOption(String answer) {
        try{
            Long numberAnswer = Long.parseLong(answer);
            if(numberAnswer <= 3 && numberAnswer >= 1){
                return true;
            } else{
              return false;
            }
        } catch (Exception e){
            return false;
        }
    }
}
