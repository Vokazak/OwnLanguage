import java.util.List;

public class Test {
    public static void main(String[] args) {
        Lexer lexer = new Lexer("src/Test.txt");
        List<Token> tokens = lexer.do_lex();

        for (Token t : tokens){
            System.out.println(t.getValue() + " " +t.getTag() + " " +t.getPriority());
        }

        Parser parser = new Parser(tokens);
        if (parser.lang()){
            System.out.println("\nDone");
        }else{
            System.out.println("\nError");
        }

        for (String p : parser.getPoliz()){
            System.out.print(p + " ");
        }

        StackMachine stackMachine = new StackMachine(parser.getPoliz());
        stackMachine.process();
        stackMachine.print();
    }
}
