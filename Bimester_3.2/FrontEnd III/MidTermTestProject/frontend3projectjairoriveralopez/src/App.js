import data from './data/data.json'
import { useState } from 'react'
import Cabecera from './components/Cabecera'
import Listado from './components/Listado'

const App = () => {
  const [purchasedItems, setPurchasedItems] = useState(0)

  const handleBuy = () =>{
    setPurchasedItems(purchasedItems+1)
  }

  return (
    <div className="App">
      <Cabecera purchasedItems={purchasedItems}/>
      <Listado countBuy={handleBuy} dataItems={data}/>
    </div>
  );
}

export default App;