
import './App.css';

function App() {


  return (
    <div className="App">
      <div className="Header">
        <h1>Bibliothèque en ligne</h1>
      </div>
        <div className="Content">
            <h2>Rechercher</h2>
            <input type="text" placeholder="Titre du livre" />
            <input type="text" placeholder="Auteur du livre" />
        </div>
    </div>
  );
}

export default App;
