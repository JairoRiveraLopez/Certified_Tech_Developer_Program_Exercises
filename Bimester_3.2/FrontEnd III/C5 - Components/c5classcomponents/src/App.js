import Container from './components/Container';
import './App.css';

function App() {

  const pets = [
    {id: 1, name: "Firulais", age: 2, gender: "M", kind: "Dog", size: 10},
    {id: 2, name: "Michu", age: 1, gender: "F", kind: "Cat", size: 2},
    {id: 3, name: "Achu", age: 6, gender: "F", kind: "Cat", size: 3},
    {id: 4, name: "Paul", age: 9, gender: "M", kind: "Dog", size: 5},
    {id: 5, name: "Bob", age: 5, gender: "M", kind: "Dog", size: 7}
  ]

  return (
      <>
        <Container pets={pets}/>
      </>
  )
}

export default App;
