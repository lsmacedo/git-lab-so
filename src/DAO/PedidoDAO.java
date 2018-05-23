package DAO;

import Objects.Pedido;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    private static String[] lerRegistro() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("dados17.txt"));

        String linha;
        int i = 0; int tam = (int) Math.pow(2, 17);
        String[] pedidos = new String[tam];

        while ((linha = br.readLine()) != null) {
            pedidos[i++] = linha;
        }

        br.close();
        return pedidos;
    }

    public static List<Pedido> lerPedidos(int ordemPedido) throws IOException {
        String[] pedidos = lerRegistro();
        List<Pedido> retorno = new ArrayList<>();
        for (int i = 0; i < pedidos.length; i++) {
            String[] gambi = pedidos[i].split(";");
            String nomeCliente = gambi[0];
            float peso = Float.parseFloat(gambi[1]);
            float precoPorKg = Float.parseFloat(gambi[2].replace(',', '.'));
            Pedido p = new Pedido(ordemPedido, nomeCliente, peso, precoPorKg);
            retorno.add(p);
        }
        return retorno;
    }

}
