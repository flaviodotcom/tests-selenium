const btnAdicionar = document.getElementById("btn-adicionar");
const tabela = document.querySelector('table>tbody');

const myModal = new bootstrap.Modal(document.getElementById('cadastro-produto'));
const modal = {
    codigo: document.getElementById('codigo'),
    nome: document.getElementById('nome'),
    quantidade: document.getElementById('quantidade'),
    valor: document.getElementById('valor'),
    dataCadastro: document.getElementById('data'),
    btnSalvar: document.getElementById('btn-salvar'),
    btnSair: document.getElementById('btn-sair')
};

btnAdicionar.addEventListener('click', (e) =>{
    e.preventDefault();
    abrirModalProdutos();
});

modal.btnSalvar.addEventListener('click', (e) =>{
    e.preventDefault();
    let produto = criarProduto();

    if(!produto.modeloValido()){
        exibirAlerta("Todos os campos são obrigatórios para o cadastro!");
        return;
    }

    adicionarProdutoNaTabela(produto);
    limparCampos();
});

modal.btnSair.addEventListener('click', (e) =>{
    e.preventDefault();
    limparCampos();
    fecharModalProdutos();
});

function abrirModalProdutos(){
    myModal.show();
}

function fecharModalProdutos(){
    myModal.hide();
}

function criarProduto(){
    return new Produto({
        codigo: modal.codigo.value,
        nome: modal.nome.value,
        quantidade: modal.quantidade.value,
        valor: modal.valor.value,
        dataCadastro: modal.dataCadastro.value,
    });
}

function limparCampos(){
    modal.codigo.value = "";
    modal.nome.value = "";
    modal.quantidade.value = "";
    modal.valor.value = "";
    modal.dataCadastro.value = "";

    esconderAlerta();
}

function adicionarProdutoNaTabela(produto){

    const tr = document.createElement('tr');
    const tdCodigo = document.createElement('td');
    const tdNome = document.createElement('td');
    const tdQuantidade = document.createElement('td');
    const tdValor = document.createElement('td');
    const tdDataCadastro = document.createElement('td');
    const tdAcoes = document.createElement('td');

    tdCodigo.textContent = produto.codigo;
    tdNome.textContent = produto.nome;
    tdQuantidade.textContent = produto.quantidade;
    tdValor.textContent = produto.valor;
    tdDataCadastro.textContent = produto.dataCadastro;
    tdAcoes.innerHTML = `<button type="button" class="btn btn-link">Editar</button> / <button type="button" class="btn btn-link">Excluir</button>`

    tr.appendChild(tdCodigo);
    tr.appendChild(tdNome);
    tr.appendChild(tdQuantidade);
    tr.appendChild(tdValor);
    tr.appendChild(tdDataCadastro);
    tr.appendChild(tdAcoes);

    tabela.appendChild(tr);
}
