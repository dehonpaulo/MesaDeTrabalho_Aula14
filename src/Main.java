import model.Contato;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Contato> contatos = new ArrayList<>();

        Contato contato1 = new Contato("Paulo Dehon", "paulodehon@email.com", "(84)99999-8888");
        Contato contato2 = new Contato("Maria Silva", "mariasilva@email.com", "(84)98888-7777");
        Contato contato3 = new Contato("João Alves", "joaoalves@email.com", "(84)97777-6666");

        contatos.add(contato1);
        contatos.add(contato2);
        contatos.add(contato3);

        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream("ListaContatos.txt");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

            objOut.writeObject(contatos);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Contato> contatos2 = null;
        FileInputStream fileInput;
        try {
            fileInput = new FileInputStream("ListaContatos.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);

            contatos2 = (ArrayList) objInput.readObject();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }

        for(Contato contato : contatos2) {
            System.out.println("Nome: " + contato.getNome()
                    + "\nEmail: " + contato.getEmail()
                    + "\nTelefone: " + contato.getTelefone() + "\n");
        }
    }
}

