function formatarCPF(cpf) {
    if (!cpf) return "";
    return cpf.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, "$1.$2.$3-$4");
}

function renderizarUsuariosNaTabela(listaDeUsuarios) {
    const corpoTabela = document.getElementById('tabela-usuarios');
    if (!corpoTabela) return;

    corpoTabela.innerHTML = '';

    listaDeUsuarios.forEach(usuario => {

        corpoTabela.innerHTML += `
            <tr>
                <td>${usuario.id}</td>
                <td>${usuario.nome}</td>
                <td>${usuario.email}</td>
                <td>${formatarCPF(usuario.cpf)}</td>
                <td>
                   <button class="btn btn-sm btn-outline-warning" onclick="prepararEdicao(${usuario.id})">Editar</button>
                   <button class="btn btn-sm btn-outline-danger" onclick="deletarUsuario(${usuario.id})">Excluir</button>
                </td>
            </tr>
        `;
    });
}

async function executarBuscaPorId() {
    const id = document.getElementById('inputBuscaId').value;
    const areaResultado = document.getElementById('resultadoBusca');
    const areaErro = document.getElementById('erroBusca');

    areaResultado.classList.add('d-none');
    areaErro.classList.add('d-none');

    if (!id) return;

    try {
        const response = await fetch(`/usuarios/find/${id}`);

        if (response.ok) {
            const user = await response.json();

            // Preenche os dados no modal
            document.getElementById('resNome').innerText = user.nome;
            document.getElementById('resEmail').innerText = user.email;
            document.getElementById('resCpf').innerText = user.cpf;

            areaResultado.classList.remove('d-none');
        } else {
            areaErro.classList.remove('d-none');
        }
    } catch (error) {
        console.error("Erro na requisição:", error);
        alert("Erro ao conectar com o servidor.");
    }
}

async function salvarNovoUsuario() {

    const cpfCru = document.getElementById('cadCpf').value.replace(/\D/g, '');

    const dados = {
        nome: document.getElementById('cadNome').value,
        email: document.getElementById('cadEmail').value,
        cpf: cpfCru,
        senha: document.getElementById('cadSenha').value
    };

    try {
        const response = await fetch('/usuarios/create', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(dados)
        });

        const data = await response.json();

        if (response.ok) {
            alert("Sucesso!");
            location.reload();
        } else if (response.status === 400) {
            // Aqui pegamos os erros do MethodArgumentNotValidException (Senha, Nome, etc)
            let mensagens = Object.values(data).join("\n");
            alert("Erro de validação:\n" + mensagens);
        } else if (response.status === 409) {
            // Aqui pegamos o erro de DadosDuplicadosException
            alert("Conflito: " + data.erro);
        }
    } catch (error) {
        alert("Erro técnico ao salvar.");
    }
}

async function carregarTodosUsuarios() {
    try {
        const response = await fetch('http://localhost:8081/usuarios/find');

        const usuarios = await response.json();

        if (usuarios.length === 0) {
            document.getElementById('tabela-usuarios').innerHTML =
                '<tr><td colspan="5" class="text-center">Nenhum usuário cadastrado.</td></tr>';
            return;
        }

        renderizarUsuariosNaTabela(usuarios);

    } catch (error) {
        console.error("Erro ao carregar:", error);
    }
}

document.addEventListener('DOMContentLoaded', carregarTodosUsuarios);

async function prepararEdicao(id) {
    try {
        const response = await fetch(`/usuarios/find/${id}`);
        if (response.ok) {
            const user = await response.json();


            document.getElementById('cadNome').value = user.nome;
            document.getElementById('cadEmail').value = user.email;
            document.getElementById('cadCpf').value = user.cpf;


            const modalCadastro = new bootstrap.Modal(document.getElementById('modalCadastro'));


            document.querySelector('#modalCadastro .modal-title').innerText = "Editar Usuário ID: " + id;

            modalCadastro.show();

            const btnSalvar = document.querySelector('#modalCadastro .btn-primary');
            btnSalvar.onclick = () => executarAtualizacao(id);
        }
    } catch (error) {
        alert("Erro ao buscar dados para edição.");
    }
}

async function executarAtualizacao(id) {
    const cpfCru = document.getElementById('cadCpf').value.replace(/\D/g, '');

    const dadosAtualizados = {
        nome: document.getElementById('cadNome').value,
        email: document.getElementById('cadEmail').value,
        cpf: cpfCru,
        senha: document.getElementById('cadSenha').value
    };

    try {

        const response = await fetch(`/usuarios/update/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dadosAtualizados)
        });

        const data = await response.json();

        if (response.ok) {
            alert("Usuário atualizado com sucesso!");


            document.getElementById('formCadastro').reset();
            const modalElement = document.getElementById('modalCadastro');
            const modal = bootstrap.Modal.getInstance(modalElement);
            modal.hide();

            carregarTodosUsuarios();
        } else if (response.status === 400) {
            let mensagens = Object.values(data).join("\n");
            alert("Erro de validação:\n" + mensagens);
        } else {
            alert("Erro ao atualizar: " + (data.erro || "Erro desconhecido"));
        }
    } catch (error) {
        console.error("Erro no PUT:", error);
        alert("Erro técnico ao conectar com o servidor.");
    }
}


function abrirModalCadastroLimpo() {
    document.getElementById('formCadastro').reset();
    document.querySelector('#modalCadastro .modal-title').innerText = "Novo Usuário";

    const btnSalvar = document.querySelector('#modalCadastro .btn-primary');
    btnSalvar.onclick = salvarNovoUsuario;
}

function abrirEdicaoDoBusca() {
    const id = document.getElementById('inputBuscaId').value;
    if (!id) return;

    // Fecha o modal de busca
    const modalBusca = bootstrap.Modal.getInstance(document.getElementById('modalBuscaId'));
    if (modalBusca){
    modalBusca.hide();
    document.activeElement.blur();}

    setTimeout(() => {
    prepararEdicao(id);
    }, 300);
}

async function deletarUsuario(id) {

    if (!confirm(`Tem certeza que deseja excluir o usuário com ID: ${id}?`)) {
        return;
    }

    try {
        const response = await fetch(`/usuarios/delete/${id}`, {
            method: 'DELETE'
        });

        if (response.status === 204 || response.ok) {
            alert("Usuário removido com sucesso!");

            carregarTodosUsuarios();
        } else {
            const data = await response.json();
            alert("Erro ao excluir: " + (data.erro || "Erro desconhecido"));
        }
    } catch (error) {
        console.error("Erro na requisição DELETE:", error);
        alert("Erro de conexão com o servidor ao tentar excluir.");
    }
}