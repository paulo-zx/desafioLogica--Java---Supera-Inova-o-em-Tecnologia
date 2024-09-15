import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    private static final Map<Integer, String> digitToColor = new HashMap<>();
    private static final String TOLERANCE_COLOR = "dourado"; // 5% de tolerância

    static {
        digitToColor.put(0, "preto");
        digitToColor.put(1, "marrom");
        digitToColor.put(2, "vermelho");
        digitToColor.put(3, "laranja");
        digitToColor.put(4, "amarelo");
        digitToColor.put(5, "verde");
        digitToColor.put(6, "azul");
        digitToColor.put(7, "violeta");
        digitToColor.put(8, "cinza");
        digitToColor.put(9, "branco");
    }

    // Função principal que recebe a string de entrada e retorna a sequência de cores
    public static String getResistorColors(String input) {

        if (!input.toLowerCase().contains("ohms")) {
            return "Entrada inválida! O valor deve estar no formato '<valor> ohms', como '47 ohms' ou '4.7k ohms'.";
        }

        // Remove a palavra "ohms" e quaisquer espaços extras para obter apenas o valor
        String valueStr = input.toLowerCase().replace("ohms", "").trim();

        // Converte para número
        double resistanceValue = parseResistanceValue(valueStr);


        if (resistanceValue <= 0) {
            return "Erro: O valor de resistência deve ser maior que 0 ohms.";
        }

        // Extrai os dois primeiros dígitos significativos e o expoente do multiplicador
        StringBuilder colors = new StringBuilder();
        String[] colorBands = calculateColorBands(resistanceValue);

        for (String band : colorBands) {
            colors.append(band).append(" ");
        }


        colors.append(TOLERANCE_COLOR);

        return colors.toString();
    }

    // Função para calcular as cores das faixas com base no valor de resistência
    private static String[] calculateColorBands(double resistanceValue) {
        String[] result = new String[3];
        int exponent = 0;

        // Ajusta o valor de resistência para ficar no formato de dois dígitos significativos
        while (resistanceValue >= 100) {
            resistanceValue /= 10;
            exponent++;
        }
        while (resistanceValue < 10) {
            resistanceValue *= 10;
            exponent--;
        }

        // Extrai os dois primeiros dígitos significativos
        int firstDigit = (int) resistanceValue / 10;
        int secondDigit = (int) resistanceValue % 10;


        result[0] = digitToColor.get(firstDigit);
        result[1] = digitToColor.get(secondDigit);
        result[2] = digitToColor.get(exponent);

        return result;
    }


    private static double parseResistanceValue(String valueStr) {
        if (valueStr.endsWith("k")) {
            return Double.parseDouble(valueStr.replace("k", "")) * 1_000;
        } else if (valueStr.endsWith("m")) { // Corrigido de "m" para "M"
            return Double.parseDouble(valueStr.replace("m", "")) * 1_000_000;
        } else if (valueStr.endsWith("M")) {
            return Double.parseDouble(valueStr.replace("M", "")) * 1_000_000;
        } else {
            return Double.parseDouble(valueStr);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o scanner para receber entrada do usuário
        String input;

        while (true) {

            System.out.print("Digite o valor do resistor (por exemplo, 47 ohms, 4.7k ohms, 1M ohms): ");
            input = scanner.nextLine().trim();


            if (!input.matches(".*\\s+ohms$")) {
                System.out.println("Erro: Entrada inválida. Por favor, insira o valor no formato correto, como '47 ohms'.");
            } else {

                String valueStr = input.toLowerCase().replace("ohms", "").trim();
                double resistanceValue = parseResistanceValue(valueStr);

                if (resistanceValue <= 0) {
                    System.out.println("Erro: O valor de resistência deve ser maior que 0 ohms.");
                } else {
                    break;
                }
            }
        }


        String colors = getResistorColors(input);
        System.out.println(colors);
    }
}
