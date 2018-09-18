package br.com.informatica.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotaDeVenda {
    // Attributes
    private Cliente cliente;
    private Date DataDeEmissao;
    private List<Equipamento> produtos;
    private double precoTotal;

    public NotaDeVenda() {}

    public NotaDeVenda(Cliente cliente, Date dataDeEmissao, List<Equipamento> produtos) {
        setCliente(cliente);
        setDataDeEmissao(dataDeEmissao);
        setProdutos(produtos);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataDeEmissao() {
        return DataDeEmissao;
    }

    public void setDataDeEmissao(Date dataDeEmissao) {
        DataDeEmissao = dataDeEmissao;
    }

    public List<Equipamento> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Equipamento> produtos) {
        this.produtos = produtos;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public  String toString()
    {
        String notaTxt;
        double PrecoGeral = 0.0;
        notaTxt = "|--------------------------------------------------------------------------------|\n" +
                "|     _____   ______       _        _________  ________    ______  ____  ____    |\n" +
                "|    |_   _|.' ___  |     / \\      |  _   _  ||_   __  | .' ___  ||_   ||   _|   |	\n" +
                "|      | | / .'   \\_|    / _ \\     |_/ | | \\_|  | |_ \\_|/ .'   \\_|  | |__| |     |\n" +
                "|  _   | | | |   ____   / ___ \\        | |      |  _| _ | |         |  __  |     |\n" +
                "| | |__' | \\ `.___]  |_/ /   \\ \\_     _| |_    _| |__/ |\\ `.___.'\\ _| |  | |_    |\n" +
                "| `.____.'  `._____.'|____| |____|   |_____|  |________| `.____ .'|____||____|   |\n" +
                "|--------------------------------------------------------------------------------| \n";

        notaTxt += " Dados do Cliente             Data de emissão: "+ getDataDeEmissao() +	" \n" +
                " Nome: " + getCliente().getNome() + "   Endereço: "+ getCliente().getEndereco() +
                "   CPF: " + getCliente().getCpf() + "\n" +
                "|--------------------------------------------------------------------------------|\n" +
                "|------------------------------LISTA DE PRODUTOS---------------------------------|\n";
        for(int i = 0; i < produtos.size(); i++)
        {
            double precoUnidade = Double.parseDouble(produtos.get(i).getPreco());
            int quantidade = Integer.parseInt(produtos.get(i).getQuantidade());
            double precoUnitario = precoUnidade * quantidade;

            notaTxt += " \t Produto " + i + ":" + produtos.get(i).getNome() + "\t\t"
                    + "1x" + precoUnidade + "\t\t"
                    + produtos.get(i).getQuantidade() + "x" + precoUnitario+ "\n";

            PrecoGeral += precoUnitario;
        }
        setPrecoTotal(PrecoGeral);
        notaTxt += "|--------------------------------------------------------------------------------|\n" +
                "| 			      			 Preço total:  " + getPrecoTotal() +"                 |\n" +
                "|--------------------------------------------------------------------------------|\n" +
                "                                                                             ";
        return notaTxt;
    }
}
