import { useState } from 'react'
import styles from './styles/item.module.css'
const Item = ({buy, title, description, stock}) =>{
    const [stockItem, setStockItem] = useState(stock)

    const reduceStock = () => {
        setStockItem(stockItem-1)
    }

    return (
    <div className={`${styles.item}`}>
        <h3>{title}</h3>
        <p>{description}</p>
        <h5>En stock: {stockItem <= 0 ? <span className={`${styles.soldOut}`}> agotado</span> : <span className={`${styles.available}`}>{stockItem}</span>}</h5>
        {stockItem <= 0 ? <button disabled> Sin Stock</button> : <button onClick={() => {buy(); reduceStock();}}> Comprar</button>}
    </div>
    )
}

export default Item;