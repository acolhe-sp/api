package com.sptech.apikraken.service;

import com.sptech.apikraken.entity.User;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@Service
public class CSVService {

    public void gravaArquivoCSV(List<User> lista, String nomeArquivo) {
        FileWriter arq = null;
        Formatter saida = null;
        Boolean deuRuim = false;
        nomeArquivo += ".csv";

        try {
            arq = new FileWriter(nomeArquivo);
            saida = new Formatter(arq);
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        try {

            for (int i = 0; i < lista.size(); i++) {
                User usuario = lista.get(i);
                saida.format("%d;%s;%s;%s;%b;%d;%s;%s;%s;%s;%s\n",
                        usuario.getId(),
                        usuario.getImg(),
                        usuario.getEmail(),
                        usuario.getUserType(),
                        usuario.isConnect(),
                        usuario.getAddress().getId(),
                        usuario.getAddress().getCep(),
                        usuario.getAddress().getState(),
                        usuario.getAddress().getDistrict(),
                        usuario.getAddress().getStreet(),
                        usuario.getAddress().getNumber());
            }

        } catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar o arquivo");
            deuRuim = true;
        } finally {
            saida.close();
            try {
                arq.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) System.exit(1);
        }
    }

    public void leExibeArquivoCsv(String nomeArq) {
        FileReader arq = null;
        Scanner in = null;
        Boolean deuRuim = false;
        nomeArq += ".csv";

        try {
            arq = new FileReader(nomeArq);
            in = new Scanner(arq).useDelimiter(";|\\n");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
            System.exit(1);
        }

        try {
            System.out.printf("%-10s %-15s %-20s %-12s %10s %-11s %9s %15s %15s %15s %-6s",
                    "ID USUARIO", "IMAGEM", "EMAIL", "TIPO USUARIO", "CONECTADO?",
                    "ID ENDEREÇO", "CEP", "ESTADO", "CIDADE", "RUA", "NUMBER");

            while (in.hasNext()) {
                Integer id = in.nextInt();
                String img = in.next();
                String email = in.next();
                String userType = in.next();
                Boolean connect = in.nextBoolean();
                Integer idEndereco = in.nextInt();
                String cep = in.next();
                String estado = in.next();
                String cidade = in.next();
                String rua = in.next();
                String numero = in.next();

                System.out.printf("%-10d %-15s %-20s %-12s %10b %-11d %9s %15s %15s %15s %-6s\n",
                        id, img, email, userType, connect,
                        idEndereco, cep, estado, cidade, rua, numero);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Arquivo com problemas");
        } catch (IllegalStateException e) {
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
        } finally {
            in.close();
            try {
                arq.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) System.exit(1);
        }
    }

}
