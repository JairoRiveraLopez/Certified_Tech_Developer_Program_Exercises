import './App.css';
import Container from './components/Container';
import React from 'react'
function App() {

  const titles = [
    {id: 1, title: "HOLA"},
    {id: 2, title: "HOLA"},
    {id: 3, title: "HOLA"},
    {id: 4, title: "HOLA MUNDO"}
  ]

  return (
    <div className="App">
      <>
        <Container titles={titles}/>
      </>
    </div>
  );
}

export default App;
