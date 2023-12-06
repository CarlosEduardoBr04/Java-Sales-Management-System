
package Modelagem;

import Controle.conexao;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class Controle {
    private int cod;
    private String nomeVendedor;
    private String produtoVendido;
    private conexao con = new conexao();

    public Controle() {
        this(0,"","");
    }

    public Controle(int cod, String nomeVendedor, String produtoVendido) {
        this.cod = cod;
        this.nomeVendedor = nomeVendedor;
        this.produtoVendido = produtoVendido;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public String getProdutoVendido() {
        return produtoVendido;
    }

    public void setProdutoVendido(String produtoVendido) {
        this.produtoVendido = produtoVendido;
    }
    
    public void CadastrarVenda(){
        String sql;
        sql= "Insert into Controlevendas(cod,nomeVendedor,produtoVendido)values(" + this.getCod()+ " ,'" + this.getNomeVendedor()+ "' ,'" + this.getProdutoVendido()+ "')";
        con.executeSQL(sql);
        JOptionPane.showMessageDialog(null, "Cadastro feito com Sucesso..." );  
    }
    
    public  ResultSet Listar(){
        ResultSet tabela;
        tabela= null;
        
        String sql= "Select * from Controlevendas";
        tabela= con.RetornarResultset(sql);
        return tabela;
    }
     
    public void Alterar(){
        String sql;
        sql ="UPDATE Controlevendas set cod=" +this.getCod()+
                " ,nomeVendedor= '"+ this.getNomeVendedor()+
                "' ,produtoVendido= '" + this.getProdutoVendido()+ "' WHERE cod="+this.getCod();
        
        con.executeSQL(sql);
        JOptionPane.showMessageDialog(null, " Alterado com sucesso...");
    }
    
       public void Excluir(){
       String sql;
        sql = "Delete  FROM Controlevendas WHERE cod =" + this.getCod();
        con.executeSQL(sql);
        JOptionPane.showMessageDialog(null, "Registro Excluido com sucesso...");
    }
}
