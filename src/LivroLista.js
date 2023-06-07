import React, { useState, useEffect } from 'react';

import {ControleEditora} from './controle/ControleEditora'
import {ControleLivros} from './controle/ControleLivros'

function LinhaLivro({ livro, excluir }) {
  const [nomeEditora, setNomeEditora] = useState('');

  useEffect(() => {
    // Instanciar um controlador de editoras
    const controleEditora = new ControleEditora();
    // Obter o nome da editora com base no código
    const nome = controleEditora.getNomeEditora(livro.codEditora);
    setNomeEditora(nome);
  }, [livro.codEditora]);

  return (
    <tr>
      <td>
        <button onClick={() => excluir(livro.codigo)}>Excluir</button>
      </td>
      <td>{livro.codigo}</td>
      <td>{livro.titulo}</td>
      <td>{nomeEditora}</td>
      <td>{livro.resumo}</td>
      <td>
        <ul>
          {livro.autores.map((autor, index) => (
            <li key={index}>{autor}</li>
          ))}
        </ul>
      </td>
    </tr>
  );
}

export default function LivroLista() {
  const [livros, setLivros] = useState([]);
  const [carregado, setCarregado] = useState(false);

  useEffect(() => {
    // Instanciar um controlador de livros
    const controleLivro = new ControleLivros();
    // Obter a lista de livros
    const listaLivros = controleLivro.obterLivros();
    setLivros(listaLivros);
    setCarregado(true);
  }, []);

  const excluir = (codigo) => {
    // Instanciar um controlador de livros
    const controleLivro = new ControleLivros();
    // Excluir o livro com base no código
    controleLivro.excluir(codigo);
    setCarregado(false);
  };

  return (
    <main>
      <h1>Lista de Livros</h1>
      {carregado ? (
        <table>
          <thead>
            <tr>
              <th></th>
              <th>Código</th>
              <th>Título</th>
              <th>Editora</th>
              <th>Resumo</th>
              <th>Autores</th>
            </tr>
          </thead>
          <tbody>
            {livros.map((livro) => (
              <LinhaLivro key={livro.codigo} livro={livro} excluir={excluir} />
            ))}
          </tbody>
        </table>
      ) : (
        <p>Carregando...</p>
      )}
    </main>
  );
}
