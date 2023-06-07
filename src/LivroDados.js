import React, { useState, useNavigate } from 'react';

import {ControleEditora} from './controle/ControleEditora'
import {ControleLivros} from './controle/ControleLivros'

export default function LivroDados() {
  const [codEditora, setCodEditora] = useState(0);
  const [titulo, setTitulo] = useState('');
  const [resumo, setResumo] = useState('');
  const [autores, setAutores] = useState('');

  const controleLivro = new ControleLivros();
  const controleEditora = new ControleEditora();

  const opcoes = controleEditora.getEditoras().map((editora) => ({
    value: editora.codEditora,
    text: editora.nome,
  }));

  const navigate = useNavigate();

  const tratarCombo = (event) => {
    const { value } = event.target;
    setCodEditora(Number(value));
  };

  const incluir = (event) => {
    event.preventDefault();

    const livro = {
      codigo: 0,
      titulo,
      resumo,
      autores: autores.split('\n'),
      codEditora,
    };

    controleLivro.incluir(livro);

    navigate('/');
  };

  return (
    <main>
      <h1>Livro Dados</h1>
      <form onSubmit={incluir}>
        <div className="form-group">
          <label htmlFor="titulo">Título:</label>
          <input
            type="text"
            id="titulo"
            value={titulo}
            onChange={(event) => setTitulo(event.target.value)}
            className="form-control"
          />
        </div>
        <div className="form-group">
          <label htmlFor="resumo">Resumo:</label>
          <textarea
            id="resumo"
            value={resumo}
            onChange={(event) => setResumo(event.target.value)}
            className="form-control"
          ></textarea>
        </div>
        <div className="form-group">
          <label htmlFor="autores">Autores:</label>
          <input
            type="text"
            id="autores"
            value={autores}
            onChange={(event) => setAutores(event.target.value)}
            className="form-control"
          />
        </div>
        <div className="form-group">
          <label htmlFor="editora">Editora:</label>
          <select
            id="editora"
            value={codEditora}
            onChange={tratarCombo}
            className="form-control"
          >
            {opcoes.map((opcao) => (
              <option key={opcao.value} value={opcao.value}>
                {opcao.text}
              </option>
            ))}
          </select>
        </div>
        <button type="submit" className="btn btn-primary">
          Salvar
        </button>
      </form>
    </main>
  );
}
