import React from 'react';
import LivroLista from './LivroLista';
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';
import LivroDados from './LivroDados';


function App() {
  return (
    <BrowserRouter>
      <nav className="navbar navbar-expand navbar-dark bg-dark">
        <div className="container">
          <ul className="navbar-nav">
            <li className="nav-item">
              <Link to="/" className="nav-link">Livros</Link>
            </li>
            <li className="nav-item">
              <Link to="/dados" className="nav-link">Dados</Link>
            </li>
          </ul>
        </div>
      </nav>
      <div className="container mt-4">
        <Routes>
          <Route path="/" element={<LivroLista />} />
          <Route path="/dados" element={<LivroDados />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
