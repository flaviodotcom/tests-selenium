package builder;

import page.ControleProdutoPO;

import static utils.AppUtils.dataAtual;

public class ProdutoBuilder {
    public String codigo = "0001";
    public String nome = "Cubo Mágico";
    public Integer quantidade = 1;
    public Double valor = 19.99;
    public String data = dataAtual();

    private final ControleProdutoPO produto;

    public ProdutoBuilder(ControleProdutoPO produto) {
        this.produto = produto;
    }


    public ProdutoBuilder addCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public ProdutoBuilder addNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ProdutoBuilder addQuantididade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public ProdutoBuilder addValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public ProdutoBuilder addData(String data) {
        this.data = data;
        return this;
    }

    /**
     * Utilizando o design pattern Builder para preencher os campos do produto a ser cadastrado.
     **/
    public void builder() {
        produto.escrever(produto.codigoModal, codigo);
        produto.escrever(produto.nomeModal, nome);
        produto.escrever(produto.quantidadeModal, quantidade.toString());
        produto.escrever(produto.valorModal, valor.toString());
        produto.escrever(produto.dataModal, data);

        produto.buttonSalvarModal.click();
    }

}
