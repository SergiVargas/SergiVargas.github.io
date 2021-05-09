import React from 'react';
import Header from './components/Header';
import Footer from './components/Footer';


function App() {
  return (
    <div className="App">
      <h1>LLEGUÉ.....</h1>
      <p>
        esto se va a poner muy muy bien 
      </p>

      < Header 
      
      titulo = 'llegando por fin al final del primer capitulo'
      numero = {20}
      />

      <div>

        <Footer />
      </div>
      <Footer />
    </div>

  
  );
}

export default App;
