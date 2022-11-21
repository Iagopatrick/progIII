public class varargs {
    public static void main(String[] args) {
        String numero = "12";
        String mensagem = "O numero foi convertido";
        String mensagem2 = "Digita certo ai irmao";
        int num, num2;
        num = tratamentoint(numero, mensagem);
        // num2 = 2;
        num2 = tratamentoint(numero);

        System.out.println(num +" "+ num2);

        num += num2;

        System.out.println(num +" "+ num2);

        num = tratamentoint("123", mensagem2);

    }

    static public int tratamentoint(String num, String... msg){
        int retorno = Integer.parseInt(num);
        for(String mensagem: msg){
            System.out.println(mensagem);
        }
        
        return retorno;
    }



}
