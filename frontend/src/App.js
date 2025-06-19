import React, { useEffect, useState } from 'react';
import './App.css';

function App() {
  const [livres, setLivres] = useState([]);
  const [index, setIndex] = useState(0);

  useEffect(() => {
    fetch('http://127.0.0.1:8080/books')
      .then(res => res.json())
      .then(data => setLivres(data))
      .catch(() => setLivres([]));
  }, []);

  const prevLivre = () => {
    setIndex((prev) => (prev === 0 ? livres.length - 1 : prev - 1));
  };

  const nextLivre = () => {
    setIndex((prev) => (prev === livres.length - 1 ? 0 : prev + 1));
  };

  return (
    <div className="App">
      <div className="Header">
        <h1>Bibliothèque en ligne</h1>
      </div>
      <header className="App-header">
        <h2>Livres en vedette</h2>
        {livres.length > 0 && (
          <div className="carousel">
            <button className="carousel-btn" onClick={prevLivre}>&lt;</button>
            <div className="carousel-content">
              {livres[index].coverUrl && (
                <img
                  src={livres[index].coverUrl}
                  alt={livres[index].title}
                  className="carousel-cover"
                  style={{ maxHeight: 180, marginBottom: 12, borderRadius: 8 }}
                />
              )}
              <strong>{livres[index].title}</strong>
              <div>{livres[index].author}</div>
              <div style={{ fontSize: '0.9rem', margin: '8px 0' }}>
                {livres[index].publisher} &middot; {livres[index].pageCount} pages
              </div>
              <div style={{ fontSize: '0.95rem', margin: '8px 0', fontStyle: 'italic' }}>
                {livres[index].bookGenres && livres[index].bookGenres.join(', ')}
              </div>
              <div style={{ fontSize: '0.95rem', marginTop: 8 }}>
                {livres[index].description}
              </div>
            </div>
            <button className="carousel-btn" onClick={nextLivre}>&gt;</button>
          </div>
        )}
        {livres.length === 0 && <div>Chargement...</div>}
      </header>
    </div>
  );
}

export default App;
