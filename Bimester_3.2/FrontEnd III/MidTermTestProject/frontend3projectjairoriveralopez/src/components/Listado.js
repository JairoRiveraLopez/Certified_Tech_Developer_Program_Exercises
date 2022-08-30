import React from 'react'
import Item from './Item'
import styles from './styles/listado.module.css'

const Listado = ({countBuy, dataItems}) =>{
    return (
      <div className={`${styles.listado}`}>
        {
          dataItems.map((item) => <Item buy={countBuy} key={item.id} title={item.producto.nombre} description={item.producto.descripcion} stock={item.stock}></Item>)
        }
      </div>
    )
}

export default Listado;