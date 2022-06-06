package com.sptech.apikraken.service;

import com.sptech.apikraken.entity.Donation;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ExportService {

    public String lerArquivo () {
        String nome = "Doacoes.txt";

        try {
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();

            while (linha != null) {
                System.out.printf("%s\n", linha);

                linha = lerArq.readLine();
            }

            arq.close();

            return arq.toString();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
            throw new Error("Deu");
        }
    }

    public void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;

        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro);
        }

        try {
            saida.append(registro + "\n");
            saida.close();
        }
        catch (IOException erro) {
            System.out.println("Erro ao gravar o arquivo: " + erro);
        }
    }

    public Boolean exportTXT(List<Donation> donations) {
        int contaRegCorpo = 0;
        String nomeArq = "Doacoes.txt";

        String header = "00DOACOES";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header += "01";

        gravaRegistro(header, nomeArq);

        String corpo;
        for (Donation d : donations) {
            corpo = "02";
            corpo += String.format("%-8d", d.getId());
            corpo += String.format("%-19s", d.getStatus());
            corpo += String.format("%-25s", d.getDonor().getUser().getName());
            corpo += String.format("%-18s", d.getDonor().getCpf());
            corpo += String.format("%-18s", d.getDonor().getRg());
            corpo += String.format("%10.02f", d.getPayment().getValue());
            corpo += String.format("%-33.29s", d.getPayment().getType());
            corpo += String.format("%-26s", d.getDateDonation());
            contaRegCorpo++;
            gravaRegistro(corpo, nomeArq);
        }

        String trailer = "01";
        trailer += String.format("%010d", contaRegCorpo);
        gravaRegistro(trailer, nomeArq);

        return true;
    }

}
